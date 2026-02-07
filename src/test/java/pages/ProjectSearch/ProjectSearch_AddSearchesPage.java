package pages.ProjectSearch;

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

public class ProjectSearch_AddSearchesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	String getProjNameOnSearchRsult,  getProjNoOnSearchResult, getPrjStatusOnSearchResult, getAreaOnSearchResult, getProjName, getProjNo, getPrjStatus, getArea   ;
	SoftAssert assertion =new SoftAssert();
	
	public ProjectSearch_AddSearchesPage(WebDriver driver) {
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
	By navProjectSearch = By.xpath("//span[contains(text(),'Project Search')]");
	By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
	By btnExcel = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToExcelButton']");
    By btnCSV = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToCsvButton']");
    By btnWord = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToWordButton']");
	
    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
    By btnOpenInCurrentWindow = By.xpath("//span[contains(text(),'Open in current window')]");
	
	//Open in pop up validation
  	By TxtProjNameOnSearchResult= By.xpath("(//table/tbody/tr/td[count(//table/thead/tr/th[.='Project Name']/preceding-sibling::th)+1])[2]");
    By ProjNoSearchResult=By.xpath("(//table[contains(@id,'idSearch_grdSearchResults')]/..//td[count(//table/thead/tr/th[.='Project #']/preceding-sibling::th)+1])[1]");
  	By ProjNoSearchResultOrion=By.xpath("(//table/tbody/tr/td[count(//table/thead/tr/th[.='Project #']/preceding-sibling::th)+1])[1]");
  	By ProjNoSearchResultTRA=By.xpath("(//table[contains(@id,'idSearch_grdSearchResults')]/..//td[count(//table/thead/tr/th[.='Project Number']/preceding-sibling::th)+1])[1]");
  	By searchFrame=By.xpath("//iframe[@name='SearchSingleOpen']");
  	By TabonPopUp=By.xpath("//*[@id='ctl00_ConPHRightTop_RadTabStrip1']//span[text()='Project Details']");
  	
  	By ProjName= By.xpath("//input[contains(@id,'OBJPROJECTINFO_radPrjName') and @type='text']");
	public String getProjName() {
		return util.getAttributeValue(ProjName, "value");
	}
	
	By ProjNo= By.xpath("//input[contains(@id,'OBJPROJECTINFO_radPrjNum') and @type='text']");
	public String getProjNo() {
		return util.getAttributeValue(ProjNo, "value");
	}
	
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
		    
		    public void SelectValueFromDropDown(String value) {
		    	if (!commonFunction.checkNA(value)) 
					util.inputTextAndPressTab(dropdown, value);
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
		    }   
		    public void OpenInCurrentWindowButton() {
		    	WebElement web = driver.findElement(documentgrid);
		    	util.waitUntilElementDisplay(documentgrid);
		    	Actions act = new Actions(driver);
		    	act.moveToElement(web).contextClick().build().perform();
		    	util.click(btnOpenInCurrentWindow);
		    	util.dummyWait(2);
		    
		    }
		    
		    public void ValidateProjectDetailsOnPopup() {
		  	  	 getProjNameOnSearchRsult= driver.findElement(TxtProjNameOnSearchResult).getText();
		  	  	 if(clientName.contains("ORION")) {
		  	  	 getProjNoOnSearchResult=driver.findElement(ProjNoSearchResultOrion).getText();
		  	  	 }else if(clientName.contains("TRA")) {
		  	  	 getProjNoOnSearchResult=driver.findElement(ProjNoSearchResultTRA).getText();
		  	  	 }else {
			  	  	 getProjNoOnSearchResult=driver.findElement(ProjNoSearchResult).getText();
			  	  	 }
		  	  	
		  	  	util.dummyWait(2);
		  		ClickOnOpeninPopupButton();
		  		util.isElementVisible(TabonPopUp);
		  		
				assertion.assertEquals(getProjName(), getProjNameOnSearchRsult, "Project Name mismatched");
				ExtentTestManager.log("Project Name on Pupup : " + getProjName());

				if (!clientName.contains("ORSTED")) {
					assertion.assertEquals(getProjNo(), getProjNoOnSearchResult, "Project Number mismatched");
					ExtentTestManager.log("Project Number on Pupup : " + getProjNo());
				}		  		
		  	  	}
		  	  	
		  	  	public void ValidateProjectDetailsOnCurrentWindow() {
		  	  		OpenInCurrentWindowButton();
		  	  		util.isElementVisible(TabonPopUp);
		  	  		
		  	  	assertion.assertEquals(getProjName(), getProjNameOnSearchRsult, "Project Name mismatched");
				ExtentTestManager.log("Project Name on Current Window : "+getProjName());
		  		 
				if (!clientName.contains("ORSTED")) {
					assertion.assertEquals(getProjNo(), getProjNoOnSearchResult, "Project Number mismatched");
					ExtentTestManager.log("Project Number on Current Window : " + getProjNo());
				}	
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
				
	   public void AddSearches(Map<String, String> map, String testcaseName) {
		   try {
				NavigateToProjectSearch();
				log("STEP 1:  user can navigate to Project search ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:   user cannot see the Project Search options in menu", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		   
		   
		   try {
				ClickOnPlusButton();
				log("STEP 2:  user can able to click on the plus button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  user cannot able to click on the plus button", Status.FAIL);
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
			if(environment.contains("STEELHEAD") || environment.contains("CRIMSON")) {
				try {
					ClickOnAddFilterButton(map.get("OtherFilter"));
					log("STEP 6:   user can click on Add filter button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
			}else if(environment.contains("WOLFMIDSTREAM")){
			try {
				ClickOnAddFilterButton("Wolf File #");
				log("STEP 6:   user can click on Add filter button", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			}else if(environment.contains("NEXTERA")){
				try {
					ClickOnAddFilterButton("GIS ID:");
					log("STEP 6:   user can click on Add filter button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
				}{
				try {
					ClickOnAddFilterButton(map.get(Excel.SelectFilter));
					log("STEP 6:   user can click on Add filter button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
				}
			util.waitUntilPageLoad();
			if (util.isElementPresent(dropdown)) {
				   log("STEP 7 : one more \"Add new filter\"  DD filed added    ", Status.PASS);
				} else {
				   log("STEP 7: \"Add new filter\" dd filed not added", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 7");
		   	} 
			
			try {
				SelectDropDown(map.get(Excel.DropDown));
				log("STEP 8: User can enter value in the added filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot enter value in the added filter ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}

			try {
				ClickOnSearch();
				log("STEP 9: user is able to click on save button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: user not able to click on save button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			if (util.isElementPresent(documentgrid)) {
				   log("STEP 10 :search results should  displays according to applied filter on right side ", Status.PASS);
				} else {
				   log("STEP 10: Search results not displays according to applied filter  ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 10 ");
		   	} 
			
			try {
				ValidateProjectDetailsOnPopup();
				log("STEP 11: Project Details on pop up is matched", Status.PASS);
			}
			catch(Exception e) {
				log("STEP 11: Project Details on pop up not matched", Status.FAIL);
			}
			driver.switchTo().defaultContent();
			util.click(btnClose);
			
			
			try {
				ValidateProjectDetailsOnCurrentWindow();
				log("STEP 12: Project Details on current window is matched", Status.PASS);
			}
			catch(Exception e) {
				log("STEP 12: Project Details on current window is not  matched", Status.FAIL);
			}
			
				util.waitUntilElementDisplay(navTools);
		    	util.click(navTools);
		    	util.waitUntilElementDisplay(navProjectSearch);
		    	util.click(navProjectSearch);
		    	
           try {
				SelectSavedSearches(map.get(Excel.SavedSearches));
				log("STEP 13: User can select the saved search", Status.PASS);
			} catch (Exception e) {
				log("STEP 13:  User cannot select the saved search", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			if(environment.contains("STEELHEAD") || environment.contains("CRIMSON")) {
				try {
					ClickOnAddFilterButton(map.get("OtherFilter"));
					log("STEP 6:   user can click on Add filter button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
			}else if(environment.contains("WOLFMIDSTREAM")){
				try {
					ClickOnAddFilterButton("Wolf File #");
					log("STEP 6:   user can click on Add filter button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
			} else if(environment.contains("NEXTERA")){
				try {
					ClickOnAddFilterButton("GIS ID:");
					log("STEP 6:   user can click on Add filter button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
				}{
				try {
					ClickOnAddFilterButton(map.get(Excel.SelectFilter));
					log("STEP 6:   user can click on Add filter button", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
				}
			try {
				ClickOnAddFilterButton();
				log("STEP 15: User can click on Add Filter button", Status.PASS);
			} catch (Exception e) {
				log("STEP 15:  User cannot click on Add Filter button", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			util.waitUntilPageLoad();
			util.waitFor(500);
			try {
				SelectValueFromDropDown(map.get(Excel.DropDown));
				log("STEP 16: User can enter value in the added Filter", Status.PASS);
			} catch (Exception e) {
				log("STEP 16:  User cannot enter value in the added filter", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
			
			try {
				ClickOnSearch();
				log("STEP 17: User can click on search button", Status.PASS);
			} catch (Exception e) {
				log("STEP 17:  User cannot click on search button", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			
			
			try {
				Assert.assertTrue(util.isElementVisible(btnExcel));
				log("STEP 18: user is able to see on export to excel icon ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 18: user not able see on export to excel icon ", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(btnCSV));
				log("STEP 19: user is able to see on export to CSV icon ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 19: user not able see on export to CSV icon", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(btnWord));
				assertion.assertAll();
				log("STEP 20: user is able to see on export to word icon", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 20: user not able see on export to word icon", Status.FAIL);
			}
			
			
			
			
			
			
			
	 }
}
