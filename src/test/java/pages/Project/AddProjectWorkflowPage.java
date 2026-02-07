package pages.Project;

import java.io.File;
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

import extentReports.ExtentTestManager;

public class AddProjectWorkflowPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public boolean associatedTab;
	public String ApprovalType, APPROVER, AGREEMENTNUMBER;
	
	public AddProjectWorkflowPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	

	By autoApproved = By.xpath("//a[text()='Approved']");
	By adminReviewLink = By.xpath("//a[text()='Admin Review'] | //a[text()='Land Admin/Admin Review'] | //a[text()='Step 1']");
	By reviewIframe = By.xpath("//iframe[@name='geoPopUpWF']");
	By btnSubmitForReview = By.xpath("//input[contains(@id,'WorkflowApprove_btnSubmit')]");
	By btnSubmitForReviewNew = By.xpath("//input[@id='idManageApproval_YALInLineWorkflowApprove_btnSubmit']");
	By projectApprovals = By.xpath("//a[normalize-space()='Project Approvals' or normalize-space()='Project Forms']");
	By addProjectApprovals = By.xpath(
			"//*[normalize-space()='Project Approvals' or normalize-space()='Project Forms']/..//a[normalize-space()='Add new record']");
	By iframeApproval = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@name,'idManageApproval$cbParcelApprovalType')]");
	By drpAssociateWorkflow = By.xpath("//input[contains(@name,'idManageApproval$cbAssociate_Workflows')]");
	By drpSelectTemplate = By.xpath(
			"//*[normalize-space()='Select Templates']/..//input[contains(@id,'idManageApproval_customFields')]");
	By drpSelectTemplateClose = By.xpath("//*[normalize-space()='Select Templates']/..//a[contains(@id,'Arrow')]");
	By btnSaveApprovals = By.xpath("//input[contains(@id,'_btnSaveHeader')]");
	By btnCloseForm = By.xpath("//div[contains(@id,'ManageApprovalDialog')]//a[@title='Close']");

	// All tabs
	By tabApproval = By.xpath(
			"//div[@id='idManageApproval_tabStrip']//a[normalize-space()='Approvals' and not(contains(@class,'rtsDisabled'))]");
	By tabDocument = By.xpath(
			"//div[@id='idManageApproval_tabStrip']//a[contains(normalize-space(),'Documents') and not(contains(@class,'rtsDisabled'))]");
	By tabNotes = By.xpath(
			"//div[@id='idManageApproval_tabStrip']//a[contains(normalize-space(),'Notes') and not(contains(@class,'rtsDisabled'))]");
	By drpNotesCategory = By.xpath("//input[contains(@id,'AgntNotes_CID_radYALDropDownList_Input')] | //input[contains(@id,'AgntNotes_DDL1_radYALDropDownList_Input')]");
	By drpPriority = By.xpath("//input[contains(@id,'PID_radYALDropDownList_Input')]");
	By txtNotesDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
	By tabLinkedApprovals = By.xpath(
			"//div[@id='idManageApproval_tabStrip']//a[normalize-space()='Linked Approvals' and not(contains(@class,'rtsDisabled'))]");
	By tabAssociatedRecords = By.xpath(
			"//div[@id='idManageApproval_tabStrip']//a[contains(normalize-space(),'Associated Records') and not(contains(@class,'rtsDisabled'))]");
	By tabLinkApproval = By.xpath(
			"//div[@id='idManageApproval_tabStrip']//a[contains(normalize-space(),'Linked Approvals') and not(contains(@class,'rtsDisabled'))]");
	By excelIcon = By.xpath("//a[contains(@id,'DownloadEXCELNew')]");
	// Document tab
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
	By btnAddDocument = By.xpath("//input[@id='idManageApproval_btnAddDocuments']");
	By drpCategory = By.xpath("//select[contains(@id,'_rauFileUploadcategory')] | //select[contains(@id,'Category')]");
	By description = By.xpath("//input[contains(@id,'RadUpload1Desc') or contains(@id,'rauFileUploadDesc')]");
	By fileUpload = By.xpath("//input[contains(@id,'RadUpload1file') or contains(@id,'rauFileUploadfile')]");
	By loadDocumentFile = By.cssSelector("#buttonSubmit");
	By loadDocumentFile2 = By.xpath("//input[contains(@id,'buttonSubmit_input')]");
	By documentSuccessMessage = By.xpath("//span[@id='lblResults']");
	By btnCloseDocument = By.xpath("//div[contains(@id,'_AddDocuments')]//a[@title='Close']");

	// Note Tab
	By iframeNotes = By.xpath("//iframe[@name='radWinAgentNotes']");
	By btnAddNotes = By.xpath("//input[@id='idManageApproval_btnAddNotes']");
	By btnSaveNotes = By.xpath("//input[@id='AgntNotes_SN']");
	By notesMessages = By.xpath("//span[@id='AgntNotes_usrMessage']");
	By btnCloseNotes = By.xpath("//div[contains(@id,'_radWinAgentNotes')]//a[@title='Close']");
	By btnRefreshNotes = By.xpath("//table[contains(@id,'idManageApproval_NOTES')]//a[contains(@id,'_lnkRefresh')]");
	By addedApprovedNote = By
			.xpath("//table[contains(@id,'idManageApproval_NOTES_radYALGridControl')]//td[contains(.,'Approved')]");

	// Associated records
	By drpAddProjects = By.xpath(
			"//*[contains(text(),'Projects:')]/..//input[@id='idManageApproval_Projects_Input'] | //*[normalize-space()='Projects:']/../following-sibling::tr//input[@id='idManageApproval_Projects_Input']");
	By drpAddProjectsClose = By.xpath(
			"//*[normalize-space()='Projects:']/../following-sibling::tr//a[contains(@id,'Approval_Projects_Arrow')] | //*[contains(text(),'Projects:')]//a[contains(@id,'Approval_Projects_Arrow')]");
	By drpListOfTrack = By.xpath(
			"//*[contains(text(),'List of Tract:') or contains(text(),'List of Parcels:') ]/..//input[@id='idManageApproval_Tract_Agreement_Input'] | //*[normalize-space()='List of Tract:']/../following-sibling::tr//input[@id='idManageApproval_Tract_Agreement_Input'] | //*[normalize-space()='List of Parcels:']/../following-sibling::tr//input[@id='idManageApproval_Tract_Agreement_Input']");
	By drpListOfTrackClose = By.xpath(
			"//*[normalize-space()='List of Tract:']/../following-sibling::tr//a[contains(@id,'Tract_Agreement_Arrow')] | //*[normalize-space()='List of Parcels:']/../following-sibling::tr//a[contains(@id,'Tract_Agreement_Arrow')] | //*[contains(text(),'List of Tract:') or contains(text(),'List of Parcels:')]/..//a[contains(@id,'Tract_Agreement_Arrow')]");
	
	By drpListofLeases = By.xpath(
			"//*[contains(text(),'List of Leases:') or contains(text(),'List of Agreements:')]/..//input[@id='idManageApproval_Lease_Association_Input'] | //*[normalize-space()='List of Leases:']/../following::div[@id='idManageApproval_Lease_Association'] | //*[normalize-space()='List of Agreements:']/../following::div[@id='idManageApproval_Lease_Association']");
	By drpListofLeasesClose = By.xpath(
			"//*[contains(text(),'List of Leases:') or contains(text(),'List of Agreements:')]/..//a[@id='idManageApproval_Lease_Association_Arrow'] | //*[normalize-space()='List of Leases:']/../following-sibling::tr//a[@id='idManageApproval_Lease_Association_Arrow'] | //*[normalize-space()='List of Agreements:']/../following-sibling::tr//a[@id='idManageApproval_Lease_Association_Arrow']");
	
	
	By btnGoProject = By.xpath("//input[@id='idManageApproval_btnGo']");
	By btnAddListOfTract = By.xpath("//input[@id='idManageApproval_btnAddApprovalAssociation']");
	By btnRefreshListTract = By.xpath(
			"//table[contains(@id,'idManageApproval_ASSOCIATED_APPROVAL_TRACTS')]//a[contains(@id,'_lnkRefresh')]");
	By listTractMessage = By.xpath("//span[@id='idManageApproval_msgAgreement']");
	By btnDeleteListTract = By.xpath("//table[contains(@id,'ASSOCIATED_APPROVAL_TRACTS')]//input[@alt='Delete']");
	By btnDeleteOk = By.xpath("//div[contains(@class,'rwDialogPopup')]//span[text()='OK']");
	By listTractUsrMessage = By.xpath("//span[@id='idManageApproval_ASSOCIATED_APPROVAL_TRACTS_usrMessage']");
	
	//updated 1
	By WFStatus = By.xpath("(//td[text()='Pending']/..//td[text()='GIS Bulk Processing Document Generation'])[1]");
	By EditWF = By.xpath("(//*[contains(@id,'YALWorkflows_radYALGridControl_ctl00__0')]//a[1])[1]");
	By AgreementWFStatus = By.xpath("(//td[text()='Pending']/..//td[text()='Sample Lease Workflow'])[1] | (//td[text()='Pending']/..//td[text()='One Off Payment'])[1]");
	
	
	public void selectApprovalType(String value) {
		util.selectValueFromDropdown(drpApprovalType, value);
	}

	public void selectTemplate(String value) {
		if (!commonFunction.checkNA(value)) {
		util.selectValueFromDropdown(drpSelectTemplate, value);
		util.click(drpSelectTemplateClose);
		}
	}

	public void selectReportFormat(String value) {
		if (!commonFunction.checkNA(value)) {
		By radioButton = By.xpath(
				"//*[normalize-space()='Report format']/..//label[text()='" + value + "']/preceding-sibling::input");
		util.click(radioButton);
		}
	}

	public void clickOnSaveApprovals() {
		util.click(btnSaveApprovals);
	}

	public void clickOnDocumentTab() {
		util.waitForWebElementToBePresent(tabDocument, 60);
		util.waitFor(2000);
		util.click(tabDocument);
	}

	public void clickOnAddDocument() {
		util.click(btnAddDocument);
	}

	public void selectCategory(String value) {
		if (!commonFunction.checkNA(value)) {
		if(util.isElementPresent(drpCategory)) {
			util.selectValueFromDropdown2(value, drpCategory);
		}
	}}

	public void selectCategory() {
		util.pressDownkey();
		util.pressENTERkey();
	}
	
	By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined')]");
	 
	public void selectCategoryTree(String value) {
		if (!commonFunction.checkNA(value)) {
			util.waitForWebElementToBePresent(drpCategoryROWTree);
			util.selectValueFromDropdown3(drpCategoryROWTree, value);			
		}
	}
	public void setDescription(String value) {
		if(util.isElementPresent(description)) {
			util.inputText(description, value);
		}
	}

	public void uploadFile() {
		String filepath = System.getProperty("user.dir") + File.separator + "WorkflowDoc.txt";
		driver.findElement(fileUpload).sendKeys(filepath);
	}

	public void clickOnNoteTab() {
		util.click(tabNotes);
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
	public void clickOnAddNote() {
		util.click(btnAddNotes);
	}

	public void clickOnSaveNote() {
		util.click(btnSaveNotes);
	}

	public void clickOnCloseNote() {
		util.click(btnCloseNotes);
	}

	public void clickOnRefreshNote() {
		util.click(btnRefreshNotes);
	}

	public String getNotesMessage() {
		return util.getText(notesMessages);
	}

	public void clickOnAssociatedRecordsTab() {
		util.click(tabAssociatedRecords);
	}

	public void ClickonLinkApprovaltab() {
		util.click(tabLinkApproval);
	}

	public void ClickOnExcel() {
		util.click(excelIcon);
	}

	public void selectProject(String value) {
		try {
			util.selectValueFromDropdown(drpAddProjects, value);
			util.click(drpAddProjectsClose);
		} catch (Exception e) {
//			util.click(drpAddProjectsClose);
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

	public void deleteListOfTract() {
		util.waitForWebElementToBePresent(btnDeleteListTract);
		util.click(btnDeleteListTract);
		util.waitFor(2000);
		util.click(btnDeleteOk);

	}
	

	public String getListTractUsrMessage() {
		return util.getText(listTractUsrMessage);
	}

	public void clickOnAddNewRecord() {
		util.click(addProjectApprovals);
	}
	
	//updated script 2
	
	public void CloseForm() {
		util.switchToDefaultContent();
		util.isElementVisible(btnCloseForm);
		util.click(btnCloseForm);
		util.reloadPage();
		util.waitUntilPageLoad();
	}
	
	public void EditWorkflow() {
		util.isElementVisible(EditWF);
		util.click(EditWF);
	}

	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navLeaseManager = By.xpath("//a//span[contains(text(),'Lease Manager')] ");
	By navAgreementInformation = By.xpath("//a//span[contains(text(),'Agreement Information')] | //a//span[contains(text(),'Entity Information')]");
	
	public void navigateToAgreementInformationALT() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitFor(500);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navAgreementInformation);
		
	}
	
	public void navigateToAgreementInformationROW() {
		util.waitFor(500);
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navLeaseManager);
		util.click(navLeaseManager);
	}
	
	
	public void projectApprovalTestcase(Map<String, String> map) {
		if (!util.isElementVisible(addProjectApprovals)) {
			util.click(projectApprovals);
			if (!util.isElementVisible(addProjectApprovals)) {
				util.click(projectApprovals);
			}
		}
		try {
			clickOnAddNewRecord();
			log("STEP 1: Click on Add button under the  Project Approvals panels", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on Add button on the Project Approvals panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			util.waitForWebElementToBePresent(iframeApproval);
			util.switchToIframe(iframeApproval);
			selectApprovalType(map.get(Excel.ApprovalType));
			ApprovalType=map.get(Excel.ApprovalType);
			log("STEP 2: User can select the Approval type from Approval Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select the Approval type from Approval Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		try {
			selectTemplate(map.get(Excel.Template));
			log("STEP 3: Selected the templates from DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select the templates from DD", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			selectReportFormat(map.get(Excel.ReportFormat));
			log("STEP 4: Selected the report format", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select the report format", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
	}
	By agreementOrLeaseTab = By.xpath("//span[text()='Agreement Forms' or text()='Lease Forms']");
	By addNewAgreementForm = By.xpath("//table[contains(@id,'LeaseInfoApproval')]//a[contains(@id,'lnkAddNewRecord')]");
	public void navigateToAgreementForm() {
		if(!util.isElementVisible(addNewAgreementForm)) {
			util.click(agreementOrLeaseTab);
		}
		util.click(addNewAgreementForm);
	}
	
	By projectApprovalIFrame = By.xpath("//iframe[@name='ManageApprovalDialog']");
	public void switchToProjectApprovalIframe() {
		util.waitForWebElementToBePresent(projectApprovalIFrame, IMPLICIT_WAIT);
		util.switchToIframe(projectApprovalIFrame);
	}
	By typeOfPaymentTXT = By.xpath("//span[contains(text(),'Type of Payment')]/..//input[@type='text'] | //span[contains(text(),'Payment Template')]/..//input[@type='text']");
	By paymentAmountTXT = By.xpath("//span[text()='Payment Amount:']/..//input[@type='text']");
	By agreementPhaseTXT = By.xpath("//span[text()='Agreement Phase:']/..//input[@type='text'] | //span[text()='Agreement Term:']/..//input[@type='text'] |//span[text()='Doc Type:']/..//input[@type='text']");
	By dueDateTXT = By.xpath("//span[text()='Due Date:']/..//input[contains(@id,'dateInput') and @type='text']");
	By distributionTXT = By.xpath("//span[text()='Distribution:']/..//input[@type='text']");
	By additionalPaymentTXT = By.xpath("//span[contains(text(),'# of Additional Payments')]/..//input[@type='text']");
	By frequencyIncreaseTXT = By.xpath("//span[text()='Frequency Increment:']/..//input[@type='text']");
	By paymentFrquencyTXT = By.xpath("//span[text()='Payment Frequency:']/..//input[@type='text']");
	By remarksTXT = By.xpath("//span[contains(text(),'Remarks')]/..//textarea");
	By drpPeerReviewer = By.xpath("//span[text()='Peer Reviewer:']/..//input[@type='text']");
	
	public void fillAlldetailsInProjectApproval(String typeOFPaymentValue, String agreementPhaseValue, String distributionValue) {
		util.inputTextAndPressTab(typeOfPaymentTXT, typeOFPaymentValue);
		log("Type of payment sucessfully selected");
		util.inputText(paymentAmountTXT, "1");
		log("Payment Amount sucessfully entered");
		util.inputTextAndPressTab(agreementPhaseTXT, agreementPhaseValue);
		log("Agreement Phase sucessfully selected");
		util.inputText(dueDateTXT, TestUtil.getCurrentDateTime("dd/MM/yyyy"));
		log("Due Date sucessfully entered");
		util.inputTextAndPressTab(distributionTXT, distributionValue);
		log("Distribution value sucessfully selected");
		util.inputText(additionalPaymentTXT, "1");
		log("Additional Payment sucessfully entered");
		util.inputText(frequencyIncreaseTXT, "1");
		log("Frequency Increased entered");
		util.inputTextAndPressTab(paymentFrquencyTXT, "Days");
		log("Payment Frequency sucessfully selected");
		util.inputText(remarksTXT, "Automation Remarks");
		log("Remark sucessfully entered");
		
		if(environment.contains("NEXTERA")) {
			util.inputText(drpPeerReviewer, "Support, Geo");
		}
	}
	public void agreementFormTestcase(Map<String, String> map, String testName) {
		try {
			navigateToAgreementForm();
			switchToProjectApprovalIframe();
			log("STEP 1: User can click on Add button under the  Project Approvals panels", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on Add button under the  Project Approvals panels", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			selectApprovalType(map.get(Excel.ApprovalType));
			ApprovalType = map.get(Excel.ApprovalType);
			log("STEP 2: User can Select Work Flow from Approval Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Work Flow from Approval Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		try {
			
			if (!testName.contains("ROW") && !testName.contains("TRA") ) {
			fillAlldetailsInProjectApproval(map.get(Excel.TypeOFPayment), map.get(Excel.AgreementPhase), map.get(Excel.Distribution));
			}log("STEP 3:User can select all mandatory field", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select all mandatory field", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			log("STEP 4: User can Verify validations if any", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot verify validations ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
	}
	
	 By agreementReviewChecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @checked='checked']");
	    By agreementReviewUnchecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @type='checkbox']");
	    
	    By saveButton = By.xpath("(//input[contains(@id,'_btnSave') and not(@disabled)])[1]");

		private void clickOnSaveButton() {
			util.click(saveButton);
			util.dummyWait(5);
		}
		

	public void addNewWorkflow(Map<String, String> map, String testcaseName, boolean isAllSteps) throws InterruptedException {
		
		
		if(testcaseName.contains("Agreement")) {
			if(environment.contains("NEXTERA")) {
				if(!util.isElementVisible(agreementReviewChecked)) {
					util.click(agreementReviewUnchecked);
					clickOnSaveButton();
				}
			}
			agreementFormTestcase(map, testcaseName);
		} else {
			projectApprovalTestcase(map);
		}

		try {
			clickOnSaveApprovals();
			log("STEP 5: User can click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		// updated script  3	
		
				try {
					CloseForm();
					log("STEP 6: User can click on close button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User cannot click on close button", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
				
				
//			  if(util.isElementVisible(WFStatus) || util.isElementVisible(AgreementWFStatus)) {
//			  log("STEP 7: Workflow Status is 'Pending'", Status.PASS);
//			  }else{
//			  log("STEP 7: Workflow status is not updated to 'Pending'", Status.FAIL);
//				  throw new RuntimeException("Failed in step 7");
//			  }
			  
			  
			  try {
				  Assert.assertTrue(util.isElementVisible(WFStatus)||util.isElementVisible(AgreementWFStatus));
				  log("STEP 7: Workflow Status is 'Pending'", Status.PASS);
			  }catch (AssertionError e){
				  log("STEP 7: Workflow status is not updated to 'Pending'", Status.FAIL);
				  throw new RuntimeException("Failed in step 7");
			  }
			  
			 
			  try {
				  EditWorkflow();  
		          log("STEP 8: User can click on edit icon", Status.PASS);
			  }catch (Exception e){
				  log("STEP 8: User cannot click on Edit icon", Status.FAIL);
				  throw new RuntimeException("Failed in step 8");
			  }
		

		try {
			util.switchToIframe(iframeApproval);
			clickOnDocumentTab();
			util.dummyWait(10);
			clickOnAddDocument();
			log("STEP 9: User can select the Douments tab and clicked on add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot select the Douments tab and click on add button", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

		try {
			util.waitForWebElementToBePresent(iframeDocument, IMPLICIT_WAIT);
			util.waitFor(5000);
			util.switchToIframe(iframeDocument);
			uploadFile();
			util.waitFor(2000);
			log("STEP 10: Document is uploaded", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: Document is not uploaded", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		if(util.isElementPresent(drpCategory)) {
		try {
			util.dummyWait(10);
			 util.click(drpCategory);
//			selectCategory(map.get(Excel.DocCategory));
			selectCategory();
			log("STEP 11: User can select the document category", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot select the document category", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		}else {
		try {
			util.dummyWait(10);
			selectCategoryTree(map.get(Excel.DocCategory));
			log("STEP 12: User can select the document category", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot select the document category", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		}
		try {
			setDescription(map.get(Excel.DocComments));
			log("STEP 13: User can enter the description of document", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot enter the description of document", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}

		try {
			if (util.isElementPresent(loadDocumentFile)) {
				util.click(loadDocumentFile);
			} else if (util.isElementPresent(loadDocumentFile2)) {
				util.click(loadDocumentFile2);
			}
			util.waitUntilElementDisplay(documentSuccessMessage);
			String msg = util.getText(documentSuccessMessage);
			Assert.assertEquals(msg, "Loaded: WorkflowDoc.txt", "Success message is mismatch");
			util.switchToDefaultContent();
			util.switchToIframe(iframeApproval);
			util.click(btnCloseDocument);
			log("STEP 14: User can click on Load documents button", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot click on Load documents button", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}

		// Notes Tab
		try {
			clickOnNoteTab();
			clickOnAddNote();
			log("STEP 15: User can select the Notes  tab and click on add Notes button", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: User cannot select the Notes  tab and click on add notes button", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		// select filters
		try {
			util.switchToIframe(iframeNotes);
			SelectNotesCategory(map.get(Excel.Category));
			SelectPriority(map.get(Excel.Priority));
			log("STEP 16: User can select the category", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot select the category", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		try {
			AddNotesDescription(map.get(Excel.Description));
			log("STEP 17: User can enter the description", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot enter the description", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		SoftAssert softAssert = new SoftAssert();
		try {
			clickOnSaveNote();
			try {
				softAssert.assertEquals(getNotesMessage(), "Note submitted for review.", "Success message is mismatch");
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			log("STEP 18: User can click on Save Note button", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: User cannot click on Save Note button", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		try {
			util.switchToDefaultContent();
			util.switchToIframe(iframeApproval);
			clickOnCloseNote();
			clickOnRefreshNote();
			// Verify added record
			try {
				softAssert.assertTrue(util.isElementPresent(addedApprovedNote), "Record is not added properly");
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
			log("STEP 19: Note added successfully", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: Note does not added successfully", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}

		try {
			ClickonLinkApprovaltab();
			log("STEP 20: User can navigate to the Link Approval tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: User cannot navigate to the Link Approval tab", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}

//		try {
//			softAssert.assertTrue(util.isElementPresent(excelIcon), "Unable to CLick on Excel Download");
//			util.click(excelIcon);
//			log("STEP 17: User can click on Download Excel file Icon", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 17: User cannot click on Download Excel file Icon", Status.FAIL);
//			throw new RuntimeException("Failed in step 17");
//		}
		
		 if(!testcaseName.toLowerCase().contains("dot")) {
			 associatedTab= true;
		try {
			// Associated record tab
			clickOnAssociatedRecordsTab();
			log("STEP 21: User can navigate to the associated records tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: User cannot navigate to the associated records tab", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}

		try {
			selectProject(map.get(Excel.ProjectName));
			clickOnGoProject();
			log("STEP 22: User can select a project from DD and click on GO button", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: User cannot select a project from DD and click on GO button", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
		
		
        
		try {
			selectListOfTrack(map.get(Excel.ListOfTrack));
			Thread.sleep(5000);
			if(!environment.contains("VERDANTERRA") & !environment.contains("TRA") & !environment.contains("DOM")) {
			if(util.isElementPresent(drpListofLeases)) {
			selectListOfLeases(map.get(Excel.ListOfLeases));
			}
			}
			Thread.sleep(5000);
			clickOnListOfTract();
			softAssert.assertEquals(getListOfTractMessage(), "Requested association created successfully",
					"Success message is mismatch");
			log("STEP 23: User can select a Tract from the Tract list DD and click on Add ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: User cannot select a Tract from the Tract list DD and click on Add ", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		 }
		
		
//		if (isAllSteps) {
//			if(!testcaseName.toLowerCase().contains("dot")) {
//			try {
//				deleteListOfTract();
//				Thread.sleep(5000);
//				softAssert.assertEquals(getListTractUsrMessage(), "Changes saved successfully!",
//						"Success message is mismatch");
//				log("STEP 24: User can click on delete (X) icon", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 24 User cannot click on delete (X) icon", Status.FAIL);
//				throw new RuntimeException("Failed in step 24");
//			}
//			}
//			try {
//	//			util.switchToDefaultContent();
//				util.dummyWait(3);
//				log("STEP 25: User can click on ok button", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 25: User cannot click on ok button", Status.FAIL);
//				throw new RuntimeException("Failed in step 25");
//			}
//		}
	}

	public void submitTheFormForReview() {
		SoftAssert softAssert = new SoftAssert();
		try {
			util.click(tabApproval);
			util.dummyWait(2);
			if(util.isElementPresent(btnSubmitForReviewNew)) {
				util.click(btnSubmitForReviewNew);
			}else {
				util.click(btnSubmitForReview);
			}
			
			util.waitForWebElementToBePresent(autoApproved, 30);
			softAssert.assertTrue(util.isElementPresent(autoApproved), "Form is not auto approved");
			log("STEP 26: User can click on submit for review on the form", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: User cannot Click on submit for review on the form", Status.FAIL);
		}
	}
	
	
	By linkInReview = By.xpath("//a[text()='In-Review']");
	By adminLink = By.xpath("//a[text()='Security Role: Land Administrator/Admin']");
	By iframeWF = By.xpath("//iframe[contains(@name,'idManageApproval_YALInLineWorkflowApprove_RadWindowManager')]");
	By approver = By.xpath("(//tr[contains(@id,'idApproveInLineWorkflow_gridAPPROVERUSERLIST_radYALGridControl')]/..//td[count(//table/thead/tr/th[.='Name']/preceding-sibling::th)+1])[1]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By agreementNumber = By.xpath("//input[contains(@id,'_LSINFO_radPanels_i0_i0_Lease_Number') and @type='text']");
	
	public void TurnOnDesignMode() {
		util.waitUntilElementDisplay(btnDesignMode);
		util.click(btnDesignMode);
		util.dummyWait(2);
	}
	
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	public void SelectUser(String value) {
			if (!commonFunction.checkNA(value)) {
					util.selectValueFromDropdown(drpUser, value);
					
				util.pressENTERkey();
				}
		  }
	
	public void approveWorkflowOrsted() {
		
		try {
			util.waitUntilElementDisplay(linkInReview);
			util.click(linkInReview);
			log("User can click on In-Review link", Status.PASS);
		} catch (Exception e) {
			log("User cannot click on In-Review link", Status.FAIL);
		}
		
		try {
			util.waitUntilElementDisplay(adminLink);
			util.click(adminLink);
			util.switchToIframe(iframeWF);
			util.waitUntilElementDisplay(approver);
			String approverName = util.getText(approver);
			APPROVER=approverName.replace(",", ", ");
			util.switchToDefaultContent();
			util.click(btnCloseForm);
			AGREEMENTNUMBER=util.getAttributeValue(agreementNumber, "value");
			log("User can click on In-Review link", Status.PASS);
		} catch (Exception e) {
			log("User cannot click on In-Review link", Status.FAIL);
		}
		
		try {
			TurnOnDesignMode();
			SelectUser(APPROVER);
			util.dummyWait(2);
			log("User can switch to approver", Status.PASS);
		} catch (Exception e) {
			log("User cannot switch to approver", Status.FAIL);
		}
		
		try {
			navigateToAgreementInformationALT();
			commonFunction.projectSelection();
			util.waitUntilPageLoad();
			By agNo = By.xpath("//td[text()='"+AGREEMENTNUMBER+"']/parent::tr");
			util.click(agNo);
			log("User can navigate to Agreement Information", Status.PASS);
		} catch (Exception e) {
			log("User cannot navigate to Agreement Information", Status.FAIL);
		}
	}
	
	
	By reviewComments = By.xpath("//textarea[contains(@id,'txtReviewerComments')]");
	By approveButton = By.xpath("//input[contains(@id,'btnApprove')]");
	public void submitTheFormForReviewAgreement() {
		SoftAssert softAssert = new SoftAssert();
		try {
			util.click(tabApproval);
			if(util.isElementPresent(btnSubmitForReviewNew)) {
				util.click(btnSubmitForReviewNew);
				log("User can click on submit for review button on the form");
			}else {
				util.click(btnSubmitForReview);
				log("User can click on submit for review button on the form");
			}
			util.dummyWait(3);
			if(util.isElementPresent(adminReviewLink)) {
			util.waitForWebElementToBePresent(adminReviewLink, 60);
			util.click(adminReviewLink);
			if(util.isElementVisible(reviewIframe)) {
			util.waitForWebElementToBePresent(reviewIframe, 30);
			util.switchToIframe(reviewIframe);
			}
			util.inputText(reviewComments, "Automation review comments.");
			util.click(approveButton);
			
			if(util.isElementVisible(reviewIframe)) {
			try {
				util.switchToDefaultContent();
			} catch (Exception e1) { }
			switchToProjectApprovalIframe();}
			}
			
			if(!util.isElementPresent(linkInReview)) {
				
			
			util.click(tabApproval);
			
			util.waitForWebElementToBePresent(autoApproved, IMPLICIT_WAIT);
			softAssert.assertTrue(util.isElementPresent(autoApproved), "Form is not Approved");
			
			log("STEP 27: User can Approve the workflow", Status.PASS);
			}else {
				ExtentTestManager.infoWithScreenshot("Workflow is in In-Review state");
			}
			util.switchToDefaultContent();
		} catch (Exception e) {
			log("STEP 27: User cannot Approve the workflow", Status.FAIL);
			throw new RuntimeException("Failed in STEP 27");
		}
	}

	public void closeApprovalForm() {
		util.switchToDefaultContent();
		util.click(btnCloseForm);
		util.waitFor(5000);
	}

	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	
	public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
	}
	
	public void verifyStoredRecord(Map<String, String> map, String workflow, String testcaseName) {
		By locator = By.xpath("//td[text()='Approved']/..//td[text()='" + workflow + "']");
		if (util.isElementPresent(locator)) {
			log("STEP 28:  Status changed to 'Approved'  ", Status.PASS);
		} else {
			log("STEP 28: workflow is not Approved ", Status.FAIL);
		}
		
		if(!environment.contains("DOM")) {
		if(associatedTab ==true) {
			
			By panelAssociatedForms = By.xpath("//span[text()='Associated Forms']");
			By workflowName = By.xpath("(//*[contains(@id,'AssoInfoApproval_YALWorkflows_radYALGridControl')]/.//td[text()='"+workflow+"'])[1]");
			By workflowCreatedFrom = By.xpath("(//*[contains(@id,'AssoInfoApproval_YALWorkflows_radYALGridControl')]/.//td[text()='"+workflow+"']/..//*[text()='Project'])[1]");
			By colworkflowCreatedFrom = By.xpath("//a[text()='Workflow Created From' and contains(@onclick,'AssoInfoApproval')]");
			
			try {
				navigateParcelInformation();
				util.waitUntilPageLoad();
				commonFunction.selectProjectNew(map.get(Excel.ProjectName));
				String parcelNo = map.get(Excel.ListOfTrack);
				String [] parcel=parcelNo.split("-");
				By addedRecord = By.xpath("//td[text()='"+parcel[1].trim()+"']/parent::tr");
				util.click(addedRecord);
				util.dummyWait(2);
				log("STEP 29: user can Navigate to Parcel Information", Status.PASS);
			} catch (Exception e) {
				log("STEP 29: user can not Navigate to Parcel Information", Status.FAIL);
				throw new RuntimeException("Failed in step 29");
			}
			
			try {
				util.waitUntilElementDisplay(panelAssociatedForms);
				Assert.assertTrue(util.isElementVisible(workflowName));
				util.waitFor(500);
				log("STEP 30: user can verify Associate workflow on parcel level", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 30: user can not verify Associate workflow on parcel level", Status.FAIL);
			}
			
			try {
				util.waitUntilElementDisplay(colworkflowCreatedFrom);
				Assert.assertTrue(util.isElementVisible(colworkflowCreatedFrom));
				util.waitFor(500);
				log("STEP 31: user can see Workflow Created From Column on the Associated Form Grid on parcel level", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 31: user can not see Workflow Created From Column on the Associated Form Grid on parcel level", Status.FAIL);
			}
			
			if(testcaseName.contains("ProjectApproval")) {
			try {
				Assert.assertTrue(util.isElementVisible(workflowCreatedFrom));
				util.waitFor(500);
				log("STEP 32: user can see value 'Project' in the Workflow Created From Column on the Associated Form Grid on parcel level", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 32: user can not see value 'Project' in the Workflow Created From Column on the Associated Form Grid on parcel level", Status.FAIL);
			}
			}
			else {
				try {
					Assert.assertTrue(util.isElementVisible(workflowCreatedFrom));
					util.waitFor(500);
					log("STEP 32: user can see value 'Agreement' in the Workflow Created From Column on the Associated Form Grid on parcel level", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 32: user can not see value 'Agreement' in the Workflow Created From Column on the Associated Form Grid on parcel level", Status.FAIL);
				}
			}
			if(!testcaseName.contains("DOT") & !testcaseName.contains("ORION") & !environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("DOM")) {
				try {
					if(testcaseName.toLowerCase().contains("row") || testcaseName.contains("TRA")) {
						navigateToAgreementInformationROW();
					} else {
						navigateToAgreementInformationALT();
					}
					util.waitUntilPageLoad();
					commonFunction.selectProjectNew(map.get(Excel.ProjectName));
					String leaseNo = map.get(Excel.ListOfLeases);
					String [] lease=leaseNo.split("-");
					By addedRecord = By.xpath("//td[text()='"+lease[1].trim()+"']/parent::tr");
					util.click(addedRecord);
					util.dummyWait(2);
					log("STEP 33: user can Navigate to Agreement Manager", Status.PASS);
				} catch (Exception e) {
					log("STEP 33: user can not Navigate to Agreement Manager", Status.FAIL);
					throw new RuntimeException("Failed in step 33");
				}
			
				try {
					util.waitUntilElementDisplay(panelAssociatedForms);
					Assert.assertTrue(util.isElementVisible(workflowName));
					util.waitFor(500);
					log("STEP 34: user can verify Associate workflow on Agreement level", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 34: user can not verify Associate workflow on Agreement level", Status.FAIL);
				}
				
				try {
					Assert.assertTrue(util.isElementVisible(colworkflowCreatedFrom));
					util.waitFor(500);
					log("STEP 35: user can see Workflow Created From Column on the Associated Form Grid on Agreement level", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 35: user can not see Workflow Created From Column on the Associated Form Grid on Agreement level", Status.FAIL);
				}
				
				if(testcaseName.contains("ProjectApproval")) {
				try {
					Assert.assertTrue(util.isElementVisible(workflowCreatedFrom));
					util.waitFor(500);
					log("STEP 36: user can see value 'Project' in the Workflow Created From Column on the Associated Form Grid on Agreement level", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 36: user can not see value 'Project' in the Workflow Created From Column on the Associated Form Grid on Agreement level", Status.FAIL);
				}
				}else {
					try {
						Assert.assertTrue(util.isElementVisible(workflowCreatedFrom));
						util.waitFor(500);
						log("STEP 36: user can see value 'Agreement' in the Workflow Created From Column on the Associated Form Grid on Agreement level", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 36: user can not see value 'Agreement' in the Workflow Created From Column on the Associated Form Grid on Agreement level", Status.FAIL);
					}
				}
	}
		}
			}
	}
	
	public void verifyStoredRecord( String workflow) {
		By locator = By.xpath("//td[text()='Approved']/..//td[text()='" + workflow + "']");
		if (util.isElementPresent(locator)) {
			log("STEP 28:  Status changed to 'Approved'  ", Status.PASS);
		} else {
			log("STEP 28: workflow is not Approved ", Status.FAIL);
		}
		
	}
	

}
