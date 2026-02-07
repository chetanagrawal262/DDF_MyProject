package pages.PermanentInfrastructure;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditMetTowerRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditMetTowerRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnEdit = By.xpath("//tbody/tr[contains(@id,'METTOWER_radYALGridControl')]/td[30]/a");
	By iframeMet = By.xpath("//iframe[@name='MetDialog']");
	By txtTowerName = By.xpath("//input[contains(@id,'TOWER_NUMBER') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'Save') and @type='image']");
	By SuccessMessage = By.xpath("//span[text()='Update successful']");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
	
	public void ClickOnEditButton() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
	}
	
	public void AddTowerName(String value) {
		util.switchToIframe(iframeMet);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTowerName, value);
	}
	
	public void ClickOnSaveButton() {
	     util.waitUntilElementDisplay(btnSave);
	     util.click(btnSave);
			util.dummyWait(1);
	     util.waitUntilElementDisplay(SuccessMessage);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Update successful");
	}
	
	public void ClickOnCloseButton() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
		util.dummyWait(3);
	}
	
	 public void EditMetTowerRecord(Map<String, String> map, String testcaseName) {
		 try {
			 util.dummyWait(5);
			 ClickOnEditButton();
  			 log("STEP 1:  Popup Manage Met Tower should be open with Save button ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  1:  Popup Manage Met Tower does not open ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		 }

		 try {
			 AddTowerName(map.get(Excel.TowerName));
			 log("STEP 2: Entered value should displays in the Tower Name field.",Status.PASS);
		 }catch(Exception e) {
			 log("STEP 2: Entered value does not display in  Tower Name field. ",Status.PASS);
			 throw new RuntimeException("Failed in step 2");
		 }
		 
		 try {
			 ClickOnSaveButton();
			 log("STEP 3: Update successful message should be display above the Save button ",Status.PASS);
		 }catch(Exception e) {
			 log("STEP 3: Update successful message should not be display above the Save button ",Status.PASS);
			 throw new RuntimeException("Failed in step 3");
		 }
		 
		 try {
			 ClickOnCloseButton();
			 log("STEP 4: Popup should close successfully",Status.PASS);
		 }catch(Exception e) {
			 log("STEP 4:  popup does not close  ",Status.PASS);
			 throw new RuntimeException("Failed in step 4");
		 }

	 }
}
