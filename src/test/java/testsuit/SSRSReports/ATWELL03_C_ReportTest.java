package testsuit.SSRSReports;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.SSRSReport.ATWELL03_C_ReportValidationPage;
import pages.SSRSReport.ReportValidationPage;
import pages.projectImportALT.LandDataImportPage;
import pages.projectImportALT.ProjectImportPage;

@Listeners(com.listeners.MyListeners.class)
public class ATWELL03_C_ReportTest extends BasePage {

	LoginPage objLogin;
	ProjectImportPage objProjectImportPage;
	LandDataImportPage objLandDataImportPage;
	ReportValidationPage objReportPerm;
	ATWELL03_C_ReportValidationPage objVerifyData;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objLandDataImportPage = new LandDataImportPage(driver);
		objReportPerm = new ReportValidationPage(driver);
		objVerifyData = new ATWELL03_C_ReportValidationPage(driver);
	}

	@Test(priority=1)
	public void LandDataImport_TC_01() throws Exception {
		if(environment.contains("ATWELL")) {
		log("TC01 : Land Data Import");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LandDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), Excel.ProjectImportALT,
				testcaseName);
		objLandDataImportPage.verifyLandDataMapping(map, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionAgreement(map, testcaseName);
		String testcaseName2 = "Report" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), "Atwell_Reports", testcaseName2);
		objVerifyData.validationOfImportedData(map, testcaseName2);
		}else {
			log("Test Case is Atwell Specific and not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=2)
	public void Set_Report_Permission_TC_02() throws Exception {
		if(environment.contains("ATWELL")) {
		log("TC02 : Set Report Permission");
		String testcaseName = "Report" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), "Atwell_Reports", testcaseName);
		objReportPerm.ReportPermission(map, testcaseName);
		}else {
			log("Test Case is Atwell Specific and not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=3)
	public void view_ATWELL03_C_Report_TC_03() throws Exception {
		if(environment.contains("ATWELL")) {
		log("TC 03 : Verify ATWELL03_C Landowner Acreage Report");
		String testcaseName = "Report" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), "Atwell_Reports", testcaseName);
		objVerifyData.viewSSRSReport(map, testcaseName);
		}else {
			log("Test Case is Atwell Specific and not applicable for this client", Status.SKIP);
		}
	}
}
