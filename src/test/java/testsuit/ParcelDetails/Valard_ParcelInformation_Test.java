package testsuit.ParcelDetails;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.ParcelDetails.AddParcelWorkflowPage;
import pages.ParcelDetails.ConfigureParcelFormPage;
import pages.ParcelDetails.ContactDetails_AddNewContactPage;
import pages.ParcelDetails.CrownLandClassCustomDropDownValidationPage;
import pages.ParcelDetails.Landowner_AddLandownerPage;
import pages.ParcelDetails.MilestoneDate_AddMilestoneDatePage;
import pages.ParcelDetails.Valard_ParcelInformation_Page;
import pages.ParcelDetails.Valard_WarningMessages_Page;
import pages.ParcelDetails.ParcelSummary_AddParcelSummaryPage;
import pages.ParcelDetails.ParcelWorkflow_AddNotesPage;
import pages.ParcelDetails.ParcelWorkflow_AssociatedRecordsPage;
import pages.ParcelDetails.ParcelWorkflow_Edit_DeleteProjectNotesPage;
import pages.ParcelDetails.PermitClassCustomDropDownValidationPage;
import pages.ParcelDetails.PrivateClassCustomDropDownValidationPage;
import pages.ParcelDetails.ThirdPartyClassCustomDropDownValidationPage;
import pages.ParcelDetails.Valard_ParcelAssociationPage;



@Listeners(com.listeners.MyListeners.class)

public class Valard_ParcelInformation_Test extends BasePage {
	
