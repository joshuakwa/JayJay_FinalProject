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

  @web
  Scenario: Click all the categories in homepage
    Given user is on demoblaze.com page
    When user click phones categories
    Then system will show all phones products
    When user click laptops categories
    Then system will show all laptops products
    When user click monitor categories
    Then system will show all monitor products

  @web
  Scenario: Click next and previous button to see other page
    Given user is on demoblaze.com page
    When user click next page button
    Then system will show next page products
    When user click previous page button
    Then system will show previous page products

  @web
  Scenario: Add to cart a product from homepage
    Given user is on demoblaze.com page
    And user is already logged in
    When user click first product in phones page
    Then system will show product detail page
    When user click add to cart button
    Then system will show alert says product added
