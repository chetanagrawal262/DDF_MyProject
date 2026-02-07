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
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.ThirdPartyAgreement.ThirdPartyInformationPage;
import pages.ThirdPartyAgreement.TractInformationPage;
import pages.agreementManager.MilestoneDatePage;

@Listeners(com.listeners.MyListeners.class)
public class ThirdPartyInformationTest extends BasePage {

	LoginPage objLogin;
	ThirdPartyInformationPage objThirdPartyInfo;
	MilestoneDatePage objMilestoneDate;
	TractInformationPage objTractInformation;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	public static String AGREEMENT_NUMBER; 
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objThirdPartyInfo = new ThirdPartyInformationPage(driver);
		objMilestoneDate = new MilestoneDatePage(driver);
		objTractInformation = new TractInformationPage(driver);
	}

	@Test(priority = 1,enabled = true)
	public void ThirdPartyAgreements_Add_New_Crossing_TC_01() throws Exception {
		if(environment.contains("WOLFMIDSTREAM")) {
		log("TC01 : Add New Crossing ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AddCrossing" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.THIRD_PARTY_AGREEMENTS_DATA), Excel.CrossingInfo, testcaseName);
		objThirdPartyInfo.addNewCrossing(map, testcaseName);
		}else {
			log("Third Party Agreements Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 2,enabled = true)
	public void ThirdPartyAgreements_Add_Milestone_Dates_TC_02() throws Exception {
		log("TC02 : Update Milestone Date");
			String testcaseName = "AddKey" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.THIRD_PARTY_AGREEMENTS_DATA), Excel.MilestoneDate, testcaseName);
			objMilestoneDate.addMilestoneDate(map,testcaseName);
	}

	@Test(priority = 3,enabled = true)
	public void ThirdPartyAgreements_Add_GrantorGrantee_TC_03() throws Exception {
		log("TC03 : Add Grantor / Grantee");
			String testcaseName = "AddGrantor" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.THIRD_PARTY_AGREEMENTS_DATA), Excel.Grantor, testcaseName);
			objThirdPartyInfo.addGrantorGranteeDetails(map, testcaseName);
	}
	
	@Test(priority = 4,enabled = true)
	public void ThirdPartyAgreements_Add_TractInformation_TC_04() throws Exception {
		log("TC04 : Add Tract Information");
			String testcaseName = "AddTractInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.THIRD_PARTY_AGREEMENTS_DATA), Excel.TractInformation, testcaseName);
			objTractInformation.addTractInformation(map, testcaseName);
	}
	
	@Test(priority = 5,enabled = true)
	public void ThirdPartyAgreements_Edit_TractInformation_TC_05() throws Exception {
		log("TC05 : Edit Tract Information");
			String testcaseName = "EditTractInformation" + clientName;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.THIRD_PARTY_AGREEMENTS_DATA), Excel.TractInformation, testcaseName);
			objTractInformation.editTractInformation(map, testcaseName);
	}
	
	@Test(priority = 6,enabled = true)
	public void ThirdPartyAgreements_Delete_TractInformation_TC_06() throws Exception {
		log("TC06 : Delete Tract Information");
			String testcaseName = "DeleteTractInformation" + clientName;
			objTractInformation.deleteTractInformation(testcaseName);
	}
	
}
