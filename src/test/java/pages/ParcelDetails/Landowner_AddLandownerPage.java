package pages.ParcelDetails;

import java.io.File;
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

import extentReports.ExtentTestManager;

public class Landowner_AddLandownerPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String COUNTRY;
	public static boolean isCountryPresent;

	public Landowner_AddLandownerPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	

	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By navLandowner = By.xpath("//span[text()='Landowner' and @class='rpText']");
	By btnAddNew = By.xpath("(//img[@alt='Add New Landowner(s)'])[1]");
	By btnAddNewRow = By.xpath("//input[contains(@id,'_ImgAddLandowner') and @type='image']");
	By Activecheckbox = By.xpath("//input[contains(@id,'IsEntityActive') and @checked='checked']");
	By frmFull = By.xpath("//iframe[@name='AddLandowner']");
	By txtExistingContact = By.xpath("//input[contains(@id,'RadEntityInfo_Input') and @type='text']");
	By txtSurfaceOwnership = By.xpath("//input[contains(@id,'Pct_Ownership') and @type='text']");
	By txtWindOwnership = By.xpath("//input[contains(@id,'PCT_Ownership_Wind') and @type='text']");
	By txtCropOwnership = By.xpath("//input[contains(@id,'PCT_Ownership_Crop') and @type='text']");
	By drpContactType = By.xpath("//input[contains(@id,'Title_of_Rep_ID_radYALDropDownList_Input') and @type='text']");
	By txtLastName = By.xpath("//input[contains(@id,'ENTITY_Last_Name') and @type='text']");
	By txtFirstName = By.xpath("//input[contains(@id,'ENTITY_First_Name') and @type='text']");
	By txtMiddleName = By.xpath("//input[contains(@id,'ENTITY_Middle_Name') and @type='text']");
	By txtTitle = By.xpath("//input[contains(@id,'ENTITY_Title') and @type='text']");
	By drpEntityName = By.xpath("(//input[contains(@id,'ENTITY_Corporation_Trust') and @type='text'])[1]");
	By txtEntityType = By.xpath("//input[contains(@id,'ENTITY_Entity_Type_ID_radYALDropDownList_Input') and @type='text']");
	By txtContactNumber = By.xpath("//input[contains(@id,'ENTITY_txtContactNum') and @type='text']");
	By txtSuffix = By.xpath("//input[contains(@id,'ENTITY_Suffix') and @type='text']");
	By txtCOName = By.xpath("//input[contains(@id,'ENTITY_CO_Name') and @type='text']");
	By txtMaritalStatus = By.xpath("//input[contains(@id,'ENTITY_Marital_Status_ID_radYALDropDownList_Input') and @type='text']");
	By drpW9Flag = By.xpath("//input[contains(@id,'ENTITY_W9_STATUS_ID_radYALDropDownList_Input') and @type='text']");
	By drpPaymentMethod = By.xpath("//input[contains(@id,'ENTITY_Payment_Method_ID_radYALDropDownList_Input') and @type='text']");
	By txtVendor = By.xpath("//input[contains(@id,'ENTITY_Vendor_ID') and @type='text']");
	By btnSave = By.xpath("//input[@id='btnSaveLO']");
	By ChangesaveSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	By SuccessMassage = By.xpath("//span[contains(text(),'New landowner has created and added to the')]");
	By SuccessMassageRow = By.xpath("//span[text()='New landowner was created and added to the tract.']");
	By PrimaryMsg = By.xpath("//span[text()='No primary address assigned.']");
    By btnClose = By.xpath("//a[@class='rwCloseButton']");   //not validate
	By btnEdit = By.xpath("//tr[contains(@id,'LANDOWNERS_radYALGridControl_ctl00__0')]/.//a[contains(text(),'Edit')]");
	//By btnEdit = By.xpath("//*[contains(@id,'LANDOWNERS_radYALGridControl_ctl00__0')]/td[60]/a");
	By btnParcelAssociation = By.xpath("(//span[@class='rdExpand'])[1]");
	By btnAssociatDocumentsOrsted = By.xpath("//em[text()='Associated Documents']/..//a[@title='Expand']");
	By btnParcelAssociationOrsted = By.xpath("(//span[@class='rdExpand'])[2]");
	By ExpandedParcel = By.xpath("//span[@class='rdCollapse']");
	//By btnRelatedParties = By.xpath("(//span[@class='rdExpand'])[1]");
	By btnRelatedParties = By.xpath("//*[contains(@id,'RadDock1_T')]/ul/li/a");
	By btnRelatedPartiesOrsted = By.xpath("(//span[@class='rdExpand'])[2]");
	By drpRelatedParties = By.xpath("//input[contains(@id,'RadDock1_C_cbRelatedParty_Input') and @type='text']");
	By drpTitleRep = By.xpath("//input[contains(@id,'RadDock1_C_EXEC_ENT_RELN_ID_radYALDropDownList_Input') and @type='text']");
	By btnAdd = By.xpath("//input[contains(@id,'RadDock1_C_btnAddRelatedParty') and @type='image']");
	By btnAddNewRecord = By.xpath("//input[@id='RadDock1_C_btnAddnew']");
	
	By btnRefresh = By.xpath("//input[@id='RadDock1_C_btnRefreshList']");
	//By btnAssociatedDocuments = By.xpath("(//ul[@class='rdCommands'])[3]");
	By btnAssociatedDocuments = By.xpath("//*[contains(@id,'RadDock10_T')]/ul/li/a/span");
	By expandAss = By.xpath("//*[contains(@id,'RadDock10_T')]/ul/li/a/span");
	By btnAssociatedDocumentsOrsted = By.xpath("//em[text()='Associated Documents']/..//a[@title='Expand']");
	By btnAddDocuments = By.xpath("//input[contains(@id,'RadDock10_C_btnAddDocuments') and @type='submit']");
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
	By btnSelectDocumnet = By.xpath("//span[contains(text(),'Select')]");
	By drpCategory = By.xpath("//select[@id='RadPanelBar1_i0_i0_rauFileUploadCategory0']");
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc0') and @type='text']"); 
	By btnLoadDocuments = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_buttonSubmit_input') and @type='submit']");
	By btnExternalLink = By.xpath("(//span[@class='rpExpandHandle'])[2]");
	By txtDocumentName = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtname1') and @type='text']");
	By txtExternalLink = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtlinkname1') and @type='text']");
	By drpCategoryExelink = By.xpath("//input[contains(@id,'_radYALDropDownList_Input') and @type='text']");
	By txtDescriptionExelink = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtDynamic1') and @type='text']");
	By btnLoadDocumentsExeLink = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_btnSave_input') and @type='submit']");
	By btnAddExeLink = By.xpath("//input[@id='RadPanelBar2_i0_i0_btnAdd_input']");
	By btnCloseDocuments = By.xpath("//a[@class='rwCloseButton']");
	By linkViewDocuments = By.xpath("(//a[text()='View Document'])[2]");
	By linkComments = By.xpath("//a[@id='LOCommentsLink']");
	By frmComments = By.xpath("//iframe[@name='GeneralComments']");
	By txtActivityDate = By.xpath("//input[contains(@id,'idGeneralComments_Activity_Date_dateInput') and @type='text']");
	By txtComment = By.xpath("//textarea[@id='idGeneralComments_Comments']");
	By btnSaveComment = By.xpath("//input[@id='idGeneralComments_btnSave1']");
	By btnCommentHistory = By.xpath("//span[contains(text(),'Comments History')]");
	By btnDelete = By.xpath("//input[contains(@id,'_ctl04_gbcDeleteAlignment') and @type='image']");
	By frmDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnOK = By.xpath("//span[text()='OK']");
	By btnCloseComment = By.xpath("//a[@class='rwCloseButton']");
	By btnAddRecordUnderComment = By.xpath("//img[@id='YALCONTACTWITHNAME_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By txtAddressLine1 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_1') and @type='text']");
	By txtAddressLine2 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_2') and @type='text']");
	By txtAddressLine3 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_3') and @type='text']");
	By txtAddressLine4 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_4') and @type='text']");
	By txtCity = By.xpath("//input[contains(@id,'_EditFormControl_City') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'_State_ABB_radYALDropDownList_Input') and @type='text']");
	By txtZipCode = By.xpath("//input[contains(@id,'_EditFormControl_Zip_Code') and @type='text']");
	By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert') and @type='submit']");
	By btnEditComment = By.xpath("(//input[contains(@id,'YALCONTACTWITHNAME_radYALGridControl_ctl00_ctl04_EditButton') and @type='image'])[1]");
	By btnAddContact = By.xpath("//input[contains(@id,'_EditFormControl_btnAddItem') and @type='submit']");
	By txtLastNameadd = By.xpath("//input[contains(@id,'_Last_Name_Footer') and @type='text']");
	By txtFirstNameadd = By.xpath("//input[contains(@id,'_First_Name_Footer') and @type='text']");
	By txtMiddleNameadd  = By.xpath("//input[contains(@id,'_Middle_Name_Footer') and @type='text']");
	By txtNameForALT = By.xpath("//input[contains(@id,'_Full_Name_Footer') and @type='text']");
	By txtHomePhone = By.xpath("//input[contains(@id,'_Home_Phone_Footer') and @type='text']");
	By txtCellPhone = By.xpath("//input[contains(@id,'_Cell_Phone_Footer') and @type='text']");
	By txtWorkPhone = By.xpath("//input[contains(@id,'_Work_Phone_Footer') and @type='text']");
	By txtFaxPhone  = By.xpath("//input[contains(@id,'_FAX_NUMBER_Footer') and @type='text']");
	By txtEmail  = By.xpath("//input[contains(@id,'_Email_Footer') and @type='text']"); 
	By chcPreferredContact = By.xpath("(//label[text()='Preferred Contact'])[1]");
	By btnSaveContact = By.xpath("//input[contains(@id,'_EditFormControl_btnSaveItem') and @type='submit']");
	By btnDeleteContact = By.xpath("//input[@id='YALCONTACTWITHNAME_radYALGridControl_ctl00_ctl05_EditFormControl_rptOracleSupplierInfo_ctl01_DeleteInfo']") ;
