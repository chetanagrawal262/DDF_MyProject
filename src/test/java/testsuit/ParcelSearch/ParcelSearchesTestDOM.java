package testsuit.ParcelSearch;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import page.Common.LoginPage;
import pages.ParcelSearch.ParcelSearchPageDOM;


@Listeners(com.listeners.MyListeners.class)
public class ParcelSearchesTestDOM extends BasePage{

	LoginPage objLogin;
	ParcelSearchPageDOM objSearch;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objSearch = new ParcelSearchPageDOM(driver);
	}
	
	
	
	@Test(priority = 1,enabled = true)
	public void SearchByDeedBook_Page_TC_01() throws Exception {
		log("TC01 : Search By Deed Book/Page");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "BookAndPageSearch" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.SearchFilterDOM, testcaseName);
		objSearch.searchBookRecord(map, testcaseName);
	}
	
	@Test(priority = 2,enabled = true)
	public void SearchByParcelSearch_Page_TC_02() throws Exception {
		log("TC02 : Search By Parcel Search");
		String testcaseName = "ParcelSearch" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.SearchFilterDOM, testcaseName);
		objSearch.searchRecord(map, testcaseName);
	}
	
//	@Test(priority = 3,enabled = true)
//	public void Tract_Duplication_TC_03() throws Exception {
//		log("TC03 : Tract Duplication");
//		String testcaseName = "ParcelSearch" + clientName;
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.SearchFilterDOM, testcaseName);
//		
//	}
	

	
}
