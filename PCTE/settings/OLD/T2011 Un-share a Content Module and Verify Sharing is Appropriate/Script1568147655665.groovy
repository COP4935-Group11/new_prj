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
import org.openqa.selenium.Keys as Keys
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

'Click "more"'
WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/i_Content_ContentModulesMore'))

'Wait for page to load'
TestSupport.delay(1)

'Click share'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleShare'))

'Wait for page to load'
TestSupport.delay(1)

'Remove org list permission'
WebUI.click(findTestObject('Page_PCTE Portal/i_Content_ContentModuleShareOrgList'))

'Remove org view permission'
WebUI.click(findTestObject('Page_PCTE Portal/i_Content_ContentModuleShareOrgView'))

'Wait for page to load'
TestSupport.delay(1)

'Save the share data'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleShareSave'))

'Get the instance of the test support class'
TestSupport support = TestSupport.getInstance()

'Log out of the portal as admin'
support.logout()

'Wait a second'
TestSupport.delay(1)

'Login as test user'
support.login(GlobalVariable.user1_username, GlobalVariable.user1_password)

'Wait a second'
TestSupport.delay(1)

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

'Make sure module does *not* show for this user'
WebUI.verifyElementNotPresent(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : 'PCTE Test ' + 
            testCode]), 2)

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

    'Logout as test user'
    support.logout()

    'Wait a second'
    TestSupport.delay(1)

    'Login as admin'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Wait a second'
    TestSupport.delay(1)

    'Get the instance of the shared test data class'
    SharedTestData data = SharedTestData.getInstance()

    'Delete our test content module'
    data.deleteContentModule('PCTE Test ' + testCode)

    'Log out of the portal'
    support.logout()
}

