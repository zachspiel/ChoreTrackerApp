package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.SignOutOptions;

import androidx.appcompat.app.AppCompatActivity;

import static com.amazonaws.mobile.client.internal.oauth2.OAuth2Client.TAG;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(Logout.this, Login.class);
        startActivity(intent);

        AWSMobileClient.getInstance().signOut(SignOutOptions.builder().signOutGlobally(true).build(), new Callback<Void>() {
            @Override
            public void onResult(final Void result) {
                Log.d(TAG, "signed-out");
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, "sign-out error", e);
            }
        });
    }
}
