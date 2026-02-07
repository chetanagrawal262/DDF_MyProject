package testsuit.Legal;

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
import pages.Legal.AddCondemnationRecordPage;
import pages.Legal.DeleteCondemnationRecordPage;
import pages.Legal.EditCondemnationRecordPage;
import pages.Legal.LegalFormsPage;
import pages.Legal.LegalTabPage;
import pages.Legal.PendingLegalFormPage;

@Listeners(com.listeners.MyListeners.class)


public class LegalTabTest extends BasePage{

	LoginPage objLogin;
	LegalTabPage objLegalTab;
	AddCondemnationRecordPage objAddCondemnationRecord;
	EditCondemnationRecordPage objEditCondemnationRecord;
	DeleteCondemnationRecordPage objDeleteCondemnationRecord;
	PendingLegalFormPage objPendingLegalForm;
	LegalFormsPage objLegalForms;
	 ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
	
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objLegalTab = new LegalTabPage(driver);
			objAddCondemnationRecord = new AddCondemnationRecordPage(driver);
			objEditCondemnationRecord = new EditCondemnationRecordPage(driver);
			objDeleteCondemnationRecord = new DeleteCondemnationRecordPage(driver);
			objLegalForms = new LegalFormsPage(driver);
			objPendingLegalForm = new PendingLegalFormPage(driver);
		}
		
		
		@Test(priority=1)
		public void LegalTab_TC_01() throws Exception {
			log("TC01 : Legal Tab");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "LegalTab" + clientName;
			log("Data picked : " + testcaseName);
			objLegalTab.LegalTab(testcaseName);
			
		}
		
		@Test(priority=2)
		public void AddCondemnationRecord_TC_02() throws Exception {
			log("TC02 : Add Condemnation record");
			String testcaseName = "AddCondemnationRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddCondemnationRecord,testcaseName);
			objAddCondemnationRecord.AddCondemnationRecord(map, testcaseName);
			
		}
		
		@Test(priority=3)
		public void EditCondemnationRecord_TC_03() throws Exception {
			log("TC03 : Edit Condemnation record");
			String testcaseName = "EditCondemnationRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.EditCondemnationRecord,testcaseName);
			objEditCondemnationRecord.EditCondemnationRecord(map, testcaseName);
			
		}
		
		@Test(priority=4)
		public void DeleteCondemnationRecord_TC_04() throws Exception {
			log("TC04 : Delete Condemnation record");
			String testcaseName = "DeleteCondemnationRecord" + clientName;
			log("Data picked : " + testcaseName);
			objDeleteCondemnationRecord.DeleteCondemnationRecord(testcaseName);
			
		}
		
}
