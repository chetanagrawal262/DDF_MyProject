package testsuit.GlobalTemplate;

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
import pages.GlobalTemplate.AdditionalPaymentTemplatePage;
import pages.GlobalTemplate.PaymentCalculationsPage;
import pages.GlobalTemplate.PaymentDatesPage;
import pages.GlobalTemplate.ProjectGlobalTemplatePage;
import pages.ProjectPayTemplate.PaymentDatesFieldValidationPage;

@Listeners(com.listeners.MyListeners.class)
public class ProjectGlobalTemplateTest extends BasePage{
	
		LoginPage objLogin;
		ReadPropertyFile readPro = new ReadPropertyFile();
		ProjectGlobalTemplatePage objProjectGlobalTemplate;
		AdditionalPaymentTemplatePage objAdditionalPay;
		Map<String, String> map = new HashMap<String, String>();
		PaymentDatesPage objPaymentDates;
		PaymentCalculationsPage objPaymentCalculations;
		PaymentDatesFieldValidationPage objPaymentDatesField;
		
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objProjectGlobalTemplate = new ProjectGlobalTemplatePage(driver);
			objPaymentDates = new PaymentDatesPage(driver);
			objPaymentCalculations = new PaymentCalculationsPage(driver);
            objAdditionalPay = new AdditionalPaymentTemplatePage(driver);
            objPaymentDatesField = new PaymentDatesFieldValidationPage(driver);
		}

		@Test(priority = 1)
		public void ProjectGlobalTemplate_TC_01() throws Exception {
			if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
			log("TC01 :Project - Global Template");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			if(environment.contains("CONNECTGEN")) {
				objLogin.loginWithSuperAdmin(map);
				}else {
					objLogin.login(map);
				}
			String testcaseName = "ProjectGlobalTemplate" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.GLOBAL_TEMPLATE_TEST_DATA), Excel.ProjectGlobalTemplate,
					testcaseName);
			objProjectGlobalTemplate.ProjectGlobalTemplate(map, testcaseName);
			}else {
				log("Global Template Test Case is not applicable for this client", Status.SKIP);
			}

		}
		
		@Test(priority=2, enabled=true, description="US-105586")
		public void GlobalTemplate_PaymentDatesFieldValidation_TC_02() throws Exception {
			log("TC02 :Global Template-Payment dates Field Validation ");
			String testcaseName = "PaymentDates" + clientName;
			if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
				objPaymentDatesField.verifyPaymentDatesFields(testcaseName);
			}else {
				log("Payment Date Fields validation TC is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority = 3)
		public void PaymentDates_TC_03() throws Exception {
			if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
			log("TC03 :Project Global Template-Payment dates");
			String testcaseName = "PaymentDates" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.GLOBAL_TEMPLATE_TEST_DATA), Excel.PaymentDates,
					testcaseName);
			objPaymentDates.PaymentDates(map, testcaseName);
			}else {
				log("Global Template Test Case is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority = 4)
		public void PaymentCalculations_TC_04() throws Exception {
			if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
			log("TC04: Project Global  Template-Payment calculations");
			String testcaseName = "PaymentCalculations" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.GLOBAL_TEMPLATE_TEST_DATA), Excel.PaymentCalculations,
					testcaseName);
			objPaymentCalculations.PaymentCalculations(map, testcaseName);
			}else {
				log("Global Template Test Case is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority = 5)
		public void QuarterEnd_AdditionalPaymentTemplate_TC_05() throws Exception {
			log("TC05: Quarter End Additional Payment Template");
			String testcaseName;
			if(environment.contains("NEXTERA")) {
				testcaseName = "AdditionalPaymentsNEXTERA";
			}else {
			testcaseName = "AdditionalPayments" + clientName;
			}
			if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.GLOBAL_TEMPLATE_TEST_DATA), Excel.AdditionalPaymentTemplate,
					testcaseName);
			objAdditionalPay.addPaymentTemplate(map, testcaseName);
			}else {
				log("Additional Payment Template Test Case is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority = 6)
		public void ConstructionPaymentTemplate_TC_06() throws Exception {
			if(environment.contains("NEXTERA")) {
				String	testcaseName = "ConstructionPaymentTemplateNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.GLOBAL_TEMPLATE_TEST_DATA), Excel.AdditionalPaymentTemplate,
					testcaseName);
			objAdditionalPay.createTemplate(map, testcaseName);
			}else {
				log("Test Case is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority = 7)
		public void OperationalPaymentTemplate_TC_07() throws Exception {
			if(environment.contains("NEXTERA")) {
				String	testcaseName = "OperationalPaymentTemplateNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.GLOBAL_TEMPLATE_TEST_DATA), Excel.AdditionalPaymentTemplate,
					testcaseName);
			objAdditionalPay.createTemplate(map, testcaseName);
			}else {
				log("Test Case is not applicable for this client", Status.SKIP);
			}
		}

}
