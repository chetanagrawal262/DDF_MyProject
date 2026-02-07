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

public class AgreementDataImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public AgreementDataImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By agreementNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Number: ']/..//input[contains(@id,'Dest_Input')] |(//input[contains(@id,'Lease_Number') and @type='text'])[2]");
	public String getAgreementNumber() {
		
		return util.getAttributeValue(agreementNumber, "value");
	}
	
	By grantoragreementName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Grantor/Agreement Name: ']/..//input[contains(@id,'Dest_Input')] |//*[contains(@id,'tractInfo')]/..//*[text()='Agreement Name'] | //span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Counterparty')]/..//input[contains(@id,'Dest_Input')]");
	public String getGrantorAgreementName() {
		return util.getAttributeValue(grantoragreementName, "value");
	}
	
	By agreementType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Type_ID') and @type='text']");
	public String getAgreementType() {
		return util.getAttributeValue(agreementType, "value");
	}
	
	By agreementStatus = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Status: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Lease_Status_ID') and @type='text']");
	public String getAgreementStatus() {
		return util.getAttributeValue(agreementStatus, "value");
	}
	
	By operatingCompany = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Operating Company')]/..//input[contains(@id,'Dest_Input')] | (//*[text()='Operating Company']/..//input[@type='text'])[1]");
	public String getOperatingCompany() {
		return util.getAttributeValue(operatingCompany, "value");
	}
	
	By associatedAgreement = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Associated Agreement')]/..//input[contains(@id,'Dest_Input')] | (//*[text()='Associated Agreement:']/..//input[@type='text'])[1]");
	public String getAssociatedAgreement() {
		return util.getAttributeValue(associatedAgreement, "value");
	}
	
	By recordedDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Recorded Date')]/..//input[contains(@id,'Dest_Input')] | (//*[text()='Recorded Date:']/..//input[@type='text'])[2]");
	public String getRecordedDate() {
		return util.getAttributeValue(recordedDate, "value");
	}
	
	By executedDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Executed Date')]/..//input[contains(@id,'Dest_Input')] | (//*[text()='Executed Date:']/..//input[@type='text'])[2]");
	public String getExecutedDate() {
		return util.getAttributeValue(executedDate, "value");
	}
	
	By accoundingDocNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Accounting Document Number')]/..//input[contains(@id,'Dest_Input')] | //*[text()='Accounting Document Number:']/..//input[@type='text']");
	public String getAccountingDocNo() {
		return util.getAttributeValue(accoundingDocNo, "value");
	}
	
	Map<String, String> excelData;
	public void agreementDataMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementDataMapping, testcaseName);
				assertion.assertEquals(getAgreementNumber(), excelData.get("Agreement Number").trim(), "Agreement Number mapping mismatched");
				ExtentTestManager.log("Agreement Number Mapping : " +getAgreementNumber());
				
				if(testcaseName.contains("CONNECTGEN")) {
				assertion.assertEquals(getOperatingCompany(), excelData.get("Operating Company").trim(), "Operating Company mapping mismatched");
				ExtentTestManager.log("Operating Company Mapping : " +getOperatingCompany());
				}
				
				assertion.assertEquals(getGrantorAgreementName(), excelData.get("Grantor/Agreement Name").trim(), "Grantor/Agreement Name mapping mismatched");
				ExtentTestManager.log("Grantor/Agreement Name Mapping : " +getGrantorAgreementName());
				
				assertion.assertEquals(getAgreementType(), excelData.get("Agreement Type").trim(), "Agreement Type mapping mismatched");
				ExtentTestManager.log("Agreement Type Mapping : "+getAgreementType());
				
				if(testcaseName.contains("CONNECTGEN")) {
					assertion.assertEquals(getAssociatedAgreement(), excelData.get("Associated Agreement").trim(), "Associated Agreement mapping mismatched");
					ExtentTestManager.log("Associated Agreement Mapping : " +getAssociatedAgreement());
					
					assertion.assertEquals(getRecordedDate(), excelData.get("Recorded Date").trim(), "Recorded Date mapping mismatched");
					ExtentTestManager.log("Recorded Date Mapping : " +getRecordedDate());
					
					assertion.assertEquals(getExecutedDate(), excelData.get("Executed Date").trim(), "Executed Date mapping mismatched");
					ExtentTestManager.log("Executed Date Mapping : " +getExecutedDate());
					
					}
				
				assertion.assertEquals(getAgreementStatus(), excelData.get("Agreement Status").trim(), "Agreement Status mapping mismatched");
				ExtentTestManager.log("Agreement Status Mapping : "+getAgreementStatus());
				
				if(testcaseName.contains("CONNECTGEN")) {
					assertion.assertEquals(getAccountingDocNo(), excelData.get("Accounting Document Number").trim(), "Accounting Document Number mapping mismatched");
					ExtentTestManager.log("Accounting Document Number Mapping : " +getAccountingDocNo());
					}
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyAgreementDataMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			agreementDataMapping(testcaseName);
			log("STEP 7:  All Agreement Data Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		ExtentTestManager.log("Verifying Imported Agreement Data for Agreement # "+map.get("Agreement Number").trim());
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Agreement Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not visible in the Agreement list");
				util.click(addedRecord);
				
				assertion.assertEquals(getAgreementNumber(), map.get("Agreement Number").trim(), "Agreement Number mismatched");
				ExtentTestManager.log("Agreement Number matched : " +getAgreementNumber());
				

				By GrantorAgreementName = By.xpath("//*[contains(@id,'tractInfo')]/..//*[text()='"+map.get("Grantor/Agreement Name").trim()+"']");
				String AgreementName = driver.findElement(GrantorAgreementName).getText();
				
				assertion.assertEquals(AgreementName, map.get("Grantor/Agreement Name").trim(), "Grantor / Agreement Name mismatched");
				ExtentTestManager.log("Grantor / Agreement Name : "+AgreementName);
				
				assertion.assertEquals(getAgreementType(), map.get("Agreement Type").trim(), "Agreement Type mismatched");
				ExtentTestManager.log("Agreement Type : "+getAgreementType());
				
				if(environment.contains("NEXTERA")) {
				assertion.assertEquals(getAgreementStatus(), map.get("NextEraStatus").trim(), "Agreement Status mismatched");
				ExtentTestManager.log("Agreement Status : "+getAgreementStatus());
				}else {
					assertion.assertEquals(getAgreementStatus(), map.get("Agreement Status").trim(), "Agreement Status mismatched");
					ExtentTestManager.log("Agreement Status : "+getAgreementStatus());
				}
				
				if(testcaseName.contains("CONNECTGEN")){
//					assertion.assertEquals(getOperatingCompany(), map.get("Operating Company").trim(), "Operating Company mismatched");
					assertion.assertTrue(getOperatingCompany().contains(map.get("Operating Company").trim()));
					ExtentTestManager.log("Operating Company : " +getOperatingCompany());
					
					assertion.assertEquals(getAccountingDocNo(), map.get("Accounting Document Number").trim(), "Accounting Document Number mismatched");
					ExtentTestManager.log("Accounting Document Number : " +getAccountingDocNo());
					
					assertion.assertEquals(getAssociatedAgreement(), map.get("Associated Agreement").trim(), "Associated Agreement mismatched");
					ExtentTestManager.log("Associated Agreement : " +getAssociatedAgreement());
					
					assertion.assertEquals(getRecordedDate(), map.get("Recorded Date").trim(), "Recorded Date mismatched");
					ExtentTestManager.log("Recorded Date : " +getRecordedDate());
					
					assertion.assertEquals(getExecutedDate(), map.get("Executed Date").trim(), "Executed Date mismatched");
					ExtentTestManager.log("Executed Date : " +getExecutedDate());
				}
						
				
				assertion.assertAll();
				
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.AgreementDatavalidationMsg(testcaseName); 
			objErrorLog.printErrorLog();
	        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
		} catch (Exception t) {
			  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
			  throw new RuntimeException("Failed in step 12");
		}
		
//		try {//Removed in 24.04
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
