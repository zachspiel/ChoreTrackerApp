Feature: Add Events Screen
  As a user, I want to be able to add events to my account

  @ui
  Scenario: Checking the feature UI on start
    Given I am on the add Events Page
    Then I see EventName
    Then I see evenDescription



  @smoke
  Scenario: Submitting a valid event
    Given I am on the add Events Page
    And I enter valid name Event Name
    And I add valid date for date
    And I enter Description as a Description
    When I tap on add button
    Then I add event
