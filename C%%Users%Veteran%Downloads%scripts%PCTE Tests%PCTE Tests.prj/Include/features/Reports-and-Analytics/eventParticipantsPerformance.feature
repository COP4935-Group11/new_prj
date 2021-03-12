@CD-6
@PCTE-6179
@Report-And-Analytics
@Severity-1

Feature: Event participants Performance
	As a training manager, I want to access a previous event so that I can view the participants' performance

#Assumes 
#There was a scheduled an event 
#Participants answered questions
#The event has ended and is closed.   

	Scenario: Verify the Performance Overview populates correctly
		Given My role is training manager
		When I access the Reports and Analytics
		Then I should see Events Performance Overview
  
	Scenario: View Performance based on participants
		Given My role is training manager 
		When I access the Performance Tab
		Then I should see a list of participants with their performances 

	Scenario: View individual user performance
		Given My role is training manager 
		When I select an individual user
		Then I should see the individual's performance details
		
	Scenario: View Event results
		Given My role is training manager 
		When I select an Event
		Then I should see the Event's Performance with particpant scores	