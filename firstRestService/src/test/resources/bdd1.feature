Feature: Need to test MyRestController
  Scenario: Whenever a student enrolls to a school
    Given A Student enrolls
    When The data is collected
    Then Data is added in the database

  Scenario: Whenever a student leaves the school
    Given A Student leaves
    When The data is collected
    Then Data is removed from the database