package testsuit.ProjectNotes;

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
import pages.ProjectNotes.DeleteNotesPage;
import pages.ProjectNotes.RemoveDocumentPage;
import pages.ProjectNotes.AddDocumentExternalLinkPage;
import pages.ProjectNotes.AddProjectNotesPage;
import pages.ProjectNotes.AddViewDocumentLinkPage;
import pages.ProjectNotes.DownloadAllDocumentPage;
import pages.ProjectNotes.EditProjectNotesPage;


@Listeners(com.listeners.MyListeners.class)
public class AddProjectNotesTest extends BasePage{

	 LoginPage objLogin;
	 AddProjectNotesPage objAddProjectNotes;
	 EditProjectNotesPage objEditProjectNotes;
	 AddViewDocumentLinkPage objAddViewDocumentLink;
	 AddDocumentExternalLinkPage objAddDocumentExternalLink;
	 DownloadAllDocumentPage objDownloadAllDocuments;
	 DeleteNotesPage objDeleteNotes;
	 RemoveDocumentPage objRemoveDocument;
		ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
	
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objAddProjectNotes = new AddProjectNotesPage(driver);
			objEditProjectNotes = new EditProjectNotesPage(driver);
			objAddViewDocumentLink = new AddViewDocumentLinkPage(driver);
			objAddDocumentExternalLink = new AddDocumentExternalLinkPage(driver);
			objDownloadAllDocuments = new DownloadAllDocumentPage(driver);
			objDeleteNotes = new DeleteNotesPage(driver);
			objRemoveDocument = new RemoveDocumentPage(driver);
		}
		
		@Test(priority=1)
		public void AddProjectNotes_TC_01() throws Exception {
			log("TC01 : Add Project Notes");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddProjectNotes" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AddProjectNotes,testcaseName);
			objAddProjectNotes.AddProjectNotes(map, testcaseName);
			
		}
		

		@Test(priority=2, enabled=true)
		public void EditProjectNotes_TC_02() throws Exception {
			log("TC02 : Edit Project Notes");
			String testcaseName = "EditProjectNotes" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.EditProjectNotes,testcaseName);
			objEditProjectNotes.EditProjectNotes(map, testcaseName);
			
		}
		
		@Test(priority=3, enabled=true)
		public void AddViewDocumentLink_TC_03() throws Exception {
			if(!environment.contains("ATWELL")) {
			log("TC03 : Add/View Document Link ");
			String testcaseName = "AddViewDocumentLink" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AddViewDocumentLink,testcaseName);
			objAddViewDocumentLink.AddViewDocumentLink(map, testcaseName);
			}else {
				log("Approving the Note for atwell in the previous tc", Status.SKIP);
			}
		}
		
		@Test(priority=4, enabled=true)
		public void AddDocumentExternalLink_TC_04() throws Exception {
			if(!environment.contains("ATWELL")) {
			log("TC04 : Add a Document - External Link ");
			String testcaseName = "AddDocumentExternalLink" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AddDocumentExternalLink,testcaseName);
			objAddDocumentExternalLink.AddDocumentExternalLink(map, testcaseName);
			}else {
				log("Approving the Note for atwell in the previous tc", Status.SKIP);
			}
		}

//		@Test(priority=5, enabled=true)
//		public void DownloadAllDocument_TC_05() throws Exception {
//			log("TC05 : Download All Document  ");
//			String testcaseName = "DownloadAllDocument" + clientName;
//			log("Data picked : " + testcaseName);
//				objDownloadAllDocuments.DownloadAllDocument(testcaseName);
//			
//			
//		}
		
		@Test(priority=6, enabled=true)
		public void RemoveDocument_TC_06() throws Exception {
			if(!environment.contains("ATWELL")) {
			log("TC06 :Remove document");
			String testcaseName = "RemoveDocument" + clientName;
			log("Data picked : " + testcaseName);
			objRemoveDocument.RemoveDocument(testcaseName);			
		}else {
			log("Approving the Note for atwell in the previous tc", Status.SKIP);
		}
	}
		
//		@Test(priority=7,enabled=true)
//		public void DeleteNotes_TC_07() throws Exception {
//			log("TC07 :Delete notes");
//			String testcaseName = "DeleteNotes" + clientName;
//			log("Data picked : " + testcaseName);
//				objDeleteNotes.DeleteNotes(testcaseName);		
//		}
		
	
}
