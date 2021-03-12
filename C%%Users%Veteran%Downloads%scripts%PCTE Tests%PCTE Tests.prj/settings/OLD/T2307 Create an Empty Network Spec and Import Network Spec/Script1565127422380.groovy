import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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


'Click on the application button in the upper left corner'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait briefly for the apps menu to load'
TestSupport.delay(3)

'Click on the Content icon'
WebUI.click(findTestObject('Page_PCTE Portal/icon_Apps_Content'))

'Click on the Network Spec section of the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'))

'Wait for network specs to load'
TestSupport.delay(3)

'Click on the Ellipses button to open more options for network spec creation'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewSpecEllipsis'))

'Create a new empty network spec'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NewEmptySpec'))

'Input the name of the new project based on the configuration parameter'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_NewSpecName'), GlobalVariable.hardhat_project_name)

'Click the Create Customer Project button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_CreateProject'))

'Click the Import button to import the YAML definition'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ImportDefinition'))

'Send the file path of the YAML configuration file'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Content_UploadYAMLFile'), RunConfiguration.getProjectDir() + '\\Data Files\\Grey-Space-Medium-draft.yml')

'Wait up to 3 seconds for the upload button to appear'
WebUI.waitForElementVisible(findTestObject('Page_PCTE Portal/span_Content_UploadYAMLFile'), 3)

'Click on the upload button'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_UploadYAMLFile'))

'Wait 5 seconds for the upload to finish\r\nThis may require a larger delay based on the complexity of the configuration file used'
TestSupport.delay(5)

'Verify that the YAML file was uploaded successfully'
WebUI.verifyElementVisible(findTestObject('Page_PCTE Portal/div_Content_YAMLSuccessfullyImported'), FailureHandling.STOP_ON_FAILURE)

@com.kms.katalon.core.annotation.SetUp
def setup() 
{
   'Get the instance of the test support class'
   TestSupport support = TestSupport.getInstance()

   'Log into the portal'
   support.login(GlobalVariable.username, GlobalVariable.password)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() 
{
   'Get the instance of the test support class'
   TestSupport support = TestSupport.getInstance()

   'Go to network spec project page again to make sure that there are no pop ups getting in the way'
   WebUI.navigateToUrl(GlobalVariable.portal_url + '/index.html#/app/hardhat/library')

   'Check to see if the customer project was successfully created in the test case earlier'
   if (WebUI.verifyElementPresent(findTestObject('Page_PCTE Portal/div_Content_DynamicCustomerProject', [('projectName') : GlobalVariable.hardhat_project_name]), 
        5, FailureHandling.OPTIONAL)) 
   {
      'Click on the customer project that was created earlier'
      WebUI.click(findTestObject('Page_PCTE Portal/div_Content_DynamicCustomerProject', [('projectName') : GlobalVariable.hardhat_project_name]))

      TestSupport.delay(3)

      'Delete the current network that was created'
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_DeleteCustomerProject'))

      'Wait for the confirmation window to display the confirmation delete button'
      WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/button_HardHat_Yes_Delete_Project'), 15)

      'Confirm the deletion of the current network that was created'
      WebUI.click(findTestObject('Page_PCTE Portal/button_HardHat_Yes_Delete_Project'))
   }
    
   'Log out of the portal'
   support.logout()
}
