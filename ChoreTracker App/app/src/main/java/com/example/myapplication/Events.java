package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.apollographql.apollo.GraphQLCall;
import com.apollographql.apollo.exception.ApolloException;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import androidx.appcompat.app.AppCompatActivity;

public class Events extends AppCompatActivity {

    private AWSAppSyncClient mAWSAppSyncClient;
    private static final String TAG = Events.class.getSimpleName();
    private List<Events> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String TAG = "EVENTS";

        Log.i(TAG, "In Events correctly");


    }

}
