package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {

    private String testName = "Brian";
    private String testDate = "11/11/1111";
    private String testDescription = "Description";
    private String testUsername = "briansUsername";

    private Event testEvent = new Event(testName, testDate, testDescription, testUsername);

    @Test
    public void getName() {
        String testNameGot = testEvent.getName();
        assertEquals(testName, testNameGot);
    }

    @Test
    public void setName() {
        String newName = "Charlie";
        testEvent.setName(newName);
        testName = newName;
        getName();
    }

    @Test
    public void getDate() {
        String testDateGot = testEvent.getDate();
        assertEquals(testDate, testDateGot);
    }

    @Test
    public void setDate() {
        String newDate = "2/2/2222";
        testEvent.setDate(newDate);
        testDate = newDate;
        getDate();
    }

    @Test
    public void getDesc() {
        String testDescGot = testEvent.getDesc();
        assertEquals(testDescription, testDescGot);
    }

    @Test
    public void setDesc() {
        String newDescription = "Update Description";
        testEvent.setDesc(newDescription);
        testDescription = newDescription;
        getDesc();
    }

    @Test
    public void getUsername() {
        String testUsernameGot = testEvent.getUsername();
        assertEquals(testUsername, testUsernameGot);
    }

    @Test
    public void setUsername() {
        String newUsername = "newUsername";
        testEvent.setUsername(newUsername);
        testUsername = newUsername;
        getUsername();
    }
}
