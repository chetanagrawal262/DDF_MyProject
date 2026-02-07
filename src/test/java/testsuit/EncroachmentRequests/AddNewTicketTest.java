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
import pages.EncroachmentRequests.AddNewTicketPage;
import pages.EncroachmentRequests.ConditionsPage;
import pages.EncroachmentRequests.EncroachmentAgreementManagementPage;
import pages.EncroachmentRequests.EncroachmentAssignmentsPage;
import pages.EncroachmentRequests.EncroachmentInformationPage;
import pages.EncroachmentRequests.EncroachmentPaymentsPage;
import pages.EncroachmentRequests.KeyDatePage;
import pages.EncroachmentRequests.LandownersPage;
import pages.EncroachmentRequests.RequestorPage;

@Listeners(com.listeners.MyListeners.class)
public class AddNewTicketTest extends BasePage{

	
		LoginPage objLogin;
		ReadPropertyFile readPro = new ReadPropertyFile();
		AddNewTicketPage objAddNewTicket;
		EncroachmentInformationPage objEncroachmentInformation;
		ConditionsPage objConditions;
		EncroachmentAgreementManagementPage objAgreementManagement;
		EncroachmentAssignmentsPage objAssignments;
		KeyDatePage objKeyDate;
		LandownersPage objLandowners;
		RequestorPage objRequestor;
		EncroachmentPaymentsPage objPayments;
		
