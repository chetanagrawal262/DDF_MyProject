package pages.ProjectDocuments;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditDocumentPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditDocumentPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectInformation = By.xpath("(//span[contains(text(),'Project Information')])[1]");
	By navDocumentManagement = By.xpath("(//span[text()='Document Management'])[1]");
	By navDocument = By.xpath("//span//span//span[text()='Documents']");
	By btnEditALT = By.xpath("//input[@id='ctl00_ConPHRightTop_DOCUMENT_radYALGridControl_ctl00_ctl04_EditButton']");
	By btnEditRow = By.xpath("//input[@id='ctl00_ConPHRightTop_PRDC_UC_DOCUMENT_radYALGridControl_ctl00_ctl04_EditButton']");
	By btnEditDot = By.xpath("(//tbody//tr//td//input[contains(@id,'_EditButton')])[1]");
	By txtDocumentName = By.xpath("//input[contains(@id,'_EditFormControl_txtDocName') and @type='text']");
	By txtDocumentCategory = By.xpath("//input[contains(@id,'_ddlDocCat_radYALDropDownList_Input') and @type='text']");
	By txtDraft = By.xpath("//input[contains(@id,'_ddlDocDraftFinal_radYALDropDownList_Input') and @type='text']");
	By txtDate = By.xpath("//input[contains(@id,'_dtExecDate_dateInput') and @type='text']");
	By txtDocumentDescription = By.xpath("//input[contains(@id,'_txtDocDesc') and @type='text']");
	By txtDocDescriptionDot = By.xpath("//textarea[contains(@id,'_EditFormControl_txtDocDesc')]");
	By txtDocumentTitle = By.xpath("(//input[contains(@id,'_EditFormControl_txtTitle')])[1]");
	By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
	By btnCancel = By.xpath("//input[contains(@id,'_EditFormControl_btnCancel') and @type='submit']");
	 By drpDraftFinal = By.xpath("//input[contains(@id,'_EditFormControl_ddlDocDraftFinal_radYALDropDownList_Input')");
	By txtExecutionDate = By.xpath("//input[contains(@id,'EditFormControl_dtExecDate_dateInput') and @type='text']");
	By txtEffectiveDate = By.xpath("//input[contains(@id,'_EditFormControl_dtEffectiveDate_dateInput') and @type='text']");
	
	public void NavigateToDocument() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navProjectInformation);
		util.click(navProjectInformation);
		util.waitUntilElementDisplay(navDocumentManagement);
		util.click(navDocumentManagement);
		
	}
	
	public void ClickonEditButton() {
		util.waitUntilElementDisplay(btnEditALT);
		util.click(btnEditALT);
		util.waitUntilPageLoad();
	}
	
	public void ClickonEdit() {
		util.waitUntilElementDisplay(btnEditRow);
		util.click(btnEditRow);
	}
	
	public void ClickonEditDot() {
		util.waitUntilElementDisplay(btnEditDot);
		util.click(btnEditDot);
	}
	
	 public void AddDocumentName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentName, value);
	  }
	 
	 public void AddDocumentCategory(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentCategory, value);
	  }
	 
	 By selectcategory = By.xpath("//div[contains(@id,'_EditFormControl_ddTreeDocCat_RadDropDownTree1') and @title]");
	 By txtCategory = By.xpath("//div[contains(@id,'_EditFormControl_ddTreeDocCat_RadDropDownTree1')]/../..//input[contains(@value,'Filtering...')]");
	 
	 
	 public void AddDocumentCategoryRow(String value) {
		 util.click(selectcategory);
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCategory, value);
	    	util.pressDownkey();
	    	util.pressENTERkey();
	  }
	 
	 public void AddDraft(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDraft, value);
	  }
	 
	 public void AddDate(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDate, value);
	  }
	 
	 public void AddDocumentDescription(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentDescription, value);
	  }
	 
	 public void AddDocumentDescriptionDot(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocDescriptionDot, value);
	  }
	 
	 public void AddDocumentTitle(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentTitle, value);
	  }
	 
	 public void ClickonUpdateButton() {
			util.waitUntilElementDisplay(btnUpdate);
			util.click(btnUpdate);
			util.waitUntilPageLoad();
			 util.dummyWait(2);
	 }
	 
	 public void ClickonCancelButton() {
		 util.waitUntilElementDisplay(btnEditALT);
			util.click(btnEditALT);
			util.waitUntilPageLoad();
			util.waitUntilElementDisplay(btnCancel);
			util.click(btnCancel);
			util.waitUntilPageLoad();
	}
	 
	 public void ClickonCancel() {
		 util.dummyWait(5);
		 util.waitUntilElementDisplay(btnEditRow);
			util.click(btnEditRow);
			util.waitUntilElementDisplay(btnCancel);
			util.click(btnCancel);
			util.dummyWait(5);
	}
	 
	 public void ClickonCancelDot() {
		 util.dummyWait(3);
		 util.waitUntilElementDisplay(btnEditDot);
			util.click(btnEditDot);
			util.waitUntilElementDisplay(btnCancel);
			util.click(btnCancel);
			util.dummyWait(3);
	}
	 
	   public void EditDocument(Map<String, String> map, String testcaseName) {
	    	
	    	
	       if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL"))
	    	 {  
	    	   try {
	    		   ClickonEditButton();
					log("STEP 1: User can click on the Edit document ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: User cannot able to click on Edit Link ", Status.FAIL);
					throw new RuntimeException("Failed in step 1 ");
				}
	    	   
	    	   try {
		    		 AddDocumentName(map.get(Excel.DocumentName));
		 			log("STEP 2: User can enter a value in Document Name field ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2: User cannot add a value in Document Name field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }
	    	   
	    	   try {
	    		   AddDocumentCategory(map.get(Excel.Category));
		 			log("STEP 3: Added value displays in Category field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3: User  cannot select  value  from Category DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }
	    	   
	    	  try {
	    		   AddDraft(map.get(Excel.Comment));
		 			log("STEP 4: Added value displays in Draft DD  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 4: User  cannot select  value  from Draft DD", Status.FAIL);
		 			throw new RuntimeException("Failed in step 4");
		 		 }
	    	   
	    	   try {
	    		   AddDate(map.get(Excel.Date));
		 			log("STEP 5: User can enter a value in Date field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 5: User cannot add a value in Date field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 5");
		 		 }
	    	   
	    	   try {
	    		   AddDocumentDescription(map.get(Excel.Description));
		 			log("STEP 6: User can enter a value in Description field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 6: User cannot add a value in Description field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 6");
		 		 }
	    	   
	    	    try {
	    		   ClickonUpdateButton();
		 			log("STEP 7: Updated value should be display and saved  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 7: Updated value should not be display in the field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 7");
		 		 }
	    	   
	    	   try {
	    		   ClickonCancelButton();
	    		   log("STEP 8: User can verify the Cancel button", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 8: User cannot verify the cancel button ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 8");
		 		 }
	    	   
	    	 }
	       else if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
	    	   
	    	   try {
	    		   ClickonEdit();
					log("STEP 1: User can click on the Edit document ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: User cannot able to click on Edit document Link ", Status.FAIL);
					throw new RuntimeException("Failed in step 1 ");
				}
	    	   
	    	   try {
		    		 AddDocumentName(map.get(Excel.DocumentName));
		 			log("STEP 2: User can enter a value in Document Name field ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2: User cannot add a value in Document Name field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }
	    	   
	    	   if(util.isElementPresent(txtDocumentCategory)) {
	    	   try {
	    		   AddDocumentCategory(map.get(Excel.Category));
		 			log("STEP 3: Added value displays in Category field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3: User  cannot select  value  from Category DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }
	    	   }else {
	    	   try {
	    		   AddDocumentCategoryRow(map.get(Excel.Category));
		 			log("STEP 4: Added value displays in Category field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 4: User  cannot select  value  from Category DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 4");
		 		 }
	    	   }
	    	   
	    	   try {
	    		   AddDraft(map.get(Excel.Comment));
		 			log("STEP 5: Added value displays in Comment field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 5: User  cannot select  value  from Comment DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 5");
		 		 }
	    	   
	    	   try {
	    		   AddDate(map.get(Excel.Date));
		 			log("STEP 6: User can enter a value in Date field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 6: User cannot add a value in Date field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 6");
		 		 }
		    	   
		    	   try {
			    		  Assert.assertTrue(util.isElementVisible(txtExecutionDate));
				 			log("STEP 7: User can see Execution Date Field", Status.PASS);
				 		 } catch (AssertionError e) {
				 			log("STEP 7: User cannot see Execution Date Field", Status.FAIL);
				 		 }
	    	   
	    	   try {
	    		   AddDocumentDescription(map.get(Excel.Description));
		 			log("STEP 8: User can enter a value in the field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 8: User cannot add a value in the field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 8");
		 		 }
	    	   
	    	   try {
	    		   ClickonUpdateButton();
		 			log("STEP 9: Updated value should be display and saved  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 9: Updated value should not be display in the field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 9");
		 		 }
	    	   
	    	   try {
	    		   ClickonCancel();
	    		   log("STEP 10: User can verify the Cancel button", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 10: User cannot verify the Cancel button ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 10");
		 		 }
	       }
	       else {
	    	   
	    	   try {
	    		   ClickonEditDot();
					log("STEP 1: User can click on the Edit document ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: User cannot able to click on Edit document Link ", Status.FAIL);
					throw new RuntimeException("Failed in step 1 ");
				}
	    	   
	    	   try {
		    		 AddDocumentName(map.get(Excel.DocumentName));
		 			log("STEP 2: User can enter a value in Document Name field ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2: User cannot add a value in Document Name field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }
	    	   
	    	   try {
	    		   AddDocumentCategory(map.get(Excel.Category));
		 			log("STEP 3: Added value displays in Category field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3: User  cannot select  value  from Category DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }
	    	   
	    	   try {
	    		   AddDraft(map.get(Excel.Comment));
		 			log("STEP 4: Added value displays in Comment field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 4: User  cannot select  value  from Comment DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 4");
		 		 }
	    	   
	    	   try {
	    		   AddDate(map.get(Excel.Date));
		 			log("STEP 5: User can enter a value in Date field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 5: User cannot add a value in Date field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 5");
		 		 }
	    	   
	    	   
	    	   try {
	    		   AddDocumentDescriptionDot(map.get(Excel.Description));
		 			log("STEP 6: User can enter a value in Description field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 6: User cannot add a value in Description field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 6");
		 		 }
	    	   
	    	   try {
	    		   AddDocumentTitle(map.get(Excel.DocumentTitle));
		 			log("STEP 7: User can enter a value in Document Title field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 7: User cannot add a value in Document Title field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 7");
		 		 }
	    	   
	    	   try {
	    		   ClickonUpdateButton();
		 			log("STEP 8: User can click on update button", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 8: User cannot click on update button", Status.FAIL);
		 			throw new RuntimeException("Failed in step 8");
		 		 }
	    	   
	    	   try {
	    		   ClickonCancelDot();
		 			log("STEP 9: User can verify the Cancel button", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 9: User cannot verify the Cancel button", Status.FAIL);
		 			throw new RuntimeException("Failed in step 9");
		 		 }
	       }

	   }
}