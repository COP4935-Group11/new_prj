@CD-9
@PCTE-10715
@Content-Deployments
@Severity-1

Feature: Ranges
	As a PCTE member, I want to filter ranges so that I can sort and find specific ranges from the entire list
 
	Scenario: Verify sort and filter for ranges populates correctly
		Given My role is member
		When I filter the ranges
		And I sort the ranges from Z-A
		Then I should see the ranges sorted and filtered correctly

	Scenario: Verify sort and filter for ranges populates correctly in card mode
		Given My role is member in card mode
		When I filter the ranges in card mode
		And I sort the ranges from Z-A in card mode
		Then I should see the ranges sorted and filtered in card mode
  
	Scenario: Verify search ranges populates correctly
		Given My role is member 
		When I search the ranges
		Then I should see the desired range displayed

	Scenario: Verify search ranges populates correctly in card mode
		Given My role is member 
		When I search the ranges in card mode
		Then I should see the desired range displayed in card mode
  
	Scenario: Verify active range consoles are accessible
		Given My role is member 
		When I enter an active console
		Then I should see a connection with the console in the range log  
