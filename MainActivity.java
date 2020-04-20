package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }

        });

        Button groupsBttn = (Button) findViewById(R.id.groupBttn);
        groupsBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), GroupDisplay.class);
                startActivityForResult(myIntent, 0);
            }

        });



      //  getSupportActionBar().setHomeAsUpIndicator(R.drawable.logo);// set drawable icon
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
