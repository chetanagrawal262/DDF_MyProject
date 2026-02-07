package pages.LandownerSearch;

import java.util.Iterator;
import java.util.Set;

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

	By Checkbox = By.xpath("//input[contains(@id,'RadGrid1_ctl00_ctl04_CheckBox1') and @type='checkbox']");
	By ExpandBulkUpdateOptions = By.xpath("(//span[@class='rdExpand'])[1]");
	By MergeRecordCheckbox = By.xpath("//input[contains(@id,'C_BLK_chkLOSearch')]");
	By btnUpdate = By.xpath("//input[contains(@id,'_BLK_btnBulkUpdate')]");
	By radioButton = By.xpath("(//input[contains(@id,'C') and @type='radio'])[1]");
	By btnCompleteMerge = By.xpath("//input[@id='btnCompleteMerge']");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By SuccessMessage = By.xpath("//span[@id='usrMessage']");
    
	public void ClickOnCheckbox() {
		util.waitUntilElementDisplay(Checkbox);
		util.click(Checkbox);
	}
	
	public void ClickOnMergeRecordCheckbox() {
		util.waitUntilElementDisplay(ExpandBulkUpdateOptions);
		util.click(ExpandBulkUpdateOptions);
		util.dummyWait(1);
		util.waitUntilElementDisplay(MergeRecordCheckbox);
		util.click(MergeRecordCheckbox);
		util.click(MergeRecordCheckbox);
	}
	
	public void ClickOnUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.dummyWait(5);
	}
	
	public void ClickOnRadioButton() {
		util.waitUntilElementDisplay(radioButton);
		util.click(radioButton);
	}
	
	public void ClickOnCompleteMergeButton() {
		util.waitUntilElementDisplay(btnCompleteMerge);
		util.click(btnCompleteMerge);
		util.dummyWait(1);
	}
	
	By Arrow = By.xpath("(//span[@class='rdCollapse'])[2]");
	 By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
	    By btnClose = By.xpath("//a[@title='Close']");
	    public void ClickOnOpeninPopupButton() {
	    	WebElement web = driver.findElement(documentgrid);
	    	util.waitUntilElementDisplay(documentgrid);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	    	util.click(btnOpenInPopup);
	    	util.dummyWait(1);
	    	util.click(btnClose);
	    	util.dummyWait(2);
	    	util.click(Arrow);

	    }
	    
	    public void BulkUpdateOption(String testcaseName) {
			try {
				ClickOnCheckbox();
				log("STEP 1: user can check checkbox which is present before project name ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  user cannot check checkbox which is present before project name", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			try {
				ClickOnMergeRecordCheckbox();
				log("STEP 2: User can check/uncheck checkbox ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot check/uncheck checkbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 3: user can click on update button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user cannot click on update button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			Set<String> windowId = driver.getWindowHandles(); // get window id of current window
			Iterator<String> itererator = windowId.iterator();
			String mainWinID = itererator.next();
			String newAdwinID = itererator.next();
			driver.switchTo().window(newAdwinID);
			
			try {
				ClickOnRadioButton();
				log("STEP 4: User can click on option button", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User cannot click on option button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				ClickOnCompleteMergeButton();
				log("STEP 5: User can click on merge  button.", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot click on merge  button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 6 : verify 'Merge Completed successfully! Please refresh the grid on main page to see updated results.' message will be displayed. In green color. ", Status.PASS);
				} else {
				   log("STEP 6: User cannot click on merge  button.", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 6 ");
		   	}
			driver.close();
			util.dummyWait(2);
			driver.switchTo().window(mainWinID);
			util.dummyWait(2);
			
			
			try {
				ClickOnOpeninPopupButton();
				log("STEP 7:  'AMPS:Project dashboard' popup is open with poject information.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  Popup will not be opened. ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
	    }
}
