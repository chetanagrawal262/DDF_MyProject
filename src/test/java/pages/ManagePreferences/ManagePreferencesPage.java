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

public class ManagePreferencesPage extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;

	public ManagePreferencesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navTools = By.xpath("//span[contains(text(),'Tools')]");
	By navMyPrefrence = By.xpath("//span[contains(text(),'My Preferences')]");
	By navManagePreferences = By.xpath("//span[contains(text(),'Manage Preferences')]");
	By txtNewPassword = By.xpath("//input[contains(@id,'Password1') and @type='password']");
	By txtConfirmPassword = By.xpath("//input[contains(@id,'Password2') and @type='password']");
	By btnSavePassword = By.xpath("//input[contains(@id,'btnSavePassword') and @type='image']");
	By txtEmail = By.xpath("//input[contains(@id,'userEmail') and @type='text']");
	By btnSaveEmail = By.xpath("//input[contains(@id,'SaveAddInfo') and @type='image']");
	By SuccessMessage = By.xpath("//span[text()='Password has been changed successfully!']");
	By SuccessEmail = By.xpath("//span[text()='Email has been changed successfully!']");
	
	public void NavigatetToManagePreferencesROW() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitUntilElementDisplay(navMyPrefrence);
		util.click(navMyPrefrence);
		util.waitUntilElementDisplay(navManagePreferences);
		util.click(navManagePreferences);
	}
	
	public void NavigatetToManagePreferences() {
		util.waitUntilElementDisplay(navMyPrefrence);
		util.click(navMyPrefrence);
		util.waitUntilElementDisplay(navManagePreferences);
		util.click(navManagePreferences);
	}
	
	public void AddNewPassword(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtNewPassword,value);
	}
	
	public void AddConfirmPassword(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtConfirmPassword,value);
	}
	
	public void ClickOnSave() {
	     util.waitUntilElementDisplay(btnSavePassword);
	     util.click(btnSavePassword);
	     util.dummyWait(3);
	     util.waitUntilElementDisplay(SuccessMessage);
	     Assert.assertTrue(util.isElementPresent(SuccessMessage), "Password has been changed successfully!");
	}
	
	public void AddEmail(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmail,value);
	}
	
	public void ClickOnSaveButton() {
	     util.waitUntilElementDisplay(btnSaveEmail);
	     util.click(btnSaveEmail);
	     util.dummyWait(3);
	     util.waitUntilElementDisplay(SuccessEmail);
	     Assert.assertTrue(util.isElementPresent(SuccessEmail), "Email has been changed successfully!");
	}
	
	public void  ManagePreferences(Map<String, String> map,String testcaseName) throws InterruptedException  {

		if(testcaseName.contains("ROW")) {
		 try {
			 NavigatetToManagePreferencesROW();
				log("STEP 1: user can navigate to manage preference  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: user cannot  navigate to manage preference  ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		}
		else{
			 try {
				 NavigatetToManagePreferences();
					log("STEP 1: user can navigate to manage preference ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: user cannot  navigate to manage preference ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
		}
		
		try {
			AddNewPassword(map.get(Excel.Password));
				log("STEP 3: user can able to set new password having combination of uppercase characters,lowercase charactors,digits,special charcters   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user can not able to enter lowercase,uppercase, digits,special charcters  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		
		try {
			AddConfirmPassword(map.get(Excel.Password));
				log("STEP 4: user can able to set new password having combination of uppercase characters,lowercase charactors,digits,special charcters  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: user can not able to enter lowercase,uppercase, digits,special charcters ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		
		try {
			ClickOnSave();
				log("STEP 5: user can able to click on save button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user cannot able to click on save button ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
		
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 5 : password changes successfully ", Status.PASS);
			} else {
			   log("STEP 5: Error message should be display", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 5 ");
	    	} 
		
		try {
			AddEmail(map.get(Excel.Email));
				log("STEP 6: user can able to enter email in the field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user not able to enter email in the field ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
		
		try {
			ClickOnSaveButton();
				log("STEP 7: user can able to click on save button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: user cannot able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}


		if (util.isElementPresent(SuccessEmail)) {
			   log("STEP 7 :Email changes successfully", Status.PASS);
			} else {
			   log("STEP 7: Error message should be display", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 7 ");
	    	} 
	}
}
