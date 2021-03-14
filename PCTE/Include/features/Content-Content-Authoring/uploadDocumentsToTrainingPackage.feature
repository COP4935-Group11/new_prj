@CD-35
@PCTE-10787
@Content-Content-Authoring
@Severity-1

Feature: Upload Documents to a Training Package
	As a Content Author, I want to upload documents to a Training Package so that users can view them.

	Scenario: Login as a content author and upload documents to existing Training Package
		Given My role is content author 
		When I upload the documents to the Training Package
		Then I should see the documents uploaded to the package

	Scenario: Login as authorized participants and verify you can view documents uploaded
		Given My role is member 
		And I am a participant of an event
		When I access the event's Training Package
		Then I should see documents were uploaded to the Training Package
