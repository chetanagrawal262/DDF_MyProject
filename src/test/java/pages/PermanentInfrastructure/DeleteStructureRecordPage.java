package pages.PermanentInfrastructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DeleteStructureRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DeleteStructureRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnDelete = By.xpath("//input[contains(@id,'customFields2') and @title='Delete']");
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
		util.dummyWait(1);
	}
	
	public void DeleteStructureRecord(String testcaseName) {
		
		try {
			 ClickOnDeleteButton();
  			 log("STEP 1: User can click on 'x' Icon to delete the record ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  1: User cannot click on 'x' Icon to delete the record ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		 }
		 
		 try {
			 ClickOnCancelButton();
  			 log("STEP 2: User can Cancel the Delete Process ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  2: User cannot Cancel the Delete Process ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		 }
		
		 try {
			 ClickOnOkButton();
  			 log("STEP 3: User can Delete the record", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP  3:  User cannot Delete the record ", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		 }
		 
		 try {
			 Assert.assertTrue(util.isElementVisible(SuccessfulMessage));
  			 log("STEP 4: User can see the success message", Status.PASS);
  		 } catch (AssertionError e) {
  			log("STEP  4:  User cannot see the success message ", Status.FAIL);
  		 }
	}

	
}