//alert
	By btnUpdateContact = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
	
	
	
	 public void navigateParcelInformation() {
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
			
		}
	 
	    public void AddnewLandownerRow() {
	    	util.waitUntilElementDisplay(navLandowner);
			util.click(navLandowner);
			util.dummyWait(1);
			util.waitUntilElementDisplay(btnAddNewRow);
			util.click(btnAddNewRow);
			
	    }
	    
	    public void AddnewLandowner() {
	    	util.waitUntilElementDisplay(navLandowner);
			util.click(navLandowner);
			util.dummyWait(1);
			util.waitUntilElementDisplay(btnAddNew);
			util.click(btnAddNew);
			
	    }
	    
	    
	    
	    public void VerifyCheckbox() {
			Assert.assertTrue(true, "Activecheckbox");
			
	    }
	    
	    public void AddExistingContact(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExistingContact, value);
			
	    }
	    
	    public void AddSurfaceOwnership(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSurfaceOwnership, value);
			
	    }
	    
	    public void AddWindOwnership(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtWindOwnership, value);
			
	    }
	    
	    public void AddCropOwnership(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCropOwnership, value);
			
	    }
	    
	    public void AddContactType(String value) {
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
	    
	    public void AddEntityName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpEntityName, value);
			
	    }
	    
	    public void AddEntityType(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtEntityType, value);
			
	    }
	    
	    public void AddContactNumber(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtContactNumber, value);
			
	    }
	    
	    public void AddSuffix(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSuffix, value);
			
	    }
	    
	    public void AddCOName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCOName, value);
			
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
	    
	    public void Save() {
	    	util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.dummyWait(2);			
			Assert.assertTrue(util.isElementPresent(SuccessMassage), "New landowner has created and added");
			Assert.assertTrue(util.isElementPresent(PrimaryMsg), "No primary address assigned.");
			
	    }
	    
	    public void SaveDot() {
	    	util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.waitUntilElementDisplay(ChangesaveSuccessfully);
	    	Assert.assertTrue(util.isElementPresent(ChangesaveSuccessfully), "Changes saved successfully!");
			
	    }
	    
	    public void SaveROW() {
	    	util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.waitUntilElementDisplay(SuccessMassageRow);
			Assert.assertTrue(util.isElementPresent(SuccessMassageRow), "New landowner was created and added to the tract.");
			
	    }
	    
