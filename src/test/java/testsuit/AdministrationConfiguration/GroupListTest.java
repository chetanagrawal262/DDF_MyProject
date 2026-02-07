package testsuit.AdministrationConfiguration;
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
import pages.Administration.AddNewGroupListPage;


@Listeners(com.listeners.MyListeners.class)

public class GroupListTest extends BasePage{

	 LoginPage objLogin;
	 AddNewGroupListPage objAddNewGroupList;
	 ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
		
		
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objAddNewGroupList = new AddNewGroupListPage(driver);
			

		}
		
		@Test(priority=1)
		public void Group_List_TC() throws Exception {
			log("Add a New Group List");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddNewGroup" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.GroupList,testcaseName);
			objAddNewGroupList.addNewGroupList(map, testcaseName);
		}
		
}
