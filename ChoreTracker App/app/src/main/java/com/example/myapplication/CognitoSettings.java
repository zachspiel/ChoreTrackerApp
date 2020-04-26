package com.example.myapplication;

import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.regions.Regions;

public class CognitoSettings {

    private String userPoolId = "us-east-2_8BWGv4Ysw";
    private String clientId = "4dkg2hpaps4liit01hb2s18d63";
    private String clientSecret = "10g01j3plqar585g6fg0bif1ve6gmsefbaab8tjpmbro0q8m08er";
    private Regions cognitoRegion = Regions.US_EAST_2;
    private String identityPoolId = "us-east-2:b46b1b86-e570-41be-b907-c24675e61ae3";
    private Context context;

    public CognitoSettings(Context context) {
        this.context = context;
    }

    public String getUserPoolId() {
        return userPoolId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public Regions getCognitoRegion() {
        return cognitoRegion;
    }

    /*Entry point to user pool*/
    public CognitoUserPool getUserPool() {
        return new CognitoUserPool(context, userPoolId, clientId, clientSecret, cognitoRegion);
    }

    public CognitoCachingCredentialsProvider getCredentialsProvider() {
        return new CognitoCachingCredentialsProvider(
                context.getApplicationContext(),
                identityPoolId,
                cognitoRegion
        );
    }
}
