@CD-20
@PCTE-10776
@Content-Traffic-Tracker
@Severity-1

Feature: Traffic Tracker Geo-IP
	As a Content Author, I want to access GEO-IP in Traffic Tracker so that I can manage GEO-IP records and tracks used in an event.
  
#Assumes
#EP-CP Message Bus Functional
#Traffic Tracker VM deployed
#Interop VM deployed
#Portal Event created
#Portal range deployed  
 
	Scenario: Add a new record
		Given My role is Content Author 
		When I add an IP record in Geo-IP
		And I provide values for the IP address, lattitude, and longitude
		Then I should see the new record in Geo-IP
	
	Scenario: Generate Tracks
		Given My role is Content Author 
		When I Generate Tracks in the Geo-IP
		Then I should see the new tracks in Geo-IP
		
	Scenario: Delete a record
		Given My role is Content Author 
		When I delete a record in the Geo-IP
		Then I should not see the record in Geo-IP
				
		