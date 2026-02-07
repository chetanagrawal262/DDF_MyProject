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
import pages.ProjectPaymentManager.CheckLogInformationPage;
import pages.ProjectPaymentManager.PaymentTermsFilterPage;
import pages.ProjectPaymentManager.ProjectPaymentManagerPage;
import pages.ProjectPaymentManager.ProjectProcessingOptionsPage;
import pages.RoyaltyProcessing.RoyaltyPaymentsPage;

@Listeners(com.listeners.MyListeners.class)
public class ProjectPaymentManagerTest extends BasePage{

	LoginPage objLogin;
	ProjectPaymentManagerPage objPaymentManager;
	ProjectProcessingOptionsPage objProjectProcessingOptions;
	CheckLogInformationPage objCheckLogInformation;
	PaymentTermsFilterPage objPaymentTermsFilter;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objPaymentManager = new ProjectPaymentManagerPage(driver);
		objProjectProcessingOptions = new ProjectProcessingOptionsPage(driver);
		objCheckLogInformation = new CheckLogInformationPage(driver);
		objPaymentTermsFilter = new PaymentTermsFilterPage(driver);
	}
	
	
	@Test(priority =1, enabled= true)
	public void AddCheckLogApprover_TC_01() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC01 : Work Queue- Add Check Log Approver");
		String testcaseName = "PaymentTermsFilter" + clientName;
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), Excel.PaymentTerms,
				testcaseName);
		if(!testcaseName.contains("ROW") & !environment.contains("ORION")) {
		objCheckLogInformation.addWorkQueueUser(map,testcaseName);
		}else {
			log("Check Log Approval not applicable for this client", Status.SKIP);
		}
		}else {
			log("Payment Manager Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	
	@Test(priority =2)
	public void ProjectPaymentManager_SearchInformation_TC_02() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC02 : Project- Payment Manager Search Information");
		String testcaseName = "ProjectPaymentManager" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), Excel.ProjectPaymentManager,
				testcaseName);
		objPaymentManager.ProjectPaymentManager(map, testcaseName);
		}else {
			log("Payment Manager Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =3, enabled= true)
	public void ProjectProcessingOptions_TC_03() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC03 : Project- Processing Options");
		String testcaseName = "ProjectProcessingOptions" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), Excel.ProjectProcessingOptions,testcaseName);
		objProjectProcessingOptions.ProjectProcessingOptions(map, testcaseName);
		
		}else {
			log("Payment Manager Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =4, enabled= true)
	public void CheckLogInformation_ApproveCheckLog_TC_04() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC04 :Project-Payment manager-check log information");
		String testcaseName = "PaymentTermsFilter" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), Excel.PaymentTerms,
				testcaseName);
		if(!testcaseName.contains("ROW") & !environment.contains("ORION") & !environment.contains("NEXTERA")) {
		objCheckLogInformation.CheckLogInformation(map,testcaseName);
		}else {
			log("Check Log Approval not applicable for this client", Status.SKIP);
		}
		}else {
			log("Payment Manager Test Case is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority =5, enabled= true)
	public void PaymentTermsFilter_TC_05() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC05 :Project-Payment manager-Payment terms filter");
		String testcaseName = "PaymentTermsFilter" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAYMENT_MANAGER_TEST_DATA), Excel.PaymentTerms,
				testcaseName);
		objPaymentTermsFilter.PaymentTermsFilter(map, testcaseName);
		}else {
			log("Payment Manager Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	
}
