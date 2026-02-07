package testsuit.PropertyManagement;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import page.Common.LoginPage;
import pages.PropertyManagement.PropertyManagementSearchesPage;


@Listeners(com.listeners.MyListeners.class)
public class PropertyMangementSearchesTest extends BasePage{
	
	LoginPage objLogin;
	PropertyManagementSearchesPage ObjPMSearchePage;
	
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		ObjPMSearchePage = new PropertyManagementSearchesPage(driver);
		
	}
	
	
	@Test(priority = 1,enabled = true)
	public void PropertyManagementSearch_Add_Savedsearch_TC_01() throws Exception {
		log("TC01 : Add New Saved Search");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddSearches" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTY_MANAGEMENT), Excel.AddSearches, testcaseName);
		ObjPMSearchePage.AddSearches(map, testcaseName);
	}
	
	
	@Test(priority = 2,enabled = true)
	public void PropertyManagementSearche_PerformSearch_TC_02() throws Exception {
		log("TC02 : Perform Search");
		String testcaseName = "AddSearches" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTY_MANAGEMENT), Excel.AddSearches, testcaseName);
		ObjPMSearchePage.SavedSearches(map, testcaseName);
	}

	@Test(priority = 3,enabled = true)
	public void PropertyManagementSearche_DeleteSavedSearch_TC_03() throws Exception {
		log("TC03 :Delete saved search");
		String testcaseName = "AddSearches" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTY_MANAGEMENT), Excel.AddSearches, testcaseName);
		ObjPMSearchePage.DeleteSelectedSearch(map, testcaseName);
	}
	
}
