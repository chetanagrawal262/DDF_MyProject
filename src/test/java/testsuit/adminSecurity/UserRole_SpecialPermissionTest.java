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
import pages.administrationSecurity.UserRoleSpecialPermissionPage;

@Listeners(com.listeners.MyListeners.class)
public class UserRole_SpecialPermissionTest extends BasePage {

	
	LoginPage objLogin;
	UserRoleSpecialPermissionPage objSpecialPermission;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objSpecialPermission = new UserRoleSpecialPermissionPage(driver);
	}
	
	@Test()
	public void specialPermission_UserRole_TC() throws Exception {
		log("Verify Special Permission");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddSpecialPermission" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_SECURITY_TEST_DATA), Excel.UserRoleSpecialPermission,
				testcaseName);
		objSpecialPermission.selectSpecialPermission(map, testcaseName);
	}
}
