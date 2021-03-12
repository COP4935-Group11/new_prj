@CD-2
@PCTE-10731
@Event-Event-Outlook
@Severity-1

Feature: Scheduling new Lab Events
	As a Training Manager, I want to be able to create a Lab Event so that I can train users.
	
	Scenario: Create a Lab Event
		Given My role is training manager
		When I create a Lab Event 
		And I provide the Name, Description, Participants, a Training Package, and a Survey Module
		Then The new Lab Event should appear in the Event Outlook
