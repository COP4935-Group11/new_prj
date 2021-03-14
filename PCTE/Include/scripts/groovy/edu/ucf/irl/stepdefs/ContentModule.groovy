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


class ContentModule {
	private void uploadFileOld(String filename) {
		// Get filename in native format
		String upload = new java.io.File(filename).getAbsoluteFile()

		// Put filename into the clipboard
		StringSelection ss = new StringSelection(upload)
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null)

		// Use the robot to paste clipboard into native file browser
		Robot robot = new Robot()
		robot.keyPress(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_CONTROL)
		robot.keyRelease(KeyEvent.VK_V)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)

		// Pause to let upload happen
		TestSupport.delay(10)
	}


	private void uploadFile(TestObject obj, String filename) {
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


	private void uploadFile2(TestObject obj, String filename) {
		// Get filename in native format
		String absoluteFilename = new java.io.File(filename).getAbsoluteFile()

		// Send the filename to the "input" file field
		WebUI.sendKeys(obj, absoluteFilename)
		TestSupport.delay(1)
		//WebUI.sendKeys(obj, Keys.chord(Keys.ENTER))
		//WebUI.setText(obj, absoluteFilename)
		TestSupport.delay(1)

		// Submit the form
		WebUI.submit(obj)

		// Pause to let upload happen
		TestSupport.delay(5)
	}

	// ============================================================================================================================


	// shareAContentModule.feature

	@Given("I do not have permission to view the content module")
	def ensureModuleNotShared()
	{
		//

		// TODO
	}


	@Given("An Organization exists with test users")
	def ensureOrgExistsWithUsers()
	{
		//
	}


	// uploadDocumentsToContentModule.feature

	@Given("I have had a Content Module shared with me")
	def shareContentModuleWithMe()
	{
		//
	}


	// ============================================================================================================================


	// createAndEditModule.feature

	@When("I create a new content module")
	def startCreatingContentModule()
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
	}


	@When("I provide the Name, Description, Duration, and Tasks")
	def fillParameters()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleName")

		// Enter name and description for Content Module
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleName'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleName'), moduleName)
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleDescription'), 'Create a content module with one of each task type.')

		// Set duration to 1 day
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleDuration'), '1')

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

		// Add a task (information)
		WebUI.click(findTestObject('Page_PCTE Portal/i_Content_ContentModuleAddTaskType'))
		WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/span_Content_ContentModuleInformationTask'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleInformationTask'))
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleAddTask'))

		// Enter the question
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), "Thanks for testing PCTE!")
		TestSupport.delay(2)

		// Add a task (a question again)
		WebUI.click(findTestObject('Page_PCTE Portal/i_Content_ContentModuleAddTaskType'))
		TestSupport.delay(1)
		WebUI.waitForElementClickable(findTestObject('Page_PCTE Portal/span_Content_ContentModuleQuestionTask'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleQuestionTask'))
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleAddTask'))

		// Enter short answer question and answer
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 'How many stripes are on the U.S. flag?')
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleAnswer'), '13')
		TestSupport.delay(2)

		// Click create!
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleCreate'))
		TestSupport.delay(5)
	}


	@When("I update a content module with new Tasks")
	def updateContentModule()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleToUse")

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

		// Set text to search for
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)

		// Open our new module and pause for it to load
		WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]))
		TestSupport.delay(1)

		// Click on "Edit Content Module"
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_EditContentModule'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_EditContentModule'))

		// Create a task chain
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleCreateNewChain'))

		// Enter short answer question and answer
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleNewQuestion1'), 'How many amendments make up the Bill of Rights?')
		WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_ContentModuleAnswer'), '10')
		TestSupport.delay(2)

		// Click update!
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleUpdate'))
		TestSupport.delay(5)
	}


	// uploadDocumentsToContentModule.feature

	@When("I upload the documents to the Content Module")
	def uploadDocumentsToContentModule()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleToUse")

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

		// Set text to search for
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)
		TestSupport.delay(1)

		// Open our new module and pause for it to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]))
		TestSupport.delay(1)

		// Upload a doc file into the module
		uploadFile(findTestObject('Page_PCTE Portal/input_Content_ContentModuleUploadDoc'),
				RunConfiguration.getProjectDir() + '/Data Files/PCTE-Test-Document.doc')

		// Upload a ppt file into the module
		uploadFile(findTestObject('Page_PCTE Portal/input_Content_ContentModuleUploadDoc'),
				RunConfiguration.getProjectDir() + '/Data Files/PCTE-Test-Document.ppt')

		// Upload an xml file into the module
		uploadFile(findTestObject('Page_PCTE Portal/input_Content_ContentModuleUploadDoc'),
				RunConfiguration.getProjectDir() + '/Data Files/PCTE-Test-Document.xml')
	}


	@When("I upload the documents to the Content Module chain")
	def uploadDocumentsToContentModuleChain()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleToUse")

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

		// Set text to search for
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)

		// Open our new module and pause for it to load
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]))
		TestSupport.delay(1)

		// Click on "Edit Content Module"
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_EditContentModule'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_EditContentModule'))
		TestSupport.delay(1)

		TestSupport.delay(60)


		// Upload a doc file into the task
		uploadFile2(findTestObject('Page_PCTE Portal/input_Content_ContentModuleTaskUploadDoc'),
				RunConfiguration.getProjectDir() + '/Data Files/PCTE-Test-Document.doc')

		// Upload a ppt file into the task
		uploadFile2(findTestObject('Page_PCTE Portal/input_Content_ContentModuleTaskUploadDoc'),
				RunConfiguration.getProjectDir() + '/Data Files/PCTE-Test-Document.ppt')

		// Upload a xml file into the task
		uploadFile2(findTestObject('Page_PCTE Portal/input_Content_ContentModuleTaskUploadDoc'),
				RunConfiguration.getProjectDir() + '/Data Files/PCTE-Test-Document.xml')

		// Strangely, we do not have to click update
	}


	@When("I create a Training Package using the Content Module")
	def useContentModuleInTrainingPackage()
	{
		//
	}


	@When("I access the shared Content Module")
	def accessSharedContentModule()
	{
		//
	}


	// shareAContentModule.feature

	@When("I select an existing content module")
	def selectExistingContentModule()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleName")

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
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)

		// Open our new module and pause for it to load
		WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]))
		TestSupport.delay(1)
	}


	@When("I search for the existing content module")
	def searchContentModule()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleName")

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
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)
	}


	@When("I give User B permissions to the content module")
	def grantPermissionToContentModule()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleName")

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
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)

		// Open our new module and pause for it to load
		WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]))
		TestSupport.delay(1)

		// Open "more" menu
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_ContentModuleMoreVert'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleMoreVert'))

		// Click "share"
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModuleShare'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ContentModuleShare'))

		// Click a name to share to
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Content_ContentModuleShareName'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/div_Content_ContentModuleShareName'))
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleShareName'), GlobalVariable.user1_name)
		WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Content_ContentModuleShareName'), Keys.chord(Keys.TAB))
		TestSupport.delay(1)

		// List list and view permissions
		WebUI.click(findTestObject('Page_PCTE Portal/i_Content_ContentModuleShareList'))
		WebUI.click(findTestObject('Page_PCTE Portal/i_Content_ContentModuleShareView'))

		// Share!
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleShareShare'))
		TestSupport.delay(1)

		// Save the share data
		WebUI.click(findTestObject('Page_PCTE Portal/button_Content_ContentModuleShareSave'))
	}


	@When("I give the organization and descendants permissions")
	def grantOrgPermissionToContentModule()
	{
		//
	}


	// ============================================================================================================================


	// createAndEditModule.feature

	@Then("I should see the content module in the content library")
	def verifyCreatedContentModule()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleName")

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
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)

		// Open our new module and pause for it to load
		WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]))
		TestSupport.delay(1)

		// Verify content module (item type, status, published field, task count)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 30)
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 'Content Module')
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleStatus'), 'Published')
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModulePublished'), 'Published')
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleQuestionCount'), '4')

		// Wait one second
		TestSupport.delay(1)

		// Delete our module and use SharedTestData since we are in teardown
		data.deleteContentModule(moduleName)
	}


	@Then("I should see the new Tasks in the content module")
	def verifyEditedContentModule()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleToUse")

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

		// Set text to search for
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)

		// Open our new module and pause for it to load
		WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]))
		TestSupport.delay(1)

		// Verify content module (item type, status, published field, task count)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 30)
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 'Content Module')
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleStatus'), 'Published')
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModulePublished'), 'Published')
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleQuestionCount'), '4')

		// Wait one second
		TestSupport.delay(1)
	}


	// uploadDocumentsToContentModule.feature

	@Then("I should see the documents uploaded to the Content Module")
	def verifyUploadedDocumentsInContentModule()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleToUse")

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

		// Set text to search for
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)

		// Open our new module and pause for it to load
		WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]))
		TestSupport.delay(1)

		// Switch to "Documents" tab
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Content_ContentModuleDocuments'), 30)
		WebUI.click(findTestObject('Page_PCTE Portal/a_Content_ContentModuleDocuments'))
		TestSupport.delay(1)

		// Verify documents appear in chain
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddedDocFile'), 30)
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddedDocFile'), 'PCTE-Test-Document.doc')
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddedPptFile'), 30)
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddedPptFile'), 'PCTE-Test-Document.ppt')
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddedXmlFile'), 30)
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_Content_ContentModuleAddedXmlFile'), 'PCTE-Test-Document.xml')
	}


	@Then("I should see the documents uploaded to the Content Module chain")
	def verifyUploadedDocumentsInContentModuleChain()
	{
		// Verify documents appear in chain
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Content_ContentModuleTaskAddedDocFile'), 30)
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Content_ContentModuleTaskAddedDocFile'), 'PCTE-Test-Document.doc')
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Content_ContentModuleTaskAddedPptFile'), 30)
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Content_ContentModuleTaskAddedPptFile'), 'PCTE-Test-Document.ppt')
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/div_Content_ContentModuleTaskAddedXmlFile'), 30)
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Content_ContentModuleTaskAddedXmlFile'), 'PCTE-Test-Document.xml')
	}


	@Then("I should see the documents within the package")
	def verifyDocumentsInTrainingPackage()
	{
		//
	}


	@Then("I should see the documents uploaded to the Content Module and its chains")
	def verifyDocumentsInSharedContentModule()
	{
		//
	}


	// shareAContentModule.feature

	@Then("I should see the details of the content module")
	def verifyCanViewContentModule()
	{
		// Verify content module (item type, status, published field, task count)
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 30)
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleItemType'), 'Content Module')
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleStatus'), 'Published')
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModulePublished'), 'Published')
		WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_ContentModuleQuestionCount'), '3')
	}


	@Then("The content module should not appear")
	def verifyCannotViewContentModule()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleName")

		// Make sure content module is not visible
		WebUI.verifyElementNotPresent(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]), 30)
	}


	@Then("User B can access the content module")
	def verifyUserCanViewContentModule()
	{
		// Get test parameters
		SharedTestData data = SharedTestData.getInstance()
		String moduleName = data.getTestParam("contentModuleName")

		// Logout of author and become basic user
		TestSupport support = TestSupport.getInstance()
		support.logout()
		support.login(GlobalVariable.user1_username, GlobalVariable.user1_password, GlobalVariable.user1_key)

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

		// Set text to search for
		WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), 30)
		WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_ContentModuleSearch'), moduleName)

		// Make sure content module is visible
		WebUI.verifyElementPresent(findTestObject('Page_PCTE Portal/a_Content_ContentModuleListSpecificTest', [('specificTestName') : moduleName]), 30)
	}


	@Then("Users in that organization can access the content module")
	def verifyOrgUsersCanViewContentModule()
	{
		//
	}
}
