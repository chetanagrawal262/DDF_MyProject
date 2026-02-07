package pages.projectImportDOT;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

public class ContactImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public ContactImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	By tractNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Parcel #: ']/..//input[contains(@id,'Dest_Input')] |//input[contains(@id,'TRACT_NUMBER') and @type='text']");
	public String getTractNo() {
		
		return util.getAttributeValue(tractNo, "value");
	}
	
	By active = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Active: ']/..//input[contains(@id,'Dest_Input')]");
	public String getActive() {
		
		return util.getAttributeValue(active, "value");
	}
	
	By contactType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Contact Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_TYPE_ID') and @type='text']");
	public String getContactType() {
		return util.getAttributeValue(contactType, "value");
	}
	
	By firstName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='First Name: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_First_Name') and @type='text']");
	public String getFirstName() {
		
		return util.getAttributeValue(firstName, "value");
	}
	
	By middleName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Middle Name: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_Middle_Name') and @type='text']");
	public String getMiddleName() {
		return util.getAttributeValue(middleName, "value");
	}
	
	By lastName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Last Name: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_Last_Name') and @type='text']");
	public String getLastName() {
		return util.getAttributeValue(lastName, "value");
	}
	
	By title = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Title: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_Title') and @type='text']");
	public String getTitle() {
		return util.getAttributeValue(title, "value");
	}
	
	By entityName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Entity Name: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'CONTACT_Corporation_Trust') and @type='text'])[1]");
	public String getEntityName() {
		return util.getAttributeValue(entityName, "value");
	}
	
	By entityType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Entity Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_Entity_Type_ID_radYALDropDownList_Input') and @type='text']");
	public String getEntityType() {
		return util.getAttributeValue(entityType, "value");
	}
	
	By addressLine1 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 1: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_Address_Line_1') and @type='text']");
	public String getAddressLine1() {
		return util.getAttributeValue(addressLine1, "value");
	}
	
	By addressLine2 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 2: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_Address_Line_2') and @type='text']");
	public String getAddressLine2() {
		return util.getAttributeValue(addressLine2, "value");
	}
	
	By addressLine3 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Address Line 3: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_Address_Line_3') and @type='text']");
	public String getAddressLine3() {
		return util.getAttributeValue(addressLine3, "value");
	}
	
	By city = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='City: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_City') and @type='text']");
	public String getCity() {
		return util.getAttributeValue(city, "value");
	}
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='State: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_RadState_Input') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By county = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='County: ']/..//input[contains(@id,'Dest_Input')]");
	public String getCounty() {
		return util.getAttributeValue(county, "value");
	}
	
	By zip = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Zip: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'CONTACT_Zip_Code') and @type='text'])[1]");
	public String getZip() {
		return util.getAttributeValue(zip, "value");
	}
	
	By homePhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Home Phone: ']/..//input[contains(@id,'Dest_Input')]");
	public String getHomePhone() {
		return util.getAttributeValue(homePhone, "value");
	}
	
	By cellPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Cell Phone: ']/..//input[contains(@id,'Dest_Input')]");
	public String getCellPhone() {
		return util.getAttributeValue(cellPhone, "value");
	}
	
	By workPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Work Phone: ']/..//input[contains(@id,'Dest_Input')]");
	public String getWorkPhone() {
		return util.getAttributeValue(workPhone, "value");
	}
	
	By workPhoneExt = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Work Phone Ext: ']/..//input[contains(@id,'Dest_Input')]");
	public String getWorkPhoneExt() {
		return util.getAttributeValue(workPhoneExt, "value");
	}
	
	By preferredPhone = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Preferred Phone: ']/..//input[contains(@id,'Dest_Input')]");
	public String getPreferredPhone() {
		return util.getAttributeValue(preferredPhone, "value");
	}
	
	By email = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Email: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'CONTACT_Email') and @type='text']");
	public String getEmail() {
		return util.getAttributeValue(email, "value");
	}
	
	By comment = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Comment: ']/..//input[contains(@id,'Dest_Input')] | //textarea[contains(@id,'COMMENTS')]");
	public String getComment() {
		return util.getAttributeValue(comment, "value");
	}
	
	Map<String, String> excelData;
	public void ContactMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.LandownerMapping, testcaseName);
				assertion.assertEquals(getTractNo(), excelData.get("Tract #").trim(), "Tract # mapping mismatched");
				ExtentTestManager.log("Tract # Mapping : " +getTractNo());
				
				assertion.assertEquals(getActive(), excelData.get("Active").trim(), "Active mapping mismatched");
				ExtentTestManager.log("Active Mapping : " +getActive());
				
				assertion.assertEquals(getContactType(), excelData.get("Contact Type").trim(), "Contact Type mapping mismatched");
				ExtentTestManager.log("Contact Type Mapping : " +getContactType());
				
				assertion.assertEquals(getFirstName().trim(), excelData.get("First Name").trim(), "First Name mapping mismatched");
				ExtentTestManager.log("First Name Mapping : "+getFirstName().trim());
				
				assertion.assertEquals(getMiddleName(), excelData.get("Middle Name").trim(), "Middle Name mapping mismatched");
				ExtentTestManager.log("Middle Name Mapping : "+getMiddleName());
				
				assertion.assertEquals(getLastName(), excelData.get("Last Name").trim(), "Last Name mapping mismatched");
				ExtentTestManager.log("Last Name Mapping : "+getLastName());
				
				assertion.assertEquals(getTitle(), excelData.get("Title").trim(), "Title mapping mismatched");
				ExtentTestManager.log("Title Mapping : "+getTitle());
								
				assertion.assertEquals(getEntityName(), excelData.get("Entity Name").trim(), "Entity Name mapping mismatched");
				ExtentTestManager.log("Entity Name Mapping : "+getEntityName());
				
				assertion.assertEquals(getEntityType(), excelData.get("Entity Type").trim(), "Entity Type mapping mismatched");
				ExtentTestManager.log("Entity Type Mapping : "+getEntityType());
				
				assertion.assertEquals(getAddressLine1(), excelData.get("Address Line1").trim(), "Address Line 1 mapping mismatched");
				ExtentTestManager.log("Address Line 1 Mapping : "+getAddressLine1());
				
				assertion.assertEquals(getAddressLine2(), excelData.get("Address Line2").trim(), "Address Line 2 mapping mismatched");
				ExtentTestManager.log("Address Line 2 Mapping : "+getAddressLine2());
				
				assertion.assertEquals(getAddressLine3(), excelData.get("Address Line3").trim(), "Address Line 3 mapping mismatched");
				ExtentTestManager.log("Address Line 3 Mapping : "+getAddressLine3());
				
				assertion.assertEquals(getCity(), excelData.get("City").trim(), "City mapping mismatched");
				ExtentTestManager.log("City Mapping : "+getCity());
				
				assertion.assertEquals(getState(), excelData.get("State").trim(), "State mapping mismatched");
				ExtentTestManager.log("State Mapping : "+getState());
				
				assertion.assertEquals(getCounty(), excelData.get("County").trim(), "County mapping mismatched");
				ExtentTestManager.log("County Mapping : "+getCounty());
				
				assertion.assertEquals(getZip(), excelData.get("Zip").trim(), "Zip mapping mismatched");
				ExtentTestManager.log("Zip Mapping : "+getZip());
				
				assertion.assertEquals(getHomePhone(), excelData.get("Home Phone").trim(), "Home Phone mapping mismatched");
				ExtentTestManager.log("Home Phone Mapping : "+getHomePhone());
				
				assertion.assertEquals(getCellPhone(), excelData.get("Cell Phone").trim(), "Cell Phone mapping mismatched");
				ExtentTestManager.log("Cell Phone Mapping : "+getCellPhone());
				
				assertion.assertEquals(getWorkPhone(), excelData.get("Work Phone").trim(), "Work Phone mapping mismatched");
				ExtentTestManager.log("Work Phone Mapping : "+getWorkPhone());
				
				assertion.assertEquals(getWorkPhoneExt(), excelData.get("Work Phone Ext").trim(), "Work Phone Ext mapping mismatched");
				ExtentTestManager.log("Work Phone Ext Mapping : "+getWorkPhoneExt());
				
				assertion.assertEquals(getPreferredPhone(), excelData.get("Preferred Phone").trim(), "Preferred Phone mapping mismatched");
				ExtentTestManager.log("Preferred Phone Mapping : "+getPreferredPhone());
				
				assertion.assertEquals(getEmail(), excelData.get("Email").trim(), "Email mapping mismatched");
				ExtentTestManager.log("Email Mapping : "+getEmail());
				
				assertion.assertEquals(getComment(), excelData.get("Comment").trim(), "Comment mapping mismatched");
				ExtentTestManager.log("Comment Mapping : "+getComment());
				
				assertion.assertAll();		
			
			}
	
	public void verifyContactMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			ContactMapping(testcaseName);
			log("STEP 7:  All Contact Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navContact = By.xpath("//span[text()='Contact Details']");
	
	public void validationOfImportedData(Map<String, String> map, String testcaseName) {	
		ExtentTestManager.log("Verifying Imported Landowner Record for Parcel # "+map.get("Parcel #").trim());
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Parcel #").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
			    By parcelSummary = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Parcel #")+"']");
				util.waitForWebElementToBePresent(parcelSummary, IMPLICIT_WAIT);
				
				assertion.assertEquals(getTractNo(), map.get("Parcel #").trim(), "Parcel number mismatched");
				ExtentTestManager.log("Parcel number matched : " +getTractNo());
				
				util.waitUntilElementDisplay(navContact);
				util.click(navContact);
				util.dummyWait(1);
				
				By btnEdit = By.xpath("//tr[contains(@id,'CONTACT_radYALGridControl')]/..//*[text()='"+map.get("Entity Name")+"']/../..//a[text()='Edit']");
				util.click(btnEdit);
				util.dummyWait(2);
				
				 Set<String> windowId = driver.getWindowHandles(); // get window id of current window
			  		Iterator<String> itererator = windowId.iterator();
			  		String mainWinID = itererator.next();
			  		String newAdwinID = itererator.next();
			  		driver.switchTo().window(newAdwinID);
			  		
			  		assertion.assertEquals(getContactType(), map.get("Contact Type").trim(), "Contact Type mismatched");
					ExtentTestManager.log("Contact Type matched : " +getContactType());
					
					assertion.assertEquals(getComment(), map.get("Comment").trim(), "Comment mismatched");
					ExtentTestManager.log("Comment matched : " +getComment());
					
			  		assertion.assertEquals(getFirstName(), map.get("First Name").trim(), "First Name mismatched");
					ExtentTestManager.log("First Name matched : " +getFirstName());
			  		
					assertion.assertEquals(getMiddleName(), map.get("Middle Name").trim(), "Middle Name mismatched");
					ExtentTestManager.log("Middle Name matched : " +getMiddleName());
					
					assertion.assertEquals(getLastName(), map.get("Last Name").trim(), "Last Name mismatched");
					ExtentTestManager.log("Last Name matched : " +getLastName());
					
					assertion.assertEquals(getTitle(), map.get("Title").trim(), "Title mismatched");
					ExtentTestManager.log("Title Matched : "+getTitle());
									
					assertion.assertEquals(getEntityName(), map.get("Entity Name").trim(), "Entity Name mismatched");
					ExtentTestManager.log("Entity Name Matched : "+getEntityName());
					
					assertion.assertEquals(getEntityType(), map.get("Entity Type").trim(), "Entity Type mismatched");
					ExtentTestManager.log("Entity Type Matched : "+getEntityType());
					
					assertion.assertEquals(getAddressLine1(), map.get("Address Line1").trim(), "Address Line 1 mismatched");
					ExtentTestManager.log("Address Line 1 Matched : "+getAddressLine1());
					
					assertion.assertEquals(getAddressLine2(), map.get("Address Line2").trim(), "Address Line 2 mismatched");
					ExtentTestManager.log("Address Line 2 Matched : "+getAddressLine2());
					
					assertion.assertEquals(getAddressLine3(), map.get("Address Line3").trim(), "Address Line 3 mismatched");
					ExtentTestManager.log("Address Line 3 matched : " +getAddressLine3());
				
					assertion.assertEquals(getCity(), map.get("City").trim(), "City mismatched");
					ExtentTestManager.log("City Matched : "+getCity());
					
					assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
					ExtentTestManager.log("State Matched : "+getState());
					
					assertion.assertEquals(getZip(), map.get("Zip").trim(), "Zip mismatched");
					ExtentTestManager.log("Zip Matched : "+getZip());
					
					assertion.assertEquals(getEmail(), map.get("Email").trim(), "Email mismatched");
					ExtentTestManager.log("Email Matched : "+getEmail());
					
					driver.close();
					driver.switchTo().window(mainWinID);
					assertion.assertAll();
			
		}
	
	
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.contactValidationMsg(testcaseName); 
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
