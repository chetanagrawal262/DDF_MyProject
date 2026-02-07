package pages.EncroachmentRequests;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EncroachmentAgreementManagementPage extends BasePage{

	
	TestUtil util;
	CommonFunction commonFunction;
	public static String DOCUMENT_TYPE;

	public EncroachmentAgreementManagementPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navAgreementManagement = By.xpath("//span[text()='Agreement Management']");
	By drpExistingAgreements = By.xpath("//input[contains(@id,'_agreementmanagement_Input') and @type='text']");
	By btnAddExistingAgreements = By.xpath("//input[contains(@id,'_btn_AddExistingAgreement') and @type='image']");
	By btnAddNewRecord = By.xpath("//img[contains(@id,'YALAGREEMENTMANAGEMENT_radYALGridControl_ctl00_ctl02_ctl00_Img4')]");
	By drpState = By.xpath("//input[contains(@id,'EditFormControl_State_Abb_radYALDropDownList_Input')]");
	By txtEfectiveDate = By.xpath("(//span[contains(text(),'Effective Date')]/..//input[@type='text'])[2]");
	By txtDateExecuted = By.xpath("//input[contains(@id,'_DATE_EXECUTED_dateInput') and @type='text']");
	By checkBoxPerpetual = By.xpath("//input[contains(@id,'_EditFormControl_ChkPrepetual') and @type='checkbox']");
	By txtPhysicalFileLocation = By.xpath("//input[contains(@id,'_EditFormControl_File_Location') and @type='text']");
	By txtExtAgreementNo = By.xpath("//input[contains(@id,'_EditFormControl_ExtAgreementNumber') and @type='text']");
	By txtAgreementTitle = By.xpath("//input[contains(@id,'_EditFormControl_Agreement_Title') and @type='text']");
	By txtTermYears = By.xpath("//input[contains(@id,'_EditFormControl_Term_Years') and @type='text']");
	By txtTermMonths = By.xpath("//input[contains(@id,'_EditFormControl_Term_Months') and @type='text']");
	By txtDateExpiration = By.xpath("//input[contains(@id,'EditFormControl_EXPIRATION_DATE_dateInput') and @type='text']");
	By txtDaysBeforeExp = By.xpath("//input[contains(@id,'_EditFormControl_DAYS_BEFORE_EXP') and @type='text']");
	By checkboxUnrecorded = By.xpath("//input[contains(@id,'_EditFormControl_UNRECORDED') and @type='checkbox']");
	By checkboxDoNotRecord = By.xpath("//input[contains(@id,'EditFormControl_DoNotRecord_Flag') and @type='checkbox']");
	By checkboxExercised = By.xpath("//input[contains(@id,'_EditFormControl_Exercised_Flag') and @type='checkbox']");
	By checkboxExtensionProvision = By.xpath("//input[contains(@id,'_EditFormControl_Extension_Flag') and @type='checkbox']");
	By txtLeaseNo = By.xpath("//input[contains(@id,'_EditFormControl_rtbLeaseNum') and @type='text']");
	By checkboxPrimaryAgreement = By.xpath("//input[contains(@id,'_EditFormControl_chkAMPrimaryAgree') and @type='checkbox']");
	By txtGrantor = By.xpath("//textarea[contains(@id,'_EditFormControl_GRANTOR')]");
	By txtGrantee = By.xpath("//textarea[contains(@id,'_EditFormControl_GRANTEE')]");
	By txtComment = By.xpath("//span[text()='Comments:']/..//textarea");
    By btnInsert = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
	By changesSavedSuccessfully = By.xpath("//span[contains(@id,'YALAGREEMENTMANAGEMENT_usrMessage') and text()='Changes saved successfully!']");
    By btnEdit = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_radYALGridControl_ctl00_ctl04_EditButton')]");
    By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
    By btnDelete = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
    By iframeDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnOk = By.xpath("//span[text()='OK']");
	By btnAddCounty = By.xpath("//input[contains(@id,'_EditFormControl_btnAddCounty') and @type='submit']");
	By btnSaveCounty = By.xpath("//input[contains(@id,'_EditFormControl_btnSave') and @type='submit']");
	By drpCounty = By.xpath("//input[contains(@id,'_EditFormControl_rptrCountyInfo_ctl02_CountyNewCombo_Input') and @type='text']");
	By txtBook = By.xpath("//input[contains(@id,'_EditFormControl_rptrCountyInfo_ctl02_DOC_VOLUME') and @type='text']");
	By txtPage = By.xpath("//input[contains(@id,'_EditFormControl_rptrCountyInfo_ctl02_DOC_PAGE') and @type='text']");
	By txtMicroFilm = By.xpath("//input[contains(@id,'_EditFormControl_rptrCountyInfo_ctl02_NewMicroFilm') and @type='text']");
	By txtDocumentNumber = By.xpath("//input[contains(@id,'_EditFormControl_rptrCountyInfo_ctl02_DOC_NO') and @type='text']");
	By txtDateRecorded = By.xpath("//input[contains(@id,'_EditFormControl_rptrCountyInfo_ctl02_DATE_RECORDED_dateInput') and @type='text']");
	
	public void ExpandAgreementManagement() {
		util.waitUntilElementDisplay(navAgreementManagement);
		util.click(navAgreementManagement);
	}
	
	public void SelectExistingAgreement(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(drpExistingAgreements, value);
		By selectValue = By.xpath("//em[text()='"+value+"']");
		util.click(selectValue);
	}
	
	public void ClickOnAdd() {
		util.waitUntilElementDisplay(btnAddExistingAgreements);
		util.click(btnAddExistingAgreements);
		util.waitUntilPageLoad();
	}
	
	public void ClickonAddNewRecord() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.waitUntilLoaderDisappear();
	}
	
	By drpDocumentType =By.xpath("(//div[contains(@id,'_EditFormControl_DOCUMENT_TYPE_ID_RadDropDownTree1')])[1]");
	By filterDocumentType = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
	     public void selectDocumentType(String value) {
	    	 util.click(drpDocumentType);
	 	    	if (!commonFunction.checkNA(value))
	 	    		DOCUMENT_TYPE=value;
	 				util.inputText(filterDocumentType, value);
	 	    	By selectValue = By.xpath("(//em[text()='"+value+"'])[1]");
	 	    	util.click(selectValue);
	     }
	     
	public void SelectState(String value) {
		if (!commonFunction.checkNA(value))
			util.click(drpState);
		util.waitFor(500);
		util.clearInputField(drpState);
		util.waitFor(500);
		WebElement inputField =driver.findElement(drpState);
		inputField.sendKeys(value);
		util.waitFor(1000);
		inputField.sendKeys(Keys.TAB);
	}
	
	public void AddEfectiveDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEfectiveDate, value);
	}
	
	public void SelectDateExecuted(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateExecuted, value);
	}
	
	public void selectPerpetual() {
		util.waitUntilElementDisplay(checkBoxPerpetual);
		util.click(checkBoxPerpetual);
	}
	
	public void AddPhysicalFileLocation(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPhysicalFileLocation, value);
	}
	
	public void AddExtAgreementNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExtAgreementNo, value);
	}
	
	public void AddAgreementTitle(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAgreementTitle, value);
	}
	
	public void AddTermYears(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTermYears, value);
	}
	
	public void AddTermMonths(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTermMonths, value);
	}
	
	public void AddDateExpiration(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateExpiration, value);
	}
	
	public void AddDaysBeforeExp(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDaysBeforeExp, value);
	}
	
	public void selectUnrecorded() {
		util.waitUntilElementDisplay(checkboxUnrecorded);
		util.click(checkboxUnrecorded);
	}
	
	public void selectDoNotRecord() {
		util.waitUntilElementDisplay(checkboxDoNotRecord);
		util.click(checkboxDoNotRecord);
	}
	
	public void selectExercised() {
		util.waitUntilElementDisplay(checkboxExercised);
		util.click(checkboxExercised);
	}
	
	public void selectExtensionProvision() {
		util.waitUntilElementDisplay(checkboxExtensionProvision);
		util.click(checkboxExtensionProvision);
	}
	
	public void AddLease(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLeaseNo, value);
	}
	
	public void selectPrimaryAgreement() {
		util.waitUntilElementDisplay(checkboxPrimaryAgreement);
		util.click(checkboxPrimaryAgreement);
	}
	
	public void AddGrantor(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGrantor, value);
	}
	
	public void AddGrantee(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGrantee, value);
	}
	
	public void AddComment(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
	}
	
	public void ClickonInsert() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilLoaderDisappear();

	}
	
	public void ClickOnEdit() {
		util.waitFor(500);
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.waitUntilLoaderDisappear();	
	}
	
	public void ClickonUpdate() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.waitUntilLoaderDisappear();
	}
	
	public void ClickonDeleteButton() {
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
	}
	
	public void ClickonOk() {
		util.waitUntilElementDisplay(btnOk);
		util.click(btnOk);
		util.waitUntilLoaderDisappear();
	}
	
	public void ClickOnAddCounty() {
		util.waitUntilElementDisplay(btnAddCounty);
		util.click(btnAddCounty);
		util.waitUntilLoaderDisappear();
	}
	
	public void selectCounty(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCounty, value);
	}
	
	public void AddBookVolume(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtBook, value);
	}
	
	public void AddPage(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPage, value);
	}
	
	public void AddMicroFilm(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMicroFilm, value);
	}
	
	public void AddDocumentNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDocumentNumber, value);
	}
	
	public void AddDateExecuted(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateExecuted, value);
	}
	
	public void AddDateRecorded(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateRecorded, value);
	}
	
	public void ClickOnSaveCounty() {
		util.waitUntilElementDisplay(btnSaveCounty);
		util.click(btnSaveCounty);
		util.waitUntilLoaderDisappear();
	}

	public void AddExistingAgreementRecord(Map<String, String> map, String testcaseName) {

		try {
			ExpandAgreementManagement();
			log("STEP 1: User can expand the Agreement Manager Panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot expand the Agreement Manager Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			SelectExistingAgreement(map.get("ExistingAgreement"));
			log("STEP 2: User can select Existing Agreement from the dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot select Existing Agreement from the dd", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			ClickOnAdd();
			log("STEP 3: User can click on Add Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot click on Add Button", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			By documentType =By.xpath("(//div[contains(@id,'_YALAGREEMENTMANAGEMENT_radYALGridControl')])/..//strong[text()='"+map.get(Excel.DocumentType)+"']");
			Assert.assertTrue(util.isElementVisible(documentType));
			log("STEP 4: User can see Document Type value for the Existing record in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4:  User cannot see Document Type value for the Existing record in the grid view", Status.FAIL);
		}
		
		try {
			By dateExecuted =By.xpath("(//div[contains(@id,'_YALAGREEMENTMANAGEMENT_radYALGridControl')])/..//strong[text()='"+map.get(Excel.DateExecuted)+"']");
			Assert.assertTrue(util.isElementVisible(dateExecuted));
			log("STEP 5: User can see Date Executed value for the Existing record in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5:  User cannot see Date Executed value for the Existing record in the grid view", Status.FAIL);
		}
		
		try {
			By county =By.xpath("(//div[contains(@id,'_YALAGREEMENTMANAGEMENT_radYALGridControl')])/..//strong[text()='"+map.get(Excel.County)+"']");
			Assert.assertTrue(util.isElementVisible(county));
			log("STEP 6: User can see County for the Existing record in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6:  User cannot see County for the Existing record in the grid view", Status.FAIL);
		}
		
		try {
			By dateRecorded =By.xpath("(//div[contains(@id,'_YALAGREEMENTMANAGEMENT_radYALGridControl')])/..//strong[text()='"+map.get(Excel.EffectiveDate)+"']");
			Assert.assertTrue(util.isElementVisible(dateRecorded));
			log("STEP 7: User can see date Recorded for the Existing record in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7:  User cannot see date Recorded for the Existing record in the grid view", Status.FAIL);
		}
	}

	public void AddNewAgreementManagementRecord(Map<String, String> map, String testcaseName) {
		
		try {
			ClickonAddNewRecord();
			log("STEP 1: User can click on Add New reocrd button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot click on Add New reocrd button", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			selectDocumentType(map.get(Excel.DocumentType));
			log("STEP 2: User can select the document type ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select the document type ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			SelectState(map.get(Excel.State));
			log("STEP 3:  User can select State", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot select State ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			AddEfectiveDate(map.get(Excel.EffectiveDate));
			log("STEP 4:  User can select Effective Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot select Effective Date ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			SelectDateExecuted(map.get(Excel.DateExecuted));
			log("STEP 5:  User can select Executed Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User cannot select Executed Date ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		 
//		try {
//			selectPerpetual();
//			log("STEP 6:  User can select Perpetual Checkbox", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 6:  User cannot select Perpetual Checkbox ", Status.FAIL);
//			throw new RuntimeException("Failed in step 6");
//		}
		
		try {
			AddPhysicalFileLocation(map.get("PhysicalFileLocation"));
			log("STEP 7:  User can add Physical File Location", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User cannot add Physical File Location ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			AddExtAgreementNo(map.get("ExtAgreementNo"));
			log("STEP 8:  User can add Ext Agreement No", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User cannot add Ext Agreement No ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			AddAgreementTitle(map.get("AgreementTitle"));
			log("STEP 9:  User can add Agreement Title", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User cannot add Agreement Title ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			AddTermYears(map.get(Excel.Year));
			log("STEP 10:  User can add Term Year", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User cannot add Term Year ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			AddTermMonths(map.get(Excel.Months));
			log("STEP 11:  User can add Term Months", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User cannot add Term Months ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}

		try {
			AddDateExpiration(map.get("DateExpiration"));
			log("STEP 12:  User can select Date Expiration", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:   User can not select Date Expiration", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			AddDaysBeforeExp(map.get("DaysBeforeExp"));
			log("STEP 13:  User can add Days Before Exp", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:   User can not add Days Before Exp", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}

		try {
			selectUnrecorded();
			log("STEP 14:  User can select Unrecorded Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:  User cannot select Unrecorded Checkbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
			selectDoNotRecord();
			log("STEP 15:  User can select Do Not Record Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:  User cannot select Do Not Record Checkbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		try {
			selectExercised();
			log("STEP 16:  User can select Exercised Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:  User cannot select Exercised Checkbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		try {
			selectExtensionProvision();
			log("STEP 17:  User can select Extension Provision Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 17:  User cannot select Extension Provision Checkbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}

		try {
			AddLease(map.get(Excel.Lease));
			log("STEP 18:  User can enter Lease No", Status.PASS);
		} catch (Exception e) {
			log("STEP 18:   User cannot enter Lease No", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		 
		try {
			selectPrimaryAgreement();
			log("STEP 19:  User can select Primary Agreement Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 19:  User cannot select Primary Agreement Checkbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		 
		try {
			AddGrantor(map.get(Excel.Grantor));
			log("STEP 20:  User can enter the value in the Grantor field  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 20:  User cannot enter the value in the Grantor field", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}

		try {
			AddGrantee(map.get(Excel.Grantee));
			log("STEP 21:  User can enter the value in the Grantee field  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 21:  User cannot enter the value in the Grantee field", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}

		try {
			AddComment(map.get(Excel.Comment));
			log("STEP 22:  User can enter the value in the Comment field  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 22:  User cannot enter the value in the Comment field", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}

		try {
			ClickonInsert();
			log("STEP 23:   User can click on Insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23:   User cannot click on Insert button", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
			log("STEP 24: User can see 'Changes saved successfully' Message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 24:  User cannot see 'Changes saved successfully' Message", Status.FAIL);
		}
		
		try {
			By documentType =By.xpath("(//div[contains(@id,'_YALAGREEMENTMANAGEMENT_radYALGridControl')])/..//strong[text()='"+map.get(Excel.DocumentType)+"']");
			Assert.assertTrue(util.isElementVisible(documentType));
			log("STEP 25: User can see Document Type in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 25:  User cannot see Document Type in the grid view", Status.FAIL);
		}
		
		try {
			By dateExecuted =By.xpath("(//div[contains(@id,'_YALAGREEMENTMANAGEMENT_radYALGridControl')])/..//strong[text()='"+map.get(Excel.DateExecuted)+"']");
			Assert.assertTrue(util.isElementVisible(dateExecuted));
			log("STEP 26: User can see Date Executed in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 26:  User cannot see Date Executed in the grid view", Status.FAIL);
		}
		 
   }
	
	
	public void EditAgreementManagementRecord(Map<String, String> map, String testcaseName) {
		try {
			By edit = By.xpath("(//div[contains(@id,'_YALAGREEMENTMANAGEMENT_radYALGridControl')])/..//strong[text()='"+ map.get(Excel.DocumentType)+"']/../..//input[@alt='Edit']");
			util.click(edit);
			util.waitUntilLoaderDisappear();
			log("STEP 1:  User can click on Edit Record ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:   User cannot click on Edit Record", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			ClickOnAddCounty();
			log("STEP 2:  User can click on Add County Button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot click on Add County Button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			selectCounty(map.get(Excel.County));
			log("STEP 3:  User can select County ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot select County", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			AddBookVolume(map.get(Excel.Book));
			log("STEP 4:  User can add Book / Volume ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot add Book / Volume", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			AddPage(map.get(Excel.Page));
			log("STEP 5:  User can add Page ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User cannot add Page", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			AddMicroFilm(map.get("MicroFilm"));
			log("STEP 6:  User can add Micro Film ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User cannot add Micro Film", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			AddDocumentNo(map.get("DocumentNo"));
			log("STEP 7:  User can add Document # ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User cannot add Document #", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			AddDateRecorded(map.get("DateRecorded"));
			log("STEP 8:  User can add Date Executed ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User cannot add Date Executed", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			ClickOnSaveCounty();
			log("STEP 9:  User can click on Save County Button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User cannot click on Save County Button", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			AddComment(map.get(Excel.Comment));
			log("STEP 10:  User can update the Comment  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User cannot update the Comment", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		try {
			ClickonUpdate();
			log("STEP 11: User can click on Update button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot click on Update button ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		 
		try {
			Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
			log("STEP 12: User can see 'Changes saved successfully' Message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12:  User cannot see 'Changes saved successfully' Message", Status.FAIL);
		}
		
		try {
			By county =By.xpath("(//div[contains(@id,'_YALAGREEMENTMANAGEMENT_radYALGridControl')])/..//strong[text()='"+map.get(Excel.County)+"']");
			Assert.assertTrue(util.isElementVisible(county));
			log("STEP 13: User can see County value in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 13:  User cannot see County value in the grid view", Status.FAIL);
		}
		
		try {
			By dateRecorded =By.xpath("(//div[contains(@id,'_YALAGREEMENTMANAGEMENT_radYALGridControl')])/..//strong[text()='"+map.get("DateRecorded")+"']");
			Assert.assertTrue(util.isElementVisible(dateRecorded));
			log("STEP 14: User can see Date Recorded in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 14:  User cannot see Date Recorded in the grid view", Status.FAIL);
		}
	}
	
	public void DeleteAgreementManagement(String testcaseName) {
		try {
			ClickonDeleteButton();
			log("STEP 1: User can click on Delete Button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on Delete Button ", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}

		try {
			ClickonOk();
			log("STEP 2: User can click on Ok Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Ok Button", Status.FAIL);
			throw new RuntimeException("Failed in step 2 ");

		}

	}
}
