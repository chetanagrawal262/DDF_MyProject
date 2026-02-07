package testsuit.adminSecurity;

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
import pages.administrationSecurity.ParcelInformation_AddNewParcelPage;
import pages.InfoByParcelReport.AddProjectPage;
import pages.administrationSecurity.AddNewUserUserAccountPage;

@Listeners(com.listeners.MyListeners.class)
public class UserAccount_AddNewUserTest extends BasePage {
	
	LoginPage objLogin;
	AddProjectPage objAddProject;
	AddNewUserUserAccountPage objAddUser;
	ParcelInformation_AddNewParcelPage objAddParcel;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddUser = new AddNewUserUserAccountPage(driver);
		objAddParcel = new ParcelInformation_AddNewParcelPage(driver);
		objAddProject = new AddProjectPage(driver);
	}
	
	@Test(enabled = true,priority = 1)
	public void UserAccounts_add_Project_TC_01() throws Exception {
		log("TC01 : Add a Project");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "AddProjectUA" + clientName;
		log("Data picked : " + testcaseName);
		log("navigating to create new Project");
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_SECURITY_TEST_DATA), Excel.ProjectInformation,
				testcaseName);
		objAddProject.addProjectInformation(map, testcaseName);
	}
	
	@Test(priority = 2, enabled=true)
	public void UserAccounts_add_NewUser_TC_02() throws Exception {
		log("TC02 : Add a New User");
		String testcaseName = "AddNewUser" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_SECURITY_TEST_DATA), Excel.UserAccount,
				testcaseName);
		objAddUser.addNewUser(map, testcaseName);
		objAddUser.updateNewUser(map,testcaseName);
	}
	
	
	@Test(priority = 3, enabled=true)
	public void UserAccounts_add_NewParcel_TC_03() throws Exception {
		if(!environment.contains("VALARD") & !environment.contains("ORSTED") & !environment.contains("NOVA") & !environment.contains("BAYWA") & !environment.contains("WSBALT") & !environment.contains("AVANTUS") & !environment.contains("GRAYHAWKALT") & !environment.contains("RAMACO") & !environment.contains("ORION") & !environment.contains("WOLFMIDSTREAM")) {
		String testcaseName = "AddParcel" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcel,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
		objAddUser.verifyTractAssignment(testcaseName);
		}else {
			log("Tract Assignment Validation not applicable for this clients", Status.SKIP);
		}
	}

}
