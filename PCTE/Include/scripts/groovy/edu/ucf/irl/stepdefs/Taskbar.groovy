package edu.ucf.irl.stepdefs
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import org.openqa.selenium.Keys

import java.awt.Robot
import java.awt.event.KeyEvent

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import edu.ucf.irl.TestSupport as TestSupport
import edu.ucf.irl.SharedTestData as SharedTestData


class Taskbar
{
   // apps.feature

   @When("I access Apps")
   def accessApps()
   {
      // Wait for the Apps button to appear and then click it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))
   }


   // create.feature

   @When("I select Create Lab Event in Portal Dashboard")
   def selectCreateLabEvent()
   {
      // Go to portal (in case previous scenario failed)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Wait for Create button and then select it
      WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

      // Wait for and click on "Event"
      WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/span_Dashboard_CreateEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateEvent'))

      // Wait for and select "Lab Training Event"
      WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/span_Dashboard_SelectStructuredContentEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_SelectStructuredContentEvent'))
      TestSupport.delay(1)

      // Click "Create"
      WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/button_Dashboard_CreateEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_CreateEvent'))
   }


   @When("I select Create Exercise Event in Portal Dashboard")
   def selectCreateExerciseEvent()
   {
      // Go to portal (in case previous scenario failed)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Wait for Create button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

      // Wait for and click on "Event"
      WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/span_Dashboard_CreateEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateEvent'))
      TestSupport.delay(1)

      // Wait for and select "Live Action Event"
      WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/span_Dashboard_SelectLiveActionEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_SelectLiveActionEvent'))
      TestSupport.delay(1)

      // Click "Create"
      WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/button_Dashboard_CreateEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_CreateEvent'))
   }


   @When("I select Create Network Spec in Portal Dashboard")
   def selectCreateNetworkSpec()
   {
      // Go to portal (in case previous scenario failed)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Wait for Create button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

      // Wait for and click on "Network Spec" (which can take longer sometimes)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateNetworkSpec'), 60)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateNetworkSpec'))
   }


   @When("I select Create VM Template in Portal Dashboard")
   def selectCreateVMTemplate()
   {
      // Go to portal (in case previous scenario failed)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Wait for Create button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

      // Wait for and click on "VM Template"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateVMTemplate'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateVMTemplate'))
   }


   @When("I select Create Physical Asset in Portal Dashboard")
   def selectCreatePhysicalAsset()
   {
      // Go to portal (in case previous scenario failed)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Wait for Create button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

      // Wait for and click on "Physical Asset"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreatePhysicalAsset'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreatePhysicalAsset'))
   }


   @When("I select Create Config Module in Portal Dashboard")
   def selectCreateConfigModule()
   {
      // Go to portal (in case previous scenario failed)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Wait for Create button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

      // Wait for and click on "Physical Asset"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateConfigModule'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateConfigModule'))
   }


   @When("I select Create External Subnet in Portal Dashboard")
   def selectCreateExternalSubnet()
   {
      // Go to portal (in case previous scenario failed)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Wait for Create button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

      // Wait for and click on "External Subnet"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateExternalSubnet'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateExternalSubnet'))
   }


   @When("I select Create Course Plan in Portal Dashboard")
   def selectCreateCoursePlan()
   {
      // Go to portal (in case previous scenario failed)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Wait for Create button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

      // Wait for and click on "Course Plan"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateCoursePlan'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateCoursePlan'))
   }


   @When("I select Create Training Package in Portal Dashboard")
   def selectCreateTrainingPackage()
   {
      // Wait for Create button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

      // Wait for and click on "Training Package"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateTrainingPackage'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateTrainingPackage'))
   }


   @When("I select Create Content Module in Portal Dashboard")
   def selectCreateContentModule()
   {
      // Wait for Create button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

      // Wait for and click on "Content Module"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_CreateContentModule'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateContentModule'))
   }


   // search.feature

