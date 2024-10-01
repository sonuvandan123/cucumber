Feature: Website login

  Background: 
    Given user is on homepage "https://www.saucedemo.com"
    When user input username "standard_user"

  Scenario Outline: user login with different passwords
  And user input password "<password>"
    And user click on Login button
    Then user <outcome>

    Examples: 
      | password     | outcome                                           |
      | secret_sauce | successfully login and navigate to inventory page |
      | invalid      | should remain in login page                       |
