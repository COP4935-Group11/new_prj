@CD-14
@PCTE-10740
@Content-Content-Authoring
@Severity-1

Feature: Import Training Package
	As a Content Author, I want to import a training package so that I can use it in another event.

	Scenario: Import a training package
		Given My role is portal admin
		When I import a Training Package
		Then I should see the imported Training Package in the Content Library