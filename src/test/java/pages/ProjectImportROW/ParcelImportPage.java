package pages.ProjectImportROW;

import java.util.HashMap;
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

public class ParcelImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	public ParcelImportPage(WebDriver driver) {
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
	By importMessage = By.xpath("//*[text()='Data imported successfully']");
	By errorMessage = By.xpath("//*[contains(text(),'error(s) exist in your import file.  Please click on View Errors for more details and try again.')]");
	By btnLoadDataProject = By.xpath("//input[contains(@id,'btnLoadTract')]");
	By parcelNo = By.xpath("//tr[contains(@id,'idYalImport_RadGridUpload_ctl00__0')]/td[1]");
	
	public void ParcelImport(Map<String, String> map, String testcaseName) throws Exception {
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
			  log("STEP 9:  Import is not perfome Successfully :", Status.FAIL);
			  throw new RuntimeException("Failed in step 9:  Import is not perfome Successfully");
		}
		
	}
	
	public void verifyParcelImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			ParcelImportMapping(testcaseName);
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
	
	By tractNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Tract #: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TRACT_NUMBER') and @type='text'])[1]");
	public String getTractNumber() {
		
		
		return util.getAttributeValue(tractNumber, "value");
	}
	
	By tractType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Tract Type: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TractType_Tract_Type_ID') and @type='text'])[1]");
	public String getTractType() {
		return util.getAttributeValue(tractType, "value");
	}
	By propertyType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Property Type: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TractType_Property_Type_ID') and @type='text'])[1]");
	public String getPropertyType() {
		return util.getAttributeValue(propertyType, "value");
	}
	
	By acquisitionType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Acquisition Type: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TractType_Acquisition_type_ID') and @type='text'])[1]");
	public String getAcquisitionType() {
		return util.getAttributeValue(acquisitionType, "value");
	}
	
	By alternateNum = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Alternate #: ']/..//input[contains(@id,'Dest_Input')]");
	public String getAlternateNum() {
		return util.getAttributeValue(alternateNum, "value");
	}
	
	By acquisitionStatus = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Acquisition Status: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_ACQUISITION_STATUS_ID') and @type='text'])[1]");
	public String getAcquisitionStatus() {
		return util.getAttributeValue(acquisitionStatus, "value");
	}
	
	By grantor = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Grantor: ']/..//input[contains(@id,'Dest_Input')]");
	public String getGrantor() {
		return util.getAttributeValue(grantor, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_STATE') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By county = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_County') and @type='text']");
	public String getCounty() {
		return util.getAttributeValue(county, "value");
	}
	
	By comments = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Comments: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'TractType_radComments')]");
	public String getComments() {
		return util.getAttributeValue(comments, "value");
	}
	

	Map<String, String> excelData;
	public void ParcelImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ParcelImportMapping, testcaseName);
				assertion.assertEquals(getTractNumber(), excelData.get("Parcel Number").trim(), "Parcel number mapping mismatched");
				ExtentTestManager.log("Parcel number Mapping : " +getTractNumber());
				
				assertion.assertEquals(getTractType(), excelData.get("Parcel Type").trim(), "Parcel type mapping mismatched");
				ExtentTestManager.log("Parcel type Mapping : " +getTractType());
				
				assertion.assertEquals(getPropertyType(), excelData.get("Property Type").trim(), "Property type mapping mismatched");
				ExtentTestManager.log("Property type Mapping : "+getPropertyType());
				
				assertion.assertEquals(getAcquisitionType(), excelData.get("Acquisition Type").trim(), "Acquisition Type mapping mismatched");
				ExtentTestManager.log("Acquisition Type Mapping : "+getAcquisitionType());
				
				assertion.assertEquals(getAlternateNum(), excelData.get("Alternate #").trim(), "Alternate # mapping mismatched");
				ExtentTestManager.log("Alternate # Mapping : "+getAlternateNum());
				
				assertion.assertEquals(getAcquisitionStatus(), excelData.get("Acquisition Status").trim(), "Acquisition Status mapping mismatched");
				ExtentTestManager.log("Acquisition Status Mapping : "+getAcquisitionStatus());
				
				assertion.assertEquals(getGrantor(), excelData.get("Grantor").trim(), "Grantor mapping mismatched");
				ExtentTestManager.log("Grantor Mapping : "+getGrantor());
				
				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getCounty(), excelData.get("County").trim(), "County mapping mismatched");
				ExtentTestManager.log("County Mapping : "+getCounty());
				
				assertion.assertEquals(getComments(), excelData.get("Comments").trim(), "Comments mapping mismatched");
				ExtentTestManager.log("Comments Mapping : "+getComments());
				
				assertion.assertAll();

			}
	
	public void verifyImportedParcelData(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
		for(int i=1; i<ExcelUtils.totalRows-1; i++) {
			String testcaseName1 = "ParcelImport" + clientName+i;
		
	if(testcaseName.toLowerCase().contains("row")) {
			if(testcaseName.contains("TRA")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.TRA_PROJECTIMPORT_FILE), Excel.ParcelImport, testcaseName1);
				
			}else if(environment.contains("WOLFMIDSTREAM")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.WOLF_PROJECTIMPORT_FILE), Excel.ParcelImport, testcaseName1);
				
			}else {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.ParcelImport, testcaseName1);
			}
				 By addedRecord = By.xpath("//td[text()='"+map.get("Tract #") +"']/parent::tr");
					Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
					util.click(addedRecord);
					util.dummyWait(2);
					
					assertion.assertEquals(getTractNumber(), map.get("Tract #").trim(), "Parcel number mismatched");
					ExtentTestManager.log("Parcel number matched : " +getTractNumber());
					assertion.assertEquals(getTractType(), map.get("Tract Type").trim(), "Parcel type mismatched");
					ExtentTestManager.log("Parcel type matched : " +getTractType());
					
					if(!environment.contains("WOLFMIDSTREAM")) {
					assertion.assertEquals(getPropertyType(), map.get("Property Type").trim(), "Property type mismatched");
					ExtentTestManager.log("Property type matched : "+getPropertyType());
					}
					assertion.assertEquals(getAcquisitionType(), map.get("Acquisition Type").trim(), "Acquisition type mismatched");
					ExtentTestManager.log("Acquisition type matched : "+getAcquisitionType());
					if(util.isElementPresent(state)) {
					assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
					ExtentTestManager.log("State matched : "+getState());
					assertion.assertEquals(getCounty().toLowerCase(), map.get("County").trim().toLowerCase(), "County mismatched");
					ExtentTestManager.log("County matched : "+getCounty());
					}
					assertion.assertEquals(getComments(), map.get("Comments").trim(), "Comments mismatched");
					ExtentTestManager.log("Comments matched : "+getComments());
					System.out.println(getComments());
					
					if(!environment.contains("WOLFMIDSTREAM")) {
					objProjectImportPage.navigateToAcquisition();
					util.dummyWait(2);
					assertion.assertEquals(getAcquisitionStatus(), map.get("Acquisition Status").trim(), "Acquisition Status mismatched");
					ExtentTestManager.log("Acquisition Status matched : "+getAcquisitionStatus());	
					}
	}
					assertion.assertAll();
			 }
		
			
		}
			
		
//	}
			

	

}
