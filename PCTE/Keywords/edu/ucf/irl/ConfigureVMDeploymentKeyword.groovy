package edu.ucf.irl
import org.openqa.selenium.Dimension
import org.openqa.selenium.Keys
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.CSVData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


public class ConfigureVMDeploymentKeyword {
	/**
	 * Configure VM templates and provision actions for a deployment.
	 * @param vmDataFile Data file that is used as the basis for the configuration 
	 */
	@Keyword
	def ConfigureVMDeployment(CSVData vmDataFile) {
		// Go through each of the rows in the VM configuration data file
		for (int currRow = 1; currRow <= vmDataFile.getRowNumbers(); currRow++)
		{
			// Fetch the name of the VM being currently configured
			String vmName = vmDataFile.getValue(1, currRow);

			// Fetch whether the VM should be included or not
			boolean include = false;
			if (vmDataFile.getValue(2, currRow) == "yes")
			{
				include = true;
			}

			// Fetch the name of the VM template to be used for the VM
			String vmTemplate = vmDataFile.getValue(3, currRow);

			// Fetch the provision action for the current VM
			String provisionAction = vmDataFile.getValue(4, currRow);

			// Search for the VM in the VM configuration
			WebUI.setText(findTestObject('Page_PCTE Portal/input_Content_DeploymentVMSearch'), vmName);
			WebUI.delay(5);

			// Now that the configuration data has been gathered, the first step
			// is to check whether the VM template needs to be changed from the spec template
			String xpath;
			String xPathString;
			if (!vmTemplate.equals("Use Spec Template"))
			{
				// Create a test object for the VM template dropdown
				TestObject vmTemplateDropdown = new TestObject();

				// Form the XPath for the VM template dropdown
				xPathString =
						"//div[@class = \'vm\' and .//div[@class = \'text\' and (text() = \'%s\')]]//div[@class = \'template\']//span[@class = 'Select-arrow-zone']";

				// Form the full XPath with the VM name
				xpath = String.format(xPathString, vmName);

				// Add the XPath as a property to the template dropdown test object
				vmTemplateDropdown.addProperty('xpath', ConditionType.EQUALS, xpath);

				// Click on the dropdown
				WebUI.click(vmTemplateDropdown);

				// Next step is to choose the desired VM template from the dropdown
				// Create a new test object for the desired template dropdown item
				TestObject vmTemplateItem = new TestObject();

				// Form the XPath for the VM template item
				xPathString = "//div[@role = \'option\' and (text() = \'%s\')]";

				// Form the XPath for the VM template item
				xpath = String.format(xPathString, vmTemplate);

				// Add the XPath as a property to the template item test object
				vmTemplateItem.addProperty('xpath', ConditionType.EQUALS, xpath);

				// Click on the dropdown item
				WebUI.click(vmTemplateItem);
			}

			// Next step is to click on the provision action dropdown
			// Create a test object for the provision action dropdown
			TestObject provisionActionDropdown = new TestObject();

			// Form the basis of the XPath for the provision action dropdown
			xPathString =
					"//div[contains(@class, 'vm') and ./div[@class = 'name ' and ./div[@class = 'text' and text() = '%s']]]/div[@class = 'post']//span[@class = 'Select-multi-value-wrapper']";

			// Form the full XPath for the provision action dropdown
			xpath = String.format(xPathString, vmName);

			// Add the XPath as a property to the provision action dropdown
			provisionActionDropdown.addProperty('xpath', ConditionType.EQUALS, xpath);

			// Click on the provision action dropdown
			WebUI.click(provisionActionDropdown);

			// Give some time for the dropdown to show up
			WebUI.delay(1);

			// The final step is to pick the provision action from the dropdown menu
			// Create a test object for the provision action dropdown menu item
			TestObject provisionActionItem = new TestObject();

			// Form the basis of XPath for the provision action item
			xPathString = "//div[@role = 'option' and (text() = '%s')]";

			// Form the full XPath for the provision action item
			xpath = String.format(xPathString, provisionAction);

			// Add the XPath as a property to the provision action item
			provisionActionItem.addProperty('xpath', ConditionType.EQUALS, xpath);

			// Click on the provision action item
			WebUI.click(provisionActionItem);

			// Wait for the change to be processed
			WebUI.delay(5);
		}
	}
}