                                                    Deliverable 3 - Analysis
                                                      Chore Tracker App
                                                   =========================
  
 
<h3>1. System Description</h3>
  <p>The problem of managing chores affects households and creates a dirty, disorganized house and tension between household members if left unaddressed. For households with a variety of chores between members, the Chore Tracker App is an organizational app that allows for the efficient distribution and tracking of household chores between household members. Unlike Google Calendar, which just displays events and chores, our app will assign them routinely between household members in an organized fashion. The Chore Tracker App is an organizational app that allows household members to fairly distribute chores and tasks to complete. The value of the Chore Tracker App is the organized approach it brings to chore management and decreases the tensions between household members. The Chore Tracker is different from other apps as it contains fun incentives to stick to the planned schedule created using it.</p>


The **User** class is a pivotal element of the Chore Tracker App. The User has four key attributes: a *name, group, events, calendar, and settings.* The *name* attribute is inputted by the **User** and identifies the object. The *events* list stores any tasks and items the **User** needs to complete. The __*group*__ attribute specifies which **Group** the **User** belongs to. **Groups** contain attributes of the _list of members_, a _group name_, and a _list of **Admins**_ for the group. **Users** update their <ins>instance</ins> of the **Calendar** class and view it using the viewCalendar method. **Users** can populate their **Calendar** with **events** and tasks that they would like to schedule and complete. Finally, **Users** are able to <ins>create and modify</ins> their own unique **Settings** for the app. **Settings** include attributes such as _theme, profileName, and profilePicture_ that are unique to each **User**. The **Admin** class <ins>inherits</ins> from the **User** class as **Admins** <ins>are</ins> Users. Admins <ins>create</ins> instances of Groups and assign members (**Users**) to them.

The **Calendar** class correlates when the <ins>user</ins> wants to see the <ins>date</ins> of the **event**. The **Calendar** class contains the attributes _month, year, week, and day_ which, gives an exact date of the **event**. Then to _switch_ from **Calendar** view to a more specific view, there is the **Monthly view** class that has the attributes _year, month name,  month days, and the task_. The **User** can change their monthly view on which _month_ by using the switchMonth method or change the format of the view completely by switching to the **Weekly View** class. The attributes for the **Weekly View** class is similar to **Monthly view**, _year, month name,  month days, start date, and task_, but the only difference is _start date_ that gets the starting date of that week. Similarly the **User** can change from **Monthly view** to **Daily view**, that has the attributes _year, month, day, time, and task_, that gives the **User** the view of their task in a daily setting. 


The **Notification** class is responsible for notifying users of what tasks are upcoming and need to be completed. The notification class will contain the following information: _time, repeated, and description_. The **Notification** class will implement methods <ins>sendNotification and repeatNotifications</ins> out for events that need to be done repeatedly. The notification class will also have a <ins>sendNotification</ins> method that will handle sending out the notification to the users responsible. The **Event** class is responsible for creating, deleting and managing the events that are created within the desired group. The event class will contain the following information: _name, startTime, endTime, dateAssigned, completionStatus, description, difficulty, assignedUser, and priority._ The event class will also hold the methods <ins>add, edit, delete and assign.</ins> The <ins>add</ins> method will allow the user to create a new event. The <ins>assign</ins> method can be called during or after creation to assign and unassign tasks to certain members in the household. The <ins>delete</ins> method deletes the event and the <ins>edit</ins> event allows for users to change the details and the information listed above. On the other hand the **Event panel** class contains the attributes, _color, size, and event date_ that help create the outer appearance of the event, this class correlates to **Calendar** and **Event** class due to it being used in **Calendar** when the **User** want to know more information about the task, **Event** is used to gain the information about the task itself.The **Repeating event** class handles events that need to be repeatedly done over a specified time span. The information that this class holds is _repeatedDates and repeatedTimes_. These times are used by the app to create the event throughout the calendar. The method <ins>reset</ins> allows for the user to reset event information to its default values. The **Multiparted Event** class is a class that helps out when a chore need to be cut down into smaller tasks. **Multiparted Event** has attributes _checklist and completed_ to help out what needs to be done for the whole event itself to be <ins>completed</ins> also it contain a checkItem and uncheckedItem to help with the _checklist_ it contains.


 
<h3>2. Model</h3>

![UML Diagram](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/UML_Combined%20(1).png)




<h3>3.Class Responsibilites</h3>


* The User class was included as it is responsible for handling user data and their account as they use the Chore Tracker App. The User class fulfills the requirement of client-server interaction as each user's information will be stored on a database hosted by AWS. The User Class also provides a foundation for implementing group Admins, as they themselves are users that inherit general user functionality but have extended functionality. Users are able to view their event list and calendar and add new events to them as they please.

* The Admin class is responsible for managing groups of users. The Admin class will create a class Group that they can add users to and post events for the group to complete. 

* The Group class is responsible for holding groups of users that share common tasks and goals. The Group class implements the group functionality of the Chore Tracker App, as it will allow households and teams to share tasks. The Group class will be responsible for organizing events and members within the group. 

* The Settings class is responsible for containing the settings information for a given user. Each user will have their own unique settings class that contains information such as their app theme, profile name, and profile picture. The methods for this class will consist of getter and setter methods that allow users to access and update their settings info.

* The Event class is responsible for containing all details about any event that the user logs in the app. Almost every other class interacts in some way with the Event class since tracking chores/events in the main purpose of the application. Along with details about a certain event, the Event class allows users to create, edit, delete and assign the Event. Through these methods, the Event class will interact with other classes such as the User class and Calendar class.

* The MultipartedEvent class inherits from the Event class. This class is specifically for dealing with events/chores that must be done in steps. Therefore, the class allows users to check if a certain part of a task is done, and keeps track of which parts have been completed or not.

* The RepeatingEvent class also inherits from the Event class. This class is for all events that happen on a regular schedule. This class allows the user to specify repeating dates for an Event so that they do not need to create a new Event object for every instance of the same events.

* The Notification class is responsible for keeping track of which event objects have notifications attached to them. The notification settings can be specified by the user, such that every individual notification is tied to one event, but an event can have multiple notifications. Therefore, a user can get a notification about an event multiple times so they do not forget about it.

* The EventPanel class is responsible for the display of an event. An object of the EventPanel class will contain details about the event that it is displayed and will also allow the user to see its priority and deadline.

* The Calendar class is responsible for the calendar view of all the events currently logged in the system. The Calendar class will contain all necessary information about the current date, such as year, month, etc. so that it can display events to the user in the given time range using the getTaskList() method. The Calendar will have multiple views that the user can switch between.

* The MonthlyView class is one type of display of the calendar. It is responsible for displaying all events in a given month, selected by the user. From the view, the user will be able to view the daily schedule of a certain day, switch between months, click into an event to view its details, and create events. 

* The WeeklyView class is another type of display of the calendar. It is responsible for displaying all events in a given week, selected by the user. The class contains the necessary information to get the correct week, such as the start date of the week. It then displays all events that occur during that week. From the view, the user will be able to view the daily schedule of a certain day, switch between weeks, click into an event to view its details, and create events. 

* The DailyView class is the final type of display of the calendar. It is responsible for displaying all events on a given day, selected by the user. The class contains all the necessary information needed to obtain the correct date of the given day so that tasks on that day can be displayed. The tasks will be displayed in order using the startTime/endTime attributes of the Event class. From the view, the user will be able to switch between days, click into an event to view its details, and create events. 
  
 
