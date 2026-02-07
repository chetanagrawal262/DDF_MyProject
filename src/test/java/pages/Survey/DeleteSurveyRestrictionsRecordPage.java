package pages.Survey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DeleteSurveyRestrictionsRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DeleteSurveyRestrictionsRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	
	 By btnDeleteRow = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i8_i0_SURVEY_STIP_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment']");
	 By btnDeleteDot = By.xpath("//input[contains(@id,'_i0_SURVEY_STIP_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");	 
	 By btnCancel = By.xpath("//span[text()='Cancel']");
	 By btnOk = By.xpath("//span[text()='OK']");
	 By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");

	
	 
	 
	 public void ClickonDeleteRow()
	 {
		 util.waitUntilElementDisplay(btnDeleteRow);
		 util.click(btnDeleteRow);
	 }
	 
	 public void ClickonDeleteDot()
	 {
		 util.waitUntilElementDisplay(btnDeleteDot);
		 util.click(btnDeleteDot);
	 }
	 
	 public void ClickonCancel()
	 {
		 util.dummyWait(1);
		 util.waitUntilElementDisplay(btnCancel);
		 util.click(btnCancel);
	 }
	 
	 public void ClickonOK()
	 {
		 util.waitUntilElementDisplay(btnDeleteDot);
		 util.click(btnDeleteDot);
		 util.dummyWait(1);
		 util.waitUntilElementDisplay(btnOk);
		 util.click(btnOk);
		 util.waitUntilElementDisplay(changesSavedSuccessfully);
		 Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	    util.dummyWait(2);
	 }
	 
	 public void ClickonOKRow()
	 {
		 util.waitUntilElementDisplay(btnDeleteRow);
		 util.click(btnDeleteRow);
		 util.waitUntilElementDisplay(btnOk);
		 util.click(btnOk);
		 util.waitUntilLoaderDisappear();
		 util.waitUntilElementDisplay(changesSavedSuccessfully);
		 Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");

	 }
	 
	 public void DeleteSurveyRestrictionsRecords(String testcaseName) {
		 if(testcaseName.contains("ROW")) {
			 
		 try {
			 ClickonDeleteRow();
				log("STEP 1: Popup Delete should be open with OK and Cancel button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Popup Survey Restrictions does not open", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
		 try {
			 ClickonCancel();
				log("STEP 2: Delete popup should Close and Survey Restrictions record should not delete ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: unable to click  Cancel button OR popup does not close", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		 
		 try {
			 ClickonOKRow();
				log("STEP 3: Message \"Changes saved successfully!\" should be display above the grid  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: unable to click  OK button OR popup does not close", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		 }
		 
		 else
		 {
				 
				 try {
					 ClickonDeleteDot();
						log("STEP 1: Popup Delete should be open with OK and Cancel button ", Status.PASS);
					} catch (Exception e) {
						log("STEP 1: Popup Survey Restrictions does not open", Status.FAIL);
						throw new RuntimeException("Failed in step 1");
					}
				 
				 try {
					 ClickonCancel();
						log("STEP 2: Delete popup should Close and Survey Restrictions record should not delete ", Status.PASS);
					} catch (Exception e) {
						log("STEP 2: unable to click  Cancel button OR popup does not close", Status.FAIL);
						throw new RuntimeException("Failed in step 2");
					}
				 
				 try {
					 ClickonOK();
						log("STEP 3: Message \"Changes saved successfully!\" should be display above the grid  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 3: unable to click  OK button OR popup does not close", Status.FAIL);
						throw new RuntimeException("Failed in step 3");
					}
				 
		 }
	 }
}
