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
import pages.ParcelDetails.BulkAssignCustomFieldValdiationPage;
import pages.ParcelDetails.ConfigureParcelFormPage;
import pages.ParcelDetails.ContactDetails_AddNewContactPage;
import pages.ParcelDetails.Grantor_GranteePage;
import pages.ParcelDetails.Landowner_AddLandownerPage;
import pages.ParcelDetails.LegalDescription_AddLegalDescriptionRecordPage;
import pages.ParcelDetails.LegalDescription_DeleteRecordPage;
import pages.ParcelDetails.LegalDescription_EditLegalDescriptionRecordPage;
import pages.ParcelDetails.LinkedApprovalPage;
import pages.ParcelDetails.MilestoneDate_AddMilestoneDatePage;
import pages.ParcelDetails.ParcelInformation_AddNewParcelPage;
import pages.ParcelDetails.ParcelReorder_ParcelReorderPage;
import pages.ParcelDetails.ParcelSummary_AddParcelSummaryPage;
import pages.ParcelDetails.ParcelWorkflow_AddNotesPage;
import pages.ParcelDetails.ParcelWorkflow_AssociatedRecordsPage;
import pages.ParcelDetails.ParcelWorkflow_Edit_DeleteProjectNotesPage;
import pages.ParcelDetails.TitleOrderFormWorkflowPage;



@Listeners(com.listeners.MyListeners.class)

public class ParcelInformation_AddNewParcelTest extends BasePage {
	
