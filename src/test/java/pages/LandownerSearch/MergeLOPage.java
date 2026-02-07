package pages.LandownerSearch;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class MergeLOPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public MergeLOPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navTools = By.xpath("//span[text()='Tools']");
	By navParcelSearch = By.xpath("//span[contains(text(),'Parcel Search')] | //span[contains(text(),'Tract Search')] | //span[contains(text(),'Record Search')]");
	By navAgreementSearch = By.xpath("//span[contains(text(),'Agreement Search')]");
	By navLandownerSearch = By.xpath("//span[contains(text(),'Landowner Search')]");
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
    By navBulkUpdateOptions = By.xpath("//em[text()='Bulk Update Options']/..//a[@title='Expand']");

    public void NavigateToParcelSearch() {
    	util.waitUntilElementDisplay(navTools);
    	util.click(navTools);
    	util.waitUntilElementDisplay(navParcelSearch);
    	util.click(navParcelSearch);
    	
    }
    
    public void NavigateToAgreementSearch() {
    	util.waitUntilElementDisplay(navTools);
    	util.click(navTools);
    	util.waitUntilElementDisplay(navAgreementSearch);
    	util.click(navAgreementSearch);
    	
    }
    
    public void NavigateToLandownerSearch() {
    	util.waitUntilElementDisplay(navTools);
    	util.click(navTools);
    	util.waitUntilElementDisplay(navLandownerSearch);
    	util.click(navLandownerSearch);
    	
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
	 public void AddFilterValue(String value) {
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
		
	   public void ClickOnSearch() {
	    	util.waitUntilElementDisplay(btnSearch);
	    	util.click(btnSearch);
	    	util.dummyWait(2);
	    	
	    }
	   
	   By btnDelete = By.xpath("//input[contains(@id,'DeleteSearch') and @type='image']");
		By Message = By.xpath("//span[text()='Search deleted']");
	   public void ClickOnDeleteButton() {
			 util.waitUntilElementDisplay(btnDelete);
			 util.click(btnDelete);
			 util.dummyWait(1);
			Assert.assertTrue(util.isElementPresent(Message), "Search deleted");
		 }
	   
	   public void NavigateToBulkUpdateOptions() {
	    	util.waitUntilElementDisplay(navBulkUpdateOptions);
	    	util.click(navBulkUpdateOptions);
	    }
	   
	   
	   public void searchRecord(Map<String, String> map, String testcaseName) {

			try {
				NavigateToLandownerSearch();
				log("STEP 1:  user can navigate to Landowner Search ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  user can navigate to Landowner Search", Status.FAIL);
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
				SelectSavedSearches(map.get(Excel.SearchName));
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
				AddFilterValue(LandownerPage.ENTITY_NAME+"*");
				log("STEP 7:   user can add Filter value", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:   user cannot add Filter value ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}

			try {
				ClickOnSearch();
				log("STEP 8: user is able to click on save button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}

			ExtentTestManager.infoWithScreenshot("Search Result");

			try {
				By firstLO = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME1 + "')])[1]");
				Assert.assertTrue(util.isElementVisible(firstLO));
				log("STEP 9: user can see the " + LandownerPage.LANDOWNER_NAME1 + " Landowner in search result ",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9: user cannot see the " + LandownerPage.LANDOWNER_NAME1 + " Landowner in search result  ",Status.FAIL);
			}

			try {
				By secondLO = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME2 + "')])[1]");
				Assert.assertTrue(util.isElementVisible(secondLO));
				log("STEP 10: user can see the " + LandownerPage.LANDOWNER_NAME2 + " Landowner in search result ",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10: user cannot see the " + LandownerPage.LANDOWNER_NAME2 + " Landowner in search result  ",Status.FAIL);
			}
			
			try {
				By thirdLO = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME3 + "')])[1]");
				Assert.assertTrue(util.isElementVisible(thirdLO));
				log("STEP 11: user can see the " + LandownerPage.LANDOWNER_NAME3 + " Landowner in search result ",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11: user cannot see the " + LandownerPage.LANDOWNER_NAME3 + " Landowner in search result  ",Status.FAIL);
			}
			
			if(!environment.contains("DOM")) {
			try {
				By noOfContactLinked = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME2 + "')])[1]/..//a[text()='1' and contains(@onclick,'ViewContactInfo')]");
				Assert.assertTrue(util.isElementVisible(noOfContactLinked));
				log("STEP 12: user can see the correct # of Contact for  " + LandownerPage.LANDOWNER_NAME2 + " entity",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12: user cannot see the correct # of Contact for" + LandownerPage.LANDOWNER_NAME2 + " entity  ",Status.FAIL);
			}
			}
			
			try {
				By noOfParcelsLinked = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME2 + "')])[1]/..//a[text()='1' and contains(@onclick,'ViewParcelInfo')]");
				Assert.assertTrue(util.isElementVisible(noOfParcelsLinked));
				log("STEP 13: user can see the correct # of Parcels for" + LandownerPage.LANDOWNER_NAME2 + " entity",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 13: user cannot see the correct # of Parcels for" + LandownerPage.LANDOWNER_NAME2 + " entity  ",Status.FAIL);
			}
			
	 }
	   
	   By MergeRecordCheckbox = By.xpath("//input[contains(@id,'C_BLK_chkLOSearch')]");
		By btnUpdate = By.xpath("//input[contains(@id,'_BLK_btnBulkUpdate')]");
		By radioButton = By.xpath("(//input[contains(@id,'C') and @type='radio'])[1]");
		By btnCompleteMerge = By.xpath("//input[@id='btnCompleteMerge']");
	    By SuccessMessage = By.xpath("//span[@id='usrMessage']");
	    
	   public void ClickOnMergeRecordCheckbox() {
			util.dummyWait(1);
			util.waitUntilElementDisplay(MergeRecordCheckbox);
			util.click(MergeRecordCheckbox);
			util.click(MergeRecordCheckbox);
		}
		
		public void ClickOnUpdateButton() {
			util.waitUntilElementDisplay(btnUpdate);
			util.click(btnUpdate);
			util.dummyWait(1);
		}
		
		public void ClickOnRadioButton() {
			util.waitUntilElementDisplay(radioButton);
			util.click(radioButton);
		}
		
		public void ClickOnCompleteMergeButton() {
			util.waitUntilElementDisplay(btnCompleteMerge);
			util.click(btnCompleteMerge);
		}
		
	    public void mergeRecord(String testcaseName) {
		   try {
			   NavigateToBulkUpdateOptions();
				log("STEP 1:  user can expand Bulk Update Options ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  user can not expand Bulk Update Options", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		   
		   try {
			   By secondLO = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME2 + "')])[1]/..//input[@type='checkbox']");
			   util.click(secondLO);
			   By thirdLO = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME3 + "')])[1]/..//input[@type='checkbox']");
			   util.click(thirdLO);
				log("STEP 2: User can select second and third landowner record to merge", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot select second and third landowner  to merge", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		   
		   try {
				ClickOnMergeRecordCheckbox();
				log("STEP 3: User can check Merge Records checkbox ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot check Merge Records checkbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 4: user can click on update button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: user cannot click on update button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				util.switchToChildWindow();
				ClickOnRadioButton();
				log("STEP 5: User can select landowner to keep after merger", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User cannot select landowner to keep after merger", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				ClickOnCompleteMergeButton();
				log("STEP 6: User can click on merge  button.", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot click on merge  button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(SuccessMessage));
				ExtentTestManager.infoWithScreenshot("Landowner Merger");
				log("STEP 7: User can see success message", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 7: User cannot see success message", Status.FAIL);
			}		
			
			driver.close();
			util.dummyWait(2);
			util.switchToParentWindow();
			util.dummyWait(2);
			
			try {
				ClickOnSearch();
				log("STEP 8: user is able to click on save button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				By secondLO = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME2 + "')])[1]");
				Assert.assertTrue(util.isElementVisible(secondLO));
				log("STEP 9: user can see the " + LandownerPage.LANDOWNER_NAME2 + " Landowner in search result ",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9: user cannot see the " + LandownerPage.LANDOWNER_NAME2 + " Landowner in search result  ",Status.FAIL);
			}
			
			try {
				By thirdLO = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME3 + "')])[1]");
				Assert.assertFalse(util.isElementVisible(thirdLO));
				log("STEP 10: user cannot see the " + LandownerPage.LANDOWNER_NAME3 + " Landowner in search result after merger ",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10: user can see the " + LandownerPage.LANDOWNER_NAME3 + " Landowner in search result after merger ",Status.FAIL);
			}
			
			if(!environment.contains("DOM")) {
			try {
				By noOfContactLinked = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME2 + "')])[1]/..//a[text()='2' and contains(@onclick,'ViewContactInfo')]");
				Assert.assertTrue(util.isElementVisible(noOfContactLinked));
				log("STEP 11: user can see the correct # of Contact for  " + LandownerPage.LANDOWNER_NAME2 + " entity",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11: user cannot see the correct # of Contact for" + LandownerPage.LANDOWNER_NAME2 + " entity  ",Status.FAIL);
			}
			}
			
			try {
				By noOfParcelsLinked = By.xpath("(//*[contains(text(),'" + LandownerPage.LANDOWNER_NAME2 + "')])[1]/..//a[text()='2' and contains(@onclick,'ViewParcelInfo')]");
				Assert.assertTrue(util.isElementVisible(noOfParcelsLinked));
				log("STEP 12: user can see the correct # of Parcels for" + LandownerPage.LANDOWNER_NAME2 + " entity",Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12: user cannot see the correct # of Parcels for" + LandownerPage.LANDOWNER_NAME2 + " entity  ",Status.FAIL);
			}
			
			ExtentTestManager.infoWithScreenshot("After Landowner Merger");
			
			if (util.isElementVisible(btnDelete)) {
				try {
					ClickOnDeleteButton();
					log("STEP 13: user can delete the added search", Status.PASS);
				} catch (Exception e) {
					log("STEP 13: user can not delete the added search", Status.FAIL);
					throw new RuntimeException("Failed in step 13");
				}
			}
			
	   }
}
