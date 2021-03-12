@CD-8
@PCTE-10734
@Event-Event-Outlook
@Severity-1


Feature: Verify Survey Results
  As a PCTE Member, I want to provide feedback in a survey.
  
  Scenario: Complete Survey and Verify Results
    Given My role is Training Manager
    When Users complete the survey of an ended event
    Then I can view the feedback of the closed event
    