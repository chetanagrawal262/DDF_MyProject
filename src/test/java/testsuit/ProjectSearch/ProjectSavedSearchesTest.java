package testsuit.ProjectSearch;

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
import pages.ProjectSearch.BulkAssignmentOptionPage;
import pages.ProjectSearch.BulkDocumentGenerationPanelPage;
import pages.ProjectSearch.BulkUpdateOptionPage;
import pages.ProjectSearch.ProjectSearch_AddSearchesPage;
import pages.ProjectSearch.ProjectSearch_DeleteSearchesPage;


@Listeners(com.listeners.MyListeners.class)
public class ProjectSavedSearchesTest extends BasePage{

	LoginPage objLogin;

	ProjectSearch_AddSearchesPage objAddSearches;
	ProjectSearch_DeleteSearchesPage objDeleteSelected;
	
	BulkUpdateOptionPage objBulkUpdate;

	BulkDocumentGenerationPanelPage objDocumentGeneration;
	BulkAssignmentOptionPage objBulkAssignment;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
	
		objAddSearches = new ProjectSearch_AddSearchesPage(driver);
		objDeleteSelected = new ProjectSearch_DeleteSearchesPage(driver);
		
		objBulkUpdate = new BulkUpdateOptionPage(driver);

		objDocumentGeneration = new BulkDocumentGenerationPanelPage(driver);
		objBulkAssignment = new BulkAssignmentOptionPage(driver);
	}
	

	
	@Test(priority = 1,enabled = true)
	public void ToolsProject_Searches_Add_search_TC_01() throws Exception {
		log("TC01 : Tools-Project searches-add search");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddSearches" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_SEARCH_TEST_DATA), Excel.AddSearches, testcaseName);
		objAddSearches.AddSearches(map, testcaseName);
	}
	
	@Test(priority = 2,enabled = true)
	public void Bulk_Update_Option__TC_02() throws Exception {
		log("TC02 : Bulk update option ");
		String testcaseName = "BulkUpdateOption" + clientName;
		log("Data picked : " + testcaseName);
		objBulkUpdate.BulkUpdateOption(testcaseName);
	}
	
	@Test(priority = 3,enabled = true)
	public void Bulk_Document_Generation_panel_TC_03() throws Exception {
		log("TC03 : Bulk Document  generation panel");
		String testcaseName = "BulkDocumentGeneration" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_SEARCH_TEST_DATA), Excel.BulkDocumentGeneration, testcaseName);
		objDocumentGeneration.BulkDocumentGenerationPanel(map, testcaseName);
	}

	@Test(priority = 4,enabled = true)
	public void Bulk_assignment_option_panel_TC_04() throws Exception {
		log("TC04 : Bulk assignment option panel ");
		String testcaseName = "BulkAssignmentOption" + clientName;
		log("Data picked : " + testcaseName);
		if(!testcaseName.contains("DOT")) {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_SEARCH_TEST_DATA), Excel.BulkAssignmentOption, testcaseName);
		objBulkAssignment.BulkAssignmentOption(map, testcaseName);
		}else {
			log("Not applicable for this client ", Status.SKIP);
		}
	}
	
	@Test(priority = 5,enabled = true)//Delete Icon visibility depends on special permission 'Can use global search'
	public void ToolsProject_Searches_Delete_selected_search_TC_05() throws Exception {
		log("TC05 : Tools-Project  searches-Delete selected search");
		String testcaseName = "DeleteSelectedSearch" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_SEARCH_TEST_DATA), Excel.DeleteSelectedSearch, testcaseName);
		objDeleteSelected.DeleteSelectedSearch(map, testcaseName);
	}
	
}
