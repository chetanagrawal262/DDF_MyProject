package testsuit.LandownerSearch;

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
import pages.LandownerSearch.LandownerPage;
import pages.LandownerSearch.MergeLOPage;
import pages.LandownerSearch.ParcelInformation_AddNewParcelPage;


@Listeners(com.listeners.MyListeners.class)
public class LandownerMergeTest extends BasePage{
	LoginPage objLogin;
	LandownerPage objAddLandowner;
	MergeLOPage objMergeLO;
	ParcelInformation_AddNewParcelPage objAddParcel;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddLandowner = new LandownerPage(driver);
		objMergeLO = new MergeLOPage(driver);
		objAddParcel = new ParcelInformation_AddNewParcelPage(driver);
	}
	
	@Test(priority=1, enabled=true)
	public void addTwoNewParcels_TC_01() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("ATWELL") & !environment.contains("ORION") & !environment.contains("VALARD")) {
		log("TC01 : Add Two new Parcel");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddParcel" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LANDOWNER_SEARCH_TEST_DATA), Excel.AddParcel,testcaseName);
		objAddParcel.AddParcel(map, testcaseName);
		}else {
			log("Landowner Search not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 2, enabled = true)
	public void AddLandownersAndContact_TC_02() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("ATWELL") & !environment.contains("ORION") & !environment.contains("VALARD")) {
		log("TC02 : Add Landowners on both parcels");
		for (int i = 1; i < ExcelUtils.totalRows - 1; i++) {
			String testcaseName = "AddLandowner"+i;
			String clientVerticalName = clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LANDOWNER_SEARCH_TEST_DATA), Excel.Landowner, testcaseName);
			objAddLandowner.AddLandowner(map, testcaseName, clientVerticalName);
		}
	}else {
		log("Landowner Search not applicable for this client", Status.SKIP);
	}
	}

	@Test(priority = 3, enabled=true)
	public void LandownerSearch_TC_03() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("ATWELL") & !environment.contains("ORION") & !environment.contains("VALARD")) {
	    log("TC03 : Tools-Landowner search");
	    String testcaseName = "LandownerSearch" + clientName;
	    log("Data picked : " + testcaseName);
	    map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LANDOWNER_SEARCH_TEST_DATA), Excel.Searches, testcaseName);
	    objMergeLO.searchRecord(map, testcaseName);	
	}else {
		log("Landowner Search not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority = 4, enabled=true)
	public void MergeLandownerAndContact_TC_04() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("ATWELL") & !environment.contains("ORION") & !environment.contains("VALARD")) {
	    log("TC04 : Merge Landowner");
	    String testcaseName = "LandownerSearch" + clientName;
	    log("Data picked : " + testcaseName);
	    objMergeLO.mergeRecord(testcaseName);
	    objAddLandowner.verifyMergedLandowner(testcaseName);
	}else {
		log("Landowner Search not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority=5, enabled=true, description="Bug- 112854")
	public void verifySameEntityOnMultipleParcels_TC_05() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("TRA") & !environment.contains("ATWELL") & !environment.contains("ORION") & !environment.contains("VALARD") & !environment.contains("DOM")) {
		String testcaseName = "AddEntity" + clientName;
		 objAddLandowner.addSameEntityOnMultipleParcels(testcaseName);
		}else {
			log("This TC not applicable for this client", Status.SKIP);
		}
	}
	
}
