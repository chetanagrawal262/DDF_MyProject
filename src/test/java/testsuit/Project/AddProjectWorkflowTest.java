package testsuit.Project;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;

import page.Common.LoginPage;
import pages.Project.AddProjectWorkflowPage;
import pages.tools.MyDashboardPage;

@Listeners(com.listeners.MyListeners.class)
public class AddProjectWorkflowTest extends BasePage {

	LoginPage objLogin;
	CommonFunction commonFunction;
	MyDashboardPage dashboardPage;
	ReadPropertyFile readPro = new ReadPropertyFile();
	AddProjectWorkflowPage projectWorkflow;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		projectWorkflow = new AddProjectWorkflowPage(driver);
		commonFunction = new CommonFunction(driver);
		dashboardPage = new MyDashboardPage(driver);
	}

	@Test(priority=1, enabled=true)
	public void Project_Workflow_GIS_Bulk_Processing_Document_Generation_09() throws Exception {
		if(!environment.contains("ORSTED") & !environment.contains("ATWELL")) {
		log("TC09 : Add a Project workflow -GIS Bulk Processing Document Generation ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ProjectApproval" + clientName;
		log("Data picked : " + testcaseName);
		log("Nevigate to Add Workflow");
		commonFunction.navigateToProjectDeails();
		commonFunction.projectSelection();
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_DETAILS_TEST_DATA), Excel.ProjectApproval,
				testcaseName);
		projectWorkflow.addNewWorkflow(map, testcaseName, true);
		projectWorkflow.submitTheFormForReview();
		projectWorkflow.closeApprovalForm();
		projectWorkflow.verifyStoredRecord(map,map.get(Excel.ApprovalType),testcaseName);
		if(map.get(Excel.ApprovalType).contains("GIS Bulk Processing Document Generation")) {		
			try {
				commonFunction.navigateToMyDashboard();
				log("STEP 29: Click on submit for review on the form", Status.PASS);
			} catch (Exception e) {
				log("STEP 29: Not Click on submit for review on the form", Status.FAIL);
				throw new RuntimeException("Failed in step 29");
			}
			try {
				dashboardPage.navigateToRequestedDocumentTab();
				
				log("STEP 30: Click on the requested documents tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 30: Not Click on the requested documents tab", Status.FAIL);
				throw new RuntimeException("Failed in step 30"); 
			}
			Assert.assertTrue(dashboardPage.isJobCreated("Requested"), "Job is not created");
			log("STEP 31: The Job created is listed under the tab", Status.PASS);
	}
		}else {
			log("GIS Bulk Processing Document Generation workflow is not applicable for orsted", Status.SKIP);
		}
	}
	
	
	
	
	
}
