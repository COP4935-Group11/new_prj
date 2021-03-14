@CD-x
@PCTE-11325
@Portal-Login
@Severity-x


Feature: Dashboard User Menu
	As a PCTE user, I want to be able to access items within the Portal Dashboard User Menu.
	
	Scenario: Access Chat
		Given My role is member
		When I access Chat in the Portal Dashboard User Menu
		Then I should be able to view Chat with no errors

  Scenario: Access User Guide
		Given My role is member
		When I access User Guide in the Portal Dashboard User Menu
		Then I should be able to view User Guide with no errors

  Scenario: Access Support
		Given My role is member
		When I access Contact Support in the Portal Dashboard User Menu
		Then I should be able to view Contact Support with no errors

  Scenario: Access View All Content
		Given My role is portal admin
		When I access View All Content in the Portal Dashboard User Menu
		Then I should be able to view shared content with no errors
								