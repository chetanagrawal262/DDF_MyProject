package testsuit.SSRSReports;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;

import page.Common.LoginPage;
import pages.InfoByParcelReport.ALT019_ReportConfigurationPage;
import pages.InfoByParcelReport.AddAgreementPage;
import pages.InfoByParcelReport.AddNewPayeeInfoPage;
import pages.InfoByParcelReport.AddProjectPage;
import pages.InfoByParcelReport.InfoByParcelsReportsPage;
import pages.InfoByParcelReport.Landowner_AddLandownerPage;
import pages.InfoByParcelReport.LegalDescription_AddLegalDescriptionRecordPage;
import pages.InfoByParcelReport.ParcelInformation_AddNewParcelPage;
import pages.SSRSReport.C006_ReportConfigurationPage;

@Listeners(com.listeners.MyListeners.class)
public class C006_MilestoneTrackingByProjectReportTest extends BasePage {

	LoginPage objLogin;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	C006_ReportConfigurationPage objReportConfig;
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objReportConfig = new C006_ReportConfigurationPage(driver);
	}

	@Test(priority=1)
	public void Set_Report_Permission_TC_01() throws Exception {
		if (Stream.of("STEELHEAD", "ORSTED", "WSBALT", "CONNECTGEN", "RAMACO", "AVANTUS", "VALARD", "GRAYHAWKALT", "TREATYOAK", "NOVA", "ORION", "BAYWA", "WOLFMIDSTREAM").noneMatch(environment::contains)) {
		log("TC01 : Set Report Permission");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "Report" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), Excel.ReportsPermission, testcaseName);
		objReportConfig.ReportPermission(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 2,enabled = true)
	public void C006_Report_Configuration_TC_02() throws Exception {
		if (Stream.of("STEELHEAD", "ORSTED", "WSBALT", "CONNECTGEN", "RAMACO", "AVANTUS", "VALARD", "GRAYHAWKALT", "TREATYOAK", "NOVA", "ORION", "BAYWA", "WOLFMIDSTREAM").noneMatch(environment::contains)) {
		log("TC02 : C006 Report configuration");
		String testcaseName = "Report" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), Excel.ReportsPermission, testcaseName);
		objReportConfig.ReportConfiguration(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 3,enabled = true)
	public void Remove_C006_Report_Configuration_TC_3() throws Exception {
		if (Stream.of("STEELHEAD", "ORSTED", "WSBALT", "CONNECTGEN", "RAMACO", "AVANTUS", "VALARD", "GRAYHAWKALT", "TREATYOAK", "NOVA", "ORION", "BAYWA", "WOLFMIDSTREAM").noneMatch(environment::contains)) {
		log("TC3 : Delete Report configuration");
		String testcaseName = "Report" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), Excel.ReportsPermission, testcaseName);
		objReportConfig.removeReportConfiguration(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
}
