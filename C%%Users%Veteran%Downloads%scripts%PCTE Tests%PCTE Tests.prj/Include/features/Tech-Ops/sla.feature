@CD-9
@PCTE-10723
@Tech-Ops
@Severity-1

Feature: SLA
	As a God Mode Admin, I want to view the SLA's Grafana dashboard in the Tech Ops application so that I can keep track of Spotter menu items.

	Scenario: View SLA Grafana Dashboard
		Given My role is God Mode
		When I access the Tech Ops Spotter SLA app
		Then I should see the Spotter's menu items 
		
#Other scenarios from this test have already been done in the Content-Traffic-Tracker bucket
  