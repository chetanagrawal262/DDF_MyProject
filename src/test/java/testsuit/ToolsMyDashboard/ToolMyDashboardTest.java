package testsuit.ToolsMyDashboard;

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
import page.toolsMyDashboard.ToolMyDashboardPage;

@Listeners(com.listeners.MyListeners.class)
public class ToolMyDashboardTest extends BasePage {
	
	LoginPage objLogin;
	ToolMyDashboardPage objToolMyDashboard ;
	Map<String, String> map = new HashMap<String, String>();
	public static String USERNAME, PASSWORD;
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objToolMyDashboard = new ToolMyDashboardPage(driver);
	}

	@Test(priority = 1,enabled = true)
	public void verifyMyParcel_TC_01() throws Exception {
		log("TC01 : Verify MyParcel :");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = " Verify MyParcel" + clientName;
		log("Data picked : " + testcaseName);
		objToolMyDashboard.verifyMyParcel(testcaseName);
	}
		
	@Test(priority = 2,enabled = true)
	public void verifyMyProject_TC_02() throws Exception {
		log("TC02 : Verify MyProject :");
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		String testcaseName = "VerifyMyProject" + clientName;
		log("Data picked : " + testcaseName);
		objToolMyDashboard.verifyMyProject(testcaseName);
	}
	@Test(priority = 3,enabled = true)
	public void verifyNoteToReview_TC_03() throws Exception {
		if(!environment.contains("DOM")) {
		log("TC03 : Verify NoteToReview :");
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		String testcaseName = "VerifyMyProject" + clientName;
		log("Data picked : " + testcaseName);
		objToolMyDashboard.verifyNoteToReview( testcaseName);
		}else {
			log(" Notes To Review is not  applicable for DOMINION", Status.SKIP);
		}
	}
	@Test(priority = 4,enabled = true)
	public void verifyNotesToEdit_TC_04() throws Exception {
		if(!environment.contains("DOM")) {
		log("TC04 : verify Notes to Edit :");
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		String testcaseName = "EditNoteReview" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddParcelNotes,testcaseName);
		
		objToolMyDashboard.editNoteToReview(map, testcaseName);
	}else {
		log(" Notes To Review is not  applicable for DOMINION", Status.SKIP);
	}
	}

	@Test(priority = 5,enabled = true)
	public void deletDoc_TC_05() throws Exception {
		log("TC05 : Delect Doc :");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
			USERNAME=map.get(Excel.UserName);
			PASSWORD=map.get(Excel.Password);
		String testcaseName = "AddDocument" + clientName;
		if(testcaseName.contains("ROW") || testcaseName.contains("DOM")) {
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddDocument,testcaseName);
		objToolMyDashboard.deleteDoc(map,testcaseName,USERNAME,PASSWORD);
		}else {
			log("Deleted doc is not applicable for this client", Status.SKIP);
		}
	}
	
}
