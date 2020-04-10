package com.example.myapplication;

import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class DatabaseAccess {

    private String TAG = "DynamoDb";

    private final String COGNITO_IDENTITY_POOL_ID = "";
    private final String DNYNAMODB_TABLE = "";
    private Context context;
    private CognitoCachingCredentialsProvider credentialsProvider;
    private AmazonDynamoDBClient dbClient;
    private Table dbTable;
}
