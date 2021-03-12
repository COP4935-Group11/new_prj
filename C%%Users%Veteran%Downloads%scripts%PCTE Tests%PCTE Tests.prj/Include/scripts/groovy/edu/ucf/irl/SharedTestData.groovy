package edu.ucf.irl

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.CSVData
import com.kms.katalon.core.testdata.reader.CSVSeparator
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


public class SharedTestData {
	static private SharedTestData singleton_instance = null;

	def test_params = [:];


	public static SharedTestData getInstance() {
		// Check to see if the singleton instance needs to be instantiated
		if (singleton_instance == null)
		{
			// Instantiate the singleton
			singleton_instance = new SharedTestData();
		}

		// Return the singleton instance
		return singleton_instance;
	}


	// ============================================================================================================================


	void addTestParam(String key, String value)
	{
		// Add the key, value pair to the map
		test_params[key] = value;
	}


	void removeTestParam(String key)
	{
		// Remove key from map
		test_params.remove(key);
	}


	String getTestParam(String key)
	{
		// Return the key
		return test_params[key];
	}


	// ============================================================================================================================


	void createLabEvent(String eventName, String trainingPackageToLink, String surveyModuleToLink, int minutesAhead = 0)
	{
		/*
		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url)

		// Open the Dashboard (apps)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

		// Select the Events area (app)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))
		TestSupport.delay(1)

		// Make sure we are in Lab Event area
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'))

		// Click "Schedule Event"
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_ScheduleEvent'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Events_ScheduleEvent'))

		// Set the name
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_NewEventName'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventName'), eventName)

		// Set the description
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Events_NewEventDescription'), eventName + ' Description')

		// Enter the training package to use
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventSpecificTrainingPackage'), trainingPackageToLink)
		TestSupport.delay(1)
		WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventSpecificTrainingPackage'), Keys.chord(Keys.ENTER))
		TestSupport.delay(1)

		// Enable revealing answers
		WebUI.click(findTestObject('Page_PCTE Portal/label_Events_NewEventEnableRevealingAnswers'))

		// Enable using randomized questions
		WebUI.click(findTestObject('Page_PCTE Portal/label_Events_NewEventEnableRandomizedQuestions'))

		// Enable using the leaderboard
		WebUI.click(findTestObject('Page_PCTE Portal/label_Events_NewEventEnableLeaderboard'))

		// Enable using the survey module
		WebUI.click(findTestObject('Page_PCTE Portal/label_Events_NewEventEnableSurveyModule'))

		// Enter which survey to use
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventSpecifiedSurveyModule'), surveyModuleToLink)
		TestSupport.delay(1)
		WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventSpecifiedSurveyModule'), Keys.chord(Keys.ENTER))
		TestSupport.delay(1)

		// Switch to participants pane
		WebUI.click(findTestObject('Page_PCTE Portal/div_Events_EventParticipants'))

		// Add test user 1
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), GlobalVariable.user1_name)
		WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), Keys.chord(Keys.ENTER))
		TestSupport.delay(1)

		// Add test user 2
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), GlobalVariable.user2_name)
		WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Events_NewEventParticipant'), Keys.chord(Keys.ENTER))
		TestSupport.delay(1)

		// Switch to schedule pane
		WebUI.click(findTestObject('Page_PCTE Portal/div_Events_Schedule'))
		TestSupport.delay(1)

		// Click on today
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Events_ScheduleToday'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/div_Events_ScheduleToday'))
		TestSupport.delay(1)

		// Advance minutes (as appropriate)
		WebUI.click(findTestObject('Page_PCTE Portal/input_Events_ScheduleStartTime'))
		TestSupport.delay(1)
		for (int i = 0; i < minutesAhead; i++)
		{
			// Advance start time by one minute
			WebUI.click(findTestObject('Page_PCTE Portal/span_Events_ScheduleAdvanceMinuteStart'))
			TestSupport.delay(1)
		}

		// Save the schedule
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_ScheduleSave'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Events_ScheduleSave'))
		TestSupport.delay(1)

		// Create the event!
		WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/button_Events_CreateEvent'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Events_CreateEvent'))
		TestSupport.delay(5)
		*/
	}


	void endLabEvent(String eventName)
	{
		/*
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

		// Get our event
		TestObject specificEvent = findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName])

		// If we find our test, end it
		if (TestSupport.isObjectPresent(specificEvent, 3))
		{
			// Open the event
			WebUI.click(specificEvent)
			TestSupport.delay(1)

			// End the event
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_EndEvent'), 60)
			WebUI.click(findTestObject('Page_PCTE Portal/button_Events_EndEvent'))
			TestSupport.delay(3)
		}
		*/
	}



	void closeLabEvent(String eventName)
	{
		/*
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

		// Get our event
		TestObject specificEvent = findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName])

		// If we find our test, close it
		if (TestSupport.isObjectPresent(specificEvent, 3))
		{
			// Open the event
			WebUI.click(specificEvent)
			TestSupport.delay(1)

			// Close the event
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_CloseEvent'), 60)
			WebUI.click(findTestObject('Page_PCTE Portal/button_Events_CloseEvent'))
			TestSupport.delay(3)
		}
		*/
	}


