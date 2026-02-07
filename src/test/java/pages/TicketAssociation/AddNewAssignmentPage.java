package pages.TicketAssociation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewAssignmentPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddNewAssignmentPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navCustomerOutreach = By.xpath("//span[contains(text(),'Customer Outreach')]");
	By navTicketInformation = By.xpath("(//span[contains(text(),'Ticket Information')])[1]");
	By Assignment = By.xpath("(//span[text()='Assignments'])[2]");
	By btnAddNew = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[1]");
	By btnActiveCheckbox = By.xpath("//*[text()='Active:']/..//input[contains(@id,'EditFormControl_idEditLOAssignment') and @type='checkbox']");
	By drpAssignedToAlt = By.xpath("//span[text()='Assign To:']/..//span[text()='Select One']");
	By drpAssignedTo = By.xpath("(//span[contains(@class,'rddtFakeInput rddtEmptyMessage')])[1]");
	By txtAssignedTo = By.xpath("(//input[contains(@class,'rddtFilterEmptyMessage') and @value='Filtering...'])[1]");
    By drpTicketOwner = By.xpath("//*[contains(text(),'Ticket Owner:')]/..//input[contains(@id,'EditFormControl_idEditLOAssignment') and @type='text']");
    By btnSave = By.xpath("//input[contains(@id,'EditFormControl_idEditLOAssignment_btnSave')]");
	By btnCancel = By.xpath("//input[contains(@id,'idEditLOAssignment_btnCancel')]");
	
	 public void ClickOnAddNewRecord() {
	    	util.dummyWait(1);
		 if(!util.isElementVisible(btnAddNew)) {
	    	util.click(Assignment);
		 }
	    	util.waitUntilElementDisplay(btnAddNew);
	    	util.click(btnAddNew);
	    	util.waitUntilLoaderDisappear();
	    }
	    
	    public void ClickOnAddNewRecordROW() {
	    	if(!util.isElementVisible(btnAddNew)) {
	    	util.click(Assignment);
	    	}
	    	util.waitUntilElementDisplay(btnAddNew);
	    	util.click(btnAddNew);
	    	util.waitUntilLoaderDisappear();
	    }
	    
	    public void ClickOnActiveCheckbox() {
	    	util.waitUntilElementDisplay(btnActiveCheckbox);
	    	util.click(btnActiveCheckbox);
	    	util.click(btnActiveCheckbox);

	    }
	
	   public void SelectAssignedToALT(String value) {
		   util.waitUntilElementDisplay(drpAssignedToAlt);
		   util.click(drpAssignedToAlt);
		   if (!commonFunction.checkNA(value))
				util.inputText(txtAssignedTo,value);
		   util.pressDownkey();
		   util.pressDownkey();
		   util.pressENTERkey();
	   }
	   
	   public void SelectAssignedToROW(String value) {
		   util.waitUntilElementDisplay(drpAssignedTo);
		   util.click(drpAssignedTo);
		   if (!commonFunction.checkNA(value))
				util.inputText(txtAssignedTo,value);
		   util.pressDownkey();
		   util.pressDownkey();
		   util.pressENTERkey();
	   }
	   
	   public void SelectMakeTicketOwner(String value) {
		   if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpTicketOwner,value);
	   }
	   
	   public void ClickOnSaveButton() {
              util.waitUntilElementDisplay(btnSave);
              util.click(btnSave);
              util.waitUntilLoaderDisappear();
	   }
	   
	   public void ClickOnCancelButton() {
			util.waitUntilElementDisplay(btnAddNew);
	    	util.click(btnAddNew);
	    	util.waitUntilLoaderDisappear();
       	util.waitUntilElementDisplay(btnCancel);
    	util.click(btnCancel);
    	util.waitUntilLoaderDisappear();
	   }
	   
	   By drpTicket = By.xpath("//input[contains(@id,'idCustOutreach_RadLOWTicketQueueSelector_Input') and @type='text']");
	   
	   public void SelectTicket(String value) {
		   util.click(drpTicket);
		   util.selectValueFromDropdown(drpTicket, value);
		   util.dummyWait(2);
	   }
	 
	  public void AddNewAssignment(Map<String, String> map, String testcaseName) {
		  
		  SelectTicket(map.get(Excel.Ticket));
		  
		  util.dummyWait(2);
	   if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
   		try {
   			ClickOnAddNewRecord();
   				log("STEP 1: User can click on Add new Assignment ", Status.PASS);
   			} catch (Exception e) {
   				log("STEP 1: User cannot click on Add new Assignment ", Status.FAIL);
   				throw new RuntimeException("Failed in step 1");
   			}
   	}
   	else {
   		try {
   			ClickOnAddNewRecordROW();
   			    log("STEP 1: User can click on Add new Assignment ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot click on Add new Assignment ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
   	}
 	  
 	  
 	  try {
 		 ClickOnActiveCheckbox();
			log("STEP 2: User can checked the Active check box ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot checked the Active check box ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
 	  
 	  if(testcaseName.contains("ALT")) {
 	  try {
 		 SelectAssignedToALT(map.get(Excel.AssignedTo));
			log("STEP 3: Entered value should diplays in the Assigned To field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot enter value  in Assigned To field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
 	  }
 	  else {
 	 try {
 		SelectAssignedToROW(map.get(Excel.AssignedTo));
 		    log("STEP 3: Entered value should diplays in the Assigned To field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: Entered value does not display in Assigned To field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
 	  }
 	  
 	  
 	try {
 		SelectMakeTicketOwner(map.get(Excel.TicketOwner));
			log("STEP 4: Entered value should diplays in the Ticket Owner field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: Entered value does not display in Ticket Owner field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
 	
 	try {
 		ClickOnSaveButton();
			log("STEP 5: New Assignment should be Saved Successfully ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: New Assignment can not be Saved Successfully ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
 	
 	try {
 		ClickOnCancelButton();
			log("STEP 6:  New Assignment pop up should be closed and record should not be saved ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  New Assignment pop up  can not be closed ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
   }
	   
}
