package testsuite.BulkDataUpload;

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
import pages.BulkDataUpload.BulkDataUploadPage;

@Listeners(com.listeners.MyListeners.class)
public class BulkDataImportTest extends BasePage {

	LoginPage objLogin;
	BulkDataUploadPage objBulkDataUpload;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	String testcaseName;

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objBulkDataUpload = new BulkDataUploadPage(driver);
	}

	@Test(priority = 1, enabled = false)
	public void Download_BulkDataUpload_Template_TC_01() throws Exception {
		log("TC01 :Download Bulk Data Upload Templates");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		objBulkDataUpload.downloadImportTemplates();
	}

	@Test(priority = 2, enabled = true)
	public void ScheduleImportJob_TC_02() throws Exception {
		log("TC 02 :Schedule Bulk Data Import Job");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "ScheduleImportJob" + clientName;
			log("Data picked : " + testcaseName);
			objBulkDataUpload.scheduleImportJob(testcaseName);
	}
	

}
