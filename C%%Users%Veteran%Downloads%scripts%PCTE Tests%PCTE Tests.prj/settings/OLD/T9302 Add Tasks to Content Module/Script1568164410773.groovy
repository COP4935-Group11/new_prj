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

'Select Tasks tab'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleTasks'))

'Click to add a task to the chain'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddTaskToChain'))

'Wait one second'
TestSupport.delay(1)

'Enter the question'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 'Which of the following letters is in "PCTE?"')

'Wait one second'
TestSupport.delay(1)

'Select "Short Answer" to open drop down list'
WebUI.click(findTestObject('Page_PCTE Portal/i_Content_ContentModuleShortAnswerArrow'))

'Click the "Multiple Choice" item'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_ContentModuleMultipleChoice'))

'Wait one second'
TestSupport.delay(1)

'Add a choice'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddChoice2'))

'Wait one second'
TestSupport.delay(1)

'Add a choice'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddChoice3'))

'Wait one second'
TestSupport.delay(1)

'Add a choice'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddChoice4'))

'Wait one second'
TestSupport.delay(1)

'Set choice 1'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice1'), 'C')

'Set choice 2'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice2'), 'G')

'Set choice 3'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice3'), 'U')

'Set choice 4'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice4'), 'S')

'Set choice 5'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice5'), 'A')

'Create a second chain'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleCreateNewChain'))

'Enter a question'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 'Who is the mascot for UCF\'s athletic programs?')

'Enter the correct answer'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleAnswer'), 'Knightro')

'Click update!'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleUpdate'))

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
WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : 'PCTE Test ' + 
            testCode]))

TestSupport.delay(1)

WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 'Content Module')

WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleStatus'), 'Final')

WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModulePublished'), 'Published')

WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleQuestionCount'), '3')

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

    'Delete our test content module'
    data.deleteContentModule('PCTE Test ' + testCode)

    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log out of the portal'
    support.logout()
}

