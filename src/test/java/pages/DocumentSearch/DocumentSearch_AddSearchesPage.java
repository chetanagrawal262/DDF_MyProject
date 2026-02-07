package pages.DocumentSearch;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DocumentSearch_AddSearchesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public DocumentSearch_AddSearchesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navTools = By.xpath("//span[text()='Tools']");
	By navDocumentSearch = By.xpath("//span[contains(text(),'Document Search')]");
	By PlusButton = By.xpath("//img[contains(@id,'btnAddSearch')]");
	By Iframe = By.xpath("//iframe[@name='RadAddNewSearch']");
	By txtSavedSearch = By.xpath("//input[contains(@id,'ItemName') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'SaveNewMapping')]");
    By btnClose = By.xpath("//a[@title='Close']");
	By drpSavedSearches = By.xpath("//input[contains(@id,'radPreFilter_Input') and @type='text']");
    By drpAddFilter = By.xpath("//input[contains(@id,'cbSearchOptions_Input') and @type='text']");
    By btnAddFilter = By.xpath("//input[contains(@id,'btnAddSearchOption') and @type='submit']");
	By btnSaveSearch = By.xpath("//input[contains(@id,'btnSaveFilter') and @type='button']");
    By dropdown = By.xpath("//*[text()='Document Name']/..//input[@type='text']");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By btnExcel = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToExcelButton']");
    By btnCSV = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToCsvButton']");
    By btnWord = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToWordButton']");

    By AgeDocument =By.xpath("//*[contains(@id,'SearchOptions_DropDown')]/div/ul/li[contains(text(),'Age of Document')]");
    By docUpdatedDate =By.xpath("//*[contains(@id,'SearchOptions_DropDown')]/div/ul/li[contains(text(),'Document Uploaded Date')]");
    By docUpdatedBy =By.xpath("//*[contains(@id,'SearchOptions_DropDown')]/div/ul/li[contains(text(),'Document Uploaded By')]");
    By FilterArrow = By.xpath("//a[contains(@id,'SearchOptions_Arrow')]");
   
    
    
    
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
	 
	 public void SelectDropDown(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(dropdown, value);
   }
	    
	   public void ClickOnAddFilterButton(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpAddFilter, value);
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnAddFilter);
	    	util.click(btnAddFilter);
	  }
	    By btnSearch = By.xpath("//input[contains(@id,'btnDoSearch') and @type='button']");
	    By spinner = By.xpath("(//div[contains(@id,'idSearch') and @class='loading'])[1]");
	   public void ClickOnSearch() {
	    	util.waitUntilElementDisplay(btnSearch);
	    	util.click(btnSearch);
	    	util.waitUntilElementDisappear(spinner);
	    
	    }
	   public void NavigateToDocumentSearch() {
	    	util.waitUntilElementDisplay(navTools);
	    	util.click(navTools);
	    	util.waitUntilElementDisplay(navDocumentSearch);
	    	util.click(navDocumentSearch);
	    	
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
	    	util.dummyWait(2);

	    }
	   public void AddSearches(Map<String, String> map, String testcaseName) {
		   try {
				NavigateToDocumentSearch();
				log("STEP 1:  user can navigate to Document search ", Status.PASS);
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
				   log("STEP 7: 'Document Name' Filter successfully added  ", Status.PASS);
				} else {
				   log("STEP 7: 'Document Name' Filter  not added", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 7");
		   	} 
			SelectDropDown(map.get(Excel.DropDown));

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
			
			
			
			try {
				CliclOnExcelIcon();
				log("STEP 10: user is able to click on export to excel icon ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: user not able click on export to excel icon ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				CliclOnCSVIcon();
				log("STEP 11: user is able to click on export to CSV icon ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: user not able click on export to CSV icon", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
			
			
			try {
				CliclOnWordIcon();
				log("STEP 12: user is able to click on export to word icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: user not able click on export to word icon", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			
		// 51442 changes 	
			try {
				SelectSavedSearches(map.get(Excel.SavedSearches));
				log("STEP 13 : user can able to select value from SavedSearches dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: user not able to select value from SavedSearches dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				util.waitUntilElementDisplay(drpAddFilter);
				util.click(drpAddFilter);
				Assert.assertTrue(util.isElementVisible(AgeDocument));
				log("STEP 14 : user can see 'age Of Document' filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: user cannot see 'age Of Document' filter  ", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(docUpdatedBy));
				log("STEP 15 : user can see 'Document Uploaded By' filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: user cannot see 'Document Uploaded By' filter  ", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(docUpdatedDate));
				log("STEP 16 : user can see 'Document Uploaded Date' filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 16: user cannot see 'Document Uploaded Date' filter  ", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
			
		    util.click(FilterArrow);
		    
		    if(!environment.contains("WOLFMIDSTREAM")) {
		    try {
				ClickOnAddFilterButton(map.get(Excel.SelectFilter));
				log("STEP 17:   user can click on Add filter button", Status.PASS);
			} catch (Exception e) {
				log("STEP 17:   user cannot click on Add filter button ", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			
			if (util.isElementPresent(dropdown)) {
				   log("STEP 18: one more \"Add new filter\"  DD filed added    ", Status.PASS);
				} else {
				   log("STEP 18: \"Add new filter\" dd filed not added", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 18");
		   	} 
			

			try {
				SelectDropDown(map.get(Excel.DocumentName));
				log("STEP 19: user can enter document name ", Status.PASS);
			} catch (Exception e) {
				log("STEP 19: user cannot enter document name  ", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
			
			try {
				ClickOnSearch();
				log("STEP 20: user is able to click on save button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 20: user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 1209");
			}
			
			try {
				 By WorkflowDoc = By.xpath("(//td[contains(text(),'WorkflowDoc.txt')])[1]");
				Assert.assertTrue(util.isElementVisible(WorkflowDoc));
				log("STEP 21 : user can see Workfloe documents in the search results", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 21:user cannot see Workfloe documents in the search results ", Status.FAIL);
			}	
			
		    }
	 }
}
