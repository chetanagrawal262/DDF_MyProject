package pages.Assignment;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditParcelAssignmentRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String ASSIGNMENT_VALUE;

	public EditParcelAssignmentRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By btnEdit = By.xpath("//input[contains(@id,'_AGENTS_radYALGridControl_ctl00_ctl04_EditButton') and @type='image']");
	By drpAgent = By.xpath("//input[contains(@id,'_AGENT_ID_radYALDropDownList_Input') and @type='text']");
	 By drpAssignmentsOuter = By.xpath("//input[contains(@id,'_MSASSIGNMENTS_MSDropDown_Input') and @type='text'] | //input[contains(@id,'_MSASSIGNMENTS_YALComboBox_Input') and @type='text']");
    By drpAssignment = By.xpath("//input[contains(@id,'_ASSIGNMENT_TYPE_ID_radYALDropDownList_Input') and @type='text']");
    By txtDateAssigned = By.xpath("//input[contains(@id,'_date_Assigned_dateInput') and @type='text']");
    By txtDueDate = By.xpath("//input[contains(@id,'_Due_Date_dateInput') and @type='text']");
    By txtExtendedDate = By.xpath("//input[contains(@id,'_Extended_Date_dateInput') and @type='text']");
    By txtDateCompleted = By.xpath("//input[contains(@id,'_date_Completed_dateInput') and @type='text']");
    By drpStatus = By.xpath("//input[contains(@id,'_EditFormControl_STATUS_ID_radYALDropDownList_Input') and @type='text']");
    By drpPriority = By.xpath("//input[contains(@id,'_EditFormControl_Priority_ID_radYALDropDownList_Input') and @type='text']");
    By txtComments = By.xpath("//textarea[contains(@id,'_EditFormControl_COMMENTS')]");
    By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    By btnCancel = By.xpath("//input[contains(@id,'_EditFormControl_btnCancel') and @type='submit']");

    
    public void ClickOnEditButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    	
    }

    public void SelectAgent(String value) {
    	util.waitUntilElementDisplay(drpAgent);
		if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAgent, value);
   }
    
    public void SelectAssignment(String value) {
		if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAssignment, value);
    }
    
    public void AddDateAssigned(String value) {
		if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDateAssigned, value);
    }
    
    public void AddDueDate(String value) {
		if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDueDate, value);
    }
    
    public void AddExtendedDate(String value) {
		if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExtendedDate, value);
    }
    
    public void AddDateCompleted(String value) {
		if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDateCompleted , value);
    }
    
    public void SelectStatus(String value) {
		if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpStatus , value);
    }
    
    public void SelectPriority(String value) {
		if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpPriority , value);
    }
    
    public void AddComments(String value) {
		if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtComments , value);
    }
    
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    	util.dummyWait(10);
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
  		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
  		util.dummyWait(2);
    }
    
   public void ClickOnCancelButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    	util.waitUntilElementDisplay(btnCancel);
    	util.click(btnCancel);
    	util.dummyWait(2);
    }

   By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
   By drpConfigAssignment = By.xpath("//span[contains(@id,'_EditFormControl_ASSIGNMENT_TYPE_ID_ManageDDID')]");
   By editLink = By.xpath("(//*[contains(@id,'idManageDD_GridDetails_radYALGridControl')]/..//*[text()='True'])[1]/..//input[@alt='Edit']");
   By txtDisplayName = By.xpath("//textarea[contains(@id,'EditFormControl_RadDisplayName')]");
   By txtLegalDesc = By.xpath("//textarea[contains(@id,'_EditFormControl_Lookup_Desc')]");
   By activeCheckbox = By.xpath("//input[contains(@id,'_EditFormControl_Active')]");
   By buttonUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
   By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
   
	public void TurnOnDesignMode() {
   	util.waitUntilElementDisplay(btnDesignMode);
   	util.click(btnDesignMode);
   	util.dummyWait(2);
   }
	
    public void EditParcelAssignmentRecord(Map<String, String> map, String testcaseName) {
    	util.dummyWait(5);
    	if (testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
    		
    		 try {
    	  		   ClickOnEditButton();
    				log("STEP 1: Existing record should expands below  ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1: Existing record does not expand below", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
    	  	  
    		 try {
 				util.click(drpConfigAssignment);
 				util.switchToChildWindow();
 				log("STEP 2: User can click on Assignment DD Configuration Icon ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 2: User cannot click on Assignment DD Configuration Icon", Status.FAIL);
 				throw new RuntimeException("Failed in step 2");
 			}
 			
 			try {
 				util.click(editLink);
 				util.dummyWait(1);
 				log("STEP 3: User can click on Edit link of the first Active Assignment Value ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 3: User cannot click on Edit link of the first Active Assignment Value", Status.FAIL);
 				throw new RuntimeException("Failed in step 3");
 			}
 			
 			ASSIGNMENT_VALUE = driver.findElement(txtDisplayName).getText();
 			System.out.println("Display Name"+ASSIGNMENT_VALUE);
 			if(ASSIGNMENT_VALUE.isEmpty()) {
 				ASSIGNMENT_VALUE = driver.findElement(txtLegalDesc).getText();
 				System.out.println("Legal Desc"+ASSIGNMENT_VALUE);
 			}

 			try {
 				util.switchToParentWindow();
 				util.inputText(drpAssignment, ASSIGNMENT_VALUE);
 				By ddValue = By.xpath("//div[contains(@id,'_EditFormControl_ASSIGNMENT_TYPE_ID_radYALDropDownList_DropDown')]/..//li[normalize-space()='"+ASSIGNMENT_VALUE+"']");
 				Assert.assertTrue(util.isElementVisible(ddValue));
 				log("STEP 4: User can see 'Active' Assignments in dd", Status.PASS);
 			} catch (AssertionError e) {
 				log("STEP 4: User cannot see 'Active' Assignments in dd", Status.FAIL);
 			}
 			
 			try {
 				util.switchToChildWindow();
 				util.click(activeCheckbox);
 				util.waitFor(200);
 				log("STEP 5: User can make Assignment Dd value Inactive ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 5: User cannot make Assignment Dd value Inactive", Status.FAIL);
 				throw new RuntimeException("Failed in step 5");
 			}
 			
 			try {
 				util.click(buttonUpdate);
 				util.dummyWait(1);
 				log("STEP 6: User can click on Update Button ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 6: User cannot click on Update Button", Status.FAIL);
 				throw new RuntimeException("Failed in step 6");
 			}
 			
 			try {
 				util.switchToParentWindow();
 				 util.waitUntilElementDisplay(firstParcel);
 	 	    		util.click(firstParcel);
 				util.dummyWait(1);
 				log("STEP 7: User can Refresh the grid ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 7: User cannot Refresh the grid", Status.FAIL);
 				throw new RuntimeException("Failed in step 7");
 			}
 			
 			try {
 				util.click(drpAssignmentsOuter);
 				By ddValue = By.xpath("//div[contains(@id,'_MSASSIGNMENTS_MSDropDown')]/..//div[normalize-space()='"+ASSIGNMENT_VALUE+"']");
 				Assert.assertFalse(util.isElementVisible(ddValue));
 				log("STEP 8: User cannot see 'InActive' Assignments in dd", Status.PASS);
 			} catch (AssertionError e) {
 				log("STEP 8: User can see 'InActive' Assignments in dd", Status.FAIL);
 			}
 			
 			try {
 				util.switchToChildWindow();
 				By edit = By.xpath("(//*[contains(@id,'idManageDD_GridDetails_radYALGridControl')]/..//*[text()='"+ASSIGNMENT_VALUE+"'])[1]/..//input[@alt='Edit']");
 				util.click(edit);
 				log("STEP 9: User can click on edit icon", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 9: User cannot click on edit icon", Status.FAIL);
 			}
 			
 			try {
 				util.click(activeCheckbox);
 				log("STEP 10: User can make Assignment DD Value Active", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 10: User cannot make Assignment DD Value Active", Status.FAIL);
 				throw new RuntimeException("Failed in step 10");
 			}
 			
 			try {
 				util.click(buttonUpdate);
 				util.dummyWait(1);
 				log("STEP 11: User can click on Update Button ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 11: User cannot click on Update Button", Status.FAIL);
 				throw new RuntimeException("Failed in step 11");
 			}
 			
 			try {
 				util.switchToParentWindow();
 				ClickOnEditButton();
 				util.dummyWait(1);
 				log("STEP 12: User can Refresh the grid ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 12: User cannot Refresh the grid", Status.FAIL);
 				throw new RuntimeException("Failed in step 12");
 			}
    	  	  try {
    	  		   SelectAgent(map.get(Excel.Agent));
    				log("STEP 13: Selected value display in the Agents DD  ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 13: selected value does not display in Agents DD. ", Status.FAIL);
    				throw new RuntimeException("Failed in step 13");
    			}
    	  	  
    	  	  try {
    	  		  SelectAssignment(map.get(Excel.ParcelAssignment));
    				log("STEP 14: Selected value display in the Assignments DD  ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 14: selected value does not display in Assignments DD. ", Status.FAIL);
    				throw new RuntimeException("Failed in step 14");
    			}
    	  	  
    	  	 try {
    	  		   AddDateAssigned(map.get(Excel.AssignedDate));
    				log("STEP 15: selected Date Assigned date should be display as selected  ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 15: selected Date Assigned date does not display as selected ", Status.FAIL);
    				throw new RuntimeException("Failed in step 15");
    			}
    	  	 
    	  	 try {
    	  		   AddDueDate(map.get(Excel.DueDate));
    				log("STEP 16: selected Due date should be display as selected  ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 16: selected Due date does not display as selected ", Status.FAIL);
    				throw new RuntimeException("Failed in step 16");
    			}
    	  	 
    	  	 
    	  	 try {
    	  		SelectStatus(map.get(Excel.Status));
    				log("STEP 17: Selected value display in the Status DD ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 17: selected value does not display in Status DD. ", Status.FAIL);
    				throw new RuntimeException("Failed in step 17");
    			}
    	  	 
    	  	 
    	  	try {
    	  		AddComments(map.get(Excel.Comments));
    	 			log("STEP 18: Entered value should display in the Comments field. ", Status.PASS);
    	 		} catch (Exception e) {
    	 			log("STEP 18: Entered value does not display in Comments field. ", Status.FAIL);
    	 			throw new RuntimeException("Failed in step 18");
    	 		}
    	  	
    	  	try {
    	  		ClickOnUpdateButton();
    	 			log("STEP 19:  Changes saved successfully! message should be display above grid", Status.PASS);
    	 		} catch (Exception e) {
    	 			log("STEP 19: Changes saved successfully! message should be display above the Save button ", Status.FAIL);
    	 			throw new RuntimeException("Failed in step 19");
    	 		}
    	  	
     	       try {
    	  		ClickOnCancelButton();
    	 			log("STEP 20:  Expanded Grid part should close and Chnaged value should not be update ", Status.PASS);
    	 		} catch (Exception e) {
    	 			log("STEP 20: unable to click Cancel button OR Expanded Grid does not close ", Status.FAIL);
    	 			throw new RuntimeException("Failed in step 20");
    	 		}
    	  	
    		
    	}
    	
    else {	  
			try {
				ClickOnEditButton();
				log("STEP 2: Existing record should expands below  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: Existing record does not expand below", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

			//#66458-Start
			try {
				util.click(drpConfigAssignment);
				util.switchToChildWindow();
				log("STEP 3: User can click on Assignment DD Configuration Icon ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot click on Assignment DD Configuration Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				util.click(editLink);
				util.dummyWait(1);
				log("STEP 4: User can click on Edit link of the first Active Assignment Value ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot click on Edit link of the first Active Assignment Value", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			ASSIGNMENT_VALUE = driver.findElement(txtDisplayName).getText();
			System.out.println("Display Name"+ASSIGNMENT_VALUE);
			if(ASSIGNMENT_VALUE.isEmpty()) {
				ASSIGNMENT_VALUE = driver.findElement(txtLegalDesc).getText();
				System.out.println("Legal Desc"+ASSIGNMENT_VALUE);
			}

			try {
				util.switchToParentWindow();
				util.inputText(drpAssignment, ASSIGNMENT_VALUE);
				By ddValue = By.xpath("//div[contains(@id,'_EditFormControl_ASSIGNMENT_TYPE_ID_radYALDropDownList_DropDown')]/..//li[normalize-space()='"+ASSIGNMENT_VALUE+"']");
				Assert.assertTrue(util.isElementVisible(ddValue));
				log("STEP 5: User can see 'Active' Assignments in dd", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 5: User cannot see 'Active' Assignments in dd", Status.FAIL);
			}
			
			try {
				util.switchToChildWindow();
				util.click(activeCheckbox);
				util.waitFor(200);
				log("STEP 6: User can make Assignment Dd value Inactive ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot make Assignment Dd value Inactive", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				util.click(buttonUpdate);
				util.dummyWait(1);
				log("STEP 7: User can click on Update Button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot click on Update Button", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				util.switchToParentWindow();
				 util.waitUntilElementDisplay(firstParcel);
	 	    		util.click(firstParcel);
				util.dummyWait(1);
				log("STEP 8: User can Refresh the grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot Refresh the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				util.inputText(drpAssignmentsOuter, ASSIGNMENT_VALUE);
				By ddValue = By.xpath("//div[contains(@id,'_MSASSIGNMENTS_MSDropDown_DropDown')]/..//em[normalize-space()='"+ASSIGNMENT_VALUE+"']");
				Assert.assertFalse(util.isElementVisible(ddValue));
				log("STEP 9: User cannot see 'InActive' Assignments in dd", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9: User can see 'InActive' Assignments in dd", Status.FAIL);
			}
			
			try {
				util.switchToChildWindow();
				By edit = By.xpath("(//*[contains(@id,'idManageDD_GridDetails_radYALGridControl')]/..//*[text()='"+ASSIGNMENT_VALUE+"'])[1]/..//input[@alt='Edit']");
				util.click(edit);
				log("STEP 10: User can click on edit icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot click on edit icon", Status.FAIL);
			}
			
			try {
				util.click(activeCheckbox);
				log("STEP 11: User can make Assignment DD Value Active", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User cannot make Assignment DD Value Active", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				util.click(buttonUpdate);
				util.dummyWait(1);
				log("STEP 12: User can click on Update Button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User cannot click on Update Button", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			
			try {
				util.switchToParentWindow();
				ClickOnEditButton();
				util.dummyWait(1);
				log("STEP 13: User can Refresh the grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: User cannot Refresh the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			//#66458-End
  	  if(testcaseName.contains("DOT")) {
  	  try {
  		  util.dummyWait(15);
  		   SelectAgent(map.get(Excel.Agent));
			log("STEP 14: Selected value display in the Agents DD  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: selected value does not display in Agents DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
  	  }
  	  else {
  		try {
  		 SelectAgent(map.get(Excel.Agent));
			log("STEP 15: Selected value display in the Agents DD  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: selected value does not display in Agents DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
  	  }
    	
  	  try {
  		  SelectAssignment(map.get(Excel.ParcelAssignment));
			log("STEP 16: Selected value display in the Assignments DD  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: selected value does not display in Assignments DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
  	  
  	 try {
  		   AddDateAssigned(map.get(Excel.AssignedDate));
			log("STEP 17: selected  Assigned date should be display as selected  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: selected Date Assigned date does not display as selected ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
  	 
  	 try {
  		   AddDueDate(map.get(Excel.DueDate));
			log("STEP 18: selected Due date should be display as selected  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: selected Due date does not display as selected ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
  	 
  	 try {
  		  AddExtendedDate(map.get(Excel.ExecutedDate));
			log("STEP 19:  selected Extended date should be display as selected  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: selected Extended date does not display as selected ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
  	 
  	 try {
  		  AddDateCompleted(map.get(Excel.LastCompletedDate));
			log("STEP 20: selected  Completed date should be display as selected  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: selected Date Completed date does not display as selected ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
  	 
  	 try {
  		SelectStatus(map.get(Excel.Status));
			log("STEP 21: Selected value display in the Status DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: selected value does not display in Status DD. ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
  	 
  	 try {
  		SelectPriority(map.get(Excel.Priority));
 			log("STEP 22: Selected value display in the Priority DD  ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 22: selected value does not display in Priority DD.  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 22");
 		}
  	 
  	try {
  		AddComments(map.get(Excel.Comments));
 			log("STEP 23: Entered value should display in the Comments field. ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 23: Entered value does not display in Comments field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 23");
 		}
  	
  	try {
  		ClickOnUpdateButton();
 			log("STEP 24:  Changes saved successfully! message should be display above grid", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 24: Changes saved successfully! message should be display above the Save button ", Status.FAIL);
 			throw new RuntimeException("Failed in step 24");
 		}
  	util.dummyWait(2); 
  	
     }
    	
    }
}
