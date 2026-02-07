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

public class ParcelContactImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public ParcelContactImportPage(WebDriver driver) {
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
	
	By title = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Title: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Title') and @type='text']");
	public String getTitle() {
		return util.getAttributeValue(title, "value");
	}
	
	By entityName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Entity Name: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Corporation_Trust') and @type='text']");
	public String getEntityName() {
		return util.getAttributeValue(entityName, "value");
	}
	
	By coName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'C/O Name: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_CO_Name') and @type='text']");
	public String getCOName() {
		return util.getAttributeValue(coName, "value");
	}
	
	By address1 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 1: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Address_Line_1') and @type='text']");
	public String getAddress1() {
		return util.getAttributeValue(address1, "value");
	}
	
	By address2 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 2: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Address_Line_2') and @type='text']");
	public String getAddress2() {
		return util.getAttributeValue(address2, "value");
	}
	
	By address3 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 3: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Address_Line_3') and @type='text']");
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
	
	By county = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County: ']/..//input[contains(@id,'Dest_Input')]");
	public String getCounty() {
		return util.getAttributeValue(county, "value");
	}
	
	By zip = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Zip: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Zip_Code') and @type='text']");
	public String getZip() {
		return util.getAttributeValue(zip, "value");
	}
	
	By zipPlus = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Zip Plus: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Zip_Code') and @type='text']");
	public String getZipPlus() {
		return util.getAttributeValue(zipPlus, "value");
	}

	By preferredContact = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Preferred Contact: ']/..//input[contains(@id,'Dest_Input')]");
	public String getPreferredContact() {
		return util.getAttributeValue(preferredContact, "value");
	}
	
	By workPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Work Phone: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Work_Phone_Footer') and @type='text']");
	public String getWorkPhone() {
		return util.getAttributeValue(workPhone, "value");
	}
	
	By workPhoneExt = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Work Phone Ext: ')]/..//input[contains(@id,'Dest_Input')] ");
	public String getWorkPhoneExt() {
		return util.getAttributeValue(workPhoneExt, "value");
	}
	
	By cellPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Cell Phone: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Cell_Phone_Footer') and @type='text']");
	public String getCellPhone() {
		return util.getAttributeValue(cellPhone, "value");
	}
	
	By homePhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Home Phone: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Home_Phone_Footer') and @type='text']");
	public String getHomePhone() {
		return util.getAttributeValue(homePhone, "value");
	}
	
	By faxPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Fax Number: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_Work_Phone_Footer') and @type='text']");
	public String getFaxPhone() {
		return util.getAttributeValue(faxPhone, "value");
	}
	
	By email = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Email: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_Email') and @type='text'])[1]");
	public String getEmail() {
		return util.getAttributeValue(email, "value");
	}
	
	By comment = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Comment: ')]/..//input[contains(@id,'Dest_Input')] ");
	public String getComment() {
		return util.getAttributeValue(comment, "value");
	}
	
	By preferredPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Preferred Phone: ')]/..//input[contains(@id,'Dest_Input')] ");
	public String getPreferredPhone() {
		return util.getAttributeValue(preferredPhone, "value");
	}
	
	By Active = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Active: ')]/..//input[contains(@id,'Dest_Input')] ");
	public String getActive() {
		return util.getAttributeValue(Active, "value");
	}
	
	
	Map<String, String> excelData;
	public void parcelContactsMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.ParcelContactsMapping, testcaseName);
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
				
				assertion.assertEquals(getSuffix(), excelData.get("Suffix").trim(), "Suffix mapping mismatched");
				ExtentTestManager.log("Suffix Mapping : "+getSuffix());
				
				assertion.assertEquals(getTitle(), excelData.get("Title").trim(), "Title mapping mismatched");
				ExtentTestManager.log("Title Mapping : "+getTitle());
				
				assertion.assertEquals(getEntityName(), excelData.get("Entity Name").trim(), "Entity Name mapping mismatched");
				ExtentTestManager.log("Entity Name Mapping : "+getEntityName());
				
				assertion.assertEquals(getCOName(), excelData.get("CO Name").trim(), "CO Name mapping mismatched");
				ExtentTestManager.log("CO Name Mapping : "+getCOName());
				
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
				
				assertion.assertEquals(getCounty(), excelData.get("County").trim(), "County mapping mismatched");
				ExtentTestManager.log("County Mapping : "+getCounty());
				
				assertion.assertEquals(getZip(), excelData.get("Zip Code").trim(), "Zip Code mapping mismatched");
				ExtentTestManager.log("Zip Code Mapping : "+getZip());
				
				assertion.assertEquals(getZipPlus(), excelData.get("Zip Code Plus").trim(), "Zip Code Plus mapping mismatched");
				ExtentTestManager.log("Zip Code Plus Mapping : "+getZipPlus());
				
				assertion.assertEquals(getPreferredContact(), excelData.get("Preferred Contact").trim(), "Preferred Contact mapping mismatched");
				ExtentTestManager.log("Preferred Contact Mapping : "+getPreferredContact());
				
				assertion.assertEquals(getHomePhone(), excelData.get("Home Phone").trim(), "Home Phone mapping mismatched");
				ExtentTestManager.log("Home Phone Mapping : "+getHomePhone());
				
				assertion.assertEquals(getCellPhone(), excelData.get("Cell Phone").trim(), "Cell Phone mapping mismatched");
				ExtentTestManager.log("Cell Phone Mapping : "+getCellPhone());
				
				assertion.assertEquals(getFaxPhone(), excelData.get("Fax Phone").trim(), "Fax Phone mapping mismatched");
				ExtentTestManager.log("Fax Phone Mapping : "+getFaxPhone());
				
				assertion.assertEquals(getWorkPhone(), excelData.get("Work Phone").trim(), "Work Phone mapping mismatched");
				ExtentTestManager.log("Work Phone Mapping : "+getWorkPhone());
				
				assertion.assertEquals(getWorkPhoneExt(), excelData.get("Work Phone Ext").trim(), "Work Phone Ext mapping mismatched");
				ExtentTestManager.log("Work Phone  Ext Mapping : "+getWorkPhoneExt());
				
				assertion.assertEquals(getEmail(), excelData.get("Email").trim(), "Email mapping mismatched");
				ExtentTestManager.log("Email Mapping : "+getEmail());
				
				assertion.assertEquals(getComment(), excelData.get("Comment").trim(), "Comment mapping mismatched");
				ExtentTestManager.log("Comment Mapping : "+getComment());
				
				assertion.assertEquals(getPreferredPhone(), excelData.get("Preferred Phone").trim(), "Preferred Phone mapping mismatched");
				ExtentTestManager.log("Preferred Phone Mapping : "+getPreferredPhone());
				
				assertion.assertEquals(getActive(), excelData.get("Active").trim(), "Active mapping mismatched");
				ExtentTestManager.log("Active Mapping : "+getActive());
				
				
				assertion.assertAll();		
			
			}
	
	
	public void verifyParcelContactsMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			parcelContactsMapping(testcaseName);
			log("STEP 7:  All Parcel Owner Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navContactDetails = By.xpath("//span[text()='Contact Details']");
	By editContact = By.xpath("//input[contains(@id,'EditButton')]");
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Parcel #").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				assertion.assertEquals(getParcelNumber(), map.get("Parcel #").trim(), "Parcel number mismatched");
				ExtentTestManager.log("Parcel number matched : " +getParcelNumber());
				
				util.waitUntilElementDisplay(navContactDetails);
				util.click(navContactDetails);
				log("User can navigate to Contact Details Panel");
				
				By btnEdit = By.xpath("//tr[contains(@id,'CONTACT_radYALGridControl_ctl00')]/.//*[text()='"+map.get("Entity Name") +"']/..//a[contains(text(),'Edit')]");
				util.waitUntilElementDisplay(btnEdit);
				util.click(btnEdit);
				log("User can click on Edit Contact Details link");
				log("Verifying the Imported Contact Details");
				util.dummyWait(5);
				util.switchToChildWindow();
				
//				assertion.assertEquals(getContactType(), map.get("Contact Type").trim(), "Contact Type mismatched");
//				ExtentTestManager.log("Contact Type : "+getContactType());
				
				if(!testcaseName.contains("ORSTED")) {
				assertion.assertEquals(getLastName(), map.get("Last Name").trim(), "Last Name mismatched");
				ExtentTestManager.log("Last Name : "+getLastName());
				
				assertion.assertEquals(getFirstName(), map.get("First Name").trim(), "First Name mismatched");
				ExtentTestManager.log("First Name : "+getFirstName());
				
				assertion.assertEquals(getMiddleName(), map.get("Middle Name").trim(), "Middle Name mismatched");
				ExtentTestManager.log("Middle Name : "+getMiddleName());
				
				assertion.assertEquals(getTitle(), map.get("Title").trim(), "Title mismatched");
				ExtentTestManager.log("Title : "+getTitle());
				}
				
				assertion.assertEquals(getEntityName(), map.get("Entity Name").trim(), "Entity Name mismatched");
				ExtentTestManager.log("Entity Name matched : "+getEntityName());		
				
				if(!testcaseName.contains("ORSTED")) {
				assertion.assertEquals(getSuffix(), map.get("Suffix").trim(), "Suffix mismatched");
				ExtentTestManager.log("Suffix matched : "+getSuffix());
				}
				
				assertion.assertEquals(getCOName(), map.get("CO Name").trim(), "C/O Name mismatched");
				ExtentTestManager.log("C/O Name matched : "+getCOName());
				
				
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
				
				assertion.assertEquals(getZip(), map.get("Zip Code").trim(), "Zip Code mismatched");
				ExtentTestManager.log("Zip Code matched : "+getZip());
				
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
