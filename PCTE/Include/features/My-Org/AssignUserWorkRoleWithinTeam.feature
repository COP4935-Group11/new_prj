@CD-x
@PCTE-12403
@My-Org
@Severity-x

Feature: Assign User to Work Role within a Team
  As a Portal Admin, I want to be able to manage a team within my org

  
  Scenario: Assign User to Work Role
    Given My role is admin
    And I am at the My Organization section of the catalog
    When I check for the <value> in step
    Then I verify the <status> in step