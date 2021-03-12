import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import edu.ucf.irl.SharedTestData as SharedTestData
import edu.ucf.irl.TestSupport as TestSupport
import internal.GlobalVariable as GlobalVariable

'Click on the application button in the upper left corner'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait briefly for the apps menu to load'
TestSupport.delay(3)

'Click on the Content icon'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

'Click on the Network Spec section of the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'))

TestSupport.delay(3)

'Click on the Ellipses button to open more options for network spec creation'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewSpecEllipsis'))

'Create a new empty network spec'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NewEmptySpec'))

'Input the name of the new project based on the configuration parameter'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_NewSpecName'), networkSpecName)

TestSupport.delay(1)

'Click the Create Customer Project button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_CreateProject'))

'Click the Import button to import the YAML definition'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ImportDefinition'))

'Send the file path of the YAML configuration file'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Content_UploadYAMLFile'), (RunConfiguration.getProjectDir() + '/Data Files/') + 
    yamlFile)

'Wait 5 seconds for the upload to finish\r\nThis may require a larger delay based on the complexity of the configuration file used'
TestSupport.delay(5)

'Click on the finalize upload button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_FinalizeYAMLUpload'), FailureHandling.STOP_ON_FAILURE)

'Wait 5 seconds for the upload to finish\r\nThis may require a larger delay based on the complexity of the configuration file used'
TestSupport.delay(5)

'Verify that the upload finalized successfully by checking that the heading is visible'
WebUI.verifyElementVisible(findTestObject('Page_PCTE Portal/h1_Content_UploadTestHeading', [('specName') : networkSpecName]))

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

    'Navigate back to the home page to ensure that no popups are in the way'
    WebUI.navigateToUrl(GlobalVariable.portal_url)

    'Wait 5 seconds for the page to load'
    TestSupport.delay(5)

    'Delete the network spec that was potentially created in this test case'
    sharedData.deleteNetworkSpec(networkSpecName)

    'Log out of the portal'
    support.logout()
}

