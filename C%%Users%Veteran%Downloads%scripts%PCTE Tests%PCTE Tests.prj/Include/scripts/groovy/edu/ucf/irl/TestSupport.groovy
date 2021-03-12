package edu.ucf.irl

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.common.WebUiCommonHelper

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

import internal.GlobalVariable as GlobalVariable

import com.warrenstrange.googleauth.GoogleAuthenticator
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder
import com.warrenstrange.googleauth.HmacHashFunction

import edu.ucf.irl.cryptographer.Cryptographer


public class TestSupport {
	static private TestSupport   singleton_instance = null;

	private boolean   isLoggedIn = false;
	private boolean   isInTestSuite = false;
	private boolean   isInTestCaseExecution = false;
	private GoogleAuthenticator   g_auth;
	private Cryptographer         key_cryptographer;


	public static TestSupport getInstance() {
		// Check to see if the singleton instance needs to be instantiated
		if (singleton_instance == null)
		{
			// Instantiate the singleton
			singleton_instance = new TestSupport();
		}

		// Return the singleton instance
		return singleton_instance;
	}


	// ============================================================================================================================


	public void beginTestSuiteSetup()
	{
		// Indicate that tests are being executed inside a test suite
		isInTestSuite = true;
	}


	public void endTestSuiteSetup()
	{
		// Indicate that the execution is no longer inside test suite setup
		isInTestCaseExecution = true;
	}


	public void beginTestSuiteTeardown()
	{
		// Indicate that the execution is currently inside test suite teardown
		isInTestCaseExecution = false;
	}


	public void endTestSuiteTeardown()
	{
		// Indicate that tests are done being executed inside a test suite
		isInTestSuite = false;
	}


	public boolean isInTestSuite()
	{
		// Return whether execution is currently taking place inside of a test suite
		return isInTestSuite;
	}


	public boolean isInTestCaseExecution()
	{
		// Return whether execution of test cases is taking place within the suite
		return isInTestCaseExecution;
	}


	// ============================================================================================================================


	public void login(String username = "", String password = "", String ekey = "")
	{
		// If login has already occurred, exit out
		if (isLoggedIn)
			return;

		// Open the browser
		WebUI.openBrowser('');
		WebUI.deleteAllCookies();

		// Maximize the window (to avoid mobile version)
		WebUI.maximizeWindow();

		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Delay for 5 seconds for the Single Sign On hub to show up
		TestSupport.delay(5);

		// Get username and password fields as well as the "authenticate" button
		// (handle either SSO page or original page)

		// Try to find username field (check SSO first, then original)
		def usernameField;
		if (GlobalVariable.sso)
			usernameField = findTestObject('Object Repository/Page_/input_SSO_Username');
		else
			usernameField = findTestObject('Object Repository/Page_/input_USERNAME_username');

		// Try to find password field (check SSO first, then original)
		def passwordField;
		if (GlobalVariable.sso)
			passwordField = findTestObject('Object Repository/Page_/input_SSO_Password');
		else
			passwordField = findTestObject('Object Repository/Page_/input_Password_password');

		// Try to find authenticate button (check SSO first, then original)
		def loginButton;
		if (GlobalVariable.sso)
			loginButton = findTestObject('Object Repository/Page_/input_SSO_Login');
		else
			loginButton = findTestObject('Object Repository/Page_/button_LOGIN');

		// Check to see if the username and password were specified
		if (username != "" && password != "") {
			// Use the given username
			WebUI.setText(usernameField, username);

			// Use the given password
			WebUI.setEncryptedText(passwordField, password);
		}
		else {
			// Use the default username from the execution profile
			WebUI.setText(usernameField, GlobalVariable.user1_username);

			// Use the default password from the execution profile
			WebUI.setEncryptedText(passwordField, GlobalVariable.user1_password);
		}

		// Click the Authenticate button
		WebUI.scrollToElement(loginButton, 5)
		WebUI.click(loginButton);
		TestSupport.delay(1);

		/*
		 // See if OTP appears by waiting for TOTP field to appear
		 if (WebUI.waitForElementPresent(findTestObject('Page_Log in to pcte/input_Login_OneTimeCode'), 10, FailureHandling.OPTIONAL))
		 {
		 // Create instance of Google Authenticator with PCTE OTP configuration
		 GoogleAuthenticatorConfigBuilder gacb = new GoogleAuthenticatorConfigBuilder();
		 gacb.setHmacHashFunction(HmacHashFunction.HmacSHA256);
		 gacb.setCodeDigits(6);
		 gacb.setTimeStepSizeInMillis(90000);
		 gacb.setWindowSize(3);
		 GoogleAuthenticatorConfig gac = gacb.build();
		 g_auth = new GoogleAuthenticator(gac);
		 // Create instance of decryption code
		 Cryptographer key_cryptographer = new Cryptographer(RunConfiguration.getProjectDir() + '/Data Files/code.txt');
		 // Get the current OTP for the user
		 String key = key_cryptographer.decrypt(ekey)
		 int code = g_auth.getTotpPassword(key)
		 // Enter code
		 WebUI.setText(findTestObject('Page_Log in to pcte/input_Login_OneTimeCode'), String.format("%06d", code));
		 // Click on the Login button
		 WebUI.click(findTestObject('Page_Log in to pcte/input_Login_OneTimeLogin'), FailureHandling.OPTIONAL);
		 TestSupport.delay(1);
		 }
		 // See if the OpenShift portal permissions banner appears
		 if (WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Login_PermissionsYes'), 10, FailureHandling.OPTIONAL))
		 {
		 // Click the Yes button
		 WebUI.click(findTestObject('Page_PCTE Portal/input_Login_PermissionsYes'), FailureHandling.OPTIONAL);
		 }
		 // See if login banner appears by waiting for the Accept button on the login banner to appear
		 if (WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Login_Accept'), 10, FailureHandling.OPTIONAL))
		 {
		 // Click on the Accept button on the login banner (if it shows up)
		 WebUI.click(findTestObject('Page_PCTE Portal/button_Login_Accept'), FailureHandling.OPTIONAL);
		 }
		 // See if OpenDash login banner appears by waiting for the I Agree button on the login banner to appear
		 if (WebUI.waitForElementVisible(findTestObject('Page_OpenDash360 Portal/span_Lobby_IAgree'), 30, FailureHandling.OPTIONAL))
		 {
		 // Click on the I Agree button on the login banner (if it shows up)
		 WebUI.click(findTestObject('Page_OpenDash360 Portal/span_Lobby_IAgree'), FailureHandling.OPTIONAL);
		 }
		 // Wait for the OpenDash lobby page to load
		 if (WebUI.waitForElementVisible(findTestObject('Page_OpenDash360 Portal/a_Lobby_PortalLink'), 10, FailureHandling.OPTIONAL))
		 {
		 // Click on the link to navigate to the portal home page
		 WebUI.click(findTestObject('Page_OpenDash360 Portal/a_Lobby_PortalLink'), FailureHandling.OPTIONAL);
		 }
		 */

		// Make sure that the login has finished the login finished by checking
		// to see if the Apps icon is visible
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Messages/a_Account'), 10);

		// Indicate that login has occurred successfully
		isLoggedIn = true;
	}


