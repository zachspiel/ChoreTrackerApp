package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.amplify.generated.graphql.ListBlogsQuery;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.amazonaws.mobileconnectors.appsync.sigv4.BasicCognitoUserPoolsAuthProvider;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.regions.Regions;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private AWSAppSyncClient mAWSAppSyncClient;
    Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInButton = findViewById(R.id.signinbutton);
        TextView user = findViewById(R.id.userNameField);
        final String TAG = "TESTING";
        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
            @Override
            public void onResult(UserStateDetails userStateDetails) {
                switch (userStateDetails.getUserState()){
                    case SIGNED_IN:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String username = AWSMobileClient.getInstance().getUsername();
                                username = "Hello, " + username;
                                user.setText(username);
                                signInButton.setText("Sign out");

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

        CognitoSettings currentPool = new CognitoSettings(this);

        CognitoUserPool userPool = currentPool.getUserPool();

        mAWSAppSyncClient = AWSAppSyncClient.builder()
                .context(getApplicationContext())
                .region(Regions.US_EAST_2)
                .cognitoUserPoolsAuthProvider(new BasicCognitoUserPoolsAuthProvider(userPool))
                .awsConfiguration(new AWSConfiguration(getApplicationContext()))
                .build();


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
                Intent myIntent = new Intent(view.getContext(), GroupDisplay.class);
                startActivityForResult(myIntent, 0);
            }

        });

        ImageButton userBttn = (ImageButton) findViewById(R.id.user_button);
        final LinearLayout userMenu = (LinearLayout) findViewById(R.id.userMenu);
        final RelativeLayout buttonMenu = (RelativeLayout) findViewById(R.id.bttnLayout);
        userBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                userMenu.getBackground().setAlpha(255);
                toggleView(userMenu);
                userMenu.bringToFront();
                toggleView(buttonMenu);


            }


        });

        /*@Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()) {
                case android.R.id.home:
                    Toast.makeText(this, "click..!!", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);

            }
        }*/
    }
    public void toggleView(View view){
        if(view.getVisibility()==View.GONE)
            view.setVisibility(View.VISIBLE);
        else if(view.getVisibility()==View.VISIBLE)
            view.setVisibility(View.GONE);
    }
}
