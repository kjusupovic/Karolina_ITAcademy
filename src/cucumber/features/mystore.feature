Feature: MyStore

  Scenario: Registration an account
    Given Navigate to shop page
    When I click Sign in
    And I click Create an account
    And I fill a form
    And I click save
    Then I can see I am logged in