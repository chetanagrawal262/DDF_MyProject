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

public class TitleIssueImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public TitleIssueImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}
	
	By parcelNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Parcel #')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getParcelNo() {
		return util.getAttributeValue(parcelNo, "value");
	}
	
	By issueDescription = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Issue Description')]/..//input[contains(@id,'Dest_Input')] | //*[contains(@id,'EditFormControl_Issue_Text') and @type='text']");
	public String getIssueDescription() {
		return util.getAttributeValue(issueDescription, "value");
	}
	
	By priority = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Priority')]/..//input[contains(@id,'Dest_Input')] | //*[contains(@id,'_EditFormControl_Issue_Priority_ID_radYALDropDownList_Input') and @type='text']");
	public String getPriority() {
		return util.getAttributeValue(priority, "value");
	}
	
	By status = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Status')]/..//input[contains(@id,'Dest_Input')] | //*[contains(@id,'EditFormControl_Issue_Status_ID_radYALDropDownList_Input') and @type='text']");
	public String getStatus() {
		return util.getAttributeValue(status, "value");
	}
	
	By dateCleared = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Date Cleared')]/..//input[contains(@id,'Dest_Input')] | //*[contains(@id,'_EditFormControl_Date_Cleared_dateInput') and @type='text']");
	public String getDateCleared() {
		return util.getAttributeValue(dateCleared, "value");
	}
	
	By comments = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Comments')]/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'_EditFormControl_COMMENTS')]");
	public String getComments() {
		return util.getAttributeValue(comments, "value");
	}
	
	
	
	Map<String, String> excelData;
	public void TitleMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.TitleImportMapping, testcaseName);
				
				assertion.assertEquals(getParcelNo(), excelData.get("Parcel #").trim(), "Parcel # mapping mismatched");
				ExtentTestManager.log("Parcel # Mapping : "+getParcelNo());
				
				assertion.assertEquals(getIssueDescription(), excelData.get("Issue Description").trim(), "Issue Description mapping mismatched");
				ExtentTestManager.log("Issue Description Mapping : "+getIssueDescription());
				
				assertion.assertEquals(getPriority(), excelData.get("Priority").trim(), "Priority mapping mismatched");
				ExtentTestManager.log("Priority Mapping : "+getPriority());
				
				assertion.assertEquals(getStatus(), excelData.get("Status").trim(), "Status mapping mismatched");
				ExtentTestManager.log("Status Mapping : "+getStatus());
				
				assertion.assertEquals(getDateCleared(), excelData.get("Date Cleared").trim(), "Date Cleared mapping mismatched");
				ExtentTestManager.log("Date Cleared Mapping : "+getDateCleared());
				
				assertion.assertEquals(getComments(), excelData.get("Comments").trim(), "Comments mapping mismatched");
				ExtentTestManager.log("Comments Mapping : "+getComments());
				
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
		util.dummyWait(5);
		
	}
    
	By navTitle = By.xpath("//div[contains(@id,'RadTabStrip1')]/.//span[contains(text(),'Title')]");
	By navTitleIssues = By.xpath("//span[contains(text(),'Title Issues')]");
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		
		ExtentTestManager.log("Verifying Imported Title Issue Data for parcel # "+map.get("Parcel #").trim());
		SoftAssert assertion = new SoftAssert();
		        
		By addedRecord = By.xpath("(//td[text()='"+map.get("Parcel #").trim()+"']/parent::tr)[1]");
		Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
		util.click(addedRecord);
		
		if(!environment.contains("NOVA")) {
		By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Parcel #")+"']");
		util.waitForWebElementToBePresent(parcelSummary, IMPLICIT_WAIT);
		}
		
		assertion.assertEquals(getParcelNo(), map.get("Parcel #").trim(), "Parcel # mismatched");
		ExtentTestManager.log("Parcel # matched : " +getParcelNo());
		
		        util.waitUntilElementDisplay(navTitle);
		    	util.click(navTitle);
		    	util.dummyWait(1);	
				
		    	util.waitUntilElementDisplay(navTitleIssues);
		    	util.click(navTitleIssues);
		    	util.dummyWait(1);	
		    	
		    	By btnEdit = By.xpath("(//tr[contains(@id,'YALTITLEISSUES_radYALGridControl')]//*[text()='"+map.get("Issue Description").trim()+"']/..//input[@title='Edit'])[1]");
				util.waitUntilElementDisplay(btnEdit);
				util.click(btnEdit);
				
		        assertion.assertEquals(getIssueDescription(), map.get("Issue Description").trim(), "Issue Description mismatched");
				ExtentTestManager.log("Issue Description : "+getIssueDescription());
				
				assertion.assertEquals(getPriority(), map.get("Priority").trim(), "Priority mismatched");
				ExtentTestManager.log("Priority : "+getPriority());
				
				assertion.assertEquals(getStatus(), map.get("Status").trim(), "Status mismatched");
				ExtentTestManager.log("Status : "+getStatus());
				
				assertion.assertEquals(getDateCleared(), map.get("Date Cleared").trim(), "Date Cleared mismatched");
				ExtentTestManager.log("Date Cleared : "+getDateCleared());
				
				assertion.assertEquals(getComments(), map.get("Comments").trim(), "Comments mismatched");
				ExtentTestManager.log("Comments : "+getComments());
				
				assertion.assertAll();
				log("All Imported Data Successfully matched");
			
		}
	
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
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
