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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import edu.ucf.irl.TestSupport as TestSupport
import edu.ucf.irl.SharedTestData as SharedTestData


class Survey
{
   @When("I create a Survey module")
   def createSurveyModule()
   {
      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Content Modules"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModules'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModules'))

      // Click on "New Content Module"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_NewContentModule'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewContentModule'))

      // Set to survey mode
      WebUI.click(findTestObject('Page_PCTE Portal/label_Content_ContentModuleSurvey'))
   }


   @When("I provide the Name, Description, and Survey Questions")
   def fillSurveyQuestions()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String surveyName = data.getTestParam("surveyName")

      // Enter name and description for Content Module
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleName'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleName'), surveyName)
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleDescription'), 'Create a survey module with one of each task type.')

      // Then select Tasks tab
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleTasks'))

      // Create a task chain
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleCreateNewChain'))

      // Enter short answer question and answer
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 'What does PCTE stand for?')
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleAnswer'), 'Persistent Cyber Training Environment')

      // Add a task (question)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleAddTask'))

      // Enter the question
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 'Which of the following letters is in "PCTE?"')

      // Switch from "Short Answer" to "Multiple Choice"
      WebUI.click(findTestObject('Page_PCTE Portal/i_Content_ContentModuleShortAnswerArrow'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Page_PCTE Portal/div_Content_ContentModuleMultipleChoice'))
      TestSupport.delay(1)

      // Add choices
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddChoice2'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddChoice3'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddChoice4'))
      TestSupport.delay(1)

      // Define the choices
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice1'), 'C')
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice2'), 'G')
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice3'), 'U')
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice4'), 'S')
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice5'), 'A')

      // Add a task (question)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleAddTask'))

      // Enter the question
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), "Which were among Washington's generals in the American Revolutionary War?")

      // Switch from "Short Answer" to "Selections"
      WebUI.click(findTestObject('Page_PCTE Portal/i_Content_ContentModuleShortAnswerArrow'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Page_PCTE Portal/div_Content_ContentModuleSelections'))
      TestSupport.delay(1)

      // Add third selection
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddSelection'))
      TestSupport.delay(1)

      // Define the choices
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleSelection1'), 'Knox')
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleSelection2'), 'Greene')
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleSelection3'), 'Cornwallis')
      TestSupport.delay(2)

      // Click create!
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleCreate'))
      TestSupport.delay(5)
   }


   // ============================================================================================================================


   @Then("I should see the Survey in the Content Library")
   def verifySurveyCreation()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String surveyName = data.getTestParam("surveyName")

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Content Modules"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModules'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModules'))

      // Set text to search for
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), surveyName)

      // Open our new module and pause for it to load
      WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : surveyName]))
      TestSupport.delay(1)

      // Verify content module (item type, status, published field, task count)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 'Content Module')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleStatus'), 'Published')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModulePublished'), 'Published')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleQuestionCount'), '3')

      // Wait one second
      TestSupport.delay(1)

      // Delete our module and use SharedTestData since we are in teardown
      data.deleteContentModule(surveyName)
   }
}
