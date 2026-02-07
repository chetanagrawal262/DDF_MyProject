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
import pages.Administration.AddNewOperatingCompanyPage;

@Listeners(com.listeners.MyListeners.class)

public class OperatingCompaniesTest extends BasePage{

	LoginPage objLogin;
	AddNewOperatingCompanyPage objAddNewOperatingCompany;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddNewOperatingCompany = new AddNewOperatingCompanyPage(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Add_New_Operating_Company_TC_01() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC01 : Add a Operating Company");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddNewUser" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.AddNewUser, testcaseName);
		objAddNewOperatingCompany.AddNewOperatingCompany(map, testcaseName);
		}else {
			log("Operating Company Menu not applicable for this client", Status.SKIP);
		}
	}
	
}
