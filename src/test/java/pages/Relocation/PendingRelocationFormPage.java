package pages.Relocation;

import java.io.File;
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

public class PendingRelocationFormPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public PendingRelocationFormPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navParcelForms = By.xpath("//span[contains(text(),'Parcel Forms')]");
	By btnAddNewRecordAlt = By.xpath("//img[@id='ctl00_ConPHRightTop_ParcelInformation_UC_radPrjPanels_i13_i0_idTractInfoApproval_YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By btnAddNewRecordDot = By.xpath("(//img[@alt='Add new record'])[1]");
	By btnAddNewRecordRow = By.xpath("//img[@id='ctl00_ConPHRightTop_TRPI_UC_radPrjPanels_i25_i0_YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By btnAddDocuments = By.xpath("//input[contains(@id,'idManageApproval_btnAddDocuments') and @type='button']");

	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@id,'idManageApproval_cbParcelApprovalType_YALComboBox_Input') and @type='text']");
	By radiobtnNo = By.xpath("//input[contains(@id,'idManageApproval_customFields2_36_1')] | //input[contains(@id,'idManageApproval_customFields2_83_1')]");
	By btnSave = By.xpath("//input[contains(@id,'idManageApproval_btnSaveHeader') and @type='image']");
	By SuccessfulMessage = By.xpath("//span[text()='Changes saved successfully.']");
	By btnSubmitforReview = By.xpath("//input[contains(@id,'_btnSubmit') and @type='image']");
	By Step1Link = By.xpath("//a[contains(text(),'Upload Document')]");
	By iframe = By.xpath("//iframe[@name='geoPopUpWF']");
	By save = By.xpath("//input[@id='idApproveInLineWorkflow_btnSaveReviewLogData']");
	By txtComment = By.xpath("//textarea[@id='idApproveInLineWorkflow_txtReviewerComments']");
	By btnApprove = By.xpath("//input[contains(@id,'_btnApprove') and @type='submit']");
	By linkApprove = By.xpath("//a[contains(text(),'Approved')]");
	By LinkRequester = By.xpath("//a[contains(text(),'Requestor')]");
	By btnClose = By.xpath("//a[@title='Close']");
	By drpCategory = By.xpath("//select[@id='RadPanelBar1_i0_i0_rauFileUploadCategory0']");
	By txtDescriptionDot = By.xpath("//textarea[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')]");
	By btnLoadDocuments = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_buttonSubmit_input') and @type='submit']");
	By btnDocuments = By.xpath("//span[text()='Documents']");
	By btnNotes = By.xpath("//span[contains(text(),'Notes')]");
	By iframeNotes = By.xpath("//iframe[@name='radWinAgentNotes']");
	By btnAddNotes = By.xpath("//input[contains(@id,'_btnAddNotes') and  @type='submit']");
	By txtActivityDate = By.xpath("//input[contains(@id,'_AD_dateInput') and  @type='text']");
	By datePicker = By.xpath("//a[@class='rcCalPopup']");
	By SelectDate = By.xpath("//td[@title='Monday, February 27, 2023']");
	By drpAgent = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[1]");
	By drpNotesCategory = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[2]");
	By drpPriority = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[3]");
	By txtNotesDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
	By btnaddNotes = By.xpath("//input[contains(@id,'AgntNotes_SN') and  @type='image']");
	By btnCloseNotes = By.xpath("//a[@class='rwCloseButton']");
	By linkLinkedApprovals = By.xpath("//span[contains(text(),'Linked Approvals')]");
    By  Successmsg = By.xpath("//span[@id='AgntNotes_usrMessage']");

	public void ClickOnAddButton() {
		util.waitUntilElementDisplay(btnAddNewRecordDot);
		util.click(btnAddNewRecordDot);
	}
	
	public void SelectApprovalType(String value) {
		util.switchToIframe(FullFrm);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpApprovalType, value);
	}
	
	public void ClickonSaveButton() {
		util.waitUntilElementDisplay(radiobtnNo);
		util.click(radiobtnNo);
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.waitUntilElementDisplay(SuccessfulMessage);
		Assert.assertTrue(util.isElementPresent(SuccessfulMessage), "Changes saved successfully.");
	}
	
	public void ClickOnSubmitForReviewButton() {
		util.waitUntilElementDisplay(btnSubmitforReview);
		util.click(btnSubmitforReview);
		util.dummyWait(3);
		Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		Iterator<String> itererator = windowId.iterator();
		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();
		driver.switchTo().window(newAdwinID);
		driver.close();
		driver.switchTo().window(mainWinID);
		util.dummyWait(2);
	
	}
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
	By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
	public void uploadFile() {
		String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
		driver.findElement(fileUpload).sendKeys(filepath);
	}
	
	  public void selectCategory(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategory, value);
		}	
	
	 
	
	  public void AddDescriptionDot(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionDot, value);
		}

	  public void ClickonLoadDocuments() {
			util.waitUntilElementDisplay(btnLoadDocuments);
			util.click(btnLoadDocuments);
			
		}
		By refreshDocuments = By.xpath("//div[contains(@id,'Approval_DOCUMENT_radYALGridControlPanel')]//a[contains(@id,'_lnkRefresh')]");
		By btnCloseDocuments = By.xpath("//a[@class='rwCloseButton']");
	    By iframeWorkflow = By.xpath("//iframe[@name='ManageApprovalDialog']");
	    public void ClickOnCloseDocument() {
	    	util.switchToDefaultContent();
	    	util.switchToIframe(iframeWorkflow);
	    	util.dummyWait(1);
	    	util.waitUntilElementDisplay(btnCloseDocuments);
	    	util.click(btnCloseDocuments);
			util.click(refreshDocuments);
			util.dummyWait(1);
	    }
	
	public void ClickOnStep1Link() {
		util.switchToIframe(FullFrm);
		util.dummyWait(2);
		util.waitUntilElementDisplay(Step1Link);
		util.click(Step1Link);
		util.switchToIframe(iframe);
	}
	
	public void ClickOnSave() {
		util.waitUntilElementDisplay(save);
		util.click(save);
		util.waitUntilElementDisplay(SuccessfulMessage);
		Assert.assertTrue(util.isElementPresent(SuccessfulMessage), "Changes saved successfully.");
	}
	
	public void AddReviewerComment(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
	}
	
	public void ClickonApproveButton() {
		util.waitUntilElementDisplay(btnApprove);
		util.click(btnApprove);
		util.switchToDefaultContent();
	}
	
	public void ClickonRequesterLink() {
		util.dummyWait(2);
		util.waitUntilElementDisplay(linkApprove);
		util.click(linkApprove);
		
		util.switchToIframe(iframe);
		util.waitUntilElementDisplay(LinkRequester);
		util.click(LinkRequester);
	}
	
	
	public void ClickonCloseButton() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
	}
	
	public void ClickonDocumentsTab()
	{   util.dummyWait(2);
		util.waitUntilElementDisplay(btnDocuments);
		util.click(btnDocuments);	    	
		    
	}
	public void ClickonAddDocuments()
	{
		util.waitUntilElementDisplay(btnAddDocuments);
		util.click(btnAddDocuments);	    	
		    
	}
	
	 public void ClickOnNotes() {
	    	util.waitUntilElementDisplay(btnNotes);
	    	util.click(btnNotes);
			
	    } 
	    
	    public void ClickOnAddNotes() {
	    	util.waitUntilElementDisplay(btnAddNotes);
	    	util.click(btnAddNotes);
	    	util.switchToIframe(iframeNotes);
	    	util.dummyWait(3);
			
	    }
	    
	    public void AddActivityDate(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtActivityDate, value);
	    }
	    
	    public void SelectAgent(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAgent, value);
			
	    }
	    
	    public void SelectNotesCategory(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpNotesCategory, value);
			
	    }
	    
	    public void SelectPriority(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpPriority, value);
			
	    }
	    
	    public void AddNotesDescription(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtNotesDescription, value);
			
	    }
	    
	    By btnSaveDot = By.xpath("//input[contains(@id,'AgntNotes_SN') and  @type='button']");
	    public void ClickonAddNoteDot() {
	    	util.waitUntilElementDisplay(btnSaveDot);
	    	util.click(btnSaveDot);
	    	util.waitUntilElementDisplay(Successmsg);
	    	Assert.assertTrue(util.isElementPresent(Successmsg), "Note submitted and auto-approved.");
	    	util.dummyWait(1);
	    }
	    
	    By Iframe= By.xpath("//iframe[@name='ManageApprovalDialog']");
	    public void ClickonClose() {
			util.switchToDefaultContent();
	    	util.dummyWait(1);
	    	util.switchToIframe(Iframe);
            util.dummyWait(1);
		    util.waitUntilElementDisplay(btnCloseNotes);
	    	util.click(btnCloseNotes);
            util.dummyWait(2);

	    }
	    
	    By icon = By.xpath("//img[contains(@id,'_radYALGridControl_ctl00_ctl02_ctl00_Img3')]");

	    public void ClickonLinkedApprovals() {
	    	util.waitUntilElementDisplay(linkLinkedApprovals);
	    	util.click(linkLinkedApprovals);
	    	util.dummyWait(1);
			util.waitUntilElementDisplay(icon);
			util.click(icon);
			util.dummyWait(2);
	    }
	    
	    By btnApproval = By.xpath("//span[text()='Approvals ']");
	 
	    By CategoryDot = By.xpath("//*[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadundefined1')]/span");
	    public void AddCategory(String value) {
			  if(util.isElementPresent(CategoryDot))
			  util.inputTextAndPressTab(CategoryDot, value);
	   }
	    
    public void PendingRelocationforms(Map<String, String> map, String testcaseName) {
    	 try {
    		 ClickOnAddButton();
 			log("STEP 1: The Pop up should be appear  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 1: The Pop Up should not appear  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 1");
 		 }
    	 
    	 try {
    		 SelectApprovalType(map.get(Excel.ApprovalType));
 			log("STEP 2:  The selected Approval Form fields should be appears  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 2: The Workflow cannot be selected ", Status.FAIL);
 			throw new RuntimeException("Failed in step 2");
 		 }
    	 
    	 try {
    		 ClickonSaveButton();
 			log("STEP 3:Message - 'Changes saved sucessfully!' in green displays   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 3:  Added values are not saved  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 3");
 		 }

    	 try {
	    		ClickonDocumentsTab();
	    		util.dummyWait(2);
				log("STEP 4: Document  window should display on documents tab    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  The document  window does not display ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
	    	
	    	try {
	    		ClickonAddDocuments();
				log("STEP 5: Document popup window should display with external documents tab ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: The document pop window does not display ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
	    
	    	try {
	    		util.switchToIframe(iframeDocument);
	    		 util.dummyWait(5);
	    		uploadFile();
				log("STEP 6: User can upload document from the system  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot upload a document ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
	    	
	    	if(util.isElementPresent(drpCategory)) {
		    	 try {
		    		 util.dummyWait(10);
		    		// util.click(drpCategory);
		    	// selectCategory(map.get(Excel.DocCategory));
		  			 log("STEP 7:  Value added display in Category field  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 7:  User  cannot select  value  from Category DD  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 7");
		  		 }
		    	}
		    	else {
		    		try {
			    	//	 AddCategory(map.get(Excel.DocCategory));
			  			 log("STEP 7:  Value added display in Category field  ", Status.PASS);
			  		 } catch (Exception e) {
			  			log("STEP 7:  User  cannot select  value  from Category DD  ", Status.FAIL);
			  			throw new RuntimeException("Failed in step 7");
			  		 }
		    	}
	    	 
	    	 try {
	    		 AddDescriptionDot(map.get(Excel.Description));
	  			 log("STEP 8:  User can enter a value in Description field   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 8:  User cannot add a value in Description field   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 8");
	  		 }
	    	 

	    	 try {
	    		 ClickonLoadDocuments();
	  			 log("STEP 9:  document is loaded  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 9:  docuemnt could not be uploaded.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 9");
	  		 }
	    	 
	    	 
	    	 try {
	    		 ClickOnCloseDocument();
	  			 log("STEP 10:  POpup should get closed ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 10:  popup does not get closed  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 10");
	  		 }

    	 
    	 
    	 try {
    		 ClickOnNotes();
    		 util.dummyWait(2);
    		 ClickOnAddNotes();
  			 log("STEP 11: User can click on the add Notes button  ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 11:  User cannot see the add Notes button  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 11");
  		 }
    	 
    	 
    	 try {
    		 AddActivityDate(map.get(Excel.ActivityDate));
  			 log("STEP 12:  User can select Activity  Date   ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 12:  User  cannot select Activity Date  from Date Picker ", Status.FAIL);
  			throw new RuntimeException("Failed in step 12");
  		 }
    	 
    	 try {
    		 SelectAgent(map.get(Excel.Agent));	
	         log("STEP 13:   Added value displays in Agent field ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 13:  User  cannot select  value  from Agent DD  ", Status.FAIL);
  			throw new RuntimeException("Failed in step  13");
  		 }
    	 
    	 try {
    		// SelectNotesCategory(map.get(Excel.Category));
  			 log("STEP 14:  Added value displays in Category field ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 14:  User  cannot select  value  from Category DD  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 14");
  		 }

    	 
    	 try {
    		 AddNotesDescription(map.get(Excel.Description));
  			 log("STEP 15:  User can enter a value in the description field ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 15:  User cannot add a value in Description field   ", Status.FAIL);
  			throw new RuntimeException("Failed in step 15");
  		 }
  	 
    	
    		 try {
    		 ClickonAddNoteDot();
  			 log("STEP 16:  The added notes displays in the grid    ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 16:  Added values does  not displayed in the grid.   ", Status.FAIL);
  			throw new RuntimeException("Failed in step 16");
  		 }
    		 ClickonClose(); 
     
    		 try {
 	    		 ClickonLinkedApprovals();
 	  			 log("STEP 17: record will be visible on grid. ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 17:   record will not be visible on grid.  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 17");
 	  		 }

     	 ClickonCloseButton();
    
     }

	
}
