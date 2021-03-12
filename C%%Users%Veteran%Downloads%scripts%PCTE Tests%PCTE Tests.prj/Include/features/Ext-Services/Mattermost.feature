@CD-27
@PCTE-5530
@External-Services
@Severity-1

Feature: Mattermost Chat
	As a PCTE Member, I want to be able to communicate with my team, so that we can participate in an event together. 
​
	Scenario: Verify Login to Mattermost via Keycloak 
		Given My role is Member 
		And I am on the mattermost login page
		When I login with keycloak
		Then I should see my chat dashboard
		
	Scenario: Confirm messages can be sent through direct message
		Given My role is Member
		And A chat exists with another user
		When I send a message to the other user
		Then the other user should receive the message
		
	Scenario: Confirm files can be sent through direct message
		Given My role is Member
		And A chat exists with another user
		When I send a file to the other user
		Then the other user should receive the file

	Scenario: Adding members to a public channel
		 Given My role is Member
		 And I am in the mattermost chat menu
		 And other members are part of my team
		 And A public channel has been created
		 When I add members from my team to the channel
		 Then I should be able to communicate with them on the channel 
		 
	Scenario: Adding members to a private channel
		Given My role is Member
		And I am in the mattermost chat menu
		And other members are part of my team
		And A private channel has been created
		When I invite users using the invite others to private channel link 
		Then I should be able to communicate with them on the channel	   
