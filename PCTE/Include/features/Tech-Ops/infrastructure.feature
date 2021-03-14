@CD-22
@PCTE-10719
@Tech-Ops
@Severity-1

Feature: Infrastructure
	As a God Mode Admin, I want to view the Infrastructure's Grafana dashboard in the Tech Ops application so that I can keep track of the Portal's resource utilization.

	Scenario: View Infrastructure's Grafana Dashboard
		Given My role is God Mode
		And I access the Tech Ops Infrastructure app
		When I open the Infrastructure's Grafana dashboard
		Then I should see the Infrastructure's Grafana dashboard correctly populates
