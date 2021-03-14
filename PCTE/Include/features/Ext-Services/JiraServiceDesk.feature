@CD-25
@PCTE-6124	
@External-Services
@Severity-1

Feature: Jira Service Desk
	As a PCTE Member, I want to be to create a jira support request when issues are encountered, so that they can be documented
  
	Scenario: Creating Tickets for any of the designated fields
		Given My role is Member 
		And I open jira service desk from the menu
		When I create a ticket for all the fields 
		Then I can view that the tickets were added

	 Scenario: Browsing through existing tickets
		Given My role is Member 
		And I open jira service desk from the menu
		When I browse through tickets
		Then I should see other tickets in all fields
#including the one previously made in the scenario prior. 
