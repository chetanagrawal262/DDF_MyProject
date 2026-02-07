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

public class EditEasementDetailsPage  extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditEasementDetailsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnEdit = By.xpath("//input[contains(@id,'WINDEASEMENT_radYALGridControl_ctl00_ctl04_EditButton')]");
	By txtEstimatedQuantity = By.xpath("//input[contains(@id,'_EditFormControl_EST_AMOUNT') and @type='text']");
//  By txtBuiltQuantity = By.xpath("//input[contains(@id,'_EditFormControl_Survey_Amount') and @type='text']");
    By txtUnit = By.xpath("//input[contains(@id,'_ddlUnit_radYALDropDownList_Input') and @type='text']");
    By btnUpdate = By.xpath("//input[contains(@id,'WINDEASEMENT_radYALGridControl_ctl00_ctl05_EditFormControl_btnUpdate')]");
    By changesSavedSuccessfully = By.xpath("//span[contains(@id,'WINDEASEMENT_usrMessage') and text()='Changes saved successfully!']");
    By btnCancel = By.xpath("//input[contains(@id,'WINDEASEMENT_radYALGridControl_ctl00_ctl05_EditFormControl_btnCancel')]");
   
    public void ClickonEditButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    	util.dummyWait(10);
    }
    
    public void AddUnit(String value) {
    	
    	if (!commonFunction.checkNA(value)) {
    		util.waitUntilElementDisplay(txtUnit);
			util.inputTextAndPressTab(txtUnit, value); }   	
    }

    public void AddEstimatedQuantity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEstimatedQuantity, value);    	
    }
    
    public void ClickOnCancelButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    	util.dummyWait(1);
    	util.waitUntilElementDisplay(btnCancel);
    	util.click(btnCancel);
    	util.dummyWait(1);
    }
    
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
		util.dummyWait(2);
    }
    
    public void EditEasementDetails(Map<String, String> map, String testcaseName) {
    	
   	 try {
   		       ClickonEditButton();
	 			log("STEP 1: record should expands below", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: record does not expand below", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
   	 
	    	 try {
	    		 if(util.isElementVisible(txtUnit)) {
	    		 AddUnit(map.get(Excel.Unit));
	    		 
	    		 }
	    		 AddEstimatedQuantity(map.get(Excel.Quantity));
	    		log("STEP 2: Entered value should displays in the respective field.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: Entered value does not display in respective field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 try {
	    		 ClickOnUpdateButton();
	 			log("STEP 3: Changes saved successfully! message should be display above grid ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: Changes saved successfully! message should be display above the Save button", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 
	    	 try {
	    		 ClickOnCancelButton();
	 			log("STEP 4: User can click on cancel button.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: User cannot click on cancel button.", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
    }
    

}
