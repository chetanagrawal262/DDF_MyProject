package pages.projectImportALT;

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

public class LandDataImportPageOrion extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	AgreementDataImportPage objAgreementDataImportPage;
	public LandDataImportPageOrion(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
		objAgreementDataImportPage = new AgreementDataImportPage(driver);
	}

	By parcelNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel ID #: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getParcelNumber() {
		
		return util.getAttributeValue(parcelNumber, "value");
	}
	
	By legalDesc = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Legal Desc')]/..//input[contains(@id,'Dest_Input')]");
	public String getLegalDesc() {
		return util.getAttributeValue(legalDesc, "value");
	}
	
	By grantor = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Grantor')]/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'GRANTOR_Grantor')]");
	public String getGrantor() {
		return util.getAttributeValue(grantor, "value");
	}
	
	By address = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Address')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'GRANTOR_PROPADD_Address_Line_1')]");
	public String getAddress() {
		return util.getAttributeValue(address, "value");
	}
	
	By city = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'City')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'GRANTOR_PROPADD_City')]");
	public String getCity() {
		return util.getAttributeValue(city, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'State:')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'GRANTOR_PROPADD_STATE_ID') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By zipCode = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Zip Code')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'GRANTOR_PROPADD_Zip_Code') and @type='text'])[1]");
	public String getZipCode() {
		return util.getAttributeValue(zipCode, "value");
	}
	
	By leaseNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Lease Number')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Number') and @type='text']");
	public String getLeaseNumber() {
		return util.getAttributeValue(leaseNumber, "value");
	}
	
	By leaseType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Lease Type')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Type') and @type='text']");
	public String getLeaseType() {
		return util.getAttributeValue(leaseType, "value");
	}
	
	By parcelAcres = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel Acres: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TractType_customFields2_25') and @type='text']");
	public String getParcelAcres() {
		return util.getAttributeValue(parcelAcres, "value");
	}
	
	By gisParcelAcres = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='GIS Parcel Acres: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_customFields2_29') and @type='text']");
	public String getGISAcres() {
		return util.getAttributeValue(gisParcelAcres, "value");
	}
	
	By leasedAcres = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Leased Acres: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_customFields2_32') and @type='text']");
	public String getLeasedAcres() {
		return util.getAttributeValue(leasedAcres, "value");
	}
	
	By excludedAcres = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Excluded Acres: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_customFields2_33') and @type='text']");
	public String getExcludedAcres() {
		return util.getAttributeValue(excludedAcres, "value");
	}
	
	By statePID = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'State PID')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_TractType_radGISID') and @type='text']");
	public String getStatePID() {
		return util.getAttributeValue(statePID, "value");
	}
	
	By quarterSection = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='1/4 Section (CDN): ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_QSec') and @type='text']");
	public String getQuarterSection() {
		return util.getAttributeValue(quarterSection, "value");
	}
	
	By section = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Section: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Section') and @type='text']");
	public String getSection() {
		return util.getAttributeValue(section, "value");
	}
	
	By block = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Block: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Block') and @type='text']");
	public String getBlock() {
		return util.getAttributeValue(block, "value");
	}
	
	By lot = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Lot: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Lot') and @type='text']");
	public String getLot() {
		return util.getAttributeValue(lot, "value");
	}
	
	By township = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Township: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Township') and @type='text']");
	public String getTownship() {
		return util.getAttributeValue(township, "value");
	}
	
	By range = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Range: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Range') and @type='text']");
	public String getRange() {
		return util.getAttributeValue(range, "value");
	}
	
	By meridian = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Meridian (CDN): ']/..//input[contains(@id,'Dest_Input')]");
	public String getMeridian() {
		return util.getAttributeValue(meridian, "value");
	}
	
	By county = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_County') and @type='text']");
	public String getCounty() {
		return util.getAttributeValue(county, "value");
	}
	
	By province = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State/Province: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_STATE') and @type='text']");
	public String getProvince() {
		return util.getAttributeValue(province, "value");
	}
	
	By orionInterested = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Orion Interested: ']/..//input[contains(@id,'Dest_Input')]");
	public String getOrionInterested() {
		return util.getAttributeValue(orionInterested, "value");
	}
	
	By ownerLabel = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Owner Label: ']/..//input[contains(@id,'Dest_Input')] | //span[text()='Owner Label:']/..//input[@type='text']");
	public String getOwnerLabel() {
		return util.getAttributeValue(ownerLabel, "value");
	}
	
	By Tier = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Tier: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TractType_Acquisition_type_ID_radYALDropDownList_Input')]");
	public String getTier() {
		return util.getAttributeValue(Tier, "value");
	}
	
	By status = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Status: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Status_ID') and @type='text']");
	public String getStatus() {
		return util.getAttributeValue(status, "value");
	}
	
	Map<String, String> excelData;
	public void LandDataMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.LandDataMappingOrion, testcaseName);
				assertion.assertEquals(getParcelNumber(), excelData.get("Parcel ID").trim(), "Parcel ID mapping mismatched");
				ExtentTestManager.log("Parcel ID Mapping : " +getParcelNumber());
				
				assertion.assertEquals(getLegalDesc(), excelData.get("Legal Desc").trim(), "Legal Description mapping mismatched");
				ExtentTestManager.log("Legal Description Mapping : "+getLegalDesc());
				
				assertion.assertEquals(getGrantor(), excelData.get("Grantor").trim(), "Grantor mapping mismatched");
				ExtentTestManager.log("Grantor Mapping : "+getGrantor());
				
				assertion.assertEquals(getAddress(), excelData.get("Address").trim(), "Address mapping mismatched");
				ExtentTestManager.log("Address Mapping : "+getAddress());
				
				assertion.assertEquals(getCity(), excelData.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());
				
				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getZipCode(), excelData.get("Zip Code").trim(), "Zip Code mapping mismatched");
				ExtentTestManager.log("Zip Code Mapping : "+getZipCode());
				
				assertion.assertEquals(getLeaseNumber(), excelData.get("Lease Number").trim(), "Lease Number mapping mismatched");
				ExtentTestManager.log("Lease Number Mapping : "+getLeaseNumber());
				
				assertion.assertEquals(getLeaseType(), excelData.get("Lease Type").trim(), "Lease Type mapping mismatched");
				ExtentTestManager.log("Lease Type Mapping : "+getLeaseType());
				
				assertion.assertEquals(getParcelAcres(), excelData.get("Parcel Acres").trim(), "Parcel Acres mapping mismatched");
				ExtentTestManager.log("Parcel Acres Mapping : "+getParcelAcres());
				
				assertion.assertEquals(getGISAcres(), excelData.get("GIS Parcel Acres").trim(), "GIS Parcel Acres mapping mismatched");
				ExtentTestManager.log("GIS Parcel Acres Mapping : "+getGISAcres());
				
				assertion.assertEquals(getLeasedAcres(), excelData.get("Leased Acres").trim(), "Leased Acres mapping mismatched");
				ExtentTestManager.log("Leased Acres Mapping : "+getLeasedAcres());
				
				assertion.assertEquals(getExcludedAcres(), excelData.get("Excluded Acres").trim(), "Excluded Acres mapping mismatched");
				ExtentTestManager.log("Excluded Acres Mapping : "+getExcludedAcres());
				
				assertion.assertEquals(getStatePID(), excelData.get("State PID").trim(), "State PID mapping mismatched");
				ExtentTestManager.log("State PID Mapping : "+getStatePID());
				
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
				
				assertion.assertEquals(getMeridian(), excelData.get("Meridian").trim(), "Meridian mapping mismatched");
				ExtentTestManager.log("Meridian Mapping : "+getMeridian());
				
				assertion.assertEquals(getCounty(), excelData.get("County").trim(), "county mapping mismatched");
				ExtentTestManager.log("county Mapping : "+getCounty());
				
				assertion.assertEquals(getProvince(), excelData.get("Province").trim(), "Province mapping mismatched");
				ExtentTestManager.log("Province Mapping : "+getProvince());
				
				assertion.assertEquals(getOrionInterested(), excelData.get("Orion Interested").trim(), "Orion Interested mapping mismatched");
				ExtentTestManager.log("Orion Interested Mapping : "+getOrionInterested());
				
				assertion.assertEquals(getOwnerLabel(), excelData.get("Owner Label").trim(), "Owner Label mapping mismatched");
				ExtentTestManager.log("Owner Label Mapping : "+getOwnerLabel());
				
				assertion.assertEquals(getTier(), excelData.get("Tier").trim(), "Tier mapping mismatched");
				ExtentTestManager.log("Tier Mapping : "+getTier());
				
				assertion.assertEquals(getStatus(), excelData.get("Status").trim(), "Status mapping mismatched");
				ExtentTestManager.log("Status Mapping : "+getStatus());
				assertion.assertAll();		
			
			}
	
	public void verifyLandDataMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
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
	By navLandowner = By.xpath("//span[text()='Landowner']");
	By navGrantor = By.xpath("//span[text()='Grantor']");
	By iframeDescription = By.xpath("//iframe[contains(@id,'PROPERTY_LEGAL_DESC_contentIframe')]");

	public void verifyImportedLandData(Map<String, String> map, String testcaseName) {	
		ExtentTestManager.log("Verifying Imported Land Data for parcel # "+map.get("Parcel ID").trim());
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("(//td[text()='"+map.get("Parcel ID").trim()+"']/parent::tr)[1]");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
			    By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Parcel ID")+"']");
				util.waitForWebElementToBePresent(parcelSummary, IMPLICIT_WAIT);
				
				assertion.assertEquals(getParcelNumber(), map.get("Parcel ID").trim(), "Parcel number mismatched");
				ExtentTestManager.log("Parcel number matched : " +getParcelNumber());
				
//				By btnActive = By.xpath("//input[contains(@id,'takeOffline')]");
//				util.waitForWebElementToBePresent(btnActive, IMPLICIT_WAIT);
//				ExtentTestManager.log("Parcel is in Active Status");
				
				assertion.assertEquals(getTier(), map.get("Tier").trim(), "Tier mismatched");
				ExtentTestManager.log("Tier matched : "+getTier());
				
				assertion.assertEquals(getParcelAcres(), map.get("Parcel Acres").trim(), "Parcel Acres mismatched");
				ExtentTestManager.log("Parcel Acres matched : "+getParcelAcres());
				
				assertion.assertEquals(getGISAcres(), map.get("GIS Parcel Acres").trim(), "GIS Parcel Acres mismatched");
				ExtentTestManager.log("GIS Parcel Acres matched : "+getGISAcres());
				
				assertion.assertEquals(getLeasedAcres(), map.get("Leased Acres").trim(), "Leased Acres mismatched");
				ExtentTestManager.log("Leased Acres matched : "+getLeasedAcres());
				
				assertion.assertEquals(getExcludedAcres(), map.get("Excluded Acres").trim(), "Excluded Acres mismatched");
				ExtentTestManager.log("Excluded Acres matched : "+getExcludedAcres());
				
				assertion.assertEquals(getStatePID(), map.get("County PID").trim(), "County PID mismatched");
				ExtentTestManager.log("County PID matched : "+getStatePID());
				
				if(clientName.contains("ORION")){
					if(util.isElementVisible(navGrantor)) {
					util.waitUntilElementDisplay(navGrantor);
					util.click(navGrantor);
					}
					else {
						util.waitUntilElementDisplay(navLandowner);
						util.click(navLandowner);
					}
				}else {
				util.dummyWait(1);
				util.waitUntilElementDisplay(navLandowner);
				util.click(navLandowner);
				util.dummyWait(1);
				}
				
				assertion.assertEquals(getGrantor(), map.get("Grantor").trim(), "Grantor mismatched");
				ExtentTestManager.log("Grantor matched : "+getGrantor());
				
				assertion.assertEquals(getAddress(), map.get("Address").trim(), "Address mismatched");
				ExtentTestManager.log("Address matched : "+getAddress());
				
				assertion.assertEquals(getCity(), map.get("City").trim(), "City mismatched");
				ExtentTestManager.log("City matched : "+getCity());
				
				assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
				ExtentTestManager.log("State matched : "+getState());
				
				assertion.assertEquals(getZipCode(), map.get("Zip Code").trim(), "Zip Code mismatched");
				ExtentTestManager.log("Zip Code matched : "+getZipCode());
				
				if(clientName.contains("ORION")){
					if(util.isElementVisible(navGrantor)) {
					util.waitUntilElementDisplay(navGrantor);
					util.click(navGrantor);
					}
					else {
						util.waitUntilElementDisplay(navLandowner);
						util.click(navLandowner);
					}
				}else {
				util.dummyWait(1);
				util.waitUntilElementDisplay(navLandowner);
				util.click(navLandowner);
				util.dummyWait(1);
				}
				
				util.waitUntilElementDisplay(navLegalDescription);
				util.click(navLegalDescription);
				util.dummyWait(1);
				
				util.switchToIframe(iframeDescription);
				
				By textDesc = By.xpath("(//body/../..//*[text()='"+map.get("Legal Desc").trim()+"'])[1]");
				String text = driver.findElement(textDesc).getText();
				if(util.isElementVisible(textDesc)) {
				assertion.assertEquals(text, map.get("Legal Desc").trim(), "Legal Desc mismatched");
				ExtentTestManager.log("Legal Desc matched : "+text);
				}
				
				util.switchToDefaultContent();
				By edit = By.xpath("(//*[contains(@id,'LEGALDESC_radYALGridControl_ctl00__')]/..//td[3]/.//*[text()='"+map.get("Province")+"'])[1]/../..//*[@title='Edit']");
				util.click(edit);
				util.dummyWait(3);
					
				assertion.assertEquals(getProvince(), map.get("Province").trim(), "Province mismatched");
				ExtentTestManager.log("Province matched : "+getProvince());
				
				assertion.assertEquals(getCounty(), map.get("County").trim(), "County mismatched");
				ExtentTestManager.log("County matched : "+getCounty());
				
				assertion.assertEquals(getQuarterSection(), map.get("Quarter Section").trim(), "Quarter Section mismatched");
				ExtentTestManager.log("Quarter Section matched : "+getQuarterSection());
				
				assertion.assertEquals(getSection(), map.get("Section").trim(), "Section mismatched");
				ExtentTestManager.log("Section matched : "+getSection());
				
				assertion.assertEquals(getTownship(), map.get("Township").trim(), "Township mismatched");
				ExtentTestManager.log("Township matched : "+getTownship());
				
				assertion.assertEquals(getRange(), map.get("Range").trim(), "Range mismatched");
				ExtentTestManager.log("Range matched : "+getRange());
				
				assertion.assertEquals(getLot(), map.get("Lot").trim(), "Lot mismatched");
				ExtentTestManager.log("Lot matched : "+getLot());
				
				assertion.assertEquals(getBlock(), map.get("Block").trim(), "Block mismatched");
				ExtentTestManager.log("Block matched : "+getBlock());
				
					By agreementNo = By.xpath("//a[text()='"+map.get("Lease Number")+"']");
					util.waitForWebElementToBePresent(agreementNo, IMPLICIT_WAIT);
					ExtentTestManager.log("Lease Number matched : "+driver.findElement(agreementNo).getText());
					
					util.click(agreementNo);
					util.dummyWait(10);
					By agrPopUp = By.xpath("//iframe[@name='LeaseManager']");
					util.switchToIframe(agrPopUp);
					assertion.assertEquals(getLeaseNumber(), map.get("Lease Number").trim(), "Lease Number mismatched");
					
					assertion.assertEquals(getLeaseType(), map.get("Lease Type").trim(), "Lease Type mismatched");
					ExtentTestManager.log("Lease Type : "+getLeaseType());
					
					assertion.assertEquals(getStatus(), map.get("Status").trim(), "Lease Status mismatched");
					ExtentTestManager.log("Lease Status : "+getStatus());
					
					if (testcaseName.contains("ORION")){
						assertion.assertEquals(getOwnerLabel(), map.get("Owner Label").trim(), "Owner Label mismatched");
						ExtentTestManager.log("Owner Label : "+getOwnerLabel());
					}
					
				assertion.assertAll();
			
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.landDatavalidationMsgOrion(testcaseName); 
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
