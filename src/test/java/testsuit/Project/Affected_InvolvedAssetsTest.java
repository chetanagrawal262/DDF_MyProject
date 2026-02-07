package testsuit.Project;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.Project.AffectedAssetsPage;

@Listeners(com.listeners.MyListeners.class)
public class Affected_InvolvedAssetsTest extends BasePage {

	LoginPage objLogin;
	AffectedAssetsPage objAffectedAssetsPage;
	ReadPropertyFile readPro = new ReadPropertyFile();
	CommonFunction commonFunction;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAffectedAssetsPage = new AffectedAssetsPage(driver);
		commonFunction = new CommonFunction(driver);
	}

	@Test(priority=1)
	public void Add_InvolvedAssets_TC_01() throws Exception {
		log("TC01 : Add Involved Assets");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddAffectedAssets" + clientName;
		commonFunction.navigateToProjectDeails();
		commonFunction.projectSelection();
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AffectedAssets,testcaseName);
		objAffectedAssetsPage.addAffectedAssets(map, testcaseName);
	}
	
	@Test(priority=3)
	public void Delete_InvolvedAssets_TC_03() throws Exception {
		log("TC03 : Delete Involved Assets");
		String testcaseName = "AddAffectedAssets" + clientName;
		objAffectedAssetsPage.deleteAffectedAssets(testcaseName);
	}
	
	@Test(priority=4)
	public void Add_LinesAssets_TC_04() throws Exception {
		log("TC04 : Add Lines Assets");
		String testcaseName = "AddLineAssets" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AffectedAssets,testcaseName);
		objAffectedAssetsPage.addAffectedAssets(map, testcaseName);
	}

}
