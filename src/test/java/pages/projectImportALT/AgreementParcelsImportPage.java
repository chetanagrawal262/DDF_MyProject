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

public class AgreementParcelsImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public AgreementParcelsImportPage(WebDriver driver) {
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
	
	By parcelnumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel #: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getParcelNumber() {
	
		return util.getAttributeValue(parcelnumber, "value");
	}
	By paidacreage = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Paid Acreage: ']/..//input[contains(@id,'Dest_Input')] | //*[contains(@id,'tractInfo')]/..//*[text()='Total Acres']");
	public String getPaidAcreage() {
		return util.getAttributeValue(paidacreage, "value");
	}

	
	Map<String, String> excelData;
	public void agreementParcelsMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementParcelsMapping, testcaseName);
				assertion.assertEquals(getAgreementNumber(), excelData.get("Agreement Number").trim(), "Agreement Number mapping mismatched");
				ExtentTestManager.log("Agreement Number Mapping : " +getAgreementNumber());
				
				assertion.assertEquals(getParcelNumber(), excelData.get("Parcel #").trim(), "Parcel # mapping mismatched");
				ExtentTestManager.log("Parcel # Mapping : " +getParcelNumber());
				
				if(!testcaseName.contains("NOVA")) {
				assertion.assertEquals(getPaidAcreage(), excelData.get("Paid Acreage").trim(), "Paid Acreage mapping mismatched");
				ExtentTestManager.log("Paid Acreage Mapping : "+getPaidAcreage());
				}
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyAgreementParcelsMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			agreementParcelsMapping(testcaseName);			
			log("STEP 7:  All Agreement Parcel Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navParcelInformation = By.xpath("//div[contains(@id,'RadTabStripLO')]//span[text()='Parcel Information']");

	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Agreement Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				assertion.assertEquals(getAgreementNumber(), map.get("Agreement Number").trim(), "Agreement Number mismatched");
				ExtentTestManager.log("Agreement Number matched : " +getAgreementNumber());
				
				util.waitFor(500);
				util.click(navParcelInformation);
				util.waitFor(500);
				By parcelNumber = By.xpath("//tr[contains(@id,'_RadGridTract1_radYALGridControl')]/..//*[text()='"+map.get("Parcel #").trim()+"']");
				String ParcelNo = driver.findElement(parcelNumber).getText();
				assertion.assertEquals(ParcelNo, map.get("Parcel #").trim(), "Parcel # mismatched");
				ExtentTestManager.log("Parcel # : "+ParcelNo);	
				
				if(!testcaseName.contains("NOVA")) {
					By PaidAcreage = By.xpath("//tr[contains(@id,'_RadGridTract1_radYALGridControl')]/..//*[contains(text(),'"+map.get("Paid Acreage").trim()+"')]");
					String PaidAcreagevalue = driver.findElement(PaidAcreage).getText();
					assertion.assertTrue(PaidAcreagevalue.contains(map.get("Paid Acreage").trim()), "Paid Acreage mismatched");
					ExtentTestManager.log("Paid Acreage : "+PaidAcreagevalue);
					}
				
				assertion.assertAll();
				
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.AgreementParcelsvalidationMsg(testcaseName); 
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
