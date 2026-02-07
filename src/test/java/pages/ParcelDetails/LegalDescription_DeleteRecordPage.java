package pages.ParcelDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class LegalDescription_DeleteRecordPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public LegalDescription_DeleteRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navLegalDescription = By.xpath("//span[text()='Legal Description']");
	By btnDelete = By.xpath("//input[contains(@id,'_LEGALDESC_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
	By btnDeleteRow = By.xpath("//input[contains(@id,'gridCustomLegalDesc_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')] | //input[contains(@id,'LEGALDESC_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
	By frmDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnCancel = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
	
       public void ClickOnDelete()
       {
    	   util.waitUntilElementDisplay(btnDelete);
    	   util.click(btnDelete);
       }
	
       public void ClickOnDeleteROW()
       { 
    	   util.waitUntilElementDisplay(btnDeleteRow);
    	   util.click(btnDeleteRow);
       }

       public void ClickOnCancel()
       {
    	   util.dummyWait(2);
    	   util.waitUntilElementDisplay(btnCancel);
    	   util.click(btnCancel);
       }


       public void ClickOnOK()
       {
    	   util.waitUntilElementDisplay(btnDelete);
    	   util.click(btnDelete);
    	   util.dummyWait(2);
    	   util.waitUntilElementDisplay(btnOk);
    	   util.click(btnOk);
    	   util.waitUntilElementDisplay(SuccessMessage);
    	   Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
       }
       
       public void ClickOnOKRow()
       {
    	   util.waitUntilElementDisplay(btnDeleteRow);
    	   util.click(btnDeleteRow);
    	   util.dummyWait(2);
    	   util.waitUntilElementDisplay(btnOk);
    	   util.click(btnOk);
    	   util.waitUntilElementDisplay(SuccessMessage);
    	   Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
       }
       
       
       public void LegalDescription_DeleteRecord(String testcaseName) {
    	   
    	   if (testcaseName.contains("DOT")) {
   			log("Delete Legal Description record not applicable for DOT ", Status.SKIP);
   		}
   		else {
util.dummyWait(5);
    	   if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL"))
    	   {
	    	try {
	    		ClickOnDelete();
				log("STEP 1: Popup Delete should be open with OK and Cancel button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Popup Delete does not open", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	    	
	    	try {
	    		ClickOnCancel();
				log("STEP 2: Delete popup should Close and Legal Description record should not delete ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  Legal Description record deleted", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

	    	try {
	    		ClickOnOK();
				log("STEP 3: Delete popup should Close and Legal Description record should get deleted ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  Legal Description record does not deleted ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
	    	
	    	
    	   }
    	   
    	   
    	   else
    	   {
    		   try {
   	    		ClickOnDeleteROW();
   				log("STEP 1:  Popup Delete should be open with OK and Cancel button  ", Status.PASS);
   			} catch (Exception e) {
   				log("STEP 1:  Popup Delete does not open ", Status.FAIL);
   				throw new RuntimeException("Failed in step 1");
   			}  
    		   
    		   try {
   	    		ClickOnCancel();
   				log("STEP 2: Delete popup should Close and Legal Description record should not delete ", Status.PASS);
   			} catch (Exception e) {
   				log("STEP 2:  Legal Description record deleted", Status.FAIL);
   				throw new RuntimeException("Failed in step 2");
   			}
util.dummyWait(5);
   	    	try {
   	    		ClickOnOKRow();
   				log("STEP 3: Delete popup should Close and Legal Description record should get deleted ", Status.PASS);
   			} catch (Exception e) {
   				log("STEP 3:  Legal Description record does not deleted ", Status.FAIL);
   				throw new RuntimeException("Failed in step 3");
   			}
   	    	
    	   }

       }
    }
}
