package pages.RoyaltyProcessing;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;
import pages.InfoByParcelReport.AddProjectPage;
import pages.RoyaltyPayment.AddNewPayeeInfoPage;

public class RoyaltyPaymentsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	SoftAssert sf = new SoftAssert();

	public RoyaltyPaymentsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navPaymentManager = By.xpath("//span[text()='Payment Manager']");
	By navRoyaltyProcessing = By.xpath("//span[contains(text(),'Royalty Processing')]");
	By navRoyaltyPayments = By.xpath("//span[contains(text(),'Royalty Payments')]");
	By LinkProcess = By.xpath("(//a[text()='Process'])[1]");
	By LinkProcessClosed = By.xpath("(//a[text()='Process(Closed)'])[1]");
	By LinkUnlockRevenue = By.xpath("(//a[text()='Unlock Revenue'])[1]");
	By LinkUnlockProduction = By.xpath("(//a[text()='Unlock Production'])[1]");
	By LinkViewReport = By.xpath("(//a[text()='View Report'])[1]");
	By btnProcessAllRoyalty = By.xpath("//input[@id='processAllPayments']");
	
	public void navigateToRoyaltyPayments() {
  		util.waitUntilElementDisplay(navProject);
  		util.click(navProject);
  		util.waitFor(100);
  		if(util.isElementVisible(navRoyaltyProcessing)) {
  		util.waitUntilElementDisplay(navRoyaltyProcessing);
  		util.waitFor(100);
  		util.hoverOnElement(navRoyaltyProcessing);
  		util.waitUntilElementDisplay(navRoyaltyPayments);
  		util.click(navRoyaltyPayments);
  		}else {
  			util.hoverOnElement(navPaymentManager);
  			util.click(navPaymentManager);
  			util.waitUntilElementDisplay(navRoyaltyPayments);
  	  		util.click(navRoyaltyPayments);
  		}
 }
	
	public void ClickOnProcessLink(By xpath) {
		util.waitUntilElementDisplay(xpath);
		util.click(xpath);
	}
	
	By iframe = By.xpath("//iframe[@name='royaltyPayments']");
	public void ClickOnUnlockRevenue() {
		util.waitUntilElementDisplay(LinkUnlockRevenue);
		util.click(LinkUnlockRevenue);
		util.switchToIframe(iframe);
	}
	
	By Successmessage = By.xpath("//span[@id='usrMessage']");
	
	By btnClose = By.xpath("//a[@title='Close']");
	public void ClickOnClose() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
	}
	
	public void ClickOnUnlockProduction() {
		util.waitUntilElementDisplay(LinkUnlockProduction);
		util.click(LinkUnlockProduction);
		util.switchToIframe(iframe);
	}
	
	public void ClickOnViewReportLink(By xpath) {
		util.waitUntilElementDisplay(xpath);
		util.click(xpath);
	}
	
    public void RoyaltyPayments(Map<String, String> map, String testcaseName)  {
      
    	try {
    		navigateToRoyaltyPayments();
			log("STEP 1:user can navigate to payment  Manager.", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: user cannot navigate to payment Manager. ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    	
//    	if(util.isElementPresent(LinkUnlockRevenue)) {
//		try {
//			ClickOnUnlockRevenue();
//			log("STEP 4: user can click on unlock revenue link.", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 4: user cannot  click on unlock revenue link. ", Status.FAIL);
//			throw new RuntimeException("Failed in step 4");
//		}
//		
//		if (util.isElementPresent(Successmessage)) {
//			log("New popup will be opened which contains detail information.", Status.PASS);
//		} else {
//			log("user cannot  click on unlock revenue link.", Status.FAIL);
//		}
//		ClickOnClose();
//    	}
//    	
//		if(util.isElementPresent(LinkUnlockProduction)) {
//		try {
//			ClickOnUnlockProduction();
//			log("STEP 5: user can click on unlock production  link. ", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 5: user cannot  click on unlock production  link. ", Status.FAIL);
//			throw new RuntimeException("Failed in step 5");
//		}
//		
//		if (util.isElementPresent(Successmessage)) {
//			log("New popup will be opened which contains detail information.", Status.PASS);
//		} else {
//			log("user cannot  click on unlock production  link.", Status.FAIL);
//		}
//		ClickOnClose();
//		}
		//
    	
    	By LinkViewReport = By.xpath("(//*[text()='"+AddProjectPage.PN+"']/..//a[text()='View Report'])[1]");
		if(util.isElementPresent(LinkViewReport)) {
		try {
			ClickOnViewReportLink(LinkViewReport);
			util.switchToChildWindow();
			By landowner = By.xpath("(//*[text()='"+AddNewPayeeInfoPage.LANDOWNER+"'])[1]");
			sf.assertTrue(util.isElementVisible(landowner), "Landowner "+ AddNewPayeeInfoPage.LANDOWNER+" is not displaying on report window");
			driver.close();
			util.switchToParentWindow();
			util.dummyWait(1);
			log("STEP 2: user can click on view report link. ", Status.PASS);
		} catch (AssertionError e) {
			ExtentTestManager.infoWithScreenshot("Report Result");
			driver.close();
			util.switchToParentWindow();
			log("STEP 2: user cannot  click on view report  link.", Status.FAIL);
			
		}
		}
		
		By LinkProcess = By.xpath("(//*[text()='"+AddProjectPage.PN+"']/..//a[text()='Process'])[1]");
		if(util.isElementPresent(LinkProcess)) {
			try {
				ClickOnProcessLink(LinkProcess);
				util.switchToChildWindow();
				By landowner = By.xpath("(//*[text()='"+AddNewPayeeInfoPage.LANDOWNER+"'])[1]");
				By payment = By.xpath("(//*[text()='"+map.get("Royalty Amount")+"'])[1]");
				sf.assertTrue(util.isElementVisible(landowner), "Landowner "+ AddNewPayeeInfoPage.LANDOWNER+" not displaying on the process popup");
				sf.assertTrue(util.isElementVisible(payment), "Roylaty Payment "+ map.get("Royalty Amount")+" not displaying on the process popup");
				ExtentTestManager.infoWithScreenshot("Process all royalty");
				log("STEP 3: New popup will be opened which contains detail information. ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 3:  user cannot  click on process link. ", Status.FAIL);
			}
	    	}else {
	    		log("STEP 3:  Process Link not Available ", Status.SKIP);
	    	}
		
		try {
			util.click(btnProcessAllRoyalty);
			driver.switchTo().alert().accept();
			util.waitFor(500);
			driver.close();
			util.switchToParentWindow();
			log("STEP 4: User can click on Process All Royalty button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot click on Process All Royalty button", Status.FAIL);
		}
		
		try {
			util.reloadPage();
			util.dummyWait(1);
			By LinkProcessClosed = By.xpath("(//*[text()='"+AddProjectPage.PN+"']/..//a[text()='Process(Closed)'])[1]");
			Assert.assertTrue(util.isElementVisible(LinkProcessClosed));
			log("STEP 5: User can see process (closed) link", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User cannot see process (closed) link", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		sf.assertAll();
    }
}
