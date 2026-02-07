package pages.LeaseSearch;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;



public class BulkDocumentGenerationPanelPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public BulkDocumentGenerationPanelPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By ExpandPanel = By.xpath("//span[@class='rdExpand']");
	By Checkbox = By.xpath("//input[contains(@id,'_CheckBox1')]");
	By SelectTemplate = By.xpath("//input[contains(@id,'BULKQ_chkTemplates_0')]");	
	By SelectReportFormat = By.xpath("//label[contains(text(),'Word 2007 & Newer')]");
	By drpPriority = By.xpath("//select[@id='ctl00_ConPHRightTop_idSearch_rdBulkDocs_C_BULKQ_ddlPriority']");
	By CheckboxAddDocument = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_rdBulkDocs_C_BULKQ_chkAttach']");
    By AddEmail = By.xpath("//textarea[contains(@id,'_BULKQ_txtEmails')]");
    By btnGenerateDocument = By.xpath("//input[contains(@id,'_BULKQ_btnSubmit')]");
    By SuccessMessage = By.xpath("//span[text()='Job Created!  Your job number is: ']");
    By LinkJobNumber = By.xpath("//span[@id='ctl00_ConPHRightTop_idSearch_rdBulkDocs_C_BULKQ_lblSuccessMsg']//a");
    By btnClose = By.xpath("//input[contains(@title,'Close')]");
    By btnCancel = By.xpath("//input[@id='RadDock3_C_btnCmd']");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
    By btnclose = By.xpath("//a[@title='Close']");

    public void ClickOnExpandPanel() {
    	util.waitUntilElementDisplay(ExpandPanel);
    	util.click(ExpandPanel);
    }
    
    public void ClickOnLeaseCheckbox() {
    	util.waitUntilElementDisplay(Checkbox);
    	util.click(Checkbox);
    }
    
    public void SelectTemplate() {
    	util.waitUntilElementDisplay(SelectTemplate);
    	util.click(SelectTemplate);
    }
    
    
    public void SelectReportFormat() {
    	util.waitUntilElementDisplay(SelectReportFormat);
    	util.click(SelectReportFormat);
    }
    
    public void SelectPriority(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputText(drpPriority, value);
    }
    
    public void ClickOnAddDocumentCheckbox() {
         util.waitUntilElementDisplay(CheckboxAddDocument);
         util.click(CheckboxAddDocument);
    }
    
    public void AddEmail(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputText(AddEmail, value);
   }
    
    public void ClickOnGenerateDocument() {
    	util.waitUntilElementDisplay(btnGenerateDocument);
    	util.click(btnGenerateDocument);
    	util.dummyWait(1);
   }

    public void ClickOnJobNumberLink() {
    	util.waitUntilElementDisplay(LinkJobNumber);
    	util.click(LinkJobNumber);
    }
    
    public void ClickOnCancelButton() {
    	util.waitUntilElementDisplay(btnCancel);
    	util.click(btnCancel);
    }
    
    public void ClickOnCloseButton() {
    	util.waitUntilElementDisplay(btnClose);
    	util.click(btnClose);
    }
    
    public void ClickOnOpeninPopupButton() {
    	WebElement web = driver.findElement(documentgrid);
    	util.waitUntilElementDisplay(documentgrid);
    	Actions act = new Actions(driver);
    	act.moveToElement(web).contextClick().build().perform();
    	util.waitUntilElementDisplay(btnOpenInPopup);
    	util.click(btnOpenInPopup);
    	util.dummyWait(1);
    	util.click(btnClose);
    }
    
    public void OpenInCurrentWindowButton() {
    	WebElement web = driver.findElement(documentgrid);
    	util.waitUntilElementDisplay(documentgrid);
    	Actions act = new Actions(driver);
    	act.moveToElement(web).contextClick().build().perform();
    	util.click(btnOpenInCurrentWindow);
    	util.dummyWait(2);
    	
    
    }
    By btnOpenInCurrentWindow = By.xpath("//span[contains(text(),'Open in current window')]");

    By navTools = By.xpath("//span[contains(text(),'Tools')]");
    By navMyDashboard = By.xpath("//span[contains(text(),'My Dashboard')]");
    By navRequestedDocument = By.xpath("//span[contains(text(),'Requested Documents')]");
    By getstrjobNo = By.xpath("//tr[contains(@id,'grdDocumentQueue_ctl00__0')]//td[1]");
    By getstrjobNoROW = By.xpath("//tr[contains(@id,'grdDocumentQueue_ctl00__0')]//td[1]");

    By JobNoGrid = By.xpath("//tr[contains(@id,'grdDocumentQueue_ctl00__0')]");
    
    public void NevigateToRequestedDocument() {
    	util.waitUntilElementDisplay(navTools);
    	util.click(navTools);
    	if(!util.isElementVisible(navMyDashboard)) {
    		util.hoverOnElement(navTools);
    	}
    	util.waitUntilElementDisplay(navMyDashboard);
    	util.click(navMyDashboard);
    	util.waitUntilElementDisplay(navRequestedDocument);
    	util.click(navRequestedDocument);
    	util.dummyWait(1);
    }
    
    private void JobNo() {
		String jobNo = util.getText(getstrjobNo);
		ExtentTestManager.info("User typed: " + jobNo);
		util.dummyWait(1);
	
	}
    
    private void JobNoRow() {
		String jobNo = util.getText(getstrjobNoROW);
		ExtentTestManager.info("User typed: " + jobNo);
		util.dummyWait(1);
	
	}
    
    public void BulkDocumentGeneration(Map<String, String> map, String testcaseName) {
		try {
			ClickOnExpandPanel();
			log("STEP 1: User can expand bulk document generation panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand bulk document generation panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			ClickOnLeaseCheckbox();
			log("STEP 2: User can check/uncheck checkbox from Lease search result. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot check/uncheck checkbox from Leaset search result. ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			SelectTemplate();
			log("STEP 3:  User can check/uncheck checkbox. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot check/uncheck checkbox.     ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			SelectReportFormat();
			log("STEP 4: User can select value from given optioin button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select value from given option button.", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			SelectPriority(map.get(Excel.Priority));
			log("STEP 5: User can select value from Priority dd ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user not able to select value from Priority DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			ClickOnAddDocumentCheckbox();
			log("STEP 6: User can check/uncheck checkbox.   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot check/uncheck checkbox. ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			AddEmail(map.get(Excel.Email));
			log("STEP 7: User can enter value in Email textbox  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot enter value in Email textbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			ClickOnGenerateDocument();
			log("STEP 8: User can click on generate document button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on generate document button ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 9 :'Job Created! Your job number is:XXXXX ' message will be displayed.  ", Status.PASS);
			} else {
			   log("STEP 9: User cannot click on generate document button.  ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 9 ");
	   	} 
		
		String LinkJobNo = util.getText(LinkJobNumber);
		ExtentTestManager.info("System Created Job Number is " + LinkJobNo);
		util.dummyWait(1);
		
		try {
			ClickOnJobNumberLink();
			log("STEP 10: User can click on job number link  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot click on job number link ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		Iterator<String> itererator = windowId.iterator();
		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();
		driver.switchTo().window(newAdwinID);

		
//		try {
//			ClickOnCancelButton();
//			log("STEP 11: User can click on Cancel button ", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 11: User cannot click on Cancel  button ", Status.FAIL);
//			throw new RuntimeException("Failed in step 11");
//		}
		
		try {
			ClickOnCloseButton();
			log("STEP 11: User can click on Close button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot click on Close  button ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		driver.switchTo().window(mainWinID);
		util.dummyWait(2);
		
		try {
			NevigateToRequestedDocument();
			log("STEP 12: User can NavigateTo Requested Document ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot NavigateTo Requested Document ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
		String jobNo = util.getText(getstrjobNo);
		ExtentTestManager.info("Requested Document tab  Job Number is " + jobNo);

		if (LinkJobNo.equals(jobNo)) {
			System.out.println(LinkJobNo.equals(jobNo));
			System.out.println("Job Number  Matched !!!");
			log("STEP 13: Job Number  Matched !!!", Status.PASS);
		} else {
			System.out.println("Job Number  Not Matched !!!");
			log("STEP 13: Job Number  Not Matched !!!", Status.FAIL);
	    }
		JobNo();
	}
		else {
			String jobNoROW = util.getText(getstrjobNoROW);
			ExtentTestManager.info("Requested Document tab  Job Number is " + jobNoROW);

			if (LinkJobNo.equals(jobNoROW)) {
				System.out.println(LinkJobNo.equals(jobNoROW));
				System.out.println("Job Number  Matched !!!");
				log("STEP 13: Job Number  Matched !!!", Status.PASS);
			} else {
				System.out.println("Job Number  Not Matched !!!");
				log("STEP 13: Job Number  Not Matched !!!", Status.FAIL);
		    }
			JobNoRow();
		}
		if (util.isElementPresent(JobNoGrid)) {
			   log("STEP 14 : Created job displayed in job# filed ", Status.PASS);
			} else {
			   log("STEP 14 :  Created job not displayed in job# filed  ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 14 ");
	   	} 
		
		util.dummyWait(1);
		
    }

}
