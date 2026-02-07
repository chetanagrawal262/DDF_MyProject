package testsuit.SSRSReports;

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
import pages.Assignment.AddParcelAssignmentsPage;
import pages.ParcelNotes.AddParcelNotesPage;
import pages.SSRSReport.ROWReportsPage;

@Listeners(com.listeners.MyListeners.class)
public class ROW016_ReportTest extends BasePage {

	LoginPage objLogin;
	AddParcelNotesPage objAddParcelNotes;
	AddParcelAssignmentsPage objAddParcelAssignments;
	ROWReportsPage objROWReportsPage;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddParcelNotes = new AddParcelNotesPage(driver);
		objAddParcelAssignments = new AddParcelAssignmentsPage(driver);
		objROWReportsPage = new ROWReportsPage(driver);
	}

	@Test(priority=1)
	public void AddAgentNotes_TC_01() throws Exception {
		log("TC01 : Add Agent Notes");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddParcelNotes" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddParcelNotes,testcaseName);
		objAddParcelNotes.AddParcelNotes(map, testcaseName);
	}
	
//	@Test(priority = 2)
//	public void Add_TractAssignment_TC_02() throws Exception {
//		log("TC02 : Add Tract Assignment");
//		String testcaseName = "AddParcelAssignments" + clientName;
//		log("Data picked : " + testcaseName);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcelAssignments, testcaseName);
//		objAddParcelAssignments.NavigateToAssignmentTabDot();
//		objAddParcelAssignments.AddParcelAssignments(map, testcaseName);
//	}
	
	@Test(priority=3)
	public void viewReport_ROW016_NotesByTract_TC_03() throws Exception {
		log("TC03 : verify Notes by Tract Report");
		String testcaseName = "ViewReport_" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.REPORT_TEST_DATA), Excel.SSRSReport, testcaseName);
		objROWReportsPage.ReportPermission(map, testcaseName);
		objROWReportsPage.viewReport_ROW016(map, testcaseName);
	}
}
