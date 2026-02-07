package pages.Survey;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditDrawingTrackingrecordPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditDrawingTrackingrecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
       By btnEdit = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i4_i0_ACQSURVEY_radYALGridControl_ctl00_ctl04_EditButton']");
       By txtRevisionNumber = By.xpath("//input[contains(@id,'_RevisionNumber') and @type='text']");
   	   By txtPlatEntitled = By.xpath("//input[contains(@id,'_PLATENTITLED') and @type='text']");
   	   By btnUpdate = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i4_i0_ACQSURVEY_radYALGridControl_ctl00_ctl05_EditFormControl_btnUpdate']");
	   By Successmsg = By.xpath("//span[text()='Changes saved successfully!']");
	   By btnCancel = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i4_i0_ACQSURVEY_radYALGridControl_ctl00_ctl05_EditFormControl_btnCancel']");
	   
	   
	   
	   public void ClickonEdit(){
		   util.waitUntilElementDisplay(btnEdit);
		   util.click(btnEdit);
	   }
	   
	   public void AddRevisionNumber(String value) {
		   util.waitUntilElementDisplay(txtRevisionNumber);
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtRevisionNumber, value);
   }
	 
	 public void AddPlatEntitled(String value) {
		 util.waitUntilElementDisplay(txtPlatEntitled);
			if (!commonFunction.checkNA(value))
		util.inputTextAndPressTab(txtPlatEntitled, value);
   }
	   
	   public void ClickonUpdateButton() {
		   util.waitUntilElementDisplay(btnUpdate);
		   util.click(btnUpdate);
           Assert.assertTrue(util.isElementPresent(Successmsg), "Changes saved successfully!");
	   }
	   
	   public void ClickonCancel() {
		   util.waitUntilElementDisplay(btnEdit);
		   util.click(btnEdit);
		   util.waitUntilElementDisplay(btnCancel);
		   util.click(btnCancel);
		   util.dummyWait(5);
	   }
	   
	   public void EditDrawingTrackingrecord(Map<String, String> map, String testcaseName) {
		   
			if (testcaseName.contains("DOT") || environment.contains("ALT")) {
				log(" Edit Drawing Tracking record not applicable for DOT and ALT", Status.SKIP);
			}
			else {
		   try {
			   ClickonEdit();
	  			 log("STEP 1:  Record should expands below   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP  1:   Record does not expand below  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 1");
	  		 }
		   
		   
		   try {
			   AddRevisionNumber(map.get(Excel.RevisionNumber));
			   AddPlatEntitled(map.get(Excel.PlatEntitled));
	  			 log("STEP 2:  Entered value should display in the Revision Number  and Plat Entitled fields.   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP  2:  Entered value does not display in the field.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 2");
	  		 }
		   
		   try {
			   ClickonUpdateButton();
	  			 log("STEP 3:  Changes saved successfully! message should be display above grid    ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP  3:   Changes saved successfully! message should not be display above the Save button  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 3");
	  		 }
		   
		   try {
			   ClickonCancel();
	  			 log("STEP 4:  User can click on cancel button.  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP  4:   User cannot click on cancel button.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 4");
	  		 }
		   
		   
	   }
	 }   
}
