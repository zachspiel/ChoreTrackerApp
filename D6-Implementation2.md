                                                    Deliverable 6 - Implementation 2
                                                      Chore Tracker App
                                                   =========================

<h3>1. Introduction </h3>
The Chore Tracker App is designed as an easy to use tracking tool that takes under 30 seconds to use. Upon logging into the app, the user’s are greeted with several options, such as adding an event, viewing their event calendar, and viewing all the groups they are registered under. When adding an event, a user needs to put in an event name as well as a start and end date. The event is then forwarded to their calendar. Users can view a list of their events and swipe to mark them completed. Users can also open their calendar and see the events that they have registered.

A user is able to sign out and view their information by clicking the i icon on the top right of the homepage. This is unique to each registered user, and displays their unique username. In this panel, users can sign out and exit the app as well.

Github Repo: https://github.com/zachspiel/ChoreTrackerApp

Trello: https://trello.com/b/YXtiDz3w/main

<h3>2. Implementation Requirements</h3>

Implementation:

- Joe V: Navigation, Home Page, User and Admin Classes.  
  [Main Activity pull request,](https://github.com/zachspiel/ChoreTrackerApp/commit/a21e9c1161b902022bd8e556adbbc851c5a716f5)
  [Home Page XML pull request,](https://github.com/zachspiel/ChoreTrackerApp/commit/4bdc2c584db17c2691333f8ad5cb05444527a3dc)
  [Admin Class,](https://github.com/zachspiel/ChoreTrackerApp/blob/master/javasrc/d5templatemethod/Admin.java)
  [User Class](https://github.com/zachspiel/ChoreTrackerApp/blob/master/javasrc/d5templatemethod/User.java)
  
  ![MainPage](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/JoeMain_Activity.png)
  ![MainPage2](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/JoeMain_Activity2.png)
  
  Review of pull requests: Zach S, main person helping with databse branch.
  
- Zach S: Database, added backend and connections

  [Setting Pull request](https://github.com/zachspiel/ChoreTrackerApp/commit/ad7b45493c4ba765d21510e6df8d891cfa9be761)
  
  Review of pull request: Zach W, Quality Assurance 
  
  [Database with backend and connection pull request](https://github.com/zachspiel/ChoreTrackerApp/commit/d8fce98026a755504f3d78a68dbc3090ea1eada6)
  
  Review of pull request: Zach W, Quality Assurance
  
- Leslie G: Minor part of Event class

  [Event pull request](https://github.com/zachspiel/ChoreTrackerApp/commit/b7cfab861745e21233cf931d3e948664d15d22f6)
  
  ![Event](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/LeslieAdd_event.JPG)
  
  Review of pull request: Olivia, She was the main person to contribute to Event form

  
- Olivia T: Event Form for database

  [Event finalized pull request](https://github.com/zachspiel/ChoreTrackerApp/commit/92438da72ada2ce060af277170b125ea9c4b6350)
  
  Review of pull request: Zach W, he was quality assurance

  
- Andrew M: Adding users, improving UI design plus Navigation through calendars

  [Calendar navigation pull request](https://github.com/zachspiel/ChoreTrackerApp/commit/84670e13b3d4bcc12251a5dce977eade449fd2a9)
 
  Review of pull request: Zach S, main person to work on databse branch

- Zach W: Adding groups display

  [Group display pull request](https://github.com/zachspiel/ChoreTrackerApp/commit/ae0eee029989fd5d7c07243f1b308d7139a0fc8d)
  
  ![Groups](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/ZacharyGroups.JPG)
  ![Groups](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/ZacharyGroupDisplay.JPG)
  
  Review of pull request: Zach W, Quality assurance


<h3>3. Demo </h3>
[link to demo](https://youtu.be/FFFoCwIYMPo)

<h3>4. Code quality </h3>

In order to maintain good code quality, we used several techniques we learned in class such as low coupling, high cohesion and team collaboration. We wanted to make sure our project can function well due to one aspect of the project not working so we implemented low coupling. Every bit of the app can work on it's own and has little to no dependencies on other activities. Using high cohesion helps us by creating a cohesive project that can be easily tested and creates maintainable code. Lastly we use team collaboration to ensure that the code we submit is reviewed and doesn't break the current product in place. We make sure every bit is reviewed even if the user who submitted the code is quality assurance. This insures that multiple eyes can make sure what we are uploading is for the best of the project and any mistakes can be corrected before we make any critical errors.
quick writeup thoughts?

<h3>5. Lesson learned </h3>

In the second implementation we, as a group, learned how to distribute our roles better and make sure everyone is on time with their part of the project. With more people knowledgeable about creating apps, they were the ones that had a bigger role in this project due to them helping out more compared to the people that do not have as much experience. With this in mind of the different level of app development we have in the group we communicated better as a team to help each other out if needed so. If we did have more time for this implementation we would like to step up the program by making additional features to our app so it can appeal to the consumers, but as of right now our app is suited for a simple application that allows users to track their chores as a group and see when the chore need to be done with the calendar aspect. Something that we would like to change if we were to continue developing our app was to further tweak our notify part of the application so when users need to be notified of a task the application will allow them so.
