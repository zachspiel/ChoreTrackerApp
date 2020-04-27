package com.example.myapplication.robot;

import com.example.myapplication.Event;
import com.example.myapplication.addEvents;
import com.example.myapplication.R;
import com.example.myapplication.testCalendar;
import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.not;

public class LoginScreenRobot {

    private ActivityTestRule<addEvents> testRule = new ActivityTestRule<>(addEvents.class, false, false);

    private ActivityTestRule<testCalendar> calendar = new ActivityTestRule<>(testCalendar.class, false, false);

    public void launchScreen() {
        testRule.launchActivity(null);
    }

    public void EventNameClick() {
        onView(withId(R.id.editText)).perform(click());
    }

    public void enterEvent(String event) {
        onView(withId(R.id.editText)).perform(typeText(event));
    }


    public void clickDate()
    {
        onView(withId(R.id.buttonDate)).perform(click());

    }

    public void pickDateClose()
    {
        Espresso.pressBack();

    }

    public void EventDescClick() {
        onView(withId(R.id.editDesc)).perform(click());
    }

    public void enterDesc(String desc) {
        onView(withId(R.id.editDesc)).perform(typeText(desc));
    }
    public void clickAddEvent(){
        onView(withId(R.id.button)).perform(click());
    }

    public void closeKeyboard() {
        Espresso.closeSoftKeyboard();
    }

    public void calendar()
    {
        calendar.launchActivity(null);
    }

}