	void deleteLabEvent(String eventName, boolean eventCompleted = false)
	{
		/*
		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url)

		// Open the Dashboard (apps)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

		// Select the Events area (app)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

		// Go to the "Completed" tab, if specified
		if (eventCompleted == true)
		{
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_CompletedEvents'), 30)
			WebUI.click(findTestObject('Page_PCTE Portal/span_Events_CompletedEvents'))
		}
		else
		{
			// Make sure we are in Lab Event area
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'), 30)
			WebUI.click(findTestObject('Page_PCTE Portal/span_Events_StructuredContentEvents'))
		}

		// Search for the event
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

		// Get our event
		TestObject specificEvent = findTestObject('Page_PCTE Portal/a_Events_EventListSpecificTest', [('specificTestName') : eventName])

		// If we find our test, delete it
		if (TestSupport.isObjectPresent(specificEvent, 3))
		{
			// Open the event
			WebUI.click(specificEvent)
			TestSupport.delay(1)

			// Click "more"
			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/i_Events_EventMore'), 30)
			WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/i_Events_EventMore'))

			// Click delete
			WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/span_Events_EventDelete'), 30)
			WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/span_Events_EventDelete'))
			TestSupport.delay(1)

			// Confirm that the project should be deleted by entering name
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_DeleteName'), 30)
			WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_DeleteName'), eventName)
			TestSupport.delay(1)

			// Click delete
			WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Events_Delete'))
			TestSupport.delay(1)
		}
		*/
	}


	void createContentModule(String moduleName)
	{
		/*
		// Go to portal home page again to make sure that there are no pop ups getting in the way
		WebUI.navigateToUrl(GlobalVariable.portal_url)

		// Wait for the Apps button to appear
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)

		// Open the Dashboard (apps)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

		// Wait for the apps dashboard to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)

		// Select the Content area (app)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

		// Wait for the Content page to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModules'), 30)

		// Click on "Content Modules"
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModules'))

		// Wait for the Content Modules page to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_NewContentModule'), 30)

		// Click on "New Content Module"
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewContentModule'))

		// Enter name for Content Module
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleName'), moduleName)

		// Enter description for Content Module
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleDescription'), 'Create a content module for testing.')

		// Set duration to 1 day
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleDuration'), '1')

		// Select Tasks tab
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleTasks'))

		// Advance to next tab
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleCreateNewChain'))

		// Enter a question
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleTaskName'), 'What does PCTE stand for?')

		// Enter the correct answer
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleShortAnswer1'), 'Persistent Cyber Training Environment')

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
		WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/div_Content_ContentModuleSelections'), 10)
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
		TestSupport.delay(1)
		
		*/
	}


	void deleteContentModule(String moduleName)
	{
		/*
		// Go to portal home page again to make sure that there are no pop ups getting in the way
		WebUI.navigateToUrl(GlobalVariable.portal_url)
		TestSupport.delay(1)

		// Open the Dashboard (apps)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))
		TestSupport.delay(1)

		// Select the Content area (app)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

		// Click on "Content Modules"
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModules'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModules'))

		// Set text to search for
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)
		TestSupport.delay(1)

		// Get our test
		TestObject specificTest = findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName])

		// If we find our test, delete it
		if (TestSupport.isObjectPresent(specificTest, 3))
		{
			// Click "more"
			WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/i_Content_ContentModulesMore'))

			// Click delete
			WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/div_Content_ContentModulesDelete'))
			TestSupport.delay(1)

			// Confirm that the project should be deleted
			WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModulesConfirmDelete'))
		}
		*/
	}


	void deleteContentModuleDocuments(String moduleName)
	{
		/*
		// Go to portal home page again to make sure that there are no pop ups getting in the way
		WebUI.navigateToUrl(GlobalVariable.portal_url)

		// Open the Dashboard (apps)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))
		TestSupport.delay(1)

		// Select the Content area (app)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

		// Click on "Content Modules"
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModules'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModules'))

		// Set text to search for
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)
		TestSupport.delay(1)

		// Get our test
		TestObject specificTest = findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName])

		// If we find our test, delete it
		if (TestSupport.isObjectPresent(specificTest, 3))
		{
			// Open our new module and pause for it to load
			WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]))
			TestSupport.delay(1)

			// Switch to "Documents" tab
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Content_ContentModuleDocuments'), 30)
			WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleDocuments'))

			// Loop over documents and delete each one
			TestObject doc = findTestObject('Page_PCTE Portal/span_Content_ContentModuleDocumentName')
			while (TestSupport.isObjectPresent(doc, 3))
			{
				// Open the "more" menu
				WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleDocumentsMoreVert'))

				// Click "Delete Document"
				WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModuleDeleteDocument'), 30)
				WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleDeleteDocument'))

				// Pause and then check for next document
				TestSupport.delay(2)
				doc = findTestObject('Page_PCTE Portal/span_Content_ContentModuleDocumentName')
			}
		}
		*/
	}


