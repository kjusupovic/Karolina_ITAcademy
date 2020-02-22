Feature: UserAdress

  Scenario: Adding new user address
    Given Navigate to shop page
    When I click Sign in
    And I log in
    And I choose to add new address
    And I fill address form
    And I click save address
    Then I can see I have added first address