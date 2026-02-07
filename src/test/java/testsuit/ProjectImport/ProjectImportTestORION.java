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
import pages.projectImportALT.LandDataImportPageOrion;
import pages.projectImportALT.LayoutPermittedImportPage;
import pages.projectImportALT.LeaseContactDataImportPage;
import pages.projectImportALT.LeaseTermsImportPageOrion;
import pages.projectImportALT.ProductionTrackingImportPage;
import pages.projectImportALT.ProjectImportPage;
import pages.projectImportALT.TitleImportPage;

@Listeners(com.listeners.MyListeners.class)
public class ProjectImportTestORION extends BasePage {
	
	LoginPage objLogin;
	ProjectImportPage objProjectImportPage;
	LandDataImportPageOrion objLandDataImportPageOrion;	
	LeaseTermsImportPageOrion objLeaseTermsImportPageOrion;
	LeaseContactDataImportPage objLeaseContactDataImportPage;
	ProductionTrackingImportPage objProductionTrackingImportPage;
	TitleImportPage objTitleImportPage;
	LayoutPermittedImportPage objLayoutPermittedImportPage;
	
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objLandDataImportPageOrion = new LandDataImportPageOrion(driver);
		objLeaseTermsImportPageOrion = new LeaseTermsImportPageOrion(driver);
		objLeaseContactDataImportPage = new LeaseContactDataImportPage(driver);
		objProductionTrackingImportPage = new ProductionTrackingImportPage(driver);
		objTitleImportPage = new TitleImportPage(driver);
		objLayoutPermittedImportPage = new LayoutPermittedImportPage(driver);
		}
	
		@Test(priority=1, enabled=false)
	public void Download_Import_Templates_TC_01() throws Exception {
		log("TC01 :Download Import Templates");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		objProjectImportPage.downloadImportTemplates();
	}
	
	@Test(priority = 2, enabled = true)
	public void verifyLandDataMapping_TC_02() throws Exception {
		log("TC02 :Verify Land Data Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LandDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objLandDataImportPageOrion.verifyLandDataMapping(map, testcaseName);
	}
	
	@Test(priority=3, enabled=true)
	public void ValidLandDataImport_TC_03() throws Exception {
		log("TC03 :Import Valid Land Data");
		String testcaseName = "LandDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		for(int i=1; i<ExcelUtils.totalRows-1; i++) {
		String rowName = "LandDataImport" + clientName+i;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORION_PROJECTIMPORT_FILE), Excel.LandDataImportOrion,rowName);
		objLandDataImportPageOrion.verifyImportedLandData(map,rowName);
		}
		
	}
	
	@Test(priority=4, enabled=true)
	public void InvalidLandDataImport_TC_04() throws Exception {
		log("TC04 :Verify Validation messages");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LandDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objLandDataImportPageOrion.errorLogValidation(testcaseName);
	}
	
	@Test(priority=5, enabled=true)
	public void verifyLeaseTermsMapping_TC_05() throws Exception {
		log("TC05 :Verify Lease Terms Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LeaseTermsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objLeaseTermsImportPageOrion.verifyLeaseTermsMapping(map, testcaseName);
	}
	
	@Test(priority=6, enabled=true)
	public void validLeaseTermsImport_TC_06() throws Exception {
		log("TC06 :Import valid Lease Terms");
		String testcaseName = "LeaseTermsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionAgreement(map, testcaseName);
		for(int i=1; i<ExcelUtils.totalRows-1; i++) {
			String rowName = "LeaseTermsImport" + clientName+i;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORION_PROJECTIMPORT_FILE), Excel.LeaseTermsImportOrion, rowName);
		objLeaseTermsImportPageOrion.validationOfImportedData(map, rowName);
		}
	}
	
	@Test(priority=7, enabled=true)
	public void InvalidLeaseTermsImport_TC_07() throws Exception {
		log("TC07 :Importing Invalid Lease Terms");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LeaseTermsImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objLeaseTermsImportPageOrion.errorLogValidation(testcaseName);
	}
	
	
	@Test(priority=8, enabled=true)
	public void verifyLeaseContactDataMapping_TC_08() throws Exception {
		log("TC08 :Verify Lease contact Data Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LeaseContactDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objLeaseContactDataImportPage.verifyLeaseContactDataMapping(map, testcaseName);
	}
	
	@Test(priority=9, enabled=true)
	public void validLeaseContactDataImport_TC_09() throws Exception {
		log("TC09 :Import valid Lease Contact Data");
		String testcaseName = "LeaseContactDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelectionAgreement(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORION_PROJECTIMPORT_FILE), Excel.LeaseContactDataImport, testcaseName);
		objLeaseContactDataImportPage.validationOfImportedData(map, testcaseName);
	}
	
	@Test(priority=10, enabled=true)
	public void InvalidLeaseContactDataImport_TC_10() throws Exception {
		log("TC10 :Importing Invalid Lease Contact data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "LeaseContactDataImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objLeaseContactDataImportPage.errorLogValidation(testcaseName);
	}
	
	@Test(priority=11, enabled=true)
	public void verifyProductionTrackingImportMapping_TC_11() throws Exception {
		log("TC11 :Verify Production Tracking Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ProductionTrackingImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProductionTrackingImportPage.verifyProductionTrackingImportMapping(map, testcaseName);
	}
	
//	@Test(priority=12, enabled=true, description="Orion don't use Production Tracking Import")
//	public void validProductionTrackingImport_TC_12() throws Exception {
//		log("TC12 :Import valid Production Tracking Data");
//		String testcaseName = "ProductionTrackingImport" + clientName;
//		log("Data picked : " + testcaseName);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
//		objProjectImportPage.loadDataToProject(map, testcaseName);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PRODUCTION_TRACKING_IMPORT_FILE), Excel.ProductionTrackingImport, testcaseName);
//		objProductionTrackingImportPage.validationOfImportedData(map, testcaseName);
//	}
	
	@Test(priority=13, enabled=true)
	public void InvalidProductionTrackingImport_TC_13() throws Exception {
		log("TC13 :Importing Invalid Production Tracking data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ProductionTrackingImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objProductionTrackingImportPage.errorLogValidation(testcaseName);
	}
	
	@Test(priority=14, enabled=true)
	public void verifyTitleImportMapping_TC_14() throws Exception {
		log("TC14 :Verify Title Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "TitleImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objTitleImportPage.verifyTitleImportMapping(map, testcaseName);
	}

	@Test(priority=15, enabled=true)
	public void validTitleImport_TC_15() throws Exception {
		log("TC15 :Import valid Title Import Data");
		String testcaseName = "TitleImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORION_TITLEIMPORT_FILE), Excel.TitleImportOrion, testcaseName);
		objTitleImportPage.validationOfImportedData(map, testcaseName);
	}
	
	@Test(priority=16, enabled=true)
	public void InvalidTitleImport_TC_16() throws Exception {
		log("TC16 :Importing Invalid Title data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "TitleImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objTitleImportPage.errorLogValidation(testcaseName);
	}
	
	@Test(priority=17, enabled=true)
	public void verifyLayoutPermittedImportMapping_TC_17() throws Exception {
		log("TC17 :Verify Layout Permitted Import Mapping");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "Layout_PermittedImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objLayoutPermittedImportPage.verifyLayoutPermittedImportMapping(map, testcaseName);
	}
	
	@Test(priority=18, enabled=true)
	public void validLayoutPermittedImport_TC_18() throws Exception {
		log("TC18 :Import valid Layout Permitted Import Data");
		String testcaseName = "Layout_PermittedImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.loadDataToProject(map, testcaseName);
		objProjectImportPage.projectSelection(map, testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORION_TITLEIMPORT_FILE), Excel.LayoutPermittedImport, testcaseName);
		objLayoutPermittedImportPage.validationOfImportedData(map, testcaseName);
	}
	
	@Test(priority=19, enabled=true)
	public void InvalidLayoutPermittedImport_TC_19() throws Exception {
		log("TC19 :Importing Invalid Layout Permitted Import data");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "Layout_PermittedImport" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseName);
		objProjectImportPage.invalidProjectDataImport(map, testcaseName);
		objLayoutPermittedImportPage.errorLogValidation(testcaseName);
	}
	
}