	void createSurveyModule(String moduleName)
	{
		/*
		// Go to portal home page again to make sure that there are no pop ups getting in the way
		WebUI.navigateToUrl(GlobalVariable.portal_url)

		// Wait for the Apps button to appear
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)

		// Open the Dashboard (apps)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

		// Wait for the apps dashboard to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)

		// Select the Content area (app)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

		// Wait for the Content page to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModules'), 30)

		// Click on "Content Modules"
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModules'))

		// Wait for the Content Modules page to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_NewContentModule'), 30)

		// Click on "New Content Module"
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewContentModule'))

		// Enter name for Content Module
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleName'), moduleName)

		// Enter description for Content Module
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleDescription'), 'Create a survey module for testing.')

		// Set survey module flag
		WebUI.click(findTestObject('Page_PCTE Portal/label_Content_ContentModuleSurvey'))

		// Select Tasks tab
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleTasks'))

		// Advance to next tab
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleCreateNewChain'))

		// Enter a question
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleTaskName'), 'What was the last name of the first U.S. President (under U.S. Constitution)?')

		// Enter the correct answer
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleShortAnswer1'), 'Washington')

		// Add a task (question)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleAddTask'))

		// Enter the question
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 'In which year was the Declaration of Independence signed?')

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
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice1'), '1776')
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice2'), '1620')
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice3'), '1787')
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice4'), '1803')
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleChoice5'), '1812')

		// Add a task (question)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleAddTask'))

		// Enter the question
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), "Which were battles in the American Revolutionary War?")

		// Switch from "Short Answer" to "Selections"
		WebUI.click(findTestObject('Page_PCTE Portal/i_Content_ContentModuleShortAnswerArrow'))
		TestSupport.delay(1)
		WebUI.click(findTestObject('Page_PCTE Portal/div_Content_ContentModuleSelections'))
		TestSupport.delay(1)

		// Add third selection
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddSelection'))
		TestSupport.delay(1)

		// Define the choices
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleSelection1'), 'Battle of Yorktown')
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleSelection2'), 'Battle of Saratoga')
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleSelection3'), 'Battle of the Bulge')
		TestSupport.delay(2)

		// Click create!
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleCreate'))
		TestSupport.delay(1)
		*/
	}


	void deleteSurveyModule(String moduleName)
	{
		deleteContentModule(moduleName)
	}


	void createTrainingPackage(String packageName, String moduleNameToLink = packageName)
	{
		/*
		'Go to portal home page again to make sure that there are no pop ups getting in the way'
		WebUI.navigateToUrl(GlobalVariable.portal_url)

		'Open the Dashboard (apps)'
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

		'Select the Content area (app)'
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

		'Click on "Training Packages"'
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

		'Delay for a second for Dashboard to open'
		TestSupport.delay(1)

		'Click on "New Training Package"'
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_NewTrainingPackage'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewTrainingPackage'))

		'Enter name for Training Package'
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageName'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageName'), packageName)

		'Enter description for Training Package'
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_TrainingPackageDescription'), 'Create an event package with content and network.')

		'Set content category'
		WebUI.click(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageContentCategory'))
		TestSupport.delay(1)
		WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageContentCategoryTraining'))

		'Set training type'
		WebUI.click(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageTrainingType'))
		TestSupport.delay(1)
		WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageTrainingTypeStructuredContent'))

		'Set sector'
		WebUI.click(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSector'))
		TestSupport.delay(1)
		WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageSectorGovernmentAndMilitary'))

		'Advance to next tab'
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageDetailsNext'))
		/*
		 'Click to add an objective'
		 WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddCreateObjective'), 30)
		 WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddCreateObjective'))
		 'Specify the objective description'
		 WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_TrainingPackageObjectiveDescription'), packageName +
		 ' Objective #1 Test Description')
		 'Set blue team complexity to medium'
		 WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageBlueDefensiveComplexityMedium'))
		 'Set red thread severity to medium'
		 WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageRedThreatSeverityMedium'))
		 'Set meets expectations'
		 WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageTargetScoreMeetsExpectations'), '25')
		 'Set exceeds expectations'
		 WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageTargetScoreExceedsExpectations'), '51')
		 'Select time requirement'
		 WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageTimeRequirementsNone'))
		 'Select threshold'
		 WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageDegradationThreshold'), '2')
		 'Advance to next tab'
		 WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageObjectiveNext'))
		 */
		/*
		'No prerequisites'
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_TrainingPackagePrerequisitesNext'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackagePrerequisitesNext'))

		'Click "Add Content Modules"'
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddContentModules'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddContentModules'))
		TestSupport.delay(1)

		'Select our content module'
		WebUI.click(findTestObject('Page_PCTE Portal/div_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleNameToLink]))

		'Click "Add to Package"'
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddToPackage'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddToPackage'))
		TestSupport.delay(1)

		'Advance to next tab'
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageModulesNext'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageModulesNext'))
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAssessmentsNext'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAssessmentsNext'))
		/*
		 WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageOptionsNext'), 30)
		 WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageOptionsNext'))
		 */

		/*
		'Click "Confirm" to create the training package'
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageConfirm'))

		'Delay a second to let confirmation page load'
		TestSupport.delay(1)
		*/
	}


	void deleteTrainingPackage(String packageName)
	{
		/*
		'Open the Dashboard (apps)'
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

		'Delay for a second for Dashboard to open'
		TestSupport.delay(1)

		'Select the Content area (app)'
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

		'Click on "Training Packages"'
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

		'Wait a second'
		TestSupport.delay(1)

		'Set text to search for'
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), packageName)

		'Wait for page to load'
		TestSupport.delay(1)

		'Get our test'
		TestObject specificTest = findTestObject('Page_PCTE Portal/a_Content_TrainingPackageListSpecificTest', [('specificTestName') : packageName])

		'If we find our test, delete it'
		if (TestSupport.isObjectPresent(specificTest))
		{
			'Click "more"'
			WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/i_Content_TrainingPackagesMore'))

			'Click delete'
			WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/span_Content_TrainingPackagesDelete'))

			'Wait for pop-up window'
			TestSupport.delay(1)

			'Confirm that the project should be deleted'
			WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackagesConfirmDelete'))
		}
		*/
	}


