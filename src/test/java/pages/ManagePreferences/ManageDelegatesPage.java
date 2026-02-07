package pages.ManagePreferences;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ManageDelegatesPage extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;

	public ManageDelegatesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By drpAgent = By.xpath("//input[contains(@id,'MSUSERS_YALComboBox_Input') and @type='text']");
    By txtExpirationDate = By.xpath("//input[contains(@id,'dtDelegateDate_dateInput') and @type='text']");
    By ActiveCheckbox = By.xpath("//input[contains(@id,'chkActive') and @type='checkbox']");
    By ActiveCheckboxChecked = By.xpath("//input[contains(@id,'chkActive') and @checked='checked']");
    By btnAdd = By.xpath("//input[contains(@id,'_ImageButton1') and @type='image']");
    By SuccessMessage = By.xpath("//span[text()='Selected users have been assigned!']");
    By btnEdit = By.xpath("(//input[contains(@id,'DELEGATES_radYALGridControl_ctl00_ctl04_EditButton') and @type='image'])[1]");
    By btnUpdate = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate') and @type='submit']");
    
    public void SelectAgent(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressEnter(drpAgent, value);
//    	util.pressDownkey();
//    	util.pressENTERkey();
    	util.dummyWait(1);
    }
    
    By checkboxAgent = By.xpath("//div[contains(@id,'MSUSERS_YALComboBox_DropDown')]/..//li[1]//input[@type='checkbox']");
    By closeAgentDD = By.xpath("//a[contains(@id,'_MSUSERS_YALComboBox_Arrow')]");
    public void SelectAgentRandomly() {
    	util.click(drpAgent);
    	util.click(checkboxAgent);
    	util.click(closeAgentDD);
    }
    
    public void AddExpirationDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExpirationDate,value);
    }
    
    public void ClickOnActiveCheckbox() {
    	if(!util.isElementVisible(ActiveCheckboxChecked)) {
    	util.waitUntilElementDisplay(ActiveCheckbox);
    	util.click(ActiveCheckbox);
    	}
    	util.dummyWait(1);
    }
    
    public void ClickOnAddButton() {
    	util.waitUntilElementDisplay(btnAdd);
    	util.click(btnAdd);
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(SuccessMessage);
    	Assert.assertTrue(util.isElementPresent(SuccessMessage), NA);
    }
    
    public void ClickOnEditButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    }
    
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    }
    
	public void  ManageDelegates(Map<String, String> map,String testcaseName) throws InterruptedException  {
        
		 if (testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
				log(" Manage Delegates not applicable for ALT", Status.SKIP);
			}
			else {
		 try {
			 SelectAgentRandomly();
				log("STEP 1: user can able to select Agent from dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: user not able to select agent from dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
		 try {
			 AddExpirationDate(map.get(Excel.ExpirationDate));
				log("STEP 2: user can able to select Expiration Date from calender  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: user cannot select Expiration date from calender   ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
	
		 try {
			 ClickOnActiveCheckbox();
				log("STEP 3: user can able to select Active checkbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user not able to select Active checkbox  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		
		 try {
			 ClickOnAddButton();
				log("STEP 4: user can able to click on add button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  user not able to click on add button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		 
		 if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 5: \"Selcted user have been assigned\" message should be displayed", Status.PASS);
			} else {
			   log("STEP 5: \"Selcted user have been assigned\" message not displays ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 5 ");
	    	} 
		 
		 try {
			 ClickOnEditButton();
				log("STEP 6: user can able to edit the required information as per requirement ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user not able to edit information        ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
		 
		 try {
			 ClickOnUpdateButton();
				log("STEP 7:  user is able to click on update button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: user not able to click on update button   ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		}
	} 
}
