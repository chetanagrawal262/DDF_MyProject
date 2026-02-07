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
import pages.Administration.AddNewContractCompanyPage;

@Listeners(com.listeners.MyListeners.class)

public class ContractCompaniesTest extends BasePage{

	LoginPage objLogin;
	AddNewContractCompanyPage objAddNewContractCompany;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddNewContractCompany = new AddNewContractCompanyPage(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Add_New_Contract_Company_TC_01() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("ORSTED")) {
		log("TC01 : Add New Contract Company");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddNewContractCompany" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.AddNewContractCompany, testcaseName);
		objAddNewContractCompany.AddNewContractCompany(map, testcaseName);
		}else {
			log("Contract Company Menu not applicable for this client", Status.SKIP);
		}
	}
	
}
