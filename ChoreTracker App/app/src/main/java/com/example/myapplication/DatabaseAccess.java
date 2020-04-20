package com.example.myapplication;

import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.document.Table;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

import org.w3c.dom.Document;

public class DatabaseAccess {

    private String TAG = "DynamoDb";

    private final String COGNITO_IDENTITY_POOL_ID = "us-east-2:b46b1b86-e570-41be-b907-c24675e61ae3";
    private final Regions COGNITO_IDENTITY_POOL_REGION = Regions.US_EAST_2;
    private final String DNYNAMODB_TABLE = "";
    private Context context;
    private CognitoCachingCredentialsProvider credentialsProvider;
    private AmazonDynamoDBClient dbClient;
    private Table dbTable;

    private static volatile DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.context = context;

        // Create a new credentials provider
        credentialsProvider = new CognitoCachingCredentialsProvider(context, COGNITO_IDENTITY_POOL_ID, COGNITO_IDENTITY_POOL_REGION);

        // Create a new connection to the DynamoDB service
        dbClient = new AmazonDynamoDBClient(credentialsProvider);

        dbClient.setRegion(Region.getRegion(Regions.US_EAST_2));

        dbTable = Table.loadTable(dbClient, DNYNAMODB_TABLE);
    }

    public static synchronized DatabaseAccess getInstance(Context context) {
        if(instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
}

