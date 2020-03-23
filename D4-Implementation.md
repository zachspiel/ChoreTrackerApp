                                                    Deliverable 4 - Implementation 1
                                                      Chore Tracker App
                                                   =========================

<h3>1. Introduction </h3>

The problem of managing chores affects households and creates a dirty, disorganized house and tension between household members if left unaddressed. For households with a variety of chores between members, the Chore Tracker App is an organizational app that allows for the efficient distribution and tracking of household chores between household members. Unlike Google Calendar, which just displays events and chores, our app will assign them routinely between household members in an organized fashion. The Chore Tracker App is an organizational app that allows household members to fairly distribute chores and tasks to complete. The value of the Chore Tracker App is the organized approach it brings to chore management and decreases the tensions between household members. The Chore Tracker is different from other apps as it contains fun incentives to stick to the planned schedule created using it.

Github: https://github.com/zachspiel/ChoreTrackerApp/tree/Androidapp-Initial

Trello: https://trello.com/b/YXtiDz3w/main

<h3>2. Implemented requirements</h3>

Our initial implementation focuses on implementing the most important three reuirements:
1. Must be able to add events to calendar if user is an admin.
2. Must be able to view all chores on the calendar, completed or not and can be viewed by either child or admin.
3. Must be able to add or remove members if the user is an admin, and designate groups or families in the app.

By implementing these three requirements, we successfully satified all requirements to be included in our MVP. In the Requirements deliverable, we decided that our MVP would include the ability to add events and view the event calendar. To validate this, we would create a UI for the display of the home page and allowing user to complete the add event form. As a team, we assigned memebers different screens to implement as Java and .xml files in Android Studio. 

Joe - Home screen XML and MainActivity.java 

Olivia - Daily view page for calendar (XML and java)

Zach S-  Monthly view page for calendar (XML and java)

Leslie - Weekly view page for calendar(XML and java)

Andrew -  Login page and add event form (XML and java)

Zach W - Group display page (XML and java)

<h3>3. Adopted technologies </h3>

1. **Android Studio**

      Allows for the group to create an app using java code and xml. Simple and familiar for everyone in the group

2. **Github**

      Allows us to use a simple interface to view and host our repository

3. **GitKraken** 

      Allows easy version control of out app through a simple interface. Can view who made what changes and to easily pull and push our local repository

4. **Trello** 

      Allows for easy organization of our to be completed tasks. Keeps the team organized and provides a place to view their  assigned tasks.

5. **Discord**     

      Allows team communication between all members. Ability to create multiple channels to organize questions, ideas and general             discussions.


<h3>4. Learning/training </h3>
Andrew was already experienced with Android Studio and GitKraken so he was our main source for help and information when doing our assigned panels of the app. We also used online references to help develop aspects of our pages.

<h3>5. Deployment </h3>
AWS link:
[AWS Amplify Link](https://androidapp-initial.d31yomglsbfse1.amplifyapp.com/)

AWS Amplify console:
![AWS console screenshot](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/awsConsole.png)

<h3>6. Licensing </h3>
We choose to license our Chore Tracker App using the GNU General Public License v3.0 (GNU GPLv3), a strong copyleft license. This licesnse grants software developers the freedom to run, study, share, and modify the software. However, the liecnse specifies that developers who modify/use the code, "must pass on to the recipients the same freedoms that [they] received," meaning all modifcations must be published under the same license. We choose this licecnse to prevent people from using the Chore Tracker software in their own projects and then denying other developers use by making their source code closed source.

<h3>7. Readme File </h3>

[Readme.md](https://github.com/zachspiel/ChoreTrackerApp/blob/master/README.md)

[LICENSE.md](https://github.com/zachspiel/ChoreTrackerApp/blob/master/LICENSE)

[CONTRIBUTING.md](https://github.com/zachspiel/ChoreTrackerApp/blob/master/CONTRIBUTING.md)

[CODE_OF_CONDUCT.md](https://github.com/zachspiel/ChoreTrackerApp/blob/master/CODE_OF_CONDUCT.md)

<h3>8. Look & feel </h3>

**Home page**

![This is the homepage, where users navigate to various sections of the app.](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/Homepage.PNG)

We designed the home page to look like a corkboard where you would normally post events in an office. It was a nice touch that primed users for a productive day. We wanted the homepage to be simple so that the user may convienently use it in as little time as possible. We have three main buttons on the corkboard itself, which corresond to the three main functions of our app. At the bottom are the settings, sign-in, and exit buttons, which are more auxillary functions currently.

**Add events page**

![This is the add events form, where users can create and add new events to their schedule.](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/addevent.PNG)

We designed the add events page to allow users to easily add events in under 30 seconds. We currently have the date and time selections as free-text, but we will likely seperate this category later, adding in hardcoded values for time selection specifically. A user's group can also be selected here using radio buttons, but for now we simulate it with three placeholder values. The user can press add to add their event to their calendar (or their groups calendar if selected). If the user would like to cancel the form, they would simply select the cancel button to clear the form and return to the homepage.

![This is the calendar view of events, currently arragned in a weekly view.](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/calendar.PNG)

The calendar (shown in a weekly view) will display each of the users events using textviews and information stored about each event in the app's sql database. Each event will gradually turn red as the deadline to complete each one approaches closer. Once an event is marked as complete, it will turn green.


![This is the login screen for the app](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/login.PNG)

The login screen currently is a form that allows users to enter their username and password into the appropriate sections and be matched up with their profile in the database for the app. We plan on implementing the registration page in the future, which would simply be another form that the user could access by pressing the register button. It will contain a few additional sections that would allow us to track user information, such as their email, username, and password. 


<h3>9. Lessons learned </h3>
This deliverable was a much needed part of developing this project. First off it forced us to use our tools and learn how to use Git which was frustrating but now everyone has a better understanding of how we are going to work together. We learned that this is very time consuming and giving ourselves more time throughout the week is beneficial for future success.

<h3>10.Demo </h3>
Link to the demo video: https://youtu.be/qzIpneAMP7I
