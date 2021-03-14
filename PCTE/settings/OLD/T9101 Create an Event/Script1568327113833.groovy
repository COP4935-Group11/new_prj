import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import edu.ucf.irl.SharedTestData as SharedTestData
import edu.ucf.irl.TestSupport as TestSupport
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Wait for the Apps button to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)

'Click on the apps button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the Apps dashboard to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)

'Click on the Events app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

'Wait for the Schedule Event dropdown button to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_ScheduleEventDropdown'), 30)

'Click on the Schedule Event dropdown button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Events_ScheduleEventDropdown'))

'Wait for the Schedule Exercise Event button to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_ScheduleExerciseEvent'), 30)

'Click on the ScheduleExercise Event button'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events_ScheduleExerciseEvent'))

'Enter the name of the new event as per the parameter'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Admin_NewEventName'), eventName)

'Enter a description for the new event'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Events_NewEventDescription'), 'This event was created by an automated script')

'This is a workaround because clicking on the Create Event button does not work currently'

'It marks the step as completed but does not actually click'
WebUI.focus(findTestObject('Page_PCTE Portal/button_Admin_CreateEventFinalize'))

'Delay for a second'
TestSupport.delay(1)

WebUI.sendKeys(findTestObject('Page_PCTE Portal/button_Admin_CreateEventFinalize'), Keys.chord(Keys.ENTER))

'Wait for the event to be created'
TestSupport.delay(2)

'Navigate to the homepage to clear any popups'
WebUI.navigateToUrl(GlobalVariable.portal_url)

'Wait for the page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)

'Click on the apps button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the Apps dashboard to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)

'Click on the Events app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

'Wait for the search filter to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)

'Enter the name of the event that was just created into the search filter'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

'Wait for the event item to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]), 30)

'View the newly-created event'
WebUI.click(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]), FailureHandling.STOP_ON_FAILURE)

'Wait for the event page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_Management'), 30)

'Click on the Management tab'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events_Management'))

'Wait for the page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Admin_DynamicEventTitle', [('eventName') : eventName]), 
    30)

'Verify that the correct event is being viewed, thus verifying its creation'
WebUI.verifyElementPresent(findTestObject('Page_PCTE Portal/h1_Admin_DynamicEventTitle', [('eventName') : eventName]), 10)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log into the portal'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Get the instance of the shared test data class'
    SharedTestData sharedData = SharedTestData.getInstance()

    'Archive the event that was potentially created during this test'
    sharedData.archiveExerciseEvent(eventName)

    'Log out of the portal'
    support.logout()
}

