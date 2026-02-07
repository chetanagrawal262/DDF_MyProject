package pages.RoyaltyProcessing;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import pages.InfoByParcelReport.AddProjectPage;

public class RevenueDataPage  extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;

	public RevenueDataPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navProject = By.xpath("//span[text()='Project']");
	By navRevenueManager = By.xpath("//span[text()='Revenue Manager']");
	By navRoyaltyProcessing = By.xpath("//span[contains(text(),'Royalty Processing')]");
	By navRevenueData = By.xpath("//span[contains(text(),'Revenue Data') and @class='rmText']");
	By drpYear = By.xpath("//input[contains(@id,'YALRevenueManager_ddlYear') and @type='text']");
	By drpPeriod = By.xpath("//input[contains(@id,'YALRevenueManager_ddlPD') and @type='text']");
	By btnView = By.xpath("//input[contains(@id,'YALRevenueManager_btnView') and @type='image']");
	By txtMWH = By.xpath("(//input[contains(@id,'RNTB_REVMWH') and @type='text'])[1]");
	By txtSelesRevenue = By.xpath("(//input[contains(@id,'RNTB_SALESREV') and @type='text'])[1]");
	By txtRecRevenue = By.xpath("(//input[contains(@id,'RNTB_RECREV') and @type='text'])[1]");
	By txtBilateralTradeRevenue = By.xpath("(//input[contains(@id,'RNTB_BILAT') and @type='text'])[1]");
	By btnSave = By.xpath("(//input[contains(@id,'btnUpdateAll') and @type='image'])[1]");
	By btnApprove = By.xpath("(//input[contains(@id,'btnApprove') and @type='image'])[1]");
	By ExcelIcon = By.xpath("//img[contains(@src,'ExportToExcel')]");
	By SuccessMessage = By.xpath("//span[text()='Revenue approved']");
	By alreadyApproved = By.xpath("//*[text()='Revenue data for this period has already been approved, and cannot be modified']");
	
	 public void navigateToRevenueData() {
	  		util.waitUntilElementDisplay(navProject);
	  		util.click(navProject);
	  		
	  		if(!util.isElementVisible(navRevenueManager)) {
	  		util.waitUntilElementDisplay(navRoyaltyProcessing);
	  		util.waitFor(100);
	  		util.hoverOnElement(navRoyaltyProcessing);
	  		util.waitUntilElementDisplay(navRevenueData);
	  		util.click(navRevenueData);}
	  		else {
	  			util.hoverOnElement(navRevenueManager);
	  			util.click(navRevenueManager);
	  		}
	 }
	
	public void SelectYear(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpYear, value);
		util.dummyWait(1);
	}
	
	public void SelectPeriod(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpPeriod, value);
		util.dummyWait(2);
	}
	
	public void ClickOnView() {
		util.waitUntilElementDisplay(btnView);
		util.click(btnView);
		util.dummyWait(3);
	}
	
	public void AddMWH(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtMWH, value);
	}
	
	public void AddSelesRevenue(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtSelesRevenue, value);
	}
	
	public void AddRecRevenue(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtRecRevenue, value);
	}
	
	public void AddBilateralTradeRevenue(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtBilateralTradeRevenue, value);
	}
	
	public void ClickOnSave() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(2);
	}
	
	public void ClickOnApproveButton() {
		util.waitUntilElementDisplay(btnApprove);
		util.click(btnApprove);
		util.dummyWait(2);
	}
	
	public void ClickOnExcelIcon() {
		util.waitUntilElementDisplay(ExcelIcon);
		util.click(ExcelIcon);
	}
	
	 public void RevenueManager(Map<String, String> map, String testcaseName) {

		 try {
				navigateToRevenueData();
			    commonFunction.selectProjectNew(AddProjectPage.PN);
			    util.dummyWait(1);
				log("STEP 1: User can navigate to Revenue Data", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to Revenue Data ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
			try {
				SelectYear(map.get(Excel.Year));
				log("STEP 2: user can able to select value from select year dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  user cannot able to select value from select year dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		
			try {
				SelectPeriod(map.get(Excel.Period));
				log("STEP 3: user can able to select value from select period dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user cannot able to select value from select period dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				ClickOnView();
				log("STEP 4: user is able to click on view button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: user not able to click on view button ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			if(!util.isElementVisible(alreadyApproved)) {
			try {
				AddMWH(map.get(Excel.MWh));
				log("STEP 5: user can able to  enter value in MWh field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user cannot able to  enter value in MWh field ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				AddSelesRevenue(map.get(Excel.SalesRevenue));
				log("STEP 6: user can able to enter values in sales revenue field  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user cannot able to enter values in sales revenue field ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				AddRecRevenue(map.get(Excel.RecRevenue));
				log("STEP 7:  user can able to enter values in rec revenue field   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  user not able to enter values in rec revenue field  ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				AddBilateralTradeRevenue(map.get(Excel.TradeRevenue));
				log("STEP 8: user can able to enter value in Bilateral trade revenue field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user not able to enter value in Bilateral trade revenue ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				ClickOnSave();
				log("STEP 9: user can able to click on save button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: user cannot able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			if (util.isElementPresent(btnApprove)) {
				   log("STEP 10: Approve button is visible ", Status.PASS);
				} else {
				   log("STEP 10: user cannot able to click on save button  ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 10");
		   	} 
			
			try {
				ClickOnApproveButton();
				log("STEP 11: user is able to click on approve button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11:  user not able to click on approve button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 12: Revenue Approved  message displays  ", Status.PASS);
				} else {
				   log("STEP 12:  \"Revenue Approved \" message not displays .  ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 12 ");
		    	} 
			}else {
				log("Revenue data for this period has already been approved, and cannot be modified");
			}
			
	 }
	
}
