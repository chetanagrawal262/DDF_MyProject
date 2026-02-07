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

public class EditEasementRecordPage extends BasePage{

	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditEasementRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navEasementsRecord = By.xpath("//span[contains(text(),'Easements, Plats, Oil & Gas Leases')]");
	By btnEdit = By.xpath("//input[contains(@id,'TEASEMENT_radYALGridControl_ctl00_ctl04_EditButton')]");
	By txtDocumentNo  = By.xpath("//input[contains(@id,'_EditFormControl_DOCUMENT_NUMBER') and @type='text']");
	By txtImageNo  = By.xpath("//input[contains(@id,'_EditFormControl_IMAGE_NUMBER') and @type='text']");
	By btnUpdate = By.xpath("//input[contains(@id,'TEASEMENT_radYALGridControl_ctl00_ctl05_EditFormControl_btnUpdate')]");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	
	
	public void ClickonEdit() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    	util.waitUntilLoaderDisappear();
    }
    
	   public void AddDocumentNo(String value) 
	    {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentNo, util.randomNumber());
		}
	    public void AddImageNo(String value) 
	    {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtImageNo, util.randomNumber());
		}
	
    
       public void ClickonUpdate() {
	   
	   util.waitUntilElementDisplay(btnUpdate);
   	    util.click(btnUpdate);
   	 util.waitUntilLoaderDisappear();
   	    util.waitUntilElementDisplay(changesSavedSuccessfully);
	   Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
       }
	
       public void EditEasementRecord(Map<String, String> map, String testcaseName) {
    	    
    	   try {
    		   ClickonEdit();
        	   log("STEP 1: User can click on Edit icon", Status.PASS);
        	} catch (Exception e) {
    		   log("STEP 1: User cannot click on Edit icon ", Status.FAIL);
    		   throw new RuntimeException(" Failed in step 1 ");
    	    }
    	   
    	   try {
    		   AddDocumentNo(map.get(Excel.DocumentNo));
      		   util.dummyWait(2);
        	   log("STEP 2: User can update Document No", Status.PASS);
        	} catch (Exception e) {
    		   log("STEP 2: User cannot update Document No", Status.FAIL);
    		   throw new RuntimeException(" Failed in step 2 ");
    	    }
    	   
    	   try {
      		   AddImageNo(map.get(Excel.ImageNo));
    	   			log("STEP 3:  User can update Image No ", Status.PASS);
    	   		} catch (Exception e) {
    	   			log("STEP 3:  User cannot update Image No ", Status.FAIL);
    	   			throw new RuntimeException("Failed in step 3");
    	   		}
      	 
    	   try {
    		   ClickonUpdate();
        	   log("STEP 4: Changes saved successfully! message should be display above grid ", Status.PASS);
        	} catch (Exception e) {
    		   log("STEP 4: User cannot click on update button or success message does not display  ", Status.FAIL);
    		   throw new RuntimeException(" Failed in step 4 ");
    	    }
	
       }
}
