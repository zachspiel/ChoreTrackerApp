package com.example.myapplication;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import com.riontech.calendar.CustomCalendar;
import com.riontech.calendar.dao.EventData;
import com.riontech.calendar.dao.dataAboutDate;
import com.riontech.calendar.utils.CalendarUtils;

import java.util.ArrayList;
import java.util.Random;

public class testCalendar extends AppCompatActivity {

    private CustomCalendar customCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_calendar);
        customCalendar = (CustomCalendar) findViewById(R.id.customCalendar);
        //List of dates with events
        String[] arr = {"2020-04-24", "2020-05-01", "2020-05-08", "2020-05-15" , "2020-05-22", "2020-05-29"};
        for (int i = 0; i < arr.length; i++) {
            int eventCount = 1;
            customCalendar.addAnEvent(arr[i], eventCount, getEventDataList(eventCount));
        }
    }

    public ArrayList<EventData> getEventDataList(int count) {
        ArrayList<EventData> eventDataList = new ArrayList();

        //loop to call the event data
        for (int i = 0; i < count; i++) {
            EventData dateData = new EventData();
            ArrayList<dataAboutDate> dataAboutDates = new ArrayList();

            //sets name to Alex for Every event
            dateData.setSection(CalendarUtils.getNAMES()[new Random().nextInt(1)]);
            dataAboutDate dataAboutDate = new dataAboutDate();


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
        }

        return eventDataList;
    }
}

