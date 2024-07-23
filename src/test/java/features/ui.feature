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

  @web
  Scenario: See phone product detail
    Given user is on demoblaze.com page
    When user click first product in phones page
    Then system will show product detail page

  @web
  Scenario: Send a message through contact menu
    Given user is on demoblaze.com page
    When user click contact on header menu
    And user fill contact email with "joshuakwa99@gmail.com"
    And user fill contact name with "joshua"
    And user fill message text with "testing 123"
    And user click send message button
    Then system will show alert says send message success

  @web
  Scenario: See all product in my cart after add product to cart
    Given user is on demoblaze.com page
    And user is already logged in
    And user click first product in phones page
    And user click add to cart button
    Then system will show alert says product added
    When user click cart icon from header menu
    Then system will show page of cart list

  @web
  Scenario: Delete first product from cart
    Given user is on demoblaze.com page
    And user is already logged in
    And user click first product in phones page
    And user click add to cart button
    Then system will show alert says product added
    When user click cart icon from header menu
    And user click delete button on the first item

  @web
  Scenario: Buy 1 phone product
    Given user is on demoblaze.com page
    And user is already logged in
    And user click first product in phones page
    And user click add to cart button
    Then system will show alert says product added
    When user click cart icon from header menu
    And user click place order button
    And user fill name field with "joshua"
    And user fill country field with "indonesia"
    And user fill city field with "jakarta"
    And user fill credit card field with "test"
    And user fill month field with "02"
    And user fill year field with "2020"
    And user click purchase button
    Then system will show pop up of success placing order with detail information
