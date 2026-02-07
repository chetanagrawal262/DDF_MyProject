package pages.PermanentInfrastructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DeleteMetTowerRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DeleteMetTowerRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnDelete = By.xpath("//input[contains(@id,'_METTOWER_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment') and @type='image']");
	By iframeDelete = By.xpath("//tr//td[@class='rwWindowContent']");
	By btnCancel = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By SuccessfulMessage = By.xpath("//span[text()='Changes saved successfully!']");
	
	public void ClickOnDeleteButton() {
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
	}
	
	public void ClickOnCancelButton() {
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
	}
	
	public void ClickOnOkButton() {
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
		util.waitUntilElementDisplay(btnOk);
		util.click(btnOk);
		util.dummyWait(5);
		util.waitUntilElementDisplay(SuccessfulMessage);
		Assert.assertTrue(util.isElementPresent(SuccessfulMessage), "Changes saved successfully!");
	}
	
	public void DeleteMetTowerRecord(String testcaseName) {
		
		 try {
			 ClickOnDeleteButton();
  			 log("STEP 1: Popup Delete should be open with OK and Cancel button ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  1: Popup Met Tower does not open ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		 }
		 
		 try {
			 ClickOnCancelButton();
  			 log("STEP 2: Delete popup should Close and Met Tower record should not delete ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  2: unable to click  Cancel button OR popup does not close ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		 }
		util.dummyWait(3);
		 try {
			 ClickOnOkButton();
  			 log("STEP 3: Message \"Changes saved successfully!\" should be display above the grid", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  3:  unable to click  OK button OR popup does not close ", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		 }
	}
}