//	    By frmClose = By.xpath("//div[@id='RadWindowWrapper_ctl00_ConPHRightTop_AddLandowner']");
	    public void Close() {
	    	util.switchToDefaultContent();
	    	util.dummyWait(3);
	    	util.waitUntilElementDisplay(btnClose);
			util.click(btnClose);
			
	    }
	    
	    public void Edit() {
	    	util.waitUntilElementDisplay(navLandowner);
 			util.click(navLandowner);
	    	util.waitUntilElementDisplay(btnEdit);
			util.click(btnEdit);
			
	    }
	    
	    public void EditDot() {
	    	util.reloadPage();
	    	util.dummyWait(3);
	    	util.waitUntilElementDisplay(navLandowner);
 			util.click(navLandowner);
	    	util.waitUntilElementDisplay(btnEdit);
			util.click(btnEdit);
			
	    }
	    
	    public void EditROW() {
	    	util.waitUntilElementDisplay(navLandowner);
 			util.click(navLandowner);
 			util.click(navLandowner);
 			util.dummyWait(1);
	    	util.waitUntilElementDisplay(btnEdit);
			util.click(btnEdit);
			
	    }
	    
	    public void UpdateRecord(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCOName, value);
			
	    }
	    
	    public void ClickOnSaveButton() {
	    	util.waitUntilElementDisplay(btnSave);
	    	util.click(btnSave);
	    	util.waitUntilElementDisplay(ChangesaveSuccessfully);
	    	Assert.assertTrue(util.isElementPresent(ChangesaveSuccessfully), "Changes saved successfully!");
			
	    }
	    
	    
	    public void expandParcelAssociation() {
	    	util.dummyWait(3);
	    	
	    	util.waitUntilElementDisplay(btnParcelAssociation);
			util.click(btnParcelAssociation);
			
	    }
	    
	    public void expandParcelAssociationOrsted() {
	    	util.dummyWait(3);
	    	util.waitUntilElementDisplay(btnParcelAssociationOrsted);
			util.click(btnParcelAssociationOrsted);
			
	    }
	    
	    public void expandRelatedParties(String value) {
			if (!commonFunction.checkNA(value)) {
				//util.inputTextAndPressEnter(drpRelatedParties, value);	
				//util.selectValueFromDropdown(drpRelatedParties, value);
//		      	  util.click(drpRelatedParties);
//		      	  util.pressENTERkey();
				util.inputText(drpRelatedParties, value);
				By selectValue = By.xpath("(//li[contains(text(),'"+value+"')])[1]");
				util.click(selectValue);
			}
			
	    }
	    
//	    public void addRelatedParties(String value) {
//	    	if (!commonFunction.checkNA(value))
//				util.inputTextAndPressTab(drpRelatedParties, value);
			
//	    }
	    
	    public void addTitleRep(String value) {
	    	if (!commonFunction.checkNA(value)) {
	    		//util.inputTextAndPressTab(drpTitleRep, value);
	    		util.selectValueFromDropdown(drpTitleRep, value);
	      	  util.click(drpTitleRep);
	      	  util.pressENTERkey();
	    	}
				
			
	    }
	    
	    By Updatedmassage = By.xpath("//span[text()='Related party added successfully!']");
	    public void Add() {
	    	util.dummyWait(1);
	    	util.waitUntilElementDisplay(btnAdd);
			util.click(btnAdd);
			util.dummyWait(5);
			util.waitUntilElementDisplay(Updatedmassage);
			Assert.assertTrue(util.isElementPresent(Updatedmassage), "Related party added successfully!");
	    }
	    
	    
	  
	    public void Refresh() {
			util.dummyWait(1);
	    	util.waitUntilElementDisplay(btnRefresh);
			util.click(btnRefresh);
			
	    }
	    
	    public void ExpandAssociatedDocuments() {
	    	util.waitUntilElementDisplay(btnAssociatedDocuments);
			util.click(btnAssociatedDocuments);
			
	    }
	    
	    public void ExpandAssociatedDocumentsOrsted() {
	    	util.waitUntilElementDisplay(btnAssociatedDocumentsOrsted);
			util.click(btnAssociatedDocumentsOrsted);
			
	    }
	    
	    public void AddDocuments() {
	    	util.waitUntilElementDisplay(btnAddDocuments);
			util.click(btnAddDocuments);
			
	    }
	    
//	    public void SelectDocument() {
//	    	util.waitUntilElementDisplay(btnSelectDocumnet);
//			util.click(btnSelectDocumnet);
			
