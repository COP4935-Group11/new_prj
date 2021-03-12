@CD-13
@PCTE-11593
@Portal-Login
@Severity-1


Feature: SSO Login
	As a PCTE member, I want to access SSO applications within Portal to use its services.

	Scenario: Access Traffic Tracker via Event
		Given My role is member
		When I access Traffic Tracker via Event
		Then I should be able to view Traffic Tracker contents with no errors 

  Scenario: Access Traffic Tracker via URL
		Given My role is member
		When I access Traffic Tracker via URL
		Then I should be able to view Traffic Tracker contents with no errors 

	Scenario: Access Grafana via Portal
		Given My role is portal admin
		When I access Grafana via Portal
		Then I should be able to view Grafana contents with no errors 
	
	Scenario: Access Grafana via URL
		Given My role is portal admin
		When I access Grafana via URL
		Then I should be able to view Grafana contents with no errors 
 