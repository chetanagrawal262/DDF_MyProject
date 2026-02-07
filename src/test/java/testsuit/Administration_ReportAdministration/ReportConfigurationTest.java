package testsuit.Administration_ReportAdministration;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import page.Common.LoginPage;
import pages.Administration_ReportAdministration.ReportConfigurationPage;

@Listeners(com.listeners.MyListeners.class)

public class ReportConfigurationTest extends BasePage{

	LoginPage objLogin;
	ReportConfigurationPage objReportConfiguration;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objReportConfiguration = new ReportConfigurationPage(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Report_Configuration_TC_01() throws Exception {
		log("TC01 : Add Report configuration");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ReportConfiguration" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.ReportConfiguration, testcaseName);
		objReportConfiguration.ReportConfiguration(map, testcaseName);
		
	}
	
	@Test(priority = 2,enabled = true)
	public void Remove_Report_Configuration_TC_02() throws Exception {
		log("TC02 : Delete Report configuration");
		String testcaseName = "ReportConfiguration" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.ReportConfiguration, testcaseName);
		objReportConfiguration.removeReportConfiguration(map, testcaseName);
		
	}
}
