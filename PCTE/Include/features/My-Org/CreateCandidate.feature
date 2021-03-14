@CD-x
@PCTE-13583
@My-Org
@Severity-x

Feature: Create a candidate
  As a portal admin, I want to register a candidate within My Org

  Scenario: Creating a candidate
    Given My role is admin
    And I am at the My Organization section of the catalog
    When I register a new canidate
    And Fill out the canidate information
    Then A canidate will have been created
    And I should see the canidate information when clicked 
