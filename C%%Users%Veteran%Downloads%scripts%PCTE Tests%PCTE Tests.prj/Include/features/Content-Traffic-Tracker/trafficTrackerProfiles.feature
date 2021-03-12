@CD-20
@PCTE-10776
@Content-Traffic-Tracker
@Severity-1

Feature: Traffic Tracker Profiles
	As a Content Author, I want to access Profiles in Traffic Tracker so that I can manage the profiles used in an event.
  
#Assumes
#EP-CP Message Bus Functional
#Traffic Tracker VM deployed
#Interop VM deployed
#Portal Event created
#Portal range deployed  
 
	Scenario: Load style settings
		Given My role is Content Author
		When I load a style setting in Profiles
		Then I should the new style reflect on the map

	Scenario: Edit name of Profile
		Given My role is Content Author
		When I edit the base Profile
		And I provide a new name for the Profile
		Then I should see the Profile is renamed in Profiles

	Scenario: Download a Profile
		Given My role is Content Author 
		When I download a Profile
		Then I should see the Profile was downloaded successfully   

	Scenario: Upload a Profile
		Given My role is Content Author 
		When I upload a Profile
		Then I should see the new Profile in Profiles 	
		
	Scenario: Create a Profile
		Given My role is Content Author 
		When I create a new Profile
		And I provide a name for the Profile
		Then I should see the new Profile in Profiles 	
