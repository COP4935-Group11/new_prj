@CD-14
@PCTE-11595
@Admin-System-Admin
@Severity-1

Feature: VM Templates Upload
	As an Admin, I want to upload VM templates in Portal Admin so that it could be used to create VMs.
	
	Scenario: VM Templates Upload
		Given My role is Admin
		And I access Portal Admin
		When I upload a VM Template
		Then I should see the VM Template in the Content Library