package testsuit.CustomerOutreach;

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
import pages.TicketAssociation.AddNewAssignmentPage;
import pages.TicketAssociation.AddNewNonParticipatingStakeholdersPage;
import pages.TicketAssociation.AddNewParticipatingStakeholderLandownerInformationPage;
import pages.TicketAssociation.AddNewTicketPage;
import pages.TicketAssociation.ConfigureCustomerOutreachFormPage;
import pages.TicketAssociation.ParticipatingStakeholdersLeaseInformationPage;
import pages.TicketAssociation.ParticipatingStakeholdersParcelInformationPage;

@Listeners(com.listeners.MyListeners.class)
public class AddNewTicketTest extends BasePage{

	
		LoginPage objLogin;
		ReadPropertyFile readPro = new ReadPropertyFile();
		AddNewTicketPage objAddNewTicket;
		AddNewAssignmentPage objAddNewAssignment;
		AddNewParticipatingStakeholderLandownerInformationPage objLandownerInformation;
		ParticipatingStakeholdersParcelInformationPage objParcelInformation;
		ParticipatingStakeholdersLeaseInformationPage objLeaseInformation;
		AddNewNonParticipatingStakeholdersPage objAddNewNonParticipatingStakeholders;
		ConfigureCustomerOutreachFormPage objCOFormPage;
		Map<String, String> map = new HashMap<String, String>();

		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objAddNewTicket = new AddNewTicketPage(driver);
			objAddNewAssignment = new AddNewAssignmentPage(driver);
			objLandownerInformation = new AddNewParticipatingStakeholderLandownerInformationPage(driver);
			objParcelInformation = new ParticipatingStakeholdersParcelInformationPage(driver);
			objLeaseInformation = new ParticipatingStakeholdersLeaseInformationPage(driver);
			objAddNewNonParticipatingStakeholders = new AddNewNonParticipatingStakeholdersPage(driver);
			objCOFormPage = new ConfigureCustomerOutreachFormPage(driver);
			
		}

		@Test(priority=1)
		public void AddNewTicket_TC_01() throws Exception {
			log("TC01 : Add a New Ticket ");
			if (!environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddNewTicket" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.TicketAssociation,
					testcaseName);
			objAddNewTicket.AddNewTicket(map, testcaseName);
			}else {
				log("Customer Outreach is not applicable for this client", Status.SKIP);
			}

		}
		
		@Test(priority=2)
		public void Add_New_Assignment_TC_02() throws Exception {
			log("TC02 : Add a New Assignment ");
			if (!environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			String testcaseName = "AddNewAssignment" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.AddNewAssignment,
					testcaseName);
			objAddNewAssignment.AddNewAssignment(map, testcaseName);
			}else {
				log("Customer Outreach is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=3)
		public void AddNewParticipatingStakeholdersLandownerInformation_TC_03() throws Exception {
			log("TC03 : Add a New Participating Stakeholders > Landowner Information  ");
			if (!environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			String testcaseName = "LandownerInformation" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.LandownerInformation,
					testcaseName);
			objLandownerInformation.LandownerInformation(map, testcaseName);
			}else {
				log("Customer Outreach is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=4)
		public void AddNewParticipatingStakeholdersParcelInformation_TC_04() throws Exception {
			log("TC04 : Add a New Participating Stakeholders > Parcel Information  ");
			if (!environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			String testcaseName = "ParcelInformation" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.ParcelInformation,
					testcaseName);
			objParcelInformation.ParcelInformation(map, testcaseName);
			}else {
				log("Customer Outreach is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=5)
		public void AddNewParticipatingStakeholdersLeaseInformation_TC_05() throws Exception {
			log("TC05 : Add a New Participating Stakeholders > Lease Information ");
			if (!environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			String testcaseName = "LeaseInformation" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.LeaseInformation,
					testcaseName);
			objLeaseInformation.LeaseInformation(map, testcaseName);
			}else {
				log("Customer Outreach is not applicable for this client", Status.SKIP);
			}
		}
			
		
		@Test(priority=6)
		public void AddNewNonParticipatingStakeholders_TC_06() throws Exception {
			log("TC06 : Add a New Non - Participating Stakeholders ");
			if (!environment.contains("STEELHEAD") & !environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			String testcaseName = "AddNewNonParticipatingStakeholders" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.NonParticipatingStakeholders,
					testcaseName);
			objAddNewNonParticipatingStakeholders.AddNewNonParticipatingStakeholders(map, testcaseName);
			}else {
				log("Customer Outreach is not applicable for this client", Status.SKIP);
			}
			}
		
		@Test(priority=7)
		public void DeleteNonParticipatingStakeholders_TC_07() throws Exception {
			log("TC07 : Delete a Non - Participating Stakeholders ");
			if (!environment.contains("STEELHEAD") & !environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			String testcaseName = "DeleteNonParticipatingStakeholders" + clientName;
			log("Data picked : " + testcaseName);
			objAddNewNonParticipatingStakeholders.DeleteNonParticipatingStakeholders(testcaseName);
			}else {
				log("Customer Outreach is not applicable for this client", Status.SKIP);
			}
		}
		
		@Test(priority=8)
		public void Customer_Outreach_Form_TC_08() throws Exception {
			log("TC07 : Delete a Non - Participating Stakeholders ");
			if (!environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.loginWithSuperAdmin(map);
			String testcaseName = "CustomerOutreachForm" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.COFORM,testcaseName);
			objCOFormPage.COFormConfiguration(map, testcaseName);
			}else {
				log("Customer Outreach is not applicable for this client", Status.SKIP);
			}
		}
}
