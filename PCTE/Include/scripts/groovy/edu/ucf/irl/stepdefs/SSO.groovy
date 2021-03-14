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


class SSO
{
   Boolean directly = true


   @When("I access Traffic Tracker via Event")
   def accessTrafficTrackerViaEvent()
   {
      // Get test parameters
      SharedTestData data = SharedTestData.getInstance()
      String eventName = data.getTestParam("exerciseEventToUse")

      // Mark that we are not going there directly (via URL)
      directly = false

      // Wait for the Apps button to appear and then click it
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

      // Wait for the Apps dashboard to appear and then select Events app
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events'))

      // Go to "Live Action" events
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Events_LiveActionEvents'), 30)
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_LiveActionEvents'))

      // Wait for the Events page to load, and then enter event name into search box
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), 30)
      WebUI.setText(findTestObject('Page_PCTE Portal/input_Events_EventSearch'), eventName)

      // Wait for the event item to appear
      WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]), 30)

      // View the newly-created event
      WebUI.click(findTestObject('Page_PCTE Portal/a_Events_DynamicEventItem', [('eventName') : eventName]))

      // Go to Traffic Tracker in event
      WebUI.click(findTestObject('Page_PCTE Portal/span_Events_TrafficTracker'))
   }


   @When("I access Traffic Tracker via URL")
   def accessTrafficTrackerViaURL()
   {
      // Mark that we *are* going there directly (via URL)
      directly = true

      // Go to Traffic Tracker directly
      WebUI.navigateToUrl(GlobalVariable.traffictracker_url)
   }


   @When("I access Grafana via Portal")
   def accessGrafanaViaPortal()
   {
      // Only perform Grafana test in production zones
      if (GlobalVariable.production_zone)
      {
         // Mark that we are not going there directly (via URL)
         directly = false

         // Wait for the Apps button to appear and then click it
         WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/button_Apps'), 30)
         WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

         // Wait for the Apps dashboard to appear and then select Events app
         WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_TechOps'), 30)
         WebUI.click(findTestObject('Page_PCTE Portal/span_TechOps'))

         // Wait for Grafana login to appear and login with SSO
         if (WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/a_Grafana_IframeSignInWithKeyCloak'), 15, FailureHandling.OPTIONAL))
            WebUI.click(findTestObject('Page_PCTE Portal/a_Grafana_IframeSignInWithKeyCloak'), FailureHandling.OPTIONAL)
      }
   }


   @When("I access Grafana via URL")
   def accessGrafanaViaURL()
   {
      // Only perform Grafana test in production zones
      if (GlobalVariable.production_zone)
      {
         // Mark that we *are* going there directly (via URL)
         directly = true

         // Go to Grafana directly
         WebUI.navigateToUrl(GlobalVariable.grafana_url)

         // Wait for the Grafana login to appear and then enter through SSO
         if (WebUI.waitForElementPresent(findTestObject('Page_Grafana/a_Grafana_SignInWithKeyCloak'), 15, FailureHandling.OPTIONAL))
            WebUI.click(findTestObject('Page_Grafana/a_Grafana_SignInWithKeyCloak'), FailureHandling.OPTIONAL)
      }
   }


   // ============================================================================================================================


   @Then("I should be able to view Traffic Tracker contents with no errors")
   def verifyTrafficTracker()
   {
      if (directly)
      {
         // Check using objects for direct access

         // Verify initial page has loaded
         WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_TrafficTracker_TitleLabel'), 30);
         WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_TrafficTracker_TitleLabel'), 'Traffic Tracker')

         // Let's wait to allow Traffic Tracker status to stabilize before we check it
         TestSupport.delay(15)

         // Verify we have a green face (saying connection is good)
         WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_PCTE Portal/button_TrafficTracker_Face'), 'title', 'Connection: Good', 10)
      }
      else
      {
         // Check using objects via portal (inside iframe)

         // Verify initial page has loaded
         WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_TrafficTracker_IframeTitleLabel'), 30);
         WebUI.verifyElementText(findTestObject('Page_PCTE Portal/span_TrafficTracker_IframeTitleLabel'), 'Traffic Tracker')

         // Let's wait to allow Traffic Tracker status to stabilize before we check it
         TestSupport.delay(15)

         // Verify we have a green face (saying connection is good)
         WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_PCTE Portal/button_TrafficTracker_IframeFace'), 'title', 'Connection: Good', 10)
      }
   }


   @Then("I should be able to view Grafana contents with no errors")
   def verifyGrafana()
   {
      // Only perform Grafana test in production zones
      if (GlobalVariable.production_zone)
      {
         if (directly)
         {
            // Check using objects for direct access

            // Verify initial page has loaded
            WebUI.waitForElementPresent(findTestObject('Page_Grafana/span_Grafana_WelcomeToGrafana'), 30)
            WebUI.verifyElementText(findTestObject('Page_Grafana/span_Grafana_WelcomeToGrafana'), 'Welcome to Grafana')

            // Then logout of Grafana
            WebUI.click(findTestObject('Page_Grafana/img_Grafana_UserMenu'))
            WebUI.waitForElementPresent(findTestObject('Page_Grafana/a_Grafana_SignOut'), 30)
            WebUI.click(findTestObject('Page_Grafana/a_Grafana_SignOut'))
         }
         else
         {
            // Check using objects via portal (inside iframe)

            // Wait for Grafana Ranges page to load and then verify some elements
            WebUI.waitForElementPresent(findTestObject('Page_PCTE Portal/span_Grafana_IframeCurrentActiveUsers'), 30)
            WebUI.click(findTestObject('Page_PCTE Portal/span_Grafana_IframeCurrentActiveUsers'))
            WebUI.click(findTestObject('Page_PCTE Portal/span_Grafana_IframeActiveConsoles'))
            WebUI.click(findTestObject('Page_PCTE Portal/span_Grafana_IframeRunningVMs'))
            WebUI.click(findTestObject('Page_PCTE Portal/span_Grafana_IframeTotalVMs'))
         }
      }
   }
}
