@CD-11
@PCTE-10739
@Admin-System-Admin
@Severity-1

Feature: Organizational Structure
	As an Admin, I want to be able to create Organization Structures so that I organize users within them.

 Scenario: Creating an Organizational group
		Given My role is Admin
		When I add an Organization group
		And I provide a Name for the group
		Then I should see the group in the Organization Structure

	Scenario: Move a user to an Organization group
		Given My role is Admin
		When I move a user to an Organization group 
		Then I should see the user is a member of the group

	Scenario: Move a user back to root Organization group
		Given My role is Admin
		When I move a user to the root Organization group
		Then I should see the user is a member of the root Organization group
		
	Scenario: Delete an Organizational group
		Given My role is Admin
		When I delete an Organization group
		Then I should not see the group in the Organization Structure