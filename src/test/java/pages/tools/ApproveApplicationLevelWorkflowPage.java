package pages.tools;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class ApproveApplicationLevelWorkflowPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public String ApprovalType = "";
	public boolean associatedTab;

	public ApproveApplicationLevelWorkflowPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	
	By btnAddNewRecord = By.xpath("//img[contains(@id,'YALWorkflows_radYALGridControl')]");
	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@name,'idManageApproval$cbParcelApprovalType')]");
	By btnSaveApprovals = By.xpath("//input[contains(@id,'_btnSaveHeader')]");By approved = By.xpath("//a[text()='Approved']");
	By adminReviewLink = By.xpath("//a[text()='Admin Review']");
	By btnSubmitForReview = By.xpath("//input[contains(@id,'WorkflowApprove_btnSubmit')]");
	By btnSubmitForReviewNew = By.xpath("//input[@id='idManageApproval_YALInLineWorkflowApprove_btnSubmit']");
	By iframeApproval = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpAssociateWorkflow = By.xpath("//input[contains(@name,'idManageApproval$cbAssociate_Workflows')]");
	By btnCloseForm = By.xpath("//div[contains(@id,'ManageApprovalDialog')]//a[@class='rwCloseButton']");

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
	By tabAssociatedRecords = By.xpath(
			"//div[@id='idManageApproval_tabStrip']//a[contains(normalize-space(),'Associated Records') and not(contains(@class,'rtsDisabled'))]");
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
	By reviewComments = By.xpath("//textarea[contains(@id,'txtReviewerComments')]");
	By approveButton = By.xpath("//input[contains(@id,'btnApprove')]");
	By panelAssociatedForms = By.xpath("//span[text()='Associated Forms']");
	By spinner = By.xpath("//img[@id='idManageApproval_idApproveInLineWorkflow_Image2']");
	
	By ColExpectedStepCompletionDate = By.xpath("//span[text()='Expected Step Completion Date']");
	public void ClickOnAddNewRecord() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.waitFor(500);
		util.switchToIframe(FullFrm);
	}
	public void selectApprovalType(String value) {
		util.selectValueFromDropdown(drpApprovalType, value);
	}

	public void clickOnSaveApprovals() {
		util.click(btnSaveApprovals);
	}

	public void clickOnDocumentTab() {
		util.waitForWebElementToBePresent(tabDocument, 10);
		util.waitFor(200);
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

	By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined')]");
	 
	public void selectCategoryTree(String value) {
		if (!commonFunction.checkNA(value)) {
			util.waitForWebElementToBePresent(drpCategoryROWTree);
			util.selectValueFromDropdown3(drpCategoryROWTree, value);			
		}
	}
	
	By firstCategory = By.xpath("//div[@id='AgntNotes_DDL1_radYALDropDownList_DropDown']//li[1]");
    public void SelectCategoryWithoutMap() {
    	util.click(drpNotesCategory);
    	util.click(firstCategory);
    }
    
	public void setDescription(String value) {
		if(util.isElementPresent(description)) {
			util.inputText(description, value);
		}
	}

	public void uploadFile() {
		String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
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
	
	public void closeApprovalForm() {
		util.switchToDefaultContent();
		util.click(btnCloseForm);
		util.waitFor(200);
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
	
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navLeaseManager = By.xpath("//a//span[contains(text(),'Lease Manager')] ");
	By navAgreementInformation = By.xpath("//a//span[contains(text(),'Agreement Information')] | //a//span[contains(text(),'Entity Information')]");
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By navTool = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Tools')] ");
	By navMyDashBoard = By.xpath("*//a//span[contains(text(),'Project Group') or contains(text(),'My Dashboard')] ");
	By navTools = By.xpath("//span[text()='Tools']");
	By navBulkEdit = By.xpath("//span[contains(text(),'Bulk Edit')]");
	By navMyApproval = By.xpath("//span[contains(text(),'My Approvals')]");
	By navMyRequest = By.xpath("//span[contains(text(),'My Requests')]");
	By navCreateApplicationRequest = By.xpath("//a//span[@class='rmText' and contains(text(),'Create Application Requests')] ");
	
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
		util.dummyWait(2);
	}	
		
	 public void navigateParcelInformation() {
			util.waitUntilElementDisplay(navParcel);
			util.click(navParcel);
			util.waitUntilElementDisplay(navParcelInfo);
			util.click(navParcelInfo);
			util.waitUntilElementDisplay(navParcelInformation);
			util.click(navParcelInformation);
		}
	
		public void navigateToMyDashBoard() {
			util.waitUntilElementDisplay(navTool);
			util.click(navTool);
			util.waitUntilElementDisplay(navMyDashBoard);
			util.click(navMyDashBoard);
		}
		
		public void NavigateToMyApproval() {
			util.waitUntilElementDisplay(navTools);
			util.click(navTools);
			util.waitFor(150);
			if(!util.isElementVisible(navBulkEdit)) {
				util.hoverOnElement(navTools);
			}
			util.hoverOnElement(navBulkEdit);
			util.waitFor(150);
			if(!util.isElementVisible(navMyApproval)) {
				util.hoverOnElement(navBulkEdit);
			}
			util.click(navMyApproval);
		}
		
		public void NavigateToMyRequest() {
			util.waitUntilElementDisplay(navTools);
			util.click(navTools);
			util.waitFor(150);
			util.hoverOnElement(navBulkEdit);
			util.waitFor(150);
			if(util.isElementVisible(navMyRequest)) {
				util.hoverOnElement(navBulkEdit);
			}
			util.click(navMyRequest);
		}
		
		public void navigateToCreateApplicationRequests() {
			util.waitUntilElementDisplay(navTools);
			util.click(navTools);
			util.waitUntilElementDisplay(navCreateApplicationRequest);
			util.click(navCreateApplicationRequest);
		}
		
		public String EndDateAfterAddingCalendarDays(String day) {
			 int days=Integer.parseInt(day);
			 String expDate= util.addDaysInCurrentDate("M/d/yyyy", days);
			return expDate;
		}
		
		public String EndDateAfterAddingBusinessDays(String day) {
			int days=Integer.parseInt(day);
			LocalDate currentDate = LocalDate.now();
	        LocalDate expDate = util.addBusinessDays(currentDate, days);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
	        String formattedDate = expDate.format(formatter);
			return formattedDate;
		}
		
		By txtFilterType = By.xpath("//input[contains(@id,'_FilterTextBox_TYPE')]");
		By filterIconType = By.xpath("//input[contains(@id,'Filter_TYPE') and @title='Filter']");
		By selectContains = By.xpath("//span[text()='Contains']");
		
		public void addType(String value) {
			util.inputText(txtFilterType, value);
	}
		
public void addNewWorkflow(Map<String, String> map, String testcaseName, String scenario) throws InterruptedException {
	   
	if(scenario.contains("CalendarDays")) {
		ApprovalType = map.get("ApprovalType1");
	}else if(scenario.contains("BusinessDays")) {
		ApprovalType = map.get("ApprovalType2");
	}else {
		ApprovalType = map.get("ApprovalType3");
	}
	
		try {
			ClickOnAddNewRecord();
			log("STEP 1: User can click on Add new record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on Add new record button", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			selectApprovalType(ApprovalType);
			log("STEP 2: User can Select Work Flow from Approval Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Work Flow from Approval Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			By approverName = By.xpath("(//*[contains(text(),'"+map.get("FieldName1")+"')]/..//input)[1]");
			util.inputTextAndPressTab(approverName, map.get("Approver Name"));
			log("STEP 3: User can enter value in Approver Name field", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot enter value in Approver Name field", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			By approverEmail = By.xpath("(//*[contains(text(),'"+map.get("FieldName2")+"')]/..//input)[1]");
			util.inputTextAndPressTab(approverEmail, map.get("Approver Email"));
			log("STEP 4: User can enter value in Approver Email field", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter value in Approver Email field", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			By comment = By.xpath("(//*[contains(text(),'"+map.get("FieldName3")+"')]/..//textarea)[1]");
			util.inputTextAndPressTab(comment, map.get("Comments"));
			log("STEP 3: User can enter value in comments field", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot enter value in comments field", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			clickOnSaveApprovals();
			log("STEP 4: User can click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		
		try {
			clickOnSaveApprovals();
			util.dummyWait(1);
			log("STEP 5: User can click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			clickOnDocumentTab();
			clickOnAddDocument();
			log("STEP 6: User can select the Douments tab and clicked on add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select the Douments tab and click on add button", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			util.waitForWebElementToBePresent(iframeDocument, IMPLICIT_WAIT);
			util.switchToIframe(iframeDocument);
			uploadFile();
			util.waitFor(500);
			log("STEP 7: Document is uploaded", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: Document is not uploaded", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		if(util.isElementPresent(drpCategory)) {
		try {
			util.waitFor(500);
			 util.click(drpCategory);
			 util.pressDownkey();
			 util.pressENTERkey();
			//selectCategory(map.get(Excel.DocCategory));
			log("STEP 8: User can select the document category", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot select the document category", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		}else {
		try {
			
			selectCategoryTree(map.get(Excel.DocCategory));
		 
			log("STEP 8: User can select the document category", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot select the document category", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		}
		try {
			setDescription(map.get(Excel.DocComments));
			log("STEP 9: User can enter the description of document", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot enter the description of document", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

		try {
			if (util.isElementPresent(loadDocumentFile)) {
				util.click(loadDocumentFile);
			} else if (util.isElementPresent(loadDocumentFile2)) {
				util.click(loadDocumentFile2);
			}
			log("STEP 10: User can click on Load documents button", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot click on Load documents button", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		try {
			util.waitUntilElementDisplay(documentSuccessMessage);
			String msg = util.getText(documentSuccessMessage);
			Assert.assertEquals(msg, "Loaded: test.txt", "Success message is mismatch");
			log(" User can see Sucess Message", Status.PASS);
		} catch (AssertionError e) {
			log("User cannot see Sucess Message", Status.FAIL);
		}
		
		util.switchToDefaultContent();
		util.switchToIframe(iframeApproval);
		util.click(btnCloseDocument);
		
		// Notes Tab
		try {
			util.waitFor(300);
			clickOnNoteTab();
			clickOnAddNote();
			log("STEP 11: User can select the Notes  tab and click on add Notes button", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot select the Notes  tab and click on add notes button", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		// select filters
		try {
			util.switchToIframe(iframeNotes);
			
			if(environment.contains("WOLFMIDSTREAM")) {
				 SelectCategoryWithoutMap();
		 }else {
			SelectNotesCategory(map.get(Excel.Category));
		 }
			if(util.isElementVisible(drpPriority)) {
			SelectPriority(map.get(Excel.Priority));
			}
			log("STEP 12: User can select the category", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot select the category", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}

		try {
			AddNotesDescription(map.get(Excel.Description));
			log("STEP 13: User can enter the description", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot enter the description", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			clickOnSaveNote();
			log("STEP 14: User can click on Save Note button", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot click on Save Note button", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		try {
			util.switchToDefaultContent();
			util.switchToIframe(iframeApproval);
			clickOnCloseNote();
			clickOnRefreshNote();
			log("STEP 15: Note added successfully", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: Note does not added successfully", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}

		 if(util.isElementVisible(tabAssociatedRecords)) {
			 associatedTab= true;
		try {
			// Associated record tab
			clickOnAssociatedRecordsTab();
			log("STEP 16: User can navigate to the associated records tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot navigate to the associated records tab", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		try {
			selectProject(map.get(Excel.ProjectName));
			clickOnListOfTract();
			util.dummyWait(1);
			clickOnGoProject();
			log("STEP 17: User can select a project from DD and click on GO button", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot select a project from DD and click on GO button", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}

		try {
			selectListOfTrack(map.get(Excel.ListOfTrack));
			util.waitFor(300);
			if(!environment.contains("VALARD") & !environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("DOM")) {
			if(util.isElementVisible(drpListofLeases)) {
			selectListOfLeases(map.get(Excel.ListOfLeases));
			}
			util.waitFor(300);
			}
			clickOnListOfTract();
			util.dummyWait(1);
			log("STEP 18: User can select a Tract from the Tract list DD and click on Add ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: User cannot select a Tract from the Tract list DD and click on Add ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		 }
		 
		
			try {
				util.click(tabApproval);
				log("STEP 19: User can click on Approval Tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 19: User cannot click on Approval Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
		
			try {
				if(util.isElementPresent(btnSubmitForReviewNew)) {
					util.click(btnSubmitForReviewNew);
				}else {
					util.click(btnSubmitForReview);
				}
				log("STEP 20: User can click on submit for review button on the form", Status.PASS);
			} catch (Exception e) {
				log("STEP 20: User cannot click on submit for review button on the form", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}
			
			try {
				closeApprovalForm();
				util.reloadPage();
				log("STEP 21: user can close the popup", Status.PASS);
			} catch (Exception e) {
				log("STEP 21: user can not close the popup", Status.FAIL);
				throw new RuntimeException("Failed in step 21");
			}
			String wfID="";
			if(environment.contains("VALARD")) {
				By PendingwfID = By.xpath("(//*[text()='In-Review']/..//*[text()='"+ApprovalType+"']/..//td[10])[1]");
				util.waitUntilElementDisplay(PendingwfID);
				wfID= driver.findElement(PendingwfID).getText();
				util.waitFor(500);
			}else {
				By PendingwfID = By.xpath("(//*[text()='In-Review']/..//*[text()='"+ApprovalType+"']/..//td[10])[1]");
				util.waitUntilElementDisplay(PendingwfID);
				wfID= driver.findElement(PendingwfID).getText();
				util.waitFor(500);
			}
			
			
			
			if (!environment.contains("CRIMSON")) {
				util.waitFor(500);
			try {
				   NavigateToMyRequest();
					log("STEP 22:  User can navigate to My Request  page ", Status.PASS);
				} catch (Exception e) {
					log("STEP 22:  User cannot navigate to My Request  page", Status.FAIL);
					throw new RuntimeException("Failed in step 22");
				}
			
			try {
				addType(ApprovalType);
				util.click(filterIconType);
				util.click(selectContains);
				util.dummyWait(2);
				log("STEP 23: User can filter record using Type", Status.PASS);
			} catch (Exception e) {
				log("STEP 23: User cannot  filter record using Type", Status.FAIL);
				throw new RuntimeException("Failed in step 23");
			}
			
			try {
				By approvalType = By.xpath("//*[text()='"+ApprovalType+"']");
				Assert.assertTrue(util.isElementVisible(approvalType));
					log("STEP 24:  User can see Approval Type on My Request  ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 24: User cannot see Approval Type on My Request", Status.FAIL);
				}
			
//			try {
//				By proName = By.xpath("//*[text()='"+map.get(Excel.ApprovalType)+"']/..//*[text()='"+map.get(Excel.ProjectName)+"']");
//				Assert.assertTrue(util.isElementVisible(proName));
//					log("STEP 24:  User can see Project Name on My Request", Status.PASS);
//				} catch (AssertionError e) {
//					log("STEP 24: User cannot see Project Name on My Request", Status.FAIL);
//				}
//			
//			try {
//				String parcelNo = map.get(Excel.ListOfTrack);
//				String [] parcel=parcelNo.split("-");
//				By tractNo = By.xpath("//*[text()='"+map.get(Excel.ApprovalType)+"']/..//*[text()='"+parcel+"']");
//				Assert.assertTrue(util.isElementVisible(tractNo));
//					log("STEP 25:  User can see Tract No on My Request", Status.PASS);
//				} catch (AssertionError e) {
//					log("STEP 25: User cannot see Tract No on My Request", Status.FAIL);
//				}
			
			if(scenario.contains("CalendarDays")) {
				if(util.isElementVisible(ColExpectedStepCompletionDate)) {
			try {
				String expEndDate = EndDateAfterAddingCalendarDays(map.get("Days"));
				By compDate = By.xpath("(//*[text()='"+ApprovalType+"']/..//*[contains(text(),'"+expEndDate+"')])[1]");
				Assert.assertTrue(util.isElementVisible(compDate));
					log("STEP 26:  User can see Expected Step Completion Date on My Requests Quick View", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 26: User cannot see Expected Step Completion Date on My Requests Quick View", Status.FAIL);
				}
			}
			}
			else if(scenario.contains("BusinessDays")) {
				if(util.isElementVisible(ColExpectedStepCompletionDate)) {
				try {
					String expEndDate =EndDateAfterAddingBusinessDays(map.get("Days"));
					By compDate = By.xpath("(//*[text()='"+ApprovalType+"']/..//*[contains(text(),'"+expEndDate+"')])[1]");
					Assert.assertTrue(util.isElementVisible(compDate));
						log("STEP 26:  User can see Expected Step Completion Date on My Requests Quick View", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 26: User cannot see Expected Step Completion Date on My Requests Quick View", Status.FAIL);
					}
				}
			}
			
			
			
			try {
				   NavigateToMyApproval();
					log("STEP 27:  User can navigate to  My Approval page   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 27: User cannot navigate to My Approval  page", Status.FAIL);
					throw new RuntimeException("Failed in step 27");
				}
			
			try {
				addType(ApprovalType);
				util.click(filterIconType);
				util.click(selectContains);
				util.dummyWait(2);
				log("STEP 28: User can filter record using Type", Status.PASS);
			} catch (Exception e) {
				log("STEP 28: User cannot  filter record using Type", Status.FAIL);
				throw new RuntimeException("Failed in step 28");
			}
			
			try {
				By approvalType = By.xpath("//*[text()='"+wfID+"']/..//*[text()='"+ApprovalType+"']");
				Assert.assertTrue(util.isElementVisible(approvalType));
					log("STEP 29:  User can see Approval Type on My Approval Quick View ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 29: User cannot see Approval Type on My Approval Quick View", Status.FAIL);
				}
			
//			try {
//				By proName = By.xpath("//*[text()='"+wfID+"']/..//*[text()='"+map.get(Excel.ProjectName)+"']");
//				Assert.assertTrue(util.isElementVisible(proName));
//					log("STEP 29:  User can see Project Name on My Approval Quick View", Status.PASS);
//				} catch (AssertionError e) {
//					log("STEP 29: User cannot see Project Name on My Approval Quick View", Status.FAIL);
//				}
//			
//			try {
//				String parcelNo = map.get(Excel.ListOfTrack);
//				String [] parcel=parcelNo.split("-");
//				By tractNo = By.xpath("//*[text()='"+wfID+"']/..//*[text()='"+parcel+"']");
//				Assert.assertTrue(util.isElementVisible(tractNo));
//					log("STEP 30:  User can see Tract No on My Approval Quick View", Status.PASS);
//				} catch (AssertionError e) {
//					log("STEP 30: User cannot see Tract No on My Approval Quick View", Status.FAIL);
//				}
			
			if(scenario.contains("CalendarDays")) {
			if(util.isElementVisible(ColExpectedStepCompletionDate)) {
			try {
				String expEndDate = EndDateAfterAddingCalendarDays(map.get("Days"));
				By compDate = By.xpath("//*[text()='"+wfID+"']/..//*[contains(text(),'"+expEndDate+"')]");
				Assert.assertTrue(util.isElementVisible(compDate));
					log("STEP 31:  User can see Expected Step Completion Date on My Approval Quick View", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 31: User cannot see Expected Step Completion Date on My Approval Quick View", Status.FAIL);
				}
			}
			}
			else if(scenario.contains("BusinessDays")) {
		     if(util.isElementVisible(ColExpectedStepCompletionDate)) {
				try {
					String expEndDate =EndDateAfterAddingBusinessDays(map.get("Days"));
					By compDate = By.xpath("//*[text()='"+wfID+"']/..//*[contains(text(),'"+expEndDate+"')]");
					Assert.assertTrue(util.isElementVisible(compDate));
					log("STEP 31:  User can see Expected Step Completion Date on My Approval Quick View", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 31: User cannot see Expected Step Completion Date on My Approval Quick View", Status.FAIL);
				}
		     }
			}

			try {
				By approveLink = By.xpath("//*[text()='"+wfID+"']/..//a[text()='Approve/Reject']");
				util.click(approveLink);
				util.dummyWait(1);
				util.switchToIframe(FullFrm);
				log("STEP 32:  user can click on Edit link", Status.PASS);
			} catch (Exception e) {
				log("STEP 32:  user cannot click on Edit link", Status.FAIL);
				throw new RuntimeException("Failed in step 32");
			}
			}else{
				By editWorkflow = By.xpath("(//*[text()='In-Review']/..//*[text()='"+ApprovalType+"']/..//a[text()='Edit'])[1]");
				util.click(editWorkflow);
				util.switchToIframe(FullFrm);
			}
			
			try {
				util.waitForWebElementToBeVisible(adminReviewLink, 5);
				util.click(adminReviewLink);
				util.dummyWait(2);
				
				log("STEP 33: User can click on Admin review link on the form", Status.PASS);
			} catch (Exception e) {
				log("STEP 33: User cannot click on Admin review link on the form", Status.FAIL);
				throw new RuntimeException("Failed in step 33");
			}
			
			try {
				util.inputText(reviewComments, "Automation review comments.");
				log("STEP 34: User can enter Reviewer Comments", Status.PASS);
			} catch (Exception e) {
				ExtentTestManager.infoWithScreenshot("Failed part");
				closeApprovalForm();
				log("STEP 34: User cannot enter Reviewer Comments", Status.FAIL);
				throw new RuntimeException("Failed in step 34");
			}
			
			try {
				util.click(approveButton);
				log("STEP 35: User can click on Approve Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 35: User cannot click on Approve Button", Status.FAIL);
				throw new RuntimeException("Failed in step 35");
			}
			
			try {
				util.click(tabApproval);
				log("STEP 36: User can click on Approval Tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 36: User cannot click on Approval Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 36");
			}
			
			try {
				closeApprovalForm();
				util.reloadPage();
				log("STEP 37: user can close the popup", Status.PASS);
			} catch (Exception e) {
				log("STEP 37: user can not close the popup", Status.FAIL);
				throw new RuntimeException("Failed in step 37");
			}
	
			if(!environment.contains("WOLFMIDSTREAM")) {
			if(associatedTab ==true) {
			try {
				commonFunction.navigateToProjectDeails();
				commonFunction.selectProjectNew(map.get(Excel.ProjectName));
				log("STEP 38: user can Navigate to Project Details", Status.PASS);
			} catch (Exception e) {
				log("STEP 38: user can not Navigate to Project Details", Status.FAIL);
				throw new RuntimeException("Failed in step 38");
			}
			
			By workflowName = By.xpath("//*[contains(@id,'AssoInfoApproval_YALWorkflows_radYALGridControl')]/.//td[text()='"+ApprovalType+"']");
			By workflowCreatedFrom = By.xpath("//*[contains(@id,'AssoInfoApproval_YALWorkflows_radYALGridControl')]/.//td[text()='"+ApprovalType+"']/..//*[text()='Application']");
			By colworkflowCreatedFrom = By.xpath("//a[text()='Workflow Created From' and contains(@onclick,'AssoInfoApproval')]");
			try {
				util.waitUntilElementDisplay(panelAssociatedForms);
				Assert.assertTrue(util.isElementVisible(workflowName));
				util.waitFor(500);
				log("STEP 39: user can verify Associate workflow on project level", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 39: user can not verify Associate workflow on project level", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(colworkflowCreatedFrom));
				util.waitFor(500);
				log("STEP 40: user can see Workflow Created From Column on the Associated Form Grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 40: user can not see Workflow Created From Column on the Associated Form Grid", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(workflowCreatedFrom));
				util.waitFor(500);
				log("STEP 41: user can see value 'Application' in the Workflow Created From Column on the Associated Form Grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 41: user can not see value 'Application' in the Workflow Created From Column on the Associated Form Grid", Status.FAIL);
			}
			
			if(!environment.contains("DOM")) {
			try {
				navigateParcelInformation();
				util.waitUntilPageLoad();
				commonFunction.selectProjectNew(map.get(Excel.ProjectName));
				util.waitFor(1000);
				String parcelNo = map.get(Excel.ListOfTrack);
				String [] parcel=parcelNo.split("-");
				By addedRecord = By.xpath("//td[text()='"+parcel[1].trim()+"']/parent::tr");
				util.click(addedRecord);
				util.waitFor(2000);
				log("STEP 42: user can Navigate to Parcel Information", Status.PASS);
			} catch (Exception e) {
				log("STEP 42: user can not Navigate to Parcel Information", Status.FAIL);
				throw new RuntimeException("Failed in step 42");
			}
			
			try {
				util.waitUntilElementDisplay(panelAssociatedForms);
				Assert.assertTrue(util.isElementVisible(workflowName));
				util.waitFor(500);
				log("STEP 43: user can verify Associate workflow on parcel level", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 43: user can not verify Associate workflow on parcel level", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(colworkflowCreatedFrom));
				util.waitFor(500);
				log("STEP 44: user can see Workflow Created From Column on the Associated Form Grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 44: user can not see Workflow Created From Column on the Associated Form Grid", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(workflowCreatedFrom));
				util.waitFor(500);
				log("STEP 45: user can see value 'Application' in the Workflow Created From Column on the Associated Form Grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 45: user can not see value 'Application' in the Workflow Created From Column on the Associated Form Grid", Status.FAIL);
			}
			}
			if(!testcaseName.contains("DOT") & !testcaseName.contains("ORION")& !environment.contains("CRIMSON")& !environment.contains("DOM") & !testcaseName.contains("TRA")) {
				try {
					if(testcaseName.toLowerCase().contains("row") || testcaseName.contains("TRA")) {
						navigateToAgreementInformationROW();
					} else {
						navigateToAgreementInformationALT();
					}
					commonFunction.selectProjectNew(map.get(Excel.ProjectName));
					String leaseNo = map.get(Excel.ListOfLeases);
					String [] lease=leaseNo.split("-");
					By addedRecord = By.xpath("//td[text()='"+lease[1].trim()+"']/parent::tr");
					util.click(addedRecord);
					util.waitFor(500);
					log("STEP 46: user can Navigate to Agreement Manager", Status.PASS);
				} catch (Exception e) {
					log("STEP 46: user can not Navigate to Agreement Manager", Status.FAIL);
					throw new RuntimeException("Failed in step 46");
				}
			
				try {
					util.waitUntilElementDisplay(panelAssociatedForms);
					Assert.assertTrue(util.isElementVisible(workflowName));
					util.waitFor(500);
					log("STEP 47: user can verify Associate workflow on Agreement level", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 47: user can not verify Associate workflow on Agreement level", Status.FAIL);
				}
				
				try {
					Assert.assertTrue(util.isElementVisible(colworkflowCreatedFrom));
					util.waitFor(500);
					log("STEP 48: user can see Workflow Created From Column on the Associated Form Grid", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 48: user can not see Workflow Created From Column on the Associated Form Grid", Status.FAIL);
				}
				
				try {
					Assert.assertTrue(util.isElementVisible(workflowCreatedFrom));
					util.waitFor(500);
					log("STEP 49: user can see value 'Application' in the Workflow Created From Column on the Associated Form Grid", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 49: user can not see value 'Application' in the Workflow Created From Column on the Associated Form Grid", Status.FAIL);
				}
	}
			}
				try {
					navigateToMyDashBoard();
					log("STEP 50: user can navigate to Dashboard Page", Status.PASS);
				} catch (Exception e) {
					log("STEP 50: user can not navigate to Dashboard Page", Status.FAIL);
					throw new RuntimeException("Failed in step 50");
				}
				
				try {
					By assignedNotification = By.xpath("//strong[contains(text(),'Workflow ID: "+wfID+": Workflow "+ApprovalType+" is assigned. Please click ')]/..");
					Assert.assertTrue(util.isElementVisible(assignedNotification));
					util.waitFor(500);
					log("STEP 51: user can see Workflow assignment Notification", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 51: user can not see Workflow assignment Notification", Status.FAIL);
				}
				
				try {
					By approvedNotification = By.xpath("//strong[contains(text(),'Workflow ID: "+wfID+": Workflow "+ApprovalType+" is Approved. Please click ')]/..");
					Assert.assertTrue(util.isElementVisible(approvedNotification));
					util.waitFor(500);
					log("STEP 52: user can see Workflow Approval Notification", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 52: user can not see Workflow Approval Notification", Status.FAIL);
				}
			}
	}

	
	

}
