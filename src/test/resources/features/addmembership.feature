Feature: Membership Management

  Scenario Outline: Create new membership records
    Given the admin user is logged into the OrangeHRM application
    And the user opens the membership configuration page
    When the user enters membership name as "<membership>"
    And saves the membership details
    Then the membership "<membership>" should be visible in the membership list

    Examples:
      | membership           |
      | Corporate Membership |
      | Premium Membership   |
      | Annual Membership    |
