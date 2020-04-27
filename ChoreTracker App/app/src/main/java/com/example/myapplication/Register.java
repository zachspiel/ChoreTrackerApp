package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;

import java.util.HashMap;
import java.util.Map;

public class Register extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText inputName = findViewById(R.id.editText4);
        final EditText inputPassword = findViewById(R.id.editText5);
        final EditText userName = findViewById(R.id.username);

        final String username = String.valueOf(userName);
        final String password = String.valueOf(inputPassword);

        final CognitoUserAttributes userAttributes = new CognitoUserAttributes();

        final Map<String, String> attributes = new HashMap<>();
        attributes.put("email", "name@email.com");

    }


}
