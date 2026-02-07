package testsuit.ProjectDocuments;

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
import pages.ProjectDocuments.AddDocumentExternalLinkPage;
import pages.ProjectDocuments.AddDocumentPage;
import pages.ProjectDocuments.AddDocumentsVersionPage;
import pages.ProjectDocuments.ApplicationBehaviourSettingsPage;
import pages.ProjectDocuments.DeleteDocumentsPage;
import pages.ProjectDocuments.DocumentsHistoryPage;
import pages.ProjectDocuments.DownloadAllDocumentsPage;
import pages.ProjectDocuments.EditDocumentPage;
import pages.ProjectDocuments.ViewDocumentPage;



@Listeners(com.listeners.MyListeners.class)
public class AddDocumentTest extends BasePage{

	 LoginPage objLogin;
	 AddDocumentPage objAddDocument;	
	 AddDocumentExternalLinkPage objAddDocumentExternalLink;
	 ViewDocumentPage objViewDocument;
	 EditDocumentPage objEditDocument;
	 DeleteDocumentsPage objDeleteDocuments;
	 DownloadAllDocumentsPage objDownloadAllDocuments;
	 DocumentsHistoryPage objDocumentsHistory;
	 AddDocumentsVersionPage objAddDocumentsVersion;
	 ApplicationBehaviourSettingsPage objABS;
	 ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
	
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objAddDocument = new AddDocumentPage(driver);
			objAddDocumentExternalLink = new AddDocumentExternalLinkPage(driver);
			objViewDocument = new ViewDocumentPage(driver);
			objEditDocument = new EditDocumentPage(driver);
			objDeleteDocuments = new DeleteDocumentsPage(driver);
			objDownloadAllDocuments = new DownloadAllDocumentsPage(driver);
			objDocumentsHistory = new DocumentsHistoryPage(driver);
			objAddDocumentsVersion = new AddDocumentsVersionPage(driver);
			objABS = new ApplicationBehaviourSettingsPage(driver);
		}
		
		@Test(priority=1, enabled=true)
		public void DOCDRAFTFINAL_DoExecutionDate_TRUE_TC_01() throws Exception {
			log("TC1 : Doc Draft Final  and Doc Execution Date key settings set to 'True'  ");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.loginWithSuperAdmin(map);
			String testcaseName = "AddDocument" + clientName;
			if(!testcaseName.contains("DOT")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AddDocument,
					testcaseName);
			objABS.SetDocDraftFinalSetting(map, testcaseName, "True");
			}else {
				log("This Test Case not applicable for the DOT" ,Status.SKIP);
			}
		}
		
		@Test(priority=2)
		public void AddDocument_TC_02() throws Exception {
			log("TC02 : Add a Document - External Document");
			String testcaseName = "AddDocument" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AddDocument,testcaseName);
			objAddDocument.AddDocument(map, testcaseName);
			
		}
		
		@Test(priority=3, enabled=true)
		public void AddDocumentExternalLink_TC_03() throws Exception {
			log("TC03 : Add a Document - External Link");
			String testcaseName = "AddDocumentExternalLink" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AddDocumentExternalLink,testcaseName);
			objAddDocumentExternalLink.AddDocumentExternalLink(map, testcaseName);
			
		}
		
		@Test(priority=4, enabled=false, description="This test case is not applicable for edge browser")
		public void ViewDocument_TC_04() throws Exception {
			log("TC04 : View Document");
			String testcaseName = "AddDocumentExternalLink" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AddDocumentExternalLink,testcaseName);
			objViewDocument.ViewDocument(map,testcaseName);
			
		}
		
		@Test(priority=5, enabled=true)
		public void EditDocument_TC_05() throws Exception {
			log("TC05 : Edit Document");
			String testcaseName = "EditDocument" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.EditDocument,testcaseName);
			objEditDocument.EditDocument(map, testcaseName);
			
			
		}

		@Test(priority=6, enabled=true)
		public void DownloadAllDocuments_TC_06() throws Exception {
			log("TC06 : Download All Documents");
			String testcaseName = "DownloadAllDocuments" + clientName;
			log("Data picked : " + testcaseName);
			objDownloadAllDocuments.DownloadAllDocuments(testcaseName);
			
		}
		
		@Test(priority=7, enabled=true)
		public void DOCDRAFTFINAL_DoExecutionDate_FALSE_TC_07() throws Exception {
			log("TC 7 : Doc Draft Final  and Doc Execution Date key settings set to 'False'  ");
			String testcaseName = "AddDocument" + clientName;
			if(!testcaseName.contains("DOT")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AddDocument,
					testcaseName);
			objABS.SetDocDraftFinalSetting(map, testcaseName, "False");
			}else {
				log("This Test Case not applicable for the DOT" ,Status.SKIP);
			}
		}


		@Test(priority=8, enabled=true)
		public void AddDocumentsVersion_TC_08() throws Exception {
			log("TC08 : Add Documents Version");
			String testcaseName = "AddDocumentsVersion" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AddDocumentsVersion,testcaseName);
			objAddDocumentsVersion.AddDocumentsVersion(map, testcaseName);
			
		}
		
		@Test(priority=9, enabled=true)
		public void DocumentsHistory_TC_09() throws Exception {
			log("TC09 : Documents History");
			String testcaseName = "EditDocument" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.EditDocument,testcaseName);
			objDocumentsHistory.DocumentsHistory(map,testcaseName);
			
		}
		
		
		@Test(priority=10)
		public void DeleteDocument_TC_10() throws Exception {
			log("TC 10 : Delete Document");
			String testcaseName = "DeleteDocuments" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.DeleteDocument,testcaseName);
			objDeleteDocuments.DeleteDocument(map, testcaseName);
			
		}
	
}