	public void staggeredLogin(String username = "", String password = "", String name, int batchSize, int timeBetweenBatches, int suiteSize)
	{
		// If login has already occurred, exit out
		if (isLoggedIn)
		{
			return;
		}

		// Fetch the number of the user from the last
		def userString = name.tokenize().pop() as String;
		def userNumber = userString.replaceAll('User', '') as int;

		// Calculate the delay amount based on size of launch batches, the time between the launch batches, and
		// the number of the users in the suite
		// The first user is the pilot user (used to take a baseline of the portal responsiveness measurements,
		// and so has no delay)
		def delayAmount = 0;
		if (userNumber != 1)
		{
			// 0 index the users for easier calculations
			userNumber = userNumber - 1;

			// Each suite is launched separately and their timing is handled manually,
			// so no need to delay between suites
			userNumber = userNumber % suiteSize;

			// Calculate the delay based on the batch
			delayAmount = (userNumber / batchSize) as int;
			delayAmount = delayAmount * timeBetweenBatches;
		}

		// Delay by the above calculated delay amount
		WebUI.delay(delayAmount);

		// Open the browser
		WebUI.openBrowser('');
		WebUI.deleteAllCookies();

		// Maximize the window (to avoid mobile version)
		WebUI.maximizeWindow();

		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Get username and password fields as well as the "authenticate" button
		// (handle either SSO page or original page)

		// Try to find username field (check SSO first, then original)
		def usernameField;
		if (GlobalVariable.sso)
			usernameField = findTestObject('Object Repository/Page_/input_SSO_Username');
		else
			usernameField = findTestObject('Object Repository/Page_/input_USERNAME_username');

		// Try to find password field (check SSO first, then original)
		def passwordField;
		if (GlobalVariable.sso)
			passwordField = findTestObject('Object Repository/Page_/input_SSO_Password');
		else
			passwordField = findTestObject('Object Repository/Page_/input_Password_password');

		// Try to find authenticate button (check SSO first, then original)
		def loginButton;
		if (GlobalVariable.sso)
			loginButton = findTestObject('Object Repository/Page_/input_SSO_Login');
		else
			loginButton = findTestObject('Object Repository/Page_/button_LOGIN');

		// Check to see if the username and password were specified
		if (username != "" && password != "") {
			// Use the given username
			WebUI.waitForElementVisible(usernameField, 300)
			WebUI.setText(usernameField, username);

			// Use the given password
			WebUI.waitForElementVisible(passwordField, 300)
			WebUI.setEncryptedText(passwordField, password);
		}
		else {
			// Use the default username from the execution profile
			WebUI.waitForElementVisible(usernameField, 300)
			WebUI.setText(usernameField, GlobalVariable.user1_username);

			// Use the default password from the execution profile
			WebUI.waitForElementVisible(passwordField, 300)
			WebUI.setEncryptedText(passwordField, GlobalVariable.user1_password);
		}

		// Click the Authenticate button
		WebUI.scrollToElement(loginButton, 5)
		WebUI.waitForElementVisible(loginButton, 300)
		WebUI.click(loginButton);

		/*
		 // See if login banner appears by waiting for the Accept button on the login banner to appear
		 if (WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Login_Accept'), 10, FailureHandling.OPTIONAL))
		 {
		 // Click on the Accept button on the login banner (if it shows up)
		 WebUI.click(findTestObject('Page_PCTE Portal/button_Login_Accept'), FailureHandling.OPTIONAL);
		 }
		 // See if OpenDash login banner appears by waiting for the I Agree button on the login banner to appear
		 if (WebUI.waitForElementVisible(findTestObject('Page_OpenDash360 Portal/span_Lobby_IAgree'), 30, FailureHandling.OPTIONAL))
		 {
		 // Click on the I Agree button on the login banner (if it shows up)
		 WebUI.click(findTestObject('Page_OpenDash360 Portal/span_Lobby_IAgree'), FailureHandling.OPTIONAL);
		 }
		 // Wait for the OpenDash lobby page to load
		 if (WebUI.waitForElementVisible(findTestObject('Page_OpenDash360 Portal/a_Lobby_PortalLink'), 10, FailureHandling.OPTIONAL))
		 {
		 // Click on the link to navigate to the portal home page
		 WebUI.click(findTestObject('Page_OpenDash360 Portal/a_Lobby_PortalLink'), FailureHandling.OPTIONAL);
		 }
		 */
		// Make sure that the login has finished the login finished by checking
		// to see if the Apps icon is visible
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Messages/a_Account'), 300);

		// Indicate that login has occurred successfully
		isLoggedIn = true;
	}


