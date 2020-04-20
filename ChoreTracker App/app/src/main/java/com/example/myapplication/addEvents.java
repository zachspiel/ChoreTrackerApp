package com.example.myapplication;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.mobile.client.AWSMobileClient;

import java.util.Calendar;

public class addEvents extends AppCompatActivity {
    EditText eventName, desc;
    Button addBtn, viewAllBtn, date;
    TextView dateText;
    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    String selectedDay;
    DatabaseAccess myDb;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        myDb = new DatabaseAccess(this);

        eventName = findViewById(R.id.editText);
        desc = findViewById(R.id.editDesc);

        addBtn = findViewById(R.id.button);
        date = findViewById(R.id.buttonDate);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(addEvents.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                month = month + 1;
                                // format the month to add a 0 in front of it
                                String formatted = String.format("%02d", month);
                                date.setText(day + "/" + formatted + "/" + year);
                                selectedDay = year + "-" + formatted + "-" + day;
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
        AddData();
    }

    public void AddData() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = AWSMobileClient.getInstance().getUsername();
                Boolean isInserted = myDb.addEvent(username, eventName.getText().toString(), selectedDay, desc.getText().toString());

                if(isInserted) {
                    Toast.makeText(addEvents.this, "Data inserted", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(addEvents.this, "Data not inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    /*
    public void viewAll() {
        viewAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllEvents();
                if(res.getCount() == 0) {
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("id: " + res.getString(0)+"\n");
                    buffer.append("name; " + res.getString(1)+"\n");
                    buffer.append("event: " + res.getString(2)+"\n");
                    buffer.append("description; " + res.getString(3)+"\n\n");
                }

            }

        });

    }*/

    /*
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }*/
};



