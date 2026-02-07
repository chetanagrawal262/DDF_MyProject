package pages.ProjectImportROW;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;
import pages.projectImportALT.ProjectImportPage;

public class ParcelNumberUpdateImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	public ParcelNumberUpdateImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By navProjectMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navImfort = By.xpath("*//span[text()='Import'] | *//span[text()='Import'] | //*[@id=\"ctl00_ContentPlaceHolderHeader_YALHD_RadYALMenu\"]/ul/li[3]/div/ul/li[3]/a/span");
	public void navigateToImport() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navImfort);
		util.click(navImfort);

	}

	By viewErrorLog = By.xpath("//*[contains(@id,'ViewErrorLog')]/img");
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	By importMessage = By.xpath("//*[text()='Data imported successfully'] | //*[text()='Data was imported successfully to the selected project']");
	By errorMessage = By.xpath("//*[contains(text(),'error(s) exist in your import file.  Please click on View Errors for more details and try again.')]");
	By btnLoadDataProject = By.xpath("//input[contains(@id,'btnLoadTract')]");
	By parcelNo = By.xpath("//tr[contains(@id,'idYalImport_RadGridUpload_ctl00__0')]/td[1]");
	
	public void ParcelNumberUpdateImport(Map<String, String> map, String testcaseName) throws Exception {
		util.dummyWait(10);
		try {
			util.click(btnLoadDataProject);
			log("STEP 8:  User can able to click on Load Data to Project Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User can not able to click on Load Data to Project Button", Status.FAIL);
			throw new RuntimeException("Failed in step 8: User can not able to click on Load Data to Project Button");
		}
		util.dummyWait(10);
		try {
			Assert.assertTrue(util.isElementPresent(importMessage, 20), "Data import message not displayed");
  			WebElement element = driver.findElement(importMessage);
		new Actions(driver).moveToElement(element).perform();
			ExtentTestManager.infoWithScreenshot("Data Imported Successfully");
	        log("STEP 9:  Import Successfully :", Status.PASS);
		} catch (AssertionError t) {
			util.dummyWait(10);
			  util.click(viewErrorLog);
			  util.switchToChildWindow();
			  ExtentTestManager.infoWithScreenshot("Error Log Info");
			  util.click(downlodPDF); 
			  util.click(downloadExcel);
			  driver.close();
			  util.switchToParentWindow(); 
			  util.dummyWait(1);
			  log("STEP 9:  Import is not perform Successfully :", Status.FAIL);
			  throw new RuntimeException("Failed in step 9:  Import is not perform Successfully");
		}
		
	}
	
	public void verifyParcelNumberUpdateImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			ParcelNumberUpdateImportMapping(testcaseName);
			log("STEP 7:  All Land  Data Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.ParcelvalidationMsg(testcaseName); 
			objErrorLog.printErrorLog();
	        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
		} catch (Exception t) {
			  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
			  throw new RuntimeException("Failed in step 12");
		}
		
//		try {
//			  util.click(downlodPDF); 
//	        log("STEP 13:  User can click on PDF Icon", Status.PASS);
//		} catch (Exception t) {
//			  log("STEP 13:  User cannot click on PDF Icon", Status.FAIL);
//			  throw new RuntimeException("Failed in step 13");
//		}
		
		try {
			  driver.close();
			  util.switchToParentWindow(); 
			  util.dummyWait(1);
	        log("STEP 14:  User can close the popup", Status.PASS);
		} catch (Exception t) {
			  driver.close();
			  util.switchToParentWindow(); 
			  log("STEP 14:  User cannot close the popup", Status.FAIL);
			  throw new RuntimeException("Failed in step 14");
		}
	}
	
	By tractNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Current Parcel #: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TRACT_NUMBER') and @type='text'])[1]");
	public String getTractNumber() {		
		return util.getAttributeValue(tractNumber, "value");
	}
	
	By newtractNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='New Parcel #: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TractType_Tract_Type_ID') and @type='text'])[1]");
	public String getNewTractNumber() {
		return util.getAttributeValue(newtractNumber, "value");
	}
	By displayOrder = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Display Order: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TractType_Property_Type_ID') and @type='text'])[1]");
	public String getDisplayOrder() {
		return util.getAttributeValue(displayOrder, "value");
	}
	
	By loaderIcon = By.xpath("(//div[contains(@id,'_RadMultiPage1')])[1]");

	Map<String, String> excelData;
	public void ParcelNumberUpdateImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ParcelNumberUpdateMapping, testcaseName);
				assertion.assertEquals(getTractNumber(), excelData.get("Current Parcel #").trim(), "Current Parcel # mapping mismatched");
				ExtentTestManager.log("Current Parcel # Mapping : " +getTractNumber());
				
				assertion.assertEquals(getNewTractNumber(), excelData.get("New Parcel #").trim(), "New Parcel # mapping mismatched");
				ExtentTestManager.log("New Parcel # Mapping : " +getNewTractNumber());
				
				assertion.assertEquals(getDisplayOrder(), excelData.get("Display Order").trim(), "Display Order mapping mismatched");
				ExtentTestManager.log("Display Order Mapping : "+getDisplayOrder());
				assertion.assertAll();

			}
	
	
	public void verifyImportedParcelNumberUpdateData(Map<String, String> map, String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
	if(testcaseName.toLowerCase().contains("row")) {
			
				By addedRecord = By.xpath("//td[text()='"+map.get("Current Parcel #").trim()+"']/parent::tr");
				Assert.assertFalse(util.isElementPresent(addedRecord, 30), "Exiting Parcel not updated yet");
				ExtentTestManager.log("Existing/Previous Parcel # updated with New Parcel #");
				
				 By addedRecordNew = By.xpath("//td[text()='"+map.get("New Parcel #").trim()+"']/parent::tr");
				 Assert.assertTrue(util.isElementPresent(addedRecordNew, 30), "Record is not added yet");
				 ExtentTestManager.log("Newly updated parcel # visible  on parcel list");
					util.click(addedRecordNew);
					util.waitUntilElementDisappear(loaderIcon);
					
					assertion.assertEquals(getTractNumber(), map.get("New Parcel #").trim(), "Parcel number mismatched");
					ExtentTestManager.log("Parcel number matched : " +getTractNumber());
					
					assertion.assertAll();
			 }
		
		
}
			

	

}
