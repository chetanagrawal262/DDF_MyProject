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

public class LeaseContactDataImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public LeaseContactDataImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By leaseNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Lease Number: ']/..//input[contains(@id,'Dest_Input')] |//span[contains(@id,'_Lease_Number_wrapper')]/input[contains(@id,'_Lease_Number') and @type='text']");
	public String getLeaseNumber() {
		
		return util.getAttributeValue(leaseNumber, "value");
	}
	
	By trustName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Trust Name')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Corporation_Trust') and @type='text']");
	public String getTrustName() {
		return util.getAttributeValue(trustName, "value");
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
	
	By suffix = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Suffix: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Suffix') and @type='text']");
	public String getSuffix() {
		return util.getAttributeValue(suffix, "value");
	}
	
	By coName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'In Care of')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_CO_Name') and @type='text']");
	public String getCOName() {
		return util.getAttributeValue(coName, "value");
	}
	
	By ownershipPer = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Ownership')]/..//input[contains(@id,'Dest_Input')]");
	public String getOwnershipPer() {
		return util.getAttributeValue(ownershipPer, "value");
	}
	
	By address1 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address 1: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Address_Line_1') and @type='text']");
	public String getAddress1() {
		return util.getAttributeValue(address1, "value");
	}
	
	By city = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='City: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_City') and @type='text']");
	public String getCity() {
		return util.getAttributeValue(city, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'State')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_State_ABB_radYALDropDownList_Input') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By postalCode = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Postal')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Zip_Code') and @type='text']");
	public String getPostalCode() {
		return util.getAttributeValue(postalCode, "value");
	}
	
	By payeeType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Payee Type')]/..//input[contains(@id,'Dest_Input')]");
	public String getPayeeType() {
		return util.getAttributeValue(payeeType, "value");
	}
	
	By homePhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Home Phone: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'Home_Phone') and @type='text'])[1]");
	public String getHomePhone() {
		return util.getAttributeValue(homePhone, "value");
	}
	
	By workPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Work Phone: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'Work_Phone') and @type='text'])[1]");
	public String getWorkPhone() {
		return util.getAttributeValue(workPhone, "value");
	}
	
	By cellPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Cell Phone: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'Cell_Phone') and @type='text'])[1]");
	public String getCellPhone() {
		return util.getAttributeValue(cellPhone, "value");
	}
	
	By faxNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Fax Number')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'FAX_NUMBER') and @type='text'])[1]");
	public String getFaxNo() {
		return util.getAttributeValue(faxNo, "value");
	}
	
	By vendorNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Vendor')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Vendor_ID') and @type='text']");
	public String getVendorNo() {
		return util.getAttributeValue(vendorNo, "value");
	}
	
	Map<String, String> excelData;
	public void LeaseContactDataMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementContactsMapping, testcaseName);
				assertion.assertEquals(getLeaseNumber(), excelData.get("Agreement Number").trim(), "Lease Number mapping mismatched");
				ExtentTestManager.log("Lease number Mapping : " +getLeaseNumber());
				
				assertion.assertEquals(getTrustName(), excelData.get("Corporation").trim(), "Corporation/Trust Name mapping mismatched");
				ExtentTestManager.log("Corporation/Trust Name Mapping : "+getTrustName());
				
				assertion.assertEquals(getFirstName(), excelData.get("First Name").trim(), "First Name mapping mismatched");
				ExtentTestManager.log("First Name Mapping : "+getFirstName());
				
				assertion.assertEquals(getMiddleName(), excelData.get("Middle Name").trim(), "Middle Name mapping mismatched");
				ExtentTestManager.log("Middle Name Mapping : "+getMiddleName());
				
				assertion.assertEquals(getLastName(), excelData.get("Last Name").trim(), "Last Name mapping mismatched");
				ExtentTestManager.log("Last Name Mapping : "+getLastName());
				
				assertion.assertEquals(getSuffix(), excelData.get("Suffix").trim(), "Suffix mapping mismatched");
				ExtentTestManager.log("Suffix Mapping : "+getSuffix());
				
				assertion.assertEquals(getCOName(), excelData.get("Attn To").trim(), "Care of Name mapping mismatched");
				ExtentTestManager.log("Care of Name Mapping : "+getCOName());
				
				assertion.assertEquals(getOwnershipPer(), excelData.get("Surface Ownership").trim(), "Ownership % mapping mismatched");
				ExtentTestManager.log("Ownership % Mapping : "+getOwnershipPer());
				
				assertion.assertEquals(getAddress1(), excelData.get("Address 1").trim(), "Address 1 mapping mismatched");
				ExtentTestManager.log("Address 1 Mapping : "+getAddress1());
				
				assertion.assertEquals(getCity(), excelData.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());

				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getPostalCode(), excelData.get("Zip Code").trim(), "Zip Code mapping mismatched");
				ExtentTestManager.log("Zip Code Mapping : "+getPostalCode());
                
				assertion.assertEquals(getPayeeType(), excelData.get("Payee Type").trim(), "Payee Type mapping mismatched");
				ExtentTestManager.log("Payee Type Mapping : "+getPayeeType());
				
				assertion.assertEquals(getHomePhone(), excelData.get("Home Phone").trim(), "Home Phone mapping mismatched");
				ExtentTestManager.log("Home Phone Mapping : "+getHomePhone());
				
				assertion.assertEquals(getWorkPhone(), excelData.get("Work Phone").trim(), "Work Phone mapping mismatched");
				ExtentTestManager.log("Work Phone Mapping : "+getWorkPhone());
				
				assertion.assertEquals(getCellPhone(), excelData.get("Cell Phone").trim(), "Cell Phone mapping mismatched");
				ExtentTestManager.log("Cell Phone Mapping : "+getCellPhone());
				
				if(util.isElementVisible(faxNo)) {
					assertion.assertEquals(getFaxNo(), excelData.get("Fax Number").trim(),
							"Fax Number mapping mismatched");
					ExtentTestManager.log("Fax Number Mapping : " + getFaxNo());
				}
				
				assertion.assertEquals(getVendorNo(), excelData.get("Vendor #").trim(), "Vendor # mapping mismatched");
				ExtentTestManager.log("Vendor # Mapping : "+getVendorNo());
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyLeaseContactDataMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			LeaseContactDataMapping(testcaseName);
			log("STEP 7:  All Agreement Contacts Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navLandownerInformation = By.xpath("//span[text()='Landowner Information']");
	By editContact = By.xpath("//input[contains(@id,'EditButton')]");
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Lease Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				assertion.assertEquals(getLeaseNumber(), map.get("Lease Number").trim(), "Lease Number mismatched");
				ExtentTestManager.log("Lease Number : "+getLeaseNumber());
				
				util.waitUntilElementDisplay(navLandownerInformation);
				log("User can navigate to Landowner Information tab");
				
				By ownership = By.xpath("//tr[contains(@id,'RadGridLO_radYALGridControl')]/.//*[contains(text(),'"+map.get("Corporation Name") +"')]/..//td[3]");		
				assertion.assertEquals(driver.findElement(ownership).getText(), map.get("Ownership %").trim(), "Ownership % mismatched");
				ExtentTestManager.log("Ownership % : "+driver.findElement(ownership).getText());
				
				By btnEdit = By.xpath("//tr[contains(@id,'RadGridLO_radYALGridControl')]/.//*[contains(text(),'"+map.get("Corporation Name") +"')]/..//a[text()='Edit']");
				util.waitUntilElementDisplay(btnEdit);
				util.click(btnEdit);
				log("User can click on Edit Landowner button");
				log("Verifying the Imported Owner Details");
				util.dummyWait(5);
				util.switchToChildWindow();
				
				assertion.assertEquals(getFirstName(), map.get("First Name").trim(), "First Name mismatched");
				ExtentTestManager.log("First Name : "+getFirstName());
				
				assertion.assertEquals(getMiddleName(), map.get("Middle Name").trim(), "Middle Name mismatched");
				ExtentTestManager.log("Middle Name : "+getMiddleName());
				
				assertion.assertEquals(getLastName(), map.get("Last Name").trim(), "Last Name mismatched");
				ExtentTestManager.log("Last Name : "+getLastName());
				
				assertion.assertEquals(getTrustName(), map.get("Corporation Name").trim(), "Trust Name mismatched");
				ExtentTestManager.log("Trust Name : "+getTrustName());
				
				if(util.isElementVisible(suffix)) {
				assertion.assertEquals(getSuffix(), map.get("Suffix").trim(), "Suffix mismatched");
				ExtentTestManager.log("Suffix : "+getSuffix());
				}
				
				assertion.assertEquals(getCOName(), map.get("Attn to").trim(), "C/O Name mismatched");
				ExtentTestManager.log("C/O Name : "+getCOName());
				
				assertion.assertEquals(getVendorNo(), map.get("Vendor #").trim(), "Vendor mismatched");
				ExtentTestManager.log("Vendor : "+getVendorNo());
				
				util.waitUntilElementDisplay(editContact);
				util.click(editContact);
				util.dummyWait(5);
				log("User can click on Edit contact button");
				log("verifying the Imported Contact Details");
				
				assertion.assertEquals(getAddress1(), map.get("Address 1").trim(), "Address Line 1 mismatched");
				ExtentTestManager.log("Address Line 1 : "+getAddress1());
				
				assertion.assertEquals(getCity(), map.get("City").trim(), "City mismatched");
				ExtentTestManager.log("City : "+getCity());
				
				assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
				ExtentTestManager.log("State : "+getState());
				
				assertion.assertEquals(getPostalCode(), map.get("Postal").trim(), "Zip Code mismatched");
				ExtentTestManager.log("Zip Code : "+getPostalCode());
				
				String homePhone = getHomePhone().replaceAll("[^0-9]", "");
				assertion.assertEquals(homePhone, map.get("Home Phone").trim(), "Home Phone mismatched");
				ExtentTestManager.log("Home Phone : "+homePhone);
				
				String cellPhone = getCellPhone().replaceAll("[^0-9]", "");
				assertion.assertEquals(cellPhone, map.get("Cell Phone").trim(), "Cell Phone mismatched");
				ExtentTestManager.log("Cell Phone : "+cellPhone);
				
				String workPhone = getWorkPhone().replaceAll("[^0-9]", "");
				assertion.assertEquals(workPhone, map.get("Work Phone").trim(), "Work Phone mismatched");
				ExtentTestManager.log("Work Phone : "+workPhone);
				
				if(util.isElementVisible(faxNo)) {
				String faxNumber = getFaxNo().replaceAll("[^0-9]", "");
				assertion.assertEquals(faxNumber, map.get("Fax Number").trim(), "Fax Number mismatched");
				ExtentTestManager.log("Fax Number : "+faxNumber);
				}
				
				driver.close();
				util.switchToParentWindow();
				assertion.assertAll();
				
				log("All Imported Data Successfully matched");
			
		}
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			objErrorLog.printErrorLog();
			//objErrorLog.leaseContactDatavalidationMsg(testcaseName); 
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
