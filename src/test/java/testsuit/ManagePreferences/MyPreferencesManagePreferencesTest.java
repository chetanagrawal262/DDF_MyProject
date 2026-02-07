package testsuit.ManagePreferences;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;

import page.Common.LoginPage;
import pages.ManagePreferences.ManageDelegatesPage;
import pages.ManagePreferences.NotificationPreferencesPage;
import pages.ManagePreferences.PasswordManagementPage;
import pages.ManagePreferences.UserInformationManagementPage;
import pages.ManagePreferences.UserPreferencesPage;

@Listeners(com.listeners.MyListeners.class)

public class MyPreferencesManagePreferencesTest extends BasePage{
	
	LoginPage objLogin;
	PasswordManagementPage objPasswordManagement;
	UserPreferencesPage objUserPreferences;
	NotificationPreferencesPage objNotificationPreferences;
	ManageDelegatesPage objManageDelegates;
	UserInformationManagementPage objUserInformation;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objPasswordManagement = new PasswordManagementPage(driver);
		objUserPreferences = new UserPreferencesPage(driver);
		objNotificationPreferences = new NotificationPreferencesPage(driver);
		objManageDelegates = new ManageDelegatesPage(driver);
		objUserInformation = new UserInformationManagementPage(driver);
	}
	
	@Test(priority = 1, enabled=false)
	public void Password_Management_TC_01() throws Exception {
		log("TC01 :  Password management");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "PasswordManagement" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.PasswordManagement,
				testcaseName);
		objPasswordManagement.PasswordManagement(map, testcaseName);
	}

	@Test(priority=2)
	public void Notification_Preferences_TC_02() throws Exception {
		log("TC02 : Notification preferences ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		if(environment.contains("ORION")) {
			objLogin.loginWithSuperAdmin(map);
		}else {
		objLogin.login(map);
		}
		String testcaseName = "NotificationPreferences" + clientName;
		objNotificationPreferences.NotificationPreferences(testcaseName);
	}
	
	@Test(priority=3)
	public void User_Preferences_TC_03() throws Exception {
		log("TC03 : User preferences ");
		String testcaseName = "UserPreferences" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.UserPreferences,
				testcaseName);
		objUserPreferences.UserPreferences(map, testcaseName);
	}
	
	@Test(priority=4)
	public void Manage_Delegates_TC_04() throws Exception {
		log("TC04 : Manage delegates ");
		String testcaseName = "ManageDelegates" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.ManageDelegates,
				testcaseName);
		objManageDelegates.ManageDelegates(map, testcaseName);
	}
	
	@Test(priority=5)
	public void User_Information_Management_TC_05() throws Exception {
		log("TC05 : User Information Management ");
		String testcaseName = "UserInformationManagement" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.UserInformationManagement,
				testcaseName);
		objUserInformation.UserInformationManagement(map, testcaseName);
	}
}

