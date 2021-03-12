@CD-20
@PCTE-10776
@Content-Traffic-Tracker
@Severity-1

Feature: Traffic Tracker Settings
	As a Content Author, I want to access Settings in Traffic Tracker so that I can manage Traffic Tracks used in an event.
  
#Assumes
#EP-CP Message Bus Functional
#Traffic Tracker VM deployed
#Interop VM deployed
#Portal Event created
#Portal range deployed  
 
	Scenario: Access Settings Overview
		Given My role is Content Author
		When I enter the Settings Overview in an Event's Traffic Tracker
		Then I should see all Setting Overview options are present

	Scenario: Enable Pause Tracks
		Given My role is Content Author  
		When I toggle Pause Tracks on
		Then I should see no network activity

	Scenario: Disable Pause Tracks
		Given My role is Content Author  
		When I toggle Pause Tracks off
		Then I should see network activity

	Scenario: Use Rewind Tracks
		Given My role is Content Author  
		When I Rewind Tracks
		Then I should see previous network activity

	Scenario: Enable Globe View
		Given My role is Content Author  
		When I toggle Globe View on
		Then I should see Traffic Tracker as a Globe

	Scenario: Enable Show Locals
		Given My role is Content Author 
		When I toggle the Show Locals option
		Then I should see the local Traffic
				