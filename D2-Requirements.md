1. Positioning
  1.1 Problem Statement
  "The problem of mangaging chores affects households the impact of which creates a dirty, disorganized house and tension between household members if left unaddressed."
  1.2 Product Position Statement
  "For households with a variety of chores between members, the Chore Tracker App is a organizational app that allows for the efficient distribution and tracking of household chores between household members, unlike Google Calendar, which just displays events and chores, our app will assign them routinely between household members in an organized fashion.
  
  1.3 Value Proposition
  The Chore Tracker App is a organizational app that allows household members to fairly distribute chores and tasks to complete. The value of this organized approach to chore managment is a clean house and a low amount of tension between household members. The Chore Tracker is different from other apps, such as Google Calendar, as it contains fun incentives to stick to the planned schedule created using it.
  
 Consumer segment: Households/Household members with a variety of chores to routinely complete.
 
2. Stakeholders

3. Functional Requirements (features)
  1.	Must be able to add events to calendar if user is an admin.
  2.	Must be able to remove or edit events from calendar if user is an admin.
  3.	Must be able to mark chores as completed if child or admin. 
  4.	Must be able to view all chores on the calendar, completed or not and can be viewed by either child or admin.
  5.	Must be able to add or remove members if the user is an admin, and designate groups or families in the app.
  6. One chore is completed, users must be able to view availible rewwards, or any reward they may earn. 
  
4. Nonfunctional Requirements
   1. Flexibility: App will be compatible on Android devices regardless of size.
   2. Reliability: App will always be able to show users calendar with events.
   3. Maintainability: App will be maintained through its lifetime to ensure user satisfaction.
   4. Security: User information will be stored in secure database to prevent from data leaks.
   5. Effeciency: App load time will be minimized in order to keep users satisfied.
   6. Satisfation: App will be convienient to use and encourage users to compelete chores.
   7. Performance: Data will be loaded quickly and presented to users in easy to use manner.
   
5. MVP
To develop the minimum viable product(MVP) for this project, we would need to develop the core components of our app. The core component of the Chore Tracker app is the ability to add events and view the event calendar. To validate this, we would create a UI for the display of the home page and allowing user to complete the add event form. Additionally, we would allow users to view either a list of events or the calendar to display them. Another core feature that needs to be implemented is the group designation in order to group users together. This feature would be validated through user testing of the group form.

6. Use Cases
  6.1 Use-Case Diagram
  In Repository, under name "UseCaseDigram.png"
 
 6.2 Use-Case Description
  
Use Case: Edit Group and Account Information

Actor: Household Admins 

Description: The users can edit who is in the household and the household name

PreCondition: The user has clicked on the settings button

Post-Conditions:  The user now has either made changes to the household or has viewed household information

Main Flow: 

The user clicks on the settings button

The user views their information \

If the user decides to edit the information they click the pencil icon

The household names will now either appear for the user to add or subtract users

The household name is now editable

The household picture is now editable

The app notifies the user that their information has been updated.

Alternative Flows: 

The user chooses to sign off from their app at the bottom of the screen.

The user is returned to the login screen

The user exits the screen after viewing the information with no changes made 
 
 ![Image of AccountInformation](https://github.com/zachspiel/ChoreTrackerApp/blob/Resource-branch/Image%20Resources/Account%20Information(Edit%20state).png)
  
Use Case: Add Event

Actor: Household Admins 

Description: The admin can assign tasks to particular individuals in their household and can set when and where the event is to be completed.

PreCondition: The user is logged in and has clicked the add event button

Post-Conditions:  The admin has now assigned a task to a household individual

Main Flow: 

The user clicks the add event button

The user names the event or chore in question

The user sets the start time for the event

The user sets the end time for the event

The user chooses which one of it’s groups need to be assigned the task

The user clicks on the user who they want to assign the task to

The user submits the task

The user has now created a chore for someone else to complete 

Alternative Flows: 

The user chooses to edit an event
 
 The user changes events accordingly 
 
 The user receives and in app alert that their event has been edited

The user exits the screen after viewing the information with no changes made 

  ![Image of ModifyEvent](https://github.com/zachspiel/ChoreTrackerApp/blob/Resource-branch/Image%20Resources/Add%20_ModifyEvent.png)
  
Use Case: Calendar Monthly View

Actor: Household Admins and subusers

Description: The users can check their chores that were assigned to them and view how much they have completed, how much they missed and how many they still have left to do

PreCondition: The user is logged in and has clicked the calendar view

Post-Conditions:  The user now has insight on how their month looks in a calendar view

Main Flow: 

The user clicks on the calendar view for their household

If there is an assignment assigned to them they can see it in the calendar view

If the user has an upcoming task that has not been completed they will see it in labeled in blue.

The user sees that they have either completed a task or missed a task

The user clicks on whichever chore they are seeking more information on

They will be notified if the task is overdue or how long is left to complete the task.

Alternative Flows: 

The user chooses to cancel the calendar view

The user is returned to the home screen

The user decides to add to the event calendar
 
 The app checks for admin privileges and if the user has these privileges then they are taken to the add event screen
 
 ![Image of Calendar](https://github.com/zachspiel/ChoreTrackerApp/blob/Resource-branch/Image%20Resources/Calendar%20Monthly%20View.png)


7. User Stories

8. Trello
  Trello URL: https://trello.com/b/YXtiDz3w/main 
