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

import org.openqa.selenium.Keys as Keys

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import edu.ucf.irl.TestSupport as TestSupport
import edu.ucf.irl.SharedTestData as SharedTestData


class Event
{
   // scheduleLabEvent.feature

   @When("I create a Lab Event")
   def createLabEvent()
   {
      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Make sure we are in Lab Event area
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'))

      // Click "Schedule Event"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_ScheduleEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_ScheduleEvent'))
   }


   @When("I provide the Name, Description, Participants, a Training Package, and a Survey Module")
   def fillEventParameters()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String eventName = data.getTestParam("labEventName")
      String packageName = data.getTestParam("trainingPackageToUse")
      String surveyName = data.getTestParam("surveyToUse")

      // Specify the name and description of event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_NewEventName'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventName'), eventName)
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Events_NewEventDescription'), eventName + ' Description')

      // Select the training package
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventSpecificTrainingPackage'), packageName)
      TestSupport.delay(1)
      WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventSpecificTrainingPackage'), Keys.chord(Keys.ENTER))
      TestSupport.delay(1)

      // Enable leaderboard, answer revealing, randomized questions, and using a survey module
      WebUI.click(findTestObject('Page_PCTE Portal/label_Events_NewEventEnableRevealingAnswers'))
      WebUI.click(findTestObject('Page_PCTE Portal/label_Events_NewEventEnableRandomizedQuestions'))
      WebUI.click(findTestObject('Page_PCTE Portal/label_Events_NewEventEnableLeaderboard'))
      WebUI.click(findTestObject('Page_PCTE Portal/label_Events_NewEventEnableSurveyModule'))

      // Specify the survey module
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventSpecifiedSurveyModule'), surveyName)
      TestSupport.delay(1)
      WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventSpecifiedSurveyModule'), Keys.chord(Keys.ENTER))
      TestSupport.delay(1)

      // Switch to the participants pane
      WebUI.click(findTestObject('Page_PCTE Portal/div_Events_EventParticipants'))