	void deleteTrainingPackageDocuments(String packageName)
	{
		/*
		'Go to portal home page again to make sure that there are no pop ups getting in the way'
		WebUI.navigateToUrl(GlobalVariable.portal_url)

		'Wait 3 seconds for the portal page to appear fully'
		TestSupport.delay(3)

		'Open the Dashboard (apps)'
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

		'Delay for a second for Dashboard to open'
		TestSupport.delay(1)

		'Select the Content area (app)'
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

		'Click on "Content Modules"'
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackages'))

		'Set text to search for'
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), packageName)

		'Wait for page to load'
		TestSupport.delay(1)

		'Get our test'
		TestObject specificTest = findTestObject('Page_PCTE Portal/a_Content_TrainingPackageListSpecificTest', [('specificTestName') : packageName])

		'If we find our test, delete it'
		if (TestSupport.isObjectPresent(specificTest, 3))
		{
			// Open our new module and pause for it to load
			WebUI.click(findTestObject('Page_PCTE Portal/a_Content_TrainingPackageListSpecificTest', [('specificTestName') : packageName]))
			TestSupport.delay(1)

			// Switch to "Documents" tab
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Content_TrainingPackageDocuments'), 30)
			WebUI.click(findTestObject('Page_PCTE Portal/a_Content_TrainingPackageDocuments'))

			// Loop over documents and delete each one
			TestObject doc = findTestObject('Page_PCTE Portal/span_Content_TrainingPackageDocumentName')
			while (TestSupport.isObjectPresent(doc, 3))
			{
				// Open the "more" menu
				WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageDocumentsMoreVert'))

				// Click "Delete Document"
				WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_TrainingPackageDeleteDocument'), 30)
				WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackageDeleteDocument'))

				// Pause and then check for next document
				TestSupport.delay(2)
				doc = findTestObject('Page_PCTE Portal/span_Content_TrainingPackageDocumentName')
			}
		}
		*/
	}


	public void createEmptyNetworkSpec(String specName)
	{
		/*
		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Wait for the page to load
		TestSupport.delay(3);

		// Click on the application button in the upper left corner
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'));

		// Wait briefly for the apps menu to load
		TestSupport.delay(3);

		// Click on the Content icon
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'));

		// Wait for the Content app to load
		TestSupport.delay(2);

		// Click on the Network Spec section of the Content app
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'));

		// Wait for the Network Spec section to load
		TestSupport.delay(2);

		// Click on the Ellipses button to open more options for network spec creation
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewSpecEllipsis'));

		// Create a new empty network spec
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NewEmptySpec'));

		// Wait for the popup dialog to appear
		TestSupport.delay(1);

		// Input the name of the new project based on the configuration parameter
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_NewSpecName'), specName);

		// Wait for the name of project to get set
		TestSupport.delay(1);

		// Click the Create Customer Project button
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_CreateProject'));
		
		*/
	}


	public void createAndImportNetworkSpec(String specName, String fileToImport)
	{
		/*
		// Create the network spec with the given name
		createEmptyNetworkSpec(specName);

		// Wait for the spec creation to complete
		TestSupport.delay(1);

		// Click the import spec button
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ImportDefinition'));

		// Wait for the import popup to appear
		TestSupport.delay(1);

		// Send input keys that write in the file path where the import file is located in order to load the correct yaml file
		WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Content_UploadYAMLFile'), RunConfiguration.getProjectDir() + "/Data Files/" + fileToImport);

		// Wait for the upload to finish. This may require a larger delay based on the complexity of the definition file used
		TestSupport.delay(5);

		// Click to import the file that was written into the upload yaml file input
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_FinalizeYAMLUpload'));

		// Wait for the finalization to finish. This may require a larger delay based on the complexity of the definition file used
		TestSupport.delay(5);
		*/
	}

	public void deleteNetworkSpec(String specName)
	{
		/*
		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Wait for the page to load
		TestSupport.delay(3);

		// Click on the application button in the upper left corner
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'));

		// Wait briefly for the apps menu to load
		TestSupport.delay(3);

		// Click on the Content icon
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'));

		// Wait for the Content app to load
		TestSupport.delay(2);

		// Click on the Network Spec section of the Content app
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'));

		// Wait for the Network Spec section to load
		TestSupport.delay(2);

		// Check to see if the network spec was created in the test case
		def networkSpecDiv = findTestObject('Page_PCTE Portal/a_Content_DynamicNetworkSpecLink', [('specName') : specName]);

		if (TestSupport.isObjectPresent(networkSpecDiv)) {
			// Click on the spec
			WebUI.click(networkSpecDiv);

			// Wait for the network spec page to load
			TestSupport.delay(1);

			// Click on the edit button
			WebUI.click(findTestObject('Page_PCTE Portal/button_Content_EditNetworkSpec'));

			// Click on the default version in order to make the delete button appear
			WebUI.click(findTestObject('Page_PCTE Portal/div_Content_NetworkSpecDraftVersion'));

			// Click on the delete button
			WebUI.click(findTestObject('Page_PCTE Portal/button_Content_DeleteCustomerProject'));

			// Wait for the delete popup to display
			TestSupport.delay(1);

			// Confirm the deletion
			WebUI.click(findTestObject('Page_PCTE Portal/span_HardHat_Yes-Delete-Project'));
		}
		*/
	}


