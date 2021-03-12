@CD-4
@PCTE-11588
@Admin-System-Admin
@Severity-1

Feature: Test Deployment Target
	As an God Mode Admin, I want to test a target deployment so that I can verify connectivity.

	Scenario: Test Deployment Target
		Given My role is God Mode
		And I select a deployment target
		When I test the connection
		Then I should see the connection was successful