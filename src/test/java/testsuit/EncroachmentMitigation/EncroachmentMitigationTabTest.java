package testsuit.EncroachmentMitigation;

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
import pages.EncroachmentMitigation.AffectedParcelInformationPage;
import pages.EncroachmentMitigation.AffectedPropertyInformationPage;
import pages.EncroachmentMitigation.MilestoneDatePage;
import pages.EncroachmentMitigation.Obligations_CommitmentsPage;
import pages.EncroachmentMitigation.RemovalReimbursementPage;
import pages.EncroachmentMitigation.TicketInformationPage;

@Listeners(com.listeners.MyListeners.class)


public class EncroachmentMitigationTabTest extends BasePage{

	LoginPage objLogin;
	TicketInformationPage objTicketInformation;
	AffectedParcelInformationPage objAffectedParcelInformation;
	AffectedPropertyInformationPage objAffectedPropertyInformation;
	MilestoneDatePage objMilestoneDate;
	Obligations_CommitmentsPage objObligations;
	RemovalReimbursementPage objRemovalReimbursement;
	 ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
	
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objTicketInformation = new TicketInformationPage(driver);
			objAffectedParcelInformation = new AffectedParcelInformationPage(driver);
			objAffectedPropertyInformation = new AffectedPropertyInformationPage(driver);
			objMilestoneDate = new MilestoneDatePage(driver);
			objObligations = new Obligations_CommitmentsPage(driver);
			objRemovalReimbursement = new RemovalReimbursementPage(driver);
		}
		
		
		@Test(priority=1)
		public void AddTicketInformation_TC_01() throws Exception {
			log("TC01 : Add Ticket Information");
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddEncroachmentMitigation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_MITIGATION_TEST_DATA), Excel.TicketInformation,testcaseName);
			objTicketInformation.addEncroachmentMitigationTicket(map, testcaseName);	
		}
		
		@Test(priority=2)
		public void AddLandownerInformation_TC_02() throws Exception {
			log("TC02 : Add Landowner Information");
			String testcaseName = "LandownerInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_MITIGATION_TEST_DATA), Excel.LandownerInformation,testcaseName);
			objAffectedParcelInformation.LandownerInformation(map, testcaseName);	
		}
		
		@Test(priority=3)
		public void AddTractInformation_TC_03() throws Exception {
			log("TC03 : Add Tract Information");
			String testcaseName = "ParcelInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_MITIGATION_TEST_DATA), Excel.ParcelInformation,testcaseName);
			objAffectedParcelInformation.TractInformation(map, testcaseName);	
		}
		
		@Test(priority=4)
		public void AddAffectedPropertyInformation_TC_04() throws Exception {
			log("TC04 : Add Affected Property Information");
			String testcaseName = "AddAffectedPropertyInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_MITIGATION_TEST_DATA), Excel.AffectedPropertyInformation,testcaseName);
			objAffectedPropertyInformation.addAffectedPropertyInformation(map, testcaseName);
		}
		
		@Test(priority=5)
		public void EditAffectedPropertyInformation_TC_05() throws Exception {
			log("TC05 : Edit Affected Property Information");
			String testcaseName = "EditAffectedPropertyInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_MITIGATION_TEST_DATA), Excel.AffectedPropertyInformation,testcaseName);
			objAffectedPropertyInformation.editAffectedPropertyInformation(map, testcaseName);
		}
		
		@Test(priority=6)
		public void DeleteAffectedPropertyInformation_TC_06() throws Exception {
			log("TC06 : Delete Affected Property Information");
			String testcaseName = "DeleteAffectedPropertyInformation" + clientName;
			objAffectedPropertyInformation.deleteAffectedPropertyInformation(testcaseName);
		}
		
		@Test(priority=7)
		public void UpdateMilestoneDates_TC_07() throws Exception {
			log("TC07 : Update Milestone Dates");
			String testcaseName = "UpdateMilestoneDates" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_MITIGATION_TEST_DATA), Excel.KeyDate,testcaseName);
			objMilestoneDate.AddMilestoneDate(map,testcaseName);
		}
		
		@Test(priority=8)
		public void AddObligations_Commitments_TC_08() throws Exception {
			log("TC08 : Add Obligations / Commitments");
			String testcaseName = "AddObligation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_MITIGATION_TEST_DATA), Excel.Obligations,testcaseName);
			objObligations.AddObligationsRecord(map, testcaseName);
		}
		
		@Test(priority=9)
		public void EditObligations_Commitments_TC_09() throws Exception {
			log("TC09 : Edit Obligations / Commitments");
			String testcaseName = "EditObligation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_MITIGATION_TEST_DATA), Excel.Obligations,testcaseName);
			objObligations.EditObligationsRecord(map, testcaseName);
		}
		
		@Test(priority=10)
		public void DeleteObligations_Commitments_TC_10() throws Exception {
			log("TC 10 : Delete Obligations / Commitments");
			String testcaseName = "DeleteObligation" + clientName;
			objObligations.DeleteObligationsRecord(testcaseName);
		}

		@Test(priority=11)
		public void AddRemoval_Reimbursment_TC_11() throws Exception {
			log("TC 11 : Add Removal Reimbursment");
			String testcaseName = "AddRemovalReimbursment" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_MITIGATION_TEST_DATA), Excel.RemovalReimbursment,testcaseName);
			objRemovalReimbursement.AddReimbursementDetails(map, testcaseName);
		}
		
		@Test(priority=12)
		public void EditRemoval_Reimbursment_TC_12() throws Exception {
			log("TC 12 : Edit Removal Reimbursment");
			String testcaseName = "EditRemovalReimbursment" + clientName;
			objRemovalReimbursement.EditReimbursementDetails(testcaseName);
		}
		
		
		
}
