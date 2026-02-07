package testsuit.agreementManager;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.ParcelDetails.ParcelInformation_AddNewParcelPage;
import pages.agreementManager.AddNewAgreementPageNextEra;
import pages.agreementManager.AddNewInformationPage;
import pages.RoyaltyPayment.AddNewPayeeInfoPage;
import pages.agreementManager.AdditionalPaymentInformationPage;
import pages.agreementManager.RecurringPaymentPage;

@Listeners(com.listeners.MyListeners.class)
public class AdditionalPaymentTest extends BasePage {

	LoginPage objLogin;
	ParcelInformation_AddNewParcelPage objAddParcel;
	AddNewInformationPage objAddInfo;
	AddNewPayeeInfoPage objAddPayee;
	CommonFunction commonFunction;
	AdditionalPaymentInformationPage objPayment;
	RecurringPaymentPage objRecurringPayment;
	AddNewAgreementPageNextEra objAddNewAgreementNextEra;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddParcel = new ParcelInformation_AddNewParcelPage(driver);
		objAddInfo = new AddNewInformationPage(driver);
		objAddPayee = new AddNewPayeeInfoPage(driver);
		commonFunction = new CommonFunction(driver);
		objPayment = new AdditionalPaymentInformationPage(driver);
		objRecurringPayment = new RecurringPaymentPage(driver);
		objAddNewAgreementNextEra = new AddNewAgreementPageNextEra(driver);
	}

	@Test(priority = 1, enabled=true)
	public void add_Parcel_ParcelInformation_TC_01() throws Exception {
		log("TC01 : Add Parcel");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddParcel" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcel,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
	}
	
	@Test(priority = 2,enabled = true)
	public void AgreementManager_Add_Agreement_Information_TC_02() throws Exception {
		log("TC02 : Add an Agreement");
		String testcaseName = "AddAgreementInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), Excel.AgreementInfo, testcaseName);
		objAddInfo.addAgreementInformation(map, testcaseName);
	}

	@Test(priority = 3,enabled = true)
	public void AgreementManager_Add_Payee_Information_TC_03() throws Exception {
		log("TC03 : Add a Payee Information");
		String testcaseName = "AddPayeeInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), Excel.PayeeInfo, testcaseName);
		objAddPayee.addPayeeInformation(map, testcaseName);
	}
	
	@Test(priority = 4,enabled = true, description = "US-105586: Custom Dates payment option removed from Payment Template Page")
	public void Add_Payment_Additional_CustomDates_TC_04() throws Exception {
		if (LoginPage.isApplicableVersion(LoginPage.VERSION)) {
			log("TC not applicable for this application version ",Status.SKIP);
		}else {
		log("TC 04 : Generate Additional Custom Dates Payment");
		String testcaseName = "AddPaymentCustomDate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), Excel.PaymentInfo, testcaseName);
		objPayment.addNewPaymentInformation(map, testcaseName);
		}
	}
	
	@Test(priority = 5,enabled = true)
	public void Add_Payment_Additional_QuarterEnd_TC_05() throws Exception {
		log("TC 05 : Generate Additional Quarter End Payment");
		String testcaseName = "AddPaymentQuarterEnd" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), Excel.PaymentInfo, testcaseName);
		objPayment.addNewPaymentInformation(map, testcaseName);
	}
	
	@Test(priority = 6,enabled = true, description = "US-105655")
	public void Add_RecurringPayment_TC_06() throws Exception {
		if (LoginPage.isApplicableVersion(LoginPage.VERSION)) {
			log("TC 06 : Recurring Payment Test");
			String testcaseName = "RecurringPayment" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "RecurringPaymentInfo", testcaseName);
			objRecurringPayment.verifyRecurringPayment(map, testcaseName);
		}else {
			log("TC not applicable for this application version " + Status.SKIP);
		}
	}
	
	@Test(priority = 7,enabled = true, description = "US-105655")
	public void Add_AltPaymentStartDate_TC_07() throws Exception {
		if (LoginPage.isApplicableVersion(LoginPage.VERSION)) {
			log("TC 07 : Alt Payment Start Date Test");
			String testcaseName = "RecurringPayment" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "RecurringPaymentInfo", testcaseName);
			objRecurringPayment.updateGlobalTemplate("Alt. First Payment Date", testcaseName);
			objRecurringPayment.verifyAltFirstPaymentDateCalculation(map, testcaseName);
		}else {
			log("TC not applicable for this application version " + Status.SKIP);
		}
	}
	
	@Test(priority = 8,enabled = true, description = "US-105655")
	public void Add_EffectiveDateOffsetPayment_TC_08() throws Exception {
		if (LoginPage.isApplicableVersion(LoginPage.VERSION)) {
			log("TC 08: Effective Date + Offset # of Days Test");
			String testcaseName = "RecurringPayment" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "RecurringPaymentInfo", testcaseName);
			objRecurringPayment.updateGlobalTemplate("Effective Date + Offset # of Days", testcaseName);
			objRecurringPayment.verifyEffectiveDateOffsetPaymentCalculation(map, testcaseName);
		}else {
			log("TC not applicable for this application version " + Status.SKIP);
		}
	}
	
	@Test(priority = 9,enabled = true, description = "US-105577")
	public void Verfify_LabelConfigOfStartPaymentDate_TC_09() throws Exception {
		if (LoginPage.isApplicableVersion(LoginPage.VERSION)) {
			log("TC 09 : Verify Label Configuration of Alt. First Payment Date, Offset #Days and Recurring Payment Start Date");
			String testcaseName = "RecurringPayment" + clientName;
			objRecurringPayment.verifyLabelConfigAgreementTermFields(testcaseName);
		}else {
			log("TC not applicable for this application version " + Status.SKIP);
		}
	}
	
	@Test(priority = 10,enabled = true, description = "US-113466")
	public void Create_ConstructionPayments_TC_10() throws Exception {
		if (environment.contains("NEXTERA")) {
			String testcaseName = "AddConstructionPaymentsNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.PaymentInfoNEXTERA, testcaseName);
			objAddNewAgreementNextEra.AddAgreementTerm(map, testcaseName);
			objAddNewAgreementNextEra.addPayment(map, testcaseName);
		}else {
			log("TC not applicable for this Client " + Status.SKIP);
		}
	}
	
	@Test(priority = 11,enabled = true, description = "US-113466")
	public void Create_OperationalPayments_TC_11() throws Exception {
		if (environment.contains("NEXTERA")) {
			String testcaseName = "AddOperationalPaymentsNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.PaymentInfoNEXTERA, testcaseName);
			objAddNewAgreementNextEra.navigateToAgreementInformationTab();
			objAddNewAgreementNextEra.AddAgreementTerm(map, testcaseName);
			objAddNewAgreementNextEra.addPayment(map, testcaseName);
		}else {
			log("TC not applicable for this Client " + Status.SKIP);
		}
	}
	
	@Test(priority = 12,enabled = true)
	public void Add_InActive_Agreement_Term_TC_12() throws Exception {
		if (environment.contains("NEXTERA")) {
		log("TC12 : Add In-Active Agreement Term");
		String testcaseName = "AddPowerFunctionPaymentsNEXTERA";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.PaymentInfoNEXTERA, testcaseName);
		objAddNewAgreementNextEra.navigateToAgreementInformationTab();
		objAddNewAgreementNextEra.AddAgreementTerm(map, testcaseName);
		}
	}
	
	@Test(priority = 13,enabled = true)
	public void Create_PowerFunctionPayment_TC_13() throws Exception {
		if (environment.contains("NEXTERA")) {
			String testcaseName = "AddPowerFunctionPaymentsNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.PaymentInfoNEXTERA, testcaseName);
			objAddNewAgreementNextEra.addPayment(map, testcaseName);
			objAddNewAgreementNextEra.verifyPowerPaymentCalculation(map, testcaseName);
		}else {
			log("TC not applicable for this Client " + Status.SKIP);
		}
	}
	
	@Test(priority = 14,enabled = true)
	public void Create_CPIPaymentFromEffectiveDate_TC_14() throws Exception {
		if (environment.contains("NEXTERA")) {
			String testcaseName = "AddCPIPaymentsNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.PaymentInfoNEXTERA, testcaseName);
			objAddNewAgreementNextEra.verifyCPIPayment(map, testcaseName);
		}else {
			log("TC not applicable for this Client " + Status.SKIP);
		}
	}
}
