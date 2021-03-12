@CD-14
@PCTE-10765
@Admin-Manage-Events
@Severity-1

Feature: View and Edit An Exercise Event
	As an Admin, I want to be able to view and edit an Excercise Event so that I can manage Event content.

	Scenario: View an Exercise Event
		Given My role is Admin
		When I access an Event's management overview
		Then I should see the Excercise Event information

	Scenario: Edit an Excercise Event's info
		Given My role is Admin
		When I change an Excerise Event's description
		Then I should see the Excercise Event's info updated

	Scenario: Upload a document to Event
		Given My role is Admin
		When I upload a document to an Event
		Then I should see the document uploaded to the Event
 	
	Scenario: Add a scenario to Exercise Event
		Given My role is Admin
		When I add a scenario to an Exercise Event
		And I provide an inject for the scenario
		Then I should see the Excercise Event's scenarios updated
		
	Scenario: Add participants to Event
		Given My role is Admin
		When I add participants to an Event
		Then I should see the participants were added to the Event	
		
	Scenario: Change roles of participants
		Given My role is Admin
		When I change roles of the participants in an Event
		Then I should see the amount users under a role change	
  
	Scenario: Download an Excercise Event
		Given My role is Admin
		And I access the management overview of an Event
		When I download the Excercise Event
		Then The download should be successful