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
import edu.ucf.irl.TestSupport as TestSupport
import com.kms.katalon.core.testobject.ConditionType as ConditionType

'Select the Create (+) button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

'Wait for the Create Lab Event button to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateLabEvent'), 30)

'Click on "Lab Event"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateLabEvent'))

'Briefly wait for Create Event page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Events_NewEvent'), 30)

'Verify "New Event" label exists on page (so we got to the page)'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Events_NewEvent'), 'New Event')

'Briefly wait to ensure page loaded'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)

'Select the Create (+) button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

'Briefly wait for submenu to open'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateExerciseEvent'), 30)

'Click on "Exercise Event"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateExerciseEvent'))

'Briefly wait for Create Event page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Events_CreateExerciseEvent'), 30)

'Verify "New Event" label exists on page (so we got to the page)'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Events_CreateExerciseEvent'), 'Create Exercise Event')

'Close the Create Exercise Event popup'
WebUI.click(findTestObject('Page_PCTE Portal/button_Events_ClosePopup'))

'Briefly wait to ensure page loaded'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)

'Select the Create (+) button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

'Briefly wait for submenu to open'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateNetworkSpec'), 30)

'Click on "Network Spec"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateNetworkSpec'))

'Briefly wait for Create Network Spec page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewNetworkSpec'), 30)

'Verify "New Network Spec Wizard" label exists on page (so we got to the page)'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewNetworkSpec'), 'Network Spec Wizard')

'Close wizard'
WebUI.click(findTestObject('Page_PCTE Portal/i_NetworkSpecWizard_Close'))

'Wait to make sure popup closes'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_NetworkSpecWizard_Exit'), 30)

'Yes we are sure'
WebUI.click(findTestObject('Page_PCTE Portal/button_NetworkSpecWizard_Exit'))

'Wait to make sure popup closes'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)

'Select the Create (+) button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

'Briefly wait for Create VM Template page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateVMTemplate'), 30)

'Click on "VM Template"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateVMTemplate'))

'Briefly wait for Create VM Template page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewVMTemplate'), 30)

'Verify "New VM Template" label exists on page (so we got to the page)'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewVMTemplate'), 'New VM Template')

'Close VM template create tool'
WebUI.click(findTestObject('Page_PCTE Portal/i_NewVMTemplate_Close'))

'Wait to make sure popup closes'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)

'Select the Create (+) button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

'Briefly wait for Create Physical Asset page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreatePhysicalAsset'), 30)

'Click on "Physical Asset"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreatePhysicalAsset'))

'Briefly wait for Create Physical Asset page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewPhysicalAsset'), 30)

'Verify "New Physical Asset" label exists on page (so we got to the page)'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewPhysicalAsset'), 'New Physical Asset')

'Briefly wait to ensure page loaded'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)

'Select the Create (+) button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

'Briefly wait for Create Content Module page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateContentModule'), 30)

'Click on "Content Module"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateContentModule'))

'Briefly wait for Create Content Module page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewContentModule'), 30)

'Verify "New Module" label exists on page (so we got to the page)'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewContentModule'), 'New Module')

'Briefly wait to ensure page loaded'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)

'Select the Create (+) button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

'Briefly wait for Create Training Package page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateTrainingPackage'), 30)

'Click on "Training Package"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateTrainingPackage'))

'Briefly wait for Create Training Package page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewTrainingPackage'), 30)

'Verify "Create Package" label exists on page (so we got to the page)'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewTrainingPackage'), 'Create Package')

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
    
    'Log out of the portal'
    support.logout()
}

