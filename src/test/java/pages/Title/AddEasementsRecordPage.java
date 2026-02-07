package pages.Title;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddEasementsRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddEasementsRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navEasementsRecord = By.xpath("//span[contains(text(),'Easements, Plats, Oil & Gas Leases')]");
	By btnAddNew = By.xpath("(//img[contains(@id,'_TEASEMENT_radYALGridControl_')])[1]");
	By drpDocumentType  =  By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_DOC_TYPE_DDL_radYALDropDownList_Input') and @type='text'] | //input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_DOCUMENT_TYPE') and @type='text']");
	By txtDocumentNo  = By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_DOCUMENT_NUMBER') and @type='text']");
	By txtImageNo  = By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_IMAGE_NUMBER') and @type='text']");
	By txtVolume = By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_VOLUME') and @type='text']");
	By txtPage = By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_DPAGE') and @type='text']");
	By txtExecutedDate = By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_EXECUTED_DATE_dateInput') and @type='text']");
	By txtRecordedDate = By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_RECORDED_DATE_dateInput') and @type='text']");
	By txtEffectiveDate = By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_EFFECTIVE_DATE_dateInput') and @type='text']");
	By txtExpirationDate = By.xpath("//input[contains(@id,'_EditFormControl_Expiration_Date_dateInput') and @type='text']");
	By txtState = By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_State') and @type='text']");
	By txtCounty = By.xpath("//input[contains(@id,'_EditFormControl_County') and @type='text']");
	By txtBookName = By.xpath("//input[contains(@id,'_EditFormControl_Name_Of_Record') and @type='text']");
	By btnAddDocument = By.xpath("//img[@alt='Add Document']");
	//By txtHeirs = By.xpath("//textarea[contains(@id,'_EditFormControl_HIERS')]");
	By txtGrantor = By.xpath("//textarea[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_GRANTOR')]");
	By txtGrantee = By.xpath("//textarea[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_GRANTEE')]");
    By txtComments = By.xpath("//textarea[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_COMMENTS')]");
