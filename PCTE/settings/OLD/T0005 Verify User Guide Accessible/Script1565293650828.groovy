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


'Open user menu'
WebUI.click(findTestObject('Page_PCTE Portal/div_User'))

'Briefly wait for user menu to open'
TestSupport.delay(1)

'Select user guide'
WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_UserGuide'))

'Briefly wait for user guide to open'
TestSupport.delay(1)

'Switch to window/tab with user guide'
WebUI.switchToWindowUrl('https://portal.pcte.mil/docs/index.html')

'Verify user guide loaded'
WebUI.verifyElementText(findTestObject('Page_UserGuide/h1_SimSpace CyberRange'), 'SimSpace CyberRange')

'Briefly wait'
TestSupport.delay(1)

'Close user guide window/tab'
WebUI.closeWindowUrl('https://portal.pcte.mil/docs/index.html')

'Select main portal window/tab again'
WebUI.switchToWindowTitle('PCTE Portal')

'Briefly wait for user guide window/tab to close'
TestSupport.delay(3)


@com.kms.katalon.core.annotation.SetUp
def setup() 
{
   'Get the instance of the test support class'
   TestSupport support = TestSupport.getInstance()

   'Log into the portal'
   support.login(GlobalVariable.user1_username, GlobalVariable.user1_password)
}


@com.kms.katalon.core.annotation.TearDown
def teardown() 
{
   'Get the instance of the test support class'
   TestSupport support = TestSupport.getInstance()

   if (false) 
   {
      'Go to portal home page again to make sure that there are no pop ups getting in the way'
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      'Wait 3 seconds for the portal page to appear fully'
      TestSupport.delay(3)

      'Navigate to the Academy app by first click on the dashboard button'
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/icon_Apps'))

      'Delay for 3 seconds in order to make sure that the dashboard animation has completed'
      TestSupport.delay(3)

      'Click on the Academy icon to navigate to the Academy app'
      WebUI.click(findTestObject('Page_PCTE Portal/a_Academy'))

      'Click on Content Authoring'
      WebUI.click(findTestObject('Page_PCTE Portal/a_Academy_ContentAuthoring'))

      'Create a dynamic test object and find the HTML element with the correct name'
      TestObject packageDiv = new TestObject()

      'Form the xpath for the ... button in an event package'
      String packageDivPath = '//div[(text() = \'%s\' or . = \'%s\')]/parent::*/parent::*/div[5]/button'

      'Form the full xpath with the name of the desired package'
      String packageDivXPath = String.format(packageDivPath, 'PCTE Test T9041', 'PCTE Test T9041')

      'Set the newly-formed xpath as a property of the dynamic test object'
      packageDiv.addProperty('xpath', ConditionType.EQUALS, packageDivXPath)

      'Check to see if package for this test case has been created'
      if (WebUI.verifyElementPresent(packageDiv, 1, FailureHandling.OPTIONAL)) 
      {
         'Click on the project'
         WebUI.click(packageDiv)

         'Click delete'
         WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/span_Academy_Content_Delete'))

         'Confirm that the project should be deleted'
         WebUI.click(findTestObject('Page_PCTE Portal/button_Academy_Content_Delete'))
      }
   }
    
   'Log out of the portal'
   support.logout()
}
