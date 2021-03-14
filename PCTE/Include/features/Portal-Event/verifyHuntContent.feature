@CD-x
@PCTE-12048
@Portal-Event
@Severity-x

Feature: Verify Hunt content 
  As a PCTE member, I want to be able to see that the Hunt content exists

  Scenario Outline: Finding Hunt VM Templates
    Given My role is Member
    And I am at the PCTE Content Catalog
    When  I check the VM Templates
    Then  I should see the Hunt VM Template <name>

    Examples: 
      |name                      |
      |Hunt-Auto-Opfor-00-0101_01|
      |Hunt-Control-DHCP-0101_01|
      |Hunt-CPTT-ELK-Kit-0101_01|
      |Hunt-CS-Kali-0101_01|
      |Hunt-Dev-CLI-0101_01|
      |Hunt-Dev-SRV-0101_01|
      |Hunt-DMZ-Web-0101_01|
      |Hunt-Edge-Router-0101_01|
      |Hunt-Enterprise-File-0101_01|
      |Hunt-00-0101_01|
      |Hunt-01-0101_01|
      |Hunt-02-0101_01|
      |Hunt-03-0101_01|
      |Hunt-04-0101_01|
      |Hunt-05-0101_01|
      |Hunt-06-0101_01|
      |Hunt-07-0101_01|
      |Hunt-08-0101_01|
      |Hunt-09-0101_01|
      |Hunt-10-0101_01|
      |Hunt-11-0101_01|
      |Hunt-12-0101_01|
      |Hunt-13-0101_01|
      |Hunt-14-0101_01|
      |Hunt-15-0101_01|
      |Hunt-16-0101_01|
      |Hunt-17-0101_01|
      |Hunt-18-0101_01|
      |Hunt-19-0101_01|
      |Hunt-20-0101_01|
      |Hunt-21-0101_01|
      |Hunt-22-0101_01|
      |Hunt-23-0101_01|
      |Hunt-24-0101_01|
      |Hunt-Internet-00-0101_01|
      |Hunt-Internet-01-0101_01|
      |Hunt-Internet-02-0101_01|
      |Hunt-Internet-03-0101_01|
      |Hunt-Internet-04-0101_01|
      |Hunt-Internet-05-0101_01|
      |Hunt-Internet-06-0101_01|
      |Hunt-Internet-07-0101_01|
      |Hunt-Internet-08-0101_01|
      |Hunt-Internet-09-0101_01|
      |Hunt-Internet-DC-0101_01|
      |Hunt-Internet-Mail-0101_01|
      |Hunt-Internet-Router-0101_01|
      |Hunt-IS-1-0101_01|
      |Hunt-IS-2-0101_01|
      |Hunt-IS-3-0101_01|
      |Hunt-IS-4-0101_01|
      |Hunt-Kali-01-0101_01|
      |Hunt-Kali-02-0101_01|
      |Hunt-Kali-03-0101_01|
      |Hunt-Kali-04-0101_01|
      |Hunt-Kali-Bleed-0101_01|
      |Hunt-Kali-Hunt-00-0101_01|
      |Hunt-Kali-Hunt-01-0101_01|
      |Hunt-Kali-Hunt-02-0101_01|
      |Hunt-Kali-Hunt-03-0101_01|
      |Hunt-Kali-PNY-0101_01|
      |Hunt-Lariat94-0101_01|
      |Hunt-Nagios-0101_01|
      |Hunt-Range-Transfer-0101_01|
      |Hunt-Red-Windows2008-1-0101_01|
      |Hunt-Red-Windows2008-2-0101_01|
      |Hunt-Red-Windows2008-3-0101_01|
      |Hunt-Red-Windows2008-4-0101_01|
      |Hunt-Sandbox-Windows7-0101_01|
      |Hunt-Simspace-Management-0101_01|
      |Hunt-Site-Carbon-Black-0101_01|
      |Hunt-Site-DC-0101_01|
      |Hunt-Site-DNS-0101_01|
      |Hunt-Site-EPO-0101_01|
      |Hunt-Site-File-0101_01|
      |Hunt-Site-Forensics-0101_01|
      |Hunt-Site-FW-0101_01|
      |Hunt-Site-GRR-0101_01|
      |Hunt-Site-Intranet-0101_01|
      |Hunt-Site-Mail-0101_01|
      |Hunt-Site-NUIX-0101_01|
      |Hunt-Site-Reverse-Proxy-0101_01|
      |Hunt-Site-Rock-0101_01|
      |Hunt-Site-Router-0101_01|
      |Hunt-Site-Sharepoint-0101_01|
      |Hunt-Site-SMPT-0101_01|
      |Hunt-Site-SQL-0101_01|
      |Hunt-Site-Syslog-0101_01|
      |Hunt-Site-WWW-0101_01|
      |Hunt-Team Server-1-0101_01|
      |Hunt-Team Server-2-0101_01|
      |Hunt-Team Server-3-0101_01|
      |Hunt-Team Server-4-0101_01|
      |Hunt-Team Server-5-0101_01|
      |Hunt-Team Server-6-0101_01|
      |Hunt-Web-Proxy-0101_01|
      |Hunt-Workstation-01-0101_01|
      |Hunt-Workstation-02-0101_01|
      |Hunt-Workstation-03-0101_01|
      |Hunt-Workstation-04-0101_01|
      |Hunt-Workstation-CDR-0101_01|
      |Hunt-Workstation-DCO-0101_01|
      |Hunt-Workstation-65-0101_01|
      |Hunt-Workstation-66-0101_01|
      |Hunt-Workstation-67-0101_01|
      |Hunt-Workstation-68-0101_01|
      |Hunt-Workstation-69-0101_01|
      |Hunt-Workstation-70-0101_01|
      |Hunt-Workstation-71-0101_01|
      |Hunt-Workstation-72-0101_01|
      |Hunt-Workstation-73-0101_01|
      |Hunt-Workstation-74-0101_01|
      |Hunt-Workstation-75-0101_01|
      |Hunt-Workstation-76-0101_01|
      |Hunt-Workstation-77-0101_01|
      |Hunt-Workstation-78-0101_01|
      |Hunt-Workstation-79-0101_01|
      |Hunt-Workstation-80-0101_01|
      |Hunt-Workstation-81-0101_01|
      |Hunt-Workstation-82-0101_01|
      
      
      
      
      
      
      
      
      
      
      