	public void createExerciseEvent(String eventName)
	{
		/*
		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url);
		*/
		/*
		 // Wait for the page to load
		 WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30);
		 // Click on the apps button
		 WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'));
		 // Wait for the Apps dashboard to appear
		 WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30);
		 // Click on the Events app
		 WebUI.click(findTestObject('Page_PCTE Portal/span_Events'));
		 // Make sure we are in Team Event area
		 WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_TeamEventOutlook'), 30)
		 WebUI.click(findTestObject('Page_PCTE Portal/span_Events_TeamEventOutlook'))
		 // Click create event
		 WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_ScheduleExerciseEvent'), 30);
		 WebUI.click(findTestObject('Page_PCTE Portal/span_Events_ScheduleExerciseEvent'));
		 */
		/*
		// Wait for Create button and then select it
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Dashboard_Create'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Dashboard_Create'))

		// Wait for and click on "Event"
		WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/span_Dashboard_CreateEvent'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Dashboard_CreateEvent'))
		TestSupport.delay(1)

		// Click "Legacy Exercise Event"
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Dashboard_SelectLegacyExerciseEvent'), 30);
		WebUI.click(findTestObject('Page_PCTE Portal/a_Dashboard_SelectLegacyExerciseEvent'));
		TestSupport.delay(1)

		// Wait for the popup to appear
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Admin_NewEventName'), 30);

		// Enter the name of the new event as per the parameter
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Admin_NewEventName'), eventName);
		TestSupport.delay(1);

		// Enter a description for the new event
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Events_NewEventDescription'), 'This event was created by an automated script');
		TestSupport.delay(1);
		*/
		// This is a workaround because clicking on the Create Event button does not work currently
		// It marks the step as completed but does not actually click
		/*
		 WebUI.focus(findTestObject('Page_PCTE Portal/button_Admin_CreateEventFinalize'));
		 TestSupport.delay(1);
		 WebUI.sendKeys(findTestObject('Page_PCTE Portal/button_Admin_CreateEventFinalize'), Keys.chord(Keys.ENTER));
		 */
		/*
		WebUI.click(findTestObject('Page_PCTE Portal/button_Admin_CreateEventFinalize'));

		// Wait for the event to be created
		TestSupport.delay(2);
		*/
	}


	public void addParticipantsToExerciseEvent(String eventName, String[] participants)
	{
		/*
		// Go to the home page
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Wait for the Apps button to appear
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30);

		// Click on the Apps button
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'));

		// Wait for the Apps dashboard to appear
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30);

		// Click on the Events app
		WebUI.click(findTestObject('Page_PCTE Portal/span_Events'));

		// Make sure we are in Live Action Event area
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_LiveActionEvents'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Events_LiveActionEvents'))

		// Wait for the Events page to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30);

		// Enter the name of the newly-created event into the search box
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName);

		// Wait for the event item to appear
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]), 30);

		// View the newly-created event
		WebUI.click(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]));
		TestSupport.delay(1);

		// Wait for the event page to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_Management'), 30);

		// Click on the Management tab
		WebUI.click(findTestObject('Page_PCTE Portal/span_Events_Management'));

		// Wait for the Management tab to open
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_EventParticipants'), 30);

		// Click on the Participants tab
		WebUI.click(findTestObject('Page_PCTE Portal/span_Events_EventParticipants'));

		// Wait for the participants page to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_EditParticipants'), 30);

		// Open the Edit Participant dialog
		WebUI.click(findTestObject('Page_PCTE Portal/button_Events_EditParticipants'));

		// Add each of the given participants to the event
		for (int currParticipant = 0; currParticipant < participants.length; currParticipant++)
		{
			// Wait for the participant dialog to load
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Admin_EventParticipantFilter'), 30);

			// Enter the name of the first user into the participant filter
			WebUI.setText(findTestObject('Page_PCTE Portal/input_Admin_EventParticipantFilter'), participants[currParticipant]);

			// Fetch the participant item on the event page that will be used for picking the participant
			TestObject dynamicParticipantItem = findTestObject('Page_PCTE Portal/label_Events_DynamicParticipantSelectionCheckbox', [('participantName') : participants[currParticipant]]);

			// Wait for the participant page to load
			WebUI.waitForElementPresent(dynamicParticipantItem, 60);

			// Select the participant by clicking the checkbox next to the participants name
			WebUI.click(dynamicParticipantItem);

			// Select the All Session Viewer role
			WebUI.click(findTestObject('Page_PCTE Portal/label_Events_AllSessionViewerCheckbox'));

			// Select the All Network Viewer role
			WebUI.click(findTestObject('Page_PCTE Portal/label_Events_AllNetworkViewerCheckbox'));
		}

		// This is a workaround because clicking the button does not work
		WebUI.focus(findTestObject('Page_PCTE Portal/button_Events_ApplyClose'));

		// Send the Enter key to the Apply & Close button to activate it
		WebUI.sendKeys(findTestObject('Page_PCTE Portal/button_Events_ApplyClose'), Keys.chord(Keys.ENTER));

		// Wait for the Participant page to load back up
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Events_SaveChanges'), 30);

		// Click on the Save Changes button
		WebUI.click(findTestObject('Page_PCTE Portal/button_Events_SaveChanges'));

		// Wait for the operation to complete
		TestSupport.delay(1)
		*/
	}


	public void archiveExerciseEvent(String eventName)
	{
		/*
		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Wait for the page to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30);

		// Click on the Apps button
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'));

		// Wait briefly for the app dashboard to appear
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30);

		// Click on the Events app
		WebUI.click(findTestObject('Page_PCTE Portal/span_Events'));

		// Make sure we are in Live Action Event area
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_LiveActionEvents'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Events_LiveActionEvents'))

		// Wait for the Events page to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 120);

		// Enter the desired event into the search bar
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName);

		// Check to see if the given exercise event exists
		def eventView = findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]);
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]), 120);
		if (TestSupport.isObjectPresent(eventView))
		{
			// View the event that needs to be archived
			WebUI.click(eventView);

			// Wait for the event page to load
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_Management'), 30);

			// Click on the Management section
			WebUI.click(findTestObject('Page_PCTE Portal/span_Events_Management'));

			// Wait for the management page to load and then click to archive event
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/i_Events_EventMoreVert'), 30);
			WebUI.click(findTestObject('Page_PCTE Portal/i_Events_EventMoreVert'));
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_ArchiveEvent'), 30);
			WebUI.click(findTestObject('Page_PCTE Portal/span_Events_ArchiveEvent'));

			// Wait for the confirmation popup
			WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Admin_ConfirmArchive'), 30);

			// Click on the confirmation button
			WebUI.click(findTestObject('Page_PCTE Portal/button_Admin_ConfirmArchive'));

			// Wait for the archive operation to complete
			TestSupport.delay(1);
		}
		*/
	}


