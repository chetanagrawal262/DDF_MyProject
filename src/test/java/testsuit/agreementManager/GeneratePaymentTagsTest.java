package testsuit.agreementManager;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.ParcelDetails.ParcelInformation_AddNewParcelPage;
import pages.RoyaltyPayment.AddNewPayeeInfoPage;
import pages.agreementManager.CF_PaymentTagsPage;
import pages.agreementManager.CF_PaymentTags_PaymentTemplatePage;


@Listeners(com.listeners.MyListeners.class)
public class GeneratePaymentTagsTest extends BasePage {

	LoginPage objLogin;
	ParcelInformation_AddNewParcelPage objAddParcel;
	CF_PaymentTagsPage obPaymentTags;
	AddNewPayeeInfoPage objAddPayee;
	CF_PaymentTags_PaymentTemplatePage objPayTemplate;
	CommonFunction commonFunction;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddParcel = new ParcelInformation_AddNewParcelPage(driver);
		obPaymentTags = new CF_PaymentTagsPage(driver);
		objAddPayee = new AddNewPayeeInfoPage(driver);
		commonFunction = new CommonFunction(driver);
		objPayTemplate = new CF_PaymentTags_PaymentTemplatePage(driver);
	}

	@Test(priority = 1, enabled=true)
	public void Add_Parcel_For_CF_PaymentTag_TC_01() throws Exception {
		log("TC01 : Add Parcel");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		if(environment.contains("CONNECTGEN")) {
			objLogin.loginWithSuperAdmin(map);
		}else {
			objLogin.login(map);
		}
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
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), "Generate_CF_PaymentTags", testcaseName);
		obPaymentTags.addAgreementInformation(map, testcaseName);
	}

	@Test(priority = 3,enabled = true)
	public void AgreementManager_Add_Payee_Information_TC_03() throws Exception {
		log("TC03 : Add a Payee Information");
		String testcaseName = "AddPayeeInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), Excel.PayeeInfo, testcaseName);
		objAddPayee.addPayeeInformation(map, testcaseName);
	}
	
	@Test(priority = 4,enabled = true)
	public void Verify_Payment_Templates_TC_04() throws Exception {
		log("TC04 : Verify Payment Tags in payment templates ");
		String testcaseName = "PaymentTermsSummary" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), "CF_Tags_PaymentTemplate", testcaseName);
		objPayTemplate.PaymentTerms(map, testcaseName);
	}
	
	@Test(priority = 5,enabled = true)
	public void Generate_Payment_TC_05() throws Exception {
		log("TC05 : Generate Payment using payment Tags formula ");
		String testcaseName = "Payment" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), "CF_Tags_Payment", testcaseName);
		obPaymentTags.addNewPaymentInformation(map, testcaseName);
	}
}
