package pages.ParcelDetails;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ContactDetails_AddNewContactPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String COUNTRY;
	public static boolean isCountryPresent;

	public ContactDetails_AddNewContactPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')]");
	By navContactDetails = By.xpath("//span[contains(text(),'Contact Details')]");
	By btnAddUnderContact = By.xpath("(//img[@alt='Add New Landowner(s)'])[2]");
	By btnAddContactforROW = By.xpath("//input[contains(@id,'ImgAddContact') and @type = 'image']");
	By frmFull = By.xpath("//iframe[@name='AddLandowner']");
	By Activecheckbox = By.xpath("//input[contains(@id,'IsEntityActive') and @checked='checked']");
	By txtExistingContact = By.xpath("//input[contains(@id,'RadEntityInfo_Input') and @type='text']");
	By txtExistingContactDot = By.xpath("//input[contains(@id,'ContactList_Input') and @type='text']");
	By CheckParcelOnPrimary = By.xpath("//label[text()='Primary On Parcel']");
	By CheckParcelOnPrimaryDOT = By.xpath("//input[@id='isPrimaryContact']");
	By drpContactType = By.xpath("//input[contains(@id,'CONTACT_TYPE_ID_radYALDropDownList_Input') and @type='text']");
	By CheckContactFor = By.xpath("(//input[@class='rlbCheck'])[1]");
	By txtLastName = By.xpath("//input[contains(@id,'_Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'_First_Name') and @type='text']");
	By txtMiddleName = By.xpath("//input[contains(@id,'_Middle_Name') and @type='text']");
	By txtTitle = By.xpath("//input[contains(@id,'_Title') and @type='text']");
	By drpEntityName = By.xpath("(//input[contains(@id,'_Corporation_Trust') and @type='text'])[1]");
	By txtEntityType = By.xpath("//input[contains(@id,'_Entity_Type_ID_radYALDropDownList_Input') and @type='text']");
	By txtContactNumber = By.xpath("//input[contains(@id,'ENTITY_txtContactNum') and @type='text']");
	By txtSuffix = By.xpath("//input[contains(@id,'ENTITY_Suffix') and @type='text']");
	By txtCOName = By.xpath("//input[contains(@id,'ENTITY_CO_Name') and @type='text']");
	By txtMaritalStatus = By.xpath("//input[contains(@id,'_Marital_Status_ID_radYALDropDownList_Input') and @type='text']");
	By drpW9Flag = By.xpath("//input[contains(@id,'ENTITY_W9_STATUS_ID_radYALDropDownList_Input') and @type='text']");
	By drpPaymentMethod = By.xpath("//input[contains(@id,'ENTITY_Payment_Method_ID_radYALDropDownList_Input') and @type='text']");
	By txtVendor = By.xpath("//input[contains(@id,'ENTITY_Vendor_ID') and @type='text']");
	By btnSave = By.xpath("//input[@id='btnSaveLO']");
	By successmassage = By.xpath("//span[@id='usrMessage']");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");   //not validate
	By btnEditAlt = By.xpath("//*[contains(@id,'CONTACT_radYALGridControl_ctl00__0')]/.//a[contains(text(),'Edit')]");
	By btnEditRow = By.xpath("//*[contains(@id,'CONTACT_radYALGridControl_ctl00__0')]/.//a[contains(text(),'Edit')]");
	By linkComment = By.xpath("//a[@id='LOCommentsLink']");
	By frmComments = By.xpath("//iframe[@name='GeneralComments']");
	By txtActivityDate = By.xpath("//input[contains(@id,'idGeneralComments_Activity_Date_dateInput') and @type='text']");
	By txtComment = By.xpath("//textarea[@id='idGeneralComments_Comments']");
	By btnSaveComment = By.xpath("//input[@id='idGeneralComments_btnSave1']");
	By btnCommentHistory = By.xpath("//span[contains(text(),'Comments History')]");
	By btnDelete = By.xpath("//input[contains(@id,'_ctl04_gbcDeleteAlignment') and @type='image']");
	By frmDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnOK = By.xpath("//span[text()='OK']");
	By btnCloseComment = By.xpath("//a[@class='rwCloseButton']");
	By btnAddNewRecord = By.xpath("//img[@id='YALCONTACTWITHNAME_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By txtAddressLine1 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_2') and @type='text']");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_3') and @type='text']");
	By txtAddressLine4 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_4') and @type='text']");
	By txtCity = By.xpath("//input[contains(@id,'_EditFormControl_City') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'_EditFormControl_State_ABB_radYALDropDownList_Input') and @type='text']");
	By drpStateRow = By.xpath("//input[contains(@id,'_EditFormControl_RadStateABB_Input') and @type='text']");
	By txtZipCode = By.xpath("(//input[contains(@id,'_EditFormControl_Zip_Code') and @type='text'])[1]");
	By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert') and @type='submit']");
	By btnEditComment = By.xpath("//input[contains(@id,'_ctl04_EditButton') and @type='image']");
	By btnAddContact = By.xpath("//input[contains(@id,'_EditFormControl_btnAddItem') and @type='submit']");
	By txtLastNameadd = By.xpath("//input[contains(@id,'_Last_Name_Footer') and @type='text']");
	By txtFirstNameadd = By.xpath("//input[contains(@id,'_First_Name_Footer') and @type='text']");
	By txtMiddleNameadd  = By.xpath("//input[contains(@id,'_Middle_Name_Footer') and @type='text']");
	By txtNameForALT = By.xpath("//input[contains(@id,'ctl01_Full_Name') and @type='text']");
	By txtHomePhone = By.xpath("//input[contains(@id,'ctl01_Home_Phone') and @type='text']");
	By txtCellPhone = By.xpath("//input[contains(@id,'ctl01_Cell_Phone') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'ctl01_Work_Phone') and @type='text']");
	By txtFaxPhone  = By.xpath("//input[contains(@id,'ctl01_FAX_NUMBER') and @type='text']");
	By txtEmail  = By.xpath("//input[contains(@id,'ctl01_Email') and @type='text']"); 
	By chcPreferredContact = By.xpath("//label[contains(text(),'Preferred Contact')]");
	By btnSaveContact = By.xpath("//input[contains(@id,'_EditFormControl_btnSaveItem') and @type='submit']");
	By btnDeleteContact = By.xpath("//input[contains(@id,'_ctl01_DeleteInfo')]") ;
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	By btnUpdateContact = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
	By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
	 By country = By.xpath("//input[contains(@id,'EditFormControl_ddlCountry_radYALDropDownList_Input')]");
	    By countryUSA = By.xpath("//div[contains(@id,'EditFormControl_ddlCountry_radYALDropDownList_DropDown')]/..//*[text()='USA' or text()='United States']");
	    By countryCANADA = By.xpath("//div[contains(@id,'EditFormControl_ddlCountry_radYALDropDownList_DropDown')]/..//*[text()='Canada']");
	    By countryDDClose = By.xpath("//div[contains(@id,'_EditFormControl_ddlCountry_radYALDropDownList')]/..//a[contains(@id,'Arrow')]");
	    
	    
	 public void navigateToContatDetails() {
	  		util.waitUntilElementDisplay(navParcel);
	  		util.click(navParcel);
	  		util.waitUntilElementDisplay(navParcelInfo);
	  		util.click(navParcelInfo);
	  		util.waitUntilElementDisplay(navParcelInformation);
	  		util.click(navParcelInformation);
	  		commonFunction.projectSelection();
	  		util.waitUntilElementDisplay(firstParcel);
    		util.click(firstParcel);
    		util.dummyWait(10);
		 util.waitUntilElementDisplay(navContactDetails);
			util.click(navContactDetails);
	    }
	    public void AddnewContactROW() {
			util.waitUntilElementDisplay(btnAddContactforROW);
			util.click(btnAddContactforROW);
			
	    }
	    
	    public void AddnewContact() {
			util.waitUntilElementDisplay(btnAddUnderContact);
			util.click(btnAddUnderContact);
			
	    }
	    
	    public void AddnewContactForROW() {
			util.waitUntilElementDisplay(btnAddContactforROW);
			util.click(btnAddContactforROW);
			
	    }
	    
	    
	    public void VerifyCheckbox() {
			Assert.assertTrue(true, "Activecheckbox");
			
	    }
	    
	    public void AddExistingContact(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExistingContact, value);
			
	    }
	    
	    public void AddExistingContactDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExistingContactDot, value);
			
	    }
	    
	    public void VerifyParcelPrimaryCheckbox() {
	    	util.waitUntilElementDisplay(CheckParcelOnPrimary);
	    	util.click(CheckParcelOnPrimary);
			
	    }
	    
	    public void VerifyParcelPrimaryCheckboxDot() {
	    	util.waitUntilElementDisplay(CheckParcelOnPrimaryDOT);
	    	util.click(CheckParcelOnPrimaryDOT);
			
	    }
	 By PrimaryCheckboxRow = By.xpath("//input[@id='IsPrimary']"); 
	 public void VerifyParcelPrimaryCheckboxRow() {
	    	util.waitUntilElementDisplay(PrimaryCheckboxRow);
	    	util.click(PrimaryCheckboxRow);
			
	    }
	 
	    public void AddContactType(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpContactType, value);
			
	    }
	
	    public void CheckContactFor() {
			util.waitUntilElementDisplay(CheckContactFor);
			util.click(CheckContactFor);
			
	    }
	    By LastnameDot = By.xpath("//input[contains(@id,'CONTACT_Last_Name') and @type='text']");
	    public void AddLastNameDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(LastnameDot, value);
			
	    }
	    
	    public void AddLastName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtLastName, value);
			
	    }
	    
	    By FirstNameDot = By.xpath("//input[contains(@id,'CONTACT_First_Name') and @type='text']");
	    public void AddFirstNameDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(FirstNameDot, value);
			
	    }
	    
	    public void AddFirstName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtFirstName, value);
			
	    }
	    By MiddleNameDot = By.xpath("//input[contains(@id,'CONTACT_Middle_Name') and @type='text']");
	    public void AddMiddleNameDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(MiddleNameDot, value);
			
	    }

	    
	    public void AddMiddleName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtMiddleName, value);
			
	    }
	    By TitleDot = By.xpath("//input[contains(@id,'CONTACT_Title') and @type='text']");
	    public void AddTitleDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(TitleDot, value);
			
	    }
	    
	    public void AddTitle(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtTitle, value);
			
	    }
	    By EntityNameDot = By.xpath("//input[contains(@id,'CONTACT_Corporation_Trust') and @type='text']");
	    public void AddEntityNameDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(EntityNameDot, value);
			
	    }
	    
	    public void AddEntityName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpEntityName, value);
			
	    }
	    By EntityTypeDot = By.xpath("//input[contains(@id,'CONTACT_Entity_Type_ID_radYALDropDownList_Input') and @type='text']");
	    public void AddEntityTypeDot(String value) {
	    	util.click(txtEntityType);
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(EntityTypeDot, value);
			
	    }
	    
	    public void AddEntityType(String value) {
	    	util.click(txtEntityType);
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtEntityType, value);
			
	    }
	    
	    
	    
	    public void AddContactNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtContactNumber, value);
			
	    }
	    By SuffixDot = By.xpath("//input[contains(@id,'CONTACT_Suffix') and @type='text']");
	    public void AddSuffixDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(SuffixDot, value);
			
	    }
	    public void AddSuffix(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSuffix, value);
			
	    }
	    By CONameDot = By.xpath("//input[contains(@id,'CONTACT_CO_Name') and @type='text']");
	    public void AddCONameDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(CONameDot, value);
			
	    }
	    
	    public void AddCOName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCOName, value);
			
	    }
	    
	    By MaritalStatusDot = By.xpath("//input[contains(@id,'CONTACT_Marital_Status_ID_radYALDropDownList_Input') and @type='text']");
	    public void AddMaritalStatusDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(MaritalStatusDot, value);
			
	    }
	    
	    public void AddMaritalStatus(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtMaritalStatus, value);
			
	    }
	    
	    
	    public void AddW9Flag(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpW9Flag, value);
			
	    }
	    
	    public void AddPaymentMethod(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpPaymentMethod, value);
			
	    }
	    
	    public void AddVendor(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtVendor, value);
			
	    }
	    
	    By btnSaveDot = By.xpath("//input[@id='SaveContact']");
	    public void SaveDot() {
	    	util.waitUntilElementDisplay(btnSaveDot);
			util.click(btnSaveDot);
			util.dummyWait(2);
			util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	    }
	    
	    
	    public void Save() {
	    	util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.dummyWait(2);
			util.waitUntilElementDisplay(successmassage);
			Assert.assertTrue(util.isElementPresent(successmassage), "New Contact has created and added to the Parcel.");
	    }

	    public void Close() {
	    	util.switchToDefaultContent();
	    	util.dummyWait(3);
	    	util.waitUntilElementDisplay(btnClose);
			util.click(btnClose);
			
	    }
	    
	    public void EditForAlt() {
	    	util.dummyWait(3);
	    	util.waitUntilElementDisplay(navContactDetails);
 			util.click(navContactDetails);
 			util.dummyWait(1);
	    	util.waitUntilElementDisplay(btnEditAlt);
			util.click(btnEditAlt);
			
	    }
	
	    public void EditForROW() {
	    	util.waitUntilElementDisplay(navContactDetails);
 			util.click(navContactDetails);
 			util.click(navContactDetails);
 			util.dummyWait(1);
	    	util.waitUntilElementDisplay(btnEditRow);
			util.click(btnEditRow);
			
	    }
	    
	    By btnEditDot = By.xpath("//*[contains(@id,'CONTACT_radYALGridControl_ctl00__0')]/.//a[contains(text(),'Edit')]");
	    public void EditForDot() {
	    	util.reloadPage();
	    	util.dummyWait(3);
	    	util.waitUntilElementDisplay(navContactDetails);
 			util.click(navContactDetails);
 			util.dummyWait(1);
	    	util.waitUntilElementDisplay(btnEditDot);
			util.click(btnEditDot);
			
	    }
	
	    public void UpdateRecord(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCOName, value);
			
	    }
	    
	    public void UpdateRecordDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(CONameDot, value);
			
	    }
	
	    public void SaveUpdate() {
	    	util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			
	    }
	    By LinkCommentDot = By.xpath("//a[@id='CoContactLink']");
	    public void ClickOnLinkCommentDot() {
	    	util.waitUntilElementDisplay(LinkCommentDot);
	    	util.click(LinkCommentDot);
			
	    }
	
	    public void ClickOnLinkComment() {
	    	util.waitUntilElementDisplay(linkComment);
	    	util.click(linkComment);
			
	    }
	    
	    public void ActivityDate(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtActivityDate, value);
			
	    }
	    
	    public void addComment(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtComment, value);
			
	    }
	    
	    public void SaveComment() {
	    	util.waitUntilElementDisplay(btnSaveComment);
	    	util.click(btnSaveComment);
			
	    }
	    
	    public void CommentHistory() {
	    	util.waitUntilElementDisplay(btnCommentHistory);
	    	util.click(btnCommentHistory);
			
	    }
	    
	    public void DeleteComment() {
	    	util.waitUntilElementDisplay(btnDelete);
	    	util.click(btnDelete);
            util.dummyWait(1);
	    }
	    
	    public void ClickOnOk() {
	    	util.waitUntilElementDisplay(btnOK);
	    	util.click(btnOK);
	    	util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	    }
	    
	    public void ClosePopup() {
	    	util.switchToDefaultContent();
	    	util.waitUntilElementDisplay(btnCloseComment);
	    	util.click(btnCloseComment);
	    }
	    
	    public void addNewRecordUnderComment() {
	    	util.waitUntilElementDisplay(btnAddNewRecord);
	    	util.click(btnAddNewRecord);
			util.dummyWait(1);
	    }
	    
	    public void addNewRecordUnderCommentRow() {
	    	util.waitUntilElementDisplay(btnAddNewRecord);
	    	util.click(btnAddNewRecord);
			util.dummyWait(1);
			util.click(btnAddNewRecord);
	    }
	    
	    public void addAddressLine1(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAddressLine1, value);
			
	    }
	    
	    public void addAddressLine2(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAddressLine2, value);
			
	    }
	    
	    public void addAddressLine3(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAddressLine3, value);
			
	    }
	    
	    public void addAddressLine4(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAddressLine4, value);
			
	    }
	    
	    public void AddCity(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCity, value);
			
	    }
	    
	    public void SelectState(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpState, value);
			
	    }
	    
	    public void SelectStateRow(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpStateRow, value);
			
	    }
	    
	    public void addZipCode(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtZipCode, value);
			
	    }
	    
	    public void InsertRecord() {
	    	util.waitUntilElementDisplay(btnInsert);
	    	util.click(btnInsert);
			
	    }
	    
	    public void EditComment() {
	    	util.waitUntilElementDisplay(btnEditComment);
	    	util.click(btnEditComment);
			
	    } 
	    
	    public void AddContact() {
	    	util.waitUntilElementDisplay(btnAddContact);
	    	util.click(btnAddContact);
			
	    }
	    public void addNameForALT(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtNameForALT, value);
			
	    }
	    public void addLastNameContact(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtLastNameadd, value);
			
	    }
	    
	    public void addFirstNameContact(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtFirstNameadd, value);
			
	    }
	    
	    public void addMiddleNameContact(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtMiddleNameadd, value);
			
	    }
	    
	    public void addHomePhoneNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtHomePhone, value);
			
	    }
	    
	    public void addCellPhoneNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCellPhone, value);
			
	    }
	    
	    public void addWorkPhoneNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtWorkPhone, value);
			
	    }
	    
	    public void addFaxPhoneNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtFaxPhone , value);
			
	    }
	    
	    public void addEmail(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtEmail, value);
			
	    }
	    
	    public void ClickOnPreferredContact() {
	    	util.waitUntilElementDisplay(chcPreferredContact);
	    	util.click(chcPreferredContact);
			
	    }
	    
	    
	    public void ClickOnSaveContact() {
	    	util.waitUntilElementDisplay(btnSaveContact);
	    	util.click(btnSaveContact);
			
	    }
	    
	    public void ClickOnDeleteContct() {
	    	util.click(btnDeleteContact);
			driver.switchTo().alert().accept();
	    }    
	    
	    public void ClickOnUpdateContact() {
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnUpdateContact);
	    	util.click(btnUpdateContact);
	    }
	    
  By drpcontactinfo = By.xpath("//input[contains(@id,'_ddlContactFor_Input') and @type='text']");
	    
	    public void addContactInfoFor(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpcontactinfo, value);
	    }

	
	    public void AddnewContact(Map<String, String> map, String testcaseName) {
	    	util.dummyWait(5);
           if(testcaseName.contains("DOT")) {
        	   try {
   	    		navigateToContatDetails();
   				log("STEP 1: The 'AMPS:Manage Landowner & Contacts' popup displays with fields  ", Status.PASS);
   			} catch (Exception e) {
   				log("STEP 1:  The panel does not expand ", Status.FAIL);
   				throw new RuntimeException("User cannot see the option in Menu");
   			}

   	    	 try {
   	    		 AddnewContact(); 
    				log("STEP 1: The 'AMPS:Manage Landowner & Contacts' popup displays with fields  ", Status.PASS);
   				} catch (Exception e) {
   					log("STEP 1:  The panel does not expand ", Status.FAIL);
   					throw new RuntimeException("Failed in step 1");
   				}
   	     
   	    
   	       try {
   	    		 util.switchToIframe(frmFull);
   	    		 VerifyCheckbox();
   	 			log("STEP 2: Checkbox is auto checked ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 2:  Active checkbox is not auto checked", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 2");
   	 		 }
   	       
   	       try {
   		    	 AddExistingContactDot(map.get(Excel.ExistingContact));
   		 			log("STEP 3: Added value displays in Existing Contact field    ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 3:  User  cannot select  value  from Existing Contact DD     ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 3");
   		 		 } 

   	    	   try {
   		    	   VerifyParcelPrimaryCheckboxDot();
   		 			log("STEP 4:  Checkbox can be checked   ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 4:  User cannot check the checkbox  ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 4");
   		 		 }

   	    	 if(util.isElementVisible(LastnameDot)) {
   	    	 try {
   	    		 AddLastNameDot(map.get(Excel.LastName));
   	 			log("STEP 5: User can enter a value in LastName field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 5:  User cannot add a value in LastName field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 5");
   	 		 }
   	    	 }
   	    	 
   	    	if(util.isElementVisible(FirstNameDot)) {
   	    	 try {
   	    		 AddFirstNameDot(map.get(Excel.FirstName));
   	 			log("STEP 6: User can enter a value in FirstName field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 6:  User cannot add a value in FirstName field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 6");
   	 		 }
   	    	}
   	    	
   	    	if(util.isElementVisible(MiddleNameDot)) {
   	    	 try {
   	    		 AddMiddleNameDot(map.get(Excel.MiddleName));
   	 			log("STEP 7: User can enter a value in MiddleName field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 7:  User cannot add a value in MiddleName field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 7");
   	 		 }
   	    	}
   	    	
   	    	if(util.isElementVisible(TitleDot)) {
   	    	 try {
   	    		 AddTitleDot(map.get(Excel.TITLE));
   	 			log("STEP 8: User can enter a value in TITLE field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 8:  User cannot add a value in TITLE field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 8");
   	 		 }
   	    	}
   	    	
   	    	 try {
   	    		 AddEntityNameDot(map.get(Excel.EntityName));
   	 			log("STEP 9: User can enter a value in Entity Name field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 9:  User cannot add a value in Entity Name field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 9");
   	 		 }
   	    	 
//   	    	 try {
//   	    		AddEntityTypeDot(map.get(Excel.EntityType));
//   	 			log("STEP 14: Added value displays in the field   ", Status.PASS);
//   	 		 } catch (Exception e) {
//   	 			log("STEP 14:  User  cannot select  value  from the DD    ", Status.FAIL);
//   	 			throw new RuntimeException("Failed in step 14");
//   	 		 }
   	    	
   	    	if(util.isElementVisible(SuffixDot)) {
   	    	 try {
   	    		 AddSuffixDot(map.get(Excel.Suffix));
   	 			log("STEP 10: User can enter a value in Suffix field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 10:  User cannot add a value in Suffix field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 10");
   	 		 }
   	    	}
   	    	
   	    	if(util.isElementVisible(CONameDot)) {
   	    	 try {
   	    		 AddCONameDot(map.get(Excel.COName));
   	 			log("STEP 11: User can enter a value in COName field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 11:  User cannot add a value in COName field    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 11");
   	 		 }
   	    	}
   	    	
   	    	if(util.isElementPresent(txtMaritalStatus)) {
   	    	 try {
   	    		 AddMaritalStatusDot(map.get(Excel.MaritalStatus));
   	 			log("STEP 12: Added value displays in Marital Status field   ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 12:  User  cannot select  value  from Marital Status DD    ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 12");
   	 		 }
   	    	
   	    	}
   	    	 try {
   	    		 SaveDot();
   	 			log("STEP 13: Message - 'Message - 'New landowner has created and added to the parcel.' in green displays     ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 13:  Added Landowner record does not display in grid      ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 13");
   	 		 }
   	       
   	       
   	    	 try {
   	    		 Close();                                                 //step is missing popup is opened
   	 			log("STEP 14: Close Button Clicked  ", Status.PASS);
   	 		 } catch (Exception e) {
   	 			log("STEP 14:  Close Button not Clicked     ", Status.FAIL);
   	 			throw new RuntimeException("Failed in step 14");
   	 		 }
   	    	
   	    	 
   	    		 try {
   		    		 util.dummyWait(4);
   		 			EditForDot();
   		 			log("STEP 15:  Added Contact opens in new tab on browser  ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 15: On Edit Added Contact does not opens in new tab on browser   ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 15");
   		 		 }
   	    	 
   	    	  
   	    	  Set<String> windowId = driver.getWindowHandles(); // get window id of current window
   	  		Iterator<String> itererator = windowId.iterator();

   	  		String mainWinID = itererator.next();
   	  		String newAdwinID = itererator.next();

   	  		driver.switchTo().window(newAdwinID);
   	    	  
   	       
   	    	  try {
   		    		 util.dummyWait(4);
   		    		 UpdateRecordDot(map.get(Excel.UpdatedCOName));
                     log("STEP 16: User can enter a value in COName field   ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 16:  User cannot add a value in COName field    ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 16");
   		 		 }
   	       
   	        	try {
   	    		  SaveDot();
		 			log("STEP 17:User can save the contact ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 17:  User cannot save the contact ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 17");
		 		 }
   	    	  
   	    	  
   	    	  try {
   		    		 ClickOnLinkCommentDot();
   		 			log("STEP 18: Comments popup open with Review comments & comment history  tab    ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 18:  Comment popup does not open   ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 18");
   		 		 }
   		    	 
   		    	 
   		    	 try {
   		    		 util.switchToIframe(frmComments);
   		    		 ActivityDate(map.get(Excel.ActivityDate));
   		 			log("STEP 19: selected date display in ActivityDate Filed  ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 19:  selected date not display in ActivityDate Filed   ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 19");
   		 		 }
   		    	 
   		    	 try {
   		    		 addComment(map.get(Excel.Comment));
   		 			log("STEP 20: Entered value display  in Comment Filed  ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 20:  Entered value does not display  in Comment Filed  ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 20");
   		 		 }
   		    	 
   		    	 
   		    	 try {
   		    		 SaveComment();
   		 			log("STEP 21: Message - 'Message - 'Changes saved successfully' in green displays    ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 21:  Message - 'Message - 'Changes saved successfully' does not displays    ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 21");
   		 		 }
   		    	 
   		    	 try {
   		    		 CommentHistory();
   		 			log("STEP 22:  Above added comments should display in the grid     ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 22:  Above added comments should not display in the grid   ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 22");
   		 		 }
   		    	 
   		    	 try {
   		    		 DeleteComment();
   		 			log("STEP 23: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record  ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 23:  The delete pop window does not display    ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 23");
   		 		 }
   		    	 
   		    	 try {
   		    		 ClickOnOk();
   		 			log("STEP 24: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record  ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 24:  The delete pop window does not display    ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 24");
   		 		 }
   		    	 
   		    	 try {
   		    		 ClosePopup();
   		 			log("STEP 25: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record  ", Status.PASS);
   		 		 } catch (Exception e) {
   		 			log("STEP 25:  The delete pop window does not display    ", Status.FAIL);
   		 			throw new RuntimeException("Failed in step 25");
   		 		 }
   		    	 util.dummyWait(2);
   		    	driver.close();
	    		 driver.switchTo().window(mainWinID);
	    		 util.dummyWait(2);
           }
	    	
           else {	
        	   
        	   
	    	try {
	    		navigateToContatDetails();
				log("STEP 1: The 'AMPS:Manage Landowner & Contacts' popup displays with fields  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  The panel does not expand ", Status.FAIL);
				throw new RuntimeException("User cannot see the option in Menu");
			}
	    	
	    	
	       if(testcaseName.contains("ROW") || testcaseName.contains("TRA"))
	    	 {  
	    	try {
	    		AddnewContactForROW();
				log("STEP 1: The panel fields displays ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  The panel does not expand ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	     }
	    	 else {
	    		
	    	 try {
	    		 AddnewContact(); 
					log("STEP 1: The 'AMPS:Manage Landowner & Contacts' popup displays with fields ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1:  The panel does not expand ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
	     }
	    
	       try {
	    		 util.switchToIframe(frmFull);
	    		 VerifyCheckbox();
	 			log("STEP 2: Checkbox is auto checked   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: Active checkbox is not auto checked   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	       
	      try {
	    		 AddExistingContact(map.get(Excel.ExistingContact));
	 			log("STEP 3:  select value from Existing Contact dd     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3:  User  cannot select  value  from Existing Contact DD     ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	        
	     
	        if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
//	    	   try {
//	    		   VerifyParcelPrimaryCheckboxRow();
//		 			log("STEP 4: Checkbox can be checked    ", Status.PASS);
//		 		 } catch (Exception e) {
//		 			log("STEP 4: User cannot check the checkbox    ", Status.FAIL);
//		 			throw new RuntimeException("Failed in step 4");
//		 		 } 
	    	   
	    	   try {
		    		// CheckContactFor();
		 			log("STEP 5: Added value displays in the field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 5: No value displays in the Dropdown    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 5");
		 		 }
		    	
	       }
	       
	       else
	       {
	       try {
	    	   VerifyParcelPrimaryCheckbox();
	 			log("STEP 4: Checkbox can be checked    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: User cannot check the checkbox    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	       
	       try {
	    		 AddContactType(map.get(Excel.ContactType));
	 			log("STEP 5: Added value displays in Contact Type field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: No value displays in Contact Type Dropdown   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	       
	       } 

	 
	    	 try {
	    		 AddLastName(map.get(Excel.LastName));
	 			log("STEP 6: User can enter a value in LastName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6:  User cannot add a value in LastName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
   	 
	    	 try {
	    		 AddFirstName(map.get(Excel.FirstName));
	 			log("STEP 7: User can enter a value in FirstName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7:  User cannot add a value in FirstName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	
	    	 try {
	    		 AddMiddleName(map.get(Excel.MiddleName));
	 			log("STEP 8: User can enter a value in MiddleName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8:  User cannot add a value in MiddleName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	
	    	 try {
	    		 AddTitle(map.get(Excel.TITLE));
	 			log("STEP 9: User can enter a value in TITLE field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 9:  User cannot add a value in TITLE field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 9");
	 		 }
	    	 
	    	 try {
	    		 AddEntityName(map.get(Excel.EntityName));
	 			log("STEP 10: User can enter a value in EntityName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 10:  User cannot add a value in EntityName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 10");
	 		 }
	    	 
//	    	 try {
//	    		 AddEntityType(map.get(Excel.EntityType));
//	 			log("STEP 14: Added value displays in the field   ", Status.PASS);
//	 		 } catch (Exception e) {
//	 			log("STEP 14:  User  cannot select  value  from the DD    ", Status.FAIL);
//	 			throw new RuntimeException("Failed in step 14");
//	 		 }
	    	 
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    	
	    		 if(util.isElementVisible(txtContactNumber)) {
	    	 try {
	    		 AddContactNumber(map.get(Excel.ContactNumber));
	 			log("STEP 11: User can enter a value in ContactNumber field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 11:  User cannot add a value in ContactNumber field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 11");
	 		 }
	    		 }
	    }	
	    	 
	    	 try {
	    		 AddSuffix(map.get(Excel.Suffix));
	 			log("STEP 12: User can enter a value in Suffix field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 12:  User cannot add a value in Suffix field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 12");
	 		 }
	    	
	    	 if(util.isElementVisible(txtCOName)) {
	    	 try {
	    		 AddCOName(map.get(Excel.COName));
	 			log("STEP 13: User can enter a value in COName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 13:  User cannot add a value in COName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 13");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementPresent(txtMaritalStatus)) {
	    	
	    	 try {
	    		 AddMaritalStatus(map.get(Excel.MaritalStatus));
	 			log("STEP 14: Added value displays in Marital Status field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 14:  User  cannot select  value  from Marital Status DD    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 14");
	 		 }
	    	 }
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    	 
	    		 if(util.isElementPresent(drpW9Flag)) {
	    		 try {
	    		 AddW9Flag(map.get(Excel.W9Flag));
	 			log("STEP 15: Added value displays in W9Flag field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 15: User  cannot select  value  from W9Flag DD   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 15");
	 		 }
	    		 }
	    		  
	    	if(!environment.contains("CONNECTGEN")) {
	    		
	    		if(util.isElementPresent(drpPaymentMethod)) {
	    	 try {
	    		 AddPaymentMethod(map.get(Excel.PaymentMethod));
	 			log("STEP 16: Added value displays in Payment Method field    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 16:  User  cannot select  value  from Payment Method DD   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 16");
	 		 }
	    		}
	    	}
	    }
	    	 if(!environment.contains("CONNECTGEN")) {
	    	 try {
	    		 AddVendor(map.get(Excel.Vendor));
	 			log("STEP 17: User can enter a value in Vendor field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 17:  User cannot add a value in Vendor field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 17");
	 		 }
	    	 }
	    	 try {
	    		 Save();
	 			log("STEP 18: Message - 'Message - 'New landowner has created and added to the parcel.' in green displays     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 18: Message - 'Message - 'New landowner has created and added to the parcel.' does not displays    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 18");
	 		 }
	    	 Close(); 
         	util.dummyWait(3);
	    	
	    	  if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL"))
	      {		  
	    	 try {
	    		 util.dummyWait(4);
	 			EditForAlt();
	 			log("STEP 19:  Added Landowner opens in new tab on browser  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 19: On Edit Added Landowner does not opens in new tab on browser   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 19");
	 		 }
	   	  }
	    	 else
	    	 {
	    		 try {
		    		 util.dummyWait(4);
		 			EditForROW();
		 			log("STEP 19:  Added Landowner opens in new tab on browser  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 19: On Edit Added Landowner does not opens in new tab on browser   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 19");
		 		 }
	    	 }
	    	  
	    	  Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		  		Iterator<String> itererator = windowId.iterator();

		  		String mainWinID = itererator.next();
		  		String newAdwinID = itererator.next();

		  		driver.switchTo().window(newAdwinID);
	    	  
		  		if(util.isElementVisible(txtCOName)) {
	    	  try {
		    		 util.dummyWait(4);
		    		 UpdateRecord(map.get(Excel.UpdatedCOName));
		 			log("STEP 20:  User can update a value in COName field/s       ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 20:   User cannot update a value in COName field/s        ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 20");
		 		 }
		  	}
	    	  try {
	    		  SaveUpdate();
		 			log("STEP 21: User can update contact details record  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 21:   User cannot update contact details record ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 21");
		 		 }
	    	  
	    	  
	    	  if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    	  try {
		    		 ClickOnLinkComment();
		 			log("STEP 22: Comments popup open with Review comments & comment history  tab    ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 22:  Comment popup does not open   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 22");
		 		 }
		    	 
		    	 
		    	 try {
		    		 util.switchToIframe(frmComments);
		    		 ActivityDate(map.get(Excel.ActivityDate));
		 			log("STEP 23: selected date display in Activity Date Feild   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 23:  selected date not display in Activity Date Feild   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 23");
		 		 }
		    	 
		    	 try {
		    		 addComment(map.get(Excel.Comment));
		 			log("STEP 24: Entered value display in Comment Feild   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 24:  Entered value does not display in Comment Feild   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 24");
		 		 }
		    	 
		    	 
		    	 try {
		    		 SaveComment();
		 			log("STEP 25: Message - 'Message - 'Changes saved successfully' in green displays    ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 25:  Message - 'Message - 'Changes saved successfully' does not displays    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 25");
		 		 }
		    	 
		    	 try {
		    		 CommentHistory();
		 			log("STEP 26:  Above added comments should display in the grid     ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 26:  Above added comments should not display in the grid   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 26");
		 		 }
		    	 
		    	 try {
		    		 DeleteComment();
		 			log("STEP 27: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 27:  The delete pop window does not display    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 27");
		 		 }
		    	 
		    	 try {
		    		 ClickOnOk();
		 			log("STEP 28: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 28:  The delete pop window does not display    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 28");
		 		 }
		    	 
		    	 try {
		    		 ClosePopup();
		 			log("STEP 29: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 29:  The delete pop window does not display    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 29");
		 		 }
	    	  } 
	    	  
	    	  if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
		    	 try {
		    		 addNewRecordUnderComment();
		 			log("STEP 30: Grid will expand with fields   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 30: The panel does not expand    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 30");
		 		 }
	    	  }	 
	    	  else {
	    		  try {
			    	addNewRecordUnderCommentRow();
			 			log("STEP 30: Grid will expand with fields   ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 30: The panel does not expand    ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 30");
			 		 }
	    	  }
		    	 
		    	 try {
		    		 util.dummyWait(2);
		    		 addAddressLine1(map.get(Excel.AddressLine1));
		 			log("STEP 31:  User can enter a value in AddressLine1 field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 31:  User cannot add a value in AddressLine1 field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 31");
		 		 }
		    	 if(util.isElementVisible(txtAddressLine2)) {
		    	 try {
		    		 addAddressLine2(map.get(Excel.AddressLine2));
		 			log("STEP 32: User can enter a value in AddressLine2 field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 32:  User cannot add a value in AddressLine2 field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 32");
		 		 }
		    	 }
		    	
		    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
		    		 if(util.isElementVisible(txtAddressLine3)) {
		    		 try {
		    		 addAddressLine3(map.get(Excel.AddressLine3));
		 			log("STEP 33: User can enter a value in AddressLine3 field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 33:  User cannot add a value in AddressLine3 field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 33");
		 		 }
		    		 }
		    		 if(util.isElementVisible(txtAddressLine4)) {
		    	 try {
		    		 addAddressLine4(map.get(Excel.AddressLine4));
		 			log("STEP 34: User can enter a value in AddressLine4 field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 34:  User cannot add a value in AddressLine4 field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 34");
		 		 }
		    		 }
		    }	 
		    	 
		    	 try {
		    		 AddCity(map.get(Excel.City));
		 			log("STEP 35: User can enter a value in City field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 35:  User cannot add a value in City field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 35");
		 		 }
		    	 
		    	 if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
		    		 try {
			    		 SelectStateRow(map.get(Excel.State));
			 			log("STEP 36: Added value displays in State field   ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 36:  No value displays in State Dropdown    ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 36");
			 		 } 
		    	 }
		    	 else {
		    	 try {
		    		 SelectState(map.get(Excel.State));
		 			log("STEP 36: Added value displays in State field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 36:  No value displays in State Dropdown    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 36");
		 		 }
		     } 
		    	 try {
		    		 addZipCode(map.get(Excel.ZipCode));
		 			log("STEP 37: User can enter a value in ZipCode field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 37:  User cannot add a value in ZipCode field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 37");
		 		 }
		    	 
		    	 if(util.isElementVisible(country)){
		    		 isCountryPresent=true;
		    		 try {
			    		util.click(country);
			    		Assert.assertTrue(util.isElementVisible(countryCANADA));
			    		Assert.assertTrue(util.isElementVisible(countryUSA));
			    		util.click(countryDDClose);
			    		COUNTRY= util.getAttributeValue(country, "value");
			 			log("STEP 38: User can see country DD with USA and CANADA values ", Status.PASS);
			 		 } catch (AssertionError e) {
			 			log("STEP 38:  User cannot see country DD with USA and CANADA values", Status.FAIL);
			 		 }
		    	 }
		    	 
		    	 try {
		    		 InsertRecord();
		    		 util.dummyWait(2);
		 			log("STEP 38:  Added address displays in the grid       ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 38:   Added address not displays in the grid        ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 38");
		 		 }
		    	 
		    	 if(isCountryPresent == true) {
		    		 if(!environment.contains("STEELHEAD")) {
		    			 if(!COUNTRY.contains("Select One")) {
			    	 try {
			    		 By countryValidation = By.xpath("(//*[contains(@id,'YALCONTACTWITHNAME_radYALGridControl')]/..//td[text()='"+COUNTRY+"'])[1]");
			    		 Assert.assertTrue(util.isElementVisible(countryValidation));
			 			log("STEP 38:  User can see added Country on grid ", Status.PASS);
			 		 } catch (AssertionError e) {
			 			log("STEP 38:  User cannot see added Country on grid", Status.FAIL);
			 		 }
		    			 }
		    		 }
			    	 }
		    	 
		    	 try {
		    		 
		    		 EditComment();
		 			log("STEP 39:   Record will expand with fields   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 39:  The panel does not expand     ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 39");
		 		 }
		    	 
		    	 try {
		    		 AddContact();
		    		 util.dummyWait(1);
		 			log("STEP 40: User can click on the Add Contact Button ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 40:  User cannot click on the Add Contact Button", Status.FAIL);
		 			throw new RuntimeException("Failed in step 40");
		 		 }
		    	 
		    	 if(!environment.contains("WOLFMIDSTREAM")) {
		    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL") || testcaseName.contains("TRA")) 
		    	 {
		    		 try {
		    			 addNameForALT(map.get(Excel.Name));
			 			log("STEP 41: User can enter a value in Name field   ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 41:  User cannot add a value in Name field    ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 41");
			 		 }
		    	 }
		    	 
		    	 else {
		    	 try {
	    			 addContactInfoFor(map.get(Excel.ContactInfo));
                      util.dummyWait(1);
		 			log("STEP 41: User can enter a value in Contact Info field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 41:  User cannot add a value in Contact Info field    ", Status.FAIL);
		 			driver.close();
		    		 driver.switchTo().window(mainWinID);
		 			throw new RuntimeException("Failed in step 41");
		 		 }
		    }
		    	 }
		    	 try {
		    		 addHomePhoneNumber(map.get(Excel.HomePhone));
		 			log("STEP 42: User can enter a value in HomePhone field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 42:  User cannot add a value in HomePhone field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 42");
		 		 }
		    	 
		    	 try {
		    		 addCellPhoneNumber(map.get(Excel.CellPhone));
		 			log("STEP 43: User can enter a value in CellPhone field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 43:  User cannot add a value in CellPhone field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 43");
		 		 }
		    	 
		    	 try {
		    		 addWorkPhoneNumber(map.get(Excel.WorkPhone));
		 			log("STEP 44: User can enter a value in WorkPhone field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 44:  User cannot add a value in WorkPhone field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 44");
		 		 }
		    	 
		    	 if(util.isElementVisible(txtFaxPhone)) {
		    	 try {
		    		 addFaxPhoneNumber(map.get(Excel.FaxPhone));
		 			log("STEP 45: User can enter a value in FaxPhone field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 45:  User cannot add a value in FaxPhone field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 45");
		 		 }
		    	 }
		    	 
		    	 try {
		    		 addEmail(map.get(Excel.Email));
		 			log("STEP 46: User can enter a value in Email field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 46:  User cannot add a value in Email field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 46");
		 		 }
		    	 
		    	 try {
		    		 ClickOnPreferredContact();
		 			log("STEP 47: User can check the check box    ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 47:  User cannot check the checkbox   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 47");
		 		 }
		    	 
		    	 
		    	 try {
		    		 ClickOnSaveContact();
		 			log("STEP 48: Contact information should get saved and delete icon will display for added contact  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 48: Contact information not get saved   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 48");
		 		 }
		    	 
		    	 
		    	 try {
		    		 ClickOnDeleteContct();
		 			log("STEP 49: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record    ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 49:  The delete pop window does not display   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 49");
		 		 }
		    	 
		    	 try {
		    		 ClickOnUpdateContact();
		    		 driver.close();
		    		 driver.switchTo().window(mainWinID);
		    		 util.dummyWait(2);
		 			log("STEP 50: Added Contact information should get display on the grid  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 50:  Contact information not get displaying on the grid    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 50");
		 		 }
		    
	    }
		
	    
	  }

}