	public void addUserToExerciseEvent(String eventName, String userName)
	{
		/*
		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Wait for the page to load
		TestSupport.delay(3);

		// Click on the apps button
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'));

		// Wait 3 seconds for the Apps dashboard to appear
		TestSupport.delay(3);

		// Click on the Events app
		WebUI.click(findTestObject('Page_PCTE Portal/span_Apps_Events'));

		// Wait for the app to load
		TestSupport.delay(2);

		// Check to see if the given exercise event exists
		def eventView = findTestObject('Page_PCTE Portal/button_Admin_DynamicViewEditEvent', [('eventName') : eventName]);
		if (TestSupport.isObjectPresent(eventView))
		{
			// View the event that needs to be archived
			WebUI.click(eventView);

			// Wait for the exercise event to load
			TestSupport.delay(1);

			// Select the participants tab of the exercise event
			WebUI.click(findTestObject('Page_PCTE Portal/li_Admin_EventParticipants'));

			// Wait for the participant tab to load
			TestSupport.delay(1);

			// Filter the participants tab by the name that is going to be added as a member
			WebUI.setText(findTestObject('Page_PCTE Portal/input_Admin_EventParticipantFilter'), userName);

			// Wait for the participant list to filter
			TestSupport.delay(1);

			// Click on the event pemission box for the user that is being added
			WebUI.click(findTestObject('Page_PCTE Portal/div_Admin_EventPermission'));

			// Wait for the dropdown list to populate for the event permissions
			TestSupport.delay(1);

			// Click on the event member option in the drop down list for the participant
			WebUI.click(findTestObject('Page_PCTE Portal/div_Admin_EventMemberItem'));
		}
		*/
	}


	public void deleteCloneSource(String specName, String cloneName)
	{
		/*
		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Wait briefly for the apps menu to load
		TestSupport.delay(1);

		// Click on the application button in the upper left corner
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'));

		// Wait briefly for the apps menu to load
		TestSupport.delay(3);

		// Click on the Content icon
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'));

		// Click on the Network Spec section of the Content app
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'));

		// Wait for the Network Spec section to load
		TestSupport.delay(3);

		// Check to see if the network spec was created in the test case
		def networkSpecDiv = findTestObject('Page_PCTE Portal/a_Content_DynamicNetworkSpecLink', [('specName') : specName]);

		if (WebUI.verifyElementVisible(networkSpecDiv, FailureHandling.OPTIONAL))
		{
			// Click on the spec
			WebUI.click(networkSpecDiv);

			// Click on the edit button
			WebUI.click(findTestObject('Page_PCTE Portal/button_Content_EditNetworkSpec'));

			// Click on the clone source tab
			WebUI.click(findTestObject('Page_PCTE Portal/li_Content_CloneSourceTab'));

			// Allow the screen to load
			TestSupport.delay(3);

			// Look for the clone source name and find the correct ellipses
			def cloneSourceDiv = findTestObject('Page_PCTE Portal/div_Content_DynamicCloneSourceEllipsis', [('specName') : cloneName]);

			if (WebUI.verifyElementVisible(cloneSourceDiv, FailureHandling.OPTIONAL))
			{
				WebUI.click(cloneSourceDiv);

				// Select the option to delete the clone source
				WebUI.click(findTestObject('Page_PCTE Portal/span_Content_DeleteCloneSource'));

				// Type in the name of the clone source to verify the deletion
				WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_DeleteCloneSourceNameConfirmation'), cloneName);

				// Delay to give the button time to become clickable
				TestSupport.delay(3);

				// Click the delete button in the pop up to delete the clone source
				WebUI.click(findTestObject('Page_PCTE Portal/button_Content_DeleteCloneSource'));
			}
		}
		*/
	}


