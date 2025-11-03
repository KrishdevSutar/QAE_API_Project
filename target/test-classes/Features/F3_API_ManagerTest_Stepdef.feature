Feature: Test that the second portion API Testing is functioning
	Background:
		Given User access the "managers" section of the API endpoint
Scenario: Update the list of staffs under a manager
    Given the manager with id 2 exists
    And User sends the staff 3, "bob", and 500 of the new staff
    When I update the list of staffs for manager with id 2
    Then all the staff information under manager with id 2 should be updated

  Scenario: Delete a staff under a manager
    Given the manager "Bell Pepper" and staff id 1 exists
    When I delete the staff with id 1 under manager "Bell Pepper"
    Then the number of staffs managed by manager 2