package pages.AgreementSearch;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class AgreementSearch_AddSearchesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	String AgreementNoOnSeachResult, AgreementStatusOnSearchResult;

	public AgreementSearch_AddSearchesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navTools = By.xpath("//span[text()='Tools']");
	By navAgreementSearch = By.xpath("//span[contains(text(),'Agreement Search')]");
	By PlusButton = By.xpath("//img[contains(@id,'btnAddSearch')]");
	By Iframe = By.xpath("//iframe[@name='RadAddNewSearch']");
	By txtSavedSearch = By.xpath("//input[contains(@id,'ItemName') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'SaveNewMapping') and @type='image']");
    
	By drpSavedSearches = By.xpath("//input[contains(@id,'radPreFilter_Input') and @type='text']");
    By drpAddFilter = By.xpath("//input[contains(@id,'cbSearchOptions_Input') and @type='text']");
    By btnAddFilter = By.xpath("//input[contains(@id,'btnAddSearchOption') and @type='submit']");
	By btnSaveSearch = By.xpath("//input[contains(@id,'btnSaveFilter') and @type='button']");
    By dropdown = By.xpath("(//input[contains(@id,'idSearch_RadDock3') and @type='text'])[2]");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By btnExcel = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToExcelButton']");
    By btnCSV = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToCsvButton']");
    By btnWord = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToWordButton']");
    By SeachIfrme=By.xpath("//iframe[@name='SearchSingleOpen']");
    By fitlerSalesforceID = By.xpath("//td[text()='Salesforce ID:']/..//input[@type='text']");
    By fitlerQLSNumber = By.xpath("//td[text()='QLS Number:']/..//input[@type='text']");
    By fitlerAgreementPaymentStatus = By.xpath("//td[text()='Agreement Payment Status:']/..//input[@type='text']");
    
    public void NavigateToAgreementSearch() {
    	util.waitUntilElementDisplay(navTools);
    	util.click(navTools);
    	util.waitUntilElementDisplay(navAgreementSearch);
    	util.click(navAgreementSearch);
    	
    }
	public void ClickOnPlusButton() {
		util.waitUntilElementDisplay(PlusButton);
		util.click(PlusButton);
		util.switchToIframe(Iframe);
		util.dummyWait(2);
	}
		
	public void AddSavedSearch(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtSavedSearch, value);
	}
	
	public void ClickOnSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(1);
		util.switchToDefaultContent();
	}
	
	 public void SelectSavedSearches(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpSavedSearches, value);
    }
	 public void SelectValueFromDropDown(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(dropdown, value);
	    }
	    
	 public void addSalesforceIDFilterValue(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(fitlerSalesforceID, value);
	    }
	 
	 public void addQLSNumberFilterValue(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(fitlerQLSNumber, value);
	    }
	 
	 public void selectAgreementPaymentStatusFilterValue(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(fitlerAgreementPaymentStatus, value);
	    }
	 
	   public void ClickOnAddFilterButton(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpAddFilter, value);
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnAddFilter);
	    	util.click(btnAddFilter);
	  }
		By btnSearch = By.xpath("//input[contains(@id,'btnDoSearch') and @type='button']");
		
	   public void ClickOnSearch() {
	    	util.waitUntilElementDisplay(btnSearch);
	    	util.click(btnSearch);
	    	util.dummyWait(2);
	    	
	    }
	   
	   
	   public void SelectAddFilter(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpAddFilter, value);
	    }
	    
	    public void ClickOnAddFilterButton() {
	    	util.waitUntilElementDisplay(btnAddFilter);
	    	util.click(btnAddFilter);
	    }
	    
	
	    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
	    By btnOpenInCurrentWindow = By.xpath("//span[contains(text(),'Open in current window')]");
		By Information = By.xpath("(//span[contains(text(),'Agreement Information')])[2]");
	    By btnClose = By.xpath("//a[@title='Close']");
	    public void ClickOnOpeninPopupButton() {
	    	WebElement web = driver.findElement(documentgrid);
	    	util.waitUntilElementDisplay(documentgrid);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	    	util.waitUntilElementDisplay(btnOpenInPopup);
	    	util.click(btnOpenInPopup);
	    	util.switchToIframe(SeachIfrme);
	    	util.dummyWait(1);
	    }
	    
	    public void OpenInCurrentWindowButton() {
	    	WebElement web = driver.findElement(documentgrid);
	    	util.waitUntilElementDisplay(documentgrid);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	    	util.click(btnOpenInCurrentWindow);
	    	util.dummyWait(2);    
	    }
	    
	       
	    public void CliclOnExcelIcon() {
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnExcel);
	    	util.click(btnExcel);
	    }
	    
	    public void CliclOnCSVIcon() {
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnCSV);
	    	util.click(btnCSV);
	    }
	    
	    public void CliclOnWordIcon() {
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnWord);
	    	util.click(btnWord);
	    }
	    
	    
	    By AgreementNo= By.xpath("//input[contains(@id,'LSINFO_radPanels_i0_i0_Lease_Number') and @type='text']");
		public String getAgreementNo() {
			return util.getAttributeValue(AgreementNo, "value");
		}
		
		By AgreementStatus= By.xpath("//input[contains(@id,'Lease_Status') and @type='text']");
		public String getAgreementStatus() {
			return util.getAttributeValue(AgreementStatus, "value");
		}
	    
		By AgreementNumberGrid= By.xpath("(//table/tbody/tr/td[count(//table/thead/tr/th[.='Agreement Number']/preceding-sibling::th)+1])[2]");
		By AgreementStatusGrid= By.xpath("(//table/tbody/tr/td[count(//table/thead/tr/th[.='Agreement Status']/preceding-sibling::th)+1])[1]");
		
	    public void ValidateAgreementOnPopUp() {
	    	
	    	SoftAssert assertion = new SoftAssert();
	    	
	    	AgreementNoOnSeachResult=driver.findElement(AgreementNumberGrid).getText();
	    	AgreementStatusOnSearchResult=driver.findElement(AgreementStatusGrid).getText();	
	    	
	    	ClickOnOpeninPopupButton();
	    	
	    	util.dummyWait(1);
	    	
	    	assertion.assertEquals(getAgreementNo(), AgreementNoOnSeachResult, "Agreement No mismatched");
			ExtentTestManager.log("Agreement No on Pupup : "+getAgreementNo());
			
//			assertion.assertEquals(getAgreementStatus(), AgreementStatusOnSearchResult, "Agreement Status mismatched");
//			ExtentTestManager.log("Agreement Status on Pupup : "+getAgreementStatus());
			
			assertion.assertAll();
	    }
	    
	         public void ValidateAgreementOnCurrentWnindow() {
	        	 SoftAssert assertion = new SoftAssert();
	        	 OpenInCurrentWindowButton();
	        	 
	        	 assertion.assertEquals(getAgreementNo(), AgreementNoOnSeachResult, "Agreement No mismatched");
	     		ExtentTestManager.log("Agreement No on Current Window : "+getAgreementNo());
	     		
//	     		assertion.assertEquals(getAgreementStatus(), AgreementStatusOnSearchResult, "Agreement Status mismatched");
//	     		ExtentTestManager.log("Agreement Status on Current Window : "+getAgreementStatus());
	     		assertion.assertAll();
	    }
	   
	   public void AddSearches(Map<String, String> map, String testcaseName) {
		   try {
				NavigateToAgreementSearch();
				log("STEP 1:  user can navigate to Agrrement search ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:   user cannot see the options in menu", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		   try {
				ClickOnPlusButton();
				log("STEP 2:  user can able to click the button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  user can able to click the button", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

			try {
				AddSavedSearch(map.get(Excel.SearchName));
				log("STEP 3:  user can enter the text in  SavedSearch field    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user cannot enter the text in  SavedSearch field ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				ClickOnSaveButton();
				log("STEP 4:  user can click on save button", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				SelectSavedSearches(map.get(Excel.SavedSearches));
				log("STEP 5: user can able to select value from SavedSearches dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user not able to select value from SavedSearches dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				ClickOnAddFilterButton(map.get(Excel.SelectFilter));
				log("STEP 6:   user can click on Add filter button", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			if (util.isElementPresent(dropdown)) {
				   log("STEP 7 : one more \"Add new filter\"  DD filed added    ", Status.PASS);
				} else {
				   log("STEP 7: \"Add new filter\" dd filed not added", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 7 ");
		   	} 
			
			SelectValueFromDropDown(map.get(Excel.DropDown));
			
			try {
				ClickOnSearch();
				log("STEP 8: user is able to click on save button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			util.dummyWait(3);
			if (util.isElementPresent(documentgrid)) {
				   log("STEP 9 :search results should  displays according to applied filter on right side ", Status.PASS);
				} else {
				   log("STEP 9: Search results not displays according to applied filter  ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 9");
		       	} 
			
			try {
				ValidateAgreementOnPopUp();
				driver.switchTo().defaultContent();
				util.click(btnClose);
				log("STEP 10: Agreement Information on pop up is matched", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: Agreement Information on pop up not matched", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				ValidateAgreementOnCurrentWnindow();
				log("STEP 11:Agreement Information on Current window is matched", Status.PASS);
			}catch(Exception e) {
				log("STEP 11: Agreement Information on Current window  not matched", Status.FAIL);
			}
			
			util.dummyWait(1);
			//driver.switchTo().defaultContent();
				util.waitUntilElementDisplay(navTools);
		    	util.click(navTools);
		    	util.waitUntilElementDisplay(navAgreementSearch);
		    	util.click(navAgreementSearch);
			SelectSavedSearches(map.get(Excel.SavedSearches));
			SelectAddFilter(map.get(Excel.SelectFilter));
			ClickOnAddFilterButton();
			SelectValueFromDropDown(map.get(Excel.DropDown));
			ClickOnSearch();
			
			try {
				Assert.assertTrue(util.isElementVisible(btnExcel));
//				CliclOnExcelIcon();
				log("STEP 12: user is able to see on export to excel icon ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12: user not able see on export to excel icon ", Status.FAIL);
//				throw new RuntimeException("Failed in step 12");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(btnCSV));
//				CliclOnCSVIcon();
				log("STEP 13: user is able to see on export to CSV icon ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 13: user not able see on export to CSV icon", Status.FAIL);
//				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(btnWord));
//				CliclOnWordIcon();
				log("STEP 14: user is able to see on export to word icon", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 14: user not able see on export to word icon", Status.FAIL);
//				throw new RuntimeException("Failed in step 14");
			}
			
	 }
	   
	   public void agreementSearchNextEra(Map<String, String> map, String testcaseName) {
		   try {
				NavigateToAgreementSearch();
				log("STEP 1:  user can navigate to Agrrement search ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:   user cannot see the options in menu", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		   
		   try {
				SelectSavedSearches(map.get(Excel.SavedSearches));
				log("STEP 2: user can able to select value from SavedSearches dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: user not able to select value from SavedSearches dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				ClickOnAddFilterButton("Salesforce ID:");
				log("STEP 3:   user can Add Salesforce ID: filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:   user cannot Add Salesforce ID: filter", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				ClickOnAddFilterButton("QLS Number:");
				log("STEP 4:   user can Add QLS Number: filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:   user cannot Add QLS Number: filter", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				ClickOnAddFilterButton("Agreement Payment Status:");
				log("STEP 5:   user can Add Agreement Payment Status: filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:   user cannot Add Agreement Payment Status: filter", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				addSalesforceIDFilterValue(map.get("SalesforceID"));
				log("STEP 6:   user can enter value in Salesforce ID filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:   user cannot enter value in Salesforce ID filter", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				addQLSNumberFilterValue(map.get("QLSNumber"));
				log("STEP 7:   user can enter value in QLS Number filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:   user cannot enter value in QLS Number filter", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				selectAgreementPaymentStatusFilterValue(map.get("AgreementPaymentStatus"));
				log("STEP 8:   user can enter value in Agreement Payment Status filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:   user cannot enter value in Agreement Payment Status filter", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			
			try {
				ClickOnSearch();
				log("STEP 9: user is able to click on save button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				By salesforceID= By.xpath("(//*[contains(@id,'_idSearch_grdSearchResults')]/..//td[text()='"+map.get("SalesforceID")+"'])[1]");
				Assert.assertTrue(util.isElementVisible(salesforceID));
				log("STEP 10: user can see Salesforce ID in the search result grid ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10: user cannot see Salesforce ID in the search result grid", Status.FAIL);
			}
			
			try {
				By qlsNo= By.xpath("(//*[contains(@id,'_idSearch_grdSearchResults')]/..//td[text()='"+map.get("QLSNumber")+"'])[1]");
				Assert.assertTrue(util.isElementVisible(qlsNo));
				log("STEP 11: user can see QLS Number in the search result grid ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11: user cannot see QLS Number in the search result grid", Status.FAIL);
			}
			
			try {
				By agreementPaymentStatus= By.xpath("(//*[contains(@id,'_idSearch_grdSearchResults')]/..//td[text()='"+map.get("AgreementPaymentStatus")+"'])[1]");
				Assert.assertTrue(util.isElementVisible(agreementPaymentStatus));
				log("STEP 12: user can see Agreement Payment Status in the search result grid ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12: user cannot see Agreement Payment Status in the search result grid", Status.FAIL);
			}
			
	 }
}
