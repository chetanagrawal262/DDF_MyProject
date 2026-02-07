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
import pages.Administration_ReportAdministration.EditReportSchedulerPage;
import pages.Administration_ReportAdministration.ReportScheduler_AddNewReportSchedulerPage;

@Listeners(com.listeners.MyListeners.class)


public class ReportSchedulerTest extends BasePage{

	LoginPage objLogin;
	ReportScheduler_AddNewReportSchedulerPage objAddNewReportScheduler;
	EditReportSchedulerPage objEditReportScheduler;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddNewReportScheduler = new ReportScheduler_AddNewReportSchedulerPage(driver);
		objEditReportScheduler = new EditReportSchedulerPage(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Add_New_Report_Scheduler_TC_01() throws Exception {
		log("TC01 : Add New Report scheduler");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddNewReportScheduler" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.AddNewReportScheduler, testcaseName);
		objAddNewReportScheduler.AddNewReportScheduler(map, testcaseName);
		objAddNewReportScheduler.DuplicateRecord(map, testcaseName);
	}
	
//	@Test(priority = 2,enabled = true)
//	public void Edit_Report_Scheduler_TC_02() throws Exception {
//		log("TC02 : Edit Report scheduler");
//		String testcaseName = "EditReportScheduler" + clientName;
//		log("Data picked : " + testcaseName);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.EditReportScheduler, testcaseName);
//		objEditReportScheduler.EditReportScheduler(map, testcaseName);
//	}
	
	
//	@Test(priority = 3,enabled = true)//not applicable
//	public void Delete_Report_Scheduler_TC_03() throws Exception {
//		log("TC03 : Delete Report scheduler");
//		String testcaseName = "DeleteReportScheduler" + clientName;
//		log("Data picked : " + testcaseName);
//		objEditReportScheduler.DeleteReportScheduler(testcaseName);
//	}
}
