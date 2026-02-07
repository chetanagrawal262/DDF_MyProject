package testsuit.AdministrationConfiguration;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import page.Common.LoginPage;
import pages.Administration.AddNewPermitInfoPage;


@Listeners(com.listeners.MyListeners.class)
public class PermitAgenciesTest extends BasePage{

	LoginPage objLogin;
	AddNewPermitInfoPage objAddNewPermit;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddNewPermit = new AddNewPermitInfoPage(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Add_New_Permit_Agency_TC_01() throws Exception {
		log("TC01 : Add New Permit Info");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddNewPermit" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.AddNewPermit, testcaseName);
		objAddNewPermit.AddNewPermit(map, testcaseName);
	}
	
}