	LoginPage objLogin;
	Valard_ParcelInformation_Page objAddParcel;
	PrivateClassCustomDropDownValidationPage objPrivateClassDDValidation;
	PermitClassCustomDropDownValidationPage objPermitClassDDValidation;
	ThirdPartyClassCustomDropDownValidationPage objThirdPartyClassDDValidation;
	CrownLandClassCustomDropDownValidationPage objCrownLandClassDDValidation;
	Valard_ParcelAssociationPage objParcelAssociationPage;
	ParcelSummary_AddParcelSummaryPage objParcelSummary;
	MilestoneDate_AddMilestoneDatePage objMilestoneDate;
	Landowner_AddLandownerPage objAddLandowner;
	ContactDetails_AddNewContactPage objAddContact;
	AddParcelWorkflowPage objAddParcelWorkflow;
	ParcelWorkflow_AddNotesPage objAddNotes;
	ParcelWorkflow_Edit_DeleteProjectNotesPage objEditNotes;
	ParcelWorkflow_AssociatedRecordsPage objAssociatedRecords;
	ConfigureParcelFormPage objConfigureParcelFormPage;
	Valard_WarningMessages_Page objValard_WarningMessages_Page;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddParcel = new Valard_ParcelInformation_Page(driver);
		objPrivateClassDDValidation = new PrivateClassCustomDropDownValidationPage(driver);
		objPermitClassDDValidation = new PermitClassCustomDropDownValidationPage(driver);
		objThirdPartyClassDDValidation = new ThirdPartyClassCustomDropDownValidationPage(driver);
		objCrownLandClassDDValidation = new CrownLandClassCustomDropDownValidationPage(driver);
		objParcelAssociationPage = new Valard_ParcelAssociationPage(driver);
		objParcelSummary = new ParcelSummary_AddParcelSummaryPage(driver);
		objMilestoneDate = new MilestoneDate_AddMilestoneDatePage(driver);
		objAddLandowner = new Landowner_AddLandownerPage(driver);
		objAddContact = new ContactDetails_AddNewContactPage(driver);
		objAddParcelWorkflow = new AddParcelWorkflowPage(driver);
        objAddNotes = new ParcelWorkflow_AddNotesPage(driver);
		objEditNotes = new ParcelWorkflow_Edit_DeleteProjectNotesPage(driver);
		objAssociatedRecords = new ParcelWorkflow_AssociatedRecordsPage(driver);
		objConfigureParcelFormPage = new ConfigureParcelFormPage(driver);
		objValard_WarningMessages_Page = new Valard_WarningMessages_Page(driver);		
	}

	@Test(priority = 1, enabled=true)
	public void addClass_Private_TC_01() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC01 : Add Private Class ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddPrivateParcelVALARD";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcelValard,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
		objAddParcel.verifyCustomFields(map, testcaseName);
		}else {
			log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority = 2, enabled=true)
	public void addClass_Permit_TC_02() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC02 : Add Permit Class ");
		String testcaseName = "AddPermitParcelVALARD";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcelValard,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
		objAddParcel.verifyCustomFields(map, testcaseName);
		}else {
			log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority = 3, enabled=true)
	public void addClass_ThirdParty_TC_03() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC03 : Add Third Party Class ");
		String testcaseName = "AddThirdPartyParcelVALARD";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcelValard,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
		objAddParcel.verifyCustomFields(map, testcaseName);
		}else {
			log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority = 4, enabled=true)
	public void addClass_CrownLand_TC_04() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC04 : Add Crown Land Class ");
		String testcaseName = "AddCrownLandParcelVALARD";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcelValard,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
		objAddParcel.verifyCustomFields(map, testcaseName);
	}else {
		log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
	}
	}
	
	@Test(priority = 5, enabled=true)
	public void Parcel_Association_TC_05() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC05 : Parcel Association with same or different parcels ");
		String testcaseName = "AssociateParcelsVALARD";
		objParcelAssociationPage.associateParcels(testcaseName);
		}else {
			log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority = 6, enabled=true)
	public void Verify_Jurusdiction_ApplicationType_AgreementTypeDD_OfPrivateClass_TC_06() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC06 : Verify Jurusdiction, Application/Request Type and Agreement Type DD values of Private Class ");
		String testcaseName = "DDValidationVALARD";
		objPrivateClassDDValidation.verifyCustomDDValues(testcaseName);
	}else {
		log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
	}
	}
	
	@Test(priority = 7, enabled=true)
	public void Verify_Jurusdiction_ApplicationType_AgreementTypeDD_OfPermitClass_TC_07() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC07 : Verify Jurusdiction, Application/Request Type and Agreement Type DD values of Permit Class ");
		String testcaseName = "DDValidationVALARD";
		objPermitClassDDValidation.verifyCustomDDValues(testcaseName);
	}else {
		log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
	}
	}
	
	@Test(priority = 8, enabled=true)
	public void Verify_Jurusdiction_ApplicationType_AgreementTypeDD_OfThirdPartyClass_TC_08() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC08 : Verify Jurusdiction, Application/Request Type and Agreement Type DD values of Third Party Class ");
		String testcaseName = "DDValidationVALARD";
		objThirdPartyClassDDValidation.verifyCustomDDValues(testcaseName);
		}else {
			log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority = 9, enabled=true)
	public void Verify_Jurusdiction_ApplicationType_AgreementTypeDD_OfCrownLandClass_TC_09() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC09 : Verify Jurusdiction, Application/Request Type and Agreement Type DD values of Crown Land Class ");
		String testcaseName = "DDValidationVALARD";
		objCrownLandClassDDValidation.verifyCustomDDValues(testcaseName);
		}else {
			log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
		}
		
	}
	
	@Test(priority = 10, enabled=true)
	public void MilestoneDate_AddMilestoneDate_TC_10() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC10 : Add a Milestone Dates");
		String testcaseName = "AddMilestoneDate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.MilestoneDate,testcaseName);
		objMilestoneDate.AddMilestoneDate(map, testcaseName);
	}else {
		log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
	}
	}
	
	@Test(priority=11, enabled=true)
	public void Parcel_Form_LTEXT_Validation_TC_11() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC11 : LTEXT Field Validation - Parcel Form");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "SummaryConfig" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.ParcelFormConfiguration,
				testcaseName);
		objConfigureParcelFormPage.parcelWorkflowConfiguration(map, testcaseName);
		}else {
			log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
		}
	}
	
	@Test(priority=12, enabled=true)
	public void WarningMessages_Validation_TC_12() throws Exception {
		if(environment.contains("VALARD")) {
		log("TC12 : Warning Messages Validation of Save Unsaved work");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "WarningMessage" + clientName;
		objValard_WarningMessages_Page.verifyMessages(testcaseName);
	}else {
		log("This is Valard Specific Scenario and not applicable for other clients", Status.SKIP);
	}
	}

}
