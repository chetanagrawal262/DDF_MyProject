package pages.Title;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddLesseeRecordPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddLesseeRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navLessee = By.xpath("//span[contains(text(),'Tenant/Lessee')]");
	By btnAddNew = By.xpath("//img[contains(@id,'YALTITLESTAKEHOLDERS_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By drpType = By.xpath("//input[contains(@id,'_TYPE_ID_radYALDropDownList_Input') and @type='text']");
	By txtLastName = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_First_Name') and @type='text']");
	By txtMiddleName = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Middle_Name') and @type='text']");
	By txtTitle = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Title') and @type='text']");
	By drpMaritalStatus = By.xpath("//input[contains(@id,'_ENTITY_Marital_Status_ID_radYALDropDownList_Input') and @type='text']");
	By drpGender = By.xpath("//input[contains(@id,'_ENTITY_Gender_radYALDropDownList_Inpu') and @type='text']");
	By txtVendor = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Vendor_ID') and @type='text']");
	By txtEntityName = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Corporation_Trust') and @type='text']");
	By drpEntityType = By.xpath("//input[contains(@id,'_ENTITY_Entity_Type_ID_radYALDropDownList_Input') and @type='text']");
	By txtAddressLine1 = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Address_Line_2') and @type='text']");
	By txtHomePhone = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Home_Phone') and @type='text']");
	By txtCellPhone = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Cell_Phone') and @type='text']");
	By txtCity = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_City') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_RadState_Input') and @type='text']");
	By SelectState = By.xpath("//li[contains(text(),'New York')]");
	By txtZipCode = By.xpath("(//input[contains(@id,'_EditFormControl_ENTITY_Zip_Code') and @type='text'])[1]");
	By txtFaxNumber = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_FAX_NUMBER') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Work_Phone') and @type='text']");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Address_Line_3') and @type='text']");
	By txtEmail = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Email') and @type='text']");
	By txtComments = By.xpath("//textarea[contains(@id,'_YALTITLESTAKEHOLDERS_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_COMMENTS')]");
	By btnInsert = By.xpath("//input[contains(@id,'YALTITLESTAKEHOLDERS_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
    By changesSavedSuccessfully = By.xpath("//span[contains(@id,'YALTITLESTAKEHOLDERS_usrMessage')]"); 
   
    
    public void ClickonAddNewButton() {	
    	util.waitUntilElementDisplay(navLessee);
    	util.click(navLessee);
    	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    	util.dummyWait(10);
    }
    
    public void SelectType(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpType, value);
	}
    
    public void AddLastName(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLastName, value);
	}
    
    public void AddFirstName(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFirstName, value);
	}
    
    public void AddMiddleName(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMiddleName, value);
	}
    
    public void AddTitle(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTitle, value);
	}
    
    public void SelectMaritalStatus(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTitle, value);
	}
    
    public void SelectGender(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpGender, value);
	}
    
    public void AddVendor(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtVendor, value);
	}
    
    public void AddEntityName(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEntityName, value);
	}
    
    public void SelectEntityType(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEntityType, value);
	}
    
    public void AddAddressLine1(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine1, value);
	}
    
    public void AddAddressLine2(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine2, value);
	}
    
    public void AddHomePhone(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtHomePhone, value);
	}
    
    public void AddCellPhone(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCellPhone, value);
	}
    
    public void AddCity(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCity, value);
	}
    
    
    public void SelectState() 
    {   util.waitUntilElementDisplay(drpState);
        util.click(drpState);
        util.waitUntilElementDisplay(SelectState);
        util.click(SelectState);
		
	}
    
    public void AddZipCode(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCode, value);
	}
    
    public void AddFaxNumber(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCode, value);
	}
    
    public void AddWorkPhone(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtWorkPhone, value);
	}
    
    public void AddAddressLine3(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine3, value);
	}
    
    public void AddEmail(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmail, value);
	}
    
    public void AddComments(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComments, value);
	}
    
    public void ClickonInsert() 
    {
    	util.waitUntilElementDisplay(btnInsert);
    	util.click(btnInsert);
    	util.dummyWait(5);
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
  		util.dummyWait(2);

	}
    
    
    public void AddLesseeRecord(Map<String, String> map, String testcaseName) {
    	
     	 try {
     		ClickonAddNewButton();
       	   log("STEP 1: Record should expands below ", Status.PASS);
       	} catch (Exception e) {
   		   log("STEP 1: Record does not expand below  ", Status.FAIL);
   		   throw new RuntimeException(" Failed in step 1 ");
   	    }
     	
     	 
     	 try {
     		SelectType(map.get(Excel.Type));
  	   			log("STEP 2: Added value displays in the Type field ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 2: User  cannot select  value  from Type DD ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 2");
  	   		}
     	 
     	try {
     		AddLastName(map.get(Excel.LastName));
  	   			log("STEP 3: User can enter a value in the LastName field   ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 3: User cannot add a value in the LastName field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 3");
  	   		}
     	
     	try {
     		AddFirstName(map.get(Excel.FirstName));
  	   			log("STEP 4: User can enter a value in the FirstName field   ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 4: User cannot add a value in the FirstName field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 4");
  	   		}
     	
     	try {
     		AddMiddleName(map.get(Excel.MiddleName));
  	   			log("STEP 5: User can enter a value in the MiddleName field  ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 5: User cannot add a value in the MiddleName field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 5");
  	   		}
    
     	
     	try {
     		AddTitle(map.get(Excel.Titles));
  	   			log("STEP 6: User can enter a value in the Title field  ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 6: User cannot add a value in the Title field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 6");
  	   		}
     	if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
     	
     	try {
     		SelectMaritalStatus(map.get(Excel.MaritalStatus));
  	   			log("STEP 7: Added value displays in the  Marital Status field   ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 7: User  cannot select  value  from the Marital Status DD ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 7");
  	   		}
     	
     	try {
     		SelectGender(map.get(Excel.Gender));
  	   			log("STEP 8: Added value displays in the  Gender field  ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 8: User  cannot select  value  from the Gender DD ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 8");
  	   		}
    }
