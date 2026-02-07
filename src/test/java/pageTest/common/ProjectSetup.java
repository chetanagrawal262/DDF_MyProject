package pageTest.common;

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
import pages.ProjectSetup.AddProjectPage;
import pages.ProjectSetup.PermissionPage;
import pages.ProjectSetup.ABSPage;
import pages.ProjectSetup.AddAgreementPage;
import pages.ProjectSetup.AddLandownerPage;
import pages.ProjectSetup.AddNewParcelPage;
import pages.ProjectSetup.AddNewUserAccountPage;
import pages.ProjectSetup.AddProjectAssignmentPage;
import com.aventstack.extentreports.Status;

@Listeners(com.listeners.MyListeners.class)
public class ProjectSetup extends BasePage {
	
	public static String AGREEMENT_NUMBER;
	String testcaseName;
	
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	AddNewUserAccountPage objAddUser;
	LoginPage objLogin;
	AddProjectPage objAddProject;
	AddProjectAssignmentPage objAddAssignment;
	AddAgreementPage objAddAgreement;
	AddNewParcelPage objAddParcel;
	AddLandownerPage objAddLandowner;
	PermissionPage objPermission;
	ABSPage objABS;
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddUser = new AddNewUserAccountPage(driver);
		objAddProject = new AddProjectPage(driver);
		objAddAssignment = new AddProjectAssignmentPage(driver);
		objAddAgreement = new AddAgreementPage(driver);
		objAddParcel = new AddNewParcelPage(driver);
		objAddLandowner = new AddLandownerPage(driver);
		objPermission = new PermissionPage(driver);
		objABS = new ABSPage(driver);
	}

	@Test(priority = 1, enabled=true)
	public void add_New_UserRole_TC_01() throws Exception {
		log("TC01 : Add a New User Role");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "AddNewUser" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), Excel.UserAccount,
				testcaseName);
		objPermission.createNewRole(map, testcaseName);
	}
	
	@Test(priority = 2, enabled=true)
	public void add_First_UserAccount_TC_02() throws Exception {
		log("TC02 : Add a New User");
		String testcaseName = "AddFirstUser" + clientName;
		if(!environment.contains("ORSTED")) {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), Excel.UserAccount,testcaseName);
		objAddUser.addFirstUser(map, testcaseName);
		}else {
			log("Not Applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 3, enabled=true)
	public void add_Second_UserAccount_TC_03() throws Exception {
		log("TC03 : Add a New User");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "AddNewUser" + clientName;
		if(!environment.contains("ORSTED")) {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), Excel.UserAccount,testcaseName);
		objAddUser.addNewUser(map, testcaseName);
		}else {
			log("Not Applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 4, enabled=true)
	public void Update_DefaultProjectRole_TC_04() throws Exception {
		if(environment.contains("CONNECTGEN") || environment.contains("AKUOENERGY")) {
		log("TC04 : update default project role for geosupport user");
		if(environment.contains("CONNECTGEN")) {
		testcaseName = "ProjectAssignmentCONNECTGEN";
		}else if(environment.contains("AKUOENERGY")) {
			testcaseName = "ProjectAssignmentAKUOENERGY";
		}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), Excel.ProjectAssignment,
				testcaseName);
		objAddUser.updateDefaultProjectRole(map, testcaseName);
		}else {
			log("Not Applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 5, enabled = true)
	public void Add_Project_TC_05() throws Exception {
		log("TC05 : Add a Project");
		String testcaseName = "AddProject" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), Excel.ProjectInformation,
				testcaseName);
		objAddProject.addProjectInformation(map, testcaseName);
	}
	
	@Test(priority = 6, enabled = true)
	public void Add_ProjectAssignment_TC_06() throws Exception {
		if(environment.contains("CONNECTGEN") || environment.contains("AKUOENERGY")) {
		log("TC06 : Add Project Assignment");
		if(environment.contains("CONNECTGEN")) {
			testcaseName = "ProjectAssignmentCONNECTGEN";
			}else if(environment.contains("AKUOENERGY")) {
				testcaseName = "ProjectAssignmentAKUOENERGY";
			}
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), Excel.ProjectAssignment,
				testcaseName);
		objAddAssignment.addProjectAssignment(map, testcaseName);
		}else {
			log("Not Applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 7,enabled = true)
	public void Add_Agreement_TC_07() throws Exception {
		log("TC07 : Add a Agreement");
		String testcaseName = "AddAgreementInformation" + clientName;
		if(!testcaseName.contains("DOT") & !environment.contains("CRIMSON") & !testcaseName.contains("TRA") & !testcaseName.contains("DOM")) {
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), Excel.AgreementInfo, testcaseName);
		objAddAgreement.addAgreementInformation(map, testcaseName);
		}
	}	
	
	@Test(priority = 8, enabled = true)
	public void Add_Parcels_TC_08() throws Exception {
		log("TC08 : Add Parcels");
		String testcaseName = "AddParcel" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), Excel.AddParcel,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
	}
	
	@Test(priority = 9)
	public void Add_Landowner_TC_09() throws Exception {
		log("TC09 : Add a Landowner");
		String testcaseName = "AddLandowner" + clientName;
		if(!environment.contains("ORION") & !testcaseName.contains("DOT")) {
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), Excel.Landowner, testcaseName);
		objAddLandowner.AddLandowner(map, testcaseName);
		}else {
			log("Not Applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 10)
	public void Check_Permissions_TC_10() throws Exception {
		log("TC10 : Check Permissions");
		String testcaseName = "CheckPermissions" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), "Permissions", testcaseName);
		objPermission.selectSpecialPermission(map, testcaseName);
	}
	
	@Test(priority = 11)
	public void Check_KeySettings_TC_11() throws Exception {
		log("TC11 : Check Key Settings");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "CheckPermissions" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TEST_DATA_SETUP), "KeySettings", testcaseName);
		objABS.SetKeySetting(map, testcaseName);
	}
	
	
}
