package pages.Contact;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class AddaContactPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String ADD_1, ADD_2, CITY, STATE, ABBREVIATION, ZIP, ZIP_PLUS;

	public AddaContactPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectInformation = By.xpath("//span[contains(text(),'Project Information')]");
	By navContact = By.xpath("//span[contains(text(),'Contacts')] | //span[contains(text(),'Project Contacts')]");
	By btnAddNew = By.xpath("//img[@alt='Add New Landowner(s)']");
	By iframeAlt = By.xpath("//iframe[@name='ProjDashAddContact']");
	By iframe = By.xpath("//iframe[@name='AddContact']");
	By ActiveCheckBox = By.xpath("//input[@id='IsEntityActive']");
	By ActiveCheckboxDot = By.xpath("//input[@id='IsContactActive']");
	By txtComment = By.xpath("//textarea[@id='COMMENTS']");
	By txtFuturePayments = By.xpath("//textarea[@id='Contact_Future_Payments']");//dot
	By drpContactType = By.xpath("//input[contains(@id,'CONTACT_TYPE_ID_radYALDropDownList_Input') and @type='text']");
	By txtLastName = By.xpath("//input[contains(@id,'_Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'_First_Name') and @type='text']");
	By txtMiddleName = By.xpath("//input[contains(@id,'_Middle_Name') and @type='text']"); 
	By txtTitle = By.xpath("//input[contains(@id,'_Title') and @type='text']");
	By txtSuffix = By.xpath("//input[contains(@id,'ENTITY_Suffix') and @type='text']");
	By txtCOName = By.xpath("//input[contains(@id,'ENTITY_CO_Name') and @type='text']");

	By txtLastNameDot = By.xpath("(//input[contains(@id,'CONTACT_Last_Name') and @type='text'])");
	By txtFirstNameDot = By.xpath("(//input[contains(@id,'CONTACT_First_Name') and @type='text'])");
	By txtMiddleNameDot = By.xpath("(//input[contains(@id,'CONTACT_Middle_Name') and @type='text'])"); 
	By txtTitleDot = By.xpath("(//input[contains(@id,'CONTACT_Title') and @type='text'])");
	By txtSuffixDot = By.xpath("(//input[contains(@id,'CONTACT_Suffix') and @type='text'])");
	By txtCONameDot = By.xpath("(//input[contains(@id,'CONTACT_CO_Name') and @type='text'])");

	
	By txtMaritalStatus = By.xpath("//input[contains(@id,'_Marital_Status_ID_radYALDropDownList_Input') and @type='text']");
	By txtMaritalStatusDot = By.xpath("(//input[contains(@id,'CONTACT_Marital_Status_ID_radYALDropDownList_Input') and @type='text'])");
	By drpEntityName = By.xpath("(//input[contains(@id,'_Corporation_Trust') and @type='text'])[1]");
	By drpEntityNameDot = By.xpath("(//input[contains(@id,'CONTACT_Corporation_Trust') and @type='text'])");
    By drpEntityTypeDot = By.xpath("(//input[contains(@id,'CONTACT_Entity_Type_ID_radYALDropDownList_Input') and @type='text'])");
    By drpEntityTypeRow = By.xpath("(//input[contains(@id,'_Entity_Type_ID_radYALDropDownList_Input') and @type='text'])[1]");
    By txtExecutingEntity = By.xpath("//input[contains(@id,'CONTACT_EXEC_ENTITY') and @type='text']");
    By drpRelationship = By.xpath("//input[contains(@id,'CONTACT_EXEC_ENT_RELN_ID_radYALDropDownList_Input') and @type='text']");
    By txtVendor = By.xpath("//input[contains(@id,'ENTITY_Vendor_ID') and @type='text']");
    By txtAddressLine1 = By.xpath("//input[contains(@id,'CONTACT_Address_Line_1') and @type='text']");
    By txtAddressLine1Row = By.xpath("//input[contains(@id,'_Address_Line_1') and @type='text']");
    By txtAddressLine2 = By.xpath("//input[contains(@id,'CONTACT_Address_Line_2') and @type='text']");
    By txtAddressLine2Row = By.xpath("//input[contains(@id,'_Address_Line_2') and @type='text']");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'CONTACT_Address_Line_3') and @type='text']"); 
    By txtZipCodeRow = By.xpath("(//input[contains(@id,'ENTITY_Zip_Code') and @type='text'])[1]");
    By txtZipCode = By.xpath("(//input[contains(@id,'CONTACT_Zip_Code') and @type='text'])[1]");
    By txtZipCodePlusRow = By.xpath("(//input[contains(@id,'ENTITY_Zip_Code') and @type='text'])[2]");
    By txtZipCodePlus = By.xpath("(//input[contains(@id,'CONTACT_Zip_Code') and @type='text'])[2]");
    By txtEmail = By.xpath("//input[contains(@id,'CONTACT_Email') and @type='text']");
    By txtEmailRow = By.xpath("//input[contains(@id,'ENTITY_Email') and @type='text']");
    By txtHomePhone = By.xpath("//input[contains(@id,'CONTACT_Home_Phone') and @type='text']");
    By txtHomePhoneRow = By.xpath("//input[contains(@id,'ENTITY_Home_Phone') and @type='text']");
    By txtCellPhone = By.xpath("//input[contains(@id,'CONTACT_Cell_Phone') and @type='text']");
    By txtCellPhoneRow = By.xpath("//input[contains(@id,'ENTITY_Cell_Phone') and @type='text']");
    By txtWorkPhone = By.xpath("//input[contains(@id,'CONTACT_Work_Phone') and @type='text']");
    By txtWorkPhoneRow = By.xpath("//input[contains(@id,'ENTITY_Work_Phone') and @type='text']");
    By txtInternationalPhone = By.xpath("//input[contains(@id,'CONTACT_Intl_Phone') and @type='text']");
    By drpW9Flag = By.xpath("//input[contains(@id,'ENTITY_W9_STATUS_ID_radYALDropDownList_Input') and @type='text']");
    By txtContactNumber = By.xpath("//input[contains(@id,'ENTITY_txtContactNum') and @type='text']");
    By drpContactInfoFor = By.xpath("//input[contains(@id,'ENTITY_ddlContactFor_radYALDropDownList_Input') and @type='text']");
    By txtAdditionalComment = By.xpath("//input[contains(@id,'ENTITY_rtbAdditionalComments') and @type='text']");
    By drpExistingContact = By.xpath("(//input[contains(@id,'ContactList_Input') and @type='text'])[1]");
    By drpExistingContactRow = By.xpath("(//input[contains(@id,'RadEntityInfo_Input') and @type='text'])[1]");
    By drpPaymentMethod = By.xpath("//input[contains(@id,'ENTITY_Payment_Method_ID_radYALDropDownList_Input') and @type='text']");
    By txtEntityNameLine2 = By.xpath("(//input[contains(@id,'ENTITY_Corporation_Trust2') and @type='text'])[1]");
    By txtFaxNumber = By.xpath("(//input[contains(@id,'ENTITY_FAX_NUMBER') and @type='text'])[1]");
    By btnSave = By.xpath("//input[@id='btnSaveLO']");
    By btnSaveDot = By.xpath("//input[@id='SaveContact']");
    By SuccessMessage = By.xpath("//span[@id='usrMessage']");
    
    public void ClickOnAddNewButton() {
    	util.waitUntilElementDisplay(navProject);
    	util.click(navProject);
    	util.waitUntilElementDisplay(navProjectInformation);
    	util.click(navProjectInformation);
    	util.waitUntilElementDisplay(navContact);
    	util.click(navContact);
    	commonFunction.projectSelection();
    	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    }
    
    public void CheckActiveCheckbox() {
    	util.dummyWait(2);
    	util.switchToIframe(iframeAlt);
    	util.waitUntilElementDisplay(ActiveCheckBox);
		Assert.assertTrue(util.isElementPresent(ActiveCheckBox));

    }
    
    public void CheckActiveCheckboxRow() {
    	util.dummyWait(2);
    	util.switchToIframe(iframe);
    	util.waitUntilElementDisplay(ActiveCheckBox);
		Assert.assertTrue(util.isElementPresent(ActiveCheckBox));

    }
    
    public void CheckActiveCheckboxDot() {
    	util.dummyWait(2);
    	util.switchToIframe(iframe);
    	util.waitUntilElementDisplay(ActiveCheckboxDot);
		Assert.assertTrue(util.isElementPresent(ActiveCheckboxDot));

    }
    
    public void AddComment(String value) {
    	util.dummyWait(2);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
    }
    
    public void AddFuturePayments(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFuturePayments, value);
    }
    
    public void SelectContactType(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpContactType, value);
    }
    
    public void AddLastName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLastName, value);
    }
    
    public void AddFirstName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFirstName, value);
    }
    
    public void AddMiddleName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMiddleName, value);
    }
    
    public void AddTitle(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTitle, value);
    }
    
    public void AddSuffix(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSuffix, value);
    }
    
    public void AddCOName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCOName, value);
    }
    
    public void AddLastNameDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLastNameDot, value);
    }
    
    public void AddFirstNameDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFirstNameDot, value);
    }
    
    public void AddMiddleNameDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMiddleNameDot, value);
    }
    
    public void AddTitleDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTitleDot, value);
    }
    
    public void AddSuffixDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSuffixDot, value);
    }
    
    public void AddCONameDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCONameDot, value);
    }
    
    public void AddMaritalStatus(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMaritalStatus, value);
    }
    
    public void AddMaritalStatusDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMaritalStatusDot, value);
    }
    
    public void AddEntityName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEntityName, value);
    }
    
    public void AddEntityNameDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEntityNameDot, value);
    }
    
    public void AddEntityType(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEntityTypeDot, value);
    }
    
    public void AddEntityTypeRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEntityTypeRow, value);
    }
    
    public void AddExecutingEntity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExecutingEntity, value);
    }
    
    public void SelectRelationship(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpRelationship, value);
    }
    
    public void AddVendor(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtVendor, value);
    }
    
    public void AddAddressLine1(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine1, value);
    }
    
    public void AddAddressLine1Row(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine1Row, value);
    }
    
    public void AddAddressLine2(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine2, value);
    }
    
    public void AddAddressLine2Row(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine2Row, value);
    }
    
    public void AddAddressLine3(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAddressLine3, value);
    }
    By txtCity = By.xpath("//input[@id='CONTACT_City']");
    public void AddCity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCity, value);
    }
    
    By txtCityRow = By.xpath("//input[@id='ENTITY_City']");
    public void AddCityRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCityRow, value);
    }
    
    By txtState = By.xpath("//input[@id='CONTACT_RadState_Input']");
    public void AddState(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtState, value);
    }
    
    By txtStateRow = By.xpath("//input[@id='ENTITY_RadState_Input']");
    public void AddStateRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtStateRow, value);
    }
    
    public void AddZipCode(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCode, value);
    }
    
    public void AddZipCodeRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCodeRow, value);
    }
    
    public void AddZipCodePlus(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCodePlus, value);
    }
    
    public void AddZipCodePlusRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtZipCodePlusRow, value);
    }
    
    public void AddEmail(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmail, value);
    }
    
    public void AddEmailRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmailRow, value);
    }
    
    public void AddHomePhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtHomePhone, value);
    }
    
    public void AddHomePhoneRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtHomePhoneRow, value);
    }
    
    public void AddCellPhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCellPhone, value);
    }
    
    public void AddCellPhoneRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCellPhoneRow, value);
    }
    
    public void AddWorkPhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtWorkPhone, value);
    }
    
    public void AddWorkPhoneRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtWorkPhoneRow, value);
    }
    
    public void AddInternationalPhone(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtInternationalPhone, value);
    }
    
    public void SelectW9Flag(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpW9Flag, value);
    }
    
    public void AddContactNumber(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtContactNumber, value);
    }
    
    public void SelectContactInfoFor(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpContactInfoFor, value);
    }
    
    public void AddAdditionalComment(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAdditionalComment, value);
    }
    
    public void SelectExistingContact(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpExistingContact, value);
    	util.dummyWait(2);
    }
    
    public void SelectExistingContactRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpExistingContactRow, value);
    	util.dummyWait(2);

    }
    
    public void SelectPaymentMethod(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPaymentMethod, value);
    }
    
    public void AddEntityNameLine2(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEntityNameLine2, value);
    }
    
    public void AddFaxNumber(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFaxNumber, value);
    }
    
    public void ClickOnSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    }
    
    By SuccessMessageDot = By.xpath("//span[text()='Changes saved successfully!']");
    By btnClose = By.xpath("//a[@title='Close']");
    public void ClickOnSaveButtonDot() {
    	util.waitUntilElementDisplay(btnSaveDot);
    	util.click(btnSaveDot);
    }
    
    public void AddnewContact(Map<String, String> map, String testcaseName) {
        if(testcaseName.contains("DOT")) {
     	   try {
     		  ClickOnAddNewButton();
				log("STEP 1:  if Contact Tab does not exists in the instance  and skip the steps     ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:   User cannot see the option in Menu ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

	    
	       try {
	    		 CheckActiveCheckboxDot();
	 			log("STEP 2: Checkbox is auto checked   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: Active checkbox is not auto checked", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	       
	      if(util.isElementVisible(txtComment)) {
	       try {
	    	   AddComment(map.get(Excel.Comment));
 	 			log("STEP 3: User can enter a value in Comment field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 3:  User cannot add a value in Comment field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 3");
 	 		 }
	      }
	      
	      if(util.isElementVisible(txtFuturePayments)) {
	       try {
	    	   AddFuturePayments(map.get(Excel.FuturePayments));
 	 			log("STEP 4: User can enter a value in Future Payments field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 4:  User cannot add a value in Future Payments field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 4");
 	 		 }
	      }
	      
	      if(util.isElementVisible(drpContactType)) {
	       try {
	    	   SelectContactType(map.get(Excel.ContactType));
 	 			log("STEP 5: User can enter a value in Contact Type field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 5:  User cannot add a value in Contact Type field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 5");
 	 		 } 
	      }
	      
	      if(util.isElementVisible(txtLastNameDot)) {
	       try {
	    	   AddLastNameDot(map.get(Excel.LastName));
 	 			log("STEP 6: User can enter a value in LastName field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 6:  User cannot add a value in LastName field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 6");
 	 		 } 
	      }
	      
	      if(util.isElementVisible(txtFirstNameDot)) {
	       try {
	    	   AddFirstNameDot(map.get(Excel.FirstName));
 	 			log("STEP 7: User can enter a value in FirstName field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 7:  User cannot add a value in FirstName field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 7");
 	 		 } 
	      }
	      
	      if(util.isElementVisible(txtMiddleNameDot)) {
	       try {
	    	   AddMiddleNameDot(map.get(Excel.MiddleName));
 	 			log("STEP 8: User can enter a value in MiddleName field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 8:  User cannot add a value in MiddleName field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 8");
 	 		 } 
	      }
	      
	      if(util.isElementVisible(txtTitleDot)) {
	       try {
 	    		 AddTitleDot(map.get(Excel.TITLE));
 	 			log("STEP 9: User can enter a value in TITLE field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 9:  User cannot add a value in TITLE field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 9");
 	 		 }
	      }
	      
	      if(util.isElementVisible(txtSuffixDot)) {
	       try {
 	    		 AddSuffixDot(map.get(Excel.Suffix));
 	 			log("STEP 10: User can enter a value in Suffix field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 10:  User cannot add a value in Suffix field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 10");
 	 		 }
	      }
	      
	      if(util.isElementVisible(txtCONameDot)) {
	       try {
 	    		 AddCONameDot(map.get(Excel.COName));
 	 			log("STEP 11: User can enter a value in COName field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 11:  User cannot add a value in COName field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 11");
 	 		 }
	      }
	      
	      if(util.isElementVisible(txtMaritalStatusDot)) {
	       try {
 	    		 AddMaritalStatusDot(map.get(Excel.MaritalStatus));
 	 			log("STEP 13: Added value displays in Marital Status field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 13:  User  cannot select  value  from Marital Status DD    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 13");
 	 		 }
	      }
	      
	      if(util.isElementVisible(drpEntityNameDot)) {
	       try {
 	    		 AddEntityNameDot(map.get(Excel.EntityName));
 	 			log("STEP 14: User can enter a value in Entity Name field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 14:  User cannot add a value in Entity Name field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 14");
 	 		 }
	      }
	      
	       if(util.isElementVisible(drpEntityTypeDot)) {
	       try {
	    	   AddEntityType(map.get(Excel.EntityType));
  	 			log("STEP 15: Added value displays in Entity Type field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 15:  User  cannot select  value  from Entity Type DD    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 15");
  	 		 }
	       }
	       
	       try {
	    	   AddExecutingEntity(map.get(Excel.ExecutingEntity));
  	 			log("STEP 16: Added value displays in Executing Entity field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 16:  User  cannot select  value  from Executing Entity DD    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 16");
  	 		 }
	       
	       try {
	    	   SelectRelationship(map.get(Excel.Relationship));
  	 			log("STEP 17: Added value displays in Relationship field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 17:  User  cannot select  value  from Relationship DD    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 17");
  	 		 }
	       
	       try {
	    		 AddAddressLine1(map.get(Excel.AddressLine1));
	 			log("STEP 18:  User can enter a value in AddressLine1 field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 18:  User cannot add a value in AddressLine1 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 18");
	 		 }

	    	 try {
	    		 AddAddressLine2(map.get(Excel.AddressLine2));
	    		log("STEP 19: User can enter a value in AddressLine2 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 19:  User cannot add a value in AddressLine2 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 19");
	 		 }
	    	 
	    	 try {
	    		 AddAddressLine3(map.get(Excel.AddressLine3));
	 			log("STEP 20: User can enter a value in AddressLine3 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 20:  User cannot add a value in AddressLine3 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 20");
	 		 }
	    	 
	    	 try {
	    		 AddCity(map.get(Excel.City));
	 			log("STEP 21: User can enter a value in City field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 21:  User cannot add a value in City field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 21");
	 		 }
	    	 
	    	 try {
	    		 AddState(map.get(Excel.State));
	 			log("STEP 22: User can enter a value in State field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 22:  User cannot add a value in State field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 22");
	 		 }
	    	 
	    	 
	    	 try {
	    		 AddZipCode(map.get(Excel.ZipCode));
	 			log("STEP 23: User can enter a value in ZipCode field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 23:  User cannot add a value in ZipCode field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 23");
	 		 }
	    	 
	    	 if(util.isElementVisible(txtZipCodePlus)) {
	    	 try {
	    		 AddZipCodePlus(map.get(Excel.ZipCodePlus));
	 			log("STEP 24: User can enter a value in ZipCode Plus field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 24:  User cannot add a value in ZipCode Plus field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 24");
	 		 }
	    	 }
	    	 
	    	 try {
	    		 AddEmail(map.get(Excel.Email));
	 			log("STEP 25: User can enter a value in Email field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 25:  User cannot add a value in Email field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 25");
	 		 }
	    	 
	       
	    	 try {
	    		 AddHomePhone(map.get(Excel.HomePhone));
	 			log("STEP 26: User can enter a value in Home Phone field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 26:  User cannot add a value in Home Phone field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 26");
	 		 }
	    	 
	    	 try {
	    		 AddCellPhone(map.get(Excel.CellPhone));
	 			log("STEP 27: User can enter a value in Cell Phone field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 27:  User cannot add a value in Cell Phone field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 27");
	 		 }
	    	 
	    	 try {
	    		 AddWorkPhone(map.get(Excel.WorkPhone));
	 			log("STEP 28: User can enter a value in Work Phone field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 28:  User cannot add a value in Work Phone field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 28");
	 		 }
	    	 
	    	 try {
	    		 AddInternationalPhone(map.get(Excel.InternationalPhone));
	 			log("STEP 29: User can enter a value in International Phone field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 29:  User cannot add a value in International Phone field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 29");
	 		 }
	    	 
	    	 
//	    	 try {
//	    		 SelectExistingContact(map.get(Excel.ExistingContact));
//	 			log("STEP 37: User can enter a value in Existing Contact field   ", Status.PASS);
//	 		 } catch (Exception e) {
//	 			log("STEP 37:  User cannot add a value in Existing Contact field    ", Status.FAIL);
//	 			throw new RuntimeException("Failed in step 37");
//	 		 }
	    	 
	    	 try {
	    		 ClickOnSaveButtonDot();
	    		 util.dummyWait(2);
	 			log("STEP 30: Added Contact record should display in grid  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 30: Added Contact record should display in grid  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 30");
	 		 }
	    	 Assert.assertTrue(util.isElementPresent(SuccessMessageDot), "Changes saved successfully!");
	 		if (util.isElementPresent(SuccessMessageDot)) {
	 			log("STEP 31:Message - 'Changes saved sucessfully!' in green displays", Status.PASS);
	 		} else {
	 			log("STEP 31:Message- Changes saved sucessfully' does not display", Status.FAIL);
	 			throw new RuntimeException("Faild in STEP 31 :Message- Changes saved sucessfully' does not display ");
	 		}
     
	 		util.switchToDefaultContent();
	 		util.click(btnClose);	
      }
        else {
        	
        	try {
       		  ClickOnAddNewButton();
  				log("STEP 1:  if Contact Tab does not exists in the instance  and skip the steps     ", Status.PASS);
  			} catch (Exception e) {
  				log("STEP 1:   User cannot see the option in Menu ", Status.FAIL);
  				throw new RuntimeException("Failed in step 1");
  			}
       
        	if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
        		 try {
        			 CheckActiveCheckboxRow();
      	 			log("STEP 2: Checkbox is auto checked   ", Status.PASS);
      	 		 } catch (Exception e) {
      	 			log("STEP 2: Active checkbox is not auto checked", Status.FAIL);
      	 			throw new RuntimeException("Failed in step 2");
      	 		 }
        	}
        	else {
  	       try {
  	    		 CheckActiveCheckbox();
  	 			log("STEP 2: Checkbox is auto checked   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 2: Active checkbox is not auto checked", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 2");
  	 		 }
  	       
        	}  
        	
        	if(util.isElementVisible(txtComment)) {
  	       try {
  	    	   AddComment(map.get(Excel.Comment));
   	 			log("STEP 3: User can enter a value in Comment field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 3:  User cannot add a value in Comment field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 3");
   	 		 }
        	}
        	
  	       try {
  	    	   SelectContactType(map.get(Excel.ContactType));
   	 			log("STEP 4: User can enter a value in Contact Type field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 4:  User cannot add a value in Contact Type field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 4");
   	 		 } 
  	       
  	     if(util.isElementVisible(txtLastName)) {
  	       try {
  	    	   AddLastName(map.get(Excel.LastName));
   	 			log("STEP 5: User can enter a value in LastName field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 5:  User cannot add a value in LastName field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 5");
   	 		 } 
  	     }
  	     
  	   if(util.isElementVisible(txtFirstName)) {
  	       try {
  	    	   AddFirstName(map.get(Excel.FirstName));
   	 			log("STEP 6: User can enter a value in FirstName field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 6:  User cannot add a value in FirstName field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 6");
   	 		 } 
  	   }
  	   
  	 if(util.isElementVisible(txtMiddleName)) {
  	       try {
  	    	   AddMiddleName(map.get(Excel.MiddleName));
   	 			log("STEP 7: User can enter a value in MiddleName field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 7:  User cannot add a value in MiddleName field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 7");
   	 		 } 
  	 }
  	 
  	       if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
  	       try {
   	    		 AddTitle(map.get(Excel.TITLE));
   	 			log("STEP 8: User can enter a value in TITLE field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 8:  User cannot add a value in TITLE field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 8");
   	 		 }
  	       }
  	       
  	     if(util.isElementVisible(txtSuffix)) {
  	       try {
   	    		 AddSuffix(map.get(Excel.Suffix));
   	 			log("STEP 9: User can enter a value in Suffix field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 9:  User cannot add a value in Suffix field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 9");
   	 		 }
  	     }
  	     
  	   if(util.isElementVisible(txtCOName)) {
  	       try {
   	    		 AddCOName(map.get(Excel.COName));
   	 			log("STEP 10: User can enter a value in COName field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 10:  User cannot add a value in COName field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 10");
   	 		 }
  	   }
  	   
  	 if(util.isElementVisible(txtMaritalStatus)) {
  	       try {
   	    		 AddMaritalStatus(map.get(Excel.MaritalStatus));
   	 			log("STEP 11: Added value displays in Marital Status field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 11:  User  cannot select  value  from Marital Status DD    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 11");
   	 		 }
  	 }
  	 
  	 if(util.isElementVisible(drpEntityName)) {
  	       try {
   	    		 AddEntityName(map.get(Excel.EntityName));
   	 			log("STEP 12: User can enter a value in Entity Name field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 12:  User cannot add a value in Entity Name field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 12");
   	 		 }
  	 }
  	       if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
  	       try {
  	    	 AddEntityTypeRow(map.get(Excel.EntityType));
    	 			log("STEP 13: Added value displays in Entity Type field   ", Status.PASS);
    	 		 } catch (Exception e) {
    	 			log("STEP 13:  User  cannot select  value  from Entity Type DD    ", Status.FAIL);
    	 			throw new RuntimeException("Failed in step 13");
    	 		 }

//  	       try {
//  	    	     AddVendor(map.get(Excel.Vendor));
//    	 			log("STEP 18: Added value displays in the field   ", Status.PASS);
//    	 		 } catch (Exception e) {
//    	 			log("STEP 18:  User  cannot select  value  from the DD    ", Status.FAIL);
//    	 			throw new RuntimeException("Failed in step 18");
//    	 		 }
//  	       
  	       try {
  	    		 AddAddressLine1Row(map.get(Excel.AddressLine1));
  	    		ADD_1= map.get(Excel.AddressLine1);
  	 			log("STEP 14:  User can enter a value in AddressLine1 field  ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 14:  User cannot add a value in AddressLine1 field    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 14");
  	 		 }

  	    	 try {
  	    		 AddAddressLine2Row(map.get(Excel.AddressLine2));
  	    		ADD_2= map.get(Excel.AddressLine2);
  	    		log("STEP 15: User can enter a value in AddressLine2 field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 15:  User cannot add a value in AddressLine2 field    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 15");
  	 		 }
  	    	 
  	    	 
  	    	 try {
  	    		 AddCityRow(map.get(Excel.City));
  	    		 CITY= map.get(Excel.City);
  	 			log("STEP 16: User can enter a value in City field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 16:  User cannot add a value in City field    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 16");
  	 		 }
  	    	 
  	    	 try {
  	    		 AddStateRow(map.get(Excel.State));
  	    		 STATE= map.get(Excel.State);
  	 			log("STEP 17: User can enter a value in State field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 17:  User cannot add a value in State field    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 17");
  	 		 }
  	    	 
  	    	 
  	    	 try {
  	    		 AddZipCodeRow(map.get(Excel.ZipCode));
  	    		 ZIP=map.get(Excel.ZipCode);
  	 			log("STEP 18: User can enter a value in ZipCode field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 18:  User cannot add a value in ZipCode field    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 18");
  	 		 }
  	    	 
  	    	if(util.isElementVisible(txtZipCodePlusRow)) {
  	    	 try {
  	    		 AddZipCodePlusRow(map.get(Excel.ZipCodePlus));
  	 			log("STEP 19: User can enter a value in ZipCode Plus field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 19:  User cannot add a value in ZipCode Plus field    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 19");
  	 		 }
  	    	}
  	    	
  	    	 try {
  	    		 AddEmailRow(map.get(Excel.Email));
  	 			log("STEP 20: User can enter a value in Email field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 20:  User cannot add a value in Email field    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 20");
  	 		 }
  	    	 
  	       
  	    	 try {
  	    		 AddHomePhoneRow(map.get(Excel.HomePhone));
  	 			log("STEP 21: User can enter a value in HomePhone field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 21:  User cannot add a value in HomePhone field    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 21");
  	 		 }
  	    	 
  	    	 try {
  	    		 AddCellPhoneRow(map.get(Excel.CellPhone));
  	 			log("STEP 22: User can enter a value in CellPhone field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 22:  User cannot add a value in CellPhone field    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 22");
  	 		 }
  	    	 
  	    	 try {
  	    		 AddWorkPhoneRow(map.get(Excel.WorkPhone));
  	 			log("STEP 23: User can enter a value in WorkPhone field   ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 23:  User cannot add a value in WorkPhone field    ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 23");
  	 		 }
  	    	 
  	    	 
  	    	try {
  	    		SelectContactInfoFor(map.get(Excel.ContactInfo));
 	 			log("STEP 24: User can enter a value in ContactInfo field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 24:  User cannot add a value in ContactInfo field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 24");
 	 		 }
  	    	
  	    	try {
  	    		AddAdditionalComment(map.get(Excel.Comment));
 	 			log("STEP 25: User can enter a value in Comment field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 25:  User cannot add a value in Comment field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 25");
 	 		 }
  	      
  	    	 
//  	    	 try {
//  	    		 SelectExistingContactRow(map.get(Excel.ExistingContact));
//  	 			log("STEP 37: User can enter a value in the field   ", Status.PASS);
//  	 		 } catch (Exception e) {
//  	 			log("STEP 37:  User cannot add a value in the field    ", Status.FAIL);
//  	 			throw new RuntimeException("Failed in step 37");
//  	 		 }
  	       }
  	       
  	       if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {	    	   
  	    	 
  	    	 if(util.isElementPresent(drpW9Flag)) {
  	    	   try {
  	    		SelectW9Flag(map.get(Excel.W9Flag));
	 			log("STEP 13: Added value displays in W9Flag field    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 13:  User  cannot select  value  from W9Flag DD   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 13");
	 		 }}

  	    	 if(util.isElementPresent(txtContactNumber)) {
  	    	 try {
  	    		AddContactNumber(map.get(Excel.ContactNumber));
	 			log("STEP 14: Added value displays in Contact Number field    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 14:  User  cannot select  value  from Contact Number DD   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 14");
	 		 }
  	    	 }
  	    	   
  	    	if(util.isElementPresent(drpPaymentMethod)) {
  	    	 try {
	    		 SelectPaymentMethod(map.get(Excel.PaymentMethod));
	 			log("STEP 15: Added value displays in Payment Method field    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 15:  User  cannot select  value  from Payment Method DD   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 15");
	 		 }
  	    	}
  	       }
  	       else {
//  	    	 try {
//  	    		AddEntityNameLine2(map.get(Excel.EntityNameLine));
//	 			log("STEP 41: Added value displays in the field    ", Status.PASS);
//	 		 } catch (Exception e) {
//	 			log("STEP 41:  User  cannot select  value  from the DD   ", Status.FAIL);
//	 			throw new RuntimeException("Failed in step 41");
//	 		 }
  	    	 
  	    	try {
  	    		AddFaxNumber(map.get(Excel.FaxNumber));
	 			log("STEP 26: Added value displays in FaxNumber field    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 26:  User  cannot select  value  from FaxNumber DD   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 26");
	 		 }
  	    	 
  	       }
  	       
  	       if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
  	    	 try {
  	    		 ClickOnSaveButton();
  	    		 util.dummyWait(2);
  	 			log("STEP 16: User can click on save button  ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 16: User cannot click on save button ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 16");
  	 		 }
  	    	 Assert.assertTrue(util.isElementPresent(SuccessMessage), "New Contact has created and added to the Parcel.");
  	 		if (util.isElementPresent(SuccessMessage)) {
  	 			log("STEP 17:Message - 'Message - 'New Contact was created and added to the parcel.' in green displays", Status.PASS);
  	 		} else {
  	 			log("STEP 17:Message - 'Message - 'New Contact was created and added to the parcel.' does not displays", Status.FAIL);
  	 			throw new RuntimeException("Faild in STEP 17 :");
  	 		}
  	      }
  	       else {
  	    	 try {
  	    		 ClickOnSaveButton();
  	    		 util.dummyWait(2);
  	 			log("STEP 27: User can click on save button  ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 27: User cannot click on Save button  ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 27");
  	 		 }
  	    	 Assert.assertTrue(util.isElementPresent(SuccessMessage), "New Contact has created and added to the Tract.");
  	 		if (util.isElementPresent(SuccessMessage)) {
  	 			log("STEP 28:Message - 'Message - 'New Contact was created and added to the parcel.' in green displays", Status.PASS);
  	 		} else {
  	 			log("STEP 28:Message - 'Message - 'New Contact was created and added to the parcel.' does not displays", Status.FAIL);
  	 			throw new RuntimeException("Faild in STEP 28 :");
  	 		}
  	       }
  	       if(environment.contains("VALARD")) {
  	    	 try {
  	    		 By primaryAddress = By.xpath("//td[text()='Primary/Preferred Address: "+ADD_1+", "+ADD_2+", "+CITY+", "+ZIP+"']");
  	    		 String pA= "Primary/Preferred Address: "+ADD_1+", "+ADD_2+", "+CITY+", "+ZIP;
  	    		 Assert.assertTrue(util.isElementVisible(primaryAddress));
  	 			log("STEP 29: Primary/Prefered Address Pulled Successfully "+pA, Status.PASS);
  	 		 } catch (AssertionError e) {
  	 			 ExtentTestManager.infoWithScreenshot("Failed Screenshot");
  	 			log("STEP 29: Primary/ Prefered Address is not showing ", Status.FAIL);
  	
  	 		 }
  	       }
  	    
  	 		util.switchToDefaultContent();
  	 		util.click(btnClose);	

        }
        
    }
}
