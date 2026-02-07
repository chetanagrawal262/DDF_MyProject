package pages.ParcelDetails;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class TitleOrderFormWorkflowPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	static String parcelNo, ApprovalType;

	public TitleOrderFormWorkflowPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By parcelApprovals = By.xpath("//a[normalize-space()='Parcel Approvals' or normalize-space()='Parcel Forms']");
	By addParcelApprovals = By.xpath(
			"//img[contains(@id,'_idTractInfoApproval_YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By iframeApproval = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@name,'idManageApproval$cbParcelApprovalType')]");
	By txtComments = By.xpath("//*[text()='Comments:']/..//textarea");
	By btnSaveApprovals = By.xpath("//input[contains(@id,'_btnSaveHeader')]");
	By btnSubmitForReviewNew = By.xpath("//input[@id='idManageApproval_YALInLineWorkflowApprove_btnSubmit']");
	By linkTitlePrioritySelection = By.xpath(" //a[text()='Title Priority Selection']");
	By drpHighPriority = By.xpath("//*[text()='High Priority:']/..//input[@type='text']");
	By drpHighPriorityClose = By.xpath(
			"//*[contains(text(),'High Priority:')]/..//a[contains(@id,'YALComboBox_Arrow')]");
	By reviewerComments = By.xpath("//*[text()='Reviewer Comments:']/..//textarea");
	By btnApprove = By.xpath("//input[contains(@id,'btnApprove')]");
	By linkApproved = By.xpath("//a[text()='Approved']");
	By btnCloseForm = By.xpath("//div[contains(@id,'ManageApprovalDialog')]//a[@title='Close']");

	// All tabs
	By tabApproval = By.xpath(
			"//div[@id='idManageApproval_tabStrip']//a[normalize-space()='Approvals' and not(contains(@class,'rtsDisabled'))]");
	By tabAssociatedRecords = By.xpath(
			"//div[@id='idManageApproval_tabStrip']//a[contains(normalize-space(),'Associated Records') and not(contains(@class,'rtsDisabled'))]");
	// Associated records
	By drpAddProjects = By.xpath(
			"//*[contains(text(),'Projects:')]/..//input[@id='idManageApproval_Projects_Input'] | //*[normalize-space()='Projects:']/../following-sibling::tr//input[@id='idManageApproval_Projects_Input']");
	By drpAddProjectsClose = By.xpath(
			"//*[normalize-space()='Projects:']/../following-sibling::tr//a[contains(@id,'Approval_Projects_Arrow')] | //*[contains(text(),'Projects:')]//a[contains(@id,'Approval_Projects_Arrow')]");
	By btnGoProject = By.xpath("//input[@id='idManageApproval_btnGo']");
	By drpListOfTrack = By.xpath(
			"//*[contains(text(),'List of Tract:') or contains(text(),'List of Parcels:') ]/..//input[@id='idManageApproval_Tract_Agreement_Input'] | //*[normalize-space()='List of Tract:']/../following-sibling::tr//input[@id='idManageApproval_Tract_Agreement_Input'] | //*[normalize-space()='List of Parcels:']/../following-sibling::tr//input[@id='idManageApproval_Tract_Agreement_Input']");
	By drpListOfTrackClose = By.xpath(
			"//*[normalize-space()='List of Tract:']/../following-sibling::tr//a[contains(@id,'Tract_Agreement_Arrow')] | //*[normalize-space()='List of Parcels:']/../following-sibling::tr//a[contains(@id,'Tract_Agreement_Arrow')] | //*[contains(text(),'List of Tract:') or contains(text(),'List of Parcels:')]/..//a[contains(@id,'Tract_Agreement_Arrow')]");
	
	By drpListofLeases = By.xpath(
			"//*[contains(text(),'List of Leases:') or contains(text(),'List of Agreements:')]/..//input[@id='idManageApproval_Lease_Association_Input'] | //*[normalize-space()='List of Leases:']/../following::div[@id='idManageApproval_Lease_Association'] | //*[normalize-space()='List of Agreements:']/../following::div[@id='idManageApproval_Lease_Association']");
	By drpListofLeasesClose = By.xpath(
			"//*[contains(text(),'List of Leases:') or contains(text(),'List of Agreements:')]/..//a[@id='idManageApproval_Lease_Association_Arrow'] | //*[normalize-space()='List of Leases:']/../following-sibling::tr//a[@id='idManageApproval_Lease_Association_Arrow'] | //*[normalize-space()='List of Agreements:']/../following-sibling::tr//a[@id='idManageApproval_Lease_Association_Arrow']");
	By btnAddApprovalAssociation = By.xpath("//input[@id='idManageApproval_btnAddApprovalAssociation']");
	By btnRefreshListTract = By.xpath(
			"//table[contains(@id,'idManageApproval_ASSOCIATED_APPROVAL_TRACTS')]//a[contains(@id,'_lnkRefresh')]");
	By listTractMessage = By.xpath("//span[@id='idManageApproval_msgAgreement']");
	By listTractUsrMessage = By.xpath("//span[@id='idManageApproval_ASSOCIATED_APPROVAL_TRACTS_usrMessage']");	
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By tabRequestedDocument = By.xpath("//span[text()='Requested Documents']");
	By drpTitleOrderSelection = By.xpath("//*[contains(text(),'Title Order Status')]/..//input[@type='text']");
	By panelAssociatedForms = By.xpath("//span[text()='Associated Forms']");
	By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
	
   public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
		commonFunction.projectSelection();
  		util.waitUntilElementDisplay(firstParcel);
		util.click(firstParcel);
	}
	 
	public void clickOnAddNewRecord() {
		util.click(addParcelApprovals);
	}
	
	public void selectApprovalType(String value) {
		util.selectValueFromDropdown(drpApprovalType, value);
	}

	public void addComments(String value) {
		if(util.isElementPresent(txtComments)) {
			util.inputText(txtComments, value);
		}
	}
	
	public void clickOnSaveApprovals() {
		util.click(btnSaveApprovals);
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
	

	public void clickOnAdd() {
		util.click(btnAddApprovalAssociation);
	}

	public void refreshListOfTract() {
		util.click(btnRefreshListTract);
	}

	public String getListOfTractMessage() {
		return util.getText(listTractMessage);
	}
	

	public String getListTractUsrMessage() {
		return util.getText(listTractUsrMessage);
	}
	
	public void selectHighPrioirtyParcels(String value) {
			util.selectValueFromDropdown(drpHighPriority, value);
			util.click(drpHighPriorityClose);
	}
	
	public void addReviewerComments(String value) {
		if(util.isElementPresent(reviewerComments)) {
			util.inputText(reviewerComments, value);
		}
	}
	
	public void addTitleOrderFormWorkflow(Map<String, String> map, String testcaseName) {
		
		try {
			navigateParcelInformation();
			log("STEP 1: User can navigate to Parcel Information Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Parcel Information Page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			clickOnAddNewRecord();
			log("STEP 2: Click on Add button under the  Parcel Approvals panels", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Add button on the Parcel Approvals panel", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		try {
			util.waitForWebElementToBePresent(iframeApproval);
			util.switchToIframe(iframeApproval);
			selectApprovalType(map.get(Excel.ApprovalType));
			ApprovalType = map.get(Excel.ApprovalType);
			log("STEP 3: User can select the Title Order Form from Approval Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select the Title Order Form from Approval Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			addComments(map.get("Comment"));
			log("STEP 4: User can enter comments", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter comments", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			clickOnSaveApprovals();
			log("STEP 5: User can click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			clickOnAssociatedRecordsTab();
			log("STEP 6: User can navigate to the associated records tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot navigate to the associated records tab", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			selectProject(map.get(Excel.ProjectName));
			clickOnGoProject();
			log("STEP 7: User can select a project from DD and click on GO button", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot select a project from DD and click on GO button", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}		
        
		try {
			selectListOfTrack(map.get(Excel.ListOfTrack));
			log("STEP 8: User can select a Tract from the Tract list DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot select a Tract from the Tract list DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
		    Thread.sleep(2000);
		    if(!environment.contains("VERDANTERRA")) {
			if(util.isElementPresent(drpListofLeases)) {
			selectListOfLeases(map.get(Excel.ListOfLeases));
			}
		    }
			Thread.sleep(2000);
			clickOnAdd();
			util.waitFor(1000);
			Assert.assertEquals(getListOfTractMessage(), "Requested association created successfully",
					"Success message is mismatch");
			log("STEP 9: User can select a Lease from the Leases list DD and click on Add ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot select a Lease from the Leases list DD and click on Add ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			util.click(tabApproval);
			util.dummyWait(2);
			util.click(btnSubmitForReviewNew);
			log("STEP 10: User can click on submit for review button", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot Click on submit for review button", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
	
		try {
			util.click(linkTitlePrioritySelection);
			util.dummyWait(1);
			log("STEP 11: User can click on Title Prioirty Selection link", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot Click on Title Prioirty Selection link", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		if(util.isElementVisible(drpHighPriority)) {
		try {
			selectHighPrioirtyParcels(map.get("HighPriorityParcel"));
			parcelNo=map.get("HighPriorityParcel");
			log("STEP 12: User can select High Prioirty Parcels from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot select High Prioirty Parcels from the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		}else {
			parcelNo=map.get("HighPriorityParcel");
		}
		
		try {
			addReviewerComments(map.get("Comment"));
			log("STEP 13: User can enter Reviewer Comments", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot enter Reviewer Comments", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			util.click(btnApprove);
			util.waitFor(3000);
			log("STEP 14: User can click on Approve Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot click on Approve Button", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
			util.click(tabApproval);
			util.waitFor(3000);
			if(!util.isElementVisible(linkApproved)) {
				util.click(tabApproval);
				util.dummyWait(1);
			}
			Assert.assertTrue(util.isElementVisible(linkApproved));
			log("STEP 15: Workflow is approved sucessfully", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: User cannot see  Approve Status", Status.FAIL);
		}
		
	}

	public void closeApprovalForm() {
		util.switchToDefaultContent();
		util.click(btnCloseForm);
		util.waitFor(5000);
	}
	
	public void navigateToRequestedDocumentTab() {
		util.click(tabRequestedDocument);
//		driver.navigate().refresh();
		
	}
	   
	public boolean isJobCreated(String status) {
		By jobPath = By.xpath("//table[contains(@id,'Queue_grdDocumentQueue')]//td[text()='"+status+"']");
		return util.isElementPresent(jobPath);
	}
	
	public void verifyApprovedWorkflow(String workflow) {
		
		By locator = By.xpath("//td[text()='Approved']/..//td[text()='" + workflow + "']");
		if (util.isElementPresent(locator)) {
			log("STEP 16:  User can see Approved Workflow on the grid  ", Status.PASS);
		} else {
			log("STEP 16: User cannot see Approved Workflow on the grid ", Status.FAIL);
		}
		
		
		try {
			By associatedParcel = By.xpath("//td[text()='"+parcelNo +"']/parent::tr");
			Assert.assertTrue(util.isElementPresent(associatedParcel, 30), "Assiated parcel record is not displaying");
			util.click(associatedParcel);
			log("STEP 17: User can select Associated parcel from the parcel list", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot select Associated parcel from the parcel list", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
		
		try {
			String titleOrderStatus = util.getAttributeValue(drpTitleOrderSelection, "value");
			Assert.assertEquals(titleOrderStatus, "Order Title");
			log("STEP 18: Title Order Status updated to 'Order Title' Successfully", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: Title Order Status not updated to 'Order Title' ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		
//		try {
//			util.waitUntilElementDisplay(panelAssociatedForms);
//			By workflowName = By.xpath("//*[contains(@id,'AssoInfoApproval_YALWorkflows_radYALGridControl')]/.//td[text()='"+ApprovalType+"']");
//			Assert.assertTrue(util.isElementVisible(workflowName));
//			util.waitFor(500);
//			log("STEP 19: user can see Associate workflow at parcel level", Status.PASS);
//		} catch (AssertionError e) {
//			log("STEP 19: user can not see Associate workflow at parcel level", Status.FAIL);
//		}
		
//		try {
//			commonFunction.navigateToMyDashboard();
//			log("STEP 20: User can navigate to My Dashboard page ", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 20: User cannot navigate to My Dashboard page", Status.FAIL);
//			throw new RuntimeException("Failed in step 20");
//		}
//		
//		try {
//			navigateToRequestedDocumentTab();
//            Assert.assertTrue(isJobCreated("Requested"), "Job is not created");
//			log("STEP 21: Job is created Successfully", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 21: Job is not created for the approved workflow", Status.FAIL);
//			throw new RuntimeException("Failed in step 21");
//		}
		
	}
	

}
