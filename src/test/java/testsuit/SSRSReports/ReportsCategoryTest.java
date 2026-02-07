package testsuit.SSRSReports;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.SSRSReport.ReportsCategoryPage;

@Listeners(com.listeners.MyListeners.class)
public class ReportsCategoryTest extends BasePage {

	LoginPage objLogin;
	ReportsCategoryPage objReportsCategory;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objReportsCategory = new ReportsCategoryPage(driver);
	}

	@Test(priority=1)
	public void Add_New_Reports_Category_TC_01() throws Exception {
		log("TC01 : Add New Reports Category");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ReportsCategory" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), Excel.ReportsCategory, testcaseName);
		objReportsCategory.addReportsCategory(map, testcaseName);
	}

	@Test(priority=2)
	public void Check_Report_Permission_TC_02() throws Exception {
		log("TC02 : Check Report Permission");
		String testcaseName = "ReportsCategory" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), Excel.ReportsCategory, testcaseName);
		objReportsCategory.checkReportsPermission(map, testcaseName);
	}
	
	@Test(priority=3)
	public void Verify_SSRS_Reports_DashboardPage_TC_03() throws Exception {
		log("TC03 : verify Reports Category on SSRS Reports Dashboard Page");
		String testcaseName = "ReportsCategory" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), Excel.ReportsCategory, testcaseName);
		objReportsCategory.verifyReports(map, testcaseName);
	}
}
