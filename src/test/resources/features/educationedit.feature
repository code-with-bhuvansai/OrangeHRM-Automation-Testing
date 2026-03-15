Feature: Edit Education

  Scenario Outline: Edit an existing education
    Given the user will login into OrgHRM
    When user will edits education "<oldEducation>" to "<newEducation>"
    Then education should updated successfully

    Examples:
      | oldEducation | newEducation |
      | BSc          | B.E Engineering |
