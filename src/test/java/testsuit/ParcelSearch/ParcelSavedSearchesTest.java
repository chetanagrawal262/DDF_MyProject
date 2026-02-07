package testsuit.ParcelSearch;

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
import pages.ParcelSearch.BulkDocumentGenerationPanelPage;
import pages.ParcelSearch.BulkMilestonesDatePage;
import pages.ParcelSearch.BulkParcelAssignementPage;
import pages.ParcelSearch.BulkUpdateOptionALTPage;
import pages.ParcelSearch.BulkUpdateOptionDOTPage;
import pages.ParcelSearch.BulkUpdateOptionROWPage;
import pages.ParcelSearch.ParcelSearch_AddSearchesPage;
import pages.ParcelSearch.ParcelSearch_DeleteSearchesPage;
import pages.ParcelSearch.VerifyAcquisitionStatusFilter;


@Listeners(com.listeners.MyListeners.class)
public class ParcelSavedSearchesTest extends BasePage{

	LoginPage objLogin;

	ParcelSearch_AddSearchesPage objAddSearches;
	ParcelSearch_DeleteSearchesPage objDeleteSelected;
	
	BulkUpdateOptionALTPage objBulkUpdateALT;
	BulkUpdateOptionDOTPage objBulkUpdateDOT;
	BulkUpdateOptionROWPage objBulkUpdateROW;
	
	BulkDocumentGenerationPanelPage objDocumentGeneration;
	BulkParcelAssignementPage objBulkParcelAssignement;
	BulkMilestonesDatePage objBulkMilestonesDate;
	VerifyAcquisitionStatusFilter objVerifyAcquisitionStatusFilter;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddSearches = new ParcelSearch_AddSearchesPage(driver);
		objDeleteSelected = new ParcelSearch_DeleteSearchesPage(driver);
		objBulkUpdateALT = new BulkUpdateOptionALTPage(driver);
		objBulkUpdateDOT = new BulkUpdateOptionDOTPage(driver);
		objBulkUpdateROW = new BulkUpdateOptionROWPage(driver);	
		objDocumentGeneration = new BulkDocumentGenerationPanelPage(driver);
		objBulkParcelAssignement = new BulkParcelAssignementPage(driver);
		objBulkMilestonesDate = new BulkMilestonesDatePage(driver);
		objVerifyAcquisitionStatusFilter =new VerifyAcquisitionStatusFilter(driver);
	}
	
	
	
	@Test(priority = 1,enabled = true)
	public void ToolsParcel_Searches_Add_search_TC_01() throws Exception {
		log("TC01 : Tools-Parcel searches-add search");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "AddSearches" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.AddSearches, testcaseName);
		objAddSearches.AddSearches(map, testcaseName);
	}
	

	
	@Test(priority = 2,enabled = true)
	public void Bulk_Update_Option_ALT_TC_02() throws Exception {
		log("TC02 : Bulk update option (ALT) ");
		String testcaseName = "BulkUpdateOption" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.BulkUpdateROW, testcaseName);
		objBulkUpdateALT.BulkUpdateOption(map, testcaseName);
	}
	
	@Test(priority = 3,enabled = true)
	public void Bulk_Update_Option_DOT_TC_03() throws Exception {
		log("TC03 : Bulk update option (DOT) ");
		String testcaseName = "BulkUpdateOption" + clientName;
		log("Data picked : " + testcaseName);
		objBulkUpdateDOT.BulkUpdateOption(testcaseName);
	}
	
	@Test(priority = 4,enabled = true)
	public void Bulk_Update_Option_ROW_TC_04() throws Exception {
		log("TC04 : Bulk update option (ROW) ");
		String testcaseName = "BulkUpdateOption" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.BulkUpdateROW, testcaseName);
		objBulkUpdateROW.BulkUpdateOption(map, testcaseName);
	}
	
	@Test(priority = 5,enabled = true)
	public void Bulk_Document_Generation_panel_TC_05() throws Exception {
		log("TC05: Bulk Document  generation panel");
		String testcaseName = "BulkDocumentGeneration" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.BulkDocumentGeneration, testcaseName);
		objDocumentGeneration.BulkDocumentGenerationPanel(map, testcaseName);
	}

	@Test(priority = 6,enabled = true)
	public void Bulk_Parcel_Assignement_TC_06() throws Exception {
		if(!environment.contains("NOVA") & !environment.contains("ORSTED") & !environment.contains("RAMACO") & !environment.contains("ORION") & !environment.contains("AVANTUS") & !environment.contains("WSBALT") & !environment.contains("WOLFMIDSTREAM") & !environment.contains("VALARD")) {
		log("TC06 : Bulk  Parcel assignement option panel ");
		String testcaseName = "BulkParcelAssignement" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.BulkParcelAssignement, testcaseName);
		objBulkParcelAssignement.BulkParcelAssignement(map, testcaseName);
		}else {
			log("Bulk Parcel Assignment Not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 7,enabled = true)
	public void Bulk_Milestones_Date_TC_07() throws Exception {
		log("TC07 : Bulk  Parcel assignement option panel ");
		String testcaseName = "BulkMilestonesDate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.BulkMilestonesDate, testcaseName);
		objBulkMilestonesDate.BulkMilestonesDate(map, testcaseName);
		
		
	}
	@Test(priority = 8,enabled = true)
	public void VerifyAcquisitionStatusFilter_MultiselectDD_TC_08() throws Exception {
		log("TC08 :Acquisition Status filter ");
		String testcaseName = "AcquisitionStatusFilter" + clientName;
		if(!testcaseName.contains("ROW") & !testcaseName.contains("DOT") & !testcaseName.contains("TRA") & !testcaseName.contains("ORION") & !testcaseName.contains("DOM")) {
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.AcquisitionStatusFilter, testcaseName);
		objVerifyAcquisitionStatusFilter.VerifyAcquisitionStatusFilter_MultiselectDD(map, testcaseName);
		}else {
			log("Not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 9,enabled = true)//Delete Icon not present in application
	public void ToolsParecl_Searches_Delete_selected_search_TC_09() throws Exception {
		log("TC09 : Tools-Parcel  searches-Delete selected search");
		String testcaseName = "DeleteSelectedSearch" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_SEARCH_TEST_DATA), Excel.DeleteSelectedSearch, testcaseName);
		objDeleteSelected.DeleteSelectedSearch(map, testcaseName);
	}
	
}
