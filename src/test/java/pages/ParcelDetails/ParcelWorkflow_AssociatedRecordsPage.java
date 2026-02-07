package pages.ParcelDetails;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ParcelWorkflow_AssociatedRecordsPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ParcelWorkflow_AssociatedRecordsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}


	By btnAddNewRecordAlt = By.xpath("//img[contains(@id,'_idTractInfoApproval_YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By btnAddNewRecordDot = By.xpath("//img[contains(@id,'YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4')] ");
	By btnAddNewRecordRow = By.xpath("//img[contains(@id,'_YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@id,'_YALComboBox_Input')  and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'idManageApproval_btnSaveHeader') and @type='image']");
	By drpStatusException = By.xpath("//input[contains(@id,'idManageApproval_STATUS_EXC_ID_radYALDropDownList_Input') and @type='text']");
	By txtReasonForStatusException = By.xpath("//textarea[@id='idManageApproval_STS_COMMENTS']");
	By navAssociatedRecord = By.xpath("//span[contains(text(),'Associated Records')]");
	By SuccessfulMessage = By.xpath("//span[text()='Changes saved successfully.']");

	By drpAddProjects = By.xpath(
				"//*[normalize-space()='Projects:']/../following-sibling::tr//input[@id='idManageApproval_Projects_Input']");
	By drpAddProjectsClose = By.xpath(
				"//*[normalize-space()='Projects:']/../following-sibling::tr//a[contains(@id,'Approval_Projects_Arrow')]");
	By drpListOfTrack = By.xpath(
				"//*[normalize-space()='List of Tract:']/../following-sibling::tr//input[@id='idManageApproval_Tract_Agreement_Input']");
		By drpListOfTrackClose = By.xpath(
				"//*[normalize-space()='List of Tract:']/../following-sibling::tr//a[contains(@id,'Tract_Agreement_Arrow')]");
		
		By drpListofLeases = By.xpath(
				"//*[normalize-space()='List of Leases:']/../following::div[@id='idManageApproval_Lease_Association']");
		By drpListofLeasesClose = By.xpath(
				"//*[normalize-space()='List of Leases:']/../following-sibling::tr//a[@id='idManageApproval_Lease_Association_Arrow']");
		
		
		By btnGoProject = By.xpath("//input[@id='idManageApproval_btnGo']");
		By btnAddListOfTract = By.xpath("//input[@id='idManageApproval_btnAddApprovalAssociation']");
		By btnRefreshListTract = By.xpath(
				"//table[contains(@id,'idManageApproval_ASSOCIATED_APPROVAL_TRACTS')]//a[contains(@id,'_lnkRefresh')]");
		By listTractMessage = By.xpath("//span[@id='idManageApproval_msgAgreement']");
		By btnDeleteListTract = By.xpath("//table[contains(@id,'ASSOCIATED_APPROVAL_TRACTS')]//input[@alt='Delete']");
		By btnDeleteOk = By.xpath("//div[contains(@class,'rwDialogPopup')]//span[text()='OK']");
		By listTractUsrMessage = By.xpath("//span[@id='idManageApproval_ASSOCIATED_APPROVAL_TRACTS_usrMessage']");
		By btnClose = By.xpath("//a[@title='Close']");

	public void clickonAddNewRecordALT(){
		util.waitUntilElementDisplay(btnAddNewRecordAlt);
    	util.click(btnAddNewRecordAlt);
		
	}
	
	public void clickonAddNewRecordDOT(){
		util.waitUntilElementDisplay(btnAddNewRecordDot);
    	util.click(btnAddNewRecordDot);
		
	}
	
	public void clickonAddNewRecordROW(){
		util.waitUntilElementDisplay(btnAddNewRecordRow);
    	util.click(btnAddNewRecordRow);
		
	}
	
	public void SelectApprovalType(String value) {
		util.switchToIframe(FullFrm);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpApprovalType, value);
		
    }
	
	public void clickonSave()
	{
		util.dummyWait(2);
		util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
		util.dummyWait(2);
		util.waitUntilElementDisplay(SuccessfulMessage);
	    Assert.assertTrue(util.isElementPresent(SuccessfulMessage), "Changes saved successfully.");
	}
	
	public void SelectStatusException(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatusException, value);
		util.dummyWait(2);
    }
	
	public void AddReasonForStatusException(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtReasonForStatusException, value);
		
    }
	
	 public void navigatetoAssociatedRecord() {
	    	util.waitUntilElementDisplay(navAssociatedRecord);
	    	util.click(navAssociatedRecord);
			
	    }

	    
	  public void selectProject(String value) {
			try {
				util.selectValueFromDropdown(drpAddProjects, value);
				util.click(drpAddProjectsClose);
			} catch (Exception e) {
				util.click(drpAddProjectsClose);
				By valueLocator = By.xpath("//ul//li[normalize-space()='"+value+"']//input");
				util.scrollToElement(valueLocator);
				util.click(valueLocator);
				util.click(drpAddProjectsClose);
			}
		}

		public void clickOnGoProject() {
			util.click(btnGoProject);
			util.waitFor(5000);
		}

		public void selectListOfTrack(String value) {
			try {
				util.selectValueFromDropdown(drpListOfTrack, value);
				util.click(drpListOfTrackClose);
			} catch (Exception e) {
				util.click(drpListOfTrackClose);
				util.click(By.xpath("//ul//li[normalize-space()='"+value+"']//input"));
				util.click(drpListOfTrackClose);
			}
		}
		public void selectListOfLeases(String value) {
			try {
				util.selectValueFromDropdown(drpListofLeases, value);
				util.click(drpListofLeasesClose);
			} catch (Exception e) {
				util.click(drpListofLeasesClose);
				util.click(By.xpath("//ul//li[normalize-space()='"+value+"']//input"));
				util.click(drpListofLeasesClose);
			}
		}
		

		public void clickOnListOfTract() {
			util.click(btnAddListOfTract);
		}

		public void refreshListOfTract() {
			util.click(btnRefreshListTract);
		}

		public String getListOfTractMessage() {
			return util.getText(listTractMessage);
		}
	    By btnActive = By.xpath("//input[contains(@id,'_RadDockTractSS_C_takeOffline')]");

		 public void clickOnActive() {
		    	util.waitUntilElementDisplay(btnActive);
				util.click(btnActive);
				util.dummyWait(3);
			}
	    
	    public void AddAssociatedRecord(Map<String, String> map, String testcaseName) {
	    	   if (environment.contains("DOT")) {
	      			log("Parcel workflow Associated records not applicable for DOT ", Status.SKIP);
	      		}
	    	   else {
	    	  if(testcaseName.contains("ALT"))
			  {
		    	 try {
		    		 clickonAddNewRecordALT();
		    		 util.dummyWait(5);
		  			 log("STEP 1: user can click on add new record button    ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 1:  User is unable to click on add new record.  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 1");
		  		 }
			  }
			  else
			  {
				  try {
			    		 clickonAddNewRecordROW();
			    		 util.dummyWait(5);
			  			 log("STEP 1: user can click on add new record button  ", Status.PASS);
			  		 } catch (Exception e) {
			  			log("STEP 1:  User is unable to click on add new record. ", Status.FAIL);
			  			throw new RuntimeException("Failed in step 1");
			  		 }   
			  }
			  
			  try {
				  SelectApprovalType(map.get(Excel.ApprovalType));
		  			 log("STEP 2:  User can select a value in Approval Type field      ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 2:  User cannot add a value in Approval Type field    ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 2");
		  		 }
			  
			  try {
				  clickonSave();
		  			 log("STEP 3:  user can click on save button ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 3:  User is unable to click on save button.  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 3");
		  		 }
			  
			  try {
				  SelectStatusException(map.get(Excel.StatusException));
		  			 log("STEP 4:  User can select a value in Status Exception field ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 4:   User cannot add a value in Status Exception field   ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 4");
		  		 }
			  
			  try {
				  AddReasonForStatusException(map.get(Excel.ReasonStatusException));
		  			 log("STEP 5: User can select a value in Reason Status Exception field", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 5:   User cannot add a value in Reason Status Exception field  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 5");
		  		 }
			  
			  try {
				  clickonSave();
		  			 log("STEP 6:  user can click on save button ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 6:  User is unable to click on save button.  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 6");
		  		 }

	    		 try {
	    			 navigatetoAssociatedRecord();
	    			 util.dummyWait(1);
	 				selectProject(map.get(Excel.ProjectName));
	 				clickOnGoProject();
	 				log("STEP 7: Selected a project from DD and click on GO button", Status.PASS);
	 			} catch (Exception e) {
	 				log("STEP 7: Selected a project from DD and click on GO button", Status.FAIL);
	 				throw new RuntimeException("Failed in step 7");
	 			}
	 			SoftAssert softAssert = new SoftAssert();
	 			try {
	 				selectListOfTrack(map.get(Excel.ListOfTrack));
	 				Thread.sleep(5000);
	 				selectListOfLeases(map.get(Excel.ListOfLeases));
	 				Thread.sleep(5000);
	 				clickOnListOfTract();
	 				util.dummyWait(1);
	 				softAssert.assertEquals(getListOfTractMessage(), "Requested association created successfully",
	 						"Success message is mismatch");
	 				refreshListOfTract();
	 				log("STEP 8: Select a Tract list from the DD and click on Add ", Status.PASS);
	 			} catch (Exception e) {
	 				log("STEP 8: Select a Tract list from the DD and click on Add ", Status.FAIL);
	 				throw new RuntimeException("Failed in step 8");
	 			}
	 			util.dummyWait(2);
	 			util.switchToDefaultContent();
	 			util.click(btnClose);
	 			util.dummyWait(5);
	 	    } 
	    	   
	         try {
	    	    util.scrollToElement(btnActive);
	           	util.dummyWait(3);
	           	clickOnActive();
	   			log("STEP 20: TC1 Add New Parcel Step no 20", Status.PASS);
	   			log("STEP 20: The button text should be changed to Inactive and color of button should be turned to Red ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 20: Button text or color does not change.    ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 20");
	   		}   
		util.dummyWait(3); 
	    	          
	  }
	    
	    public void cancelParcelWorkflow(Map<String, String> map, String testcaseName) {
	    	driver.navigate().refresh();
	  if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL"))
	  {
    	 try {
    		 clickonAddNewRecordALT();
    		 util.dummyWait(3);
  			 log("STEP 1: user can click on add new record button    ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 1:  User is unable to click on add new record.  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		 }
	  }
	  else if(testcaseName.contains("ROW") || testcaseName.contains("TRA"))
	  {
		  try {
	    		 clickonAddNewRecordROW();
	    		 util.dummyWait(3);
	  			 log("STEP 1: user can click on add new record button  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 1:  User is unable to click on add new record. ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 1");
	  		 }   
	  }else {
		  try {
	    		 clickonAddNewRecordDOT();
	    		 util.dummyWait(3);
	  			 log("STEP 1: user can click on add new record button  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 1:  User is unable to click on add new record. ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 1");
	  		 }
	  }
	  
	  try {
		  SelectApprovalType(map.get(Excel.ApprovalType));
  			 log("STEP 2:  User can select a value in Approval Type field      ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 2:  User cannot add a value in Approval Type field    ", Status.FAIL);
  			throw new RuntimeException("Failed in step 2");
  		 }
	  
	  try {
		  clickonSave();
  			 log("STEP 3:  user can click on save button ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 3:  User is unable to click on save button.  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		 }
	  util.dummyWait(15);
	  try {
		  SelectStatusException(map.get(Excel.StatusException));
  			 log("STEP 4:  User can select a value in Status Exception field ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 4:   User cannot add a value in Status Exception field   ", Status.FAIL);
  			throw new RuntimeException("Failed in step 4");
  		 }
	  
	  try {
		  AddReasonForStatusException(map.get(Excel.ReasonStatusException));
  			 log("STEP 5: User can select a value in Reason Status Exception field", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 5:   User cannot add a value in Reason Status Exception field  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 5");
  		 }
	  
	  try {
		  clickonSave();
  			 log("STEP 6:  user can click on save button ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 6:  User is unable to click on save button.  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 6");
  		 }

		 
util.dummyWait(3); 
}
}
