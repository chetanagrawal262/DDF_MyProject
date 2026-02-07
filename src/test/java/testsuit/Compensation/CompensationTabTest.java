package testsuit.Compensation;

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
import pages.Compensation.AddPaymentObligationRecordPage;
import pages.Compensation.CompensationTabPage;
import pages.Compensation.DeletePaymentObligationRecordPage;
import pages.Compensation.EditPaymentObligationRecordPage;



@Listeners(com.listeners.MyListeners.class)

public class CompensationTabTest extends BasePage{

	 LoginPage objLogin;
	 CompensationTabPage objCompensationTab;
	 AddPaymentObligationRecordPage objAddPaymentObligationRecord;
	 EditPaymentObligationRecordPage objEditPaymentObligationRecord;
	 DeletePaymentObligationRecordPage objDeletePaymentObligationRecord;
		ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
	
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objCompensationTab = new CompensationTabPage(driver);
			objAddPaymentObligationRecord = new AddPaymentObligationRecordPage(driver);
			objEditPaymentObligationRecord = new EditPaymentObligationRecordPage(driver);
			objDeletePaymentObligationRecord = new DeletePaymentObligationRecordPage(driver);
		}
		
		@Test(priority=1)
		public void CompensationTab_TC_01() throws Exception {
			log("TC01 : Compensation Tab");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "CompensationTab" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.CompensationTab,testcaseName);
			objCompensationTab.CompensationTab(map, testcaseName);
			
		}
		
		@Test(priority=2)
		public void AddPaymentObligationRecord_TC_02() throws Exception {
			log("TC02 : Add Payment Obligation record");
			String testcaseName = "AddPaymentObligationRecord" + clientName;
			log("Data picked : " + testcaseName);
			if(!testcaseName.contains("TRA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddPaymentObligationRecord,testcaseName);
			objAddPaymentObligationRecord.AddPaymentObligationRecord(map, testcaseName);
			}else {
				log("Add Obligation Panel is not available on the TRA", Status.SKIP);
			}
			
		}
		
		@Test(priority=3)
		public void EditPaymentObligationRecord_TC_03() throws Exception {
			log("TC03 : Edit Payment Obligation Record");
			String testcaseName = "EditPaymentObligationRecord" + clientName;
			log("Data picked : " + testcaseName);
			if(!testcaseName.contains("TRA")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.EditPaymentObligationRecord,testcaseName);
			objEditPaymentObligationRecord.EditPaymentObligationRecord(map, testcaseName);
			}else {
				log("Add Obligation Panel is not available on the TRA", Status.SKIP);
			}
		}
		
		
//		@Test(priority=4)	
//		public void DeletePaymentObligationRecord_TC_04() throws Exception {
//			log("TC04 : Delete Payment Obligation Record");
//			String testcaseName = "DeletePaymentObligationRecord" + clientName;
//			log("Data picked : " + testcaseName);
//			if(!testcaseName.contains("TRA")) {
//			objDeletePaymentObligationRecord.DeleteCondemnationRecord(testcaseName);
//			}else {
//				log("Add Obligation Panel is not available on the TRA", Status.SKIP);
//			}
//		}
		
		
	
}
