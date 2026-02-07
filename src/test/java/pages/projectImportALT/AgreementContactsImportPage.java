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

public class AgreementContactsImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	
	public AgreementContactsImportPage(WebDriver driver) {
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
	
	By suffix = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Suffix')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'ENTITY_Suffix') and @type='text'])[1]");
	public String getSuffix() {
		return util.getAttributeValue(suffix, "value");
	}
	
	By EntityName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Entity Name: ')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'ENTITY_Corporation_Trust') and @type='text'])[1]");
	public String getEntityName() {
		return util.getAttributeValue(EntityName, "value");
	}
	
	By coName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'In Care of')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_CO_Name') and @type='text']");
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
	
	By state = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'State')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_State_ABB_radYALDropDownList_Input') and @type='text']");
	public String getState() {
		return util.getAttributeValue(state, "value");
	}
	
	By postalCode = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Postal')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'_EditFormControl_Zip_Code') and @type='text']");
	public String getPostalCode() {
		return util.getAttributeValue(postalCode, "value");
	}
	
	By contactName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Contact Name')]/..//input[contains(@id,'Dest_Input')]");
	public String getContactName() {
		return util.getAttributeValue(contactName, "value");
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
	
	By faxNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Fax Number')]/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'_Email') and @type='text'])[1]");
	public String getFaxNo() {
		return util.getAttributeValue(faxNo, "value");
	}
	
	By surfaceOwnership = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Surface Ownership')]/..//input[contains(@id,'Dest_Input')] | //tr[contains(@id,'RadGridLO_radYALGridControl_ctl00__0') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO_ctl00__0')]/td[4]");
	public String getSurfaceOwnership() {
		return util.getAttributeValue(surfaceOwnership, "value");
	}
	
	By windOwnership = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Wind Ownership')]/..//input[contains(@id,'Dest_Input')] | //tr[contains(@id,'RadGridLO_radYALGridControl_ctl00__0') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO_ctl00__0')]/td[5]");
	public String getWindOwnership() {
		return util.getAttributeValue(windOwnership, "value");
	}
	
	By cropOwnership = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Crop Ownership')]/..//input[contains(@id,'Dest_Input')] | //tr[contains(@id,'RadGridLO_radYALGridControl_ctl00__0') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO_ctl00__0')]/td[6]");
	public String getCropOwnership() {
		return util.getAttributeValue(cropOwnership, "value");
	}
	
	By paymentShare = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Payment Share')]/..//input[contains(@id,'Dest_Input')] | //*[text()='Ownership Share:']/..//input[@type='text']");
	public String getPaymentShare() {
		return util.getAttributeValue(paymentShare, "value");
	}
	
	By vendorNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'Vendor')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_Vendor_ID') and @type='text']");
	public String getVendorNo() {
		return util.getAttributeValue(vendorNo, "value");
	}
	
	By w9 = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and contains(text(),'W9')]/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'ENTITY_W9') and @type='text']");
	public String getW9() {
		return util.getAttributeValue(w9, "value");
	}
	
	Map<String, String> excelData;
	public void agreementContactsMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgreementContactsMapping, testcaseName);
				assertion.assertEquals(getAgreementNumber(), excelData.get("Agreement Number").trim(), "Agreement Number mapping mismatched");
				ExtentTestManager.log("Agreement number Mapping : " +getAgreementNumber());
				
				assertion.assertEquals(getFirstName(), excelData.get("First Name").trim(), "First Name mapping mismatched");
				ExtentTestManager.log("First Name Mapping : "+getFirstName());
				
				assertion.assertEquals(getMiddleName(), excelData.get("Middle Name").trim(), "Middle Name mapping mismatched");
				ExtentTestManager.log("Middle Name Mapping : "+getMiddleName());
				
				assertion.assertEquals(getLastName(), excelData.get("Last Name").trim(), "Last Name mapping mismatched");
				ExtentTestManager.log("Last Name Mapping : "+getLastName());
				
				if(util.isElementVisible(suffix)) {
				assertion.assertEquals(getSuffix(), excelData.get("Suffix").trim(), "Suffix mapping mismatched");
				ExtentTestManager.log("Suffix Mapping : "+getSuffix());
				}
				
				assertion.assertEquals(getEntityName(), excelData.get("Corporation").trim(), "Corp/Trust/Entity Name mapping mismatched");
				ExtentTestManager.log("Corp/Trust/Entity Name Mapping : "+getEntityName());
				
				assertion.assertEquals(getCOName(), excelData.get("Attn To").trim(), "Care of Name mapping mismatched");
				ExtentTestManager.log("Care of Name Mapping : "+getCOName());
				
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

				if(util.isElementVisible(contactName)) {
				assertion.assertEquals(getContactName(), excelData.get("Contact Name").trim(), "Contact Name mapping mismatched");
				ExtentTestManager.log("Contact Name Mapping : "+getContactName());
				}
				
				assertion.assertEquals(getHomePhone(), excelData.get("Home Phone").trim(), "Home Phone mapping mismatched");
				ExtentTestManager.log("Home Phone Mapping : "+getHomePhone());
				
				assertion.assertEquals(getWorkPhone(), excelData.get("Work Phone").trim(), "Work Phone mapping mismatched");
				ExtentTestManager.log("Work Phone Mapping : "+getWorkPhone());
				
				assertion.assertEquals(getCellPhone(), excelData.get("Cell Phone").trim(), "Cell Phone mapping mismatched");
				ExtentTestManager.log("Cell Phone Mapping : "+getCellPhone());
				
				assertion.assertEquals(getEmail(), excelData.get("Email").trim(), "Email mapping mismatched");
				ExtentTestManager.log("Email Mapping : "+getEmail());
				
				if(util.isElementVisible(faxNo)) {
				assertion.assertEquals(getFaxNo(), excelData.get("Fax Number").trim(), "Fax Number mapping mismatched");
				ExtentTestManager.log("Fax Number Mapping : "+getFaxNo());
				}
				
				assertion.assertEquals(getSurfaceOwnership(), excelData.get("Surface Ownership").trim(), "Surface Ownership mapping mismatched");
				ExtentTestManager.log("Surface Ownership Mapping : "+getSurfaceOwnership());
				
				assertion.assertEquals(getWindOwnership(), excelData.get("Wind Ownership").trim(), "Wind Ownership mapping mismatched");
				ExtentTestManager.log("Wind Ownership Mapping : "+getWindOwnership());
				
				assertion.assertEquals(getCropOwnership(), excelData.get("Crop Ownership").trim(), "Crop Ownership mapping mismatched");
				ExtentTestManager.log("Crop Ownership Mapping : "+getCropOwnership());
				
				if(util.isElementVisible(paymentShare)) {
				assertion.assertEquals(getPaymentShare(), excelData.get("Payment Share").trim(), "Payment Share mapping mismatched");
				ExtentTestManager.log("Payment Share Mapping : "+getPaymentShare());
				}
				
				if(util.isElementVisible(vendorNo)) {
				assertion.assertEquals(getVendorNo(), excelData.get("Vendor #").trim(), "Vendor # mapping mismatched");
				ExtentTestManager.log("Vendor # Mapping : "+getVendorNo());
				}
				
				if(util.isElementVisible(w9)) {
					assertion.assertEquals(getW9(), excelData.get("W9").trim(), "W9 mapping mismatched");
					ExtentTestManager.log("W9 Mapping : "+getW9());
					}
				assertion.assertAll();		
			
			}
	
	
	public void verifyAgreementContactsMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			agreementContactsMapping(testcaseName);
			log("STEP 7:  All Agreement Contacts Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By navLandownerInformation = By.xpath("//span[text()='Landowner Information']");
	By editContact = By.xpath("//input[contains(@id,'EditButton')]");
	
	By editOwnershipButton = By.xpath("//img[@alt='Edit Ownership'] | //input[contains(@id,'btnEditPayStatus')]");
	private void clickOnEditOwnershipButton() {
		util.click(editOwnershipButton);
		util.dummyWait(1);
	}
	
	By editLandOwnerIframe = By.xpath("//iframe[@name = 'LOOwnership']");
	private void switchToEditLandOwnerIframe() {
		util.waitForWebElementToBePresent(editLandOwnerIframe, IMPLICIT_WAIT);
		util.switchToIframe(editLandOwnerIframe);
	}
	
	By surfacePercentage = By.xpath("//input[contains(@id,'Surface_Ownership_All_Tracts') and @type='text']");
	By windPercentage = By.xpath("//input[contains(@id,'Wind_Ownership_All_Tracts') and @type='text']");
	By cropPercentage = By.xpath("//input[contains(@id,'Crop_Ownership_All_Tracts') and @type='text']");
	By ownershipPercentage = By.xpath("//input[contains(@id,'Ownership_Share_All_Tracts') and @type='text']");
	
	By closeLandOwnershipForm = By.xpath("//div[contains(@id,'LOOwnership')]//a[@title='Close']");
	private void closeLandOwnershipIframe() {
		util.switchToDefaultContent();
		util.click(closeLandOwnershipForm);
		util.waitFor(1000);
	}
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Agreement Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				assertion.assertEquals(getAgreementNumber(), map.get("Agreement Number").trim(), "Agreement Number mismatched");
				ExtentTestManager.log("Agreement Number : "+getAgreementNumber());
				
				util.waitUntilElementDisplay(navLandownerInformation);
				log("User can navigate to Landowner Information tab");
				
//				if(testcaseName.contains("ATWELL")) {
//				By surfOwnership = By.xpath("//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/..//*[normalize-space()='"+map.get("First Name").trim()+" "+map.get("Middle Name").trim()+" "+map.get("Last Name").trim()+"']/../..//td[4]");
//				assertion.assertTrue(driver.findElement(surfOwnership).getText().contains(map.get("Surface Ownership %").trim()), "Surface Ownership mismatched");
//				ExtentTestManager.log("Surface Ownership : "+driver.findElement(surfOwnership).getText());
//				
//				By windOwner = By.xpath("//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/..//*[normalize-space()='"+map.get("First Name").trim()+" "+map.get("Middle Name").trim()+" "+map.get("Last Name").trim()+"']/../..//td[5]");
//				assertion.assertTrue(driver.findElement(windOwner).getText().contains(map.get("Wind Ownership %").trim()), "Wind Ownership mismatched");
//				ExtentTestManager.log("Wind Ownership : "+driver.findElement(windOwner).getText());
//				
//				By cropOwner = By.xpath("//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/..//*[normalize-space()='"+map.get("First Name").trim()+" "+map.get("Middle Name").trim()+" "+map.get("Last Name").trim()+"']/../..//td[6]");
//				assertion.assertTrue(driver.findElement(cropOwner).getText().contains(map.get("Crop Ownership %").trim()), "Crop Ownership mismatched");
//				ExtentTestManager.log("Crop Ownership : "+driver.findElement(cropOwner).getText());
//	
//				By btnEdit = By.xpath("//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/.//*[contains(text(),'"+map.get("First Name").trim()+" "+map.get("Middle Name").trim()+" "+map.get("Last Name").trim() +"')]/..//a[text()='Edit'] | //tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/.//*[contains(text(),'"+map.get("Entity Name") +"')]/..//a[text()='Edit']");
//				util.waitUntilElementDisplay(btnEdit);
//				util.click(btnEdit);
//				}else {
					 By surfOwnership = By.xpath("(//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/../..//td[count(//table/thead/tr/th[contains(.,'Surface')]/preceding-sibling::th)+1])[1]");
				    assertion.assertTrue(driver.findElement(surfOwnership).getText().contains(map.get("Surface Ownership %").trim()), "Surface Ownership mismatched");
					ExtentTestManager.log("Surface Ownership : "+driver.findElement(surfOwnership).getText());
					
					if(environment.contains("TREATYOAK")) {
						By windOwner = By.xpath("(//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/../..//td[count(//table/thead/tr/th[contains(.,'Tax')]/preceding-sibling::th)+1])[1]");
						assertion.assertTrue(driver.findElement(windOwner).getText().contains(map.get("Wind Ownership %").trim()), "Wind Ownership mismatched");
						ExtentTestManager.log("Wind Ownership : "+driver.findElement(windOwner).getText());
					}else {
					By windOwner = By.xpath("(//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/../..//td[count(//table/thead/tr/th[contains(.,'Wind')]/preceding-sibling::th)+1])[1]");
					assertion.assertTrue(driver.findElement(windOwner).getText().contains(map.get("Wind Ownership %").trim()), "Wind Ownership mismatched");
					ExtentTestManager.log("Wind Ownership : "+driver.findElement(windOwner).getText());
					
					}
					By cropOwner = By.xpath("(//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/../..//td[count(//table/thead/tr/th[contains(.,'Crop')]/preceding-sibling::th)+1])[1]");
					assertion.assertTrue(driver.findElement(cropOwner).getText().contains(map.get("Crop Ownership %").trim()), "Crop Ownership mismatched");
					ExtentTestManager.log("Crop Ownership : "+driver.findElement(cropOwner).getText());
					
					By paymentShare = By.xpath("(//table[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/../..//td[count(//table/thead/tr/th[contains(.,'Payment ') or contains(.,'Ownership')]/preceding-sibling::th)])[1]");
					if(util.isElementVisible(paymentShare)) {
					assertion.assertTrue(driver.findElement(paymentShare).getText().contains(map.get("Payment Share").trim()), "Payment Share mismatched");
					ExtentTestManager.log("Payment Share : "+driver.findElement(paymentShare).getText());
					}
		
					By primaryAddressMissing = By.xpath("(//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/.//b[text()='Primary Address Missing'])[1]");
					assertion.assertFalse(util.isElementVisible(primaryAddressMissing), "Primary Address is not displaying in the Payee Summary on the grid");
					
					By add1 = By.xpath("(//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//strong[text()='"+map.get("Address 1").trim()+"'])[1]");
					assertion.assertTrue(util.isElementVisible(add1), "Address Line 1 is not displaying in the Payee Summary on the grid");
					
					By add2 = By.xpath("(//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//strong[text()='"+map.get("Address 2").trim()+"'])[1]");
					assertion.assertTrue(util.isElementVisible(add2), "Address Line 2 is not displaying in the Payee Summary on the grid");
					
					By add3 = By.xpath("(//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/../..//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//strong[text()='"+map.get("Address 3").trim()+"'])[1]");
					assertion.assertTrue(util.isElementVisible(add3), "Address Line 3 is not displaying in the Payee Summary on the grid");
					
					ExtentTestManager.log("Primary Address is displaying on the grid");
					
					clickOnEditOwnershipButton();
					switchToEditLandOwnerIframe();
					
					By surfPer = By.xpath("//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//input[contains(@id,'Surface_Ownership_All_Tracts') and @type='text']");
					assertion.assertTrue(util.getAttributeValue(surfPer, "value").contains(map.get("Surface Ownership %").trim()), "Surface Ownership mismatched on Ownership Popup");
					
					By windPer = By.xpath("//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//input[contains(@id,'Wind_Ownership_All_Tracts') and @type='text']");
					assertion.assertTrue(util.getAttributeValue(windPer, "value").contains(map.get("Wind Ownership %").trim()), "Wind Ownership mismatched  on Ownership Popup");
					
					By cropPer = By.xpath("//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//input[contains(@id,'Crop_Ownership_All_Tracts') and @type='text']");
					assertion.assertTrue(util.getAttributeValue(cropPer, "value").contains(map.get("Crop Ownership %").trim()), "Crop Ownership mismatched on Ownership Popup");
					
					By ownPer = By.xpath("//*[contains(text(),'"+map.get("Entity Name").trim()+"')]/..//input[contains(@id,'Ownership_Share_All_Tracts') and @type='text']");
					if(util.isElementVisible(ownPer)) {
					assertion.assertTrue(util.getAttributeValue(ownPer, "value").contains(map.get("Payment Share").trim()), "Payment Share mismatched on Ownership Popup");
					}
					
					ExtentTestManager.infoWithScreenshot("Ownership Popup");
					closeLandOwnershipIframe();
					
					By btnEdit = By.xpath("//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/.//*[contains(text(),'"+map.get("Entity Name").trim() +"')]/..//a[text()='Edit']");
					util.waitUntilElementDisplay(btnEdit);
					util.click(btnEdit);
//				}
				log("User can click on Edit Landowner button");
				log("Verifying the Imported Owner Details");
				util.dummyWait(5);
				util.switchToChildWindow();
				
				if(!testcaseName.contains("ORSTED")) {
				assertion.assertEquals(getFirstName(), map.get("First Name").trim(), "First Name mismatched");
				ExtentTestManager.log("First Name : "+getFirstName());
				
				assertion.assertEquals(getMiddleName(), map.get("Middle Name").trim(), "Middle Name mismatched");
				ExtentTestManager.log("Middle Name : "+getMiddleName());
				
				assertion.assertEquals(getLastName(), map.get("Last Name").trim(), "Last Name mismatched");
				ExtentTestManager.log("Last Name : "+getLastName());
				}
				
				assertion.assertEquals(getEntityName().trim(), map.get("Entity Name").trim(), "Entity Name mismatched");
				ExtentTestManager.log("Entity Name matched : "+getEntityName());
				
				if(testcaseName.contains("CONNECTGEN")) {
					assertion.assertEquals(getSuffix(), map.get("Suffix").trim(), "Suffix mismatched");
					ExtentTestManager.log("Suffix matched : "+getSuffix());
					}
				
				assertion.assertEquals(getCOName(), map.get("Attn To").trim(), "C/O Name mismatched");
				ExtentTestManager.log("C/O Name matched : "+getCOName());
				
				if(!testcaseName.contains("NOVA")) {
				assertion.assertEquals(getVendorNo(), map.get("Vendor #").trim(), "Vendor mismatched");
				ExtentTestManager.log("Vendor matched : "+getVendorNo());
				}
				
				if(environment.contains("RAMACO")) {
					assertion.assertEquals(getW9(), map.get("W9").trim(), "W9 Flag mismatched");
					ExtentTestManager.log("W9 Flag matched : "+getW9());
					}
				
				if(util.isElementVisible(paymentShare)){
				assertion.assertTrue(getPaymentShare().contains(map.get("Payment Share").trim()), "Payment Share mismatched");
				ExtentTestManager.log("Ownership Share : "+getPaymentShare());
				}
				util.waitUntilElementDisplay(editContact);
				util.click(editContact);
				util.dummyWait(5);
				log("User can click on Edit contact button");
				log("verifying the Imported Contact Details");
				
				assertion.assertEquals(getAddress1(), map.get("Address 1").trim(), "Address Line 1 mismatched");
				ExtentTestManager.log("Address Line 1 matched : "+getAddress1());
				
				if (util.isElementVisible(address2)) {
					assertion.assertEquals(getAddress2(), map.get("Address 2").trim(), "Address Line 2 mismatched");
					ExtentTestManager.log("Address Line 2 matched : " + getAddress2());
				}

				if (util.isElementVisible(address3)) {
					assertion.assertEquals(getAddress3(), map.get("Address 3").trim(), "Address Line 3 mismatched");
					ExtentTestManager.log("Address Line 3 matched : " + getAddress3());
				}
				
				assertion.assertEquals(getCity(), map.get("City").trim(), "City mismatched");
				ExtentTestManager.log("City matched : "+getCity());
				
				assertion.assertEquals(getState(), map.get("State").trim(), "State mismatched");
				ExtentTestManager.log("State matched : "+getState());
				
				assertion.assertEquals(getPostalCode(), map.get("Zip").trim(), "Zip Code mismatched");
				ExtentTestManager.log("Zip Code matched : "+getPostalCode());
				
				assertion.assertEquals(getEmail(), map.get("Email").trim(), "Email mismatched");
				ExtentTestManager.log("Email matched : "+getEmail());
				
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
//			if(environment.contains("AVANTUS")) {
			objErrorLog.agreementContactsvalidationMsgOfAvantus(testcaseName); 
//			}
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
