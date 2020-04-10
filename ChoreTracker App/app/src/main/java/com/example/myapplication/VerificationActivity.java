package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;

import androidx.appcompat.app.AppCompatActivity;

import static com.amazonaws.mobile.client.internal.oauth2.OAuth2Client.TAG;

public class VerificationActivity extends AppCompatActivity {
    private static final String TAG = "Cognito";
    private CognitoUserPool userPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        final EditText verificationCode = findViewById(R.id.verificationCode);
        final EditText username = findViewById(R.id.verifyUsername);

        Button buttonVerify = findViewById(R.id.button5);

        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ConfirmTask().execute(String.valueOf(verificationCode.getText()), String.valueOf(username.getText()));
            }

        });
    }

    private class ConfirmTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            final String[] result = new String[1];

            final GenericHandler confirmationCallback = new GenericHandler() {
                @Override
                public void onSuccess() {
                    // if successful confirmation
                    result[0] = "Succeeded!";
                }

                @Override
                public void onFailure(Exception exception) {
                    // if confirmation failed
                    result[0] = "Failed: " + exception.getMessage();
                }
            };

            CognitoSettings cognitoSettings = new CognitoSettings(VerificationActivity.this);

            CognitoUser thisUser = cognitoSettings.getUserPool().getUser(strings[1]);

            thisUser.confirmSignUp(strings[0], false, confirmationCallback);

            return result[0];
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Log.i(TAG, "Confirmation result: " + result);
        }
    }
}
