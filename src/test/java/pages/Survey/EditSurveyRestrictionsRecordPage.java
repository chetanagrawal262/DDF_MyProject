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

public class EditSurveyRestrictionsRecordPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditSurveyRestrictionsRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By btnEditRow = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i8_i0_SURVEY_STIP_radYALGridControl_ctl00_ctl04_EditButton']");
	By btnEditDot = By.xpath("//input[contains(@id,'_i0_SURVEY_STIP_radYALGridControl_ctl00_ctl04_EditButton')]");
	By drpPriority = By.xpath("//input[contains(@id,'_PRIORITY_ID_radYALDropDownList_Input') and @type='text']");
	By drpStatus = By.xpath("//input[contains(@id,'_EditFormControl_STATUS_ID_radYALDropDownList_Input') and @type='text']");
	By drpFrequency = By.xpath("//input[contains(@id,'_FREQUENCY_ID_radYALDropDownList_Input') and @type='text']");
	By drpAssignedTo = By.xpath("//input[contains(@id,'_Assigned_To_ID_radYALDropDownList_Input') and @type='text']");
	By btnUpdate = By.xpath("(//input[contains(@id,'_btnUpdate')  and @type='submit'])");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	By btnCancelRow = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i8_i0_SURVEY_STIP_radYALGridControl_ctl00_ctl05_EditFormControl_btnCancel']");
    By btnCancelDot = By.xpath("//input[contains(@id,'_SURVEY_STIP_radYALGridControl_ctl00_ctl05_EditFormControl_btnCancel')]");
	
	public void ClickonEditButtonRow() {
		util.waitUntilElementDisplay(btnEditRow);
		util.click(btnEditRow);
	}
	
	public void ClickonEditButtonDot() {
		util.waitUntilElementDisplay(btnEditDot);
		util.click(btnEditDot);
	}
	
	 public void SelectPriority(String value) {
		 util.waitUntilElementDisplay(drpPriority);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpPriority,value);
		}
	
	 public void SelectStatus(String value) {
		 util.waitUntilElementDisplay(drpStatus);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpStatus,value);
		}
	 
	
	 
	 public void ClickOnUpdateButton(){
		 util.waitUntilElementDisplay(btnUpdate);
			util.click(btnUpdate);
			util.waitUntilLoaderDisappear();
			util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	 }
	 
	 public void ClickOnCancelRow() {
		 util.waitUntilElementDisplay(btnEditRow);
		 util.click(btnEditRow);
		 util.waitUntilLoaderDisappear();
		 util.waitUntilElementDisplay(btnCancelRow);
		 util.click(btnCancelRow);
		 util.waitUntilLoaderDisappear();

		}
	 
	 public void ClickOnCancelDot() {
		 util.waitUntilElementDisplay(btnEditDot);
		 util.click(btnEditDot);
		 util.waitUntilElementDisplay(btnCancelDot);
		 util.click(btnCancelDot);
			util.dummyWait(5);
		}
	 
	 public void EditSurveyRestrictionsRecords(Map<String, String> map, String testcaseName) {
		if(testcaseName.contains("ROW")) { 
		 try {
			 ClickonEditButtonRow();
			 util.waitUntilLoaderDisappear();
				log("STEP 1: Record Grid should expands below  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: record does not expand below", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
		 
		 try {
			 SelectPriority(map.get(Excel.Priority));
			 SelectStatus(map.get(Excel.Status));
	   			log("STEP 2:  Entered value should display in the respective fields.    ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 2:  Entered value does not display in the field  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 2");
	   		}
	 
		 try {
			 ClickOnUpdateButton();
				log("STEP 3:  Changes saved successfully! message should be display above grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: Changes saved successfully! message should be display above the Save button", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		 
		 try {
			 ClickOnCancelRow();
				log("STEP 4:  User can click on cancel button.", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: record does not expand below", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		  
	 }
		
		else {
			 try {
				 ClickonEditButtonDot();
					log("STEP 1: Record Grid should expands below  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: record does not expand below", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
			 
			 
			 try {
				 SelectPriority(map.get(Excel.Priority));
				 SelectStatus(map.get(Excel.Status));
		   			log("STEP 2:  Entered value should display in the respective fields.    ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 2:  Entered value does not display in the field  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 2");
		   		}
		 
			 try {
				 ClickOnUpdateButton();
					log("STEP 3:  Changes saved successfully! message should be display above grid ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: Changes saved successfully! message should be display above the Save button", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
			 
			 try {
				 ClickOnCancelDot();
					log("STEP 4:  User can click on cancel button.", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: record does not expand below", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}

		}
 
	 } 

	 
}
