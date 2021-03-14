@CD-14
@PCTE-10728
@Content-Content-Authoring
@Severity-1

Feature: Share a Content Module
	As a Content Author, I want to be able to share content modules with other users So that other users can edit and view content I have created. 

	Scenario: Selecting a specific content module to share 
		Given My role is content author
		When I select an existing content module
		Then I should see the details of the content module

	Scenario: Verifying that as a different user cannot view without permissions
		Given My role is member
		And I do not have permission to view the content module
		When I search for the existing content module
		Then The content module should not appear

	Scenario: User A gives User B permissions to the content module 
		Given My role is content author
		When I give User B permissions to the content module
		Then User B can access the content module

	Scenario: User A gives an organization and its descendants
		Given An Organization exists with test users
		And My role is content author
		When I give the organization and descendants permissions
		Then Users in that organization can access the content module