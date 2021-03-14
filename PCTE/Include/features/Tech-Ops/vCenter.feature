@CD-22
@PCTE-10720
@Tech-Ops
@Severity-1

Feature: vCenter
	As a God Mode Admin, I want to view the vCenter's Grafana dashboard in the Tech Ops application so that I can keep track of the containers.

	Scenario: View vCenter's Grafana Dashboard
		Given My role is God Mode
		And I access the Tech Ops vCenter app
		When I open a vCenter's Grafana dashboard
		Then I should see the vCenter's Grafana dashboard correctly populates
