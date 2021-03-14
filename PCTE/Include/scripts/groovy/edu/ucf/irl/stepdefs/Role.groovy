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

import internal.GlobalVariable

import edu.ucf.irl.TestSupport as TestSupport


class Role {
	enum Roles {
		NONE,
		MEMBER,
		AUTHOR,
		MANAGER,
		ADMIN,
		GOD
	}

	static Roles   currentRole = Roles.NONE


	@Given("My role is (.*)")
	def loginAsRole(String role) {
		// Store previous (current) role
		Roles previousRole = currentRole;

		// Based on user type, get the appropriate username/password
		// from execution profile
		String user = ""
		String pass = ""
		String key = ""
		if (role.equalsIgnoreCase("member"))
		{
			currentRole = Roles.MEMBER
			user = GlobalVariable.user1_username
			pass = GlobalVariable.user1_password
			key = GlobalVariable.user1_key
		}
		else if (role.equalsIgnoreCase("content author"))
		{
			currentRole = Roles.AUTHOR
			user = GlobalVariable.author_username
			pass = GlobalVariable.author_password
			key = GlobalVariable.author_key
		}
		else if (role.equalsIgnoreCase("training manager"))
		{
			currentRole = Roles.MANAGER
			user = GlobalVariable.manager_username
			pass = GlobalVariable.manager_password
			key = GlobalVariable.manager_key
		}
		else if (role.equalsIgnoreCase("admin"))
		{
			currentRole = Roles.ADMIN
			user = GlobalVariable.orgadmin_username
			pass = GlobalVariable.orgadmin_password
			key = GlobalVariable.orgadmin_key
		}
		else if (role.equalsIgnoreCase("portal admin"))
		{
			currentRole = Roles.GOD
			user = GlobalVariable.god_username
			pass = GlobalVariable.god_password
			key = GlobalVariable.god_key
		}

		// Get instance of TestSupport for use
		TestSupport support = TestSupport.getInstance()

		// If we are currently logged in but are switching roles, we must logout first
		if ( (currentRole != previousRole) && (previousRole != Roles.NONE) )
		{
			// Logout current user
			support.logout()
		}

		// Login as specified user type
		support.login(user, pass, key)
	}
}
