package pages.administrationSecurity;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class PagePermissionUserAccountsPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String USER_NAME,FIRST_NAME, LAST_NAME;

	public PagePermissionUserAccountsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By addNewUser = By.xpath("//a[contains(@id,'lnkAddNewRecord')]");
	By txtNetworkID = By.xpath("//input[contains(@id,'EditFormControl_NetworkID') and @type='text']");
	By txtLastName = By.xpath("//input[contains(@id,'EditFormControl_Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'EditFormControl_First_Name') and @type='text']");
	By txtTitle = By.xpath("//input[contains(@id,'EditFormControl_Title') and @type='text']");
	By selectActive = By.xpath("//input[contains(@id,'Active_ind')]");
	By txtEmail = By.xpath("//input[contains(@id,'Email') and @type='text']");
	By drpContractCompany = By
			.xpath("//input[contains(@id,'_svc_Provider_ID_radYALDropDownList_Input') and @type='text']");

	By selectClient = By.xpath("//*[text()='geoAMPS Power Generation, LLC']/../input[@type='checkbox']");
	By selectRole = By.xpath("//*[text()='Administrator']/../input[@type='checkbox']");
	By txtHomePhone = By.xpath("//input[contains(@id,'EditFormControl_Home_Phone') and @type='text']");
	By txtCellPhone = By.xpath("//input[contains(@id,'EditFormControl_Cell_Phone') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'EditFormControl_Work_Phone') and @type='text']");
	By drpDefaultProjectRole = By
			.xpath("//input[contains(@id,'Default_project_Role_ID_radYALDropDownList_Input') and @type='text']");
	By drpDegaulTrackAssignment = By
			.xpath("//input[contains(@id,'_Default_Tract_Role_ID_radYALDropDownList_Input') and @type='text']");
	By selectProjectAssignmentAre = By
			.xpath("//input[contains(@id,'_CanSeeAllProjectsofAssignedArea') and @type='checkbox']");

	By navAddminitstration = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Administration')] ");
	By navSecurity = By.xpath("//a//span[@class='rmText rmExpandRight' and contains(text(),'Security')]");
	By navUserAccount = By.xpath("//a//span[@class='rmText' and contains(text(),'User Accounts')]");

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
			util.inputTextAndPressTab(txtNetworkID, util.randomNumber());
	}

	public void addLastName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLastName, value);
	}

	public void addFirstName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFirstName, value);
	}

	public void addTitle(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTitle, value);
	}

	public void clickOnActive() {
		util.click(selectActive);
	}

	public void addEmail(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmail, value);
	}

	public void addContractCompany(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpContractCompany, value);
	}

	public void selectClient(String value) {
		if (!commonFunction.checkNA(value)) {
			By selectArea = By.xpath("//*[contains(text(),'" + value + "')]/../input[@type='checkbox']");
			util.click(selectArea);
		}
	}

	public void selectRole(String value) {
		if (!commonFunction.checkNA(value)) {
			By selectRole = By.xpath("//*[text()='" + value + "']/../input[@type='checkbox']");
			util.click(selectRole);
		}
	}

	public void addHomePhone(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtHomePhone, value);
	}

	public void addCellPhone(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCellPhone, value);
	}

	public void addWorkPhone(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtWorkPhone, value);
	}

	public void selectDefaultProjectRole(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpDefaultProjectRole, value);
	}

	public void selectDefaultTractAssignment(String value) {
		if (!commonFunction.checkNA(value)) {
			util.dummyWait(2);
			util.waitForWebElementToBePresent(drpDegaulTrackAssignment, IMPLICIT_WAIT);
			util.inputTextAndPressTab(drpDegaulTrackAssignment, value);
		}
	}

	By seeAllProjectAssigned = By.xpath("//input[contains(@id,'CanSeeAllProjectsofAssignedArea')]");

	public void selectSeeAllProject() {
		util.click(seeAllProjectAssigned);
	}

	By btnInsert = By.xpath("//input[contains(@id,'btnInsert')]");
	By buttonNewRecord = By.xpath("//a[contains(@id,'AddNewRecord')]");
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

	public void refresh(String value) {
		By editNewUser = By.xpath("//*[contains(text(),'" + value + "')]/..//td[1]");
		util.dummyWait(2);
		util.waitForWebElementToBeClickableReturnElement(editNewUser, IMPLICIT_WAIT);
		util.click(editNewUser);
	}

	By btnAddPircture = By.xpath("//img[@alt='Add Picture']");
	By selectPicture = By.xpath("//input[@class='ruButton ruBrowse']");
	By loadDocument = By.xpath("//input[contains(@id,'buttonSubmit_input')]");
	By successMessage = By.xpath("//span[@id='lblResults']");
	By fileUpload = By.xpath("//input[contains(@id,'RadUpload1file') or contains(@id,'rauFileUploadfile')]");
	By iframeDocument = By.xpath("//iframe[@name='UserListDialog']");
	By close = By.xpath("//a[@title='Close']");

	public void addPicture() {
		util.waitForWebElementToBePresent(btnAddPircture, 60);
		util.dummyWait(5);
		util.click(btnAddPircture);
		log("Add Picuture clicked : ", Status.PASS);
		util.waitUntilElementDisplay(iframeDocument);
		util.switchToIframe(iframeDocument);
		util.dummyWait(2);
		log("Switch to frame ", Status.PASS);
		String filepath = System.getProperty("user.dir") + File.separator + "Image2.jpg";
		driver.findElement(fileUpload).sendKeys(filepath);
		util.dummyWait(5);
		log("Uploadfile ", Status.PASS);
		util.waitUntilElementDisplay(loadDocument);
		util.click(loadDocument);
		log("Click on load ", Status.PASS);
		util.dummyWait(10);
		util.waitUntilElementDisplay(successMessage);
		log("Waitfor Message ", Status.PASS);
		util.switchToDefaultContent();
		util.click(close);
	}

	public void uploadFile() {
		String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
		driver.findElement(fileUpload).sendKeys(filepath);
		util.waitFor(5000);
	}

	By loadDocumentFile = By.cssSelector("#buttonSubmit");
	By loadDocumentFile2 = By.xpath("//input[contains(@id,'buttonSubmit_input')]");
	By documentSuccessMessage = By.xpath("//span[@id='lblResults']");
	By btnCloseDocument = By.xpath("//div[contains(@id,'UserListDialog')]//a[@title='Close']");
	By drpCategoryExtDoc = By.xpath("//select[@name='category']");

	public void selectCategory(String value) {
		if (util.isElementPresent(drpCategoryExtDoc)) {
			util.selectValueFromDropdown2(value, drpCategoryExtDoc);
		}
	}

	By description = By.xpath("//input[contains(@id,'RadUpload1Desc') or contains(@id,'rauFileUploadDesc')]");

	public void setDescription(String value) {
		if (util.isElementPresent(description)) {
			util.inputText(description, value);
		}
	}

	public void addExternalDocumentFromIframe() {
		try {
			uploadFile();
			log(" Click on the select button", Status.PASS);
		} catch (Exception e) {
			log(" Click on the select button", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			selectCategory("Docusign Demo");
			log(" Fill in Category", Status.PASS);
		} catch (Exception e) {
			log(" Fill in Category", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			setDescription("Automation comments");
			log(" Fill in Description", Status.PASS);
		} catch (Exception e) {
			log(" Fill in Description", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			if (util.isElementPresent(loadDocumentFile)) {
				util.click(loadDocumentFile);
			} else if (util.isElementPresent(loadDocumentFile2)) {
				util.click(loadDocumentFile2);
			}
			util.waitUntilElementDisplay(documentSuccessMessage);
			String msg = util.getText(documentSuccessMessage);
			Assert.assertEquals(msg, "Loaded: test.txt", "Success message is mismatch");
		} catch (Exception e) {
			log(" Click on the load document button", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
	}

	By navUserRole = By.xpath("//a//span[@class='rmText' and contains(text(),'User Role')]");
	By savePermission = By.xpath("//input[contains(@id,'savePermissions')]");

	public void navigateUserRoles() {
		util.waitUntilElementDisplay(navAddminitstration);
		util.click(navAddminitstration);
		util.waitUntilElementDisplay(navSecurity);
		util.click(navSecurity);
		util.waitUntilElementDisplay(navUserRole);
		util.click(navUserRole);
	}

	By navProjectMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navProjectInformation = By.xpath("*//a//span[contains(text(),'Project Information')] ");

	public void navigateToProjectDeails() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navProjectInformation);
		util.click(navProjectInformation);
	}

	By navProjectDetails = By.xpath("*//a//span[contains(text(),'Project Details')] ");

	public void projectDetailsNotDisplay() {
		if (util.isElementPresent(navProjectDetails) == false)
			;
		log("Project Details tab not display :", Status.PASS);
	}

	By readOnly = By.xpath("//input[contains(@src,'ReadOnly')]");

	public void verifyReadOnly() {
		util.isElementPresent(readOnly, 10);
		log("Read Only button display :", Status.PASS);
	}

	By drpRole = By.xpath("//input[contains(@id,'DISTRIBUTION_Input')]");

	public void selectRoleDD(String value) {
		if (!commonFunction.checkNA(value))
			util.selectDropDownValue(drpRole, value);
	}

	By tabPagePermission = By.xpath("//span[text()='Page Permissions']");

	public void clickOnPagePermission() {
		util.click(tabPagePermission);

	}
	By selectRead = By.xpath("(//span[text()='User Accounts']//following-sibling::table/.//td/input[@value='R'])[1]");
	By selectReadUR = By.xpath("(//span[text()='User Roles']//following-sibling::table/.//td/input[@value='R'])[1]");
	public void selectReadPermission() {
		util.click(selectRead);
		util.dummyWait(1);
		util.click(selectReadUR);
	}

	public void setReadPermission() {
		selectReadPermission();
		util.click(savePermission);
	}
	
	By area = By.xpath("(//*[contains(@id,'EditFormControl_AREA')]/..//input)[1]");
	
	public void addNewUser(Map<String, String> map, String testcaseName) {
		try {
			navigateUserAccount();
			commonFunction.clickOnNewRecord();
			log("STEP 1:  Navigate to Menu - User Account", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to Menu - User Account", Status.FAIL);
			throw new RuntimeException("Failed in step 1: Popup up does not appear");
		}

		try {
			addNetworkID(map.get(Excel.NetworkID));
			log("STEP 2:  Enter Network ID", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not enter NetworkID", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		try {
			LAST_NAME=map.get(Excel.LastName)+util.randomNumber();
			addLastName(LAST_NAME);
			log("STEP 3:  Enter LastName", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User can not enter LastName", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			addFirstName(map.get(Excel.FirstName));
			FIRST_NAME=map.get(Excel.FirstName);
			USER_NAME=LAST_NAME+", "+FIRST_NAME;
			log("STEP 4:  Enter FirstName", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User can not enter FirstName", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			addEmail(map.get(Excel.Email));
			log("STEP 5:  Enter Email", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not enter Email", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		if(environment.contains("TALENENERGY")){
			try {
				util.waitUntilElementDisplay(area);
    			util.click(area);
//				selectClient(map.get(Excel.TalenEnergyArea));
				log("STEP 6:  Select Client", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  User can not select Client", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
		}else {
			
		
		try {
			util.waitUntilElementDisplay(area);
			util.click(area);
//			selectClient(map.get(Excel.Client));
			log("STEP 6:  Select Client", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User can not select Client", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		}
		try {
			selectRole(map.get(Excel.Roles));
			log("STEP 7:  Select Roles", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User can not select Roles", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			clickOnInsert();
			log("STEP 8:  Click On Insert", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User can not Click On Insert", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		util.dummyWait(3);
	}
	
	By btnDesignMode = By.xpath("//input[contains(@id,'_YALHD_btnDesignModeOff')]");
	By drpUser = By.xpath("//input[contains(@id,'mockUserID_radYALDropDownList_Input')]");
	public void SelectUser(String value) {
		util.waitUntilElementDisplay(btnDesignMode);
		util.click(btnDesignMode);
		util.dummyWait(2);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpUser,value);
	}
	
	public void selectPagePermission(Map<String, String> map, String testcaseName) {
		try {
			navigateUserRoles();
			log("STEP 9:  Navigate to Menu - User Roles", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  Not Navigate to Menu - User Roles", Status.FAIL);
			throw new RuntimeException("Failed in step 9:  Not Navigate to Menu - User Roles");
		}
		try {
			selectRoleDD(map.get(Excel.Roles));
			log("STEP 10:  User can select Role", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User can not select Role", Status.FAIL);
			throw new RuntimeException("Failed in step 10:  User can not select Role");
		}
		try {
			clickOnPagePermission();
			log("STEP 11:  User can click on Page Permission", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User can not click on Page Permission", Status.FAIL);
			throw new RuntimeException("Failed in step 11:  User can not click on Page Permission");
		}

		try {
			setReadPermission();
			log("STEP 12:  User can set the Read Page permission to the User Account and User Role Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User cannot set the Read Page permission to the User Account and User Role Page", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}

		util.dummyWait(5);	
		try {
			SelectUser(USER_NAME);
			log("STEP 13:  User can switch to the another user account", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User cannot switch to the another user account", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			navigateUserAccount();
			log("STEP 14:  User can navigate to the User Accounts Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:  User cannot navigate to the User Accounts Page", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
			if(util.isElementVisible(buttonNewRecord)){
				commonFunction.clickOnNewRecord();
				Assert.assertFalse(util.isElementVisible(btnInsert));
        		ExtentTestManager.infoWithScreenshot("User Account Page Verification");
			}else{
			Assert.assertFalse(util.isElementVisible(buttonNewRecord));
			ExtentTestManager.infoWithScreenshot("User Account Page Verification");
			}			
			log("STEP 15:  User cannot click on Add New Record Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:  User can click on Add New Record Button", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
       
//		try {
//			Assert.assertFalse(util.isElementVisible(btnInsert));
//			ExtentTestManager.infoWithScreenshot("User Account Page Verification");
//			log("STEP 16:  Insert button does not display if User Account has Read Permission", Status.PASS);
//		} catch (AssertionError e) {
//			log("STEP 16:  Insert button still display even though the User Account has Read Permission set", Status.FAIL);
//			throw new RuntimeException("Failed in step 16");
//		}
	}
		public void verifyUserRolePagePermission(Map<String, String> map, String testcaseName) {
			
			try {
				navigateUserRoles();
				log("STEP 1:  User can navigate to the User Accounts Page", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot navigate to the User Accounts Page", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			By rChecked = By.xpath("(//span[text()='User Roles']//following-sibling::table/.//td/input[@value='R' and @checked='checked'] )[1]");
			try {
				Assert.assertTrue(util.isElementVisible(rChecked));
				log("STEP 2:  verified R permission set sucessfully", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  R permission does not set", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				Assert.assertFalse(util.isElementVisible(savePermission));
				ExtentTestManager.infoWithScreenshot("User Role Page Verification");
				log("STEP 3:  Save Permission Button does not display", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 3:  Save Permission button still display", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
	       
			
	}

		//#76318
		By RParcelNotes = By.xpath("//div[@class='rtTop defaultPermission']/..//*[text()='Parcel' or text()='Tract']/../..//span[text()='Agent Notes' or text()='Parcel Notes' or text()='Notes']//following-sibling::table/.//td/input[@value='R']");
		By RParcelDocuments = By.xpath("//div[@class='rtTop defaultPermission']/..//*[text()='Parcel' or text()='Tract']/../..//span[text()='Documents']//following-sibling::table/.//td/input[@value='R']");
		By WParcelNotes = By.xpath("//div[@class='rtTop defaultPermission']/..//*[text()='Parcel' or text()='Tract']/../..//span[text()='Agent Notes' or text()='Parcel Notes' or text()='Notes']//following-sibling::table/.//td/input[@value='W']");
		By WParcelDocuments = By.xpath("//div[@class='rtTop defaultPermission']/..//*[text()='Parcel' or text()='Tract']/../..//span[text()='Documents']//following-sibling::table/.//td/input[@value='W']");
		By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
		By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
		By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
		By btnAddNotes = By.xpath("//input[contains(@id,'_TractType_btnAddnotes')] | //input[contains(@id,'_TractType_btnAgentNotes')] | //img[@alt='Add Notes']");
		By btnAddDocuments = By.xpath("//input[contains(@id,'_TractType_btnAdddocuments')] | //input[contains(@id,'_TractType_btnAgentDocs')] | //img[@alt='Add Documents']");
		public void navigateParcelInformation() {
			util.waitUntilElementDisplay(navParcel);
			util.click(navParcel);
			util.waitUntilElementDisplay(navParcelInfo);
			util.click(navParcelInfo);
			util.waitUntilElementDisplay(navParcelInformation);
			util.click(navParcelInformation);
		}
		
		By btnLogOff = By.xpath("//input[@alt='Logout']");
		By hereLinkLogIn = By.xpath("//a[@id='UCLogoff_LoginUrl']");
		By txtUsername = By.xpath("//input[@id='UCLogin_inpTxtUserName']"); 
		By txtPassword = By.xpath("//input[@id='UCLogin_inpTxtPassword']");    
		By btnLogin = By.xpath("//input[@id='UCLogin_cmdSubmit_login']");
		By txtUsernameOld = By.xpath("//input[@id='UCLogin_txtUserName']"); 
	    By txtPasswordOld = By.xpath("//input[@id='UCLogin_txtPassword']"); 
	    
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
		
		public void verifyParcelInformationPagePermission(Map<String, String> map, String testcaseName, String uName, String pass) {
			
			try {
				navigateUserRoles();
				log("STEP 1:  User can navigate to the User Roles Page", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot navigate to the User Roles Page", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
			try {
				selectRoleDD(map.get(Excel.Roles));
				log("STEP 2:  User can select Role", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User can not select Role", Status.FAIL);
				throw new RuntimeException("Failed in step 2:  User can not select Role");
			}
			
			By rChecked = By.xpath("(//span[text()='Parcel Information']//following-sibling::table/.//td/input[@value='R'] )[1] | (//span[text()='Tract Information']//following-sibling::table/.//td/input[@value='R'] )[1] | (//span[text()='Record Information']//following-sibling::table/.//td/input[@value='R'] )[1]");
			try {
				util.click(rChecked);
				log("STEP 3:  User can set R permission for Parcel Information Page", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User cannot set R permission for Parcel Information Page", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				if(!environment.contains("ORION") & !environment.contains("DOMINION")) {
				util.click(WParcelNotes);
				}
				util.click(WParcelDocuments);
				log("STEP 4:  User can set W permission for Parcel Notes and Document Tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User cannot set W permission for Parcel Notes and Document Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				util.click(savePermission);
				log("STEP 5:  User can save permission", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User cannot save permission", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
	       
			try {
	 	  		util.click(btnLogOff);
	 	  		if(util.isElementVisible(hereLinkLogIn)) {
	 	  		util.click(hereLinkLogIn);
	 	  		}
	 	  		else {
	 	  			navigateToApplication(appURL);
	 	  		}
	 				log("STEP 6: User can log off the application", Status.PASS);
	 			} catch (Exception e) {
	 				log("STEP 6:  User cannot log off the application", Status.FAIL);
	 				throw new RuntimeException("Failed in step 6");
	 			}
	     	
	     	try {
	     		    login(uName, pass);
	 				log("STEP 7: User can logIn the application again", Status.PASS);
	 			} catch (Exception e) {
	 				log("STEP 7:  User cannot logIn the application again", Status.FAIL);
	 				throw new RuntimeException("Failed in step 7");
	 			}
	     	
			try {
				navigateParcelInformation();
				log("STEP 8:  User can navigate to Parcel Information", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:  User cannot navigate to Parcel Information", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			if(!environment.contains("ORION") & !environment.contains("DOMINION")) {
			try {
				Assert.assertTrue(util.isElementVisible(btnAddNotes));
				log("STEP 9:  User can see Add Notes Button on Parcel Information Tab", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9:  User cannot see Add Notes Button on Parcel Information Tab", Status.FAIL);
			}
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(btnAddDocuments));
				log("STEP 10:  User can see Add Documents Button on Parcel Information Tab", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10:  User cannot see Add Documents Button on Parcel Information Tab", Status.FAIL);
			}
			
			try {
				navigateUserRoles();
				log("STEP 11:  User can navigate to the User Roles Page", Status.PASS);
			} catch (Exception e) {
				log("STEP 11:  User cannot navigate to the User Roles Page", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				selectRoleDD(map.get(Excel.Roles));
				log("STEP 12:  User can select Role", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:  User can not select Role", Status.FAIL);
				throw new RuntimeException("Failed in step 12:  User can not select Role");
			}
			
			By wChecked = By.xpath("(//span[text()='Parcel Information']//following-sibling::table/.//td/input[@value='W'] )[1] | (//span[text()='Tract Information']//following-sibling::table/.//td/input[@value='W'] )[1] | (//span[text()='Record Information']//following-sibling::table/.//td/input[@value='W'] )[1]");
			try {
				util.click(wChecked);
				log("STEP 13:  User can set W permission for Parcel Information Page", Status.PASS);
			} catch (Exception e) {
				log("STEP 13:  User cannot set W permission for Parcel Information Page", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				if(!environment.contains("ORION") & !environment.contains("DOMINION")) {
				util.click(RParcelNotes);
				}
				util.click(RParcelDocuments);
				log("STEP 14:  User can set R permission for Parcel Notes and Document Tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 14:  User cannot set R permission for Parcel Notes and Document Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			try {
				util.click(savePermission);
				log("STEP 15:  User can save permission", Status.PASS);
			} catch (Exception e) {
				log("STEP 15:  User cannot save permission", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			try {
	 	  		util.click(btnLogOff);
	 	  		if(util.isElementVisible(hereLinkLogIn)) {
	 	  		util.click(hereLinkLogIn);
	 	  		}
	 	  		else {
	 	  			navigateToApplication(appURL);
	 	  		}
	 				log("STEP 16: User can log off the application", Status.PASS);
	 			} catch (Exception e) {
	 				log("STEP 16:  User cannot log off the application", Status.FAIL);
	 				throw new RuntimeException("Failed in step 16");
	 			}
	     	
	     	try {
	     		    login(uName, pass);
	 				log("STEP 17: User can logIn the application again", Status.PASS);
	 			} catch (Exception e) {
	 				log("STEP 17:  User cannot logIn the application again", Status.FAIL);
	 				throw new RuntimeException("Failed in step 17");
	 			}
	     	
			try {
				navigateParcelInformation();
				log("STEP 18:  User can navigate to Parcel Information", Status.PASS);
			} catch (Exception e) {
				log("STEP 18:  User cannot navigate to Parcel Information", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
			
			if(!environment.contains("ORION") & !environment.contains("DOMINION")) {
				try {
					Assert.assertFalse(util.isElementVisible(btnAddNotes));
					log("STEP 19:  User cannot see Add Notes Button on Parcel Information Tab", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 19:  User can see Add Notes Button on Parcel Information Tab", Status.FAIL);
				}
				}
				
				try {
					Assert.assertFalse(util.isElementVisible(btnAddDocuments));
					log("STEP 20:  User cannot see Add Documents Button on Parcel Information Tab", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 20:  User can see Add Documents Button on Parcel Information Tab", Status.FAIL);
				}
				
				try {
					navigateUserRoles();
					log("STEP 21:  User can navigate to the User Roles Page", Status.PASS);
				} catch (Exception e) {
					log("STEP 21:  User cannot navigate to the User Roles Page", Status.FAIL);
					throw new RuntimeException("Failed in step 21");
				}
				
				try {
					selectRoleDD(map.get(Excel.Roles));
					log("STEP 22:  User can select Role", Status.PASS);
				} catch (Exception e) {
					log("STEP 22:  User can not select Role", Status.FAIL);
					throw new RuntimeException("Failed in step 22:  User can not select Role");
				}
				
				try {
					if(!environment.contains("ORION") & !environment.contains("DOMINION")) {
					util.click(WParcelNotes);
					}
					util.click(WParcelDocuments);
					log("STEP 23:  User can set W permission for Parcel Notes and Document Tab", Status.PASS);
				} catch (Exception e) {
					log("STEP 23:  User cannot set W permission for Parcel Notes and Document Tab", Status.FAIL);
					throw new RuntimeException("Failed in step 23");
				}
				
				try {
					util.click(savePermission);
					log("STEP 24:  User can save permission", Status.PASS);
				} catch (Exception e) {
					log("STEP 24:  User cannot save permission", Status.FAIL);
					throw new RuntimeException("Failed in step 24");
				}
	}

}
