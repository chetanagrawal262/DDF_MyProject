package testsuit.RoyaltyPayment;

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
import pages.RoyaltyPayment.ParcelInformation_AddNewParcelPage;
import pages.InfoByParcelReport.AddProjectPage;
import pages.PermanentInfrastructure.AddTurbineRecordPage;
import pages.Project.UpdateProjectSettingAndMaintancePage;
import pages.RoyaltyPayment.AddNewInformationPage;
import pages.RoyaltyPayment.ProjectPayTemplatePage;
import pages.RoyaltyPayment.ProjectPaymentManagerPage;
import pages.RoyaltyProcessing.ProductionTracking_AddProductionData;
import pages.RoyaltyProcessing.RevenueDataPage;
import pages.RoyaltyProcessing.RevenuePeriodsPage;
import pages.RoyaltyProcessing.RoyaltyPaymentsPage;
import pages.RoyaltyPayment.AddNewPayeeInfoPage;
import pages.RoyaltyPayment.PaymentInformationPage;

@Listeners(com.listeners.MyListeners.class)
public class RoyaltyPaymentTest extends BasePage {

	LoginPage objLogin;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	AddProjectPage objAddProject;
	UpdateProjectSettingAndMaintancePage objUpdateProject;
	ParcelInformation_AddNewParcelPage objAddParcel;
	AddTurbineRecordPage objAddTurbineRecord;
	ProjectPayTemplatePage objProjectPayTemplatePage;
	RevenuePeriodsPage objRevenuePeriods;
	RevenueDataPage objRevenueData;
	ProductionTracking_AddProductionData objAddProductionData;
	AddNewInformationPage objAddInfo;
	AddNewPayeeInfoPage objAddPayee;
	PaymentInformationPage objPayment;
	ProjectPaymentManagerPage objProjectPaymentManagerPage;
	RoyaltyPaymentsPage objRoyaltyPayments;
	String testcaseName;
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddProject = new AddProjectPage(driver);
		objUpdateProject = new UpdateProjectSettingAndMaintancePage(driver);
		objAddParcel = new ParcelInformation_AddNewParcelPage(driver);
		objAddTurbineRecord = new AddTurbineRecordPage(driver);
		objProjectPayTemplatePage = new ProjectPayTemplatePage(driver);
		objRevenuePeriods = new RevenuePeriodsPage(driver);
		objRevenueData = new RevenueDataPage(driver);
		objAddProductionData = new ProductionTracking_AddProductionData(driver);
		objAddInfo = new AddNewInformationPage(driver);
		objAddPayee = new AddNewPayeeInfoPage(driver);
		objPayment = new PaymentInformationPage(driver);
		objProjectPaymentManagerPage = new ProjectPaymentManagerPage(driver);
		objRoyaltyPayments = new RoyaltyPaymentsPage(driver);
	}

	@Test(enabled = true,priority = 1)
	public void add_Project_TC_01() throws Exception {
		log("TC01 : Add a Project");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "AddProject" + clientName;
		log("Data picked : " + testcaseName);
		log("navigating to create new Project");
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.ProjectInformation,
				testcaseName);
		objAddProject.addProjectInformation(map, testcaseName);
	}

	@Test(priority=2, enabled=true)
	public void Update_Royalty_Processing_Setting_TC_02() throws Exception {
		log("TC02 : Update Royalty Processing Setting");
		String testcaseName = "ProjectSettingsAndMaintence" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.ProjectSettingsAndMaintence,
				testcaseName);
		objUpdateProject.updateProjectSettingAndMaintence(map);
	}
	
	@Test(priority=3, enabled=true)
	public void Revenue_Periods_TC_03() throws Exception {
		log("TC03 : Add Revenue Periods ");
		String testcaseName = "RevenueManager" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.RevenueManager, testcaseName);
		objRevenuePeriods.RevenuePeriods(map, testcaseName);
		objRevenuePeriods.VerifyNoTurbineMessage(map, testcaseName);
	}
	
	@Test(priority=4, enabled=true)
	public void addNewParcel_TC_04() throws Exception {
		log("TC04 : Add Parcel");
		String testcaseName = "AddParcel" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.AddParcel,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
	}
	
	@Test(priority =5, enabled=true)
	public void AddTurbineRecord_TC_05() throws Exception {
		log("TC05 : Add Turbine record");
		String testcaseName = "AddTurbineRecord" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddTurbineRecord, testcaseName);
		objAddTurbineRecord.NavigateToPermanentInfrastructure();
		objAddTurbineRecord.AddTurbineRecord(map, testcaseName);
	}
	
	@Test(priority=6,enabled = true)
	public void AddRoyaltyTemplate_TC_06() throws Exception {
		log("TC06 :Project Pay Template-Royalty Template");
		String testcaseName = "PaymentTermsSummary" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.PaymentTermsSummary,
				testcaseName);
		objProjectPayTemplatePage.PaymentTerms(map, testcaseName);
	}
	
	
	@Test(priority = 7,enabled = true)
	public void Revenue_Data_TC_07() throws Exception {
		log("TC07 : Revenue Data");
		String testcaseName = "RevenueManager" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.RevenueManager, testcaseName);
		objRevenueData.RevenueManager(map, testcaseName);
	}
	
	@Test(priority = 8,enabled = true)
	public void Production_Data_TC_08() throws Exception {
		log("TC08 :Production Data");
		String testcaseName = "RevenueManager" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.RevenueManager, testcaseName);
		objAddProductionData.ProductionTracking(map, testcaseName);
	}
	
	@Test(priority = 9,enabled = true)
	public void Add_Agreement_TC_09() throws Exception {
		log("TC09 : Add a Agreement Information");
		String testcaseName = "AddAgreementInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.AgreementInfo, testcaseName);
		objAddInfo.addAgreementInformation(map, testcaseName);
	}

	@Test(priority = 10,enabled = true)
	public void Add_Payee_Information_TC_10() throws Exception {
		log("TC10 : Add Payee Information");
		String testcaseName = "AddPayeeInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.PayeeInfo, testcaseName);
		objAddPayee.addPayeeInformation(map, testcaseName);
	}
	
	@Test(priority = 11,enabled = true)
	public void Create_Royalty_Payment_TC_11() throws Exception {
		log("TC11 : Create Royalty Payment");
		String testcaseName = "RoyaltyPayment" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.PaymentInfo, testcaseName);
		objPayment.addNewPaymentInformation(map, testcaseName);
	}
	
	@Test(priority =12, enabled= true)
	public void Process_Royalty_Payments_TC_12() throws Exception {
		log("TC12 : Royalty Payments");
		String testcaseName = "RoyaltyPayments";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), "RoyaltyPayments", testcaseName);
		objRoyaltyPayments.RoyaltyPayments(map,testcaseName);
	}
	
	@Test(priority = 13,enabled = true)
	public void ApprovePayment_TC_13() throws Exception {
		log("TC13 : Approve Pending Payment");
		String testcaseName = "ProjectPaymentManager" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.ProjectPaymentManager, testcaseName);
		objProjectPaymentManagerPage.approvePayment(map, testcaseName);
	}
	
	@Test(priority = 14,enabled = true)
	public void Verify_Revenue_Period_Message_TC_14() throws Exception {
	    log("TC14 : verify Message when Revenue Period is already generated");
		String testcaseName = "RevenueManager" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.RevenueManager, testcaseName);
		objRevenuePeriods.VerifyRevenuePeriodsMessage(map, testcaseName);
	}
	
	@Test(priority = 15,enabled = true)
	public void Verify_Royalty_Payments_Calculation_TC_15() throws Exception {
	    log("TC15 : verify Royalty Payments");
		String testcaseName = "RoyaltyPayment" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), Excel.PaymentInfo, testcaseName);
		objPayment.verifyCalculations(map, testcaseName);
	}
}
