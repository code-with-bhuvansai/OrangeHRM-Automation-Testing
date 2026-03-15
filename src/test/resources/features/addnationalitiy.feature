Feature: Add Nationality Functionality
  As an Admin User
  I want to add new nationalities to the system
  So that I can assign them to employee profiles

  Background:
    Given the user is logged in as an Administrator
    And the user navigates to the "Nationalities" configuration page

  # 'Scenario Outline' is used for Data-Driven Testing in BDD
  Scenario Outline: Successfully add multiple new nationalities
    When the user clicks on the "Add" button
    And the user enters "<nationalityName>" into the Name field
    And the user clicks on the "Save" button
    Then the system should display a success message "<successMessage>"
    And the new nationality "<nationalityName>" should appear in the Nationalities list

    # The 'Examples' table drives the data into the variables above
    Examples:
      | nationalityName | successMessage      |
      | Russia1234          | Successfully Saved  |
      | Indian1234          | Successfully Saved  |
      | Japanese1234        | Successfully Saved  |
      | Brazilian1234       | Successfully Saved  |
      | Kenyan1234          | Successfully Saved  |