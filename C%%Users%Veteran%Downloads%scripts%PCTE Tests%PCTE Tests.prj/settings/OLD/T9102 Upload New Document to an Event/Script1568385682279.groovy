import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
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

'Go to the home page'
WebUI.navigateToUrl(GlobalVariable.portal_url);

'Wait for the Apps dashboard button to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)

'Click on the Apps button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait for the Events app to appear'
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

'Wait for the Management page to load'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Admin_UploadNewDocument'), 30)

'Click on the Upload button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Admin_UploadNewDocument'))

'Wait for the upload popup to appear'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Admin_DocumentUpload'), 30)

'Enter the filepath of the document to be uploaded'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Admin_DocumentUpload'), (RunConfiguration.getProjectDir() + '/Data Files/') + 
    documentName)

'Wait for the Import button to be enabled'
WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/button_Admin_ImportDocument'), 30)

'Click on the Import button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Admin_ImportDocument'))

'Wait for the import to finish'
WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Admin_DynamicDocumentationItem', [('documentName') : documentName]), 30)

'Verify that the item was uploaded successfully by checking the documentation item list'
WebUI.verifyElementVisible(findTestObject('Page_PCTE Portal/div_Admin_DynamicDocumentationItem', [('documentName') : documentName]))

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

