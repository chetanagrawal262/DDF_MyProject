package testsuit.Negotiations;

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
import pages.Negotiations.EditLandInventoryPage;
import pages.Negotiations.LandInventory_AddLandInventoryPage;
import pages.Negotiations.LandInventory_DeleteLandInventoryPage;
import pages.Negotiations.NegotiationsTabPage;
@Listeners(com.listeners.MyListeners.class)
public class NegotiationsTabTest extends BasePage
{
	
	LoginPage objLogin;
	NegotiationsTabPage objNegotiations;
	LandInventory_AddLandInventoryPage objAddLandInventory;
	EditLandInventoryPage objEditLandInventory;
	LandInventory_DeleteLandInventoryPage objDeleteLandInventory;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objNegotiations = new NegotiationsTabPage(driver);
		objAddLandInventory = new LandInventory_AddLandInventoryPage(driver);
		objEditLandInventory= new EditLandInventoryPage(driver);
		objDeleteLandInventory = new LandInventory_DeleteLandInventoryPage(driver);
	}
	

	@Test(priority =1 )
	public void NegotiationsTab_TC_01() throws Exception {
		log("TC01 :Negotiations Tab ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "Negotiations" + clientName;
		log("Data picked : " + testcaseName);
		objNegotiations.Negotiations(testcaseName);
	}
	
	@Test(priority =2 )
	public void AddLandInventory_TC_02() throws Exception {
		log("TC02 : Add Land Inventory and Easements record ");
		String testcaseName = "AddLandInventory" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddLandInventory, testcaseName);
		objAddLandInventory.AddLandInventory(map, testcaseName);
	}
	
	@Test(priority =3 )
	public void EditLandInventory_TC_03() throws Exception {
		log("TC02 : Edit Land Inventory and Easements record ");
		String testcaseName = "EditLandInventory" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.EditLandInventory, testcaseName);
		objEditLandInventory.EditLandInventory(map, testcaseName);
	}
	
	@Test(priority =4 )
	public void DeleteLandInventory_TC_04() throws Exception {
		log("TC04 : Delete Land Inventory and Easements record ");
		String testcaseName = "AddLandInventory" + clientName;
		log("Data picked : " + testcaseName);
		objDeleteLandInventory.DeleteLandInventory(testcaseName);
	}
	
}
