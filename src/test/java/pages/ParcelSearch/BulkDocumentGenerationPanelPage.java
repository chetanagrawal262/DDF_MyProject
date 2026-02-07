package pages.ParcelSearch;

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
	
	By checkbox = By.xpath("//input[contains(@id,'RadGrid1_ctl00_ctl04_CheckBox1')]");
	By ExpandPanel = By.xpath("(//span[@class='rdExpand'])[1]");
	By Checkbox = By.xpath("//input[contains(@id,'_CheckBox1')]");
	By SelectTemplate = By.xpath("(//label[contains(text(),'Summary')])[1]");
	By SelectTemplateDot = By.xpath("//input[contains(@id,'_BULKQ_chkTemplates_0')]");
	By SelectReportFormat = By.xpath("//label[contains(text(),'Word 2007 & Newer')]");
	By drpPriority = By.xpath("//select[@id='ctl00_ConPHRightTop_idSearch_rdBulkDocs_C_BULKQ_ddlPriority']");
	By CheckboxAddDocument = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_rdBulkDocs_C_BULKQ_chkAttach']");
    By AddEmail = By.xpath("//textarea[contains(@id,'_BULKQ_txtEmails')]");
    By btnGenerateDocument = By.xpath("//input[contains(@id,'_BULKQ_btnSubmit')]");
    By SuccessMessage = By.xpath("//span[text()='Job Created!  Your job number is: ']");
    By LinkJobNumber = By.xpath("//span[@id='ctl00_ConPHRightTop_idSearch_rdBulkDocs_C_BULKQ_lblSuccessMsg']//a");
    By btnCancel = By.xpath("//input[@id='RadDock3_C_btnCmd']");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
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
    
    public void SelectTemplateDot() {
    	util.waitUntilElementDisplay(SelectTemplateDot);
    	util.click(SelectTemplateDot);
    }
    
    
    public void SelectReportFormat() {
    	util.waitUntilElementDisplay(SelectReportFormat);
    	util.click(SelectReportFormat);
    }
    
    public void SelectPriority(String value) {
    	util.click(drpPriority);
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
    
    public void RightClickOnDocumentGrid() {
    	WebElement web = driver.findElement(documentgrid);
    	util.waitUntilElementDisplay(documentgrid);
    	Actions act = new Actions(driver);
    	act.moveToElement(web).contextClick().build().perform();
    }
    By message = By.xpath("//span[text()='Please select at least one tract to generate documents.']");
    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
    By btnClose = By.xpath("//input[contains(@title,'Close')]");
    public void ClickOnOpeninPopupButton() {
    	util.dummyWait(1);
    	util.click(btnOpenInPopup);
    	util.dummyWait(1);
    	util.click(btnclose);
    }
    
    public void ClickOnCheckbox() {
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(checkbox);
    	util.click(checkbox);
    }
    
    public void BulkDocumentGenerationPanel(Map<String, String> map, String testcaseName) {
    	
       try {
			ClickOnExpandPanel();
			log("STEP 1: User can expand bulk document generation panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand bulk document generation panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			ClickOnLeaseCheckbox();
			log("STEP 2: User can check/uncheck checkbox from  search result. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot check/uncheck checkbox from  search result. ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		if(testcaseName.contains("DOT")) {
			try {
				SelectTemplateDot();
				log("STEP 3:  User can select Template", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select Template ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		}
		else {
			try {
				SelectTemplate();
				log("STEP 3:  User can select Template", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select Template ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		}
		
		
		try {
			SelectReportFormat();
			log("STEP 4: User can select Report Format ", Status.PASS);
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
			log("STEP 6: User can select Add Documents to Documents Tab checkbox ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select Add Documents to Documents Tab checkbox ", Status.FAIL);
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
		
		if(util.isElementPresent(message)) {
			util.click(Checkbox);
			ClickOnGenerateDocument();
		}
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 9 :'Job Created! Your job number is:XXXXX ' message displayed.  ", Status.PASS);
			} else {
			   log("STEP 9: Sucess message does not display ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 9");
	   	} 
		
		try {
			ClickOnJobNumberLink();
			log("STEP 10: User can click on job number link  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot click on job number link ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		

		util.dummyWait(2);
           util.switchToChildWindow();
		
        try {
			ClickOnCloseButton();
			log("STEP 11: User can click on Close button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot click on Close  button ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		util.switchToParentWindow();
		util.dummyWait(2);
	
    }
}
