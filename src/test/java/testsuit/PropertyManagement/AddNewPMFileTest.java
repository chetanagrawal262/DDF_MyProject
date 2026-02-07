package testsuit.PropertyManagement;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;

import page.Common.LoginPage;
import pages.PropertyManagement.AddKeyDatePage;
import pages.PropertyManagement.AddParticipatingStakeholdersPage;
import pages.PropertyManagement.AgreementsPanelPage;
import pages.PropertyManagement.FileInformationPage;
import pages.PropertyManagement.StakeholdersPage;


@Listeners(com.listeners.MyListeners.class)
public class AddNewPMFileTest extends BasePage{

	LoginPage objLogin;
	FileInformationPage ObjFileInformationPage;
	AddKeyDatePage ObjAddKeyDatePage;
	AddParticipatingStakeholdersPage ObjParticipatingStakeholdersPage;
	AgreementsPanelPage ObjAgreementsPanelPage;
	StakeholdersPage ObjStakeholdersPage; 
	
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	String testcaseName;
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		ObjFileInformationPage = new FileInformationPage(driver);
		ObjAddKeyDatePage = new AddKeyDatePage(driver); 
		ObjAgreementsPanelPage = new AgreementsPanelPage(driver);
		ObjParticipatingStakeholdersPage = new AddParticipatingStakeholdersPage(driver);
		ObjStakeholdersPage = new StakeholdersPage(driver);
		
	}
	
	@Test(priority = 1, enabled = true)
	public void Add_PMFile_TC_01() throws Exception {
		log("TC01 : Add Property Management file");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddPMFile" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTYMANAGEMENT_TEST_DATA), Excel.PMFileSummary,testcaseName);
	    ObjFileInformationPage.AddPMFile(map, testcaseName);
	}
		
		@Test(priority = 2, enabled = true)
		public void Edit_KeyDates_TC_02() throws Exception {
			log("TC02 : Edit Key Dates");
			String testcaseName = "EditKeyDates" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTYMANAGEMENT_TEST_DATA), Excel.EditKeyDates,testcaseName);
			ObjAddKeyDatePage.KeyDates(map, testcaseName);
		}
		
		
		@Test(priority = 3, enabled = true)
		public void Add_Participating_Stakeholders_TC_03() throws Exception {
			log("TC03 : Add Participating stakeholders");
			String testcaseName = "AddParticipatingStakeholders" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTYMANAGEMENT_TEST_DATA), Excel.AddParticipatingStakeholders,testcaseName);
			ObjParticipatingStakeholdersPage.AddParticipatingStakeholders(map, testcaseName);
		}	
		
		@Test(priority = 4, enabled = true)
		public void Delete_Participating_Stakeholders_TC_04() throws Exception {
			log("TC04 : Add Participating stakeholders");
			ObjParticipatingStakeholdersPage.DeleteParticipatingStakeholders();
		}
		
		@Test(priority = 5, enabled = true)
		public void Add_Recording_Information_TC_05() throws Exception {
			log("TC05 : Add Recording information");
			String testcaseName = "AddRecordingInfo" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTYMANAGEMENT_TEST_DATA), Excel.AgreementsPanel,testcaseName);
			ObjAgreementsPanelPage.AddNewRecordOnAgreementsPanel(map, testcaseName);
			
		}	
		@Test(priority = 6, enabled = true)
		public void View_Edit_Document_Link_TC_06() throws Exception {
			log("TC06 : View Edit Document");
			String testcaseName = "ViewEditDocument" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTYMANAGEMENT_TEST_DATA), Excel.ViewEditDocument,testcaseName);
			ObjAgreementsPanelPage.AddDocument(map, testcaseName);
		}
		
		@Test(priority = 7, enabled = true)
		public void Delete_Agreements_Panel_Info_TC_07() throws Exception {
			log("TC07 :Delete Agreement panel info");
			ObjAgreementsPanelPage.DeleteAgreementsPanelInformation();
		}
		
		@Test(priority = 8, enabled = true)
		public void Add_Stakeholders_TC_08() throws Exception {
			log("TC08 : Add Stakeholders");
			String testcaseName = "AddStakeholders" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTYMANAGEMENT_TEST_DATA), Excel.Stakeholders,testcaseName);
			ObjStakeholdersPage.AddStakeholders(map, testcaseName);
		}
		@Test(priority = 9, enabled = true)
		public void Delete_Stakeholders_Info_TC_09() throws Exception {
			log("TC09 : Delete Stakeholder");
			ObjStakeholdersPage.DeleteStakeholdersInfo();
		}
		
		
}


