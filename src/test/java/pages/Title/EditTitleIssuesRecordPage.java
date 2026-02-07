package pages.Title;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditTitleIssuesRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditTitleIssuesRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By btnEdit = By.xpath("//input[contains(@id,'YALTITLEISSUES_radYALGridControl_ctl00_ctl04_EditButton')]");
	By drpPriority = By.xpath("//input[contains(@id,'_Issue_Priority_ID_radYALDropDownList_Input') and @type='text']");
	By drpStatus = By.xpath("//input[contains(@id,'_Issue_Status_ID_radYALDropDownList_Input') and @type='text']");
	By btnUpdate = By.xpath("//input[contains(@id,'YALTITLEISSUES_radYALGridControl_ctl00_ctl05_EditFormControl_btnUpdate')]");
    By changesSavedSuccessfully = By.xpath("//span[contains(@id,'YALTITLEISSUES_usrMessage')]"); 

	
    public void ClickonEditButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);	
    }
    
    public void SelectPriority(String value) {	
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriority, value);	
	}
	
	public void SelectStatus(String value) {	
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatus, value);	
	}
	
	public void ClickonUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
		util.dummyWait(2);

	}
	
	 public void EditTitleIssuesRecord(Map<String, String> map, String testcaseName) {
		    
		   try {
			   ClickonEditButton();
	    	   log("STEP 1: Record should expands below ", Status.PASS);
	    	} catch (Exception e) {
			   log("STEP 1: Record does not expand below  ", Status.FAIL);
			   throw new RuntimeException(" Failed in step 1 ");
		    }
		   
		   try {
			   SelectPriority(map.get(Excel.Priority));
	  		   util.dummyWait(2);
	  		  SelectStatus(map.get(Excel.Status));
		   			log("STEP 2:  Entered value should displays in the respective fields.   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 2:   Entered value does not display in the field. ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 2");
		   		}
	  	 
		   try {
			   ClickonUpdateButton();
	    	   log("STEP 3: Changes saved successfully! message should be display above grid ", Status.PASS);
	    	} catch (Exception e) {
			   log("STEP 3: Changes saved successfully! message should be display above the Save button ", Status.FAIL);
			   throw new RuntimeException(" Failed in step 3 ");
		    }
	 }
}
