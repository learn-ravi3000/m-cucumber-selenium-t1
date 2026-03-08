Feature: Example domain smoke check
  As a learner
  I want to validate a simple web page
  So that I can practice Selenium automation with Cucumber and TestNG

  Scenario: Open Example Domain and verify heading
    Given I open the example domain home page
    Then I should see the page heading as "Example Domain"
