@CD-20
@PCTE-6424
@Content-Deployments
@Severity-1

Feature: Verify DHCP
	As a RCS Admin, I want to create a simspace-mgmt VM so so that I can verify DHCP is running
    
	Scenario: Create a DHCP deployment
		Given My role is admin
		When I create a deployment with the simspace-mgmt VM template
		And I login into vCenter as RCS admin
		Then I should see the deployment in vCenter
   	
	Scenario: Verify the deployment is getting IPS
		Given I am in vCenter as RCS admin
		When I access the deployment
		Then I should see four IPs connected to the deployment
