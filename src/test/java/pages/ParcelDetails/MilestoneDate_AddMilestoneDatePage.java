package pages.ParcelDetails;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class MilestoneDate_AddMilestoneDatePage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public MilestoneDate_AddMilestoneDatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')]");
	By altMilestoneDates = By.xpath("//span[contains(text(),'Milestone Dates')]");
	By rowMilestoneDates = By.xpath("//span[contains(text(),'Key Dates')] | //span[contains(text(),'Parcel Milestones')]");
    By btnEdit = By.xpath("(//input[contains(@id,'_ctl04_EditButton') and @type='image'])[1]");
    By txtExpectedDate = By.xpath("//input[contains(@id,'_Expected_Date_dateInput') and @type='text']"); 
    By txtActualDate = By.xpath("//input[contains(@id,'_Actual_Date_dateInput') and @type='text']");
    By txtAmount = By.xpath("//input[contains(@id,'_EditFormControl_AMOUNT') and @type='text']");
    By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    By btnCancle = By.xpath("//input[contains(@id,'_EditFormControl_btnCancel') and @type='submit']");
    
    public void navigateParcelInformation() {
  		util.waitUntilElementDisplay(navParcel);
  		util.click(navParcel);
  		util.waitUntilElementDisplay(navParcelInfo);
  		util.click(navParcelInfo);
  		util.waitUntilElementDisplay(navParcelInformation);
  		util.click(navParcelInformation);
    }
    public void addMilestoneDateALT() {
    	util.waitUntilElementDisplay(altMilestoneDates);
		util.click(altMilestoneDates);
		
    }
    
    public void addMilestoneDateROW() {
    	util.waitUntilElementDisplay(rowMilestoneDates);
		util.click(rowMilestoneDates);
		
    }
    
    
    
    public void AddExpectedDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExpectedDate, value);
    	
		
    }
    
    public void AddActualDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtActualDate, value);
		
    }
    
    public void AddAmount(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAmount, value);
		
    }
    
    public void Update() {
    	util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.dummyWait(2);
    }
    
    public void CancleALT() {
    	if(!util.isElementVisible(btnEdit)) {
    		util.click(altMilestoneDates);
    	}
    	
    	util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.dummyWait(5);
    	util.waitUntilElementDisplay(btnCancle);
		util.click(btnCancle);
		
    }
    
    public void CancleROW() {
    	util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.dummyWait(5);
    	util.waitUntilElementDisplay(btnCancle);
		util.click(btnCancle);
		
    }
    
    public void AddMilestoneDate(Map<String, String> map, String testcaseName) {
    	
    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL"))
    	 { util.dummyWait(5);
    	try {
    		addMilestoneDateALT();
			log("STEP 1: The panel fields displays ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  The panel does not expand ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
     }
    	 else
    	 {
    		 try {
    			 addMilestoneDateROW();
    				log("STEP 1: The panel fields displays ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1:  The panel does not expand ", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
    	 }
    	 if(util.isElementVisible(btnEdit)) {
    		 util.waitUntilElementDisplay(btnEdit);
    		 util.click(btnEdit);
    	util.dummyWait(5);
    	 if(util.isElementPresent(txtExpectedDate)) {
    	 try {
    		 AddExpectedDate(map.get(Excel.ExpectedDateMilestone));
 			log("STEP 2: User can enter a value in Expected Date field   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 2:  User cannot add a value in Expected Date field    ", Status.FAIL);
 			throw new RuntimeException("Failed in step 2");
 		 }
    	 }
    	 
    	 if(util.isElementPresent(txtActualDate)) {
    	 try {
    		 AddActualDate(map.get(Excel.ActualDateMilestone));
 			log("STEP 3:User can enter a value in Actual Date field   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 3:   User cannot add a value in Actual Date field  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 3");
 		 }
    	 }
    	 
    	 if(util.isElementPresent(txtAmount)) {
    	 try {
    		 AddAmount(map.get(Excel.AmountMilestone));
 			log("STEP 4:User can enter a value in Amount field   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 4:   User cannot add a value in Amount field  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 4");
 		 }
    	 }
    	 
    	 try {
    		 Update();
 			log("STEP 5: The updated  values displays in the grid    ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 5:  Updated values does  not displayed in the grid.    ", Status.FAIL);
 			throw new RuntimeException("Failed in step 5");
 		 }
    	 
    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
    		 util.dummyWait(10);
    	 try {
        	 CancleALT();
     		 log("STEP 6:  User can click on cancel button.    ", Status.PASS);
     	 } catch (Exception e) {
     		 log("STEP 6:  User cannot click on cancel button.   ", Status.FAIL);
     		 throw new RuntimeException("Failed in step 6");
     	   }
    	 }
    	 else {
    		 util.dummyWait(10);
    	 try {
    		 CancleROW();
 			log("STEP 6:  User can click on cancel button.    ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 6:  User cannot click on cancel button.   ", Status.FAIL);
 			throw new RuntimeException("Failed in step 6");
 		 }
    }
    	 
    	 util.dummyWait(5);
    	 }else {
    		 log("Milestone date not configured to display", Status.SKIP);
    	 }
    }
    
    By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
    By manageKeyDates = By.xpath("//span[contains(@onclick,'KeyDate')]");
    By addNewRecord = By.xpath("//a[contains(@id,'_lnkAddNewRecord')]");
    By txtKeyDateName = By.xpath("//input[contains(@id,'_EditFormControl_Date_Name') and @type='text']");
    By checkBoxIncludeExpected = By.xpath("//input[contains(@id,'_EditFormControl_IncludeExpected') and @type='checkbox']");
    By checkBoxIncludeActual = By.xpath("//input[contains(@id,'_EditFormControl_IncludeActual') and @type='checkbox']");
    By checkBoxIncludeActualInSnapshot = By.xpath("//input[contains(@id,'_EditFormControl_IncActualInSnapshot') and @type='checkbox']");
    By checkBoxToggleAll = By.xpath("//strong[text()='Toggle All']/..//input[@type='checkbox']");
    By radioParcelInfo = By.xpath("//input[contains(@id,'_EditFormControl_tabOptionRepeter_ctl01_rb_write')]");
    By buttonInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert')]");
    By successMessage = By.xpath("//span[text()='Changes saved successfully!']");
    
    By activeChecked = By.xpath("//input[contains(@id,'EditFormControl_Active_Ind') and @checked='checked']");
    By activeUnchecked = By.xpath("//input[contains(@id,'EditFormControl_Active_Ind')]");
   
    public void TurnOnDesignCode() {
    	util.waitUntilElementDisplay(btnDesignMode);
    	util.click(btnDesignMode);
    	util.dummyWait(2);
    }
    
    public void clickOnManageKeyDatesIcon() {
    	util.waitUntilElementDisplay(manageKeyDates);
    	util.click(manageKeyDates);
    	util.dummyWait(2);
    	util.switchToChildWindow();
    }
    
    public void clickOnAddNewRecord() {
    	util.waitUntilElementDisplay(addNewRecord);
    	util.click(addNewRecord);
    	util.dummyWait(2);
    }
    
    public void addKeyDateName(String value) {
    	util.waitUntilElementDisplay(txtKeyDateName);
        util.inputTextAndPressTab(txtKeyDateName, value);
    }
    
    public void clickOnIncludeExpectedCheckbox() {
    	util.waitUntilElementDisplay(checkBoxIncludeExpected);
    	util.click(checkBoxIncludeExpected);
    }
    
    public void clickOnIncludeActualCheckbox() {
    	util.waitUntilElementDisplay(checkBoxIncludeActual);
    	util.click(checkBoxIncludeActual);
    }
    
    public void clickOnIncludeActualInSnapshot() {
    	util.waitUntilElementDisplay(checkBoxIncludeActualInSnapshot);
    	util.click(checkBoxIncludeActualInSnapshot);
    }
    
    public void clickOnToggleAllCheckbox() {
    	util.waitUntilElementDisplay(checkBoxToggleAll);
    	util.click(checkBoxToggleAll);
    }
    
    public void clickOnWRadioButton() {
    	util.waitUntilElementDisplay(radioParcelInfo);
    	util.click(radioParcelInfo);
    }
    
    public void clickOnInsertButton() {
    	util.waitUntilElementDisplay(buttonInsert);
    	util.click(buttonInsert);
    	util.dummyWait(2);
    }
    
    public void configureMilestoneDate(Map<String, String> map, String testcaseName) {
    	
    	By keyDate = By.xpath("//tr[contains(@id,'TRACTDATES_radYALGridControl')]/..//td[text()='"+map.get("Date Name")+"']");
    	
    	if(!util.isElementVisible(keyDate)) {
    	try {
			TurnOnDesignCode();
			log("STEP 1:  user can able to click on the design mode icon     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: user not able to click on the design mode icon ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    	
    	if(!util.isElementVisible(manageKeyDates)) {
    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL"))
    	 { 
    	try {
    		addMilestoneDateALT();
    		log("STEP 2:  user can expand Milestone Dates Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: user cannot expand Milestone Dates Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
     }
    	 else
    	 {
    		 try {
    			 addMilestoneDateROW();
    			 log("STEP 2:  user can expand Milestone Dates Panel", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 2: user cannot expand Milestone Dates Panel", Status.FAIL);
    				throw new RuntimeException("Failed in step 2");
    			}
    	 }
    	 
    	}
    	
    	try {
    		clickOnManageKeyDatesIcon();
			log("STEP 3:  user can able to click on the Manage Key Dates Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user not able to click on the Manage Key Dates Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
    	
    	try {
    		clickOnAddNewRecord();
			log("STEP 4:  user can able to click on the Add New Record", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: user not able to click on the Add New Record", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
    	
    	try {
    		addKeyDateName(map.get("Date Name"));
			if (testcaseName.contains("DOT")) {
				if (!util.isElementVisible(activeChecked)) {
					util.click(activeUnchecked);
				}
			}
			log("STEP 5:  user can add Date Name", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user not able to add Date Name", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
    	
    	try {
    		clickOnIncludeExpectedCheckbox();
			log("STEP 6:  user can select Include Expected Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: user cannot select Include Expected Checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
    	
    	try {
    		clickOnIncludeActualCheckbox();
			log("STEP 7:  user can select Include Actual Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot select Include Actual Checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
    	
    	try {
    		clickOnIncludeActualInSnapshot();
			log("STEP 8:  user can select Include Actual in Snapshot Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user cannot select Include Actual in Snapshot Checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
    	
    	try {
    		clickOnToggleAllCheckbox();
			log("STEP 9:  user can select Toggle All Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot select Toggle All Checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
    	
    	try {
    		clickOnWRadioButton();
			log("STEP 10:  user can select Write permission for Parcel Info Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user cannot select Write permission for Parcel Info Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
    	
    	try {
    		clickOnInsertButton();
			log("STEP 11:  user can click on Insert button", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot click on Insert button", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
    	
    	try {
    		Assert.assertTrue(util.isElementVisible(successMessage));
			log("STEP 12:  user can see success message", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: user cannot see success message", Status.FAIL);
		}
    	
    	driver.close();
    	util.switchToParentWindow();
    	
    	util.reloadPage();
    	util.waitUntilPageLoad();
    	By btnEditKey = By.xpath("//*[text()='"+map.get("Date Name")+"']/..//input[@title='Edit']");
    	if(!util.isElementVisible(btnEditKey)) {
    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL"))
   	 { 
   	try {
   		addMilestoneDateALT();
   		log("STEP 13:  user can expand Milestone Dates Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: user cannot expand Milestone Dates Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
    }
   	 else
   	 {
   		 try {
   			 addMilestoneDateROW();
   			 log("STEP 13:  user can expand Milestone Dates Panel", Status.PASS);
   			} catch (Exception e) {
   				log("STEP 13: user cannot expand Milestone Dates Panel", Status.FAIL);
   				throw new RuntimeException("Failed in step 13");
   			}
   	 }
    	}
    	}
    	
		try {
			By btnEditKey = By.xpath("//*[text()='"+map.get("Date Name")+"']/..//input[@title='Edit']");
			 util.click(btnEditKey);
			util.dummyWait(5);
			log("STEP 14:  user can click on Edit Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user cannot click on Edit Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}

		try {
			AddExpectedDate(map.get(Excel.ExpectedDateMilestone));
			log("STEP 15: User can enter a value in Expected Date field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:  User cannot add a value in Expected Date field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}

		try {
			AddActualDate(map.get(Excel.ActualDateMilestone));
			log("STEP 16:User can enter a value in Actual Date field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:   User cannot add a value in Actual Date field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		try {
			Update();
			util.reloadPage();
			log("STEP 17: User can click on the update button", Status.PASS);
		} catch (Exception e) {
			log("STEP 17:  User cannot click on the update button", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}

		try {
			 By Summary = By.xpath("//td[contains(@id,'tractInfo')]/..//*[contains(text(),'"+map.get("Date Name")+":')]/../..//*[contains(text(),'"+map.get(Excel.ActualDateMilestone)+"')]");
			 Assert.assertTrue(util.isElementVisible(Summary));
			log("STEP 18:  user can see Key Date in parcel summary", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 18: user cannot see Key Date in parcel summary", Status.FAIL);
		}
   	
    }
    
}
