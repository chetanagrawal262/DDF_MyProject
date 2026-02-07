package pages.ProjectImportROW;

import java.io.File;
import java.util.HashMap;
import java.util.List;
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
import pages.ProjectImportROW.ErrorLog;
import pages.projectImportALT.ProjectImportPage;

public class AgreementImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public AgreementImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	
	By tractNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Tract #: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TRACT_NUMBER') and @type='text'])[1]");
	public String getTractNumber() {
		return util.getAttributeValue(tractNumber, "value");
	}
	
	By agreementdocumenttypeCat = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Doc Type Category: ']/..//input[contains(@id,'Dest_Input')] | //*[contains(@id,'_EditFormControl_DOCUMENT_TYPE_ID_RadDropDownTree1')]/span/span[1]");
	public String getAgreementdocumenttypeCat() {
		return util.getAttributeValue(agreementdocumenttypeCat, "value");
	}
	
	By agreementdocumenttypeCatChild = By.xpath("(//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Doc Type Category Child: ']/..//input[contains(@id,'Dest_Input')] | //div[contains(@id,'EditFormControl_DOCUMENT_TYPE_ID_RadDropDownTree1')])[1]");
	public String getAgreementdocumenttypeCatChild() {
		return util.getAttributeValue(agreementdocumenttypeCatChild, "value");
	}
	
	By dateExecuted = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Date Executed: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_DATE_EXECUTED_dateInput') and @type='text'] ");
	public String getDateExecuted() {
		return util.getAttributeValue(dateExecuted, "value");
	}
	
	By effectiveDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Effective Date: ']/..//input[contains(@id,'Dest_Input')] | (//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[contains(text(),'Effective Date')]/..//input[@type='text'])[2]");
	public String getEffectiveDate() {
		return util.getAttributeValue(effectiveDate, "value");
	}
	
	By expirationDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Expiration Date: ']/..//input[contains(@id,'Dest_Input')] | (//*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[contains(text(),'Expiration Date')]/..//input[@type='text'])[2] ");
	public String getExpirationDate() {
		return util.getAttributeValue(expirationDate, "value");
	}
	
	By grantor = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Grantor: ']/..//input[contains(@id,'Dest_Input')] | //*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[text()='Grantor:']/..//textarea");
	public String getGrantor() {
		return util.getAttributeValue(grantor, "value");
	}
	
	By grantee = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Grantee: ']/..//input[contains(@id,'Dest_Input')] | //*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[text()='Grantee:']/..//textarea");
	public String getGrantee() {
		return util.getAttributeValue(grantee, "value");
	}
	
	By comments = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Comments: ']/..//input[contains(@id,'Dest_Input')] | //*[contains(@id,'_EditFormControl_CustFieldAGMNew')]/..//span[text()='Comments:']/..//textarea");
	public String getComments() {
		return util.getAttributeValue(comments, "value");
	}
	By externalAgreementNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='External Agreement #: ']/..//input[contains(@id,'Dest_Input')] | //span[contains(text(),'External Agreement')]/..//input[@type='text']");
	public String getExternalAgreementNo() {
		return util.getAttributeValue(externalAgreementNo, "value");
	}
	
	By leaseSetupRequired = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Lease Setup Required: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_recurring_payment_flag')]");
	public String getLeaseSetupRequired() {
		return util.getAttributeValue(leaseSetupRequired, "value");
	}
	
	By unrecorded = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Unrecorded: ']/..//input[contains(@id,'Dest_Input')] | //span[text()='Unrecorded:']/..//input");
	public String getUnrecorded() {
		return util.getAttributeValue(unrecorded, "value");
	}
	
	By perpetual = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Perpetual: ']/..//input[contains(@id,'Dest_Input')] | //span[text()='Perpetual:']/..//input ");
	public String getPerpetual() {
		return util.getAttributeValue(perpetual, "value");
	}
	
	By extensionProvision = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Extension Provision: ']/..//input[contains(@id,'Dest_Input')] | //span[text()='Extension Provision:']/..//input");
	public String getExtensionProvision() {
		return util.getAttributeValue(extensionProvision, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_State') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By county = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_rcbCounty_Input') and @type='text']");
	public String getCounty() {
		return util.getAttributeValue(county, "value");
	}
	
	By bookvolume = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Book/Volume: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Doc_Book') and @type='text']");
	public String getBookVolume() {
		return util.getAttributeValue(bookvolume, "value");
	}
	
	By page = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Page: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Doc_Page') and @type='text']");
	public String getPage() {
		return util.getAttributeValue(page, "value");
	}
	
	
	By microfilm = By.xpath("(//span[contains(@id,'idYalImport_SourceCols') and text()='Microfilm: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Micro_Film')])[1]");
	public String getMicrofilm() {
		return util.getAttributeValue(microfilm, "value");
	}
	
	By instrumentRecordingDocNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Instrument/Recording/Doc #: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_DOC_NO') and @type='text']");
	public String getInstrumentRecordingDocNo() {
		return util.getAttributeValue(instrumentRecordingDocNo, "value");
	}
	
	
	By dateRecorded = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Date Recorded: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Date_Recorded_Info_dateInput') and @type='text'] ");
	public String getDateRecorded() {
		return util.getAttributeValue(dateRecorded, "value");
	}
	
	
	By leaseNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Lease Number: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_rtbLeaseNum') and @type='text']");
	public String getLeaseNumber() {
		return util.getAttributeValue(leaseNumber, "value");
	}
	
	

	

	Map<String, String> excelData;
	public void AgreementImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementMapping, testcaseName);
				
				assertion.assertEquals(getTractNumber(), excelData.get("Tract #").trim(), "Tract # mapping mismatched");
				ExtentTestManager.log("Tract # Mapping : " +getTractNumber());
				
				assertion.assertEquals(getAgreementdocumenttypeCat(), excelData.get("Agreement Doc Type Category").trim(), "Agreement Doc Type Category mapping mismatched");
				ExtentTestManager.log("Agreement Doc Type Category Mapping : "+getAgreementdocumenttypeCat());
				
				assertion.assertEquals(getAgreementdocumenttypeCatChild(), excelData.get("Agreement Doc Type Category Child").trim(), "Agreement Doc Type Category Child mapping mismatched");
				ExtentTestManager.log("Agreement Doc Type Category Child Mapping : "+getAgreementdocumenttypeCatChild());
				
				assertion.assertEquals(getDateExecuted(), excelData.get("Date Executed").trim(), "Date Executed mapping mismatched");
				ExtentTestManager.log("Date Executed Mapping : "+getDateExecuted());
				
				assertion.assertEquals(getEffectiveDate(), excelData.get("Effective Date").trim(), "Effective Date mapping mismatched");
				ExtentTestManager.log("Effective Date Mapping : "+getEffectiveDate());
				
				assertion.assertEquals(getExpirationDate(), excelData.get("Expiration Date").trim(), "Expiration Date mapping mismatched");
				ExtentTestManager.log("Expiration Date Mapping : "+getExpirationDate());
				
				assertion.assertEquals(getGrantor(), excelData.get("Grantor").trim(), "Grantor mapping mismatched");
				ExtentTestManager.log("Grantor Mapping : "+getGrantor());
				
				assertion.assertEquals(getGrantee(), excelData.get("Grantee").trim(), "Grantee mapping mismatched");
				ExtentTestManager.log("Grantee Mapping : "+getGrantee());
				
				assertion.assertEquals(getComments(), excelData.get("Comments").trim(), "Comments mapping mismatched");
				ExtentTestManager.log("Comments Mapping : "+getComments());
				
				assertion.assertEquals(getExternalAgreementNo(), excelData.get("External Agreement #").trim(), "External Agreement # mapping mismatched");
				ExtentTestManager.log("External Agreement # Mapping : "+getExternalAgreementNo());
				
				assertion.assertEquals(getLeaseSetupRequired(), excelData.get("Lease Setup Required").trim(), "Lease Setup Required mapping mismatched");
				ExtentTestManager.log("Lease Setup Required Mapping : "+getLeaseSetupRequired());
				
				assertion.assertEquals(getUnrecorded(), excelData.get("Unrecorded").trim(), "Unrecorded mapping mismatched");
				ExtentTestManager.log("Unrecorded Mapping : "+getUnrecorded());
				
				assertion.assertEquals(getPerpetual(), excelData.get("Perpetual").trim(), "Perpetual mapping mismatched");
				ExtentTestManager.log("Perpetual Mapping : "+getPerpetual());
				
				assertion.assertEquals(getExtensionProvision(), excelData.get("Extension Provision").trim(), "Extension Provision mapping mismatched");
				ExtentTestManager.log("Recorded Date Mapping : "+getExtensionProvision());
				
				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getCounty(), excelData.get("County").trim(), "County mapping mismatched");
				ExtentTestManager.log("County Mapping : "+getCounty());
				
				assertion.assertEquals(getBookVolume(), excelData.get("Book/Volume").trim(), "Book/Volume mapping mismatched");
				ExtentTestManager.log("Book/Volume Mapping : "+getBookVolume());
				
				assertion.assertEquals(getPage(), excelData.get("Page").trim(), "Page mapping mismatched");
				ExtentTestManager.log("Page Mapping : "+getPage());
				
				assertion.assertEquals(getMicrofilm(), excelData.get("Microfilm").trim(), "Microfilm mapping mismatched");
				ExtentTestManager.log("Microfilm Mapping : "+getMicrofilm());
				
				assertion.assertEquals(getInstrumentRecordingDocNo(), excelData.get("Instrument/Recording/Doc #").trim(), "Instrument/Recording/Doc # mapping mismatched");
				ExtentTestManager.log("Instrument/Recording/Doc # Mapping : "+getInstrumentRecordingDocNo());
				
				assertion.assertEquals(getDateRecorded(), excelData.get("Date Recorded").trim(), "Date Recorded mapping mismatched");
				ExtentTestManager.log("Date Recorded Mapping : "+getDateRecorded());
				
				assertion.assertEquals(getLeaseNumber(), excelData.get("Lease Number").trim(), "Lease Number mapping mismatched");
				ExtentTestManager.log("Lease Number Mapping : "+getLeaseNumber());
				
				assertion.assertAll();

			}
	
	public void verifyAgreementImportMapping(Map<String, String> map, String testcaseName) throws Exception {
	objProjectImportPage.projectDataImport(map, testcaseName);
	try {
		AgreementImportMapping(testcaseName);
		log("STEP 7:  All Land  Data Mappings are correct", Status.PASS);
	} catch (Exception e) {
		log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
		throw new RuntimeException("Failed in step 7");
	}
	util.dummyWait(10);
	
}

	By navAgreementManagement = By.xpath("//span[text()='Agreement Management']");
	By AgreementManagementEdit = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl_ctl00_ctl04_EditButton')]");
	
	By RecodingInfo = By.xpath("//*[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl')]/..//a[text()=' Recording Info ']");
	By RecordingInfoEdit = By.xpath("//input[contains(@id,'AGMRecordingInfo_radYALGridControl_ctl00_ctl04_EditButton')]");
	By iframerecordingInfo = By.xpath("//body[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/iframe[1]");
	
	By doctypeDD = By.xpath("(//*[contains(@id,'EditFormControl_DOCUMENT_TYPE_ID_RadDropDownTree1')]/..//span[2])[13]");
	By loaderIcon = By.xpath("(//div[contains(@id,'_RadMultiPage1')])[1]");

	public void validationOfImportedData(String testcaseName) {

		SoftAssert assertion = new SoftAssert();
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.AgreementImport,testcaseName);
		util.dummyWait(2);
		
			
				 	By addedRecord = By.xpath("//td[text()='"+map.get("Tract #") +"']/parent::tr");
					Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
					util.click(addedRecord);
				
					util.waitUntilElementDisappear(loaderIcon);
					assertion.assertEquals(getTractNumber(), map.get("Tract #").trim(), "Parcel number mismatched");
					ExtentTestManager.log("Parcel number matched : " +getTractNumber());
				
					
					util.dummyWait(2);
					util.waitUntilElementDisplay(navAgreementManagement);
					util.click(navAgreementManagement);
					util.dummyWait(2);
					util.click(AgreementManagementEdit);
					
					
					util.dummyWait(2);
					
					assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
					ExtentTestManager.log("State : "+getState());
					
					assertion.assertEquals(getDateExecuted(), map.get("Date Executed").trim(), "Date Executed mismatched");
					ExtentTestManager.log("Date Executed : "+getDateExecuted());
					
					assertion.assertEquals(getLeaseSetupRequired(), map.get("Lease Setup Required").trim(), "Lease Setup Required mismatched");
					ExtentTestManager.log("Lease Setup Required : "+getLeaseSetupRequired());
					
					assertion.assertEquals(getLeaseNumber(), map.get("Lease Number").trim(), "Lease Number value mismatched");
					ExtentTestManager.log("Lease Number value  : "+getLeaseNumber());
					
					assertion.assertEquals(getEffectiveDate(), map.get("Effective Date").trim(), "Effective Date mismatched");
					ExtentTestManager.log("Effective Date : "+getEffectiveDate());
					
					assertion.assertEquals(getExpirationDate(), map.get("Expiration Date").trim(), "Expiration Date mismatched");
					ExtentTestManager.log("Expiration Date  : "+getExpirationDate());
					
					assertion.assertEquals(getExternalAgreementNo(), map.get("External Agreement #").trim(), "External Agreement # mismatched");
					ExtentTestManager.log("External Agreement # : "+getExternalAgreementNo());
					
					assertion.assertEquals(getGrantor(), map.get("Grantor").trim(), "Grantor mismatched");
					ExtentTestManager.log("Grantor : "+getGrantor());
					
					assertion.assertEquals(getGrantee(), map.get("Grantee").trim(), "Grantee mismatched");
					ExtentTestManager.log("Grantee : "+getGrantee());
					
					assertion.assertEquals(getComments(), map.get("Comments").trim(), "Comments mismatched");
					ExtentTestManager.log("Comments : "+getComments());
					
					
					util.dummyWait(2);
					util.click(RecodingInfo);
					util.dummyWait(2);
					util.switchToIframe(iframerecordingInfo);
					util.click(RecordingInfoEdit);
					
					assertion.assertEquals(getCounty(), map.get("County").trim(), "County mismatched");
					ExtentTestManager.log("County : "+getCounty());

					assertion.assertEquals(getBookVolume(), map.get("Book/Volume").trim(), "Book/Volume value mismatched");
					ExtentTestManager.log("Book/Volume value  : "+getBookVolume());
					
					assertion.assertEquals(getPage(), map.get("Page").trim(), "Page mismatched");
					ExtentTestManager.log("Page : "+getPage());
					
					assertion.assertEquals(getMicrofilm(), map.get("Microfilm").trim(), "Microfilm value mismatched");
					ExtentTestManager.log("Microfilm value  : "+getMicrofilm());
					
					assertion.assertEquals(getInstrumentRecordingDocNo(), map.get("Instrument/Recording/Doc #").trim(), "Instrument/Recording/Doc # value mismatched");
					ExtentTestManager.log("Instrument/Recording/Doc # value  : "+getInstrumentRecordingDocNo());

					assertion.assertEquals(getDateRecorded(), map.get("Date Recorded").trim(), "Date Recorded value mismatched");
					ExtentTestManager.log("Date Recorded value  : "+getDateRecorded());
					
					
					
					assertion.assertAll();
					
					}
		
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.AgreementvalidationMsg(testcaseName); 
			objErrorLog.printErrorLog();
	        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
		} catch (Exception t) {
			  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
			  throw new RuntimeException("Failed in step 12");
		}
		
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
			
		
