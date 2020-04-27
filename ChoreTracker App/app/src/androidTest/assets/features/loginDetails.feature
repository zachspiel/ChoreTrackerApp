Feature: Login Screen
  As a user, I want to be able to login to my account that I created

  @ui
  Scenario: Checking the feature UI on start
    Given I am on the Login Screen
    Then I see username and password input

  @acceptance
  Scenario: Submitting valid date of birth in the required format
    Given I am on the Login Screen
    And I enter invalidUser as date of birth
    And I enter badPassword as password
    When I tap on login button
    Then I see Login Failed

  @smoke
  Scenario: Submitting a valid login
    Given I am on the Login Screen
    And I enter testingUser as date of birth
    And I enter Testing123 as password
    When I tap on login button
    Then I login



