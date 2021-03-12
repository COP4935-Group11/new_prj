package edu.ucf.irl.stepdefs
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import edu.ucf.irl.TestSupport as TestSupport

import com.warrenstrange.googleauth.GoogleAuthenticator
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder
import com.warrenstrange.googleauth.HmacHashFunction

import edu.ucf.irl.cryptographer.Cryptographer


class Login {
	private def login() {
		// Try to find username field (check SSO first, then original)
		def usernameField;
		if (GlobalVariable.sso)
			usernameField = findTestObject('Object Repository/Page_Log in to pcte/input_SSO_Username');
		else
			usernameField = findTestObject('Object Repository/Page_/input_USERNAME_username');

		// Try to find password field (check SSO first, then original)
		def passwordField;
		if (GlobalVariable.sso)
			passwordField = findTestObject('Object Repository/Page_Log in to pcte/input_SSO_Password');
		else
			passwordField = findTestObject('Object Repository/Page_/input_Password_password');

		// Try to find authenticate button (check SSO first, then original)
		def loginButton;
		if (GlobalVariable.sso)
			loginButton = findTestObject('Object Repository/Page_Log in to pcte/input_SSO_Login');
		else
			loginButton = findTestObject('Object Repository/Page_/button_LOGIN');

		// Use the member username from the execution profile
		WebUI.setText(usernameField, GlobalVariable.user1_username);

		// Use the member password from the execution profile
		WebUI.setEncryptedText(passwordField, GlobalVariable.user1_password);

		// Click the Authenticate button
		WebUI.click(loginButton);

		/*
		 // See if OTP appears by waiting for TOTP field to appear
		 if (WebUI.waitForElementPresent(findTestObject('Page_Log in to pcte/input_Login_OneTimeCode'), 30, FailureHandling.OPTIONAL))
		 {
		 // Create instance of Google Authenticator with PCTE OTP configuration
		 GoogleAuthenticatorConfigBuilder gacb = new GoogleAuthenticatorConfigBuilder();
		 gacb.setHmacHashFunction(HmacHashFunction.HmacSHA256);
		 gacb.setCodeDigits(6);
		 gacb.setTimeStepSizeInMillis(90000);
		 gacb.setWindowSize(3);
		 GoogleAuthenticatorConfig gac = gacb.build();
		 GoogleAuthenticator gAuth = new GoogleAuthenticator(gac);
		 // Create instance of decryption code
		 Cryptographer keyCryptographer = new Cryptographer(RunConfiguration.getProjectDir() + '/Data Files/code.txt');
		 // Get the current OTP for the user
		 String key = keyCryptographer.decrypt(GlobalVariable.user1_key)
		 int code = gAuth.getTotpPassword(key)
		 // Enter code
		 WebUI.setText(findTestObject('Page_Log in to pcte/input_Login_OneTimeCode'), String.format("%06d", code));
		 // Click on the Login button
		 WebUI.click(findTestObject('Page_Log in to pcte/input_Login_OneTimeLogin'), FailureHandling.OPTIONAL);
		 }
		 // See if login banner appears by waiting for the Accept button on the login banner to appear
		 if (WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Login_Accept'), 10, FailureHandling.OPTIONAL))
		 {
		 // Click on the Accept button on the login banner (if it shows up)
		 WebUI.click(findTestObject('Page_PCTE Portal/button_Login_Accept'), FailureHandling.OPTIONAL);
		 }
		 */
		// Wait for login to clear
		TestSupport.delay(3)
	}


	@Given("I am at the PCTE Portal")
	def goToPortal() {
		// Open the browser
		WebUI.openBrowser('')

		// Maximize the window (to avoid mobile version)
		WebUI.maximizeWindow()

		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url)
	}


	@Given("I am logged into the PCTE Portal")
	def getLoggedIn() {
		// Call login helper function
		login()
	}


	// ============================================================================================================================


	@When("I log into the PCTE Portal")
	def loginToPortal()
	{
		// Call login helper function
		login()
	}


	@When("I logout of the PCTE Portal")
	def logout()
	{
		/*
		 // Go to portal home page again to make sure that there are no pop ups getting in the way
		 WebUI.navigateToUrl(GlobalVariable.portal_url)
		 */

		// Wait for the browser to finish navigating
		TestSupport.delay(3);

		// Find the User icon
		def userIcon;
		if (GlobalVariable.sso)
			userIcon = findTestObject('Object Repository/Page_PCTE Portal/div_UserMenu');
		else
			userIcon = findTestObject('Object Repository/Page_Messages/i_'+GlobalVariable.user1_username+'_fa fa-angle-down hidden-side');

		// Click the User icon
		WebUI.click(userIcon);

		// Wait for the User menu to pop up
		TestSupport.delay(3)

		// Find the Log out button
		def logoutButton;
		if (GlobalVariable.sso)
			logoutButton = findTestObject('Object Repository/Page_PCTE Portal/span_UserMenu_Logout');
		else
			logoutButton = findTestObject('Object Repository/Page_Messages/a_Logout');

		// Click the Log out button
		WebUI.click(logoutButton);
	}


	// ============================================================================================================================


	@Then("I should be able to access the PCTE Portal")
	def confirmInitialPage()
	{
		// Verify initial page has loaded
		WebUI.verifyElementPresent(findTestObject('Page_Messages/a_Account'), 10)
	}


	@Then("I should no longer have access to the PCTE Portal")
	def confirmNoInitialPage()
	{
		// Verify initial page is not on screen
		WebUI.verifyElementNotPresent(findTestObject('Page_Messages/a_Account'), 5)

		// Close the browser
		WebUI.closeBrowser();
	}
}
