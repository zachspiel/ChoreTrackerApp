                                                            Deliverable 2
                                                           Chore Tracker App

**1. Positioning**
  
  **1.1 Problem Statement**
  "The problem of managing chores affects households the impact of which creates a dirty, disorganized house and tension between household members if left unaddressed."
 
  **1.2 Product Position Statement**
  "For households with a variety of chores between members, the Chore Tracker App is a organizational app that allows for the efficient distribution and tracking of household chores between household members, unlike Google Calendar, which just displays events and chores, our app will assign them routinely between household members in an organized fashion.
  
  **1.3 Value Proposition**
  The Chore Tracker App is a organizational app that allows household members to fairly distribute chores and tasks to complete. The value of this organized approach to chore management is a clean house and a low amount of tension between household members. The Chore Tracker is different from other apps, such as Google Calendar, as it contains fun incentives to stick to the planned schedule created using it.
  
 Consumer segment: Households/Household members with a variety of chores to routinely complete.
 
**2. Stakeholders**
  
  1. College Students
    College students are a primary user of the Chore Tracker app as they often live in dormitories with fellow students. The Chore Tracker App will be useful to them as they will be able to divide up tasks evenly between their household members. 
  
  2. Parents
  Parents will also benefit from the Chore Tracker App as they will be able to assign chores and tasks for their children to complete.  The Chore Tracker App will include simple incentives to encourage children to do their assigned chore consistently.  
  
  3. Competitors: Google Calendar, Physical Agendas
  Google Calendar offers basic time-management tools that are like ours. We will need to add a unique design and emphasize convenience in order to beat it.
  Physical agendas are quite easy to use. We must emphasize the convenience of having a programmable agenda on a user’s smartphone.     Perhaps we can emphasize the eco-friendliness of a digital agenda over using a physical book. 
  
  4. Potential Detractors: Professors and Managers
Professors and other types of managers will likely have their own systems in place already to track assignments and tasks for their students. We must be able to integrate these plans (such as syllabi) to our app efficiently.
  
  5. Development team
The development of the Chore Tracker App will be divided between our six team members. Using the pre-established roles, we will rotate between responsibilities for each phase of implementation.



**3. Functional Requirements (features)**
  1.	Must be able to add events to calendar if user is an admin.
  2.	Must be able to remove or edit events from calendar if user is an admin.
  3.	Must be able to mark chores as completed if child or admin. 
  4.	Must be able to view all chores on the calendar, completed or not and can be viewed by either child or admin.
  5.	Must be able to add or remove members if the user is an admin, and designate groups or families in the app.
  6. One chore is completed, users must be able to view available rewards, or any reward they may earn. 
  
**4. Nonfunctional Requirements**
   1. Flexibility: App will be compatible on Android devices regardless of size.
   2. Reliability: App will always be able to show users calendar with events.
   3. Maintainability: App will be maintained through its lifetime to ensure user satisfaction.
   4. Security: User information will be stored in secure database to prevent from data leaks.
   5. Efficiency: App load time will be minimized in order to keep users satisfied.
   6. Satisfaction: App will be convenient to use and encourage users to complete chores.
   7. Performance: Data will be loaded quickly and presented to users in easy to use manner.
   
**5. MVP**
To develop the minimum viable product(MVP) for this project, we would need to develop the core components of our app. The core component of the Chore Tracker app is the ability to add events and view the event calendar. To validate this, we would create a UI for the display of the home page and allowing user to complete the add event form. Additionally, we would allow users to view either a list of events or the calendar to display them. Another core feature that needs to be implemented is the group designation in order to group users together. This feature would be validated through user testing of the group form.

