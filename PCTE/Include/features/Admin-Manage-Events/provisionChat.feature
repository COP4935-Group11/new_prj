@CD-34
@PCTE-9533
@Admin-Manage-Events
@Severity-1

Feature: Provision Chat
	As an Admin, I want to access Provision Chat so that I can create Chat channels 

	Scenario: Access Provision Chat
		Given My role is Admin
		When I access Provision Chat for the Event
		Then I should see the Chat Provisioning succeeded
  
	Scenario: View a private channel
		Given My role is Admin
		When I access the Chat dashboard
		Then I should see a private channel with all Event participants
