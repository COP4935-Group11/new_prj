@CD-12
@PCTE-17159
@Portal-Login
@Severity-1


Feature: PCTE Portal Login 
	As a PCTE member, I want to be able to log into PCTE Portal using my credentials and 2FA so I can access its contents.  

	Scenario: User Login 
		Given I am at the PCTE Portal
		When I log into the PCTE Portal
		Then I should be able to access the PCTE Portal
  
	Scenario: User Logout
		Given I am at the PCTE Portal
    And I am logged into the PCTE Portal
		When I logout of the PCTE Portal
		Then I should no longer have access to the PCTE Portal
