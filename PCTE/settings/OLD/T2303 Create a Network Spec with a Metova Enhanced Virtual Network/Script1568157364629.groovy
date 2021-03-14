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
import edu.ucf.irl.TestSupport as TestSupport
import edu.ucf.irl.SharedTestData as SharedData
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Click on the application button in the upper left corner.'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for a short while to make sure the application pullout has fininshed rendering and is ready for commands.'
TestSupport.delay(3)

'Select the content application this navigates to the main content page.'
WebUI.click(findTestObject('Page_PCTE Portal/icon_Apps_Content'))

'Click on the create content button.'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'))

'Select the create network spec from the dropdown menu that the create button revealed.'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewWizardSpec'))

'Set the name of the network inside of the easy wizard.'
WebUI.setText(findTestObject('Page_PCTE Portal/input_EasyWizard_OverviewName'), 'Metova250')

'Set the text of the description for the new network being created.'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_EasyWizard_OverviewDescription'), 'Automated creation of Simspace network.')

'This moves the easy wizard to the internet setup of the network.'
WebUI.click(findTestObject('Page_PCTE Portal/button_EasyWizard_ProceedToInternet'))

'Select the simspace network from the list of networks.'
WebUI.click(findTestObject('Page_PCTE Portal/div_EasyWizard_MetovaVirtualInternetEnhanced'))

'Move the easy wizard forward to the orginizations.'
WebUI.click(findTestObject('Page_PCTE Portal/button_EasyWizard_ProceedToOrganizations'))

'Create a name for the orginization.'
WebUI.setText(findTestObject('Page_PCTE Portal/input_EasyWizard_OrganizationName'), 'metova_network')

'Create a name for the external network elements.'
WebUI.setText(findTestObject('Page_PCTE Portal/input_EasyWizard_ExternalDomainName'), 'ext_metova')

'Create a name for the internal network elements.'
WebUI.setText(findTestObject('Page_PCTE Portal/input_EasyWizard_InternalDomainName'), 'int_metova')

'Move to the next Boundary Defense section of the orginization setup.'
WebUI.click(findTestObject('Page_PCTE Portal/button_EasyWizard_SetupNext'))

'Delay for a bit to allow the boundary defense to render and become clickable.'
TestSupport.delay(2)

'Move on to the Infastructure of the new network.'
WebUI.click(findTestObject('Page_PCTE Portal/button_EasyWizard_BoundaryDefenseNext'))

'Delay for a bit to allow the Infastructure section to render and become clickable.'
TestSupport.delay(2)

'Move on to the client subnets setup and this doesn\'t need a delay as the text input doesn\'t need to wait for the section to render.'
WebUI.click(findTestObject('Page_PCTE Portal/button_EasyWizard_InfrastructureNext'))

'Create a name for the windows 7 clients that will be in the network.'
WebUI.setText(findTestObject('Page_PCTE Portal/input_EasyWizard_ClientSubnetNameWin7'), 'win7client')

'Create a prefix for the windows 7 clients this needs to be all lower case, otherwise the machine names will be invalid.'
WebUI.setText(findTestObject('Page_PCTE Portal/input_EasyWizard_ClientPrefixWin7'), 'win7client')

'Set the number of clients to 128 as this will make sure that there is at least 250 VM\'s'
WebUI.setText(findTestObject('Page_PCTE Portal/input_EasyWizard_CountWin7'), '128')

'Add a second client group as the first client group can\'t have more than the 128 clients. '
WebUI.click(findTestObject('Page_PCTE Portal/button_EasyWizard_AddClientGroup'))

'Create a name for the windows 10 client group of systems.'
WebUI.setText(findTestObject('Page_PCTE Portal/input_EasyWizard_ClientSubnetNameWin10'), 'win10client')

'Create a prefix for all the windows 10 clients and this also needs to be all lower case, otherwise the machine names will be invalid.'
WebUI.setText(findTestObject('Page_PCTE Portal/input_EasyWizard_ClientPrefixWin10'), 'win10client')

'Set the number of clients to 128 as this will make sure that there is at least 250 VM\'s'
WebUI.setText(findTestObject('Page_PCTE Portal/input_EasyWizard_CountWin10'), '128')

