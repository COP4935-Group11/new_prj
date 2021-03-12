@CD-20
@PCTE-10776
@Content-Traffic-Tracker
@Severity-1

Feature: Traffic Tracker Overview
	As a Content Author, I want to access Overview in Traffic Tracker so that I can manage the availability of the different menus and profiles.
  
#Assumes
#EP-CP Message Bus Functional
#Traffic Tracker VM deployed
#Interop VM deployed
#Portal Event created
#Portal range deployed  
 
	Scenario: Access Traffic Tracker Overview
		Given My role is Content Author 
		When I access Traffic Tracker Overview
		Then I should see all the Overview options are present

	Scenario: Menu collapse
		Given My role is Content Author 
		When I toggle the Traffic Tracker Tile
		Then I should see the menu has collapsed

	Scenario: Menu expansion
		Given My role is Content Author 
		When I toggle the Traffic Tracker Tile
		Then I should see the menu has expanded		
		
	Scenario: View Default Profiles
		Given My role is Content Author 
		When I access the Profile Overview in Traffic Tracker
		Then I should see the default Profiles available		

	Scenario: Make Profiles Hidden
		Given My role is Content Author 
		When I set Profiles to be hidden
		Then I should not be able to access Protocols, Geo-IP, and Filters

	Scenario: Make Profiles Visible
		Given My role is Content Author 
		When I set Profile to visible
		Then I should be able to access Protocols, Geo-IP, and Filters				