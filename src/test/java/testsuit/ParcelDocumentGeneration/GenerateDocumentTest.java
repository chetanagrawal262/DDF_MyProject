package testsuit.ParcelDocumentGeneration;

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
import pages.DocumentGeneration.DocumentGenerationPage;



@Listeners(com.listeners.MyListeners.class)
public class GenerateDocumentTest extends BasePage{

	LoginPage objLogin;
	DocumentGenerationPage objDocument;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objDocument = new DocumentGenerationPage(driver);
	
	}
	

	@Test(priority =1)
	public void DocumentGenerations_TC_01() throws Exception {
		log("TC01 : Document generation Panel(Generate document) ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "DocumentGenrate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.DocGenerate, testcaseName);
		objDocument.verifyGenerateDocument(map,testcaseName);
	}
	
	
	@Test(priority =2, enabled=true)
	public void PreviewDocument_TC_02() throws Exception {
		log("TC02 : Document generation Panel(Preview document) ");
		String testcaseName = "DocumentGenrate" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TITLE_TEST_DATA), Excel.DocGenerate, testcaseName);
		objDocument.verifyPreviewDocument(map,testcaseName);
	}
	
}