//	    }
	    
	    By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
		public void uploadFile() {
			String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
			driver.findElement(fileUpload).sendKeys(filepath);
		}
	    
	    public void SelectCategory(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategory, value);
			
	    }
	    
	    public void AddDescription(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescription, value);
			
	    }
	    
	    public void LoadDocuments() {
	    	util.waitUntilElementDisplay(btnLoadDocuments);
	    	util.click(btnLoadDocuments);
			
	    }
	    
	    public void ClickonExternalLink() {
	    	util.waitUntilElementDisplay(btnExternalLink);
	    	util.click(btnExternalLink);
			
	    }
	    
	    public void AddDocumentName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentName, value);
			
	    }
	    
	    public void AddExternalLink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExternalLink, value);
			
	    }
	    
	    public void AddCategoryForExeLink(String value) {
	    	util.click(drpCategoryExelink);
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategoryExelink, value);
			
	    }
	    
	    public void AddDescriptionExelink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionExelink, value);
			
	    }
	    
	    public void ClickOnLoadDocumentsExeLink() {
	    	util.waitUntilElementDisplay(btnLoadDocumentsExeLink);
	    	util.click(btnLoadDocumentsExeLink);
			
	    }
	    
	    public void ClickOnAddExeLink() {
	    	util.waitUntilElementDisplay(btnAddExeLink);
	    	util.click(btnAddExeLink);
			
	    }
	    
	    public void ClickOnCloseDocument() {
	    	util.switchToDefaultContent();
	    	util.waitUntilElementDisplay(btnCloseDocuments);
	    	util.click(btnCloseDocuments);
			
	    }
	    
	    By btnRefreash = By.xpath("//img[@id='RadDock10_C_LO3Docs_radYALGridControl_ctl00_ctl02_ctl00_Img1']");
	    public void ClickOnViewDocuments() {
	    	util.click(btnRefreash);
	    	util.waitUntilElementDisplay(linkViewDocuments);
	    	util.click(linkViewDocuments);
	    	util.dummyWait(2);
//	    	Set<String> windowId = driver.getWindowHandles(); // get window id of current window
//			Iterator<String> itererator = windowId.iterator();
//			String mainWinID = itererator.next();
//			String newAdwinID = itererator.next();
//			driver.switchTo().window(newAdwinID);
//			driver.close();
//			driver.switchTo().window(mainWinID);
	    	util.switchToWindow();
			driver.close();
			util.dummyWait(2);
			
	    }
	    
	    public void ClickOnLinkComment() {
	    	util.waitUntilElementDisplay(linkComments);
	    	util.click(linkComments);
			
	    }
	    
	    By iframeComment = By.xpath("//iframe[@name='GeneralComments']");
	    public void ActivityDate(String value) {
	    	util.switchToIframe(iframeComment);
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtActivityDate, value);
			
	    }
	    
	    public void addComment(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtComment, value);
			
	    }
	    
	    By massage = By.xpath("//span[text()='Changes saved successfully']"); 
	    public void SaveComment() {
	    	util.waitUntilElementDisplay(btnSaveComment);
	    	util.click(btnSaveComment);
	    	util.waitUntilElementDisplay(massage);
	    	Assert.assertTrue(util.isElementPresent(massage), "Changes saved successfully");
			
	    }
	    
	    public void CommentHistory() {
	    	util.waitUntilElementDisplay(btnCommentHistory);
	    	util.click(btnCommentHistory);
	    	
			
	    }
	    
	    public void DeleteComment() {
	    	util.waitUntilElementDisplay(btnDelete);
	    	util.click(btnDelete);
	    	util.waitUntilElementDisplay(btnOK);
	    	util.click(btnOK);
	    	util.dummyWait(1);
	    	util.waitUntilElementDisplay(ChangesaveSuccessfully);
			Assert.assertTrue(util.isElementPresent(ChangesaveSuccessfully), "Changes saved successfully!");
	    	util.switchToDefaultContent();
	    	util.waitUntilElementDisplay(btnCloseComment);
	    	util.click(btnCloseComment);
			
	    }
	    
	    public void addNewRecordUnderComment() {
	    	util.waitUntilElementDisplay(btnAddRecordUnderComment);
	    	util.click(btnAddRecordUnderComment);
//	    	util.click(btnAddRecordUnderComment);
	    }
	    
	    public void addNewRecordUnderCommentRow() {
	    	util.waitUntilElementDisplay(btnAddRecordUnderComment);
	    	util.click(btnAddRecordUnderComment);
			util.dummyWait(1);
			util.click(btnAddRecordUnderComment);
	    }
	    
	    public void addAddressLine1(String value) {
	    	util.dummyWait(4);
	    	util.waitUntilElementDisplay(txtAddressLine1);
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
	    By StateRow = By.xpath("//input[contains(@id,'_EditFormControl_RadStateABB_Input') and @type='text']");
	   
	    public void SelectStateRow(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(StateRow, value);
			
	    }
	    
	    public void addZipCode(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtZipCode, value);
			
	    }
	    
	    By country = By.xpath("//input[contains(@id,'EditFormControl_ddlCountry_radYALDropDownList_Input')]");
	    By countryUSA = By.xpath("//div[contains(@id,'EditFormControl_ddlCountry_radYALDropDownList_DropDown')]/..//*[text()='USA' or text()='United States']");
	    By countryCANADA = By.xpath("//div[contains(@id,'EditFormControl_ddlCountry_radYALDropDownList_DropDown')]/..//*[text()='Canada']");
	    By countryDDClose = By.xpath("//div[contains(@id,'_EditFormControl_ddlCountry_radYALDropDownList')]/..//a[contains(@id,'Arrow')]");
	    
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
	    
	    By drpcontactinfo = By.xpath("//input[contains(@id,'_ddlContactFor_Footer_radYALDropDownList_Input') and @type='text']");
	    
	    public void addContactInfoFor(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpcontactinfo, value);
			
	    }
	    
	    public void ClickOnPreferredContact() {
	    	util.waitUntilElementDisplay(chcPreferredContact);
	    	util.click(chcPreferredContact);
			util.dummyWait(1);
	    }
	    
	    
	    public void ClickOnSaveContact() {
	    	util.waitUntilElementDisplay(btnSaveContact);
	    	util.click(btnSaveContact);
			util.dummyWait(1);
	    }
	    
	    public void ClickOnDeleteContct() {
	    	util.waitUntilElementDisplay(btnDeleteContact);
	    	util.click(btnDeleteContact);
			driver.switchTo().alert().accept();
	    }    
	    
	    public void ClickOnUpdateContact() {
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnUpdateContact);
	    	util.click(btnUpdateContact);	
	    }
	    
	    public void ClickOnEdit() {
	    	util.waitUntilElementDisplay(btnEditComment);
	    	util.click(btnEditComment);
			
	    } 
	    By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
	    
	    public void AddLandowner(Map<String, String> map, String testcaseName) {
	    	
	    	util.dummyWait(3);
	    	
	       if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM"))
	    	 {  
	    	try {
	    		AddnewLandownerRow();
				log("STEP 1: Log a message in results 'Landowner panel is not available', if panel does not exists in the instance  and skip the steps  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  The panel does not expand ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	     }
	    	 else {
	    		
	    	 try {
	    		 AddnewLandowner(); 
					log("STEP 1:Log a message in results 'Landowner panel is not available', if panel does not exists in the instance  and skip the steps  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1:  The panel does not expand ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
	     }
	    	
	    	 try {
	    		 util.switchToIframe(frmFull);
	    		 VerifyCheckbox();
	 			log("STEP 2: Checkbox is auto checked      ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: Active checkbox is not auto checked    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 try {
	    		 AddExistingContact(map.get(Excel.ExistingContact));
	 			log("STEP 3:   select value from Existing Contact dd    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3:  User  cannot select  value  from Existing Contact DD    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	
	    	 try {
	    		 AddSurfaceOwnership(map.get(Excel.SurfaceOwnership));
	 			log("STEP 4: User can enter a value in Surface Ownership field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4:  User cannot add a value in Surface Ownership field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	
	    	 try {
	    		 AddWindOwnership(map.get(Excel.WindOwnership));
	 			log("STEP 5: User can enter a value in Wind Ownership field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5:  User cannot add a value in Wind Ownership field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	
	    	 try {
	    		 AddCropOwnership(map.get(Excel.CropOwnership));
	 			log("STEP 6: User can enter a value in Crop Ownership field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6:  User cannot add a value in Crop Ownership field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	
	    	 try {
	    		 AddContactType(map.get(Excel.ContactType));
	 			log("STEP 7: User can enter a value in Contact Type field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7:  User cannot add a value in Contact Type field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	
	    	 if(util.isElementVisible(txtLastName)) {
	    	 try {
	    		 AddLastName(map.get(Excel.LastName));
	 			log("STEP 8: User can enter a value in LastName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8:  User cannot add a value in LastName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtFirstName)) {
	    	 try {
	    		 AddFirstName(map.get(Excel.FirstName));
	 			log("STEP 9: User can enter a value in FirstName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 9:  User cannot add a value in FirstName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 9");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtMiddleName)) {
	    	 try {
	    		 AddMiddleName(map.get(Excel.MiddleName));
	 			log("STEP 10: User can enter a value in MiddleName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 10:  User cannot add a value in MiddleName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 10");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtTitle)) {
	    	 try {
	    		 AddTitle(map.get(Excel.TITLE));
	 			log("STEP 11: User can enter a value in TITLE field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 11:  User cannot add a value in TITLE field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 11");
	 		 }
	    	 }
	    	 
	    	 try {
	    		 AddEntityName(map.get(Excel.EntityName));
	 			log("STEP 12: User can enter a value in EntityName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 12:  User cannot add a value in EntityName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 12");
	 		 }
	    	 
//	    	 try {
//	    		 AddEntityType(map.get(Excel.EntityType));
//	 			log("STEP 13: Added value displays in the field   ", Status.PASS);
//	 		 } catch (Exception e) {
//	 			log("STEP 13:  User  cannot select  value  from the DD    ", Status.FAIL);
//	 			throw new RuntimeException("Failed in step 13");
//	 		 }
	    	 if(util.isElementVisible(txtContactNumber)) {
	    	 try {
	    		 AddContactNumber(map.get(Excel.ContactNumber));
	 			log("STEP 14: User can enter a value in Contact Number field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 14:  User cannot add a value in Contact Number field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 14");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtSuffix)) {
	    	 try {
	    		 AddSuffix(map.get(Excel.Suffix));
	 			log("STEP 15: User can enter a value in Suffix field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 15:  User cannot add a value in Suffix field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 15");
	 		 }
	    	 }

	    	 if(util.isElementVisible(txtCOName)) {
	    	 try {
	    		 AddCOName(map.get(Excel.COName));
	 			log("STEP 16: User can enter a value in COName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 16:  User cannot add a value in COName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 16");
	 		 }
	    	 }
	    	 
	    	if(util.isElementPresent(txtMaritalStatus)) {
	    	 try {
	    		 AddMaritalStatus(map.get(Excel.MaritalStatus));
	 			log("STEP 17: Added value displays in Marital Status field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 17:  User  cannot select  value  from Marital Status DD    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 17");
	 		 }
	    	}
	    	
	    	if(util.isElementPresent(drpW9Flag)) {
	    	try {
	    		 AddW9Flag(map.get(Excel.W9Flag));
	 			log("STEP 18: Added value displays in W9Flag field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 18: User  cannot select  value  from W9Flag DD   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 18");
	 		 }
	    	}
	    	
	    	if(!environment.contains("CONNECTGEN")) {
	    		
	    		if(util.isElementPresent(drpPaymentMethod)) {
	    	 try {
	    		 AddPaymentMethod(map.get(Excel.PaymentMethod));
	 			log("STEP 19: Added value displays in Payment Method field    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 19:  User  cannot select  value  from Payment Method DD   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 19");
	 		 }
	    		}
	    		
	    	 try {
	    		 AddVendor(map.get(Excel.Vendor));
	 			log("STEP 20: User can enter a value in Vendor field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 20:  User cannot add a value in Vendor field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 20");
	 		 }
	    	}
	    	
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    	 try {
	    		 Save();
	    		 Close(); 
	 			log("STEP 21: Message - 'Message - 'New landowner has created and added to the parcel.' in green displays     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 21:  Added Landowner record does not display in grid      ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 21");
	 		 }
	    	}
	    	 else if(testcaseName.contains("DOT")){
	    		 try {
		    		 SaveDot();
		    		 Close(); 
		 			log("STEP 21: Message - 'Message - 'New landowner has created and added to the parcel.' in green displays     ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 21:  Added Landowner record does not display in grid      ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 21");
		 		 } 
	    	 }else {
	    		 try {
		    		 SaveROW();
		    		 Close(); 
		 			log("STEP 21: Message - 'Message - 'New landowner was created and added to the tract.' in green displays     ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 21:  Added Landowner record does not display in grid      ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 21");
		 		 }
	    	 }
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    		 try {
		    		 util.dummyWait(2);
		    		 Edit();
		 			log("STEP 22:  Added Landowner opens in new tab on browser  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 22: On Edit Added Landowner does not opens in new tab on browser   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 23");
		 		 }
	    	 }
	    	 else if (testcaseName.contains("DOT"))  {
	    		 try {
		    		 util.dummyWait(2);
		    		EditDot();
		 			log("STEP 22:  Added Landowner opens in new tab on browser  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 22: On Edit Added Landowner does not opens in new tab on browser   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 23");
		 		 }
	    	 }
	    	 else {
	    		 try {
		    		 util.dummyWait(2);
		    		 EditROW();
		 			log("STEP 22:  Added Landowner opens in new tab on browser  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 22: On Edit Added Landowner does not opens in new tab on browser   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 23");
		 		 }
	    	 }

	    	  
	    	  Set<String> windowId = driver.getWindowHandles(); // get window id of current window
	  		Iterator<String> itererator = windowId.iterator();

	  		String mainWinID = itererator.next();
	  		String newAdwinID = itererator.next();

	  		driver.switchTo().window(newAdwinID);
	    	  
	    	if(util.isElementVisible(txtCOName)) {
	    	 try {
	    		 util.dummyWait(2);
	    		 UpdateRecord(map.get(Excel.CONameUpdate));
	 			log("STEP 23: User can update a value in CO Name field/s     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 23: User cannot update a value in CO Name field/s  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 24");
	 		 }
	    	}
	    	
	    	 try {
	    		 ClickOnSaveButton();
	 			log("STEP 24: Message - 'Message - 'Changes saved successfully' in green display ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 24: Message - 'Message - 'Changes saved successfully' does not displays  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 24");
	 		 }
	    	 
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    	 
	    	 try {
	    		 if(testcaseName.contains("ORSTED")) {
	    			 expandParcelAssociationOrsted();
	    		 }else {
	    			 expandParcelAssociation();
	    		 }
	    		
	 			log("STEP 25: User can expand pannel   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 25: User cannot expand pannel   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 25");
	 		 }
	    	
	    	if(util.isElementPresent(btnRelatedParties)) {
	    	 try {
	    		 util.waitUntilElementDisplay(btnRelatedParties);
	 			 util.click(btnRelatedParties);
	    		 expandRelatedParties(map.get(Excel.RelatedParties));
	 			log("STEP 26: User can expand Related Parties pannel   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 26: User cannot expand RelatedParties pannel  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 26");
	 		 }
	    	util.dummyWait(3);

	    	 try {
	    		 addTitleRep(map.get(Excel.Titleofrep));
	 			log("STEP 27:  User can select value from  Title of rep dd    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 27:  User cannot select value from Title of rep dd    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 27");
	 		 }
	    	util.dummyWait(3);
	    	 try {
	    		 Add();
	    		 util.dummyWait(1);
	 			log("STEP 28: related party added sucessfully message will be displayed in gerren color.  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 28:  User cannot click on add  button.    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 28");
	 		 }
	    	
	    	 
	    	 try {
	    		 Refresh();
	 			log("STEP 29: User can click on refresh button  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 29:   User cannot click on refresh button.   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 29");
	 		 }
	    	}else {
	    		ExtentTestManager.info("Related Parties Tab Not Available");
	    	}
	    	
	    	 try {
	    		
	    		 util.dummyWait(2);
	    		 if(util.isElementVisible(btnAssociatedDocumentsOrsted)) {
						util.click(btnAssociatedDocumentsOrsted);
					}
	 			log("STEP 30: The panel grid displays  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 30:  The panel does not expand      ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 30");
	 		 }
	    	 
	    	 try {
	    		 AddDocuments();
	 			log("STEP 31: Document popup window should display with external documents tab     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 31:  The document pop window does not display    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 31");
	 		 }
	    	 
	    	 try {
	    		util.switchToIframe(iframeDocument);
	    		 util.dummyWait(5);
	    		 uploadFile();
	 			log("STEP 32: User can upload document from the system     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 32:  User cannot upload document from the system   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 32");
	 		 }

	    	 
	    	 try {
	    		 util.dummyWait(5);
	    		 util.click(drpCategory);
	    		 SelectCategory(map.get(Excel.Category));
	 			log("STEP 33: Value added displays in Category field      ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 33:  Added value does not display in Category field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 33");
	 		 }
	    	 
	    	 
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	 			log("STEP 34: User can enter a value in Description field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 34:  User cannot add a value in Description field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 34");
	 		 }

	    	 try {
	    		 LoadDocuments();
	 			log("STEP 35: document is loaded     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 35:   docuemnt could not be uploaded.   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 35");
	 		 }
	    	 
	    	 try {
	    		 ClickonExternalLink();
	 			log("STEP 36: panel is expanded & fields are visible.     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 36:  Panel is not expanded    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 
	    	 try {
	    		 AddDocumentName(map.get(Excel.DocumentName1));
	 			log("STEP 37: User can enter a value in Document Name field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 37:  User cannot add a value in Document Name field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 37");
	 		 }
	    	 
	    	 
	    	 try {
	    		 AddExternalLink(map.get(Excel.ExternalLink1));
	 			log("STEP 38: User can enter a value in External Link field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 38:  User cannot add a value in External Link field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 38");
	 		 }
	    	 
	    	 try {
	    		 AddCategoryForExeLink(map.get(Excel.CategoryExelink));
	 			log("STEP 39: User can enter a value in Category field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 39:  User cannot add a value in Category field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 39");
	 		 }
	    	 
	    	 try {
	    		 AddDescriptionExelink(map.get(Excel.DescriptionExelink));
	 			log("STEP 40: User can enter a value in Description field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 40:  User cannot add a value in Description field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 40");
	 		 }
	    	 
	    	 try {
	    		 ClickOnLoadDocumentsExeLink();
	 			log("STEP 41: document is loaded     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 41: document could not be uploaded   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 41");
	 		 }
	    	 
	    	 try {
	    		 util.waitFor(500);
	    		 ClickOnAddExeLink();
	 			log("STEP 42:  User can click on add button.      ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 42:  User cannot click on add button.    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 42");
	 		 }
	    	 
	    	 try {
	    		 ClickOnCloseDocument();
	 			log("STEP 43: POpup should get closed   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 43:  popup does not get closed    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 43");
	 		 }
	    	 
	    	 try {
	    		 ClickOnViewDocuments();
	    		 driver.switchTo().window(newAdwinID);
	 			log("STEP 44: POpup should get closed   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 44:  popup does not get closed    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 44");
	 		 }
	    	 
	     }
	    	 
	    	 try {
	    		 ClickOnLinkComment();
	 			log("STEP 45: Comments popup open with Review comments & comment history  tab    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 45:  Comment popup does not open   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 45");
	 		 }
	    	 
	    	 
	    	 try {
	    		 ActivityDate(map.get(Excel.ActivityDate));
	 			log("STEP 46: selected Activity Date display    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 46:  selected Activity Date not display    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 46");
	 		 }
	    	 
	    	 try {
	    		 addComment(map.get(Excel.Comment));
	 			log("STEP 47: Entered value in  display in Comment Field    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 47:  Entered value does not display in Comment Field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 47");
	 		 }
	    	 
	    	 
	    	 try {
	    		 SaveComment();
	 			log("STEP 48: Message - 'Message - 'Changes saved successfully' in green displays    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 48:  Message - 'Message - 'Changes saved successfully' does not displays    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 48");
	 		 }
	    	 
	    	 try {
	    		 CommentHistory();
	 			log("STEP 49:  Above added comments should display in the grid     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 49:  Above added comments should not display in the grid   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 49");
	 		 }
	    if(testcaseName.contains("DOT")) {	 
	    	 try {
	    		 DeleteComment();
	 			log("STEP 50: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 50:  The delete pop window does not display    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 50");
	 		 }
	    	 
	    	 driver.close();
    		 driver.switchTo().window(mainWinID);
    		 util.dummyWait(2);
	    }	 
	    else { 
	    	 try {
	    		 DeleteComment();
	 			log("STEP 50: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 50:  The delete pop window does not display    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 50");
	 		 }
	    
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")) {
	    		 try {
		    		 addNewRecordUnderComment();
		 			log("STEP 51: Grid will expand with fields   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 51: The panel does not expand    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 51");
		 		 }
	    	 }
	    	 else {
	    		 try {
				   	addNewRecordUnderCommentRow();
				 		log("STEP 51: Grid will expand with fields   ", Status.PASS);
				 	 } catch (Exception e) {
				 		log("STEP 51: The panel does not expand    ", Status.FAIL);
				 		throw new RuntimeException("Failed in step 51");
				 	 }
	    	 }
	    	 
	    	 try {
	    		 util.dummyWait(2);
	    		 addAddressLine1(map.get(Excel.AddressLine1));
	 			log("STEP 52:  User can enter a value in Address Line1 field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 52:  User cannot add a value in Address Line1 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 52");
	 		 }
	    	 if(util.isElementVisible(txtAddressLine2)) {
	    	 try {
	    		 addAddressLine2(map.get(Excel.AddressLine2));
	 			log("STEP 53: User can enter a value in Address Line2 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 53:  User cannot add a value in Address Line2 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 53");
	 		 }
	    	 }
	    	 if(util.isElementVisible(txtAddressLine3)) {
	    	 try {
	    		 addAddressLine3(map.get(Excel.AddressLine3));
	 			log("STEP 54: User can enter a value in Address Line3 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 54:  User cannot add a value in Address Line3 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 54");
	 		 }
	    	 }
	    	 if(util.isElementVisible(txtAddressLine4)) {
	    	 try {
	    		 addAddressLine4(map.get(Excel.AddressLine4));
	 			log("STEP 55: User can enter a value in Address Line4 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 55:  User cannot add a value in Address Line4 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 55");
	 		 }
	    	 }
	    	 
	    	 try {
	    		 AddCity(map.get(Excel.City));
	 			log("STEP 56: User can enter a value in City field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 56:  User cannot add a value in City field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 56");
	 		 }
	    	 
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    	 try {
	    		 SelectState(map.get(Excel.State));
	 			log("STEP 57: Added value displays in State field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 57:  No value displays in State Dropdown    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 57");
	 		 }
	    }	
	    	 else {
	    		 try {
		    		 SelectStateRow(map.get(Excel.State));
		 			log("STEP 57: Added value displays in State field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 57:  No value displays in State Dropdown    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 57");
		 		 }
	    	 }
	    		 
	    	 try {
	    		 addZipCode(map.get(Excel.ZipCode));
	 			log("STEP 58: User can enter a value in Zip Code field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 58:  User cannot add a value in Zip Code field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 58");
	 		 }
	    	 
	    	 if(util.isElementVisible(country)){
	    		 isCountryPresent=true;
	    		 try {
		    		util.click(country);
		    		Assert.assertTrue(util.isElementVisible(countryCANADA));
		    		Assert.assertTrue(util.isElementVisible(countryUSA));
		    		util.click(countryDDClose);
		    		COUNTRY= util.getAttributeValue(country, "value");
		 			log("STEP 59: User can see country DD with USA and CANADA values ", Status.PASS);
		 		 } catch (AssertionError e) {
		 			log("STEP 59:  User cannot see country DD with USA and CANADA values", Status.FAIL);
		 		 }
	    	 }
	    	 
	    	 try {
	    		 InsertRecord();
	    		 util.dummyWait(2);
	 			log("STEP 60:  Added address displays in the grid       ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 60:   Added address not displays in the grid        ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 60");
	 		 }
	    	 
	    	 if(isCountryPresent == true) {
	    		 if(!environment.contains("STEELHEAD")) {
	    			 if(!COUNTRY.contains("Select One")) {
	    	 try {
	    		 By countryValidation = By.xpath("(//*[contains(@id,'YALCONTACTWITHNAME_radYALGridControl')]/..//td[text()='"+COUNTRY+"'])[1]");
	    		 Assert.assertTrue(util.isElementVisible(countryValidation));
	 			log("STEP 61:  User can see added Country on grid ", Status.PASS);
	 		 } catch (AssertionError e) {
	 			log("STEP 61:  User cannot see added Country on grid", Status.FAIL);
	 		 }
	    			 }
	    		 }
	    	 }
	    	 
	    	 try {
	    		 EditComment();
	 			log("STEP 62:   Record will expand with fields   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 62:  The panel does not expand     ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 62");
	 		 }
	    	 
	    	 try {
	    		 AddContact();
	    		 util.dummyWait(1);
	 			log("STEP 63: The fields displays  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 63:  On click if fields does not appear  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 63");
	 		 }

	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL") || testcaseName.contains("TRA")) 
	    	 {
	    		 try {
	    			 addNameForALT(map.get(Excel.Name));
		 			log("STEP 64: User can enter a value in Name field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 64:  User cannot add a value in Name field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 64");
		 		 }
	    	 }
	    	 else {

	    		 if(util.isElementVisible(drpcontactinfo)) {
	    		 try {
	    			 addContactInfoFor(map.get(Excel.ContactInfo));
		    		 log("STEP 64: Added value displays in Contact Info field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 64:  User  cannot select  value  from Contact Info DD   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 64");
		 		 }
	    		 }
	    		 
	    		 if(util.isElementVisible(txtLastNameadd)) {
	    	 try {
	    		 addLastNameContact(map.get(Excel.LastNameadd));
	    		 log("STEP 65: User can enter a value in Last Name field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 65:  User cannot add a value in Last Name field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 65");
	 		 }
	    		 }
	     }
	    	 
	    	 if(util.isElementVisible(txtHomePhone)) {
	    	 try {
	    		 addHomePhoneNumber(map.get(Excel.HomePhone));
	 			log("STEP 66: User can enter a value in Home Phone field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 66:  User cannot add a value in Home Phone field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 66");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtCellPhone)) {
	    	 try {
	    		 addCellPhoneNumber(map.get(Excel.CellPhone));
	 			log("STEP 67: User can enter a value in Cell Phone field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 67:  User cannot add a value in Cell Phone field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 67");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtWorkPhone)) {
	    	 try {
	    		 addWorkPhoneNumber(map.get(Excel.WorkPhone));
	 			log("STEP 68: User can enter a value in Work Phone field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 68:  User cannot add a value in Work Phone field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 68");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtFaxPhone)){
	    	 try {
	    		 addFaxPhoneNumber(map.get(Excel.FaxPhone));
	 			log("STEP 69: User can enter a value in Fax Phone field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 69:  User cannot add a value in Fax Phone field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 69");
	 		 }
	         }
	    	 if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
	    		 if(util.isElementVisible(txtEmail)) {
	    	 try {
	    		 addEmail(map.get(Excel.Email));
	 			log("STEP 70: User can enter a value in Email field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 70  User cannot add a value in Email field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 70");
	 		 }
	    		 }
	    }	 
	    	 
	    	 try {
	    		 ClickOnPreferredContact();
	 			log("STEP 71: User can check the check box    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 71:  User cannot check the checkbox   ", Status.FAIL);
	 			ExtentTestManager.infoWithScreenshot("unable to add contact details record");
	 			driver.close();
	    		 driver.switchTo().window(mainWinID);
	 			throw new RuntimeException("Failed in step 71");
	 		 }
	    	 
	    	 
	    	 try {
	    		 ClickOnSaveContact();
	 			log("STEP 72: Contact information should get saved and delete icon will display for added contact  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 72: Contact information not get saved   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 72");
	 		 }
	    	 
	    	 
	    	 try {
	    		 ClickOnDeleteContct();
	 			log("STEP 73: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 73:  The delete pop window does not display   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 73");
	 		 }
	    	 
	    	 try {
	    		 ClickOnUpdateContact();
	    		 driver.close();
	    		 driver.switchTo().window(mainWinID);
	    		 util.dummyWait(2);
	 			log("STEP 74: Added Contact information should get display on the grid  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 74:  Contact information not get displaying on the grid    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 74");
	 		 }
 
	    }
	    
	    util.dummyWait(5);
	  }
	    
	    
         public void AddExistingLandowner(Map<String, String> map, String testcaseName) {
	    	
				try {
					navigateParcelInformation();
					log("STEP 1: User can navigate to the Parcel Information ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1:  User cannot see the Parcel Information option in Menu", Status.FAIL);
					throw new RuntimeException("User cannot see the Parcel Information option in Menu");
				}

				try {
					AddnewLandownerRow();
					log("STEP 2: User can click on Add New Landowner ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: User cannot click on Add New Landowner  ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}

				try {
					util.switchToIframe(frmFull);
					AddExistingContact("Regression_LO");
					log("STEP 3:   User can select value from Existing Contact dd    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3:  User  cannot select  value  from Existing Contact DD    ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
				
				try {
					util.waitUntilElementDisplay(btnSave);
					util.click(btnSave);
		    		 Close(); 
		 			log("STEP 4: Landowner Added Successfully ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 4:  Landowner not added ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 4");
		 		 }
	    
         }
}
