@PCTE-12836
@Event-Event-Outlook
@Severity-x

Feature: Editing Lab Events
	As a Training Manager, I want to be able to edit a Lab Event so that I can train users.
	
	Scenario: Edit a Lab Event
		Given My role is training manager
		When I update an existing Lab Event with a new name and description, and an additional user 
		Then The updated Lab Event should appear with the updated information
		