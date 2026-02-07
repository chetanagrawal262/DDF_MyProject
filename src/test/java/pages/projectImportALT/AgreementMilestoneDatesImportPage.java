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

public class AgreementMilestoneDatesImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public AgreementMilestoneDatesImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By agreementNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Number: ']/..//input[contains(@id,'Dest_Input')] |//span[contains(@id,'_Lease_Number_wrapper')]/input[contains(@id,'_Lease_Number') and @type='text']");
	public String getAgreementNumber() {
		
		return util.getAttributeValue(agreementNumber, "value");
	}
	
	By dateName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Date Name: ']/..//input[contains(@id,'Dest_Input')]");
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
	
	By comments = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Comments: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'EditFormControl_tb_Comment')]");
	public String getComments() {
		return util.getAttributeValue(comments, "value");
	}
	
	Map<String, String> excelData;
	public void agreementMilestoneDatesMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementMilestoneDatesMapping, testcaseName);
				assertion.assertEquals(getAgreementNumber(), excelData.get("Agreement Number").trim(), "Agreement Number mapping mismatched");
				ExtentTestManager.log("Agreement number Mapping : " +getAgreementNumber());
				
				assertion.assertEquals(getDateName(), excelData.get("Date Name").trim(), "Date Name mapping mismatched");
				ExtentTestManager.log("Date Name Mapping : "+getDateName());
				
				assertion.assertEquals(getExpectedDate(), excelData.get("Expected Date").trim(), "Expected Date mapping mismatched");
				ExtentTestManager.log("Expected Date Mapping : "+getExpectedDate());
				
				assertion.assertEquals(getActualDate(), excelData.get("Actual Date").trim(), "Actual Date mapping mismatched");
				ExtentTestManager.log("Actual Date Mapping : "+getActualDate());
				
				assertion.assertEquals(getComments(), excelData.get("Comments").trim(), "Comments mapping mismatched");
				ExtentTestManager.log("Comments Mapping : "+getComments());
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyAgreementMilestoneDatesMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			agreementMilestoneDatesMapping(testcaseName);
			log("STEP 7:  All Agreement Contacts Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By milestoneDatesPanel = By.xpath("//div[contains(@id,'LSINFO_radPanels')]//span[text()='Milestone Dates']");
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Agreement Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				assertion.assertEquals(getAgreementNumber(), map.get("Agreement Number").trim(), "Agreement Number mismatched");
				ExtentTestManager.log("Agreement Number : "+getAgreementNumber());
				
				util.dummyWait(2);
				util.waitUntilElementDisplay(milestoneDatesPanel);
				util.click(milestoneDatesPanel);
										
				By keydateadded = By.xpath("//td[text()='"+map.get("Date Name") +"']/..//following-sibling::td//input[@title='Edit']");
				Assert.assertTrue(util.isElementPresent(keydateadded, 30), "Record is not added yet");
				util.click(keydateadded);
				
				if(util.isElementVisible(expectedDate)) {
					if(! map.get("Expected Date").trim().contains("NA")) {
				assertion.assertEquals(getExpectedDate(), map.get("Expected Date").trim(), "Expected Date mismatched");
				ExtentTestManager.log("Expected Date : "+getExpectedDate());
				}
				}
				
				assertion.assertEquals(getActualDate(), map.get("Actual Date").trim(), "Actual Date mismatched");
				ExtentTestManager.log("Actual Date : "+getActualDate());
				
				if(util.isElementVisible(comments)) {
				assertion.assertEquals(getComments(), map.get("Comments").trim(), "Comments mismatched");
				ExtentTestManager.log("Comments : "+getComments());
				util.dummyWait(2);
				}
				
				assertion.assertAll();
			
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
			log("STEP 13:  User can close the pop up", Status.PASS);
		} catch (Exception t) {
			driver.close();
			util.switchToParentWindow();
			log("STEP 13:  User cannot close the pop up", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
	}
	
}
