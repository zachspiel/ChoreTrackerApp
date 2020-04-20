package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.riontech.calendar.CustomCalendar;
import com.riontech.calendar.dao.EventData;
import com.riontech.calendar.dao.dataAboutDate;
import com.riontech.calendar.utils.CalendarUtils;

import java.util.ArrayList;
import java.util.Random;

public class testCalendar extends AppCompatActivity {

    private CustomCalendar customCalendar;
    DatabaseAccess myDb;

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_calendar);
        customCalendar = (CustomCalendar) findViewById(R.id.customCalendar);
        myDb = new DatabaseAccess(this);
        int eventCount = 1;
        Cursor res = myDb.getAllEvents();
        String[] chores;
        if(res.getCount() == 0) {
            Log.i("FAILED", "NO ENTITIES");
            return;
        }

        while (res.moveToNext()) {
            eventCount++;
            Log.i("IN RES",res.getString(1));
            Log.i("IN RES",res.getString(2));
            Log.i("IN RES",res.getString(3));
            Log.i("IN RES",res.getString(4));
            customCalendar.addAnEvent(res.getString(3), eventCount, getEventDataList(res.getString(2), res.getString(4), res.getString(1)) );
        }

        //List of dates with events
        /*String[] arr = {"2020-04-24", "2020-05-01", "2020-05-08", "2020-05-15" , "2020-05-22", "2020-05-29"};
        for (int i = 0; i < arr.length; i++) {
            int eventCount = 1;
            customCalendar.addAnEvent(arr[i], eventCount, getEventDataList(eventCount));
        }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_calendar);
        customCalendar = (CustomCalendar) findViewById(R.id.customCalendar);

        myDb = new DatabaseAccess(this);
        Cursor res = myDb.getAllEvents();

        int size = 0;

        while(res.moveToNext()) {
            Log.i("RETRIEVING LIST", res.getString(3));
            customCalendar.addAnEvent(res.getString(3), 1, getEventDataList(1, res.getString(2), res.getString(4)));
        }
    }


    public ArrayList<EventData> getEventDataList(int count, String name, String description) {
    //public ArrayList<EventData> getEventDataList(String eventName, String desc, String username) {
        /*ArrayList<EventData> eventDataList = new ArrayList();
        EventData dateData = new EventData();
        dataAboutDate dataAboutDate = new dataAboutDate();
        ArrayList<dataAboutDate> dataAboutDates = new ArrayList();
        int count =1;
        dateData.setSection(username);
        Log.i("IN GET EVENT","data set username" + username);

        dataAboutDate.setTitle(eventName);
        Log.i("IN GET EVENT","data set title" + eventName);

        dataAboutDate.setSubject(desc);
        Log.i("IN GET EVENT","data set desc" + desc);

        // add the information
        dataAboutDates.add(dataAboutDate);

        // set the data to above
        dateData.setData(dataAboutDates);

        // adds data to calendar
        eventDataList.add(dateData);


        //loop to call the event data
        for (int i = 0; i < count; i++) {
            //EventData dateData = new EventData();

            //sets name to Alex for Every event
            //String username = AWSMobileClient.getInstance().getUsername();
            dateData.setSection(username);
            //dataAboutDate dataAboutDate = new dataAboutDate();


            int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            //Currently hardcoded values that will be present for every event
            dataAboutDate.setTitle("Take out the Trash");
            dataAboutDate.setSubject("Make Sure to take the trash out of the kitchen");
            //adds the information
            dataAboutDates.add(dataAboutDate);

            //function to set the data to the above
            dateData.setData(dataAboutDates);
            //adds the data onto the calendar
            eventDataList.add(dateData);
        }*/

        ArrayList<EventData> eventDataList = new ArrayList();
        //loop to call the event data
        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //sets name to Alex for Every event
            String username = AWSMobileClient.getInstance().getUsername();
            dateData.setSection(username);

            dataAboutDate dataAboutDate = new dataAboutDate();

            int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

            //Currently hardcoded values that will be present for every event
            dataAboutDate.setTitle(name);
            dataAboutDate.setSubject(description);
            //adds the information
            dataAboutDates.add(dataAboutDate);

            //function to set the data to the above
            dateData.setData(dataAboutDates);
            //adds the data onto the calendar
            eventDataList.add(dateData);
        }

        return eventDataList;
    }
}

