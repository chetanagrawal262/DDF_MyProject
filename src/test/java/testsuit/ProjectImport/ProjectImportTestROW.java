package testsuit.ProjectImport;

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
import pages.ProjectImportROW.AgentNotesImportPage;
import pages.ProjectImportROW.AgreementImportPage;
import pages.ProjectImportROW.ContactImportPage;
import pages.ProjectImportROW.KeyDatesImportPage;
import pages.ProjectImportROW.LandownerImportPage;
import pages.ProjectImportROW.LegalDescriptionImportPage;
import pages.ProjectImportROW.ParcelImportPage;
import pages.ProjectImportROW.ParcelNumberUpdateImportPage;
import pages.ProjectImportROW.ProjectNotesImport;
import pages.ProjectImportROW.RowDimensionsImportPage;
import pages.ProjectImportROW.SpecialConditionsImportPage;
import pages.ProjectImportROW.TitleImportPage;
import pages.projectImportALT.ProjectImportPage;

@Listeners(com.listeners.MyListeners.class)
public class ProjectImportTestROW extends BasePage {
	
	LoginPage objLogin;
	ProjectImportPage objProjectImportPage;
	ParcelImportPage objParcelImportPage;
	ParcelNumberUpdateImportPage objParcelNumberUpdateImportPage;
	AgentNotesImportPage objAgentNotesImportPage;
	TitleImportPage objTitleImportPage;
	AgreementImportPage objAgreementImportPage;
	KeyDatesImportPage objKeyDatesImportPage;
	ContactImportPage objContactImportPage;
	LandownerImportPage objLandownerImportPage;
	LegalDescriptionImportPage objLegalDescriptionImportPage;
	ProjectNotesImport objProjectNotesImport;
	RowDimensionsImportPage objRowDimensionsImportPage;
	SpecialConditionsImportPage objSpecialConditionsImportPage;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objParcelImportPage = new ParcelImportPage(driver);
		objParcelNumberUpdateImportPage = new ParcelNumberUpdateImportPage(driver);
		objAgentNotesImportPage = new AgentNotesImportPage(driver);
		objTitleImportPage = new TitleImportPage(driver);
		objAgreementImportPage = new AgreementImportPage(driver);
		objKeyDatesImportPage = new KeyDatesImportPage(driver);
		objContactImportPage = new ContactImportPage(driver);
		objLandownerImportPage = new LandownerImportPage(driver);
		objLegalDescriptionImportPage = new LegalDescriptionImportPage(driver);
		objProjectNotesImport = new ProjectNotesImport(driver);
		objRowDimensionsImportPage = new RowDimensionsImportPage(driver);
		objSpecialConditionsImportPage = new SpecialConditionsImportPage(driver);	
	}
	
	@Test(priority=1, enabled=false)
	public void Download_Import_Templates_TC_01() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC01 :Download Import Templates");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		objProjectImportPage.downloadImportTemplates();
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}	
    
	@Test(priority=2, enabled=true)
	public void verifyParcelImportMapping_TC_02() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC02 :Verify Parcel Import");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ParcelImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objParcelImportPage.verifyParcelImportMapping(map, testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=3, enabled=true)
	public void ValidParcelImport_TC_03() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC03 :Import Valid Land Data");
		String testcaseName = "ParcelImport" + clientName;
		log("Data picked : " + testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);			
		objParcelImportPage.verifyImportedParcelData(testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=4, enabled=true)
	public void InvalidParcelImport_TC_04() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC04 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ParcelImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objParcelImportPage.errorLogValidation(testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=5, enabled=true)
	public void verifyParcelNumberUpdateImportMapping_TC_05() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC05 :Verify Parcel Number Update Import");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ParcelNumberUpdateImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objParcelNumberUpdateImportPage.verifyParcelNumberUpdateImportMapping(map, testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=6, enabled=true)
	public void ValidParcelNumberUpdateImport_TC_06() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC06 :Import Valid Parcel Number Update");
		String testcaseName = "ParcelNumberUpdateImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		if(testcaseName.contains("TRA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TRA_PROJECTIMPORT_FILE), Excel.ParcelNumberUpdateImport, testcaseName);
		}else {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.ParcelNumberUpdateImport, testcaseName);
		}
		objParcelNumberUpdateImportPage.verifyImportedParcelNumberUpdateData(map,testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=7, enabled=true)
	public void InvalidParcelNumberUpdateImport_TC_07() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC07 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ParcelNumberUpdateImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objParcelNumberUpdateImportPage.errorLogValidation(testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=8, enabled=true)
	public void verifyAgentNotesMapping_TC_08() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC08 :Verify Land Data Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "AgentNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objAgentNotesImportPage.verifyAgentNotesImportMapping(map, testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=9, enabled=true)
	public void ValidAgentNotesImport_TC_09() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC09 :Import Valid Land Data");
		String testcaseName = "AgentNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.NotesSelection(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.AgentNotesImport, testcaseName);
		objAgentNotesImportPage.validationOfImportedData(testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=10, enabled=true)
	public void verifyAgentNotesPageSize_TC_10() throws Exception {
		if(!environment.contains("TRA")) {
		log("Verify Agent Notes Page Size");
		String testcaseName = "AgentNotesImport" + clientName;
		objAgentNotesImportPage.verifyPageSize(testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=11, enabled=true)
	public void InvalidAgentNotesImport_TC_11() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC11 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AgentNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objAgentNotesImportPage.errorLogValidation(testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority=12, enabled=true)
	public void verifyTitleMapping_TC_12() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC12 :Verify Title Data Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "TitleImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objTitleImportPage.verifyTitleImportMapping(map, testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=13, enabled=true)
	public void ValidTitleImport_TC_13() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC13 :Import Valid Title Data");
		String testcaseName = "TitleImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.titleSelection(map, testcaseName);
		
		for(int i=1; i<ExcelUtils.totalRows-1; i++) {
			String rowName = "TitleImport" + clientName+i;
			if(testcaseName.contains("TRA")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TRA_PROJECTIMPORT_FILE), Excel.TitleImport,rowName);
			}else {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.TitleImport,rowName);
			}
			objTitleImportPage.validationOfImportedData(map,rowName);
		}
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=14, enabled=true)
	public void InvalidTitleImport_TC_14() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC14 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "TitleImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objTitleImportPage.errorLogValidation(testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=15, enabled=true)
	public void verifyAgreementMapping_TC_15() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC15 :Verify Agreement Data Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AgreementImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objAgreementImportPage.verifyAgreementImportMapping(map, testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=16, enabled=true)
	public void ValidAgreementImport_TC_16() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC16 :Import Valid Agreement Data");
		String testcaseName = "AgreementImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.acquisitionSelection(map, testcaseName);
		if(testcaseName.contains("TRA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TRA_PROJECTIMPORT_FILE), Excel.AgreementImport,testcaseName);
		}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.AgreementImport,testcaseName);
		}
		objAgreementImportPage.validationOfImportedData(testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=17, enabled=true)
	public void InvalidAgreementImport_TC_17() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC17 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AgreementImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objAgreementImportPage.errorLogValidation(testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=18, enabled=true)
	public void verifyKeyDatesMapping_TC_18() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC18 :Verify Key Dates Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "KeyDatesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objKeyDatesImportPage.verifyKeyDatesImportMapping(map, testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=19, enabled=true)
	public void ValidKeyDatesImport_TC_19() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC19 :Import Valid Key Dates");
		String testcaseName = "KeyDatesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		if(testcaseName.contains("TRA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TRA_PROJECTIMPORT_FILE), Excel.KeyDatesImportDOT,testcaseName);
		}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.KeyDatesImportDOT,testcaseName);
		}
		objKeyDatesImportPage.validationOfImportedData(testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=20, enabled=true)
	public void InvalidKeyDatesImport_TC_20() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC20 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "KeyDatesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objContactImportPage.errorLogValidation(testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}


    @Test(priority=21, enabled=true)
    public void verifyContactMapping_TC_21() throws Exception {
    	if(!environment.contains("TRA")) {
    	log("TC21 :Verify Contact Mapping");
	    navigateToApplication(appURL);
	    map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
	    objLogin.login(map);
	    String testcaseName = "ContactImport" + clientName;
	    log("Data picked : " + testcaseName);
	    map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
	    objContactImportPage.verifyContactImportMapping(map,testcaseName);
    	}else {
    		log("Project Import Menu not applicable for this client", Status.SKIP);
    	}
    }

    @Test(priority=22, enabled=true)
    public void ValidContactImport_TC_22() throws Exception {
    	if(!environment.contains("TRA")) {
    	log("TC22 :Import Valid Contact");
    	String testcaseName = "ContactImport" + clientName;
	    log("Data picked : " + testcaseName);
	    map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
	    objProjectImportPage.loadDataToProject(map, testcaseName);
	    objProjectImportPage.projectSelection(map, testcaseName);
	    if(testcaseName.contains("TRA")) {
	    	map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TRA_PROJECTIMPORT_FILE), Excel.ContactImportDOT,testcaseName);
	    }else {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.ContactImportDOT,testcaseName);
    	}
	    objContactImportPage.validationOfImportedData(testcaseName);
    	}else {
    		log("Project Import Menu not applicable for this client", Status.SKIP);
    	}
    }

    @Test(priority=23, enabled=true)
    public void InvalidContactImport_TC_23() throws Exception {
    	if(!environment.contains("TRA")) {
    	log("TC23 :Verify Validation messages");
	    navigateToApplication(appURL);
	    map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
	    objLogin.login(map);
	    String testcaseName = "ContactImport" + clientName;
	    log("Data picked : " + testcaseName);
	    map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
	    objProjectImportPage.invalidProjectDataImport(map, testcaseName);
	    objKeyDatesImportPage.errorLogValidation(testcaseName);
    	}else {
    		log("Project Import Menu not applicable for this client", Status.SKIP);
    	}
    }
    
	@Test(priority=24, enabled=true)
	public void verifyLandownerImportMapping_TC_24() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC24: Verify Landowner Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LandownerImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objLandownerImportPage.verifyLandownerMapping(map, testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=25, enabled=true)
	public void validLandownerImport_TC_25() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC25 :Import valid Landowner Data");
		String testcaseName = "LandownerImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		if(environment.contains("WOLFMIDSTREAM")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.WOLF_PROJECTIMPORT_FILE), Excel.LandownerImport,testcaseName);
		}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.LandownerImport,testcaseName);
		}
		objLandownerImportPage.validationOfImportedData(map, testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=26, enabled=true)
	public void InvalidLandownerImport_TC_26() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC26 :Importing Invalid Landowner data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LandownerImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objLandownerImportPage.errorLogValidation(testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=27, enabled=true)
	public void verifyLegalDescriptionImportMapping_TC_27() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC27: Verify Legal Description Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LegalDescriptionImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objLegalDescriptionImportPage.verifyLegalDescriptionMapping(map, testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=28, enabled=true)
	public void validLegalDescriptionImport_TC_28() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC28 :Import valid Legal Description Data");
		String testcaseName = "LegalDescriptionImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		if(testcaseName.contains("TRA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TRA_PROJECTIMPORT_FILE), Excel.legalDescription,testcaseName);
		}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.legalDescription,testcaseName);
		}
		objLegalDescriptionImportPage.validationOfImportedData(map, testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=29, enabled=true)
	public void InvalidLegalDescriptionImport_TC_29() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC29 :Importing Invalid Legal Description data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LegalDescriptionImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objLegalDescriptionImportPage.errorLogValidation(testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=30, enabled=true)
	public void verifyProjectNotesImportMapping_TC_30() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC30:Verify Project Notes Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ProjectNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectNotesImport.verifyProjectNotesMapping(map, testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=31, enabled=true)
	public void validProjectNotesImport_TC_31() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC31 :Import valid Project Notes Data");
		String testcaseName = "ProjectNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionProject(map, testcaseName);
		if(testcaseName.contains("TRA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TRA_PROJECTIMPORT_FILE), Excel.ProjectNotes,testcaseName);
		}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.ProjectNotes,testcaseName);
		}
		objProjectNotesImport.validationOfImportedData(map, testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=32, enabled=true)
	public void InvalidProjectNotesImport_TC_32() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC32 :Importing Invalid Project Notes data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ProjectNotesImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objProjectNotesImport.errorLogValidation(testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=33, enabled=true)
	public void verifyRowDimensionsImportMapping_TC_33() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC33 :Verify Special Condition Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ROWDimensionsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objRowDimensionsImportPage.verifyRowDimensionsMapping(map, testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=34, enabled=true)
	public void validRowDimensionsImport_TC_34() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC34 :Import valid Row Dimensions Data");
		String testcaseName = "ROWDimensionsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		if(testcaseName.contains("TRA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TRA_PROJECTIMPORT_FILE), Excel.RowDimensions,testcaseName);
		}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.RowDimensions,testcaseName);
		}
		objRowDimensionsImportPage.validationOfImportedData(map, testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=35, enabled=true)
	public void InvalidROWDimensionsImport_TC_35() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC35 :Importing Invalid ROW Dimensions data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ROWDimensionsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objRowDimensionsImportPage.errorLogValidation(testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=36, enabled=true)
	public void verifySpecialConditionImportMapping_TC_36() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC36 :Verify Special Condition Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "SpecialConditionsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objSpecialConditionsImportPage.verifySpecialConditionsMapping(map, testcaseName);
		}else {
			log("Project Import Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=37, enabled=true)
	public void validSpecialConditionsImport_TC_37() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC37 :Import valid Special Conditions Data");
		String testcaseName = "SpecialConditionsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		if(testcaseName.contains("TRA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TRA_PROJECTIMPORT_FILE), Excel.SpecialConditions,testcaseName);
		}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.SpecialConditions,testcaseName);
		}
		objSpecialConditionsImportPage.validationOfImportedData(map, testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}

	@Test(priority=38, enabled=true)
	public void InvalidSpecialConditionsImport_TC_38() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("WOLFMIDSTREAM")) {
		log("TC38 :Importing Invalid Special Conditions data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "SpecialConditionsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportROW, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objSpecialConditionsImportPage.errorLogValidation(testcaseName);
	}else {
		log("Project Import Menu not applicable for this client", Status.SKIP);
	}
	}
	
	
	

}
