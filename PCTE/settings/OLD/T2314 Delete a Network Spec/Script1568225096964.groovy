import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import edu.ucf.irl.SharedTestData as SharedTestData
import edu.ucf.irl.TestSupport as TestSupport
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Navigate to the homepage'
WebUI.navigateToUrl(GlobalVariable.portal_url)

'Wait 5 seconds for the page to load'
TestSupport.delay(5)

'Click on the application button in the upper left corner'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait briefly for the apps menu to load'
TestSupport.delay(3)

'Click on the Content icon'
WebUI.click(findTestObject('Page_PCTE Portal/icon_Apps_Content'))

'Click on the Network Spec section of the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'))

'Delay 3 seconds'
TestSupport.delay(3)

'Click on the spec'
WebUI.click(findTestObject('Page_PCTE Portal/a_Content_DynamicNetworkSpecLink', [('specName') : networkSpecName]))

'Click on the edit button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_EditNetworkSpec'))

'Click on the delete button'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_DeleteCustomerProject'))

'Confirm the deletion'
WebUI.click(findTestObject('Page_PCTE Portal/span_HardHat_Yes-Delete-Project'))

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log into the portal'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Create an empty network spec'
    SharedTestData sharedData = SharedTestData.getInstance()

    sharedData.createEmptyNetworkSpec(networkSpecName)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Log out of the portal'
    support.logout()
}

