package testsuit.Survey;

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

import pages.Survey.AddDrawingTrackingRecordPage;
import pages.Survey.AddSurveyRestrictionsRecordsPage;
import pages.Survey.DeleteDrawingTrackingRecordPage;
import pages.Survey.DeleteSurveyRestrictionsRecordPage;
import pages.Survey.EditDrawingTrackingrecordPage;

import pages.Survey.EditSurveyRestrictionsRecordPage;

import pages.Survey.SurveyDocumentsPage;
import pages.Survey.SurveyRevisionsPage;
import pages.Survey.SurveyTabPage;
import pages.Survey.SurveyTitleChainPage;
import pages.Survey.SurveyTrackingPage;

@Listeners(com.listeners.MyListeners.class)
public class AddDrawingTrackingRecordTest extends BasePage {

	 LoginPage objLogin;
	 SurveyTabPage objSurveyTab;
	 AddDrawingTrackingRecordPage objAddDrawingTracking;
	 EditDrawingTrackingrecordPage objEditDrawingTracking;
	 DeleteDrawingTrackingRecordPage objDeleteDrawingTracking;
	 AddSurveyRestrictionsRecordsPage objAddSurveyRestrictions;
	 EditSurveyRestrictionsRecordPage objEditSurveyRestrictions;
	 DeleteSurveyRestrictionsRecordPage objDeleteSurveyRestrictionsRecord;
	 SurveyRevisionsPage objSurveyRevisions;

	 SurveyTrackingPage objSurveyTracking;

	 SurveyDocumentsPage objSurveyDocuments;
	 SurveyTitleChainPage objSurveyTitleChain;
		ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
	
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objSurveyTab = new SurveyTabPage(driver);
			objAddDrawingTracking = new AddDrawingTrackingRecordPage(driver);
			objEditDrawingTracking = new EditDrawingTrackingrecordPage(driver);
			objDeleteDrawingTracking = new DeleteDrawingTrackingRecordPage(driver);
			objAddSurveyRestrictions = new AddSurveyRestrictionsRecordsPage(driver);
			objEditSurveyRestrictions = new EditSurveyRestrictionsRecordPage(driver);
			objDeleteSurveyRestrictionsRecord = new DeleteSurveyRestrictionsRecordPage(driver);

			objSurveyTracking = new SurveyTrackingPage(driver);
			objSurveyRevisions = new SurveyRevisionsPage(driver);
		
			objSurveyDocuments = new SurveyDocumentsPage(driver);
			objSurveyTitleChain = new SurveyTitleChainPage(driver);

		}
		
		@Test(priority=1)
		public void SurveyTab_TC_01() throws Exception {
			if(!environment.contains("WSBALT") & !environment.contains("VALARD")) {
			log("TC01 : Survey Tab-Parcel Information/MTA item information");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "SurveyTab" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.SurveyTab,testcaseName);
			objSurveyTab.SurveyTab(map, testcaseName);
			}else {
				log("Survey Tab not applicable for this client", Status.SKIP);
			}
		}
		
		
		@Test(priority=2, enabled=true)
		public void AddDrawingTrackingRecord_TC_02() throws Exception {
			if(!environment.contains("WSBALT") & !environment.contains("VALARD")) {
			log("TC02 : Survey Tab-Parcel Information/MTA item information");
			String testcaseName = "AddDrawingTrackingRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddDrawingTrackingRecord,testcaseName);
			objAddDrawingTracking.AddDrawingTrackingRecord(map, testcaseName);
			}else {
				log("Survey Tab not applicable for this client", Status.SKIP);
			}
		}

		@Test(priority=3, enabled=true)
		public void EditDrawingTrackingrecord_TC_03() throws Exception {
			if(!environment.contains("WSBALT") & !environment.contains("VALARD")) {
			log("TC03 : Edit Drawing Tracking record");
			String testcaseName = "EditDrawingTrackingrecord" + clientName;
			log("Data picked : " + testcaseName);
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.EditDrawingTrackingRecord,testcaseName);
				objEditDrawingTracking.EditDrawingTrackingrecord(map, testcaseName);			
		}else {
			log("Survey Tab not applicable for this client", Status.SKIP);
		}
		}
		
		@Test(priority=4, enabled=true)
		public void DeleteDrawingTrackingRecord_TC_04() throws Exception {
			if(!environment.contains("WSBALT") & !environment.contains("VALARD")) {
			log("TC04 : Delete Drawing Tracking record");
			String testcaseName = "DeleteDrawingTrackingRecord" + clientName;
			log("Data picked : " + testcaseName);
				objDeleteDrawingTracking.DeleteDrawingTrackingRecord(testcaseName);
			}else {
				log("Survey Tab not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=5, enabled=true)
		public void AddSurveyRestrictionsRecords_TC_05() throws Exception {
			if(!environment.contains("PRIMERGY") & !environment.contains("WSBALT") & !environment.contains("VALARD")) {
			log("TC05 : Add Survey Restrictions record");
			String testcaseName = "AddSurveyRestrictionsRecords" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddSurveyRestrictionsRecords,testcaseName);
			objAddSurveyRestrictions.AddSurveyRestrictionsRecords(map, testcaseName);
			}else {
				log("Survey Tab not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=6, enabled=true)
		public void EditSurveyRestrictionsRecords_TC_06() throws Exception {
			if(!environment.contains("PRIMERGY") & !environment.contains("WSBALT") & !environment.contains("VALARD")) {
			log("TC06 :Edit Survey Restrictions record");
			String testcaseName = "EditSurveyRestrictionsRecords" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.EditSurveyRestrictionsRecords,testcaseName);
			objEditSurveyRestrictions.EditSurveyRestrictionsRecords(map, testcaseName);	
			}else {
				log("Survey Tab not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=7, enabled=true)
		public void DeleteSurveyRestrictionsRecord_TC_07() throws Exception {
			if(!environment.contains("PRIMERGY") & !environment.contains("WSBALT") & !environment.contains("VALARD")) {
			log("TC07 : Delete Survey Restrictions Record");
			String testcaseName = "DeleteSurveyRestrictionsRecord" + clientName;
			log("Data picked : " + testcaseName);
			objDeleteSurveyRestrictionsRecord.DeleteSurveyRestrictionsRecords(testcaseName);
			}else {
				log("Survey Tab not applicable for this client", Status.SKIP);
			}
		}
		

}
