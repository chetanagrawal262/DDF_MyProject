package pages.projectImportALT;

import java.util.HashMap;
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

public class LandDataImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	AgreementDataImportPage objAgreementDataImportPage;
	Map<String, String> map = new HashMap<String, String>();
	
	public LandDataImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
		objAgreementDataImportPage = new AgreementDataImportPage(driver);
	}

	By parcelNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel #: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getParcelNumber() {
		
		return util.getAttributeValue(parcelNumber, "value");
	}
	
	By parcelType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Tract_Type_ID') and @type='text']");
	public String getParcelType() {
		return util.getAttributeValue(parcelType, "value");
	}
	By propertyType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Property Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Property_Type_ID') and @type='text']");
	public String getPropertyType() {
		return util.getAttributeValue(propertyType, "value");
	}
	
	By legalDescription = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Legal Description: ']/..//input[contains(@id,'Dest_Input')]");
	public String getLegalDescription() {
		return util.getAttributeValue(legalDescription, "value");
	}
	
	By grantor = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Grantor: ']/..//input[contains(@id,'Dest_Input')]");
	public String getGrantor() {
		return util.getAttributeValue(grantor, "value");
	}
	
	By agreementNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Number: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Number') and @type='text']");
	public String getAgreementNumber() {
		return util.getAttributeValue(agreementNumber, "value");
	}
	
	By agreementType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Type_ID') and @type='text']");
	public String getAgreementType() {
		return util.getAttributeValue(agreementType, "value");
	}
	
	By parcelAcres = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel Acres: ']/..//input[contains(@id,'Dest_Input')] | //span[text()='Parcel Acres:']/..//input[@type='text']");
	public String getParcelAcres() {
		return util.getAttributeValue(parcelAcres, "value");
	}
	
	By gisParcelAcres = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='GIS Parcel Acres: ']/..//input[contains(@id,'Dest_Input')] | //span[text()='GIS Acres:']/..//input[@type='text'] | //span[text()='GIS Parcel Acres:']/..//input[@type='text']");
	public String getGISAcres() {
		return util.getAttributeValue(gisParcelAcres, "value");
	}
	
	By leasedAcres = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Leased Acres: ']/..//input[contains(@id,'Dest_Input')] | //span[text()='Leased Acres:']/..//input[@type='text']");
	public String getLeasedAcres() {
		return util.getAttributeValue(leasedAcres, "value");
	}
	
	By excludedAcres = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Excluded Acres: ']/..//input[contains(@id,'Dest_Input')]");
	public String getExcludedAcres() {
		return util.getAttributeValue(excludedAcres, "value");
	}
	
	By countyPID = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County PID: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_TractType_radGISID') and @type='text']");
	public String getCountyPID() {
		return util.getAttributeValue(countyPID, "value");
	}
	
	By quarterSection = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='1/4 Section (CDN): ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_EditFormControl_QSec') and @type='text'])[1] | (//input[contains(@id,'EditFormControl_EditLegalDescription2_QSec') and @type='text'])[1]");
	public String getQuarterSection() {
		return util.getAttributeValue(quarterSection, "value");
	}
	
	By section = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Section: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_EditFormControl_Section') and @type='text'])[1] | (//input[contains(@id,'EditFormControl_EditLegalDescription2_Section') and @type='text'])[1]");
	public String getSection() {
		return util.getAttributeValue(section, "value");
	}
	
	By block = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Block: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_EditFormControl_Block') and @type='text'])[1] | (//input[contains(@id,'EditFormControl_EditLegalDescription2_Block') and @type='text'])[1]");
	public String getBlock() {
		return util.getAttributeValue(block, "value");
	}
	
	By lot = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Lot: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_EditFormControl_Lot') and @type='text'])[1] | (//input[contains(@id,'EditFormControl_EditLegalDescription2_Lot') and @type='text'])[1]");
	public String getLot() {
		return util.getAttributeValue(lot, "value");
	}
	
	By township = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Township: ']/..//input[contains(@id,'Dest_Input')] |  (//input[contains(@id,'_EditFormControl_Township') and @type='text'])[1] | (//input[contains(@id,'EditFormControl_EditLegalDescription2_Township') and @type='text'])[1]");
	public String getTownship() {
		return util.getAttributeValue(township, "value");
	}
	
	By range = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Range: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_EditFormControl_Range') and @type='text'])[1] | (//input[contains(@id,'EditFormControl_EditLegalDescription2_Range') and @type='text'])[1]");
	public String getRange() {
		return util.getAttributeValue(range, "value");
	}
	
	By county = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_EditFormControl_County') and @type='text'])[1] | (//input[contains(@id,'EditFormControl_EditLegalDescription2_County') and @type='text'])[1]");
	public String getCounty() {
		return util.getAttributeValue(county, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State/Province: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_EditFormControl_STATE') and @type='text'])[1] | (//input[contains(@id,'EditFormControl_EditLegalDescription2_STATE') and @type='text'])[1]");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By active = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Active: ']/..//input[contains(@id,'Dest_Input')]");
	public String getActive() {
		return util.getAttributeValue(active, "value");
	}
	
	By acquisitionPriority = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Acquisition Priority: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Acquisition_type_ID') and @type='text']");
	public String getAcquisitionPriority() {
		return util.getAttributeValue(acquisitionPriority, "value");
	}
	
	By status = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Status: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Status_ID') and @type='text']");
	public String getStatus() {
		return util.getAttributeValue(status, "value");
	}
	
	Map<String, String> excelData;
	public void LandDataMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.LandDataMapping, testcaseName);
				assertion.assertEquals(getParcelNumber(), excelData.get("Parcel Number").trim(), "Parcel number mapping mismatched");
				ExtentTestManager.log("Parcel number Mapping : " +getParcelNumber());
				
				assertion.assertEquals(getParcelType(), excelData.get("Parcel Type").trim(), "Parcel type mapping mismatched");
				ExtentTestManager.log("Parcel type Mapping : " +getParcelType());
				
				assertion.assertEquals(getPropertyType(), excelData.get("Property Type").trim(), "Property type mapping mismatched");
				ExtentTestManager.log("Property type Mapping : "+getPropertyType());
				
				assertion.assertEquals(getLegalDescription(), excelData.get("Legal Description").trim(), "Legal Description mapping mismatched");
				ExtentTestManager.log("Legal Description Mapping : "+getLegalDescription());
				
				if (!testcaseName.contains("CONNECTGEN")) {
				assertion.assertEquals(getGrantor(), excelData.get("Grantor").trim(), "Grantor mapping mismatched");
				ExtentTestManager.log("Grantor Mapping : "+getGrantor());
				
				assertion.assertEquals(getAgreementNumber(), excelData.get("Agreement Number").trim(), "Agreement Number mapping mismatched");
				ExtentTestManager.log("Agreement Number Mapping : "+getAgreementNumber());
				
				assertion.assertEquals(getAgreementType(), excelData.get("Agreement Type").trim(), "Agreement Type mapping mismatched");
				ExtentTestManager.log("Agreement Type Mapping : "+getAgreementType());
				}
				
				assertion.assertEquals(getParcelAcres(), excelData.get("Parcel Acres").trim(), "Parcel Acres mapping mismatched");
				ExtentTestManager.log("Parcel Acres Mapping : "+getParcelAcres());
				
				assertion.assertEquals(getGISAcres(), excelData.get("GIS Parcel Acres").trim(), "GIS Parcel Acres mapping mismatched");
				ExtentTestManager.log("GIS Parcel Acres Mapping : "+getGISAcres());
				
				if (!testcaseName.contains("CONNECTGEN")) {
				assertion.assertEquals(getLeasedAcres(), excelData.get("Leased Acres").trim(), "Leased Acres mapping mismatched");
				ExtentTestManager.log("Leased Acres Mapping : "+getLeasedAcres());
				
				assertion.assertEquals(getExcludedAcres(), excelData.get("Excluded Acres").trim(), "Excluded Acres mapping mismatched");
				ExtentTestManager.log("Excluded Acres Mapping : "+getExcludedAcres());
				}
				
				assertion.assertEquals(getCountyPID(), excelData.get("County PID").trim(), "County PID mapping mismatched");
				ExtentTestManager.log("COUNTY PID Mapping : "+getCountyPID());
				
				assertion.assertEquals(getQuarterSection(), excelData.get("Quarter Section").trim(), "Quarter Section mapping mismatched");
				ExtentTestManager.log("Quarter Section Mapping : "+getQuarterSection());
				
				assertion.assertEquals(getSection(), excelData.get("Section").trim(), "Section mapping mismatched");
				ExtentTestManager.log("Section Mapping : "+getSection());
				
				assertion.assertEquals(getBlock(), excelData.get("Block").trim(), "Block mapping mismatched");
				ExtentTestManager.log("Block Mapping : "+getBlock());
				
				assertion.assertEquals(getLot(), excelData.get("Lot").trim(), "Lot mapping mismatched");
				ExtentTestManager.log("Lot Mapping : "+getLot());
				
				assertion.assertEquals(getTownship(), excelData.get("Township").trim(), "Township mapping mismatched");
				ExtentTestManager.log("Township Mapping : "+getTownship());
				
				assertion.assertEquals(getRange(), excelData.get("Range").trim(), "Range mapping mismatched");
				ExtentTestManager.log("Range Mapping : "+getRange());
				
				assertion.assertEquals(getCounty(), excelData.get("County").trim(), "county mapping mismatched");
				ExtentTestManager.log("county Mapping : "+getCounty());
				
				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getActive(), excelData.get("Active").trim(), "Active mapping mismatched");
				ExtentTestManager.log("Active Mapping : "+getActive());
				
				if (!testcaseName.contains("CONNECTGEN")) {
				assertion.assertEquals(getAcquisitionPriority(), excelData.get("Acquisition Priority").trim(), "Acauisition Priority mapping mismatched");
				ExtentTestManager.log("Acquisition Priority Mapping : "+getAcquisitionPriority());
				
				assertion.assertEquals(getStatus(), excelData.get("Status").trim(), "Status mapping mismatched");
				ExtentTestManager.log("Status Mapping : "+getStatus());
				}
				
				assertion.assertAll();		
			
			}
	
	By CheckAgreementNo = By.xpath("(//tr[contains(@id,'idYalImport_RadGridUpload')]/td[6])[1]");
	public String AgreementValue;
	
	public void verifyLandDataMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		if(!testcaseName.contains("CONNECTGEN")) {
			util.dummyWait(1);
			AgreementValue=driver.findElement(CheckAgreementNo).getText();
		}
		
		
		try {
			LandDataMapping(testcaseName);
			log("STEP 7:  All Land  Data Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	
	By navLegalDescription = By.xpath("//span[text()='Legal Description']");

	public void verifyImportedLandData(Map<String, String> map, String testcaseName) {	
		ExtentTestManager.log("Verifying Imported Land Data for parcel # "+map.get("Parcel #").trim());
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("(//td[text()='"+map.get("Parcel #").trim()+"']/parent::tr)[1]");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				if(!environment.contains("NOVA")) {
			    By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Parcel #")+"']");
				util.waitForWebElementToBePresent(parcelSummary, IMPLICIT_WAIT);
				}
				
				assertion.assertEquals(getParcelNumber(), map.get("Parcel #").trim(), "Parcel number mismatched");
				ExtentTestManager.log("Parcel number matched : " +getParcelNumber());
				
				By btnActive = By.xpath("//input[contains(@id,'takeOffline')]");
				util.waitForWebElementToBePresent(btnActive, IMPLICIT_WAIT);
				ExtentTestManager.log("Parcel is in Active Status");
				
				assertion.assertEquals(getParcelType(), map.get("Parcel Type").trim(), "Parcel type mismatched");
				ExtentTestManager.log("Parcel type matched : " +getParcelType());
				
				assertion.assertEquals(getPropertyType(), map.get("Property Type").trim(), "Property type mismatched");
				ExtentTestManager.log("Property type matched : "+getPropertyType());
				
				if(util.isElementVisible(parcelAcres)) {
				assertion.assertEquals(getParcelAcres(), map.get("Parcel Acres").trim(), "Parcel Acres mismatched");
				ExtentTestManager.log("Parcel Acres matched : "+getParcelAcres());
				}
				
				if(util.isElementPresent(gisParcelAcres)){
				assertion.assertEquals(getGISAcres(), map.get("GIS Parcel Acres").trim(), "GIS Parcel Acres mismatched");
				ExtentTestManager.log("GIS Parcel Acres matched : "+getGISAcres());
				}
				
				if (!testcaseName.contains("CONNECTGEN")) {
					if(util.isElementVisible(leasedAcres)) {
				assertion.assertEquals(getLeasedAcres(), map.get("Leased Acres").trim(), "Leased Acres mismatched");
				ExtentTestManager.log("Leased Acres matched : "+getLeasedAcres());
					}
				}
				
				if(util.isElementVisible(countyPID)) {
				assertion.assertEquals(getCountyPID(), map.get("County PID").trim(), "County PID mismatched");
				ExtentTestManager.log("County PID matched : "+getCountyPID());
				}
				
				//#71369-Start
				if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")) {
					By parcelListGrantor = By.xpath("//strong[text()='"+map.get("Grantor").trim()+"']");
					assertion.assertTrue(util.isElementVisible(parcelListGrantor), "Grantor mismatched");
					ExtentTestManager.log("Grantor matched : "+map.get("Grantor").trim());
					}
				//#71369-End
				
				util.dummyWait(1);
				util.waitUntilElementDisplay(navLegalDescription);
				util.click(navLegalDescription);
				util.dummyWait(1);
				
				By btnEdit = By.xpath("//tr[contains(@id,'LEGALDESC_radYALGridControl')]/..//*[text()='"+map.get("County PID")+"']/../..//*[@title='Edit']");
				util.click(btnEdit);
				util.dummyWait(5);
				
				assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
				ExtentTestManager.log("State matched : " +getState());
				
				assertion.assertEquals(getCounty(), map.get("County").trim(), "County mismatched");
				ExtentTestManager.log("County matched : " +getCounty());
				
				assertion.assertEquals(getQuarterSection(), map.get("Quarter Section").trim(), "Quarter Section mismatched");
				ExtentTestManager.log("Quarter Section matched : " +getQuarterSection());
				
				assertion.assertEquals(getSection(), map.get("Section").trim(), "Section mismatched");
				ExtentTestManager.log("Section matched : " +getSection());
				
				assertion.assertEquals(getTownship(), map.get("Township").trim(), "Township mismatched");
				ExtentTestManager.log("Township matched : " +getTownship());
				
				assertion.assertEquals(getRange(), map.get("Range").trim(), "Range mismatched");
				ExtentTestManager.log("Range matched : " +getRange());
				
				assertion.assertEquals(getLot(), map.get("Lot").trim(), "Lot mismatched");
				ExtentTestManager.log("Lot matched : " +getLot());
				
				assertion.assertEquals(getBlock(), map.get("Block").trim(), "Block mismatched");
				ExtentTestManager.log("Block matched : " +getBlock());
			
				if(!testcaseName.contains("CONNECTGEN")) {
				if(!map.get("Agreement Number").equals(NA)) {
					
					By agreementNo = By.xpath("//a[text()='"+map.get("Agreement Number")+"']");
					if(util.isElementVisible(agreementNo)) {
					util.waitForWebElementToBePresent(agreementNo, IMPLICIT_WAIT);
					ExtentTestManager.log("Agreement Number matched : "+driver.findElement(agreementNo).getText());
					
					util.click(agreementNo);
					util.dummyWait(10);
					By agrPopUp = By.xpath("//iframe[@name='LeaseManager']");
					util.switchToIframe(agrPopUp);
					assertion.assertEquals(getAgreementNumber(), map.get("Agreement Number").trim(), "Agreement Number mismatched");
					
					assertion.assertEquals(getAgreementType(), map.get("Agreement Type").trim(), "Agreement Type mismatched");
					ExtentTestManager.log("Agreement Type : "+getAgreementType());
					
					if(environment.contains("NEXTERA")) {
						assertion.assertEquals(getStatus(), map.get("NextEraStatus").trim(), "Agreement Status mismatched");
						ExtentTestManager.log("Agreement Status : "+getStatus());
					}else {
					assertion.assertEquals(getStatus(), map.get("Status").trim(), "Agreement Status mismatched");
					ExtentTestManager.log("Agreement Status : "+getStatus());
					}
					driver.navigate().refresh();
					}else {
						ExtentTestManager.log("Agreement Link is not available" );
					}
					}else {
						ExtentTestManager.log("Agreement is not imported");
					}
				}
				assertion.assertAll();
			
		}
	
	public void verifyImportedData(String testcaseName) throws Exception {	
		for(int i=1; i<ExcelUtils.totalRows-1; i++) {
			String rowName = testcaseName+i;
			if(testcaseName.contains("NOVA")) {
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NOVA_PROJECTIMPORT_FILE), Excel.LandData,rowName);	
				}else if(testcaseName.contains("CONNECTGEN")) {
			
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.CONNECTGEN_PROJECTIMPORT_FILE), Excel.LandData,rowName);
				}else if(testcaseName.contains("ATWELL")){
					map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ATWELL_PROJECTIMPORT_FILE), Excel.LandData,rowName);
				}else if(testcaseName.contains("ORSTED")) {
					map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE), Excel.LandData,rowName);
				}else {
					if(environment.contains("STEELHEAD")) {
						map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.STEELHEAD_PROJECTIMPORT_FILE), Excel.LandData,rowName);
					}else {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE), Excel.LandData,rowName);
					}
		}
			verifyImportedLandData(map,rowName);
			}
			
			if(!environment.contains("CONNECTGEN")) {
			if(AgreementValue.isEmpty()) {
				log("Agreement Data is not imported through Land Data Import,doing the Agreement Data Import Seperately");
				String testcaseNameAgr = "AgreementDataImport" + clientName;
				map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectImportALT, testcaseNameAgr);
				objAgreementDataImportPage.verifyAgreementDataMapping(map, testcaseNameAgr);
				objProjectImportPage.loadDataToProject(map, testcaseName);
				objProjectImportPage.projectSelectionAgreement(map, testcaseName);
				for(int i=1; i<ExcelUtils.totalRows-1; i++) {
					String rowName = "AgreementDataImport" + clientName+i;
					if(testcaseName.contains("NOVA")) {
						map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NOVA_PROJECTIMPORT_FILE), Excel.AgreementData, rowName);
					}else if(testcaseName.contains("ATWELL")){
					map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ATWELL_PROJECTIMPORT_FILE), Excel.AgreementData, rowName);			
					}else if(testcaseName.contains("ORSTED")) {
						map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE), Excel.AgreementData,rowName);
					}else {
						if(environment.contains("STEELHEAD")) {
							map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.STEELHEAD_PROJECTIMPORT_FILE), Excel.AgreementData,rowName);
						}else {
						map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE), Excel.AgreementData, rowName);	
						}
					}
					objAgreementDataImportPage.validationOfImportedData(map, rowName);
				}
				
				
			}else {
				log("The Agreement is created by importing the Land Data, So Agreement Data Import is skipped");
			}
			}
	}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.landDatavalidationMsg(testcaseName); 
			objErrorLog.printErrorLog(); 
	        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
		} catch (Exception t) {
//			  driver.close();
//			  util.switchToParentWindow();
			  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
			  throw new RuntimeException("Failed in step 12");
		}
		
//		try {//removed in 24.04
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
