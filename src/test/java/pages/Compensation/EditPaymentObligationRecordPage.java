package pages.Compensation;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditPaymentObligationRecordPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditPaymentObligationRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnEdit = By.xpath("//tbody/tr[@id='ctl00_ConPHRightTop_TRCD2_UC_radPanels_i3_i0_DYNAMICCHECK_radYALGridControl_ctl00__0']/td[4]/a[1]");
	By txtDueDate = By.xpath("//input[@id='RAD_DUE_DATE_dateInput']");
	By txtComment = By.xpath("//textarea[@id='rptCompensation_ctl01_Comment']");
	By btnUpdate = By.xpath("//input[@id='btnSave1']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully']");
	By btnCancel = By.xpath("//input[@id='btnCancel']");
	
	public void ClickOnEditPaymentLink() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		
	}
	
	public void AddDueDate(String value) {
		util.waitUntilElementDisplay(txtDueDate);
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtDueDate, value);
	}
	
	public void AddComment(String value) {
		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtComment, value);
	}
	
	public void ClickOnUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully");
	}
	
	public void ClickOnCancelButton() {
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
	}
	
	
	 public void EditPaymentObligationRecord(Map<String, String> map, String testcaseName) {
		    
		   try {
			   ClickOnEditPaymentLink();
	    	   log("STEP 1:  Pop up should be appeared with existing record ", Status.PASS);
	    	} catch (Exception e) {
			   log("STEP 1: Pop up should not appeared  ", Status.FAIL);
			   throw new RuntimeException(" Failed in step 1 ");
		    }
		   
		   Set<String> windowId = driver.getWindowHandles(); // get window id of current window
			Iterator<String> itererator = windowId.iterator();
			String mainWinID = itererator.next();
			String newAdwinID = itererator.next();
			
			
		   
		   try {
			   driver.switchTo().window(newAdwinID);
			   util.dummyWait(1);
			   AddDueDate(map.get(Excel.DueDate));
			   util.dummyWait(1);
			   AddComment(map.get(Excel.Comment));
		   			log("STEP 2:  Entered value should displays in the respective fields.   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 2:   Entered value does not display in the field. ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 2");
		   		}
		   
		   
	  	 
		   try {
			   ClickOnUpdateButton();
	    	   log("STEP 3: Changes saved successfully! message should be display above grid ", Status.PASS);
	    	} catch (Exception e) {
			   log("STEP 3: Changes saved successfully! message should be display above the Save button ", Status.FAIL);
			   throw new RuntimeException(" Failed in step 3 ");
		    }
		   
		   if(util.isElementVisible(btnCancel)) {
		   try {
			   ClickOnCancelButton();
	    	   log("STEP 4: User can click on cancel button. ", Status.PASS);
	    	} catch (Exception e) {
			   log("STEP 4: User cannot click on cancel button. ", Status.FAIL);
			   throw new RuntimeException(" Failed in step 3 ");
		    }
		   }
		util.dummyWait(1);
		   driver.close();
			driver.switchTo().window(mainWinID);
			util.dummyWait(2);
		   
	   }
	   
	
}
