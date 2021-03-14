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


class CoursePlan
{
   @When("I create a new Course Plan with a Training Package")
   def createCoursePlan()
   {
      // Go to the PCTE test portal
      WebUI.navigateToUrl(GlobalVariable.portal_url)

      // Open the Dashboard (apps)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Select the Content area (app)
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

      // Click on "Course Plans"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Content_CoursePlans'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Content_CoursePlans'))

      // Click on "New Course Plan"
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Content_NewCoursePlan'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewCoursePlan'))
   }


   @Then("I should see the updated Course Plan in the content library")
   def verifyCoursePlan()
   {
      //
   }
}