	public void logout()
	{
		// Make sure we are logged in before we try to logout
		if (!isLoggedIn)
		{
			// We are not logged in, so bail
			return;
		}

		// Go to portal home page again to make sure that there are no pop ups getting in the way
		WebUI.navigateToUrl(GlobalVariable.portal_url)

		// Wait for the browser to finish navigating
		TestSupport.delay(3);

		// Find the User icon
		def userIcon;
		if (GlobalVariable.sso)
			userIcon = findTestObject('Object Repository/Page_Messages/div_ '+GlobalVariable.user1_username+' Account           Document_935841');
		else
			userIcon = findTestObject('Object Repository/Page_Messages/div_ '+GlobalVariable.user1_username+' Account           Document_935841');

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

		// Close the browser
		WebUI.closeBrowser();

		// Indicate that the user is not logged in
		isLoggedIn = false;
	}


	public static void delay(int seconds)
	{
		// Delay for specified seconds scaled by constant
		WebUI.delay(seconds * GlobalVariable.delay_scale);
	}


	public static void clickDynamicElement(String xPath, String objectName)
	{
		// Create a dynamic test object and find the HTML element with the correct name
		TestObject dynamicObject = new TestObject();

		// Form the full XPath with the name of the desired object
		String dynamicObjectXPath = String.format(xPath, objectName);

		// Set the newly-formed XPath as a property of the dynamic test object
		dynamicObject.addProperty('xpath', ConditionType.EQUALS, dynamicObjectXPath);

		// Click on the dynamic object
		WebUI.click(dynamicObject);
	}


	public static boolean verifyDynamicElementPresent(String xPath, String objectName, int timeout, FailureHandling fail)
	{
		// Create a dynamic test object and find the HTML element with the correct name
		TestObject dynamicObject = new TestObject();

		// Form the full XPath with the name of the desired object
		String dynamicObjectXPath = String.format(xPath, objectName);

		// Set the newly-formed XPath as a property of the dynamic test object
		dynamicObject.addProperty('xpath', ConditionType.EQUALS, dynamicObjectXPath);

		// Verify that the dynamic object is visible
		return WebUI.verifyElementPresent(dynamicObject, timeout, fail);
	}


	public static void clickOffsetScaling(TestObject object, double percentX, double percentY)
	{
		// Get the dimensions of the object that is being clicked
		int width = WebUI.getElementWidth(object);
		int height = WebUI.getElementHeight(object);

		// Calculate relative click coordinates using the dimensions
		int clickX = (int) width * percentX;
		int clickY = (int) height * percentY;
		KeywordUtil.logInfo("click: ("+clickX+", "+clickY+")");

		// Perform an offset click
		WebUI.clickOffset(object, clickX, clickY);
	}


	public static boolean isObjectPresent(TestObject testObject, int wait = 5)
	{
		try
		{
			// Use this Katalon internal function to just find the element (without any error generation)
			WebUiCommonHelper.findWebElement(testObject, wait)
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
