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
import pages.EncroachmentRequests.EncroachmentDocumentGenerationPage;



@Listeners(com.listeners.MyListeners.class)
public class EncroachmentGenerateDocumentTest extends BasePage{

	LoginPage objLogin;
	EncroachmentDocumentGenerationPage objDocument;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objDocument = new EncroachmentDocumentGenerationPage(driver);
	}
	

	@Test(priority =1)
	public void EncroachmentRequests_GenerateDocuement_TC_01() throws Exception {
		log("TC01 : Encroachment Requests - Generate Document");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "GenerateDocument" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.DocGenerate,testcaseName);
		objDocument.GenerateDocument(map,testcaseName);
		
	}
	
	@Test(priority =2)
	public void EncroachmentRequests_PreviewDocument_TC_02() throws Exception {
		log("TC02 : Document generation Panel(Preview document)");
		String testcaseName = "PreviewDocument" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ENCROACHMENT_REQUESTS_TEST_DATA), Excel.DocGenerate,testcaseName);
		objDocument.PreviewDocument(map,testcaseName);
		
	}
	
}
