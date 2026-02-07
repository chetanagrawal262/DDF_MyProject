package testsuit.AdministrationTemplate;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;

import page.Common.LoginPage;
import pages.AdministrationTemplate.AddNewTemplatePage;
import pages.AdministrationTemplate.EditNewTemplatePage;


@Listeners(com.listeners.MyListeners.class)
public class AddNewTemplateTest extends BasePage{

	LoginPage objLogin;
	AddNewTemplatePage objAddNewTemplate;
	EditNewTemplatePage objEditNewTemplate;
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddNewTemplate = new AddNewTemplatePage(driver);
		objEditNewTemplate = new EditNewTemplatePage(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Add_New_Template_TC_01() throws Exception {
		log("TC01 : Add a New Template");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddNewTemplate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.AddNewTemplate, testcaseName);
		objAddNewTemplate.AddNewTemplate(map, testcaseName);
	}
	
	@Test(priority = 2,enabled = true)
	public void Edit_New_Template_TC_02() throws Exception {
		log("TC02 : Edit a New Template");
		String testcaseName = "EditNewTemplate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.EditNewTemplate, testcaseName);
		objEditNewTemplate.EditNewTemplate(map, testcaseName);
	}
	
	@Test(priority = 3,enabled = true)
	public void Verify_New_Template_TC_03() throws Exception {
		log("TC03 : Document Generation As per upated Screening Option ");
		String testcaseName = "EditNewTemplate" + clientName;
		log("Data picked : " + testcaseName);
		objEditNewTemplate.verifyAsPerScreeningOption(testcaseName);
	}
	
}
