@CD-x
@PCTE-11323
@Portal-Login
@Severity-x


Feature: Dashboard Create
	As a PCTE content author, I want to be able to access all the create tools from the Portal Dashboard.
	
	Scenario: Check Lab Event
		Given My role is training manager
		When I select Create Lab Event in Portal Dashboard
		Then I should get to the Lab Event area

	Scenario: Check Exercise Event
		Given My role is training manager
		When I select Create Exercise Event in Portal Dashboard
		Then I should get to the Exercise Event area

	Scenario: Check Network Spec
		Given My role is content author
		When I select Create Network Spec in Portal Dashboard
		Then I should get to the Network Spec area

	Scenario: Check VM Template
		Given My role is content author
		When I select Create VM Template in Portal Dashboard
		Then I should get to the VM Template area
		
	Scenario: Check Physical Asset
		Given My role is content author
		When I select Create Physical Asset in Portal Dashboard
		Then I should get to the Physical Asset area		

	Scenario: Check Config Module
		Given My role is content author
		When I select Create Config Module in Portal Dashboard
		Then I should get to the Config Module area		

	Scenario: Check External Subnet
		Given My role is content author
		When I select Create External Subnet in Portal Dashboard
		Then I should get to the External Subnet area		
		
	Scenario: Check Course Plan
		Given My role is content author
		When I select Create Course Plan in Portal Dashboard
		Then I should get to the Course Plan area		

	Scenario: Check Training Package
		Given My role is content author
		When I select Create Training Package in Portal Dashboard
		Then I should get to the Training Package area		

	Scenario: Check Content Module
		Given My role is content author
		When I select Create Content Module in Portal Dashboard
		Then I should get to the Content Module area		
	