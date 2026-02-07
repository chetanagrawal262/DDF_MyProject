package pages.ParcelSearch;

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

public class ParcelSearch_AddSearchesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	String ParcelNoOnSearchResult, ParcelTypeSearchResult;
	SoftAssert assertion = new SoftAssert();
	
	public ParcelSearch_AddSearchesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By PlusButton = By.xpath("//img[contains(@id,'btnAddSearch')]");
	By Iframe = By.xpath("//iframe[@name='RadAddNewSearch']");
	By txtSavedSearch = By.xpath("//input[contains(@id,'ItemName') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'SaveNewMapping')]");
    By btnClose = By.xpath("//a[@title='Close']");
	By drpSavedSearches = By.xpath("//input[contains(@id,'radPreFilter_Input') and @type='text']");
    By drpAddFilter = By.xpath("//input[contains(@id,'cbSearchOptions_Input') and @type='text']");
    By btnAddFilter = By.xpath("//input[contains(@id,'btnAddSearchOption') and @type='submit']");
	By btnSaveSearch = By.xpath("//input[contains(@id,'btnSaveFilter') and @type='button']");
    By dropdown = By.xpath("(//input[contains(@id,'idSearch_RadDock3') and @type='text'])[2]");
    By navTools = By.xpath("//span[text()='Tools']");
	By navParcelSearch = By.xpath("//span[contains(text(),'Parcel Search')] | //span[contains(text(),'Tract Search')] | //span[contains(text(),'Record Search')]");
	By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
	 By searchFrame=By.xpath("//iframe[@name='SearchSingleOpen']");
	 By btnExcel = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToExcelButton']");
	    By btnCSV = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToCsvButton']");
	    By btnWord = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToWordButton']");
	
    public void NavigateToParcelSearch() {
    	util.waitUntilElementDisplay(navTools);
    	util.click(navTools);
    	util.waitUntilElementDisplay(navParcelSearch);
    	util.click(navParcelSearch);
    	
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
	    	util.dummyWait(1);
	  }
	   
	   public void SelectDropDown(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(dropdown, value);
      }
	   
	   By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
		By btnSearch = By.xpath("//input[contains(@id,'btnDoSearch') and @type='button']");
		
		   public void ClickOnSearch() {
		    	util.waitUntilElementDisplay(btnSearch);
		    	util.click(btnSearch);
		    	util.dummyWait(15);
		    }
		   
		   
		   By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
		    By btnOpenInCurrentWindow = By.xpath("//span[contains(text(),'Open in current window')]");
			By Information = By.xpath("(//span[contains(text(),'Agreement Information')])[2]");
