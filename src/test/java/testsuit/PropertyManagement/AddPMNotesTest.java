package testsuit.PropertyManagement;

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
import pages.PMNotes.AddDocumentExternalLinkPage;
import pages.PMNotes.AddPMNotesPage;
import pages.PMNotes.AddViewDocumentLinkPage;
import pages.PMNotes.DeleteNotesPage;
import pages.PMNotes.DownloadAllDocumentPage;
import pages.PMNotes.EditProjectNotesPage;
import pages.PMNotes.RemoveDocumentPage;


@Listeners(com.listeners.MyListeners.class)
public class AddPMNotesTest extends BasePage{

	 LoginPage objLogin;
	 AddPMNotesPage objAddProjectNotes;
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
			objAddProjectNotes = new AddPMNotesPage(driver);
			objEditProjectNotes = new EditProjectNotesPage(driver);
			objAddViewDocumentLink = new AddViewDocumentLinkPage(driver);
			objAddDocumentExternalLink = new AddDocumentExternalLinkPage(driver);
			objDownloadAllDocuments = new DownloadAllDocumentPage(driver);
			objDeleteNotes = new DeleteNotesPage(driver);
			objRemoveDocument = new RemoveDocumentPage(driver);
		}
		
		@Test(priority=1)
		public void AddPropertyManagementNotes_TC_01() throws Exception {
			log("TC01 : Add Project Notes");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddProjectNotes" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTYMANAGEMENT_TEST_DATA), Excel.AddPMNotes,testcaseName);
			objAddProjectNotes.AddProjectNotes(map, testcaseName);
			
		}
		

		@Test(priority=2, enabled=true)
		public void EditPropertyManagementNotes_TC_02() throws Exception {
			log("TC02 : Edit Project Notes");
			String testcaseName = "EditProjectNotes" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTYMANAGEMENT_TEST_DATA), Excel.EditPMNotes,testcaseName);
			objEditProjectNotes.EditProjectNotes(map, testcaseName);
			
		}
		
		
		@Test(priority=3,enabled=false)
		public void DeleteNotes_TC_03() throws Exception {
			log("TC03 :Delete notes");
			String testcaseName = "DeleteNotes" + clientName;
			log("Data picked : " + testcaseName);
				objDeleteNotes.DeleteNotes(testcaseName);		
		}
		
	
}
