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
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleDescription'), 'Create a content module with multiple questions and tasks.')

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

'Click to add a task to the chain'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddTaskToChain'))

'Delay a second to let drop down render'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 'Which of the following letters is in "PCTE?"')

'Select "Short Answer" to open drop down list'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleShort AnswerArrow'))

'Click the "Multiple Choice" item'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_ContentModuleMultipleChoice'))

'Add a choice'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddChoice2'))

'Wait one second'
TestSupport.delay(1, FailureHandling.STOP_ON_FAILURE)

'Add a choice'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddChoice3'))

'Wait one second'
TestSupport.delay(1, FailureHandling.STOP_ON_FAILURE)

'Add a choice'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddChoice4'))

'Wait one second'
TestSupport.delay(1, FailureHandling.STOP_ON_FAILURE)

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

'Click create!'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleCreate'))

'Wait one second'
TestSupport.delay(1, FailureHandling.STOP_ON_FAILURE)

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

WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModulePublished'), 'published')

WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleQuestionCount'), '2')

TestSupport.delay(1)


@com.kms.katalon.core.annotation.SetUp
def setup() 
{
   'Get the instance of the test support class'
   TestSupport support = TestSupport.getInstance()

   'Log into the portal'
   support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() 
{
   'Delete our module and use SharedTestData since we are in teardown'
   SharedTestData data = SharedTestData.getInstance()
   data.deleteContentModule('PCTE Test ' + testCode)
    
   'Get the instance of the test support class'
   TestSupport support = TestSupport.getInstance()

   'Log out of the portal'
   support.logout()
}
