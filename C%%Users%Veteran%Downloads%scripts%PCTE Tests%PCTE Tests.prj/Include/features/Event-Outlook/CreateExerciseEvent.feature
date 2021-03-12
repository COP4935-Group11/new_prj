@CD-3
@PCTE-10766
@Event-Event-Outlook
@Severity-1

Feature: Create an Exercise Event
  As a Training Manager, I want to be able to create an exercise event so that participants can be involved in an exercise that requires ranges and objectives for training.

  Scenario: Creating an exercise event method one
    Given My role is Training Manager
    When I create an exercise event with method one
    Then The created event should appear in the event outlook page

  Scenario: Creating an exercise event method two
    Given My role is Training Manager
    When I create an exercise event with method two
    Then The created event should appear in the event outlook page
