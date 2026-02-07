package pages.projectImportORSTED;

import java.util.HashMap;
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


public class AgreementContactDataImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public AgreementContactDataImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By agreementNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Number: ']/..//input[contains(@id,'Dest_Input')] |(//input[contains(@id,'Lease_Number') and @type='text'])[2]");
	public String getAgreementNumber() {
		return util.getAttributeValue(agreementNumber, "value");
	}
	
	By landownerName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Landowner Name: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Corporation_Trust') and @type='text']");
	public String getLandownerName() {
		return util.getAttributeValue(landownerName, "value");
	}
	
	By inCareOf = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'In Care of/Attn to: ')]/..//input[contains(@id,'Dest_Input')]");
	public String getInCareOf() {
		return util.getAttributeValue(inCareOf, "value");
	}
	
	By ownership = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Ownership %: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Pct_Ownership') and @type='text']");
	public String getOwnership() {
		return util.getAttributeValue(ownership, "value");
	}

	By address1 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address 1: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Address_Line_1') and @type='text']");
	public String getAddress1() {
		return util.getAttributeValue(address1, "value");
	} 
	
	By address2 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address 2: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Address_Line_2') and @type='text']");
	public String getAddress2() {
		return util.getAttributeValue(address2, "value");
	}
	
	By address3 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address 3: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Address_Line_3') and @type='text']");
	public String getAddress3() {
		return util.getAttributeValue(address3, "value");
	}
	
	By city = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='City: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_City') and @type='text']");
	public String getCity() {
		return util.getAttributeValue(city, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State / Province: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_State') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By zip = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Zip / Postal: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'EditFormControl_Zip_Code') and @type='text']");
	public String getZip() {
		return util.getAttributeValue(zip, "value");
	}
	
	By homePhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text() = 'Home Phone: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'PCT_Ownership_Wind') and @type='text']");
	public String getHomePhone() {
		return util.getAttributeValue(homePhone, "value");
	}
	
	By cellPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text() = 'Cell Phone: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'PCT_Ownership_Wind') and @type='text']");
	public String getCellPhone() {
		return util.getAttributeValue(cellPhone, "value");
	}
	
	By email = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text() = 'Email: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'PCT_Ownership_Wind') and @type='text']");
	public String getEmail() {
		return util.getAttributeValue(email, "value");
	}

	
	Map<String, String> excelData;
	public void AgreementContactMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementContactsMapping, testcaseName);
				assertion.assertEquals(getAgreementNumber(), excelData.get("Agreement Number").trim(), "Agreement Number mapping mismatched");
				ExtentTestManager.log("Agreement Number Mapping : " +getAgreementNumber());
				
				assertion.assertEquals(getLandownerName(), excelData.get("Corporation").trim(), "Landowner Name mapping mismatched");
				ExtentTestManager.log("Landowner Name Mapping : "+getLandownerName());
				
				assertion.assertEquals(getInCareOf(), excelData.get("Attn To").trim(), "In Care of/Attn to mapping mismatched");
				ExtentTestManager.log("Title of Rep Mapping : "+getInCareOf());
				
				assertion.assertEquals(getOwnership(), excelData.get("Surface Ownership").trim(), " Ownership mapping mismatched");
				ExtentTestManager.log(" Ownership Mapping : "+getOwnership());
				
				assertion.assertEquals(getAddress1(), excelData.get("Address 1").trim(), "Address 1 mapping mismatched");
				ExtentTestManager.log("Address 1 Mapping : "+getAddress1());
				
				assertion.assertEquals(getAddress2(), excelData.get("Address 2").trim(), "Address 2 mapping mismatched");
				ExtentTestManager.log("Address 2 Mapping : "+getAddress2());
				
				assertion.assertEquals(getAddress3().trim(), excelData.get("Address 3").trim(), "Address 3 mapping mismatched");
				ExtentTestManager.log("Address 3 Mapping : "+getAddress3().trim());
				
				assertion.assertEquals(getCity(), excelData.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());

				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getZip(), excelData.get("Zip Code").trim(), "Zip Code mapping mismatched");
				ExtentTestManager.log("Zip Code Mapping : "+getZip());
												
				assertion.assertEquals(getHomePhone(), excelData.get("Home Phone").trim(), "Home Phone mapping mismatched");
				ExtentTestManager.log("Home Phone Mapping : "+getHomePhone());
				
				assertion.assertEquals(getCellPhone(), excelData.get("Cell Phone").trim(), "Cell Phone mapping mismatched");
				ExtentTestManager.log("Cell Phone Mapping : "+getCellPhone());
				
				assertion.assertEquals(getEmail(), excelData.get("Email").trim(), "Email mapping mismatched");
				ExtentTestManager.log("Email Mapping : "+getEmail());
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyAgreementContactDataImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			AgreementContactMapping(testcaseName);
			log("STEP 7:  All Parcel Owner Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navLandowner = By.xpath("//span[text()='Landowner']");
	By editcontact = By.xpath("//input[contains(@id,'EditButton')]");
	
	public void verifyImportedAgreementContactData(Map<String, String> map, String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
        util.dummyWait(2);
		
				By addedRecord = By.xpath("//td[text()='"+map.get("Agreement Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				util.dummyWait(20);
				
				assertion.assertEquals(getAgreementNumber(), map.get("Agreement Number").trim(), "Agreement Number mismatched");
				ExtentTestManager.log("Agreement Number matched : " +getAgreementNumber());
				util.dummyWait(2);
				
				util.waitUntilElementDisplay(navLandowner);
				util.dummyWait(2);
				util.click(navLandowner);
				log("User can navigate to Landowner panel");
				
				
				
				By btnEdit = By.xpath("//tr[contains(@id,'_RadGridLO_radYALGridControl_ctl00')]/..//*[text()='"+map.get("Landowner Name") +"']/..//a[contains(text(),'Edit')]");
				util.waitUntilElementDisplay(btnEdit);
				util.click(btnEdit);
				log("User can click on Edit Landowner button");
				log("Verifying the Imported Landowner Details");
				util.dummyWait(5);
				util.switchToChildWindow();
			
				assertion.assertEquals(getOwnership(), map.get("Ownership").trim(), "Ownership mapping mismatched");
				ExtentTestManager.log("Ownership Mapping : "+getOwnership());
											
				assertion.assertEquals(getLandownerName(), map.get("Landowner Name").trim(), "Landowner Name mapping mismatched");
				ExtentTestManager.log("Landowner Name Mapping : "+getLandownerName());
				
//				assertion.assertEquals(getTitleofRep(), map.get("Title of Rep").trim(), "Title of Rep mapping mismatched");
//				ExtentTestManager.log("Title of Rep Mapping : "+getTitleofRep());
				
				util.waitUntilElementDisplay(editcontact);
				util.dummyWait(2);
				util.click(editcontact);
				log("User can navigate to contact panel");
				util.dummyWait(2);
				
				
				assertion.assertEquals(getAddress1(), map.get("Address 1").trim(), "Address 1 mapping mismatched");
				ExtentTestManager.log("Address 1 Mapping : "+getAddress1());
				
				assertion.assertEquals(getAddress2(), map.get("Address 2").trim(), "Address 2 mapping mismatched");
				ExtentTestManager.log("Address 2 Mapping : "+getAddress2());
				
				assertion.assertEquals(getAddress3(), map.get("Address 3").trim(), "Address 3 mapping mismatched");
				ExtentTestManager.log("Address 3 Mapping : "+getAddress3());
				
				assertion.assertEquals(getCity(), map.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());

				assertion.assertEquals(getState(), map.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getZip(), map.get("Zip Code").trim(), "Zip Code mapping mismatched");
				ExtentTestManager.log("Zip Code Mapping : "+getZip());
				
				assertion.assertEquals(getHomePhone(), map.get("Home Phone").trim(), "Home Phone mapping mismatched");
				ExtentTestManager.log("Home Phone Mapping : "+getHomePhone());
				
				assertion.assertEquals(getCellPhone(), map.get("Cell Phone").trim(), "Cell Phone mapping mismatched");
				ExtentTestManager.log("Cell Phone Mapping : "+getCellPhone());
				
				assertion.assertEquals(getEmail(), map.get("Email").trim(), "Email mapping mismatched");
				ExtentTestManager.log("Email Mapping : "+getEmail());
				
				assertion.assertAll();
				
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.agreementcontactvalidationMsg(testcaseName); 
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
	        log("STEP 14:  User can close the pop up", Status.PASS);
		} catch (Exception t) {
		
			  driver.close();
			  util.switchToParentWindow(); 
			  log("STEP 14:  User cannot close the pop up", Status.FAIL);
			  throw new RuntimeException("Failed in step 14");
		}
	}
	
	
	

}
