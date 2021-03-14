@CD-27
@PCTE-7750
@Content-Deployments
@Severity-1

Feature: Range Transfers
	As an admin, I want to upload documents to range transfer so that I can access them on other VMs
  
#This test assumes that you have a network with range-transfer VM
#The assumption is also made that the range-transfer VM is already
#Configured and is ready to accept file uploads
  
	Scenario: Transfer a file to a range
		Given My role is admin
		And I access the an event with ranges
		When I upload a file to the range transfer
		And I open a VM console to download the file
		Then I should see the file was downloaded to the VM
