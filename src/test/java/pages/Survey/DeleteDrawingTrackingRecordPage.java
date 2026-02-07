package pages.Survey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DeleteDrawingTrackingRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DeleteDrawingTrackingRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By btnDelete = By.xpath("//input[contains(@id,'_gbcDeleteAlignment') and @type='image']");
	By iframeDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnCancel = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
	
	
	public void ClickonDeleteButton() {
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
	}
	
	public void ClickonCancel() {
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
	}
	
	public void ClickonOk() {
		util.dummyWait(2);
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
		util.click(btnOk);
		util.dummyWait(2);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
		util.dummyWait(5);
	}
	
	public void DeleteDrawingTrackingRecord(String testcaseName) {
		if (testcaseName.contains("DOT") || environment.contains("ALT")) {
			log(" Delete Drawing Tracking Record not applicable for DOT and ALT", Status.SKIP);
		}
		else {
		 try {
			 ClickonDeleteButton();
  			 log("STEP 1:  Popup Delete should be open with OK and Cancel button  ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  1:  Popup Drawing Tracking does not open  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		 }
		
		 try {
			 ClickonCancel();
  			 log("STEP 2:  Delete popup should Close and Drawing Tracking record should not delete  ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  2:   unable to click  Cancel button OR popup does not close   ", Status.FAIL);
  			throw new RuntimeException("Failed in step 2");
  		 }
		 
		 try {
			 ClickonOk();
  			 log("STEP 3:  Message \"Changes saved successfully!\" should be display above the grid  ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  3:  unable to click  OK button OR popup does not close  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		 }
	  }
	
	}
	
}
