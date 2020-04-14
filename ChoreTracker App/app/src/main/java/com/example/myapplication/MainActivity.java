package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobile.client.UserStateListener;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicCognitoUserPoolsAuthProvider;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.core.Amplify;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private AWSAppSyncClient mAWSAppSyncClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
            @Override
            public void onResult(UserStateDetails userStateDetails) {
                try {
                    Amplify.addPlugin(new AWSApiPlugin());
                    Amplify.configure(getApplicationContext());
                    Log.i("ApiQuickstart", "All set and ready to go!");
                } catch (Exception exception) {
                    Log.e("ApiQuickstart", exception.getMessage(), exception);
                }
            }
            @Override
            public void onError(Exception exception) {
                Log.e("ApiQuickstart", "Initialization error.", exception);
            }
        });

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        /*
        AWSMobileClient.getInstance().addUserStateListener(new UserStateListener() {
            @Override
            public void onUserStateChanged(UserStateDetails userStateDetails) {
                switch (userStateDetails.getUserState()){
                    case GUEST:
                        Log.i("AuthQuickStart", "user is in guest mode");
                        break;
                    case SIGNED_OUT:
                        Log.i("AuthQuickStart", "user is signed out");
                        break;
                    case SIGNED_IN:
                        Log.i("AuthQuickStart", "user is signed in");
                        break;
                    case SIGNED_OUT_USER_POOLS_TOKENS_INVALID:
                        Log.i("AuthQuickStart", "need to login again");
                        break;
                    case SIGNED_OUT_FEDERATED_TOKENS_INVALID:
                        Log.i("AuthQuickStart", "user logged in via federation, but currently needs new tokens");
                        break;
                    default:
                        Log.e("AuthQuickStart", "unsupported");
                }
            }
        });*/

    }
    }


        Button calendarBttn = (Button) findViewById(R.id.calendarBttn);
        calendarBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Weekly.class);
                startActivityForResult(myIntent, 0);
            }

        });


        Button signinBttn = (Button) findViewById(R.id.signinbutton);
        signinBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Login.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button addChoresBttn = (Button) findViewById(R.id.addChoresBttn);
        addChoresBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), addEvents.class);
                startActivityForResult(myIntent, 0);
            }

        });

        ImageButton exitButton = (ImageButton) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });

      /*  Button groupsBttn = (Button) findViewById(R.id.addChoresBttn);
        groupsBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Groups.class);
                startActivityForResult(myIntent, 0);
            }

        });*/
    }
}
