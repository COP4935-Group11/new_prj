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

'Wait for the user button to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_User'), 30)

'Open user menu'
WebUI.click(findTestObject('Page_PCTE Portal/div_User'))

'Briefly wait for user menu to open'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_UserGuide'), 30)

'Select user guide'
WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_UserGuide'))

'Briefly wait for user guide window to open'
TestSupport.delay(1)

'Switch to window/tab with user guide'
WebUI.switchToWindowTitle('Introduction · PCTE Cyber Range Documentation')

'Wait for the user guide content to load'
WebUI.waitForElementPresent(findTestObject('Page_UserGuide/h1_PCTECyberRange'), 30)

'Verify user guide loaded'
WebUI.verifyElementText(findTestObject('Page_UserGuide/h1_PCTECyberRange'), 'PCTE CyberRange')

'Close user guide window/tab'
WebUI.closeWindowTitle('Introduction · PCTE Cyber Range Documentation')

'Select main portal window/tab again'
WebUI.switchToWindowTitle('PCTE Portal')

'Briefly wait for user guide window/tab to close'
TestSupport.delay(2)

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
    
    'Close user guide window/tab'
    WebUI.closeWindowTitle('Introduction · PCTE Cyber Range Documentation', FailureHandling.OPTIONAL)
    
    'Select main portal window/tab again (to be sure)'
    WebUI.switchToWindowTitle('PCTE Portal')
    
    'Log out of the portal'
    support.logout()
}