		Map<String, String> map = new HashMap<String, String>();

		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objAddNewTicket = new AddNewTicketPage(driver);	
			objEncroachmentInformation = new EncroachmentInformationPage(driver);
			objConditions = new ConditionsPage(driver);
			objAgreementManagement = new EncroachmentAgreementManagementPage(driver);
			objAssignments = new EncroachmentAssignmentsPage(driver);
			objKeyDate = new KeyDatePage(driver);
			objLandowners = new LandownersPage(driver);
			objRequestor = new RequestorPage(driver);
			objPayments = new EncroachmentPaymentsPage(driver);
		}

		@Test(priority=1)
		public void AddNewTicket_TC_01() throws Exception {
			log("TC01 : Add a New Ticket ");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddNewTicket" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.RequestInformation,testcaseName);
			objAddNewTicket.AddNewTicket(map, testcaseName);
		}
		
		@Test(priority=2)
		public void Add_EncroachmentInformation_TC_02() throws Exception {
			log("TC02 : Add Encroachment Information ");
			String testcaseName = "EncroachmentInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.EncroachmentInformation,testcaseName);
			objEncroachmentInformation.AddEncroachmentInformation(map, testcaseName);
		}
		
		@Test(priority=3)
		public void Add_Conditions_TC_03() throws Exception {
			log("TC03 : Add Conditions ");
			String testcaseName = "Conditions" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.Conditions,testcaseName);
			objConditions.AddConditions(map, testcaseName);
		}
		
		@Test(priority=4)
		public void Edit_Conditions_TC_04() throws Exception {
			log("TC04 : Edit Conditions ");
			String testcaseName = "Conditions" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.Conditions,testcaseName);
			objConditions.EditConditions(map, testcaseName);
		}
		
		@Test(priority=5)
		public void Save_ConstructionDeadline_TC_05() throws Exception {
			log("TC05 : Save Construction Deadline ");
			String testcaseName = "Conditions" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.Conditions,testcaseName);
			objConditions.SaveConstructionDeadline(map, testcaseName);
		}
		
		@Test(priority=6)
		public void Extend_ConstructionDeadline_TC_06() throws Exception {
			log("TC06 : Extend Construction Deadline ");
			String testcaseName = "Conditions" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.Conditions,testcaseName);
			objConditions.ExtendConstructionDeadline(map, testcaseName);
		}
		
		@Test(priority=7)
		public void ViewHistory_TC_07() throws Exception {
			log("TC07 : View History ");
			String testcaseName = "Conditions" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.Conditions,testcaseName);
			objConditions.ViewHistory(map, testcaseName);
		}
		
		@Test(priority=8)
		public void Add_Existing_AgreementManagementRecord_TC_08() throws Exception {
			log("TC08 : Add Existing Agreement Management Record ");
			String testcaseName = "AddExistingAgreementRecord" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.AddAgreementManagement,testcaseName);
			objAgreementManagement.AddExistingAgreementRecord(map, testcaseName);
		}
		
		@Test(priority=9)
		public void Add_New_AgreementManagementRecord_TC_09() throws Exception {
			log("TC09 : Add New Agreement Management Record ");
			String testcaseName = "AddNewAgreementRecord" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.AddAgreementManagement,testcaseName);
			objAgreementManagement.AddNewAgreementManagementRecord(map, testcaseName);
		}
		
		@Test(priority=10)
		public void Edit_AgreementManagementRecord_TC_10() throws Exception {
			log("TC 10 : Edit Agreement Management Record ");
			String testcaseName = "EditAgreementRecord" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.AddAgreementManagement,testcaseName);
			objAgreementManagement.EditAgreementManagementRecord(map, testcaseName);
		}
		
		@Test(priority=11)
		public void Delete_AgreementManagementRecord_TC_11() throws Exception {
			log("TC 11 : Delete Agreement Management Record ");
			String testcaseName = "DeleteAgreementRecord" + clientName;
			objAgreementManagement.DeleteAgreementManagement(testcaseName);
		}
		
		@Test(priority = 12)
		public void AddAssignments_TC_12() throws Exception {
			log("TC12 : Add Assignments");
			String testcaseName = "AddAssignment" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.Assignment, testcaseName);
			objAssignments.AddAssignments(map, testcaseName);
		}
		
		@Test(priority = 13)
		public void EditAssignment_TC_13() throws Exception {
			log("TC13 : Edit Assignment");
			String testcaseName = "EditAssignment" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.Assignment, testcaseName);
			objAssignments.EditAssignments(map, testcaseName);
		}
		
		@Test(priority = 14)
		public void UpdateKeyDates_TC_14() throws Exception {
			log("TC14 :Update Key Dates");
			String testcaseName = "UpdateKeyDate" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.KeyDate, testcaseName);
			objKeyDate.UpdateKeyDate(map, testcaseName);
		}
		
		@Test(priority = 15)
		public void Add_LandownerInformation_TC_15() throws Exception {
			log("TC15 :Add Landowner Information");
			String testcaseName = "LandownerInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.LandownerInformation, testcaseName);
			objLandowners.LandownerInformation(map, testcaseName);
		}
		
		@Test(priority = 16)
		public void Add_ParcelInformation_TC_16() throws Exception {
			log("TC16 :Add Parcel Information");
			String testcaseName = "ParcelInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.ParcelInformation, testcaseName);
			objLandowners.AddParcelInformation(map, testcaseName);
		}
		
		@Test(priority = 17)
		public void Add_Requestor_TC_17() throws Exception {
			log("TC17 :Add Requestor");
			String testcaseName = "AddRequestor" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.Requestor, testcaseName);
			objRequestor.AddNewRecord(map, testcaseName);
		}
		
		@Test(priority = 18)
		public void Edit_Requestor_TC_18() throws Exception {
			log("TC18 :Edit Requestor");
			String testcaseName = "EditRequestor" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.Requestor, testcaseName);
			objRequestor.EditRecord(map, testcaseName);
		}
		
		@Test(priority = 19)
		public void Delete_Requestor_TC_19() throws Exception {
			log("TC19 :Delete Requestor");
			String testcaseName = "DeleteRequestor" + clientName;
			objRequestor.DeleteRecord(testcaseName);
		}
		
		@Test(priority = 20)
		public void Add_EncroachmentPayments_TC_20() throws Exception {
			log("TC 20 : Add Encroachment Payments");
			String testcaseName = "AddEncroachmentPayments" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.EncroachmentPayments, testcaseName);
			objPayments.AddEncroachmentPaymentRecord(map, testcaseName);
		}
		
		@Test(priority = 21)
		public void RecordPayment_TC_21() throws Exception {
			log("TC 21 : Record Payments");
			String testcaseName = "AddRecordPayment" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.RecordPayment, testcaseName);
			objPayments.recordPayment(map, testcaseName);
		}
		
		@Test(priority = 22)
		public void RentalReview_TC_22() throws Exception {
			log("TC 22 : Rental Review");
			String testcaseName = "AddRentalReview" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.RentalReview, testcaseName);
			objPayments.rentalReview(map, testcaseName);
		}
		
		@Test(priority = 23)
		public void RentalComments_TC_23() throws Exception {
			log("TC 23 : Rental Comments");
			String testcaseName = "AddRentalComments" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.ReviewComments, testcaseName);
			objPayments.reviewComments(map, testcaseName);
		}
}
