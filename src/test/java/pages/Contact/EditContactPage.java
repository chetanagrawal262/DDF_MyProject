package pages.Contact;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class EditContactPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String ADD_1, ADD_2, CITY, STATE, ABBREVIATION, ZIP, ZIP_PLUS;

	public EditContactPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By LinlEditAlt = By.xpath("//tbody/tr[@id='ctl00_ConPHRightTop_RadPanelBar4_i0_i0_PRJCONTACTS_radYALGridControl_ctl00__0']/td[4]/a[1]");
	By LinlEditDot = By.xpath("//tbody/tr[@id='ctl00_ConPHRightTop_PRCN_UC_PRJCONTACTS_radYALGridControl_ctl00__0']/td[3]/a[1]");
    By LinlEditRow = By.xpath("//a[contains(text(),'Edit')]");
	By drpContactType = By.xpath("//input[contains(@id,'CONTACT_TYPE_ID_radYALDropDownList_Input') and @type='text']");
	By btnAddNewRecord = By.xpath("//img[@id='YALCONTACTWITHNAME_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By txtAddressLine1 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_2') and @type='text']");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_3') and @type='text']");
	By txtAddressLine4 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_4') and @type='text']");
	By txtCity = By.xpath("//input[contains(@id,'_EditFormControl_City') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'_EditFormControl_State_ABB_radYALDropDownList_Input') and @type='text']");
	By drpStateRow = By.xpath("//input[contains(@id,'_EditFormControl_RadStateABB_Input') and @type='text']");
	By txtZipCode = By.xpath("(//input[contains(@id,'_EditFormControl_Zip_Code') and @type='text'])[1]");
	By txtZipCodePlus = By.xpath("//input[contains(@id,'_EditFormControl_Zip_Code_Plus') and @type='text']");
	By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert') and @type='submit']");
    By btnCancel = By.xpath("//input[contains(@id,'_EditFormControl_btnCancel') and @type='submit']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");

    
    public void ClickOnEditAlt() {
    	util.waitUntilElementDisplay(LinlEditAlt);
    	util.click(LinlEditAlt);
    }

    public void ClickOnEditDot() {
    	util.waitUntilElementDisplay(LinlEditDot);
    	util.click(LinlEditDot);
    }
    
    public void ClickOnEditRow() {
    	util.waitUntilElementDisplay(LinlEditRow);
    	util.click(LinlEditRow);
    }

    public void UpdateField(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpContactType, value);
    }

    public void addNewRecord() {
    	util.waitUntilElementDisplay(btnAddNewRecord);
    	util.click(btnAddNewRecord);
		
    }
    
    public void addAddressLine1(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine1, value);
		
    }
    
    public void addAddressLine2(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine2, value);
		
    }
    
    public void addAddressLine3(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine3, value);
		
    }
    
    public void addAddressLine4(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine4, value);
		
    }
    
    public void AddCity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCity, value);
		
    }
    
    public void SelectState(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpState, value);
		
    }
    
    public void SelectStateRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStateRow, value);
		
    }
    
    public void addZipCode(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCode, value);
		
    }
    
    public void addZipCodePlus(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCodePlus, value);
		
    }
    
    public void InsertRecord() {
    	util.waitUntilElementDisplay(btnInsert);
    	util.click(btnInsert);
    }
    
    public void ClickOnCancel() {
    	util.waitUntilElementDisplay(btnAddNewRecord);
    	util.click(btnAddNewRecord);
    	util.dummyWait(1);
    	util.waitUntilElementDisplay(btnCancel);
    	util.click(btnCancel);
    }
    
    By btnSaveDot = By.xpath("//input[@id='SaveContact']");
    public void ClickonSaveDot() {
    	util.waitUntilElementDisplay(btnSaveDot);
    	util.click(btnSaveDot);
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
    	Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
    }
    
    
    By btnSave = By.xpath("//input[@id='btnSaveLO']");
    By isPrimary = By.xpath("//input[contains(@id,'EditFormControl_chkIsPrimary') and @type='checkbox']");
    public void ClickonSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    	if(util.isElementVisible(changesSavedSuccessfully)) {
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
    	Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
    	}
    }

    public void EditContact(Map<String, String> map, String testcaseName) {
    	util.dummyWait(5);
        if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
     	   try {
     		  ClickOnEditAlt();
				log("STEP 1: Added Contact opens in new tab on browser ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: On Edit Added Contact does not opens in new tab on browser", Status.FAIL);
				throw new RuntimeException("User cannot see the option in Menu");
			}
        }
        else if(testcaseName.contains("DOT")) {
        	 try {
        		  ClickOnEditDot();
   				log("STEP 1: Added Contact opens in new tab on browser ", Status.PASS);
   			} catch (Exception e) {
   				log("STEP 1: On Edit Added Contact does not opens in new tab on browser", Status.FAIL);
   				throw new RuntimeException("User cannot see the option in Menu");
   			}
        }
        else {
        	 try {
       		  ClickOnEditRow();
  				log("STEP 1:Added Contact opens in new tab on browser ", Status.PASS);
  			} catch (Exception e) {
  				log("STEP 1: On Edit Added Contact does not opens in new tab on browser", Status.FAIL);
  				throw new RuntimeException("User cannot see the option in Menu");
  			}
        }
        
        Set<String> windowId = driver.getWindowHandles(); // get window id of current window
	  		Iterator<String> itererator = windowId.iterator();

	  		String mainWinID = itererator.next();
	  		String newAdwinID = itererator.next();

	  		driver.switchTo().window(newAdwinID);
        try {
         if(testcaseName.contains("DOT")) { 
        try {
        	UpdateField(map.get(Excel.ContactType));
	 			log("STEP 2: User can enter a value in ContactType field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2:  User cannot add a value in ContactType field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 } 
        
        try {
        	ClickonSaveDot(); 
			log("STEP 3:  'Changes saved sucessfully ' message will be displayed ' in green displays. ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 3:  User cannot click on save button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		 }
        
        } 
        
         else {
        	
        	 try {
             	UpdateField(map.get(Excel.ContactType));
     	 			log("STEP 2: User can enter a value in ContactType field   ", Status.PASS);
     	 		 } catch (Exception e) {
     	 			log("STEP 2:  User cannot add a value in ContactType field    ", Status.FAIL);
     	 			throw new RuntimeException("Failed in step 5");
     	 		 } 
        	 
        	 try {
	    		 addNewRecord();
	 			log("STEP 3: Grid will expand with fields   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: The panel does not expand    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 
	    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    	 try {
	    		 addAddressLine1(map.get(Excel.AddressLine1));
	 			log("STEP 4:  User can enter a value in AddressLine1 field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4:  User cannot add a value in AddressLine1 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
             
	    	 if(util.isElementVisible(txtAddressLine2)) {
	    	 try {
	    		 addAddressLine2(map.get(Excel.AddressLine2));
	 			log("STEP 5: User can enter a value in AddressLine2 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5:  User cannot add a value in AddressLine2 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtAddressLine3)) {
	    	 try {
	    		 addAddressLine3(map.get(Excel.AddressLine3));
	 			log("STEP 6: User can enter a value in AddressLine3 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6:  User cannot add a value in AddressLine3 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 }
	    	 if(util.isElementVisible(txtAddressLine4)) {
	    	 try {
	    		 addAddressLine4(map.get(Excel.AddressLine4));
	 			log("STEP 7: User can enter a value in AddressLine4 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7:  User cannot add a value in AddressLine4 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	 } 
         }
         else {
        	 try {
        		 util.click(isPrimary);
	    		 addAddressLine1(map.get(Excel.AddressLine1));
	    		 ADD_1=map.get(Excel.AddressLine1);
	 			log("STEP 4:  User can enter a value in AddressLine1 field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4:  User cannot add a value in AddressLine1 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
        	 if(util.isElementVisible(txtAddressLine2)) {
	    	 try {
	    		 addAddressLine2(map.get(Excel.AddressLine2));
	    		 ADD_2=map.get(Excel.AddressLine2);
	 			log("STEP 5: User can enter a value in AddressLine2 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5:  User cannot add a value in AddressLine2 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
        	 }
         }
	    	 
	    	 try {
	    		 AddCity(map.get(Excel.City));
	    		 CITY=map.get(Excel.City);
	 			log("STEP 6: User can enter a value in City field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6:  User cannot add a value in City field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 
	    	 if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
	    		 try {
		    		 SelectStateRow(map.get(Excel.State));
		    		 STATE=map.get(Excel.State);
		 			log("STEP 7: Added value displays in State field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 7:  No value displays in State Dropdown    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 7");
		 		 } 
	    	 }
	    	 else {
	    	 try {
	    		 SelectState(map.get(Excel.State));
	 			log("STEP 7: Added value displays in State field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7:  No value displays in State Dropdown    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	     } 
	    	 try {
	    		 addZipCode(map.get(Excel.ZipCode));
	    		 ZIP=map.get(Excel.ZipCode);
	 			log("STEP 8: User can enter a value in ZipCode field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8:  User cannot add a value in ZipCode field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 
	    	 if(util.isElementVisible(txtZipCodePlus)) {
	    	 try {
	    		 addZipCodePlus(map.get(Excel.ZipCodePlus));
	 			log("STEP 9: User can enter a value in ZipCode Plus field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 9:  User cannot add a value in ZipCode Plus field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 9");
	 		 }
	    	 }
	    	 
	    	 try {
	    		 InsertRecord();
	 			log("STEP 10:  User can click on insert button.  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 10:  User cannot click on insert button.   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 10");
	 		 }
	    	 
	    	 util.dummyWait(3);
	    	 try {
	    		 ClickOnCancel();
	 			log("STEP 11:  User can click on Cancel button.  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 11:  User cannot click on Cancel button.     ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 11");
	 		 }
         	 
	    	 try {
	    		 ClickonSaveButton(); 
	 			log("STEP 12:  'Changes saved sucessfully ' message will be displayed ' in green displays. ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 12:  User cannot click on save button.  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 12");
	 		 }
	    	 
	    	 if(environment.contains("VALARD")) {
	  	    	 try {
	  	    		 By primaryAddress = By.xpath("//td[text()='Primary/Preferred Address: "+ADD_1+", "+ADD_2+", "+CITY+", "+ZIP+"']");
	  	    		String pA= "Primary/Preferred Address: "+ADD_1+", "+ADD_2+", "+CITY+", "+ZIP;
	  	    		 Assert.assertTrue(util.isElementVisible(primaryAddress));
	  	 			log("STEP 13: Primary/Prefered Address Pulled Successfully "+pA, Status.PASS);
	  	 		 } catch (AssertionError e) {
	  	 			 ExtentTestManager.infoWithScreenshot("Failed Point");
	  	 			log("STEP 13: Primary/ Prefered Address is not showing ", Status.FAIL);
	  	 		 }
	  	       }
         
	    	
         }
        }catch (Exception e) {
       	 
        }finally {
        	ExtentTestManager.infoWithScreenshot("Edit Contact Page");
        	 driver.close();
    		 driver.switchTo().window(mainWinID);
    		 util.dummyWait(2);
        }
    }
}
