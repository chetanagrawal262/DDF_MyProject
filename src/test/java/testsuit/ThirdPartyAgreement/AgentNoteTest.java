package testsuit.ThirdPartyAgreement;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;

import page.Common.LoginPage;
import pages.ThirdPartyAgreement.AgentNotePage;

@Listeners(com.listeners.MyListeners.class)
public class AgentNoteTest extends BasePage {

	LoginPage objLogin;
	AgentNotePage objNotes;
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objNotes = new AgentNotePage(driver);
	}
	
	@Test(priority = 1)
	public void ThirdPartyAgreements_Add_Agent_Notes() throws Exception {
		if(environment.contains("WOLFMIDSTREAM")) {
		log("TC01 : Add Agent Notes");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddAgreementNote" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AgreementNote, testcaseName);
		objNotes.addNotes(map, testcaseName);
	}else {
		log(" Test Case is not applicable for this client", Status.SKIP);
	}
	}
	
	@Test(priority = 2)
	public void ThirdPartyAgreements__Edit_Agent_Notes() throws Exception {
		if(environment.contains("WOLFMIDSTREAM")) {
		log("TC02 : Edit Agreement Notes");
		String testcaseName = "EditAgreementNote" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.AgreementNote, testcaseName);
		objNotes.editNotes(map, testcaseName);
	}else {
		log("Agreement Notes Test Case is not applicable for this client", Status.SKIP);
	}
	}
}
