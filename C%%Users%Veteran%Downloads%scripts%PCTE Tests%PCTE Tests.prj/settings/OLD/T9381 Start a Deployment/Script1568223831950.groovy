import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testdata.CSVData as CSVData
import com.kms.katalon.core.testdata.reader.CSVSeparator as CSVSeparator
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
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

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

'Hide the Diff panel'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ShowDiffPanel'))

'Click on the new version 1'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_NetworkSpecVersion1'))

'Click on the New Deployment button'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NewDeployment'))

TestSupport.delay(1)

'Set the name of the deployment according to configuration parameters'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_DeploymentName'), deploymentName)

TestSupport.delay(2)

'Hit the \'TAB\' key to take focus away from the deployment name text box. This is a kludge necessary for the \'Create\' button to appear'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Content_DeploymentName'), Keys.chord(Keys.TAB))

TestSupport.delay(5)

'Click on the Create button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_DeploymentCreate'))

TestSupport.delay(5)

'Open the network range selection dropdown'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_RangeControlSelectArrow'))

'Pick the first valid option on this list.'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_RangeControlFirstOption'))

TestSupport.delay(2)

'Click on the Review Deployment tab'
WebUI.click(findTestObject('Page_PCTE Portal/li_Content_ReviewDeployment'))

'Wait for the VM list to load'
WebUI.delay(5)

'Set up the VM configuration according to the configuration CSV file'
CustomKeywords.'edu.ucf.irl.ConfigureVMDeploymentKeyword.ConfigureVMDeployment'(new CSVData((RunConfiguration.getProjectDir() + 
    '/Data Files/') + vmConfigurationFilename, true, CSVSeparator.COMMA))

TestSupport.delay(5)

'Open the Summary tab of the Deployment dialog'
WebUI.click(findTestObject('Page_PCTE Portal/li_Content_DeploymentSummary'))

TestSupport.delay(2)

'Open the Select Event dropdown'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_DeploySelectEvent'))

TestSupport.delay(1)

'Enter the name of the exercise event that was created earlier in the startup function of this test case'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_DeploySelectEvent'), eventName)

TestSupport.delay(1)

'Pick the exercise event'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_DynamicDeployEventItem', [('eventName') : eventName]))

TestSupport.delay(1)

'Click Build Deployment to start the deployment'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_BuildDeployment'))

def currIteration = 0

'Wait while the deployment is being started. The maximum wait time can be set in the test case variables'
while (!(TestSupport.isObjectPresent(findTestObject('Page_PCTE Portal/div_Content_DeploymentCompleted'))) && 
(currIteration < maxDeploymentTime)) {
    WebUI.delay(60)

    currIteration++
}

'Now that deployment is done, it\'s time to verify the range. Open the Apps sidebar'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

TestSupport.delay(2)

'Navigate to the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

TestSupport.delay(2)

'Navigate to the Ranges section of the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_Ranges'))

TestSupport.delay(2)

'Input the name of the range that was deployed in this test case'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_RangeFilter'), deploymentName)

TestSupport.delay(1)

'Click on the deployment'
WebUI.click(findTestObject('Page_PCTE Portal/a_Ranges_DynamicRangeLink', [('text') : deploymentName]))

'Verify that navigation into the range is successful by checking the heading'
WebUI.verifyElementVisible(findTestObject('Page_PCTE Portal/h2_Content_DynamicRangeHeader', [('rangeName') : deploymentName]))

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
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Get the instance of the shared test data class'
    SharedTestData sharedData = SharedTestData.getInstance()

    'Navigate back to the home page to clear any popups'
    WebUI.navigateToUrl(GlobalVariable.portal_url)

    'Wait for the page to load'
    TestSupport.delay(5)

    WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/button_Apps'), 5)

    'Open the Apps menu'
    WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

    TestSupport.delay(2)

    'Click on the Content app'
    WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

    TestSupport.delay(5)

    'Click on the Ranges section'
    WebUI.click(findTestObject('Page_PCTE Portal/span_Content_Ranges'))

    TestSupport.delay(5)

    WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_RangeFilter'), deploymentName)

    TestSupport.delay(5)

    'Check to see if a range was created in this test case'
    if (TestSupport.isObjectPresent(findTestObject('Page_PCTE Portal/a_Ranges_DynamicRangeLink', [('text') : deploymentName]))) {
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

        while ((vmStatus.contains('running') || vmStatus.contains('transitioning')) && (currIter < 30)) {
            WebUI.delay(10)

            'Increment the timer'
            currIter++

            'Get the current status on the VMs in the range'
            vmStatus = WebUI.getText(findTestObject('Page_PCTE Portal/span_Content_RangesVMStatus'))
        }
    }
    
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

