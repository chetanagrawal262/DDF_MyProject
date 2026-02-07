package testsuit.agreementManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.agreementManager.AddNewAgreementForPrecision;
import pages.agreementManager.OwnershipAndAcresPrecisionPage;

@Listeners(com.listeners.MyListeners.class)
public class OwnershipAndAcresPrecisionTest extends BasePage {

	LoginPage objLogin;
	OwnershipAndAcresPrecisionPage ObjPrecision;
	AddNewAgreementForPrecision objAddInfo;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	public static String AGREEMENT_NUMBER; 
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		ObjPrecision = new OwnershipAndAcresPrecisionPage(driver);
		objAddInfo = new AddNewAgreementForPrecision(driver);
	}

	//#69807 , #70564
	@Test(priority=1, enabled=true)
	public void Ownership_Acres_Precision_ABS_TC_01() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC01 : check Ownership Precision and Acres Precision value");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "PrecisionValue" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.PrecisionInfo, testcaseName);
		ObjPrecision.checkPrecisionValue(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 2,enabled = true )
	public void Add_Agreement_TC_02() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC02 : Add a New Agreement ");
		String testcaseName = "AddAgreementInformation" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AgreementInfo, testcaseName);
		objAddInfo.addAgreementInformation(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 3,enabled = true)
	public void Add_Payee_Information_TC_03() throws Exception {
		if(!environment.contains("VERDANTERRA")) {
		log("TC03 : Add Payee Information ");
		String testcaseName = "PrecisionValue" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.PrecisionInfo, testcaseName);
		ObjPrecision.addPayeeInformation(map, testcaseName);	
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
}
