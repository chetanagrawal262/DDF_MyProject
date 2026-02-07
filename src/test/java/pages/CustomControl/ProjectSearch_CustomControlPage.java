package pages.CustomControl;

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

public class ProjectSearch_CustomControlPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String ProjectName;
	
	public ProjectSearch_CustomControlPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By PlusButton = By.xpath("//img[contains(@id,'btnAddSearch')]");
	By Iframe = By.xpath("//iframe[@name='RadAddNewSearch']");
	By txtSavedSearch = By.xpath("//input[contains(@id,'ItemName') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'SaveNewMapping')]");
	By btnSaveProject = By.xpath("//input[contains(@id,'btnSaveProject')]");
    By btnClose = By.xpath("//a[@title='Close']");
	By drpSavedSearches = By.xpath("//input[contains(@id,'radPreFilter_Input') and @type='text']");
    By drpAddFilter = By.xpath("//input[contains(@id,'cbSearchOptions_Input') and @type='text']");
    By btnAddFilter = By.xpath("//input[contains(@id,'btnAddSearchOption') and @type='submit']");
	By btnSaveSearch = By.xpath("//input[contains(@id,'btnSaveFilter') and @type='button']");
   By navTools = By.xpath("//span[text()='Tools']");
   By navProjectSearch = By.xpath("//span[contains(text(),'Project Search')]");
	
    public void NavigateToProjectSearch() {
    	util.waitUntilElementDisplay(navTools);
    	util.click(navTools);
    	util.waitUntilElementDisplay(navProjectSearch);
    	util.click(navProjectSearch);
    	
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
	   
	  
	   By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
		By btnSearch = By.xpath("//input[contains(@id,'btnDoSearch') and @type='button']");
		By loader = By.xpath("(//img[contains(@id,'ctl00_ConPHRightTop_idSearch_Image2') and @alt='loading'])[1]");
		   public void ClickOnSearch() {
		    	util.waitUntilElementDisplay(btnSearch);
		    	util.click(btnSearch);
		    	util.waitUntilElementDisappear(loader);
		    }
		   
		    public void SelectAddFilter(String value) {
		    	if (!commonFunction.checkNA(value)) 
					util.inputTextAndPressTab(drpAddFilter, value);
		    }
		    
		    public void ClickOnAddFilterButton() {
		    	util.waitUntilElementDisplay(btnAddFilter);
		    	util.click(btnAddFilter);
		    }

			By projectTitle= By.xpath("//div[@id=\"ctl00_ConPHLeftTop_PROJLST_ddt_ProjectList\"]");
			public String getProjectTitle() {
				return util.getAttributeValue(projectTitle, "title");
			}
			
			    
			    public void clickOnSaveProject() {
			    	util.waitUntilElementDisplay(btnSaveProject);
					util.click(btnSaveProject);
					util.dummyWait(3);
			    }
			    
			    
			    
	   public void verifyProjectSearch(Map<String, String> map, String testcaseName) {
		  
		   try {
			   By fieldRadio = By.xpath("//*[text()='" +map.get(Excel.DisplayName)+ "']/..//label[text()='"+map.get("FieldValue")+"']/..//input");
			   util.waitUntilElementDisplay(fieldRadio);
				util.click(fieldRadio);
				log("STEP 1:  user can enter data in the custom field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:   user cannot enter data in the custom field", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		   
		   try {
			   ProjectName=getProjectTitle();
			   clickOnSaveProject();
				log("STEP 2:  user can save data in custom field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:   user cannot save data in custom field", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		   try {
				NavigateToProjectSearch();
				log("STEP 3:  user can navigate to Project search ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:   user cannot navigate to Project Search", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		   try {
				ClickOnPlusButton();
				log("STEP 4:  user can able to click the button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  user can able to click the button", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}

			try {
				AddSavedSearch(map.get(Excel.SearchName));
				log("STEP 5:  user can enter the text in  SavedSearch field    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user cannot enter the text in  SavedSearch field ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				ClickOnSaveButton();
				log("STEP 6:  user can click on save button", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				SelectSavedSearches(map.get(Excel.SearchName));
				log("STEP 7: user can able to select value from SavedSearches dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: user not able to select value from SavedSearches dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				ClickOnAddFilterButton(map.get(Excel.DisplayName));
				log("STEP 8:   user can click on Add filter button", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:   user cannot click on Add filter button ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				 By FielOnParcelInfo = By.xpath("//*[text()='" +map.get(Excel.DisplayName)+ "']/..//input[@type='text']");
				   util.waitUntilElementDisplay(FielOnParcelInfo);
					util.inputTextAndPressTab(FielOnParcelInfo, map.get("FieldValue"));
				log("STEP 9:   user can enter value in Search Filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:   user cannot enter value in Search Filter ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}

			try {
				ClickOnSearch();
				log("STEP 10: user is able to click on save button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				By searchResult = By.xpath("//tr[contains(@id,'grdSearchResults_RadGrid')]/..//*[text()='"+map.get("FieldValue")+"']");
				Assert.assertTrue(util.isElementVisible(searchResult));
				log("STEP 11: user can see searched result as per the search filter ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11: user cannot see the searched result ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
	 }
}
