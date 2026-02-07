package testsuit.AdministrationConfiguration;

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
import pages.Administration.AddNewDropDownPage;


@Listeners(com.listeners.MyListeners.class)

public class AddNewDropDownTest extends BasePage{

	 LoginPage objLogin;
	 AddNewDropDownPage objDropDown;	
	 ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
		
		
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objDropDown = new AddNewDropDownPage(driver);
			

		}
		
		@Test(priority=1)
		public void Add_New_Drop_Down_TC_01() throws Exception {
			log("TC01 : Add a New Drop Down");
			if (!environment.contains("PRIMERGY")){
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddNewDropDown" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.DropDown,testcaseName);
			objDropDown.AddNewDropDown(map, testcaseName);
			}else {
				log("dropdown is not applicable for this client", Status.SKIP);
			}
		}
		
}
