package testsuit.Acquistion;

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
import pages.Acquistion.AcquistionTabPage;
import pages.Acquistion.DomAgreementManagementPage;

@Listeners(com.listeners.MyListeners.class)
public class DOM_AcquistionTest extends BasePage{
 
	LoginPage objLogin;
	AcquistionTabPage objAcquistionTab;
	DomAgreementManagementPage objAddAgreementManagement;
	
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAcquistionTab = new AcquistionTabPage(driver);
		objAddAgreementManagement = new DomAgreementManagementPage(driver);
	}
	
	@Test(priority =1 )
	public void AcquistionTab_TC_01() throws Exception {
		log("TC01 :Acquistion Tab ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AcquistionTab" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AcquistionTab,testcaseName);
		objAcquistionTab.AcquistionTab(map, testcaseName);
   }
	
	@Test(priority =2 )
	public void AddAgreementManagement_TC_02() throws Exception {
		log("TC02 :Add Agreement Management	");
		String testcaseName = "AddAgreementManagement" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AgreementManagementDOM,testcaseName);
		objAddAgreementManagement.AddAgreementManagement(map, testcaseName);
	}
	
	@Test(priority =3 )
	public void EditAgreementManagement_TC_03() throws Exception {
		log("TC03 :Edit Agreement Management	");
		String testcaseName = "AddAgreementManagement" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AgreementManagementDOM,testcaseName);
		objAddAgreementManagement.EditAgreementManagement(map, testcaseName);
	}
	
	@Test(priority =4 )
	public void LinkAssets_TC_04() throws Exception {
		log("TC04 : Link Assets");
		String testcaseName = "AddAgreementManagement" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AgreementManagementDOM,testcaseName);
		objAddAgreementManagement.AddLinkAssets(map, testcaseName);
	}
	
	@Test(priority =5 )
	public void AddRecordingInfo_TC_05() throws Exception {
		log("TC05 : Add Recording Info");
		String testcaseName = "AddAgreementManagement" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AgreementManagementDOM,testcaseName);
		objAddAgreementManagement.AddRecordingInfo(map, testcaseName);
	}
	
	
}
