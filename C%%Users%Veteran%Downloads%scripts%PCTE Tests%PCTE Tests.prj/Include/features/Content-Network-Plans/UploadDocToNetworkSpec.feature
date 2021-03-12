@CD-23
@PCTE-10783
@Content-Network-Plans
@Severity-1

Feature: Upload Documents to a Network Spec
  As a content author I want to be able to upload documents to a network spec so that other users can access those documents

	Scenario: I want to upload a document to network spec
		Given My role is content author 
		And I am on the coverpage for a network spec
		When I add three different file types 
		Then I should be able to download them from the network spec

	Scenario: As another user I should be able to download those files 
		Given My role is admin 
#member may not have initial access, consider using admin and if admin doesn't have, admin can give themself access
		And I have been given access to the network spec
		When I download the files from the network spec
		Then I should be able to view the files
#this may not be available depending on groovyfile or because of katalon capabilities 
