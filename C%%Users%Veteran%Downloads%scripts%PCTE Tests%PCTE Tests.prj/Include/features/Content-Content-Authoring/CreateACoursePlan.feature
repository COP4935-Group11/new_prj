@CD-3
@PCTE-10727
@Content-Content-Authoring
@Severity-1

Feature: Create a Course Plan
As a content author I want to make a course that include multiple training packages so that users can be trained for a specified skillset

	Scenario: Users will be able to create course plans
		Given My role is content author
		When I create a new Course Plan with a Training Package
		Then I should see the updated Course Plan in the content library