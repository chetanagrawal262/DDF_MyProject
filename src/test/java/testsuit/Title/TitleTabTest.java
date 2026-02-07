package testsuit.Title;

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
import pages.ParcelDetails.TitleOrderFormWorkflowPage;
import pages.ProjectDocuments.DeleteDocumentsPage;
import pages.Title.*;

@Listeners(com.listeners.MyListeners.class)
public class TitleTabTest extends BasePage{

	 LoginPage objLogin;
	 TitleTabPage objTitleTab;
	 AddTitleTrackingRecordPage objAddTitleTrackingRecord;
	 EditTitleTrackingRecordPage objEditTitleTrackingRecord;
	 AddDocumentVestingOwnershipRecordPage objAddDocumentVestingOwnershipRecord;
	 AddDocumentLinkPage objAddDocumentLink;
	 DeleteDocumentsPage objDeleteDocuments;
	 EditDocumentVestingOwnershipRecordPage objEditDocumentVestingOwnershipRecord;
	 DeleteDocumentVestingOwnershipRecordPage objDeleteDocumentVestingOwnershipRecord;
	 AddEasementsRecordPage objAddEasementsRecord;
	 EditEasementRecordPage objEditEasementRecord;
	 ViewDocumentLinkPage objViewDocumentLink;
	 DeleteEasementsRecordPage objDeleteEasementsRecord;
	 AddInvoluntaryLiensRecordPage objAddInvoluntaryLiensRecord;
	 AddViewDocumentLinkPage objAddViewDocumentLink;
	 EditInvoluntaryLiensRecordPage objEditInvoluntaryLiensRecord;
	 DeleteInvoluntaryLiensRecordPage objDeleteInvoluntaryLiensRecord;
	 AddLesseeRecordPage objAddLesseeRecord;
	 EditLesseeRecordPage objEditLesseeRecord;
	 DeleteLesseeRecordPage objDeleteLesseeRecord;
	 AddTitleIssuesRecordPage objAddTitleIssuesRecord;
	 EditTitleIssuesRecordPage objEditTitleIssuesRecord;
	 DeleteTitleIssuesRecordPage objDeleteTitleIssuesRecord;
	 AddTitleCommentsPage objAddTitleComments;
	 TitleFormPage objTitleForm;
	 
		ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
	
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objTitleTab = new TitleTabPage(driver);
			objAddTitleTrackingRecord = new AddTitleTrackingRecordPage(driver);
			objEditTitleTrackingRecord = new EditTitleTrackingRecordPage(driver);
			objAddDocumentVestingOwnershipRecord = new AddDocumentVestingOwnershipRecordPage(driver);
			objAddDocumentLink = new AddDocumentLinkPage(driver);
			objDeleteDocuments = new DeleteDocumentsPage(driver);
			objEditDocumentVestingOwnershipRecord = new EditDocumentVestingOwnershipRecordPage(driver);
			objDeleteDocumentVestingOwnershipRecord = new DeleteDocumentVestingOwnershipRecordPage(driver);
			objAddEasementsRecord = new AddEasementsRecordPage(driver);
			objViewDocumentLink = new ViewDocumentLinkPage(driver);
			objEditEasementRecord = new EditEasementRecordPage(driver);
			objDeleteEasementsRecord = new DeleteEasementsRecordPage(driver);
			objAddInvoluntaryLiensRecord = new AddInvoluntaryLiensRecordPage(driver);
			objAddViewDocumentLink = new AddViewDocumentLinkPage(driver);
			objEditInvoluntaryLiensRecord = new EditInvoluntaryLiensRecordPage(driver);
			objDeleteInvoluntaryLiensRecord = new DeleteInvoluntaryLiensRecordPage(driver);
			objAddLesseeRecord = new AddLesseeRecordPage(driver);
			objEditLesseeRecord = new EditLesseeRecordPage(driver);
			objDeleteLesseeRecord = new DeleteLesseeRecordPage(driver);
			objAddTitleIssuesRecord = new AddTitleIssuesRecordPage(driver);
			objEditTitleIssuesRecord = new EditTitleIssuesRecordPage(driver);
			objDeleteTitleIssuesRecord = new DeleteTitleIssuesRecordPage(driver);
			objAddTitleComments = new AddTitleCommentsPage(driver);
			objTitleForm = new TitleFormPage(driver);
		}
		
		@Test(priority=1)
		public void TitleTab_TC_01() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("GRAYHAWKALT")) {
			log("TC01 : Title Tab");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "TitleTab" + clientName;
			log("Data picked : " + testcaseName);
			objTitleTab.TitleTab(testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			}
			
		}
		
		@Test(priority=2, enabled=true)
		public void AddTitleTrackingRecord_TC_02() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("GRAYHAWKALT")) {
			log("TC02 : Title Tab- Title Tracking/MTA item information");
			String testcaseName = "AddTitleTrackingRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddTitleTrackingRecord,testcaseName);
			objAddTitleTrackingRecord.AddTitleTrackingRecord(map, testcaseName);
			objAddTitleTrackingRecord.AddGrantorInParcelSummary(testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			}
		}
		
		@Test(priority=3, enabled=true)
		public void EditTitleTrackingRecord_TC_03() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("GRAYHAWKALT")) {
			log("TC03 : Edit Title Tracking record. ");
			String testcaseName = "EditTitleTrackingRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.EditTitleTrackingRecord,testcaseName);
			objEditTitleTrackingRecord.EditTitleTrackingRecord(map, testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			}
		}
		
		@Test(priority=4, enabled=true)
		public void AddDocumentVestingOwnershipRecord_TC_04() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC04 : Add Document Vesting Ownership record");
			String testcaseName = "AddDocumentVestingOwnershipRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddDocumentVestingOwnership,testcaseName);
			objAddDocumentVestingOwnershipRecord.AddDocumentVestingOwnershipRecord(map, testcaseName);
		   }else {
			log("This TC is not applicable for this client" + Status.SKIP);
		   }
		}
		
		@Test(priority=5, enabled=true)
		public void AddDocumentLink_TC_05() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC05 :Add/View Document Link ");
			String testcaseName = "AddDocumentLink" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddDocumentLink,testcaseName);
			objAddDocumentLink.AddDocumentLink(map, testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=6, enabled=true, description="71448")
		public void ViewDocumentHistory_TC_06() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT")& !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC06 :Add Version and view document history ");
			String testcaseName = "AddDocumentLink" + clientName;
			if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddDocumentLink,testcaseName);
			objAddDocumentLink.verifyDocumentVersionAndHistory(map, testcaseName);
			}else {
				log("This TC is ROW Specific" + Status.SKIP);
			   }
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=7, enabled=true, description="71448")
		public void DeleteDocument_TC_07() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT")& !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC 07 : Delete Document");
			String testcaseName = "DeleteDocuments" + clientName;
			if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.DeleteDocument,testcaseName);
			objDeleteDocuments.DeleteDocument(map, testcaseName);
			objDeleteDocuments.DeleteDocument(map, testcaseName);
			}else {
				log("This TC is ROW Specific" + Status.SKIP);
			   }
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=8, enabled=true, description="71448")
		public void VerifyDeletedDocumentOnTitle_TC_07() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT")& !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC 08 : Verify Deleted Document on Title Tab");
			String testcaseName = "DeleteDocuments" + clientName;
			if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.DeleteDocument,testcaseName);
			objAddDocumentLink.verifyDeletedDoc(testcaseName);
			}else {
				log("This TC is ROW Specific" + Status.SKIP);
			   }
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=9, enabled=true)
		public void EditDocumentVestingOwnershipRecord_TC_09() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC09 : Edit Document Vesting Ownership record");
			String testcaseName = "EditDocumentVestingOwnershipRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.EditDocumentVestingOwnership,testcaseName);
			objEditDocumentVestingOwnershipRecord.EditDocumentVestingOwnershipRecord(map, testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=10, enabled=true)
		public void DeleteDocumentVestingOwnershipRecord_TC_10() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC10 : Delete Document Vesting Ownership Record");
			String testcaseName = "DeleteDocumentVestingOwnershipRecord " + clientName;
			log("Data picked : " + testcaseName);
			objDeleteDocumentVestingOwnershipRecord.DeleteDocumentVestingOwnershipRecord(testcaseName);
		}else {
			log("This TC is not applicable for this client" + Status.SKIP);
		   }
		}
	
		@Test(priority=11, enabled=true)
		public void AddEasementsRecord_TC_11() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT") & !environment.contains("ORION")) {
			log("TC11 : Add Easements, Plats, Oil & Gas Leases record");
			String testcaseName = "AddEasementsRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddEasementsRecord,testcaseName);
			objAddEasementsRecord.AddEasementsRecord(map, testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=12, enabled=true)
		public void ViewDocumentLink_TC_12() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT") & !environment.contains("ORION")) {
			log("TC12 :Add/View Document Link ");
			String testcaseName = "ViewDocumentLink" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.ViewDocumentLink,testcaseName);
			objViewDocumentLink.ViewDocumentLink(map, testcaseName);
		}else {
			log("This TC is not applicable for this client" + Status.SKIP);
		   }
		}
		
		@Test(priority=13, enabled=true)
		public void EditEasementRecord_TC_13() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT") & !environment.contains("ORION")) {
			log("TC13 : Edit Easements, Plats, Oil & Gas Leases record");
			String testcaseName = "EditEasementRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.EditEasementsRecord,testcaseName);
			objEditEasementRecord.EditEasementRecord(map, testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=14, enabled=true)
		public void DeleteEasementsRecord_TC_14() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT") & !environment.contains("ORION")) {
			log("TC14 : Delete Easements, Plats, Oil & Gas Leases record");
			String testcaseName = "DeleteEasementsRecord" + clientName;
			log("Data picked : " + testcaseName);
			objDeleteEasementsRecord.DeleteEasementsRecord(testcaseName);
		    }else {
			log("This TC is not applicable for this client" + Status.SKIP);
		   }
		}
		
		@Test(priority=15, enabled=true)
		public void AddInvoluntaryLiensRecord_TC_15() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC15 : Add Involuntary Liens, Lis Pendens & Other Encumbrance record ");
			String testcaseName = "AddInvoluntaryLiensRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddInvoluntaryLiensRecord,testcaseName);
			objAddInvoluntaryLiensRecord.AddInvoluntaryLiensRecord(map, testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=16, enabled=true)
		public void AddViewDocumentLink_TC_16() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC16 :Add/View Document Link ");
			String testcaseName = "AddViewDocumentLink" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddViewDocumentLink,testcaseName);
			objAddViewDocumentLink.AddViewDocumentLink(map, testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=17, enabled=true)
		public void EditInvoluntaryLiensRecord_TC_17() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC17 : Edit Involuntary Liens, Lis Pendens & Other Encumbrance record");
			String testcaseName = "EditInvoluntaryLiensRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.EditInvoluntaryLiensRecord,testcaseName);
			objEditInvoluntaryLiensRecord.EditInvoluntaryLiensRecord(map, testcaseName);
		}else {
			log("This TC is not applicable for this client" + Status.SKIP);
		   }
		}
		
		@Test(priority=18, enabled=true)
		public void DeleteInvoluntaryLiensRecord_TC_18() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT")) {
			log("TC18 : Delete Involuntary Liens, Lis Pendens & Other Encumbrance record");
			String testcaseName = "DeleteInvoluntaryLiensRecord" + clientName;
			log("Data picked : " + testcaseName);
			objDeleteInvoluntaryLiensRecord.DeleteInvoluntaryLiensRecord(testcaseName);
		}else {
			log("This TC is not applicable for this client" + Status.SKIP);
		   }
		}
		

		@Test(priority=19, enabled=true)
		public void AddLesseeRecord_TC_19() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("NOVA") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("GRAYHAWKALT") & !environment.contains("WSBROW") & !environment.contains("VALARD") & !environment.contains("ORION")  ) {
			log("TC19 :Add a Tenant/Lessee Record ");
			String testcaseName = "AddLesseeRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddLesseeRecord,testcaseName);
			objAddLesseeRecord.AddLesseeRecord(map, testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=20, enabled=true)
		public void EditLesseeRecord_TC_20() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("NOVA") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("GRAYHAWKALT") & !environment.contains("WSBROW") & !environment.contains("VALARD") & !environment.contains("ORION") ) {
			log("TC20 : Edit a Tenant/Lessee Record ");
			String testcaseName = "EditLesseeRecord" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.EditLesseeRecord,testcaseName);
			objEditLesseeRecord.EditLesseeRecord(map, testcaseName);
			}else {
				log("This TC is not applicable for this client" + Status.SKIP);
			   }
		}
		
		@Test(priority=21, enabled=true)
		public void DeleteLesseeRecord_TC_21() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("NOVA") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("GRAYHAWKALT") & !environment.contains("WSBROW") & !environment.contains("VALARD") & !environment.contains("ORION") ) {
			log("TC21 :Delete Tenant/Lessee record");
			String testcaseName = "DeleteLesseeRecord" + clientName;
			log("Data picked : " + testcaseName);
			objDeleteLesseeRecord.DeleteLesseeRecord(testcaseName);
		}else {
			log("This TC is not applicable for this client" + Status.SKIP);
		   }
		}
		
		@Test(priority=22, enabled=true)
		public void AddTitleIssuesRecord_TC_22() throws Exception {
			log("TC22 :Add Title Issues record ");
			String testcaseName = "AddTitleIssuesRecord" + clientName;
			log("Data picked : " + testcaseName);
			if(testcaseName.contains("ATWELL") || testcaseName.contains("ORION") || testcaseName.contains("ORSTED") || environment.contains("WSBALT") || environment.contains("PRIMERGY") || environment.contains("VERDANTERRA") || environment.contains("RAMACO") || environment.contains("AVANTUS") || environment.contains("GRAYHAWKALT")) {
				log("Title Issue panel not available on this client", Status.SKIP);
			}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.AddTitleIssuesRecord,testcaseName);
			objAddTitleIssuesRecord.AddTitleIssuesRecord(map, testcaseName);
			}
			
		}
		
		@Test(priority=23, enabled=true)
		public void EditTitleIssuesRecord_TC_23() throws Exception {
			log("TC23 : Edit Title Issues record ");
			String testcaseName = "EditTitleIssuesRecord" + clientName;
			log("Data picked : " + testcaseName);
			if(testcaseName.contains("ATWELL") || testcaseName.contains("ORION") || testcaseName.contains("ORSTED") || environment.contains("WSBALT") || environment.contains("PRIMERGY") || environment.contains("VERDANTERRA")  || environment.contains("RAMACO") || environment.contains("AVANTUS") || environment.contains("GRAYHAWKALT")) {
				log("Title Issue panel not available on this client", Status.SKIP);
			}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.EditTitleIssuesRecord,testcaseName);
			objEditTitleIssuesRecord.EditTitleIssuesRecord(map, testcaseName);
			}
		}
		
		@Test(priority=24, enabled=true)
		public void DeleteTitleIssuesRecord_TC_24() throws Exception {
			log("TC24 :Delete Title Issues record ");
			String testcaseName = "DeleteTitleIssuesRecord" + clientName;
			log("Data picked : " + testcaseName);
			if(testcaseName.contains("ATWELL") || testcaseName.contains("ORION") || testcaseName.contains("ORSTED") || environment.contains("WSBALT") || environment.contains("PRIMERGY") || environment.contains("VERDANTERRA") || environment.contains("RAMACO") || environment.contains("AVANTUS") || environment.contains("GRAYHAWKALT")) {
				log("Title Issue panel not available on this client", Status.SKIP);
			}else {
			objDeleteTitleIssuesRecord.DeleteTitleIssuesRecord(testcaseName);
			}
		}
		
		@Test(priority=25, enabled=true)
		public void Title_Form_TC_25() throws Exception {
			if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("GRAYHAWKALT")) {
			log("TC 25 : Add a Title Form ");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.loginWithSuperAdmin(map);
			String testcaseName = "TitleForm" + clientName;
			if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA") & !testcaseName.contains("DOT")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.TitleForm,
					testcaseName);
			objTitleForm.TitleFormConfiguration(map, testcaseName);
			}
			}else {
				log("Title Form is not applicable for ROW and DOT Vertical", Status.SKIP);
			}
		}
		
}
