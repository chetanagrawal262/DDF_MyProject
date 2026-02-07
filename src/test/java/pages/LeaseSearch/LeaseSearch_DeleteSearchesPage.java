package pages.LeaseSearch;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class LeaseSearch_DeleteSearchesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public LeaseSearch_DeleteSearchesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navTools = By.xpath("//span[text()='Tools']");
	By navLeaseSearch = By.xpath("//span[contains(text(),'Lease Search')]");
	By drpSavedSearches = By.xpath("//input[contains(@id,'radPreFilter_Input') and @type='text']");
    By btnDelete = By.xpath("//input[contains(@id,'DeleteSearch') and @type='image']");
	By Message = By.xpath("//span[text()='Search deleted']");
	
	  public void NavigateToLeaseSearch() {
		  util.waitFor(300);
	    	util.waitUntilElementDisplay(navTools);
	    	util.click(navTools);
	    	util.waitUntilElementDisplay(navLeaseSearch);
	    	util.click(navLeaseSearch);
	    	
	    }
	  
	 public void SelectSavedSearches(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpSavedSearches, value);
	 }
	 
	 public void ClickOnDeleteButton() {
		 util.waitFor(500);
		 util.waitUntilElementDisplay(btnDelete);
		 util.click(btnDelete);
		 util.dummyWait(2);
		 util.waitUntilElementDisplay(btnDelete);
		 Assert.assertTrue(util.isElementPresent(Message), "Search deleted");
	 }
	 
	  public void DeleteSelectedSearch(Map<String, String> map, String testcaseName) {
		  
		  try {
				NavigateToLeaseSearch();
				log("STEP 1:  user can navigate to Lease search ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:   user cannot see the options in menu", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

		  
	 try {
		 SelectSavedSearches(map.get(Excel.SavedSearches));
			log("STEP 2: user can able to select value from Saved Searches dd  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: user not able to select value from Saved Searches DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	 
	 try {
		 ClickOnDeleteButton();
			log("STEP 3: user can able to click on delete icon ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user can not click on delete icon", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		if (util.isElementPresent(btnDelete)) {
			   log("STEP 4 : \"search deleted\" message should display      ", Status.PASS);
			} else {
			   log("STEP 4: \"search deleted\" message should not display  ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 4 ");
	   	} 
		
	  }
}
