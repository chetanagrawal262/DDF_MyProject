package pages.Negotiations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class LandInventory_DeleteLandInventoryPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public LandInventory_DeleteLandInventoryPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	
	By btnDelete = By.xpath("//input[contains(@id,'_ACQDIMENSIONS_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
	By btnCancle = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	
	
	
	
	 public void ClickonDelete() {
	  		util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);
	  		
	  		
	    }
	
	 
	 public void ClickonCancle() 
	 {
	  		util.waitUntilElementDisplay(btnCancle);
	  		util.click(btnCancle);
	  		
	  		
	    }
	 
	 
	 public void ClickonOk() 
	 {
		    util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);	
	  		util.waitUntilElementDisplay(btnOk);
	  		util.click(btnOk);
	  		util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	  		
	  		
	    }
	 
	 
 public void DeleteLandInventory(String testcaseName) {
		 
		 try {
			 ClickonDelete();
				log("STEP 1: Popup Delete should be open with OK and Cancel button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  Popup Delete does not open", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}
	 
		 
		 
		 try {
			 ClickonCancle();
				log("STEP 2: Delete popup should Close and Legal Description record should not delete", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: unable to click  Cancel button OR popup does not close", Status.FAIL);
				throw new RuntimeException("Failed in step 2 ");
			}
		 
		 try {
			 ClickonOk();
				log("STEP 3: Message \"Changes saved successfully!\" should be display above the grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  Legal Description record does not deleted", Status.FAIL);
				throw new RuntimeException("Failed in step 3 ");
			
			}
 }
				
}



