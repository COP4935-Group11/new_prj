@CD-19
@PCTE-6136
@Content-Network-Plans
@Severity-1

Feature: Create clone source and deploy
	As a content author I want to create a clone source from an existing range so that after initial configurations are made I can reuse that as a template for other events. 


	Scenario: I want to create a clone source and deploy the range
		Given My role is content author
		And An existing range has already been deployed
		When I clone the existing range
		And Deploy the clone source into an event
		Then The event should be able to access the network's VMs
		
		