   @When("I browse for content modules in the Portal Dashboard")
   def browseContentModules()
   {
      // Wait for Search button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Search'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Search'))

      // Click to browse for content modules
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h3_Dashboard_BrowseContentModule'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/h3_Dashboard_BrowseContentModule'))
   }


   @When("I search for a known content module in the Portal Dashboard")
   def searchContentModule()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String moduleName = data.getTestParam("contentModuleToUse")

      // Go to portal (clear previous scenario)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Wait for Search button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Search'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Search'))

      // Wait for and search for known content module
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Dashboard_Search'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Dashboard_Search'), moduleName)
      TestSupport.delay(1)
      WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Dashboard_Search'), Keys.chord(Keys.ENTER));
   }


   @When("I search for a known content module details in the Portal Dashboard")
   def searchContentModuleDetails()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String moduleName = data.getTestParam("contentModuleToUse")

      // Go to portal (clear previous scenario)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Wait for Search button and then select it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Search'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Search'))

      // Wait for and search for known content module
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Dashboard_Search'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Dashboard_Search'), moduleName)
      TestSupport.delay(1)
      WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Dashboard_Search'), Keys.chord(Keys.ENTER));

      // Open the module
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h3_Dashboard_SearchResult', [('specificTestName') : moduleName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/h3_Dashboard_SearchResult', [('specificTestName') : moduleName]))
   }


   // userMenu.feature

   @When("I access Chat in the Portal Dashboard User Menu")
   def accessChat()
   {
      // Go to portal (clear previous scenario)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Open the user menu
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_User'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/div_User'))

      // Click on "Chat"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_Chat'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_Chat'))

      // Briefly wait for chat window to open
      TestSupport.delay(3)

      // Switch to window/tab with chat
      WebUI.switchToWindowTitle('Mattermost')
   }


   @When("I access User Guide in the Portal Dashboard User Menu")
   def accessUserGuide()
   {
      // Go to portal (clear previous scenario)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Open the user menu
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_User'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/div_User'))

      // Click on "User Guide"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_UserGuide'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_UserGuide'))

      // Briefly wait for user guide window to open
      TestSupport.delay(3)

      // Switch to window/tab with user guide
      WebUI.switchToWindowTitle('Introduction · PCTE Cyber Range Documentation')
   }


   @When("I access Contact Support in the Portal Dashboard User Menu")
   def accessSupport()
   {
      // Go to portal (clear previous scenario)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Open the user menu
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_User'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/div_User'))

      // Click on "Contact Support"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_ContactSupport'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_ContactSupport'))

      // Wait for support page to load in case language pop-up appears
      TestSupport.delay(3)

      // Choose default English if language pop-up appears
      if (TestSupport.isObjectPresent(findTestObject('Page_PCTE Portal/p_Support_LanguageHeader')))
      {
         // Click through language and avatar
         WebUI.click(findTestObject('Page_PCTE Portal/input_Support_LanguageContinue'))

         // Wait for the next button to appear and click it
         WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Support_AvatarNext'), 30)
         WebUI.click(findTestObject('Page_PCTE Portal/input_Support_AvatarNext'))

         // Go back to the home page again
         WebUI.navigateToUrl(GlobalVariable.portal_url)

         // Wait for the user menu button to appear and click it
         WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_User'), 30)
         WebUI.click(findTestObject('Page_PCTE Portal/div_User'))

         // Wait for the Contact Support button to appear and click it
         WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_ContactSupport'), 30)
         WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_ContactSupport'))
      }
   }


   @When("I access View All Content in the Portal Dashboard User Menu")
   def accessViewAllContent()
   {
      // Go to portal (clear previous scenario)
      WebUI.navigateToUrl(GlobalVariable.portal_url);

      // Open the user menu
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_User'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/div_User'))

      // Toggle "View All Content"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/i_Dashboard_ViewAllContent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/i_Dashboard_ViewAllContent'))
      TestSupport.delay(1)

      /*
      // Close the user menu by sending an Escape to the page (can't send to any object as an overlay covers them all)
      Robot robot = new Robot()
      robot.keyPress(KeyEvent.VK_ESCAPE)
      robot.keyRelease(KeyEvent.VK_ESCAPE)
      */
      // Close the user menu by selecting "about" and then closing it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Dashboard_About'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_About'))
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_CloseAbout'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_CloseAbout'))

      // Click on Dashboard Apps
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select Content app
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Wait for the Content page to load and select Content Modules
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModules'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModules'))

      // Wait for the Content Modules page to load
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_NewContentModule'), 30)
   }


   // notifications.feature

   @When("I access Notifications in the Portal Dashboard User Menu")
   def accessNotifications()
   {
      // Open the notifications
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Notifications'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Notifications'))
   }


   // ============================================================================================================================


   // apps.feature

   @Then("I should be able to view all basic user applications")
   def verifyBasicUserApps()
   {
      // Verify Content, Events, My Org are visible
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_MyOrg'), 30)
   }


   @Then("I should be able to view all org admin applications")
   def verifyOrgAdminApps()
   {
      // Verify Content, Events, My Org, Reports & Analytics, Admin are visible
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_MyOrg'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_ReportsAndAnalytics'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Admin'), 30)
   }


   @Then("I should be able to view all portal admin applications")
   def verifyPortalAdminApps()
   {
      // Verify Content, Events, My Org, Reports & Analytics, Tech Ops, Admin are visible
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_MyOrg'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_ReportsAndAnalytics'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_TechOps'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Admin'), 30)
   }


   // create.feature

   @Then("I should get to the Lab Event area")
   def verifyLabEventPage()
   {
      // Verify "New Event" label exists on page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Events_NewEvent'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Events_NewEvent'), 'New Event')
   }


   @Then("I should get to the Exercise Event area")
   def verifyExerciseEventPage()
   {
      // Verify "New Event" label exists on page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Events_NewEvent'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Events_NewEvent'), 'New Event')

      // Check other elements on page?
   }


   @Then("I should get to the Network Spec area")
   def verifyNetworkSpecPage()
   {
      // Verify Network Spec Wizard exists on page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewNetworkSpec'), 90)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewNetworkSpec'), 'Network Spec Wizard')

      // Then close the wizard
      WebUI.click(findTestObject('Page_PCTE Portal/i_NetworkSpecWizard_Close'))

      // And confirm we want to exit
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_NetworkSpecWizard_Exit'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_NetworkSpecWizard_Exit'))
   }


   @Then("I should get to the VM Template area")
   def verifyVMTemplatePage()
   {
      // Verify "New VM Template" label exists on page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewVMTemplate'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewVMTemplate'), 'New VM Template')

      'Close VM template create tool'
      WebUI.click(findTestObject('Page_PCTE Portal/i_NewVMTemplate_Close'))
   }


   @Then("I should get to the Physical Asset area")
   def verifyPhysicalAssetPage()
   {
      // Verify "New Physical Asset" label exists on page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewPhysicalAsset'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewPhysicalAsset'), 'New Physical Asset')
   }


   @Then("I should get to the Config Module area")
   def verifyConfigModulePage()
   {
      // Verify "New Config Module" label exists on page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewConfigModule'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewConfigModule'), 'New Config Module')
   }


   @Then("I should get to the External Subnet area")
   def verifyExternalSubnetPage()
   {
      // Verify "New External Subnet" label exists on page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewExternalSubnet'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewExternalSubnet'), 'New External Subnet')
   }


   @Then("I should get to the Course Plan area")
   def verifyCoursePlanPage()
   {
      // Verify "New Course Plan" label exists on page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewCoursePlan'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewCoursePlan'), 'New Course Plan')
   }


   @Then("I should get to the Training Package area")
   def verifyTrainingPackagePage()
   {
      // Verify "Create Package" label exists on page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewTrainingPackage'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewTrainingPackage'), 'Create Package')
   }


   @Then("I should get to the Content Module area")
   def verifyContentModulePage()
   {
      // Verify "New Module" label exists on page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_NewContentModule'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_NewContentModule'), 'New Module')
   }


   // search.feature

   @Then("I should see the main content module area")
   def verifyBrowsedContentModules()
   {
      // Verify on Content Modules page (so we got to the page)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_ContentModulesHeader'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_ContentModulesHeader'), 'Content Modules')
   }


   @Then("I should find that content module in the return list")
   def verifySearchContentModule()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String moduleName = data.getTestParam("contentModuleToUse")

      // Verify content module appears in list
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h3_Dashboard_SearchResult', [('specificTestName') : moduleName]), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h3_Dashboard_SearchResult', [('specificTestName') : moduleName]), moduleName)
   }


   @Then("I should find that content module details")
   def verifySearchContentModuleDetails()
   {
      // Make sure we find our content module details
      TestSupport.delay(1)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 'Content Module')
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModuleStatus'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_Content_ContentModuleStatus'), 'Published')
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/td_Content_ContentModulePublished'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModulePublished'), 'Published')

      // We do not verify question/task count as it could vary when run within a suite
      // WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/td_Content_ContentModuleQuestionCount'), 30)
      // WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleQuestionCount'), '1')
   }


   // userMenu.feature

   @Then("I should be able to view Chat with no errors")
   def verifyChat()
   {
      // Wait for the chat content to load
      WebUI.waitForElementPresent(findTestObject('Page_Mattermost/h1_Mattermost_MattermostHeader'), 30)

      // Verify chat loaded
      WebUI.verifyElementText(findTestObject('Page_Mattermost/h1_Mattermost_MattermostHeader'), 'Mattermost')
      WebUI.verifyElementPresent(findTestObject('Page_Mattermost/span_Mattermost_KeycloakLogin'), 30)

      // Then close chat window/tab and go back to main portal window
      WebUI.closeWindowTitle('Mattermost')
      WebUI.switchToWindowTitle('PCTE Portal')

      // Briefly wait for chat window/tab to close
      TestSupport.delay(2)
   }


   @Then("I should be able to view User Guide with no errors")
   def verifyUserGuide()
   {
      // Wait for the user guide content to load
      WebUI.waitForElementPresent(findTestObject('Page_UserGuide/h1_PCTECyberRange'), 30)

      // Verify user guide loaded
      WebUI.verifyElementText(findTestObject('Page_UserGuide/h1_PCTECyberRange'), 'PCTE Cyber Range')

      // Then close user guide window/tab and go back to main portal window
      WebUI.closeWindowTitle('Introduction · PCTE Cyber Range Documentation')
      WebUI.switchToWindowTitle('PCTE Portal')

      // Briefly wait for user guide window/tab to close
      TestSupport.delay(2)
   }


   @Then("I should be able to view Contact Support with no errors")
   def verifySupport()
   {
      // Verify we load the support page
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_ServiceDeskDashboard'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_ServiceDeskDashboard'), 'Open a Support Ticket')
   }


   @Then("I should be able to view shared content with no errors")
   def verifyViewSharedContent()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String moduleName = data.getTestParam("contentModuleToUse")

      // See if the shared module is there; first, let's search for it
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)
      TestSupport.delay(2)

      // Find our content module and verify it's there
      TestObject specificModule = findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName])
      WebUI.verifyElementPresent(specificModule, 30)
   }


   // notifications.feature

   @Then("I should be able to view Notifications with no errors")
   def verifyNotifications()
   {
      // Verify the notification window opens
      /* Header can now include a varying number after it that causes issues
       WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Dashboard_Notifications'), 30)
       WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Dashboard_Notifications'), 'Notifications')
       */

      // Verify bell
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/i_Dashboard_Notifications'), 30)

   }
}
