package testsuit.CustomControl;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import page.Common.LoginPage;
import pages.CustomControl.ConfigureFieldPermissionPage;
import pages.CustomControl.CustomControl_ADDRESSPage;
import pages.CustomControl.CustomControl_CHECKBOXPage;
import pages.CustomControl.CustomControl_COLLAPSIBLEPANELFieldPage;
import pages.CustomControl.CustomControl_CURRENCYFieldPage;
import pages.CustomControl.CustomControl_DATEFieldPage;
import pages.CustomControl.CustomControl_DDCOMBOPage;
import pages.CustomControl.CustomControl_DDTREEFiledPage;
import pages.CustomControl.CustomControl_DOCUMENTSUPLOADFiledPage;
import pages.CustomControl.CustomControl_DependentDDFieldPage;
import pages.CustomControl.CustomControl_FORMULATEXTFieldPage;
import pages.CustomControl.CustomControl_GEOGRIDFieldPage;
import pages.CustomControl.CustomControl_HTMLFORMULAFieldPage;
import pages.CustomControl.CustomControl_LABELFieldPage;
import pages.CustomControl.CustomControl_LTEXTPage;
import pages.CustomControl.CustomControl_MASKEDTEXTBOXFiledPage;
import pages.CustomControl.CustomControl_MSCOMBOFieldPage;
import pages.CustomControl.CustomControl_MULTIDOCUPLOADFiledPage;
import pages.CustomControl.CustomControl_NUMERICFiledPage;
import pages.CustomControl.CustomControl_PHONENUMBERFiledPage;
import pages.CustomControl.CustomControl_RADIOFieldPage;
import pages.CustomControl.CustomControl_RICHTEXTFieldPage;
import pages.CustomControl.CustomControl_SECTIONHEADERFieldPage;
import pages.CustomControl.CustomControl_TEXTFieldPage;
import pages.CustomControl.CustomControl_TIMEFiledPage;
import pages.CustomControl.CustomControl_WF;
import pages.CustomControl.DeleteCustomControlFieldsPage;

@Listeners(com.listeners.MyListeners.class)

public class CustomControlFieldsTestDOT extends BasePage{


	LoginPage objLogin;
	CustomControl_LTEXTPage objCustomControlLTEXT;
	CustomControl_DDCOMBOPage objCustomControlDDCOMBO;
	CustomControl_ADDRESSPage objCustomControlADDRESS;
	CustomControl_CHECKBOXPage objCustomControlCHECKBOX;
	CustomControl_TIMEFiledPage objCustomControlTIME;
	CustomControl_COLLAPSIBLEPANELFieldPage objCustomControlCOLLAPSIBLEPANEL;
	CustomControl_CURRENCYFieldPage objCustomControlCURRENCY;
	CustomControl_DATEFieldPage objCustomControlDATE;
	CustomControl_DDTREEFiledPage objCustomControlDDTREE;
	CustomControl_DOCUMENTSUPLOADFiledPage objCustomControlDOCUMENTSUPLOAD;
	CustomControl_FORMULATEXTFieldPage objCustomControlFORMULATEXT;
	CustomControl_GEOGRIDFieldPage objCustomControlGEOGRID;
	CustomControl_HTMLFORMULAFieldPage objCustomControlHTMLFORMULA;
	CustomControl_LABELFieldPage objCustomControlLABEL;
	CustomControl_MASKEDTEXTBOXFiledPage objCustomControlMASKEDTEXTBOX;
	CustomControl_MSCOMBOFieldPage objCustomControlMSCOMBO;
	CustomControl_MULTIDOCUPLOADFiledPage objCustomControlMULTIDOCUPLOAD;
	CustomControl_NUMERICFiledPage objCustomControlNUMERIC;
	CustomControl_PHONENUMBERFiledPage objCustomControlPHONENUMBER;
	CustomControl_RADIOFieldPage objCustomControlRADIO;
	CustomControl_RICHTEXTFieldPage objCustomControlRICHTEXT;
	CustomControl_SECTIONHEADERFieldPage objCustomControlSECTIONHEADER;
	CustomControl_TEXTFieldPage objCustomControlTEXT;
	CustomControl_WF objCustomControl_WF;
	ConfigureFieldPermissionPage objFieldPermission;
	DeleteCustomControlFieldsPage objDeleteCustomControlFieldsPage;
	CustomControl_DependentDDFieldPage objCustomControlDependentDD;
	
