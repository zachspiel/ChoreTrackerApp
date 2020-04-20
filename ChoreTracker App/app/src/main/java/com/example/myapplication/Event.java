package com.example.myapplication;

import com.amazonaws.mobile.client.AWSMobileClient;

public class Event {

    private String name;
    private String date;
    private String endDate;
    private String desc;
    private String username;

    public Event(String name, String date, String desc, String username) {
        this.name = name;
        this.date = date;
        this.endDate = endDate;
        this.desc = desc;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
