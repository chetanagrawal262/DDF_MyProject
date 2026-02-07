package testsuit.Administration_ReportAdministration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;

import page.Common.LoginPage;
import pages.Administration_ReportAdministration.ReportManagementPage;

@Listeners(com.listeners.MyListeners.class)

public class ReportManagementTest extends BasePage{

	LoginPage objLogin;
	ReportManagementPage objReportManagement;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objReportManagement = new ReportManagementPage(driver);	

	}
	
	@Test()
	public void Report_Permission_TC_01() throws Exception {
		log("TC01 : Report Permission");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ReportAdministration" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.ReportAdministration, testcaseName);
		objReportManagement.ReportAdministration(map, testcaseName);
	}
	
}
