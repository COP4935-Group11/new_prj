package edu.ucf.irl.stepdefs

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import edu.ucf.irl.TestSupport as TestSupport
import edu.ucf.irl.SharedTestData as SharedTestData


public class Chat {

	@Given("I am on the mattermost login page")
	def navigateToChat() {
		// Go to the PCTE portal home page
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Wait for the user menu to be clickable
		WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/div_User_Menu'), 30);

		// Click on the user menu
		WebUI.click(findTestObject('Page_PCTE Portal/div_User_Menu'));

		// Wait for the Chat menu entry to be clickable
		WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/span_Dashboard_Chat'), 30);

		// Click on the Chat menu entry
		WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_Chat'));

		// Wait for the new page to load
		WebUI.delay(5);

		// Switch to the new page
		WebUI.switchToWindowIndex(1);
	}

	@When("I login with keycloak")
	def loginWithKeycloak() {
		// Wait for the Keycloak login button to appear
		WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/span_Chat_Keycloak'), 30);

		// Click on the Keycloak button
		WebUI.click(findTestObject('Page_PCTE Portal/span_Chat_Keycloak'));

		// Check to see if the Mattermost tutorial has been displayed
		if (WebUI.waitForElementPresent(findTestObject('Page_Mattermost/span_Chat_SkipTutorial'), 10, FailureHandling.OPTIONAL))
		{
			// Skip the tutorial
			WebUI.click(findTestObject('Page_Mattermost/span_Chat_SkipTutorial'), FailureHandling.OPTIONAL)
		}
	}

	@Then("I should see my chat dashboard")
	def verifyChatDashboard()
	{
		// Verify that the chat input box has appeared
		WebUI.verifyElementPresent(findTestObject('Page_Mattermost/textarea_Chat_Input'), 30)
	}

	@Given("A chat exists with another user")
	def setupDirectChat()
	{
		// TODO
	}

	@When("I send a message to the other user")
	def sendDirectMessage()
	{
		// TODO
	}

	@Then("the other user should receive the message")
	def verifyMessageSent()
	{
		// TODO
	}

	@When("I send a file to the other user")
	def sendFile()
	{
		// TODO
	}

	@Then("the other user should receive the file")
	def verifyFileSent()
	{
		// TODO
	}

	@Given("I am in the mattermost chat menu")
	def navigateToChatMenu()
	{
		// TODO
	}

	@Given("other members are part of my team")
	def addChatTeamMembers()
	{
		// TODO
	}

	@Given("A public channel has been created")
	def setupPublicChannel()
	{
		// TODO
	}

	@When("I add members from my team to the channel")
	def addMembersToChannel()
	{
		// TODO
	}

	@Then("I should be able to communicate with them on the channel")
	def verifyChatChannelMessaging()
	{
		// TODO
	}

	@Given("A private channel has been created")
	def setupPrivateChannel()
	{
		// TODO
	}

	@When("I invite users using the invite others to private channel link")
	def addMembersToPrivateChannel()
	{
		// TODO
	}
}
