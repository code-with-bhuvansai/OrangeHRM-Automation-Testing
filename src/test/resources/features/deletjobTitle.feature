Feature: Delete Job Title

  Scenario Outline: Delete an existing job title
    Given user is logged to OrangeHRM
    When user deletes job title "<jobTitle>"
    Then job title should be deleted successfully

    Examples:
      | jobTitle |
      | Tester   |
