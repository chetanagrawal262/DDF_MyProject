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

import extentReports.ExtentTestManager;

public class ParcelSearchPageDOM extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	
	public ParcelSearchPageDOM(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By drpSavedSearches = By.xpath("//input[contains(@id,'radPreFilter_Input') and @type='text']");
    By drpAddFilter = By.xpath("//input[contains(@id,'cbSearchOptions_Input') and @type='text']");
    By btnAddFilter = By.xpath("//input[contains(@id,'btnAddSearchOption') and @type='submit']");
    By btnSearch = By.xpath("//input[contains(@id,'btnDoSearch') and @type='button']");
    By navTools = By.xpath("//span[text()='Tools']");
	By navParcelSearch = By.xpath("//span[contains(text(),'Parcel Search')]");
	By txtPage = By.xpath("//*[text()='Page']//input[@type='text']");
	By txtDeedBook = By.xpath("//*[text()='Deed Book']//input[@type='text']");
	By txtCorridorNo = By.xpath("//*[text()='Corridor #']//input[@type='text']");
	By txtParcelNo = By.xpath("//*[text()='Parcel #']//input[@type='text']");
	By txtProjectNo = By.xpath("//*[text()='Project #']//input[@type='text']");
	By txtSubstationNo = By.xpath("//*[text()='Substation #']//input[@type='text']");
	By txtSubstationName = By.xpath("//*[text()='Substation Name']//input[@type='text']");
	By txtInstrumentNumber = By.xpath("//*[text()='Instrument Number']//input[@type='text']");
	By cellParcelNo = By.xpath("(//*[contains(@id,'RadGrid1')]/..//table/tbody/tr/td[count(//table/thead/tr/th[.='Parcel #']/preceding-sibling::th)+1])[1]");
	
	public void NavigateToParcelSearch() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitUntilElementDisplay(navParcelSearch);
		util.click(navParcelSearch);
		util.waitUntilPageLoad();

	}

	public void SelectSavedSearches(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpSavedSearches, value);
		util.dummyWait(1);
	}
	
	public void EnterPage(String value) {
		util.waitUntilElementDisplay(txtPage);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPage, value);
	}
	
	public void EnterDeedBook(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDeedBook, value);
	}

	public void EnterCorridorNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCorridorNo, value);
	}

	public void EnterParcelNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelNo, value);
	}

	public void EnterProjectNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtProjectNo, value);
	}

	public void EnterSubstationNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSubstationNo, value);
	}

	public void EnterSubstationName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSubstationName, value);
	}

	public void EnterInstrumentNumber(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtInstrumentNumber, value);
	}

	public void SelectAddFilter(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAddFilter, value);
		util.dummyWait(2);
	}

	public void ClickOnAddFilterButton() {
		util.waitUntilElementDisplay(btnAddFilter);
		util.click(btnAddFilter);
		util.dummyWait(1);
	}

	public void ClickOnSearch() {
		util.waitUntilElementDisplay(btnSearch);
		util.click(btnSearch);
		util.dummyWait(15);
	}


	public void searchBookRecord(Map<String, String> map, String testcaseName) {

		try {
			NavigateToParcelSearch();
			log("STEP 1:  user can navigate to Parcel search ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:   user cannot see the options in menu", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			SelectSavedSearches(map.get(Excel.SavedSearches));
			log("STEP 2: user can able to select value from Saved Searches dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: user not able to select value from Saved Searches dd  ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			EnterPage(map.get(Excel.Page));
			log("STEP 3: user can enter value in the Page Filter", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user cannot enter value in the Page Filter", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			EnterDeedBook(map.get(Excel.Book));
			log("STEP 4: user can enter value in the Deed Book Filter", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: user cannot enter value in the Deed Book Filter", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			ClickOnSearch();
			log("STEP 5: user is able to click on save button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user not able to click on save button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			By pageValue = By.xpath("(//tr[contains(@id,'ConPHRightTop_idSearch_grdSearchResults_RadGrid1')]//td[text()='"+map.get(Excel.Page)+"'])[1]");
			Assert.assertTrue(util.isElementVisible(pageValue));
			log("STEP 6: user can see Page Value in the Search Record ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: user  cannot see Page Value in the Search Record", Status.FAIL);
		}
		
		try {
			By bookValue = By.xpath("(//tr[contains(@id,'ConPHRightTop_idSearch_grdSearchResults_RadGrid1')]//td[text()='"+map.get(Excel.Book)+"'])[1]");
			Assert.assertTrue(util.isElementVisible(bookValue));
			log("STEP 7: user can see Book Value in the Search Record ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: user  cannot see Book Value in the Search Record", Status.FAIL);
		}

	}
	
	public void searchRecord(Map<String, String> map, String testcaseName) {

		try {
			SelectSavedSearches(map.get(Excel.SavedSearches));
			log("STEP 1: user can able to select value from Saved Searches dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: user not able to select value from Saved Searches dd  ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			SelectAddFilter("Instrument Number");
			log("STEP 2: user can select Instrument Number Filter from the Add Filter DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: user cannot select Instrument Number Filter from the Add Filter DD", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			ClickOnAddFilterButton();
			log("STEP 3: user can click on Add filter button", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user cannot click on Add filter button ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			SelectAddFilter("Substation #");
			log("STEP 4: user can select Substation No Filter from the Add Filter DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: user cannot select Substation No Filter from the Add Filter DD", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			ClickOnAddFilterButton();
			log("STEP 5: user can click on Add filter button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user cannot click on Add filter button ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			SelectAddFilter("Substation Name");
			log("STEP 6: user can select Substation Name Filter from the Add Filter DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: user cannot select Substation Name Filter from the Add Filter DD", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			ClickOnAddFilterButton();
			log("STEP 7: user can click on Add filter button", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot click on Add filter button ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			SelectAddFilter("Project #");
			log("STEP 8: user can select Project No Filter from the Add Filter DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user cannot select Project No Filter from the Add Filter DD", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}

		try {
			ClickOnAddFilterButton();
			log("STEP 9: user can click on Add filter button", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot click on Add filter button ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			EnterCorridorNo("*");
			log("STEP 10: user can enter value in the Corridor # Filter", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user cannot enter value in the Corridor # Filter", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			EnterParcelNo("*");
			log("STEP 11: user can enter value in the Parcel # Filter", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot enter value in the Parcel # Filter", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			EnterInstrumentNumber(map.get("DocNo"));
			log("STEP 12: user can enter value in the Instrument Number Filter", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: user cannot enter value in the Instrument Number Filter", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			EnterSubstationNo(map.get("SubstationNo"));
			log("STEP 13: user can enter value in the Substation # Filter", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: user cannot enter value in the Substation # Filter", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}

		try {
			EnterSubstationName(map.get("SubstationName"));
			log("STEP 14: user can enter value in the Substation Name Filter", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user cannot enter value in the Substation Name Filter", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
			EnterProjectNo(map.get("ProjectNo"));
			log("STEP 15: user can enter value in the Project # Filter", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: user cannot enter value in the Project # Filter", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		try {
			ClickOnSearch();
			log("STEP 16: user is able to click on save button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: user not able to click on save button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		try {
			By docNo = By.xpath("(//tr[contains(@id,'ConPHRightTop_idSearch_grdSearchResults_RadGrid1')]//td[text()='"+map.get("DocNo")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(docNo));
			log("STEP 17: user can see Instrument Number Value in the Search Record ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 17: user  cannot see Instrument Number Value in the Search Record", Status.FAIL);
		}
		
		try {
			By substationNo = By.xpath("(//tr[contains(@id,'ConPHRightTop_idSearch_grdSearchResults_RadGrid1')]//td[text()='"+map.get("SubstationNo")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(substationNo));
			log("STEP 18: user can see Substation # Value in the Search Record ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 18: user  cannot see Substation # Value in the Search Record", Status.FAIL);
		}
		
		try {
			By substationName = By.xpath("(//tr[contains(@id,'ConPHRightTop_idSearch_grdSearchResults_RadGrid1')]//td[text()='"+map.get("SubstationName")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(substationName));
			log("STEP 19: user can see Substation Name Value in the Search Record ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 19: user  cannot see Substation Name Value in the Search Record", Status.FAIL);
		}
		
		try {
			By projectNo = By.xpath("(//tr[contains(@id,'ConPHRightTop_idSearch_grdSearchResults_RadGrid1')]//td[text()='"+map.get("ProjectNo")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(projectNo));
			log("STEP 20: user can see Project # Value in the Search Record ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 20: user  cannot see Project # Value in the Search Record", Status.FAIL);
		}
		
		ExtentTestManager.infoWithScreenshot("Search Record");
		
		String parcelNo= driver.findElement(cellParcelNo).getText();
		String CorridorNo =map.get("ProjectNo")+"/"+parcelNo;
		
		try {
			EnterParcelNo(parcelNo);
			log("STEP 21: user can enter value in the Parcel # Filter", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: user cannot enter value in the Parcel # Filter", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
		
		try {
			EnterCorridorNo(CorridorNo);
			log("STEP 22: user can enter value in the Corridor # Filter", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: user cannot enter value in the Corridor # Filter", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
		
		try {
			ClickOnSearch();
			log("STEP 23: user is able to click on save button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: user not able to click on save button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		
		try {
			By corridor = By.xpath("(//tr[contains(@id,'ConPHRightTop_idSearch_grdSearchResults_RadGrid1')]//td[text()='"+CorridorNo+"'])[1]");
			Assert.assertTrue(util.isElementVisible(corridor));
			log("STEP 24: user can see Corridor # Value in the Search Record ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 24: user  cannot see Corridor # Value in the Search Record", Status.FAIL);
		}

	}
}
