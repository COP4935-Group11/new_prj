@CD-20
@PCTE-10776
@Content-Traffic-Tracker
@Severity-1

Feature: Traffic Tracker Filters
	As a Content Author, I want to access Filters in Traffic Tracker so that I can manage filters used during an event.
  
#Assumes
#EP-CP Message Bus Functional
#Traffic Tracker VM deployed
#Interop VM deployed
#Portal Event created
#Portal range deployed  

	Scenario: Create a Filter
		Given My role is Content Author
		When I create a Filter
		And I provide an address and traffic type
		Then I should see the new Filter in Filters
		
	Scenario: Edit existing Filter
		Given My role is Content Author
		When I edit a Filter
		Then I should see the Filter's address was updated
		
	Scenario: Delete a Filter
		Given My role is Content Author
		When I delete a Filter
		Then I should not see the Filter anymore
