package pages.ProjectDocuments;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DeleteDocumentsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DeleteDocumentsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	
	By navDocument = By.xpath("//span//span//span[text()='Documents']");
    By CheckBox = By.xpath("(//input[contains(@id,'_CheckBox1') and @type='checkbox'])[1]");
    By btnRequestDelete = By.xpath("//input[contains(@id,'_btnRequestDelete') and @type='image']");
    By tableRow = By.xpath("//tr[contains(@id,'_DOCUMENT_radYALGridControl_ctl00__0')]");
   
    
    public void SelectCheckBox() {
    	util.waitUntilElementDisplay(CheckBox);
    	util.click(CheckBox);
    }
    
    public void ClickonRequestDelete() {
    	util.waitUntilElementDisplay(btnRequestDelete);
    	util.click(btnRequestDelete);
    	
    }
    
     By iframe = By.xpath("//iframe[@name='RadWindowDocRequestDeleteMulti']"); 
     By drpReason = By.xpath("//input[contains(@id,'idDocRequestDeletion_ddlDeletionReason_radYALDropDownList_Input') and @type='text']");
     By txtComment = By.xpath("//textarea[@id='idDocRequestDeletion_DeletionReasonComments']");
     By btnRequestDeletion = By.xpath("//input[@id='idDocRequestDeletion_btnRequestDeletion']");
    public void ClickonRequestDeleteROW() {
    	util.waitUntilElementDisplay(btnRequestDelete);
    	util.click(btnRequestDelete);
    }
    
	By DocumentGrid = By.xpath("(//tr[contains(@id,'_DOCUMENT_radYALGridControl')])[1]");
	By btnRequestDeleteDot = By.xpath("//span[contains(text(),'Request Delete')]");
    public void ClickonRequestDeleteDOT(String value) {
    	
    	By clickOnDocument = By.xpath("(//*[text()='" + value + "'])[1]");
		WebElement RclickOnDocument = driver.findElement(clickOnDocument);
		util.click(clickOnDocument);
		util.Rcllick(RclickOnDocument);
//    	WebElement web = driver.findElement(DocumentGrid);
//    	util.waitUntilElementDisplay(DocumentGrid);
//    	Actions act = new Actions(driver);
//    	act.moveToElement(web).contextClick().build().perform();
    	util.dummyWait(1);
    	if(util.isElementVisible(btnRequestDeleteDot)) {
    	util.waitUntilElementDisplay(btnRequestDeleteDot);
    	util.click(btnRequestDeleteDot);
    	util.dummyWait(3);
    	}else {
    		log("Request Delete Option not visible ", Status.SKIP);
    	}
    }
    
    
    
    public void SelectReason(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpReason, value);
    }
    
    public void AddComment(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
    }
    
    public void ClickonRequestDeletionButton() {
    	util.waitUntilElementDisplay(btnRequestDeletion);
    	util.click(btnRequestDeletion);
    	util.switchToDefaultContent();
    	util.dummyWait(2);
    }
    
    By btnCancel = By.xpath("//input[contains(@id,'_btnCancel') and @type='submit']");
    public void ClickonCancelButton() {
    	util.waitUntilElementDisplay(btnRequestDelete);
    	util.click(btnRequestDelete);
    	util.switchToIframe(iframe);
    	util.dummyWait(1);
    	util.waitUntilElementDisplay(btnCancel);
    	util.click(btnCancel);

    }
    
    
    public void DeleteDocument(Map<String, String> map, String testcaseName) {
    
 	   
 	   try {
 		  SelectCheckBox();
	 			log("STEP 1: User can Checked check box ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User cannot able to click on Check Boxes ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
 	
 	   if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
 		   
 		   if(environment.contains("WOLFMIDSTREAM")) {
 			   
 			  try {
 		 		  ClickonRequestDelete();
 			 			log("STEP 2: User can click on the Request Delete button  ", Status.PASS);
 			 		 } catch (Exception e) {
 			 			log("STEP 2: User cannot able to click on Request Delete button ", Status.FAIL);
 			 			throw new RuntimeException("Failed in step 2");
 			 		 }
 			  
 		   }else {
 		   if(util.isElementVisible(btnRequestDelete)) {
 		  try {
 			 ClickonRequestDeleteROW();
 		 			log("STEP 2: User can click on the Request Delete button  ", Status.PASS);
 		 		 } catch (Exception e) {
 		 			log("STEP 2: User cannot able to click on Request Delete button ", Status.FAIL);
 		 			throw new RuntimeException("Failed in step 2");
 		 		 }
 		  
 		  if(util.isElementPresent(iframe)) {
 		 try {
 			util.switchToIframe(iframe);
 	    	util.dummyWait(1);
 			SelectReason(map.get(Excel.Reason));
		 			log("STEP 3: user should be able to select the value from Reason dd  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3: user not able to select the value from Reason dd    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }
 		 
 		try {
 			AddComment(map.get(Excel.Comment));
		 			log("STEP 4: user should be able enter text in the comments field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 4: user not able to enter text in the comments field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 4");
		 		 }
 		
 		try {
 			ClickonRequestDeletionButton();
		 			log("STEP 5: user should be able to click on request deletion button  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 5: user not able to click on request deletion button    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 5");
		 		 }
 		  }
 		   }
 		   }
 	    }
 	   
 	   else if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")){
 		   
 	   try {
 		  ClickonRequestDelete();
	 			log("STEP 2: User can click on the Request Delete button  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot able to click on Request Delete button ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
 	   
 	   }
 	   
 	   else {
 		   util.dummyWait(2);
 		  try {
 		  ClickonRequestDeleteDOT(map.get(Excel.Comment));
			log("STEP 2: User can click on the Request Delete button  ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 2: User cannot able to click on Request Delete button ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		 }
   
    	
       }
 	   
    }
	
}
