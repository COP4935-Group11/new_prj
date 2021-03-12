@CD-x
@PCTE-12050
@Portal-Event
@Severity-x

Feature: Verify Business Medium content 
  As a PCTE member, I want to be able to see that the Business Medium content exists

  Scenario Outline: Finding Business Medium VM Templates
    Given My role is Member
    And I am at the PCTE Content Catalog
    When  I check the VM Templates
    Then  I should see the Business Medium VM Template <name>

    Examples: 
      |name                              |
      |Bus-Med-Site-DC-0101_01           |
      |Bus-Med-Site-FW-0101_01           |
      |Bus-Med-Site-Mail-0101_01         |
      |Bus-Med-Site-Reverse-Proxy-0101_01|
      |Bus-Med-Site-SMTP-0101_01         |
      |Bus-Med-Web-Proxy-0101_01         |