//    By btnInsert = By.xpath("//input[@id='ctl00_ConPHRightTop_TRTT_UC_radPanels_i5_i0_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert']");
    By btnInsert = By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']"); 
	
    public void ClickonAddNewButton() 
    {
		util.waitUntilElementDisplay(navEasementsRecord);
		util.click(navEasementsRecord);
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.waitUntilLoaderDisappear();
    } 
    
    public void AddDocumentType(String value) 
    {  util.waitUntilElementDisplay(drpDocumentType);
    util.click(drpDocumentType);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpDocumentType, value);
	}
     
    public void AddDocumentNo(String value) 
    {   
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDocumentNo, util.randomNumber());
	}
    public void AddImageNo(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtImageNo, util.randomNumber());
	}
    
    
    public void AddVolume(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtVolume, value);
	}
    
    public void AddPage(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPage, value);
	}
    public void AddExecutedDate(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExecutedDate, value);
	}
    public void AddRecordedDate(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtRecordedDate, value);
	}
    
    public void AddExpirationDate(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExpirationDate, value);
	}
    
    public void AddEffectiveDate(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEffectiveDate, value);
	}
    
    public void AddState(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtState, value);
	}
    public void AddCounty(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCounty, value);
	}
    public void AddBookName(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtBookName, value);
	}
    public void ClcikOnAddDocument() 
    {
    	util.waitUntilElementDisplay(btnAddDocument);
		util.click(btnAddDocument);
		util.dummyWait(5);
		driver.switchTo().alert().accept();
		
	}
  
    public void AddGrantor(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGrantor, value);
	}
    
    public void AddGrantee(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGrantee, value);
	}
    
    public void AddtComments(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComments, value);
	}
    
    public void ClickOnInsert() 
    {
    	util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilLoaderDisappear();
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	}
    
    public void AddEasementsRecord(Map<String, String> map, String testcaseName) {
    	
   	 try {
   		ClickonAddNewButton();
     	   log("STEP 1: Record should expands below ", Status.PASS);
     	} catch (Exception e) {
 		   log("STEP 1: Record does not expand below  ", Status.FAIL);
 		   throw new RuntimeException(" Failed in step 1 ");
 	    }
   	
   	 
   	 try {
   		 AddDocumentType(map.get(Excel.DocumentType));
	   			log("STEP 2: Selected value display in the Document Type dd field  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 2: Added value does not display in the field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 2");
	   		}
   	
   	 try {
   		 AddDocumentNo(map.get(Excel.DocumentNo));
	   			log("STEP 3: Entered value should display in the Document No field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 3: Entered value does not display in Document No field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 3");
	   		}
   	 
   	 try {
   		 AddImageNo(map.get(Excel.ImageNo));
	   			log("STEP 4: Entered value should display in the Image No field  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 4: Entered value does not display in Image No field ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 4");
	   		}
   	
   	 
   	 try {
   		 AddVolume(map.get(Excel.Volume));
	   			log("STEP 5:  Entered value should display in the Volume field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 5: Entered value does not display in Volume field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 5");
	   		}
   	 
   	 try {
   		 AddPage(map.get(Excel.Page));
	   			log("STEP 6:  Entered value should display in the Page field.   ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 6: Entered value does not display in Page field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 6");
	   		}
   	 
   	 try {
   		 AddExecutedDate(map.get(Excel.ExecutedDate));
	   			log("STEP 7:  User can select the Executed Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 7: User  cannot select Executed Date ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 7");
	   		}
   	 
   	 try {
   		 AddRecordedDate(map.get(Excel.RecordedDate));
	   			log("STEP 8:  User can select the Recorded Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 8: User  cannot select  Recorded Date ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 8");
	   		}
   	 
   	 try {
   		 AddEffectiveDate(map.get(Excel.EffectiveDate));
	   			log("STEP 9:  User can select the Effective Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 9: User  cannot select  Effective Date ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 9");
	   		}
   	 
 	 
   	 try {
   		AddExpirationDate(map.get(Excel.ExpirationDate));
	   			log("STEP 10:  User can select the Expiration  Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 10: User  cannot select Expiration Date ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 10");
	   		}
   	 
   	 try {
		 AddState(map.get(Excel.State));
   			log("STEP 11:  Entered value should display in the State field. ", Status.PASS);
   		} catch (Exception e) {
   			log("STEP 11: Entered value does not display in State field ", Status.FAIL);
   			throw new RuntimeException("Failed in step 11");
   		}
	 
	 try {
		 AddCounty(map.get(Excel.County));
   			log("STEP 12:  Entered value should display in the County field. ", Status.PASS);
   		} catch (Exception e) {
   			log("STEP 12: Entered value does not display in County field. ", Status.FAIL);
   			throw new RuntimeException("Failed in step 12");
   		}
	 
	 try {
		 AddBookName(map.get(Excel.BookName));
   			log("STEP 13:  Entered value should display in the Book Name field.  ", Status.PASS);
   		} catch (Exception e) {
   			log("STEP 13: Entered value does not display in Book Name field. ", Status.FAIL);
   			throw new RuntimeException("Failed in step 13");
   		}
	 
	 try {
		 AddGrantor(map.get(Excel.Grantor));
   			log("STEP 14: Entered value should display in the Grantor field. ", Status.PASS);
   		} catch (Exception e) {
   			log("STEP 14:  Entered value does not display in Grantor field. ", Status.FAIL);
   			throw new RuntimeException("Failed in step 14");
   		}
	 
	 try {
		 AddGrantee(map.get(Excel.Grantee));
   			log("STEP 15: Entered value should display in the Grantee field.  ", Status.PASS);
   		} catch (Exception e) {
   			log("STEP 15: Entered value does not display in Grantee field. ", Status.FAIL);
   			throw new RuntimeException("Failed in step 15");
   		}
	 
	 try {
		 AddtComments(map.get(Excel.Comments));
   			log("STEP 16: Entered value should display in the Comments field. ", Status.PASS);
   		} catch (Exception e) {
   			log("STEP 16: Entered value does not display in Comments field. ", Status.FAIL);
   			throw new RuntimeException("Failed in step 16");
   		}
	 
	 try {
		 ClickOnInsert();
   			log("STEP 17: Changes saved successfully!  message should be display above the add new button  ", Status.PASS);
   		} catch (Exception e) {
   			log("STEP 17: User cannot click on Insert button and sucess message does not display ", Status.FAIL);
   			throw new RuntimeException("Failed in step 17");
   		}

    }
}
