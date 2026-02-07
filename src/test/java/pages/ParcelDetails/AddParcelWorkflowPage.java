package pages.ParcelDetails;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddParcelWorkflowPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddParcelWorkflowPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By navParcelForms = By.xpath("//span[contains(text(),'Parcel Forms')]");
	By btnAddNewRecordAlt = By.xpath("(//img[contains(@id,'YALWorkflows_radYALGridControl')])[1]");
	By btnAddNewRecordDot = By.xpath("//img[contains(@id,'YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4')] ");
	By btnAddNewRecordRow = By.xpath("//img[contains(@id,'_YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@id,'idManageApproval_cbParcelApprovalType_YALComboBox_Input') and @type='text']");
	By radiobtnNo = By.xpath("//label[contains(text(),'Yes')]");
	By btnSave = By.xpath("//input[contains(@id,'idManageApproval_btnSaveHeader') and @type='image']");
	By SuccessfulMessage = By.xpath("//span[text()='Changes saved successfully.']");
	By btnSubmitforReview = By.xpath("//input[@id='idManageApproval_YALInLineWorkflowApprove_btnSubmit']");
	By Step1Link = By.xpath("//a[contains(text(),'Upload Document')]");
	By save = By.xpath("//input[@id='idApproveInLineWorkflow_btnSaveReviewLogData']");
	By txtComment = By.xpath("//textarea[@id='idApproveInLineWorkflow_txtReviewerComments']");
	By btnApprove = By.xpath("//input[contains(@id,'_btnApprove') and @type='submit']");
	By linkApprove = By.xpath("//a[contains(text(),'Approved')]");
	By LinkRequester = By.xpath("//a[contains(text(),'Requestor')]");
	By btnClose = By.xpath("//a[@title='Close']");
	
	
	
	
	 public void navigateParcelInformation() {
			util.waitUntilElementDisplay(navParcel);
			util.click(navParcel);
			util.waitUntilElementDisplay(navParcelInfo);
			util.click(navParcelInfo);
			util.waitUntilElementDisplay(navParcelInformation);
			util.click(navParcelInformation);			
		}
	
	public void ClickOnAddButtonDot() {
		util.waitUntilElementDisplay(btnAddNewRecordDot);
		util.click(btnAddNewRecordDot);
	}
	
	public void ClickOnAddButtonAlt() {
		util.waitUntilElementDisplay(btnAddNewRecordAlt);
		util.click(btnAddNewRecordAlt);
	}
	
	public void ClickOnAddButtonRow() {
		util.waitUntilElementDisplay(btnAddNewRecordRow);
		util.click(btnAddNewRecordRow);
	}
	
	public void SelectApprovalType(String value) {
		util.switchToIframe(FullFrm);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpApprovalType, value);
	}
	
	public void ClickonSaveButton() {
		util.dummyWait(1);
		util.waitUntilElementDisplay(radiobtnNo);
		util.click(radiobtnNo);
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(3);
//Assert.assertTrue(util.isElementPresent(SuccessfulMessage), "Changes saved successfully.");
//		util.dummyWait(2);
	}
	
	By btnDocuments = By.xpath("//div[@id='idManageApproval_tabStrip']//span[contains(text(),'Documents')]");
	By btnAddDocuments = By.xpath("//input[contains(@id,'idManageApproval_btnAddDocuments') and @type='button']");
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
	By drpCategory = By.xpath("//select[@id='RadPanelBar1_i0_i0_rauFileUploadCategory0']");
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc0') and @type='text']"); 
	By txtDescriptionDot = By.xpath("//textarea[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')]");
	 By drpCategoryROW = By.xpath("//select[contains(@id,'_rauFileUploadCategoryDD0')]");
	 By txtDescriptionROW = By.xpath("//input[@id='RadPanelBar1_i0_i0_rauFileUploadDesc0']");
	
	By btnLoadDocuments = By.xpath("//input[contains(@id,'buttonSubmit_input') and @type='submit'] | //input[contains(@id,'buttonSubmit_input') and @type='button']");
	By btnExternalLink = By.xpath("(//span[@class='rpExpandHandle'])[2]");
	By txtDocumentName = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtname1') and @type='text']");
	By txtExternalLink = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtlinkname1') and @type='text']");
	By drpCategoryExelink = By.xpath("//input[contains(@id,'_ddlDynamic1_radYALDropDownList_Input') and @type='text']");
	By txtDescriptionExelink = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtDynamic1') and @type='text']");
	
	By txtDocumentNameRow = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_txtDynamic1')]");
    By txtExternalLinkRow = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_link1')]");
    By Category = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_RadDropDownTree1']");
	By SelectCategory = By.xpath("(//span[contains(text(),'Docusign Demo') and @class='rtIn'])[1]");
	By txtDescriptionRow = By.xpath("//input[@id='radReportConfigPanels_i0_i0_description1']");

	By btnLoadDocumentsExeLink = By.xpath("//input[contains(@id,'_btnSave_input') and @type='submit']");
	By btnAddExeLink = By.xpath("//input[contains(@id,'_btnAdd_input') and @type='submit']");
	By btnCloseDocuments = By.xpath("//a[@class='rwCloseButton']");
	By refreshDocuments = By.xpath("//div[contains(@id,'Approval_DOCUMENT_radYALGridControlPanel')]//a[contains(@id,'_lnkRefresh')]");
	By btnDownloadSelected = By.xpath("//input[contains(@id,'_BtnDownload') and @type='button']");
	By btnEmailSelected = By.xpath("//input[contains(@id,'_btnEmailSelcted') and @type='button']");
	By btnNotes = By.xpath("//div[@id='idManageApproval_tabStrip']//span[contains(text(),'Notes')]");
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
	By navAssociatedRecord = By.xpath("//span[contains(text(),'Associated Records')]");
    By  Successmsg = By.xpath("//span[@id='AgntNotes_usrMessage']");
   
	By Iframe = By.xpath("//iframe[@name='geoPopUpWF']");
	

	By drpAddProjects = By.xpath(
			"//*[contains(text(),'Projects:')]/..//input[@id='idManageApproval_Projects_Input'] | //*[normalize-space()='Projects:']/../following-sibling::tr//input[@id='idManageApproval_Projects_Input']");
	By drpAddProjectsClose = By.xpath(
			"//*[normalize-space()='Projects:']/../following-sibling::tr//a[contains(@id,'Approval_Projects_Arrow')] | //*[contains(text(),'Projects:')]//a[contains(@id,'Approval_Projects_Arrow')]");
	By drpListOfTrack = By.xpath(
			"//*[contains(text(),'List of Tract:')]/..//input[@id='idManageApproval_Tract_Agreement_Input'] | //*[normalize-space()='List of Tract:']/../following-sibling::tr//input[@id='idManageApproval_Tract_Agreement_Input'] | //*[normalize-space()='List of Parcels:']/../following-sibling::tr//input[@id='idManageApproval_Tract_Agreement_Input'] |//*[normalize-space()='List of Parcels:']/..//input[@id='idManageApproval_Tract_Agreement_Input']");
	By drpListOfTrackClose = By.xpath(
			"//*[normalize-space()='List of Tract:']/../following-sibling::tr//a[contains(@id,'Tract_Agreement_Arrow')] | //*[normalize-space()='List of Parcels:']/../following-sibling::tr//a[contains(@id,'Tract_Agreement_Arrow')] | //*[contains(text(),'List of Tract:')]/..//a[contains(@id,'Tract_Agreement_Arrow')] | //*[normalize-space()='List of Parcels:']/..//a[contains(@id,'Tract_Agreement_Arrow')]");
	
	By drpListofLeases = By.xpath(
			"//*[contains(text(),'List of Leases:')]/..//input[@id='idManageApproval_Lease_Association_Input'] | //*[normalize-space()='List of Leases:']/../following::div[@id='idManageApproval_Lease_Association'] | //*[normalize-space()='List of Agreements:']/../following::div[@id='idManageApproval_Lease_Association'] | //*[normalize-space()='List of Agreements:']/./..//input[@id='idManageApproval_Lease_Association_Input']");
	By drpListofLeasesClose = By.xpath(
			"//*[contains(text(),'List of Leases:')]/..//a[@id='idManageApproval_Lease_Association_Arrow'] | //*[normalize-space()='List of Leases:']/../following-sibling::tr//a[@id='idManageApproval_Lease_Association_Arrow'] | //*[normalize-space()='List of Agreements:']/../following-sibling::tr//a[@id='idManageApproval_Lease_Association_Arrow'] | //*[normalize-space()='List of Agreements:']/..//a[@id='idManageApproval_Lease_Association_Arrow']");
	
	
	By btnGoProject = By.xpath("//input[@id='idManageApproval_btnGo']");
	By btnAddListOfTract = By.xpath("//input[@id='idManageApproval_btnAddApprovalAssociation']");
	By btnRefreshListTract = By.xpath(
			"//table[contains(@id,'idManageApproval_ASSOCIATED_APPROVAL_TRACTS')]//a[contains(@id,'_lnkRefresh')]");
	By listTractMessage = By.xpath("//span[@id='idManageApproval_msgAgreement']");
	By btnDeleteListTract = By.xpath("//table[contains(@id,'ASSOCIATED_APPROVAL_TRACTS')]//input[@alt='Delete']");
	By btnDeleteOk = By.xpath("//div[contains(@class,'rwDialogPopup')]//span[text()='OK']");
	By listTractUsrMessage = By.xpath("//span[@id='idManageApproval_ASSOCIATED_APPROVAL_TRACTS_usrMessage']");
	
	//updated 
	By EditWorkflow = By.xpath("//*[contains(@id,'YALWorkflows_radYALGridControl_ctl00__0')]/td[11]/a[1]");
	By btnCloseForm = By.xpath("//div[contains(@id,'ManageApprovalDialog')]//a[@title='Close']");
	By WFStatus = By.xpath("(//td[text()='Pending']/..//td[text()='Docusign Demo'])[1]");
	
	public void ClickonDocumentsTab()
	{
		util.waitUntilElementDisplay(btnDocuments);
		util.click(btnDocuments);	    	
		    
	}
	 
	
	public void ClickonAddDocuments()
	{
		util.waitUntilElementDisplay(btnAddDocuments);
		util.click(btnAddDocuments);	    	
		    
	}
	
	By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
	public void uploadFile() {
		String filepath = System.getProperty("user.dir") + File.separator + "WorkflowDoc.txt";
		driver.findElement(fileUpload).sendKeys(filepath);
	}
	
	  public void selectCategory(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategory, value);
		}	
	
	  By CategoryDot = By.xpath("//*[@id=\"RadPanelBar1_i0_i0_rauFileUploadundefined1\"]/span");
		By CategoryFilter = By.xpath("//*[@id=\"form1\"]/div[1]/div/div[1]/label/input");
		
	  public void selectCategoryDot(String value) {
			if (!commonFunction.checkNA(value)) 
				util.waitUntilElementDisplay(CategoryDot);
			util.click(CategoryDot);	
			util.inputTextAndPressTab(CategoryFilter, value);
			util.pressENTERkey();
			//util.selectValueFromDropdown2(value, CategoryFilter);
		
		}
	  
	  public void AddDescription(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescription, value);
		}
	  
	  public void AddDescriptionDot(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionDot, value);
		}
	  
	  public void selectCategoryRow(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategoryROW, value);
		}	
	
	 
	  public void AddDescriptionRow(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionROW, value);
		}
	  
	  public void ClickonLoadDocuments() {
			util.waitUntilElementDisplay(btnLoadDocuments);
			util.click(btnLoadDocuments);
			
		}
	  
	  public void ClickonExternalLink() {
			util.waitUntilElementDisplay(btnExternalLink);
			util.click(btnExternalLink);
		}
	  
	  public void AddDocumentName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentName, value);
			
	    }
	  public void AddDocumentNameRow(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentNameRow, value);
	    }
	    
	    public void AddExternalLink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExternalLink, value);
			
	    }
	    
	    public void AddExternalLinkRow(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExternalLinkRow, value);
	    }
	    
	    By selectCategory_ExternalLink = By.xpath("//input[contains(@id,'YALDropDownList_Input')]");

		public void selectCategoryExternalLink(String value) {
			util.waitUntilElementDisplay(selectCategory_ExternalLink);
			util.inputTextAndPressTab(selectCategory_ExternalLink, value);
		}

		By selectCategory_ExternalLinkDOT = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_RadDropDownTree1'] | //input[contains(@id,'XYZ1_radYALDropDownList_Input')]");

		public void selectCategoryExternalLinkDOT(String value) {
			if (!commonFunction.checkNA(value)) {
			util.waitUntilElementDisplay(selectCategory_ExternalLinkDOT);
			util.selectValueFromDropdown3(selectCategory_ExternalLinkDOT, value);}
		}
			
	    public void AddCategoryForExeLink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategoryExelink, value);
			
	    }
	    
	    public void SelectCategory() {
	    	util.waitUntilElementDisplay(Category);
	    	util.click(Category);
	    	util.waitUntilElementDisplay(SelectCategory);
	    	util.click(SelectCategory);
	      }
	    
 By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined')]");
	    
	    public void selectCategoryTree(String value) {
			if (!commonFunction.checkNA(value)) {
				util.waitForWebElementToBePresent(drpCategoryROWTree);
				util.selectValueFromDropdown3(drpCategoryROWTree, value);			
			}
		}
	    
	    By drpCategoryExtDoc = By.xpath("//select[contains(@id,'_rauFileUploadcategory')] | //select[contains(@id,'_rauFileUploadCategory')]");
	    
	    public void selectCategoryROW(String value) {
			if (util.isElementPresent(drpCategoryExtDoc)) {
				util.selectValueFromDropdown2(value, drpCategoryExtDoc);
			}
		}
	    
	    By description = By.xpath("//input[contains(@id,'RadUpload1Desc') or contains(@id,'rauFileUploadDesc')] ");
	    public void setDescription(String value) {
 			if (util.isElementPresent(description)) {
 				util.inputText(description, value);
 			}
 		}
	    
	    public void AddDescriptionExelink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionExelink, value);
			
	    }
	    
	    public void AddDescriptionROW(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionRow, value);
	    }
	    
	    
	    public void ClickOnLoadDocumentsExeLink() {
	    	util.waitUntilElementDisplay(btnLoadDocumentsExeLink);
	    	util.click(btnLoadDocumentsExeLink);
			
	    }
	  
	    public void ClickOnAddExeLink() {
	    	util.waitUntilElementDisplay(btnAddExeLink);
	    	util.click(btnAddExeLink);
			
	    }
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
	    
	    public void ClickOnDownloadSelected() {
	    	util.waitUntilElementDisplay(btnDownloadSelected);
	    	util.click(btnDownloadSelected);
			
	    }    
    
	    public void ClickOnEmailSelected() {
	    	util.waitUntilElementDisplay(btnEmailSelected);
	    	util.click(btnEmailSelected);
			
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
	    public void ClickonAddNote() {
	    	util.waitUntilElementDisplay(btnaddNotes);
	    	util.click(btnaddNotes);
	    	util.waitUntilElementDisplay(Successmsg);
	    	Assert.assertTrue(util.isElementPresent(Successmsg), "Note submitted for review.");
	    	util.dummyWait(1);
	    }
 
	    By btnRefresh = By.xpath("//a[contains(@id,'_NOTES_radYALGridControl_ctl00_ctl02_ctl00_lnkRefresh')]");
	   By iframe= By.xpath("//iframe[@name='ManageApprovalDialog']");
	    public void ClickonClose() {
			util.switchToDefaultContent();
	    	util.dummyWait(1);
	    	util.switchToIframe(iframe);
            util.dummyWait(1);
		    util.waitUntilElementDisplay(btnCloseNotes);
	    	util.click(btnCloseNotes);
            util.dummyWait(1);
            util.waitUntilElementDisplay(btnRefresh);
	    	util.click(btnRefresh);
	    	util.dummyWait(2);
	    }
	    
	    By icon = By.xpath("//img[contains(@id,'_radYALGridControl_ctl00_ctl02_ctl00_Img3')]");
	    public void ClickonLinkedApprovals() {
	    	util.waitUntilElementDisplay(linkLinkedApprovals);
	    	util.click(linkLinkedApprovals);
//			util.dummyWait(1);
//			util.waitUntilElementDisplay(icon);
//			util.click(icon);
//			util.dummyWait(1);
	    }
	    
	    By btnApproval = By.xpath("//span[text()='Approvals ']");
	    
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
				util.selectValueFromDropdownContains(drpListOfTrack, value);
				util.click(drpListOfTrackClose);
			} catch (Exception e) {
				util.click(drpListOfTrackClose);
				util.click(By.xpath("//ul//li[normalize-space()='"+value+"']//input"));
				util.click(drpListOfTrackClose);
			}
		}
		public void selectListOfLeases(String value) {
			try {
				util.selectValueFromDropdownContains(drpListofLeases, value);
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

		public void ClickOnStep1Link() {
			Set<String> windowId = driver.getWindowHandles(); // get window id of current window
			Iterator<String> itererator = windowId.iterator();
			String mainWinID = itererator.next();
			String newAdwinID = itererator.next();
			driver.switchTo().window(newAdwinID);
			driver.close();
			driver.switchTo().window(mainWinID);
			util.dummyWait(2);
			util.switchToIframe(FullFrm);
			util.waitUntilElementDisplay(Step1Link);
			util.click(Step1Link);
			util.switchToIframe(Iframe);
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
			
			util.switchToIframe(Iframe);
			util.waitUntilElementDisplay(LinkRequester);
			util.click(LinkRequester);
		}
		
		public void ClickonCloseButton() {
			util.switchToDefaultContent();
			util.dummyWait(1);
			util.waitUntilElementDisplay(btnClose);
			util.click(btnClose);
	
		}
	    
		
		public void ClickOnSubmitForReviewButton() {
			util.waitUntilElementDisplay(btnSubmitforReview);
			util.click(btnSubmitforReview);
			util.dummyWait(3);
		}
		public void ClickOnSubmitForReviewButtonDot() {
			util.waitUntilElementDisplay(btnSubmitforReview);
			util.click(btnSubmitforReview);
			util.dummyWait(5);
			
		}
	 
		By btndelete = By.xpath("//input[contains(@id,'_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
		By btnOk = By.xpath("//span[text()='OK']");
		By successMessage = By.xpath("//span[text()='Changes saved successfully!']");
		public void DeleteRecord() {
			util.waitUntilElementDisplay(btndelete);
			util.click(btndelete);
			util.waitUntilElementDisplay(btnOk);
			util.click(btnOk);
			util.dummyWait(2);
			util.waitUntilElementPresent(successMessage);
			Assert.assertTrue(util.isElementPresent(successMessage), "Changes saved successfully!");
		}
	
    //updated
		
		public void EditWorkflow(){
			util.isElementVisible(EditWorkflow);
			util.click(EditWorkflow);
		}
		public void CloseForm() {
			util.switchToDefaultContent();
			util.isElementVisible(btnCloseForm);
			util.click(btnCloseForm);
		}
		
		public void EditParcelWorkflow() {
			util.isElementVisible(EditWorkflow);
			util.click(EditWorkflow);
		}

	
    public void AddParcelWorkflow(Map<String, String> map, String testcaseName) {
    	if(testcaseName.contains("DOT")) {
    	 try {
    		 navigateParcelInformation();
    		 ClickOnAddButtonDot();
 			log("STEP 1: The Pop up should be appear  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 1: The Pop Up should not appear  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 1");
 		 }
    	} 
    	else if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
    	 try {
    		 navigateParcelInformation();
    		 ClickOnAddButtonAlt();
 			log("STEP 1: The Pop up should be appear  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 1: The Pop Up should not appear  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 1");
 		 }
    	}
    	else {
    		try {
    		 navigateParcelInformation();
       		 ClickOnAddButtonRow();
    			log("STEP 1: The Pop up should be appear  ", Status.PASS);
    		 } catch (Exception e) {
    			log("STEP 1: The Pop Up should not appear  ", Status.FAIL);
    			throw new RuntimeException("Failed in step 1");
    		 }
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
    	 
    	 //updated script
    	 
    	 try {
				CloseForm();
				log("STEP 4: User can click on close button", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot click on close button", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			
    //	 if(util.isElementVisible(WFStatus)) {
			  try {
				  Assert.assertTrue(util.isElementVisible(WFStatus));
				  log("STEP 7: Workflow Status is 'Pending'", Status.PASS);
			  }catch (AssertionError e){
				  log("STEP 7: Workflow status is not updated to 'Pending'", Status.FAIL);
				  throw new RuntimeException("Failed in step 7");
			  }
			  
		 
		  try {
			  EditWorkflow();  
	          log("STEP 6: user can click on edit icon", Status.PASS);
		  }catch (Exception e){
			  log("STEP 6: user cannot click on edit icon", Status.FAIL);
			  throw new RuntimeException("Failed in step 6");
		  }
    	 
    	 
    	 
    	 if(testcaseName.contains("DOT")) {
 	    	try {
 	    		util.switchToIframe(FullFrm);
 	    		ClickonDocumentsTab();
 	    		util.dummyWait(2);
 				log("STEP 7: Document  window should display on documents tab    ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 7:  The document  window does not display ", Status.FAIL);
 				throw new RuntimeException("Failed in step 7");
 			}
 	    	
 	    	try {
 	    		ClickonAddDocuments();
 				log("STEP 8: Document popup window should display with external documents tab ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 8: The document pop window does not display ", Status.FAIL);
 				throw new RuntimeException("Failed in step 8");
 			}
 	    
 	    	try {
 	    		util.switchToIframe(iframeDocument);
 	    		 util.dummyWait(5);
 	    		uploadFile();
 				log("STEP 9: User can upload document from the system  ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 9: User cannot upload a document ", Status.FAIL);
 				throw new RuntimeException("Failed in step 9");
 			}
 	    	
 	    	util.dummyWait(5);
 	    	if(util.isElementPresent(CategoryDot)) {
 				try {
 					selectCategoryDot(map.get(Excel.Category));
 					log("STEP 10:  Value added display in Category field", Status.PASS);
 				} catch (Exception e) {
 					log("STEP 10:  User  cannot select  value  from Category DD", Status.FAIL);
 					throw new RuntimeException("STEP 10:  User can not select Category");
 				}
 			}else {
 			try {
 				selectCategory(map.get(Excel.Category));
 				log("STEP 11:  Value added display in Category field", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 11:  User  cannot select  value  from Category DD", Status.FAIL);
 				throw new RuntimeException("STEP 11:  User can not select Category");
 			}
 			}
 	    	 
 	    	 try {
 	    		 AddDescriptionDot(map.get(Excel.Description));
 	  			 log("STEP 12:  User can enter a value in Description field   ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 12:  User cannot add a value in Description field   ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 12");
 	  		 }
 	    	 

 	    	 try {
 	    		 ClickonLoadDocuments();
 	  			 log("STEP 13:  document is loaded  ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 13:  docuemnt could not be uploaded.  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 13");
 	  		 }
 	    	 
 	    	 
 	    	 try {
 	    		 ClickOnCloseDocument();
 	  			 log("STEP 14:  POpup should get closed ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 14:  popup does not get closed  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 14");
 	  		 }

 	    }	
 	    else {
 	    	try {
 	    		util.switchToIframe(FullFrm);
 	    		ClickonDocumentsTab();
 	    		util.dummyWait(2);
 				log("STEP 7: Document  window should display on documents tab    ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 7:  The document  window does not display ", Status.FAIL);
 				throw new RuntimeException("Failed in step 7");
 			}
 	    	
 	    	try {
 	    		ClickonAddDocuments();
 				log("STEP 8: Document popup window should display with external documents tab ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 8: The document pop window does not display ", Status.FAIL);
 				throw new RuntimeException("Failed in step 8");
 			}
 	    
 	    	try {
 	    		util.switchToIframe(iframeDocument);
 	    		 util.dummyWait(5);
 	    		uploadFile();
 				log("STEP 9: User can upload document from the system  ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 9: User cannot upload a document ", Status.FAIL);
 				throw new RuntimeException("Failed in step 9");
 			}
 	    	
 	    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
 	    	 try {
 	    		 util.dummyWait(10);
  	    		 util.click(drpCategory);
 	    		 selectCategory(map.get(Excel.DocCategory));
 	  			 log("STEP 10:  Value added display in Category field  ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 10:  User  cannot select  value  from Category DD  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 10");
 	  		 }
 	    	 
 	    	 try {
 	    		 AddDescription(map.get(Excel.Description));
 	  			 log("STEP 11:  User can enter a value in Description field   ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 11:  User cannot add a value in Description field   ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 11");
 	  		 }
 	    	 
 	    	}
 	    	
 	    	else {
 	    		
 	    		if(util.isElementPresent(drpCategoryROWTree)) {
 	 	   			try {
 	 	   				selectCategoryTree(map.get(Excel.DocCategory));
 	 	   				log("STEP 10:  User can select Category", Status.PASS);
 	 	   			} catch (Exception e) {
 	 	   				log("STEP 10:  User can not select Category", Status.FAIL);
 	 	   				throw new RuntimeException("STEP 10:  User can not select Category");
 	 	   			}
 	 	   		}else {
 	 	   		try {
 	 	   			selectCategoryROW(map.get(Excel.DocCategory));
 	 	   			log("STEP 10:  User can select Category", Status.PASS);
 	 	   		} catch (Exception e) {
 	 	   			log("STEP 10:  User can not select Category", Status.FAIL);
 	 	   			throw new RuntimeException("STEP 10:  User can not select Category");
 	 	   		}
 	 	   		}
 	 		    	 
 	 	    		try {
 	 	   			setDescription(map.get(Excel.Description));
 	 	   			log("STEP 11: Fill in Description", Status.PASS);
 	 	   		} catch (Exception e) {
 	 	   			log("STEP 11: Fill in Description", Status.FAIL);
 	 	   			throw new RuntimeException("Failed in step 11");
 	 	   		}
 		    	 
 	    	}	
 	    	
 	    	
 	    	 try {
 	    		 ClickonLoadDocuments();
 	  			 log("STEP 12:  document is loaded  ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 12:  docuemnt could not be uploaded.  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 12");
 	  		 }
 	    	 
 	    	 
 	    	 try {
 	    		 
 	    		 if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
 	    		 if(!util.isElementVisible(txtDocumentNameRow)) {
 	    		 ClickonExternalLink();
 	    		 }
 	    		 }else {
 	    			 ClickonExternalLink();
 	    		 }
 	  			 log("STEP 13: panel is expanded & fields are visible ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 13:  Panel is not expanded  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 13");
 	  		 }
 	    	 
 	    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) { 
 	    	 
 	    	 try {
 	    		 AddDocumentName(map.get(Excel.DocumentName));
 	  			 log("STEP 14:  User can enter a value in Document Name field   ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP  14:  User cannot add a value in Document Name field   ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 14");
 	  		 }
 	    
 	    	 try {
 	    		 AddExternalLink(map.get(Excel.ExternalLink));
 	  			 log("STEP 15:   User can enter a value in External Link field ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 15:  User cannot add a value in External Link field  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 15");
 	  		 }
 	    	 
 	    	 try {
 	    		 AddCategoryForExeLink(map.get(Excel.DocCategory));
 	  			 log("STEP 16: Added value displays in Category field ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 16:  No value displays in Category Dropdown  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 16");
 	  		 }
 	    	 
 	    	 try {
 	    		 AddDescriptionExelink(map.get(Excel.GroupDescription));
 	  			 log("STEP 17:  User can enter a value in Description field ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 17:  User cannot add a value in Description field  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 17");
 	  		 }
 	    	 
 	    	}
 	    	
 	    	else {
 	    		
 	    		try {
 		    		 AddDocumentNameRow(map.get(Excel.DocumentName));
 		  			 log("STEP 14:  User can enter a value in Document Name field   ", Status.PASS);
 		  		 } catch (Exception e) {
 		  			log("STEP 14:  User cannot add a value in Document Name field   ", Status.FAIL);
 		  			throw new RuntimeException("Failed in step 14");
 		  		 }
 		    
 		    	 try {
 		    		 AddExternalLinkRow(map.get(Excel.ExternalLink));
 		  			 log("STEP 15:   User can enter a value in External Link field ", Status.PASS);
 		  		 } catch (Exception e) {
 		  			log("STEP 15:  User cannot add a value in External Link field  ", Status.FAIL);
 		  			throw new RuntimeException("Failed in step 15");
 		  		 }
 		    	 
 		    	 try {
 		    		if (util.isElementPresent(selectCategory_ExternalLink)) {
 						selectCategoryExternalLink(map.get(Excel.DocCategory));
 					} else {
 						selectCategoryExternalLinkDOT(map.get(Excel.DocCategory));}
 		  			 log("STEP 16: Added value displays in Category field ", Status.PASS);
 		  		 } catch (Exception e) {
 		  			log("STEP 16:  No value displays in Category Dropdown  ", Status.FAIL);
 		  			throw new RuntimeException("Failed in step 16");
 		  		 }
 		    	 
 		    	 try {
 		    		 AddDescriptionROW(map.get(Excel.GroupDescription));
 		  			 log("STEP 17:  User can enter a value in Description field ", Status.PASS);
 		  		 } catch (Exception e) {
 		  			log("STEP 17:  User cannot add a value in Description field  ", Status.FAIL);
 		  			throw new RuntimeException("Failed in step 17");
 		  		 }
 	    		
 	    		
 	    	}
 	    	 
 	    	 try {
 	    		 ClickOnLoadDocumentsExeLink();
 	  			 log("STEP 18:  document is loaded   ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 18:  docuemnt could not be uploaded  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 18");
 	  		 }
 	    	 
 	    	 try {
 	    		 util.waitFor(1000);
 	    		 ClickOnAddExeLink();
 	  			 log("STEP 19:  User can click on add button.   ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 19:  User cannot click on add button  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 19");
 	  		 }
 	    	 
 	    	 try {
 	    		 ClickOnCloseDocument();
 	  			 log("STEP 20:  POpup should get closed ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 20:  popup does not get closed  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 20");
 	  		 }
 	    	 
 	    	if(!testcaseName.contains("ORSTED")) {
 	    	 try {
 	    		 ClickOnDownloadSelected();
 	  			 log("STEP 21:  selected document will be downloaded  ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 21:  selected document will not be downloaded   ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 21");
 	  		 }
                  util.dummyWait(3);
 	    	 try {
 	    		 ClickOnEmailSelected();
 	    		 util.dummyWait(1);
 	  			 log("STEP 22:  email selected document will be downloaded    ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 22: email selected document will not be downloaded   ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 22");
 	  		 }
 	    	}
 	    } 
 	    	 try {
 	    		 ClickOnNotes();
 	    		 util.dummyWait(2);
 	    		 ClickOnAddNotes();
 	  			 log("STEP 23: User can click on the add Notes button  ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 23:  User cannot see the add Notes button  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 23");
 	  		 }
 	    	 
 	    	 
 	    	 try {
 	    		 AddActivityDate(map.get(Excel.ActivityDate));
 	  			 log("STEP 24:  User can select Activity  Date   ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 24:  User  cannot select Activity Date  from Date Picker ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 24");
 	  		 }
 	    	 
 	    	 try {
 	    		 SelectAgent(map.get(Excel.Agent));	
 		         log("STEP 25:   Added value displays in Agent field ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 25:  User  cannot select  value  from Agent DD  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step  25");
 	  		 }
 	    	 
 	    	 try {
 	    		 SelectNotesCategory(map.get(Excel.Category));
 	  			 log("STEP 26:  Added value displays in Category field ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 26:  User  cannot select  value  from Category DD  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 26");
 	  		 }
 	  
 	    	 
 	    	 try {
 	    		 SelectPriority(map.get(Excel.Priority));
 	  			 log("STEP 27:  Added value displays in Priority field ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 27:  User  cannot select  value  from Priority DD  ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 27");
 	  		 }
 	    	 
 	    	 try {
 	    		 AddNotesDescription(map.get(Excel.Description));
 	  			 log("STEP 28:  User can enter a value in the description field ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 28:  User cannot add a value in Description field   ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 28");
 	  		 }
 	    	 
 	    	 if(testcaseName.contains("DOT")) {
 	    		 try {
 	    		 ClickonAddNoteDot();
 	  			 log("STEP 29:  The added notes displays in the grid    ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 29:  Added values does  not displayed in the grid.   ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 29");
 	  		 }
 	    		 
 	     }
 	    	 else {
 	    	 try {
 	    		 ClickonAddNote();
 	  			 log("STEP 29:  The added notes displays in the grid   ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 29:  Added values does  not displayed in the grid.   ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 26");
 	  		 }
 	    }	 
 	    	 
 	   	 ClickonClose();
 	  			
 	    	 if(testcaseName.contains("DOT")) {
// 	    	 try {
// 	    		 ClickonLinkedApprovals();
// 	  			 log("STEP 27: record will be visible on grid. ", Status.PASS);
// 	  		 } catch (Exception e) {
// 	  			log("STEP 27:   record will not be visible on grid.  ", Status.FAIL);
// 	  			throw new RuntimeException("Failed in step 27");
// 	  		 }
 	    	 
 	    	 
 	    	 try {
 	    		 util.click(btnApproval); 
 	    		 util.dummyWait(2);
 	    		 ClickOnSubmitForReviewButtonDot();
 	 			log("STEP 30:   User can click on submit for review button.  ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 30:  User cannot click on submit for review button  ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 30");
 	 		 }
 	    	 
// 	    	 try {  //need to update the script
//     		 ClickOnStep1Link();
//  			log("STEP 31: Document Upload Link should be clicked successfully ", Status.PASS);
//  		 } catch (Exception e) {
//  			log("STEP 31:  Document Upload Link should not display or clickable ", Status.FAIL);
//  			throw new RuntimeException("Failed in step 31");
//  		 }
//     	 
//     	 try {
//     		 ClickOnSave();
//  			log("STEP 32:Message - 'Changes saved sucessfully!' in green displays  ", Status.PASS);
//  		 } catch (Exception e) {
//  			log("STEP 32:  User cannot click on save button ", Status.FAIL);
//  			throw new RuntimeException("Failed in step 32");
//  		 }
//     	 
//     	 try {
//     		 AddReviewerComment(map.get(Excel.Comment));
//  			log("STEP 33: User can enter Comment ", Status.PASS);
//  		 } catch (Exception e) {
//  			log("STEP 33: User cannot enter Comment  ", Status.FAIL);
//  			throw new RuntimeException("Failed in step 33");
//  		 }
//     	 
//     	 try {
//     		 ClickonApproveButton();
//     		 util.switchToIframe(FullFrm);
//     		 util.dummyWait(1);
//  			log("STEP 34: User can click on Approve button successfully  ", Status.PASS);
//  		 } catch (Exception e) {
//  			log("STEP 34: Pop Up should not appeared   ", Status.FAIL);
//  			throw new RuntimeException("Failed in step 34");
//  		 }
//     	 
//     	 try {
//     		 ClickonRequesterLink();
//  			log("STEP 35: User can click on requestor link   ", Status.PASS);
//  		 } catch (Exception e) {
//  			log("STEP 35: User cannot click on requestor link  ", Status.FAIL);
//  			throw new RuntimeException("Failed in step 35");
//  		 }
     	 
     	 ClickonCloseButton();
  	 
 	   	}
 	    	 
 	    	 
 	    	 else {
 	    		 
 	    		 try {
 		    		 ClickonLinkedApprovals();
 		  			 log("STEP 30: record will be visible on grid. ", Status.PASS);
 		  		 } catch (Exception e) {
 		  			log("STEP 30:   record will not be visible on grid.  ", Status.FAIL);
 		  			throw new RuntimeException("Failed in step 30");
 		  		 }
 	    		 
 	    	 try {
 	    		 navigatetoAssociatedRecord();
 	  			 log("STEP 31: The Record tab displays ;if field does not exists in the instance  and skip the step   ", Status.PASS);
 	  		 } catch (Exception e) {
 	  			log("STEP 31:  The Record tab does not load ", Status.FAIL);
 	  			throw new RuntimeException("Failed in step 31");
 	  		 }
 	    	 
 			try {
 				selectProject(map.get(Excel.ProjectName));
 				clickOnGoProject();
 				log("STEP 32: Selected a project from DD and click on GO button", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 32: Selected a project from DD and click on GO button", Status.FAIL);
 				throw new RuntimeException("Failed in step 32");
 			}
 			SoftAssert softAssert = new SoftAssert();
 			try {
 				selectListOfTrack(map.get(Excel.ListOfTrack));
 				Thread.sleep(5000);
 				if(util.isElementVisible(drpListofLeases)) {
 				if(!environment.contains("VERDANTERRA") & !environment.contains("TRA")) {
 				selectListOfLeases(map.get(Excel.ListOfLeases));
 				Thread.sleep(5000);
 				}
 				}
 				clickOnListOfTract();
 				softAssert.assertEquals(getListOfTractMessage(), "Requested association created successfully",
 						"Success message is mismatch");
 				refreshListOfTract();
				util.dummyWait(2);
 				log("STEP 33: Select a Tract list from the DD and click on Add ", Status.PASS);
 			} catch (Exception e) {
 				log("STEP 33: Select a Tract list from the DD and click on Add ", Status.FAIL);
 				throw new RuntimeException("Failed in step 33");
 			}

 			 try { util.click(btnApproval); 
     		 util.dummyWait(2); 
         		 ClickOnSubmitForReviewButton();
      			log("STEP 34:   User can click on submit for review button.  ", Status.PASS);
      		 } catch (Exception e) {
      			log("STEP 34:  User cannot click on submit for review button  ", Status.FAIL);
      			throw new RuntimeException("Failed in step 34");
      		 }
 			
 	    	 ClickonCloseButton();
     		 util.dummyWait(2); 

 	    } 

    }
}
