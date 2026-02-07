package pages.ParcelSearch;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class VerifyAcquisitionStatusFilter extends BasePage {
	TestUtil util;
	CommonFunction commonFunction;

	public VerifyAcquisitionStatusFilter(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navABS = By.xpath("//span[contains(text(),'Application Behavior Settings')]");
	By txtFilterKeyName = By.xpath("//input[@alt='Filter key_name column']");
	By btnFilterKeyName = By.xpath("//input[contains(@id,'Filter_key_name') and @type='button']");
	By optionFilter = By.xpath("//span[text()='Contains']");
    By btnSubmitAll = By.xpath("//input[@title='Submit All']");
    By navTools = By.xpath("//span[text()='Tools']");
   	By navParcelSearch = By.xpath("//span[contains(text(),'Parcel Search')] | //span[contains(text(),'Tract Search')] | //span[contains(text(),'Record Search')]");
   	By drpSavedSearches = By.xpath("//input[contains(@id,'radPreFilter_Input') and @type='text']");
    By drpAddFilter = By.xpath("//input[contains(@id,'cbSearchOptions_Input') and @type='text']");
    By btnAddFilter = By.xpath("//input[contains(@id,'btnAddSearchOption') and @type='submit']");
	By drpAcqStatus =By.xpath("(//td[text()='Acquisition Status']/..//input[@type='text'] )[1]");
	By SelectAllCheckbox =By.xpath("//input[@class='rcbCheckAllItemsCheckBox']");
	By firstStatus =By.xpath("(//input[@class='rcbCheckAllItemsCheckBox']/../../..//input[@type='checkbox'])[2]");
	By CloseddArrow =By.xpath("(//td[text()='Acquisition Status']/..//a)[1]");
	By btnSearch = By.xpath("//input[contains(@id,'btnDoSearch') and @type='button']");
	By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
	
	public void NavigateToApplicationBehaviorSettings() {
    	util.waitUntilElementDisplay(navAdministration);
    	util.click(navAdministration);
    	util.waitUntilElementDisplay(navABS);
    	util.click(navABS);
    }
	
	 public void enterKeyName(String value) {
			util.waitUntilElementDisplay(txtFilterKeyName);
			util.inputTextAndPressTab(txtFilterKeyName, value);
		}
	
	 public void selectFilter() {
		 util.waitFor(300);
	    	if(!util.isElementVisible(optionFilter)) {
			util.waitUntilElementDisplay(btnFilterKeyName);
			util.click(btnFilterKeyName);
			util.click(optionFilter);
			}
			
		}
	 
	
	 public void setKeyValue(String key, String value) {
	    	By keyValue = By.xpath("//*[text()='"+key+"']/..//input[contains(@name,'txtValue')]");
	    	util.dummyWait(1);
			//util.waitUntilElementDisplay(keyValue);
			util.inputTextAndPressTab(keyValue, value);
		}
	 
	  public void clickOnSubmitAll() {
			util.waitUntilElementDisplay(btnSubmitAll);
			util.click(btnSubmitAll);;
			util.dummyWait(1);
		}
	 
	  public void NavigateToParcelSearch() {
	    	util.waitUntilElementDisplay(navTools);
	    	util.click(navTools);
	    	util.waitUntilElementDisplay(navParcelSearch);
	    	util.click(navParcelSearch);
	    	
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
	   
	   
	   public void ClickOnAcqStatusFilter() {
		 util.waitUntilElementDisplay(drpAcqStatus);
		 util.click(drpAcqStatus);
	   }
	   
	   By loaderIcon = By.xpath("(//img[contains(@id,'_idSearch_Image2') and @alt='loading'])[1]");
	   public void ClickOnSearch() {
	    	util.waitUntilElementDisplay(btnSearch);
	    	util.click(btnSearch);
	    	util.dummyWait(15);
	    	util.waitUntilElementDisappear(loaderIcon);
	    }
	   
	 public void VerifyAcquisitionStatusFilter_MultiselectDD(Map<String, String> map, String testcaseName) {
			
		 try {
 		    NavigateToApplicationBehaviorSettings();
  			log("STEP 1: User can navigate to Application Behavior Settings ", Status.PASS);
  		} catch (Exception e) {
  			log("STEP 1: User cannot navigate to Application Behavior Settings ", Status.FAIL);
  			throw new RuntimeException("Failed in step 1");
  		}
		 
		 try {
 		    enterKeyName(map.get("KeyName"));
  			log("STEP 2: User can enter key name "+map.get("KeyName"), Status.PASS);
  		} catch (Exception e) {
  			log("STEP 2: User cannot enter key name "+map.get("KeyName"), Status.FAIL);
  			throw new RuntimeException("Failed in step 2");
  		} 
		 
		 try {
 		    selectFilter();
  			log("STEP 3: User can click on Filter Icon", Status.PASS);
  		} catch (Exception e) {
  			log("STEP 3: User cannot click on Filter Icon", Status.FAIL);
  			throw new RuntimeException("Failed in step 3");
  		} 
		 
		 try {
	 		    setKeyValue(map.get("KeyName"), map.get("Value"));
	  			log("STEP 4: User can set "+ map.get("Value")+" value for key name "+map.get("KeyName"), Status.PASS);
	  		} catch (Exception e) {
	  			log("STEP 4: User cannot set "+ map.get("Value")+" value for key name "+map.get("KeyName"), Status.FAIL);
	  			throw new RuntimeException("Failed in step 4");
	  		} 
		 
		 try {
 		    clickOnSubmitAll();
  			log("STEP 5: User can click on Submit All button ", Status.PASS);
  		} catch (Exception e) {
  			log("STEP 5: User cannot click on Submit All button", Status.FAIL);
  			throw new RuntimeException("Failed in step 5");
  		} 
		 
		 try {
				NavigateToParcelSearch();
				log("STEP 6:  user can navigate to Parcel search ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:   user cannot see the options in menu", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
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
		 
			try {
				ClickOnAcqStatusFilter();
				log("STEP 7:   user can click on Acquisition Status filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:   user cannot click on Acquisition Status filter", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			} 
	
			try {
				Assert.assertTrue(util.isElementVisible(SelectAllCheckbox));
				util.click(firstStatus);
				util.click(CloseddArrow);
				log("STEP 8:  user can see Acquisition Status as multiselect DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:   user cannot see Acquisition Status as multiselect DD", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			} 
			try {
				ClickOnSearch();
				log("STEP 8: user is able to click on save button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			
			
			
			}
	
}
