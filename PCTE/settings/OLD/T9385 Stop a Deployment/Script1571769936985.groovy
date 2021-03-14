import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import edu.ucf.irl.SharedTestData as SharedTestData
import edu.ucf.irl.TestSupport as TestSupport
import internal.GlobalVariable as GlobalVariable

'Navigate back to the home page to clear any popups'
WebUI.navigateToUrl(GlobalVariable.portal_url)

'Wait for the page to load'
TestSupport.delay(5)

'Wait for the Apps button to be clickable'
WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/button_Apps'), 5)

'Open the Apps menu'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the apps dashboard to load'
TestSupport.delay(2)

'Click on the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

'Wait for the page to load'
TestSupport.delay(5)

'Click on the Ranges section'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_Ranges'))

'Wait for the page to load'
TestSupport.delay(5)

'Input the name of the deployment into the range filter'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_RangeFilter'), deploymentName)

'Wait for the filtering to finish'
TestSupport.delay(5)

'Enter the range'
WebUI.click(findTestObject('Page_PCTE Portal/a_Ranges_DynamicRangeLink', [('text') : deploymentName]))

TestSupport.delay(2)

'Click the Stop Network button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_RangesStopNetwork'))

TestSupport.delay(2)

'Click the confirm button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_RangesStopNetworkConfirm'))

'Check the status span to see if any VMs are still running or shutting down, and delay until all are shut down'
String vmStatus = WebUI.getText(findTestObject('Page_PCTE Portal/span_Content_RangesVMStatus'))

'Keep waiting until all VMs are stopped or the maximum time of 5 minutes is reached'
def currIter = 0

while ((vmStatus.contains('running') || vmStatus.contains('transitioning')) && (currIter < 360)) {
	WebUI.delay(10)

	'Increment the timer'
	currIter++

	'Get the current status on the VMs in the range'
	vmStatus = WebUI.getText(findTestObject('Page_PCTE Portal/span_Content_RangesVMStatus'))
}

'Check to see if the range has fully stopped'
if (vmStatus.contains('running') || vmStatus.contains('tranistioning')) {
	'Indicate that the stopping of the range has failed'
	KeywordUtil.markFailed('Failed to stop range within time limit')
}
else {
	'Indicate that the stopping of the range has succeeded'
	KeywordUtil.markPassed('Successfully stopped range')
}

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

