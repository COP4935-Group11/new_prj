@CD-x
@PCTE-12049
@Portal-Event
@Severity-x

Feature: Verifying Kibana (ESB) content 
  As a PCTE admin, I want to be able to see that the Kibana content exists and is shareable 

  Scenario: Checking that the Kibana content exists and is sharable
    Given My role is admin
    And I am at the PCTE Content Catalog
    When I check in Training Packages
    Then I should see the ESB content
    And I should be able to share the content