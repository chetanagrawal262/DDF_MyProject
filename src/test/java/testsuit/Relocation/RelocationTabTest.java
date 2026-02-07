package testsuit.Relocation;

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
import pages.Relocation.AddNewRelocationInformationPage;
import pages.Relocation.AddRelocationOnFileRecordPage;
import pages.Relocation.DeleteRelocationInformationRecordPage;
import pages.Relocation.DeleteRelocationRecordPage;
import pages.Relocation.EditRelocationInformationPage;
import pages.Relocation.EditRelocationOnFilePage;
import pages.Relocation.PendingRelocationFormPage;
import pages.Relocation.RelocationTabPage;
import pages.Relocation.RelocationformsPage;


@Listeners(com.listeners.MyListeners.class)
public class RelocationTabTest extends BasePage{

	LoginPage objLogin;
	RelocationTabPage objRelocationTab;
	AddRelocationOnFileRecordPage objAddRelocationOnFileRecord;
	EditRelocationOnFilePage objEditRelocationOnFile;
	DeleteRelocationRecordPage objDeleteRelocationRecord;
	AddNewRelocationInformationPage objAddNewRelocationInformation;
	EditRelocationInformationPage objEditRelocationInformation;
	DeleteRelocationInformationRecordPage objDeleteRelocationInformationRecord;
	RelocationformsPage objRelocationforms;
	PendingRelocationFormPage objPendingRelocationForm;
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
	driver = getDriver();
	objLogin = new LoginPage(driver);
	objRelocationTab = new RelocationTabPage(driver);
	objAddRelocationOnFileRecord = new AddRelocationOnFileRecordPage(driver);
	objEditRelocationOnFile = new EditRelocationOnFilePage(driver);
	objDeleteRelocationRecord = new DeleteRelocationRecordPage(driver);
	objAddNewRelocationInformation = new AddNewRelocationInformationPage(driver);
	objEditRelocationInformation = new EditRelocationInformationPage(driver);
	objDeleteRelocationInformationRecord = new DeleteRelocationInformationRecordPage(driver);
	objRelocationforms = new RelocationformsPage(driver);
	objPendingRelocationForm = new PendingRelocationFormPage(driver);
	}
	
	
	@Test(priority =1 )
	public void RelocationTab_TC_01() throws Exception {
		log("TC01 :Relocation Tab ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "RelocationTab" + clientName;
		log("Data picked : " + testcaseName);
		objRelocationTab.RelocationTab(testcaseName);
	}
	
	
//	  @Test(priority =2 ,enabled=false) //panel no more exits in 23.12
//	  public void AddRelocationOnFileRecord_TC_02() throws
//	  Exception { log("TC02 :Add Relocation on file record"); 
//	  String testcaseName = "AddRelocationOnFileRecord" + clientName;
//	  log("Data picked : " + testcaseName); 
//	  map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA),Excel.AddRelocationOnFileRecord,testcaseName);
//	  objAddRelocationOnFileRecord.AddRelocationOnFileRecord(map, testcaseName); }
	  
	  
//	  @Test(priority =3,enabled=false )//panel no more exits in 23.12
//	  public void EditRelocationOnFile_TC_03() throws Exception { 
//	  log("TC03 :Edit Relocation on file record"); 
//	  String testcaseName ="EditRelocationOnFile" + clientName; 
//	  log("Data picked : " + testcaseName);
//	  map =ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA),Excel.EditRelocationOnFile,testcaseName);
//	  objEditRelocationOnFile.EditRelocationOnFile(map, testcaseName);
//	    
//	  }
	  
//	  @Test(priority =4,enabled=false ) //panel no more exits in 23.12
//	  public void DeleteRelocationRecord_TC_04() throws Exception {
//	  log("TC04 :delete  Relocation on  file  record"); 
//	  String testcaseName = "DeleteRelocationRecord" + clientName; 
//	  log("Data picked : " +testcaseName);
//	  objDeleteRelocationRecord.DeleteRelocationRecord(testcaseName);
//	  
//	  }
	  
	  @Test(priority =2,enabled=true ) 
	  public void AddNewRelocationInformation_TC_02() throws Exception { 
	  log("TC02 :Add new relocation information"); 
	  String testcaseName = "AddNewRelocationInformation" + clientName; 
	  log("Data picked : " + testcaseName); 
	  map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddNewRelocationInformation,testcaseName);
	  objAddNewRelocationInformation.AddNewRelocationInformation(map,  testcaseName); 
	  }
	  
	  @Test(priority =3,enabled=true ) 
	  public void EditRelocationInformation_TC_03() throws Exception { 
	  log("TC03 :Edit relocation information"); 
	  String testcaseName = "EditRelocationInformation" + clientName; 
	  log("Data picked : " +testcaseName); 
	  map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA),Excel.EditRelocationInformation,testcaseName);
	  objEditRelocationInformation.EditRelocationInformation(map, testcaseName); 
	  }
	  
	  @Test(priority =4,enabled=true )
	  public void DeleteRelocationInformationRecord_TC_04()throws Exception { 
	  log("TC04 :Delete  relocation information record"); 
	  String testcaseName = "DeleteRelocationInformationRecord" + clientName;
	  log("Data picked : " + testcaseName);
	  objDeleteRelocationInformationRecord.DeleteRelocationInformationRecord(testcaseName);
	  
	  }
	 
	
//	@Test(priority =5 )
//	public void Relocation_Forms_TC_05() throws Exception {
//		log("TC05 :Relocation forms");
//		String testcaseName = "Relocationforms" + clientName;
//		log("Data picked : " + testcaseName);
//		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.Relocationforms,testcaseName);
//		objPendingRelocationForm.PendingRelocationforms(map, testcaseName);
//		objRelocationforms.Relocationforms(map, testcaseName);
//	}
	
}
