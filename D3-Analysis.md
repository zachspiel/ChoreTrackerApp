                                                    Deliverable 3 - Analysis
                                                      Chore Tracker App
                                                   =========================
  
 
<h3>1. System Description</h3>
  The problem of mangaging chores affects households and creates a dirty, disorganized house and tension between household members if left unaddressed. For households with a variety of chores between members, the Chore Tracker App is a organizational app that allows for the efficient distribution and tracking of household chores between household members. Unlike Google Calendar, which just displays events and chores, our app will assign them routinely between household members in an organized fashion. The Chore Tracker App is a organizational app that allows household members to fairly distribute chores and tasks to complete. The value of the Chore Tracker App is the organized approach it brings to chore managment and decreases the tensions between houshold memebers. The Chore Tracker is different from other apps as it contains fun incentives to stick to the planned schedule created using it.<br>

The **User** class is a pivotal element of the Chore Tracker App. The User has four key attributes: a *name, group, events, calendar, and settings.* The *name* attribute is inputted by the **User** and identifies the object. The *events* list stores any tasks and items the **User** needs to complete. The __*group*__ attribute specifies which **Group** the **User** belongs to. **Groups** contain attributes for the _list of members_, a _group name_, and a _list of **Admins**_ for the group. **Users** update their <ins>instance</ins> of the **Calendar** class and view it using the viewCalendar method. **Users** can populate their **Calendar** with **events** and tasks that they would like to schedule and complete. Finally, **Users** are able to <ins>create and modify</ins> their own unique **Settings** for the app. **Settings** include attributes such as _theme, profileName, and profilePicture_ that are unique to each **User**. 

The **Admin** class <ins>inherits</ins> from the **User** class as **Admins** <ins>are</ins> Users. Admins <ins>create</ins> instances of Groups and assign members (**Users**) to them.
  



 
<h3>2. Model</h3>
![UML Diagram](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/UML_Combined%20(1).png)




<h3>3.Class Responsibilites</h3>
  The User class was included as it is responsible for handling user data and their account as they use the Chore Tracker App. The User class fulfills the requirement of client-server interaction as each user's information will be stored on a database hosted by AWS. The User Class also provides a foundation for implementing group Admins, as they themselves are users that inherit general user functionality but have extended functionality. Users are able to view their event list and calendar and add new events to them as they please.
<br>
  The Admin class is responsible for managing groups of users. The Admin class will create a class Group that they can add users to and post events for the group to complete. 
<br>
  The Group class is responsible for holding groups of users that share common tasks and goals. The Group class implements the group functionality of the Chore Tracker App, as it will allow households and teams to share tasks. The Group class will be responsible for organizing events and members within the group. 
<br>
  The Settings class is responsible for containing the settings information for a given user. Each user will have their own unique settings class that contains information such as their app theme, profile name, and profile picture. The methods for this class will consist of getter and setter methods that allow users to access and update their settings info.
