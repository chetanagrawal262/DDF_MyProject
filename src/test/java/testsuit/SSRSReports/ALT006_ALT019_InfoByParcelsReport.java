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
import pages.InfoByParcelReport.ALT019_ReportConfigurationPage;
import pages.InfoByParcelReport.AddAgreementPage;
import pages.InfoByParcelReport.AddNewPayeeInfoPage;
import pages.InfoByParcelReport.AddProjectPage;
import pages.InfoByParcelReport.InfoByParcelsReportsPage;
import pages.InfoByParcelReport.Landowner_AddLandownerPage;
import pages.InfoByParcelReport.LegalDescription_AddLegalDescriptionRecordPage;
import pages.InfoByParcelReport.ParcelInformation_AddNewParcelPage;

@Listeners(com.listeners.MyListeners.class)
public class ALT006_ALT019_InfoByParcelsReport extends BasePage {

	LoginPage objLogin;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	AddProjectPage objAddProject;
	InfoByParcelsReportsPage objInfoByParcelsReportsPage;
	ParcelInformation_AddNewParcelPage objAddParcel;
	Landowner_AddLandownerPage objAddLandowner;
	LegalDescription_AddLegalDescriptionRecordPage objAddLegalDescription;
	AddNewPayeeInfoPage objAddPayee;
	AddAgreementPage objAddAgreement;
	ALT019_ReportConfigurationPage objReportConfig;
	String testcaseName;
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddProject = new AddProjectPage(driver);
		objInfoByParcelsReportsPage = new InfoByParcelsReportsPage(driver);
		objAddParcel = new ParcelInformation_AddNewParcelPage(driver);
		objAddLandowner = new Landowner_AddLandownerPage(driver);
		objAddLegalDescription = new LegalDescription_AddLegalDescriptionRecordPage(driver);
		objAddPayee = new AddNewPayeeInfoPage(driver);
		objAddAgreement = new AddAgreementPage(driver);
		objReportConfig = new ALT019_ReportConfigurationPage(driver);
	}

	@Test(enabled = true,priority = 1)
	public void add_Project_TC_01() throws Exception {
		log("TC01 : Add a Project");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddProject" + clientName;
		log("Data picked : " + testcaseName);
		log("navigating to create new Project");
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.ProjectInformation,
				testcaseName);
		objAddProject.addProjectInformation(map, testcaseName);
	}
	
	@Test(priority=2, enabled=true)
	public void addNewParcel_TC_02() throws Exception {
		log("TC02 : Add Parcel");
		String testcaseName = "AddParcel" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.AddParcel,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
	}
	
	@Test(priority = 3, enabled=true)
	public void Landowner_AddLandowner_TC_03() throws Exception {
		log("TC03 : Add Landowner");
		String testcaseName = "AddLandowner" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.Landowner,testcaseName);
		objAddLandowner.AddLandowner(map, testcaseName);
		
	}
	
	@Test(priority = 4, enabled=true)
	public void LegalDescription_AddLegalDescriptionRecord_TC_04() throws Exception {
		log("TC04 : Add a Legal Description Record");
		String testcaseName = "AddLegalDescriptionRecord" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.LegalDescription,testcaseName);
		objAddLegalDescription.AddLegalDescriptionRecord(map, testcaseName);
		
	}
	
	@Test(priority = 5,enabled = true)
	public void Add_Agreement_TC_05() throws Exception {
		log("TC05 : Add a Agreement");
		String testcaseName = "AddAgreementInformation" + clientName;
		if(!testcaseName.contains("DOT") & !environment.contains("CRIMSON") & !testcaseName.contains("TRA")) {
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.AgreementInfo, testcaseName);
		objAddAgreement.addAgreementInformation(map, testcaseName);
		}
	}
	
	@Test(priority = 6,enabled = true)
	public void AgreementManager_Add_Payee_Information_TC_06() throws Exception {
		log("TC06 : Add a Payee Information");
		String testcaseName = "AddPayeeInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.PayeeInfo, testcaseName);
		objAddPayee.addPayeeInformation(map, testcaseName);
	}
	
	@Test(priority=7)
	public void Set_Report_Permission_TC_07() throws Exception {
		log("TC07 : Set Report Permission");
		String testcaseName = "ReportPermission" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.ReportsPermission, testcaseName);
		objReportConfig.ReportPermission(map, testcaseName);
	}
	
	
	@Test(priority=8)
	public void view_ALT006_Report_TC_08() throws Exception {
		log("TC08 : Verify ALT006 Info By Parcels Report");
		String testcaseName = "Report" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.SSRSReport, testcaseName);
		objInfoByParcelsReportsPage.viewSSRSReport(map, testcaseName);
	}
	
	
	@Test(priority = 9,enabled = true)
	public void ALT019_Report_Configuration_TC_09() throws Exception {
		log("TC09 : ALT019 Report configuration");
		String testcaseName = "ReportConfiguration" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.ReportConfiguration, testcaseName);
		objReportConfig.ReportConfiguration(map, testcaseName);
	}
	
	@Test(priority=10)
	public void view_ALT019_Report_TC_10() throws Exception {
		log("TC10 : Verify ALT019 Info By Parcels Report");
		String testcaseName = "ReportConfiguration" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.ReportConfiguration, testcaseName);
		objInfoByParcelsReportsPage.viewSSRSReport(map, testcaseName);
	}
	
	@Test(priority = 11,enabled = true)
	public void Remove_ALT019_Report_Configuration_TC_11() throws Exception {
		log("TC11 : Delete Report configuration");
		String testcaseName = "ReportConfiguration" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.ReportConfiguration, testcaseName);
		objReportConfig.removeReportConfiguration(map, testcaseName);
		
	}
}
