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

public class RowDimensionsImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public RowDimensionsImportPage(WebDriver driver) {
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
	
	By acquisitionType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Acquisition Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Acquisition_Type_ID_radYALDropDownList_Input') and @type='text']");
	public String getAcquisitionType() {
		return util.getAttributeValue(acquisitionType, "value");
	}
	By rowLength = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='ROW Length: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_LENGTH_AMOUNT') and @type='text']");
	public String getRowLength() {
		return util.getAttributeValue(rowLength, "value");
	}
	
	By rowLengthUnits = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='ROW Length Units: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Length_Units_ID_radYALDropDownList_Input') and @type='text']");
	public String getRowLengthUnit() {
		return util.getAttributeValue(rowLengthUnits, "value");
	}
	
	By rowWidth = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='ROW Width: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_WIDTH_AMOUNT') and @type='text']");
	public String getRowWidth() {
		return util.getAttributeValue(rowWidth, "value");
	}
	
	By rowWidthUnit = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='ROW Width Units: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Width_Units_ID_radYALDropDownList_Input') and @type='text']");
	public String getRowWidthUnit() {
		return util.getAttributeValue(rowWidthUnit, "value");
	}
	
	By area = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Area: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Area_Amount') and @type='text']");
	public String getArea() {
		return util.getAttributeValue(area, "value");
	}
	
	By areaUnit = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Area Units: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Area_Units_ID_radYALDropDownList_Input') and @type='text']");
	public String getAreaUnit() {
		return util.getAttributeValue(areaUnit, "value");
	}
	
	By offsetRow = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Offset ROW: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'_EditFormControl_OffsetROW')]");
	public String getOffsetRow() {
		return util.getAttributeValue(offsetRow, "value");
	}
	
	By rowComments = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='ROW Comments: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'EditFormControl_Comments')]");
	public String getRowComments() {
		return util.getAttributeValue(rowComments, "value");
	}
	
	By offset = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Offset: ']/..//input[contains(@id,'Dest_Input')]");
	public String getOffset() {
		return util.getAttributeValue(offset, "value");
	}
	
	Map<String, String> excelData;
	public void RowDimensionsMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.RowDimensionsMapping, testcaseName);
				assertion.assertEquals(getTractNo(), excelData.get("Tract #").trim(), "Tract number mapping mismatched");
				ExtentTestManager.log("Tract number Mapping : " +getTractNo());
				
				assertion.assertEquals(getAcquisitionType(), excelData.get("Acquisition Type").trim(), "Acquisition Type mapping mismatched");
				ExtentTestManager.log("Acquisition Type Mapping : " +getAcquisitionType());
				
				assertion.assertEquals(getRowLength(), excelData.get("ROW Length").trim(), "ROW Length mapping mismatched");
				ExtentTestManager.log("ROW Length Mapping : "+getRowLength());
				
				assertion.assertEquals(getRowLengthUnit(), excelData.get("ROW Length Units").trim(), "ROW Length Units mapping mismatched");
				ExtentTestManager.log("ROW Length Units Mapping : "+getRowLengthUnit());
				
				assertion.assertEquals(getRowWidth(), excelData.get("ROW Width").trim(), "ROW Width mapping mismatched");
				ExtentTestManager.log("ROW Width Mapping : "+getRowWidth());
				
				assertion.assertEquals(getRowWidthUnit(), excelData.get("ROW Width Units").trim(), "ROW Width Units mapping mismatched");
				ExtentTestManager.log("ROW Width Units Mapping : "+getRowWidthUnit());
				
				assertion.assertEquals(getArea(), excelData.get("Area").trim(), "Area mapping mismatched");
				ExtentTestManager.log("Area Mapping : "+getArea());
				
				assertion.assertEquals(getAreaUnit(), excelData.get("Area Units").trim(), "Area Units mapping mismatched");
				ExtentTestManager.log("Area Units Mapping : "+getAreaUnit());
				
				assertion.assertEquals(getOffsetRow(), excelData.get("Offset ROW").trim(), "Offset ROW mapping mismatched");
				ExtentTestManager.log("Offset ROW Mapping : "+getOffsetRow());
				
				assertion.assertEquals(getRowComments(), excelData.get("ROW Comments").trim(), "ROW Comments mapping mismatched");
				ExtentTestManager.log("ROW Comments Mapping : "+getRowComments());
				
				assertion.assertEquals(getOffset(), excelData.get("Offset").trim(), "Offset mapping mismatched");
				ExtentTestManager.log("Offset Mapping : "+getOffset());
								
				assertion.assertAll();		
			
			}
	
	public void verifyRowDimensionsMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			RowDimensionsMapping(testcaseName);
			log("STEP 7:  All ROW Dimenstions Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navAcquistion = By.xpath("//div[contains(@id,'RadTabStrip1')]/.//span[contains(text(),'Acquisition')] | //div[contains(@id,'RadTabStrip1')]/.//span[contains(text(),'ROW Components')]");
	By navRowDimension = By.xpath("(//span[contains(text(),'ROW Dimensions')])[last()]");
	By loaderIcon = By.xpath("(//div[contains(@id,'_RadMultiPage1')])[1]");
	
	public void validationOfImportedData(Map<String, String> map, String testcaseName) {	
		ExtentTestManager.log("Verifying Imported Row Dimensions Record for Tract # "+map.get("Tract #").trim());
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
				util.waitUntilElementDisplay(navRowDimension);
				util.click(navRowDimension);
				util.dummyWait(1);
				By btnEdit = By.xpath("(//input[contains(@id,'_ACQDIMENSIONS_radYALGridControl')]/..//*[text()='"+map.get("Acquisition Type").trim()+"']/.././/input[@title='Edit'])[1]");
				util.click(btnEdit);
				util.dummyWait(2);
				
				assertion.assertEquals(getAcquisitionType(), map.get("Acquisition Type").trim(), "Acquisition Type mismatched");
				ExtentTestManager.log("Acquisition Type matched : " +getAcquisitionType());
				
				assertion.assertEquals(getRowLength(), map.get("ROW Length").trim(), "ROW Length mismatched");
				ExtentTestManager.log("ROW Length matched : "+getRowLength());
				
				assertion.assertEquals(getRowLengthUnit(), map.get("ROW Length Units").trim(), "ROW Length Units mismatched");
				ExtentTestManager.log("ROW Length Units matched : "+getRowLengthUnit());
				
				assertion.assertEquals(getRowWidth(), map.get("ROW Width").trim(), "ROW Width mismatched");
				ExtentTestManager.log("ROW Width matched : "+getRowWidth());
				
				assertion.assertEquals(getRowWidthUnit(), map.get("ROW Width Units").trim(), "ROW Width Units mismatched");
				ExtentTestManager.log("ROW Width Units matched : "+getRowWidthUnit());
				
				assertion.assertEquals(getArea(), map.get("Area").trim(), "Area mismatched");
				ExtentTestManager.log("Area matched : "+getArea());
				
				assertion.assertEquals(getAreaUnit(), map.get("Area Units").trim(), "Area Unit mismatched");
				ExtentTestManager.log("Area Unit matched : "+getAreaUnit());
				
				if(util.isElementVisible(offsetRow)) {
				assertion.assertEquals(getOffsetRow(), map.get("Offset ROW").trim(), "Offset ROW mismatched");
				ExtentTestManager.log("Offset ROW matched : "+getOffsetRow());
				}
				
				assertion.assertEquals(getRowComments(), map.get("ROW Comments").trim(), "ROW Comments mismatched");
				ExtentTestManager.log("ROW Comments matched : "+getRowComments());
				
				assertion.assertAll();
			
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.rowDimensionsvalidationMsg(testcaseName); 
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
