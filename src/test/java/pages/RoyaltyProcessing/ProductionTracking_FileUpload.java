package pages.RoyaltyProcessing;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ProductionTracking_FileUpload extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ProductionTracking_FileUpload(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	 By fileUpload = By.xpath("//input[contains(@id,'ruProdfile0')]");
		public void uploadFile() {
			String filepath = System.getProperty("user.dir") + File.separator + "1012-ProductionData.xls";
			driver.findElement(fileUpload).sendKeys(filepath);
			util.dummyWait(2);
		}
	By btnUpload = By.xpath("//input[contains(@id,'btnUpload')]");
	public void ClickOnUploadButton() {
		util.waitUntilElementDisplay(btnUpload);
		util.click(btnUpload);
	}
		By SuccessMessage = By.xpath("//span[@id='ctl00_ConPHRightTop_usrMessage']");
		
		public void FileUpload(String testcaseName) {

			try {
				util.dummyWait(2);
				uploadFile();
				log("STEP 2: user can able to click on select button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: user cannot able to click on select button", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				ClickOnUploadButton();
				log("STEP 3: user can able to click on Upload button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user cannot able to click on Upload button", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 3: \"upload process successfully\" message should be displayed     ", Status.PASS);
				} else {
				   log("STEP 3: \"upload process successfully\" message not displays ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 3 ");
		   	} 
			
		}

}
