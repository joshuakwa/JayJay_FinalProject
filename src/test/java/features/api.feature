Feature: API Automation test gorest

  @api
  Scenario: Test get list data normal
    Given prepare valid url for "USER_GOREST"
    When hit api get list users
    Then validate status code is equal to 200

  @api
  Scenario: Get all user list 2
    Given prepare valid url for get list data

  @api
  Scenario: Get all user list 3
    Given prepare valid url for get list data
