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

public class EditDocumentVestingOwnershipRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditDocumentVestingOwnershipRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navDocumentVestingOwnership  = By.xpath("//span[contains(text(),'Document Vesting Ownership')]");
	By btnEdit = By.xpath("//input[contains(@id,'VESTING_radYALGridControl_ctl00_ctl04_EditButton')]");
	By txtVolume = By.xpath("//input[contains(@id,'_VESTING_radYALGridControl_ctl00_ctl05_EditFormControl_VOLUME') and @type='text']");
	By txtPage = By.xpath("//input[contains(@id,'_VESTING_radYALGridControl_ctl00_ctl05_EditFormControl_DPAGE') and @type='text']");
    By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");

    public void ClickonEdit() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    	util.waitUntilLoaderDisappear();
    }
    
    
    public void AddVolume(String value) 
    {
    	util.waitUntilElementDisplay(txtVolume);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtVolume, value);
	}
    
    public void AddPage(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPage, value);
	}
    
   public void ClickonUpdate() {
	   
	   util.waitUntilElementDisplay(btnUpdate);
   	util.click(btnUpdate);
   	util.waitUntilLoaderDisappear();
   	util.waitUntilElementDisplay(btnEdit);
	Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
   }
    
   public void EditDocumentVestingOwnershipRecord(Map<String, String> map, String testcaseName) {
    
	   try {
		   ClickonEdit();
    	   log("STEP 1: User can click on Edit icon", Status.PASS);
    	} catch (Exception e) {
		   log("STEP 1:User cannot click on Edit icon ", Status.FAIL);
		   throw new RuntimeException(" Failed in step 1 ");
	    }
	   
	   try {
  		     AddVolume(map.get(Excel.Volume));
	   			log("STEP 2:  Entered value should displays in the respective (Volume) fields.   ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 2:   Entered value does not display in the volume field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 2");
	   		}
	   
	   try {
	  		 AddPage(map.get(Excel.Page));
		   		log("STEP 3:  Entered value should displays in the respective (Page) fields.   ", Status.PASS);
		   } catch (Exception e) {
		   		log("STEP 3:   Entered value does not display in the Page field. ", Status.FAIL);
		   		throw new RuntimeException("Failed in step 3");
		   	}
  	 
	   try {
		   ClickonUpdate();
    	   log("STEP 4:User can click on update button", Status.PASS);
    	} catch (Exception e) {
		   log("STEP 4: User cannot click on udpate button", Status.FAIL);
		   throw new RuntimeException(" Failed in step 4 ");
	    }
	   
	   
   }
   
    
}
