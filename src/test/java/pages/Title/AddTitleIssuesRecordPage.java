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

public class AddTitleIssuesRecordPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddTitleIssuesRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navTitleIssues = By.xpath("//span[contains(text(),'Title Issues')]");
	By btnAddNew = By.xpath("//img[contains(@id,'YALTITLEISSUES_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By txtIssueDescription = By.xpath("//input[contains(@id,'_Issue_Text') and @type = 'text']");
	By drpPriority = By.xpath("//input[contains(@id,'_Issue_Priority_ID_radYALDropDownList_Input') and @type='text']");
	By drpStatus = By.xpath("//input[contains(@id,'_Issue_Status_ID_radYALDropDownList_Input') and @type='text']");
	By txtDateCleared = By.xpath("//input[contains(@id,'_Date_Cleared_dateInput') and @type='text']");
	By txtComments = By.xpath("//textarea[contains(@id,'_YALTITLEISSUES_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_COMMENTS')]");
	By btnInsert = By.xpath("//input[contains(@id,'YALTITLEISSUES_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
    By changesSavedSuccessfully = By.xpath("//span[contains(@id,'YALTITLEISSUES_usrMessage')]"); 

    
	public void  ClickonAddNewButton()
	{
		util.waitUntilElementDisplay(navTitleIssues);
		util.click(navTitleIssues);
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
	}
	
	public void AddIssueDescription(String value) {	
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtIssueDescription, value);	
	}
	
	public void SelectPriority(String value) {	
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriority, value);	
	}
	
	public void SelectStatus(String value) {	
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatus, value);	
	}
	
	public void AddDateCleared(String value) {	
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateCleared, value);	
	}
	
	public void AddComments(String value) {	
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComments, value);	
	}
	
	public void ClickonInsertButton() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.dummyWait(2);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
		   util.dummyWait(2);

	}
	
	 public void AddTitleIssuesRecord(Map<String, String> map, String testcaseName) {
	    	
	   	 try {
	   		ClickonAddNewButton();
	     	   log("STEP 1: Record should expands below ", Status.PASS);
	     	} catch (Exception e) {
	 		   log("STEP 1: Record does not expand below  ", Status.FAIL);
	 		   throw new RuntimeException(" Failed in step 1 ");
	 	    }
	   	
	   	 
	   	 try {
	   		AddIssueDescription(map.get(Excel.Description));
		   		log("STEP 2: Entered value should display in the Issue Description field.  ", Status.PASS);
		   	} catch (Exception e) {
		   		log("STEP 2: Entered value does not display in Issue Description field. ", Status.FAIL);
		   		throw new RuntimeException("Failed in step 2");
		   	}
	   	 
	   	 
	   	 try {
	   		SelectPriority(map.get(Excel.Priority));
	    		log("STEP 3: Selected value display in the  Priority DD ", Status.PASS);
		  	} catch (Exception e) {
			   	log("STEP 3: selected value does not display in  Priority DD. ", Status.FAIL);
			   	throw new RuntimeException("Failed in step 3");
		 	}
	   	 
	   	 try {
	   		SelectStatus(map.get(Excel.Status));
		    	log("STEP 4: Selected value display in the  Status DD  ", Status.PASS);
			 } catch (Exception e) {
			 	log("STEP 4: Selected value does not display in  Status DD. ", Status.FAIL);
			   	throw new RuntimeException("Failed in step 4");
			}
	   	 
	   	try {
	   		AddDateCleared(map.get(Excel.DateCleared));
		    	log("STEP 5: User can select the Date Cleared  ", Status.PASS);
			 } catch (Exception e) {
			 	log("STEP 5: User  cannot select  Date Cleared ", Status.FAIL);
			   	throw new RuntimeException("Failed in step 5");
			}
	   	 
		try {
			AddComments(map.get(Excel.Comments));
		    	log("STEP 6: Entered value should display in the Comments field. ", Status.PASS);
			 } catch (Exception e) {
			 	log("STEP 6: Entered value does not display in Comments field. ", Status.FAIL);
			   	throw new RuntimeException("Failed in step 6");
			}
		
		try {
			ClickonInsertButton();  
		    	log("STEP 7: Changes saved successfully!  message should be display above the add new button   ", Status.PASS);
			 } catch (Exception e) {
			 	log("STEP 7: Save successful message does not display above the add new button ", Status.FAIL);
			   	throw new RuntimeException("Failed in step 7");
			}
	   	 
	   	
	 }
}
