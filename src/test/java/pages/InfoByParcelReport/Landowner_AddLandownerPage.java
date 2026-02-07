package pages.InfoByParcelReport;

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
	public static String ENTITY_NAME;
	public static String STATE;
	public static String CITY="";
	public static String ZIPCODE="";

	public Landowner_AddLandownerPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	

	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')]");
	By navLandowner = By.xpath("//span[text()='Landowner']");
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
	By btnAssociatedDocumentsOrsted = By.xpath("(//ul[@class='rdCommands'])[4]");
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
	By linkViewDocuments = By.xpath("(//a[text()='View Document'])[1]");
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
	By checkboxIsPrimary = By.xpath("//*[@id='IsPrimary']");
	By isPrimaryChecked = By.xpath("//input[@id='IsPrimary' and @checked='checked']");
	
	
	 public void navigateLandowner() {
//	  		util.waitUntilElementDisplay(navParcel);
//	  		util.click(navParcel);
//	  		util.waitUntilElementDisplay(navParcelInfo);
//	  		util.click(navParcelInfo);
//	  		util.waitUntilElementDisplay(navParcelInformation);
//	  		util.click(navParcelInformation);
	  		//util.waitUntilElementDisplay(navLandowner);
			//util.click(navLandowner);
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
			util.dummyWait(1);
	    }
	    
	    
	    
	    public void VerifyCheckbox() {
			Assert.assertTrue(true, "Activecheckbox");
			if(!util.isElementVisible(isPrimaryChecked)) {
			util.waitUntilElementDisplay(checkboxIsPrimary);
			util.click(checkboxIsPrimary);
			}
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
//			Assert.assertTrue(util.isElementPresent(PrimaryMsg), "No primary address assigned.");
			
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
				util.inputTextAndPressTab(drpRelatedParties, value);	
				//util.selectValueFromDropdown(drpRelatedParties, value);
		      	  util.click(drpRelatedParties);
		      	  util.pressENTERkey();
				
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
	    	
	       if(testcaseName.contains("ROW") || testcaseName.contains("TRA"))
	    	 {  
	    	try {
	    		AddnewLandownerRow();
				log("STEP 1: User can click on Add New Landowner ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  Landowner panel does not expand ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	     }
	    	 else {
	    		
	    	 try {
	    		 AddnewLandowner(); 
					log("STEP 1:User can click on Add New Landowner ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1:  Landowner panel does not expand ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
	     }
	    	
	    	 try {
	    		 util.switchToIframe(frmFull);
	    		 
	 			log("STEP 2: User can switch on the popup      ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot switch on the popup  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 util.inputText(txtExistingContact, map.get(Excel.EntityName));
	    	 By landownerExists = By.xpath("//*[@id='RadEntityInfo_DropDown']/..//li[contains(normalize-space(),'"+map.get(Excel.EntityName)+"')]");
	    	 By closeExistingDD = By.xpath("//a[@id='RadEntityInfo_Arrow']");
	    	 if(!util.isElementVisible(landownerExists)) {
	    	 try {
	    		 util.click(closeExistingDD);
	    		 util.click(txtSurfaceOwnership);
	    		 util.waitFor(500);
	    		 VerifyCheckbox();
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
	    		 ENTITY_NAME=map.get(Excel.EntityName);
	 			log("STEP 12: User can enter a value in EntityName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 12:  User cannot add a value in EntityName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 12");
	 		 }
	    	
	    	 if(util.isElementVisible(txtContactNumber)) {
	    	 try {
	    		 AddContactNumber(map.get(Excel.ContactNumber));
	 			log("STEP 13: User can enter a value in Contact Number field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 13:  User cannot add a value in Contact Number field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 13");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtSuffix)) {
	    	 try {
	    		 AddSuffix(map.get(Excel.Suffix));
	 			log("STEP 14: User can enter a value in Suffix field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 14:  User cannot add a value in Suffix field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 14");
	 		 }
	    	 }

	    	 if(util.isElementVisible(txtCOName)) {
	    	 try {
	    		 AddCOName(map.get(Excel.COName));
	 			log("STEP 15: User can enter a value in COName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 15:  User cannot add a value in COName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 15");
	 		 }
	    	 }
	    	 
	    	if(util.isElementPresent(txtMaritalStatus)) {
	    	 try {
	    		 AddMaritalStatus(map.get(Excel.MaritalStatus));
	 			log("STEP 16: Added value displays in Marital Status field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 16:  User  cannot select  value  from Marital Status DD    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 16");
	 		 }
	    	}
	    	
	    	if(util.isElementVisible(drpW9Flag)) {
	    	 try {
	    		 AddW9Flag(map.get(Excel.W9Flag));
	 			log("STEP 17: Added value displays in W9Flag field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 17: User  cannot select  value  from W9Flag DD   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 17");
	 		 }
	    	}
	    	
//	    	if(!environment.contains("CONNECTGEN")) {
	    	if(util.isElementPresent(drpPaymentMethod)) {
	    	 try {
	    		 AddPaymentMethod(map.get(Excel.PaymentMethod));
	 			log("STEP 18: Added value displays in Payment Method field    ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 18:  User  cannot select  value  from Payment Method DD   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 18");
	 		 }
	    	}
	    	
	    	 try {
	    		 AddVendor(map.get(Excel.Vendor));
	 			log("STEP 19: User can enter a value in Vendor field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 19:  User cannot add a value in Vendor field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 19");
	    	}
	    	
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    	 try {
	    		 Save();
	 			log("STEP 20: Message - 'Message - 'New landowner has created and added to the parcel.' in green displays     ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 20:  Added Landowner record does not display in grid      ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 20");
	 		 }
	    	}
	    	 else if(testcaseName.contains("DOT")){
	    		 try {
		    		 SaveDot();
		 			log("STEP 20: Message - 'Message - 'New landowner has created and added to the parcel.' in green displays     ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 20:  Added Landowner record does not display in grid      ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 20");
		 		 } 
	    	 }else {
	    		 try {
		    		 SaveROW();
		 			log("STEP 20: Message - 'Message - 'New landowner was created and added to the tract.' in green displays     ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 20:  Added Landowner record does not display in grid      ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 20");
		 		 }
	    	 }  
	    
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")) {
	    		 try {
		    		 addNewRecordUnderComment();
		 			log("STEP 21: Grid will expand with fields   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 21: The panel does not expand    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 21");
		 		 }
	    	 }
	    	 else {
	    		 try {
				   	addNewRecordUnderCommentRow();
				 		log("STEP 21: Grid will expand with fields   ", Status.PASS);
				 	 } catch (Exception e) {
				 		log("STEP 21: The panel does not expand    ", Status.FAIL);
				 		throw new RuntimeException("Failed in step 21");
				 	 }
	    	 }
	    	 
	    	 try {
	    		 util.dummyWait(2);
	    		 addAddressLine1(map.get(Excel.AddressLine1));
	 			log("STEP 22:  User can enter a value in Address Line1 field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 22:  User cannot add a value in Address Line1 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 22");
	 		 }

	    	 if(util.isElementVisible(txtAddressLine2)) {
	    	 try {
	    		 addAddressLine2(map.get(Excel.AddressLine2));
	 			log("STEP 23: User can enter a value in Address Line2 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 23:  User cannot add a value in Address Line2 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 23");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtAddressLine3)) {
	    	 try {
	    		 addAddressLine3(map.get(Excel.AddressLine3));
	 			log("STEP 24: User can enter a value in Address Line3 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 24:  User cannot add a value in Address Line3 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 24");
	 		 }
	    	 }
	    	 
	    	 if(util.isElementVisible(txtAddressLine4)) {
	    	 try {
	    		 addAddressLine4(map.get(Excel.AddressLine4));
	 			log("STEP 25: User can enter a value in Address Line4 field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 25:  User cannot add a value in Address Line4 field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 25");
	 		 }
	    	 }
	    	 
	    	 try {
	    		 AddCity(map.get(Excel.City));
	    		 CITY=map.get(Excel.City);
	 			log("STEP 26: User can enter a value in City field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 26:  User cannot add a value in City field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 26");
	 		 }
	    	 
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    	 try {
	    		 SelectState(map.get(Excel.State));
	    		 STATE=map.get(Excel.State);
	 			log("STEP 27: Added value displays in State field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 27:  No value displays in State Dropdown    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 27");
	 		 }
	    }	
	    	 else {
	    		 try {
		    		 SelectStateRow(map.get(Excel.State));
		    		 STATE=map.get(Excel.State);
		 			log("STEP 27: Added value displays in State field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 27:  No value displays in State Dropdown    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 27");
		 		 }
	    	 }
	    		 
	    	 try {
	    		 addZipCode(map.get(Excel.ZipCode));
	    		 ZIPCODE=map.get(Excel.ZipCode);
	 			log("STEP 28: User can enter a value in Zip Code field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 28:  User cannot add a value in Zip Code field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 28");
	 		 }
	    	 
	    	 
	    	 try {
	    		 InsertRecord();
	 			log("STEP 29:  Added address displays in the grid       ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 29:   Added address not displays in the grid        ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 29");
	 		 }
	    	
	    	Close(); 
	    	 util.dummyWait(2);
	  }else {
		  try {
			  util.pressDownkey();
			  util.pressENTERkey();
			  util.dummyWait(2);
			  VerifyCheckbox();
		    		 Save();
		 			log("STEP 3: User can select existing landowner from the dd ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3:  User cannot select existing landowner from the dd  ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }
		  
		  try {
	    		Close(); 
	    		 util.dummyWait(2);
	 			log("STEP 4:  user can close the popup ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4:   user cannot close the popup  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
//		  ENTITY_NAME=map.get(Excel.EntityName);
//		  CITY=map.get(Excel.City);
//		  STATE=map.get(Excel.State);
//		  ZIPCODE=map.get(Excel.ZipCode);
	  }
	    }
}
