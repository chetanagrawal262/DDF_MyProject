package pages.ProjectSetup;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewUserAccountPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String USER_NAME, NETWORK_ID;

	public AddNewUserAccountPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By addNewUser = By.xpath("//a[contains(@id,'lnkAddNewRecord')]");
	By txtNetworkID = By.xpath("//input[contains(@id,'EditFormControl_NetworkID') and @type='text']");
	By txtLastName = By.xpath("//input[contains(@id,'EditFormControl_Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'EditFormControl_First_Name') and @type='text']");
	By selectActive = By.xpath("//input[contains(@id,'Active_ind')]");
	By activeChecked = By.xpath("//input[contains(@id,'Active_ind') and @checked='checked']");
	By selectRole = By.xpath("//*[text()='Administrator']/../input[@type='checkbox']");
	By drpDefaultProjectRole = By.xpath("//input[contains(@id,'Default_project_Role_ID_radYALDropDownList_Input') and @type='text']");
	By navAddminitstration = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Administration')] ");
	By navSecurity = By.xpath("//a//span[@class='rmText rmExpandRight' and contains(text(),'Security')]");
	By navUserAccount = By.xpath("//a//span[@class='rmText' and contains(text(),'User Accounts')]");
	By seeAllProjectAssigned = By.xpath("//input[contains(@id,'CanSeeAllProjectsofAssignedArea')]");
	
	public void navigateUserAccount() {
		util.waitUntilElementDisplay(navAddminitstration);
		util.click(navAddminitstration);
		util.waitUntilElementDisplay(navSecurity);
		util.click(navSecurity);
		util.waitUntilElementDisplay(navUserAccount);
		util.click(navUserAccount);
	}

	public void addNetworkID(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtNetworkID, value);
	}

	public void addLastName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLastName, value);
	}

	public void addFirstName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFirstName, value);
	}

	public void clickOnActive() {
		if(!util.isElementVisible(activeChecked))
		util.click(selectActive);
	}

	public void selectRole(String value) {
		if (!commonFunction.checkNA(value)) {
			By selectRole = By.xpath("//*[text()='" + value + "']/../input[@type='checkbox']");
			util.click(selectRole);
		}
	}

	public void selectDefaultProjectRole(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpDefaultProjectRole, value);
	}

	public void selectSeeAllProject() {
		util.click(seeAllProjectAssigned);
	}

	By btnInsert = By.xpath("//input[contains(@id,'btnInsert')]");

	public void clickOnInsert() {
		util.click(btnInsert);
	}

	By btnCancle = By.xpath("//input[contains(@id,'btnCancel')]");

	public void clickOnCancle() {
		util.click(btnCancle);
	}

	By nextPage = By.xpath("//input[@title='Next Page']");

	public void clickOnNextPage() {
		util.click(nextPage);

	}

	public void filterRecord() {
		By editNewUser = By.xpath("//*[contains(text(),'" + NETWORK_ID + "')]/..//input[@alt='Edit']");
		
		  By filterIcon = By.xpath("//input[@type='submit' and contains(@onclick,'NetworkID')]" ); 
		  By txtFilterBox = By.xpath( "//input[contains(@id,'HCFMRTBFirstCond') and @type='text']" ); 
		  By txtFilterBoxROW = By.xpath( "//input[contains(@id,'_FilterTextBox_NetworkID') and @type='text']" ); 
		  By drpFilter = By.xpath( "//input[contains(@id,'HCFMRCMBFirstCond_Input') and @type='text']" ); 
		  By filterOption = By.xpath( "//div[contains(@id,'_HCFMRCMBFirstCond_DropDown')]//li[text()='EqualTo'] | //span[text()='EqualTo']" );
		  By btnFilter = By.xpath( "//input[contains(@id,'HCFMFilterButton')]" );
		  
		  if(util.isElementVisible(txtFilterBoxROW)) {
			  util.inputTextAndPressTab(txtFilterBoxROW, NETWORK_ID); 
			  util.click(filterIcon);
			  util.click(filterOption);
		  }else {
		  if (util.isElementPresent(filterIcon)) { 
			  util.click(filterIcon);
			  util.waitFor(500);
		       util.inputTextAndPressTab(txtFilterBox, NETWORK_ID); 
		       util.click(drpFilter);
		       util.waitFor(500);
		       util.click(filterOption);
		       util.click(btnFilter);
		  
		  } 
		  else { System.out.println("Filter option not present");
		  }
		  
		  }

		util.dummyWait(2);
		util.click(editNewUser);
	}


	By area = By.xpath("(//*[contains(@id,'EditFormControl_AREA')]/..//input[@type='checkbox'])");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	 public void TurnOnDesignMode() {
		 util.waitFor(200);
	    	util.waitUntilElementDisplay(btnDesignMode);
	    	util.click(btnDesignMode);
	    	util.dummyWait(2);
	    }
	   
	   public void SelectUser(String value) {
			if (!commonFunction.checkNA(value)) {
					util.selectValueFromDropdown(drpUser, value);
					
				util.pressENTERkey();
				}
		  }
	   
	   By navTools = By.xpath("//span[contains(text(),'Tools')]");
		By navMyPrefrence = By.xpath("//span[contains(text(),'My Preferences')]");
		By navManagePreferences = By.xpath("//span[contains(text(),'Manage Preferences')]");
		By txtNewPassword = By.xpath("//input[contains(@id,'Password1') and @type='password']");
		By txtConfirmPassword = By.xpath("//input[contains(@id,'Password2') and @type='password']");
		By btnSavePassword = By.xpath("//input[contains(@id,'btnSavePassword') and @type='image']");
		By SuccessMessage = By.xpath("//span[text()='Password has been changed successfully!']");
		By btnLogOff = By.xpath("//input[@alt='Logout']");
		
	   public void NavigatetToManagePreferencesROW() {
			util.waitUntilElementDisplay(navTools);
			util.click(navTools);
			util.waitFor(200);
			util.waitUntilElementDisplay(navMyPrefrence);
			util.hoverOnElement(navMyPrefrence);
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
		
		By txtUsername = By.xpath("//input[@id='UCLogin_inpTxtUserName']"); 
		By txtPassword = By.xpath("//input[@id='UCLogin_inpTxtPassword']");    
		By btnLogin = By.xpath("//input[@id='UCLogin_cmdSubmit_login']");
		By txtUsernameOld = By.xpath("//input[@id='UCLogin_txtUserName']"); 
	    By txtPasswordOld = By.xpath("//input[@id='UCLogin_txtPassword']");
	    By radioAcceptAgreement = By.xpath("//label[contains(text(),'I accept this agreement')]/..//input[@type='radio']");
	    By btnContinue = By.xpath("//input[contains(@id,'_btnGo')]");
	    
		public void login(String uname, String pass) {
			setUserName(uname);
			setPassword(pass);
			util.click(btnLogin);
		}
		
		public void setUserName(String userName) {
			if(util.isElementVisible(txtUsername)) {
			util.inputTextAndPressTab(txtUsername, userName);
			}else {
				util.inputTextAndPressTab(txtUsernameOld, userName);
			}
			
		}

		public void setPassword(String password) {
			if(util.isElementVisible(txtPassword)) {
				util.inputText(txtPassword, password);
			}else {
				util.inputText(txtPasswordOld, password);
			}
		}
		
	public void addNewUser(Map<String, String> map, String testcaseName) {
		try {
			navigateUserAccount();
			log("STEP 1:  Navigate to Menu - User Account", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to Menu - User Account", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			TurnOnDesignMode();
			log("STEP 2:  User Can Turn On Design Mode ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User Cannot Turn On Design Mode ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		USER_NAME=map.get(Excel.LastName)+", "+map.get(Excel.FirstName);
		util.click(drpUser);
		By user= By.xpath("//div[contains(@id,'_YALHD_mockUserID_radYALDropDownList_DropDown')]/..//li[text()='"+USER_NAME+"']");
		
		if(!util.isElementVisible(user)) {
		try {
			commonFunction.clickOnNewRecord();
			log("STEP 3:  User can click on Add New Record", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot click on Add New Record", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			addNetworkID(map.get(Excel.NetworkID));
			log("STEP 4:  Enter Network ID", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User can not enter NetworkID", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		try {
			addLastName(map.get(Excel.LastName));
			log("STEP 5:  Enter LastName", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not enter LastName", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		try {
			addFirstName(map.get(Excel.FirstName));
			log("STEP 6:  Enter FirstName", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User can not enter FirstName", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			clickOnActive();
			log("STEP 7:  Click on Active Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: Not able to Clink on Active Checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			List<WebElement> projectArea=driver.findElements(area);
			for(WebElement var: projectArea) {
				var.click();
			}
			
			log("STEP 8:  Select Client/ Area", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User can not select Client / Area", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			selectRole(map.get(Excel.Roles));
			log("STEP 9:  Select Roles", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User can not select Roles", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			selectSeeAllProject();
			log("STEP 10:  Select See All Project Assigned Area", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User can not select All Project Assigned Area", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		try {
			clickOnInsert();
			log("STEP 11:  Click On Insert", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User can not Click On Insert", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		util.dummyWait(10);

		if(!environment.contains("ORSTED") & !environment.contains("DOMINION")) {
		try {
			util.reloadPage();
			SelectUser(USER_NAME);
			log("STEP 12:  User can select value from the USer DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User can not select value from the USer DD", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}

		if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
			
			try {
				NavigatetToManagePreferencesROW();
				log("STEP 13: user can navigate to manage preference  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: user cannot  navigate to manage preference  ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
		} else {
			try {
				NavigatetToManagePreferences();
				log("STEP 14: user can navigate to manage preference ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: user cannot  navigate to manage preference ", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
		}
		try {
			AddNewPassword(map.get(Excel.Password));
			log("STEP 15: user can add new password", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: user can not add new password", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}

		try {
			AddConfirmPassword(map.get(Excel.Password));
			log("STEP 16: user can update confirm password ",Status.PASS);
		} catch (Exception e) {
			log("STEP 16: user can not update confirm password", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		try {
			ClickOnSave();
			log("STEP 17: user can able to click on save button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user cannot able to click on save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
		try {
			util.click(btnLogOff);
			log("STEP 18: User can log off the application", Status.PASS);
		} catch (Exception e) {
			log("STEP 18:  User cannot log off the application", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}

		try {
			navigateToApplication(appURL);
			login(map.get(Excel.NetworkID), map.get(Excel.Password));
			log("STEP 19: User can logIn the application with New User Account", Status.PASS);
		} catch (Exception e) {
			log("STEP 19:  User cannot logIn the application with New User Account", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		
		if(util.isElementVisible(radioAcceptAgreement)) {
		try {
			util.click(radioAcceptAgreement);
			log("STEP 20: User can select radio button", Status.PASS);
		} catch (Exception e) {
			log("STEP 20:  User cannot select radio button", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		
		try {
			util.click(btnContinue);
			util.dummyWait(1);
			log("STEP 21: User can click on Continue button", Status.PASS);
		} catch (Exception e) {
			log("STEP 21:  User cannot click on Continue button", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
		}
		
		}
		}else {
			log("User Account already present ", Status.SKIP);
		}
	}


	By btnUpdate = By.xpath("//input[contains(@id,'btnUpdate')]");
	By updateMessage = By.xpath("//*[text()='Changes saved successfully!']");

	public void clickOnUpdate() {
		util.click(btnUpdate);
	}

	public void editNewUser(String value) {
		By editNewUser = By.xpath("//*[contains(text(),'" + value + "')]/..//td[1]");
		
		  By pagesize = By.xpath("//input[contains(@id,'ctl00_ConPHRightTop_GridDetails_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_Input')]" ); 
		  System.out.println(""); 
		  By pageSize50 = By.xpath( "//div[contains(@id,'YALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_DropDown')]/div/ul/li[3]" ); 
		  if (util.isElementPresent(pagesize)) { 
			  util.click(pagesize);
		       util.click(pageSize50); 
		       if (!util.isElementPresent(editNewUser)) { By btn =
		  By.xpath(
		  "//*[@id=\"ctl00_ConPHRightTop_GridDetails_radYALGridControl_ctl00\"]/tfoot/tr[2]/td/table/tbody/tr/td[2]/div[1]/input[2]"
		  );
		  
		  util.click(btn); } } 
		  else { System.out.println("Page Size option not shows");
		  }
		 

		util.dummyWait(2);
		util.waitForWebElementToBeClickableReturnElement(editNewUser, IMPLICIT_WAIT);
		util.click(editNewUser);
	}
	
	public void UpdateUserRole(String value) {
		if (!commonFunction.checkNA(value)) {
		By userRoleChecked = By.xpath("//span[text()='"+value+"']/..//input[@type='checkbox' and @checked='checked']");
		By userRoleUnchecked = By.xpath("//span[text()='"+value+"']/..//input[@type='checkbox']");
		
		if(!util.isElementPresent(userRoleChecked)) {
            util.click(userRoleUnchecked);
		}
		}
	}
	   
	public void updateDefaultProjectRole(Map<String, String> map, String testcaseName) {
		try {
			navigateUserAccount();
			log("STEP 1:  Navigate to Menu - User Account", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to Menu - User Account", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try { 
			NETWORK_ID=map.get(Excel.NetworkID);
        	filterRecord();
			log("STEP 2:  User can fitler the record and click on edit button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not fitler the record and cannot click on edit button ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
      if(testcaseName.contains("UserRolePaymentAnalyst")) {
    	  try {
  			util.dummyWait(5);
  			UpdateUserRole(map.get(Excel.SelectRole));
  			log("STEP 3:  Payment Analyst User Role selected", Status.PASS);
  		} catch (Exception e) {
  			log("STEP 3:  User can not select Payment Analyst User Role", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		}
    	  
		}else {  
		try {
			util.dummyWait(5);
			selectDefaultProjectRole(map.get(Excel.SelectRole));
			log("STEP 3:  User can select Default Project Role", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User can not select Default Project Role", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		}
		
		
		try {
			clickOnUpdate();
			util.waitForWebElementToBePresent(updateMessage, 10);
			log("STEP 4: User can Update the record", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot Update the record", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
	}
	
	
	public void addFirstUser(Map<String, String> map, String testcaseName) {
		try {
			navigateUserAccount();
			log("STEP 1:  Navigate to Menu - User Account", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to Menu - User Account", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			TurnOnDesignMode();
			log("STEP 2:  User Can Turn On Design Mode ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User Cannot Turn On Design Mode ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		USER_NAME=map.get(Excel.LastName)+", "+map.get(Excel.FirstName);
		util.click(drpUser);
		By user= By.xpath("//div[contains(@id,'_YALHD_mockUserID_radYALDropDownList_DropDown')]/..//li[text()='"+USER_NAME+"']");
		
		if(!util.isElementVisible(user)) {
		try {
			commonFunction.clickOnNewRecord();
			log("STEP 3:  User can click on Add New Record", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot click on Add New Record", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			addNetworkID(map.get(Excel.NetworkID));
			log("STEP 4:  Enter Network ID", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User can not enter NetworkID", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		try {
			addLastName(map.get(Excel.LastName));
			log("STEP 5:  Enter LastName", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not enter LastName", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		try {
			addFirstName(map.get(Excel.FirstName));
			log("STEP 6:  Enter FirstName", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User can not enter FirstName", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			clickOnActive();
			log("STEP 7:  Click on Active Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: Not able to Clink on Active Checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			List<WebElement> projectArea=driver.findElements(area);
			for(WebElement var: projectArea) {
				var.click();
			}
			
			log("STEP 8:  Select Client/ Area", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User can not select Client / Area", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			selectRole(map.get(Excel.Roles));
			log("STEP 9:  Select Roles", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User can not select Roles", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			selectSeeAllProject();
			log("STEP 10:  Select See All Project Assigned Area", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User can not select All Project Assigned Area", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		try {
			clickOnInsert();
			log("STEP 11:  Click On Insert", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User can not Click On Insert", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		util.dummyWait(10);

		}else {
			log("User Account already present ", Status.SKIP);
		}
	}

}
