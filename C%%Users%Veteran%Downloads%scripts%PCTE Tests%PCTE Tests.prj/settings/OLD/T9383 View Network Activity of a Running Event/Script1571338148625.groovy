import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import edu.ucf.irl.SharedTestData as SharedTestData
import edu.ucf.irl.TestSupport as TestSupport
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Open the app selector'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the range to be clickable or the test will fail in chrome'
TestSupport.delay(3)

'Select the range app from the app selector'
WebUI.click(findTestObject('Page_PCTE Portal/span_Apps_Content'))

'Open the network selector'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_Ranges'))

'Wait for the desired range to become available'
WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/a_Ranges_DynamicRangeLink', [('text') : deploymentName]), 
    20)

'Select the range based on the execution profile'
WebUI.click(findTestObject('Page_PCTE Portal/a_Ranges_DynamicRangeLink', [('text') : deploymentName]))

TestSupport.delay(5)

'Form the xpath for a generic "View Console" button'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Ranges_VMFilter'), consoleName)

'Wait 5 seconds for the filtering to finish'
TestSupport.delay(5)

'Click on the "View Console" button'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_DynamicRangeViewConsole', [('consoleName') : consoleName]))

'Wait for the window to launch'
TestSupport.delay(5)

'Switch the newly launched console window'
WebUI.switchToWindowTitle((('PCTE Portal (Console): ' + deploymentName) + ', ') + consoleName)

'Wait for the canvas element containing the VM console to appear'
WebUI.waitForElementVisible(findTestObject('Page_PCTE Portal/canvas_Range_MainCanvas'), 180, FailureHandling.OPTIONAL)

'Close the console window'
WebUI.closeWindowTitle((('PCTE Portal (Console): ' + deploymentName) + ', ') + consoleName)

TestSupport.delay(1)

'Switch back to the main window'
WebUI.switchToWindowTitle('PCTE Portal')

'Navigate to the home page'
WebUI.navigateToUrl(GlobalVariable.portal_url)

'Wait for the page to load'
TestSupport.delay(3)

'Open the apps dashboard'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the dashboard to open'
TestSupport.delay(1)

'Go to the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Apps_Content'))

'Wait for the page to load'
TestSupport.delay(2)

'Go to the Ranges section of the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_Ranges'))

'Wait for the page to load'
TestSupport.delay(2)

'Input the name of the range into the range filter'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_RangeFilter'), deploymentName)

'Wait for the desired range to become available'
WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/a_Ranges_DynamicRangeLink', [('text') : deploymentName]), 
    20)

'Select the range based on the parameters'
WebUI.click(findTestObject('Page_PCTE Portal/a_Ranges_DynamicRangeLink', [('text') : deploymentName]))

'Wait for the range to load'
TestSupport.delay(5)

'Go to the Network Activity section of the range'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_RangeNetworkActivity'))

'Wait for the page to load'
TestSupport.delay(1)

'Verify that the VM Consoled action is being displayed'
WebUI.verifyElementVisible(findTestObject('Page_PCTE Portal/td_Content_RangeNetActivityAction'))

'Verify that the action is being displayed for the correct VM'
WebUI.verifyElementVisible(findTestObject('Page_PCTE Portal/td_Content_DynamicRangeNetActivityVM', [('consoleName') : consoleName]))

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Get the instance of the shared test data class'
    SharedTestData sharedData = SharedTestData.getInstance()

    'Log into the portal'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Create a new event in which the network will be deployed'
    sharedData.createExerciseEvent(eventName)

    'Wait for the event to be created'
    TestSupport.delay(2)

    'Navigate to the event Participants tab'
    WebUI.click(findTestObject('Page_PCTE Portal/li_Admin_EventParticipants'))

    TestSupport.delay(2)

    'Find the user performing this test'
    WebUI.setText(findTestObject('Page_PCTE Portal/input_Admin_EventParticipantFilter'), GlobalVariable.orgadmin_name)

    TestSupport.delay(2)

    'Add this user as an admin to the event'
    WebUI.click(findTestObject('Page_PCTE Portal/div_Admin_EventPermission'))

    TestSupport.delay(1)

    WebUI.click(findTestObject('Page_PCTE Portal/div_Admin_EventAdminItem'))

    TestSupport.delay(2)

    'Navigate to the Roles tab'
    WebUI.click(findTestObject('Page_PCTE Portal/li_Admin_EventRoles'))

    TestSupport.delay(2)

    'Select the participant from the list'
    WebUI.click(findTestObject('Page_PCTE Portal/div_Admin_DynamicParticipantItem', [('participantName') : GlobalVariable.orgadmin_name]))

    'Assign the selected role to the participant'
    WebUI.click(findTestObject('Page_PCTE Portal/button_Admin_EventAssignSelected'))

    'Create the network spec for this test'
    sharedData.createAndImportNetworkSpec(networkSpecName, yamlFilename)

    'Wait for the network spec to be created'
    TestSupport.delay(2)

    'Go back to the main page of the HardHat project'
    WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ProjectHome'))

    'Show the Commit/Diff Panel'
    WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ShowDiffPanel'))

    'Wait 3 seconds for the panel to appear'
    WebUI.delay(3)

    'Click the Save button in the Show Diff/Commit Panel'
    WebUI.click(findTestObject('Page_PCTE Portal/span_Content_DiffPanelSave'))

    'Delay 3 seconds for the save to finish'
    TestSupport.delay(3)

    'Click the Commit button'
    WebUI.click(findTestObject('Page_PCTE Portal/span_Content_DiffPanelCommit'))

    'Wait 3 seconds for the commit to finish'
    WebUI.delay(3)

    'Confirm the commit'
    WebUI.click(findTestObject('Page_PCTE Portal/span_Content_CommitConfirm'))

    'Delay 3 seconds for the commit to be accepted'
    TestSupport.delay(3)

    sharedData.createDeployment(networkSpecName, deploymentName, eventName, vmConfigurationFilename, maxDeploymentTime)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Get the instance of the shared test data class'
    SharedTestData sharedData = SharedTestData.getInstance()
	
	'Close the console window if it is still open'
	WebUI.closeWindowTitle((('PCTE Portal (Console): ' + deploymentName) + ', ') + consoleName, FailureHandling.OPTIONAL)
	
	'Wait for the window to close'
	TestSupport.delay(1)
	
	'Switch back to the main window'
	WebUI.switchToWindowTitle('PCTE Portal')

    'Stop the range that may have been launched in the test case'
    sharedData.stopRange(deploymentName)

    'Delete the event that was potentially created'
    sharedData.archiveExerciseEvent(eventName)

    'Delete the deployment that was potentially created'
    sharedData.deleteDeployment(networkSpecName, deploymentName)

    'Wait for the deployment to be deleted'
    TestSupport.delay(10)

    'Delete the network spec that was potentiallycreated'
    sharedData.deleteNetworkSpec(networkSpecName)

    'Log out of the portal'
    support.logout()
}

