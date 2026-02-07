package pages.PropertyManagement;

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

import extentReports.ExtentTestManager;

public class PropertyManagementSearchesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;	
	String FileNo;
	
	public PropertyManagementSearchesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navTools = By.xpath("//span[text()='Tools']");
	By navPMSearch = By.xpath("//span[contains(text(),'Property Management Search')]");
	
	By drpSavedSearches = By.xpath("//input[contains(@id,'radPreFilter_Input') and @type='text']");
	By FirstSavedSearch = By.xpath("((//*[contains(@id,'DropDown')])[1]/..//li)[last()]");
	
 //sanity build
    
    By drpFilter = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_RadDock3_C_cbSearchOptions_Input']");
    By btnAddFilter = By.xpath("//input[contains(@id,'btnAddSearchOption') and @type='submit']");
    By btnSearch = By.xpath("//input[contains(@id,'btnDoSearch') and @type='button']");
    By checkboxGlobal = By.xpath("//input[contains(@id,'chkGlobalSearch')]");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
    By btnOpenInCurrentWindow = By.xpath("//span[contains(text(),'Open in current window')]");
    By searchFrame=By.xpath("//iframe[@name='SearchSingleOpen']");
    
    By btnExcel = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToExcelButton']");
    By btnCSV = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToCsvButton']");
    By btnWord = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToWordButton']");
	
    public void NavigateToPropertyManagementSearch() {
	    	util.waitUntilElementDisplay(navTools);
	    	util.click(navTools);
	    	util.waitUntilElementDisplay(navPMSearch);
	    	util.click(navPMSearch);
	    	
	    }
	 public void SelectSavedSearches() {
	    	util.waitUntilElementDisplay(drpSavedSearches);
	    	util.click(drpSavedSearches);
	    	util.dummyWait(1);
	    	util.click(FirstSavedSearch);
	    	
	 		}
	
	 By PlusButton = By.xpath("//img[contains(@id,'btnAddSearch')]");
		By Iframe = By.xpath("//iframe[@name='RadAddNewSearch']");
		By txtSavedSearch = By.xpath("//input[contains(@id,'ItemName') and @type='text']");
		By btnSave = By.xpath("//input[contains(@id,'SaveNewMapping')]");
	    By btnClose = By.xpath("//a[@title='Close']");
	    By drpAddFilter = By.xpath("//input[contains(@id,'cbSearchOptions_Input') and @type='text']");
		By btnSaveSearch = By.xpath("//input[contains(@id,'btnSaveFilter') and @type='button']");
	    By dropdown = By.xpath("(//input[contains(@id,'idSearch_RadDock3') and @type='text'])[2]");

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
		 
		 public void checkGlobalCheckBox() {
				util.waitUntilElementDisplay(checkboxGlobal);
				util.click(checkboxGlobal);
			}
		 
		 public void ClickOnSaveSearchButton() {
				util.waitUntilElementDisplay(btnSaveSearch);
				util.click(btnSaveSearch);
				util.dummyWait(2);
			}
		    
		   public void ClickOnAddFilterButton(String value) {
		    	if (!commonFunction.checkNA(value)) 
					util.inputTextAndPressTab(drpAddFilter, value);
		    	util.dummyWait(2);
		    	util.waitUntilElementDisplay(btnAddFilter);
		    	util.click(btnAddFilter);
		  }
		   
		   public void SelectDropDown(String value) {
		    	if (!commonFunction.checkNA(value)) 
					util.inputTextAndPressTab(dropdown, value);
	      }
		   
		   By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
			
			   public void ClickOnSearch() {
			    	util.waitUntilElementDisplay(btnSearch);
			    	util.click(btnSearch);
			    	util.dummyWait(2);
			    }
	 public void RightClickOnSearchResultgrid() {
		    	WebElement web = driver.findElement(documentgrid);
		    	util.waitUntilElementDisplay(documentgrid);
		    	Actions act = new Actions(driver);
		    	act.moveToElement(web).contextClick().build().perform();
		    	util.waitUntilElementDisplay(btnOpenInPopup);
		    	util.waitUntilElementDisplay(btnOpenInCurrentWindow);
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
		    By FileNoOnGrid= By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='File #']/preceding-sibling::th)+1])[1]");
			
		    By filelNo= By.xpath("//input[contains(@id,'File_Number') and @type='text']");
			public String getFileNo() {
				return util.getAttributeValue(filelNo, "value");
			}
			
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
		    }
		    
		   public void AddSearches(Map<String, String> map, String testcaseName) {
		    	
		    	try {
					NavigateToPropertyManagementSearch();
					log("STEP 1:  user can navigate to Proprty Management search ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1:   user cannot navigate to Proprty Management search menu", Status.FAIL);
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
					log("STEP 3:  user can enter the text in  Saved Search Name field    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: user cannot enter the text in  Saved Search Name field ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
				
				try {
					ClickOnSaveButton();
					log("STEP 4:  user can click on save button", Status.PASS);
				} catch (Exception e) {
					log("STEP 4:  user not able to click on save button  ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
					
		 }
		
	 public void SavedSearches(Map<String, String> map, String testcaseName) {
				 
		try {
				SelectSavedSearches(map.get(Excel.SavedSearches));
				log("STEP 1: user can able to select value from SavedSearches dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: user not able to select value from SavedSearches dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 util.waitFor(500);
		try {
			checkGlobalCheckBox();
			log("STEP 2: user can check the Global checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: user cannot check the Global checkbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			ClickOnSaveSearchButton();
			log("STEP 3: user can click on the Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user cannot click on the Save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
			try {
				ClickOnAddFilterButton(map.get(Excel.SelectFilter));
				log("STEP 4:   user can Add filter ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:   user cannot Add filter ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				SelectDropDown(map.get(Excel.DropDown));
				log("STEP 5:   user can add value in the Added filter ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:   user cannot add value in the Added filter ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				ClickOnSearch();
				log("STEP 6: user is able to click on Search button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user not able to click on Search button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}		
					
			if (util.isElementPresent(documentgrid)) {
			    log("STEP 7 :User can see the search result ", Status.PASS);
			} else {
				log("STEP 7: Search result does not load", Status.FAIL);
					      
			} 
			
			if(util.isElementVisible(btnExcel)) {
				CliclOnExcelIcon();
				log("STEP 8: user is able to click on export to excel icon ", Status.PASS);
			} else {
				log("STEP 8: user not able click on export to excel icon ", Status.FAIL);
				
			}
			
			if(util.isElementVisible(btnCSV)) {
				CliclOnCSVIcon();
				log("STEP 9: user is able to click on export to CSV icon ", Status.PASS);
			} else{
				log("STEP 9: user not able click on export to CSV icon", Status.FAIL);
				
			}
			
			if(util.isElementVisible(btnWord)) {
				CliclOnWordIcon();
				log("STEP 10: user is able to click on export to word icon", Status.PASS);
			} else {
				log("STEP 10: user not able click on export to word icon", Status.FAIL);
				
			}
			
			try {
				FileNo=driver.findElement(FileNoOnGrid).getText().trim();
				ClickOnOpeninPopupButton();
				log("STEP 11: User can click on Open in pop-up ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User cannot click on Open in pop-up ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			if(util.isElementVisible(filelNo)) {
			try {
				Assert.assertEquals(getFileNo(), FileNo, "File No mismatched");
				log("STEP 12: File # matched ", Status.PASS);
			}catch (AssertionError e) {
				log("STEP 12: File # mistmatched ", Status.FAIL);
			}
			}else {
				ExtentTestManager.infoWithScreenshot("Popup");
				log("STEP 12: Record does not open ", Status.FAIL);
			}
			
			try {
				util.switchToDefaultContent();
				util.click(btnClose);
				log("STEP 13: User can close the popup ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: User cannot close the popup", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				OpenInCurrentWindowButton();
				log("STEP 14: User can click on Open in Current Window", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: User cannot click on Open in Current Window", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			try {
				Assert.assertEquals(getFileNo(), FileNo, "File No mismatched");
				log("STEP 15: File # matched ", Status.PASS);
			}catch (AssertionError e) {
				log("STEP 15: File # mistmatched ", Status.FAIL);
			}
	 } 
	
	 
	 By btnDelete = By.xpath("//input[contains(@id,'DeleteSearch') and @type='image']");
		By Message = By.xpath("//span[text()='Search deleted']");
		
		 public void ClickOnDeleteButton() {
			 util.waitUntilElementDisplay(btnDelete);
			 util.click(btnDelete);
			 util.dummyWait(2);
			 util.waitUntilElementDisplay(btnDelete);
			 Assert.assertTrue(util.isElementPresent(Message), "Search deleted");
		 }
		 
		  public void DeleteSelectedSearch(Map<String, String> map, String testcaseName) {
			  try {
					NavigateToPropertyManagementSearch();
					log("STEP 1:  user can navigate to Proprty Management search ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1:   user cannot navigate to Proprty Management search menu", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}

				try {
					SelectSavedSearches(map.get(Excel.SavedSearches));
					log("STEP 2:  user can select saved search from the dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: user cannot select saved search from the dd ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
		 util.waitFor(500);
		 try {
			 ClickOnDeleteButton();
				log("STEP 3: user can able to click on delete icon ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user can not click on delete icon", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		 util.waitFor(500);
			if (util.isElementPresent(btnDelete)) {
				   log("STEP 4 : 'search deleted' message displays     ", Status.PASS);
				} else {
				   log("STEP 4: 'search deleted' message does not display ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 4 ");
		   	} 
			
		  }
	
}
