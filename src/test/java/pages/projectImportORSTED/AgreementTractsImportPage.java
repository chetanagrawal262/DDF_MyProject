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

public class AgreementTractsImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public AgreementTractsImportPage(WebDriver driver) {
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
	
	By orstedPIN = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Orsted PIN: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getOrstedPIN() {
		return util.getAttributeValue(orstedPIN, "value");
	}
	
	Map<String, String> excelData;
	public void agreementTractsMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementParcelsMapping, testcaseName);
				assertion.assertEquals(getAgreementNumber(), excelData.get("Agreement Number").trim(), "Agreement Number mapping mismatched");
				ExtentTestManager.log("Agreement Number Mapping : " +getAgreementNumber());
				
				assertion.assertEquals(getOrstedPIN(), excelData.get("Parcel #").trim(), "Orsted PIN mapping mismatched");
				ExtentTestManager.log("Orsted PIN Mapping : " +getOrstedPIN());
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyAgreementTractsMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			agreementTractsMapping(testcaseName);			
			log("STEP 7:  All Agreement Parcel Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	
	By navLO_pracelPnl	= By.xpath("//span[text()='Landowners and Parcel Information']");
	By napracelTab	= By.xpath("(//span[text()='Parcel Information'])[2]");
	
	public void verifyImportedAgreementTracts(Map<String, String> map,String testcaseName) {	
		
		SoftAssert assertion = new SoftAssert();
		
				By addedRecord = By.xpath("//td[text()='"+map.get("Agreement Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				assertion.assertEquals(getAgreementNumber(), map.get("Agreement Number").trim(), "Agreement Number mismatched");
				ExtentTestManager.log("Agreement Number : "+getAgreementNumber());
				
				util.dummyWait(2);
				util.waitUntilElementDisplay(navLO_pracelPnl);
//				util.click(navLO_pracelPnl);
				
				util.waitUntilElementDisplay(napracelTab);
				util.click(napracelTab);
				util.dummyWait(2);
				
				
				By orstedPINAsso = By.xpath("//td[text()='"+map.get("Orsted PIN") +"']/..//following-sibling::td//input[@title='Delete']");
				Assert.assertTrue(util.isElementPresent(orstedPINAsso, 30), "Record is not added yet");
				ExtentTestManager.log("Orsted PIN : "+orstedPINAsso);
//				util.click(orstedPINAsso);
						
//				By addedRecord1 = By.xpath("//td[text()='"+map.get("Orsted PIN").trim()+"']/parent::tr");
//				Assert.assertTrue(util.isElementPresent(addedRecord1, 30), "Record is not added yet");
//				util.click(addedRecord1);
//				
//				assertion.assertEquals(getOrstedPIN(), map.get("Orsted PIN").trim(), "Orsted PIN mismatched");
//				ExtentTestManager.log("Orsted PIN : "+getOrstedPIN());

				
				
				
				assertion.assertAll();
				
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.AgreementTractsvalidationMsg(testcaseName); 
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
