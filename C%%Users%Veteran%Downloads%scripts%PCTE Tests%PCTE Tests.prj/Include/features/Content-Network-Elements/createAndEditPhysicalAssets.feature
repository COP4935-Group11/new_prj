@CD-2
@PCTE-8248
@Content-Network-Elements
@Severity-1

Feature: Create and Edit Physical Assets
	As a Content Author, I want to be able to create and edit a Physical Asset so that they can be training managers can see what assests they have available for use outside the platform
	
	Scenario: Create a new Physical Asset
		Given My role is content author
		When I create a new Physical Asset Test Module
		And I provide the Name, Description, and Duration
		Then I should see the Physical Asset Test Module in the Physical Assets Library

	Scenario: Verify sort and filter for Physical Assets populates correctly
		Given My role is member
		When I filter the Physical Assets
		And I sort the Physical Assets from Z-A
		Then I should see the Physical Assets sorted and filtered
	
	Scenario: Verify sort and filter for Physical Assets populates correctly in card mode
		Given My role is member
		When I filter the Physical Assets
		And I sort the Physical Assets from Z-A in card mode
		Then I should see the Physical Assets sorted and filtered in card mode
	 
	Scenario: Verify search Physical Assets populates correctly
		Given My role is member
		When I search the Physical Assets
		Then I should see the desired Physical Asset displayed

	Scenario: Verify search Physical Assets populates correctly in card mode
		Given My role is member
		When I search the Physical Assets in card mode
		Then I should see the desired Physical Asset displayed in card mode
	
	Scenario: Verify Physical Assets overview displays correctly
		Given My role is member
		When I access a Physical Asset 
		Then I should see the Physical Assets overview
		  
	
