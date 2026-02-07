package testsuit.ProjectImport;

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
import pages.projectImportDOT.AgentNotesImportPage;
import pages.projectImportDOT.ContactImportPage;
import pages.projectImportDOT.KeyDatesImportPage;
import pages.projectImportDOT.LandownerImportPage;
import pages.projectImportDOT.ParcelImportPage;
import pages.projectImportDOT.ProjectImportPage;
import pages.projectImportDOT.ProjectNotesImportPage;

@Listeners(com.listeners.MyListeners.class)
public class ProjectImportTestDOT extends BasePage {
	
	LoginPage objLogin;
	ProjectImportPage objProjectImportPage;
	ParcelImportPage objParcelImportPage;
	AgentNotesImportPage objAgentNotesImportPage;
	LandownerImportPage objLandownerImportPage;
	ContactImportPage objcontactImportPage;
	KeyDatesImportPage objKeyDatesImportPage;
	ProjectNotesImportPage  objProjectNotesImportPage;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objParcelImportPage = new ParcelImportPage(driver);
		objAgentNotesImportPage = new AgentNotesImportPage(driver);
		objLandownerImportPage = new LandownerImportPage(driver);
		objcontactImportPage = new ContactImportPage(driver);
		objKeyDatesImportPage = new KeyDatesImportPage(driver);
		objProjectNotesImportPage = new ProjectNotesImportPage(driver);
	}

	@Test(priority=1, enabled=false)
	public void Verify_Import_Templates_TC_01() throws Exception {
		log("TC01 :Verify Import Templates");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		objProjectImportPage.downloadImportTemplates();
	}
	
	@Test(priority=2, enabled=true)
	public void verifyParcelImportMapping_TC_02() throws Exception {
		log("TC02 :Verify Parcel Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ParcelImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objParcelImportPage.verifyParcelImportMapping(map, testcaseName);
	}
	
	@Test(priority=3, enabled=true)
	public void ValidParcelImport_TC_03() throws Exception {
		log("TC03 :Import Valid Parcel Data");
		String testcaseName = "ParcelImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.DOT_PROJECTIMPORT_FILE), Excel.ParcelImport,testcaseName);
		objParcelImportPage.verifyImportedParcelData(map,testcaseName);	
	}
	
	@Test(priority=4, enabled=true)
	public void InvalidParcelImport_TC_04() throws Exception {
		log("TC04 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ParcelImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objParcelImportPage.errorLogValidation(testcaseName);
	}
	
	@Test(priority=5, enabled=true)
	public void verifyAgentNotesImportMapping_TC_05() throws Exception {
		log("TC05 :Verify Agent Notes Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AgentNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objAgentNotesImportPage.verifyAgentNotesImportMapping(map, testcaseName);
	}
	
	@Test(priority=6, enabled=true)
	public void ValidAgentNotesImport_TC_06() throws Exception {
		log("TC06 :Import Valid Agent Notes Data");
		String testcaseName = "AgentNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.DOT_PROJECTIMPORT_FILE), Excel.AgentNotesImport,testcaseName);
		objAgentNotesImportPage.verifyImportedAgentNotesData(map,testcaseName);	
	}
	
	@Test(priority=7, enabled=true)
	public void InvalidAgentNotesImport_TC_07() throws Exception {
		log("TC07 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AgentNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objAgentNotesImportPage.errorLogValidation(testcaseName);
	}
	
	@Test(priority=8, enabled=true)
	public void verifyLandownerImportMapping_TC_08() throws Exception {
		log("TC08 :Verify Landowner Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LandownerImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objLandownerImportPage.verifyLandownerMapping(map, testcaseName);
	}
	
	@Test(priority=9, enabled=true)
	public void ValidLandownerImport_TC_09() throws Exception {
		log("TC09 :Import Valid Landowner Data");
		String testcaseName = "LandownerImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.DOT_PROJECTIMPORT_FILE), Excel.LandownerImportDOT,testcaseName);
		objLandownerImportPage.validationOfImportedData(map,testcaseName);	
	}
	
	@Test(priority=10, enabled=true)
	public void InvalidLandownerImport_TC_10() throws Exception {
		log("TC10 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LandownerImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objLandownerImportPage.errorLogValidation(testcaseName);
	}
	
	@Test(priority=11, enabled=true)
	public void verifyContactImportMapping_TC_11() throws Exception {
		log("TC11 :Verify Contact Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ContactImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objcontactImportPage.verifyContactMapping(map, testcaseName);
	}
	
	@Test(priority=12, enabled=true)
	public void ValidContactImport_TC_12() throws Exception {
		log("TC12 :Import Valid Contact Data");
		String testcaseName = "ContactImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.DOT_PROJECTIMPORT_FILE), Excel.ContactImportDOT,testcaseName);
		objcontactImportPage.validationOfImportedData(map,testcaseName);	
	}
	
	@Test(priority=13, enabled=true)
	public void InvalidContactImport_TC_13() throws Exception {
		log("TC13 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ContactImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objcontactImportPage.errorLogValidation(testcaseName);
	}
	
	@Test(priority=14, enabled=true)
	public void verifyKeyDatesImportMapping_TC_14() throws Exception {
		log("TC14 :Verify Key Dates Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "KeyDatesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objKeyDatesImportPage.verifyKeyDatesImportMapping(map, testcaseName);
	}
	
	@Test(priority=15, enabled=true)
	public void ValidKeyDatesImport_TC_15() throws Exception {
		log("TC15 :Import Valid Key Dates Data");
		String testcaseName = "KeyDatesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.DOT_PROJECTIMPORT_FILE), Excel.KeyDatesImportDOT,testcaseName);
		objKeyDatesImportPage.verifyImportedKeyDatesData(map,testcaseName);	
	}
	
	@Test(priority=16, enabled=true)
	public void InvalidKeyDatesImport_TC_16() throws Exception {
		log("TC16 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "KeyDatesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objKeyDatesImportPage.errorLogValidation(testcaseName);
	}
	
	@Test(priority=17, enabled=true)
	public void verifyProjectNotesImportMapping_TC_17() throws Exception {
		log("TC17 :Verify Project Notes Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ProjectNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectNotesImportPage.verifyProjectNotesImportMapping(map, testcaseName);
	}
	
	@Test(priority=18, enabled=true)
	public void ValidProjectNotesImport_TC_18() throws Exception {
		log("TC18 :Import Valid Project Notes Data");
		String testcaseName = "ProjectNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionProject(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.DOT_PROJECTIMPORT_FILE), Excel.ProjectNotesImportDOT,testcaseName);
		objProjectNotesImportPage.verifyImportedProjectNotesData(map,testcaseName);	
	}
	
	@Test(priority=19, enabled=true)
	public void InvalidProjectNotesImport_TC_19() throws Exception {
		log("TC19 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ProjectNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objProjectNotesImportPage.errorLogValidation(testcaseName);
	}
	
	
//	@Test(priority=2, enabled=false)
//	public void DocumentImport_TC_02() throws Exception {
//		log("TC02 :Verify Document Import");
//		navigateToApplication(appURL);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
//		objLogin.login(map);
//		String testcaseName = "DocumentImport" + clientName;
//		log("Data picked : " + testcaseName);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportDOT, testcaseName);
//		objProjectImportPage.projectDataImportTemp(map, testcaseName);
//	}
//	
	
	

}
