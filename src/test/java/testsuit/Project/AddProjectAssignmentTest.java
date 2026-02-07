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
import pages.Project.AddProjectAssignmentPage;
import pages.tools.MyDashboardPage;

@Listeners(com.listeners.MyListeners.class)
public class AddProjectAssignmentTest extends BasePage {

	LoginPage objLogin;
	CommonFunction commonFunction;
	MyDashboardPage dashboardPage;
	ReadPropertyFile readPro = new ReadPropertyFile();
	AddProjectAssignmentPage AssignmentPage;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		AssignmentPage = new AddProjectAssignmentPage(driver);
		commonFunction = new CommonFunction(driver);
		dashboardPage = new MyDashboardPage(driver);
	}

	@Test()
	public void Add_Project_Assignment_05() throws Exception {
		log("TC05 : Add a Project Assignment");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "ProjectAssignment" + clientName;
		commonFunction.navigateToProjectDeails();
		commonFunction.projectSelection();
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.ProjectAssignment,
				testcaseName);
		AssignmentPage.addProjectAssignment(map,testcaseName);
		AssignmentPage.UpdateProjectAssignment(map);
	}

}
