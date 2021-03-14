@CD-x
@PCTE-15663
@Portal-Login
@Severity-x


Feature: Notifications
	As a PCTE user, I want to be able to access notifications within the Portal Dashboard User Menu.
	
	Scenario: Access Notifications
		Given My role is member
		When I access Notifications in the Portal Dashboard User Menu
		Then I should be able to view Notifications with no errors
