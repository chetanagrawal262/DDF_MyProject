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

public class AddInvoluntaryLiensRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddInvoluntaryLiensRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navInvoluntaryLiens = By.xpath("//span[contains(text(),'Involuntary Liens, Lis Pendens & Other Encumbrance')] | //span[contains(text(),'Mortgage, Liens, and Other Encumbrances')]");
//	By btnAddNew = By.xpath("//img[@id='ctl00_ConPHRightTop_TRTT_UC_radPanels_i6_i0_TLIEN_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By btnAddNew = By.xpath("(//img[contains(@id,'_TLIEN_radYALGridControl_')])[1]");
	By drpDocumentType = By.xpath("//input[contains(@id,'_DOC_TYPE_DDL_radYALDropDownList_Input') and @type='text'] | //input[contains(@id,'EditFormControl_DOCUMENT_TYPE') and @type='text']");
	By txtDocumentNo = By.xpath("//input[contains(@id,'_DOCUMENT_NUMBER') and @type='text']");
	By txtImageNo = By.xpath("//input[contains(@id,'_IMAGE_NUMBER') and @type='text']");
	By txtCauseNo = By.xpath("//input[contains(@id,'_EditFormControl_CLAUSE_NO') and @type='text']");
	By txtVolume = By.xpath("//input[contains(@id,'_EditFormControl_VOLUME') and @type='text']");
	By txtPage = By.xpath("//input[contains(@id,'_EditFormControl_DPAGE') and @type='text']");
	By txtExecutedDate = By.xpath("//input[contains(@id,'_EditFormControl_EXECUTED_DATE_dateInput') and @type='text']");
	By txtRecordedDate = By.xpath("//input[contains(@id,'_EditFormControl_RECORDED_DATE_dateInput') and @type='text']");
	By txtEffectiveDate = By.xpath("//input[contains(@id,'_EditFormControl_EFFECTIVE_DATE_dateInput') and @type='text']");
	By txtPlaintiff = By.xpath("//input[contains(@id,'_PLAINTIFF') and @type='text']");
	By txtDefendent = By.xpath("//input[contains(@id,'_DEFENDANT') and @type='text']");
	By txtSecuredParty = By.xpath("//input[contains(@id,'_SECURED_PARTY') and @type='text']");
	By txtDebtor = By.xpath("//input[contains(@id,'_DEBTOR') and @type='text']");
	By txtAmount = By.xpath("//input[contains(@id,'_ctl00_ctl02_ctl03_EditFormControl_AMOUNT') and @type='text']");
	By txtState = By.xpath("//input[contains(@id,'_State') and @type='text']");
