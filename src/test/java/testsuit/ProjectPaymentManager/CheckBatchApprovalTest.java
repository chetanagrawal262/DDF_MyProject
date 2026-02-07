package testsuit.ProjectPaymentManager;

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
import pages.ProjectPaymentManager.CheckBatchApprovalPage;

@Listeners(com.listeners.MyListeners.class)
public class CheckBatchApprovalTest extends BasePage{

	LoginPage objLogin;
	CheckBatchApprovalPage objCheckBatchApproval;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objCheckBatchApproval = new CheckBatchApprovalPage(driver);
	}
	
	
	@Test(priority =1)
	public void addState_WBS_QLSNumber_SalesforceID_01() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC01 : add State, WBS, QLS Number, Salesforce ID to the Vendor");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "AdditionalInfoNEXTERA";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "AdditionalInfo", testcaseName);
		objCheckBatchApproval.additionalInfo(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =2)
	public void DevelopmentPayment_2001_To_150000_TC_02() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC02 : Check Batch Approval Process for Development Payment withing 2,001 To 150,000");
		String testcaseName = "DevelopmentPayment_1";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =3)
	public void DevelopmentPayment_150001_To_250000_TC_03() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC03 : Check Batch Approval Process for Development Payment withing 150,001 To 250,000");
		String testcaseName = "DevelopmentPayment_2";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority =4)
	public void DevelopmentPayment_250001_To_1000000_TC_04() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC04 : Check Batch Approval Process for Development Payment withing 250,001 To 1,000,000");
		String testcaseName = "DevelopmentPayment_3";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =5)
	public void DevelopmentPayment_1000001_To_3000000_TC_05() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC05 : Check Batch Approval Process for Development Payment withing 1,000,001 To 3,000,000");
		String testcaseName = "DevelopmentPayment_4";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =6)
	public void ConstructionPayment_2001_To_150000_TC_06() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC06 : Check Batch Approval Process for Construction Payment withing 2,001 To 150,000");
		String testcaseName = "ConstructionPayment_1";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =7)
	public void ConstructionPayment_150001_To_250000_TC_07() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC07 : Check Batch Approval Process for Construction Payment withing 150,001 To 250,000");
		String testcaseName = "ConstructionPayment_2";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority =8)
	public void ConstructionPayment_250001_To_1000000_TC_08() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC08 : Check Batch Approval Process for Construction Payment withing 250,001 To 1,000,000");
		String testcaseName = "ConstructionPayment_3";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =9)
	public void ConstructionPayment_1000001_To_3000000_TC_09() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC09 : Check Batch Approval Process for Construction Payment withing 1,000,001 To 3,000,000");
		String testcaseName = "ConstructionPayment_4";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =10) //application issue unable to submit checklog
	public void OperationalPayment_2001_To_150000_TC_10() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC10 : Check Batch Approval Process for Operational Payment withing 2,001 To 150,000");
		String testcaseName = "OperationalPayment_1";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =11)
	public void OperationalPayment_150001_To_250000_TC_11() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC11 : Check Batch Approval Process for Operational Payment withing 150,001 To 250,000");
		String testcaseName = "OperationalPayment_2";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority =12)
	public void OperationalPayment_250001_To_1000000_TC_12() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC12 : Check Batch Approval Process for Operational Payment withing 250,001 To 1,000,000");
		String testcaseName = "OperationalPayment_3";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =13)
	public void OperationalPayment_1000001_To_3000000_TC_13() throws Exception {
		if(environment.contains("NEXTERA")) {
		log("TC13 : Check Batch Approval Process for Operational Payment withing 1,000,001 To 3,000,000");
		String testcaseName = "OperationalPayment_4";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), "PaymentApprovalNextera",
				testcaseName);
		objCheckBatchApproval.approvePayment(map, testcaseName);
		}else {
			log("Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
}
