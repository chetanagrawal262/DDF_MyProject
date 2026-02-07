package testsuit.ToolsBulkEdit;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import page.Common.LoginPage;
import pages.ToolsBulkEdit.BulkEdit_MyApprovalPage;
import pages.ToolsBulkEdit.ConfigureFormPage;

@Listeners(com.listeners.MyListeners.class)

public class BulkEdit_MyApprovalTest extends BasePage{

	LoginPage objLogin;
	CommonFunction commonFunction;
	ConfigureFormPage objFormConfig;
	BulkEdit_MyApprovalPage objMyApproval;
	Map<String, String> map = new HashMap<String, String>();
	
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		commonFunction = new CommonFunction(driver);
		objFormConfig = new ConfigureFormPage(driver);
		objMyApproval = new BulkEdit_MyApprovalPage(driver);
	}
	
	@Test(priority=1, enabled=true)
	public void Add_Project_Workflow_TC_01() throws Exception {
		log("TC 01. : Add Project Workflow");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.loginWithSuperAdmin(map);
		String testcaseName = "ProjectFormConfig" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.BulkEditMyApproval, testcaseName);
		commonFunction.navigateToProjectDeails();
		commonFunction.projectSelection();
		objFormConfig.WorkflowConfiguration(map, testcaseName);
	}
	
	@Test(priority=2, enabled=true)
	public void Add_Parcel_Workflow_TC_02() throws Exception {
		if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("CONNECTGEN") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("NOVA")) {
		log("TC 02 : Add Parcel Workflow");
		String testcaseName = "ParcelFormConfig" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), Excel.BulkEditMyApproval, testcaseName);
		objFormConfig.WorkflowConfiguration(map, testcaseName);
		}else {
			log("This TC is not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority=3, enabled=true)
	public void MyApproval_Grouping_And_Sorting_TC_03() throws Exception {
		log("TC 03 : Verify Grouping and Sorting");
		String testcaseName = "GroupingSorting" + clientName;
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TOOL_TEST_DATA), "GroupingSorting", testcaseName);
		objMyApproval.verifyGroupingAndSorting(map, testcaseName);
	}
	
}
