Feature: API Automation test gorest

  @api
  Scenario: Test get list data normal
    Given prepare valid url
    When hit api get list users
    Then validate status code is equal to 200

  @api
  Scenario: Get user detail with id 6940705
    Given prepare valid url
    When hit api get detail user with id 6940705
    Then validate status code is equal to 200

  @api
  Scenario: Create new user with random email and username
    Given prepare valid url
    When hit api create new user
    Then validate status code is equal to 201
    
  @api
  Scenario: Create new user with blank name
    Given prepare valid url
    When hit api create new user with blank name
    Then validate status code is equal to 422
