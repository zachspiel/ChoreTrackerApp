package d5templatemethod;

/**
 *Class to define a generic user and its functionality.
 * @author Joseph Vargovich
 */
import java.util.ArrayList;
import javafx.util.Pair;

public class User {
    String name;
    ArrayList<Group> groupList;
    ArrayList<Event> eventList;
    Calendar calendar;
    Settings settings;
    int groupCount;
    //Defualt constructor for an anoymous user.
    User()
        {
         name = "Anonymous";
         eventList = new ArrayList<Event>();
         calendar = new Calendar();
         settings = new Settings();
         groupList = new ArrayList<Group>();
         int groupCount = 0;
        }
    //Method to view all the events in the user's calender.
    private void viewEvents(){
        for(Event indexEvent : eventList)
            {
             indexEvent.displayEvent();
            }
    }
    //View all the user's groups
    private void viewGroups(){
        for(Group indexGroup : groupList)
            {
             //Get our current group's name and display it.
             System.out.println(indexGroup.displayGroupName());
            }
    }
    
    private void viewCalendar(){
        calendar.displayCalendar();
    }
    
    private void completeChore(Event currentChore)
        {
         currentChore.markComplete();
        }
    
    //Create a group and add it to the User's list of groups
    private void createGroup(String name, String description)
        {
         Group newGroup = new Group(name, descpription);
         //Append to the groups arrayList
         groupList.add(newGroup);
         groupCount++;
        }
    //Method to add a chore to a user's personal calendar
    private void addChore(String name, Pair date)
        {
         //Call the Event intialization constructor
         Event newEvent = new Event(name, date);
         //Add the new event tp our list
         eventList.add(newEvent);
        }
    
    //Method to add a chore to a user's group.
    private void addChore(String name, Pair date, Group destGroup)
        {
        //Call the Event intialization constructor
         Event newEvent = new Event(name, date);
         destGroup.addMemberEvent(newEvent);
         
        }
}
