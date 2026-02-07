package testsuit.ProjectGroup;

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

import pages.projectGroup.AddProjectGroupPage;

@Listeners(com.listeners.MyListeners.class)
public class AddProjectGroupTest extends BasePage {

	LoginPage objLogin;
	AddProjectGroupPage objAddProjectGroup;
	
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddProjectGroup = new AddProjectGroupPage(driver);
	
	}

	@Test(priority = 1, enabled = true)
	public void addProjectGroup_TC_01() throws Exception {
		if(environment.contains("ORSTED") || environment.contains("ATWELL") || environment.contains("CONNECTGEN")) {
			log("Project Group Menu not applicable for this client", Status.SKIP);
		}else {
		log("TC01 : Add Project Group");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddProjectGroup" + clientName;
		log("Data picked : " + testcaseName);
		
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectGroup, testcaseName);
	    objAddProjectGroup.addProjectGroup(map, testcaseName);
		}
	}



	

}
