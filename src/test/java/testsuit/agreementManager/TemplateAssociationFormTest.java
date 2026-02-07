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
import pages.ProjectSetup.AddNewUserAccountPage;
import pages.ProjectSetup.AddProjectAssignmentPage;
import pages.RoyaltyPayment.AddNewPayeeInfoPage;
import pages.agreementManager.AddNewAgreementPageNextEra;
import pages.agreementManager.TemplateAssociationFormPage;

@Listeners(com.listeners.MyListeners.class)
public class TemplateAssociationFormTest extends BasePage {

	LoginPage objLogin;
	CommonFunction commonFunction;
	AddNewUserAccountPage objAddUser;
	AddProjectAssignmentPage objAddAssignment;
	TemplateAssociationFormPage objTemplateAssociationForm;
	AddNewAgreementPageNextEra objAddNewAgreementNextEra;
	AddNewPayeeInfoPage objAddPayee;
	
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddAssignment = new AddProjectAssignmentPage(driver);
		commonFunction = new CommonFunction(driver);
		objAddUser = new AddNewUserAccountPage(driver);
		objTemplateAssociationForm = new TemplateAssociationFormPage(driver);
		objAddNewAgreementNextEra = new AddNewAgreementPageNextEra(driver);
		objAddPayee = new AddNewPayeeInfoPage(driver);
	}

	@Test(priority = 1, enabled=true)
	public void Check_User_Role_Payment_Analyst_TC_01() throws Exception {
		if (environment.contains("NEXTERA")) {
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "UserRolePaymentAnalystNEXTERA";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.Assignment,
				testcaseName);
		objAddUser.updateDefaultProjectRole(map, testcaseName);
		}else {
			log("This TC is NEXTERA specific and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority=2, enabled=true)
	public void Check_ProjectAssignment_PaymentAnalystPeerReview_TC_02() throws Exception {
		if(environment.contains("NEXTERA")) {
		String testcaseName = "ProjectAssignmentNEXTERA";
		commonFunction.navigateToProjectDeails();
		commonFunction.projectSelection();
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.Assignment,testcaseName);
		objAddAssignment.addProjectAssignment(map, testcaseName);
		}else {
			log("This TC is NEXTERA specific and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority = 3, enabled = true)
	public void Add_Agreement_TC_03() throws Exception {
		if (environment.contains("NEXTERA")) {
			String testcaseName = "AddAgreementInformationNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.AgreementInfo, testcaseName);
			objAddNewAgreementNextEra.verifyAgreementPage(map, testcaseName);
	}else {
		log("This Test Case is NextEra specific and not applicable for other clients", Status.SKIP);
	}
	}
	
	@Test(priority = 4, enabled = true)
	public void Add_AgreementTerm_TC_04() throws Exception {
		if (environment.contains("NEXTERA")) {
			String testcaseName = "AddAgreementInformationNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.AgreementInfo, testcaseName);
			objAddNewAgreementNextEra.AddAgreementTerm(map, testcaseName);
	}else {
		log("This Test Case is NextEra specific and not applicable for other clients", Status.SKIP);
	}
	}
	
	
	@Test(priority = 5, enabled = true)
	public void Add_PayeeInformation_TC_05() throws Exception {
		if (environment.contains("NEXTERA")) {
			String testcaseName = "PayeeInformationNEXTERA";
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.PayeeInfo, testcaseName);
			objAddPayee.addPayeeInformation(map, testcaseName);
	}else {
		log("This Test Case is NextEra specific and not applicable for other clients", Status.SKIP);
	}
	}
	
	@Test(priority=6, enabled=true)
	public void Payment_Template_Association_Form_TC_06() throws Exception {
		if(environment.contains("NEXTERA")) {
	   String testcaseName = "TemplateAssociationFormNEXTERA";
	   map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.AgreementForm,testcaseName);
	   objTemplateAssociationForm.CreateTemplateAssociationForm(map, testcaseName);
		}else {
			log("This TC is NEXTERA specific and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority=7, enabled=true)
	public void VerfiyGeneratedPayment_TC_07() throws Exception {
		if(environment.contains("NEXTERA")) {
	   String testcaseName = "GeneratedPaymentNEXTERA";
	   map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), Excel.PaymentInfo,testcaseName);
	   objTemplateAssociationForm.verifyPaymentInformation(map, testcaseName);
		}else {
			log("This TC is NEXTERA specific and not applicable for other clients", Status.SKIP);
		}
	}
	
	
	
}
