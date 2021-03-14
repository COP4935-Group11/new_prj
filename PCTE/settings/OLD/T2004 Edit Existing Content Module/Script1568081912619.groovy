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

'Delay for a second for module list to load'
TestSupport.delay(1)

'Set text to search for'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 'PCTE Test ' + testCode)

'Wait for page to load'
TestSupport.delay(1)

'Select our content module'
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

'Enter name for Content Module'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleNameUpdate'), ('PCTE Test ' + testCode) + ' EDITED')

'Enter description for Content Module'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleDescriptionUpdate'), 'NEWDESC')

'Set duration to 2 days'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleDurationUpdate'), '2')

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
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), ('PCTE Test ' + testCode) + ' EDITED')

'Open our new module'
WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : ('PCTE Test ' + 
            testCode) + ' EDITED']))

TestSupport.delay(1)

WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_Content_ContentModuleDescription'), 'NEWDESC')

TestSupport.delay(1)

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
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Get the instance of the shared test data class'
    SharedTestData data = SharedTestData.getInstance()

    'Delete our test content module (note this works because we filter first)'
    data.deleteContentModule('PCTE Test ' + testCode)

    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log out of the portal'
    support.logout()
}

