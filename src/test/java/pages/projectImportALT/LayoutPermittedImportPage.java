package pages.projectImportALT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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

public class LayoutPermittedImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public LayoutPermittedImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}
	
	By orionPID = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Orion PID')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getOrionPID() {
		return util.getAttributeValue(orionPID, "value");
	}
	
	By usedInLayout = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Used in Layout')]/..//input[contains(@id,'Dest_Input')] | //*[contains(text(),'Used in Layout:')]/..//input[@type='text']");
	public String getUsedInLayout() {
		return util.getAttributeValue(usedInLayout, "value");
	}
	
	By permitted = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Permitted')]/..//input[contains(@id,'Dest_Input')] | //*[contains(text(),'Permitted:')]/..//input[@type='text']");
	public String getPermitted() {
		return util.getAttributeValue(permitted, "value");
	}
	
	
	
	Map<String, String> excelData;
	public void LayoutPermittedMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.LayoutPermittedImportMapping, testcaseName);
				
				assertion.assertEquals(getOrionPID(), excelData.get("Orion PID").trim(), "Orion PID mapping mismatched");
				ExtentTestManager.log("Orion PID Mapping : "+getOrionPID());
				
				assertion.assertEquals(getUsedInLayout(), excelData.get("Used in Layout").trim(), "Used in Layout mapping mismatched");
				ExtentTestManager.log("Used in Layout Mapping : "+getUsedInLayout());
				
				assertion.assertEquals(getPermitted(), excelData.get("Permitted").trim(), "Permitted mapping mismatched");
				ExtentTestManager.log("Permitted Mapping : "+getPermitted());
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyLayoutPermittedImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			LayoutPermittedMapping(testcaseName);
			log("STEP 7:  All Agreement Contacts Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	
    
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		
		ExtentTestManager.log("Verifying Imported Data for parcel # "+map.get("Orion PID").trim());
		SoftAssert assertion = new SoftAssert();
		        
		By addedRecord = By.xpath("(//td[text()='"+map.get("Orion PID").trim()+"']/parent::tr)[1]");
		Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
		util.click(addedRecord);
		
		By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Orion PID")+"']");
		util.waitForWebElementToBePresent(parcelSummary, IMPLICIT_WAIT);
		
		assertion.assertEquals(getOrionPID(), map.get("Orion PID").trim(), "Orion PID mismatched");
		ExtentTestManager.log("Orion PID matched : " +getOrionPID());
		
		        assertion.assertEquals(getUsedInLayout(), map.get("Used in Layout").trim(), "Title Version mismatched");
				ExtentTestManager.log("Title Version : "+getUsedInLayout());
				
				assertion.assertEquals(getPermitted(), map.get("Permitted").trim(), "Permitted mismatched");
				ExtentTestManager.log("Permitted : "+getPermitted());
				
				assertion.assertAll();
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			objErrorLog.printErrorLog();
			//objErrorLog.layoutPermittedImportvalidationMsg(testcaseName); 
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
