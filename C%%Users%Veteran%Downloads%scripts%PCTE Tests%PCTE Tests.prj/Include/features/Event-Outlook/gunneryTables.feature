@CD-7
@PCTE-9360
@Events-Event-Outlook
@Severity-1

Feature: Gunnery Tables
	As a Portal Admin, I want to setup Gunnery Tables so that participants can access the event.

	Scenario: Create group for Gunnery Table exercises
		Given My role is Portal Admin
		And I access an Org Structure
		When I add a user to a group
		And I save the changes
		Then I should see the user was added to a group
		
	Scenario: Create a Lab Event for Gunnery Table
		Given My role is Portal Admin
		When I create a new Lab Event from the Gunnery Table package
		And I provide a Name, a Team Manager, a Participant, and a Schedule for the Event
		Then I should see the Teams tab in Gunnery Table
		
	Scenario: Set the correct answers and check a work role
		Given My role is Member
		And I am added as a Team Manager for a Gunnery Table	
		And I set the correct answers for a Gunnery Table		
		When I acess the Teams Overview 
		Then I should see a team members with no work role assigned
		
	Scenario: Change work roles
		Given My role is Member
		And I am added as a Team Manager for a Gunnery Table	
		And I acess the Teams Overview
		When I change a users work role
		Then I should see the user passsed the requirement for the role

	Scenario: Verify Role Requirements
		Given My role is Member
		And I am added as a Team Manager for a Gunnery Table	
		When I access the Role Requirements Tab
		Then I should see the Role Requirements initialized correctly	
		
	Scenario: Verify Ranges deploy
		Given My role is Member
		And I am added as a Team Manager for a Gunnery Table	
		When I deploy a Range in the Gunnery Table
		Then I should see the Range deployed successfully
		
	Scenario: Verify User Scores update
		Given My role is Member
		And I am added as a Team Manager for a Gunnery Table	
		When I change a user's score in the event
		Then I should see the user's score updated

	Scenario: Verify participant can access Gunnery Table attachments
		Given My role is Member
		And I am added as a Participant for a Gunnery Table	
		And I am access the Gunnery Table
		When I select and attachment
		Then I should see the attachment load


	Scenario: Verify participant can access Gunnery Table VMs
		Given My role is Member
		And I am added as a Participant for a Gunnery Table	
		And I am access the Gunnery Table
		When I select a VM in the Gunner Table
		Then I should be able to access the VM 

	Scenario: Verify participant can answer questions
		Given My role is Member
		And I am added as a Participant for a Gunnery Table	
		When I access the Gunnery Table's questions
		And I enter the correct answers
		Then I should see that all my answers were correct

	Scenario: End Event
		Given My role is Member
		And I am added as a Team Manager for a Gunnery Table	
		When I end the Gunnery Table
		Then I should see the event is completed
		And I should see the information is correct
				
		
		
