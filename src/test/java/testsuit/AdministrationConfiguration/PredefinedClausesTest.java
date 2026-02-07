package testsuit.AdministrationConfiguration;

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
import pages.Acquistion.AddAgreementManagementPage;
import pages.Acquistion.AddPredefineClausesPage;
import pages.Administration.AddNewPredefinedClausesPage;


@Listeners(com.listeners.MyListeners.class)
public class PredefinedClausesTest extends BasePage{

	LoginPage objLogin;
	AddNewPredefinedClausesPage objAddNewPredefinedClausesPage;
	AddAgreementManagementPage objAddAgreementManagement;
	AddPredefineClausesPage objAddPredefineClauses;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddNewPredefinedClausesPage = new AddNewPredefinedClausesPage(driver);
		objAddAgreementManagement = new AddAgreementManagementPage(driver);
		objAddPredefineClauses = new AddPredefineClausesPage(driver);
		
	}
	
	@Test(priority = 1,enabled = true)
	public void Administration_AddPredefined_Clauses_TC_01() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("GRAYHAWKTCE")  & !environment.contains("VALARD")  & !environment.contains("DOMINION")) {
		log("TC01 : Add New Pre-defined Clauses");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddClause" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.AddPredefineClauses, testcaseName);
		objAddNewPredefinedClausesPage.AddNewClause(map, testcaseName);
		}else {
			log("Predefined Clause Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =2 )
	public void Acquisition_AddAgreementManagement_TC_02() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("GRAYHAWKTCE") & !environment.contains("VALARD")  & !environment.contains("DOMINION")) {
		log("TC02 :Add Agreement Management	");
		String testcaseName = "AddAgreementManagement" + clientName;
		log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddAgreementManagement,testcaseName);
			objAddAgreementManagement.AddAgreementManagement(map, testcaseName);
		}else {
			log("Predefined Clause Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =3 , enabled=true)
	public void Acquisition_AddPredefineClauses_TC_03() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("GRAYHAWKTCE") & !environment.contains("MVEA") & !environment.contains("GRIDUNITED") & !environment.contains("VALARD")  & !environment.contains("DOMINION")) {
		log("TC03 :Verify Predefined Clause on Aquisition Tab");
		String testcaseName = "AddPredefineClauses" + clientName;
		log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddPredefineClauses,testcaseName);
			objAddPredefineClauses.AddPredefineclauses(map, testcaseName);	
		}else {
			log("Predefined Clause Menu not applicable for this client", Status.SKIP);
		}
		
  }
	
}
