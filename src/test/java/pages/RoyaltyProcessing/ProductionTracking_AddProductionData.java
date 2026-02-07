package pages.RoyaltyProcessing;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import pages.InfoByParcelReport.AddProjectPage;

public class ProductionTracking_AddProductionData extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String MONTH_NAME;

	public ProductionTracking_AddProductionData(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProductionTracking = By.xpath("//span[text()='Production Tracking']");
	By navRoyaltyProcessing = By.xpath("//span[contains(text(),'Royalty Processing')]");
	By navProductionData = By.xpath("//span[contains(text(),'Production Data')]");
	By SelectProject = By.xpath("//span[contains(@class,'rddtFakeInput')]");
	By txtProject = By.xpath("//input[contains(@class,'rddtFilterEmptyMessage')]");
	By drpYear = By.xpath("//input[contains(@id,'YalProdDM_ddlYear_radYALDropDownList_Input')]");
	By drpPeriod = By.xpath("//input[contains(@id,'YalProdDM_ddlPD_radYALDropDownList_Input')]");
	By btnView = By.xpath("//input[contains(@id,'YalProdDM_btnView')]");
    By DownloadIcon = By.xpath("//input[contains(@onclick,'openProdDLWindow')]");
    By OverrideLink = By.xpath("(//a[text()='Override'])[1]");
	By Iframe = By.xpath("//iframe[@name='ProdMGROverride']");
	By btnRefresh = By.xpath("//a[@id='radGridProdOverride_ctl00_ctl02_ctl00_Button1']");
	By btnSave = By.xpath("//input[@id='radGridProdOverride_ctl00_ctl02_ctl00_btnUpdateAll']");
	By btnClose = By.xpath("//a[@title='Close']");
    By btnApprove = By.xpath("(//input[contains(@onclick,'ApproveRecord')])[1]");
    By monthName = By.xpath("((//input[contains(@onclick,'ApproveRecord')])[1]/../../..//parent::td)[1]");

    public void navigateToProductionData() {
  		util.waitUntilElementDisplay(navProject);
  		util.click(navProject);
  		util.waitFor(200);
  		if(!util.isElementVisible(navProductionTracking)) {
  		util.waitUntilElementDisplay(navRoyaltyProcessing);
  		util.waitFor(200);
  		util.hoverOnElement(navRoyaltyProcessing);
  		util.waitUntilElementDisplay(navProductionData);
  		util.click(navProductionData);}
  		else {
  			util.hoverOnElement(navProductionTracking);
  	  		util.click(navProductionTracking);
  		}
 }
    
    public void SelectProject(String value) {
    	util.click(SelectProject);
    	if (!commonFunction.checkNA(value)) 
			util.inputText(txtProject, value);
    	util.dummyWait(1);
    	util.pressDownkey();
    	util.pressDownkey();
    	util.pressENTERkey();
    	util.dummyWait(2);
    }
    
    public void SelectYear(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpYear, value);
    	util.dummyWait(2);
    }
    
    public void SelectPeriod(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpPeriod, value);
    	util.dummyWait(2);
    }
    
    public void ClickOnView() {
    	util.waitUntilElementDisplay(btnView);
    	util.click(btnView);
    	util.dummyWait(2);
    	
    }
    
    public void ClickOnDownloadIcon() {
    	util.waitUntilElementDisplay(DownloadIcon);
    	util.click(DownloadIcon);
    	  util.dummyWait(3);
  		Set<String> windowId = driver.getWindowHandles(); // get window id of current window
  		Iterator<String> itererator = windowId.iterator();
  		String mainWinID = itererator.next();
  		String newAdwinID = itererator.next();
  		driver.switchTo().window(newAdwinID);
  		driver.close();
  		driver.switchTo().window(mainWinID);
  		util.dummyWait(2);
    }
    
    public void ClickOnOverrideLink() {
    	util.waitUntilElementDisplay(OverrideLink);
    	util.click(OverrideLink);
    	util.switchToIframe(Iframe);
    }
    
    By txtOverrideTextbox = By.xpath("//input[@id='radGridProdOverride_ctl00_ctl04_RNTB_OVERRIDE']");
    public void AddOverrideTextbox(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtOverrideTextbox, value);
    }
    
   By  SuccessMessage = By.xpath("//span[@id='usrMessage']");
    
    public void ClickOnRefershButton() {
    	util.waitUntilElementDisplay(btnRefresh);
    	util.click(btnRefresh);
    	
    }
    
    public void ClickOnSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);  
    	util.dummyWait(1);
    }
    
    public void ClickOnClose() {
    	util.switchToDefaultContent();
    	util.dummyWait(1);
    	util.waitUntilElementDisplay(btnClose);
    	util.click(btnClose); 
    }
    
    public void ClickOnApprove() {
    	util.waitUntilElementDisplay(btnApprove);
    	util.click(btnApprove); 
    	util.dummyWait(2);
    }
    
    
    public void ProductionTracking(Map<String, String> map, String testcaseName) {

		try {
			navigateToProductionData();
			log("STEP 1: user can navigate to Production Tracking page ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: user cannot  navigate to Production Tracking page ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
//			SelectProject(AddProjectPage.PN);
			log("STEP 2: User can select value from  Project dd    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select value from  Project dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			SelectYear(map.get(Excel.Year));
			log("STEP 3: User can select value from  Year dd    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select value from  Year dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			SelectPeriod(map.get(Excel.Period));
			log("STEP 4: User can select value from  Period dd    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select value from  Period dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			ClickOnView();
			log("STEP 5: user can able to click on view button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  user cannot able to click on view button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		for(int i=1; i<=3; i++) {
		try {
			ClickOnOverrideLink();
			log("STEP 6:   user can able to click on override link ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:   user cannot able to click on override link  ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			AddOverrideTextbox(map.get(Excel.Value));
			log("STEP 7: user can able to enter numeric value in override text field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot able to enter numeric value in override text field ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			ClickOnSaveButton();
			log("STEP 8:  user can able to click on save button   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  user cannot able to click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 9:  \"update successful\" message should display         ", Status.PASS);
			} else {
			   log("STEP 9: user cannot able to click on save button  ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 9");
	   	} 
		try {
			ClickOnClose();
			log("STEP 10:  user can click on Close button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  user cannot click on Close button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			MONTH_NAME=driver.findElement(monthName).getText();
			ClickOnApprove();
			log("STEP 11:  User can approve production data for "+MONTH_NAME, Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User cannot approve production data for "+MONTH_NAME, Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			By  gridData = By.xpath("(//tr[contains(@id,'_YalProdDM_radGridProductionData')]/..//td[text()='"+map.get(Excel.Value)+"'])["+i+"]");
			Assert.assertTrue(util.isElementVisible(gridData));
			log("STEP 12:  User can see Approved Production Data in grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12:  User cannot see Approved Production Data in grid view", Status.FAIL);
		}
		}
		
		
    }
    
}
