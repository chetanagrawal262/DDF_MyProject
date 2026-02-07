package testsuit.AgreementSearch;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;

import page.Common.LoginPage;
import pages.LeaseSearch.BulkDocumentGenerationPanelPage;
import pages.LeaseSearch.LeaseSearch_AddSearchesPage;
import pages.LeaseSearch.LeaseSearch_DeleteSearchesPage;


@Listeners(com.listeners.MyListeners.class)
public class LeaseSavedSearchesTest extends BasePage{

	LoginPage objLogin;
	
	LeaseSearch_AddSearchesPage objAddSearches;
	LeaseSearch_DeleteSearchesPage objDeleteSelected;
	BulkDocumentGenerationPanelPage objDocumentGeneration;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);

		objAddSearches = new LeaseSearch_AddSearchesPage(driver);
		objDeleteSelected = new LeaseSearch_DeleteSearchesPage(driver);
		objDocumentGeneration = new BulkDocumentGenerationPanelPage(driver);

	}
	
	
	
	@Test(priority = 1,enabled = true)
	public void ToolsLease_Searches_Add_search_TC_01() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC01 : Tools-Lease searches-add search");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddSearches" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LEASE_SEARCH_TEST_DATA), Excel.AddSearches, testcaseName);
		objAddSearches.AddSearches(map, testcaseName);
		}else {
			log("Lease Search not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 2,enabled = true)
	public void Bulk_Document_Generation_panel_TC_02() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC02 : Bulk Document  generation panel");
		String testcaseName = "BulkDocumentGeneration" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LEASE_SEARCH_TEST_DATA), Excel.BulkDocumentGeneration, testcaseName);
		objDocumentGeneration.BulkDocumentGeneration(map, testcaseName);
		}else {
			log("Lease Search not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 3,enabled = true)//Delete Icon not present in application
	public void ToolsLease_Searches_Delete_selected_search_TC_03() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC03 : Tools-Leases  searches-Delete selected search");
		String testcaseName = "DeleteSelectedSearch" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LEASE_SEARCH_TEST_DATA), Excel.DeleteSelectedSearch, testcaseName);
		objDeleteSelected.DeleteSelectedSearch(map, testcaseName);
		}else {
			log("Lease Search not applicable for this client", Status.SKIP);
		}
	}
	
}
