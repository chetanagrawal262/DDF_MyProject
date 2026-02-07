package testsuit.DocumentSearch;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;

import page.Common.LoginPage;
import pages.DocumentSearch.DocumentSearch_AddSearchesPage;
import pages.DocumentSearch.DocumentSearch_DeleteSearchesPage;


@Listeners(com.listeners.MyListeners.class)
public class DocumentSavedSearchesTest extends BasePage{

	LoginPage objLogin;
	DocumentSearch_AddSearchesPage objAddSearches;
	DocumentSearch_DeleteSearchesPage objDeleteSelected;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddSearches = new DocumentSearch_AddSearchesPage(driver);
		objDeleteSelected = new DocumentSearch_DeleteSearchesPage(driver);
	}
	
	
	
	@Test(priority = 1,enabled = true)
	public void ToolsDocument_Searches_Add_search_TC_01() throws Exception {
		log("TC01 : Tools-Document searches-add search");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddSearches" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.DOCUMENT_SEARCH_TEST_DATA), Excel.AddSearches, testcaseName);
		objAddSearches.AddSearches(map, testcaseName);
	}
	
	@Test(priority = 2,enabled = true)//Delete Icon not present in application
	public void ToolsDocument_Searches_Delete_selected_search_TC_02() throws Exception {
		log("TC02 : Tools-Documents  searches-Delete selected search");
		String testcaseName = "DeleteSelectedSearch" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.DOCUMENT_SEARCH_TEST_DATA), Excel.DeleteSelectedSearch, testcaseName);
		objDeleteSelected.DeleteSelectedSearch(map, testcaseName);
	}
	
}
