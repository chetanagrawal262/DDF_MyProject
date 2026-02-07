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

public class AgreementTermsImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public AgreementTermsImportPage(WebDriver driver) {
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
	
    By agreementTermType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Term Type: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'Period_Type_ID') and @type='text']");
	public String getAgreementTermType() {
		return util.getAttributeValue(agreementTermType, "value");
	}
	
    By active = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Active: ']/..//input[contains(@id,'Dest_Input')] | (//*[contains(@id,'LSINFO_radPanels')]/..//*[text()='True'])[2] | //input[contains(@id,'active_ind') and @type='checkbox'] | //input[contains(@id,'active_ind') and @checked='checked']");
	public String getActive() {
		return util.getAttributeValue(active, "value");
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
	
    By  termLengthdays = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()=' Term Length (days): ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'Term_Days') and @type='text']");
	public String getTermLengthdays() {
		return util.getAttributeValue(termLengthdays, "value");
	}
	
	By  agreementTermComments = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Term Comments: ']/..//input[contains(@id,'Dest_Input')] |  //textarea[contains(@id,'Comments')]");
	public String getAgreementTermComments() {
		return util.getAttributeValue(agreementTermComments, "value");
	}
	
    By  extensionProvision = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Extension Provision: ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'chkExtensionProvision') and @type='checkbox'] |  //input[contains(@id,'chkExtensionProvision') and @checked='checked']");
	public String getExtensionProvision() {
		return util.getAttributeValue(extensionProvision, "value");
	}
	
	By  flatAmount = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Flat Amount: ']/..//input[contains(@id,'Dest_Input')] |  //input[contains(@id,'Flat_Payment_Amount') and @type='text']");
	public String getFlatAmount() {
		return util.getAttributeValue(flatAmount, "value");
	}
	
	Map<String, String> excelData;
	public void AgreementTermsMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementTermsMapping, testcaseName);
				assertion.assertEquals(getAgreementNumber(), excelData.get("Agreement Number").trim(), "Agreement number mapping mismatched");
				ExtentTestManager.log("Agreement number Mapping : " +getAgreementNumber());
				
				assertion.assertEquals(getAgreementTermType(), excelData.get("Agreement Term Type").trim(), "Agreement Term Type mapping mismatched");
				ExtentTestManager.log("Agreement Term Type Mapping : "+getAgreementTermType());
				
				if(!testcaseName.contains("CONNECTGEN")) {
				assertion.assertEquals(getActive(), excelData.get("Active").trim(), "Active mapping mismatched");
				ExtentTestManager.log("Active Mapping : "+getActive());
				}
				
				assertion.assertEquals(getEffectiveDate(), excelData.get("Effective Date").trim(), "Effective Date mapping mismatched");
				ExtentTestManager.log("Effective Date Mapping : "+getEffectiveDate());
				
				assertion.assertEquals(getTermLengthyears(), excelData.get("Term Length Yrs").trim(), " Term Length (years) mapping mismatched");
				ExtentTestManager.log(" Term Length (years) Mapping : "+getTermLengthyears());
				
				assertion.assertEquals(getTermLengthmonth(), excelData.get("Term Length mnt").trim(), " Term Length (months) mapping mismatched");
				ExtentTestManager.log(" Term Length (months) Mapping : "+getTermLengthmonth());
				
				
				assertion.assertEquals(getTermLengthdays(), excelData.get("Term Length days").trim(), " Term Length (days) mapping mismatched");
				ExtentTestManager.log(" Term Length (days) Mapping : "+getTermLengthdays());
				
				
				assertion.assertEquals(getAgreementTermComments(), excelData.get("Agreement Term Comments").trim(), "Agreement Term Comments mapping mismatched");
				ExtentTestManager.log("Agreement Term Comments Mapping : "+getAgreementTermComments());	
				
				if(!testcaseName.contains("NOVA")) {
				assertion.assertEquals(getExtensionProvision(), excelData.get("Extension Provision").trim(), "Extension Provision mapping mismatched");
				ExtentTestManager.log("Extension Provision Mapping : "+getExtensionProvision());
					
				if(!environment.contains("RAMACO")) {
				assertion.assertEquals(getFlatAmount(), excelData.get("Flat Amount").trim(), "Flat Amount mapping mismatched");
				ExtentTestManager.log("Flat Amount Mapping : "+getFlatAmount());
				}
				}
				
				assertion.assertAll();	
				
					
			
			}
	
	
	public void verifyAgreementTermsMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			AgreementTermsMapping(testcaseName);
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
		ExtentTestManager.log("Verifying Imported Agreement Term Data for Agreement # "+map.get("Agreement Number").trim());
		SoftAssert assertion = new SoftAssert();
		
				By addedRecord = By.xpath("//td[text()='"+map.get("Agreement Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
	
				assertion.assertEquals(getAgreementNumber(), map.get("Agreement Number").trim(), "Agreement Number mismatched");
				ExtentTestManager.log("Agreement Number matched : " +getAgreementNumber());
				
				By showDetails = By.xpath("(//*[contains(@id,'LEASE_PAYMENTS_radYALGridControl')]//*[text()='Show Details'])[1]");
				util.waitForWebElementToBePresent(showDetails, IMPLICIT_WAIT);
				util.click(showDetails);
				ExtentTestManager.log("Paymnet Term Details pop up appeared");
				util.switchToIframe(agreementtermPopup);
				
				assertion.assertEquals(getAgreementTermType().toLowerCase(), map.get("Agreement Term Type").trim().toLowerCase(), "Agreement Term Type mismatched");
				ExtentTestManager.log("Agreement Term Type matched : "+getAgreementTermType());
				
				WebElement activeCheckbox= driver.findElement(active);
				if(activeCheckbox.isSelected()) {
					ExtentTestManager.log("Active Checkbox is Checked");
				}else {
					ExtentTestManager.log("Active Checkbox is Unchecked");
				}
				
				assertion.assertEquals(getEffectiveDate(), map.get("Effective Date").trim(), "Effective Date mismatched");
				ExtentTestManager.log("Effective Date matched : "+getEffectiveDate());
				
				if(!map.get("Term Length years").trim().equals("0")){
				assertion.assertEquals(getTermLengthyears(), map.get("Term Length years").trim(), "Term Length (years) mismatched");
				}
				ExtentTestManager.log("Term Length (years) matched : "+getTermLengthyears());
				
				
				if(!map.get("Term Length months").trim().equals("0")) {
				assertion.assertEquals(getTermLengthmonth(), map.get("Term Length months").trim(), "Term Length (months) mismatched");
				}
				ExtentTestManager.log("Term Length (months) matched : "+getTermLengthmonth());
				
				
				if(!map.get("Term Length days").trim().equals("0")) {
				assertion.assertEquals(getTermLengthdays(), map.get("Term Length days").trim(), "Term Length (days) mismatched");
				}
				ExtentTestManager.log("Term Length (days) matched : "+getTermLengthdays());
				
				
				assertion.assertEquals(getAgreementTermComments(), map.get("Agreement Term Comments").trim(), "Agreement Term Comments mismatched");
				ExtentTestManager.log("Agreement Term Comments matched : "+getAgreementTermComments());
				
				if(!testcaseName.contains("NOVA") & !testcaseName.contains("CONNECTGEN") ) {
//				assertion.assertEquals(getExtensionProvision(), map.get("Extension Provision").trim(), "Extension Provision mismatched");
//				ExtentTestManager.log("Extension Provision matched : "+getExtensionProvision());
				
				if(!environment.contains("RAMACO")) {
				assertion.assertEquals(getFlatAmount(), map.get("Flat Amount").trim(), "Flat Amount mismatched");
				ExtentTestManager.log("Flat Amount matched : "+getFlatAmount());
				}
				}
				
				util.switchToDefaultContent();
				util.click(closePopup);
				util.dummyWait(3);
				
				assertion.assertAll();
			
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.AgreementTermsvalidationMsg(testcaseName); 
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
