
                                        	          Deliverable 5 - Design
                                                      Chore Tracker App
                                                   =========================

<h3>1. Introduction </h3>
The Chore Tracker App is designed to address a common issue plaguing households across the world: the division of labor. Specifically, the Chore Tracker App allows members of a household to assign chores to each other in order to keep organized and get stuff done! The design of the app is based around convenience.The Chore Tracker App is designed as an easy to use tracking tool that takes under 30 seconds to use. We want to create a usable, yet powerful organization tool that prioritizes users' valuable time above all else.

When a user first opens the Chore Tracker App, they are prompted to sign in and create an account with us. This account is stored in our sql database and is used to store information, such as groups and schedules, that are tied to the user. Once logged in, the user can navigate to the add chores section. Here, users can assign themselves chores with a start date and time, end date and time, and a description. Additionally, the user can opt to post the chore in the group they belong to. Groups are added and stored in the database using a seperate form navigated to from the home page. Groups are created by inputting a group name, optional description, and a mutable list of members. The user creating it starts as the first member of the group, and is denoted as an admin. Admins may be added and removed by editing an existing group. Finally, any user can conveniently see their calendar of events by navigating to it from the home page. Here, users can see their chores from any group they are a part of as well as their personal events. Events are displayed as text boxes with a description, and they will programmatically turn from white to an increasing intensity of red if they are not yet completed. If a user marks an event as completed, it will turn green on the calendar. The Chore Tracker App will have all of this functionality implemented and tested to ensure that it conforms to our goal of a <30 second use time. 


<h3>2. Architecture </h3>
This application uses a three layered architecture consisting of the presentation layer, the business layer, and the data access layer. The presentation layer consists of the user interface and the options presented to the user. The business layer contains all of the logic needed to add events, add user's to a group and modify the app settings to the user's preferences. The data access layer consists of the classes needed to access the AWS database and modify the tables within it.

![System Architecture](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/HighLevelArchitecture.jpg)

GitHub Link: https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/HighLevelArchitecture.jpg

<h3>3. Class diagram </h3>

![UMLDiagram](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/UML_Updated.png)

GitHub Link: https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/UML_Updated.png 

<h3>4. Sequence Diagram </h3>

**Use Case Description**

Use case: view a weekly schedule of chores
Actor: household member (user)
Description: A user of the app who is registered as a household member can select the weekly view option from the calendar in order to view the current week's schedule of chores.
Pre-conditions: The user is logged into the app and it currently at the homepage
Post-condtions: The user is now on the weekly view page of the app and can see the schedule of chores for the current week

Main flow:
1. The user selects Calender from the homepage menu
2. The user selects the Weekly View option from the main Calender page
3. The system finds all events with a deadline during the current week
4. The Weekly View is displayed with all chores with a deadline in the current week

Alternative flow:
\*a. The user navigates away from the calender page at any time
  b. The user can view the weekly schedule by following the main flow from Step 1
  
**Sequence Diagram**

![SequenceDiagram](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/View%20weekly%20schedule%20sequence%20diagram.png)

GitHub Link: https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/View%20weekly%20schedule%20sequence%20diagram.png

<h3>5. Design Patterns </h3>

 ![UMLpattern](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/behavioral-stag-uml.png)
 
 - Event: 
 - EventPanel:
 - RepeatingEvent:
 - MultipartedEvent: 
 
 The strategy design pattern correlates with the classes; Event, EventPanel, RepeatingEvent, and MultipartedEvent, because we can change the Event class to have an effect to the extending classes, making the algorithm interchangeable. 

<h3>6. Design Principles </h3>
    Our design represents good design principles by having good cohesion, no repetition and simple design. An example of good cohesion is the calendar view class. The monthly, weekly and daily view complement each other so well it creates a cohesive product. For simplicity our app focuses on the basics and doesn’t try to do more than it needs to. Our basic functionality boils down to creating a group, sharing events with the group and keeping track of who needs to do which event. We want the users to be able to get the most out of the app without over complicating things. Finally we use no repetition in the app. We want screens to be as unique as possible to avoid confusing the users and keep the app simple. Each class in the design has its own unique action and while some of them are similar they present their own unique way to present data to our user base

<h3>Deliverable Information</h3>
GitHub Link: https://github.com/zachspiel/ChoreTrackerApp

**Team Partitipation**
Joe Vargovich (20%) - completed Part 1 and contributed the Design Pattern to Part 5
Leslie Gurrola (15%) - worked on EventPanel and all Calender classes for the UML Diagram for Part 3 and contributed the Strategy Pattern to Part 5
Olivia Thoney (15%) - completed Part 4 and all deliverable information requirements as Quality Assurance for this week
Zach Wilson (15%) - worked on Event classes for the UML Diagram for Part 3 and contributed the --Design Pattern-- to Part 5
Zach Spielberger (20%) - completed Part 2 and worked on the User, Settings, Group and Admin classes for the UML Diagram
Andrew Munoz (15%) - completed Part 6
  
