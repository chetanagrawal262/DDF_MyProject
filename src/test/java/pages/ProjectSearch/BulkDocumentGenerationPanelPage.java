package pages.ProjectSearch;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class BulkDocumentGenerationPanelPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public BulkDocumentGenerationPanelPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By ExpandPanel = By.xpath("(//em[text()='Bulk Document Generation']/..//span)[2]");
	By Checkbox = By.xpath("(//tr[contains(@id,'_idSearch_grdSearchResults')]/..//input[@type='checkbox'])[1]");
	By SelectTemplate = By.xpath("(//input[contains(@id,'BULKQ_chkTemplates')])[1]");
	By SelectReportFormat = By.xpath("//label[contains(text(),'Word 2007 & Newer')]/..//input[2]");
	By drpPriority = By.xpath("//select[@id='ctl00_ConPHRightTop_idSearch_rdBulkDocs_C_BULKQ_ddlPriority']");
	By CheckboxAddDocument = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_rdBulkDocs_C_BULKQ_chkAttach']");
    By AddEmail = By.xpath("//textarea[contains(@id,'_BULKQ_txtEmails')]");
    By btnGenerateDocument = By.xpath("//input[contains(@id,'_BULKQ_btnSubmit')]");
    By SuccessMessage = By.xpath("//span[text()='Job Created!  Your job number is: ']");
    By LinkJobNumber = By.xpath("//span[@id='ctl00_ConPHRightTop_idSearch_rdBulkDocs_C_BULKQ_lblSuccessMsg']//a");
    By btnCancel = By.xpath("//input[@id='RadDock3_C_btnCmd']");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By btnclose = By.xpath("//a[@title='Close']");
    By errorMsg = By.xpath("//span[text()='Please select at least one project to generate documents.']");

    public void ClickOnExpandPanel() {
    	util.waitUntilElementDisplay(ExpandPanel);
    	util.click(ExpandPanel);
    }
    
    public void RightClickOnDocumentGrid() {
    	WebElement web = driver.findElement(documentgrid);
    	util.waitUntilElementDisplay(documentgrid);
    	Actions act = new Actions(driver);
    	act.moveToElement(web).contextClick().build().perform();
    }

    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
    By btnClose = By.xpath("//input[contains(@title,'Close')]");
    public void ClickOnOpeninPopupButton() {
    	util.dummyWait(1);
    	util.click(btnOpenInPopup);
    	util.dummyWait(1);
    	util.click(btnClose);
    }
    

    public void ClickOnCheckbox() {
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
			util.inputTextAndPressTab(drpPriority, value);
    }
    
    public void ClickOnAddDocumentCheckbox() {
         util.waitUntilElementDisplay(CheckboxAddDocument);
         util.click(CheckboxAddDocument);
    }
    
    public void AddEmail(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(AddEmail, value);
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
    
   
    public void BulkDocumentGenerationPanel(Map<String, String> map, String testcaseName) {
    	util.dummyWait(1);
		try {
			ClickOnExpandPanel();
			log("STEP 1: User can expand bulk document generation panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand bulk document generation panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
//			ClickOnCheckbox();
			log("STEP 2: User can select record on the project search", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select record on the project search", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			SelectTemplate();
			log("STEP 3:  User can select template", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select template ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			SelectReportFormat();
			log("STEP 4: User can select Report Format", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select Report Format", Status.FAIL);
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
			log("STEP 6: User can uncheck Add Document Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot uncheck Add Document Checkbox", Status.FAIL);
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
			if(util.isElementVisible(errorMsg)) {
				ClickOnCheckbox();
				ClickOnGenerateDocument();
			}
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
		
		try {
			ClickOnJobNumberLink();
			log("STEP 10: User can click on job number link  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot click on job number link ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		util.waitFor(500);
		
		Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		Iterator<String> itererator = windowId.iterator();
		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();
		driver.switchTo().window(newAdwinID);

		if(util.isElementVisible(btnCancel)) {
		try {
			ClickOnCancelButton();
			log("STEP 11: User can click on Cancel button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot click on Cancel  button ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		}
		util.waitFor(500);
		try {
			ClickOnCloseButton();
			log("STEP 12: User can click on Close button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot click on Close  button ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		driver.switchTo().window(mainWinID);
		util.dummyWait(2);
		
    }
}
