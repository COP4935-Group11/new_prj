@CD-#
@PCTE-10729
@Event-Event-Outlook
@Severity-1


Feature: Task Chain Randomized 
	As a PCTE Member, I want to participate in an event with randomized task chains so that my experience is unique.


  Scenario: Verify task chains are randomized
    Given My role is Member
    And I am a participant of lab event
    And the training package used allows for randomized questions
    When I enter the event
    Then The task chains should appear in a random order

