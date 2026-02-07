package pages.projectImportDOT;

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


public class KeyDatesImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public KeyDatesImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}
	
	By parcelNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel #: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TRACT_NUMBER') and @type='text'])[1]");
	public String getParcelNumber() {		
		return util.getAttributeValue(parcelNumber, "value");
	}
	
	By dateName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Date Name: ']/..//input[contains(@id,'Dest_Input')] ");
	public String getDateName() {
		return util.getAttributeValue(dateName, "value");
	}
	By expectedDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Expected Date: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Expected_Date_dateInput') and @type='text']");
	public String getExpectedDate() {
		return util.getAttributeValue(expectedDate, "value");
	}
	By actualDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Actual Date: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Actual_Date_dateInput') and @type='text']");
	public String getActualDate() {
		return util.getAttributeValue(actualDate, "value");
	}
	By comment = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Comment: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'EditFormControl_tb_Comment')]");
	public String getComment() {
		return util.getAttributeValue(comment, "value");
	}
	
	

	Map<String, String> excelData;
	public void KeyDatesImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.KeyDatesMapping, testcaseName);
				assertion.assertEquals(getParcelNumber(), excelData.get("Parcel #").trim(), "Parcel # mapping mismatched");
				ExtentTestManager.log("Parcel # Mapping : " +getParcelNumber());
				
				assertion.assertEquals(getDateName(), excelData.get("Date Name").trim(), "Date Name mapping mismatched");
				ExtentTestManager.log("Date Name Mapping : " +getDateName());
				
				assertion.assertEquals(getExpectedDate(), excelData.get("Expected Date").trim(), "Expected Date mapping mismatched");
				ExtentTestManager.log("Expected Date Mapping : "+getExpectedDate());
				
				assertion.assertEquals(getActualDate(), excelData.get("Actual Date").trim(), "Actual Date mapping mismatched");
				ExtentTestManager.log("Display Order Mapping : "+getActualDate());
				
				assertion.assertEquals(getComment(), excelData.get("Comment").trim(), "Comment mapping mismatched");
				ExtentTestManager.log("Comment Mapping : "+getComment());
				
				
				
				assertion.assertAll();

			}
	
	
	public void verifyKeyDatesImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			KeyDatesImportMapping(testcaseName);
			log("STEP 7:  All Land  Data Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
		
		By navKeyDates = By.xpath("//span[text()='Parcel Milestones']");
		
		public void verifyImportedKeyDatesData(Map<String, String> map, String testcaseName) {

			SoftAssert assertion = new SoftAssert();
//			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.KeyDatesImport,testcaseName);
			util.dummyWait(2);
			
				
					 	By addedRecord = By.xpath("//td[text()='"+map.get("Parcel #") +"']/parent::tr");
						Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
						util.click(addedRecord);
						By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Parcel #").trim()+"']");

						assertion.assertTrue(util.isElementVisible(parcelSummary, 30), "Parcel # not visible  on Parcel summery");
						assertion.assertEquals(getParcelNumber(), map.get("Parcel #").trim(), "Parcel number mismatched");
						ExtentTestManager.log("Parcel number : " +getParcelNumber());
						
						util.dummyWait(2);
						util.waitUntilElementDisplay(navKeyDates);
						util.click(navKeyDates);
												
						By keydateadded = By.xpath("//td[text()='"+map.get("Date Name") +"']/..//following-sibling::td//input[@title='Edit']");
						Assert.assertTrue(util.isElementPresent(keydateadded, 30), "Record is not added yet");
						util.click(keydateadded);
//						util.dummyWait(2);
												
//						assertion.assertEquals(getDateName(), map.get("Date Name").trim(), "Date Name mismatched");
//						ExtentTestManager.log("Date Name : "+getDateName());
						
					if(util.isElementVisible(expectedDate)) {
						assertion.assertEquals(getExpectedDate(), map.get("Expected Date").trim(), "Expected Date mismatched");
						ExtentTestManager.log("Expected Date : "+getExpectedDate());
					}
					
						assertion.assertEquals(getActualDate(), map.get("Actual Date").trim(), "Actual Date mismatched");
						ExtentTestManager.log("Actual Date : "+getActualDate());
						
						assertion.assertEquals(getComment(), map.get("Comment").trim(), "Comment mismatched");
						ExtentTestManager.log("Comment : "+getComment());
						util.dummyWait(2);
						
						assertion.assertAll();
						
				}
			
		By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
		By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
		public void errorLogValidation(String testcaseName) throws Exception {

			try {
				//objErrorLog.KeyDatesvalidationMsg(testcaseName); 
				objErrorLog.printErrorLog();
		        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
			} catch (Exception t) {
				  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
				  throw new RuntimeException("Failed in step 12");
			}
			
//			try {
//				  util.click(downlodPDF); 
//		        log("STEP 13:  User can click on PDF Icon", Status.PASS);
//			} catch (Exception t) {
//				  log("STEP 13:  User cannot click on PDF Icon", Status.FAIL);
//				  throw new RuntimeException("Failed in step 13");
//			}
			
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
			

	

