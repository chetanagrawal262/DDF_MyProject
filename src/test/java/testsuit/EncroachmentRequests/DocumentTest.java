package testsuit.EncroachmentRequests;

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
import pages.EncroachmentDocuments.DocumentPage;
import pages.EncroachmentDocuments.DocumentsHistoryPage;
import pages.EncroachmentDocuments.EditDocumentPage;



@Listeners(com.listeners.MyListeners.class)
public class DocumentTest extends BasePage{

	 LoginPage objLogin;
	 DocumentPage objDocument;
	 EditDocumentPage objEditDocument;
	 DocumentsHistoryPage objDocumentsHistory;
	 ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
	
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objDocument = new DocumentPage(driver);
			objEditDocument = new EditDocumentPage(driver);
			objDocumentsHistory = new DocumentsHistoryPage(driver);
		}
		
		@Test(priority=1)
		public void AddExternalDocument_TC_01() throws Exception {
			log("TC01 : Add a Document - External Document");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddDocument" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.AddDocument,testcaseName);
			objDocument.AddExternalDocument(map, testcaseName);
		}
		
		@Test(priority=2, enabled=true)
		public void AddDocumentExternalLink_TC_02() throws Exception {
			log("TC02 : Add a Document - External Link");
			String testcaseName = "AddDocumentExternalLink" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.AddDocumentExternalLink,testcaseName);
			objDocument.AddExternalLink(map, testcaseName);
		}
		
		@Test(priority=3, enabled=true)
		public void ViewDocument_TC_03() throws Exception {
			log("TC03 : View Document");
			String testcaseName = "AddDocumentExternalLink" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.AddDocumentExternalLink,testcaseName);
			objDocument.ViewDocument(map,testcaseName);
		}
		
		@Test(priority=4, enabled=true)
		public void EditDocument_TC_04() throws Exception {
			log("TC04 : Edit Document");
			String testcaseName = "EditDocument" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.EditDocument,testcaseName);
			objEditDocument.EditDocument(map, testcaseName);
		}

		@Test(priority=5, enabled=true)
		public void AddDocumentsVersion_TC_05() throws Exception {
			log("TC05 : Add Documents Version");
			String testcaseName = "AddDocument" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.AddDocument,testcaseName);
			objDocument.AddDocumentsVersion(map, testcaseName);
		}
		
		@Test(priority=6, enabled=true)
		public void DocumentsHistory_TC_06() throws Exception {
			log("TC06: Documents History");
			String testcaseName = "EditDocument" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.EditDocument,testcaseName);
			objDocumentsHistory.DocumentsHistory(map,testcaseName);
		}
		
		
		@Test(priority=7)
		public void RequestDeleteDocument_TC_07() throws Exception {
			log("TC 07 : Request Delete Document");
			String testcaseName = "EditDocument" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.EditDocument,testcaseName);
			objDocument.DeleteDocument(map, testcaseName);
		}
	
}
