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

public class EditTitleTrackingRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditTitleTrackingRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navTitleTracking = By.xpath("//span[contains(text(),'Title Tracking')]");
	By txtTaxAccountNumber = By.xpath("//input[contains(@id,'_TITLETRACK_PROPERTY_TAX') and @type='text']");
	By txtGISIdentifier = By.xpath("//input[contains(@id,'_TITLETRACK_GISID') and @type='text']");
	By txtSecretaryofState = By.xpath("//input[contains(@id,'_TITLETRACK_STATE_SEC_FILENO') and @type='text']");
//	By btnSave = By.xpath("//input[contains(@id,'_TITLETRACK_btnSaveTractTitle')]");
	By btnSave = By.xpath("//input[contains(@id,'_TITLEASSIGNMENT_TractType_btnSaveTract')]");
	By successmassage = By.xpath("//span[contains(text(),'Changes Saved Successfully!')] | //span[contains(text(),'Changes saved successfully!')]");
	
	By btnSaveROW = By.xpath("//input[contains(@id,'TITLETRACK_btnSaveTractTitle')]");
	By successmassageROW = By.xpath("//span[contains(@id,'TITLETRACK_usrMessage')]");
	
	 public void ClickonTitleTracking() {
			util.waitUntilElementDisplay(navTitleTracking);
			util.click(navTitleTracking);
			util.dummyWait(2);
			util.waitUntilElementDisplay(navTitleTracking);
			util.click(navTitleTracking);
			
		}
	 
	 public void AddTaxAccountNumber(String value) {
		 util.dummyWait(1);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtTaxAccountNumber, value);
		}
	 
	 public void AddGISIdentifier(String value) {
		 util.dummyWait(1);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtGISIdentifier, value);
		}
	 
	 
	 public void AddSecretaryofState(String value) {
		 util.dummyWait(1);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSecretaryofState, value);
		}
	 
	 public void ClickonSavebutton() {
			util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.dummyWait(5);
			util.waitUntilElementDisplay(successmassage);
			Assert.assertTrue(util.isElementPresent(successmassage), "Changes saved successfully!");
	        util.dummyWait(2);

		}
	 
	 public void ClickonSavebuttonROW() {
			util.waitUntilElementDisplay(btnSaveROW);
			util.click(btnSaveROW);
			util.dummyWait(5);
			util.waitUntilElementDisplay(successmassageROW);
			Assert.assertTrue(util.isElementPresent(successmassageROW), "Changes saved successfully!");
	        util.dummyWait(2);

		}
	 
	 public void EditTitleTrackingRecord(Map<String, String> map, String testcaseName)
	 {
		 
		 try {
			   ClickonTitleTracking();
	    	   log("STEP 1: User can expand Title Tracking panel ", Status.PASS);
	    	} catch (Exception e) {
			   log("STEP 1: User cannot expand Title Tracking panel", Status.FAIL);
			   throw new RuntimeException(" Failed in step 1 ");
		   }
		 
		 try {
			 AddTaxAccountNumber(map.get(Excel.UpdatedTaxAccountNumber));
	    	   log("STEP 2: User can update Tax Account Number ", Status.PASS);
	    	} catch (Exception e) {
			   log("STEP 2: User cannot update Tax Account Number", Status.FAIL);
			   throw new RuntimeException(" Failed in step 2 ");
		   }
		 
		 try {
			 AddGISIdentifier(map.get(Excel.UpdatedGISIdentifier));
	    	   log("STEP 3: User can update GIS Identifies ", Status.PASS);
	    	} catch (Exception e) {
			   log("STEP 3: User cannot update GIS Identifier", Status.FAIL);
			   throw new RuntimeException(" Failed in step 3");
		   }
		 
		 try {
			   AddSecretaryofState(map.get(Excel.UpdatedSecretaryofState));
	   			log("STEP 4: User can update Secretary of State", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 4: User cannot update Secretary of State ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 4");
	   		}
		
		 
		 if(util.isElementPresent(btnSaveROW)) {
			 try {
				 ClickonSavebuttonROW();
		   			log("STEP 5: Title Tracking record successfully saved", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 5:Title Tracking record does not saved", Status.FAIL);
		   			throw new RuntimeException("Failed in step 5");
		   		}
		 }else {
		 try {
			 ClickonSavebutton();
	   			log("STEP 5: Title Tracking record successfully saved", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 5:Title Tracking record does not saved", Status.FAIL);
	   			throw new RuntimeException("Failed in step 5");
	   		}
		 }
		 

	 }
}
