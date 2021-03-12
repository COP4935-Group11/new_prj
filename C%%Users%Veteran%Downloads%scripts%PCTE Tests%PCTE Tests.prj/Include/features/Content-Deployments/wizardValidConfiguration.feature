@CD-1
@PCTE-11589
@Content-Deployments
@Severity-1

Feature: Wizard Valid Configuration
	As a portal admin, I want to check that the wizard configurations so that I can verify their status is valid
  
	Scenario: Check Wizard Configuration Validity
		Given My role is portal admin
		When I access Wizard Configurations 
		Then I should see the Specifation Status is valid
  
