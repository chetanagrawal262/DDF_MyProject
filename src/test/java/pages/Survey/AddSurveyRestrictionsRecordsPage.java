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

public class AddSurveyRestrictionsRecordsPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddSurveyRestrictionsRecordsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navSurveyRestriction = By.xpath("//span[contains(text(),'Survey Restrictions')]");
	By btnAddNew = By.xpath("//img[contains(@id,'_i0_SURVEY_STIP_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By drpType = By.xpath("//input[contains(@id,'_TYPE_ID_radYALDropDownList_Input') and @type='text']");
	By drpPriority = By.xpath("//input[contains(@id,'_PRIORITY_ID_radYALDropDownList_Input') and @type='text']");
	By drpStatus = By.xpath("//input[contains(@id,'_EditFormControl_STATUS_ID_radYALDropDownList_Input') and @type='text']");
	By drpFrequency = By.xpath("//input[contains(@id,'_FREQUENCY_ID_radYALDropDownList_Input') and @type='text']");
	By drpAssignedTo = By.xpath("//input[contains(@id,'_Assigned_To_ID_radYALDropDownList_Input') and @type='text']");
	By SelectApprovedDate = By.xpath("//input[contains(@id,'_EditFormControl_Date_Approved_dateInput') and @type='text']");
	By SelectStartDate = By.xpath("//input[contains(@id,'_EditFormControl_Start_Date_dateInput') and @type='text']");
	By SelectEndDate = By.xpath("//input[contains(@id,'_EditFormControl_End_Date_dateInput') and @type='text']");
	By drpAssocAgreement = By.xpath("//input[contains(@id,'_Recording_ID_radYALDropDownList_Input') and @type='text']");
	By SelectLastCompletedDate = By.xpath("//input[contains(@id,'_EditFormControl_Last_Completed_Date_dateInput') and @type='text']");
	By SelectNextDueDate = By.xpath("//input[contains(@id,'_EditFormControl_Next_Due_Date_dateInput') and @type='text']");
	By txtDescription = By.xpath("//textarea[contains(@id,'_DESCRIPTION')]");
	By btnInsertRow = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i8_i0_SURVEY_STIP_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert']");
	By btnInsertDot = By.xpath("//input[contains(@id,'_SURVEY_STIP_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    By btnCancelDot = By.xpath("//input[contains(@id,'_i0_SURVEY_STIP_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnCancel')]");
    By btnCancelRow = By.xpath("//input[@id='ctl00_ConPHRightTop_TRSR_UC_radPanels_i8_i0_SURVEY_STIP_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnCancel']");
    
	
	
	
	public void ClickonAddNewButton() {
		util.waitUntilElementDisplay(navSurveyRestriction);
		util.click(navSurveyRestriction);
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
	}
	
	 public void SelectType(String value) {
		 util.waitUntilElementDisplay(drpType);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpType,value );
		}
	 
	 public void SelectPriority(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpPriority,value);
		}
	
	 public void SelectStatus(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpStatus,value);
		}
	 
	 public void SelectFrequency(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpFrequency,value);
		}
	 
	 public void SelectAssignedTo(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAssignedTo,value);
		}
	 
	 public void SelectApprovedDate(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(SelectApprovedDate,value);
		}
	 
	 public void SelectStartDate(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(SelectStartDate,value);
		}
	 
	 public void SelectEndDate(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(SelectEndDate,value);
		}
	 
	 public void SelectAssocAgreement(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAssocAgreement,value);
		}
	 
	 public void SelectLastCompletedDate(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(SelectLastCompletedDate,value);
			
		}
	 
	 public void SelectNextDueDate(String value) { 
		 util.dummyWait(3);
		 if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(SelectNextDueDate,value);
			
		}
	 
	 public void AddDescription(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescription,value);
		}
	 
	 public void ClickOnInsertRow() {
		 util.waitUntilElementDisplay(btnInsertRow);
			util.click(btnInsertRow);
			util.waitUntilLoaderDisappear();
			util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully.");
		}
	 
	 public void ClickOnInsertDot() {
		 util.waitUntilElementDisplay(btnInsertDot);
			util.click(btnInsertDot);
			util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully.");
			util.dummyWait(2);	
	 }
	 
	 public void ClickOnCancelDot() {
		 util.waitUntilElementDisplay(btnAddNew);
		 util.click(btnAddNew);
		 util.waitUntilElementDisplay(btnCancelDot);
		 util.click(btnCancelDot);
		 util.dummyWait(3);	
		}
	 
	 public void ClickOnCancelRow() {
		 util.waitUntilElementDisplay(btnAddNew);
		 util.click(btnAddNew);
		 util.waitUntilLoaderDisappear();
		 util.waitUntilElementDisplay(btnCancelRow);
		 util.click(btnCancelRow);
		 util.waitUntilLoaderDisappear();	
		}
	 
	 public void AddSurveyRestrictionsRecords(Map<String, String> map, String testcaseName) {
		
		 
		 
		 if(testcaseName.contains("ROW"))
		 {
			 
			 try {
				 ClickonAddNewButton();
				 util.waitUntilLoaderDisappear();
					log("STEP 1: Record Grid should expands below  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: record does not expand below", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
			 
			 try {
				 SelectType(map.get(Excel.Type));
		   			log("STEP 2:  Selected value display in the  Type  DD ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 2: selected value does not display in Type  DD. ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 2");
		   		}
			 
			 try {
				 SelectPriority(map.get(Excel.Priority));
		   			log("STEP 3:  Selected value display in the Priority  DD   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 3:  selected value does not display in  Priority  DD.  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 3");
		   		}
			 
			 try {
				 SelectStatus(map.get(Excel.Status));
		   			log("STEP 4: Selected value display in the  Status DD   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 4: User  cannot select  value  in the field  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 4");
		   		}
			 
			 try {
				 SelectFrequency(map.get(Excel.Frequency));
				 util.waitUntilLoaderDisappear();
		   			log("STEP 5:  Selected value display in the  Frequency DD   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 5: selected value does not display in  Frequency DD.   ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 5");
		   		}
			 
			 try {
				 SelectAssignedTo(map.get(Excel.AssignedTo));
		   			log("STEP 6:  Selected value display in the  Assigned To DD   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 6: selected value does not display in  Assigned To DD.  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 6");
		   		}
			 
			 try {
				 SelectApprovedDate(map.get(Excel.ApprovedDate));
		   			log("STEP 7:  User can select the  Date ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 7: User  cannot select  Date  from Date Picker  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 7");
		   		}
			 
			 try {
				 SelectStartDate(map.get(Excel.StartDate));
		   			log("STEP 8:  User can select the  Date ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 8: User  cannot select  Date  from Date Picker  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 8");
		   		}
			 
			 try {
				 SelectEndDate(map.get(Excel.EndDate));
		   			log("STEP 9:  User can select the  Date  ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 9: User  cannot select  Date  from Date Picker  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 9");
		   		}
			 
			 try {
				 SelectAssocAgreement(map.get(Excel.AssocAgreement));
		   			log("STEP 10:  Selected value display in the Assoc. Agreement DD ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 10:  selected value does not display in  Assoc. Agreement DD.  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 10");
		   		}
			 
			 try {
				 SelectLastCompletedDate(map.get(Excel.LastCompletedDate));
				 util.waitUntilLoaderDisappear();
		   			log("STEP 11:  User can select the  Date ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 11:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 11");
		   		}
			 
			 try {
				 SelectNextDueDate(map.get(Excel.DueDate));
		   			log("STEP 12:  User can select the  Date ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 12:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 12");
		   		}
			 
			 try {
				 AddDescription(map.get(Excel.Description));
		   			log("STEP 13:  User can enter a value in the field   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 13: User  cannot select  value  in the field  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 13");
		   		}
			 
			 
		 try {
			 ClickOnInsertRow();
	   			log("STEP 14:  Changes saved successfully!  message should be display above the add new button ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 14:  Save successful message does not display above the add new button ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 14");
	   		}
		 
		 try {
			 ClickOnCancelRow();
	   			log("STEP 15:  User can click on cancel button. ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 15:  User cannot click on cancel button. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 15");
	   		}
		 
		 }
		
		 else
		 {
			 
			 try {
				 ClickonAddNewButton();
					log("STEP 1: Record Grid should expands below  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: record does not expand below", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
			 
			 try {
				 SelectType(map.get(Excel.Type));
		   			log("STEP 2:  Selected value display in the  Type  DD ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 2: selected value does not display in Type  DD. ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 2");
		   		}
			 
			 try {
				 SelectPriority(map.get(Excel.Priority));
		   			log("STEP 3:  Selected value display in the Priority  DD   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 3:  selected value does not display in  Priority  DD.  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 3");
		   		}
			 
			 try {
				 SelectStatus(map.get(Excel.Status));
		   			log("STEP 4: Selected value display in the  Status DD   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 4: User  cannot select  value  in the field  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 4");
		   		}
			 
			 try {
				 SelectFrequency(map.get(Excel.Frequency));
		   			log("STEP 5:  Selected value display in the  Frequency DD   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 5: selected value does not display in  Frequency DD.   ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 5");
		   		}
			 
			 try {
				 SelectAssignedTo(map.get(Excel.AssignedTo));
		   			log("STEP 6:  Selected value display in the  Assigned To DD   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 6: selected value does not display in  Assigned To DD.  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 6");
		   		}
			 
			 try {
				 SelectApprovedDate(map.get(Excel.ApprovedDate));
		   			log("STEP 7:  User can select the  Date ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 7: User  cannot select  Date  from Date Picker  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 7");
		   		}
			 
			 try {
				 SelectStartDate(map.get(Excel.StartDate));
		   			log("STEP 8:  User can select the  Date ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 8: User  cannot select  Date  from Date Picker  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 8");
		   		}
			 
			 try {
				 SelectEndDate(map.get(Excel.EndDate));
		   			log("STEP 9:  User can select the  Date  ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 9: User  cannot select  Date  from Date Picker  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 9");
		   		}
			 
			 try {
				 SelectAssocAgreement(map.get(Excel.AssocAgreement));
		   			log("STEP 10:  Selected value display in the Assoc. Agreement DD ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 10:  selected value does not display in  Assoc. Agreement DD.  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 10");
		   		}
			 
			 try {
				 SelectLastCompletedDate(map.get(Excel.LastCompletedDate));
		   			log("STEP 11:  User can select the  Date ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 11:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 11");
		   		}
			 
			 try {
				 SelectNextDueDate(map.get(Excel.DueDate));
		   			log("STEP 12:  User can select the  Date ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 12:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 12");
		   		}
			 
			 try {
				 AddDescription(map.get(Excel.Description));
		   			log("STEP 13:  User can enter a value in the field   ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 13: User  cannot select  value  in the field  ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 13");
		   		}
			 
			 
			 try {
				 ClickOnInsertDot();
		   			log("STEP 14:  Changes saved successfully!  message should be display above the add new button  ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 14:  Save successful message does not display above the add new button ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 14");
                } 
			 
			 try {
				 ClickOnCancelDot();
		   			log("STEP 15:   User can click on cancel button. ", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 15:  User cannot click on cancel button. ", Status.FAIL);
		   			throw new RuntimeException("Failed in step 15");
		   		}
		 }
	 }
}
