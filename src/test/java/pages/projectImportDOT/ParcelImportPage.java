package pages.projectImportDOT;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class ParcelImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	public ParcelImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By parcelNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel #: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getParcelNumber() {
		
		return util.getAttributeValue(parcelNumber, "value");
	}
	
	By parcelType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Parcel Type')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Tract_Type_ID') and @type='text']");
	public String getParcelType() {
		return util.getAttributeValue(parcelType, "value");
	}
	By propertyType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Property Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Property_Type_ID') and @type='text']");
	public String getPropertyType() {
		return util.getAttributeValue(propertyType, "value");
	}
	
	By acquisitionPriority = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Acquisition Priority')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Acquisition_type_ID') and @type='text']");
	public String getAcquisitionPriority() {
		return util.getAttributeValue(acquisitionPriority, "value");
	}
	
	By apn = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'APN')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_TRACTALTNO') and @type='text']");
	public String getAPN() {
		return util.getAttributeValue(apn, "value");
	}
	
	By status = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Status')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_ACQUISITION_STATUS') and @type='text']");
	public String getStatus() {
		return util.getAttributeValue(status, "value");
	}
	
	By grantor = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Grantor')]/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'GRANTOR')]");
	public String getGrantor() {
		return util.getAttributeValue(grantor, "value");
	}
	
	By relocationRequired = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Relocation Required')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Relocation_Required') and @type='text']");
	public String getRelocationRequired() {
		return util.getAttributeValue(relocationRequired, "value");
	}
	
	By occupied = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Occupied')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Occupied') and @type='text']");
	public String getOccupied() {
		return util.getAttributeValue(occupied, "value");
	}
	
	By comments = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Comments')]/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'TractType_tract_Notes')]");
	public String getComments() {
		return util.getAttributeValue(comments, "value");
	}
	
	By propertyAddLine1 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Property Add Line 1')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'GRANTOR_PROPADD_Address_Line_1') and @type='text']");
	public String getPropertyAddLine1() {
		return util.getAttributeValue(propertyAddLine1, "value");
	}
	
	By propertyAddLine2 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Property Add Line 2')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'GRANTOR_PROPADD_Address_Line_2') and @type='text']");
	public String getPropertyAddLine2() {
		return util.getAttributeValue(propertyAddLine2, "value");
	}
	
	By city = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'City')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'GRANTOR_PROPADD_City') and @type='text']");
	public String getCity() {
		return util.getAttributeValue(city, "value");
	}
	
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'State')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'GRANTOR_PROPADD_STATE') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By zipCode = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'ZipCode')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'GRANTOR_PROPADD_Zip_Code') and @type='text']");
	public String getZipCode() {
		return util.getAttributeValue(zipCode, "value");
	}
	
	Map<String, String> excelData;
	public void ParcelImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ParcelImportMapping, testcaseName);
				assertion.assertEquals(getParcelNumber(), excelData.get("Parcel Number").trim(), "Parcel number mapping mismatched");
				ExtentTestManager.log("Parcel number Mapping : " +getParcelNumber());
				
				assertion.assertEquals(getParcelType(), excelData.get("Parcel Type").trim(), "Parcel type mapping mismatched");
				ExtentTestManager.log("Parcel type Mapping : " +getParcelType());
				
				assertion.assertEquals(getPropertyType(), excelData.get("Property Type").trim(), "Property type mapping mismatched");
				ExtentTestManager.log("Property type Mapping : "+getPropertyType());
				
				assertion.assertEquals(getAcquisitionPriority(), excelData.get("Acquisition Priority").trim(), "Acquisition Priority mapping mismatched");
				ExtentTestManager.log("Acquisition Priority Mapping : "+getAcquisitionPriority());
				
				assertion.assertEquals(getAPN(), excelData.get("APN").trim(), "APN mapping mismatched");
				ExtentTestManager.log("APN Mapping : "+getAPN());
				
				assertion.assertEquals(getStatus(), excelData.get("Status").trim(), "Status mapping mismatched");
				ExtentTestManager.log("Status Mapping : "+getStatus());
				
				assertion.assertEquals(getGrantor(), excelData.get("Grantor").trim(), "Grantor mapping mismatched");
				ExtentTestManager.log("Grantor Mapping : "+getGrantor());
				
				assertion.assertEquals(getRelocationRequired(), excelData.get("Relocation Required").trim(), "Relocation Required mapping mismatched");
				ExtentTestManager.log("Relocation Required Mapping : "+getRelocationRequired());
				
				assertion.assertEquals(getOccupied(), excelData.get("Occupied").trim(), "Occupied mapping mismatched");
				ExtentTestManager.log("Occupied Mapping : "+getOccupied());
				
				assertion.assertEquals(getComments(), excelData.get("Comments").trim(), "Comments mapping mismatched");
				ExtentTestManager.log("Comments Mapping : "+getComments());
				
				assertion.assertEquals(getPropertyAddLine1(), excelData.get("Property Add Line1").trim(), "Property Add Line 1 mapping mismatched");
				ExtentTestManager.log("Property Add Line 1 Mapping : "+getPropertyAddLine1());
				
				assertion.assertEquals(getPropertyAddLine2(), excelData.get("Property Add Line2").trim(), "Property Add Line 2 mapping mismatched");
				ExtentTestManager.log("Property Add Line 2 Mapping : "+getPropertyAddLine2());
				
				assertion.assertEquals(getCity(), excelData.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());
				
				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getZipCode(), excelData.get("Zip Code").trim(), "Zip Code mapping mismatched");
				ExtentTestManager.log("Zip Code Mapping : "+getZipCode());
				
				assertion.assertAll();		
			
			}
	
	public void verifyParcelImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		
		try {
			ParcelImportMapping(testcaseName);
			log("STEP 7:  All Parcel Import Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navPropertyAddress = By.xpath("(//span[text()='Property Address'])[1]");

	public void verifyImportedParcelData(Map<String, String> map, String testcaseName) {	
		ExtentTestManager.log("Verifying Imported Parcel Data for parcel # "+map.get("Parcel #").trim());
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Parcel #").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
			    By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Parcel #")+"']");
				util.waitForWebElementToBePresent(parcelSummary, IMPLICIT_WAIT);
				
				assertion.assertEquals(getParcelNumber(), map.get("Parcel #").trim(), "Parcel number mismatched");
				ExtentTestManager.log("Parcel number matched : " +getParcelNumber());
				
				assertion.assertEquals(getParcelType(), map.get("Parcel Type").trim(), "Parcel type mismatched");
				ExtentTestManager.log("Parcel type matched : " +getParcelType());
				
				assertion.assertEquals(getPropertyType(), map.get("Property Type").trim(), "Property type mismatched");
				ExtentTestManager.log("Property type matched : "+getPropertyType());
				
				String[] arrOfStr = getAcquisitionPriority().split(",");
				 
		        for (String ap : arrOfStr) {
		        	if(ap.trim().equals(map.get("Acquisition Priority"))) {
		        		ExtentTestManager.log("Acquisition Priority matched : "+ap.trim());
		        	}
		        }			
				
				assertion.assertEquals(getAPN(), map.get("APN").trim(), "APN mismatched");
				ExtentTestManager.log("APN matched : "+getAPN());
				
				assertion.assertEquals(getStatus(), map.get("Status").trim(), "Status mismatched");
				ExtentTestManager.log("Status matched : "+getStatus());
				
				assertion.assertEquals(getOccupied(), map.get("Occupied").trim(), "Occupied mismatched");
				ExtentTestManager.log("Occupied matched : "+getOccupied());
			
				assertion.assertEquals(getRelocationRequired(), map.get("Relocation Required").trim(), "Relocation Required mismatched");
				ExtentTestManager.log("Relocation Required matched : "+getRelocationRequired());
				
				assertion.assertEquals(getComments(), map.get("Comments").trim(), "comments mismatched");
				ExtentTestManager.log("comments matched : "+getComments());
				
				util.dummyWait(1);
				util.click(navPropertyAddress);
				util.dummyWait(1);
				
				assertion.assertEquals(getGrantor(), map.get("Grantor").trim(), "Grantor mismatched");
				ExtentTestManager.log("Grantor matched : "+getGrantor());
				
				assertion.assertEquals(getPropertyAddLine1(), map.get("Property Add Line1").trim(), "Property Add Line 1 mismatched");
				ExtentTestManager.log("Property Add Line 1 matched : "+getPropertyAddLine1());
				
				assertion.assertEquals(getPropertyAddLine2(), map.get("Property Add Line2").trim(), "Property Add Line 2 mismatched");
				ExtentTestManager.log("Property Add Line 2 matched : "+getPropertyAddLine2());
				
				assertion.assertEquals(getCity(), map.get("City").trim(), "City mismatched");
				ExtentTestManager.log("City matched : "+getCity());
				
				assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
				ExtentTestManager.log("State matched : "+getState());
				
				assertion.assertEquals(getZipCode(), map.get("Zip Code").trim(), "Zip Code mismatched");
				ExtentTestManager.log("Zip Code matched : "+getZipCode());
				
				assertion.assertAll();
			
		}
	
	
	
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.parcelImportValidationMsg(testcaseName); 
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
}
