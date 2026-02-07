package pages.ProjectSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class BulkUpdateOptionPage extends BasePage{

	
	TestUtil util;
	CommonFunction commonFunction;
 
	public BulkUpdateOptionPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By checkbox = By.xpath("//input[contains(@id,'RadGrid1_ctl00_ctl04_CheckBox1')]");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By ExpandBulkUpdateOption = By.xpath("(//a[@title='Expand'])[1]");
    By ArchiveRadio = By.xpath("(//input[contains(@id,'idSearch_RadDock1_C_BLK')])[2]");
    By btnUpdate = By.xpath("//input[contains(@id,'idSearch_RadDock1_C_BLK_btnBulkUpdate')]");
    By SuccessMesssage = By.xpath("//span[contains(@id,'idSearch_RadDock1_C_BLK_usrMessage')]");

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
    
    public void ClickOnArchiveRadio() {
    	util.waitUntilElementDisplay(ArchiveRadio);
    	util.click(ArchiveRadio);
    }
    
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    }
	
    public void BulkUpdateOption(String testcaseName) {
		
		try {
			ExpandBulkUpdateOption();
			log("STEP 1:  User can expand bulk update option panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:   User cannot expand bulk update option panel   ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		if(testcaseName.contains("DOT")) {
			try {
				ClickOnCheckbox();
				log("STEP 3: user can check checkbox on the search result ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user cannot check checkbox  on the search result", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		}
		else {
		
			if(util.isElementVisible(ArchiveRadio)) {
		try {
			ClickOnArchiveRadio();
			log("STEP 2:  User can select the Archive Radio button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:   User cannot select the Archive Radio button ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}}
		
		try {
			ClickOnCheckbox();
			log("STEP 3: user can check checkbox which is present before project name ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user cannot check checkbox  before project name", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
	}
		try {
			ClickOnUpdateButton();
			log("STEP 4:  user can click on update button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  user cannot click on update button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		if (util.isElementPresent(SuccessMesssage)) {
			   log("STEP 5: Changes saved message will be displayed in green color  ", Status.PASS);
			} else {
			   log("STEP 5: user cannot click on update button.  ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 5 ");
	   	} 
    }
}
