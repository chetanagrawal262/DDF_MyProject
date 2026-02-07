package testsuit.AgreementSearch;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import org.testng.annotations.BeforeClass;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Listeners;
import page.Common.LoginPage;
import pages.AgreementSearch.AgreementSearch_AddSearchesPage;
import pages.AgreementSearch.AgreementSearch_DeleteSearchesPage;

import pages.LeaseSearch.BulkDocumentGenerationPanelPage;
import pages.agreementManager.AddNewAgreementPageNextEra;

@Listeners(com.listeners.MyListeners.class)

public class AgreementSavedSearchesTest extends BasePage{

	LoginPage objLogin;

	AgreementSearch_AddSearchesPage objAddSearches;
	AgreementSearch_DeleteSearchesPage objDeleteSelected;
	BulkDocumentGenerationPanelPage objDocumentGeneration;
	AddNewAgreementPageNextEra objAddNewAgreementNextEra;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		
		objAddSearches = new AgreementSearch_AddSearchesPage(driver);
		objDeleteSelected = new AgreementSearch_DeleteSearchesPage(driver);
		objDocumentGeneration = new BulkDocumentGenerationPanelPage(driver);
		objAddNewAgreementNextEra = new AddNewAgreementPageNextEra(driver);

	}
	

	
	@Test(priority = 1,enabled = true)
	public void ToolsAgreement_Searches_Add_search_TC_01() throws Exception {
		log("TC01 : Tools-Agreement searches-add search");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddSearches" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEMENT_SEARCH_TEST_DATA), Excel.AddSearches, testcaseName);
		objAddSearches.AddSearches(map, testcaseName);
	}
	
	@Test(priority = 2,enabled = true)
	public void Bulk_Document_Generation_panel_TC_02() throws Exception {
		if(!environment.contains("ORION")) {
		log("TC02 : Bulk Document  generation panel");
		String testcaseName = "BulkDocumentGeneration" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LEASE_SEARCH_TEST_DATA), Excel.BulkDocumentGeneration, testcaseName);
		objDocumentGeneration.BulkDocumentGeneration(map, testcaseName);
		}else {
			log("Bulk Document Generation Not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 3,enabled = true, description="109549")
	public void verifySalesForceId_QLSNo_AgrementPaymentStatusField_TC_03() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC03 : verify SalesForceId, QLSNo, Agrement Payment Status Field on Agreement page and make it searchable");
		String testcaseName = "AgreementSearchNEXTERA";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEMENT_SEARCH_TEST_DATA), "AgreementSearchNextEra", testcaseName);
		objAddNewAgreementNextEra.verifyAgreementPage(map, testcaseName);
		}else {
			log("This TC is nextera specific and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority = 4,enabled = true, description="109549")
	public void verifySalesForceId_QLSNo_AgrementPaymentStatusFilter_TC_04() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC04 : verify SalesForceId, QLSNo, Agrement Payment Status Filter on Agreement Search page");
		String testcaseName = "AgreementSearchNEXTERA";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEMENT_SEARCH_TEST_DATA), "AgreementSearchNextEra", testcaseName);
		objAddSearches.agreementSearchNextEra(map, testcaseName);
		}else {
			log("This TC is nextera specific and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority = 5,enabled = true)
	public void ToolsAgreement_Searches_Delete_selected_search_TC_05() throws Exception {
		log("TC05 : Tools-Agreement  searches-Delete selected search");
		String testcaseName = "DeleteSelectedSearch" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEMENT_SEARCH_TEST_DATA), Excel.DeleteSelectedSearch, testcaseName);
		objDeleteSelected.DeleteSelectedSearch(map, testcaseName);
	}
	
}
