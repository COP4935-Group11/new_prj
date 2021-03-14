@CD-9
@PCTE-6068
@Event-Event-Outlook
@Severity-1

Feature: Ensure Traffic Tracker Works
	As a Training Manager, I want to connect to Traffic Tracker from an Exercise Event so that I can verify I can connect to Traffic Tracker
	
	Scenario: Ensure Traffic Tracker Works
		Given My role is Training Manager
		And I access an Exercise Event
		When I access an Exercise Event's Traffic Tracker
		Then I should see that the connection is successful

##The other steps of this test have been completed in the traffic tracker bucket
