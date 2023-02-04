Feature:Login
  @Login
  Scenario: Login successfully
    Given the user is on the login page
    When the user enter his credentials
    Then the app should display de dashboard section