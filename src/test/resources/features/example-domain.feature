Feature: Home Depot search smoke check
  As a learner
  I want to validate a user search journey
  So that I can practice Selenium automation with Cucumber and TestNG

  Scenario: Open Home Depot and search for refrigerators
    Given I open the Home Depot home page
    When I search for "refrigerators" from the search bar
    Then I should be navigated to search results for "refrigerators"
