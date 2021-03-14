@CD-4
@PCTE-11594
@Admin-System-Admin
@Severity-1

Feature: Admin resource pool management
	As a God Mode Admin, I want to access an organization's resource pool so I can view and manage resources.
	
	Scenario: Access a Resource Pool
		Given My role is God Mode
		When I access a resource pool
		Then I should see an Organization's allocated resources
