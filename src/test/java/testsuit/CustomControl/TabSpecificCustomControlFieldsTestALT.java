package testsuit.CustomControl;

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
import pages.CustomControl.TabSpecific_CustomControl_Page;

@Listeners(com.listeners.MyListeners.class)

public class TabSpecificCustomControlFieldsTestALT extends BasePage{

	CommonFunction commonFunction;
	LoginPage objLogin;
	TabSpecific_CustomControl_Page objTabSpecific_CustomControl_Page;
	
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		commonFunction = new CommonFunction(driver);
		objLogin = new LoginPage(driver);
	    objTabSpecific_CustomControl_Page = new TabSpecific_CustomControl_Page(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Parcel_Information_Tab_Specific_Custom_Control_Fields_TC() throws Exception {
		log("TC01 : Verify Tab Specific Custom control field on the parcel Information Tab ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "ParcelInformationTabSpecificCustomControl";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.TabSpecificCustomControl, testcaseName);
		objTabSpecific_CustomControl_Page.verifyCustomControl(map, testcaseName);
	}
	
	@Test(priority = 2,enabled = true)
	public void Acquisition_Tab_Specific_Custom_Control_Fields_TC() throws Exception {
		if(!environment.contains("ORION") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO")) {
		log("TC02 : Verify Tab Specific Custom control field on the Acquisition Tab ");
		String testcaseName = "AcquisitionTabSpecificCustomControl";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.TabSpecificCustomControl, testcaseName);
		objTabSpecific_CustomControl_Page.NavigateToAcquisition();
		objTabSpecific_CustomControl_Page.verifyCustomControl(map, testcaseName);
		}else {
			log("This Tab not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 3,enabled = true)
	public void Survey_Tab_Specific_Custom_Control_Fields_TC() throws Exception {
		if(!environment.contains("WSBALT") & !environment.contains("ORION") & !environment.contains("NOVA") & !environment.contains("CONNECTGEN") & !environment.contains("GRAYHAWKALT") & !environment.contains("AVANTUS") & !environment.contains("AKUOENERGY")) {
		log("TC03 : Verify Tab Specific Custom control field on the Survey Tab ");
		String testcaseName = "SurveyTabSpecificCustomControl";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.TabSpecificCustomControl, testcaseName);
		objTabSpecific_CustomControl_Page.NavigateToSurvey();
		objTabSpecific_CustomControl_Page.verifyCustomControl(map, testcaseName);
		}else {
			log("This Tab not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 4,enabled = true)
	public void Title_Tab_Specific_Custom_Control_Fields_TC() throws Exception {
		if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("PRIMERGY") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("GRAYHAWKALT")) {
		log("TC04 : Verify Tab Specific Custom control field on the Title Tab ");
		String testcaseName = "TitleTabSpecificCustomControl";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.TabSpecificCustomControl, testcaseName);
		objTabSpecific_CustomControl_Page.NavigateToTitle();
		objTabSpecific_CustomControl_Page.verifyCustomControl(map, testcaseName);
		}else {
			log("This Tab not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 5,enabled = true)
	public void Documents_Tab_Specific_Custom_Control_Fields_TC() throws Exception {
		log("TC05 : Verify Tab Specific Custom control field on the Documents Tab ");
		String testcaseName = "DocumentsTabSpecificCustomControl";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.TabSpecificCustomControl, testcaseName);
		objTabSpecific_CustomControl_Page.NavigateToDocument();
		objTabSpecific_CustomControl_Page.verifyCustomControl(map, testcaseName);
	}
	
	@Test(priority = 6,enabled = true)
	public void ParcelNotes_Tab_Specific_Custom_Control_Fields_TC() throws Exception {
		if(!environment.contains("ORION")) {
		log("TC06 : Verify Tab Specific Custom control field on the Parcel Notes Tab ");
		String testcaseName = "ParcelNotesTabSpecificCustomControl";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.TabSpecificCustomControl, testcaseName);
		objTabSpecific_CustomControl_Page.NavigateToParcelNotes();
		objTabSpecific_CustomControl_Page.verifyCustomControl(map, testcaseName);
		}else {
			log("This Tab not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 7,enabled = true)
	public void ParmanentInfrastructure_Tab_Specific_Custom_Control_Fields_TC() throws Exception {
		if(!environment.contains("VERDANTERRA") & !environment.contains("ORION")) {
		log("TC07 : Verify Tab Specific Custom control field on the Permanent Infrastructure Tab ");
		String testcaseName = "PermanentInfrastructureTabSpecificCustomControl";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.TabSpecificCustomControl, testcaseName);
		objTabSpecific_CustomControl_Page.NavigateToPermanentInfrastructure();
		objTabSpecific_CustomControl_Page.verifyCustomControl(map, testcaseName);
		}else {
			log("This Tab not applicable for this client", Status.SKIP);
		}
	}
	
	@Test(priority = 8,enabled = true)
	public void Assignment_Tab_Specific_Custom_Control_Fields_TC() throws Exception {
		if(!environment.contains("ORSTED") & !environment.contains("NOVA") & !environment.contains("BAYWA") & !environment.contains("WSBALT") & !environment.contains("AVANTUS") & !environment.contains("GRAYHAWKALT") & !environment.contains("RAMACO") & !environment.contains("ORION")) {
		log("TC08 : Verify Tab Specific Custom control field on the Permanent Infrastructure Tab ");
		String testcaseName = "AssignmentTabSpecificCustomControl";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.TabSpecificCustomControl, testcaseName);
		objTabSpecific_CustomControl_Page.NavigateToAssignments();
		objTabSpecific_CustomControl_Page.verifyCustomControl(map, testcaseName);
		}else {
			log("This Tab not applicable for this client", Status.SKIP);
		}
	}
}

