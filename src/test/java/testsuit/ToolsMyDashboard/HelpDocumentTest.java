package testsuit.ToolsMyDashboard;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import com.util.TestUtil;
import page.Common.LoginPage;
import pages.tools.HelpPage;

@Listeners(com.listeners.MyListeners.class)
public class HelpDocumentTest extends BasePage{
	
	LoginPage objLogin;
	HelpPage objHelpPage ;
	Map<String, String> map = new HashMap<String, String>();
	TestUtil util;
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objHelpPage = new HelpPage(driver);
		util = new TestUtil(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Learn_WEBAdminManual() throws Exception {
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		if(!environment.contains("AKUOENERGY") ) {
		objHelpPage.verifyWebAdminManual();
		}else {
			log("WEB Admin Manual is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 2, enabled = true)
	public void Learn_GisviewerAdminManual() throws Exception {
		objHelpPage.verifyGisviewerAdminManual();
	}

	@Test(priority = 3, enabled = true)
	public void Learn_MobileAdminManual() throws Exception {
		if(!environment.contains("PRIMERGY") & !environment.contains("ORSTED") & !environment.contains("ATWELL") & !environment.contains("AKUOENERGY")) {
		objHelpPage.verifyMobileAdminManual();
		}else {
			log("Mobile Admin Manual is not applicable for this client" ,Status.SKIP);
		}
	}

	@Test(priority = 4, enabled = true)
	public void Learn_ReportConfigurationManual() throws Exception {
		if(!clientName.contains("DOT")) {
		objHelpPage.verifyReportConfigurationManual();
		}else {
			log("Reports Configuration Manual is not applicable for DOT", Status.SKIP);
		}
	}

	@Test(priority = 5, enabled = true)
	public void Learn_WEBProductManual() throws Exception {
		if(!environment.contains("AKUOENERGY") ) {
		objHelpPage.verifyWEBProductManual();
		}else {
			log("WEB Product Manual is not applicable for this client", Status.SKIP);
		}
	}

	@Test(priority = 6, enabled = true)
	public void Learn_GISViewerProductManual() throws Exception {
		objHelpPage.verifyGISViewerProductManual();
	}

	@Test(priority = 7, enabled = true)
	public void Learn_MobileProductManual() throws Exception {
		if(!environment.contains("PRIMERGY") & !environment.contains("ORSTED") & !environment.contains("ATWELL") & !environment.contains("AKUOENERGY")) {
		objHelpPage.verifyMobileProductManual();
		}else {
			log("Mobile Product Manual is not applicable for this client" ,Status.SKIP);
		}
	}

	@Test(priority = 8, enabled = true)
	public void Learn_ImportsMappingManual() throws Exception {
		if(!clientName.contains("DOT")) {
		objHelpPage.verifyImportsMappingManual();
		}else {
			log("Imports Mapping Manual is not applicable for DOT", Status.SKIP);
		}
	}

	@Test(priority = 9, enabled = true)
	public void Learn_ReportsMappingManual() throws Exception {
		if(!clientName.contains("DOT")) {
		objHelpPage.verifyReportsMappingManual();
		}else {
			log("Reports Mapping Manual is not applicable for DOT", Status.SKIP);
		}
	}

	@Test(priority = 10, enabled = true)
	public void Learn_ReportsDevelopmentGuide() throws Exception {
		objHelpPage.verifyReportsDevelopmentGuide();
	}

	@Test(priority = 11, enabled = true)
	public void Learn_DocgenDevelopmentGuide() throws Exception {
		objHelpPage.verifyDocgenDevelopmentGuide();
	}

	@Test(priority = 12,enabled = true)
	public void Learn_TrainingCourses() throws Exception {
		objHelpPage.TraingCourses();
	}
	
	@Test(priority = 13,enabled = true)
	public void Learn_Feedback() throws Exception {
		objHelpPage.submitAnIdea();
	}
}