**6. Use Cases**
  6.1 Use-Case Diagram
  
  ![UseCase1](https://github.com/zachspiel/ChoreTrackerApp/blob/master/UseCaseDiagram.png)
  In Repository, under name "UseCaseDigram.png"
 
**6.2 Use-Case Descriptions**
  
**Use Case: Edit Group and Account Information**

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
  
**Use Case: Add Event**

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
  
**Use Case: Calendar Monthly View**

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

**Use case: Creating a group**

Actor: Household member  (admin)

Description: The member is preparing a group with standard household members.

Preconditions: The member has purchased the app.

Post-condition: The member has successfully made the group and sent out invites. 

Main Flow:

The user has filled out all their login information.

The system successfully allows them to enter their account.

The user clicks on creating a new group icon, creating a new group.

The system files the information of the new group.

The system present the user with the invite link to the group

The user invites other people they desire to be in the group. 

The user waits till the invites are accepted.

The system saves the information of the people that accepted the invite.

Alternative Flows:

2.New account: The system provides them the page for them to make their new account. 

7.The invites are declined and the admin of the group will be notified about the rejection. 
The user can resend the invite or invite other people. 


**Use case: Complete chores**

Actor: Household member

Description: The member is done with their chores.

Preconditions: The member has login into their account.

Post-condition: The member has successfully completed their chores. 

Main Flow:

The user has opened up their chore list.

The user has marked their task/ chore as complete.

The system has successfully processed the data.

The system notifies the admin about the task being completed.

Extensions:

2.The user does not complete tasks so the system notifies the admin about uncompletion. 

**Use case: Assigning an admin**

Actor: Household member (admin)

Description: The admin assigns a standard member to be another admin.

Preconditions: The member has login into their account.

Post-condition: The admin has successfully added the new admin. 

Main Flow:

The admin has goes into the group information settings

They select the member they want to be admin

The system gives that member a confirmation

The member accept the role

The system process that there is another admin in the group 

The system updates the group 

The admin gets a confirmation that an admin has successfully be added to the group

Extensions:

4.The user denies the confirmation and the system notifies the admin. 
The admin can send the confirmation again. 


**7. User Stories**
 
 1. As a student with roommates, I want an app that can distribute chores fairly so that conflict is reduced and the household function better. Time est: 5 hours, Priority: High
 
 2. As a student with roommates, I want an app that can remind me of when to do my chores so that I can get my tasks done and be a more respectful roommate. Time estimated: 5hrs, Priority: High
 
 3. As a parent with children, I want to be able to assign chores to my children that they will be reminded of using their smartphone. Time est: 2hrs, Priority: High
 
 4. As a parent with children, I want to motivate my kids to do chores through simple rewards. Time estimate: 2hrs to implement incentives, Priority: Medium
 
 5. As a person who lives with roommates I would like to have an app that helps us distribute the chores around the house in a quick and easy manner Time estimate: 5 hours, Priority: Medium
 
 6. As a parent, I would like an app that notifies me when my child has done their chores and I can assign them chores as well with no hassle. Time estimate: 1 hour, Priority: Medium
 
 7. As a college student with roommates, I would like an app that allows me to keep track of who does the most chores around the house. Time: 1 hr, Priority: Medium/Low
 
 8. As a person with roommates, I want an app that allows me to send my roommate a reminder to do the dishes on her night of the week. Time: 2 hrs, Priority: Medium
 
 9. As a nanny, I want an app that I can track the progress of chores on so that I can show the parents who did what each day. Time: 2 hrs, Priority: Medium
 
 10. As a person who has a roommate, I want an app that lets me share a calendar with my roommates so we can all see when chores need to be done. Time: 1 hr, Priority: Medium/Low
 
 11. As a college student, I want an app that allows me to schedule chores on a regular basis so I keep a tidy house. Time: 2 hrs, Priority: High
 
 12. As a college student, I want an app with a list of chores to choose from to schedule because sometimes I'm unsure what chores need to be done. Time: 1 hour, Priority: Medium
 
 13. As a college student living with 3 roommates, I want the ability to send reminders to do chores around the apartment so it will remain clean. Time: 1 hour, Priority: High
 
 14. As a college student living with my family, I want an app that can track who has completed chores weekly so I can make sure everyone is contributing equally. Time: 1hr, Priority: Medium
  

**8. Trello**
  Trello URL: https://trello.com/b/YXtiDz3w/main 
