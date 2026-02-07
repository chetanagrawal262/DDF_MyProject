package testsuit.agreementManager;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
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
import pages.Project.AddProjectWorkflowPage;
import pages.ProjectPayTemplate.PaymentTermsSummaryPage;
import pages.agreementManager.AddNewInformationPage;
import pages.agreementManager.AddNewPayeeInfoPage;
import pages.agreementManager.AgreementInformationPage;
import pages.agreementManager.AgreementObligationsPage;
import pages.agreementManager.AssetInformationPage;
import pages.agreementManager.MilestoneDatePage;
import pages.agreementManager.PaymentInformationPage;
import pages.tools.MyDashboardPage;

@Listeners(com.listeners.MyListeners.class)
public class AgreementInformationTest extends BasePage {

	LoginPage objLogin;
	AddNewInformationPage objAddInfo;
	AddNewPayeeInfoPage objAddPayee;
	MilestoneDatePage objMilestoneDate;
	AgreementInformationPage objAgreement;
	AddProjectWorkflowPage projectWorkflow;
	CommonFunction commonFunction;
	MyDashboardPage dashboardPage;
	AgreementObligationsPage objObligation;
	AssetInformationPage objAssetInformationPage;
	PaymentInformationPage objPayment;
	PaymentTermsSummaryPage objPaymentTermsSummary;
	
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	public static String AGREEMENT_NUMBER; 
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddInfo = new AddNewInformationPage(driver);
		objAddPayee = new AddNewPayeeInfoPage(driver);
		objMilestoneDate = new MilestoneDatePage(driver);
		objAgreement = new AgreementInformationPage(driver);
		projectWorkflow = new AddProjectWorkflowPage(driver);
		commonFunction = new CommonFunction(driver);
		dashboardPage = new MyDashboardPage(driver);
		objObligation = new AgreementObligationsPage(driver);
		objPayment = new PaymentInformationPage(driver);
		objAssetInformationPage = new AssetInformationPage(driver);
		objPaymentTermsSummary = new PaymentTermsSummaryPage(driver);
	}

	@Test(priority = 1,enabled = true)
	public void AgreementManager_Add_Agreement_Information_TC_01() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC01 : Add a Agreement Information");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddAgreementInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AgreementInfo, testcaseName);
		AGREEMENT_NUMBER = objAddInfo.addAgreementInformation(map, testcaseName);
		}else {
			log("Agreement Manager Test Case is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 2,enabled = true)
	public void AgreementManager_Add_Payee_Information_TC_02() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC02 : Add a Payee Information");
		String testcaseName = "AddPayeeInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.PayeeInfo, testcaseName);
		objAddPayee.addPayeeInformation(map, AGREEMENT_NUMBER, testcaseName);
		}else {
			log("Agreement Manager Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 3,enabled = true)
	public void AgreementManager_Add_Agreement_Information_TC_03() throws Exception {
		log("TC03 : Add a Agreement Information");
		String testcaseName = "AddAgreementInformation" + clientName;
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA") & !environment.contains("STEELHEAD") & !environment.contains("NOVA") & !environment.contains("ORION") & !environment.contains("AVANGRID") & !environment.contains("SMUD") ) {
			objAddInfo.addAgreementInformation(environment);
		}else {
			log("Agreement Information Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 4,enabled = true)
	public void AgreementManager_Add_Milestone_Dates_TC_04() throws Exception {
		
		log("TC04 : Add a Milestone Date");
			String testcaseName = "AddKey" + clientName;
			log("Data picked : " + testcaseName);
			if(!testcaseName.contains("ROW") & !environment.contains("TRA") & !environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("NEXTERA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.MilestoneDate, testcaseName);
			log("navigating to Add Key Date");
			objMilestoneDate.addMilestoneDate(map,testcaseName);
		}else {
			log("Agreement Milestone Date Test Case is not applicable for this client", Status.SKIP);
		}
		
	}
	
	@Test(priority = 5,enabled = true)
	public void AgreementManager_Add_Agreement_Form_TC_05() throws Exception {
		if(!environment.contains("GRAYHAWKTCE") & !environment.contains("VERDANTERRA") & !environment.contains("CRIMSON") & !environment.contains("GRIDUNITED") & !environment.contains("MVEA") & !environment.contains("TRA")) {
		log("TC05 : Add a Agreement Form");
		
		String testcaseName = "AgreementForm" + clientName;
		log("Data picked : " + testcaseName);
		
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AgreementForm, testcaseName);
		
		projectWorkflow.addNewWorkflow(map, testcaseName, true);
	    if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA") & !environment.contains("CRIMSON")) {
		projectWorkflow.submitTheFormForReviewAgreement();
		projectWorkflow.closeApprovalForm();
		projectWorkflow.verifyStoredRecord( map.get(Excel.ApprovalType));
		if (!testcaseName.contains("Agreement")) {
		try {
			commonFunction.navigateToMyDashboard();
			log("STEP 25: Click on submit for review on the form", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: Not Click on submit for review on the form", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		try {
			dashboardPage.navigateToRequestedDocumentTab();
			log("STEP 26: Click on the requested documents tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: Not Click on the requested documents tab", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		Assert.assertTrue(dashboardPage.isJobCreated("Requested"), "Job is not created");
		log("STEP 27: The Job created is listed under the tab", Status.PASS);
	}
		}else {
			projectWorkflow.closeApprovalForm();
		}
		}else {
			log("Agreement Form Test Case is not applicable for this client", Status.SKIP);
		}
		}
	
	@Test(priority = 6,enabled = true)
	public void AgreementManager_Add_Agreement_Obligations_TC_06() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("MVEA") & !environment.contains("GRAYHAWKTCE") & !environment.contains("TRA") & !environment.contains("VERDANTERRA") & !environment.contains("GRIDUNITED") & !environment.contains("INTERSECTPOWER") & !environment.contains("ORION")) {
		log("TC06 : Add a Agreement Obligations");
		String testcaseName = "AddAgreementObligations" + clientName;
		log("Data picked : " + testcaseName);
		commonFunction.refreshThePage();	
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AgreementObligations, testcaseName);
		objObligation.addAgreementObligations(map, testcaseName);
		}else {
			log("Agreement Obligation Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 7,enabled = true)
	public void AgreementManager_Edit_Agreement_Obligations_TC_07() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("MVEA") & !environment.contains("GRAYHAWKTCE") & !environment.contains("TRA") & !environment.contains("VERDANTERRA") & !environment.contains("GRIDUNITED") & !environment.contains("INTERSECTPOWER") & !environment.contains("ORION")) {
		log("TC07 : Edit Agreement Obligations");
		String testcaseName = "EditAgreementObligations" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AgreementObligations, testcaseName);
		objObligation.editAgreementObligations(map, testcaseName);
		}else {
			log("Agreement Obligation Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 8,enabled = true)
	public void AgreementManager_Delete_Agreement_Obligations_TC_08() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("MVEA") & !environment.contains("GRAYHAWKTCE") & !environment.contains("TRA") & !environment.contains("VERDANTERRA") & !environment.contains("GRIDUNITED") & !environment.contains("INTERSECTPOWER") & !environment.contains("ORION")) {
		log("TC08 : Delete Agreement Obligations");
		objObligation.deleteAgreementObligations(environment);
	}else {
		log("Agreement Obligation Test Case is not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority = 9,enabled = true)
	public void AddAssetInformation_TC_09() throws Exception {
		log("TC09 : Add Asset Information");
		String testcaseName = "AddAssetInformation" + clientName;
		if(testcaseName.contains("ROW") & !environment.contains("CRIMSON") & !environment.contains("TRA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AssetInformation, testcaseName);
			objAssetInformationPage.addAssetInformation(map, testcaseName);
	}else {
		log("Asset Informatoin Test Case is not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority = 10,enabled = true)
	public void PaymentInformation_Add_Payment_Term_TC_10() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("VERDANTERRA")) {
		log("TC10 : Add Payment Term");
		String testcaseName = "AddPaymentInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.PaymentInfo, testcaseName);
		
		objPayment.addNewPaymentInformation(map, testcaseName);
		}else {
			log("Payment Information Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	//#78231
	@Test(priority = 11,enabled = true)
	public void GlobalTemplate_Payments_TC_11() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC11 : Generate Payment using Global Template");
		String testcaseName = "AddPaymentInformation" + clientName;
		log("Data picked : " + testcaseName);
		if (testcaseName.toLowerCase().contains("row")) {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.GLOBAL_TEMPLATE_TEST_DATA), Excel.PaymentInfo, testcaseName);
		objPayment.addNewPayment_GlobalTemplate(map, testcaseName);
		}else {
			log("Payment Information Test Case is not applicable for this client", Status.SKIP);
		}	
		if (testcaseName.toLowerCase().contains("row")) {
			objAddInfo.navigateToAgreementInformationROW();
		} else {
			objAddInfo.navigateToAgreementInformationALT();
		}
		if(!environment.contains("ORION")) {
		objAddInfo.duplicateTheAgreement(testcaseName);
		}
		}else {
			log("Payment Information Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 12,enabled = true)
	public void ProjectPayTemplate_TestCalculation_TC_12() throws Exception {
		log("TC12 : verify Test Calculations");
		String testcaseName = "AddPaymentInformation" + clientName;
		if(!environment.contains("VERDANTERRA") & !testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
		
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.PaymentInfo, testcaseName);
		objPayment.TestCalculations(map, testcaseName, AGREEMENT_NUMBER);
		}else {
			log("Payment Information Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	//#66527
	@Test(priority = 13,enabled = true)
	public void DeleteProjectPayTemplate_13() throws Exception {
		log("TC 13 : verify Delete Link of Payment Template");
		String testcaseName = "PaymentTermsSummary" + clientName;
		if(!environment.contains("VERDANTERRA") & !testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_PAY_TEMPLATE_TEST_DATA), Excel.PaymentTermsSummary, testcaseName);
		objPaymentTermsSummary.DeletePaymentTemplate(map, testcaseName);
		}else {
			log("Payment Information Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
}
