package pages.ParcelSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class BulkUpdateOptionDOTPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public BulkUpdateOptionDOTPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By checkbox = By.xpath("//input[contains(@id,'RadGrid1_ctl00_ctl04_CheckBox1')]");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By ExpandBulkUpdateOption = By.xpath("(//a[@title='Expand'])[1]");
    By btnUpdate = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_RadDock1_C_BLK_btnBulkUpdate']");
	
    
    public void ExpandBulkUpdateOption() {
    	util.waitUntilElementDisplay(ExpandBulkUpdateOption);
    	util.click(ExpandBulkUpdateOption);
    }
    
    public void ClickOnCheckbox() {
    	util.waitUntilElementDisplay(checkbox);
    	util.click(checkbox);
    }
    
    public void RightClickOnDocumentGrid() {
    	WebElement web = driver.findElement(documentgrid);
    	util.waitUntilElementDisplay(documentgrid);
    	Actions act = new Actions(driver);
    	act.moveToElement(web).contextClick().build().perform();
    }

    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
    By btnClose = By.xpath("//a[@title='Close']");
    public void ClickOnOpeninPopupButton() {
    	util.dummyWait(1);
    	util.click(btnOpenInPopup);
    	util.dummyWait(1);
    	util.click(btnClose);
    }
    
    By SuccessMessage = By.xpath("//span[@id='ctl00_ConPHRightTop_idSearch_RadDock1_C_BLK_usrMessage']");
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    }
    
    public void BulkUpdateOption(String testcaseName) {
    	 if (testcaseName.contains("ALT") || testcaseName.contains("ROW") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
				log(" Bulk Update Option DOT not applicable for ALT and ROW", Status.SKIP);
			}
			else {
    	
		try {
			ClickOnCheckbox();
			log("STEP 1: user can check checkbox which is present before project name ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: user cannot check checkbox  before project name", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			ExpandBulkUpdateOption();
			log("STEP 2:  User can expand bulk update option panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:   User cannot expand bulk update option panel   ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			ClickOnUpdateButton();
			log("STEP 3:  user can click on update button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  user cannot click on update button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 4 :Change(s) saved! Message will be display in green color.  ", Status.PASS);
			} else {
			   log("STEP 4: user cannot click on update button.  ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 4 ");
	   	} 
    }
    }
}
