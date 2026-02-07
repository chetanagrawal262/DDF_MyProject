package testsuit.ProjectPayTemplate;

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
import pages.ProjectPayTemplate.DocumentGenerationPage;
import pages.ProjectPayTemplate.PaymentCalculationsPage;
import pages.ProjectPayTemplate.PaymentDatesFieldValidationPage;
import pages.ProjectPayTemplate.PaymentDatesPage;
import pages.ProjectPayTemplate.PaymentTermFilterPage;
import pages.ProjectPayTemplate.PaymentTermsSummaryPage;
import pages.ProjectPayTemplate.ProjectAllowancesPage;
import pages.RoyaltyProcessing.RevenuePeriodsPage;

@Listeners(com.listeners.MyListeners.class)
public class PaymentTermsSummaryTest extends BasePage{
	
		LoginPage objLogin;
		ReadPropertyFile readPro = new ReadPropertyFile();
		PaymentTermsSummaryPage objPaymentTermsSummary;
		PaymentDatesPage objPaymentDates;
		PaymentDatesFieldValidationPage objPaymentDatesField;
		PaymentCalculationsPage objPaymentCalculations;
		DocumentGenerationPage objDocumentGeneration;
		RevenuePeriodsPage objRevenuePeriods;
		PaymentTermFilterPage objPaymentTermFilter;
		ProjectAllowancesPage objProjectAllowances;
		AdditionalPaymentTemplatePage objAdditionalPay;
		Map<String, String> map = new HashMap<String, String>();

		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objPaymentTermsSummary = new PaymentTermsSummaryPage(driver);
			objPaymentDates = new PaymentDatesPage(driver);
			objPaymentDatesField = new PaymentDatesFieldValidationPage(driver);
			objPaymentCalculations = new PaymentCalculationsPage(driver);
			objDocumentGeneration = new DocumentGenerationPage(driver);
			objRevenuePeriods = new RevenuePeriodsPage(driver);
			objPaymentTermFilter = new PaymentTermFilterPage(driver);
			objProjectAllowances = new ProjectAllowancesPage(driver);
			objAdditionalPay = new AdditionalPaymentTemplatePage(driver);
		}

		@Test(priority=1)
		public void ProjectPayTemplate_PaymentTermsSummary_TC_01() throws Exception {
			if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
			log("TC01 :Project Pay Template-Payment terms summary");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			if(environment.contains("CONNECTGEN")) {
			objLogin.loginWithSuperAdmin(map);
			}else {
				objLogin.login(map);
			}
			String testcaseName = "PaymentTermsSummary" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), Excel.PaymentTermsSummary,
					testcaseName);
			objPaymentTermsSummary.PaymentTermsSummary(map, testcaseName);
			}else {
				log("Project Pay Template Test Case is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=2, enabled=true, description="US-105586")
		public void ProjectPayTemplate_PaymentDatesFieldValidation_TC_02() throws Exception {
			log("TC02 :Project Pay Template-Payment dates Field Validation ");
			String testcaseName = "PaymentDates" + clientName;
			if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
				objPaymentDatesField.verifyPaymentDatesFields(testcaseName);
			}else {
				log("Payment Date Fields validation TC is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=3, enabled=true)
		public void ProjectPayTemplate_PaymentDates_TC_03() throws Exception {
			if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
			log("TC03 :Project Pay Template-Payment dates ");
			String testcaseName = "PaymentDates" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), Excel.PaymentDates,
					testcaseName);
			objPaymentDates.PaymentDates(map, testcaseName);
			}else {
				log("Project Pay Template Test Case is not applicable for this client", Status.SKIP);
			}
		}


		@Test(priority=4, enabled=true)
		public void ProjectPayTemplate_PaymentCalculations_TC_04() throws Exception {
			if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
			log("TC04: Project Pay Template-Payment calculations");
			String testcaseName = "PaymentCalculations" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), Excel.PaymentCalculations,
					testcaseName);
			objPaymentCalculations.PaymentCalculations(map, testcaseName);
			}else {
				log("Project Pay Template Test Case is not applicable for this client", Status.SKIP);
			}
		}
		
//		@Test(priority=5, enabled=true)
//		public void ProjectPayTemplate_DocumentGeneration_TC_05() throws Exception {
//			if(!environment.contains("CRIMSON") & !environment.contains("BAYWA") & !environment.contains("TRA") & !environment.contains("ORION")) {
//			log("TC05 :Project Pay Template-Document Generation ");
//			String testcaseName = "DocumentGeneration" + clientName;
//			log("Data picked : " + testcaseName);
//			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), Excel.DocumentGeneration,
//					testcaseName);
//			objDocumentGeneration.GenerateDocument(map, testcaseName);
//			objDocumentGeneration.PreviewDocument(map, testcaseName);
//			}else {
//				log("Project Pay Template Test Case is not applicable for this client", Status.SKIP);
//			}
//
//		}
		
       @Test(priority=6, enabled=true)
		public void ProjectPayTemplate_PaymentTermFilter_TC_06() throws Exception {
			if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
			log("TC06 :payment term filter");
			String testcaseName = "PaymentTermFilter" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), Excel.PaymentTermFilter,
					testcaseName);
			objPaymentTermFilter.PaymentTermFilter(map, testcaseName);
			}else {
				log("Project Pay Template Test Case is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=7, enabled=true)
		public void ProjectPayTemplate_Project_Allowances_TC_07() throws Exception {
			if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
			log("TC07 :Project Allowances");
			String testcaseName = "ProjectAllowances" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), Excel.ProjectAllowances,
					testcaseName);
			objProjectAllowances.ProjectAllowances(map, testcaseName);
			}else {
				log("Project Pay Template Test Case is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=8, enabled=true)
		public void Create_PowerFunctionTemplate_TC_08() throws Exception {
			if(environment.contains("NEXTERA")) {
			log("TC08 :Create Power Function Template for Effective Date Validation");
			String testcaseName = "PowerFunctionTemplateNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), Excel.CPITemplate,testcaseName);
			objAdditionalPay.createTemplate(map, testcaseName);
			}else {
				log("ThisTest Case is NEXTERA Specific and not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=9, enabled=true)
		public void Create_CPIPaymentTemplate_TC_09() throws Exception {
			if(environment.contains("NEXTERA")) {
			log("TC08 :Create CPI Template for Effective Date Validation");
			String testcaseName = "CPITemplateNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), Excel.CPITemplate,testcaseName);
			objAdditionalPay.createTemplate(map, testcaseName);
			}else {
				log("ThisTest Case is NEXTERA Specific and not applicable for this client", Status.SKIP);
			}
		}
		
}
