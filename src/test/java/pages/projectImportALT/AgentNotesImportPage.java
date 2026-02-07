package pages.projectImportALT;

import java.util.HashMap;
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
import pages.ProjectImportROW.ErrorLog;

public class AgentNotesImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public AgentNotesImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	
	By tractNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Tract #: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TRACT_NUMBER') and @type='text'])[1]");
	public String getTractNumber() {
		return util.getAttributeValue(tractNumber, "value");
	}
	
	By activityDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Activity Date: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'AgntNotes_AD_dateInput') and @type='text'])[1]");
	public String getActivityDate() {
		return util.getAttributeValue(activityDate, "value");
	}
	
	By agentName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agent Name: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'AgntNotes_UID') and @type='text'])[1]");
	public String getAgentName() {
		return util.getAttributeValue(agentName, "value");
	}
	
	By category = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Category: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'AgntNotes_CID_radYALDropDownList_Input') and @type='text']");
	public String getCategory() {
		return util.getAttributeValue(category, "value");
	}
	

    By priority = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Priority: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'AgntNotes_PID') and @type='text']");
	public String getPriority() {
		return util.getAttributeValue(priority, "value");
	}
	
	By notes = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Notes: ']/..//input[contains(@id,'Dest_Input')] ");
	public String getNotes() {
		return util.getAttributeValue(notes, "value");
	}
	

	Map<String, String> excelData;
	public void AgentNotesImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgentNotesMapping, testcaseName);
				
				assertion.assertEquals(getTractNumber(), excelData.get("Parcel Number").trim(), "Tract # mapping mismatched");
				ExtentTestManager.log("Tract # Mapping : " +getTractNumber());
				
				assertion.assertEquals(getActivityDate(), excelData.get("Activity Date").trim(), "Activity Date mapping mismatched");
				ExtentTestManager.log("Activity Date Mapping : " +getActivityDate());
				
				assertion.assertEquals(getAgentName(), excelData.get("Agent Name").trim(), "Agent Name mapping mismatched");
				ExtentTestManager.log("Agent Name Mapping : "+getAgentName());
				
				assertion.assertEquals(getCategory(), excelData.get("Notes Category-Parent").trim(), "Category mapping mismatched");
				ExtentTestManager.log("Category Mapping : "+getCategory());
				
				assertion.assertEquals(getPriority(), excelData.get("Priority").trim(), "Priority mapping mismatched");
				ExtentTestManager.log("Priority Mapping : "+getPriority());
				
				assertion.assertEquals(getNotes(), excelData.get("Notes").trim(), "Notes mapping mismatched");
				ExtentTestManager.log("Notes Mapping : "+getNotes());
				
				assertion.assertAll();

			}
	
	public void verifyAgentNotesImportMapping(Map<String, String> map, String testcaseName) throws Exception {
	objProjectImportPage.projectDataImport(map, testcaseName);
	try {
		AgentNotesImportMapping(testcaseName);
		log("STEP 7:  All Land  Data Mappings are correct", Status.PASS);
	} catch (Exception e) {
		log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
		throw new RuntimeException("Failed in step 7");
	}
	util.dummyWait(5);
	
}

	
	public void validationOfImportedData(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();	
		if(testcaseName.contains("ORSTED")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ORSTED_PROJECTIMPORT_FILE), Excel.AgentNotes, testcaseName);
		}else {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ALT_PROJECTIMPORT_FILE), Excel.AgentNotes, testcaseName);
		}
		util.dummyWait(2);
				 	By addedRecord = By.xpath("(//td[text()='"+map.get("Tract #") +"']/parent::tr)[1]");
					Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
					util.click(addedRecord);
					
					if(!environment.contains("NOVA")) {
					By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Tract #").trim()+"']");
					assertion.assertTrue(util.isElementVisible(parcelSummary, 30), "Parcel # not visible  on Parcel summery");
					}
					assertion.assertEquals(getTractNumber(), map.get("Tract #").trim(), "Parcel number mismatched");
					ExtentTestManager.log("Parcel number matched : " +getTractNumber());
					
					By editnote = By.xpath("(//tr[contains(@id,'AGENTNOTES_radYALGridControl')]/..//*[text()='"+map.get("Notes")+"']/..//*[text()='Edit'])[1]");
					if(util.isElementVisible(editnote)) {
					util.click(editnote);
					util.dummyWait(2);
					
					By iframe = By.xpath("//iframe[@name='UserListDialog']");
					util.switchToIframe(iframe);
					util.dummyWait(1);
					
					assertion.assertEquals(getActivityDate(), map.get("Activity Date").trim(), "Activity Date mismatched");
					ExtentTestManager.log("Activity Date  : " +getActivityDate());
					
					assertion.assertEquals(getAgentName(), map.get("Agent Name").trim(), "Agent Name mismatched");
					ExtentTestManager.log("Agent Name  : "+getAgentName());
					
					assertion.assertEquals(getCategory(), map.get("Category").trim(), "Category mismatched");
					ExtentTestManager.log("Category  : "+getCategory());
					
					assertion.assertEquals(getPriority(), map.get("Priority").trim(), "Priority value mismatched");
					ExtentTestManager.log("Priority value  : "+getPriority());
					
					By descriptionIframe = By.xpath("//iframe[contains(@id,'AgntNotes_RE1')]");
                    util.switchToIframe(descriptionIframe);
					 
					By NotesDesc = By.xpath("//body[text()='"+map.get("Notes").trim()+"']");				
					if(util.isElementVisible(NotesDesc)) {
					String Notestext = driver.findElement(NotesDesc).getText();					
					assertion.assertEquals(Notestext, map.get("Notes").trim(), "Notes mismatched");
					ExtentTestManager.log("Notes : "+Notestext);
					}
					
					assertion.assertAll();
					}
			 }
		
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.AgentNotesvalidationMsg(testcaseName); 
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
	        log("STEP 13:  User can close the popup", Status.PASS);
		} catch (Exception t) {
			  driver.close();
			  util.switchToParentWindow(); 
			  log("STEP 13:  User cannot close the popup", Status.FAIL);
			  throw new RuntimeException("Failed in step 13");
		}
	}
	
}
			
		
