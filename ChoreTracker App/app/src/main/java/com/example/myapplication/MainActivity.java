package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.amazonaws.amplify.generated.graphql.ListBlogsQuery;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicCognitoUserPoolsAuthProvider;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.regions.Regions;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private AWSAppSyncClient mAWSAppSyncClient;
    private ArrayList <ListBlogsQuery.Item> mPets;
    private final String TAG = MainActivity.class.getSimpleName();
    Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInButton = findViewById(R.id.signinbutton);

        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
            @Override
            public void onResult(UserStateDetails userStateDetails) {
                switch (userStateDetails.getUserState()) {
                    case SIGNED_IN:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView textView = (TextView) findViewById(R.id.text);
                                String username = AWSMobileClient.getInstance().getUsername();
                                username = "Hello, " + username;
                                textView.setText(username);

                                signInButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(v.getContext(), Logout.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                        break;
                    case SIGNED_OUT:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(MainActivity.this, Login.class);
                                startActivity(intent);
                            }
                        });
                        break;
                    default:
                        AWSMobileClient.getInstance().signOut();
                        break;
                }
            }

            @Override
            public void onError(Exception e) {
                Log.e("INIT", e.toString());
            }
        });

        AWSMobileClient.getInstance().addUserStateListener(userStateDetails -> {
            switch (userStateDetails.getUserState()) {
                case SIGNED_OUT:
                    // user clicked signout button and signedout
                    Log.i("AuthQuickStart", "user signed out");
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                    break;
                case SIGNED_OUT_USER_POOLS_TOKENS_INVALID:
                    Log.i("AuthQuickStart", "need to login again.");
                    Intent login = new Intent(MainActivity.this, Login.class);
                    startActivity(login);
                    break;
                default:
                    Log.i("AuthQuickStart", "unsupported");
            }
        });

        CognitoSettings currentPool = new CognitoSettings(this);

        CognitoUserPool userPool = currentPool.getUserPool();

        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(getApplicationContext())
                .region(Regions.US_EAST_2)
                .cognitoUserPoolsAuthProvider(new BasicCognitoUserPoolsAuthProvider(userPool))
                .awsConfiguration(new AWSConfiguration(getApplicationContext()))
                .build();

        ClientFactory.init(this);


        Button calendarBttn = (Button) findViewById(R.id.calendarBttn);
        calendarBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), testCalendar.class);
                startActivityForResult(myIntent, 0);
            }

        });


        Button addChoresBttn = (Button) findViewById(R.id.addChoresBttn);
        addChoresBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Events.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button groupsBttn = (Button) findViewById(R.id.groupBttn);
        groupsBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Events.class);
                startActivity(myIntent);
            }
        });

        ImageButton exitButton = (ImageButton) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();

            }
        });
    }

}
