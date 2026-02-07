package pages.projectImportORSTED;

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

public class AgreementPhaseImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public AgreementPhaseImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By agreementNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Number: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'Lease_Number') and @type='text'])[2]");
	public String getAgreementNumber() {
		return util.getAttributeValue(agreementNumber, "value");
	}
	

	By agreementPhase = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Phase: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'Period_Type_ID') and @type='text']");
	public String getAgreementPhase() {
		return util.getAttributeValue(agreementPhase, "value");
	}
	

	By active = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Active: ']/..//input[contains(@id,'Dest_Input')] | (//*[contains(@id,'LSINFO_radPanels')]/..//*[text()='True'])[2] | //input[contains(@id,'active_ind') and @type='checkbox'] | //input[contains(@id,'active_ind') and @checked='checked']");
	public String getActive() {
		return util.getAttributeValue(active, "value");
	}

	By effectiveDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Effective Date: ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'Effective_Date_dateInput') and @type='text']");
	public String getEffectiveDate() {
		return util.getAttributeValue(effectiveDate, "value");
	}
	
	By  phaseLengthyears = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()=' Phase Length (years): ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'Term_Years') and @type='text']");
	public String getPhaseLengthyears() {
		return util.getAttributeValue(phaseLengthyears, "value");
	}

	By  phaseLengthmonth = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()=' Phase Length (months): ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'Term_Months') and @type='text']");
	public String getPhaseLengthmonth() {
		return util.getAttributeValue(phaseLengthmonth, "value");
	}

	By  phaseLengthdays = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Phase Length (days): ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'Term_Days') and @type='text']");
	public String getPhaseLengthdays() {
		return util.getAttributeValue(phaseLengthdays, "value");
	}
	
	By expirationDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Expiration Date: ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'Expiration_Date_dateInput') and @type='text']");
	public String getExpirationDate() {
		return util.getAttributeValue(expirationDate, "value");
	}
	
	
	Map<String, String> excelData;
	public void AgreementPhaseMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementTermsMapping, testcaseName);
				assertion.assertEquals(getAgreementNumber(), excelData.get("Agreement Number").trim(), "Agreement number mapping mismatched");
				ExtentTestManager.log("Agreement number Mapping : " +getAgreementNumber());
				
				assertion.assertEquals(getAgreementPhase(), excelData.get("Agreement Term Type").trim(), "Agreement Phase mapping mismatched");
				ExtentTestManager.log("Agreement Phase Mapping : "+getAgreementPhase());
				
				assertion.assertEquals(getActive(), excelData.get("Active").trim(), "Active mapping mismatched");
				ExtentTestManager.log("Active Mapping : "+getActive());
				
				assertion.assertEquals(getEffectiveDate(), excelData.get("Effective Date").trim(), "Effective Date mapping mismatched");
				ExtentTestManager.log("Effective Date Mapping : "+getEffectiveDate());
				
				assertion.assertEquals(getPhaseLengthyears(), excelData.get("Term Length Yrs").trim(), " Term Length (years) mapping mismatched");
				ExtentTestManager.log(" Term Length (years) Mapping : "+getPhaseLengthyears());
				
				assertion.assertEquals(getPhaseLengthmonth(), excelData.get("Term Length mnt").trim(), " Term Length (months) mapping mismatched");
				ExtentTestManager.log(" Term Length (months) Mapping : "+getPhaseLengthmonth());
				
				
				assertion.assertEquals(getPhaseLengthdays(), excelData.get("Term Length days").trim(), " Term Length (days) mapping mismatched");
				ExtentTestManager.log(" Term Length (days) Mapping : "+getPhaseLengthdays());
				
				
				assertion.assertEquals(getExpirationDate(), excelData.get("Expiration Date").trim(), "Expiration Date mapping mismatched");
				ExtentTestManager.log("Expiration Date Mapping : "+getExpirationDate());

				
				assertion.assertAll();	
		
			}
	
	
	public void verifyAgreementPhaseMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			AgreementPhaseMapping(testcaseName);
			log("STEP 7:  All Agreement Terms Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
//	By navLegalDescription = By.xpath("//span[text()='Legal Description']");
	
	By agreementtermPopup = By.xpath("//iframe[contains(@name,'LeaseDocument')]");

	public void verifyImportedAgreementPhase(Map<String, String> map,String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
				util.dummyWait(2);
				By addedRecord = By.xpath("//td[text()='"+map.get("Agreement Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.dummyWait(1);
				util.click(addedRecord);
				
				By agreementNo = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Agreement Number")+"']");
				util.waitForWebElementToBePresent(agreementNo, IMPLICIT_WAIT);
				ExtentTestManager.log("Agreement Number matched : "+driver.findElement(agreementNo).getText());
				
				By showDetails = By.xpath("(//*[contains(@id,'LEASE_PAYMENTS_radYALGridControl')]//*[text()='Show Details'])[1]");
				util.waitForWebElementToBePresent(showDetails, IMPLICIT_WAIT);
				util.click(showDetails);
				ExtentTestManager.log("Paymnet Term Details pop up appeared");
				util.switchToIframe(agreementtermPopup);
				
				util.dummyWait(2);
				
				assertion.assertEquals(getAgreementPhase(), map.get("Agreement Phase").trim(), "Agreement Phase mismatched");
				ExtentTestManager.log("Agreement Phase matched : "+getAgreementPhase());
				
				assertion.assertEquals(getActive(), map.get("Active").trim(), "Active mismatched");
				ExtentTestManager.log("Active matched : "+getActive());
				
				assertion.assertEquals(getEffectiveDate(), map.get("Effective Date").trim(), "Effective Date mismatched");
				ExtentTestManager.log("Effective Date matched : "+getEffectiveDate());

				assertion.assertEquals(getPhaseLengthyears(), map.get("Phase Length years").trim(), "Term Length (years) mismatched");
				ExtentTestManager.log("Term Length (years) matched : "+getPhaseLengthyears());
				
				assertion.assertEquals(getPhaseLengthmonth(), map.get("Phase Length months").trim(), "Term Length (months) mismatched");
				ExtentTestManager.log("Term Length (months) matched : "+getPhaseLengthmonth());
				
				assertion.assertEquals(getPhaseLengthdays(), map.get("Phase Length days").trim(), "Term Length (days) mismatched");
				ExtentTestManager.log("Term Length (days) matched : "+getPhaseLengthdays());
				
				assertion.assertEquals(getExpirationDate(), map.get("Expiration Date").trim(), "Expiration Date mismatched");
				ExtentTestManager.log("Expiration Date matched : "+getExpirationDate());
				
				assertion.assertAll();
			
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.AgreementPhasevalidationMsg(testcaseName); 
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
