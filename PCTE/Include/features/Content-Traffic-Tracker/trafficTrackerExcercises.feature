@CD-20
@PCTE-10776
@Content-Traffic-Tracker
@Severity-1

Feature: Traffic Tracker Excercises
	As a Content Author, I want to access Exercises in Traffic Tracker so that I can manage Exercise recordings.
  
#Assumes
#EP-CP Message Bus Functional
#Traffic Tracker VM deployed
#Interop VM deployed
#Portal Event created
#Portal range deployed  
 	
 	Scenario: Start Traffic Tracker
		Given My role is Content Author
		When I start an Event's Traffic Tracker
		Then I should see the Event has gone live in Traffic Tracker
 
	Scenario: Get the Excerise ID of a VM within the Event
		Given My role is Content Author 
		When I enter the console of a VM within an Event
		Then I should see a new display that contains the Excerise ID

	Scenario: View Recorded Excercise
		Given My role is Content Author 
		When I view Network Events in an Event's Traffic Tracker
		Then I should see the Excercise ID in Recent Events
