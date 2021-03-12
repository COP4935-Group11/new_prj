@CD-11
@PCTE-13340
@Admin-System-Admin
@Severity-1

Feature: Manage Roles
	As a SSO Admin, I want to be able to manage roles so that I can assign users to the correct roles.

	Scenario: Create roles in IDM
		Given My role is SSO Admin
		When I create a role
		And I provide a Name, and Role Attribuets
		Then I should see the new role is created in IDM
	
	Scenario: Make a member user a Training Manager
		Given My role is SSO Admin
		When I assign the Training Manager role to a member user in IDM
		Then The user should have Training Manager permissions

	Scenario: Make a member user a Content Author
		Given My role is SSO Admin
		When I assign the Content Author role to a member user in IDM
		Then The user should have Content Author permissions
