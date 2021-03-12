@CD-5
@PCTE-10735
@Event-Completed-Events
@Severity-1

Feature: Verify Event Scoring
	As a PCTE Member, I want to be able to view my Event scores so that I can keep track of my completed Events.

	Scenario: Access My Profile
		Given My role is Member
		When I access My Profile
		Then I should see my Event scores in the Event activity information