//     	try {
//     		AddVendor(map.get(Excel.Vendor));
//  	   			log("STEP 9:  User can enter a value in the field    ", Status.PASS);
//  	   		} catch (Exception e) {
//  	   			log("STEP 9:  User cannot add a value in the field ", Status.FAIL);
//  	   			throw new RuntimeException("Failed in step 9");
//  	   		}
//    
    	try {
    		AddEntityName(map.get(Excel.EntityName));
  	   			log("STEP 10: User can enter a value in the Entity Name field  ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 10: User cannot add a value in the Entity Name field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 10");
  	   		}
    	
    	try {
    		SelectEntityType(map.get(Excel.EntityType));
  	   			log("STEP 11: User can enter a value in the Entity Type field ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 11: User cannot add a value in the Entity Type field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 11");
  	   		}
    	
    	try {
    		AddAddressLine1(map.get(Excel.AddressLine1));
  	   			log("STEP 12: User can enter a value in the Address Line1 field  ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 12: User cannot add a value in the Address Line1 field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 12");
  	   		}
    	
    	try {
    		AddAddressLine2(map.get(Excel.AddressLine2));
  	   			log("STEP 13: User can enter a value in the Address Line2 field ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 13: User cannot add a value in the Address Line2 field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 13");
  	   		}
    	
    	
    	try {
    		AddHomePhone(map.get(Excel.HomePhone));
  	   			log("STEP 14: User can enter a value in the Home Phone field ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 14: User cannot add a value in the Home Phone  field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 14");
  	   		}
    	
    	try {
    		AddCellPhone(map.get(Excel.CellPhone));
  	   			log("STEP 15: User can enter a value in the Cell Phone field  ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 15: User cannot add a value in the Cell Phone field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 15");
  	   		}
    	
    	try {
    		AddCity(map.get(Excel.City));
  	   			log("STEP 16: User can enter a value in City field  ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 16: User cannot add a value in City field ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 16");
  	   		}
    	
    	try {
    		SelectState();
  	   			log("STEP 17: Added value displays in State field  ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 17: User  cannot select  value  from State DD ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 17");
  	   		}
    	
    	try {
    		AddZipCode(map.get(Excel.ZipCode));
  	   			log("STEP 18: Added value displays in ZipCode field  ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 18: User  cannot select  value  from ZipCode DD ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 18");
  	   		}
    	
    	try {
    		AddFaxNumber(map.get(Excel.FaxNumber));
  	   			log("STEP 19: Added value displays in FaxNumber field   ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 19: User  cannot select  value  from FaxNumber DD ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 19");
  	   		}
    
    	try {
    		AddWorkPhone(map.get(Excel.WorkPhone));
  	   			log("STEP 20: Added value displays in WorkPhone field   ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 20: User  cannot select  value  from WorkPhone DD ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 20");
  	   		}
    	
    	try {
    		AddAddressLine3(map.get(Excel.AddressLine3));
  	   			log("STEP 21: Added value displays in Address Line3 field   ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 21: User  cannot select  value  from Address Line3 DD ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 21");
  	   		}
    	
    	try {
    		AddEmail(map.get(Excel.Email));
  	   			log("STEP 22: Added value displays in Email field   ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 22: User  cannot select  value  from Email DD ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 22");
  	   		}

     
    	try {
    		AddComments(map.get(Excel.Comments));
  	   			log("STEP 23: Entered value should display in the Comments field. ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 23: Entered value does not display in Comments field. ", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 23");
  	   		}
    	
    	try {
    		ClickonInsert();
  	   			log("STEP 24: User can click on Inser button ", Status.PASS);
  	   		} catch (Exception e) {
  	   			log("STEP 24: User cannot click on Insert button", Status.FAIL);
  	   			throw new RuntimeException("Failed in step 24");
  	   		}
    	
    }
}