	public void createDeployment(String specName, String deploymentName, String eventName, String vmConfigurationFilename, Number maxDeploymentTime)
	{
		/*
		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Wait for the page to load
		TestSupport.delay(3);

		// Click on the application button in the upper left corner
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'));

		// Wait briefly for the apps menu to load
		TestSupport.delay(3);

		// Click on the Content icon
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'));

		// Click on the Network Spec section of the Content app
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'));

		// Wait three seconds for the network spec to show up
		TestSupport.delay(2);

		// Check to see if the network spec was created in the test case
		def networkSpecDiv = findTestObject('Page_PCTE Portal/a_Content_DynamicNetworkSpecLink', [('specName') : specName]);

		if (TestSupport.isObjectPresent(networkSpecDiv)) {
			// Click on the spec
			WebUI.click(networkSpecDiv);

			// Wait for the network spec to load
			TestSupport.delay(1);

			// Click on the edit button
			WebUI.click(findTestObject('Page_PCTE Portal/button_Content_EditNetworkSpec'));

			// Wait for the project page to load
			TestSupport.delay(1);

			//Click on the new version 1
			WebUI.click(findTestObject('Page_PCTE Portal/div_Content_NetworkSpecVersion1'));

			// Click on the New Deployment button
			WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NewDeployment'));

			TestSupport.delay(2);

			// Focus on the popup window
			WebUI.focus(findTestObject('Page_PCTE Portal/div_Content_HardHatDeploymentFrame'));

			// Set the name of the deployment according to configuration parameters
			WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_DeploymentName'), deploymentName);

			TestSupport.delay(5);

			// Hit the 'TAB' key to take focus away from the deployment name text box. This is a kludge necessary for the 'Create' button to appear
			WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Content_DeploymentName'), Keys.chord(Keys.TAB));

			TestSupport.delay(5);

			// Click on the Create button
			WebUI.click(findTestObject('Page_PCTE Portal/button_Content_DeploymentCreate'));

			TestSupport.delay(5);

			// Open the network range selection dropdown
			WebUI.click(findTestObject('Page_PCTE Portal/span_Content_RangeControlSelectArrow'));

			// Pick the first valid option on this list
			WebUI.click(findTestObject('Page_PCTE Portal/div_Content_RangeControlFirstOption'));

			TestSupport.delay(2);

			//Click on the Review Deployment tab
			WebUI.click(findTestObject('Page_PCTE Portal/li_Content_ReviewDeployment'));

			// Wait for the VM list to load
			WebUI.delay(5);

			// Set up the VM configuration according to the configuration CSV file
			configureDeployment(new CSVData((RunConfiguration.getProjectDir() + '/Data Files/') + vmConfigurationFilename, true, CSVSeparator.COMMA));

			TestSupport.delay(5);

			// Open the Summary tab of the Deployment dialog
			WebUI.click(findTestObject('Page_PCTE Portal/li_Content_DeploymentSummary'));

			TestSupport.delay(2);

			// Open the Select Event dropdown
			WebUI.click(findTestObject('Page_PCTE Portal/div_Content_DeploySelectEvent'));

			TestSupport.delay(1);

			// Enter the name of the exercise event that was created earlier in the startup function of this test case
			WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_DeploySelectEvent'), eventName);

			TestSupport.delay(1);

			// Pick the exercise event
			WebUI.click(findTestObject('Page_PCTE Portal/div_Content_DynamicDeployEventItem', [('eventName') : eventName]));

			TestSupport.delay(1);

			// Click Build Deployment to start the deployment
			WebUI.click(findTestObject('Page_PCTE Portal/button_Content_BuildDeployment'));

			def currIteration = 0;

			// Wait while the deployment is being started. The maximum wait time can be set in the test case variables
			while (!(TestSupport.isObjectPresent(findTestObject('Page_PCTE Portal/div_Content_DeploymentCompleted'))) && (currIteration < maxDeploymentTime)) {
				WebUI.delay(60);

				currIteration++;
			}
		}
		*/
	}


	public void configureDeployment(CSVData vmDataFile)
	{
		/*
		// Go through each of the rows in the VM configuration data file
		for (int currRow = 1; currRow <= vmDataFile.getRowNumbers(); currRow++)
		{
			// Fetch the name of the VM being currently configured
			String vmName = vmDataFile.getValue(1, currRow);

			// Fetch whether the VM should be included or not
			boolean include = false;
			if (vmDataFile.getValue(2, currRow) == "yes")
			{
				include = true;
			}

			// Fetch the name of the VM template to be used for the VM
			String vmTemplate = vmDataFile.getValue(3, currRow);

			// Fetch the provision action for the current VM
			String provisionAction = vmDataFile.getValue(4, currRow);

			// Search for the VM in the VM configuration
			WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_DeploymentVMSearch'), vmName);
			WebUI.delay(5);

			// Now that the configuration data has been gathered, the first step
			// is to check whether the VM template needs to be changed from the spec template
			String xpath;
			String xPathString;
			if (!vmTemplate.equals("Use Spec Template"))
			{
				// Create a test object for the VM template dropdown
				TestObject vmTemplateDropdown = new TestObject();

				// Form the XPath for the VM template dropdown
				xPathString =
						"//div[@class = \'vm\' and .//div[@class = \'text\' and (text() = \'%s\')]]//div[@class = \'template\']//span[@class = 'Select-arrow-zone']";

				// Form the full XPath with the VM name
				xpath = String.format(xPathString, vmName);

				// Add the XPath as a property to the template dropdown test object
				vmTemplateDropdown.addProperty('xpath', ConditionType.EQUALS, xpath);

				// Click on the dropdown
				WebUI.click(vmTemplateDropdown);

				// Next step is to choose the desired VM template from the dropdown
				// Create a new test object for the desired template dropdown item
				TestObject vmTemplateItem = new TestObject();

				// Form the XPath for the VM template item
				xPathString = "//div[@role = \'option\' and (text() = \'%s\')]";

				// Form the XPath for the VM template item
				xpath = String.format(xPathString, vmTemplate);

				// Add the XPath as a property to the template item test object
				vmTemplateItem.addProperty('xpath', ConditionType.EQUALS, xpath);

				// Click on the dropdown item
				WebUI.click(vmTemplateItem);
			}

			// Next step is to click on the provision action dropdown
			// Create a test object for the provision action dropdown
			TestObject provisionActionDropdown = new TestObject();

			// Form the basis of the XPath for the provision action dropdown
			xPathString =
					"//div[contains(@class, 'vm') and ./div[@class = 'name ' and ./div[@class = 'text' and text() = '%s']]]/div[@class = 'post']//span[@class = 'Select-multi-value-wrapper']";

			// Form the full XPath for the provision action dropdown
			xpath = String.format(xPathString, vmName);

			// Add the XPath as a property to the provision action dropdown
			provisionActionDropdown.addProperty('xpath', ConditionType.EQUALS, xpath);

			// Click on the provision action dropdown
			WebUI.click(provisionActionDropdown);

			// Give some time for the dropdown to show up
			WebUI.delay(1);

			// The final step is to pick the provision action from the dropdown menu
			// Create a test object for the provision action dropdown menu item
			TestObject provisionActionItem = new TestObject();

			// Form the basis of XPath for the provision action item
			xPathString = "//div[@role = 'option' and (text() = '%s')]";

			// Form the full XPath for the provision action item
			xpath = String.format(xPathString, provisionAction);

			// Add the XPath as a property to the provision action item
			provisionActionItem.addProperty('xpath', ConditionType.EQUALS, xpath);

			// Click on the provision action item
			WebUI.click(provisionActionItem);

			// Wait for the change to be processed
			WebUI.delay(5);
		}
		*/
	}


