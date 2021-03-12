@CD-11
@PCTE-6062
@Admin-System-Admin
@Severity-1

Feature: Manage Users
	As an Admin, I want to be able to manage users so that I can provide users with the correct permissions.

	Scenario: Change a user's role to Member
		Given My role is Admin
		When I assign the Member permission to a user
		Then The user should now have Member permissions

	Scenario: Change a user's role to Admin
		Given My role is Admin
		When I assign the Admin permission to a user
		Then The user should now have Admin permissions
				