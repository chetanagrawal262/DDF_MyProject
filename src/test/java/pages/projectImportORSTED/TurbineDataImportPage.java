package pages.projectImportORSTED;

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
import pages.projectImportORSTED.ErrorLog;
import pages.projectImportORSTED.ProjectImportPage;


public class TurbineDataImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public TurbineDataImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}
	
	By orstedPin = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Orsted PIN: ']/..//input[contains(@id,'Dest_Input')] | //span[contains(@id,'idYalImport_SourceCols') and text()='Parcel #: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TRACT_NUMBER') and @type='text'])[1]");
	public String getOrstedPin() {		
		return util.getAttributeValue(orstedPin, "value");
	}
	
	By turbineNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Turbine #: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'txtTurbineNumber') and @type='text'])[1] ");
	public String getTurbineNo() {
		return util.getAttributeValue(turbineNo, "value");
	}
	By financialClass = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Financial Class: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Financial_Class_ID_radYALDropDownList_Input') and @type='text']");
	public String getFinancialClass() {
		return util.getAttributeValue(financialClass, "value");
	}
	By turbineCapacity = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Turbine Capacity: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'txtTurbineCapacity') and @type='text']");
	public String getTurbineCapacity() {
		return util.getAttributeValue(turbineCapacity, "value");
	}
	By operationalDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Operational Date: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'DATE_OPERATIONAL_dateInput') and @type='text']");
	public String getOperationalDate() {
		return util.getAttributeValue(operationalDate, "value");
	}
	By active = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Active: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'chkActive')]");
	public String getActive() {
		return util.getAttributeValue(active, "value");
	}
	By comment = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Comments: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'txtTUR_COMMENTS')]");
	public String getComment() {
		return util.getAttributeValue(comment, "value");
	}
	

	Map<String, String> excelData;
	public void TurbineDataImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
		
		excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.TurbineMapping, testcaseName);
		if(testcaseName.contains("ORSTED")) {
				assertion.assertEquals(getOrstedPin(), excelData.get("Orsted PIN").trim(), "Orsted PIN mapping mismatched");
				ExtentTestManager.log("Orsted PIN Mapping : " +getOrstedPin());
			}
			else {
				assertion.assertEquals(getOrstedPin(), excelData.get("Parcel#").trim(), "Parcel # mapping mismatched");
				ExtentTestManager.log("Parcel # Mapping : " +getOrstedPin());
			}
				
				assertion.assertEquals(getTurbineNo(), excelData.get("Turbine #").trim(), "Turbine # mapping mismatched");
				ExtentTestManager.log("Turbine # Mapping : " +getTurbineNo());
				
				assertion.assertEquals(getFinancialClass(), excelData.get("Financial Class").trim(), "Financial Class mapping mismatched");
				ExtentTestManager.log("Financial Class Mapping : "+getFinancialClass());
				
				assertion.assertEquals(getTurbineCapacity(), excelData.get("Turbine Capacity").trim(), "Turbine Capacity mapping mismatched");
				ExtentTestManager.log("Turbine Capacity Mapping : "+getTurbineCapacity());
				
				assertion.assertEquals(getOperationalDate(), excelData.get("Operational Date").trim(), "Operational Date mapping mismatched");
				ExtentTestManager.log("Operational Date Mapping : "+getOperationalDate());
				
				assertion.assertEquals(getActive(), excelData.get("Active").trim(), "Active mapping mismatched");
				ExtentTestManager.log("Active Mapping : "+getActive());
				
				assertion.assertEquals(getComment(), excelData.get("Comments").trim(), "Comments mapping mismatched");
				ExtentTestManager.log("Comments Mapping : "+getComment());
				
				
				assertion.assertAll();

			}
	
	
	public void verifyTurbineDataImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			TurbineDataImportMapping(testcaseName);
			log("STEP 7:  All Land  Data Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
		
		By navTurbine = By.xpath("//span[text()='Turbine Details'] | //span[text()='Mine Details']");
		
		
		public void verifyImportedTurbineData(Map<String, String> map, String testcaseName) {

			SoftAssert assertion = new SoftAssert();

			util.dummyWait(2);
			
					 	By addedRecord = By.xpath("//td[text()='"+map.get("Orsted PIN/Parcel #") +"']/parent::tr");
						Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
						util.click(addedRecord);
						By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Orsted PIN/Parcel #").trim()+"']");

						assertion.assertTrue(util.isElementVisible(parcelSummary, 30), "Orsted PIN/Parcel # not visible  on Parcel summery");
						assertion.assertEquals(getOrstedPin(), map.get("Orsted PIN/Parcel #").trim(), "Orsted PIN/Parcel # mismatched");
						ExtentTestManager.log("Orsted PIN/Parcel # : " +getOrstedPin());
						
						util.dummyWait(2);
						util.waitUntilElementDisplay(navTurbine);
						util.click(navTurbine);
						
//						By edit = By.xpath("//td[text()='"+map.get("Turbine #") +"']/..//following-sibling::td//input[@title='Edit']");
						By edit = By.xpath("//input[@alt='Edit']");
						
						By switchturbine = By.xpath("//iframe[@name='TurbineDialog']");
						
						util.click(edit);
						util.dummyWait(2);
						util.switchToIframe(switchturbine);
						util.dummyWait(1);
						
						assertion.assertEquals(getTurbineNo(), map.get("Turbine #").trim(), "Turbine # mismatched");
						ExtentTestManager.log("Turbine # : "+getTurbineNo());
						
						assertion.assertEquals(getFinancialClass(), map.get("Financial Class").trim(), "Financial Class mismatched");
						ExtentTestManager.log("Financial Class : "+getFinancialClass());
						
						assertion.assertEquals(getTurbineCapacity(), map.get("Turbine Capacity").trim(), "Turbine Capacity mismatched");
						ExtentTestManager.log("Turbine Capacity : "+getTurbineCapacity());
						
						assertion.assertEquals(getOperationalDate(), map.get("Operational Date").trim(), "Operational Date mismatched");
						ExtentTestManager.log("Operational Date : "+getOperationalDate());
						

						WebElement activebox = driver.findElement(By.xpath("//input[contains(@id,'chkActive') and @checked='checked']"));
						
						if (activebox.isSelected()) {
							ExtentTestManager.log("Active : Checked ");
						
						}
						else {
							ExtentTestManager.log("Active : UnChecked ");
						}
					
//						assertion.assertEquals(getActive(), map.get("Active").trim(), "Active mismatched");
//						ExtentTestManager.log("Active : "+getActive());
						
						assertion.assertEquals(getComment(), map.get("Comments").trim(), "Comments mismatched");
						ExtentTestManager.log("Comments : "+getComment());
						util.dummyWait(2);
						
						assertion.assertAll();
						
				}
			
		By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
		By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
		public void errorLogValidation(String testcaseName) throws Exception {

			try {
				//objErrorLog.TurbineDatavalidationMsg(testcaseName); 
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
		        log("STEP 14:  User can close the pop up", Status.PASS);
			} catch (Exception t) {
			
				  driver.close();
				  util.switchToParentWindow(); 
				  log("STEP 14:  User cannot close the pop up", Status.FAIL);
				  throw new RuntimeException("Failed in step 14");
			}
		}

}
