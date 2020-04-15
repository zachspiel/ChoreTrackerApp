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

public class VerifyActivity extends AppCompatActivity {

    private static final String TAG = "Cognito";
    private CognitoUserPool userPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        final EditText editTextCode = findViewById(R.id.code);
        final EditText editTextUsername = findViewById(R.id.username);

        Button buttonVerify = findViewById(R.id.button);
        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ConfirmTask().execute(String.valueOf(editTextCode.getText()), String.valueOf(editTextUsername.getText()));
            }
        });
    }

    private class ConfirmTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            final String[] result = new String[1];

            final GenericHandler confirmCallback = new GenericHandler() {
                @Override
                public void onSuccess() {
                    result[0] = "Succeeded!";
                }

                @Override
                public void onFailure(Exception exception) {
                    result[0] = "Failed: " + exception.getMessage();
                }
            };

            CognitoSettings cognitoSettings = new CognitoSettings( VerifyActivity.this );

            CognitoUser thisUser = cognitoSettings.getUserPool().getUser(strings[1]);

            thisUser.confirmSignUp(strings[0], false, confirmCallback);

            return result[0];
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Log.i(TAG, "Confirmation result: " + result );
        }
    }
}
