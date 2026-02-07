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

public class EditInvoluntaryLiensRecordPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditInvoluntaryLiensRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By btnEdit = By.xpath("//input[contains(@id,'TLIEN_radYALGridControl_ctl00_ctl04_EditButton')]");
	By txtDocumentNo = By.xpath("//input[contains(@id,'_DOCUMENT_NUMBER') and @type='text']");
	By txtImageNo = By.xpath("//input[contains(@id,'_IMAGE_NUMBER') and @type='text']");
	By txtCauseNo = By.xpath("//input[contains(@id,'_EditFormControl_CLAUSE_NO') and @type='text']");
	By txtPage = By.xpath("//input[contains(@id,'_EditFormControl_DPAGE') and @type='text']");
	By btnUpdate = By.xpath("//input[contains(@id,'TLIEN_radYALGridControl_ctl00_ctl05_EditFormControl_btnUpdate')]");
	By changesSavedSuccessfully = By.xpath("//span[contains(@id,'TLIEN_usrMessage')]");

	
	public void ClickonEdit() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    }
    
	 public void AddDocumentNo(String value) 
	    {util.waitUntilElementDisplay(txtDocumentNo);
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
    
       public void ClickonUpdate() {
	   
	   util.waitUntilElementDisplay(btnUpdate);
   	    util.click(btnUpdate);
   	    util.waitUntilElementDisplay(changesSavedSuccessfully);
	   Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	    util.dummyWait(2);

       }
	
       public void EditInvoluntaryLiensRecord(Map<String, String> map, String testcaseName) {
    	    
    	   try {
    		   ClickonEdit();
        	   log("STEP 1: User can click on Edit button ", Status.PASS);
        	} catch (Exception e) {
    		   log("STEP 1: User cannot click on Edit Icon", Status.FAIL);
    		   throw new RuntimeException(" Failed in step 1 ");
    	    }
    	   
    	   try {
    		   AddDocumentNo(map.get(Excel.DocumentNo));
      		   util.dummyWait(2);
        	   log("STEP 2: User can update Document No ", Status.PASS);
        	} catch (Exception e) {
    		   log("STEP 2: User cannot update Document No", Status.FAIL);
    		   throw new RuntimeException(" Failed in step 2 ");
    	    }
    	   
    	   try {
      		   AddImageNo(map.get(Excel.ImageNo));
    	   			log("STEP 3:  User can update Image No ", Status.PASS);
    	   		} catch (Exception e) {
    	   			log("STEP 3:  User cannot update Image No", Status.FAIL);
    	   			throw new RuntimeException("Failed in step 3");
    	   		}
      	 
    	   try {
    		   ClickonUpdate();
        	   log("STEP 4: User can click on update button and sucess message sucessfully display ", Status.PASS);
        	} catch (Exception e) {
    		   log("STEP 4: User cannot click on update button or sucess message does not display ", Status.FAIL);
    		   throw new RuntimeException(" Failed in step 4 ");
    	    }
	
       }
	
}
