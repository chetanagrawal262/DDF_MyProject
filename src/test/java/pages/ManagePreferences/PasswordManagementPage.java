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

import page.Common.LoginPage;

public class PasswordManagementPage extends BasePage{
	LoginPage objLogin;
	TestUtil util;
	CommonFunction commonFunction;

	public PasswordManagementPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objLogin = new LoginPage(driver);
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
	By SuccessEmail = By.xpath("//span[text()='Email has been changed successfully!']|//span[text()='Contact Info have been changed successfully!']");
	
	By btnDesignMode = By.xpath("//input[contains(@id,'_YALHD_btnDesignModeOff')]");
	By drpCheckbox = By.xpath("//input[contains(@id,'mockUserID_radYALDropDownList_Input')]");
	
	By btnLogout = By.xpath("//input[contains(@id,'LogStatus') and @alt='Logout']");
	By txtUsernameOld = By.xpath("//input[@id='UCLogin_txtUserName']"); 
	By txtPasswordOld = By.xpath("//input[@id='UCLogin_txtPassword']");    
	By txtUsername = By.xpath("//input[@id='UCLogin_inpTxtUserName']"); 
	By txtPassword = By.xpath("//input[@id='UCLogin_inpTxtPassword']");
	By btnLogin = By.xpath("//input[@id='UCLogin_cmdSubmit_login']");
	By Login = By.xpath("//a[contains(@id,'LoginUrl')]");
	public void ClickOnLogOut() {
		util.waitUntilElementDisplay(btnLogout);
		util.click(btnLogout);
		util.dummyWait(1);
	}
	
	public void ClickOnLogin() {
		util.waitUntilElementDisplay(Login);
		util.click(Login);
	}
	public void SetUsername(String value) {
	
		if (!commonFunction.checkNA(value))
			if(util.isElementVisible(txtUsername)) {
				util.inputTextAndPressTab(txtUsername, value);
				}else {
					util.inputTextAndPressTab(txtUsernameOld, value);
				}
	}
	
	public void SetPassword(String value) {
		if (!commonFunction.checkNA(value))
			if(util.isElementVisible(txtPassword)) {
				util.inputText(txtPassword, value);
			}else {
				util.inputText(txtPasswordOld, value);
			}
		util.waitUntilElementDisplay(btnLogin);
		util.click(btnLogin);
		util.dummyWait(2);
	}
	
	public void SelectUser(String value) {
		util.waitUntilElementDisplay(btnDesignMode);
		util.click(btnDesignMode);
		util.dummyWait(2);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCheckbox,value);
	}
			
	
	
	public void NavigatetToManagePreferencesROW() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitFor(200);
		util.waitUntilElementDisplay(navMyPrefrence);
		util.hoverOnElement(navMyPrefrence);
		//util.click(navMyPrefrence);
		
		//util.waitUntilElementDisplay(navManagePreferences);
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
	
	public void  PasswordManagement(Map<String, String> map,String testcaseName) throws InterruptedException  {

		if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
			
      try {
			 NavigatetToManagePreferencesROW();
				log("STEP 2: user can navigate to manage preference  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: user cannot  navigate to manage preference  ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		 
			
			
		 
		}
		else{
			
 	 try {
				 NavigatetToManagePreferences();
					log("STEP 2: user can navigate to manage preference ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: user cannot  navigate to manage preference ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
			 
			 
		}
		
		
		if(!environment.contains("ORSTED")) {
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
			   log("STEP 6 : password changes successfully ", Status.PASS);
			} else {
			   log("STEP 6: Error message should be display", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 6 ");
	    	} 
		
		
		
		util.dummyWait(1);
		try {
			ClickOnLogOut();
				log("STEP 7: user can able to click on LogOut button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: user cannot able to click on LogOut button ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		
			if(util.isElementVisible(Login)) {
			ClickOnLogin();	
			}
		
		
		try {
			SetUsername(map.get(Excel.UserName));
			SetPassword(map.get(Excel.Password));
				log("STEP 8: user can able to login with the updated password  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user cannot able to login with updated password ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
		
		}
		if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {

			util.dummyWait(2);
			 NavigatetToManagePreferencesROW();
		 
		}
		else{
			if(!environment.contains("ORSTED")) {
				util.dummyWait(2);
				 NavigatetToManagePreferences();
			}
		}
		
		if(!environment.contains("ORSTED")) {
		try {
			AddNewPassword(map.get(Excel.UpdatePassword));
				log("STEP 10: user can able to set new password having combination of uppercase characters,lowercase charactors,digits,special charcters   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: user can not able to enter lowercase,uppercase, digits,special charcters  ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
		
		try {
			AddConfirmPassword(map.get(Excel.UpdatePassword));
				log("STEP 11: user can able to set new password having combination of uppercase characters,lowercase charactors,digits,special charcters  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: user can not able to enter lowercase,uppercase, digits,special charcters ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
		
		try {
			ClickOnSave();
				log("STEP 12: user can able to click on save button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: user cannot able to click on save button ", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
		}
		try {
			AddEmail(map.get(Excel.Email));
				log("STEP 13: user can able to enter email in the field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: user not able to enter email in the field ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
		
		try {
			ClickOnSaveButton();
				log("STEP 14: user can able to click on save button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: user cannot able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}


		if (util.isElementPresent(SuccessEmail)) {
			   log("STEP 15 :Email changes successfully", Status.PASS);
			} else {
			   log("STEP 15: Error message should be display", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 15 ");
	    	} 
		
	}
}
