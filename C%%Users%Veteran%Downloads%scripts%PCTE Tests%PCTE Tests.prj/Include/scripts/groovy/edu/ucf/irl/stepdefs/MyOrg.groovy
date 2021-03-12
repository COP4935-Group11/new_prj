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


import com.kms.katalon.core.webui.common.WebUiCommonHelper //temporary?
import edu.ucf.irl.TestSupport as TestSupport
import org.openqa.selenium.Keys as Keys

class MyOrg {

	//Steps for PCTE-12403 Will Go here

	//Steps for PCTE-13583
	public String generate_13583 = "" //used to store generated user id from PCTE-13583 when user is created
	//GlobalVariable.user1_username
	@Given("I am at the My Organization section of the catalog")
	def goToMyOrg() {
		//Goes to My Org from main portal
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/button_Apps'), 30)
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_Apps'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/a_MyOrg'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/a_MyOrg'))
	}

	@When("I register a new canidate")
	def registerCanidate() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/a_MyOrg_pollCandidates'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/a_MyOrg_pollCandidates'))
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_MyOrg_Register Candidate'))
	}

	@When("Fill out the canidate information")
	def canidateInfo() {
		//TODO
		TestSupport support = TestSupport.getInstance()
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PCTE Portal/button_MyOrg_Generate'), 5)
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/button_MyOrg_Generate'))
		generate_13583 = WebUI.getAttribute(findTestObject('Object Repository/Page_PCTE Portal/input_MyOrg_Candidate ID_TextField'), 'value')

		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/input_MyOrg_Recruiter'))
		support.delay(5)
		String selectRecruiter = "//div[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"+GlobalVariable.orgadmin_name+"')]"
		TestObject selectRecruiterObj = new TestObject().addProperty("xpath", ConditionType.MATCHES_REGEX, selectRecruiter )
		WebUI.click(selectRecruiterObj)

		WebUI.setText(findTestObject('Object Repository/Page_PCTE Portal/input_MyOrg_Contact Email_TextField'), (GlobalVariable.orgadmin_name +"@pcte.mil"))

		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/input_MyOrg_Role'))
		support.delay(5)
		String selectRole = "//*[(text() = 'UCF test role' or . = 'UCF test role')]"
		TestObject selectRoleObj = new TestObject().addProperty("xpath", ConditionType.MATCHES_REGEX, selectRole )
		WebUI.click(selectRoleObj)

		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_PCTE Portal/input_MyOrg_Proficiency'), 5)
		WebUI.click(findTestObject('Object Repository/Page_PCTE Portal/input_MyOrg_Proficiency'))
		support.delay(5)

		WebUI.setText(findTestObject('Object Repository/Page_PCTE Portal/input_MyOrg_Proficiency'), "Novice")
		WebUI.sendKeys(findTestObject('Object Repository/Page_PCTE Portal/input_MyOrg_Proficiency'), Keys.chord(Keys.ENTER))

		//String selectProficiency = "//*[(text() = 'Novice' or . = 'Novice')]"
		//TestObject selectProficiencyObj = new TestObject().addProperty("xpath", ConditionType.MATCHES_REGEX, selectProficiency )
		//WebUI.click(selectProficiencyObj)
	}

	@Then("A canidate will have been created")
	def verifyCanidateCreation(String status) {
		//TODO
	}

	@Then("I should see the canidate information when clicked")
	def verifyCanidateInfo() {
		//TODO
	}
}