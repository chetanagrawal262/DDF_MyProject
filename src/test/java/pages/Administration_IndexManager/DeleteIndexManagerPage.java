package pages.Administration_IndexManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DeleteIndexManagerPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DeleteIndexManagerPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	
	By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteAlignment')])[1]");
	By iframDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnCancle = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	
	
	
	
	 public void ClickonDelete() {
	  		util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);
	  		
	  		
	    }
	
	 
	 public void ClickonCancle()  {
	    driver.switchTo().alert().dismiss();
	  		
	    }
	 
	 
	 public void ClickonOk() 
	 {util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
		 driver.switchTo().alert().accept();
	  		util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	  		
	  		
	    }
	 
	 
 public void DeleteIndexManager(String testcaseName) {
		 
		 try {
			 ClickonDelete();
				log("STEP 1:  user can click on cross icon   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  Popup Delete does not open", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}
	 
		 
		 
		 try {
			 ClickonCancle();
				log("STEP 2: User can click on cancel button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on cancel button", Status.FAIL);
				throw new RuntimeException("Failed in step 2 ");
			}
		 
		 try {
			 ClickonOk();
				log("STEP 3: Deleted record does not display in the grid and 2)Message- Changes saved suessfully! in green displays. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: Message- Changes saved sucessfully' does not display", Status.FAIL);
				throw new RuntimeException("Failed in step 3 ");
			
			}
		 
    }
 
	
}
