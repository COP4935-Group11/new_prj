@CD-5
@PCTE-10733
@Event-Event-Outlook
@Severity-1


Feature: Running a lab event
  As a PCTE Member, I want to be able to particpate in the event so that I can learn the subject of the event.


  Scenario: User participates in Lab Event
    Given My role is Member
    When I join the Lab Event to which I am assigned
    And I complete all the tasks
    Then My results for the Lab Event should be available to review for myself and the training manager
