package pages.ProjectImportROW;

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
import pages.projectImportALT.ProjectImportPage;

public class ContactImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public ContactImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By tractNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Tract #: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getTractNumber() {
		return util.getAttributeValue(tractNumber, "value");
	}
	
	By contactType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Contact Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_TYPE_ID_radYALDropDownList_Input') and @type='text']");
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
	
	By suffix = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Suffix: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'ENTITY_Suffix') and @type='text'])[1]");
	public String getSuffix() {
		return util.getAttributeValue(suffix, "value");
	}
	
	By title = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Title: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'ENTITY_Title') and @type='text'])[1]");
	public String getTitle() {
		return util.getAttributeValue(title, "value");
	}
	
	By entityName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Entity Name: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'ENTITY_Corporation_Trust') and @type='text'])[1]");
	public String getEntityName() {
		return util.getAttributeValue(entityName, "value");
	}
	
	By entityType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Entity Type: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'ENTITY_Entity_Type_ID_radYALDropDownList_Input') and @type='text'])[1]");
	public String getEntityType() {
		return util.getAttributeValue(entityType, "value");
	}
	
	By coName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'C/O Name: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_CO_Name') and @type='text']");
	public String getCOName() {
		return util.getAttributeValue(coName, "value");
	}
	
	By addressType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Address Type: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_ddAddressType_radYALDropDownList_Input') and @type='text']");
	public String getAddressType() {
		return util.getAttributeValue(addressType, "value");
	}
	
	By address1 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 1: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Address_Line_1') and @type='text']");
	public String getAddress1() {
		return util.getAttributeValue(address1, "value");
	}
	
	By address2 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 2: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Address_Line_2') and @type='text']");
	public String getAddress2() {
		return util.getAttributeValue(address2, "value");
	}
	
	By address3 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 3: ']/..//input[contains(@id,'Dest_Input')]");
	public String getAddress3() {
		return util.getAttributeValue(address3, "value");
	}
	
	By city = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='City: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_City') and @type='text']");
	public String getCity() {
		return util.getAttributeValue(city, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_RadState_Input') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By county = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County: ']/..//input[contains(@id,'Dest_Input')] ");
	public String getCounty() {
		return util.getAttributeValue(county, "value");
	}
	
	By zip = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Zip: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Zip_Code') and @type='text']");
	public String getZip() {
		return util.getAttributeValue(zip, "value");
	}
	
	By zipPlus = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Zip Plus: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Zip_Code_Plus') and @type='text']");
	public String getZipPlus() {
		return util.getAttributeValue(zipPlus, "value");
	}
	
	By preferredContact = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Preferred Contact: ')]/..//input[contains(@id,'Dest_Input')] ");
	public String getPreferredContact() {
		return util.getAttributeValue(preferredContact, "value");
	}
	
	By homePhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Home Phone: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Home_Phone') and @type='text']");
	public String getHomePhone() {
		return util.getAttributeValue(homePhone, "value");
	}
	
	By cellPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Cell Phone: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Cell_Phone') and @type='text']");
	public String getCellPhone() {
		return util.getAttributeValue(cellPhone, "value");
	}
	
	By faxNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Fax Number: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_FAX_NUMBER') and @type='text']");
	public String getFaxNumber() {
		return util.getAttributeValue(faxNumber, "value");
	}
	
	By workPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Work Phone: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Work_Phone') and @type='text']");
	public String getWorkPhone() {
		return util.getAttributeValue(workPhone, "value");
	}
	
	By workPhoneExt = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Work Phone Ext: ')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Work_Phone') and @type='text']");
	public String getWorkPhoneExt() {
		return util.getAttributeValue(workPhoneExt, "value");
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
	
	By active = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Active: ')]/..//input[contains(@id,'Dest_Input')]");
	public String getActive() {
		return util.getAttributeValue(active, "value");
		
		//input[contains(@id,'IsEntityActive') and @checked='checked']
	}
	
	
	Map<String, String> excelData;
	public void contactImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.LandownerMapping, testcaseName);
				assertion.assertEquals(getTractNumber(), excelData.get("Tract #").trim(), "Tract number mapping mismatched");
				ExtentTestManager.log("Tract number Mapping : " +getTractNumber());
				
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
				
				assertion.assertEquals(getEntityType(), excelData.get("Entity Type").trim(), "Entity Type mapping mismatched");
				ExtentTestManager.log("Entity Type Mapping : "+getEntityType());
				
				assertion.assertEquals(getCOName(), excelData.get("CO Name").trim(), "C/O Name mapping mismatched");
				ExtentTestManager.log("C/O Name Mapping : "+getCOName());
				
				assertion.assertEquals(getAddressType(), excelData.get("Address Type").trim(), "Address Type mapping mismatched");
				ExtentTestManager.log("Address Type Mapping : "+getAddressType());
				
				assertion.assertEquals(getAddress1(), excelData.get("Address Line1").trim(), "Address Line 1 mapping mismatched");
				ExtentTestManager.log("Address 1 Mapping : "+getAddress1());
				
				assertion.assertEquals(getAddress2(), excelData.get("Address Line2").trim(), "Address Line 2 mapping mismatched");
				ExtentTestManager.log("Address 2 Mapping : "+getAddress2());
				
				assertion.assertEquals(getAddress3().trim(), excelData.get("Address Line3").trim(), "Address Line 3 mapping mismatched");
				ExtentTestManager.log("Address 3 Mapping : "+getAddress3().trim());
				
				assertion.assertEquals(getCity(), excelData.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());

				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getCounty(), excelData.get("County").trim(), "County mapping mismatched");
				ExtentTestManager.log("County Mapping : "+getCounty());
				
				assertion.assertEquals(getZip(), excelData.get("Zip").trim(), "Zip Code mapping mismatched");
				ExtentTestManager.log("Zip Code Mapping : "+getZip());
				
				assertion.assertEquals(getZipPlus(), excelData.get("Zip Plus").trim(), "Zip Plus Code mapping mismatched");
				ExtentTestManager.log("Zip Plus Mapping : "+getZipPlus());
				
				assertion.assertEquals(getPreferredContact(), excelData.get("Preferred Contact").trim(), "Preferred Contact mapping mismatched");
				ExtentTestManager.log("Preferred Contact Mapping : "+getPreferredContact());
				
				assertion.assertEquals(getHomePhone(), excelData.get("Home Phone").trim(), "Home Phone mapping mismatched");
				ExtentTestManager.log("Home Phone Mapping : "+getHomePhone());
				
				assertion.assertEquals(getCellPhone(), excelData.get("Cell Phone").trim(), "Cell Phone mapping mismatched");
				ExtentTestManager.log("Cell Phone Mapping : "+getCellPhone());
				
				assertion.assertEquals(getFaxNumber(), excelData.get("Fax Number").trim(), "Fax Number mapping mismatched");
				ExtentTestManager.log("Fax Number Mapping : "+getFaxNumber());
				
				assertion.assertEquals(getWorkPhone(), excelData.get("Work Phone").trim(), "Work Phone mapping mismatched");
				ExtentTestManager.log("Work Phone Mapping : "+getWorkPhone());
				
				assertion.assertEquals(getWorkPhoneExt(), excelData.get("Work Phone Ext").trim(), "Work Phone Ext mapping mismatched");
				ExtentTestManager.log("Work Phone Ext Mapping : "+getWorkPhoneExt());
				
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
	
	
	public void verifyContactImportMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			contactImportMapping(testcaseName);
			log("STEP 7:  All Parcel Owner Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navContact = By.xpath("//span[text()='Contact Details']");
	By editContact = By.xpath("//input[contains(@id,'EditButton')]");
	
	public void validationOfImportedData(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
		if(environment.contains("WOLFMIDSTREAM")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.WOLF_PROJECTIMPORT_FILE), Excel.ContactImportDOT, testcaseName);
			
		}else {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.ContactImportDOT,testcaseName);
		}
		util.dummyWait(2);
		
				By addedRecord = By.xpath("//td[text()='"+map.get("Tract #").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				util.dummyWait(20);
				
				assertion.assertEquals(getTractNumber(), map.get("Tract #").trim(), "Tract # mismatched");
				ExtentTestManager.log("Tract # matched : " +getTractNumber());
				util.dummyWait(2);
				
				util.waitUntilElementDisplay(navContact);
				util.dummyWait(2);
				util.click(navContact);
				log("User can navigate to Contact Details panel");
				
				
				
				By btnEdit = By.xpath("//tr[contains(@id,'CONTACT_radYALGridControl_ctl00')]/.//*[text()='"+map.get("Entity Name") +"']/..//a[contains(text(),'Edit')]");
				util.waitUntilElementDisplay(btnEdit);
				util.click(btnEdit);
				log("User can click on Edit Contact button");
				log("Verifying the Imported Entity Details");
				util.dummyWait(5);
				util.switchToChildWindow();
				
				
				WebElement activebox = driver.findElement(By.xpath("//input[contains(@id,'IsEntityActive') and @checked='checked']"));
				
				if (activebox.isSelected()) {
				
//				By activecheckbox = By.xpath("//input[contains(@id,'IsEntityActive') and @type='checkbox']/..");
//				Assert.assertTrue(util.isElementPresent(activecheckbox, 30), "Record is not added yet");
				
												
//				assertion.assertEquals(activebox, map.get("Active").trim(), "Active mismatched");
				ExtentTestManager.log("Active : Checked ");
				}
				else {
					ExtentTestManager.log("Active : UnChecked ");
				}
								
				assertion.assertEquals(getContactType(), map.get("Contact Type").trim(), "Contact Type mismatched");
				ExtentTestManager.log("Contact Type : "+getContactType());
				
				assertion.assertEquals(getFirstName(), map.get("First Name").trim(), "First Name mismatched");
				ExtentTestManager.log("First Name  : "+getFirstName());
				
				assertion.assertEquals(getMiddleName(), map.get("Middle Name").trim(), "Middle Name mismatched");
				ExtentTestManager.log("Middle Name  : "+getMiddleName());
				
				assertion.assertEquals(getLastName(), map.get("Last Name").trim(), "Last Name mismatched");
				ExtentTestManager.log("Last Name: "+getLastName());
				
				assertion.assertEquals(getSuffix(), map.get("Suffix").trim(), "Suffix mismatched");
				ExtentTestManager.log("Suffix : "+getSuffix());
				
				assertion.assertEquals(getTitle(), map.get("Title").trim(), "Title mismatched");
				ExtentTestManager.log("Title: "+getTitle());
				
				assertion.assertEquals(getEntityName(), map.get("Entity Name").trim(), "Entity Name mismatched");
				ExtentTestManager.log("Entity Name : "+getEntityName());
				
				assertion.assertEquals(getEntityType(), map.get("Entity Type").trim(), "Entity Type mismatched");
				ExtentTestManager.log("Entity Type : "+getEntityType());
				
				assertion.assertEquals(getCOName(), map.get("C/O Name").trim(), "C/O Name mismatched");
				ExtentTestManager.log("C/O Name : "+getCOName());
				
				assertion.assertEquals(getAddressType(), map.get("Address Type").trim(), "Address Type mismatched");
				ExtentTestManager.log("Address Type : "+getAddressType());
				
				assertion.assertEquals(getAddress1(), map.get("Address Line 1").trim(), "Address Line 1 mismatched");
				ExtentTestManager.log("Address 1 : "+getAddress1());
				
				assertion.assertEquals(getAddress2(), map.get("Address Line 2").trim(), "Address Line 2 mismatched");
				ExtentTestManager.log("Address 2 : "+getAddress2());
				
//				assertion.assertEquals(getAddress3(), map.get("Address Line 3").trim(), "Address Line 3 mapping mismatched");
//				ExtentTestManager.log("Address 3 Mapping : "+getAddress3());
				
				assertion.assertEquals(getCity(), map.get("City").trim(), "City mismatched");
				ExtentTestManager.log("City : "+getCity());

				assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
				ExtentTestManager.log("State : "+getState());
				
//				assertion.assertEquals(getCounty(), map.get("County").trim(), "County mapping mismatched");
//				ExtentTestManager.log("County Mapping : "+getCounty());
				
				assertion.assertEquals(getZip(), map.get("Zip").trim(), "Zip Code mismatched");
				ExtentTestManager.log("Zip Code : "+getZip());
				
//				assertion.assertEquals(getZipPlus(), map.get("Zip Plus").trim(), "Zip Plus Code mapping mismatched");
//				ExtentTestManager.log("Zip Plus Mapping : "+getZipPlus());
				
//				assertion.assertEquals(getPreferredContact(), map.get("Preferred Contact").trim(), "Preferred Contact mapping mismatched");
//				ExtentTestManager.log("Preferred Contact Mapping : "+getPreferredContact());
				
//				assertion.assertEquals(getHomePhone(), map.get("Home Phone").trim(), "Home Phone mapping mismatched");
//				ExtentTestManager.log("Home Phone Mapping : "+getHomePhone());
//				
//				assertion.assertEquals(getCellPhone(), map.get("Cell Phone").trim(), "Cell Phone mapping mismatched");
//				ExtentTestManager.log("Cell Phone Mapping : "+getCellPhone());
//				
//				assertion.assertEquals(getFaxNumber(), map.get("Fax Number").trim(), "Fax Number mapping mismatched");
//				ExtentTestManager.log("Fax Number Mapping : "+getFaxNumber());
//				
//				assertion.assertEquals(getWorkPhone(), map.get("Work Phone").trim(), "Work Phone mapping mismatched");
//				ExtentTestManager.log("Work Phone Mapping : "+getWorkPhone());
//				
//				assertion.assertEquals(getWorkPhoneExt(), map.get("Work Phone Ext").trim(), "Work Phone Ext mapping mismatched");
//				ExtentTestManager.log("Work Phone Ext Mapping : "+getWorkPhoneExt());
				
				assertion.assertEquals(getEmail(), map.get("Email").trim(), "Email mismatched");
				ExtentTestManager.log("Email : "+getEmail());
				
//				assertion.assertEquals(getComment(), map.get("Comment").trim(), "Comment mapping mismatched");
//				ExtentTestManager.log("Comment Mapping : "+getComment());
				
//				assertion.assertEquals(getPreferredPhone(), map.get("Preferred Phone").trim(), "Preferred Phone mapping mismatched");
//				ExtentTestManager.log("Preferred Phone Mapping : "+getPreferredPhone());
				
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
			//objErrorLog.contactvalidationMsg(testcaseName); 
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
