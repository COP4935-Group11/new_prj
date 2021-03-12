@CD-9
@PCTE-10779
@Content-Content-Authoring
@Severity-1

Feature: Create a Survey
	As a content author I want to create surveys so that users can provide specific feedback on the content the users participated in
	
	Scenario: Create a survey
		Given My role is content author
		When I create a Survey module
		And I provide the Name, Description, and Survey Questions
		Then I should see the Survey in the Content Library

