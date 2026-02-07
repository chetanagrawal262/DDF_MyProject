package testsuit.ProjectDocumentGeneration;

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
import pages.ProjectDocumentGeneration.ProjectDocumentGenerationPage;



@Listeners(com.listeners.MyListeners.class)
public class ProjectGenerateDocumentTest extends BasePage{

	LoginPage objLogin;
	ProjectDocumentGenerationPage objDocument;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objDocument = new ProjectDocumentGenerationPage(driver);
	}
	

	@Test(priority =1)
	public void ProjectDocumentGenerations_GenerateDocuement_TC_01() throws Exception {
		log("TC01 : Document generation Panel(Generate document) ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "GenerateDocument" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.DocGenerate,
				testcaseName);
		objDocument.GenerateDocument(map,testcaseName);
		
	}
	
	@Test(priority =2)
	public void ProjectDocumentGeneration_PreviewDocument_TC_02() throws Exception {
		log("TC02 : Document generation Panel(Preview document)");
		String testcaseName = "PreviewDocument" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.DocGenerate,
				testcaseName);
		objDocument.PreviewDocument(map,testcaseName);
		
	}
	
}
