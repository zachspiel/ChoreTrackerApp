package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.mobile.client.AWSMobileClient;

import androidx.appcompat.app.AppCompatActivity;

public class Group extends AppCompatActivity {
    EditText newMember;

    Button newEvent;
    DatabaseAccess myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        myDb = new DatabaseAccess(this);

        newEvent = findViewById(R.id.button);

        newMember = findViewById(R.id.editText);

        AddData();
    }


    public void AddData() {
        newEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = AWSMobileClient.getInstance().getUsername();
                Boolean isInserted = myDb.addGroup(newMember.getText().toString(), username);

                if(isInserted) {
                    Toast.makeText(Group.this, "Data inserted", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Group.this, "Data not inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
