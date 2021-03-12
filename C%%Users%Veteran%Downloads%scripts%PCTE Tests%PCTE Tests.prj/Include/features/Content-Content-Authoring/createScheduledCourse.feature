@CD-3
@PCTE-10762
@Content-Content-Authoring
@Severity-1

Feature: Create a Scheduled Course
	As a Content Author, I want to create a Scheduled Course so that an Course Plan can be accessed by users. 
	
	Scenario: Schedule an Course Plan
	 	Given My role is content author
		When I Schedule a Course for a Course Plan
		And I provide a Name, Description, a manager, and a participant
		And I set the event's date
		Then I should see a Scheduled event on the Events Plane
