package pages.tools;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class RejectApplicationLevelWorkflowPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public String ApprovalType = "";

	public RejectApplicationLevelWorkflowPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By btnAddNewRecord = By.xpath("//img[contains(@id,'YALWorkflows_radYALGridControl')]");
	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@name,'idManageApproval$cbParcelApprovalType')]");
	By btnSaveApprovals = By.xpath("//input[contains(@id,'_btnSaveHeader')]");
	By adminReviewLink = By.xpath("//a[text()='Admin Review']");
	By btnSubmitForReview = By.xpath("//input[contains(@id,'WorkflowApprove_btnSubmit')]");
	By btnSubmitForReviewNew = By.xpath("//input[@id='idManageApproval_YALInLineWorkflowApprove_btnSubmit']");
	By iframeApproval = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By btnCloseForm = By.xpath("//div[contains(@id,'ManageApprovalDialog')]//a[@class='rwCloseButton']");
	By rejectButton = By.xpath("//input[contains(@id,'btnReject')]");
	By returnedLink = By.xpath("//a[text()='Returned']");
	// All tabs
	By tabApproval = By.xpath(
			"//div[@id='idManageApproval_tabStrip']//a[normalize-space()='Approvals' and not(contains(@class,'rtsDisabled'))]");
	By navTools = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Tools')] ");
	By navMyDashBoard = By.xpath("*//a//span[contains(text(),'Project Group') or contains(text(),'My Dashboard')] ");
	By navCreateApplicationRequest = By
			.xpath("//a//span[@class='rmText' and contains(text(),'Create Application Requests')] ");
	By reviewComments = By.xpath("//textarea[contains(@id,'txtReviewerComments')]");

	public void navigateToCreateApplicationRequests() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitUntilElementDisplay(navCreateApplicationRequest);
		util.click(navCreateApplicationRequest);
	}

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

	public void closeApprovalForm() {
		util.switchToDefaultContent();
		util.click(btnCloseForm);
		util.waitFor(200);
	}

	public void navigateToMyDashBoard() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitUntilElementDisplay(navMyDashBoard);
		util.click(navMyDashBoard);
	}

	public void addRejectedWorkflow(Map<String, String> map, String testcaseName, String scenario) throws InterruptedException {

		if(scenario.contains("CalendarDays")) {
			ApprovalType = map.get("ApprovalType1");
		}else if(scenario.contains("BusinessDays")) {
			ApprovalType = map.get("ApprovalType2");
		}else {
			ApprovalType = map.get("ApprovalType3");
		}
		
		try {
			navigateToCreateApplicationRequests();
			log("STEP 1: User can navigate to Create Application Requests Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Create Application Requests Page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			ClickOnAddNewRecord();
			log("STEP 2: User can click on Add new record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Add new record button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			selectApprovalType(ApprovalType);
			log("STEP 3: User can Select Work Flow from Approval Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Work Flow from Approval Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			By approverName = By.xpath("(//*[contains(text(),'" + map.get("FieldName1") + "')]/..//input)[1]");
			util.inputTextAndPressTab(approverName, map.get("Approver Name"));
			log("STEP 4: User can enter value in Approver Name field", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter value in Approver Name field", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			By approverEmail = By.xpath("(//*[contains(text(),'" + map.get("FieldName2") + "')]/..//input)[1]");
			util.inputTextAndPressTab(approverEmail, map.get("Approver Email"));
			log("STEP 5: User can enter value in Approver Email field", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot enter value in Approver Email field", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			By comment = By.xpath("(//*[contains(text(),'" + map.get("FieldName3") + "')]/..//textarea)[1]");
			util.inputTextAndPressTab(comment, map.get("Comments"));
			log("STEP 6: User can enter value in comments field", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot enter value in comments field", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			clickOnSaveApprovals();
			log("STEP 7: User can click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			if (util.isElementPresent(btnSubmitForReviewNew)) {
				util.click(btnSubmitForReviewNew);
			} else {
				util.click(btnSubmitForReview);
			}
			log("STEP 8: User can click on submit for review button on the form", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on submit for review button on the form", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}

		try {
			util.waitForWebElementToBeVisible(adminReviewLink, 30);
			util.click(adminReviewLink);
			log("STEP 9: User can click on Admin review link on the form", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot click on Admin review link on the form", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

		try {
			util.dummyWait(2);
			util.inputText(reviewComments, "Testing Reject Scenario");
			log("STEP 10: User can enter Reviewer Comments", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot enter Reviewer Comments", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		try {
			 util.click(rejectButton);
			 util.dummyWait(1);
			log("STEP 11: User can click on Reject Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot click on Reject Button", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}

		try {
			util.click(tabApproval);
			 util.dummyWait(1);
			 if(!util.isElementVisible(rejectButton)) {
				 util.click(tabApproval);
				 util.dummyWait(1);
			 }
			log("STEP 12: User can click on Approval Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot click on Approval Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			util.dummyWait(1);
			Assert.assertTrue(util.isElementVisible(returnedLink));
			log("STEP 13: User can see the Returned link", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 13: User cannot see the Returned link", Status.FAIL);
		}

		try {
			closeApprovalForm();
			util.reloadPage();
			log("STEP 14: user can close the popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user can not close the popup", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}

		try {
			By returnedWF = By.xpath("(//*[text()='"+ApprovalType+"']/..//*[text()='Returned'])[1]");
			Assert.assertTrue(util.isElementVisible(returnedWF));
			log("STEP 15: User can see the Returned WF", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 15: User cannot see the Returned WF", Status.FAIL);
		}
		
		String wfID="";
		if(environment.contains("VALARD")) {
			By returnedWFID = By.xpath("(//*[text()='Returned']/..//*[text()='"+ApprovalType+"']/..//td[10])[1]");
			util.waitUntilElementDisplay(returnedWFID);
			wfID= driver.findElement(returnedWFID).getText();
			util.waitFor(500);
		}else {
		By returnedWFID = By.xpath("(//*[text()='Returned']/..//*[text()='"+ApprovalType+"']/..//td[10])[1]");
		util.waitUntilElementDisplay(returnedWFID);
		wfID= driver.findElement(returnedWFID).getText();
		util.waitFor(500);
		}
	
		if(!environment.contains("WOLFMIDSTREAM")) {
		try {
			navigateToMyDashBoard();
			log("STEP 16: user can navigate to Dashboard Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: user can not navigate to Dashboard Page", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		try {
			By rejectedNotification = By.xpath("//strong[contains(text(),'Workflow ID: "+wfID+": Workflow "+ApprovalType+" is Returned. Please click ')]/..");
			Assert.assertTrue(util.isElementVisible(rejectedNotification));
			util.waitFor(500);
			log("STEP 17: user can see Workflow Rejection Notification", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 17: user can not see Workflow Rejection Notification", Status.FAIL);
		}
		}
	}

}
