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

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import edu.ucf.irl.TestSupport as TestSupport
import edu.ucf.irl.SharedTestData as SharedTestData


class TrainingPackage
{
   private void uploadFileOld(String filename)
   {
      // Get filename in native format
      String absoluteFilename = new java.io.File(filename).getAbsoluteFile()

      // Put filename into the clipboard
      StringSelection ss = new StringSelection(absoluteFilename)
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null)

      // Use the robot to paste clipboard into native file browser
      Robot robot = new Robot()
      robot.keyPress(KeyEvent.VK_CONTROL)
      robot.keyPress(KeyEvent.VK_V)
      robot.keyRelease(KeyEvent.VK_V)
      robot.keyRelease(KeyEvent.VK_CONTROL)
      TestSupport.delay(1)
      robot.keyPress(KeyEvent.VK_ENTER)
      robot.keyRelease(KeyEvent.VK_ENTER)
      TestSupport.delay(1)

      // Pause to let upload happen
      TestSupport.delay(5)
   }


   private void uploadFile(TestObject obj, String filename)
   {
      // Get filename in native format
      String absoluteFilename = new java.io.File(filename).getAbsoluteFile()

      // Send the filename to the "input" file field
      WebUI.sendKeys(obj, absoluteFilename)
      TestSupport.delay(1)

      // Submit the form
      WebUI.submit(obj)

      // Pause to let upload happen
      TestSupport.delay(5)
   }


   private void downloadFile(String filename)
   {
      // Get filename in native format
      String absoluteFilename = new java.io.File(filename).getAbsoluteFile()

      // Put filename into the clipboard
      StringSelection ss = new StringSelection(absoluteFilename)
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null)

      // Use the robot to paste clipboard into native file browser
      Robot robot = new Robot()
      robot.keyPress(KeyEvent.VK_CONTROL)
      robot.keyPress(KeyEvent.VK_V)
      robot.keyRelease(KeyEvent.VK_V)
      robot.keyRelease(KeyEvent.VK_CONTROL)
      TestSupport.delay(1)
      robot.keyPress(KeyEvent.VK_ENTER)
      robot.keyRelease(KeyEvent.VK_ENTER)

      // Pause to let download happen
      TestSupport.delay(5)
   }


   private void deleteFile(String filename)
   {
      // Get filename in native format
      String upload = new java.io.File(filename).getAbsoluteFile()

      // Delete the file
      try
      {
         new java.io.File(upload).delete()
      }
      catch (Exception e)
      {
         // Do nothing
      }
   }


   // ============================================================================================================================


   // uploadDocumentsToTrainingPackage.feature

   @Given("I am a participant of an event")
   def ensureAmEventParticipant()
   {
      //
   }


   // ============================================================================================================================


   // createTrainingPackage.feature

   @When("I create a Training Package")
   def startCreatingTrainingPackage()
   {
      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Training Packages"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

      // Click on "New Training Package"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_NewTrainingPackage'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewTrainingPackage'))
   }


   @When("I provide the Name, Description, Objectives, and a Content Module")
   def fillParameters()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String packageName = data.getTestParam("trainingPackageName")
      String moduleName = data.getTestParam("contentModuleToUse")

      // Enter name and description for Event Package
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageName'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageName'), packageName)
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_TrainingPackageDescription'), 'Create an event package with content and network.')

      // Set content category
      WebUI.click(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageContentCategory'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageContentCategoryTraining'))

      // Set training type
      WebUI.click(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageTrainingType'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageTrainingTypeStructuredContent'))

      // Set sector
      WebUI.click(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSector'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageSectorGovernmentAndMilitary'))

      // Advance to next tab
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageDetailsNext'))

      /*
       // Click to add an objective and description
       WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddCreateObjective'), 30)
       WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddCreateObjective'))
       WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_TrainingPackageObjectiveDescription'), packageName + ' Objective #1 Test Description')
       // Set blue team complexity to medium
       WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageBlueDefensiveComplexityMedium'))
       // Set red thread severity to medium
       WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageRedThreatSeverityMedium'))
       // Set target score expectations
       WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageTargetScoreMeetsExpectations'), '25')
       WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageTargetScoreExceedsExpectations'), '51')
       // Select time requirement (none), and threshold (2)
       WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageTimeRequirementsNone'))
       WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageDegradationThreshold'), '2')
       // Advance to next tab
       WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageObjectiveNext'))
       */

      // No prerequisites so skip this tab
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackagePrerequisitesNext'))

      // Add a content module
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddContentModules'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Page_PCTE Portal/div_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]))
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddToPackage'))
      TestSupport.delay(1)

      // Advance to next tab
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageModulesNext'))

      // Skip assessments tab and options tab
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAssessmentsNext'))
      /*
       WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageOptionsNext'))
       */

      // Click "Confirm" to create the training package
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageConfirm'))
      TestSupport.delay(5)
   }


   // importTrainingPackage.feature

   @When("I import a Training Package")
   def exportAndImportTrainingPackage()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String packageName = data.getTestParam("trainingPackageName")

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Training Packages"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

      // Set text to search for
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), packageName)
      TestSupport.delay(2)

      // Click "more" and export the training package
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/button_Content_TrainingPackagesMore'), 30)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Content_TrainingPackagesMore'))
      TestSupport.delay(1)
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/span_Content_TrainingPackagesExport'), 30)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/span_Content_TrainingPackagesExport'))

      // Save export file
      String filename = new String(packageName + '.tar.gz').replace(' ', '_')
      downloadFile(RunConfiguration.getProjectDir() + '/Data Files/' + filename)
      TestSupport.delay(10)

      // Now, we change back to author so we can delete the package
      TestSupport support = TestSupport.getInstance()
      support.logout()
      support.login(GlobalVariable.author_username, GlobalVariable.author_password, GlobalVariable.author_key)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Training Packages"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

      // Set text to search for
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), packageName)
      TestSupport.delay(1)

      // Click "more" and delete the training package
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/i_Content_TrainingPackagesMore'), 30)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/i_Content_TrainingPackagesMore'))
      TestSupport.delay(1)
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/span_Content_TrainingPackagesDelete'), 30)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/span_Content_TrainingPackagesDelete'))
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_TrainingPackagesConfirmDelete'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackagesConfirmDelete'))

      // Now, we change back to portal admin to import the package
      support.logout()
      support.login(GlobalVariable.god_username, GlobalVariable.god_password, GlobalVariable.god_key)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Training Packages"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

      /*
      // Click to open menu with "Import"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/i_Content_TrainingPackagesMoreVert'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/i_Content_TrainingPackagesMoreVert'))
      */
      /*
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_TrainingPackagesImport'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/input_Content_TrainingPackagesImport'))
      TestSupport.delay(1)
      */
      
      // Import package by loading it
      uploadFile(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageImport'),
               RunConfiguration.getProjectDir() + '/Data Files/' + filename)
      TestSupport.delay(10)

      // Clear downloaded training package
      deleteFile(RunConfiguration.getProjectDir() + '/Data Files/' + filename)
   }


   // uploadDocumentsToTrainingPackage.feature

   @When("I upload the documents to the Training Package")
   def uploadDocumentsToTrainingPackage()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String packageName = data.getTestParam("trainingPackageToUse")

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Training Packages"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

      // Set text to search for
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), packageName)

      // Open our training package and pause for it to load
      WebUI.click(findTestObject('Page_PCTE Portal/a_Content_TrainingPackageListSpecificTest', [('specificTestName') : packageName]))
      TestSupport.delay(1)

      // Upload a doc file into the package
      uploadFile(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageUploadDoc'),
               RunConfiguration.getProjectDir() + '/Data Files/PCTE-Test-Document.doc')

      // Upload a ppt file into the package
      uploadFile(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageUploadDoc'),
               RunConfiguration.getProjectDir() + '/Data Files/PCTE-Test-Document.ppt')

      // Upload an xml file into the package
      uploadFile(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageUploadDoc'),
               RunConfiguration.getProjectDir() + '/Data Files/PCTE-Test-Document.xml')
   }


   @When("I access the event's Training Package")
   def accessEventTrainingPackage()
   {
      //
   }


   // ============================================================================================================================


   // createTrainingPackage.feature

   @Then("I should see the new Training Package in the Content Library")
   def verifyCreatedTrainingPackage()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String packageName = data.getTestParam("trainingPackageName")

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Training Packages"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

      // Set text to search for
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), packageName)

      // Open our new package and pause for it to load
      WebUI.click(findTestObject('Page_PCTE Portal/a_Content_TrainingPackageListSpecificTest', [('specificTestName') : packageName]))
      TestSupport.delay(1)

      // Verify training package (item type, status, published field)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_TrainingPackageName'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_TrainingPackageName'), packageName)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_TrainingPackageDifficulty'), 'Beginner')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_TrainingPackageType'), 'Individual')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_TrainingPackageModulesCount'), '1')

      // Wait one second
      TestSupport.delay(1)

      // Delete our module and use SharedTestData since we are in teardown
      data.deleteTrainingPackage(packageName)
   }


   // importTrainingPackage.feature

   @Then("I should see the imported Training Package in the Content Library")
   def verifyImportedTrainingPackage()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String packageName = data.getTestParam("trainingPackageName")

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Training Packages"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

      // Set text to search for
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), packageName)

      // Open our new package and pause for it to load
      WebUI.click(findTestObject('Page_PCTE Portal/a_Content_TrainingPackageListSpecificTest', [('specificTestName') : packageName]))
      TestSupport.delay(1)

      // Verify training package (item type, status, published field)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Content_TrainingPackageName'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_TrainingPackageName'), packageName)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_TrainingPackageDifficulty'), 'Beginner')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_TrainingPackageType'), 'Individual')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_TrainingPackageModulesCount'), '1')

      // Wait one second
      TestSupport.delay(1)
   }


   // uploadDocumentsToTrainingPackage.feature

   @Then("I should see the documents uploaded to the package")
   def verifyDocumentsUploadedToPackage()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String packageName = data.getTestParam("trainingPackageToUse")

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Training Packages"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

      // Set text to search for
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), packageName)

      // Open our new module and pause for it to load
      WebUI.click(findTestObject('Page_PCTE Portal/a_Content_TrainingPackageListSpecificTest', [('specificTestName') : packageName]))
      TestSupport.delay(1)

      // Switch to "Documents" tab
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Content_TrainingPackageDocuments'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Content_TrainingPackageDocuments'))
      TestSupport.delay(1)

      // Verify documents appear
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackageAddedDocFile'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_Content_TrainingPackageAddedDocFile'), 'PCTE-Test-Document.doc')
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackageAddedPptFile'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_Content_TrainingPackageAddedPptFile'), 'PCTE-Test-Document.ppt')
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackageAddedXmlFile'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_Content_TrainingPackageAddedXmlFile'), 'PCTE-Test-Document.xml')
   }


   @Then("I should see documents were uploaded to the Training Package")
   def verifyDocumentsUploadedToEventTrainingPackage()
   {
      //
   }
}
