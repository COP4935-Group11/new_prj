import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import edu.ucf.irl.TestSupport as TestSupport

'Wait for the username field to appear'
WebUI.waitForElementPresent(findTestObject('Page_Log in to pcte/input_SSO_Username'), 30)

'Specify username'
WebUI.setText(findTestObject('Page_Log in to pcte/input_SSO_Username'), GlobalVariable.orgadmin_username)

'Specify password'
WebUI.setEncryptedText(findTestObject('Page_Log in to pcte/input_SSO_Password'), GlobalVariable.orgadmin_password)

'Click "Authenticate"'
WebUI.click(findTestObject('Page_Log in to pcte/input_SSO_Login'))

'Wait for login to clear'
TestSupport.delay(3)

'Wait for the Accept button on the login banner to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Login_Accept'), 10)

'Click on the Accept button on the login banner (if it shows up)'
WebUI.click(findTestObject('Page_PCTE Portal/button_Login_Accept'), FailureHandling.OPTIONAL)

'Open dashboard'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Events_EventOutlook'), 'Event Outlook')


@com.kms.katalon.core.annotation.SetUp
def setup() 
{
   'Open the browser'
   WebUI.openBrowser('')

   'Maximize the window (to avoid mobile version)'
   WebUI.maximizeWindow()

   'Go to the PCTE test portal'
   WebUI.navigateToUrl(GlobalVariable.portal_url)
}


@com.kms.katalon.core.annotation.TearDown
def teardown() 
{
   'Get the instance of the test support class'
   TestSupport support = TestSupport.getInstance()

   'Log out of the portal'
   support.logout()
}
