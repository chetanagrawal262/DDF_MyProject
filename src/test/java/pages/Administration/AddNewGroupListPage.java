package pages.Administration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewGroupListPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public AddNewGroupListPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navConfiguration = By.xpath("//span[text()='Configuration']");
	By navGroupList = By.xpath("//span[contains(text(),'Group List')]");
	By btnAddNew = By.xpath("//input[contains(@id,'_idYALGroupList_addNew')]");
	By drpGroupListArrow = By.xpath("//a[contains(@id,'_GroupList_Arrow')]");
	By txtGroupName = By.xpath("//input[contains(@id,'_idYALGroupList_NEWDistribution')]");
	By btnSave = By.xpath("//input[contains(@id,'_idYALGroupList_sav')]");
	By btnAddNewRecord = By.xpath("//a[contains(@id,'_lnkAddNewRecord')]");
	By drpUsers = By.xpath("//input[contains(@id,'_idEditGroup_cbYalUser_YALComboBox_Input')]");
	By radioButtonEmail = By.xpath("//input[contains(@id,'_idEditGroup_rbNAROWUsers')]");
	By txtEmail = By.xpath("//input[contains(@id,'_idEditGroup_EMAIL')]");
	By btnInsert = By.xpath("//input[contains(@id,'_idEditGroup_btnInsert')]");
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
	By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteAlignment')])[last()]");
	By btnOk = By.xpath("//span[text()='OK']");
	
	public void NavigateToGroupList() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navConfiguration);
		util.click(navConfiguration);
		util.waitUntilElementDisplay(navGroupList);
		util.click(navGroupList);
	}
	
	public void clickOnAddNew() {
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
	}
	
	public void enterGroupName(String groupName) {
		if (!commonFunction.checkNA(groupName)) 
			util.inputTextAndPressTab(txtGroupName, groupName);
	}
	
	public void clickOnSave() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
	}
	
	public void clickOnAddNewRecord() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
	}
	
	public void selectUser(String value) {
		if (!commonFunction.checkNA(value)) 
			util.selectValueFromDropdownCheckbox(drpUsers, value);
	}
	
	public void clickOnEmailRadio() {
		util.waitUntilElementDisplay(radioButtonEmail);
		util.click(radioButtonEmail);
	}
	
	public void enterEmail(String email) {
		if (!commonFunction.checkNA(email)) 
			util.inputTextAndPressTab(txtEmail, email);
	}
	
	public void ClickOnInsertButton() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.dummyWait(1);
	}
	
	public void ClickOnDeleteButton() {
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
		util.waitFor(300);
	}
	
	 public void ClickonOk()  {
		   util.waitUntilElementDisplay(btnOk);
	  		util.click(btnOk);
			util.dummyWait(1);
		
	    }
	
	 
	 public void addNewGroupList(Map<String, String> map, String testcaseName) {
		 
			try {
				NavigateToGroupList();
				log("STEP 1: User can navigate to Group List", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to Group List", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			By groupName = By.xpath("//div[contains(@id,'GroupList_DropDown')]/..//li[text()='"+map.get("GroupName")+"']");
			util.click(drpGroupListArrow);
			if (!util.isElementVisible(groupName)) {
				util.click(drpGroupListArrow);
			try {
				clickOnAddNew();
				log("STEP 2: Add New button clicked", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: Add New button not clickable", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

			try {
				enterGroupName(map.get("GroupName"));
				log("STEP 3: Group name entered", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: Group name not entered", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}

			try {
				clickOnSave();
				log("STEP 4: Save button clicked", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: Save button not clickable", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			}else {
				util.click(groupName);
				util.waitFor(400);
			}
			try {
				clickOnAddNewRecord();
				log("STEP 5: Add New Record button clicked", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: Add New Record button not clickable", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}

			try {
				selectUser(map.get(Excel.User));
				log("STEP 6: User selected", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User not selected", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}

			try {
				ClickOnInsertButton();
				log("STEP 7: Insert button clicked", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: Insert button not clickable", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				Assert.assertTrue(util.isElementPresent(SuccessMessage));
				log("STEP 8: User can see succes Message", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 8: User cannot see succes Message", Status.FAIL);
			}
			
			try {
				clickOnAddNewRecord();
				log("STEP 9: Add New Record button clicked", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: Add New Record button not clickable", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				clickOnEmailRadio();
				log("STEP 10: User can select Email Radio Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot select Email Radio Button", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				enterEmail(map.get(Excel.Email));
				log("STEP 11: Email entered", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: Email not entered", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}

			try {
				ClickOnInsertButton();
				log("STEP 12: Insert button clicked", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: Insert button not clickable", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}

			try {
				Assert.assertTrue(util.isElementPresent(SuccessMessage));
				log("STEP 13: User can see succes Message", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 13: User cannot see succes Message", Status.FAIL);
			}
			
			try {
				ClickOnDeleteButton();
				log("STEP 14: Delete button clicked", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: Delete button not clickable", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}

			try {
				ClickonOk();
				log("STEP 15: User can delete the record successfully", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: User cannot delete the record successfully", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
	 }
	 
}
