Feature: Cart verification

  Scenario: Verify Cart Item
    Given user is on homepage "https://www.saucedemo.com"
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user click on Login button
    Then user successfully login and navigate to inventory page
    
    
