package pages.projectImportDOT;

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

public class ProjectNotesImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public ProjectNotesImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By activityDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Activity Date')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'AgntNotes_AD_dateInput') and @type='text'])[1]");
	public String getActivityDate() {
		return util.getAttributeValue(activityDate, "value");
	}
	By agentName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Agent Name')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input') and @type='text'])[1]");
	public String getAgentName() {
		return util.getAttributeValue(agentName, "value");
	}
	
	By notesCategoryParent = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Notes Category-Parent')]/..//input[contains(@id,'Dest_Input')]");
	public String getNotesCategoryParent() {
		return util.getAttributeValue(notesCategoryParent, "value");
	}
	
	By notesCategoryChild = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Notes Category-Child')]/..//input[contains(@id,'Dest_Input')]");
	public String getNotesCategoryChild() {
		return util.getAttributeValue(notesCategoryChild, "value");
	}
	
	By notes = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Notes:')]/..//input[contains(@id,'Dest_Input')]");
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
				ExtentTestManager.log("Agent Name Mapping : "+getAgentName());
				
				assertion.assertEquals(getNotesCategoryParent(), excelData.get("Category").trim(), "Notes Category Parent mapping mismatched");
				ExtentTestManager.log("Notes Category Parent Mapping : "+getNotesCategoryParent());
				
				assertion.assertEquals(getNotesCategoryChild(), excelData.get("Child Category").trim(), "Notes Category Child mapping mismatched");
				ExtentTestManager.log("Notes Category Child Mapping : "+getNotesCategoryChild());
				
				assertion.assertEquals(getNotes(), excelData.get("Notes").trim(), "Notes mapping mismatched");
				ExtentTestManager.log("Notes Mapping : "+getNotes());
				
				assertion.assertAll();		
			
			}
	
	public void verifyProjectNotesImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		
		try {
			ProjectNotesMapping(testcaseName);
			log("STEP 7:  All Agent Notes Import Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navProjectNotes = By.xpath("//div[contains(@id,'RadTabStrip1')]/.//span[contains(text(),'Project Notes')]");
	By navNotesTab = By.xpath("//div[contains(@id,'RadTabStrip1')]/.//span[contains(text(),'Notes')]");
	By iframeNotes = By.xpath("//iframe[@name='UserListDialog']");

	public void verifyImportedProjectNotesData(Map<String, String> map, String testcaseName) {	

		SoftAssert assertion = new SoftAssert();
		
		        util.dummyWait(1);
		        util.click(navProjectNotes);
		        util.dummyWait(5);
		       
				WebElement category= driver.findElement(By.xpath("(//tr[contains(@id,'AGENTNOTES_radYALGridControl')]/..//*[text()='"+map.get("Notes")+"'])[1]"));
				String textCategory = category.getText();
				ExtentTestManager.log("Category matched on the Notes grid : " +textCategory);
				
				By notesDesc = By.xpath("//tr[contains(@id,'AGENTNOTES_radYALGridControl')]/..//*[text()='"+map.get("Notes")+"']");
				WebElement notes= driver.findElement(notesDesc);
				
				By edit = By.xpath("(//tr[contains(@id,'AGENTNOTES_radYALGridControl')]/..//*[text()='"+map.get("Notes")+"']/..//*[text()='Edit'])[1]");
				ExtentTestManager.log("Notes Description matched on the Notes grid : " +notes.getText());
				util.click(edit);
				util.dummyWait(2);
				util.switchToIframe(iframeNotes);
				
				assertion.assertEquals(getActivityDate(), map.get("Activity Date").trim(), "Activity Date mismatched");
				ExtentTestManager.log("Activity Date matched : " +getActivityDate());
				
				assertion.assertEquals(getAgentName(), map.get("Agent Name").trim(), "Agent Name mismatched");
				ExtentTestManager.log("Agent Name matched : " +getAgentName());
				
				String categoryPopup= driver.findElement(By.xpath("//*[contains(@id,'AgntNotes_CATEGORY')]/span")).getText();
				assertion.assertEquals(categoryPopup, map.get("Notes Category-Child").trim(), "Category on Notes PopUp mismatched");
				ExtentTestManager.log("Category found on the Notes PopUp : " +categoryPopup);

				By textNote = By.xpath("(//body/../..//*[text()='"+map.get("Notes").trim()+"'])[1]");
				String text = driver.findElement(textNote).getText();
				if(util.isElementVisible(textNote)) {
				assertion.assertEquals(text, map.get("Notes").trim(), "Notes mismatched");
				ExtentTestManager.log("Notes matched : "+text);
				}
			    assertion.assertAll();
			
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.ProjectNotesValidationMsg(testcaseName); 
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