'Change the client VM\'s to windows 10 instead of windows 7. This will also need to change later when we can create linux clients in the easy wizard.'
WebUI.selectOptionByLabel(findTestObject('Page_PCTE Portal/input_EasyWizard_OSWin10'), 'Windows 10', false)

'Move to the last section of the orginization setup.'
WebUI.click(findTestObject('Page_PCTE Portal/button_EasyWizard_ClientSubnetGroupsNext'))

'Delay for a second to give the section a chance to render and make the elements clickable.'
TestSupport.delay(2)

'Move on to the review of the network.'
WebUI.click(findTestObject('Page_PCTE Portal/button_EasyWizard_OrganizationsNext'))

'Delay a bit to allow the finalize button to render and become clickable.'
TestSupport.delay(2)

'Finalize the network and it will be built as a blueprint.'
WebUI.click(findTestObject('Page_PCTE Portal/button_EasyWizard_FinalizeNetwork'))

'Delay for a bit longer as it takes time for the network to be fully setup. It is currently set to 10 seconds, but could probably be a bit shorter.'
TestSupport.delay(10)

'Select the VM\'s section of the network because there is an issue with the network where the dhcp is set to the same ip address as one of the client machines.'
WebUI.click(findTestObject('Page_PCTE Portal/span_HardHat_VMs'))

'Find the dhcp machine.'
WebUI.click(findTestObject('Page_PCTE Portal/div_Hardhat_control-dhcp'))

'Switch to the networking tab that will allow us to change the ip address.'
WebUI.click(findTestObject('Page_PCTE Portal/li_Hardhat_Networking'))

'Select the ip address text box which currently has text that won\'t be selected or deleted.'
WebUI.click(findTestObject('Page_PCTE Portal/input_Hardhat_IP_Address'))

'Send the keys to select all the text of the ip address.'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Hardhat_IP_Address'), Keys.chord(Keys.CONTROL, 'a'))

'Hit backspace on the ip address in order to clear out the old ip address.'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Hardhat_IP_Address'), Keys.chord(Keys.BACK_SPACE))

'Now that the ip address has been deleted enter the new ip address for the dhcp.'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Hardhat_IP_Address'), '10.10.1.254')

'Bring up the diff panel so that the changes that were just made can be committed.'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ShowDiffPanel'))

'Delay to allow the diff screen to appear and become clickable.'
TestSupport.delay(1)

'Hit the save button to save the dhcp ip address change to be committed.'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_DiffPanelSave'))

'Hit the commit button to commit the dhcp change and to create the first version of the network so that it can be deployed.'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_DiffPanelCommit'))

'Delay for a second to allow the confirmation pop up to appear and become clickable.'
TestSupport.delay(2)

'Confirm that the changes should be committed.'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_CommitConfirm'))

'Delay to allow the system to update with the committed changes.'
TestSupport.delay(2)

'The diff panel can hide buttons so click the hide button to hide the panel.'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ShowDiffPanel'))

'Return to the homepage of the current network where the deployments happen.'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ProjectHome'))

'Make sure the validate button is available to be clicked.'
WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/button_HardHat_Validate'), 15)

'Click the validate button to make sure that the network is fully ready for deployment.'
WebUI.click(findTestObject('Page_PCTE Portal/button_HardHat_Validate'))

'Delay for a bit as the pop up tries to verify the validity of the network. It has a message letting the user know that something is happening and changes when the validation has finished.'
TestSupport.delay(20)

'Look to make sure that there are no errors in the network.'
WebUI.verifyTextPresent('No errors found.', false)

'Close the validate popup window.'
WebUI.click(findTestObject('Page_PCTE Portal/button_Validate_Close'))

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
	SharedData data = SharedData.getInstance();

	'Make sure that the validation window is closed if the validation happened to fail'
    if (WebUI.verifyElementClickable(findTestObject('Page_PCTE Portal/button_Validate_Close'), FailureHandling.CONTINUE_ON_FAILURE)) {
        WebUI.click(findTestObject('Page_PCTE Portal/button_Validate_Close'))
    }
    
	'Delete the metova network spec that was created by the test'
	data.deleteNetworkSpec("Metova250");

    'Log out of the portal'
    support.logout()
}

