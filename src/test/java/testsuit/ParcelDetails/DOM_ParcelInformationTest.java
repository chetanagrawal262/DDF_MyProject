package testsuit.ParcelDetails;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import java.util.HashMap;
import java.util.Map;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.ParcelDetails.AcquisitionTypePage;
import pages.ParcelDetails.Grantor_GranteePage;
import pages.ParcelDetails.Landowner_AddLandownerPage;
import pages.ParcelDetails.LegalDescription_AddLegalDescriptionRecordPage;
import pages.ParcelDetails.LegalDescription_DeleteRecordPage;
import pages.ParcelDetails.LegalDescription_EditLegalDescriptionRecordPage;
import pages.ParcelDetails.MilestoneDate_AddMilestoneDatePage;
import pages.ParcelDetails.ParcelInformation_AddNewParcelPage;
import pages.ParcelDetails.ParcelStructurePage;



@Listeners(com.listeners.MyListeners.class)

public class DOM_ParcelInformationTest extends BasePage {
	
	LoginPage objLogin;
	ParcelInformation_AddNewParcelPage objAddParcel;
	AcquisitionTypePage objAcquisitionType;
	MilestoneDate_AddMilestoneDatePage objMilestoneDate;
	Landowner_AddLandownerPage objAddLandowner;
	LegalDescription_AddLegalDescriptionRecordPage objAddLegalDescription;
	LegalDescription_EditLegalDescriptionRecordPage objEditLegalDescription;
	LegalDescription_DeleteRecordPage objDeleteLegalDescription;
	Grantor_GranteePage objGrantorGrantee;
	ParcelStructurePage objParcelStructure;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddParcel = new ParcelInformation_AddNewParcelPage(driver);
		objAcquisitionType = new AcquisitionTypePage(driver);
		objMilestoneDate = new MilestoneDate_AddMilestoneDatePage(driver);
		objAddLandowner = new Landowner_AddLandownerPage(driver);
		objAddLegalDescription = new LegalDescription_AddLegalDescriptionRecordPage(driver);
		objEditLegalDescription = new LegalDescription_EditLegalDescriptionRecordPage(driver);
		objDeleteLegalDescription = new LegalDescription_DeleteRecordPage(driver);
		objGrantorGrantee = new Grantor_GranteePage(driver);
		objParcelStructure = new ParcelStructurePage(driver);
	}

	@Test(priority = 1, enabled=true)
	public void add_Parcel_ParcelInformation_TC_01() throws Exception {
		log("TC01 : Add Parcel");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddParcel" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcel,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
	}
	
	@Test(priority = 2, enabled=true)
	public void add_AcquisitionType_TC_02() throws Exception {
		log("TC02 : Add Acquisition Type");
		String testcaseName = "AddAcquisitionType" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AcquisitionType,testcaseName);
		objAcquisitionType.AddAcquisitionTypeRecord(map, testcaseName);
	}
	
	@Test(priority = 3, enabled=true)
	public void edit_AcquisitionType_TC_03() throws Exception {
		log("TC03 : Edit Acquisition Type");
		String testcaseName = "AddAcquisitionType" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AcquisitionType,testcaseName);
		objAcquisitionType.editAcquisitionTypeRecord(map, testcaseName);
	}
	
	@Test(priority = 4, enabled=true)
	public void AcquisitionType_ViewHistory_TC_04() throws Exception {
		log("TC04 : Acquisition Type- View History");
		String testcaseName = "AddAcquisitionType" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AcquisitionType,testcaseName);
		objAcquisitionType.viewHistory(map, testcaseName);
	}
	
   @Test(priority = 5, enabled = true)
	public void UpdateMilestoneDate_TC_05() throws Exception {
		log("TC05 : Update a Milestone Dates");
		String testcaseName = "AddMilestoneDate" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.MilestoneDate,testcaseName);
		objMilestoneDate.AddMilestoneDate(map, testcaseName);
	}

	@Test(priority = 6, enabled = true)
	public void Configure_MilestoneDate_TC_06() throws Exception {
		log("TC 06 : Configure Milestone Dates");
		String testcaseName = "AddMilestoneDate" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.MilestoneDate,testcaseName);
		objMilestoneDate.configureMilestoneDate(map, testcaseName);
	}
	
	@Test(priority = 7, enabled = true)
	public void Add_Original_Grantor_Record_TC_07() throws Exception {
		log("TC 07 : Add Original Grantor Record");
		String testcaseName = "AddGrantor" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.Grantor,testcaseName);
		objGrantorGrantee.AddRecord(map, testcaseName);
	}
	
	
	@Test(priority = 8, enabled=true)
	public void Landowner_AddLandowner_TC_08() throws Exception {
		log("TC08 : Add Landowner");
		String testcaseName = "AddLandowner" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.Landowner,testcaseName);
		objAddLandowner.AddLandowner(map, testcaseName);
	}

	@Test(priority = 9, enabled=true)
	public void LegalDescription_AddLegalDescriptionRecord_TC_09() throws Exception {
		log("TC09 : Add a Legal Description Record");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddLegalDescriptionRecord" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.LegalDescription,testcaseName);
		objAddLegalDescription.AddLegalDescriptionRecord(map, testcaseName);
	}

	@Test(priority = 10, enabled=true)
	public void LegalDescription_EditLegalDescriptionRecord_TC_10() throws Exception {
		log("TC 10 : Edit Legal Description record ");
		String testcaseName = "EditLegalDescriptionRecord" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.EditLegalDescription,testcaseName);
		objEditLegalDescription.EditLegalDescriptionRecord(map, testcaseName);
	}

	@Test(priority = 11, enabled = true)
	public void LegalDescription_DeleteRecord_TC_11() throws Exception {
		log("TC11 : Delete Legal Description record ");
		String testcaseName = "DeleteLegalDescriptionRecord" + clientName;
		objDeleteLegalDescription.LegalDescription_DeleteRecord(testcaseName);
	}
	
	@Test(priority = 12, enabled=true)
	public void AddParcelStructureRecord_TC_12() throws Exception {
		log("TC 12 : Add Parcel Structure Record");
		String testcaseName = "AddParcelStructureRecord" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.ParcelStructure,testcaseName);
		objParcelStructure.AddParcelStructureRecord(map, testcaseName);
	}
	
	@Test(priority = 13, enabled=true)
	public void DeleteParcelStructureRecord_TC_13() throws Exception {
		log("TC 13 : Delete Parcel Structure Record");
		String testcaseName = "DeleteParcelStructureRecord" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.ParcelStructure,testcaseName);
		objParcelStructure.deleteParcelStructureRecord(testcaseName);
	}
	
}
