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

public class AddNewDropDownPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public AddNewDropDownPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navConfiguration = By.xpath("//span[text()='Configuration']");
	By navDropDown = By.xpath("//span[contains(text(),'Drop Down')]");
	By btnAddNew = By.xpath("//a[contains(@id,'lnkAddNewRecord')]");
	By drpLookUpType = By.xpath("//input[contains(@id,'Lookup_Type_radYALDropDownList_Input')]");
	By txtLookUpValue = By.xpath("//input[contains(@id,'EditFormControl_Lookup_Value') and @type='text']");
	By ActiveCheckbox = By.xpath("//input[contains(@id,'EditFormControl_Active') and @type='checkbox']");
	By isDefaultCheckbox = By.xpath("//input[contains(@id,'EditFormControl_IsDefault') and @type='checkbox']");
	By Colour = By.xpath("//em[contains(@id,'EditFormControl_LOOKUP_COLOR_icon') ]");
	By SelectColour = By.xpath("//span[contains(text(),'#FFFF00')]");
	By txtDisplayOrder = By.xpath("//input[contains(@id,'EditFormControl_Lookup_Order') and @type='text']");
	By txtShortDescription = By.xpath("//textarea[contains(@id,'EditFormControl_Short_Desc')]");
	By txtLookUpDescription = By.xpath("//textarea[contains(@id,'EditFormControl_Lookup_Desc')]");
	By txtDisplayName = By.xpath("//textarea[contains(@id,'EditFormControl_RadDisplayName')]");
	By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
	By btnCancel = By.xpath("//input[contains(@id,'EditFormControl_btnCancel') ]");
	By btnEdit = By.xpath("(//input[contains(@id,'EditButton')])[last()]");
	By btnUpdate = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate')]");
	By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteAlignment')])[last()]");
	By btncancel = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	
	public void ClickOnAddnewRecord() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navConfiguration);
		util.click(navConfiguration);
		util.waitUntilElementDisplay(navDropDown);
		util.click(navDropDown);
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
	}
	
	public void SelectLookUpType(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpLookUpType, value);
	}
	
	public void AddLookUpValue(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtLookUpValue, value);
	}
	
	public void ClickOnActiveCheckbox() {
		util.waitUntilElementDisplay(ActiveCheckbox);
		util.click(ActiveCheckbox);
	}
	
	public void ClickOnIsDefaultCheckbox() {
		util.waitUntilElementDisplay(isDefaultCheckbox);
		util.click(isDefaultCheckbox);
	}
	
	public void SelectColour() {
		util.waitUntilElementDisplay(Colour);
		util.click(Colour);
		util.waitUntilElementDisplay(SelectColour);
		util.click(SelectColour);
	}
	
	public void AddDisplayOrder(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDisplayOrder, value);
	}
	
	public void AddShortDescription(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtShortDescription, value);
	}
	
	public void AddLookUpDescription(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtLookUpDescription, value);
	}
	
	public void AddDisplayName(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDisplayName, value);
	}
	
	public void ClickOnInsertButton() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.dummyWait(1);

	}
	
	public void ClickOnCancelButton() {
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
		util.dummyWait(1);

	}
	
	public void ClickOnEditButton() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.dummyWait(1);
	}
	
	public void ClickOnUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.dummyWait(1);

	}
	
	public void ClickOnDeleteButton() {
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
		util.dummyWait(1);
	}
	
	 public void ClickonCancle()  {
	    util.dummyWait(3);
	  		util.waitUntilElementDisplay(btncancel);
	  		util.click(btncancel);
	
	    }
	 
	 
	 public void ClickonOk()  {
		    util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);	
	  		util.waitUntilElementDisplay(btnOk);
	  		util.click(btnOk);
			util.dummyWait(1);
	  		util.waitUntilElementDisplay(SuccessMessage);
			Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
		
	    }
	
	 
	 public void AddNewDropDown(Map<String, String> map, String testcaseName) {
		 
		 if (testcaseName.contains("DOT") || testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
				log(" Add New Drop Down not applicable for DOT and ROW", Status.SKIP);
			}
			else {
		 
			try {
				ClickOnAddnewRecord();
				log("STEP 1: Add new popup display with blank fields", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Popup up does not appear", Status.FAIL);
				throw new RuntimeException("Failed in step 1: Popup up does not appear");
			}

			try {
				SelectLookUpType(map.get(Excel.LookupType));
				log("STEP 2:   Added value displays in the Lookup Type field :", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:   Added value does not displays in the Lookup Type field", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			try {
				AddLookUpValue(map.get(Excel.LookupValue));
				log("STEP 3: User can enter the value in Lookup Value field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User cannot enter the value in Lookup Value field", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				ClickOnActiveCheckbox();
				log("STEP 4:  Click on Active Checkbox", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: Not able to Clink on Active Checkbox", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				ClickOnIsDefaultCheckbox();
				log("STEP 5: IsDefault Check box should be checked ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: IsDefault Check box should not be checked ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				SelectColour();
				log("STEP 6: Color should be selected and color should be changed from Default color", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  user can no ale to select color from color picker", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			
			try {
				AddDisplayOrder(map.get(Excel.DisplayOrder));
				log("STEP 7: User can enter the value in Display Order field    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot enter the value in Display Order field  ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			try {
				AddShortDescription(map.get(Excel.ShortDescription));
				log("STEP 8: User can enter the value in Short Description field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot enter the value in Short Description field", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				AddLookUpDescription(map.get(Excel.LookupDescription));
				log("STEP 9: User can enter the value in LookUp Description field", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot enter the value in LookUp Description field", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				AddDisplayName(map.get(Excel.DisplayName));
				log("STEP 10: User can enter the value in Display Name field", Status.PASS);
			} catch (Exception e) {
				log("STEP 10:   User cannot enter the value in Display Name field", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			try {
				ClickOnInsertButton();
				log("STEP 11: User should be created", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User should not be created", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 12 :Changes saved sucessfully ! message will be display in green color.   ", Status.PASS);
				} else {
				   log("STEP 12:  Error message should  be display."  , Status.FAIL);
			      throw new RuntimeException("Faild in STEP 12 ");
		   	} 
			
			try {
				ClickOnCancelButton();
				log("STEP 13: User should not be created and Window get  closed ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: Window should not be closed", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				ClickOnEditButton();
				log("STEP 14: Existing User record should be open  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: Existing User record should not be open", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 15:  Existing User record should be update", Status.PASS);
			} catch (Exception e) {
				log("STEP 15:  Existing User record should not  be update", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			 try {
				 ClickOnDeleteButton();
					log("STEP 16:  Popup Delete should be open with OK and Cancel button    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 16:  Popup Delete does not open", Status.FAIL);
					throw new RuntimeException("Failed in step 16 ");
				}
		 
			 
			 
			 try {
				 ClickonCancle();
					log("STEP 17: User can click on cancel button  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 17: User cannot click on cancel button", Status.FAIL);
					throw new RuntimeException("Failed in step 17 ");
				}
			 
			 try {
				 ClickonOk();
					log("STEP 18: Deleted record does not display in the grid and 2)Message- Changes saved suessfully! in green displays. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 18: Message- Changes saved sucessfully' does not display", Status.FAIL);
					throw new RuntimeException("Failed in step 18");
				
				}
			}
	 }
	 
}
