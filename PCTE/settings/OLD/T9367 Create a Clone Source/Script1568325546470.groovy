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
import edu.ucf.irl.TestSupport as TestSupport
import edu.ucf.irl.SharedTestData as SharedData
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestSupport.delay(3)

WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

TestSupport.delay(3)

WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'))

WebUI.click(findTestObject('Page_PCTE Portal/a_Content_DynamicNetworkSpecLink', [('specName') : networkSpecName]))

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_EditNetworkSpec'))

WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ShowDiffPanel'))

TestSupport.delay(1)

WebUI.click(findTestObject('Page_PCTE Portal/span_Content_DiffPanelSave'))

TestSupport.delay(3)

WebUI.click(findTestObject('Page_PCTE Portal/span_Content_DiffPanelCommit'))

TestSupport.delay(2)

WebUI.click(findTestObject('Page_PCTE Portal/span_Content_CommitConfirm'))

TestSupport.delay(2)

WebUI.click(findTestObject('Page_PCTE Portal/span_Content_ShowDiffPanel'))

WebUI.click(findTestObject('Page_PCTE Portal/div_Content_NetworkSpecVersion1'))

WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NewDeployment'))

WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Content_DeploymentName'), networkSpecName)

WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Content_DeploymentName'), Keys.chord(Keys.TAB))

TestSupport.delay(10)

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_DeploymentCreate'))

TestSupport.delay(2)

WebUI.click(findTestObject('Page_PCTE Portal/div_Content_CloseDeployment'))

WebUI.click(findTestObject('Page_PCTE Portal/div_Content_DeploymentEllipses', [('specName') : networkSpecName]))

WebUI.click(findTestObject('Page_PCTE Portal/span_Content_DeploymentClone'))

WebUI.sendKeys(findTestObject('Page_PCTE Portal/input_Content_DeploymentCloneName'), cloneName)

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_CreateCloneSource'))

WebUI.navigateToUrl(GlobalVariable.portal_url)

TestSupport.delay(3)

WebUI.click(findTestObject('Page_PCTE Portal/button_Apps'))

TestSupport.delay(3)

WebUI.click(findTestObject('Page_PCTE Portal/span_Content'))

WebUI.click(findTestObject('Page_PCTE Portal/span_Content_NetworkSpecs'))

WebUI.click(findTestObject('Page_PCTE Portal/a_Content_DynamicNetworkSpecLink', [('specName') : networkSpecName]))

WebUI.click(findTestObject('Page_PCTE Portal/button_Content_EditNetworkSpec'))

WebUI.click(findTestObject('Page_PCTE Portal/li_Content_CloneSourceTab'))

WebUI.verifyTextPresent(cloneName, false)

@com.kms.katalon.core.annotation.SetUp
def setup() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Get the instance of the shared test data class'
    SharedData data = SharedData.getInstance()

    'Log into the portal'
    support.login(GlobalVariable.orgadmin_username, GlobalVariable.orgadmin_password)

    'Create a new network spec that has imported a medium metova space yaml file'
    data.createAndImportNetworkSpec(networkSpecName, yamlFile)

    TestSupport.delay(3)
}

@com.kms.katalon.core.annotation.TearDown
def teardown() {
    'Get the instance of the test support class'
    TestSupport support = TestSupport.getInstance()

    'Get the instance of the shared test data class'
    SharedData data = SharedData.getInstance()

    'Delete the clone source'
    data.deleteCloneSource(networkSpecName, cloneName)

    'Delete the deployment'
    data.deleteDeployment(networkSpecName, networkSpecName)

    'Delete the no internet network spec that was created'
    data.deleteNetworkSpec(networkSpecName)

    'Log out of the portal'
    support.logout()
}

