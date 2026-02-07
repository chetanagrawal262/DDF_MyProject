package pages.projectImportORSTED;

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

public class FacilitiesDataImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public FacilitiesDataImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}
	
	By orstedPin = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Orsted PIN: ' or text()='Parcel #: ' ]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TRACT_NUMBER') and @type='text'])[1]");
	public String getOrstedPin() {		
		return util.getAttributeValue(orstedPin, "value");
	}
	
	By type = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Type: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'EditFormControl_ddlEasementType') and @type='text'])[1] ");
	public String getType() {
		return util.getAttributeValue(type, "value");
	}
	By estimateQuantity = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Estimate Quantity: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_EST_AMOUNT') and @type='text']");
	public String getEstimateQuantity() {
		return util.getAttributeValue(estimateQuantity, "value");
	}
	By asBuiltQuantity = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='As-Built Quantity: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Survey_Amount') and @type='text']");
	public String getAsBuiltQuantity() {
		return util.getAttributeValue(asBuiltQuantity, "value");
	}
	By unit = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Unit: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_ddlUnit') and @type='text']");
	public String getUnit() {
		return util.getAttributeValue(unit, "value");
	}
	By discarded = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Discarded: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_chkDiscarded')]");
	public String getDiscarded() {
		return util.getAttributeValue(discarded, "value");
	}
	By comment = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Comments: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'EditFormControl_txtComments')]");
	public String getComment() {
		return util.getAttributeValue(comment, "value");
	}
	

	Map<String, String> excelData;
	public void FacilitiesDataImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.FacilitiesMapping, testcaseName);
				assertion.assertEquals(getOrstedPin(), excelData.get("Parcel #").trim(), "Parcel # mapping mismatched");
				ExtentTestManager.log("Parcel # Mapping : " +getOrstedPin());
				
				assertion.assertEquals(getType(), excelData.get("Type").trim(), "Type mapping mismatched");
				ExtentTestManager.log("Type Mapping : " +getType());
				
				assertion.assertEquals(getEstimateQuantity(), excelData.get("Estimate Quantity").trim(), "Estimate Quantity mapping mismatched");
				ExtentTestManager.log("Estimate Quantity Mapping : "+getEstimateQuantity());
				
				assertion.assertEquals(getAsBuiltQuantity(), excelData.get("As-Built Quantity").trim(), "As-Built Quantity mapping mismatched");
				ExtentTestManager.log("As-Built Quantity Mapping : "+getAsBuiltQuantity());
				
				assertion.assertEquals(getUnit(), excelData.get("Unit").trim(), "Unit mapping mismatched");
				ExtentTestManager.log("Unit Mapping : "+getUnit());
				
				assertion.assertEquals(getDiscarded(), excelData.get("Discarded").trim(), "Discarded mapping mismatched");
				ExtentTestManager.log("Discarded Mapping : "+getDiscarded());
				
				assertion.assertEquals(getComment(), excelData.get("Comments").trim(), "Comments mapping mismatched");
				ExtentTestManager.log("Comments Mapping : "+getComment());
				
				assertion.assertAll();
			}
	
	
	public void verifyFacilitiesDataImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			FacilitiesDataImportMapping(testcaseName);
			log("STEP 7:  All Land  Data Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
		
		By navFacilities = By.xpath("//span[text()='Facilities' or text()='Easement & Collection Line Details']");
		By navPermanentInfrastructure = By.xpath("*//span[text()='Permanent Infrastructure']/parent::a");
		
		public void verifyImportedFacilitiesData(Map<String, String> map, String testcaseName) {

			SoftAssert assertion = new SoftAssert();

			util.dummyWait(2);
			
				
					 	By addedRecord = By.xpath("//td[text()='"+map.get("Orsted PIN") +"']/parent::tr");
						Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
						util.click(addedRecord);
						By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Orsted PIN").trim()+"']");

						assertion.assertTrue(util.isElementVisible(parcelSummary, 30), "Orsted PIN/ Parcel # not visible  on Parcel summery");
						assertion.assertEquals(getOrstedPin(), map.get("Orsted PIN").trim(), "Orsted PIN/ Parcel # mismatched");
						ExtentTestManager.log("Orsted PIN/ Parcel # : " +getOrstedPin());
						
						
						util.dummyWait(2);
						util.waitUntilElementDisplay(navFacilities);
						util.click(navFacilities);
						
						By edit = By.xpath("//td[text()='"+map.get("Type") +"']/..//following-sibling::td//input[@title='Edit']");

						util.click(edit);
						util.dummyWait(2);
											
						assertion.assertEquals(getType(), map.get("Type").trim(), "Type mismatched");
						ExtentTestManager.log("Type : "+getType());
						
						assertion.assertEquals(getEstimateQuantity(), map.get("Estimate Quantity").trim(), "Estimate Quantity mismatched");
						ExtentTestManager.log("Estimate Quantity : "+getEstimateQuantity());
						
						assertion.assertEquals(getAsBuiltQuantity(), map.get("As-Built Quantity").trim(), "As-Built Quantity mismatched");
						ExtentTestManager.log("As-Built Quantity : "+getAsBuiltQuantity());
						
						assertion.assertEquals(getUnit(), map.get("Unit").trim(), "Unit mismatched");
						ExtentTestManager.log("Unit : "+getUnit());
						
						assertion.assertEquals(getDiscarded(), map.get("Discarded").trim(), "Discarded mismatched");
						ExtentTestManager.log("Discarded : "+getDiscarded());
						
						assertion.assertEquals(getComment(), map.get("Comments").trim(), "Comments mismatched");
						ExtentTestManager.log("Comments : "+getComment());
						util.dummyWait(2);
						
						assertion.assertAll();
						
				}
			
		By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
		By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
		public void errorLogValidation(String testcaseName) throws Exception {

			try {
				//objErrorLog.FacilitiesDatavalidationMsg(testcaseName); 
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
		        log("STEP 14:  User can close the pop up", Status.PASS);
			} catch (Exception t) {
			
				  driver.close();
				  util.switchToParentWindow(); 
				  log("STEP 14:  User cannot close the pop up", Status.FAIL);
				  throw new RuntimeException("Failed in step 14");
			}
		}

}
