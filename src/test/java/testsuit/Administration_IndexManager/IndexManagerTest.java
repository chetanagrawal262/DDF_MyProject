package testsuit.Administration_IndexManager;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;

import page.Common.LoginPage;
import pages.Administration_IndexManager.DeleteIndexManagerPage;
import pages.Administration_IndexManager.IndexManagerPage;


@Listeners(com.listeners.MyListeners.class)

public class IndexManagerTest extends BasePage{

	LoginPage objLogin;
	IndexManagerPage objIndexManager;
	DeleteIndexManagerPage objDeleteIndexManager;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objIndexManager = new IndexManagerPage(driver);
		objDeleteIndexManager = new DeleteIndexManagerPage(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Index_Manager_TC_01() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("DOMINION")) {
		log("TC01 : Index Manager");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "IndexManager" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.IndexManager, testcaseName);
		objIndexManager.IndexManager(map, testcaseName);
		}else {
			log("Index Manager Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 2,enabled = true)
	public void Delete_Index_Manager_TC_02() throws Exception {
		if(!environment.contains("TRA") & !environment.contains("DOMINION")) {
		log("TC02 : Delete index Manager");
		String testcaseName = "DeleteIndexManager" + clientName;
		log("Data picked : " + testcaseName);
		objDeleteIndexManager.DeleteIndexManager(testcaseName);
		}else {
			log("Index Manager Menu not applicable for this client", Status.SKIP);
		}
	}
	
}
