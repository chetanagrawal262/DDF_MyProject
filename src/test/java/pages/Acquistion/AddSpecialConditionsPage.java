package pages.Acquistion;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddSpecialConditionsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddSpecialConditionsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navSpecialConditions = By.xpath("//span[contains(text(),'Special Conditions')]");
	By btnAddNew = By.xpath("//img[@id='ctl00_ConPHRightTop_TRAT_UC_radPanels_i8_i0_CONST_STIP_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By drpType = By.xpath("//input[contains(@id,'_TYPE_ID_radYALDropDownList_Input') and @type='text']");
	By drpPriority = By.xpath("//input[contains(@id,'_PRIORITY_ID_radYALDropDownList_Input') and @type='text']");
	By drpStatus = By.xpath("//input[contains(@id,'_EditFormControl_STATUS_ID_radYALDropDownList_Input') and @type='text']");
	By drpFrequency = By.xpath("//input[contains(@id,'_FREQUENCY_ID_radYALDropDownList_Input') and @type='text']");
	By drpAssignedTo = By.xpath("//input[contains(@id,'_Assigned_To_ID_radYALDropDownList_Input') and @type='text']");
	By SelectApprovedDate = By.xpath("//input[contains(@id,'_Date_Approved_dateInput') and @type='text']");
	By SelectStartDate = By.xpath("//input[contains(@id,'_Start_Date_dateInput') and @type='text']");
	By SelectEndDate = By.xpath("//input[contains(@id,'_End_Date_dateInput') and @type='text']");
	By drpAssocAgreement = By.xpath("//input[contains(@id,'_Recording_ID_radYALDropDownList_Input') and @type='text']");
	By SelectLastCompletedDate = By.xpath("//input[contains(@id,'_Last_Completed_Date_dateInput') and @type='text']");
	By SelectNextDueDate = By.xpath("//input[contains(@id,'_Next_Due_Date_dateInput') and @type='text']");
	By txtDescription = By.xpath("//textarea[contains(@id,'_EditFormControl_DESCRIPTION')]");
	By btnInsert = By.xpath("(//input[contains(@id,'_EditFormControl_btnInsert') and @type='submit'])"); 
	By changesSavedSuccessfully = By.xpath("//span[@id='ctl00_ConPHRightTop_TRAT_UC_radPanels_i8_i0_CONST_STIP_usrMessage']");
	By btnEdit = By.xpath("//input[@id='ctl00_ConPHRightTop_TRAT_UC_radPanels_i8_i0_CONST_STIP_radYALGridControl_ctl00_ctl04_EditButton']");
	By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
	By btnDelete = By.xpath("//input[@id='ctl00_ConPHRightTop_TRAT_UC_radPanels_i8_i0_CONST_STIP_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment']");
	By iframeDelete = By.xpath("//td[@class='rwWindowContent']");
    By btnOk = By.xpath("//span[text()='OK']");
    
    public void ClickonAddNewButton() {
		util.waitUntilElementDisplay(navSpecialConditions);
		util.click(navSpecialConditions);
		util.click(btnAddNew);
	}
	
	 public void SelectType(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpType,value );
		}
	 
	 By firstType = By.xpath("(//*[contains(@id,'EditFormControl_TYPE_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	 public void SelectType() {
			util.click(drpType);
			util.click(firstType);
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
			util.dummyWait(6);
		}
	 
	 public void SelectNextDueDate(String value) {
		 util.waitUntilElementDisplay(SelectNextDueDate);
		 if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(SelectNextDueDate,value);
			
		}
	 
	 public void AddDescription(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescription,value);
		}
	 
	 public void ClickOnInsertButton() {
		    util.waitUntilElementDisplay(btnInsert);
			util.click(btnInsert);
			util.dummyWait(5);	
			util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully));		
	
	 }
	 
	 public void ClickOnEdit(String value) {
		    util.waitUntilElementDisplay(btnEdit);
			util.click(btnEdit);
			util.dummyWait(3);
			if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpType,value );
		}
	 
	 public void ClickOnUpdateButton() {
		    util.waitUntilElementDisplay(btnUpdate);
			util.click(btnUpdate);
			util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully));		
            util.dummyWait(2);
		}
	 
	 public void ClickOnDelete() {
		 util.dummyWait(1);
		    util.waitUntilElementDisplay(btnDelete);
			util.click(btnDelete);
		}
	
	 public void ClickOnOk() {
		 util.waitUntilElementDisplay(btnOk);
		 util.click(btnOk);
		 util.dummyWait(1);
		 util.click(navSpecialConditions);
		 util.dummyWait(3);
		 	
		}
    
	 public void AddSpecialConditions(Map<String, String> map, String testcaseName) {
		
		 if (testcaseName.contains("DOT") || testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
				log(" Add Special Conditions not applicable for DOT and ALT", Status.SKIP);
			}
			else {
		 
		 try {
			 ClickonAddNewButton();
				log("STEP 1: Record Grid should expands below  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: record does not expand below", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
		 try {
			 SelectType();
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
	   			log("STEP 11:  User can select the  Last Completed Date ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 11:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 11");
	   		}
		 
		 try {
			 SelectNextDueDate(map.get(Excel.DueDate));
	   			log("STEP 12:  User can select the  Due Date ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 12:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 12");
	   		}
		 
		 try {
			 AddDescription(map.get(Excel.Description));
	   			log("STEP 13:  User can enter a value in Description field   ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 13: User  cannot select  value  in Description field  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 13");
	   		}
		 
		
		 try {
			 ClickOnInsertButton();
	   			log("STEP 14:  Changes saved successfully!  message should be display above the add new button ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 14:  Save successful message does not display above the add new button ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 14");
	   		}
		 
		 try {
			 ClickOnEdit(map.get(Excel.UpdatedDocumentType));
	   			log("STEP 15:  added value display in the DocumentType column field ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 15:  added  value does not displayed in the field.", Status.FAIL);
	   			throw new RuntimeException("Failed in step 15");
	   		}
		 
		 try {
			 ClickOnUpdateButton();
	   			log("STEP 16:  Changes saved successfully!  message should be display above the add new button ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 16:  Save successful message does not display above the add new button ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 16");
	   		}
		 
		 try {
			 ClickOnDelete();
	   			log("STEP 17: new pop up having title delete opens stating Delete this record? ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 17:  Pop up does not disply ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 17");
	   		}
		 
		 try {
			 ClickOnOk();
	   			log("STEP 18:  record deletes permanantly ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 18:   record not deleted  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 18");
	   		}
		 
	 }
		 
	 }
	 
}
