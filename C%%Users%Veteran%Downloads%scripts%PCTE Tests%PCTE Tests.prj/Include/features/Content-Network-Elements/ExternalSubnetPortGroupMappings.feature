@CD-20
@PCTE-11590
@Content-Network-Elements
@Severity-1

Feature: External Subnet Port Group Mappings
	As a portal Admin, I want to access external subnets so that I can verify they are corectly configured 

  Scenario: Verify Port Group Mappings
    Given My role is a portal admin
    And I note the name of the vwire used in Content Range Control
    And I note the name of the vwire used in Admin External Network
    When I compare the names of both vwires
    Then I should see they are mapped to the same vwire
    
