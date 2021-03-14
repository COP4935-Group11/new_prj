@CD-x
@PCTE-11323
@Portal-Login
@Severity-x


Feature: Dashboard Search
	As a PCTE content author, I want to be able to search for content from the Portal Dashboard.
	
	Scenario: Browse Content Modules
	  Given My role is content author
	  When I browse for content modules in the Portal Dashboard
	  Then I should see the main content module area
	  
	Scenario: Search for Content Module
		Given My role is content author
		When I search for a known content module in the Portal Dashboard
		Then I should find that content module in the return list

	Scenario: Search for Content Module and View It
		Given My role is content author
		When I search for a known content module details in the Portal Dashboard
		Then I should find that content module details
		