Feature: Practice automationtesting

  Scenario: User should be able to log in to Practice automationtesting
  Given Open the browser
    When the user is able to launch the URL "https://practice.automationtesting.in"
    And Click on my account menu
    And Enter registered username "shrayupadhyay@gmail.com" and password "Abcde@12345"
    And the user clicks the login button
    Then the user should be successfully login
