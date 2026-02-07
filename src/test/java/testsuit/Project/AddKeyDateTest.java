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
import pages.Project.AddKeyDatePage;

@Listeners(com.listeners.MyListeners.class)
public class AddKeyDateTest extends BasePage {

	LoginPage objLogin;
	ReadPropertyFile readPro = new ReadPropertyFile();
	AddKeyDatePage objKeyDate;
	CommonFunction commonFunction;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objKeyDate = new AddKeyDatePage(driver);
		commonFunction = new CommonFunction(driver);
	}

	@Test()
	public void Add_a_Key_Date_TC_06() throws Exception {
		if(!environment.contains("NEXTERA")) {
		log("TC06 : Add a Key Date");
	navigateToApplication(appURL);
	map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddKey" + clientName;
		log("Data picked : " + testcaseName);
		commonFunction.navigateToProjectDeails();
		commonFunction.projectSelection();
		map.clear();
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.KeyDate, testcaseName);
		log("navigating to Add Key Date");
		objKeyDate.addKeyDate(map,testcaseName);
	} else {
		log("Test case is not applicable for NEXTERA" + Status.SKIP);
	}
	}

}