      // Add user 1
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), GlobalVariable.user1_name)
      WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), Keys.chord(Keys.ENTER))
      TestSupport.delay(1)

      // Add user 2
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), GlobalVariable.user2_name)
      WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), Keys.chord(Keys.ENTER))
      TestSupport.delay(1)

      // Switch to the schedule pane
      WebUI.click(findTestObject('Page_PCTE Portal/div_Events_Schedule'))
      TestSupport.delay(1)

      // Schedule the event by first clicking today
      WebUI.click(findTestObject('Page_PCTE Portal/div_Events_ScheduleToday'))
      TestSupport.delay(1)

      // Advance start time by one minute
      WebUI.click(findTestObject('Page_PCTE Portal/input_Events_ScheduleStartTime'))
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_ScheduleAdvanceMinuteStart'))
      TestSupport.delay(1)

      // Save the schedule
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_ScheduleSave'))
      TestSupport.delay(1)

      // Create the event!
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_CreateEvent'))
      TestSupport.delay(1)
   }


   // runLabEvent.feature

   @When("I join the Lab Event to which I am assigned")
   def joinLabEvent()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String eventName = data.getTestParam("labEventToUse")

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Wait one minute to allow event to start
      WebUI.delay(60)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Make sure we are in Lab Event area
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'))

      // Search for the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Open the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]))
      TestSupport.delay(1)

      // Enter the event!
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_EnterEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_EnterEvent'))
      TestSupport.delay(1)
   }


   @When("I complete all the tasks")
   def completeTasksInLabEvent()
   {
      // Answer question 1
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_TaskAnswer'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_TaskAnswer'), 'Persistent Cyber Training Environment')
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_TaskSubmit'))
      TestSupport.delay(2)

      // Click "Continue"
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_TaskContinue'))
      TestSupport.delay(2)

      // Answer question 2
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/i_Events_TaskResponseButton'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/i_Events_TaskResponseButton'))
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_TaskSubmit'))
      TestSupport.delay(2)

      // Click "Continue"
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_TaskContinue'))
      TestSupport.delay(2)

      // Answer question 3
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Events_TaskResponseCheckbox1'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/div_Events_TaskResponseCheckbox1'))
      WebUI.click(findTestObject('Page_PCTE Portal/div_Events_TaskResponseCheckbox2'))
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_TaskSubmit'))
      TestSupport.delay(2)

      // Click "Finish"
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_TasksFinish'))
      TestSupport.delay(2)
   }


   // verifySurvey.feature

   @When("Users complete the survey of an ended event")
   def completeSurvey()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String eventName = data.getTestParam("labEventToUse")

      // Logout of manager and become user 1 to answer survey
      TestSupport support = TestSupport.getInstance()
      support.logout()
      support.login(GlobalVariable.user1_username, GlobalVariable.user1_password, GlobalVariable.user1_key)

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Make sure we are in Lab Event area
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'))

      // Search for the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Open the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]))
      TestSupport.delay(1)

      // Open the survey
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/button_Events_PostEventSurvey'), 30)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Events_PostEventSurvey'))

      // Provide answers
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/textarea_Events_SurveyResponseAnswer'), 30)
      WebUI.setText(findTestObject('Object Repository/Page_PCTE Portal/textarea_Events_SurveyResponseAnswer'), 'Washington')
      TestSupport.delay(1)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/div_Events_SurveyResponseMultipleChoice'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/div_Events_SurveyResponseSelection1'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/div_Events_SurveyResponseSelection2'))
      TestSupport.delay(1)

      // Submit survey
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Events_SurveySubmit'))
      TestSupport.delay(1)

      // Logout of manager and become user 2 to answer survey
      support.logout()
      support.login(GlobalVariable.user2_username, GlobalVariable.user2_password, GlobalVariable.user2_key)

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Search for the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Open the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]))
      TestSupport.delay(1)

      // Open the survey
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/button_Events_PostEventSurvey'), 30)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Events_PostEventSurvey'))

      // Provide answers
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/textarea_Events_SurveyResponseAnswer'), 30)
      WebUI.setText(findTestObject('Object Repository/Page_PCTE Portal/textarea_Events_SurveyResponseAnswer'), 'Hanson')
      TestSupport.delay(1)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/div_Events_SurveyResponseMultipleChoice'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/div_Events_SurveyResponseSelection1'))
      TestSupport.delay(1)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/div_Events_SurveyResponseSelection2'))
      TestSupport.delay(1)

      // Submit survey
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Events_SurveySubmit'))
      TestSupport.delay(1)
   }


   // editLabEvent.feature

   @When("I update an existing Lab Event with a new name and description, and an additional user")
   def editLabEvent()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String eventName = data.getTestParam("labEventToUse")

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Search for the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Open the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]))
      TestSupport.delay(1)

      // Click "more"
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/i_Events_EventMore'), 30)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/i_Events_EventMore'))

      // Click "Edit"
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/span_Events_EventEdit'), 30)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/span_Events_EventEdit'))
      TestSupport.delay(1)

      // Specify the name and description of event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_NewEventName'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventName'), eventName + ' [UPDATED]')
      WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Events_NewEventDescription'), eventName + ' Description [UPDATED]')
      TestSupport.delay(1)

      // Switch to the participants pane
      WebUI.click(findTestObject('Page_PCTE Portal/div_Events_EventParticipants'))

      // Add user (we use the content author)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), GlobalVariable.author_name)
      WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), Keys.chord(Keys.ENTER))
      TestSupport.delay(1)

      // Confirm update
      WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/button_Events_UpdateEventYes'), 30)
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Events_UpdateEventYes'))
      TestSupport.delay(2)

      // Update the event!
      WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Events_UpdateEvent'))
      TestSupport.delay(2)
   }


   // ============================================================================================================================


   // scheduleLabEvent.feature

   @Then("The new Lab Event should appear in the Event Outlook")
   def verifyLabEvent()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String eventName = data.getTestParam("labEventName")

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Make sure we are in Lab Event area
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'))

      // Search for the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Open the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]))

      // Verify event name
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Events_EventName'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Events_EventName'), eventName)

      // Delete our lab event and use SharedTestData since we are in teardown
      data.deleteLabEvent(eventName)
   }


   // runLabEvent.feature

   @Then("My results for the Lab Event should be available to review for myself and the training manager")
   def verifyLabRun()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String eventName = data.getTestParam("labEventToUse")

      // Logout of basic user and become manager to check score
      TestSupport support = TestSupport.getInstance()
      support.logout()
      support.login(GlobalVariable.manager_username, GlobalVariable.manager_password, GlobalVariable.manager_key)

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Make sure we are in Lab Event area
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'))

      // Search for the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Open the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]))
      TestSupport.delay(1)

      // End the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_EndEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_EndEvent'))
      TestSupport.delay(1)

      // Go to the "Event Standings" tab
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Events_EventStandingsTab'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/div_Events_EventStandingsTab'))
      TestSupport.delay(1)

      // Verify user scores
      String userName = GlobalVariable.user1_name
      WebUI.verifyElementPresent(findTestObject('Page_PCTE Portal/div_Events_EventUserScore', [('userName') : userName]), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Events_EventUserScore', [('userName') : userName]), '2')
      WebUI.verifyElementPresent(findTestObject('Page_PCTE Portal/div_Events_EventUserPercentCorrect', [('userName') : userName]), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Events_EventUserPercentCorrect', [('userName') : userName]), '67%')

      // Finally, now close the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_CloseEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_CloseEvent'))
      TestSupport.delay(1)

      // Now, check score as basic user so logout of manager and back to basic user
      support.logout()
      support.login(GlobalVariable.user1_username, GlobalVariable.user1_password, GlobalVariable.user1_key)

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Go the "Completed" tab
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_CompletedEvents'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_CompletedEvents'))

      // Search for the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Open the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]))
      TestSupport.delay(1)

      // Verify user scores
      WebUI.verifyElementPresent(findTestObject('Page_PCTE Portal/div_Events_EventSummaryTotalCorrect'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Events_EventSummaryTotalCorrect'), '2')
      WebUI.verifyElementPresent(findTestObject('Page_PCTE Portal/div_Events_EventSummaryTotalIncorrect'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Events_EventSummaryTotalIncorrect'), '1')
   }


   // verifySurvey.feature

   @When("I can view the feedback of the closed event")
   def verifySurvey()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String eventName = data.getTestParam("labEventToUse")

      // Logout of basic user and become manager to check score
      TestSupport support = TestSupport.getInstance()
      support.logout()
      support.login(GlobalVariable.manager_username, GlobalVariable.manager_password, GlobalVariable.manager_key)

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Make sure we are in Lab Event area
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'))

      // Search for the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Open the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]))
      TestSupport.delay(1)

      // Close the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_CloseEvent'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Events_CloseEvent'))
      TestSupport.delay(1)

      // Now, we have to find the event in the "Completed" tab so let's browse back
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Go to the "Completed" tab
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_CompletedEvents'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_CompletedEvents'))

      // Search for the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Open the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]))
      TestSupport.delay(1)

      // Go to the "Survey Results" tab
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsTab'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsTab'))
      TestSupport.delay(1)

      // Open the questions
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsOpenQuestion2'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsOpenQuestion2'))
      WebUI.click(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsOpenQuestion3'))

      // Verify participant results
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsQuestion1Response1'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsQuestion1Response2'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsQuestion2Response'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsQuestion3Response1'), 30)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsQuestion3Response2'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsQuestion1Response1'), '50% (2)')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsQuestion1Response2'), '50% (2)')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsQuestion2Response'), '100% (2)')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsQuestion3Response1'), '100% (2)')
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Events_SurveyResultsQuestion3Response2'), '100% (2)')
   }


   // editLabEvent.feature

   @Then("The updated Lab Event should appear with the updated information")
   def verifyUpdatedLabEvent()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String eventName = data.getTestParam("labEventToUse") + ' [UPDATED]'

      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Events area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Make sure we are in Lab Event area
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'))

      // Search for the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Open the event
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName]))

      // Verify updated event name
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/h1_Events_EventName'), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Events_EventName'), eventName)

      // Verify additional user is in event
      String userName = GlobalVariable.author_name
      WebUI.verifyElementPresent(findTestObject('Page_PCTE Portal/div_Events_EventUser', [('userName') : userName]), 30)
      WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Events_EventUser', [('userName') : userName]), userName)
   }
}
