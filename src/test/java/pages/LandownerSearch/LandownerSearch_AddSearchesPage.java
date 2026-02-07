package pages.LandownerSearch;

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
import page.Common.LoginPage;
import pages.ParcelNotes.AddParcelNotesPage;

public class LandownerSearch_AddSearchesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	String EntityNameSearchResult, No_OfNotes;

	
	public LandownerSearch_AddSearchesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navTools = By.xpath("//span[text()='Tools']");
	By navLandownerSearch = By.xpath("//span[contains(text(),'Landowner Search')]");
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

    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By colLandowner = By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='# Landowners']/preceding-sibling::th)+1])[1]");
    By btnExcel = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToExcelButton']");
    By btnCSV = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToCsvButton']");
    By btnWord = By.xpath("//input[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00_ctl02_ctl00_ExportToWordButton']");
    By SearchFrame=By.xpath("//iframe[@name='SearchSingleOpen']");
    By colIsPrimary = By.xpath("//a[text()='IsPrimary']");
    By checkBoxIsPrimary = By.xpath("//input[contains(@id,'_chkIsPrimary')]");
    By editLink = By.xpath("//input[@title='Edit' and contains(@id,'YALCONTACTWITHNAME_radYALGridControl')]");
    By colAgreementLink = By.xpath("//a[text()='# Agreements']");
    By colNoteLink = By.xpath("//a[text()='# Notes']");
    By linkNotes = By.xpath("(//a[contains(@onclick,'ViewNotesInfo')])[1]");
    By iframeNotes = By.xpath("//iframe[@name='ViewLoInfo']");
    By notesGrid = By.xpath("//table[contains(@id,'grid_loinfo_radYALGridControl')]");
    
    
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
	   
	   
		By btnSearch = By.xpath("//input[contains(@id,'btnDoSearch') and @type='button']");
		By spinner = By.xpath("(//div[contains(@id,'idSearch') and @class='loading'])[1]");
		
		   public void ClickOnSearch() {
		    	util.waitUntilElementDisplay(btnSearch);
		    	util.click(btnSearch);
		    	util.waitUntilElementDisappear(spinner);
		    }
		   
		   By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
		    By btnOpenInCurrentWindow = By.xpath("//span[contains(text(),'Open in current window')]");
			By Information = By.xpath("(//span[contains(text(),'Agreement Information')])[2]");
			
		
		    public void ClickOnOpeninPopupButton() {
		    	WebElement web = driver.findElement(documentgrid);
		    	util.waitUntilElementDisplay(documentgrid);
		    	Actions act = new Actions(driver);
		    	act.moveToElement(web).contextClick().build().perform();
		    	util.waitUntilElementDisplay(btnOpenInPopup);
		    	util.click(btnOpenInPopup);
		    	util.switchToIframe(SearchFrame);
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
//		    	util.waitUntilElementDisplay(navLandownerSearch);
//		    	util.click(navLandownerSearch);
		    
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
		    
			By EntityName= By.xpath("//input[contains(@id,'_Corporation_Trust')and @type='text']");
			public String getEntityName() {
				return util.getAttributeValue(EntityName, "value");
			}
			
			By FirstName= By.xpath("//input[contains(@id,'ENTITY_First_Name')and @type='text']");
			public String getFirstName() {
				return util.getAttributeValue(FirstName, "value");
			}
			
			By EntityNameGrid= By.xpath("(//table/tbody/tr/td[count(//table/thead/tr/th[.='Name']/preceding-sibling::th)+1])[2]");
			public void ValidateLandownerInfoOnPopUp() {
				util.isElementPresent(documentgrid);
			       
		    	EntityNameSearchResult=driver.findElement(EntityNameGrid).getText();
			         
		       ClickOnOpeninPopupButton();
			       util.dummyWait(2);
			      
			       if (EntityNameSearchResult.equals(getEntityName())  || EntityNameSearchResult.contains(getFirstName())) {

			      		log("STEP 10: EntityName on pop up  matched !!!", Status.PASS);
			      	} else {
			      		log("STEP 10: ntityName on pop up  Not Matched !!!", Status.FAIL);
			      	}
			     
			}    
				
				public void ValidateLandownerInfoOnCurrentWindow() {
					OpenInCurrentWindowButton();
					
			    	if (EntityNameSearchResult.equals(getEntityName()) || EntityNameSearchResult.contains(getFirstName())) {

			       		log("STEP 11 : Entity Name on current window matched !!!", Status.PASS);
			       	} else {
			       		log("STEP 11: Entity Name  on current window Matched !!!", Status.FAIL);
			       	}
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
		   
		   
		   
		   
	   public void AddSearches(Map<String, String> map, String testcaseName) {
		   try {
				NavigateToLandownerSearch();
				log("STEP 1:  user can navigate to Landowner search ", Status.PASS);
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
				if(environment.contains("WOLFMIDSTREAM")) {
					ClickOnAddFilterButton(map.get("OtherFilter"));
				}else {
				ClickOnAddFilterButton(map.get(Excel.SelectFilter));
				}
				log("STEP 6:   user can click on Add filter button", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:   user cannot click on Add filter button ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			if (util.isElementPresent(dropdown)) {
				   log("STEP 7: one more \"Add new filter\"  DD filed added    ", Status.PASS);
				} else {
				   log("STEP 7: \"Add new filter\" dd filed not added", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 7 ");
		   	} 
			
			try {
				SelectDropDown(map.get(Excel.DropDown));
				log("STEP 8: user can add filter value ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user can not add filter value ", Status.FAIL);
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
				   log("STEP 10 Search results not displays according to applied filter  ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 10 ");
		   	} 
			
			try {
				Assert.assertTrue(util.isElementVisible(colLandowner));
				log("STEP 11: user can see # Landowners column on the search grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11: user cannot see # Landowners column on the search grid ", Status.FAIL);
			}
			
			try {
				ValidateLandownerInfoOnPopUp();
				log("STEP 12: Landowner Information on pop up is matched", Status.PASS);
			}
			catch(Exception e) {
				log("STEP 12: Landowner Information on pop up not matched", Status.FAIL);
			}
			
			//#66907- start
			if(testcaseName.contains("ROW")) {
				try {
					Assert.assertFalse(util.isElementVisible(colIsPrimary));
					log("STEP 13: user cannot see IsPrimary column on the Address grid", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 13: user can see IsPrimary column on the Address grid ", Status.FAIL);
				}
				
				if(util.isElementVisible(editLink)) {
				try {
					util.click(editLink);
					log("STEP 14: User can click on edit address link", Status.PASS);
				}
				catch(Exception e) {
					log("STEP 14: User cannot click on edit address link", Status.FAIL);
				}
				
				try {
					Assert.assertFalse(util.isElementVisible(checkBoxIsPrimary));
					log("STEP 15: user cannot see IsPrimary checkbox on the Address grid", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 15: user can see IsPrimary checkbox on the Address grid ", Status.FAIL);
				}
				
				}
			}
			
			//#66907- End
			driver.switchTo().defaultContent();
			util.click(btnClose);
			
			
			try {
				ValidateLandownerInfoOnCurrentWindow();
				log("STEP 16: Landowner Information on Current window is matched", Status.PASS);
			}
			catch(Exception e) {
				log("STEP 16: Landowner Information on Current window  not matched", Status.FAIL);
			}
			util.dummyWait(1);
			driver.navigate().back();
			util.reloadPage();
			
			SelectSavedSearches(map.get(Excel.SavedSearches));
			if(environment.contains("WOLFMIDSTREAM")) {
				SelectAddFilter(map.get("OtherFilter"));
			}else {
			SelectAddFilter(map.get(Excel.SelectFilter));
			}
			ClickOnAddFilterButton();
			SelectValueFromDropDown(map.get(Excel.DropDown));
			ClickOnSearch();
			
			try {
				Assert.assertTrue(util.isElementVisible(btnExcel));
				log("STEP 17: user is able to see on export to excel icon ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 17: user not able see on export to excel icon ", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(btnCSV));
				log("STEP 18: user is able to see on export to CSV icon ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 18: user not able see on export to CSV icon", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(btnWord));
				log("STEP 19: user is able to see on export to word icon", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 19: user not able see on export to word icon", Status.FAIL);
			}
			
			
	 }
	   
	 //#104134- start
	   public void verifyLinkedLandownerNotes(Map<String, String> map, String testcaseName) {
		   try {
				NavigateToLandownerSearch();
				log("STEP 1:  user can navigate to Landowner search ", Status.PASS);
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
				ClickOnAddFilterButton(map.get("OtherFilter"));
				log("STEP 3:   user can select Name Filter and clicked on Add Filter button", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:   user cannot select Name Filter and clicked on Add Filter button ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				SelectDropDown("Regression_LO");
				log("STEP 4: user can enter Landowner Name in the 'Name' filter ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: user can not enter Landowner Name in the 'Name' filter ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}

			try {
				ClickOnSearch();
				log("STEP 5: user is able to click on search button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user not able to click on search button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}

			try {
				Assert.assertFalse(util.isElementVisible(colAgreementLink));
				log("STEP 6: user cannot see # Agreement Column", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 6: user can see # Agreement Column", Status.FAIL);
			}

			try {
				Assert.assertTrue(util.isElementVisible(colNoteLink));
				log("STEP 7: user can see # Note Column", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 7: user cannot see # Note Column", Status.FAIL);
			}

			try {
				util.click(linkNotes);
				util.dummyWait(1);
				util.switchToIframe(iframeNotes);
				log("STEP 8: User can click on # of Notes link ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user cannot click on # of Notes link", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}

			try {
				Assert.assertTrue(util.isElementVisible(notesGrid));
				log("STEP 9: user can see notes grid on the popup", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9: user cannot see notes grid on the popup", Status.FAIL);
			}

			try {
				By projectNo = By.xpath("//table[contains(@id,'grid_loinfo_radYALGridControl')]//td[text()='101']");
				Assert.assertTrue(util.isElementVisible(projectNo));
				log("STEP 10: user can see project No", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10: user cannot see project No", Status.FAIL);
			}
			
			try {
				By projName = By.xpath("//table[contains(@id,'grid_loinfo_radYALGridControl')]//td[text()='"+LoginPage.projectName+"']");
				Assert.assertTrue(util.isElementVisible(projName));
				log("STEP 11: user can see project Name", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11: user cannot see project Name", Status.FAIL);
			}
			
			try {
				By description = By.xpath("//table[contains(@id,'grid_loinfo_radYALGridControl')]//td[text()='"+AddParcelNotesPage.NOTE_TEXT+"']");
				Assert.assertTrue(util.isElementVisible(description));
				ExtentTestManager.infoWithScreenshot("Notes Popup");
				log("STEP 12: user can see Notes Text", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12: user cannot see Notes Text", Status.FAIL);
			}
			
			try {
				util.switchToDefaultContent();
				util.click(btnClose);
				log("STEP 13: User can close the notes popup ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: user cannot close the notes popup", Status.FAIL);
			}
				
	   }
}
