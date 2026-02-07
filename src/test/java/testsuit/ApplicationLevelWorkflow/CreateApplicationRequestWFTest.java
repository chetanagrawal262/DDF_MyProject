package testsuit.ApplicationLevelWorkflow;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import page.Common.LoginPage;
import pages.tools.ApproveApplicationLevelWorkflowPage;
import pages.tools.ConfiguredApplicationLevelWorkflow;
import pages.tools.RejectApplicationLevelWorkflowPage;

@Listeners(com.listeners.MyListeners.class)

public class CreateApplicationRequestWFTest extends BasePage{

	LoginPage objLogin;
	ConfiguredApplicationLevelWorkflow objConfiguredApplicationLevelWorkflow;
	ApproveApplicationLevelWorkflowPage objApproveApplicationLevelWorkflowPage;
	RejectApplicationLevelWorkflowPage objRejectApplicationLevelWorkflowPage;
	Map<String, String> map = new HashMap<String, String>();
	

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objConfiguredApplicationLevelWorkflow = new ConfiguredApplicationLevelWorkflow(driver);
		objApproveApplicationLevelWorkflowPage = new ApproveApplicationLevelWorkflowPage(driver);
		objRejectApplicationLevelWorkflowPage = new RejectApplicationLevelWorkflowPage(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Configured_CalendarDays_ApplicationLevelWorkflow_TC01() throws Exception {
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "CreateApplicationRequest" + clientName;
		String Scenario = "s1_CalendarDays";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.CreateApplicationRequests, testcaseName);
		objConfiguredApplicationLevelWorkflow.ConfiguredApplicationLevelWF(map, testcaseName, Scenario);
		
	}
		
	@Test(priority = 2,enabled = true)
	public void Approve_CalendarDays_ApplicationLevelWorkflow_TC02() throws Exception {
		String testcaseName = "CreateApplicationRequest" + clientName;
		String Scenario = "s1_CalendarDays";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.CreateApplicationRequests, testcaseName);
		objApproveApplicationLevelWorkflowPage.addNewWorkflow(map, testcaseName, Scenario);
	}
	
	@Test(priority = 3,enabled = true)
	public void Reject_CalendarDays_ApplicationLevelWorkflow_TC03() throws Exception {
		String testcaseName = "CreateApplicationRequest" + clientName;
		String Scenario = "s1_CalendarDays";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.CreateApplicationRequests, testcaseName);
		objRejectApplicationLevelWorkflowPage.addRejectedWorkflow(map, testcaseName, Scenario);
	}
	
	@Test(priority = 4,enabled = true)
	public void Configured_BusinessDays_ApplicationLevelWorkflow_TC04() throws Exception {
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "CreateApplicationRequest" + clientName;
		String Scenario = "s2_BusinessDays";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.CreateApplicationRequests, testcaseName);
		objConfiguredApplicationLevelWorkflow.ConfiguredApplicationLevelWF(map, testcaseName, Scenario);
	}
	
	@Test(priority = 5,enabled = true)
	public void Approve_BusinessDays_ApplicationLevelWorkflow_TC05() throws Exception {
		String testcaseName = "CreateApplicationRequest" + clientName;
		String Scenario = "s2_BusinessDays";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.CreateApplicationRequests, testcaseName);
		objApproveApplicationLevelWorkflowPage.addNewWorkflow(map, testcaseName, Scenario);
	}
	
	@Test(priority = 6,enabled = true)
	public void Reject_BusinessDays_ApplicationLevelWorkflow_TC06() throws Exception {
		String testcaseName = "CreateApplicationRequest" + clientName;
		String Scenario = "s2_BusinessDays";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.CreateApplicationRequests, testcaseName);
		objRejectApplicationLevelWorkflowPage.addRejectedWorkflow(map, testcaseName, Scenario);
	}
	
	@Test(priority = 7,enabled = true)
	public void Configured_WithoutSLA_ApplicationLevelWorkflow_TC07() throws Exception {
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "CreateApplicationRequest" + clientName;
		String Scenario = "s3_WithoutSLA";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.CreateApplicationRequests, testcaseName);
		objConfiguredApplicationLevelWorkflow.ConfiguredApplicationLevelWF(map, testcaseName, Scenario);
	}
	@Test(priority = 8,enabled = true)
	public void Approve_WithoutSLA_ApplicationLevelWorkflow_TC08() throws Exception {
		String testcaseName = "CreateApplicationRequest" + clientName;
		String Scenario = "s3_WithoutSLA";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.CreateApplicationRequests, testcaseName);
		objApproveApplicationLevelWorkflowPage.addNewWorkflow(map, testcaseName, Scenario);
	}
	
	@Test(priority = 9,enabled = true)
	public void Reject_WithoutSLA_ApplicationLevelWorkflow_TC09() throws Exception {
		String testcaseName = "CreateApplicationRequest" + clientName;
		String Scenario = "s3_WithoutSLA";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.CreateApplicationRequests, testcaseName);
		objRejectApplicationLevelWorkflowPage.addRejectedWorkflow(map, testcaseName, Scenario);
	}
}
