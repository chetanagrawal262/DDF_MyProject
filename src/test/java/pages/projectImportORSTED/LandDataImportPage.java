package pages.projectImportORSTED;

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
//	AgreementDataImportPage objAgreementDataImportPage;
	public LandDataImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
//		objAgreementDataImportPage = new AgreementDataImportPage(driver);
	}
	
	By legacy = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Legacy: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Property_Type_ID') and @type='text']");
	public String getLegacy() {
		return util.getAttributeValue(legacy, "value");
	}

	By orstedPIN = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Orsted PIN: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getOrstedPIN() {
		return util.getAttributeValue(orstedPIN, "value");
	}
	
	By parcelType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Tract_Type_ID') and @type='text']");
	public String getParcelType() {
		return util.getAttributeValue(parcelType, "value");
	}	
	
	By legalDescription = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Legal Desc')]/..//input[contains(@id,'Dest_Input')]");
	public String getLegalDescription() {
		return util.getAttributeValue(legalDescription, "value");
	}
	
	By agreementNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Number: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Number') and @type='text']");
	public String getAgreementNumber() {
		return util.getAttributeValue(agreementNumber, "value");
	}
	
	By agreementName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Name: ']/..//input[contains(@id,'Dest_Input')]");
	public String getAgreementName() {
		return util.getAttributeValue(agreementName, "value");
	}

	By agreementType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Type_ID') and @type='text']");
	public String getAgreementType() {
		return util.getAttributeValue(agreementType, "value");
	}
	
	By agreementOperatingCompany = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Operating Company: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TractType_customFields2_41') and @type='text']");
	public String getAgreementOperatingCompany() {
		return util.getAttributeValue(agreementOperatingCompany, "value");
	}
	
	By gisParcelAcres = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='GIS Parcel Acres: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_customFields2_42') and @type='text']");
	public String getGISAcres() {
		return util.getAttributeValue(gisParcelAcres, "value");
	}
	
	By leasedAcres = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Leased Acres: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_customFields2_43') and @type='text']");
	public String getLeasedAcres() {
		return util.getAttributeValue(leasedAcres, "value");
	}
	
	By countyPIN = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County PIN: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_TractType_radGISID') and @type='text']");
	public String getCountyPIN() {
		return util.getAttributeValue(countyPIN, "value");
	}
	
	By quarterSection = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='1/4 Section (CDN): ']/..//input[contains(@id,'Dest_Input')]");
	public String getQuarterSection() {
		return util.getAttributeValue(quarterSection, "value");
	}
	
	By section = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Section: ']/..//input[contains(@id,'Dest_Input')]");
	public String getSection() {
		return util.getAttributeValue(section, "value");
	}
	
	By block = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Block: ']/..//input[contains(@id,'Dest_Input')]");
	public String getBlock() {
		return util.getAttributeValue(block, "value");
	}
	
	By lot = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Lot: ']/..//input[contains(@id,'Dest_Input')]");
	public String getLot() {
		return util.getAttributeValue(lot, "value");
	}
	
	By township = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Township: ']/..//input[contains(@id,'Dest_Input')]");
	public String getTownship() {
		return util.getAttributeValue(township, "value");
	}
	
	By range = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Range: ']/..//input[contains(@id,'Dest_Input')]");
	public String getRange() {
		return util.getAttributeValue(range, "value");
	}
	
	By meridian = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Meridian (CDN): ']/..//input[contains(@id,'Dest_Input')]");
	public String getMeridian() {
		return util.getAttributeValue(meridian, "value");
	}
	
	By county = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County: ']/..//input[contains(@id,'Dest_Input')]");
	public String getCounty() {
		return util.getAttributeValue(county, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State/Province: ']/..//input[contains(@id,'Dest_Input')]");
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
	
	By status = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()=' Status: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Status_ID') and @type='text']");
	public String getStatus() {
		return util.getAttributeValue(status, "value");
	}
	
	Map<String, String> excelData;
	public void LandDataMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.LandDataMapping, testcaseName);
				assertion.assertEquals(getOrstedPIN(), excelData.get("Parcel Number").trim(), "Orsted PIN mapping mismatched");
				ExtentTestManager.log("Orsted PIN Mapping : " +getOrstedPIN());
				
				assertion.assertEquals(getParcelType(), excelData.get("Parcel Type").trim(), "Parcel type mapping mismatched");
				ExtentTestManager.log("Parcel type Mapping : " +getParcelType());
				
				assertion.assertEquals(getLegacy(), excelData.get("Legacy").trim(), "Legacy mapping mismatched");
				ExtentTestManager.log("Legacy Mapping : "+getLegacy());
				
				assertion.assertEquals(getLegalDescription(), excelData.get("Legal Description").trim(), "Legal Description mapping mismatched");
				ExtentTestManager.log("Legal Description Mapping : "+getLegalDescription());
				
				assertion.assertEquals(getAgreementNumber(), excelData.get("Agreement Number").trim(), "Agreement Number mapping mismatched");
				ExtentTestManager.log("Agreement Number Mapping : "+getAgreementNumber());
				
				assertion.assertEquals(getAgreementName(), excelData.get("Agreement Name").trim(), "Agreement Name mapping mismatched");
				ExtentTestManager.log("Agreement Name Mapping : "+getAgreementName());
				
				assertion.assertEquals(getAgreementType(), excelData.get("Agreement Type").trim(), "Agreement Type mapping mismatched");
				ExtentTestManager.log("Agreement Type Mapping : "+getAgreementType());
				
				assertion.assertEquals(getAgreementOperatingCompany(), excelData.get("Agreement Operating Company").trim(), "Agreement Operating Company mapping mismatched");
				ExtentTestManager.log("Agreement Operating Company Mapping : "+getAgreementOperatingCompany());
				
				assertion.assertEquals(getGISAcres(), excelData.get("GIS Parcel Acres").trim(), "GIS Parcel Acres mapping mismatched");
				ExtentTestManager.log("GIS Parcel Acres Mapping : "+getGISAcres());
				
				assertion.assertEquals(getLeasedAcres(), excelData.get("Leased Acres").trim(), "Leased Acres mapping mismatched");
				ExtentTestManager.log("Leased Acres Mapping : "+getLeasedAcres());
				
				assertion.assertEquals(getCountyPIN(), excelData.get("County PID").trim(), "County PIN mapping mismatched");
				ExtentTestManager.log("County PIN Mapping : "+getCountyPIN());
				
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
				
				assertion.assertEquals(getMeridian(), excelData.get("Meridian").trim(), "Meridian (CDN) mapping mismatched");
				ExtentTestManager.log("Meridian (CDN) Mapping : "+getMeridian());
				
				assertion.assertEquals(getCounty(), excelData.get("County").trim(), "county mapping mismatched");
				ExtentTestManager.log("county Mapping : "+getCounty());
				
				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getActive(), excelData.get("Active").trim(), "Active mapping mismatched");
				ExtentTestManager.log("Active Mapping : "+getActive());
				
				assertion.assertEquals(getAcquisitionPriority(), excelData.get("Acquisition Priority").trim(), "Acauisition Priority mapping mismatched");
				ExtentTestManager.log("Acquisition Priority Mapping : "+getAcquisitionPriority());
				
				assertion.assertEquals(getStatus(), excelData.get("Status").trim(), "Status mapping mismatched");
				ExtentTestManager.log("Status Mapping : "+getStatus());
				assertion.assertAll();		
			
			}
	
	By CheckAgreementNo = By.xpath("(//tr[contains(@id,'idYalImport_RadGridUpload')]/td[6])[1]");
	public String AgreementValue;
	
	public void verifyLandDataMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		util.dummyWait(1);
		AgreementValue=driver.findElement(CheckAgreementNo).getText();
		
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
		ExtentTestManager.log("Verifying Imported Land Data for Orsted PIN "+map.get("Orsted PIN").trim());
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Orsted PIN").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
			    By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Orsted PIN")+"']");
				util.waitForWebElementToBePresent(parcelSummary, IMPLICIT_WAIT);
				
				assertion.assertEquals(getOrstedPIN(), map.get("Orsted PIN").trim(), "Orsted PIN mismatched");
				ExtentTestManager.log("Orsted PIN matched : " +getOrstedPIN());
				
				By btnActive = By.xpath("//input[contains(@id,'takeOffline')]");
				util.waitForWebElementToBePresent(btnActive, IMPLICIT_WAIT);
				ExtentTestManager.log("Parcel is in Active Status");
				
				assertion.assertEquals(getParcelType(), map.get("Parcel Type").trim(), "Parcel type mismatched");
				ExtentTestManager.log("Parcel type matched : " +getParcelType());
				
				assertion.assertEquals(getLegacy(), map.get("Legacy").trim(), "Legacy mismatched");
				ExtentTestManager.log("Legacy matched : "+getLegacy());
								
				assertion.assertEquals(getGISAcres(), map.get("GIS Parcel Acres").trim(), "GIS Parcel Acres mismatched");
				ExtentTestManager.log("GIS Parcel Acres matched : "+getGISAcres());
				
				assertion.assertEquals(getLeasedAcres(), map.get("Leased Acres").trim(), "Leased Acres mismatched");
				ExtentTestManager.log("Leased Acres matched : "+getLeasedAcres());
				
				assertion.assertEquals(getCountyPIN(), map.get("County PIN").trim(), "County PIN mismatched");
				ExtentTestManager.log("County PIN matched : "+getCountyPIN());
				
				util.dummyWait(1);
				util.waitUntilElementDisplay(navLegalDescription);
				util.click(navLegalDescription);
				util.dummyWait(1);
				
				By legalState = By.xpath("(//*[contains(@id,'LEGALDESC_radYALGridControl_ctl00__')]/..//td[3]/.//*[text()='"+map.get("State")+"'])[1]");
				util.waitForWebElementToBePresent(legalState, IMPLICIT_WAIT);
				ExtentTestManager.log("State value matched : "+driver.findElement(legalState).getText());
				
				By legalCounty = By.xpath("(//*[contains(@id,'LEGALDESC_radYALGridControl_ctl00__')]/..//td[3]/.//*[text()='"+map.get("County")+"'])[1]");
				util.waitForWebElementToBePresent(legalCounty, IMPLICIT_WAIT);
				ExtentTestManager.log("County value matched : "+driver.findElement(legalCounty).getText());

				By legalTownship= By.xpath("(//*[contains(@id,'LEGALDESC_radYALGridControl_ctl00__')]/..//td[3]/.//*[text()='"+map.get("Township")+"'])[1]");
				util.waitForWebElementToBePresent(legalTownship, IMPLICIT_WAIT);
				ExtentTestManager.log("Township value matched : "+driver.findElement(legalTownship).getText());
				
				if(!map.get("Agreement Number").equals(NA)) {
					
					By agreementNo = By.xpath("//a[text()='"+map.get("Agreement Number")+"']");
					util.waitForWebElementToBePresent(agreementNo, IMPLICIT_WAIT);
					ExtentTestManager.log("Agreement Number matched : "+driver.findElement(agreementNo).getText());
					
					util.click(agreementNo);
					util.dummyWait(10);
					By agrPopUp = By.xpath("//iframe[@name='LeaseManager']");
					util.switchToIframe(agrPopUp);
					assertion.assertEquals(getAgreementNumber(), map.get("Agreement Number").trim(), "Agreement Number mismatched");
					
					assertion.assertEquals(getAgreementType(), map.get("Agreement Type").trim(), "Agreement Type mismatched");
					ExtentTestManager.log("Agreement Type : "+getAgreementType());
					
					assertion.assertEquals(getStatus(), map.get("Status").trim(), "Agreement Status mismatched");
					ExtentTestManager.log("Agreement Status : "+getStatus());
					driver.navigate().refresh();
					
					}else {
						ExtentTestManager.log("Agreement is not imported");
					}
				
				assertion.assertAll();
			
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.landDatavalidationMsg(testcaseName); 
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
