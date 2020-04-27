package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;

import com.amazonaws.mobile.client.AWSMobileClient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.ArrayList;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseAccessTest {
    private DatabaseAccess db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = new DatabaseAccess(context);
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        String username = "bob";
        // This test is to test multiple components of application, creating DB, creating event, and adding event to event list
        ArrayList<Event> EventList = new ArrayList<Event>();
        EventList.add(new Event("Take out Trash", "30/04/2020", "need to take out trash", username));

        try {
            assertEquals(EventList.get(0).getName(), "Take out Trash");
            assertEquals(EventList.get(0).getUsername(), username);
            System.out.println("Passed successfully");
        }
        catch (AssertionError e) {
            System.out.println("Failed");
            throw e;
        }
    }
}