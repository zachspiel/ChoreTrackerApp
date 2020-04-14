package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
            @Override
            public void onResult(UserStateDetails userStateDetails) {
                try {
                    Amplify.addPlugin(new AWSApiPlugin());
                    Amplify.configure(getApplicationContext());
                    Log.i("ApiQuickstart", "All set and ready to go!");
                } catch (Exception exception) {
                    Log.e("ApiQuickstart", exception.getMessage(), exception);
                }
            }
            @Override
            public void onError(Exception exception) {
                Log.e("ApiQuickstart", "Initialization error.", exception);
            }
        });

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    }


        Button calendarBttn = (Button) findViewById(R.id.calendarBttn);
        calendarBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Weekly.class);
                startActivityForResult(myIntent, 0);
            }

        });


        Button signinBttn = (Button) findViewById(R.id.signinbutton);
        signinBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Login.class);
                startActivityForResult(myIntent, 0);
            }

        });

        Button addChoresBttn = (Button) findViewById(R.id.addChoresBttn);
        addChoresBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), addEvents.class);
                startActivityForResult(myIntent, 0);
            }

        });

        ImageButton exitButton = (ImageButton) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });

      /*  Button groupsBttn = (Button) findViewById(R.id.addChoresBttn);
        groupsBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Groups.class);
                startActivityForResult(myIntent, 0);
            }

        });*/
    }
}
