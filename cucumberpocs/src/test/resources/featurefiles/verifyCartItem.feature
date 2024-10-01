Feature: Cart verification

  Scenario: correct item is added into cart
    Given user is on homepage "https://www.saucedemo.com"
    When user input username "standard_user"
    And user input password "abc"
    And user click on Login button
    Then user successfully login and navigate to inventory page
    
    
