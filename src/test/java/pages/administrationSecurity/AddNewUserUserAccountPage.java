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

import extentReports.ExtentManager;
import extentReports.ExtentTestManager;
import pages.InfoByParcelReport.AddProjectPage;

public class AddNewUserUserAccountPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String NETWORK_ID, USER_NAME,FIRST_NAME, LAST_NAME, AREA, PROJECT_ROLE, TRACT_ASSIGNMENT, PAGE_COUNT;

	public AddNewUserUserAccountPage(WebDriver driver) {
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
	By addProjectAssigment = By.xpath("//a[normalize-space()='Project Assignments'] | //a[normalize-space()='Project Team']");
	By ErrorMsgEmail = By.xpath("//span[contains(text(),'Invalid e-mail address.')]");
	
	
	public void setPagesize(){
		By pagesize = By.xpath("//input[contains(@id,'ProjectAssignments_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_Input')]");
		System.out.println("");
		By pageSize50 = By.xpath("//div[contains(@id,'ProjectAssignments_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_DropDown')]/div/ul/li[3]");
		if(util.isElementPresent(pagesize)){
			util.click(pagesize);
			util.click(pageSize50);
		}
		else{
			System.out.println("Page Size option not shows");
		}
		
	}
	
	By totalPages = By.xpath("//table[@summary='Data pager which controls on which page is the RadGrid control.']//strong[2]");
	
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
			NETWORK_ID=util.randomNumber();
			util.inputTextAndPressTab(txtNetworkID, NETWORK_ID);
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
	
	By defaultProjectRole = By.xpath("//div[contains(@id,'EditFormControl_Default_project_Role_ID_radYALDropDownList_DropDown')]/..//li[last()-1]");
	public void selectDefaultProjectRole() {
		util.click(drpDefaultProjectRole);

	        util.click(defaultProjectRole);
	}

	public void selectDefaultTractAssignment(String value) {
		if (!commonFunction.checkNA(value)) {
			util.dummyWait(2);
			util.waitForWebElementToBePresent(drpDegaulTrackAssignment, IMPLICIT_WAIT);
			util.inputTextAndPressTab(drpDegaulTrackAssignment, value);
		}
	}

	By defaultTractAssignment = By.xpath("(//div[contains(@id,'_EditFormControl_Default_Tract_Role_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	public void selectDefaultTractAssignment() {
		util.click(drpDegaulTrackAssignment);
		TRACT_ASSIGNMENT= driver.findElement(defaultTractAssignment).getText();
	        util.click(defaultTractAssignment);
	}
	
	By seeAllProjectAssigned = By.xpath("//input[contains(@id,'CanSeeAllProjectsofAssignedArea')]");

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
		 
		  util.waitUntilLoaderDisappear();
		util.waitForWebElementToBeClickableReturnElement(editNewUser, IMPLICIT_WAIT);
		util.click(editNewUser);
	}
	
	public void filterRecord() {
		By editNewUser = By.xpath("//*[contains(text(),'" + NETWORK_ID + "')]/..//td[1]");
		
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

	By activeCheckBox= By.xpath("//input[contains(@id,'EditFormControl_Active_ind')]");
	By autoAssignCheckbox= By.xpath("//input[contains(@id,'_EditFormControl_chkAutoAssign')]");
	By area = By.xpath("(//*[contains(@id,'EditFormControl_AREA')]/..//input)[1]");
	By areaText = By.xpath("(//*[contains(@id,'EditFormControl_AREA')]/..//input)[1]/..//span");
	By role = By.xpath("(//*[contains(@id,'EditFormControl_ROLES')]/..//span[contains(text(),'Administrator')]/..//input)[1]");
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
			util.click(activeCheckBox);
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
			addTitle(map.get(Excel.Title));
			log("STEP 5:  Enter Title", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not enter Title", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		try {
			clickOnActive();
			log("STEP 6:  Click on Active Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: Not able to Clink on Active Checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			addEmail(map.get(Excel.Email));
			log("STEP 7:  Enter Email", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User can not enter Email", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		try {
			addContractCompany(map.get(Excel.ContractorCompany));
			log("STEP 8:  Enter ContractorCompany", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User can not enter ContractorCompany", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		try {
			addHomePhone(map.get(Excel.HomePhone));
			log("STEP 9:  Enter HomePhone", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User can not enter HomePhone", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		try {
			addCellPhone(map.get(Excel.CellPhone));
			log("STEP 10:  Enter CellPhone", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User can not enter CellPhone", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		try {
			addWorkPhone(map.get(Excel.WorkPhone));
			log("STEP 11:  Enter WorkPhone", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User can not enter WorkPhone", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		try {
//			util.waitUntilElementDisplay(area);
//			util.click(area);
			AREA=AddProjectPage.AREA;
			selectClient(AREA);
			log("STEP 12:  Select Client", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User can not select Client", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			util.waitUntilElementDisplay(role);
			util.click(role);
			//selectRole(map.get(Excel.Roles));
			log("STEP 13:  Select Roles", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User can not select Roles", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		try {
			selectDefaultProjectRole();
			log("STEP 14:  Select DefaultProjectRole", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:  User can not select DefaultProjectRole", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		if(util.isElementVisible(drpDegaulTrackAssignment)) {
		try {
			selectDefaultTractAssignment();
			log("STEP 15:  Select DefaultTractAssignment", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:  User can not select DefaultTractAssignment", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		}
		
		try {
			if(util.isElementVisible(autoAssignCheckbox)) {
				util.click(autoAssignCheckbox);
				util.waitFor(300);
			}
			selectSeeAllProject();
			log("STEP 16:  Select See All Project Assigned Area", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:  User can not select All Project Assigned Area", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		try {
			clickOnInsert();
			util.waitUntilLoaderDisappear();
			log("STEP 17:  Click On Insert", Status.PASS);
		} catch (Exception e) {
			log("STEP 17:  User can not Click On Insert", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}

		try { 
          	filterRecord();
			addPicture();
			log("STEP 18:  User can fitler the record and update the picture", Status.PASS);
		} catch (Exception e) {
			log("STEP 18:  User can not fitler the record or update the picture", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
	}

	By btnUpdate = By.xpath("//input[contains(@id,'btnUpdate')]");
	By updateMessage = By.xpath("//*[text()='Changes saved successfully!']");

	public void clickOnUpdate() {
		util.click(btnUpdate);
	}

	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	By drpArea = By.xpath("//input[contains(@id,'yalPrjArea_radYALDropDownList_Input')]");
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
	   
	public void updateNewUser(Map<String, String> map, String testcaseName) {
		try {
			util.dummyWait(10);
			editNewUser(map.get(Excel.LastName));
			util.waitUntilLoaderDisappear();
			log("STEP 19:  Existing User Open ", Status.PASS);
		} catch (Exception e) {
			log("STEP 19:  Existing User not Open", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		
		if(util.isElementVisible(drpDegaulTrackAssignment)) {
		try {
			
			selectDefaultTractAssignment(map.get(Excel.DefaultTractAssignment));
			TRACT_ASSIGNMENT=map.get(Excel.DefaultTractAssignment);
	//		clickOnUpdate();
	//		util.waitForWebElementToBePresent(updateMessage, 20);
			log("STEP 20:  User can Update New User ", Status.PASS);
		} catch (Exception e) {
			log("STEP 20:  User can not Update New User", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		}
		//enhancement for US #59413
		
		PROJECT_ROLE= util.getAttributeValue(drpDefaultProjectRole, "value");
		System.out.println("Project Role: "+PROJECT_ROLE);
		
		try {
			addEmail(map.get(Excel.EmailUpdate));
			clickOnUpdate();
			log("STEP 21:  User can enter invalid email Address", Status.PASS);
		} catch (Exception e) {
			log("STEP 21:  User can not enter Email", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
		
		try {
			util.isElementVisible(ErrorMsgEmail);
			log("STEP 22: User can see Error msg 'Invalid e-mail address' for the emails with domain greater than 4 characters" , Status.PASS);
		} catch (Exception e) {
			log("STEP 22: User cannot see Error msg 'Invalid e-mail address' for the emails with domain greater than 4 characters", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
		
		try {
			addEmail(map.get(Excel.EmailUpdate1));
			clickOnUpdate();
			util.waitForWebElementToBePresent(updateMessage, 10);
			log("STEP 23: User can Update the email field with valid email address  like domain upto 4 characters  in email field", Status.PASS);
		} catch (Exception e) {
			log("STEP 23:  User cannot Update the email field with valid email address  like domain upto 4 characters  in email field", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		//
		try {
			TurnOnDesignMode();
			log("STEP 24:  user can turn on design mode", Status.PASS);
		} catch (Exception e) {
			log("STEP 24:  user cannot turn on design mode", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		} 
        
        try {
        	SelectUser(USER_NAME);
        	System.out.println("User Name: "+USER_NAME);
        	util.dummyWait(2);
			log("STEP 25:  user can switch to Newly Created User", Status.PASS);
		} catch (Exception e) {
			log("STEP 25:  user cannot switch to Newly Created User ", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		} 
        
        try {
        	commonFunction.navigateToProjectDeails();
        	commonFunction.selectProjectNew(AddProjectPage.PN);
			log("STEP 26  user can navigate to project details page", Status.PASS);
		} catch (Exception e) {
			log("STEP 26:  user cannot navigate to project details page", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		} 
        
        try {
        	String area=util.getAttributeValue(drpArea, "value").trim();
        	Assert.assertEquals(area, AREA.trim());
        	ExtentTestManager.infoWithScreenshot("Project in Assigned Areas");
			log("STEP 27:  user can see projects in Assigned Area", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 27:  user cannot see projects in Assigned Area", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		}
        
        try {
        	util.click(addProjectAssigment);
        	setPagesize();
			util.dummyWait(5);
			log("STEP 28:  User can expand Project Assignments panel", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 28:  user cannot expand Project Assignments panel", Status.FAIL);
			throw new RuntimeException("Failed in step 28");
		}
        
        if(util.isElementVisible(totalPages)) {
        	PAGE_COUNT= util.getText(totalPages);
        	By nextPage = By.xpath("//input[contains(@id,'ProjectAssignments_radYALGridControl')]/..//input[@title='Next Page']");
        	for(int i=1; i<Integer.parseInt(PAGE_COUNT); i++) {
        		By defaultProjectAssignment = By.xpath("//td[contains(text(),'" + USER_NAME.trim() + "')]/..//td[contains(text(),'"+PROJECT_ROLE.trim()+"')]");
        		if(util.isElementVisible(defaultProjectAssignment)) {
        			break;
        		}else {
        			util.click(nextPage);
        			util.dummyWait(3);
        		}
        	}
        	
        	try {
            	By defaultProjectAssignment = By.xpath("//td[contains(text(),'" + USER_NAME.trim() + "')]/..//td[contains(text(),'"+PROJECT_ROLE.trim()+"')]");
            	Assert.assertTrue(util.isElementVisible(defaultProjectAssignment));
    			log("STEP 29:  Default Project Assignment Successfully added", Status.PASS);
    		} catch (AssertionError e) {
    			log("STEP 29 Default Project Assignment not added", Status.FAIL);
    		}
        }else {
        try {
        	By defaultProjectAssignment = By.xpath("//td[contains(text(),'" + USER_NAME.trim() + "')]/..//td[contains(text(),'"+PROJECT_ROLE.trim()+"')]");
        	Assert.assertTrue(util.isElementVisible(defaultProjectAssignment));
			log("STEP 29:  Default Project Assignment Successfully added", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 29 Default Project Assignment not added", Status.FAIL);
		}
        }
	}

	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navAssignment = By.xpath("//div[contains(@id,'RadYALMenu')]/../..//span[text()='Assignments']");
	By navAssignmentdot = By.xpath("//div[contains(@id,'RadYALMenu')]/../..//span[text()='Assignments']");

	public void NavigateToAssignmentTab() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navAssignment);
		util.click(navAssignment);
		
	}
	
	public void NavigateToAssignmentTabDot() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navAssignmentdot);
		util.click(navAssignmentdot);
		
	}
	
	By btnAdd = By.xpath("//input[contains(@id,'_ImageButton1') and @type='image']");
    By successmessageforAlt = By.xpath("//span[text()='Selected users have been assigned!']");
    By successmessageforDot = By.xpath("//span[text()='Selected user(s) have been assigned!']");
    
	public void ClickOnAddButton() {
    	util.waitUntilElementDisplay(btnAdd);
    	util.click(btnAdd);
     	util.waitUntilElementDisplay(successmessageforAlt);
     	util.dummyWait(5);
    	Assert.assertTrue(util.isElementPresent(successmessageforAlt), "Selected users have been assigned!");
    	util.dummyWait(2);
    }
    
    public void ClickOnAddButtonForDot() {
    	util.waitUntilElementDisplay(btnAdd);
    	util.click(btnAdd);
    	util.dummyWait(10);
    	util.waitUntilElementDisplay(successmessageforDot);
    	Assert.assertTrue(util.isElementPresent(successmessageforDot), "Selected user(s) have been assigned!");
    	util.dummyWait(2);
    }
    
    public void ClickOnAddButtonForRow() {
    	util.waitUntilElementDisplay(btnAdd);
    	util.click(btnAdd);
    	util.dummyWait(2);
    }
    
    By drpAgents = By.xpath("//input[contains(@id,'_MSUSERS_MSDropDown_Input') and @type='text']");
    By drpAgentsDot = By.xpath("//input[contains(@id,'_MSUSERS_YALComboBox_Input') and @type='text']");
    By drpAgentRow = By.xpath("//input[contains(@id,'_MSUSERS1_YALComboBox_Input')]");
    
    public void SelectAgentForAlt(String value) {
        if (!commonFunction.checkNA(value))
			util.selectValueFromDropdown(drpAgents, value);
  	  util.click(drpAgents);
  	  util.pressENTERkey();
  }
  
  
  public void SelectAgentForDot(String value) {
  	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgentsDot, value);
  	  util.click(drpAgentsDot);
  	  util.pressENTERkey();
  }
  
  public void SelectAgentForRow(String value) {
  	util.waitUntilElementDisplay(drpAgentRow);
  	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgentRow, value);
  	util.click(drpAgentRow);
	  util.pressENTERkey();
  }
  
	public void verifyTractAssignment(String testcaseName) {
		if (testcaseName.contains("DOT")|| testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")){
			 try {
				 NavigateToAssignmentTabDot();
	 	    		util.dummyWait(10);
					log("STEP 1: User can navigate to the Assignment tab  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: Assignment tab does not load ", Status.FAIL);
					throw new RuntimeException("Failed in step 1 ");
				}
		  }
			 else {
				 try {
					 NavigateToAssignmentTab();
		 	    		util.dummyWait(10);
						log("STEP 1: User can navigate to the Assignment tab  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 1: Assignment tab does not load ", Status.FAIL);
						throw new RuntimeException("Failed in step 1 ");
					}
			 }
		
		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ATWELL") || testcaseName.contains("ORION")) {
		  	  try {
		  		   SelectAgentForAlt(USER_NAME);
					log("STEP 2:  Selected value display in the Agents DD ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2:  selected value does not display in Agents DD.", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
		  	  
		  	 try {
		  		ClickOnAddButton();
					log("STEP 3: Save successful message should be display above the add new button", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: Save successful message does not display above the add new button ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				} 
		}else if(testcaseName.contains("DOT"))
	    	{
	    		
	    		try {
	    	  		   SelectAgentForDot(USER_NAME);
	    				log("STEP 2:  Selected value display in the Agents DD ", Status.PASS);
	    			} catch (Exception e) {
	    				log("STEP 2:  selected value does not display in Agents DD.", Status.FAIL);
	    				throw new RuntimeException("Failed in step 2");
	    			}
	    	  	  
	    	  	 try {
	    	  		ClickOnAddButtonForDot();
	    				log("STEP 3: Save successful message should be display above the add new button", Status.PASS);
	    			} catch (Exception e) {
	    				log("STEP 3: Save successful message does not display above the add new button ", Status.FAIL);
	    				throw new RuntimeException("Failed in step 3");
	    			} 
	    	}else {
	        		

	        		try {
	        			SelectAgentForRow(USER_NAME);
	        				log("STEP 2:  Selected value display in the Agents DD ", Status.PASS);
	        			} catch (Exception e) {
	        				log("STEP 2:  selected value does not display in Agents DD.", Status.FAIL);
	        				throw new RuntimeException("Failed in step 2");
	        			}
	       
	        	  	 try {
	        	  		ClickOnAddButtonForRow();
	        				log("STEP 3: Save successful message should be display above the add new button", Status.PASS);
	        			} catch (Exception e) {
	        				log("STEP 3: Save successful message does not display above the add new button ", Status.FAIL);
	        				throw new RuntimeException("Failed in step 3");
	        			}
	    	  	}
		try {
        	By defaultProjectAssignment = By.xpath("(//td[contains(text(),'" + USER_NAME + "')]/..//td[contains(text(),'"+TRACT_ASSIGNMENT+"')])[1]");
        	Assert.assertTrue(util.isElementVisible(defaultProjectAssignment));
			log("STEP 4: Default Tract Assignment Successfully added", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4: Default Tract Assignment not added", Status.FAIL);
		}
	}
}
