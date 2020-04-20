package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.AWSStartupHandler;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class AWSBucket extends AppCompatActivity {

    private static final String TAG = "Cognito";

    private CognitoCachingCredentialsProvider credentialsProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s3_upload);

        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {

                    @Override
                    public void onResult(UserStateDetails userStateDetails) {
                        Log.i("INIT", "onResult: " + userStateDetails.getUserState());
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e("INIT", "Initialization error.", e);
                    }
                }
        );

        Button buttonUpload = findViewById(R.id.button5);
        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceed(1);
            }
            });

        Button buttonDownload = findViewById(R.id.download);
        buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceed( 2 );
            }
        });
    }

    private void proceed(final int action) {
        final CognitoSettings cognitoSettings = new CognitoSettings(this);

        Log.i(TAG, "getting Identity Pool credentials provider");
        credentialsProvider = cognitoSettings.getCredentialsProvider();

        Log.i(TAG, "getting User Pool user");
        CognitoUser currentUser = cognitoSettings.getUserPool().getCurrentUser();

        Log.i(TAG, "calling getSessionInBackground");
        currentUser.getSessionInBackground(new AuthenticationHandler() {
            @Override
            public void onSuccess(CognitoUserSession userSession, CognitoDevice newDevice) {
                if( userSession.isValid() ) {
                    Log.i(TAG, "user session valid, getting token... ");

                    String idToken = userSession.getIdToken().getJWTToken();

                    if( idToken.length() > 0 ) {
                        Log.i(TAG, "got id token - setting credentials using token ");
                        Map<String, String> logins = new HashMap<>();
                        logins.put("cognito-idp.us-east-2.amazonaws.com/us-east-2_8BWGv4Ysw", idToken);

                        credentialsProvider.setLogins(logins);

                        Log.i(TAG, "using credentials for the logged in user");

                        Log.i(TAG, "refreshing credentials provider in asynctask.. ");
                        new RefreshAsyncTask().execute(action);
                    } else {
                        Log.i(TAG, "no token,.. ");
                    }
                } else {
                    Log.i(TAG, "user session not valid - using identity pool credentials - guest user");
                }

                performAction(action);
            }

            @Override
            public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String userId) {
                Log.i(TAG, "Not logged in! Using identity pool credentials for guest user");

                performAction(action);
            }

            @Override
            public void getMFACode(MultiFactorAuthenticationContinuation continuation) {

            }

            @Override
            public void authenticationChallenge(ChallengeContinuation continuation) {

            }

            @Override
            public void onFailure(Exception exception) {
                Log.i(TAG, "error getting session: " + exception.getMessage());

                performAction(action);
            }
        });
    }

    private void performAction(int action) {
        switch (action) {
            case 1:
                uploadWithTransferUtility();
                break;
            case 2:
                downloadWithTrasferUtility();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()...clearing credentials provider");

        credentialsProvider.clear();
    }

    private void downloadWithTrasferUtility() {

        AmazonS3Client amazonS3Client = new AmazonS3Client(credentialsProvider);

        final ImageView imageView = findViewById(R.id.imageView3);

        try {
            File outputDir = getCacheDir();
            final File tempCachFile = File.createTempFile("images", "extensions", outputDir);

            TransferUtility transferUtility =
                    TransferUtility.builder()
                            .context(getApplicationContext())
                            .awsConfiguration(AWSMobileClient.getInstance().getConfiguration())
                            .s3Client(amazonS3Client)
                            .build();

            TransferObserver downloadObserver =
                    transferUtility.download(
                            "advert.png", tempCachFile);

            downloadObserver.setTransferListener(new TransferListener() {
                @Override
                public void onStateChanged(int id, TransferState state) {
                    if (TransferState.COMPLETED == state) {
                        Log.i(TAG, "state change, image download complete");

                        Bitmap bmp = BitmapFactory.decodeFile(tempCachFile.getAbsolutePath());
                        imageView.setImageBitmap(bmp);
                    }
                }

                @Override
                public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                    float percentDonef = ((float) bytesCurrent / (float) bytesTotal) * 100;
                    int percentDone = (int) percentDonef;

                    Log.i("YourActivity", "ID: " + id + "bytesCurrent" + bytesCurrent
                            + "bytestotal: " + bytesTotal + " " + percentDone + "%");
                }

                @Override
                public void onError(int id, Exception ex) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void uploadWithTransferUtility() {
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();

        File file = new File(path, "advert.png");

        AmazonS3 s3Client = (AmazonS3) new AmazonS3Client(credentialsProvider);
        TransferUtility transferUtility =
                TransferUtility.builder()
                        .context(getApplicationContext())
                        .awsConfiguration(AWSMobileClient.getInstance().getConfiguration())
                        .s3Client(s3Client)
                        .build();

        TransferObserver uploadObserver =
                transferUtility.upload( "advert.png", file);

        uploadObserver.setTransferListener(new TransferListener() {
            @Override
            public void onStateChanged(int id, TransferState state) {
                if(TransferState.COMPLETED == state) {
                    Log.i(TAG, "Upload completed");
                }
            }

            @Override
            public void onProgressChanged(int id, long bytesCurrent, long bytesTotal) {
                float percentDonef = ((float) bytesCurrent / (float) bytesTotal) * 100;
                int percentDone = (int) percentDonef;

                Log.i("YourActivity", "ID: " + id + "bytesCurrent" + bytesCurrent
                        + "bytestotal: " + bytesTotal + " " + percentDone + "%");
            }

            @Override
            public void onError(int id, Exception ex) {
                Log.i(TAG, "Upload error: " + ex.getMessage());
            }
        });
    }

    private class RefreshAsyncTask extends AsyncTask<Integer, Void, Integer> {
        @Override
        protected Integer doInBackground(Integer...integers) {
            Log.i(TAG, "in asyntask doInBackground()");
            credentialsProvider.refresh();
            return integers[0];
        }

        @Override
        protected void onPostExecute(Integer action) {
            Log.i(TAG, "in asyntask onPostExecute()");

            performAction(action);
        }
    }
}
