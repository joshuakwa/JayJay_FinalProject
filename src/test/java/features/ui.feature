Feature: UI Automation test demoblaze

  @web
  Scenario: Login using valid email and password
    Given user is on demoblaze.com page
    When user click sign in button from header menu
    And user input username text box with "joshuakwa"
    And user input password text box with "joshuakwa"
    When user click login button
    Then user will redirect to homepage with logged in state

  @web
  Scenario: Sign up using existing user
    Given user is on demoblaze.com page
    When user click sign up button from header menu
    And user input sign up username text box with "joshuakwa"
    And user input sign up password text box with "joshuakwa"
    When user click sign up button
    Then system will show alert says this user is already exist

  @web
  Scenario: Sign up using new user
    Given user is on demoblaze.com page
    When user click sign up button from header menu
    And user input sign up username
    And user input sign up password
    When user click sign up button
    Then system will show alert says sign up successful