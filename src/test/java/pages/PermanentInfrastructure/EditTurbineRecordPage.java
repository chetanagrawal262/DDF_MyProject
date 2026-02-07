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

public class EditTurbineRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditTurbineRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnEdit = By.xpath("//tbody/tr[contains(@id,'TURBINE')]/td[33]/img[1] | //input[contains(@id,'TURBINE_radYALGridControl_ctl00_ctl04_EditButton')]");
	By iframe = By.xpath("//iframe[@name='TurbineDialog']");
	By txtTurbineName = By.xpath("//input[contains(@id,'txtTurbineNumber') and @type='text']");
    By txtTurbineCapacity = By.xpath("//input[contains(@id,'txtTurbineCapacity') and @type='text']");
    By btnSave = By.xpath("//input[contains(@id,'Save') and @type='image']");
    By SuccessMessage = By.xpath("//span[text()='Update successful']");
    By btnClose = By.xpath("//a[@class='rwCloseButton']");
//  By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");

    
    public void ClickonEditButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    }
    
    public void AddTurbineName(String value) {
    	util.switchToIframe(iframe);
    	util.waitUntilElementDisplay(txtTurbineName);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTurbineName, value);
    }
    
    public void AddTurbineCapacity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTurbineCapacity, value);
    }
    
    public void ClickOnSaveTurbineRecord() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    	util.waitUntilElementDisplay(SuccessMessage);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Update successful");
		util.switchToDefaultContent();
        util.dummyWait(2);
    }
    
    public void ClickOnCloseButton() {
    	util.waitUntilElementDisplay(btnClose);
    	util.click(btnClose);
    	util.dummyWait(2);
    }
    
    
    public void EditTurbineRecord(Map<String, String> map, String testcaseName) {
    	
   	 try {
   		       ClickonEditButton();
	 			log("STEP 1: Popup Manage Turbine should be open with Save button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: Popup Manage Turbine does not open ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
   	 
	    	 try {
	    		 AddTurbineName(map.get(Excel.Name));
	    		 AddTurbineCapacity(map.get(Excel.TurbineCapacity));
	    		log("STEP 2: Entered value should displays in the respective field.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: Entered value does not display in respective field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 try {
	    		 ClickOnSaveTurbineRecord();
	 			log("STEP 3: Update successful message should be display above the Save button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: Update successful message should be display above the Save button ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 
	    	 try {
	    		 ClickOnCloseButton();
	 			log("STEP 4: Turbine record should  be display in the turbine grid with updated value", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: Turbine record does not display in the turbine grid with updated value", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
    }
    
}
