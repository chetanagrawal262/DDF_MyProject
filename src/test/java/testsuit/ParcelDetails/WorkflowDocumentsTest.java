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

public class WorkflowDocumentsTest extends BasePage {
	
	LoginPage objLogin;
	
	BulkAssignCustomFieldValdiationPage objBulkAssignCustomControl;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
        objBulkAssignCustomControl = new BulkAssignCustomFieldValdiationPage(driver);
	}
	
	@Test(priority=1, enabled=true)
	public void DOCDRAFTFINAL_TRUE_TC_01() throws Exception {
		if(!environment.contains("PRIMERGY") & !environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("CONNECTGEN") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("NOVA")) {
		log("TC1 : Doc Draft Final key setting set to 'True'  ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "CustomField" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.BulkAssignCustomFields,
				testcaseName);
		objBulkAssignCustomControl.SetDocDraftFinalSetting(map, testcaseName, "True");
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority= 2, enabled=true)
	public void Parcel_Form_MultiDoc_Validation_TC_02() throws Exception {
		if(!environment.contains("PRIMERGY") & !environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("CONNECTGEN") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("NOVA")) {
		log("TC 02 : Multi Doc Custom Field Validation - Parcel Form");
		String testcaseName = "CustomField" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.BulkAssignCustomFields,
				testcaseName);
		objBulkAssignCustomControl.parcelWorkflowConfiguration(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority= 3, enabled=true)
	public void DOCDRAFTFINAL_FALSE_TC_03() throws Exception {
		if(!environment.contains("PRIMERGY") & !environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("CONNECTGEN") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("NOVA")) {
		log("TC 3 : Doc Draft Final key setting set to 'True'  ");
		String testcaseName = "CustomField" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.BulkAssignCustomFields,
				testcaseName);
		objBulkAssignCustomControl.SetDocDraftFinalSetting(map, testcaseName, "False");
		objBulkAssignCustomControl.verifyDraftFinalDD(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority= 4, enabled=true)
	public void Parcel_Form_BulkAssignCustomField_Validation_TC_04() throws Exception {
		if(!environment.contains("PRIMERGY") & !environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("CONNECTGEN") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("NOVA")) {
		log("TC 04 : Bulk Assign Custom Field- Parcel Form");
		String testcaseName = "CustomField" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.BulkAssignCustomFields,
				testcaseName);
		objBulkAssignCustomControl.bulkAssignCustomFieldPermission(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
}
