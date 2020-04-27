package com.example.myapplication.stepDefinitions;

import com.example.myapplication.robot.LoginScreenRobot;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {
    private LoginScreenRobot robot = new LoginScreenRobot();
    @Given("^I am on the add Events Page")
    public void launchEventScreen() {
        robot.launchScreen();
    }
        @Then("^I see EventName")
                public void ClickEventName() {
                robot.launchScreen();
                }
        @Then("^I see evenDescription")
             public void ClickDescription() {
            robot.EventDescClick();
        }

        @And("^I enter valid name Event Name")
            public void EventNameEnter() {
            robot.enterEvent("Take out the trash");
        }
        @And("^I add valid date for date")
        public void DateClick() {
            robot.clickDate();
        }
        @And("^I enter Description as a Description")
            public void EnterDesc() {
            robot.enterDesc("Make sure to take out the trash in the kitchen and the recycling out back");
        }
        @When("^I tap on add button")
             public void addEvent() {
            robot.clickAddEvent();
        }
        @Then("^I add event")
             public void eventAddedCheck() {
            robot.calendar();
        }
    }


