Feature: goRest API Test

  @CreateTest
  Scenario: Register User Details
    Given Navigate register-user page
    When Fill user details
    Then Click register and validate in webtable

  @UpdateTest
  Scenario: Update Phone number
    Given Navigate to web tables
    When Edit button double click and update phone number
    Then Validate if new number is saved

  @SortTest
  Scenario: Sort in webtable
    Given Navigate to web tables
    When Get the webtable data and click topmenu to check sorted
    Then Validate sorted data

  @FetchTest
  Scenario: Chart data display
    Given Navigate to web tables
    When Navigate to charts page
    Then Print the available data

  @DeleteTest
  Scenario: Delete from webtable
    Given Navigate to web tables
    When Delete user from the webtable
    Then Validate

