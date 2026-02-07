package testsuit.adminSecurity;

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
import pages.administrationSecurity.PagePermissionUserAccountsPage;
import pages.administrationSecurity.UserRolePagePermissionPage;

@Listeners(com.listeners.MyListeners.class)
public class UserRole_PagePermissionTest extends BasePage {
	
	LoginPage objLogin;
	UserRolePagePermissionPage objPagePermission;
	PagePermissionUserAccountsPage objPagePermissionUserAccountsPage;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	public static String USERNAME, PASSWORD;

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objPagePermission = new UserRolePagePermissionPage(driver);
		objPagePermissionUserAccountsPage = new PagePermissionUserAccountsPage(driver);
	}
	
	@Test(priority=1, enabled=true)
	public void pagePermission_UserRole_TC_01() throws Exception {
		log("TC01 : Page Permission");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "AddPagePermission" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_SECURITY_TEST_DATA), Excel.UserRolePagePermission,
				testcaseName);
		objPagePermission.selectRolePermission(map, testcaseName);
		objPagePermission.addNewPermission(map, testcaseName);
	}
	
	@Test(priority=2)
	public void pagePermission_UserAccounts_TC_02() throws Exception {
		log("TC02 : Verify Page Permission of User Accounts Page");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "ReadPagePermission" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_SECURITY_TEST_DATA), Excel.ReadPagePermissionScenario,
				testcaseName);
		objPagePermissionUserAccountsPage.addNewUser(map, testcaseName);
		objPagePermissionUserAccountsPage.selectPagePermission(map, testcaseName);
		
	}
	
	@Test(priority=3)
	public void pagePermission_UserRoles_TC_03() throws Exception {
		log("TC03 : Verify Page Permission of User Roles Page");
		String testcaseName = "ReadPagePermission" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_SECURITY_TEST_DATA), Excel.ReadPagePermissionScenario,
				testcaseName);
		objPagePermissionUserAccountsPage.verifyUserRolePagePermission(map, testcaseName);
		
	}
	
	//#76318
	@Test(priority=4)
	public void pagePermission_ParcelInformation_TC_04() throws Exception {
		log("TC04 : Verify Page Permission of Parcel Information Page");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		USERNAME=map.get("NonSuperAdminUserName");
		PASSWORD=map.get("Password2");
		String testcaseName = "AddPagePermission" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_SECURITY_TEST_DATA), Excel.UserRolePagePermission,
				testcaseName);
		objPagePermissionUserAccountsPage.verifyParcelInformationPagePermission(map, testcaseName,USERNAME,PASSWORD);
		
	}
	
}
