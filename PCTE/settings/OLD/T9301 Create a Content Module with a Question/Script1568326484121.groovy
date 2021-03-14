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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
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

'Click on "New Content Module"'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewContentModule'))

'Enter name for Content Module'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleName'), 'PCTE Test ' + testCode)

'Enter description for Content Module'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleDescription'), 'Create a content module with one task.')

'Set duration to 1 day'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleDuration'), '1')

'Select Tasks tab'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleTasks'))

'Advance to next tab'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleCreateNewChain'))

'Enter a question'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 'What does PCTE stand for?')

'Enter the correct answer'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleAnswer'), 'Persistent Cyber Training Environment')

'Click create!'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleCreate'))

'Wait one second'
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
WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : 'PCTE Test ' + testCode]))

'Wait one second'
TestSupport.delay(1)

'Verify content module'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 'Content Module')

'Verify status'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleStatus'), 'Final')

'Verify published'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModulePublished'), 'Published')

'Verify task count'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleQuestionCount'), '1')

'Wait one second'
TestSupport.delay(1)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log into the portal'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Delete our module and use SharedTestData since we are in teardown'
    SharedTestData data = SharedTestData.getInstance()

    data.deleteContentModule('PCTE Test ' + testCode)

    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log out of the portal'
    support.logout()
}

