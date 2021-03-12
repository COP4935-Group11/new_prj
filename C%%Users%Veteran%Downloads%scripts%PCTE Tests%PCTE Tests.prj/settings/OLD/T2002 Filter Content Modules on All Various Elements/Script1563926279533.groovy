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

TestSupport.delay(3)

WebUI.comment('Testing filtering by name')

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NameFilterOpen'))

WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_NameFilter'), 'PCTE Test ' + testCode, FailureHandling.STOP_ON_FAILURE)

TestSupport.delay(1)

WebUI.verifyTextPresent('PCTE Test ' + testCode, false)

TestSupport.delay(1)

WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_NameFilter'), ' ')

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NameFilterClose'))

TestSupport.delay(3)

WebUI.comment('Testing filtering by status')

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_StatusFilterOpen'))

WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_StatusFilter'), 'Final', FailureHandling.STOP_ON_FAILURE)

TestSupport.delay(1)

WebUI.verifyTextPresent('PCTE Test ' + testCode, false)

TestSupport.delay(1)

WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_StatusFilter'), ' ')

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_StatusFilterClose'))

TestSupport.delay(3)

WebUI.comment('Testing filtering by author')

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_AuthorFilterOpen'))

WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_AuthorFilter'), GlobalVariable.orgadmin_name, FailureHandling.STOP_ON_FAILURE)

TestSupport.delay(1)

WebUI.verifyTextPresent('PCTE Test ' + testCode, false)

TestSupport.delay(1)

WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_AuthorFilter'), ' ')

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_AuthorFilterClose'))

TestSupport.delay(3)

WebUI.comment('Testing filtering by task count')

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TaskCountFilterOpen'))

WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TaskCountFilter'), '0', FailureHandling.STOP_ON_FAILURE)

TestSupport.delay(1)

WebUI.verifyTextPresent('PCTE Test ' + testCode, false)

TestSupport.delay(1)

WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TaskCountFilter'), ' ')

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TaskCountFilterClose'))

TestSupport.delay(3)

WebUI.comment('Testing filtering by textual search')

'Set text to search for'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 'PCTE Test ' + testCode)

TestSupport.delay(3)

WebUI.verifyTextPresent('PCTE Test ' + testCode, false)

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
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    SharedTestData data = SharedTestData.getInstance()

    'Delete our test content module'
    data.deleteContentModule('PCTE Test ' + testCode)

    'Log out of the portal'
    support.logout()
}

