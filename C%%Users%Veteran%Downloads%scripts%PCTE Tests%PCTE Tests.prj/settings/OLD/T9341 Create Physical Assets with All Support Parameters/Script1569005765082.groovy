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

'Click on "Physical Assets"'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_PhysicalAssets'))

'Click on "New Physical Asset"'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_NewPhysicalAsset'))

'Enter name for Physical Asset'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_PhysicalAssetName'), 'PCTE Test ' + testCode)

'Enter location for Physical Asset'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_PhysicalAssetLocation'), 'Partnership 3')

'Select Physical Asset type'
WebUI.selectOptionByLabel(findTestObject('Page_PCTE Portal/select_Content_PhysicalAssetType'), 'Facility', false)

'Select Physical Asset organization'
WebUI.selectOptionByLabel(findTestObject('Page_PCTE Portal/select_Content_PhysicalAssetOrganization'), 'PCTE', false)

'Set Physical Asset description'
WebUI.setText(findTestObject('Page_PCTE Portal/textarea_Content_PhysicalAssetDescription'), 'Testing facility for this automated test.')

'Click "Create" to create the physical asset'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_PhysicalAssetCreate'))

'Delay a second to let confirmation page load'
TestSupport.delay(1)

'Make sure name is properly defined'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/h1_Content_PhysicalAssetName'), 'PCTE Test ' + testCode)

'Make sure item type is properly defined'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_PhysicalAssetItemType'), 'Physical Asset')

'Make sure location is properly defined'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_PhysicalAssetLocation'), 'Partnership 3')

'Make sure type is properly defined'
WebUI.verifyElementText(findTestObject('Page_PCTE Portal/td_Content_PhysicalAssetType'), 'Facility')

TestSupport.delay(1) /* GAM Currently, there is no way within the PCTE Portal to delete a physical asset
   SharedTestData data = SharedTestData.getInstance()
   data.deletePhysicalAsset('PCTE Test ' + testCode)
   */

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log into the portal'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    TestSupport.delay(3)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Delete our physical asset and use SharedTestData since we are in teardown'

    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log out of the portal'
    support.logout()
}

