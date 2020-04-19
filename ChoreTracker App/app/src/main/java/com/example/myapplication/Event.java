package com.example.myapplication;

public class Event {
    public String name;
    private int startTime;
    private int endTime;
    public String dateAssigned;
    public Boolean completionStatus;
    public String description;
    public String difficulty;
    public String assignedUser;
    public int priority;

    public Event(String name, String date, String description, String user)
    {
        this.name = name;
        dateAssigned = date;
        this.description = description;
        assignedUser = user;

        completionStatus = false;
        difficulty = "easy";
        priority = 1;
    }

    public void add()
    {
        // method will add the event to the database once database integration is complete
    }

    public void edit()
    {
        // method will edit the event in the database once database integration is complete
    }

    public void delete()
    {
        // method will delete the event from the database once database integration is complete
    }

    public void assign(String user) //user will be a class, using the string as a stand-in
    {
        assignedUser = user;
    }

    public void markComplete()
    {
        completionStatus = true;
    }

    @Override
    public String toString()
    {
        String completed;
        if(completionStatus)
        {
            completed = "Completed";
        }
        else
        {
            completed = "Not completed";
        }
        String eventString = "Event:\nName: " + name +
                "\nAssigned to: " + assignedUser +
                "\nCompletion status: " + completed +
                "\nDescription: " + description;
        return eventString;
    }
}
