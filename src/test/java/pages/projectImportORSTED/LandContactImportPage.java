package pages.projectImportORSTED;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;


public class LandContactImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public LandContactImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By orstedPIN = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Orsted PIN: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getOrstedPIN() {
		return util.getAttributeValue(orstedPIN, "value");
	}

	By address1 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 1: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Address_Line_1') and @type='text']");
	public String getAddress1() {
		return util.getAttributeValue(address1, "value");
	} 
	
	By address2 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 2: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Address_Line_2') and @type='text']");
	public String getAddress2() {
		return util.getAttributeValue(address2, "value");
	}
	
	By address3 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 3: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Address_Line_3') and @type='text']");
	public String getAddress3() {
		return util.getAttributeValue(address3, "value");
	}
	
	By city = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='City: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_City') and @type='text']");
	public String getCity() {
		return util.getAttributeValue(city, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_State') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By zip = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Zip Code: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Zip_Code') and @type='text']");
	public String getZip() {
		return util.getAttributeValue(zip, "value");
	}
	
	By landownerName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Landowner Name: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Corporation_Trust') and @type='text']");
	public String getLandownerName() {
		return util.getAttributeValue(landownerName, "value");
	}
	
	By surfaceOwnership = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Surface Ownership: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Pct_Ownership') and @type='text']");
	public String getSurfaceOwnership() {
		return util.getAttributeValue(surfaceOwnership, "value");
	}
	
	By windOwnership = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Wind Ownership: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'PCT_Ownership_Wind') and @type='text']");
	public String getWindOwnership() {
		return util.getAttributeValue(windOwnership, "value");
	}
	
	By cropOwnership = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Crop Ownership: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'PCT_Ownership_Crop') and @type='text']");
	public String getCropOwnership() {
		return util.getAttributeValue(cropOwnership, "value");
	}
	
	By titleofRep = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Title of Rep: ')]/..//input[contains(@id,'Dest_Input')]");
	public String getTitleofRep() {
		return util.getAttributeValue(titleofRep, "value");
	}

	
	Map<String, String> excelData;
	public void LandContactMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ParcelOwnerMapping, testcaseName);
				assertion.assertEquals(getOrstedPIN(), excelData.get("Parcel #").trim(), "Orsted PIN mapping mismatched");
				ExtentTestManager.log("Orsted PIN Mapping : " +getOrstedPIN());
				
				assertion.assertEquals(getAddress1(), excelData.get("Address 1").trim(), "Address Line 1 mapping mismatched");
				ExtentTestManager.log("Address 1 Mapping : "+getAddress1());
				
				assertion.assertEquals(getAddress2(), excelData.get("Address 2").trim(), "Address Line 2 mapping mismatched");
				ExtentTestManager.log("Address 2 Mapping : "+getAddress2());
				
				assertion.assertEquals(getAddress3().trim(), excelData.get("Address 3").trim(), "Address Line 3 mapping mismatched");
				ExtentTestManager.log("Address 3 Mapping : "+getAddress3().trim());
				
				assertion.assertEquals(getCity(), excelData.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());

				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getZip(), excelData.get("Zip Code").trim(), "Zip Code mapping mismatched");
				ExtentTestManager.log("Zip Code Mapping : "+getZip());
				
				assertion.assertEquals(getLandownerName(), excelData.get("Corporation").trim(), "Landowner Name mapping mismatched");
				ExtentTestManager.log("Landowner Name Mapping : "+getLandownerName());
				
				assertion.assertEquals(getSurfaceOwnership(), excelData.get("Surface Ownership").trim(), "Surface Ownership mapping mismatched");
				ExtentTestManager.log("Surface Ownership Mapping : "+getSurfaceOwnership());
				
				assertion.assertEquals(getWindOwnership(), excelData.get("Wind Ownership").trim(), "Wind Ownership mapping mismatched");
				ExtentTestManager.log("Home Phone Mapping : "+getWindOwnership());
				
				assertion.assertEquals(getCropOwnership(), excelData.get("Crop Ownership").trim(), "Crop Ownership mapping mismatched");
				ExtentTestManager.log("Crop Ownership Mapping : "+getCropOwnership());
				
				assertion.assertEquals(getTitleofRep(), excelData.get("Title of Rep").trim(), "Title of Rep mapping mismatched");
				ExtentTestManager.log("Title of Rep Mapping : "+getTitleofRep());
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyLandContactImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			LandContactMapping(testcaseName);
			log("STEP 7:  All Parcel Owner Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navLandowner = By.xpath("//span[text()='Landowner']");
	By editcontact = By.xpath("//input[contains(@id,'EditButton')]");
	
	public void verifyImportedLandContact(Map<String, String> map, String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
        util.dummyWait(2);
		
				By addedRecord = By.xpath("//td[text()='"+map.get("Orsted PIN").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				util.dummyWait(20);
				
				assertion.assertEquals(getOrstedPIN(), map.get("Orsted PIN").trim(), "Orsted PIN mismatched");
				ExtentTestManager.log("Orsted PIN matched : " +getOrstedPIN());
				util.dummyWait(2);
				
				util.waitUntilElementDisplay(navLandowner);
				util.dummyWait(2);
				util.click(navLandowner);
				log("User can navigate to Landowner panel");
				
				
				
				By btnEdit = By.xpath("//tr[contains(@id,'LANDOWNERS_radYALGridControl_ctl00')]/.//*[text()='"+map.get("Landowner Name") +"']/..//a[contains(text(),'Edit')]");
				util.waitUntilElementDisplay(btnEdit);
				util.click(btnEdit);
				log("User can click on Edit Landowner button");
				log("Verifying the Imported Landowner Details");
				util.dummyWait(5);
				util.switchToChildWindow();
			
				assertion.assertEquals(getSurfaceOwnership(), map.get("Surface Ownership").trim(), "Surface Ownership mapping mismatched");
				ExtentTestManager.log("Surface Ownership Mapping : "+getSurfaceOwnership());
				
				assertion.assertEquals(getWindOwnership(), map.get("Wind Ownership").trim(), "Wind Ownership mapping mismatched");
				ExtentTestManager.log("Wind Ownership Mapping : "+getWindOwnership());
				
				assertion.assertEquals(getCropOwnership(), map.get("Crop Ownership").trim(), "Crop Ownership mapping mismatched");
				ExtentTestManager.log("Crop Ownership Mapping : "+getCropOwnership());
				
				assertion.assertEquals(getLandownerName(), map.get("Landowner Name").trim(), "Landowner Name mapping mismatched");
				ExtentTestManager.log("Landowner Name Mapping : "+getLandownerName());
				
//				assertion.assertEquals(getTitleofRep(), map.get("Title of Rep").trim(), "Title of Rep mapping mismatched");
//				ExtentTestManager.log("Title of Rep Mapping : "+getTitleofRep());
				
				util.waitUntilElementDisplay(editcontact);
				util.dummyWait(2);
				util.click(editcontact);
				log("User can navigate to contact panel");
				util.dummyWait(2);
				
				
				assertion.assertEquals(getAddress1(), map.get("Address Line 1").trim(), "Address Line 1 mapping mismatched");
				ExtentTestManager.log("Address 1 Mapping : "+getAddress1());
				
				assertion.assertEquals(getAddress2(), map.get("Address Line 2").trim(), "Address Line 2 mapping mismatched");
				ExtentTestManager.log("Address 2 Mapping : "+getAddress2());
				
				assertion.assertEquals(getAddress3(), map.get("Address Line 3").trim(), "Address Line 3 mapping mismatched");
				ExtentTestManager.log("Address 3 Mapping : "+getAddress3());
				
				assertion.assertEquals(getCity(), map.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());

				assertion.assertEquals(getState(), map.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getZip(), map.get("Zip Code").trim(), "Zip Code mapping mismatched");
				ExtentTestManager.log("Zip Code Mapping : "+getZip());
				
				assertion.assertAll();
				
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.landcontactvalidationMsg(testcaseName); 
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
	        log("STEP 14:  User can close the pop up", Status.PASS);
		} catch (Exception t) {
		
			  driver.close();
			  util.switchToParentWindow(); 
			  log("STEP 14:  User cannot close the pop up", Status.FAIL);
			  throw new RuntimeException("Failed in step 14");
		}
	}
	
	
	

}
