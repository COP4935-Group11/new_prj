@CD-3
@PCTE-10738
@Events-Courses
@Severity-1


Feature: Ensure Course Info is Correct
	As a Content Author, I  want the course information to be correct so that users can have an accurate view of the course.
	
	Scenario: Ensure course info is correct
	Given My role is Content Author
	And There is an existing course
	When I verify the training packages descriptions are correct
	And I verify the course plan description is correct
	Then The course plan is accurate
