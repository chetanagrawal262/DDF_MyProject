package pages.projectImportALT;

import java.io.File;
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

public class DocumentImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public DocumentImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By recordType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Record Type: ']/..//input[contains(@id,'Dest_Input')]");
	public String getRecordType() {
		
		return util.getAttributeValue(recordType, "value");
	}
	
	By recordNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Record Number: ']/..//input[contains(@id,'Dest_Input')] | //span[contains(@id,'_Lease_Number_wrapper')]/input[contains(@id,'_Lease_Number') and @type='text'] | //input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getRecordNumber() {
		return util.getAttributeValue(recordNumber, "value");
	}
	
	By documentName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Document Name: ']/..//input[contains(@id,'Dest_Input')]");
	public String getDocumentName() {
		return util.getAttributeValue(documentName, "value");
	}
	
	By documentCategory = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Document Category: ']/..//input[contains(@id,'Dest_Input')]");
	public String getDocumentCategory() {
		return util.getAttributeValue(documentCategory, "value");
	}
	
	By documentDescription = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Document Description: ']/..//input[contains(@id,'Dest_Input')]");
	public String getDocumentDescription() {
		return util.getAttributeValue(documentDescription, "value");
	}
	
	By documentLink = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Document Link: ']/..//input[contains(@id,'Dest_Input')]");
	public String getDocumentLink() {
		return util.getAttributeValue(documentLink, "value");
	}
	
	Map<String, String> excelData;
	public void DocumentMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.DocumentImportMapping, testcaseName);
				assertion.assertEquals(getRecordType(), excelData.get("Record Type").trim(), "Record Type mapping mismatched");
				ExtentTestManager.log("Record Type Mapping : " +getRecordType());
				
				assertion.assertEquals(getRecordNumber(), excelData.get("Record Number").trim(), "Record Number mapping mismatched");
				ExtentTestManager.log("Record Number Mapping : "+getRecordNumber());
				
				assertion.assertEquals(getDocumentName(), excelData.get("Document Name").trim(), "Document Name mapping mismatched");
				ExtentTestManager.log("Document Name Mapping : "+getDocumentName());
				
				assertion.assertEquals(getDocumentCategory(), excelData.get("Document Category").trim(), "Document Category mapping mismatched");
				ExtentTestManager.log("Document Category Mapping : "+getDocumentCategory());
				
				assertion.assertEquals(getDocumentDescription(), excelData.get("Document Description").trim(), "Document Description mapping mismatched");
				ExtentTestManager.log("Document Description Mapping : "+getDocumentDescription());
				
				assertion.assertEquals(getDocumentLink(), excelData.get("Document Link").trim(), "Document Link mapping mismatched");
				ExtentTestManager.log("Document Link Mapping : "+getDocumentLink());
				
				assertion.assertAll();		
			
			}
	
	public void verifyDocumentImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			DocumentMapping(testcaseName);
			log("STEP 7:  All Agreement Contacts Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navDocumentTab = By.xpath("//div[contains(@id,'RadTabStrip1')]/.//span[contains(text(),'Documents')]");
	By editContact = By.xpath("//input[contains(@id,'EditButton')]");
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		if(map.get("Record Type").trim().contains("Agreement")) {
			objProjectImportPage.projectSelectionAgreementConnectGen(map, testcaseName);
			ExtentTestManager.log("Verify Imported Document Links for the Agreement # "+map.get("Record Number").trim());
		}else {
			objProjectImportPage.projectSelectionParcel(map, testcaseName);
			ExtentTestManager.log("Verify Imported Document Links for the Parcel # "+map.get("Record Number").trim());
		}
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Record Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				util.dummyWait(1);
				
				assertion.assertEquals(getRecordNumber(), map.get("Record Number").trim(), "Record Number mismatched");
				ExtentTestManager.log("Record Number : "+getRecordNumber());
				
				util.waitUntilElementDisplay(navDocumentTab);
				util.click(navDocumentTab);
				log("User can navigate to Documents Tab");
				util.dummyWait(1);
				By documentName=By.xpath("//*[contains(@id,'DocumentsUC_radYALGridControl')]//*[text()='"+map.get("Document Name").trim()+"']");
				assertion.assertTrue(util.isElementVisible(documentName));
				ExtentTestManager.log("Document Name : "+driver.findElement(documentName).getText());
			
				By docCategory=By.xpath("//*[contains(@id,'DocumentsUC_radYALGridControl')]//*[text()='"+map.get("Document Category").trim()+"']");
				assertion.assertTrue(util.isElementVisible(docCategory));
				ExtentTestManager.log("Document Category : "+driver.findElement(docCategory).getText());
				
				By docDesc=By.xpath("//*[contains(@id,'DocumentsUC_radYALGridControl')]//*[text()='"+map.get("Document Description").trim()+"']");
				assertion.assertTrue(util.isElementVisible(docDesc));
				ExtentTestManager.log("Document Description : "+driver.findElement(docDesc).getText());
				
				By viewDocument=By.xpath("(//*[contains(@id,'DocumentsUC_radYALGridControl')]//*[text()='"+map.get("Document Name").trim()+"']/..//a)[1]");
				
				util.click(viewDocument);	
				util.dummyWait(1);
				util.switchToChildWindow();
				ExtentTestManager.log("Document Link : "+driver.getCurrentUrl());
				
				driver.close();
				util.switchToParentWindow();
				assertion.assertAll();
				
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			objErrorLog.printErrorLog();
			//objErrorLog.DocumentImportvalidationMsg(testcaseName); 
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

	By fileUpload = By.xpath("//*[@id=\"ctl00_ConPHRightTop_idYalImport_hdnZipDropArea\"]");
	public void uploadZipFile(String testcasename) {
			String filepath = System.getProperty("user.dir") + File.separator
					+ "Test-Logo.zip";
			driver.findElement(fileUpload).sendKeys(filepath);
			util.dummyWait(2);
		}
		
	

}
