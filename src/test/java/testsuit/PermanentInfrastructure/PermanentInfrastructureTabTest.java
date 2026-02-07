package testsuit.PermanentInfrastructure;

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
import pages.PermanentInfrastructure.AddEasementDetailsPage;
import pages.PermanentInfrastructure.AddMetTowerRecordPage;
import pages.PermanentInfrastructure.AddStructuresRecordPage;
import pages.PermanentInfrastructure.AddTurbineRecordPage;
import pages.PermanentInfrastructure.DeleteEasementDetailsPage;
import pages.PermanentInfrastructure.DeleteMetTowerRecordPage;
import pages.PermanentInfrastructure.DeleteStructureRecordPage;
import pages.PermanentInfrastructure.DeleteTurbineRecordPage;
import pages.PermanentInfrastructure.EditEasementDetailsPage;
import pages.PermanentInfrastructure.EditMetTowerRecordPage;
import pages.PermanentInfrastructure.EditStructureRecordPage;
import pages.PermanentInfrastructure.EditTurbineRecordPage;
import pages.PermanentInfrastructure.PermanentInfrastructureTabPage;

@Listeners(com.listeners.MyListeners.class)
public class PermanentInfrastructureTabTest extends BasePage{

	LoginPage objLogin;
	PermanentInfrastructureTabPage objPermanentInfrastructure;
	AddTurbineRecordPage objAddTurbineRecord;
	EditTurbineRecordPage objEditTurbineRecord;
	DeleteTurbineRecordPage objDeleteTurbineRecord;
	AddEasementDetailsPage objAddEasementDetails;
	EditEasementDetailsPage objEditEasementDetails;
	DeleteEasementDetailsPage objDeleteEasementDetails;
	AddMetTowerRecordPage objAddMetTowerRecord;
	EditMetTowerRecordPage objEditMetTowerRecord;
	DeleteMetTowerRecordPage objDeleteMetTowerRecord;
	AddStructuresRecordPage objAddStructuresRecord;
	EditStructureRecordPage objEditStructuresRecord;
	DeleteStructureRecordPage objStructureRecord;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objPermanentInfrastructure = new PermanentInfrastructureTabPage(driver);
		objAddTurbineRecord = new AddTurbineRecordPage(driver);
		objEditTurbineRecord = new EditTurbineRecordPage(driver);
		objDeleteTurbineRecord = new DeleteTurbineRecordPage(driver);
		objAddEasementDetails = new AddEasementDetailsPage(driver);
		objEditEasementDetails = new EditEasementDetailsPage(driver);
		objDeleteEasementDetails = new DeleteEasementDetailsPage(driver);
		objAddMetTowerRecord = new AddMetTowerRecordPage(driver);
		objEditMetTowerRecord = new EditMetTowerRecordPage(driver);
		objDeleteMetTowerRecord = new DeleteMetTowerRecordPage(driver);
		objAddStructuresRecord = new AddStructuresRecordPage(driver);
		objEditStructuresRecord = new EditStructureRecordPage(driver);
		objStructureRecord = new DeleteStructureRecordPage(driver);
	}
	
	@Test(priority =1)
	public void PermanentInfrastructureTab_TC_01() throws Exception {
		if(!environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC01 : Permanent Infrastructure Tab");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "PermanentInfrastructureTab" + clientName;
		log("Data picked : " + testcaseName);
		objPermanentInfrastructure.PermanentInfrastructureTab(testcaseName);
		}else {
			log("Permanent Infrastructure not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =2, enabled=true)
	public void AddTurbineRecord_TC_02() throws Exception {
		if(!environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC02 : Add Turbine record");
		String testcaseName = "AddTurbineRecord" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddTurbineRecord, testcaseName);
		objAddTurbineRecord.AddTurbineRecord(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =3, enabled=true)
	public void EditTurbineRecord_TC_03() throws Exception {
		if(!environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC03 : Add Turbine record");
		String testcaseName = "EditTurbineRecord" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.EditTurbineRecord, testcaseName);
		objEditTurbineRecord.EditTurbineRecord(map, testcaseName);
	}else {
		log("This TC is not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority = 4, enabled=true)
	public void AddEasementDetails_TC_04() throws Exception {
		if(!environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC04 : Add Easement Details");
		String testcaseName = "AddEasementDetails" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddEasementDetails, testcaseName);
		objAddEasementDetails.AddEasementDetails(map, testcaseName);
		}else {
			log("Permanent Infrastructure not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =5, enabled=true)
	public void EditEasementDetails_TC_05() throws Exception {
		if(!environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC05 : Edit Easement Details");
		String testcaseName = "EditEasementDetails" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.EditEasementDetails, testcaseName);
		objEditEasementDetails.EditEasementDetails(map, testcaseName);
		}else {
			log("Permanent Infrastructure not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =6, enabled=true)
	public void DeleteEasementDetails_TC_06() throws Exception {
		if(!environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC06 : Delete Easement Details");
		String testcaseName = "DeleteEasementDetails" + clientName;
		log("Data picked : " + testcaseName);
		objDeleteEasementDetails.DeleteEasementDetails(testcaseName);
	}else {
		log("Permanent Infrastructure not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority = 7, enabled=true)
	public void AddMetTowerRecord_TC_07() throws Exception {
		if(!environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC07 : Add Met Tower record");
		String testcaseName = "AddMetTowerRecord" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddMetTowerRecord, testcaseName);
		objAddMetTowerRecord.AddMetTowerRecord(map, testcaseName);
	}else {
		log("Permanent Infrastructure not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority =8, enabled=true)
	public void EditMetTowerRecord_TC_08() throws Exception {
		if(!environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC08 : Edit  Met Tower record");
		String testcaseName = "EditMetTowerRecord" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.EditMetTowerRecord, testcaseName);
		objEditMetTowerRecord.EditMetTowerRecord(map, testcaseName);
		}else {
			log("Permanent Infrastructure not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =9, enabled=true)
	public void DeleteMetTowerRecord_TC_09() throws Exception {
		if(!environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC09 : Delete Met Tower record");
		String testcaseName = "DeleteMetTowerRecord" + clientName;
		log("Data picked : " + testcaseName);
		objDeleteMetTowerRecord.DeleteMetTowerRecord(testcaseName);
		}else {
			log("Permanent Infrastructure not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 10, enabled=true)
	public void AddStructuresRecord_TC_10() throws Exception {
		if(environment.contains("ATWELL")) {
		log("TC 10 : Add Structures record");
		String testcaseName = "AddStructureRecord" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddStructureRecord, testcaseName);
		objAddStructuresRecord.AddStructureRecord(map, testcaseName);
	}else {
		log("Structure Panel TC not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority =11, enabled=true)
	public void EditStructuresRecord_TC_11() throws Exception {
		if(environment.contains("ATWELL")) {
		log("TC 11 : Edit  Structures record");
		String testcaseName = "EditStructureRecord" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.EditStructureRecord, testcaseName);
		objEditStructuresRecord.EditStructureRecord(map, testcaseName);
		}else {
			log("Structure Panel TC not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority =12, enabled=true)
	public void DeleteMetTowerRecord_TC_12() throws Exception {
		if(environment.contains("ATWELL")) {
		log("TC 12 : Delete Structures record");
		String testcaseName = "DeleteStructuresRecord" + clientName;
		objStructureRecord.DeleteStructureRecord(testcaseName);
		}else {
			log("Structure Panel TC not applicable for this client", Status.SKIP);
		}
	}
	
}
