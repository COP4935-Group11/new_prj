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


class Portal {

	@Given("I am at the PCTE Content Catalog")
	def gotoContentCatalog() {
		// Go to Content Catalog from main portal
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/button_Apps'), 30)
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Apps'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/a_Content'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/a_Content'))
	}


	// ============================================================================================================================


	@When("I check the VM Templates")
	def gotoVMTemplates()
	{
		// Click on VM Templates once in Content Catalog
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/a_Content_windowsVM Templates'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/a_Content_windowsVM Templates'))
	}


	@When("I check in Training Packages")
	def gotoTrainingPackages()
	{
		// Click on Training Packages once in Content Catalog
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/span_Content_TrainingPackages'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/span_Content_TrainingPackages'))
	}



	// ============================================================================================================================


	// verifyDoDDefaultEnclave(AFG)Content.feature

	@Then("I should see the DOD Enclave VM Template (.*)")
	def checkDoDVMTemplates(String name)
	{
		// Search for object in VM List
		WebUI.setText(findTestObject('Object Repository/Page_PCTE Portal/input_search_icon_s'), name)
		TestSupport.delay(2)

		// Get the object name and verify that it exists
		String path = "//*/text()[normalize-space(.)='" + name + "']/parent::*"
		TestObject VMObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, path)
		WebUI.verifyElementPresent(VMObj, 10)
		WebUI.verifyElementClickable(VMObj)
	}


	// verifyKibana(ESB)Content.feature

	@Then("I should see the ESB content")
	def checkForESBContent()
	{
		// Search for the content
		WebUI.setText(findTestObject('Object Repository/Page_PCTE Portal/input_search_icon_s'), "Navy Elastic Skills Builder")
		TestSupport.delay(2)

		// Verify the ESB can be opened
		WebUI.verifyElementClickable(findTestObject('Object Repository/Page_PCTE Portal/a_Content_Navy Elastic Skills Builder'))
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/a_Content_Navy Elastic Skills Builder'))
		TestSupport.delay(1)
	}


	@Then("I should be able to share the content")
	def checkIfContentIsSharable()
	{
		// Tests whether the content module has a share button
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/button_Content_more_vert'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Content_more_vert'))
		WebUI.verifyElementClickable(findTestObject('Object Repository/Page_PCTE Portal/span_Content_TrainingPackageShare'))
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/span_Content_TrainingPackageShare'))

		// Verify share menu comes up
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_PCTE Portal/div_Content_Share With'), 10)

		// Then, exit out of share menu
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Content_cancel'))
	}


	// verifyBusinessMediumContent.feature

	@Then("I should see the Business Medium VM Template (.*)")
	def checkBMTemplates(String name)
	{
		// Search for object in VM List
		WebUI.setText(findTestObject('Object Repository/Page_PCTE Portal/input_search_icon_s'), name)
		TestSupport.delay(3)

		// Get object name and verify that it exists
		String path = "//*/text()[normalize-space(.)='" + name + "']/parent::*"
		TestObject VMObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, path)
		WebUI.verifyElementPresent(VMObj, 10)
		WebUI.verifyElementClickable(VMObj)
	}


	// verifyHuntContent.feature

	@Then("I should see the Hunt VM Template (.*)")
	def checkHuntTemplates(String name)
	{
		// Search for object in VM List
		WebUI.setText(findTestObject('Object Repository/Page_PCTE Portal/input_search_icon_s'), name)
		TestSupport.delay(3)

		// Get object name and verify that it exists
		String path = "//*/text()[normalize-space(.)='" + name + "']/parent::*"
		TestObject VMObj = new TestObject().addProperty("xpath", ConditionType.EQUALS, path)
		WebUI.verifyElementPresent(VMObj, 10)
		WebUI.verifyElementClickable(VMObj)
	}


	// verifyGT(1-2)Content.feature

	@Then("I should see the GT 1-2 content")
	def checkForGT12Content()
	{
		// TODO
		// Search for the content
		WebUI.setText(findTestObject('Object Repository/Page_PCTE Portal/input_search_icon_s'), "Gunnery Tables 1/2")
		TestSupport.delay(2)

		// Verify the GT1-2 can be opened
		WebUI.verifyElementClickable(findTestObject('Object Repository/Page_PCTE Portal/a_Content_Gunnery Tables 12'))
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/a_Content_Gunnery Tables 12'))
		TestSupport.delay(1)
	}


	// verifyGT(3-6)Content.feature

	@Then("I should see the GT 3-6 content")
	def checkForGT36Content()
	{
		// TODO
		WebUI.verifyElementClickable(findTestObject('Object Repository/Page_PCTE Portal/a_Content_Gunnery Tables 36'))
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/a_Content_Gunnery Tables 36'))
		TestSupport.delay(3)
	}
}