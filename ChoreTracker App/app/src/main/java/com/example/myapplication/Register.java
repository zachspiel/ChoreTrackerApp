package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpResult;

import static com.amazonaws.mobile.client.internal.oauth2.OAuth2Client.TAG;

public class Register extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUser();
    }

    private void registerUser() {
        Intent intent = new Intent(this, VerificationActivity.class);

        final EditText inputName = findViewById(R.id.editText4);
        final EditText inputPassword = findViewById(R.id.editText5);
        final EditText userName = findViewById(R.id.username);

        final CognitoUserAttributes userAttributes = new CognitoUserAttributes();

        final SignUpHandler signUpCallback = new SignUpHandler() {
            @Override
            public void onSuccess(CognitoUser user, SignUpResult signUpResult) {
                Log.i(TAG, "sign up success...is confirmed: " + signUpResult);

                startActivity(intent);

            }

            @Override
            public void onFailure(Exception exception) {
                Log.i(TAG, "sign up success...not confirmed: " + exception.getLocalizedMessage());
            }


        };
        Button registerButton = findViewById(R.id.button3);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userAttributes.addAttribute("email", String.valueOf(inputName.getText()));

                CognitoSettings cognitoSettings = new CognitoSettings( Register.this) ;

                cognitoSettings.getUserPool().signUpInBackground(String.valueOf(userName.getText()), String.valueOf(inputPassword.getText()), userAttributes, null, signUpCallback);
            }
        });
    }
}
