                                           Deliverable 7 - Verification and Validation
                                                      Chore Tracker App
                                                   =========================

<h2>1. Description</h2>

The Chore Tracker App is designed to address a common issue plaguing households across the world: the division of labor. For households with a variety of chores between members, the Chore Tracker App is an organizational app that allows for the efficient distribution and tracking of household chores between household members. The design of the app is based around convenience.The Chore Tracker App is designed as an easy to use tracking tool that takes under 30 seconds to use. We want to create a usable, yet powerful organization tool that prioritizes users' valuable time above all else.

<h3>2. Verification (tests)</h3>

<h4>2.1. Unit Tests</h4>
2.1.1. Test Framework: JUnit4

2.1.2. [GitHub Test Folder](https://github.com/zachspiel/ChoreTrackerApp/tree/database_current/ChoreTracker%20App/app/src/test/java/com/example/myapplication)

<h5>2.1.3. Example: </h5>
Github Link of Event Class:
https://github.com/zachspiel/ChoreTrackerApp/blob/database_current/ChoreTracker%20App/app/src/main/java/com/example/myapplication/Event.java

GitHub Link of TestEvent:
https://github.com/zachspiel/ChoreTrackerApp/tree/database_current/ChoreTracker%20App/app/src/test/java/com/example/myapplication/EventTest.java
<h5>2.1.3. Example: </h5>

![EventTest](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/EventTest_running.JPG)

<h4>2.2. Integration Tests</h4>

2.2.1 Test Framework Used : JUnit4

2.2.2 [Automated Integration Test Locations](https://github.com/zachspiel/ChoreTrackerApp/blob/master/ChoreTracker%20App/app/src/test/java/com/example/myapplication/)

2.2.3 [Automated Integration Test File](https://github.com/zachspiel/ChoreTrackerApp/blob/master/ChoreTracker%20App/app/src/test/java/com/example/myapplication/DatabaseAccessTest.java)

2.2.4 ![Integration test of database, and chores](https://github.com/zachspiel/ChoreTrackerApp/blob/master/Image%20Resources/integration_testing.png)

<h4>2.3. Acceptance</h4>

2.3.1 Test Framework Used : Cucumber

2.3.2
[Automated Acceptance Test Locations](https://github.com/zachspiel/ChoreTrackerApp/tree/Added-Acceptance-Testing/ChoreTracker%20App/app/src/androidTest/java/com/example/myapplication)

2.3.3
Automated Acceptance Tests: 
[features](https://github.com/zachspiel/ChoreTrackerApp/blob/Added-Acceptance-Testing/ChoreTracker%20App/app/src/androidTest/assets/features/addEvents.feature) ,
[step defintions](https://github.com/zachspiel/ChoreTrackerApp/blob/Added-Acceptance-Testing/ChoreTracker%20App/app/src/androidTest/java/com/example/myapplication/stepDefinitions/MyStepdefs.java), 
[CucumberTestCase](https://github.com/zachspiel/ChoreTrackerApp/blob/Added-Acceptance-Testing/ChoreTracker%20App/app/src/androidTest/java/com/example/myapplication/test/CucumberTestCase.java) and 
[robot used](https://github.com/zachspiel/ChoreTrackerApp/blob/Added-Acceptance-Testing/ChoreTracker%20App/app/src/androidTest/java/com/example/myapplication/robot/LoginScreenRobot.java)
  
<h3>3. Validation (user evaluation)</h3>

<h3>User Validation Script and Results</h3>

**Interview 1**
Interviewee: Grace Yang

**General Questions**

**What are your first impressions of the app?**
The background is a bit blurry, use pure color instead of wood image background.


**Were you able to log in successfully?**
Yes

**Do you like the homepage?**
No, the green is weird with the brown and yellow color scheme. Try for more of a blue theme. 

 

**Please try and add an event to your calendar. How easy is it to find?**
Found manage chores, add another chores, found form. 

On the form, couldn’t easily move past fields. Cannot type in descirption after event name.
Fixed using the back button. 

Successfully modified event name. It crashed??? Event disappears with back button.

Saw the event after refresh from homepage.


Found event on calendar.

Please try and find your user information and settings. 
I didn’t find it very well, the homepage is not relatively. 

Please try and add a group through the app
Not good.  Not reactive. The form should have designated fields for first and last names. 
Should record phone numbers to add members to a group. 
Quote:
“I would want to see the quote right when I open the app, and this makes me want to click on it.”

**Reflection**

**How similar is this app to google calendar?**
Different because once you get into a normal calendar, the first thing you see is a normal calendar. Here you click on add event first, and then you can choose a date. Seperate forms.

The process is like the opposite. 
**Out of 10, how well would you rate the app so far?**
4

**What suggestions do you have to improve our app?**
First of all, make the colors look more comfortable. “If people look at the background, they can get dizzy. The yellow color is a bit too light, and shiny if you want to add at night” 

Implement more of a dark mode design. Can’t edit events. Entering the event form should navigate better. Can't cancel the add without using the back arrow. 

**Does this app perform the function of tracking chores?**
Yes, but not very well. But it is in the very early stages so its not a big deal. 


**Interview 2**
Interviewee: Kevin Lopez

**General Questions**

**What are your first impressions of the app?** 
UI is a bit basic

Not a huge fan of the color scheme

**Were you able to log in successfully?**
Yes the log in works

**Do you like the homepage?** 
Would be a 4 or 5ish. Color scheme isn’t great. Higher res, use the color theory and color wheel. Choose opposite colors and make a color palette that way.

**Please try and add an event to your calendar. How easy is it to find?**
Accidentally swiped 

Added an event successfully. Cannot view event list and should automatically bring back to event list. If you have multiple events on calendar. Displays multiple events on calendar. Calendar did not appear automatically, had to swipe for some reason.

**Please try and find your user information and settings.** 
Had to flip phone to find it. 

Please try and add a group through the app
It kinda works, but cannot save the group.

**Reflection**

**How similar is this app to google calendar?**
Extremely similar, but more involved and more features i.e. it is device independent so it wont have extreme transfer issues, you just need one account to use it.

**Out of 10, how well would you rate the app so far?**
5

**What suggestions do you have to improve our app?**
Have app fit the phone screen. Have grabbers to scale to screen size.
Color scheme, add more functionality.

**Does this app perform the function of tracking chores?**
Yes, but we should add events and notifications to remind user. 


**Interview 3**
Interviewee: Alenn Wright

General Questions

**What are your first impressions of the app?** 
Color hurts my eyes, background image looks like TV static. Slightly 

**Were you able to log in successfully?**
Yes

**Do you like the homepage?** 
Not really, needs to fit the screen and the buttons are far too spaced out. ChoreTrackerApp name is kinda bad. 

The corkboard needs to be a higher quality image. 

**Please try and add an event to your calendar. How easy is it to find?**
View calendar and manage chores are misleading. First button should be view calendar and middle button should be add/edit events. Tutorial showing add event form, add notifications and swipe messages to help users add and delete them. Edit and add events and add option to mute event instead. 

No time selection, only date. Trying to spam description and add events. Should limit form description to 100 characters. It wildly overflows and takes up the whole screen and goes under buttons. 

Event shows on calendar, but overflows and requires scroll afterwards. Need to refresh lists and displays to show info and images. 



**Please try and find your user information and settings.** 
Needed to rotate phone, need to fix display.
Please try and add a group through the app
Can add group member, but not individual groups. Swipe down and add triple bar icon. Daily reminders as sticky notes. Do most of the adding logic and sticky notes, pencil at the bottom to add something to a day. Adding sticky notes and focus on ease of use and lightweight. 

**Reflection**

**How similar is this app to google calendar?**
Not at all.

**Out of 10, how well would you rate the app so far?**
Good start, groundwork is written. 3/10 in current state, the core is there, but UI is not user friendly. Would be a lot more interesting, less form and more customization


**Does this app perform the function of tracking chores?**
Very basically yes, if I needed a todo list. It's not quite there as a calendar yet.

<h3>Overall Reflection</h3>

Overall the user validation for the product was rather poor, but we did recieve excellent feedback about how to improve. One of the main issues was that the UI was not scaled properly, especially on the homepage. To fix this, we will implement less absolute positioning and use relative positioning and layouts that easily adjust to a given screen size. This will allow the app to appear better on several different devices. 

Also, we need to implement further testing and limits on small things such as the amount of text that can be entered into an event. Additionally, groups still need to be properly implmented to meet our complete MVP. The app design still needs work to look more professional and appealing, but users were able to perform most of the core functions of the app when asked. There was a bit of a learning curve that we can address, such as users not knowing all the functionality needed to add an event to the calendar. We could add notifications and a quick tutorial for new users to learn about our app. 

On a positive note, our app does more useful things than other calendar apps such as Google Calendar. In every interview, we asked if our Chore Tracker App was similar to Google Calendar. We were pleased to see that our app behaves significantly different than Google Calendar and other built-in calendar apps on the users' devices. If we are able to fix the UI and small bugs in our application logic, we will have a solid product that is sufficiently useful over popular competitors. 