//	By txtCounty = By.xpath("//input[contains(@id,'_County') and @type='text']");
	By txtCounty = By.xpath("//input[contains(@id,'_TLIEN_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_County') and @type='text']");
	By txtBookName = By.xpath("//input[contains(@id,'_Name_Of_Record') and @type='text']");
	By btnAddDocument = By.xpath("//img[@alt='Add Document']");
	By LTCcheckbox = By.xpath("//input[contains(@id,'_INCLUDE_LTC') and @type='checkbox']");
	By txtComments = By.xpath("//textarea[contains(@id,'_TLIEN_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_COMMENTS')]");
	By btnInsert = By.xpath("//input[contains(@id,'TLIEN_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
//	By btnInsert = By.xpath("//input[contains(@id,'_TEASEMENT_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
    By changesSavedSuccessfully = By.xpath("//span[contains(@id,'TLIEN_usrMessage')]"); 
	
    public void ClickonAddNewButton() 
    {
		util.waitUntilElementDisplay(navInvoluntaryLiens);
		util.click(navInvoluntaryLiens);
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
    } 
    
    public void AddDocumentType(String value) 
    {  util.waitUntilElementDisplay(drpDocumentType);
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
    
    public void AddCauseNo(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCauseNo, util.randomNumber());
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
    
    public void AddEffectiveDate(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEffectiveDate, value);
	}	
    
    public void AddPlaintiff(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPlaintiff, value);
	}
    
    public void AddDefendent(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDefendent, value);
	}
    
    public void AddSecuredParty(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSecuredParty, value);
	}
    
    public void AddDebtor(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDebtor, value);
	}
    
    public void AddAmount(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAmount, value);
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
  
    public void ClickonLTCcheckbox() {
    	util.waitUntilElementDisplay(LTCcheckbox);
    	util.click(LTCcheckbox);
    	
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
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	    util.dummyWait(2);

	}

    
    public void AddInvoluntaryLiensRecord(Map<String, String> map, String testcaseName) {
    	
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
   	   			log("STEP 2: Added value does not display in the Document Type field. ", Status.FAIL);
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
      		 AddCauseNo(map.get(Excel.CauseNo));
   	   			log("STEP 5:  Entered value should display in the Image No field.  ", Status.PASS);
   	   		} catch (Exception e) {
   	   			log("STEP 5:  Entered value does not display in Image No field ", Status.FAIL);
   	   			throw new RuntimeException("Failed in step 5");
   	   		}
      	 
      	 try {
      		 AddVolume(map.get(Excel.Volume));
   	   			log("STEP 6:  Entered value should display in the Volume field.  ", Status.PASS);
   	   		} catch (Exception e) {
   	   			log("STEP 6: Entered value does not display in Volume field. ", Status.FAIL);
   	   			throw new RuntimeException("Failed in step 6");
   	   		}
      	 
      	 try {
      		 AddPage(map.get(Excel.Page));
   	   			log("STEP 7:  Entered value should display in the Page field.   ", Status.PASS);
   	   		} catch (Exception e) {
   	   			log("STEP 7: Entered value does not display in Page field. ", Status.FAIL);
   	   			throw new RuntimeException("Failed in step 7");
   	   		}
      	 
      	 try {
      		 AddExecutedDate(map.get(Excel.ExecutedDate));
   	   			log("STEP 8:  User can select the Executed Date  ", Status.PASS);
   	   		} catch (Exception e) {
   	   			log("STEP 8: User  cannot select  Executed Date ", Status.FAIL);
   	   			throw new RuntimeException("Failed in step 8");
   	   		}
      	 
      	 try {
      		 AddRecordedDate(map.get(Excel.RecordedDate));
   	   			log("STEP 9:  User can select the Recorded Date  ", Status.PASS);
   	   		} catch (Exception e) {
   	   			log("STEP 9: User  cannot select Recorded Date", Status.FAIL);
   	   			throw new RuntimeException("Failed in step 9");
   	   		}
      	 
      	 try {
      		 AddEffectiveDate(map.get(Excel.EffectiveDate));
   	   			log("STEP 10:  User can select the Effective Date  ", Status.PASS);
   	   		} catch (Exception e) {
   	   			log("STEP 10: User  cannot select  Effective Date ", Status.FAIL);
   	   			throw new RuntimeException("Failed in step 10");
   	   		}
      	 
          
      	 try {
      		AddPlaintiff(map.get(Excel.Plaintiff));
   	   			log("STEP 11: Entered value should display in the Plaintiff field. ", Status.PASS);
   	   		} catch (Exception e) {
   	   			log("STEP 11: Entered value does not display in Plaintiff field. ", Status.FAIL);
   	   			throw new RuntimeException("Failed in step 11");
   	   		}
      	 
      	 try {
      		AddDefendent(map.get(Excel.Defendent));
    	   			log("STEP 12: Entered value should display in the Defendant field.  ", Status.PASS);
    	   	} catch (Exception e) {
    	   			log("STEP 12: Entered value should display in the Defendant field.  ", Status.FAIL);
    	   			throw new RuntimeException("Failed in step 12");
    	   	}
      	 
      	 
      	 try {
      		AddSecuredParty(map.get(Excel.SecuredParty));
    	   			log("STEP 13: Entered value should display in the Secured Party field.  ", Status.PASS);
    	   	} catch (Exception e) {
    	   			log("STEP 13: Entered value does not display in Secured Party field. ", Status.FAIL);
    	   			throw new RuntimeException("Failed in step 13");
    	   	}
      	 

      	 try {
      		AddDebtor(map.get(Excel.Debtor));
    	   			log("STEP 14: Entered value should display in the Debtor field. ", Status.PASS);
    	   	} catch (Exception e) {
    	   			log("STEP 14: Entered value does not display in Debtor field. ", Status.FAIL);
    	   			throw new RuntimeException("Failed in step 14");
    	   	}
      	 
    	 try {
    		 AddAmount(map.get(Excel.Amount));
     	   			log("STEP 15: Entered value should display in the Amount field. ", Status.PASS);
     	   	} catch (Exception e) {
     	   			log("STEP 15: Entered value does not display in Amount field.  ", Status.FAIL);
     	   			throw new RuntimeException("Failed in step 15");
     	   	}
       	 
    	 try {
    		 AddState(map.get(Excel.State));
       			log("STEP 16:  Entered value should display in the State field. ", Status.PASS);
       		} catch (Exception e) {
       			log("STEP 16: Entered value does not display in State field ", Status.FAIL);
       			throw new RuntimeException("Failed in step 16");
       		}
    	 
    	 try {
    		 AddCounty(map.get(Excel.County));
       			log("STEP 17:  Entered value should display in the County field. ", Status.PASS);
       		} catch (Exception e) {
       			log("STEP 17: Entered value does not display in County field. ", Status.FAIL);
       			throw new RuntimeException("Failed in step 17");
       		}
    	 
    	 try {
    		 AddBookName(map.get(Excel.BookName));
       			log("STEP 18:  Entered value should display in the Book Name field.  ", Status.PASS);
       		} catch (Exception e) {
       			log("STEP 18: Entered value does not display in Book Name field. ", Status.FAIL);
       			throw new RuntimeException("Failed in step 18");
       		}
    	 
    	 try {
    		 ClickonLTCcheckbox();
       			log("STEP 19: Include in LTC checkbox should be display checked  ", Status.PASS);
       		} catch (Exception e) {
       			log("STEP 19: Include in LTC checkbox does not display checked ", Status.FAIL);
       			throw new RuntimeException("Failed in step 19");
       		}
    	 
    	 
    	 try {
    		 AddtComments(map.get(Excel.Comments));
       			log("STEP 20: Entered value should display in the Comments field. ", Status.PASS);
       		} catch (Exception e) {
       			log("STEP 20: Entered value does not display in Comments field. ", Status.FAIL);
       			throw new RuntimeException("Failed in step 20");
       		}
    	 
    	 try {
    		ClickOnInsert();
       			log("STEP 21: Changes saved successfully!  message should be display above the add new button  ", Status.PASS);
       		} catch (Exception e) {
       			log("STEP 21: User cannot click on Insert button or success message does not display ", Status.FAIL);
       			throw new RuntimeException("Failed in step 21");
       		}
       	 
      	 
    }
}
