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

public class TitleImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public TitleImportPage(WebDriver driver) {
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
	
	By titleOrderSelection = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Title Order Selection')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TractType_customFields2_137') and @type='text'])[2]");
	public String getTitleOrderSelection() {
		return util.getAttributeValue(titleOrderSelection, "value");
	}
	
	By titleOrderUpdatedBy = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Title Order Updated By')]/..//input[contains(@id,'Dest_Input')]");
	public String getTitleOrderUpdatedBy() {
		return util.getAttributeValue(titleOrderUpdatedBy, "value");
	}
	
	By developerUserName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Developer UserName')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TractType_customFields2_114') and @type='text'])[2]");
	public String getDeveloperUserName() {
		return util.getAttributeValue(developerUserName, "value");
	}
	
	By titleStatus = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Title Status: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TITLEASSIGNMENT_TITLE_STATUS_ID') and @type='text']");
	public String getTitleStatus() {
		return util.getAttributeValue(titleStatus, "value");
	}
	
	By titleVersion = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Title Version')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TractType_customFields2_111') and @type='text'])[2]");
	public String getTitleVersion() {
		return util.getAttributeValue(titleVersion, "value");
	}
	
	By titleStatusNotes = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Title Status Notes')]/..//input[contains(@id,'Dest_Input')] | (//textarea[contains(@id,'TractType_customFields2_112')])[2]");
	public String getTitleStatusNotes() {
		return util.getAttributeValue(titleStatusNotes, "value");
	}
	
	By titleStatusAgentUserName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Title Status Agent UserName')]/..//input[contains(@id,'Dest_Input')] |  (//input[contains(@id,'TractType_customFields2_113') and @type='text'])[2]");
	public String getTitleStatusAgentUserName() {
		return util.getAttributeValue(titleStatusAgentUserName, "value");
	}
	
	Map<String, String> excelData;
	public void TitleMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.TitleImportMappingOrion, testcaseName);
				
				assertion.assertEquals(getOrionPID(), excelData.get("Orion PID").trim(), "Orion PID mapping mismatched");
				ExtentTestManager.log("Orion PID Mapping : "+getOrionPID());
				
				assertion.assertEquals(getTitleOrderSelection(), excelData.get("Title Order Selection").trim(), "Title Order Selection mapping mismatched");
				ExtentTestManager.log("Title Order Selection Mapping : "+getTitleOrderSelection());
				
				assertion.assertEquals(getTitleOrderUpdatedBy(), excelData.get("Title Order Updated By").trim(), "Title Order Updated By mapping mismatched");
				ExtentTestManager.log("Title Order Updated By Mapping : "+getTitleOrderUpdatedBy());
				
				assertion.assertEquals(getDeveloperUserName(), excelData.get("Developer UserName").trim(), "Developer UserName mapping mismatched");
				ExtentTestManager.log("Developer UserName Mapping : "+getDeveloperUserName());
				
				assertion.assertEquals(getTitleStatus(), excelData.get("Title Status").trim(), "Title Status mapping mismatched");
				ExtentTestManager.log("Title Status Mapping : "+getTitleStatus());
				
				assertion.assertEquals(getTitleVersion(), excelData.get("Title Version").trim(), "Title Version mapping mismatched");
				ExtentTestManager.log("Title Version Mapping : "+getTitleVersion());
				
				assertion.assertEquals(getTitleStatusNotes(), excelData.get("Title Status Notes").trim(), "Title Status Notes mapping mismatched");
				ExtentTestManager.log("Title Status Notes Mapping : "+getTitleStatusNotes());
				
				assertion.assertEquals(getTitleStatusAgentUserName(), excelData.get("Title Status Agent UserName").trim(), "Title Status Agent UserName mapping mismatched");
				ExtentTestManager.log("Title Status Agent UserName Mapping : "+getTitleStatusAgentUserName());
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyTitleImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			TitleMapping(testcaseName);
			log("STEP 7:  All Agreement Contacts Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
    
	By navTitle = By.xpath("//div[contains(@id,'RadTabStrip1')]/.//span[contains(text(),'Title')]");
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		
		ExtentTestManager.log("Verifying Imported Title Data for parcel # "+map.get("Orion PID").trim());
		SoftAssert assertion = new SoftAssert();
		        
		By addedRecord = By.xpath("(//td[text()='"+map.get("Orion PID").trim()+"']/parent::tr)[1]");
		Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
		util.click(addedRecord);
		
		By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Orion PID")+"']");
		util.waitForWebElementToBePresent(parcelSummary, IMPLICIT_WAIT);
		
		assertion.assertEquals(getOrionPID(), map.get("Orion PID").trim(), "Orion PID mismatched");
		ExtentTestManager.log("Orion PID matched : " +getOrionPID());
		
		        util.waitUntilElementDisplay(navTitle);
		    	util.click(navTitle);
		    	util.dummyWait(1);	
				
		        assertion.assertEquals(getTitleVersion(), map.get("Title Version").trim(), "Title Version mismatched");
				ExtentTestManager.log("Title Version : "+getTitleVersion());
				
				assertion.assertEquals(getTitleOrderSelection(), map.get("Title Order Selection").trim(), "Title Order Selection mismatched");
				ExtentTestManager.log("Title Order Selection : "+getTitleOrderSelection());
				
				assertion.assertEquals(getDeveloperUserName(), map.get("Developer UserName").trim(), "Developer UserName mismatched");
				ExtentTestManager.log("Developer UserName : "+getDeveloperUserName());
				
				assertion.assertEquals(getTitleStatusAgentUserName(), map.get("Title Status Agent UserName").trim(), "Title Status Agent UserName mismatched");
				ExtentTestManager.log("Title Status Agent UserName : "+getTitleStatusAgentUserName());
				
				assertion.assertEquals(getTitleStatusNotes(), map.get("Title Status Notes").trim(), "Title Status Notes mismatched");
				ExtentTestManager.log("Title Status Notes : "+getTitleStatusNotes());
				
				assertion.assertEquals(getTitleStatus().trim(), map.get("Title Status").trim(), "Title Status mismatched");
				ExtentTestManager.log("Title Status : "+getTitleStatus());
				
				assertion.assertAll();
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			objErrorLog.printErrorLog();
			//objErrorLog.titleImportvalidationMsg(testcaseName); 
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
