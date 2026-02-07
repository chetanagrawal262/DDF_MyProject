package pages.Legal;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditCondemnationRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditCondemnationRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnEdit = By.xpath("//input[@id='ctl00_ConPHRightTop_TRLG_UC_radPanels_i2_i0_radGridLegal_radYALGridControl_ctl00_ctl04_EditButton']");
	By txtCondemnationName = By.xpath("//input[contains(@id,'_EditFormControl_PROC_NAME') and @type='text']");
    By txtAssignedTo = By.xpath("//input[contains(@id,'_EditFormControl_ASSIGNED_TO') and @type='text']"); 
    By txtCause = By.xpath("//input[contains(@id,'_Original_Cause_No') and @type='text']");
    By btnSave = By.xpath("//input[@id='ctl00_ConPHRightTop_TRLG_UC_radPanels_i2_i0_radGridLegal_radYALGridControl_ctl00_ctl05_EditFormControl_btnUpdate']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    
    public void ClickonEditButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    }
    
    public void AddCondemnationName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCondemnationName, value);
    }
  
  public void AddAssignedTo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAssignedTo, value);
    }
    
  public void AddCause(String value) {
		if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCause, value);
    }
    
   public void ClickonSaveButton() {
	   util.waitUntilElementDisplay(btnSave);
	   util.click(btnSave);
	   util.waitUntilElementDisplay(changesSavedSuccessfully);
 		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
      util.dummyWait(2);
   }
   
   public void EditCondemnationRecord(Map<String, String> map, String testcaseName) {
   	
 	  try {
 		 ClickonEditButton();
			log("STEP 1: Record Grid should expands below ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  Record does not expand below", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
 	  
 	  try {
 		  AddCondemnationName(map.get(Excel.CondemnationName));
 		  util.dummyWait(2);
 		 AddAssignedTo(map.get(Excel.AssignedTo));
			log("STEP 2: Entered value should displays in the respective fields  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Entered value does not display in the field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
 	  
 	  try {
 		 ClickonSaveButton();
			log("STEP 3: Changes saved successfully! message should be display above grid", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: Changes saved successfully! message should be display above the Save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
   }
    
}
