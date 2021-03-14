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
import edu.ucf.irl.SharedTestData as SharedTestData
import edu.ucf.irl.TestSupport as TestSupport

'Reset the portal so that it is fresh and ready.'
WebUI.navigateToUrl(GlobalVariable.portal_url)

'Wait for the website to load.'
TestSupport.delay(2)

'Open the dashboard to select the appropriate application.'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the dashboard to display.'
TestSupport.delay(2)

'Select the Admin application.'
WebUI.click(findTestObject('Page_PCTE Portal/span_Apps_Admin'))

'Wait for the Admin application to finish loading.'
TestSupport.delay(2)

'Select the event that was created for this test.'
WebUI.click(findTestObject('Page_PCTE Portal/button_Admin_DynamicViewEditEvent', [('eventName') : eventName]))

'Wait for the event to load'
TestSupport.delay(2)

'Navigate to the user role tab of the event.'
WebUI.click(findTestObject('Page_PCTE Portal/li_Admin_EventRoles'))

'Wait for the role tab to load.'
TestSupport.delay(2)

'Select the participant that will be added to a role.'
WebUI.click(findTestObject('Page_PCTE Portal/li_Admin_RoleParticipantSelection'))

'Wait for the assign selected button to appear.'
TestSupport.delay(1)

'Click the assign selected button in order to add the selected participant to the selected role.'
WebUI.click(findTestObject('Page_PCTE Portal/button_Admin_AssignSelectedRole'))

'Return to the start of the portal to for confirmation that the role was assigned.'
WebUI.navigateToUrl(GlobalVariable.portal_url)

'Wait for the portal to load.'
TestSupport.delay(2)

'Open the dashboard.'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the dashboard to load'
TestSupport.delay(2)

'Select the Admin application'
WebUI.click(findTestObject('Page_PCTE Portal/span_Apps_Admin'))

'Wait for the Admin application to load'
TestSupport.delay(2)

'Select the event that has the user role assigned.'
WebUI.click(findTestObject('Page_PCTE Portal/button_Admin_DynamicViewEditEvent', [('eventName') : eventName]))

'Wait for the event to load'
TestSupport.delay(2)

'Navigate to the event roles page'
WebUI.click(findTestObject('Page_PCTE Portal/li_Admin_EventRoles'))

'Wait for the roles tab to load'
TestSupport.delay(2)

'Verify that the test user has been assigned to a role.'
WebUI.verifyElementVisible(findTestObject('Page_PCTE Portal/li_Admin_ParticipantHasRole'))

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

