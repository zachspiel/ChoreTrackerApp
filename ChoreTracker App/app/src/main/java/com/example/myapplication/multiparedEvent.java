package com.example.myapplication;

import java.awt.CheckBox;

public class multiparedEvent extends Event {
    private CheckBox[] checklist;
    private int stepsToComplete;
    private Boolean completed;

    public multiparedEvent(int itemsToComplete)
    {
        super();
        itemsToComplete = stepsToComplete;
        checklist = CheckBox[stepsToComplete];
        int index;
        for(index = 0; index < stepsToComplete; index++)
        {
            checklist[index] = new Checkbox("Item"+index, flase);
        }
        completed = false;
    }
    public void checkItem()
    {
        // checks off next item in list
        index = 0;
        while(index == true && index < stepsToComplete)
        {
            index++;
        }
        if(index == stepsToComplete)
        {
            completed = true;
        }
        else {
            checklist[index].setState(true);
        }
    }

    public void uncheckItem()
    {
        // unchecks last item that was checked
        index = 0;
        while(index == true)
        {
            index++;
        }
        checklist[index-1].setState(true);
    }
}