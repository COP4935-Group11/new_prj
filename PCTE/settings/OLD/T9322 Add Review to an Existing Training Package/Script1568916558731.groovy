import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import internal.GlobalVariable as GlobalVariable
import edu.ucf.irl.TestSupport as TestSupport
import edu.ucf.irl.SharedTestData as SharedTestData

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
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageSearch'), 'PCTE Test ' + testCode)

'Wait for page to load'
TestSupport.delay(1)

'Open our test'
WebUI.click(findTestObject('Page_PCTE Portal/a_Content_TrainingPackageListSpecificTest', [('specificTestName') : 'PCTE Test ' +
	testCode]))

'Wait for page to load'
TestSupport.delay(1)

'Click "Write Review"'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageWriteReview'))

'Wait for page to load'
TestSupport.delay(1)

'Click 4 stars!'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_TrainingPackageRating'))

'Wait one second'
TestSupport.delay(1)

'Give a review'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_TrainingPackageReview'), ('PCTE Test ' + testCode) + ' Review')

'Post the rating and review'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackagePostReview'))

'Wait for page to load'
TestSupport.delay(1)

'Verify score average'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageReviewScore'), '4.0')

'Verify score quantity'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageReviewQuantity'), '1 Review')

'Verify score summary'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageReviewSummary'), '1 PCTE Review — 4.0 average')

'Wait for page to load'
TestSupport.delay(1)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log into the portal as admin'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Create a content module and training package to use'
    SharedTestData data = SharedTestData.getInstance()

    'Create a content module'
    data.createContentModule('PCTE Test ' + testCode)

    TestSupport.delay(3)

    'Create a training package'
    data.createTrainingPackage('PCTE Test ' + testCode)

    TestSupport.delay(3)

    'Log out of the portal'
    support.logout()

    TestSupport.delay(1)

    'Log into the portal as user'
    support.login(GlobalVariable.user1_username, GlobalVariable.user1_password)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log out of the portal as user'
    support.logout()

    TestSupport.delay(2)

    'Log into portal as admin'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Clean-up content module'
    SharedTestData data = SharedTestData.getInstance()

    'Delete the content module'
    data.deleteContentModule('PCTE Test ' + testCode)

    TestSupport.delay(1)

    'Delete the training package'
    data.deleteTrainingPackage('PCTE Test ' + testCode)

    TestSupport.delay(1)

    'Log out of the portal'
    support.logout()
}

