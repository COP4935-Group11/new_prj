@CD-22
@PCTE-10718
@Tech-Ops
@Severity-1

Feature: Active Ranges
	As a God Mode Admin, I want to view the Active Range's Grafana dashboard in the Tech Ops application so that I can keep track of all active ranges.

	Scenario: View an Active Range's Grafana Dashboard
		Given My role is God Mode
		And I access the Tech Ops Active Ranges app
		When I open a Active Range's Grafana dashboard
		Then I should see the Active Ranges' Grafana dashboard correctly populates
