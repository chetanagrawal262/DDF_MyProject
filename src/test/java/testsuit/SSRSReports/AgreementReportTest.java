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
import pages.InfoByParcelReport.AddAgreementPage;
import pages.InfoByParcelReport.AddNewPayeeInfoPage;
import pages.SSRSReport.ReportValidationPage;

@Listeners(com.listeners.MyListeners.class)
public class AgreementReportTest extends BasePage {

	LoginPage objLogin;
	AddNewPayeeInfoPage objAddPayee;
	AddAgreementPage objAddAgreement;
	ReportValidationPage objReportValidation;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	public static String AGREEMENT_NUMBER;
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddPayee = new AddNewPayeeInfoPage(driver);
		objAddAgreement = new AddAgreementPage(driver);
		objReportValidation = new ReportValidationPage(driver);
	}

	@Test(priority = 1,enabled = true)
	public void Add_Agreement_TC_01() throws Exception {
		log("TC01 : Add a Agreement");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddLease" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.AgreementInfo, testcaseName);
		objAddAgreement.addAgreementInformation(map, testcaseName);
		String testcaseName2 = "AddAgreementInformation" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AgreementInfo, testcaseName2);
		objAddAgreement.addAgreementTerm(map, testcaseName2);
	}
	
	@Test(priority = 2,enabled = true)
	public void Payee_Information_Add_Landowner_TC_02() throws Exception {
		log("TC02 : Add a Payee Information");
		String testcaseName = "AddPayeeInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.PayeeInfo, testcaseName);
		objAddPayee.addLandownerInformation(map, testcaseName);
	}
	
	@Test(priority=3)
	public void Set_Report_Permission_TC_03() throws Exception {
		log("TC03 : Set Report Permission");
		String testcaseName = "ReportPermission" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.ReportsPermission, testcaseName);
		objReportValidation.ReportPermission(map, testcaseName);
	}
	
	@Test(priority=4)
	public void View_ALT002_Agreement_Expiration_Report_TC_04() throws Exception {
		log("TC04 : View Agreement Expiration Report");
		String testcaseName = "Report2_" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.SCENARIO_INFOBYPARCELSREPORT), Excel.SSRSReport, testcaseName);
		objReportValidation.viewSSRSReport(map, testcaseName);
	}
	
}
