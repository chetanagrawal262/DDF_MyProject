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

public class EditLesseeRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditLesseeRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnEdit = By.xpath("//input[contains(@id,'YALTITLESTAKEHOLDERS_radYALGridControl_ctl00_ctl04_EditButton')]");
	By txtLastName = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_First_Name') and @type='text']");
	By txtMiddleName = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Middle_Name') and @type='text']");
	By btnUpdate = By.xpath("//input[contains(@id,'YALTITLESTAKEHOLDERS_radYALGridControl_ctl00_ctl05_EditFormControl_btnUpdate')]");
	By changesSavedSuccessfully = By.xpath("//span[contains(@id,'YALTITLESTAKEHOLDERS_usrMessage')]");

	
	public void ClickonEdit() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
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
    
    By txtEntityName = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Corporation_Trust') and @type='text']");
    public void AddEntityName(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEntityName, value);
	}
       public void ClickonUpdate() {
	   
	   util.waitUntilElementDisplay(btnUpdate);
   	    util.click(btnUpdate);
   	    util.dummyWait(5);
   	    util.waitUntilElementDisplay(changesSavedSuccessfully);
	   Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
   util.dummyWait(2);
       }
	
       public void EditLesseeRecord(Map<String, String> map, String testcaseName) {
    	    util.dummyWait(10);
    	    
    	    
    	   try {
    		   ClickonEdit();
        	   log("STEP 1: User can click on Edit Icon", Status.PASS);
        	} catch (Exception e) {
    		   log("STEP 1: User cannot click on Edit Icon ", Status.FAIL);
    		   throw new RuntimeException(" Failed in step 1 ");
    	    }
    	   
    	   try {
    		   AddLastName(map.get(Excel.LastName));
      		   util.dummyWait(2);
        	   log("STEP 2: User can update Last Name", Status.PASS);
        	} catch (Exception e) {
    		   log("STEP 2: User cannot update Last Name ", Status.FAIL);
    		   throw new RuntimeException(" Failed in step 2 ");
    	    }
    	   
    	   try {
    		   AddFirstName(map.get(Excel.FirstName));
      		   util.dummyWait(2);
        	   log("STEP 3: User can update First Name", Status.PASS);
        	} catch (Exception e) {
    		   log("STEP 3: User cannot update First Name ", Status.FAIL);
    		   throw new RuntimeException(" Failed in step 3 ");
    	    }
    	   
    	   try {
      		   AddMiddleName(map.get(Excel.MiddleName));
    	   			log("STEP 4:  User can update Middle Name   ", Status.PASS);
    	   		} catch (Exception e) {
    	   			log("STEP 4:  User cannot update Middle Name  ", Status.FAIL);
    	   			throw new RuntimeException("Failed in step 4");
    	   		}
    	   
    	   if(testcaseName.contains("ORSTED")) {
    		   AddEntityName(map.get(Excel.EntityName));
   	    }
    	   
    	   try {
    		   ClickonUpdate();
        	   log("STEP 5: User can click on update button and success message successfully display ", Status.PASS);
        	} catch (Exception e) {
    		   log("STEP 5: User cannot click on update button or success message does not display ", Status.FAIL);
    		   throw new RuntimeException(" Failed in step 5 ");
    	    }
	
       }

}
