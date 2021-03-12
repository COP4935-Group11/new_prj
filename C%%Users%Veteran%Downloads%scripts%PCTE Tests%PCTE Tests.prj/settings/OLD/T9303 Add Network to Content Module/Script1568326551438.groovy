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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import internal.GlobalVariable as GlobalVariable
import edu.ucf.irl.TestSupport as TestSupport
import edu.ucf.irl.SharedTestData as SharedTestData

'Open the Dashboard (apps)'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Delay for a second for Dashboard to open'
TestSupport.delay(1)

'Select the Content area (app)'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

'Click on "Content Modules"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModules'))

'Set text to search for'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 'PCTE Test ' + testCode)

'Open our new module'
WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : 'PCTE Test ' + 
            testCode]))

'Wait for page to load'
TestSupport.delay(1)

'Click edit content module'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_EditContentModule'))

'Wait for page to load'
TestSupport.delay(1)

'Make sure we are on overview tab'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleOverview'))

'Wait for module to load'
TestSupport.delay(1)

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_AddNetwork'))

TestSupport.delay(1)

WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_AddNetworkSearch'), 'PCTE Test ' + testCode)

TestSupport.delay(1)

WebUI.click(findTestObject('Page_PCTE Portal/i_Content_AddNetworkCheck'))

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_AddNetworkToModule'))

TestSupport.delay(1)

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleUpdate'))

TestSupport.delay(1)

'Open the Dashboard (apps)'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Delay for a second for Dashboard to open'
TestSupport.delay(1)

'Select the Content area (app)'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

'Click on "Content Modules"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModules'))

'Set text to search for'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 'PCTE Test ' + testCode)

'Open our new module'
WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : 'PCTE Test ' + 
            testCode]))

'Wait for page to load'
TestSupport.delay(1)

'Verify content module'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 'Content Module')

'Verify status'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleStatus'), 'Final')

'Verify published'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModulePublished'), 'published')

WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_Content_ModuleNetwork'), "PCTE Test " + testCode)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log into the portal as admin'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Wait a second'
    TestSupport.delay(1)

    'Get the instance of the shared test data class'
    SharedTestData data = SharedTestData.getInstance()

    'Create a simple content module'
    data.createContentModule('PCTE Test ' + testCode)

    'Wait a second'
    TestSupport.delay(1)

    'Get a network spec'
    data.createCloneSource('PCTE Test ' + testCode)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Get the instance of the shared test data class'
    SharedTestData data = SharedTestData.getInstance()

    'Get a network spec'
    data.deleteCloneSource('PCTE Test ' + testCode)

    'Wait a second'
    TestSupport.delay(1)

    'Delete our test content module'
    data.deleteContentModule('PCTE Test ' + testCode)

    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log out of the portal'
    support.logout()
}

