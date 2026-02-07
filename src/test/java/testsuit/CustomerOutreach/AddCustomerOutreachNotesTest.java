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
import pages.Notes.AddCustomerOutreachNotesPage;
import pages.Notes.DeleteCustomerOutreachNotesPage;
import pages.Notes.EditCustomerOutreachNotesPage;

@Listeners(com.listeners.MyListeners.class)
public class AddCustomerOutreachNotesTest extends BasePage{

	
	 LoginPage objLogin;
	 AddCustomerOutreachNotesPage objAddNotes;	
	 EditCustomerOutreachNotesPage objEditNotes;
	 DeleteCustomerOutreachNotesPage objDeleteNotes;
	 ReadPropertyFile readPro = new ReadPropertyFile();
	 Map<String, String> map = new HashMap<String, String>();
	 
	 
	 @BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);
			objAddNotes = new AddCustomerOutreachNotesPage(driver);
			objEditNotes = new EditCustomerOutreachNotesPage(driver);
			objDeleteNotes = new DeleteCustomerOutreachNotesPage(driver);
	 }
	 
	 @Test(priority=1)
		public void AddNotes_TC_01() throws Exception {
			log("TC01 : Add Customer Outreach Notes");
			if (!environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			navigateToApplication(appURL);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
			objLogin.login(map);
			String testcaseName = "AddNotes" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.AddNotes,testcaseName);
			objAddNotes.AddNotes(map, testcaseName);
			}else {
				log("Customer Outreach Note is not applicable for this client", Status.SKIP);
			}
		}
	 
	 @Test(priority=2)
		public void EditNotes_TC_02() throws Exception {
			log("TC02 : Edit Customer Outreach Notes");
			if (!environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("CONNECTGEN")){
			String testcaseName = "EditNotes" + clientName;
			log("Data picked : " + testcaseName);
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOMER_OUTREACH_TEST_DATA), Excel.EditNotes,testcaseName);
			objEditNotes.EditNotes(map, testcaseName);
			}else {
				log("Customer Outreach Note is not applicable for this client", Status.SKIP);
			}
		}
	 
	 @Test(priority=3)
		public void DeleteNotes_TC_03() throws Exception {
			log("TC03 : Delete Customer Outreach Notes");
			if (!environment.contains("TREATYOAK") & !environment.contains("ORION")  & !environment.contains("CONNECTGEN")  & !environment.contains("DOMINION")){
			String testcaseName = "DeleteCustomerOutreachNotes" + clientName;
			log("Data picked : " + testcaseName);
			objDeleteNotes.DeleteCustomerOutreachNotes(testcaseName);
		
	 }else {
			log("Customer Outreach Note is not applicable for this client", Status.SKIP);
		}
	 } 
	 
}
