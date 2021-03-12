@CD-20
@PCTE-10776
@Content-Traffic-Tracker
@Severity-1

Feature: Traffic Tracker Protocols
	As a Content Author, I want to access Protocols in Traffic Tracker so that I can manage the protocols used in an event.
  
#Assumes
#EP-CP Message Bus Functional
#Traffic Tracker VM deployed
#Interop VM deployed
#Portal Event created
#Portal range deployed  
 
	Scenario: Toggle Protocol visibility
		Given My role is Content Author 
		When I toggle a Protocol's visibilty off in Protocols
		Then I should not see the Protocol on the map

	Scenario: Create a Protocol
		Given My role is Content Author 
		When I create a Protocol style
		And I provide a new name for the Protocol
		Then I should see the new Protocol in Protocols
				
	Scenario: Delete a Protocol
		Given My role is Content Author 
		When I delete a Protocol
		Then I should not see the Protocol in Protocols
				