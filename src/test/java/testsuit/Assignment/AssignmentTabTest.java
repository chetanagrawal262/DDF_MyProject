package testsuit.Assignment;

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
import pages.Assignment.AddParcelAssignmentsPage;
import pages.Assignment.AssignmentTabPage;
import pages.Assignment.DeleteParcelAssignmentRecordPage;
import pages.Assignment.EditParcelAssignmentRecordPage;

@Listeners(com.listeners.MyListeners.class)

public class AssignmentTabTest extends BasePage{

	LoginPage objLogin;
	AssignmentTabPage objAssignmentTab;
	AddParcelAssignmentsPage objAddParcelAssignments;
	EditParcelAssignmentRecordPage objEditParcelAssignmentRecord;
	DeleteParcelAssignmentRecordPage objDeleteParcelAssignmentRecord;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAssignmentTab = new AssignmentTabPage(driver);
		objAddParcelAssignments = new AddParcelAssignmentsPage(driver);
		objEditParcelAssignmentRecord = new EditParcelAssignmentRecordPage(driver);
		objDeleteParcelAssignmentRecord = new DeleteParcelAssignmentRecordPage(driver);
	}

	@Test(priority = 1)
	public void Assignment_Tab_TC_01() throws Exception {
		log("TC01 : Assignment Tab");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "AssignmentTab" + clientName;
		if(testcaseName.contains("ORSTED") || environment.contains("NOVA") || environment.contains("BAYWA") || environment.contains("WSBALT") || environment.contains("AVANTUS") || environment.contains("GRAYHAWKALT") || environment.contains("RAMACO") || environment.contains("ORION")) {
			log("Assignment Tab not applicable for this client", Status.SKIP);
		}else {
		log("Data picked : " + testcaseName);
		objAssignmentTab.AssignmentTab(testcaseName);
		}
	}
	
	@Test(priority = 2)
	public void AddParcelAssignments_TC_02() throws Exception {
		log("TC02 : Add Parcel Assignments");
		String testcaseName = "AddParcelAssignments" + clientName;
		log("Data picked : " + testcaseName);
		if(testcaseName.contains("ORSTED") || environment.contains("NOVA") || environment.contains("BAYWA") || environment.contains("WSBALT") || environment.contains("AVANTUS") || environment.contains("GRAYHAWKALT") || environment.contains("RAMACO") || environment.contains("ORION")) {
			log("Assignment Tab not applicable for this client", Status.SKIP);
		}else {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddParcelAssignments, testcaseName);
		objAddParcelAssignments.AddParcelAssignments(map, testcaseName);
		}
	}
	
	@Test(priority = 3)
	public void EditParcelAssignmentRecord_TC_03() throws Exception {
		log("TC03 : Edit Parcel Assignment record");
		String testcaseName = "EditParcelAssignmentRecord" + clientName;
		log("Data picked : " + testcaseName);
		if(testcaseName.contains("ORSTED") || environment.contains("NOVA") || environment.contains("BAYWA") || environment.contains("WSBALT") || environment.contains("AVANTUS")|| environment.contains("GRAYHAWKALT") || environment.contains("RAMACO") || environment.contains("ORION")) {
			log("Assignment Tab not applicable for this client", Status.SKIP);
		}else {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.EditParcelAssignments, testcaseName);
		objEditParcelAssignmentRecord.EditParcelAssignmentRecord(map, testcaseName);
		}
	}
	
	@Test(priority = 4)
	public void DeleteParcelAssignmentRecord_TC_04() throws Exception {
		log("TC04 : Delete Parcel Assignment record");
		String testcaseName = "DeleteParcelAssignmentRecord" + clientName;
		log("Data picked : " + testcaseName);
		if(testcaseName.contains("ORSTED") || environment.contains("NOVA") || environment.contains("BAYWA") || environment.contains("WSBALT") || environment.contains("AVANTUS") || environment.contains("GRAYHAWKALT") || environment.contains("RAMACO") || environment.contains("ORION")) {
			log("Assignment Tab not applicable for this client", Status.SKIP);
		}else {
		objDeleteParcelAssignmentRecord.DeleteParcelAssignmentRecord(testcaseName);
		}
	}
	
	
}
