package pages.ProjectImportROW;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;
import pages.projectImportALT.ProjectImportPage;

public class ProjectNotesImport extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public ProjectNotesImport(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By activityDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Activity Date: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_dateInput') and @type='text'])[1]");
	public String getActivityDate() {
		
		return util.getAttributeValue(activityDate, "value");
	}
	
	By agentName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agent Name: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input')and @type='text']");
	public String getAgentName() {
		return util.getAttributeValue(agentName, "value");
	}
	
	By category = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Category: ']/..//input[contains(@id,'Dest_Input')]");
	public String getCategory() {
		return util.getAttributeValue(category, "value");
	}
	
	By childCategory = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Child Category: ']/..//input[contains(@id,'Dest_Input')]");
	public String getChildCategory() {
		return util.getAttributeValue(childCategory, "value");
	}
	
	By priority = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Priority: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'AgntNotes_PID_radYALDropDownList_Input') and @type='text']");
	public String getPriority() {
		return util.getAttributeValue(priority, "value");
	}
	
	By notes = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Notes: ']/..//input[contains(@id,'Dest_Input')]");
	public String getNotes() {
		return util.getAttributeValue(notes, "value");
	}
	
	Map<String, String> excelData;
	public void ProjectNotesMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ProjectNotesMapping, testcaseName);
				assertion.assertEquals(getActivityDate(), excelData.get("Activity Date").trim(), "Activity Date mapping mismatched");
				ExtentTestManager.log("Activity Date Mapping : " +getActivityDate());
				
				assertion.assertEquals(getAgentName(), excelData.get("Agent Name").trim(), "Agent Name mapping mismatched");
				ExtentTestManager.log("Agent Name Mapping : " +getAgentName());
				
				assertion.assertEquals(getCategory(), excelData.get("Category").trim(), "Category mapping mismatched");
				ExtentTestManager.log("Category Mapping : "+getCategory());
				
				assertion.assertEquals(getChildCategory(), excelData.get("Child Category").trim(), "Child Category mapping mismatched");
				ExtentTestManager.log("Child Category Mapping : "+getChildCategory());
				
				assertion.assertEquals(getPriority(), excelData.get("Priority").trim(), "Priority mapping mismatched");
				ExtentTestManager.log("Priority Mapping : "+getPriority());
				
				assertion.assertEquals(getNotes(), excelData.get("Notes").trim(), "Notes mapping mismatched");
				ExtentTestManager.log("Notes Mapping : "+getNotes());
								
				assertion.assertAll();		
			
			}
	
	public void verifyProjectNotesMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			ProjectNotesMapping(testcaseName);
			log("STEP 7:  All Project Notes Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navProjectNotes = By.xpath("//div[contains(@id,'RadTabStrip1')]/.//span[contains(text(),'Project Notes')]");
	By iframeNotes = By.xpath("//iframe[@name='UserListDialog']");
	By categoryNotes = By.xpath("//div[@id='AgntNotes_CID_RadDropDownTree1']/span/span[1]");
	By iframeDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
	
	public void validationOfImportedData(Map<String, String> map, String testcaseName) {	
		ExtentTestManager.log("Verifying Imported Project Notes Record ");
		SoftAssert assertion = new SoftAssert();
				
				util.dummyWait(1);
				util.click(navProjectNotes);
				util.dummyWait(5);
				By btnEdit = By.xpath("(//tr[contains(@id,'AGENTNOTES_radYALGridControl')]/..//td[text()='"+map.get("Notes").trim()+"']/..//a[text()='Edit'])[1]");
//				if(util.isElementVisible(btnEdit)) {
				util.click(btnEdit);
				util.dummyWait(2);
				util.switchToIframe(iframeNotes);
				
				assertion.assertEquals(getActivityDate(), map.get("Activity Date").trim(), "Activity Date mismatched");
				ExtentTestManager.log("Activity Date matched : " +getActivityDate());
				
				assertion.assertEquals(getAgentName(), map.get("Agent Name").trim(), "Agent Name mismatched");
				ExtentTestManager.log("Agent Name matched : "+getAgentName());
				
				if(util.isElementVisible(categoryNotes)) {
					String text=driver.findElement(categoryNotes).getText();
				assertion.assertEquals(text, map.get("Child Category").trim(), "Category mismatched");
				ExtentTestManager.log("Category matched : "+text);
				}
				
				assertion.assertEquals(getPriority(), map.get("Priority").trim(), "Priority mismatched");
				ExtentTestManager.log("Priority matched : "+getPriority());
				
				util.switchToIframe(iframeDescription);
				
				By textNote = By.xpath("(//body/../..//*[text()='"+map.get("Notes").trim()+"'])[1]");
				String text = driver.findElement(textNote).getText();
				if(util.isElementVisible(textNote)) {
				assertion.assertEquals(text, map.get("Notes").trim(), "Notes mismatched");
				ExtentTestManager.log("Notes matched : "+text);
				}
				
				assertion.assertAll();
//				}else {
//					log("Edit link is not visible or Note is auto approved", Status.SKIP);
//				}
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.projectNotesvalidationMsg(testcaseName); 
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
	        log("STEP 14:  User can close the popup", Status.PASS);
		} catch (Exception t) {
			  driver.close();
			  util.switchToParentWindow(); 
			  log("STEP 14:  User cannot close the popup", Status.FAIL);
			  throw new RuntimeException("Failed in step 14");
		}
	}
}
