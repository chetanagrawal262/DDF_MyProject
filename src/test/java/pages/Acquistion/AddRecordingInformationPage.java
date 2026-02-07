package pages.Acquistion;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddRecordingInformationPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddRecordingInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navRecordingInformation = By.xpath("//span[text()='Recording Information']");
	By btnAddNew = By.xpath("//img[@id='ctl00_ConPHRightTop_Acquisition_UC_radPanels_i7_i0_REC_INFO_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By txtDocumentType = By.xpath("//input[contains(@id,'_EditFormControl_DOC_TYPE') and @type='text']");
	By txtBook = By.xpath("//input[contains(@id,'_Book') and @type='text']");
	By txtVolume = By.xpath("//input[contains(@id,'_VOLUME') and @type='text']");
	By txtPage = By.xpath("//input[contains(@id,'_PAGE') and @type='text']");
	By txtDocument = By.xpath("//input[contains(@id,'_DOC_NO') and @type='text']");
	By txtRecorderDate = By.xpath("//input[contains(@id,'_DATE_RECORDED_dateInput') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'_RadState_Input')]");
    By drpCounty = By.xpath("//input[contains(@id,'_RadCounty_Input')]");
    By txtAgreementNumber = By.xpath("//input[contains(@id,'_LEASE_NO') and @type='text']");
    By txtDateExecuted = By.xpath("//input[contains(@id,'_DATE_EXECUTED_dateInput') and @type='text']");
    By txtGrantor = By.xpath("//textarea[contains(@id,'_EditFormControl_GRANTOR')]");
    By txtGrantee = By.xpath("//textarea[contains(@id,'_EditFormControl_GRANTEE')]");
    By txtComment = By.xpath("//textarea[contains(@id,'_EditFormControl_COMMENTS')]");
    By btnInsert = By.xpath("//input[@id='ctl00_ConPHRightTop_Acquisition_UC_radPanels_i7_i0_REC_INFO_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert']");
    By changesSavedSuccessfully = By.xpath("//span[@id='ctl00_ConPHRightTop_Acquisition_UC_radPanels_i7_i0_REC_INFO_usrMessage']");
    By btnEdit = By.xpath("//input[@id='ctl00_ConPHRightTop_Acquisition_UC_radPanels_i7_i0_REC_INFO_radYALGridControl_ctl00_ctl04_EditButton']");
    By btnUpdate = By.xpath("(//input[contains(@id,'_btnUpdate')])");
    By linkViewEditDocument = By.xpath("(//a[text()=' View/Edit Document(s)'])[1]");
    By iframeDocument = By.xpath("//iframe[@name='ViewEditDocuments']");
    By btnAddDocument = By.xpath("//input[contains(@id,'btnAdddocuments') and @type='image']");
    By iframeAddDocument = By.xpath("//iframe[@name='AddDocuments']");
	By btnSelectDocumnet = By.xpath("//span[contains(text(),'Select')]");
	By drpCategory = By.xpath("//select[@id='RadPanelBar1_i0_i0_rauFileUploadCategory0']");
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc0') and @type='text']"); 
	By btnLoadDocuments = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_buttonSubmit_input') and @type='submit']");
    By message = By.xpath("//span[@id='lblResults']");
    By btnCloseDocuments = By.xpath("//a[@class='rwCloseButton']");
    By btnDelete = By.xpath("//input[contains(@id,'_gbcDeleteAlignment') and @type='image']");
    By iframeDelete = By.xpath("//td[@class='rwWindowContent']");
    By btnOk = By.xpath("//span[text()='OK']");
    
    public void AddNew() {
    	util.waitUntilElementDisplay(navRecordingInformation);
    	util.click(navRecordingInformation);
    	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    }
    
    public void AddDocumentType(String value) {
    	util.waitUntilElementDisplay(txtDocumentType);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDocumentType, value);	
    }
    
    public void AddBook(String value) {
    	util.dummyWait(1);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtBook, value);	
    }
    
    public void AddVolume(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtVolume, value);	
    }
    
    public void AddPage(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPage, value);	
    }
    
    public void AddDocument(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDocument, value);	
    }
    
    public void AddRecorderDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtRecorderDate, value);	
    }
    
    public void SelectState(String value) {
    	util.waitUntilElementDisplay(drpState);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpState, value);	
    	util.dummyWait(3);
    }
    
    public void SelectCounty(String value) {
    	util.waitUntilElementDisplay(drpCounty);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCounty, value);	
    }
    
    public void AddAgreementNumber(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAgreementNumber, value);	
    }
    
    public void AddDateExecuted(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDateExecuted, value);	
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
    
    public void ClickoInsert() {
    	util.waitUntilElementDisplay(btnInsert);
    	util.click(btnInsert);
    	util.dummyWait(3);
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully! ");
       util.dummyWait(3);
    }
    
    public void ClickoEditButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
        util.dummyWait(3);

    }
    
    public void UpdateComment(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
	}
    
    public void ClickonUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    	util.dummyWait(3);
    	util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	       util.dummyWait(3);

    }
    
    public void ClickonViewDocument() {
    	util.waitUntilElementDisplay(linkViewEditDocument);
    	util.click(linkViewEditDocument);

    }
    
    By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
    public void UploadDocument() {
    	util.switchToIframe(iframeDocument);
    	util.waitUntilElementDisplay(btnAddDocument);
    	util.click(btnAddDocument);
    	util.switchToIframe(iframeAddDocument);
    	util.dummyWait(5);
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
		util.click(btnLoadDocuments);
	    	Assert.assertTrue(util.isElementPresent(message));
    }
    
    public void ClickonClose() {
    	util.switchToDefaultContent();
    	util.waitUntilElementDisplay(btnCloseDocuments);
    	util.click(btnCloseDocuments);
        util.dummyWait(3);

    }
    
    public void ClickonDelete() {
    	util.waitUntilElementDisplay(linkViewEditDocument);
    	util.click(linkViewEditDocument);
    	util.switchToIframe(iframeDocument);
    	util.waitUntilElementDisplay(btnDelete);
    	util.click(btnDelete);
    	
    }
    
    By successMessage = By.xpath("//span[@id='grid_doc_usrMessage']");
    
    public void ClickonOk() {
    	util.waitUntilElementDisplay(btnOk);
    	util.click(btnOk);
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(successMessage);
		Assert.assertTrue(util.isElementPresent(successMessage), "Changes saved successfully!");
    	util.switchToDefaultContent();
    	util.click(btnCloseDocuments);
    	util.click(navRecordingInformation);
	       util.dummyWait(3);

    }
    
    public void AddRecordingInformation(Map<String, String> map, String testcaseName) {
		if (testcaseName.contains("DOT") || testcaseName.contains("ROW")) {
			log(" Add Recording Information not applicable for DOT and ROW", Status.SKIP);
		}
		else {
    	try {
    		
    		AddNew();
			log("STEP 1: The panel fields displays ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: The panel does not expand ", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}
    	
    	 try {
    		 AddDocumentType(map.get(Excel.DocumentType));
 			log("STEP 2: added value display in the Document Type field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 2: added  value does not displayed in the field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 2");
 		 }
    	 
    	 try {
    		 AddBook(map.get(Excel.Book));
 			log("STEP 3:  added value display in the Book field   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 3:  added  value does not displayed in the field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 3");
 		 }
    	
    	 try {
    		 AddVolume(map.get(Excel.Volume));
 			log("STEP 4:  user is able to enter text in the volume field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 4:   user not able to enter text in the volume field ", Status.FAIL);
 			throw new RuntimeException("Failed in step 4");
 		 }
    	 
    	 try {
    		 AddPage(map.get(Excel.Page));
 			log("STEP 5:   user is able to enter text in the page field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 5:   user not able to enter text in the page field ", Status.FAIL);
 			throw new RuntimeException("Failed in step 5");
 		 }
    	 
    	 try {
    		 AddDocument(map.get(Excel.Document));
 			log("STEP 6:  user is able to enter info in the document # field   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 6:  user not able to enter text in the document # field  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 6");
 		 }
    	 
    	 try {
    		 AddRecorderDate(map.get(Excel.RecorderDate));
 			log("STEP 7:  user is able to select date from calender  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 7:  user not able to select date from calender  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 7");
 		 }
    	 
    	 try {
    		 SelectState(map.get(Excel.State));
 			log("STEP 8:  user is able to select value from state dd  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 8:  user not able to select value from dd  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 8");
 		 }
    	 util.dummyWait(3);  
    	 try {
    		 SelectCounty(map.get(Excel.County));
 			log("STEP 9:  user is able to select value from country dd ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 9:  user not able to select value from dd  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 9");
 		 }
    	
    	 try {
    		 AddAgreementNumber(map.get(Excel.AgreementNumber));
 			log("STEP 10: user is able to enter agreement number  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 10:  user not able to enter agreement number  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 10");
 		 }
    	 
    	 try {
    		 AddDateExecuted(map.get(Excel.DateExecuted));
 			log("STEP 11:  user is able to select date from calender ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 11:  user not able to select date from calender  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 11");
 		 }
    	 
    	 try {
    		 AddGrantor(map.get(Excel.Grantor));
 			log("STEP 12:  added value display in the Grantor field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 12:  added  value does not displayed in the field.  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 12");
 		 }
    	 
    	 try {
    		 AddGrantee(map.get(Excel.Grantee));
 			log("STEP 13:   user is able to enter text in the grantee field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 13:   user not able to enter text in the grantee", Status.FAIL);
 			throw new RuntimeException("Failed in step 13");
 		 }
    	 
    	 try {
    		 AddComment(map.get(Excel.Comment));
 			log("STEP 14:  user is able to enter text in the comments field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 14:  user not able to enter text in the comments field  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 14");
 		 }
    	 
    	 try {
    		 ClickoInsert();
 			log("STEP 15:  Message - 'Changes saved sucessfully!' in green displays  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 15:  Added values does  not displayed in the grid.  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 15");
 		 }
    	 util.dummyWait(5);
    	 try {
    		 ClickoEditButton();
    		 UpdateComment(map.get(Excel.Comments));
 			log("STEP 16:   added value display in the comment field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 16: added  value does not displayed in the field ", Status.FAIL);
 			throw new RuntimeException("Failed in step 16");
 		 }
    	 
    	 
    	 try {
    		 ClickonUpdateButton();
 			log("STEP 17:  Message - 'Changes saved sucessfully' in green displays ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 17: Message- Changes saved sucessfully' does not display ", Status.FAIL);
 			throw new RuntimeException("Failed in step 17");
 		 }
    	
    	 try {
    		 ClickonViewDocument();
 			log("STEP 18:  Document popup window should display with external documents tab   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 18:  The document pop window does not display ", Status.FAIL);
 			throw new RuntimeException("Failed in step 18");
 		 }
    	 
    	 try {
    		 UploadDocument();
 			log("STEP 19:  User can upload document from the system  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 19:   User cannot upload a document ", Status.FAIL);
 			throw new RuntimeException("Failed in step 3");
 		 }
    	 
    	 try {
    		 util.dummyWait(10);
    		 util.click(drpCategory);
    		 SelectCategory(map.get(Excel.Category));
 			log("STEP 20: Value added display in the field   ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 20:  Added value does not display in the field. ", Status.FAIL);
 			throw new RuntimeException("Failed in step 20");
 		 }
    	 
    	 
    	 try {
    		 AddDescription(map.get(Excel.Description));
 			log("STEP 21: User can enter a value in the field  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 21:  User cannot add a value in the field    ", Status.FAIL);
 			throw new RuntimeException("Failed in step 21");
 		 }

    	 try {
    		 LoadDocuments();
 			log("STEP 22: message-' Loaded- documentname'  displays ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 22: message-' Loaded- documentname'   does not display ", Status.FAIL);
 			throw new RuntimeException("Failed in step 22");
 		 }
    	 
    	 
    	 try {
    		 ClickonClose();
 			log("STEP 26: Message - 'Changes saved sucessfully' in green displays ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 26: Message- Changes saved sucessfully' does not display ", Status.FAIL);
 			throw new RuntimeException("Failed in step 26");
 		 }
    	 util.dummyWait(3);
    	 try {
    		 ClickonDelete();
 			log("STEP 27: Delete popup window should display with two buttons 'OK' and 'cancel ' below the  Message    - Delete this record ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 27: The delete pop window does not display ", Status.FAIL);
 			throw new RuntimeException("Failed in step 27");
 		 }
    	 util.dummyWait(3);
    	 try {
    		 ClickonOk();
 			log("STEP 28: Message- Changes saved suessfully! in green displays.  ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 28: Message- Changes saved sucessfully' does not display ", Status.FAIL);
 			throw new RuntimeException("Failed in step 28");
 		 }
    	 
    }

    }
}
