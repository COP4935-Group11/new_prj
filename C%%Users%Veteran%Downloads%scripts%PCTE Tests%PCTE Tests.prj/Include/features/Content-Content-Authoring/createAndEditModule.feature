@PCTE-10725
@CD-6
@Content-Content-Authoring
@Severity-1

Feature: Create and Edit a Content Module
  As a Content Author, I want to be able to create and edit a content module so I can add and manage training content.

  Scenario: Create a new Content Module
    Given My role is content author
    When I create a new content module
    And I provide the Name, Description, Duration, and Tasks
    Then I should see the content module in the content library
    
  Scenario: Edit Content Module
    Given My role is content author
    When I update a content module with new Tasks
    Then I should see the new Tasks in the content module
 	

 	
 	