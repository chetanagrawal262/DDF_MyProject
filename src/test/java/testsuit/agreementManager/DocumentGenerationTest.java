package testsuit.agreementManager;

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
import pages.agreementManager.AddNewInformationPage;
import pages.agreementManager.DocumentGenerationPage;

@Listeners(com.listeners.MyListeners.class)
public class DocumentGenerationTest extends BasePage {
	LoginPage objLogin;
	AddNewInformationPage objAddInfo;
	DocumentGenerationPage objDoc;
	Map<String, String> map = new HashMap<String, String>();
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAddInfo = new AddNewInformationPage(driver);
		objDoc = new DocumentGenerationPage(driver);
	}

	@Test(priority = 1)
	public void DocumentGenerationPanel_Generate_Document_TC_01() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("BAYWA") & !environment.contains("TRA") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC01 : Document generation Panel(Generate document)");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "DocumentGenrate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.DocGenerate, testcaseName);
		objDoc.verifyGenerateDocument(map,testcaseName);
		}else {
			log("Agreement Document Generation Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 2, dependsOnMethods = { "DocumentGenerationPanel_Generate_Document_TC_01" })
	public void DocumentGenerationPanel_Preview_Document_TC_02() throws Exception {
		if(!environment.contains("CRIMSON") & !environment.contains("BAYWA") & !environment.contains("TRA") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC02 : Document generation Panel(Preview document)");
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		String testcaseName = "DocumentGenrate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), Excel.DocGenerate, testcaseName);
		objDoc.verifyPreviewDocument(map,testcaseName);
		}else {
			log("Agreement Document Generation Test Case is not applicable for this client", Status.SKIP);
		}
	}
	
}
