@CD-x
@PCTE-12052
@Portal-Event
@Severity-x

Feature: Verifying GT [3-6] content 
  As a PCTE admin, I want to be able to see that the GT [3-6] content exists and is shareable 

  Scenario: Checking that the GT [3-6] content exists and is sharable
    Given My role is admin
    And I am at the PCTE Content Catalog
    When I check in Training Packages
    Then I should see the GT 3-6 content
    And I should be able to share the content