	LoginPage objLogin;
	ParcelInformation_AddNewParcelPage objAddParcel;
	ParcelReorder_ParcelReorderPage objParcelReorder;
	ParcelSummary_AddParcelSummaryPage objParcelSummary;
	MilestoneDate_AddMilestoneDatePage objMilestoneDate;
	Landowner_AddLandownerPage objAddLandowner;
	ContactDetails_AddNewContactPage objAddContact;
	LegalDescription_AddLegalDescriptionRecordPage objAddLegalDescription;
	LegalDescription_EditLegalDescriptionRecordPage objEditLegalDescription;
	LegalDescription_DeleteRecordPage objDeleteLegalDescription;
	AddParcelWorkflowPage objAddParcelWorkflow;
	ParcelWorkflow_AddNotesPage objAddNotes;
	ParcelWorkflow_Edit_DeleteProjectNotesPage objEditNotes;
	LinkedApprovalPage objLinkApproval;
	ParcelWorkflow_AssociatedRecordsPage objAssociatedRecords;
	TitleOrderFormWorkflowPage TitleOrderFormWorkflow;
	ConfigureParcelFormPage objConfigureParcelFormPage;
	Grantor_GranteePage objGrantorGrantee;
	BulkAssignCustomFieldValdiationPage objBulkAssignCustomControl;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddParcel = new ParcelInformation_AddNewParcelPage(driver);
		objParcelSummary = new ParcelSummary_AddParcelSummaryPage(driver);
		objMilestoneDate = new MilestoneDate_AddMilestoneDatePage(driver);
		objAddLandowner = new Landowner_AddLandownerPage(driver);
		objAddContact = new ContactDetails_AddNewContactPage(driver);
		objAddLegalDescription = new LegalDescription_AddLegalDescriptionRecordPage(driver);
		objEditLegalDescription = new LegalDescription_EditLegalDescriptionRecordPage(driver);
		objDeleteLegalDescription = new LegalDescription_DeleteRecordPage(driver);
		objAddParcelWorkflow = new AddParcelWorkflowPage(driver);
		TitleOrderFormWorkflow = new TitleOrderFormWorkflowPage(driver);
		objAddNotes = new ParcelWorkflow_AddNotesPage(driver);
		objEditNotes = new ParcelWorkflow_Edit_DeleteProjectNotesPage(driver);
		objLinkApproval = new LinkedApprovalPage(driver);
		objAssociatedRecords = new ParcelWorkflow_AssociatedRecordsPage(driver);
		objParcelReorder = new ParcelReorder_ParcelReorderPage(driver);
        objConfigureParcelFormPage = new ConfigureParcelFormPage(driver);
        objBulkAssignCustomControl = new BulkAssignCustomFieldValdiationPage(driver);
        objGrantorGrantee = new Grantor_GranteePage(driver);
	}

	@Test(priority = 1, enabled=true)
	public void add_Parcel_ParcelInformation_TC_01() throws Exception {
		if(!environment.contains("VALARD")) {
		log("TC01 : Add Parcel");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddParcel" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcel,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
		}else {
			log("Not applicable for valard clients", Status.SKIP);
		}
	}
	
   @Test(priority = 2, enabled = true)
	public void ParcelSummary_AddParcelSummary_TC_02() throws Exception {
		if(!environment.contains("VALARD") & !environment.contains("NOVA")) {
		log("TC02 : Parcel Summary");
		String testcaseName = "AddParcelSummary" + clientName;
		log("Data picked : " + testcaseName);
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
		objParcelSummary.AddParcelSummary(testcaseName);
		}
		}else {
			log("Not applicable for valard clients", Status.SKIP);
		}
	}

	@Test(priority = 3, enabled = true)
	public void MilestoneDate_AddMilestoneDate_TC_03() throws Exception {
		if(!environment.contains("STEELHEAD") & !environment.contains("ORSTED")
				& !environment.contains("WSBALT") & !environment.contains("CONNECTGEN")
				& !environment.contains("RAMACO")& !environment.contains("AVANTUS") & !environment.contains("VALARD")
				& !environment.contains("GRAYHAWKALT") & !environment.contains("TREATYOAK")
				& !environment.contains("NOVA") & !environment.contains("ORION") & !environment.contains("BAYWA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC03 : Add a Milestone Dates");
		String testcaseName = "AddMilestoneDate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.MilestoneDate,testcaseName);
		objMilestoneDate.AddMilestoneDate(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 4, enabled = true)
	public void Configure_MilestoneDate_TC_04() throws Exception {
		if(!environment.contains("STEELHEAD") & !environment.contains("ORSTED")
				& !environment.contains("WSBALT") & !environment.contains("CONNECTGEN")
				& !environment.contains("RAMACO")& !environment.contains("AVANTUS") & !environment.contains("VALARD")
				& !environment.contains("GRAYHAWKALT") & !environment.contains("TREATYOAK")
				& !environment.contains("NOVA") & !environment.contains("ORION") & !environment.contains("BAYWA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC 04 : Configure Milestone Dates");
		String testcaseName = "AddMilestoneDate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.MilestoneDate,testcaseName);
		objMilestoneDate.configureMilestoneDate(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 5, enabled = true)
	public void Grantor_Grantee_TC_05() throws Exception {
		if(environment.contains("WOLFMIDSTREAM")) {
		log("TC 05 : Add Grantor/Grantee");
		String testcaseName = "AddGrantor" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.Grantor,testcaseName);
		objGrantorGrantee.AddRecord(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	
	@Test(priority = 6, enabled=true)
	public void Landowner_AddLandowner_TC_06() throws Exception {
		if(!environment.contains("VALARD") & !environment.contains("ORION")) {
		log("TC06 : Add Landowner");
		String testcaseName = "AddLandowner" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.Landowner,testcaseName);
		objAddLandowner.AddLandowner(map, testcaseName);
		}else {
			log("Not applicable for valard clients", Status.SKIP);
		}
	}

	@Test(priority = 7, enabled=true)
	public void ContactDetails_AddNewContact_TC_07() throws Exception {
		if(!environment.contains("VALARD") & !environment.contains("ORION")) {
		log("TC07: Add New Contact");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddnewContact" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.Contact,testcaseName);
		objAddContact.AddnewContact(map, testcaseName);
		}else {
			log("Not applicable for valard clients", Status.SKIP);
		}
	}

	@Test(priority = 8, enabled=true)
	public void LegalDescription_AddLegalDescriptionRecord_TC_08() throws Exception {
		if(!environment.contains("ORION") & !environment.contains("VALARD") & !environment.contains("ATWELL")) {
		log("TC08 : Add a Legal Description Record");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddLegalDescriptionRecord" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.LegalDescription,testcaseName);
		objAddLegalDescription.AddLegalDescriptionRecord(map, testcaseName);
		}else {
			log("Not Applicable for this client ", Status.SKIP);
		}
	}

	@Test(priority = 9, enabled=true)
	public void LegalDescription_EditLegalDescriptionRecord_TC_09() throws Exception {
		if(!environment.contains("VALARD") & !environment.contains("ORION")) {
		log("TC09 : Edit Legal Description record ");
		String testcaseName = "EditLegalDescriptionRecord" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.EditLegalDescription,testcaseName);
		objEditLegalDescription.EditLegalDescriptionRecord(map, testcaseName);
		}else {
			log("Not Applicable for this client ", Status.SKIP);
		}
	}

	@Test(priority = 10, enabled = true)
	public void LegalDescription_DeleteRecord_TC_10() throws Exception {
		if(!environment.contains("VALARD") & !environment.contains("ORION")) {
		log("TC10 : Delete Legal Description record ");
		String testcaseName = "DeleteLegalDescriptionRecord" + clientName;
		log("Data picked : " + testcaseName);
		objDeleteLegalDescription.LegalDescription_DeleteRecord(testcaseName);
		}else {
			log("Not Applicable for this client ", Status.SKIP);
		}
	}
	
	@Test(priority = 11, enabled=true)
	public void AddParcelWorkflow_TC_11() throws Exception {
		if(!environment.contains("WOLFMIDSTREAM") & !environment.contains("ORSTED") & !environment.contains("WSBALT")
				& !environment.contains("CONNECTGEN") & !environment.contains("RAMACO")
				& !environment.contains("AVANTUS") & !environment.contains("TREATYOAK")
				& !environment.contains("VALARD") & !environment.contains("GRAYHAWKALT") & !environment.contains("ORION") & !environment.contains("NOVA")) {
		log("TC 11 : Add a Parcel workflow ");
		String testcaseName = "AddParcelWorkflow" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcelWorkflow,testcaseName);
        objAddParcelWorkflow.AddParcelWorkflow(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 12, enabled=true)
	public void CancelParcelWorkflowScenario_TC_12() throws Exception {
		if(!environment.contains("WOLFMIDSTREAM") & !environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("CONNECTGEN") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("TREATYOAK") & !environment.contains("VALARD") & !environment.contains("GRAYHAWKALT") & !environment.contains("ORION") & !environment.contains("NOVA")) {
		log("TC 12 : Cancel Parcel Workflow Scenario ");
		String testcaseName = "CancelWorkflow" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AssociatedRecords,testcaseName);
		objAssociatedRecords.cancelParcelWorkflow(map, testcaseName);
	}else {
		log("This TC is not applicable for this client", Status.SKIP);
	}
	}

	
	@Test(priority=13, enabled=true)
	public void Parcel_Workflow_Title_Order_Form_TC_13() throws Exception {
		if(!environment.contains("WOLFMIDSTREAM") & !environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("CONNECTGEN") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("NOVA")) {
		log("TC 13 : Add a Pacel workflow - Title Order Form ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "TitleOrderForm" + clientName;
		if(testcaseName.contains("ALT") || testcaseName.contains("ATWELL")) {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcelWorkflow,
				testcaseName);
		TitleOrderFormWorkflow.addTitleOrderFormWorkflow(map, testcaseName);
		TitleOrderFormWorkflow.closeApprovalForm();
		TitleOrderFormWorkflow.verifyApprovedWorkflow(map.get(Excel.ApprovalType));
		}else {
			log("Title Order Form workflow is not applicable for ROW and DOT Vertical", Status.SKIP);
		}
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority=14, enabled=true)
	public void Parcel_Form_LTEXT_Validation_TC_14() throws Exception {
		if(!environment.contains("WOLFMIDSTREAM") & !environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("CONNECTGEN") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("NOVA")) {
		log("TC 13 : LTEXT Field Validation and Configure Additional Notification link Validation- Parcel Form");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "SummaryConfig" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.ParcelFormConfiguration,
				testcaseName);
		objConfigureParcelFormPage.parcelWorkflowConfiguration(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	
}
