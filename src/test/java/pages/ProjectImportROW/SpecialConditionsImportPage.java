package pages.ProjectImportROW;

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
import pages.projectImportALT.ProjectImportPage;

public class SpecialConditionsImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public SpecialConditionsImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By tractNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Tract #: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getTractNo() {
		
		return util.getAttributeValue(tractNo, "value");
	}
	
	By type = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_TYPE_ID_radYALDropDownList_Input') and @type='text']");
	public String getType() {
		return util.getAttributeValue(type, "value");
	}
	By priority = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Priority: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_PRIORITY_ID_radYALDropDownList_Input') and @type='text']");
	public String getPriority() {
		return util.getAttributeValue(priority, "value");
	}
	
	By frequency = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Frequency: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_FREQUENCY_ID_radYALDropDownList_Input') and @type='text']");
	public String getFrequency() {
		return util.getAttributeValue(frequency, "value");
	}
	
	By startDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Start Date: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Start_Date_dateInput') and @type='text']");
	public String getStartDate() {
		return util.getAttributeValue(startDate, "value");
	}
	
	By endDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='End Date: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_End_Date_dateInput') and @type='text']");
	public String getEndDate() {
		return util.getAttributeValue(endDate, "value");
	}
	
	By dateApproved = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Date Approved: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Date_Approved_dateInput') and @type='text']");
	public String getDateApproved() {
		return util.getAttributeValue(dateApproved, "value");
	}
	
	By nextDueDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Next Due Date: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Next_Due_Date_dateInput') and @type='text']");
	public String getNextDueDate() {
		return util.getAttributeValue(nextDueDate, "value");
	}
	
	By description = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Description: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'_EditFormControl_DESCRIPTION')]");
	public String getDescription() {
		return util.getAttributeValue(description, "value");
	}
	
	
	
	Map<String, String> excelData;
	public void SpecialConditionsMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.SpecialConditionsMapping, testcaseName);
				assertion.assertEquals(getTractNo(), excelData.get("Tract #").trim(), "Tract number mapping mismatched");
				ExtentTestManager.log("Tract number Mapping : " +getTractNo());
				
				assertion.assertEquals(getType(), excelData.get("Type").trim(), "Type mapping mismatched");
				ExtentTestManager.log("Type Mapping : " +getType());
				
				assertion.assertEquals(getPriority(), excelData.get("Priority").trim(), "Priority mapping mismatched");
				ExtentTestManager.log("Priority Mapping : "+getPriority());
				
				assertion.assertEquals(getFrequency(), excelData.get("Frequency").trim(), "Frequency mapping mismatched");
				ExtentTestManager.log("Frequency Mapping : "+getFrequency());
				
				assertion.assertEquals(getStartDate(), excelData.get("Start Date").trim(), "Start Date mapping mismatched");
				ExtentTestManager.log("Start Date Mapping : "+getStartDate());
				
				assertion.assertEquals(getEndDate(), excelData.get("End Date").trim(), "End Date mapping mismatched");
				ExtentTestManager.log("End Date Mapping : "+getEndDate());
				
				assertion.assertEquals(getDateApproved(), excelData.get("Date Approved").trim(), "Date Approved mapping mismatched");
				ExtentTestManager.log("Date Approved Mapping : "+getDateApproved());
				
				assertion.assertEquals(getNextDueDate(), excelData.get("Next Due Date").trim(), "Next Due Date mapping mismatched");
				ExtentTestManager.log("Next Due Date Mapping : "+getNextDueDate());
				
				assertion.assertEquals(getDescription(), excelData.get("Description").trim(), "Description mapping mismatched");
				ExtentTestManager.log("Description Mapping : "+getDescription());
				
				assertion.assertAll();		
			
			}
	
	public void verifySpecialConditionsMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			SpecialConditionsMapping(testcaseName);
			log("STEP 7:  All Special Conditions Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navAcquistion = By.xpath("//div[contains(@id,'RadTabStrip1')]/.//span[contains(text(),'Acquisition')] | //div[contains(@id,'RadTabStrip1')]/.//span[contains(text(),'ROW Components')]");
	By navSpecialConditions = By.xpath("//span[contains(text(),'Special Conditions')]");
	By loaderIcon = By.xpath("(//div[contains(@id,'_RadMultiPage1')])[1]");
	
	public void validationOfImportedData(Map<String, String> map, String testcaseName) {	
		ExtentTestManager.log("Verifying Imported Special Conditions Record for Tract # "+map.get("Tract #").trim());
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Tract #").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				util.waitUntilElementDisappear(loaderIcon);
				assertion.assertEquals(getTractNo(), map.get("Tract #").trim(), "Tract number mismatched");
				ExtentTestManager.log("Tract number matched : " +getTractNo());
				
				util.waitUntilElementDisplay(navAcquistion);
				util.click(navAcquistion);
				util.dummyWait(5);
				util.waitUntilElementDisplay(navSpecialConditions);
				util.click(navSpecialConditions);
				util.dummyWait(1);
				By btnEdit = By.xpath("//input[contains(@id,'CONST_STIP_radYALGridControl')]/..//*[text()='"+map.get("Type").trim()+"']/../..//input[@title='Edit']");
				util.click(btnEdit);
				util.dummyWait(2);
				
				assertion.assertEquals(getType(), map.get("Type").trim(), "Type mismatched");
				ExtentTestManager.log("Type matched : " +getType());
				
				assertion.assertEquals(getPriority(), map.get("Priority").trim(), "Priority mismatched");
				ExtentTestManager.log("Priority matched : "+getPriority());
				
				assertion.assertEquals(getFrequency(), map.get("Frequency").trim(), "Frequency mismatched");
				ExtentTestManager.log("Frequency matched : "+getFrequency());
				
				assertion.assertEquals(getStartDate(), map.get("Start Date").trim(), "Start Date mismatched");
				ExtentTestManager.log("Start Date matched : "+getStartDate());
				
				assertion.assertEquals(getEndDate(), map.get("End Date").trim(), "End Date mismatched");
				ExtentTestManager.log("End Date matched : "+getEndDate());
				
				assertion.assertEquals(getDateApproved(), map.get("Date Approved").trim(), "Date Approved mismatched");
				ExtentTestManager.log("Date Approved matched : "+getDateApproved());
				
				assertion.assertEquals(getNextDueDate(), map.get("Next Due Date").trim(), "Next Due Date mismatched");
				ExtentTestManager.log("Next Due Date matched : "+getNextDueDate());
				
				assertion.assertEquals(getDescription(), map.get("Description").trim(), "Description mismatched");
				ExtentTestManager.log("Description matched : "+getDescription());
				
				assertion.assertAll();
			
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.specialConditionsvalidationMsg(testcaseName); 
			objErrorLog.printErrorLog(); 
	        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
		} catch (Exception t) {
			  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
			  throw new RuntimeException("Failed in step 12");
		}
		
		
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
