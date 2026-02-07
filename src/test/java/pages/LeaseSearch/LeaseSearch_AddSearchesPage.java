package pages.LeaseSearch;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class LeaseSearch_AddSearchesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	String LeaseNoOnSeachResult;

	
	public LeaseSearch_AddSearchesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navTools = By.xpath("//span[text()='Tools']");
	By navLeaseSearch = By.xpath("//span[contains(text(),'Lease Search')]");
	By PlusButton = By.xpath("//img[contains(@id,'btnAddSearch')]");
	By Iframe = By.xpath("//iframe[@name='RadAddNewSearch']");
	By txtSavedSearch = By.xpath("//input[contains(@id,'ItemName') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'SaveNewMapping') and @type='image']");
    By btnClose = By.xpath("//a[@title='Close']");
	By drpSavedSearches = By.xpath("//input[contains(@id,'radPreFilter_Input') and @type='text']");
    By drpAddFilter = By.xpath("//input[contains(@id,'cbSearchOptions_Input') and @type='text']");
    By btnAddFilter = By.xpath("//input[contains(@id,'btnAddSearchOption') and @type='submit']");
	By btnSaveSearch = By.xpath("//input[contains(@id,'btnSaveFilter') and @type='button']");
    By dropdown = By.xpath("(//input[contains(@id,'idSearch_RadDock3') and @type='text'])[2]");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By btnExcel = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToExcelButton']");
    By btnCSV = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToCsvButton']");
    By btnWord = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToWordButton']");
    By SearchIframe=By.xpath("//iframe[@name='SearchSingleOpen']");
    
    
    public void NavigateToLeaseSearch() {
    	util.waitUntilElementDisplay(navTools);
    	util.click(navTools);
    	util.waitUntilElementDisplay(navLeaseSearch);
    	util.click(navLeaseSearch);
    	
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
	 
	    
	   public void ClickOnAddFilterButton(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpAddFilter, value);
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnAddFilter);
	    	util.click(btnAddFilter);
	  }
	   public void SelectValueFromDropDown(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(dropdown, value);
	    }
		By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
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
		    
		    public void ClickOnOpeninPopupButton() {
		    	WebElement web = driver.findElement(documentgrid);
		    	util.waitUntilElementDisplay(documentgrid);
		    	Actions act = new Actions(driver);
		    	act.moveToElement(web).contextClick().build().perform();
		    	util.waitUntilElementDisplay(btnOpenInPopup);
		    	util.click(btnOpenInPopup);
		    	util.switchToIframe(SearchIframe);
		    	util.dummyWait(1);
		    	//util.click(btnClose);
		    }
		    By btnOpenInCurrentWindow = By.xpath("//span[contains(text(),'Open in current window')]");

		    public void OpenInCurrentWindowButton() {
		    	WebElement web = driver.findElement(documentgrid);
		    	util.waitUntilElementDisplay(documentgrid);
		    	Actions act = new Actions(driver);
		    	act.moveToElement(web).contextClick().build().perform();
		    	util.click(btnOpenInCurrentWindow);
		    	util.dummyWait(2);
//		    	util.waitUntilElementDisplay(navTools);
//		    	util.click(navTools);
//		    	util.waitUntilElementDisplay(navLeaseSearch);
//		    	util.click(navLeaseSearch);
		    
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
		    
		    By LeaseNo= By.xpath("//input[@id='ctl00_ConPHRightTop_LSINFO_radPanels_i0_i0_Lease_Number']");
		   	public String getLeaseNo() {
		   		return util.getAttributeValue(LeaseNo, "value");
		   	}
		   	
		   	By LeaseNoGrid= By.xpath("//tr[contains(@id,'grdSearchResults_RadGrid1_ctl00__0')]/td[6]");
		    public void ValidateLeaseOnPopUp() {
		    	util.isElementPresent(documentgrid);
		    	LeaseNoOnSeachResult=driver.findElement(LeaseNoGrid).getText();
		    	
		    	ClickOnOpeninPopupButton();
		    	util.dummyWait(1);
		    	
		    	if (LeaseNoOnSeachResult.equals(getLeaseNo())) {
		    	log("STEP 10 : Lease Number on pop up  matched !!!", Status.PASS);
		      	} else {
		      		log("STEP 10 : Lease Number on pop up  Not Matched !!!", Status.FAIL);
		      	}
		    	
		    }
		    
		    public void ValidateLeaseOnCurrentWnindow() {
		   	 OpenInCurrentWindowButton();
		   	 if (LeaseNoOnSeachResult.equals(getLeaseNo())) {
		   	    	log("STEP 11 : Lease Number on current window  matched !!!", Status.PASS);
		   	      	} else {
		   	      		log("STEP 11 : Lease Number on current window Not Matched !!!", Status.FAIL);
		   	      	}
		    } 
	   
	   public void AddSearches(Map<String, String> map, String testcaseName) {
		   try {
				NavigateToLeaseSearch();
				log("STEP 1:  user can navigate to Lease search ", Status.PASS);
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
				throw new RuntimeException("Failed in step 8");
			}
			if (util.isElementPresent(documentgrid)) {
				   log("STEP 9 :search results should  displays according to applied filter on right side ", Status.PASS);
				} else {
				   log("STEP 9: Search results not displays according to applied filter  ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 9 ");
		   	} 
			
//			try {
//				ClickOnOpeninPopupButton();
//				log("STEP 10:  'AMPS:Project dashboard' popup is open with poject information.", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 10:  Popup will not be opened.", Status.FAIL);
//				throw new RuntimeException("Failed in step 10");
//			}
//			
//			try {
//				OpenInCurrentWindowButton();
//				log("STEP 11:  'when user click on open in current window project information will be displayed in current window.", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 11:  Project information will not be displayed in current window.", Status.FAIL);
//				throw new RuntimeException("Failed in step 11");
//			}
			
			try {
				ValidateLeaseOnPopUp();
				log("STEP 10: Lease Information on pop up is matched", Status.PASS);
			}catch(Exception e) {
				log("STEP 10: Lease Information on pop up not matched", Status.FAIL);
			}
			driver.switchTo().defaultContent();
			util.click(btnClose);
			
			
			
			try {
				ValidateLeaseOnCurrentWnindow();
				log("STEP 11:Lease Information on Current window is matched", Status.PASS);
			}catch(Exception e) {
				log("STEP 11: Lease Information on Current window  not matched", Status.FAIL);
			}
			
			util.dummyWait(1);
			//driver.switchTo().defaultContent();
				util.waitUntilElementDisplay(navTools);
		    	util.click(navTools);
		    	util.waitUntilElementDisplay(navLeaseSearch);
		    	util.click(navLeaseSearch);
		    	
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
}
