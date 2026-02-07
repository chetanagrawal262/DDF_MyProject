package pages.Administration_ReportAdministration;

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

public class ReportScheduler_AddNewReportSchedulerPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public String REPORT_NAME, FIRST_EXECUTION_DATE;

	public ReportScheduler_AddNewReportSchedulerPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navAdministration = By.xpath("//span[text()='Administration']");
	By navReportAdministraion = By.xpath("//span[contains(text(),'Reports Administration')]");
	By navReportScheduler = By.xpath("(//span[text()='Reports Scheduler'])[1]");
	By btnAddNew = By.xpath("//input[contains(@id,'btnAdd')]");
	By iframe = By.xpath("//iframe[@name='EditReportScheduler']");
	By drpReport = By.xpath("//input[contains(@id,'rcbReports_Input')]");
	By ActiveCheckbox = By.xpath("//input[contains(@id,'chkActive')]");
	By drpReportFormat = By.xpath("//input[contains(@id,'cbReportFormat_YALComboBox_Input')]");
	By txtFirstExecution = By.xpath("//input[contains(@id,'dp_Actual_Date_dateInput') and @type='text']");
	By drpHour = By.xpath("//select[contains(@id,'ddlHour')]");
	By drpMinute = By.xpath("//select[contains(@id,'ddlMin')]");
    By drpAMPM = By.xpath("//select[contains(@id,'ddlAMPM')]");	
    By txtEmailSelected = By.xpath("//input[contains(@id,'txtEmailSubject')and @type='text']");
    By txtEmailMassage = By.xpath("//textarea[contains(@id,'txtEmailBody')]");
    By drpEmailToApplicationUserRole = By.xpath("//input[contains(@id,'cbUserRoles_YALComboBox_Input')]");
    By txtEmailTo = By.xpath("//textarea[contains(@id,'txtEmailTo')]");
    By drpAdditionalExecution = By.xpath("//input[contains(@id,'cbSchedulerType_YALComboBox_Input')]");
    By txtEvery = By.xpath("//input[contains(@id,'txtEvery')and @type='text']");
    By btnInsert = By.xpath("//input[contains(@id,'btnInsert')and @type='submit']");
	By btnCancel = By.xpath("//input[contains(@id,'btnCancel')and @type='submit']");
	By SuccessMessage = By.xpath("//span[text()='Report has been scheduled.']");
	By btnClose = By.xpath("//a[@title='Close']");
	By PDFIcon = By.xpath("//img[contains(@id,'GenGridScheduleReports_radYALGridControl_ctl00_ctl02_ctl00_Img2')]");
	By EXCELIcon = By.xpath("//img[contains(@id,'GenGridScheduleReports_radYALGridControl_ctl00_ctl02_ctl00_Img3')]");
	By navTools = By.xpath("//span[contains(text(),'Tools')]");
	By navMyDashboard =By.xpath("//span[contains(text(),'My Dashboard')]");
	By navInbox = By.xpath("//span[contains(text(),'Inbox')]");
	By documentGrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_YALCOM_InMessages_RadGrid1_ctl00__0']");
	By drpProject = By.xpath("(//td[text()='Project']/../..//input[@type='text'])[1]");
	By drpParcelType = By.xpath("(//td[text()='Parcel Type']/../..//input[@type='text'])[2]");
	By optionSelectAll = By.xpath("//*[text()='Select All']//input[@type='checkbox']");
	By closeParcelTypeDD = By.xpath("(//td[text()='Parcel Type']/../..//a)[2]");
	By colLink = By.xpath("//a[text()='Link']");
	By iframeReportHistory = By.xpath("//iframe[@name='ReportSchedulerViewHistory']");
	By colScheduledDate = By.xpath("//a[text()='Scheduled Date']");
	By colGeneratedDate = By.xpath("//a[text()='Generated Date']");
	By colGenerationStatus = By.xpath("//a[text()='Report Generation Status/Error']");
	By colEmailsDelivered = By.xpath("//a[text()='Emails Delivered']");
	By colEmailsFailedToDelivered = By.xpath("//a[text()='Emails Failed to Deliver']");
	By colViewReport = By.xpath("//a[text()='View Report']");
	
	public void NavigateToReportScheduler() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navReportAdministraion);
		util.click(navReportAdministraion);
		util.waitUntilElementDisplay(navReportScheduler);
		util.click(navReportScheduler);
	}
	
	public void ClickOnAddNewButton() {
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.dummyWait(2);
		util.switchToIframe(iframe);
	}
	
	public void SelectReport(String value) {
		if(util.isElementPresent(drpReport)) {
			util.click(drpReport);
			util.selectDropDownValue(drpReport, value);
		}
	}
	
	public void ClickOnActiveCheckbox() {
		util.waitUntilElementDisplay(ActiveCheckbox);
		util.click(ActiveCheckbox);
		util.click(ActiveCheckbox);

	}
	
	public void SelectReportFormat(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpReportFormat, value);
	}
	
	public void AddFirstExecutionDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFirstExecution, value);
	}
	
	public void AddHour(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpHour, value);
	}
	
	public void AddMinute(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpMinute, value);
	}
	
	public void AddAMPM(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAMPM, value);
	}
	
	public void AddEmailSelected(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmailSelected, value);
	}
	
	public void AddEmailMassage(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmailMassage, value);
	}
	
	public void SelectEmailToApplicationUserRole(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEmailToApplicationUserRole, value);
	}
	
	public void AddEmailTo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmailTo, value);
	}
	
	public void AddAdditionalExecution(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAdditionalExecution, value);
	}
	
	public void AddEvery(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEvery, value);
	}
	
	public void ClickOnInsert() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.dummyWait(2);
	}
	
	public void ClickOnCancel() {
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
	util.dummyWait(2);
	util.switchToDefaultContent();
	util.click(btnClose);
	}
	
	public void ClickOnPDFIcon() {
		util.waitUntilElementDisplay(PDFIcon);
		util.click(PDFIcon);
	}
	
	public void ClickOnEXCELIcon() {
		util.waitUntilElementDisplay(EXCELIcon);
		util.click(EXCELIcon);
	}
	
	public void SelectProject(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpProject, value);
	}
	
	public void SelectParcelType() {
		util.click(drpParcelType);
		util.click(optionSelectAll);
		util.click(closeParcelTypeDD);
	}
	
	public void AddNewReportScheduler(Map<String, String> map, String testcaseName) {
		try {
			NavigateToReportScheduler();
			log("STEP 1:  User can click on report scheduler  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User is unable to click on report scheduler", Status.FAIL);
			throw new RuntimeException("Failed in step 1: Popup up does not appear");
		}
		
		try {
			ClickOnAddNewButton();
			log("STEP 2:  User can click on add new button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User is unable to click on add new button.", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		

		try {
			SelectReport(map.get(Excel.Report));
			REPORT_NAME=map.get(Excel.Report);
			log("STEP 3: User can select any value from Report dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot select any value from Report dd", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		

		try {
			ClickOnActiveCheckbox();
			log("STEP 4:  User can click on active checkbox ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot click on active checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			SelectReportFormat(map.get(Excel.ReportFormat));
			log("STEP 5:  User can select any value from Report Format dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User cannot select any value from Report Format dd", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		try {
			AddFirstExecutionDate(map.get(Excel.FirstExecution));
			FIRST_EXECUTION_DATE=map.get(Excel.FirstExecution);
			log("STEP 6: User can select the First Execution Date  Date ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select the First Execution Date  Date", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		try {
			AddHour(map.get(Excel.Hour));
			log("STEP 7: User can select time ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot select time ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			AddMinute(map.get(Excel.Minute));
			log("STEP 8: User can select time", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User can not enter time", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		try {
			AddAMPM(map.get(Excel.AM_PM));
			log("STEP 9: User can select time in AM/PM format", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User  cannot select  time from dd", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		try {
			AddEmailSelected(map.get(Excel.EmailSubject)+" - "+environment);
			log("STEP 10: User can enter a value in the Email Subject field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot enter a value in the Email Subject field", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			AddEmailMassage(map.get(Excel.EmailMessage));
			log("STEP 11: User can enter a value in the Email Message field  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot enter a value in the Email Message field ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		try {
			SelectEmailToApplicationUserRole(map.get(Excel.UserRoles));
			log("STEP 12: User can select any value from Email To Application User Role dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot select any value from Email To Application User Role dd", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		try {
			AddEmailTo(map.get(Excel.Email));
			log("STEP 13: User can enter a value in the text EmailTo field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot enter a value in the text EmailTo field", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		try {
			AddAdditionalExecution(map.get(Excel.AdditionalExecution));
			log("STEP 14: User can select any value from Additional Execution dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot select any value from Additional Execution dd", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
			AddEvery(map.get(Excel.Every));
			log("STEP 15:  User can enter a value in the  Every field", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:  User cannot enter a value in the  Every field", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		try {
			ClickOnInsert();
			log("STEP 16:  User can click on insert button", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:  User cannot click on insert button ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 17 :Message - 'Report has been scheduled.!' in green displays .   ", Status.PASS);
			} else {
			   log("STEP 17: User cannot click on insert button "  , Status.FAIL);
	   	    } 
		
		try {
			String actFirstExecutionDate=util.getAttributeValue(txtFirstExecution, "value");
			Assert.assertEquals(actFirstExecutionDate,FIRST_EXECUTION_DATE);
			log("STEP 18:  User can see correct First Execution Date after record saved ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 18:  User cannot see Correct First Execution Date after record saved ", Status.FAIL);
		}
		
		try {
			ClickOnCancel();
			log("STEP 19:  User can click on cancel button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: User cannot click on cancel button ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}

	}
	
	public void DuplicateRecord(Map<String, String> map, String testcaseName) {
		
		try {
			util.dummyWait(1);
			Assert.assertTrue(util.isElementVisible(colLink));
			log("STEP 19: User can see Link column present on grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 19: User cannot see Link column present on grid", Status.FAIL);
		}
		
		try {
			By linkDuplicate = By.xpath("//tr[contains(@id,'idAllReports_YalManageReportSchedulerDetails_GenGridScheduleReports_radYALGridControl_')]//td[text()='"+REPORT_NAME+"']/..//a[text()='Duplicate']");
			util.click(linkDuplicate);
			util.dummyWait(2);
			log("STEP 20: User can click on Duplicate link", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: User cannot click on Duplicate link", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		
		try {
			util.switchToIframe(iframe);
			SelectReport(map.get("DuplicateReport"));
			util.dummyWait(1);
			log("STEP 21: User can select any value from Report dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 21:  User cannot select any value from Report dd", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
		
		try {
			SelectProject(map.get(Excel.ProjectName));
			log("STEP 22: User can select Project", Status.PASS);
		} catch (Exception e) {
			log("STEP 22:  User cannot select Project", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
		
		try {
			SelectParcelType();
			log("STEP 23: User can select Parcel Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 23:  User cannot select Parcel Type", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		
		try {
			ClickOnInsert();
			log("STEP 24:  User can click on insert button", Status.PASS);
		} catch (Exception e) {
			log("STEP 24:  User cannot click on insert button ", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		
		util.switchToDefaultContent();
		util.click(btnClose);
		util.dummyWait(3);
		
		try {
			By duplicatedReport = By.xpath("//tr[contains(@id,'idAllReports_YalManageReportSchedulerDetails_GenGridScheduleReports_radYALGridControl_')]//td[text()='"+map.get("DuplicateReport")+"']");
			Assert.assertTrue(util.isElementVisible(duplicatedReport));
			log("STEP 25: User can see duplicated report record added on grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 25: User cannot see duplicated report record added on grid", Status.FAIL);
		}
		
		try {
			By linkForDuplicatedReport = By.xpath("//tr[contains(@id,'idAllReports_YalManageReportSchedulerDetails_GenGridScheduleReports_radYALGridControl_')]//td[text()='"+map.get("DuplicateReport")+"']/..//a[text()='Duplicate']");
			Assert.assertTrue(util.isElementVisible(linkForDuplicatedReport));
			log("STEP 26: User can see duplicated link for duplicated record as well", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 26: User cannot see duplicated link for duplicated record", Status.FAIL);
		}
		
		try {
			By linkPreviousExecution = By.xpath("//tr[contains(@id,'idAllReports_YalManageReportSchedulerDetails_GenGridScheduleReports_radYALGridControl_')]//td[text()='"+REPORT_NAME+"']/..//a[text()='View Previous 30 Executions']");
			Assert.assertTrue(util.isElementVisible(linkPreviousExecution));
			log("STEP 27: User can see View Previous 30 Execution link for first added report", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 27: User cannot see View Previous 30 Execution link for first added report", Status.FAIL);
		}
		
		try {
			By linkPreviousExecution = By.xpath("//tr[contains(@id,'idAllReports_YalManageReportSchedulerDetails_GenGridScheduleReports_radYALGridControl_')]//td[text()='"+map.get("DuplicateReport")+"']/..//a[text()='View Previous 30 Executions']");
			Assert.assertTrue(util.isElementVisible(linkPreviousExecution));
			log("STEP 28: User can see View Previous 30 Execution link for duplicated report as well", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 28: User cannot see View Previous 30 Execution link for duplicated report", Status.FAIL);
		}
		
		try {
			By linkReportHistory = By.xpath("//tr[contains(@id,'idAllReports_YalManageReportSchedulerDetails_GenGridScheduleReports_radYALGridControl_')]//td[text()='"+REPORT_NAME+"']/..//a[text()='View Previous 30 Executions']");
			util.click(linkReportHistory);
			util.dummyWait(2);
			util.switchToIframe(iframeReportHistory);
			log("STEP 29: User can click on View Previous 30 Execution link", Status.PASS);
		} catch (Exception e) {
			log("STEP 29: User cannot click on View Previous 30 Execution link", Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(colScheduledDate));
			log("STEP 30: User can see scheduled date column on the report hostory grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 30: User cannot see scheduled date column on the report hostory grid", Status.FAIL);
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(colGeneratedDate));
			log("STEP 31: User can see Generated date column on the report hostory grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 31: User cannot see Generated date column on the report hostory grid", Status.FAIL);
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(colGenerationStatus));
			log("STEP 32: User can see Report Generation Staus/Error column on the report hostory grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 32: User cannot see Report Generation Staus/Error column on the report hostory grid", Status.FAIL);
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(colEmailsDelivered));
			log("STEP 33: User can see Emails Delivered column on the report hostory grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 33: User cannot see Emails Delivered column on the report hostory grid", Status.FAIL);
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(colEmailsFailedToDelivered));
			log("STEP 34: User can see Emails Failed To Delivered column on the report hostory grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 34: User cannot see Emails Failed To Delivered column on the report hostory grid", Status.FAIL);
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(colViewReport));
			log("STEP 35: User can see View Report column on the report hostory grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 35: User cannot see View Report column on the report hostory grid", Status.FAIL);
		}
		util.switchToDefaultContent();
		util.click(btnClose);
	}
	
}
