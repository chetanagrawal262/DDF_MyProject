package testsuit.Project;

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
import pages.Project.AddProjectPage;
import pages.Project.AddProjectStateCountyPage;
import pages.agreementManager.AddNewAgreementPageNextEra;

@Listeners(com.listeners.MyListeners.class)
public class AddProjectTest extends BasePage {
	LoginPage objLogin;
	AddProjectPage objAddProject;
	ReadPropertyFile readPro = new ReadPropertyFile();
	AddProjectStateCountyPage objStateCounty;
	AddNewAgreementPageNextEra objAddNewAgreementNextEra;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddProject = new AddProjectPage(driver);
		objStateCounty = new AddProjectStateCountyPage(driver);
		objAddNewAgreementNextEra = new AddNewAgreementPageNextEra(driver);
	}

	@Test(enabled = true,priority = 1)
	public void add_Project_TC_01() throws Exception {
		log("TC01 : Add a Project");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddProject" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.ProjectInformation,
				testcaseName);
		objAddProject.addProjectInformation(map, testcaseName);
	}
	
	@Test(enabled = true,priority = 2)
	public void add_Project_State_County_TC_02() throws Exception {
		
		log("TC02 : Add a Project State and County or Project Provinces & Muncipality Information");
		String testcaseName = "AddStateCounty" + clientName;
		if (testcaseName.toLowerCase().contains("alt") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")  || environment.contains("WOLFMIDSTREAM")  || environment.contains("DOM")) {
		log("Data picked : " + testcaseName);
		log("navigating to create State and County");
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.StateCounty, testcaseName);
		objStateCounty.addStateAndCountyInformation(map);
		objStateCounty.updateStateAndCountyInformation(map);
	}else {
		log(" Project State and County not applicable for DOT and ROW", Status.SKIP);
	}
		
	}
	
	@Test(enabled = true,priority = 3, description="113480")
	public void verify_Agreement_AutomationTestProject_TC_03() throws Exception {
		if (environment.contains("NEXTERA")) {
			log("TC03 : Add New Agreement for Automation Test Project");
			String testcaseName = "AddAgreementInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AgreementInfo, testcaseName);
			objAddNewAgreementNextEra.verifyAgreementPage(map, testcaseName);
			objAddNewAgreementNextEra.verifyAgreementNumber();
	}else {
		log("This Test Case is NextEra specific and not applicable for other clients", Status.SKIP);
	}
		
	}
	
	@Test(enabled = true,priority = 4, description="113480")
	public void verify_Agreement_AutomationRegressionProject_TC_04() throws Exception {
		if (environment.contains("NEXTERA")) {
			log("TC04 : Add New Agreement for Automation Regression Project");
			String testcaseName = "AddAgreementInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AgreementInfo, testcaseName);
			objAddNewAgreementNextEra.projectSelection();
			objAddNewAgreementNextEra.verifyAgreementPage(map, testcaseName);
			objAddNewAgreementNextEra.verifyNextAgreementNumber();
	}else {
		log("This Test Case is NextEra specific and not applicable for other clients", Status.SKIP);
	}
		
	}
	

}
