@CD-2
@PCTE-10780
@Events-Courses
@Severity-1


Feature: Schedule events within a course outline
	As a Training Manager, I want to schedule events directly from a course so that I can create events that correspond to the training topic defined by the course.
	
	Scenario: Schedule events within a course outline
		Given My role is Training Manager
		And There is an existing course
		When I schedule the event for each training package
		Then I should see the scheduled events in Upcoming Events
		
