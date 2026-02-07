package testsuit.Project;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;

import page.Common.LoginPage;
import pages.Project.AddProjectPermitPage;
import pages.tools.MyDashboardPage;

@Listeners(com.listeners.MyListeners.class)
public class AddProjectPermitTest extends BasePage {
	LoginPage objLogin;
	CommonFunction commonFunction;
	MyDashboardPage dashboardPage;
	ReadPropertyFile readPro = new ReadPropertyFile();
	AddProjectPermitPage projectPermit;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		projectPermit = new AddProjectPermitPage(driver);
		commonFunction = new CommonFunction(driver);
		dashboardPage = new MyDashboardPage(driver);
	}

	@Test()
	public void Add_Project_Permit_TC_07() throws Exception {
		if(!environment.contains("NEXTERA")) {
		log("TC07 : Add a Project Permit");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ProjectPermit" + clientName;
		log("Data picked : " + testcaseName);
		commonFunction.navigateToProjectDeails();
		commonFunction.projectSelection();
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.ProjectPermit,
				testcaseName);
		projectPermit.addProjectPermit(map);
		projectPermit.updateProjectPermit(map);
		projectPermit.addDocument(map,testcaseName);
		projectPermit.deletProjectPermit(map);
		}else {
			log("This test case is not applicable for NEXTERA", Status.SKIP);
		}
	}

}
