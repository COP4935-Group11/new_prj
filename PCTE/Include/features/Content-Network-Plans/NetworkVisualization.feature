@CD-
@PCTE-6073
@Content-Network-Plans
@Severity-1

Feature: Make Sure Network Visualization Loads
 	As a content author, I want to view a network's visualization so that I can visually track changes on the network map

	Scenario: I want to make sure that my network visualization loads
		Given My role is content author
		And I am on the coverpage for a network spec
		When I view network visualization
		Then A diagram containing a network map should appear
		
