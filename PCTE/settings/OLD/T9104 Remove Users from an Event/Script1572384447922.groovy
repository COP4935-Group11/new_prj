import edu.ucf.irl.SharedTestData as SharedTestData
import edu.ucf.irl.TestSupport as TestSupport
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import org.openqa.selenium.Keys as Keys

'First verify that the user can enter the event. Get an instance of test support for login/logout'
TestSupport support = TestSupport.getInstance()

'Log out of the admin user'
support.logout()

'Log in as the participating user'
support.login(GlobalVariable.user1_username, GlobalVariable.user1_password)

'Wait for the Apps button to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)

'Click on the Apps button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the Apps dashboard to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)

'Click on the Events app button'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

'Wait for the Events page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)

'Enter the name of the newly-created event into the search box'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

'Wait for the event item to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]), 30)

'View the newly-created event'
WebUI.click(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]))

'Instantiate the test object that will be used for verification of the event participation'
TestObject eventHeader = findTestObject('Page_PCTE Portal/span_Events_DynamicEventHeader', [('eventName') : eventName])

'Wait for the event page to load'
WebUI.waitForElementPresent(eventHeader, 30, FailureHandling.OPTIONAL)

'Verify that the event page loaded correctly for the user'
WebUI.verifyElementPresent(eventHeader, 10)

'Log out of the current user'
support.logout()

'Log back into the admin user for clean up'
support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

'Wait for the Apps button to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)

'Click on the Apps button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the Apps dashboard to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)

'Click on the Events app button'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

'Wait for the Events page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)

'Enter the name of the newly-created event into the search box'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

'Wait for the event item to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]), 30)

'View the newly-created event'
WebUI.click(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]))

'Wait for the event page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_Management'), 30)

'Click on the Management tab'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events_Management'))

'Wait for the Managment tab to open'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_EventParticipants'), 30)

'Click on the Participants tab'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events_EventParticipants'))

'Wait for the participants page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_EditParticipants'), 30)

'Open the Edit Participant dialog'
WebUI.click(findTestObject('Page_PCTE Portal/button_Events_EditParticipants'))

'Wait for the participant dialog to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Admin_EventParticipantFilter'), 30)

'Enter the name of the first user into the participant filter'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Admin_EventParticipantFilter'), GlobalVariable.user1_name)

'Instantiate the test object that will be used for removing the participant'
TestObject removeParticipant = findTestObject('Page_PCTE Portal/button_Events_DynamicRemoveParticipant', [('participantName') : GlobalVariable.user1_name])

'Wait for the event page to load'
WebUI.waitForElementPresent(removeParticipant, 30)

'Remove the participant'
WebUI.click(removeParticipant)

'This is a workaround because clicking the button does not work'
WebUI.focus(findTestObject('Page_PCTE Portal/button_Events_ApplyClose'))

'Send the Enter key to the Apply & Close button to activate it'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/button_Events_ApplyClose'), Keys.chord(Keys.ENTER))

'Wait for the Participant page to load back up'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_SaveChanges'), 30)

'Click on the Save Changes button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Events_SaveChanges'))

'Log out of the admin user'
support.logout()

'Log into the participant user that was just removed'
support.login(GlobalVariable.user1_username, GlobalVariable.user1_password)

'Wait for the Apps button to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)

'Click on the Apps button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the Apps dashboard to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)

'Click on the Events app button'
WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

'Wait for the Events page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)

'Enter the name of the newly-created event into the search box'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

'Verify that the user cannot see the event'
WebUI.verifyElementNotPresent(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]), 30)

'Log out of the participant user'
support.logout()

'Log into the admin user for clean up'
support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)


@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Get the instance of the shared test data class'
    SharedTestData sharedData = SharedTestData.getInstance()

    'Log into the portal'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Create an Admin event for this test'
    sharedData.createExerciseEvent(eventName)

    'Add the first test user to the event that was just created'
    String[] participants = new String[1]
    participants[0] = GlobalVariable.user1_name
    sharedData.addParticipantsToExerciseEvent(eventName, participants)
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

