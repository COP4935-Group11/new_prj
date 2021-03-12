import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
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
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Start navigating back to the Network Specs page by clicking on the application button in the upper left corner'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait briefly for the apps menu to load'
TestSupport.delay(3)

'Click on the Content icon'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

'Click on the Network Spec section of the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'))

'Click on the ellispes icon for the project that was just created'
WebUI.click(findTestObject('Page_PCTE Portal/i_Content_NetworkSpecEllipses', [('specName') : networkSpecName]))

'Click on the Share button'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ShareSpec'))

'Click the checkbox for unsharing listing from the organization of the user'
WebUI.click(findTestObject('Page_PCTE Portal/label_Content_SpecShareOrgList'))

'Click the checkbox for unsharing viewing from the organization of the user'
WebUI.click(findTestObject('Page_PCTE Portal/label_Content_SpecShareOrgView'))

'Enter the name of the user with whom spec is being shared'
WebUI.setText(findTestObject('Page_PCTE Portal/label_Content_SpecShareUsername'), GlobalVariable.user1_name)

'Confirm the username entered in the previous step'
WebUI.sendKeys(findTestObject('Page_PCTE Portal/label_Content_SpecShareUsername'), Keys.chord(Keys.ENTER))

'Click the checkbox for listing this spec for the share user'
WebUI.click(findTestObject('Page_PCTE Portal/label_Content_SpecShareListCheckbox'))

'Click the checkbox for viewing this spec for the share user'
WebUI.click(findTestObject('Page_PCTE Portal/input_Content_SpecShareViewCheckbox'))

'Wait for the share to be processed'
TestSupport.delay(1)

'Share the spec with the test user'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_SpecShare'))

'Wait for the share to be processed'
TestSupport.delay(1)

'Click on the Save button to confirm the share settings'
WebUI.click(findTestObject('Page_PCTE Portal/button_Content_SpecShareSave'))

'Get an instance of the Test Support class'
def support = TestSupport.getInstance()

'Logout of the current user'
support.logout()

'Log in to the portal with the first test user'
support.login(GlobalVariable.user1_username, GlobalVariable.user1_password)

'Start navigating back to the Network Specs page by clicking on the application button in the upper left corner'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait briefly for the apps menu to load'
TestSupport.delay(3)

'Click on the Content icon'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

'Click on the Network Spec section of the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'))

'Input the name of the spec that was created earlier\r\n'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_NetworkSpecSearch'), networkSpecName)

'Click on the network spec that was created earlier'
WebUI.click(findTestObject('Page_PCTE Portal/a_Content_DynamicNetworkSpecLink', [('specName') : networkSpecName]))

'Verify that the spec is viewable by checking the heading'
WebUI.verifyElementVisible(findTestObject('Page_PCTE Portal/h1_Content_TrainingPackageName', [('specName') : networkSpecName]))

'Logout of the current user'
support.logout()

'Log in to the portal with the first test user'
support.login(GlobalVariable.user2_username, GlobalVariable.user2_password)

'Start navigating back to the Network Specs page by clicking on the application button in the upper left corner'
WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

'Wait briefly for the apps menu to load'
TestSupport.delay(3)

'Click on the Content icon'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

'Click on the Network Spec section of the Content app'
WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'))

'Input the name of the spec that was created earlier\r\n'
WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_NetworkSpecSearch'), networkSpecName)

'Verify that the network spec isn\'t visible to this user'
WebUI.verifyElementNotPresent(findTestObject('Page_PCTE Portal/a_Content_DynamicNetworkSpecLink', [('specName') : networkSpecName]), 
    0)

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
    'Delete the network spec, if it was created'
    SharedTestData sharedData = SharedTestData.getInstance()

    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Logout and log in as the admin user that created the test spec'
    support.logout()

    'Wait a second after logout'
    TestSupport.delay(1)

    'Login as admin'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Delete the network spec that was potentially created earlier in the test case'
    sharedData.deleteNetworkSpec(networkSpecName)

    'Wait a second'
    TestSupport.delay(1)

    'Log out of the portal'
    support.logout()
}

