package pages.ParcelDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;



public class ParcelSummary_AddParcelSummaryPage extends BasePage {

	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ParcelSummary_AddParcelSummaryPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')]");
	By ParcelSummary = By.xpath("(//div[@class='rdTitleBar'])[3]");
	By frmParcelSummary = By.xpath("//div[@id='ctl00_ConPHRightTop_TRPI_UC_radPrjPanels_i0_i0_TractSS_RadDockZone2']");
	By btnActive = By.xpath("//input[contains(@id,'takeOffline')]");
	By getStrParcelNo = By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]");		
	By getParcelNoSummary = By.xpath("(//*[contains(@id,'TractSS_RadDockTractSS_C_tractInfo')]/..//*[contains(text(),'Parcel #') or contains(text(),'Tract #') or contains(text(),'Orion PID') or contains(text(),'Nova Parcel ID') or contains(text(),'Orsted ') or contains(text(),'Document Number')]/../..//td[2])[1]");

	By getStrParcelNoDot = By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]");

    
	By getParcelNoSummaryDot = By.xpath("//*[contains(@id,'TractSS_RadDockTractSS_C_tractInfo')]/..//*[contains(text(),'Parcel #') or contains(text(),'Tract #') or contains(text(),'Orion PID')  or contains(text(),'Orsted ')]/..//strong");
	
	
	
	public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
		
		
	}
	
	public void ParcelSummary() throws InterruptedException {
		String getStrParcelNo = driver
				.findElement(By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]")).getAttribute("value");		
		
		String getParcelNoSummary = driver
				.findElement(By.xpath("//td[contains(@id,'tractInfo')]/..//*[text()='Parcel #:']/..//td[2] | //td[contains(@id,'tractInfo')]/..//*[contains(text(),'Tract #')]/..//td[2] | //td[contains(@id,'tractInfo')]/..//*[text()='Location #:' or text()='Tract Number:']/..//td[2] | //td[contains(@id,'tractInfo')]/..//*[text()='ID:']/..//td[2] | //td[contains(@id,'tractInfo')]/..//*[contains(text(),'Document Number:')]/..//td[2]")).getText();
		
		
		
		if (getParcelNoSummary.equals(getStrParcelNo)) {
			log("STEP 1:  Parcel Number  Matched !!! ", Status.PASS);
			
		} else {
			log("STEP 1: Parcel Number Not Matched !!!", Status.FAIL);
		}
		
		

	}
	
	private void ParcelNumber() {
		String ParcelNo = util.getAttributeValue(getStrParcelNo, "value");
		ExtentTestManager.info("User typed: " + ParcelNo);
		util.dummyWait(2);
		ExtentTestManager.info("Verify Parcel Summary No: " + ParcelNo);
		
	}
	
	
	
	public void ParcelSummaryDot() throws InterruptedException {
		String getStrParcelNo = driver
				.findElement(By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]")).getAttribute("value");
	
        
		String getParcelNoSummary = driver
				.findElement(By.xpath("//td[contains(@id,'tractInfo')]/..//*[text()='Parcel #:']/../..//td[2] | //td[contains(@id,'tractInfo')]/..//*[text()='Orion PID:']/../..//td[2] | //td[contains(@id,'tractInfo')]/..//*[text()='Nova Parcel ID:']/../..//td[2] | //td[contains(@id,'tractInfo')]/..//*[text()='Orsted PIN:']/../..//td[2]")).getText();
		
		
		

		 if(getParcelNoSummary.equals(getStrParcelNo)) {
			System.out.println(getStrParcelNo);
			System.out.println(getParcelNoSummary);
			System.out.println(getParcelNoSummary.equals(getStrParcelNo));
			System.out.println(" Parcel Number  Matched !!!");
			log("STEP 1:  Parcel Number  Matched !!! ", Status.PASS);
			log("STEP 1:  Parcel summary should be displayed with all parcel details & active button. ", Status.PASS);
		} else {
			System.out.println("Parcel Number Not Matched !!!");
			log("STEP 1: Parcel Number Not Matched !!!", Status.FAIL);
			log("STEP 1: Parcel summary contains no data", Status.FAIL);
		}

	}
	
	private void verifyParcelSummaryNumberDot() {
		String ParcelNoDot = util.getAttributeValue(getStrParcelNoDot, "value");
		ExtentTestManager.info("User typed: " + ParcelNoDot);
		ExtentTestManager.info("Verify Summary No: " + ParcelNoDot);

	}
	
	
	 public void AddParcelSummary(String testcaseName) throws InterruptedException {
		 if(!util.isElementVisible(getStrParcelNo)) {
			 driver.close();
			 util.switchToParentWindow(); 
		 }
		 verifyParcelSummaryNumberDot();
	    		  ParcelSummaryDot();
		    
	 
	    	util.dummyWait(3);
	 }
}
