@CD-6
@PCTE-11592
@Content-Deployments
@Severity-1

Feature: VM Templates Mapping
	As a content author, I want to check my network spec so that I can see all the VMs required for deployment have mapped templates
  
	Scenario: Check VMs are all mapped
		Given My role is content author 
		And I access a Network Spec
		When I enter the Review Deployment tab
		Then I should see that all the VMs are mapped
 
