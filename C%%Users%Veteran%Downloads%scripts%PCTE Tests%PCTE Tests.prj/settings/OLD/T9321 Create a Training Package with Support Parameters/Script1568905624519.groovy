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

'Delay for a second'
TestSupport.delay(1)

'Click on "New Training Package"'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewTrainingPackage'))

'Enter name for Event Package'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageName'), 'PCTE Test ' + testCode)

'Enter description for Event Package'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_TrainingPackageDescription'), 'Create an event package with content and network.')

'Select Intermediate difficulty'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageDifficultyIntermediate'))

'Select Team package type'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageTypeTeam'))

'Advance to next tab'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageDetailsNext'))

'Click to add an objective'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddCreateObjective'))

'Specify the objective description'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_TrainingPackageObjectiveDescription'), ('PCTE Test ' + testCode) + 
    ' Objective #1 Test Description')

'Click the blue action drop down'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageBlueAction'))

'Delay a second to let drop down render'
TestSupport.delay(1)

'Select "Protect"'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageBlueActionProtect'))

'Click the red severity drop down'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageRedAction'))

'Delay a second to let drop down render'
TestSupport.delay(1)

'Select "Persistence"'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageRedActionPersistence'))

'Click the blue assets drop down'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageBlueAssets'))

'Delay a second to let drop down render'
TestSupport.delay(1)

'Select level 2'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_TrainingPackageBlueAssetsLevel2'))

'Select "Pass/Fail" evaluation'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageEvaluationPassFail'))

'Select time requirement of "None"'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageTimeRequirementsNone'))

'Set degradation threshold to 14'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_TrainingPackageDegradationThreshold'), '14')

'Advance to next tab'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageObjectiveNext'))

'No prerequisites'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackagePrerequisitesNext'))

'Click "Add Content Modules"'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddContentModules'))

TestSupport.delay(1)

'Select our content module'
WebUI.click(findTestObject('Page_PCTE Portal/div_Content_ContentModuleListSpecificTest', [('specificTestName') : 'PCTE Test ' + 
            testCode]))

'Click "Add to Package"'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAddToPackage'))

TestSupport.delay(1)

'Advance to next tab'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageModulesNext'))

'Delay a second'
TestSupport.delay(1)

'Advance to next tab'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageAssessmentsNext'))

'Delay a second'
TestSupport.delay(1)

'Advance to next tab'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageEventOptionsNext'))

'Delay a second'
TestSupport.delay(1)

'Click "Confirm" to create the training package'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_TrainingPackageConfirm'))

'Delay a second to let confirmation page load'
TestSupport.delay(1)

'Make sure name is properly defined'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_TrainingPackageName'), 'PCTE Test ' + testCode)

'Make sure difficulty is properly defined'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_TrainingPackageDifficulty'), 'Intermediate')

'Make sure type is properly defined'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_TrainingPackageType'), 'Team')

'Make sure type is properly defined'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_TrainingPackageModulesCount'), '1')

TestSupport.delay(1)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log into the portal'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Create a content module to use'
    SharedTestData data = SharedTestData.getInstance()

    data.createContentModule('PCTE Test ' + testCode)

    TestSupport.delay(3)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Delete content module'
    SharedTestData data = SharedTestData.getInstance()

    data.deleteContentModule('PCTE Test ' + testCode)

    'Delete our training package and use SharedTestData since we are in teardown'
    data.deleteTrainingPackage('PCTE Test ' + testCode)

    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log out of the portal'
    support.logout()
}

