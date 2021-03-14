@CD-17
@PCTE-10716
@Content-Network-Elements
@Severity-1

Feature: Create VM Templates
	As a content author, I want to create VM Templates so that I can use/filter them
 
	Scenario: Create a new VM Template from main page
		Given My role is content author
		When I create a new VM Template 
		And I provide the Name, Description, and Duration
		Then I should see the VM Template in the VM Templates Library

	Scenario: Create a new VM Template from sidebar
		Given My role is content author 
		When I create a new VM Template from the sidebar
		And I provide the Name, Description, and Duration
		Then I should see the VM Template in the VM Templates Library
	
	Scenario: Upload VM to VM Template Deployment Target
		Given My role is portal admin 
		When I upload a VM to the Deployment Target Mapping
		Then I should see the VM within the Template

	Scenario: Upload a VM Template through VM Template Uploads
		Given My role is portal admin and I am within VM Template Uploads 
		When I upload a VM Template
		And I aprove the VM Template upload
		Then I should see the VM Template deployment in the Background Activity Monitor

	Scenario: Verify sort and filter for VM Templates populates correctly
		Given My role is member 
		When I filter the VM Templates
		And I sort the VM Templates from Z-A
		Then I should see the VM Templates sorted and filtered
	
	Scenario: Verify sort and filter for VM Templates populates correctly in card mode
		Given My role is member 
		When I filter the VM Templates
		And I sort the VM Templates from Z-A in card mode
		Then I should see the VM Templates sorted and filtered in card mode
	 
	Scenario: Verify search VM Templates populates correctly
		Given My role is member 
		When I search the VM Templates
		Then I should see the desired VM Template displayed

	Scenario: Verify search VM Templates populates correctly in card mode
		Given My role is member 
		When I search the VM Templates in card mode
		Then I should see the desired VM Template displayed in card mode
	
	Scenario: Verify VM Templates overview displays correctly
		Given My role is member 
		When I access a VM Template 
		Then I should see the VM Templates overview
		  