	public void stopRange(String rangeName)
	{
		/*
		// Get the instance of the test support class
		TestSupport support = TestSupport.getInstance();

		// Get the instance of the shared test data class
		SharedTestData sharedData = SharedTestData.getInstance();

		// Navigate back to the home page to clear any popups
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Wait for the page to load
		TestSupport.delay(5);

		WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/button_Apps'), 5)

		'Open the Apps menu'
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

		TestSupport.delay(2)

		'Click on the Content app'
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

		TestSupport.delay(5)

		'Click on the Ranges section'
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_Ranges'))

		TestSupport.delay(5)

		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_RangeFilter'), rangeName)

		TestSupport.delay(5)

		'Check to see if a range was created in this test case'
		if (TestSupport.isObjectPresent(findTestObject('Page_PCTE Portal/a_Ranges_DynamicRangeLink', [('text') : rangeName]))) {
			'Enter the range'
			WebUI.click(findTestObject('Page_PCTE Portal/a_Ranges_DynamicRangeLink', [('text') : rangeName]))

			TestSupport.delay(2)

			'Check to see if the Stop Network button is present. This button may not be present if the network was already stopped'
			if (TestSupport.isObjectPresent(findTestObject('Page_PCTE Portal/button_Content_RangesStopNetwork')))
			{
				'Click the Stop Network button'
				WebUI.click(findTestObject('Page_PCTE Portal/button_Content_RangesStopNetwork'))

				TestSupport.delay(2)

				'Click the confirm button'
				WebUI.click(findTestObject('Page_PCTE Portal/button_Content_RangesStopNetworkConfirm'))

				'Check the status span to see if any VMs are still running or shutting down, and delay until all are shut down'
				String vmStatus = WebUI.getText(findTestObject('Page_PCTE Portal/span_Content_RangesVMStatus'))

				'Keep waiting until all VMs are stopped or the maximum time of 5 minutes is reached'
				def currIter = 0

				while ((vmStatus.contains('running') || vmStatus.contains('transitioning')) && (currIter < 30)) {
					WebUI.delay(10)

					'Increment the timer'
					currIter++

					'Get the current status on the VMs in the range'
					vmStatus = WebUI.getText(findTestObject('Page_PCTE Portal/span_Content_RangesVMStatus'))
				}
			}
		}
		*/
	}


	public void deleteDeployment(String specName, String deploymentName)
	{
		/*
		// Go to the PCTE test portal
		WebUI.navigateToUrl(GlobalVariable.portal_url);

		// Wait for the page to load
		TestSupport.delay(3);

		// Click on the application button in the upper left corner
		WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'));

		// Wait briefly for the apps menu to load
		TestSupport.delay(3);

		// Click on the Content icon
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content'));

		// Click on the Network Spec section of the Content app
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'));

		// Wait three seconds for the network spec to show up
		TestSupport.delay(2);

		// Check to see if the network spec was created in the test case
		def networkSpecDiv = findTestObject('Page_PCTE Portal/a_Content_DynamicNetworkSpecLink', [('specName') : specName]);

		if (TestSupport.isObjectPresent(networkSpecDiv)) {
			// Click on the spec
			WebUI.click(networkSpecDiv);

			// Wait for the network spec to load
			TestSupport.delay(1);

			// Click on the edit button
			WebUI.click(findTestObject('Page_PCTE Portal/button_Content_EditNetworkSpec'));

			// Wait for the project page to load
			TestSupport.delay(1);

			// Check to see if the deployment was created in the test case
			def deploymentDiv = findTestObject('Page_PCTE Portal/div_Content_DeploymentEllipsis', [('deploymentName') : deploymentName]);
			if (TestSupport.isObjectPresent(deploymentDiv)) {
				// Click on the ellipsis menu for the deployment
				WebUI.click(findTestObject('Page_PCTE Portal/div_Content_DeploymentEllipsis', [('deploymentName') : deploymentName]))

				// Attempt to stop any deployment that may be happening currently
				WebUI.click(findTestObject('Page_PCTE Portal/div_Content_DeploymentAbort'), FailureHandling.OPTIONAL)

				// Wait for any potential abortion to stop
				TestSupport.delay(10)

				// Click on the Delete item
				WebUI.click(findTestObject('Page_PCTE Portal/span_Content_DeploymentDelete'))

				// Input the name of the deployment for confirming the deletion
				WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_DeleteDeploymentName'), deploymentName)

				// Wait for the confirmation button to appear
				WebUI.delay(2)

				// Confirm the deletion
				WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ConfirmDeleteDeployment'))

				// Wait for the deployment to be deleted
				def i = 0;
				while (TestSupport.isObjectPresent(findTestObject('Page_PCTE Portal/div_Content_DeploymentStatusDeleting')) && i < 30) {
					TestSupport.delay(10);
					i++;
				}
			}
		}
		*/
	}
	
}

