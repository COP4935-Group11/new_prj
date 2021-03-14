@CD-6
@PCTE-10726
@Content-Content-Authoring
@Severity-1

Feature: Create a Training Package
	As a Content Author, I want to be able to create a Training Package so that users can access them.

	Scenario: Create a Training Package
		Given My role is content author
		When I create a Training Package
		And I provide the Name, Description, Objectives, and a Content Module
		Then I should see the new Training Package in the Content Library