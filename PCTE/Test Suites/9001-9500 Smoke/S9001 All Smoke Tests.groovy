import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase

import edu.ucf.irl.TestSupport as TestSupport
import edu.ucf.irl.SharedTestData as SharedTestData


class S9001
{
   static String   useContentModuleNamed = "PCTE S9001 Content Module"
   static String   useTrainingPackageNamed = "PCTE S9001 Training Package"
   static String   useExerciseEventNamed = "PCTE S9001 Exercise Event"
}


@SetUp(skipped = false)
def setUp() 
{
   // Mark the start of the setup method
   TestSupport support = TestSupport.getInstance()
   support.beginTestSuiteSetup()

   // Login as author and make content we need
   support.login(GlobalVariable.author_username, GlobalVariable.author_password, GlobalVariable.author_key)
   SharedTestData data = SharedTestData.getInstance()
   data.createContentModule(S9001.useContentModuleNamed)
   data.createTrainingPackage(S9001.useTrainingPackageNamed, S9001.useContentModuleNamed)
   support.logout()
   
   // Then, login as training manager and make exercise
   support.login(GlobalVariable.manager_username, GlobalVariable.manager_password, GlobalVariable.manager_key)
   data.createExerciseEvent(S9001.useExerciseEventNamed)
   String[] participants = [ GlobalVariable.user1_name ]
   data.addParticipantsToExerciseEvent(S9001.useExerciseEventNamed, participants)
   support.logout()
   
   // Mark the end of the setup method
   support.endTestSuiteSetup()
}


@TearDown(skipped = false)
def tearDown() 
{
   // Mark the start of the teardown method
   TestSupport support = TestSupport.getInstance()
   support.beginTestSuiteTeardown()

   // First, make sure we are logged out from any left over user
   support.logout()
  
   // First login as portal admin to clean up exercises
   support.login(GlobalVariable.god_username, GlobalVariable.god_password, GlobalVariable.god_key)

   // Clean-up the exercise   
   SharedTestData data = SharedTestData.getInstance()
   data.archiveExerciseEvent(S9001.useExerciseEventNamed)
   
   // Now, login as author
   support.logout()
   support.login(GlobalVariable.author_username, GlobalVariable.author_password, GlobalVariable.author_key)

   // Clean-up data we made
   // data.deleteTrainingPackageDocuments(S9001.useTrainingPackageNamed)
   data.deleteTrainingPackage(S9001.useTrainingPackageNamed)
   // data.deleteContentModuleDocuments(S9001.useContentModuleNamed)
   data.deleteContentModule(S9001.useContentModuleNamed)
   
   // And logout
   support.logout()

   // Mark the end of the teardown method
   support.endTestSuiteTeardown()
}


@SetupTestCase(skipped = true)
def setupTestCase() 
{
   // Nothing to do
}


@TearDownTestCase(skipped = true)
def tearDownTestCase() 
{
   // Nothing to do
}
