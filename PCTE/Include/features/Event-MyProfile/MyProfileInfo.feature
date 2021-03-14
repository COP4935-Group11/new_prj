@CD-#
@PCTE-10736
@Event-Event-MyProfile
@Severity-1


Feature: Verify My Profile Shows Info About Different Events
  As a PCTE Member, I want to be able to view my profile so that I can view events that correlate

  # this test could be tested across any role

  Scenario: Check My Profile as Member
    Given My role is Member
    When I access my profile
    Then I should be able to view all the events that I am associated with

