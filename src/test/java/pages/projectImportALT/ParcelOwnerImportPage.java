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

public class ParcelOwnerImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public ParcelOwnerImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By parcelNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel #: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getParcelNumber() {
		
		return util.getAttributeValue(parcelNumber, "value");
	}
	
	By contactType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Contact Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Title_of_Rep_ID_radYALDropDownList_Input') and @type='text']");
	public String getContactType() {
		return util.getAttributeValue(contactType, "value");
	}
	By firstName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='First Name: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_First_Name') and @type='text']");
	public String getFirstName() {
		return util.getAttributeValue(firstName, "value");
	}
	
	By middleName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Middle Name: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Middle_Name') and @type='text']");
	public String getMiddleName() {
		return util.getAttributeValue(middleName, "value");
	}
	
	By lastName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Last Name: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Last_Name') and @type='text']");
	public String getLastName() {
		return util.getAttributeValue(lastName, "value");
	}
	
	By suffix = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Suffix')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Suffix') and @type='text']");
	public String getSuffix() {
		return util.getAttributeValue(suffix, "value");
	}
	
	By EntityName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Entity Name: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'ENTITY_Corporation_Trust') and @type='text'])[1]");
	public String getEntityName() {
		return util.getAttributeValue(EntityName, "value");
	}
	
	By coName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'C/O Name: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_CO_Name') and @type='text']");
	public String getCOName() {
		return util.getAttributeValue(coName, "value");
	}
	
	By address1 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address 1: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Address_Line_1') and @type='text']");
	public String getAddress1() {
		return util.getAttributeValue(address1, "value");
	}
	
	By address2 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address 2: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Address_Line_2') and @type='text']");
	public String getAddress2() {
		return util.getAttributeValue(address2, "value");
	}
	
	By address3 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address 3: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Address_Line_3') and @type='text']");
	public String getAddress3() {
		return util.getAttributeValue(address3, "value");
	}
	
	By city = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='City: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_City') and @type='text']");
	public String getCity() {
		return util.getAttributeValue(city, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_State_ABB_radYALDropDownList_Input') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By postalCode = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Postal Code: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Zip_Code') and @type='text']");
	public String getPostalCode() {
		return util.getAttributeValue(postalCode, "value");
	}
	
	By workPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Work Phone: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Work_Phone_Footer') and @type='text']");
	public String getWorkPhone() {
		return util.getAttributeValue(workPhone, "value");
	}
	
	By cellPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Cell Phone: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Cell_Phone_Footer') and @type='text']");
	public String getCellPhone() {
		return util.getAttributeValue(cellPhone, "value");
	}
	
	By homePhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Home Phone: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Home_Phone_Footer') and @type='text']");
	public String getHomePhone() {
		return util.getAttributeValue(homePhone, "value");
	}
	
	By email = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Email: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_Email') and @type='text'])[1]");
	public String getEmail() {
		return util.getAttributeValue(email, "value");
	}
	
	By surfaceOwnership = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Surface Ownership')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'Pct_Ownership') and @type='text']");
	public String getSurfaceOwnership() {
		return util.getAttributeValue(surfaceOwnership, "value");
	}
	
	By windOwnership = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Wind Ownership')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'PCT_Ownership_Wind') and @type='text']");
	public String getWindOwnership() {
		return util.getAttributeValue(windOwnership, "value");
	}
	
	By cropOwnership = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Crop Ownership')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'PCT_Ownership_Crop') and @type='text']");
	public String getCropOwnership() {
		return util.getAttributeValue(cropOwnership, "value");
	}
	
	By vendorNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Vendor')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Vendor_ID') and @type='text']");
	public String getVendorNo() {
		return util.getAttributeValue(vendorNo, "value");
	}
	
	Map<String, String> excelData;
	public void parcelOwnerMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ParcelOwnerMapping, testcaseName);
				assertion.assertEquals(getParcelNumber(), excelData.get("Parcel #").trim(), "Parcel number mapping mismatched");
				ExtentTestManager.log("Parcel number Mapping : " +getParcelNumber());
				
				assertion.assertEquals(getContactType(), excelData.get("Contact Type").trim(), "Contact type mapping mismatched");
				ExtentTestManager.log("Contact type Mapping : " +getContactType());
				
				assertion.assertEquals(getFirstName(), excelData.get("First Name").trim(), "First Name mapping mismatched");
				ExtentTestManager.log("First Name Mapping : "+getFirstName());
				
				assertion.assertEquals(getMiddleName(), excelData.get("Middle Name").trim(), "Middle Name mapping mismatched");
				ExtentTestManager.log("Middle Name Mapping : "+getMiddleName());
				
				assertion.assertEquals(getLastName(), excelData.get("Last Name").trim(), "Last Name mapping mismatched");
				ExtentTestManager.log("Last Name Mapping : "+getLastName());
				
				if(testcaseName.contains("CONNECTGEN")) {
				assertion.assertEquals(getSuffix(), excelData.get("Suffix").trim(), "Suffix mapping mismatched");
				ExtentTestManager.log("Suffix Mapping : "+getSuffix());
				}
				
				assertion.assertEquals(getEntityName(), excelData.get("Corporation").trim(), "Corp/Trust/Entity Name mapping mismatched");
				ExtentTestManager.log("Corp/Trust/Entity Name Mapping : "+getEntityName());
				
				assertion.assertEquals(getCOName(), excelData.get("C/O Name").trim(), "C/O Name mapping mismatched");
				ExtentTestManager.log("C/O Name Mapping : "+getCOName());
				
				assertion.assertEquals(getAddress1(), excelData.get("Address 1").trim(), "Address 1 mapping mismatched");
				ExtentTestManager.log("Address 1 Mapping : "+getAddress1());
				
				assertion.assertEquals(getAddress2(), excelData.get("Address 2").trim(), "Address 2 mapping mismatched");
				ExtentTestManager.log("Address 2 Mapping : "+getAddress2());
				
				assertion.assertEquals(getAddress3(), excelData.get("Address 3").trim(), "Address 3 mapping mismatched");
				ExtentTestManager.log("Address 3 Mapping : "+getAddress3());
				
				assertion.assertEquals(getCity(), excelData.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());

				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getPostalCode(), excelData.get("Zip Code").trim(), "Zip Code mapping mismatched");
				ExtentTestManager.log("Zip Code Mapping : "+getPostalCode());
				
				assertion.assertEquals(getWorkPhone(), excelData.get("Work Phone").trim(), "Work Phone mapping mismatched");
				ExtentTestManager.log("Work Phone Mapping : "+getWorkPhone());
				
				assertion.assertEquals(getCellPhone(), excelData.get("Cell Phone").trim(), "Cell Phone mapping mismatched");
				ExtentTestManager.log("Cell Phone Mapping : "+getCellPhone());
				
				assertion.assertEquals(getHomePhone(), excelData.get("Home Phone").trim(), "Home Phone mapping mismatched");
				ExtentTestManager.log("Home Phone Mapping : "+getHomePhone());
				
				assertion.assertEquals(getEmail(), excelData.get("Email").trim(), "Email mapping mismatched");
				ExtentTestManager.log("Email Mapping : "+getEmail());
				
				assertion.assertEquals(getSurfaceOwnership(),excelData.get("Surface Ownership").trim(), "Surface Ownership mapping mismatched");
				ExtentTestManager.log("Surface Ownership Mapping : "+getSurfaceOwnership());
				
				assertion.assertEquals(getWindOwnership(),excelData.get("Wind Ownership").trim(), "Wind Ownership mapping mismatched");
				ExtentTestManager.log("Wind Ownership Mapping : "+getWindOwnership());
				
				assertion.assertEquals(getCropOwnership(), excelData.get("Crop Ownership").trim(), "Crop Ownership mapping mismatched");
				ExtentTestManager.log("Crop Ownership Mapping : "+getCropOwnership());
				
				if(!testcaseName.contains("NOVA")) {
				assertion.assertEquals(getVendorNo(), excelData.get("Vendor #").trim(), "Vendor # mapping mismatched");
				ExtentTestManager.log("Vendor # Mapping : "+getVendorNo());
				}
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyParcelOwnerMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			parcelOwnerMapping(testcaseName);
			log("STEP 7:  All Parcel Owner Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navLandowner = By.xpath("//span[text()='Landowner']");
	By editContact = By.xpath("//input[contains(@id,'EditButton')]");
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("(//td[text()='"+map.get("Parcel #").trim()+"']/parent::tr)[1]");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				assertion.assertEquals(getParcelNumber(), map.get("Parcel #").trim(), "Parcel number mismatched");
				ExtentTestManager.log("Parcel number matched : " +getParcelNumber());
				
				util.waitUntilElementDisplay(navLandowner);
				util.click(navLandowner);
				log("User can navigate to Landowner tab");
				
				By primaryAddressMissing = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl_ctl00')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//b[text()='Primary Address Missing'])[1]");
				assertion.assertFalse(util.isElementVisible(primaryAddressMissing), "Primary Address is not displaying on the Landowner grid");
				
				By add1 = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl_ctl00')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//strong[text()='"+map.get("Address 1").trim()+"'])[1]");
				assertion.assertTrue(util.isElementVisible(add1), "Address Line 1 is not displaying on the Landowner grid");
				
				By add2 = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl_ctl00')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//strong[text()='"+map.get("Address 2").trim()+"'])[1]");
				assertion.assertTrue(util.isElementVisible(add2), "Address Line 2 is not displaying on the Landowner grid");
				
				By city = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl_ctl00')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//strong[text()='"+map.get("City").trim()+"'])[1]");
				assertion.assertTrue(util.isElementVisible(city), "City is not displaying on the Landowner grid");
				
				By zipCode = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl_ctl00')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//strong[text()='"+map.get("Postal Code").trim()+"'])[1]");
				assertion.assertTrue(util.isElementVisible(zipCode), "Zip Code is not displaying on the Landowner grid");
				
				By email = By.xpath("(//tr[contains(@id,'LANDOWNERS_radYALGridControl_ctl00')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//strong[text()='"+map.get("Email").trim()+"'])[1]");
				assertion.assertTrue(util.isElementVisible(email), "Email is not displaying on the Landowner grid");
				
				ExtentTestManager.log("Primary Address is displaying on the grid");
				
				By btnEdit = By.xpath("//tr[contains(@id,'LANDOWNERS_radYALGridControl_ctl00')]/.//*[text()='"+map.get("Entity Name") +"']/..//a[contains(text(),'Edit')]");
				util.waitUntilElementDisplay(btnEdit);
				util.click(btnEdit);
				log("User can click on Edit Landowner button");
				log("Verifying the Imported Owner Details");
				util.dummyWait(5);
				util.switchToChildWindow();
				
				assertion.assertTrue(getSurfaceOwnership().contains(map.get("Surface Ownership %").trim()), "Surface Ownership mismatched");
				ExtentTestManager.log("Surface Ownership : "+getSurfaceOwnership());
				
				assertion.assertTrue(getWindOwnership().contains(map.get("Wind Ownership %").trim()), "Wind Ownership mismatched");
				ExtentTestManager.log("Wind Ownership : "+getWindOwnership());
				
				assertion.assertTrue(getCropOwnership().contains(map.get("Crop Ownership %").trim()), "Crop Ownership mismatched");
				ExtentTestManager.log("Crop Ownership : "+getCropOwnership());
				
				if(!testcaseName.contains("CONNECTGEN")) {
				assertion.assertEquals(getContactType(), map.get("Contact Type").trim(), "Contact Type mismatched");
				ExtentTestManager.log("Contact Type : "+getContactType());
				}
				
				if(!testcaseName.contains("ORSTED")) {
				assertion.assertEquals(getFirstName(), map.get("First Name").trim(), "First Name mismatched");
				ExtentTestManager.log("First Name : "+getFirstName());
				
				assertion.assertEquals(getMiddleName(), map.get("Middle Name").trim(), "Middle Name mismatched");
				ExtentTestManager.log("Middle Name : "+getMiddleName());
				
				assertion.assertEquals(getLastName(), map.get("Last Name").trim(), "Last Name mismatched");
				ExtentTestManager.log("Last Name : "+getLastName());
				}
				
				assertion.assertEquals(getEntityName(), map.get("Entity Name").trim(), "Entity Name mismatched");
				ExtentTestManager.log("Entity Name matched : "+getEntityName());
				
				if(testcaseName.contains("CONNECTGEN")) {
				assertion.assertEquals(getSuffix(), map.get("Suffix").trim(), "Suffix mismatched");
				ExtentTestManager.log("Suffix matched : "+getSuffix());
				}
				
				assertion.assertEquals(getCOName(), map.get("C/O Name").trim(), "C/O Name mismatched");
				ExtentTestManager.log("C/O Name matched : "+getCOName());
				
				if(!testcaseName.contains("NOVA")) {
				assertion.assertEquals(getVendorNo(), map.get("Vendor #").trim(), "Vendor mismatched");
				ExtentTestManager.log("Vendor matched : "+getVendorNo());
				}
				
				util.waitUntilElementDisplay(editContact);
				util.click(editContact);
				util.dummyWait(5);
				log("User can click on Edit contact button");
				log("verifying the Imported Contact Details");
				
				assertion.assertEquals(getAddress1(), map.get("Address 1").trim(), "Address Line 1 mismatched");
				ExtentTestManager.log("Address Line 1 matched : "+getAddress1());
				
				if(util.isElementVisible(address2)) {
				assertion.assertEquals(getAddress2(), map.get("Address 2").trim(), "Address Line 2 mismatched");
				ExtentTestManager.log("Address Line 2 matched : "+getAddress2());
				}
				
				if(util.isElementVisible(address3)) {
				assertion.assertEquals(getAddress3(), map.get("Address 3").trim(), "Address Line 3 mismatched");
				ExtentTestManager.log("Address Line 3 matched : "+getAddress3());
				}
				
				assertion.assertEquals(getCity(), map.get("City").trim(), "City mismatched");
				ExtentTestManager.log("City matched : "+getCity());
				
				assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
				ExtentTestManager.log("State matched : "+getState());
				
				assertion.assertEquals(getPostalCode(), map.get("Postal Code").trim(), "Zip Code mismatched");
				ExtentTestManager.log("Zip Code matched : "+getPostalCode());
				
				assertion.assertEquals(getEmail(), map.get("Email").trim(), "Email mismatched");
				ExtentTestManager.log("Email matched : "+getEmail());
				
				driver.close();
				util.switchToParentWindow();
				util.dummyWait(1);
				
				assertion.assertAll();
				
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.ParcelOwnervalidationMsg(testcaseName); 
			objErrorLog.printErrorLog();
	        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
		} catch (Exception t) {
//			  driver.close();
//			  util.switchToParentWindow();
			  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
			  throw new RuntimeException("Failed in step 12");
		}
		
//		try {//removed in 24.04
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
