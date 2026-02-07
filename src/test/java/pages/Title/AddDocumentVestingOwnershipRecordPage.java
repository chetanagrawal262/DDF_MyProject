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

public class AddDocumentVestingOwnershipRecordPage extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddDocumentVestingOwnershipRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navDocumentVestingOwnership  = By.xpath("//span[contains(text(),'Document Vesting Ownership')]");
    By btnAddnew  = By.xpath("(//img[contains (@id,'_VESTING_radYALGridControl_')])[1]");
	By drpDocumentType  =  By.xpath("//input[contains(@id,'_EditFormControl_DOC_TYPE_DDL_radYALDropDownList_Input') and @type='text'] | //input[contains(@id,'_VESTING_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_DOCUMENT_TYPE') and @type='text']");
	By txtDocumentNo  = By.xpath("//input[contains(@id,'_EditFormControl_DOCUMENT_NUMBER') and @type='text']");
	By txtImageNo  = By.xpath("//input[contains(@id,'_EditFormControl_IMAGE_NUMBER') and @type='text']");
	By txtCauseNo = By.xpath("//input[contains(@id,'_EditFormControl_CLAUSE_NO') and @type='text']");
	By txtVolume = By.xpath("//input[contains(@id,'_EditFormControl_VOLUME') and @type='text']");
	By txtPage = By.xpath("//input[contains(@id,'_EditFormControl_DPAGE') and @type='text']");
	By txtExecutedDate = By.xpath("//input[contains(@id,'_EditFormControl_EXECUTED_DATE_dateInput') and @type='text']");
	By txtRecordedDate = By.xpath("//input[contains(@id,'_EditFormControl_RECORDED_DATE_dateInput') and @type='text']");
	By txtEffectiveDate = By.xpath("//input[contains(@id,'_EditFormControl_EFFECTIVE_DATE_dateInput') and @type='text']");
	By txtPetitioner = By.xpath("//input[contains(@id,'_EditFormControl_PETITIONER') and @type='text']");
	By txtRespondent = By.xpath("//input[contains(@id,'_EditFormControl_RESPONDENT') and @type='text']");
	By txtIndependentExecutor = By.xpath("//input[contains(@id,'_EditFormControl_EXECUTOR') and @type='text']");
	By txtAffiant = By.xpath("//input[contains(@id,'_EditFormControl_AFFIANT') and @type='text']");
	By txtNameofDeceased = By.xpath("//input[contains(@id,'_EditFormControl_DECEASED') and @type='text']");
	By txtState = By.xpath("//input[contains(@id,'_EditFormControl_State') and @type='text']");
	By txtCounty = By.xpath("//input[contains(@id,'EditFormControl_County') and @type='text']");
	By txtBookName = By.xpath("//input[contains(@id,'_EditFormControl_Name_Of_Record') and @type='text']");
	By btnAddDocument = By.xpath("//img[@alt='Add Document']");
    By CurrentVestingCheakBox = By.xpath("//input[contains(@id,'_VESTING_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_isCurrent')]");
	By txtHeirs = By.xpath("//textarea[contains(@id,'_EditFormControl_HIERS')]");
	By txtGrantor = By.xpath("//textarea[contains(@id,'_EditFormControl_GRANTOR')]");
	By txtGrantee = By.xpath("//textarea[contains(@id,'_EditFormControl_GRANTEE')]");
    By txtComments = By.xpath("//textarea[contains(@id,'_EditFormControl_COMMENTS')]");
    By btnInsert = By.xpath("//input[contains(@id,'_VESTING_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_btnInsert')]");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");

    
    public void navDocumentVestingOwnership() 
    {
		util.waitUntilElementDisplay(navDocumentVestingOwnership);
		util.click(navDocumentVestingOwnership);
		util.waitUntilElementDisplay(btnAddnew);
		util.click(btnAddnew);
		util.waitUntilLoaderDisappear();
    } 
    
    public void AddDocumentType(String value) 
    {
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
    
    public void AddPetitioner(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPetitioner, value);
	}
    public void AddRespondent(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtRespondent, value);
	}
    public void AddIndependentExecutor(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtIndependentExecutor, value);
	}
    public void AddAffiant(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAffiant, value);
	}
    public void AddNameofDeceased(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtNameofDeceased, value);
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
		driver.switchTo().alert().dismiss();
		
	}
    public void ClcikOnCurrentVestingCheakBox() 
    {
    	util.waitUntilElementDisplay(CurrentVestingCheakBox);
		util.click(CurrentVestingCheakBox);
		
	}
    public void AddHeirs(String value) 
    {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtHeirs, value);
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
    public void AddInsert() 
    {
    	util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilLoaderDisappear();
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");

	}
    
    public void AddDocumentVestingOwnershipRecord(Map<String, String> map, String testcaseName) {
    	 try {
    		 navDocumentVestingOwnership();
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
    		 AddCauseNo(map.get(Excel.CauseNo));
	   			log("STEP 5:  Entered value should display in the Cause No field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 5:  Entered value does not display in Cause No field ", Status.FAIL);
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
	   			log("STEP 8:  User can select the  Executed Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 8: User  cannot select  Executed Date", Status.FAIL);
	   			throw new RuntimeException("Failed in step 8");
	   		}
    	 
    	 try {
    		 AddRecordedDate(map.get(Excel.RecordedDate));
	   			log("STEP 9:  User can select the  Recorded Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 9: User  cannot select  Recorded Date", Status.FAIL);
	   			throw new RuntimeException("Failed in step 9");
	   		}
    	 
    	 try {
    		 AddEffectiveDate(map.get(Excel.EffectiveDate));
	   			log("STEP 10:  User can select the  Effective Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 10: User  cannot select  Effective Date", Status.FAIL);
	   			throw new RuntimeException("Failed in step 10");
	   		}
    	 
    	 try {
    		 AddPetitioner(map.get(Excel.Petitioner));
	   			log("STEP 11: Entered value should display in the Petitioner field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 11: Entered value does not display in Petitioner field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 11");
	   		}
    	 
    	 try {
    		 AddRespondent(map.get(Excel.Respondent));
	   			log("STEP 12:  Entered value should display in the Respondent field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 12: Entered value does not display in Respondent field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 12");
	   		}
    	 
    	 try {
    		 AddIndependentExecutor(map.get(Excel.IndependentExecutor));
	   			log("STEP 13:  Entered value should display in the Independent Executor/Executrix field. ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 13: Entered value does not display in Independent Executor/Executrix field.  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 13");
	   		}
    	 
    	 try {
    		 AddAffiant(map.get(Excel.Affiant));
	   			log("STEP 14:  Entered value should display in the Affiant field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 14: Entered value does not display in Affiant field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 14");
	   		}
    	 
    	 try {
    		 AddNameofDeceased(map.get(Excel.NameofDeceased));
	   			log("STEP 15: Entered value should display in the Name of Deceased field. ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 15:  Entered value does not display in Name of Deceased field. ", Status.FAIL);
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
    		 ClcikOnCurrentVestingCheakBox();
	   			log("STEP 19: Current Vesting Deed checkbox should be display checked  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 19: Current Vesting Deed checkbox does not display checked ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 19");
	   		}
    	 
    	 try {
    		 AddHeirs(map.get(Excel.Heirs));
	   			log("STEP 20: Entered value should display in the Heirs field. ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 20: Entered value does not display in Heirs field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 20");
	   		}
    	 
    	 try {
    		 AddGrantor(map.get(Excel.Grantor));
	   			log("STEP 21: Entered value should display in the Grantor field. ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 21:  Entered value does not display in Grantor field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 21");
	   		}
    	 
    	 try {
    		 AddGrantee(map.get(Excel.Grantee));
	   			log("STEP 22: Entered value should display in the Grantee field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 22: Entered value does not display in Grantee field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 22");
	   		}
    	 
    	 try {
    		 AddtComments(map.get(Excel.Comments));
	   			log("STEP 23: Entered value should display in the Comments field. ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 23: Entered value does not display in Comments field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 23");
	   		}
    	 
    	 try {
    		 AddInsert();
	   			log("STEP 24: Changes saved successfully!  message should be display above the add new button  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 24: Save successful message does not display above the add new button   ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 24");
	   		}
    	
    	 
    	
    }
  
}
    
