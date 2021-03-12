@CD-x
@PCTE-11322
@Portal-Login
@Severity-x


Feature: Taskbar Apps
	As a PCTE member, I want the taskbar apps within Portal to have proper selections.
	
	Scenario: Check Apps as Basic User
		Given My role is member
		When I access Apps
		Then I should be able to view all basic user applications 

	Scenario: Check Apps as Org Admin
		Given My role is admin
		When I access Apps
		Then I should be able to view all org admin applications 

	Scenario: Check Apps as Portal Admin
		Given My role is portal admin
		When I access Apps
		Then I should be able to view all portal admin applications 
		