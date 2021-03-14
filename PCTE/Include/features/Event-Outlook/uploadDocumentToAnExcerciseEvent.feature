@CD-14
@PCTE-6127
@Events-Event-Outlook
@Severity-1

Feature: Upload Documents To An Excercise Event
	As a Training Manager, I want to upload documents to an Exercise Event so that users can access the documents for training.

	Scenario: Upload Documents To An Excercise Event
		Given My role is Training Manager
		And I access an Excercise Event
		When I upload documents to an Excercise Event 
		Then I should see the documents uploaded an Excercise Event
		
	Scenario: Verify authorized participants can view documents uploaded to an Excercise Event
		Given My role is Member 
		And I have had an Excercise Event shared with me
		When I access the shared Excercise Event
		Then I should see the documents uploaded to the Excercise Event
