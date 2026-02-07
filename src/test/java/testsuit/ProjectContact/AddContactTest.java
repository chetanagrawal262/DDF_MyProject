package testsuit.ProjectContact;

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

import pages.Contact.AddaContactPage;
import pages.Contact.DeleteContactPage;
import pages.Contact.EditContactPage;

@Listeners(com.listeners.MyListeners.class)
public class AddContactTest extends BasePage{

	
	 LoginPage objLogin;
	 AddaContactPage objAddContact;
	 EditContactPage objEditContact;
	 DeleteContactPage objDeleteContact;
		ReadPropertyFile readPro = new ReadPropertyFile();
		Map<String, String> map = new HashMap<String, String>();
	
		@BeforeClass
		public void setup() throws Exception {
			driver = getDriver();
			objLogin = new LoginPage(driver);		
			objAddContact = new AddaContactPage(driver);
			objEditContact =  new EditContactPage(driver);
			objDeleteContact = new DeleteContactPage(driver);
		}
	
	@Test(priority = 1)
	public void AddnewContact_TC_01() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC01 : Add a Contact");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddnewContact" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.AddContact,testcaseName);
		objAddContact.AddnewContact(map, testcaseName);
		}else {
			log("Project Contact Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 2)
	public void EditContact_TC_02() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC02 : Edit  Contact");
		String testcaseName = "EditContact" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.EditContact,testcaseName);
		objEditContact.EditContact(map, testcaseName);
		}else {
			log("Project Contact Menu not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 3)
	public void DeleteContact_TC_03() throws Exception {
		if(!environment.contains("TRA")) {
		log("TC03 : Delete  Contact");
		String testcaseName = "DeleteContact" + clientName;
		log("Data picked : " + testcaseName);
		objDeleteContact.DeleteContact(testcaseName);
		}else {
			log("Project Contact Menu not applicable for this client", Status.SKIP);
		}
	}
}