;
		    public void ClickOnOpeninPopupButton() {
		    	WebElement web = driver.findElement(documentgrid);
		    	util.waitUntilElementDisplay(documentgrid);
		    	Actions act = new Actions(driver);
		    	act.moveToElement(web).contextClick().build().perform();
		    	util.waitUntilElementDisplay(btnOpenInPopup);
		    	util.click(btnOpenInPopup);
		    	util.switchToIframe(searchFrame);
		    	util.dummyWait(1);
		    	//util.click(btnClose);
		    }
		    
		    public void OpenInCurrentWindowButton() {
		    	WebElement web = driver.findElement(documentgrid);
		    	util.waitUntilElementDisplay(documentgrid);
		    	Actions act = new Actions(driver);
		    	act.moveToElement(web).contextClick().build().perform();
		    	util.click(btnOpenInCurrentWindow);
		    	util.dummyWait(2);
//		    	util.waitUntilElementDisplay(navTools);
//		    	util.click(navTools);
//		    	util.waitUntilElementDisplay(navParcelSearch);
//		    	util.click(navParcelSearch);
		    
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
		    
		    public void SelectAddFilter(String value) {
		    	if (!commonFunction.checkNA(value)) 
					util.inputTextAndPressTab(drpAddFilter, value);
		    }
		    
		    public void ClickOnAddFilterButton() {
		    	util.waitUntilElementDisplay(btnAddFilter);
		    	util.click(btnAddFilter);
		    }
		    
		    public void SelectValueFromDropDown(String value) {
		    	if (!commonFunction.checkNA(value)) 
					util.inputTextAndPressTab(dropdown, value);
		    }
		    
		    By ParcelType= By.xpath("//input[contains(@id,'TractType_Tract_Type_ID') and @type='text']");
			public String getParcelType() {
				return util.getAttributeValue(ParcelType, "value");
			}

			By ParcelNo= By.xpath("//input[contains(@id,'TRACT_NUMBER') and @type='text']");
			public String getParcelNo() {
				return util.getAttributeValue(ParcelNo, "value");
			}
			
			
			 By ParcelNoOnGrid= By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='Parcel Number']/preceding-sibling::th)+1])[1]");
			 By RecordTypeOnGrid= By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='Parcel Type']/preceding-sibling::th)+1])[1]");
			 By ParcelNoOnGridVALARD= By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='Record Number']/preceding-sibling::th)+1])[1]");
			 By ParcelNoOnGridOrion= By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='Orion Pid']/preceding-sibling::th)+1])[1]");
			 By ParcelNoOnGridDOT= By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='Parcel #']/preceding-sibling::th)+1])[1]");
			 By ParcelTypeOnGrid= By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='Parcel Type']/preceding-sibling::th)+1])[1]");
			 By ParcelTypeOnGridTRA= By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='Tract Type']/preceding-sibling::th)+1])[1]");
			 
			 By ParcelTypeOnGridVALARD= By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='Record Type']/preceding-sibling::th)+1])[1]");
			 public void ValidateParcelDetailsOnPopUp(String testcase) {
			        
			       if(!testcase.contains("ORION")) {
			    	   if(environment.contains("VALARD")) {
			    		   ParcelTypeSearchResult =driver.findElement(ParcelTypeOnGridVALARD).getText();
			    	   }else  if(environment.contains("TRA")) {
			       ParcelTypeSearchResult =driver.findElement(ParcelTypeOnGridTRA).getText();
			    	   }else {
			    		   ParcelTypeSearchResult =driver.findElement(ParcelTypeOnGrid).getText();
			    	   }
			       }
			       ClickOnOpeninPopupButton();
			       util.dummyWait(3);
			       
			       if(!testcase.contains("ORION")) {
			       assertion.assertEquals(getParcelType(), ParcelTypeSearchResult, "Parcel Type mismatched");
					ExtentTestManager.log("Parcel Type on Pupup : "+getParcelType());
			       }
			       
			       if(!environment.contains("TRA")) {
			    	  
					assertion.assertEquals(getParcelNo(), ParcelNoOnSearchResult, "Parcel Number mismatched");
					ExtentTestManager.log("Parcel Number on Pupup : "+getParcelNo());
			       }
			       }
			    
			    public void ValidateParcelDetailsOnCurrentWindow() {
			    	OpenInCurrentWindowButton();
			    	
			    	 if(!clientName.contains("ORION")) {
			    	    assertion.assertEquals(getParcelType(), ParcelTypeSearchResult, "Parcel Type mismatched");
						ExtentTestManager.log("Parcel Type on Current Window : "+getParcelType());
						
						
			    	 }
			    	 
			    	  if(!environment.contains("TRA")) {
						assertion.assertEquals(getParcelNo(), ParcelNoOnSearchResult, "Parcel Number mismatched");
						ExtentTestManager.log("Parcel Number on Current Window : "+getParcelNo());
			    	  }
			    }
	   
	   public void AddSearches(Map<String, String> map, String testcaseName) {
		   try {
				NavigateToParcelSearch();
				log("STEP 1:  user can navigate to Parcel search ", Status.PASS);
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
			if(environment.contains("VALARD")) {
				try {
					ClickOnAddFilterButton(map.get("OtherFilter"));
					log("STEP 6:   user can click on Add filter button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
			}else if(environment.contains("WOLFMIDSTREAM")) {
				try {
					ClickOnAddFilterButton("Tract #:");
					log("STEP 6:   user can click on Add filter button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
			}else {
			try {
				ClickOnAddFilterButton(map.get(Excel.SelectFilter));
				log("STEP 6:   user can click on Add filter button", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			}
			
			SelectDropDown(map.get(Excel.DropDown));
			ParcelNoOnSearchResult=map.get(Excel.DropDown);

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
				ValidateParcelDetailsOnPopUp(testcaseName);
				log("STEP 10: Parcel Details on pop up is matched", Status.PASS);
			}
			catch(Exception e) {
				log("STEP 10: Parcel Details on pop up not matched", Status.FAIL);
			}
			driver.switchTo().defaultContent();
			util.click(btnClose);
			
			
			try {
				ValidateParcelDetailsOnCurrentWindow();
				log("STEP 11: Parcel Details on Current window is matched", Status.PASS);
			}
			catch(Exception e) {
				log("STEP 11: Parcel Details on Current window  not matched", Status.FAIL);
			}
			
			    util.waitUntilElementDisplay(navTools);
		    	util.click(navTools);
		    	util.waitUntilElementDisplay(navParcelSearch);
		    	util.click(navParcelSearch);
		    	
			SelectSavedSearches(map.get(Excel.SavedSearches));
			if(environment.contains("VALARD")) {
				SelectAddFilter(map.get("OtherFilter"));
			}else if(environment.contains("WOLFMIDSTREAM")) {
				SelectAddFilter("Tract #:");
			}else {
				SelectAddFilter(map.get(Excel.SelectFilter));
			}
			
			ClickOnAddFilterButton();
			util.dummyWait(2);
			SelectDropDown(map.get(Excel.DropDown));
			ClickOnSearch();
			
			try {
				Assert.assertTrue(util.isElementVisible(btnExcel));
				log("STEP 12: user is able to see on export to excel icon ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12: user not able see on export to excel icon ", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(btnCSV));
				log("STEP 13: user is able to see on export to CSV icon ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 13: user not able see on export to CSV icon", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(btnWord));
				log("STEP 14: user is able to see on export to word icon", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 14: user not able see on export to word icon", Status.FAIL);
			}
			
			
			
			
			
	 }
}
