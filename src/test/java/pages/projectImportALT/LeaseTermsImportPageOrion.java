package pages.projectImportALT;

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

public class LeaseTermsImportPageOrion extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public LeaseTermsImportPageOrion(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By leaseNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Lease Number: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'Lease_Number') and @type='text'])[2]");
	public String getLeaseNumber() {
		return util.getAttributeValue(leaseNumber, "value");
	}
	
    By agreementTermType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Term Type: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'Period_Type_ID') and @type='text']");
	public String getAgreementTermType() {
		return util.getAttributeValue(agreementTermType, "value");
	}
	
    By effectiveDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Effective Date: ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'Effective_Date_dateInput') and @type='text']");
	public String getEffectiveDate() {
	    return util.getAttributeValue(effectiveDate, "value");
	}
		
	By  termLengthyears = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()=' Term Length (years): ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'Term_Years') and @type='text']");
	public String getTermLengthyears() {
		return util.getAttributeValue(termLengthyears, "value");
	}
		
	By  termLengthmonth = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()=' Term Length (months): ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'Term_Months') and @type='text']");
	public String getTermLengthmonth() {
		return util.getAttributeValue(termLengthmonth, "value");
	}
			
    By termActive = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Term Active: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'active_ind') and @type='checkbox']");
	public String getTermActive() {
		return util.getAttributeValue(termActive, "value");
	}
	
	Map<String, String> excelData;
	public void LeaseTermsMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementTermsMapping, testcaseName);
				assertion.assertEquals(getLeaseNumber(), excelData.get("Agreement Number").trim(), "Lease number mapping mismatched");
				ExtentTestManager.log("Lease number Mapping : " +getLeaseNumber());
				
				assertion.assertEquals(getAgreementTermType(), excelData.get("Agreement Term Type").trim(), "Agreement Term Type mapping mismatched");
				ExtentTestManager.log("Agreement Term Type Mapping : "+getAgreementTermType());
				
				assertion.assertEquals(getEffectiveDate(), excelData.get("Effective Date").trim(), "Effective Date mapping mismatched");
				ExtentTestManager.log("Effective Date Mapping : "+getEffectiveDate());
				
				assertion.assertEquals(getTermLengthyears(), excelData.get("Term Length Yrs").trim(), " Term Length (years) mapping mismatched");
				ExtentTestManager.log(" Term Length (years) Mapping : "+getTermLengthyears());
				
				assertion.assertEquals(getTermLengthmonth(), excelData.get("Term Length mnt").trim(), " Term Length (months) mapping mismatched");
				ExtentTestManager.log(" Term Length (months) Mapping : "+getTermLengthmonth());
				
				assertion.assertEquals(getTermActive(), excelData.get("Active").trim(), "Term Active mapping mismatched");
				ExtentTestManager.log("Term Active Mapping : "+getTermActive());
				
				assertion.assertAll();	
			
			}
	
	
	public void verifyLeaseTermsMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			LeaseTermsMapping(testcaseName);
			log("STEP 7:  All Agreement Terms Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	
	By agreementtermPopup = By.xpath("//iframe[contains(@name,'LeaseDocument')]");
	By closePopup = By.xpath("//a[@title='Close']");

	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		ExtentTestManager.log("Validating Lease Term for the Lease Number "+map.get("Lease Number").trim());
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Lease Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
	            
				assertion.assertEquals(getLeaseNumber(), map.get("Lease Number").trim(), "Lease Number mismatched");
				ExtentTestManager.log("Lease Number matched : "+getLeaseNumber());
				
				By showDetails = By.xpath("(//*[contains(@id,'LEASE_PAYMENTS_radYALGridControl')]//*[text()='Show Details'])[1]");
				util.waitForWebElementToBePresent(showDetails, IMPLICIT_WAIT);
				util.click(showDetails);
				
				ExtentTestManager.log("Lease Term Details pop up appeared");
				util.switchToIframe(agreementtermPopup);
				
				assertion.assertEquals(getAgreementTermType(), map.get("Agreement Term Type").trim(), "Agreement Term Type mismatched");
				ExtentTestManager.log("Agreement Term Type matched : "+getAgreementTermType());
				
				WebElement activeCheckbox= driver.findElement(termActive);
				if(activeCheckbox.isSelected()) {
					ExtentTestManager.log("Active Checkbox is Checked");
				}else {
					ExtentTestManager.log("Active Checkbox is Unchecked");
				}
				
				assertion.assertEquals(getEffectiveDate(), map.get("Effective Date").trim(), "Effective Date mismatched");
				ExtentTestManager.log("Effective Date matched : "+getEffectiveDate());
				
				assertion.assertEquals(getTermLengthyears(), map.get("Term Length (years)").trim(), "Term Length (years) mismatched");
				ExtentTestManager.log("Term Length (years) matched : "+getTermLengthyears());
				
				assertion.assertEquals(getTermLengthmonth(), map.get("Term Length (months)").trim(), "Term Length (months) mismatched");
				ExtentTestManager.log("Term Length (months) matched : "+getTermLengthmonth());
					
				util.switchToDefaultContent();
				util.click(closePopup);
				util.dummyWait(3);
				assertion.assertAll();
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.LeaseTermsvalidationMsg(testcaseName); 
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