	Map<String, String> map = new HashMap<String, String>();

	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objCustomControlLTEXT = new CustomControl_LTEXTPage(driver);
		objCustomControlDDCOMBO = new CustomControl_DDCOMBOPage(driver);
		objCustomControlADDRESS = new CustomControl_ADDRESSPage(driver);
		objCustomControlCHECKBOX = new CustomControl_CHECKBOXPage(driver);
		objCustomControlTIME = new CustomControl_TIMEFiledPage(driver);
		objCustomControlCOLLAPSIBLEPANEL = new CustomControl_COLLAPSIBLEPANELFieldPage(driver);
		objCustomControlCURRENCY = new CustomControl_CURRENCYFieldPage(driver);
		objCustomControlDATE = new CustomControl_DATEFieldPage(driver);
		objCustomControlDDTREE = new CustomControl_DDTREEFiledPage(driver);
		objCustomControlDOCUMENTSUPLOAD = new CustomControl_DOCUMENTSUPLOADFiledPage(driver);
		objCustomControlFORMULATEXT = new CustomControl_FORMULATEXTFieldPage(driver);	
		objCustomControlGEOGRID = new CustomControl_GEOGRIDFieldPage(driver);
		objCustomControlHTMLFORMULA = new CustomControl_HTMLFORMULAFieldPage(driver);
		objCustomControlLABEL = new CustomControl_LABELFieldPage(driver);
		objCustomControlMASKEDTEXTBOX = new CustomControl_MASKEDTEXTBOXFiledPage(driver);
		objCustomControlMSCOMBO = new CustomControl_MSCOMBOFieldPage(driver);
		objCustomControlMULTIDOCUPLOAD = new CustomControl_MULTIDOCUPLOADFiledPage(driver);
		objCustomControlNUMERIC = new CustomControl_NUMERICFiledPage(driver);
		objCustomControlPHONENUMBER = new CustomControl_PHONENUMBERFiledPage(driver);
		objCustomControlRADIO = new CustomControl_RADIOFieldPage(driver);
		objCustomControlRICHTEXT = new CustomControl_RICHTEXTFieldPage(driver);
		objCustomControlSECTIONHEADER = new CustomControl_SECTIONHEADERFieldPage(driver);
		objCustomControlTEXT = new CustomControl_TEXTFieldPage(driver);
		objCustomControl_WF = new CustomControl_WF(driver);
		objFieldPermission = new ConfigureFieldPermissionPage(driver);
		objDeleteCustomControlFieldsPage  = new DeleteCustomControlFieldsPage(driver);
		objCustomControlDependentDD = new CustomControl_DependentDDFieldPage(driver);
	}
	
	@Test(priority = 1,enabled = true)
	public void Custom_Control_LTEXT_TC_01() throws Exception {
		log("TC01 : Verify LTEXT Custom control field on the parcel details ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "CustomControl_LTEXT";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlLTEXT.CustomControl(map, testcaseName);

	}
	
//	@Test(priority = 2,enabled = true) // don't use
//	public void Custom_Control_ADDRESS_TC_02() throws Exception {
//		log("TC02 : verify ADDRESS Custom Control field on the parcel details  ");
//		String testcaseName = "CustomControl_ADDRESS";
//		log("Data picked : " + testcaseName);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
//		objCustomControlADDRESS.CustomControl(map, testcaseName);
//
//	}
	
	@Test(priority = 3,enabled = true)
	public void Custom_Control_CHECKBOX_TC_03() throws Exception {
		log("TC03 : verify CHECKBOX Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_CHECKBOX";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlCHECKBOX.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 4,enabled = true)
	public void Custom_Control_TIME_TC_04() throws Exception {
		log("TC04 : Verify TIME Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_TIME";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlTIME.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 5,enabled = true)
	public void Custom_Control_COLLAPSIBLEPANEL_TC_05() throws Exception {
		log("TC05 :  verify COLLAPSIBLEPANEL Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_COLLAPSIBLEPANEL";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlCOLLAPSIBLEPANEL.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 6,enabled = true)
	public void Custom_Control_CURRENCY_TC_06() throws Exception {
		log("TC06 :  verify CURRENCY Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_CURRENCY";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlCURRENCY.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 7,enabled = true)
	public void Custom_Control_DATE_TC_07() throws Exception {
		log("TC07 : verify DATE Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_DATE";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlDATE.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 8,enabled = true)
	public void Custom_Control_DOCUMENTSUPLOAD_TC_08() throws Exception {
		log("TC08 : verify DOCUMENTSUPLOAD Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_DOCUMENTSUPLOAD";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlDOCUMENTSUPLOAD.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 9,enabled = true)
	public void Custom_Control_FORMULATEXT_TC_09() throws Exception {
		log("TC09 :  verify FORMULATEXT Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_FORMULATEXT";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlFORMULATEXT.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 10,enabled = true)
	public void Custom_Control_HTMLFORMULA_TC_10() throws Exception {
		log("TC10 : verify HTMLFORMULA Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_HTMLFORMULA";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlHTMLFORMULA.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 11,enabled = true)
	public void Custom_Control_LABEL_TC_11() throws Exception {
		log("TC11 : verify LABEL Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_LABEL";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlLABEL.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 12,enabled = true)
	public void Custom_Control_MASKEDTEXTBOX_TC_12() throws Exception {
		log("TC12 : verify MASKEDTEXTBOX Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_MASKEDTEXTBOX";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlMASKEDTEXTBOX.CustomControl(map, testcaseName);

	}
	
	
	
	
	@Test(priority = 13,enabled = true)
	public void Custom_Control_MULTIDOCUPLOAD_TC_13() throws Exception {
		log("TC13 :  verify MULTIDOCUPLOAD fields on the parcel details  ");
		String testcaseName = "CustomControl_MULTIDOCUPLOAD";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlMULTIDOCUPLOAD.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 14,enabled = true)
	public void Custom_Control_NUMERIC_TC_14() throws Exception {
		log("TC14 :  verify NUMERIC Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_NUMERIC";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlNUMERIC.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 15,enabled = true)
	public void Custom_Control_PHONENUMBER_TC_15() throws Exception {
		log("TC15 : verify PHONENUMBER Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_PHONENUMBER";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlPHONENUMBER.CustomControl(map, testcaseName);

	}
	
	

	@Test(priority = 16,enabled = true)
	public void Custom_Control_RADIO_TC_16() throws Exception {
		log("TC16 : verify RADIO Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_RADIO";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlRADIO.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 17,enabled = true)
	public void Custom_Control_RICHTEXT_TC_17() throws Exception {
		log("TC17 : verify RICHTEXT Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_RICHTEXT";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlRICHTEXT.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 18,enabled = true)
	public void Custom_Control_SECTIONHEADER_TC_18() throws Exception {
		log("TC18 :  verify SECTIONHEADER Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_SECTIONHEADER";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlSECTIONHEADER.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 19,enabled = true)
	public void Custom_Control_TEXT_TC_19() throws Exception {
		log("TC19 : verify TEXT Custom Control field on the parcel details  ");

		String testcaseName = "CustomControl_TEXT";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlTEXT.CustomControl(map, testcaseName);

	}

//	@Test(priority = 26,enabled = true)//need to update
//	public void Configure_Field_Permission_TC_20() throws Exception {
//		log("TC20 : Configure Field Permission ");
//		navigateToApplication(appURL);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
//		objLogin.login(map);
//		String testcaseName = "ConfigureFieldPermission" + clientName;
//		log("Data picked : " + testcaseName);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.Permission, testcaseName);
//		objFieldPermission.ConfigureFieldPermission(map, testcaseName);
//	}
	
//	@Test(priority = 21,enabled = true)
//	public void Custom_Cpntrol_WF_TC_21() throws Exception {
//		log("TC21 : Verify Custom Control Fields on Wf");
//		String testcaseName = "CustomControlParcelApproval" + clientName;
//		log("Data picked : " + testcaseName);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlWF, testcaseName);
//		objCustomControl_WF.VerifyCustomFieldsOnWF(map, testcaseName);
//	}
	
	@Test(priority =22 ,enabled = true)
	public void Custom_Control_DDCOMBO_TC_22() throws Exception {
		log("TC22 : verify DDCOMBO Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_DDCOMBO";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlDDCOMBO.CustomControl(map, testcaseName);

	}
	
	@Test(priority =23 ,enabled = true)
	public void Custom_Control_DDTREE_TC_23() throws Exception {
		log("TC23 : verify DDTREE Custom Control field on the parcel details  ");
	    String testcaseName = "CustomControl_DDTREE";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlDDTREE.CustomControl(map, testcaseName);

	}
	
	
	@Test(priority = 24,enabled = true)
	public void Custom_Control_MSCOMBO_TC_24() throws Exception {
		log("TC24 : verify MSCOMBO Custom Control field on the parcel details  ");
		String testcaseName = "CustomControl_MSCOMBO";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlMSCOMBO.CustomControl(map, testcaseName);

	}
	@Test(priority = 25,enabled = true)
	public void Custom_Control_GEOGRID_TC_25() throws Exception {
		log("TC25 :  verify GEOGRID Custom Control field on the parcel details  ");
     	String testcaseName = "CustomControl_GEOGRID";
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlGEOGRID.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 26,enabled = true)
	public void Custom_Control_CascadingDD_TC_26() throws Exception {
		log("TC26 : verify Cascading DD Custom Control field on the parcel details  ");
    	String testcaseName = "CustomControl_DEPENDENTDD";
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CUSTOM_CONTROL_TEST_DATA), Excel.CustomControlDOT, testcaseName);
		objCustomControlDependentDD.CustomControl(map, testcaseName);

	}
	
	@Test(priority = 27,enabled = true)
	public void Delete_Custom_Control_Fields() throws Exception {
		log("TC27 : Delete all Custom control field on the parcel details ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "CustomControl";
		log("Data picked : " + testcaseName);
		objDeleteCustomControlFieldsPage.DeleteCustomControlFields(map, testcaseName);	

	}
	
}

