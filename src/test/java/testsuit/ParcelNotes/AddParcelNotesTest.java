package testsuit.ParcelNotes;

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
import pages.ParcelNotes.AddDocumentThroughExternalLinkPage;
import pages.ParcelNotes.AddParcelNotesPage;
import pages.ParcelNotes.AddViewDocumentLinkPage;
import pages.ParcelNotes.DeleteNotesPage;
import pages.ParcelNotes.EditParcelNotesPage;
import pages.ParcelNotes.RemoveDocumentPage;
import pages.ParcelNotes.ViewDocumentLinkPage;


@Listeners(com.listeners.MyListeners.class)
public class AddParcelNotesTest extends BasePage{

	 LoginPage objLogin;
	 AddParcelNotesPage objAddParcelNotes;
	 EditParcelNotesPage objEditParcelNotes;
	 AddViewDocumentLinkPage objAddViewDocumentLink;
	 AddDocumentThroughExternalLinkPage objAddDocumentThroughExternalLink;
	 ViewDocumentLinkPage objViewDocumentLink;
	 DeleteNotesPage objDeleteNotes;
	 RemoveDocumentPage objRemoveDocument;
		ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
	
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objAddParcelNotes = new AddParcelNotesPage(driver);
			objEditParcelNotes = new EditParcelNotesPage(driver);
			objAddViewDocumentLink = new AddViewDocumentLinkPage(driver);
			objAddDocumentThroughExternalLink = new AddDocumentThroughExternalLinkPage(driver);
			objViewDocumentLink = new ViewDocumentLinkPage(driver);
			objDeleteNotes = new DeleteNotesPage(driver);
			objRemoveDocument = new RemoveDocumentPage(driver);
		}
		
		@Test(priority=1)
		public void AddParcelNotes_TC_01() throws Exception {
			if(!environment.contains("ORION")) {
			log("TC01 : Add Parcel Notes");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddParcelNotes" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddParcelNotes,testcaseName);
			objAddParcelNotes.AddParcelNotes(map, testcaseName);
			}else {
				log("This TC is not applicable for this client", Status.SKIP);
			}
		}
		

		@Test(priority=2,enabled=true)
		public void EditParcelNotes_TC_02() throws Exception {
			if(!environment.contains("ORION")) {
			log("TC02 : Edit Parcel Notes");
			String testcaseName = "EditParcelNotes" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.EditParcelNotes,testcaseName);
			objEditParcelNotes.EditParcelNotes(map, testcaseName);
			}else {
				log("This TC is not applicable for this client", Status.SKIP);
			}
			
			
		}
		
		@Test(priority=3, enabled=true)//Removing not required
		public void AddViewDocumentLink_TC_03() throws Exception {
			if(!environment.contains("STEELHEAD") & !environment.contains("ORION") & !environment.contains("ATWELL")) {
			log("TC03 :Add/update Document to added notes");
			String testcaseName = "AddDocument" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddDocument,testcaseName);
			objAddViewDocumentLink.AddDocument(map, testcaseName);
			}else {
				log("This TC is not applicable for this client", Status.SKIP);
			}
			
		}
		
		@Test(priority=4, enabled=true)
		public void AddDocumentThroughExternalLink_TC_04() throws Exception {
			if(!environment.contains("STEELHEAD") & !environment.contains("ORION") & !environment.contains("ATWELL")) {
			log("TC04 :Add a Document - through External Link");
			String testcaseName = "AddDocumentExternalLink" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddDocumentExternalLink,testcaseName);
			objAddDocumentThroughExternalLink.AddDocumentExternalLink(map, testcaseName);
			}else {
				log("This TC is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=5, enabled=true)
		public void ViewDocument_TC_05() throws Exception {
			if(!environment.contains("STEELHEAD") & !environment.contains("ORION") & !environment.contains("ATWELL")) {
			log("TC05 :View Document Link");
			String testcaseName = "ViewDocument" + clientName;
			log("Data picked : " + testcaseName);
			objViewDocumentLink.ViewDocument(testcaseName);
			}else {
				log("This TC is not applicable for this client", Status.SKIP);
			}
		}	
		
		@Test(priority=6, enabled=true)
		public void RemoveDocument_TC_06() throws Exception {
			if(!environment.contains("STEELHEAD") & !environment.contains("ORION") & !environment.contains("ATWELL")) {
			log("TC06 :Remove document");
			String testcaseName = "RemoveDocument" + clientName;
			log("Data picked : " + testcaseName);
			objRemoveDocument.RemoveDocument(testcaseName);			
			}else {
				log("This TC is not applicable for this client", Status.SKIP);
			}
	}
		
		
		@Test(priority=7,enabled=true)
		public void DeleteNotes_TC_07() throws Exception {
			if(!environment.contains("ORION")) {
			log("TC07 :Delete notes");
			String testcaseName = "DeleteNotes" + clientName;
			log("Data picked : " + testcaseName);
				objDeleteNotes.DeleteNotes(testcaseName);	
			}else {
				log("This TC is not applicable for this client", Status.SKIP);
			}
		}
}
