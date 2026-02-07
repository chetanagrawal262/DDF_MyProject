package testsuit.Acquistion;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.ExcelUtils;
import com.util.ReadPropertyFile;
import page.Common.LoginPage;
import pages.Acquistion.AcquistionTabPage;


import pages.Acquistion.AddOfferTrackingPage;
import pages.Acquistion.AddRecordingInformationPage;
import pages.Acquistion.AddSpecialConditionsPage;
import pages.Acquistion.AddaRowDimensionsPage;




@Listeners(com.listeners.MyListeners.class)
public class AcquistionTabTest extends BasePage{
 
	LoginPage objLogin;
	AcquistionTabPage objAcquistionTab;
	AddaRowDimensionsPage objAddaRowDimensions;
	AddRecordingInformationPage objAddRecordingInformation;
	
	AddOfferTrackingPage objAddOfferTracking;
	AddSpecialConditionsPage objAddSpecialConditions;
	
	ReadPropertyFile readPro = new ReadPropertyFile();
	Map<String, String> map = new HashMap<String, String>();
	
	@BeforeClass
	public void setup() throws Exception {
		driver = getDriver();
		objLogin = new LoginPage(driver);
		objAcquistionTab = new AcquistionTabPage(driver);
		objAddaRowDimensions = new AddaRowDimensionsPage(driver);
		objAddRecordingInformation = new AddRecordingInformationPage(driver);
	
		objAddOfferTracking = new AddOfferTrackingPage(driver);
		objAddSpecialConditions = new AddSpecialConditionsPage(driver);
	
	}
	
	@Test(priority =1 )
	public void AcquistionTab_TC_01() throws Exception {
		if(!environment.contains("ORION") & !environment.contains("VERDANTERRA") & !environment.contains("RAMACO") & !environment.contains("VALARD")) {
		log("TC01 :Acquistion Tab ");
		navigateToApplication(appURL);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.LOGIN_TEST_DATA), Excel.Login, environment);
		objLogin.login(map);
		String testcaseName = "AcquistionTab" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AcquistionTab,testcaseName);
		objAcquistionTab.AcquistionTab(map, testcaseName);
		}else {
			log("This client don't use this tab", Status.SKIP);
		}
   }
	
	@Test(priority =2 , enabled=true)
	public void AddRowDimensions_TC_02() throws Exception {
		if(!environment.contains("VALARD")) {
		log("TC02 :Add Row Dimensions/Edit row dimension/Delete Row dimensions");
		String testcaseName = "AddaRowDimensions" + clientName;
		log("Data picked : " + testcaseName);
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddaRowDimensions,testcaseName);
		objAddaRowDimensions.AddaRowDimensions(map, testcaseName);
		}else {
			log("This client don't use this tab", Status.SKIP);
		}
	}
	
	
//	@Test(priority =3, enabled=false )//panel no more exists on 23.12 version
	//	public void AddRecordingInformation_TC_03() throws Exception {
//		log("TC03 :Add a Recording Information");
//		String testcaseName = "AddRecordingInformation" + clientName;
//		log("Data picked : " + testcaseName);
//			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddRecordingInformation,testcaseName);
//			objAddRecordingInformation.AddRecordingInformation(map, testcaseName);
//	 
//		
//	}
	
	
	
	@Test(priority =4 , enabled=true)
	public void AddOfferTracking_TC_04() throws Exception {
		if(!environment.contains("MVEA") & !environment.contains("TRA") & !environment.contains("GRAYHAWKTCE") & !environment.contains("GRIDUNITED") & !environment.contains("VALARD")) {
		log("TC05 :Add a Offer Tracking");
		String testcaseName = "AddOfferTracking" + clientName;
		log("Data picked : " + testcaseName);	
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddOfferTracking,testcaseName);
			objAddOfferTracking.AddOfferTracking(map, testcaseName);
		}else {
			log("This client don't use this tab", Status.SKIP);
		}
	}
	
	@Test(priority =5, enabled=true )
	public void AddSpecialConditions_TC_05() throws Exception {
		if(!environment.contains("VALARD") & !environment.contains("CRIMSON") & !environment.contains("TRA")) {
		log("TC06 :Add a Special Conditions");
		String testcaseName = "AddSpecialConditions" + clientName;
		log("Data picked : " + testcaseName);	
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PARCEL_TEST_DATA), Excel.AddSpecialConditions,testcaseName);
			objAddSpecialConditions.AddSpecialConditions(map, testcaseName);
		}else {
			log("This client don't use this tab", Status.SKIP);
		}
	}
	
	
	
	
		
	
	
}
