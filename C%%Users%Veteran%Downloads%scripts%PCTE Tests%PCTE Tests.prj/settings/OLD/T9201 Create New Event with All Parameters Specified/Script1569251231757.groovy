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

'Select the Events area (app)'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

'Delay for a second'
TestSupport.delay(1)

'Click "Schedule New Event"'
WebUI.click(findTestObject('Page_PCTE Portal/a_Events_ScheduleNewEvent'))

'Delay for a second'
TestSupport.delay(1)

'Set the name'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventName'), 'PCTE Test ' + testCode)

'Delay for a second'
TestSupport.delay(1)

'Enter the training package to use'
WebUI.setText(findTestObject('Page_PCTE Portal/div_Events_NewEventSpecificTrainingPackage'), 'PCTE Test ' + testCode)

'Delay for a second'
TestSupport.delay(1)

'Hit enter'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/div_Events_NewEventSpecificTrainingPackage'), Keys.chord(Keys.ENTER))

'Delay for a second'
TestSupport.delay(1)

'Set the description'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Events_NewEventDescription'), ('PCTE Test ' + testCode) + ' Description')

'Delay for a second'
TestSupport.delay(1)

'Enable using the leaderboard'
WebUI.click(findTestObject('Page_PCTE Portal/i_Events_NewEventEnableLeaderboard'))

'Enable revealing answers'
WebUI.click(findTestObject('Page_PCTE Portal/i_Events_NewEventEnableRevealingAnswers'))

'Enable using randomized questions'
WebUI.click(findTestObject('Page_PCTE Portal/i_Events_NewEventEnableRandomizedQuestions'))

'Enable using the survey module'
WebUI.click(findTestObject('Page_PCTE Portal/i_Events_NewEventEnableSurveyModule'))

'Delay for a second'
TestSupport.delay(1)

'Enter which survey to use'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventSpecifiedSurveyModule'), ('PCTE Test ' + testCode) + 
    ' Survey')

'Delay for a second'
TestSupport.delay(1)

'Hit enter'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventSpecifiedSurveyModule'), Keys.chord(Keys.ENTER))

'Delay for a second'
TestSupport.delay(1)

'Switch to participants pane'
WebUI.click(findTestObject('Page_PCTE Portal/div_Events_EventParticipants'))

'Add test user 1'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), GlobalVariable.user1_name)

'Hit enter'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), Keys.chord(Keys.ENTER))

'Delay for a second'
TestSupport.delay(1)

'Add test user 2'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), GlobalVariable.user2_name)

'Hit enter'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), Keys.chord(Keys.ENTER))

'Delay for a second'
TestSupport.delay(1)

'Switch to schedule pane'
WebUI.click(findTestObject('Page_PCTE Portal/div_Events_Schedule'))

'Delay for a second'
TestSupport.delay(1)

'Click on today'
WebUI.click(findTestObject('Page_PCTE Portal/div_Events_ScheduleToday'))

'Delay for a second'
TestSupport.delay(1)

'Focus on the start time'
WebUI.click(findTestObject('Page_PCTE Portal/input_Events_ScheduleStartTime'))

'Advance start time by one hour'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events_ScheduleAdvanceMinuteStart'))

'Delay for a second'
TestSupport.delay(1)

'Save the schedule'
WebUI.click(findTestObject('Page_PCTE Portal/button_Events_ScheduleSave'))

'Delay for a second'
TestSupport.delay(1)

'Create the event!'
WebUI.click(findTestObject('Page_PCTE Portal/button_Events_CreateEvent'))

'Delay for a second'
TestSupport.delay(1)

'Open the Dashboard (apps)'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Delay for a second for Dashboard to open'
TestSupport.delay(1)

'Select the Events area (app)'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

'Delay for a second'
TestSupport.delay(1)

'Search for event'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 'PCTE Test ' + testCode)

'Open our new event'
WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : 'PCTE Test ' + testCode]))

'Wait one second'
TestSupport.delay(1)

'Verify event name'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Events_EventName'), 'PCTE Test ' + testCode)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log into the portal'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Create a survey module to use'
    SharedTestData data = SharedTestData.getInstance()

    data.createSurveyModule(('PCTE Test ' + testCode) + ' Survey')

    TestSupport.delay(3)

    'Create a training package to use'
    data.createContentModule(('PCTE Test ' + testCode) + ' Module')

    TestSupport.delay(3)

    data.createTrainingPackage('PCTE Test ' + testCode, ('PCTE Test ' + testCode) + ' Module')

    TestSupport.delay(3)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Delete survey module we made'
    SharedTestData data = SharedTestData.getInstance()

    'Delete the lab event we tested'
    data.deleteLabEvent('PCTE Test ' + testCode)

    TestSupport.delay(1)

    'Delete the training package we made'
    data.deleteTrainingPackage('PCTE Test ' + testCode)

    TestSupport.delay(1)

    'Delete the content module we made'
    data.deleteSurveyModule(('PCTE Test ' + testCode) + ' Survey')

    TestSupport.delay(1)

    'Delete the survey module we made'
    data.deleteContentModule(('PCTE Test ' + testCode) + ' Module')

    TestSupport.delay(1)

    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log out of the portal'
    support.logout()
}

