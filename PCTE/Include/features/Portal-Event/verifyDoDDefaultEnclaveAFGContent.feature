@CD-x
@PCTE-12047
@Portal-Event
@Severity-x

Feature: Verify DoD Default Enclave Content 
  As a PCTE member, I want to be able to see that the DOD Enclave content exists

  Scenario Outline: Finding DoD Default Enclave VM Templates
    Given My role is Member
    And I am at the PCTE Content Catalog
    When  I check the VM Templates
    Then  I should see the DOD Enclave VM Template <name>

    Examples: 
      |name                      |
      |AFG-ACAS-0101_01          |
      |AFG-DC-41-0101_01         |
      |AFG-HBSS-591-0101_01      |
      |AFG-MSSQL-0101_01         |
      |AFG-Palo-Alto-0101_01     |
      |AFG-SDC-571-Puppet-0101_01|
      |AFG-DSDC-571-0101_01      |
      |AFG-Sharepoint-0101_01    |
      |AFG-WAF-0101_01           |
 