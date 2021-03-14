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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

'Wait for the user menu button to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_User'), 30)

'Open user menu'
WebUI.click(findTestObject('Page_PCTE Portal/div_User'))

'Briefly wait for user menu to open'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_ContactSupport'), 30)

'Select "Contact Support"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_ContactSupport'))

'Wait for support page to load'
TestSupport.delay(3)

'Choose default English if language pop-up appears'
if (TestSupport.isObjectPresent(findTestObject('Page_PCTE Portal/p_Support_LanguageHeader'))) {
    'Click through language and avatar'
    WebUI.click(findTestObject('Page_PCTE Portal/input_Support_LanguageContinue'))

    'Wait for the next button to appear'
    WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Support_AvatarNext'), 30)

    'Click on the next button'
    WebUI.click(findTestObject('Page_PCTE Portal/input_Support_AvatarNext'))

    'Go back to the home page again'
    WebUI.navigateToUrl(GlobalVariable.portal_url)

    'Wait for the user menu button to appear'
    WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_User'), 30)

    'Click on the user menu button'
    WebUI.click(findTestObject('Page_PCTE Portal/div_User'))

    'Wait for the Contact Support button to appear'
    WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_ContactSupport'), 30)

    'Click on the Contact Support button'
    WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_ContactSupport'))
}

'Wait for the support page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_ServiceDeskDashboard'), 30)

'Verify support page loaded'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_ServiceDeskDashboard'), 'Open a Support Ticket')

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log into the portal'
    support.login(GlobalVariable.user1_username, GlobalVariable.user1_password)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log out of the portal'
    support.logout()
}

