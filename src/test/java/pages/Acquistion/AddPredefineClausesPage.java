package pages.Acquistion;

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

public class AddPredefineClausesPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddPredefineClausesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navPredefineclauses =By.xpath("//span[contains(text(),'Predefined Clauses')]");
	By btnAddNew = By.xpath("//img[@id='ctl00_ConPHRightTop_TRAT_UC_radPanels_i10_i0_PRED_CLAUSES_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By drpPredefineClauses = By.xpath("//input[contains(@id,'_EditFormControl_CLAUSE_ID_radYALDropDownList_Input') and @type='text']");
	By drpAssocAgreement = By.xpath("//input[contains(@id,'_PRED_CLAUSES_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_Recording_ID_radYALDropDownList_Input') and @type='text']");
	By firstValue = By.xpath("//div[contains(@id,'EditFormControl_Recording_ID_radYALDropDownList_DropDown')]/..//li[1]");
	By drpDocumentType = By.xpath("//input[contains(@id,'_EditFormControl_Document_type_ID_radYALDropDownList_Input') and @type='text']");
	By txtComments = By.xpath("//textarea[contains(@id,'Comments')]");
	By btnInsert = By.xpath("//input[@id='ctl00_ConPHRightTop_TRAT_UC_radPanels_i10_i0_PRED_CLAUSES_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert']");
    By changesSavedSuccessfully = By.xpath("//span[@id='ctl00_ConPHRightTop_TRAT_UC_radPanels_i10_i0_PRED_CLAUSES_usrMessage']");
	By btnEdit = By.xpath("//input[@id='ctl00_ConPHRightTop_TRAT_UC_radPanels_i10_i0_PRED_CLAUSES_radYALGridControl_ctl00_ctl04_EditButton']");
	By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
	By btnDelete = By.xpath("//input[@id='ctl00_ConPHRightTop_TRAT_UC_radPanels_i10_i0_PRED_CLAUSES_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment']");
	By btnDeleteAgreement = By.xpath("//input[contains(@id,'YALAGREEMENTMANAGEMENT_New_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
	By iframeDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnOk = By.xpath("//span[text()='OK']");
	By linkComment = By.xpath("//a[text()='Comments ']");
	By txtActivityDate = By.xpath("//input[@id='idGeneralComments_Activity_Date_dateInput']");
	By txtComment = By.xpath("//textarea[@id='idGeneralComments_Comments']");
	By btnSave = By.xpath("//input[@id='idGeneralComments_btnSave1']");
	By btnCommentHistory = By.xpath("//span[contains(text(),'Comments History')]");
	By btnDeleteComment = By.xpath("//input[@id='idGeneralComments_YALGeneralCOMMENTS_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment']");
	By btnClose = By.xpath("//a[@title='Close']");
	
	
	public void ClickonAddNew() {
		util.waitUntilElementDisplay(navPredefineclauses);
		util.click(navPredefineclauses);
		util.waitFor(500);
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.dummyWait(2);
	}
	
	 public void SelectPredefineClauses(String value) {
		 util.waitUntilElementDisplay(drpPredefineClauses);
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpPredefineClauses, value);
			util.dummyWait(10);
	    }
	
	 public void SelectAssocAgreement(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAssocAgreement, value);
			
	    }
	 
	 public void SelectAssocAgreement() {
	    	util.click(drpAssocAgreement);
			util.waitFor(100);
			util.click(firstValue);
	    }
	 
	 public void SelectDocumentType(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpDocumentType, value);
			
	    }
	 
	 public void AddComment(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtComment, value);
			
	    }
	 
	 public void ClickonInsert() {
		 util.waitUntilElementDisplay(btnInsert);
			util.click(btnInsert);
			util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	    util.dummyWait(2);
	 }
	 
	 public void ClickonEditButton(String value) {
		 util.waitUntilElementDisplay(btnEdit);
		 util.click(btnEdit);
		 util.dummyWait(2);
		 util.waitUntilElementDisplay(drpDocumentType);
		 if (!commonFunction.checkNA(value))
		 util.inputTextAndPressTab(drpDocumentType, value);
		 util.waitFor(200);
	 }
	 
	 
	 public void ClickonUpdate() {
		 util.waitUntilElementDisplay(btnUpdate);
			util.click(btnUpdate);
			util.waitUntilElementPresent(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");

	 }
	 
	 
	 By iframeComment = By.xpath("//iframe[@name='GeneralComments']");
	 By btnReviewComment = By.xpath("//span[contains(text(),'Review Comments')]");

	 public void ClickOnCmmentLink() {
			util.waitUntilElementDisplay(linkComment);
			util.click(linkComment);
			util.switchToIframe(iframeComment);
			util.dummyWait(1);
		}
	 
	 public void ClickOnReviewComment() {
		 util.waitUntilElementDisplay(btnReviewComment);
			util.click(btnReviewComment);
	 }
	 
	 public void AddActivityDate(String value) {
		 if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtActivityDate, value);
	 }
	
	 public void ClickOnSaveButton() {
		 util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.waitFor(500);
			util.waitUntilElementPresent(successMessgae);
			Assert.assertTrue(util.isElementPresent(successMessgae), "Changes saved successfully");
	 }
	 
	 public void ClickOnCommentHistory() {
		 util.waitUntilElementDisplay(btnCommentHistory);
			util.click(btnCommentHistory);
	 }
	 
	 By successMessgae = By.xpath("//span[@id='idGeneralComments_usrMessage']");

	 public void DeleteRecord() {
		 util.waitUntilElementDisplay(btnDeleteComment);
			util.click(btnDeleteComment);
			util.dummyWait(1);
	    util.waitUntilElementDisplay(btnOk);
		util.click(btnOk);
		util.waitUntilElementPresent(successMessgae);
		Assert.assertTrue(util.isElementPresent(successMessgae), "Changes saved successfully");	
		util.dummyWait(1);
		util.switchToDefaultContent();
		util.click(btnClose);
		util.dummyWait(1);
	 }
	 
	 
	 
	 public void ClickonDelete() {
		 util.waitUntilElementDisplay(btnDelete);
			util.click(btnDelete);
	 }
	
	 public void ClickonOK() {
		 util.waitUntilElementDisplay(btnOk);
			util.click(btnOk);
			util.dummyWait(1);
			util.click(navPredefineclauses);
			util.dummyWait(3);
	 }
	 
	 public void ClickonDeleteButtonAgreement() {
			util.dummyWait(1);
			util.waitUntilElementDisplay(btnDeleteAgreement);
			util.click(btnDeleteAgreement);
		}
		
		public void ClickonDeleteOk() {
			util.waitUntilElementDisplay(btnOk);
			util.click(btnOk);
		}
		
	    public void AddPredefineclauses(Map<String, String> map, String testcaseName) {
	    	
	    	try {
	    		  ClickonAddNew();
	       	   log("STEP 1: User can click on Add New Record button on the Pre-Defined Clauses panel ", Status.PASS);
	       	} catch (Exception e) {
	   		   log("STEP 1: User cannot click on Add New Record button on the Pre-Defined Clauses panel ", Status.FAIL);
	   		   throw new RuntimeException(" Failed in step 2 ");
	   	   }
	    	  
	    	  try {
	    		  SelectPredefineClauses(map.get(Excel.PredefineClauses));
	     			log("STEP 2: User can select value from the predefined clause dd field  ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 2: User cannot select value from the predefined clause dd field", Status.FAIL);
	     			throw new RuntimeException("Failed in step 2");
	     		}
	    	  util.dummyWait(2);
	    	  try {
	    		  SelectDocumentType(map.get(Excel.DocumentType));
	     			log("STEP 3: User can select the Document Type ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 3: User cannot select the Document Type ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 3");
	     		}
	    	  
	    	  try {
	    		  SelectAssocAgreement();
	     			log("STEP 4: User can select the Associated Agreement ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 4: User cannot select the Associated Agreement ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 4");
	     		}
	    	 
	    	  
	    	  try {
	    		  ClickonInsert();
	     			log("STEP 5: User can click on Insert button", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 5: User cannot click on Insert button ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 5");
	     		}
	    	  
	    	  try {
	    		  ClickonEditButton(map.get(Excel.UpdatedDocumentType));
	     			log("STEP 6: User can update Document Type ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 6: User cannot update Document Type ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 6");
	     		}
	    	  
	    	  try {
	    		  ClickonUpdate();
	    		  util.dummyWait(2);
	     			log("STEP 7: User can click on Update button", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 7:User cannot click on Update button ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 7");
	     		}
	    	  
	    	  try {
	    		  ClickOnCmmentLink();
	     			log("STEP 8: User can click on Comment Link ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 8: User cannot click on Comment Link", Status.FAIL);
	     			throw new RuntimeException("Failed in step 8");
	     		}
	    	  
	    	  try {
	    		  ClickOnReviewComment();
	     			log("STEP 9: User can click on Review Comment ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 9: User cannot click on Review Comment  ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 9");
	     		}
	    	  
	    	  try {
	    		  AddActivityDate(map.get(Excel.ActivityDate));
	     			log("STEP 10: User can select the Activity Date ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 10: user not able to select the activity date  ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 10");
	     		}
	    	  
	    	  try {
	    		  AddComment(map.get(Excel.Comment));
	     			log("STEP 11: User can enter the value in the Comment field ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 11: User cannot add value  to the comment field  ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 11");
	     		}
	    	  
	    	  try {
	    		  ClickOnSaveButton();
	     			log("STEP 12:  User can click on Save button ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 12: User cannot click on Save button  ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 12");
	     		}
	    	  
	    	  try {
	    		  ClickOnCommentHistory();
	     			log("STEP 13: User can click on Comment history Tab", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 13:User cannot click on Comment history Tab  ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 13");
	     		}
	    	  
	    	  try {
	    		  DeleteRecord();
	     			log("STEP 14: User can Delete comment", Status.PASS);
	     		} catch (Exception e) {
	     			ExtentTestManager.infoWithScreenshot("Failed to delete comment");
	     			util.switchToDefaultContent();
	     			util.click(btnClose);
	     			log("STEP 14: User cannot Delete comment   ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 14");
	     		}
	    	  
	    	  try {
	    		  ClickonDelete();
	     			log("STEP 15: User can click on Delete Icon", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 15: User cannot click on Delete Icon", Status.FAIL);
	     			throw new RuntimeException("Failed in step 15");
	     		}
	    	  
	    	  try {
	    		  ClickonOK();
	     			log("STEP 16:  Pre-defined clause record deleted sucessfully ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 16: Pre-defined clause record does not removed ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 16");
	     		}
	    	
	    	  try {
	    		  ClickonDeleteButtonAgreement();
	     			log("STEP 17: User can click on Delete Icon on Agreement Manager Panel", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 17: User cannot click on Delete Icon on Agreement Manager Panel", Status.FAIL);
	     			throw new RuntimeException("Failed in step 17");
	     		}
	    	  
	    	  try {
	    		  ClickonDeleteOk();
	     			log("STEP 18:  Agreement Manager record deleted sucessfully ", Status.PASS);
	     		} catch (Exception e) {
	     			log("STEP 18: Agreement Manager record does not removed ", Status.FAIL);
	     			throw new RuntimeException("Failed in step 18");
	     		}
	    
	 }
}
