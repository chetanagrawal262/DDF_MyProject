package testsuit.LandownerSearch;

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
import pages.LandownerSearch.BulkAgreementAssignmentPage;
import pages.LandownerSearch.BulkParcelAssignementPage;
import pages.LandownerSearch.BulkUpdateOptionPage;
import pages.LandownerSearch.LandownerSearch_AddSearchesPage;
import pages.LandownerSearch.LandownerSearch_DeleteSearchesPage;
import pages.ParcelDetails.Landowner_AddLandownerPage;
import pages.ParcelNotes.AddParcelNotesPage;


@Listeners(com.listeners.MyListeners.class)
public class LandownerSavedSearchesTest extends BasePage{

	LoginPage objLogin;
	Landowner_AddLandownerPage objAddLandowner;
	LandownerSearch_AddSearchesPage objAddSearches;
	LandownerSearch_DeleteSearchesPage objDeleteSelected;
	AddParcelNotesPage objAddParcelNotes;
	BulkUpdateOptionPage objBulkUpdateOption;
	BulkParcelAssignementPage objBulkParcelAssignement;
	BulkAgreementAssignmentPage objBulkAgreementAssignment;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddSearches = new LandownerSearch_AddSearchesPage(driver);
		objDeleteSelected = new LandownerSearch_DeleteSearchesPage(driver);
		objBulkUpdateOption = new BulkUpdateOptionPage(driver);
		objBulkParcelAssignement = new BulkParcelAssignementPage(driver);
		objBulkAgreementAssignment = new BulkAgreementAssignmentPage(driver);
		objAddParcelNotes = new AddParcelNotesPage(driver);
		objAddLandowner = new Landowner_AddLandownerPage(driver);
	}
	
	
	
	@Test(priority = 1,enabled = true)
	public void ToolsLandowner_Searches_Add_search_TC_01() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("ATWELL")) {
		log("TC01 : Tools-Landowner searches-add search");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddSearches" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LANDOWNER_SEARCH_TEST_DATA), Excel.AddSearches, testcaseName);
		objAddSearches.AddSearches(map, testcaseName);
		}else {
			log("Landowner Search not applicable for this client", Status.SKIP);
		}
	}
	
	
	@Test(priority = 2,enabled = true)
	public void Bulk_Update_Option_TC_02() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("ATWELL")) {
		log("TC02 : Bulk update option");
		String testcaseName = "BulkUpdateOption" + clientName;
		log("Data picked : " + testcaseName);
		objBulkUpdateOption.BulkUpdateOption(testcaseName);
	}else {
		log("Landowner Search not applicable for this client", Status.SKIP);
	}
	}
	
	
	@Test(priority = 3,enabled = true)
	public void Bulk_Parcel_Assignement_TC_03() throws Exception {
		if(!environment.contains("ORION") & !environment.contains("CRIMSON") & !environment.contains("MVEA") & !environment.contains("GRAYHAWKTCE") & !environment.contains("TRA") & !environment.contains("ATWELL") & !environment.contains("AKUOENERGY") & !environment.contains("GRIDUNITED") & !environment.contains("WOLFMIDSTREAM") & !environment.contains("CONNECTGEN") & !environment.contains("DOM")) {
		log("TC03 : Bulk  Parcel assignement option panel ");
		String testcaseName = "BulkParcelAssignement" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LANDOWNER_SEARCH_TEST_DATA), Excel.BulkParcelAssignement, testcaseName);
		objBulkParcelAssignement.BulkParcelAssignement(map, testcaseName);
		}else {
			log("Not Applicable for this client ", Status.SKIP);
		}
	}
	
	@Test(priority = 4,enabled = true)
	public void Bulk_Agreement_Assignment_TC_04() throws Exception {
		if(!environment.contains("ORION") & !environment.contains("CRIMSON") & !environment.contains("MVEA") & !environment.contains("GRAYHAWKTCE") & !environment.contains("TRA") & !environment.contains("ATWELL") & !environment.contains("WOLFMIDSTREAM") & !environment.contains("AKUOENERGY") & !environment.contains("GRIDUNITED") & !environment.contains("CONNECTGEN") & !environment.contains("NEXTERA") & !environment.contains("DOM")) {
		log("TC04 : Bulk  Agreement  assignment option panel ");
		String testcaseName = "BulkAgreementAssignment" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LANDOWNER_SEARCH_TEST_DATA), Excel.BulkAgreementAssignment, testcaseName);
		objBulkAgreementAssignment.BulkAgreementAssignment(map, testcaseName);
		}else {
			log("Not Applicable for this client ", Status.SKIP);
		}
	}
	
	@Test(priority=5,enabled = true, description="US-104134")
	public void verifyNotesLinked_TC_05() throws Exception {
		if(environment.contains("WOLFMIDSTREAM")) {
		String testcaseName = "AddParcelNotes" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddParcelNotes,testcaseName);
		objAddLandowner.AddExistingLandowner(map, testcaseName);
		objAddParcelNotes.AddParcelNotes(map, testcaseName);
		map.clear();
		String testcaseName2 = "AddSearches" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LANDOWNER_SEARCH_TEST_DATA), Excel.AddSearches, testcaseName2);
		objAddSearches.verifyLinkedLandownerNotes(map, testcaseName2);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 6,enabled = true)
	public void ToolsLandowner_Searches_Delete_saved_search_TC_06() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("ATWELL")) {
		log("TC06 : Tools-Landowner  searches-Delete saved search");
		String testcaseName = "DeleteSelectedSearch" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LANDOWNER_SEARCH_TEST_DATA), Excel.DeleteSelectedSearch, testcaseName);
		objDeleteSelected.DeleteSelectedSearch(map, testcaseName);
		}else {
			log("Not Applicable for this client ", Status.SKIP);
		}
	}
	
}
