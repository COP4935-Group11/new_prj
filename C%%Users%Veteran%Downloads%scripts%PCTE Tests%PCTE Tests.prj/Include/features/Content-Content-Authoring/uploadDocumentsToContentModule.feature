@CD-35
@PCTE-10782
@Content-Content-Authoring
@Severity-1

Feature: Upload Documents to a Content Module
	As a Content Author, I want to upload documents to a Content Module so that users can view them.

#	Scenario: Upload documents to a Content Module
#		Given My role is content author
#		When I upload the documents to the Content Module 
#		Then I should see the documents uploaded to the Content Module
		
	Scenario: Upload documents to a Content Module chain
		Given My role is content author
		When I upload the documents to the Content Module chain
		Then I should see the documents uploaded to the Content Module chain

#	Scenario: Deploy a training package with the content module
#		Given My role is content author 
#		When I create a Training Package using the Content Module
#		Then I should see the documents within the package
		
#	Scenario: Verify authorized participants can view documents uploaded to a content module
#		Given My role is member 
#		And I have had a Content Module shared with me
#		When I access the shared Content Module
#		Then I should see the documents uploaded to the Content Module and its chains
  
