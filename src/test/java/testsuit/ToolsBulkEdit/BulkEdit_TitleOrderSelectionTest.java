package testsuit.ToolsBulkEdit;

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
import pages.ToolsBulkEdit.BulkEdit_MyApprovalPage;
import pages.ToolsBulkEdit.BulkEdit_MyRequestPage;
import pages.ToolsBulkEdit.TitleOrderSelectionPage;

@Listeners(com.listeners.MyListeners.class)

public class BulkEdit_TitleOrderSelectionTest extends BasePage{

	LoginPage objLogin;
	BulkEdit_MyApprovalPage objMyApproval;
	BulkEdit_MyRequestPage objMyRequest;
	TitleOrderSelectionPage objTitleOrderSelectionPage;
	Map<String, String> map = new HashMap<String, String>();
	
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objMyApproval = new BulkEdit_MyApprovalPage(driver);
		objMyRequest = new BulkEdit_MyRequestPage(driver);
		objTitleOrderSelectionPage = new TitleOrderSelectionPage(driver);
	}
	
    @Test(priority = 1,enabled = true)
	public void AddProjectAssignment_Developer_TC_01() throws Exception {
		log("TC01 : Add Project Assignment 'Developer' ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		if(environment.contains("STEELHEAD")) {
		objLogin.loginWithSuperAdmin(map);
		}else {
			objLogin.login(map);
		}
		String testcaseName = "TitleOrderSelection" + clientName;
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA") & !testcaseName.contains("DOT") & !environment.contains("STEELHEAD") & !testcaseName.contains("ORSTED")) {
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.TitleOrderSelection, testcaseName);
		objTitleOrderSelectionPage.addProjectAssignment(map, testcaseName);
		}else {
			log("Not applicable for ROW and DOT", Status.SKIP);
		}
	}
	
	@Test(priority =2 ,enabled = true)
	public void verifyTitleOrderSelection_QuickView_TC_02() throws Exception {
		log("TC02 : verify Title Order Selection Quick View");
		String testcaseName = "TitleOrderSelection" + clientName;
		log("Data picked : " + testcaseName);
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA") & !testcaseName.contains("DOT") & !environment.contains("STEELHEAD") & !testcaseName.contains("ORSTED")) {
		objTitleOrderSelectionPage.verifyTitleOrderSelectionDD(testcaseName);
		objTitleOrderSelectionPage.verifyTitleOrderSelectionQV();
		}else {
			log("Not applicable for ROW and DOT", Status.SKIP);
		}
	}
	
	@Test(priority = 3,enabled = true)
	public void AddProjectAssignment_Title_TC_03() throws Exception {
		log("TC03 : Add Project Assignment 'Title' ");
		String testcaseName = "TitleStatusUpdate" + clientName;
		log("Data picked : " + testcaseName);
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA") & !testcaseName.contains("DOT") & !environment.contains("NOVA") & !environment.contains("STEELHEAD")) {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.TitleOrderSelection, testcaseName);
		objTitleOrderSelectionPage.addProjectAssignment(map, testcaseName);
		}else {
			log("Not applicable for ROW and DOT", Status.SKIP);
		}
	}
	
	@Test(priority =4 ,enabled = true)
	public void verifyTitleStatusUpdate_QuickView_TC_04() throws Exception {
		log("TC04 : verify Title Status Update Quick View");
		String testcaseName = "TitleStatusUpdate" + clientName;
		log("Data picked : " + testcaseName);
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA") & !testcaseName.contains("DOT") & !environment.contains("NOVA") & !environment.contains("STEELHEAD")) {
		objTitleOrderSelectionPage.verifyTitleStatusUpdateQV();
		}else {
			log("Not applicable for ROW and DOT", Status.SKIP);
		}
	}
	
	@Test(priority =5,enabled = true)
	public void ParcelSearch_BulkUpdate_TitleOrderSelection_TC_05() throws Exception {
		log("TC05 : verify Parcel search- Bulk Update Title Order Selection");
		String testcaseName = "BulkUpdate" + clientName;
		log("Data picked : " + testcaseName);
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA") & !testcaseName.contains("DOT") & !environment.contains("STEELHEAD")) {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.BulkUpdateALT, testcaseName);
		objTitleOrderSelectionPage.parcelSearch_BulkUpdate(map, testcaseName);
		}else {
			log("Not applicable for ROW and DOT", Status.SKIP);
		}
	}
}
