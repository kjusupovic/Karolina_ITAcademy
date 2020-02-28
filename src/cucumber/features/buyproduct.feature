Feature: BuyProduct

  Scenario: Buying Brown Cushion
    Given Navigate to shop page
    When I click Sign in
    And I log in
    And I navigate to accessories
    And I choose Mountain Fox Cushion
    And I choose black color
    And I add two cushions to cart
    And I go to cart
    And I can see I have two cushions in my cart
    And I remove one cushion from cart
    And I finish my purchase
    Then I can see my order is confirmed