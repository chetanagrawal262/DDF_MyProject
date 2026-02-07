package testsuit.CustomControl;

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
import page.Common.LoginPage;
import pages.CustomControl.CustomControl_RADIOFieldPage;
import pages.CustomControl.CustomControl_TEXTFieldPage;
import pages.CustomControl.ParcelSearch_CustomControlPage;
import pages.CustomControl.ProjectSearch_CustomControlPage;

@Listeners(com.listeners.MyListeners.class)

public class SearchableCustomControlFieldsTest extends BasePage{

	CommonFunction commonFunction;
	LoginPage objLogin;
	CustomControl_TEXTFieldPage objCustomControlTEXT;
	ParcelSearch_CustomControlPage objParcelSearch_CustomControlPage;
	CustomControl_RADIOFieldPage objCustomControlRADIO;
	ProjectSearch_CustomControlPage objProjectSearch_CustomControlPage;
	
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		commonFunction = new CommonFunction(driver);
		objLogin = new LoginPage(driver);
		objCustomControlTEXT = new CustomControl_TEXTFieldPage(driver);
		objParcelSearch_CustomControlPage = new ParcelSearch_CustomControlPage(driver);
		objCustomControlRADIO = new CustomControl_RADIOFieldPage(driver);
		objProjectSearch_CustomControlPage = new ProjectSearch_CustomControlPage(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Add_CustomField_Parcel_Information_TC_01() throws Exception {
		if(!environment.contains("VALARD")) {
		log("TC01 : add Searchable TEXT Custom control field on the parcel Information ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "CustomControl_TEXT_"+clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.SearchableCustomControlParcel, testcaseName);
		commonFunction.navigateParcelInformation();
		commonFunction.TurnOnDesignMode();
		objCustomControlTEXT.CustomControl(map, testcaseName);
		}else {
			log("Skipping Testcase as Custom Control is not available for VALARD client", Status.SKIP);
		}
	}
	
	@Test(priority = 2,enabled = true)
	public void VerifyCustomControlOnParcelSearch_TC_02() throws Exception {
		if(!environment.contains("VALARD")) {
		log("TC02 : verify Custom Control On Parcel Search ");
		String testcaseName = "CustomControl_TEXT_"+clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.SearchableCustomControlParcel, testcaseName);
		objParcelSearch_CustomControlPage.verifyParcelSearch(map, testcaseName);
		}else {
			log("Skipping Testcase as Custom Control is not available for VALARD client", Status.SKIP);
		}
	}
	
	@Test(priority = 3,enabled = true)
	public void Add_CustomField_ProjectDetails_TC_03() throws Exception {
		if(!environment.contains("VALARD")) {
		log("TC03 : add Custom Control RADIO on the Project details  ");
    	String testcaseName = "CustomControl_RADIO_"+clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.SearchableCustomControlProject, testcaseName);
		commonFunction.navigateToProjectDeails();
		objCustomControlRADIO.CustomControl(map, testcaseName);
		}else {
			log("Skipping Testcase as Custom Control is not available for VALARD client", Status.SKIP);
		}
	}
	
	@Test(priority = 4,enabled = true)
	public void VerifyCustomControlOnProjectSearch_TC_04() throws Exception {
		if(!environment.contains("VALARD")) {
		log("TC04 : verify Custom Control On Project Search ");
		String testcaseName = "CustomControl_RADIO_"+clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.SearchableCustomControlProject, testcaseName);
		objProjectSearch_CustomControlPage.verifyProjectSearch(map, testcaseName);
		}else {
			log("Skipping Testcase as Custom Control is not available for VALARD client", Status.SKIP);
		}
	}
	
}

