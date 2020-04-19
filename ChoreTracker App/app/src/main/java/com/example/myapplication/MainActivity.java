package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

    // temporary array just to store events created until database integration is complete
    ArrayList<Event> events = new ArrayList<Event>();

    // method fired on click of "add" button on event form
    public void sendEventFeedback(View view) {
        final EditText nameField = (EditText) findViewById(R.id.editEventName);
        String eventName = nameField.getText().toString();

        final EditText startField = (EditText) findViewById(R.id.editStartDate);
        String start = startField.getText().toString();

        final EditText endField = (EditText) findViewById(R.id.editEndDate);
        String end = endField.getText().toString();

        final EditText desc = (EditText) findViewById(R.id.editDesc);
        String description = desc.getText().toString();

        final RadioGroup groupSelect = (RadioGroup) findViewById(R.id.radioGroup);
        int group = groupSelect.getCheckedRadioButtonId();

        // creates event and adds to events list, John Doe is a stand in user, user will be
        // the name of the person currently logged in
        Event newEvent = new Event(eventName, start, description, "John Doe");
        events.add(newEvent);
    }
}
