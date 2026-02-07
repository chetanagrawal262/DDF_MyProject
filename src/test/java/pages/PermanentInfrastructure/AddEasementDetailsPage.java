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

public class AddEasementDetailsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddEasementDetailsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navEasementRecord = By.xpath("//span[contains(text(),'Easement & Collection Line Details')] | //span[contains(text(),'Facilities')]");
	By navEasementRecordAtwell = By.xpath("//span[contains(text(),'Easement & Collection Line Details')]");
	By btnAddNew = By.xpath("//img[contains(@id,'_WINDEASEMENT_radYALGridControl_') and @alt='Add new record']");
	By drpType = By.xpath("//input[contains(@id,'_ddlEasementType_radYALDropDownList_Input') and @type='text']");
	By txtEstimatedQuantity = By.xpath("//input[contains(@id,'_EditFormControl_EST_AMOUNT') and @type='text']");
    By txtBuiltQuantity = By.xpath("//input[contains(@id,'_EditFormControl_Survey_Amount') and @type='text']");
    By txtUnit = By.xpath("//input[contains(@id,'_ddlUnit_radYALDropDownList_Input') and @type='text']");
    By Discardedcheckbox = By.xpath("//input[contains(@id,'_EditFormControl_chkDiscarded') and @type='checkbox']");
    By txtComment = By.xpath("//textarea[contains(@id,'_EditFormControl_txtComments')]");
    By btnInsert = By.xpath("//input[contains(@id,'WINDEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
    By btnCancel = By.xpath("//input[contains(@id,'WINDEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnCancel')]");
    By changesSavedSuccessfully = By.xpath("//span[contains(@id,'WINDEASEMENT_usrMessage') and text()='Changes saved successfully!']");

    
    public void NavigateToEasementRecord() {
    	if(environment.contains("ATWELL")) {
    		util.waitUntilElementDisplay(navEasementRecordAtwell);
        	util.click(navEasementRecordAtwell);
    	}else {
    		util.waitUntilElementDisplay(navEasementRecord);
        	util.click(navEasementRecord);
    	}
    	
    	util.dummyWait(1);
    	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    	util.dummyWait(5);
    }
    
    public void SelectType(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpType, value);    	
    }
    
    public void AddUnit(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtUnit, value);    	
    }

    public void AddEstimatedQuantity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEstimatedQuantity, value);    	
    }
    
    public void ClickOnDiscardedcheckbox() {
    	util.waitUntilElementDisplay(Discardedcheckbox);
    	util.click(Discardedcheckbox);
    }
    
    public void AddBuiltQuantity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtBuiltQuantity, value);    	
    }
    
    public void AddComment(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);    	
    }
    
    public void ClickOnInsert() {
    	util.waitUntilElementDisplay(btnInsert);
    	util.click(btnInsert);
    	util.dummyWait(1);
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
    	util.dummyWait(1);

    }
    
    public void AddEasementDetails(Map<String, String> map, String testcaseName) {
    	
   	 try {
   		NavigateToEasementRecord();
	 			log("STEP 1: user should  be able to click add new record button", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User does not able to click Add new record button ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
   	 util.dummyWait(5);	    	 
	    	 try {
	    		 SelectType(map.get(Excel.Type));
	 			log("STEP 2: Selected value display in the Type DD ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: selected value does not display in Type DD  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 if(util.isElementVisible(txtUnit)) {
	    	 try {
	    		 AddUnit(map.get(Excel.Unit));
	    		log("STEP 3: Selected value display in the Unit DD ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: selected value does not display in Unit DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 }
	    	 
	    	 try {
	    		 AddEstimatedQuantity(map.get(Excel.Quantity));
	 			log("STEP 4: Entered value should display in the Estimated quentity field. ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: Entered value does not display in  Estimated quentity field.  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
	    	 try {
	    		 ClickOnDiscardedcheckbox();
	 			log("STEP 5: Discarded checkbox should be display checked ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: Discarded checkbox does not display checkedEntered value does not display in Turbine Capacity MW field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 
	    	 try {
	    		 AddBuiltQuantity(map.get(Excel.Quantity));
	 			log("STEP 6: Entered value should display in the as built quantity field.  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6: Entered value does not display in  as built quantity field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 
	    	 try {
	    		 AddComment(map.get(Excel.Comment));
	 			log("STEP 7: Entered value should display in the Comments field. ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: Entered value does not display in Comments field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	 
	    	 try {
	    		 ClickOnInsert();
	 			log("STEP 8: Changes saved successfully!  message should be display above the add new butto ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: Save successful message does not display above the add new button ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 
    }
}