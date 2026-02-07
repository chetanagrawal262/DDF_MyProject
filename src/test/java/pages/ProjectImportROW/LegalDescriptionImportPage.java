package pages.ProjectImportROW;

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
import pages.projectImportALT.ProjectImportPage;

public class LegalDescriptionImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public LegalDescriptionImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By tractNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Tract #: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getTractNo() {
		
		return util.getAttributeValue(tractNo, "value");
	}
	
	By district = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'District: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[1]");
	public String getDistrict() {
		
		return util.getAttributeValue(district, "value");
	}
	
	By quarterSection = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Quarter Section')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[2]");
	public String getQuarterSection() {
		return util.getAttributeValue(quarterSection, "value");
	}
	
	By section = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Section: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[3]");
	public String getSection() {
		return util.getAttributeValue(section, "value");
	}
	
	By township = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Township: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[4]");
	public String getTownship() {
		return util.getAttributeValue(township, "value");
	}
	
	By range = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Range: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[5]");
	public String getRange() {
		return util.getAttributeValue(range, "value");
	}
	
	By survey = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Survey: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[6]");
	public String getSurvey() {
		return util.getAttributeValue(survey, "value");
	}
	
	By Abstract = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Abstract: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[7]");
	public String getAbstract() {
		return util.getAttributeValue(Abstract, "value");
	}
	
	By porcion = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Porcion: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[8]");
	public String getPorcion() {
		return util.getAttributeValue(porcion, "value");
	}
	
	By share = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Share: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[9]");
	public String getShare() {
		return util.getAttributeValue(share, "value");
	}
	
	By lot = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='LOT: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[10]");
	public String getLot() {
		return util.getAttributeValue(lot, "value");
	}
	
	By block = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Block: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[11]");
	public String getBlock() {
		return util.getAttributeValue(block, "value");
	}
	
	By subdivision = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Subdivision: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[12]");
	public String getSubdivision() {
		return util.getAttributeValue(subdivision, "value");
	}
	
	By city = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='City: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[13]");
	public String getCity() {
		return util.getAttributeValue(city, "value");
	}
	
	By county = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'County')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[14]");
	public String getCounty() {
		return util.getAttributeValue(county, "value");
	}
	
	By taxParcelNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Tax Parcel Number')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_rtbFieldValue') and @type='text'])[15]");
	public String getTaxParcelNumber() {
		return util.getAttributeValue(taxParcelNumber, "value");
	}
	
	By fullLegal = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Full legal')]/..//input[contains(@id,'Dest_Input')]");
	public String getFullLegal() {
		return util.getAttributeValue(fullLegal, "value");
	}
	
	Map<String, String> excelData;
	public void LegalDescriptionMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.LegalDescriptionMapping, testcaseName);
				assertion.assertEquals(getTractNo(), excelData.get("Tract #").trim(), "Tract # mapping mismatched");
				ExtentTestManager.log("Tract # Mapping : " +getTractNo());
				
				assertion.assertEquals(getDistrict(), excelData.get("District").trim(), "District mapping mismatched");
				ExtentTestManager.log("District Mapping : " +getDistrict());
				
				assertion.assertEquals(getQuarterSection(), excelData.get("Quarter Section").trim(), "Quarter Section mapping mismatched");
				ExtentTestManager.log("Quarter Section Mapping : "+getQuarterSection());
				
				assertion.assertEquals(getSection(), excelData.get("Section").trim(), "Section mapping mismatched");
				ExtentTestManager.log("Section Mapping : "+getSection());
				
				assertion.assertEquals(getTownship(), excelData.get("Township").trim(), "Township mapping mismatched");
				ExtentTestManager.log("Township Mapping : "+getTownship());
				
				assertion.assertEquals(getRange(), excelData.get("Range").trim(), "Range mapping mismatched");
				ExtentTestManager.log("Range Mapping : "+getRange());
				
				assertion.assertEquals(getSurvey(), excelData.get("Survey").trim(), "Survey mapping mismatched");
				ExtentTestManager.log("Survey Mapping : "+getSurvey());
								
				assertion.assertEquals(getAbstract(), excelData.get("Abstract").trim(), "Abstract mapping mismatched");
				ExtentTestManager.log("Abstract Mapping : "+getAbstract());
				
				assertion.assertEquals(getPorcion(), excelData.get("Porcion").trim(), "Porcion mapping mismatched");
				ExtentTestManager.log("Porcion Mapping : "+getPorcion());
				
				assertion.assertEquals(getShare(), excelData.get("Share").trim(), "Share mapping mismatched");
				ExtentTestManager.log("Share Mapping : "+getShare());
				
				assertion.assertEquals(getLot(), excelData.get("Lot").trim(), "Lot mapping mismatched");
				ExtentTestManager.log("Lot Mapping : "+getLot());
				
				assertion.assertEquals(getBlock(), excelData.get("Block").trim(), "Block mapping mismatched");
				ExtentTestManager.log("Block Mapping : "+getBlock());
				
				assertion.assertEquals(getSubdivision(), excelData.get("Subdivision").trim(), "Subdivision mapping mismatched");
				ExtentTestManager.log("Subdivision Mapping : "+getSubdivision());
				
				assertion.assertEquals(getCity(), excelData.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());
				
				assertion.assertEquals(getCounty(), excelData.get("County").trim(), "County mapping mismatched");
				ExtentTestManager.log("County Mapping : "+getCounty());
				
				assertion.assertEquals(getTaxParcelNumber(), excelData.get("Tax Parcel Number").trim(), "Tax Parcel Number mapping mismatched");
				ExtentTestManager.log("Tax Parcel Number Mapping : "+getTaxParcelNumber());
				
					assertion.assertEquals(getFullLegal().toLowerCase(), excelData.get("Full legal").toLowerCase().trim(),
							"Full Legal mapping mismatched");
					ExtentTestManager.log("Full Legal Mapping : " + getFullLegal().toLowerCase());
				
				assertion.assertAll();		
			
			}
	
	public void verifyLegalDescriptionMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			LegalDescriptionMapping(testcaseName);
			log("STEP 7:  All Legal Description Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navLegalDescription = By.xpath("//span[text()='Legal Description']");
	By loaderIcon = By.xpath("(//div[contains(@id,'_RadMultiPage1')])[1]");
	
	public void validationOfImportedData(Map<String, String> map, String testcaseName) {	
		ExtentTestManager.log("Verifying Imported Legal Description Record for Tract # "+map.get("Tract #").trim());
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Tract #").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				util.waitUntilElementDisappear(loaderIcon);
				assertion.assertEquals(getTractNo(), map.get("Tract #").trim(), "Tract number mismatched");
				ExtentTestManager.log("Tract number matched : " +getTractNo());
				
				util.waitUntilElementDisplay(navLegalDescription);
				util.click(navLegalDescription);
				util.dummyWait(1);
				if(environment.contains("GRAYHAWKTCE")) {
					By btnEdit = By.xpath("(//tr[contains(@id,'gridCustomLegalDesc_radYALGridControl')]/..//*[text()='"+map.get("District")+"']/../..//*[@title='Edit'])[1]");
					util.click(btnEdit);
					util.dummyWait(2);
				}else {
					By btnEdit = By.xpath("//tr[contains(@id,'gridCustomLegalDesc_radYALGridControl')]/..//*[text()='"+map.get("Tax Parcel Number")+"']/../..//*[@title='Edit']");
					util.click(btnEdit);
					util.dummyWait(2);
				}
				
				
				assertion.assertEquals(getDistrict(), map.get("District").trim(), "District mismatched");
				ExtentTestManager.log("District matched : " +getDistrict());
				
				assertion.assertEquals(getQuarterSection(), map.get("Quarter Section").trim(), "Quarter Section mismatched");
				ExtentTestManager.log("Quarter Section matched : " +getQuarterSection());
				
				assertion.assertEquals(getSection(), map.get("Section").trim(), "Section mismatched");
				ExtentTestManager.log("Section matched : " +getSection());
				
				assertion.assertEquals(getTownship(), map.get("Township").trim(), "Township mismatched");
				ExtentTestManager.log("Township matched : " +getTownship());
				
				assertion.assertEquals(getRange(), map.get("Range").trim(), "Range mismatched");
				ExtentTestManager.log("Range matched : " +getRange());
				
				assertion.assertEquals(getSurvey(), map.get("Survey").trim(), "Survey mismatched");
				ExtentTestManager.log("Survey matched : " +getSurvey());
				
				assertion.assertEquals(getAbstract(), map.get("Abstract").trim(), "Abstract mismatched");
				ExtentTestManager.log("Abstract matched : " +getAbstract());
				
				assertion.assertEquals(getPorcion(), map.get("Porcion").trim(), "Porcion mismatched");
				ExtentTestManager.log("Porcion matched : " +getPorcion());
				
				assertion.assertEquals(getShare(), map.get("Share").trim(), "Share mismatched");
				ExtentTestManager.log("Share matched : " +getShare());
				
				assertion.assertEquals(getLot(), map.get("LOT").trim(), "Lot mismatched");
				ExtentTestManager.log("Lot matched : " +getLot());
				
				assertion.assertEquals(getBlock(), map.get("Block").trim(), "Block mismatched");
				ExtentTestManager.log("Block matched : " +getBlock());
				
				assertion.assertEquals(getSubdivision(), map.get("Subdivision").trim(), "Subdivision mismatched");
				ExtentTestManager.log("Subdivision matched : " +getSubdivision());
				
				assertion.assertEquals(getCity(), map.get("City").trim(), "City mismatched");
				ExtentTestManager.log("City matched : " +getCity());
				
				assertion.assertEquals(getCounty(), map.get("County").trim(), "County mismatched");
				ExtentTestManager.log("County matched : " +getCounty());
				
				assertion.assertEquals(getTaxParcelNumber(), map.get("Tax Parcel Number").trim(), "Tax Parcel Number mismatched");
				ExtentTestManager.log("Tax Parcel Number matched : " +getTaxParcelNumber());
				
				assertion.assertAll();
			
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.legalDescriptionvalidationMsg(testcaseName); 
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
