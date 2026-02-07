package pages.EncroachmentMitigation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class Obligations_CommitmentsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public Obligations_CommitmentsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By expandObligationsPanel = By.xpath("//span[contains(text(),'Obligations/Commitments')]");
	By btnAddNew = By.xpath("//a[contains(@id,'_ISSUESCONST_STIP_radYALGridControl_ctl00_ctl02_ctl00_lnkAddNewRecord')]");
	By drpType = By.xpath("//input[contains(@id,'_EditFormControl_TYPE_ID_radYALDropDownList_Input') and @type='text']");
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
	By changesSavedSuccessfully = By.xpath("//span[@id='ctl00_ConPHRightTop_TREM_UC_radPanels_i5_i0_ISSUESCONST_STIP_usrMessage']");
	By btnEdit = By.xpath("//input[@id='ctl00_ConPHRightTop_TREM_UC_radPanels_i5_i0_ISSUESCONST_STIP_radYALGridControl_ctl00_ctl04_EditButton']");
	By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
	By btnDelete = By.xpath("//input[@id='ctl00_ConPHRightTop_TREM_UC_radPanels_i5_i0_ISSUESCONST_STIP_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment']");
	By iframeDelete = By.xpath("//td[@class='rwWindowContent']");
    By btnOk = By.xpath("//span[text()='OK']");
    
    public void ExpandObligationPanel() {
		util.waitUntilElementDisplay(expandObligationsPanel);
		util.click(expandObligationsPanel);
	}
    
    public void ClickonAddNewButton() {
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.waitUntilLoaderDisappear();
	}
	
	 public void SelectType(String value) {
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
			util.waitUntilLoaderDisappear();
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
			util.waitUntilLoaderDisappear();		
	 }
	 
	 public void ClickOnEdit() {
		    util.waitUntilElementDisplay(btnEdit);
			util.click(btnEdit);
			util.waitUntilLoaderDisappear();
		}
	 
	 public void ClickOnUpdateButton() {
		    util.waitUntilElementDisplay(btnUpdate);
			util.click(btnUpdate);
			util.waitUntilLoaderDisappear();
		}
	 
	 public void ClickOnDelete() {
		    util.waitUntilElementDisplay(btnDelete);
			util.click(btnDelete);
		}
	
	 public void ClickOnOk() {
		 util.waitUntilElementDisplay(btnOk);
		 util.click(btnOk);
		 util.waitUntilLoaderDisappear();
		 	
		}
    
	 public void AddObligationsRecord(Map<String, String> map, String testcaseName) {
		
		  try {
			  ExpandObligationPanel();
			 ClickonAddNewButton();
				log("STEP 1: User can click on Add New Record button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot click on Add New Record button", Status.FAIL);
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
	   			log("STEP 11:  User can select the  Last Completed Date ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 11:  User  cannot select  Date  from Date Picker  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 11");
	   		}
		 
		 try {
			 AddDescription(map.get(Excel.Description));
	   			log("STEP 12:  User can enter a value in Description field   ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 12: User  cannot select  value  in Description field  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 12");
	   		}
		 
		
		 try {
			 ClickOnInsertButton();
	   			log("STEP 13:  User can click on Insert Button ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 13:  User cannot click on Insert Button ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 13");
	   		}
		 
		 try {
			 Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
	   			log("STEP 14:  User can see Success Message", Status.PASS);
	   		} catch (AssertionError e) {
	   			log("STEP 14:  User cannot Success Message ", Status.FAIL);
	   		}
		 
		 try {
				By stipulationType = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//strong[text()='"+map.get(Excel.Type)+"']");
				Assert.assertTrue(util.isElementVisible(stipulationType));
				log("STEP 15: User can see Stipulation Type in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 15: User cannot see Stipulation Type in the grid veiw", Status.FAIL);
			}
		 
		 try {
				By priority = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//strong[text()='"+map.get(Excel.Priority)+"']");
				Assert.assertTrue(util.isElementVisible(priority));
				log("STEP 16: User can see Priority in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 16: User cannot see Priority in the grid veiw", Status.FAIL);
			}
		 
		 try {
				By frequency = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//strong[text()='"+map.get(Excel.Frequency)+"']");
				Assert.assertTrue(util.isElementVisible(frequency));
				log("STEP 17: User can see Frequency in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 17: User cannot see Frequency in the grid veiw", Status.FAIL);
			}
		 
		 try {
				By status = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//strong[text()='"+map.get(Excel.Status)+"']");
				Assert.assertTrue(util.isElementVisible(status));
				log("STEP 18: User can see Status in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 18: User cannot see Status in the grid veiw", Status.FAIL);
			}
		 
		 try {
				By dateApproved = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//strong[text()='"+map.get(Excel.ApprovedDate)+"']");
				Assert.assertTrue(util.isElementVisible(dateApproved));
				log("STEP 19: User can see Date Approved in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 19: User cannot see Date Approved in the grid veiw", Status.FAIL);
			}
		 
		 try {
				By startDate = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//strong[text()='"+map.get(Excel.StartDate)+"']");
				Assert.assertTrue(util.isElementVisible(startDate));
				log("STEP 20: User can see Start Date in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 20: User cannot see Start Date in the grid veiw", Status.FAIL);
			}
		 
		 try {
				By endDate = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//strong[text()='"+map.get(Excel.EndDate)+"']");
				Assert.assertTrue(util.isElementVisible(endDate));
				log("STEP 21: User can see End Date in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 21: User cannot see End Date in the grid veiw", Status.FAIL);
			}
		 
		 try {
				By lastCompletedDate = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//strong[text()='"+map.get(Excel.LastCompletedDate)+"']");
				Assert.assertTrue(util.isElementVisible(lastCompletedDate));
				log("STEP 22: User can see Last Completed Date in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 22: User cannot see Last Completed Date in the grid veiw", Status.FAIL);
			}
		 
		 try {
				By nextDueDate = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//strong[text()='"+map.get(Excel.NextDueDate)+"']");
				Assert.assertTrue(util.isElementVisible(nextDueDate));
				log("STEP 23: User can see Next Due Date in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 23: User cannot see Next Due Date in the grid veiw", Status.FAIL);
			}
		 
		 try {
				By assignedTo = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//td[text()='"+map.get(Excel.AssignedTo)+"']");
				Assert.assertTrue(util.isElementVisible(assignedTo));
				log("STEP 24: User can see Assigned To in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 24: User cannot see Assigned To in the grid veiw", Status.FAIL);
			}
		 
	 }
	 
	 public void EditObligationsRecord(Map<String, String> map, String testcaseName) {
			
		  try {
			  ClickOnEdit();
				log("STEP 1: User can click on Edit Icon ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot click on Edit Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
		 try {
			 SelectStatus(map.get(Excel.Status));
	   			log("STEP 2: User can update the status  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 2: User cannot update the status ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 2");
	   		}
		 
		 try {
			 SelectAssignedTo(map.get(Excel.AssignedTo));
	   			log("STEP 3:  User can change the Assignment   ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 3: User cannot change the Assignment ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 3");
	   		}
		 
		 try {
			 ClickOnUpdateButton();
	   			log("STEP 4:  User can click on Update Button ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 4:  User cannot click on Update Button ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 4");
	   		}
		 
		 try {
			 Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
	   			log("STEP 5:  User can see Success Message", Status.PASS);
	   		} catch (AssertionError e) {
	   			log("STEP 5:  User cannot Success Message ", Status.FAIL);
	   		}
		 
		 try {
				By status = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//strong[text()='"+map.get(Excel.Status)+"']");
				Assert.assertTrue(util.isElementVisible(status));
				log("STEP 6: User can see updated Status in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 6: User cannot see updated Status in the grid veiw", Status.FAIL);
			}
		 
		 try {
				By assignedTo = By.xpath("//tr[contains(@id,'_ISSUESCONST_STIP_radYALGridControl')]/..//td[text()='"+map.get(Excel.AssignedTo)+"']");
				Assert.assertTrue(util.isElementVisible(assignedTo));
				log("STEP 7: User can see updated Assigned To value in the grid veiw", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 7: User cannot see updated Assigned To value  in the grid veiw", Status.FAIL);
			}
		 
	 }
	 
		public void DeleteObligationsRecord(String testcaseName) {

			try {
				ClickOnDelete();
				log("STEP 1: User can click on Delete Icon ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot click on Delete Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			try {
				ClickOnOk();
				log("STEP 2: User can click on Ok ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on Ok", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

			try {
				Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
				log("STEP 3:  User can see Success Message", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 3:  User cannot Success Message ", Status.FAIL);
			}
		}
	 
}
