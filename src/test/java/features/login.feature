@login
Feature: Login

  Scenario: Login using valid email and password
    Given user is on demoblaze.com page
    When user click sign up button from header menu
    And user input username text box with "joshuakwa"
    And user input password text box with "joshuakwa"
    When user click login button
    Then user will redirect to homepage with logged in state