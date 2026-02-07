package pages.Notes;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditCustomerOutreachNotesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditCustomerOutreachNotesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelNotes = By.xpath("(//span[text()='Parcel Notes'])[1]");
	By navNotes = By.xpath("//*[@id='idCustOutreach_RadTabStrip1']/..//*[text()='Notes']");
	 By notesTab = By.xpath("//*[@id='ctl00_ConPHRightTop_RadTabStrip1']/..//*[text()='Notes']");
	By btnEdit = By.xpath("(//a[contains(text(),'Edit')])[1]");
	By btnEditRow = By.xpath("(//a[contains(text(),'Edit')])[1]");
	By btnEditDOM = By.xpath("(//div[contains(@id,'_LOHTICKETNOTESSEARCH_AGENTNOTES_rgROGrid')]//a[contains(text(),'Edit')])[1]");
//	By navAgentNotes = By.xpath("(//span[text()='Agent Notes'])[1]");
	By btnAddNotesAlt = By.xpath("//img[@alt='Add Notes']");
	By iframeNotesAlt = By.xpath("//iframe[@name='radticketnotes']");
	By iframeRow = By.xpath("//iframe[@name='radticketnotes']");
	By drpActivityDate = By.xpath("(//input[contains(@id,'_dateInput') and @type='text'])[1]");
	By drpAgentAlt = By.xpath("//input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input')and @type='text']");
    By drpCategoryAlt = By.xpath("//input[contains(@id,'AgntNotes_CID_radYALDropDownList_Input') and @type='text']");
    By drpPriorityAlt = By.xpath("//input[contains(@id,'AgntNotes_PID_radYALDropDownList_Input') and @type='text']");
    By txtOfferAmount = By.xpath("//input[contains(@id,'RadNumericTextBox1') and @type='text']"); 
    By txtDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
    By btnUpdateNote = By.xpath("//input[@id='AgntNotes_SN']");
    By SuccessMessage = By.xpath("//span[@id='AgntNotes_usrMessage']");
    
    By iframeNotesDOM = By.xpath("//iframe[@name='UserListDialog']");
	By txtActivityDateDOM = By.xpath("(//input[contains(@id,'AgntNotes_AD_dateInput') and @type='text'])[1]");
	
    public void NavigateToNotesAlt() {
    	util.reloadPage();
    	util.dummyWait(2);
        util.waitUntilElementDisplay(navNotes);
        util.click(navNotes);
    }
    
  
    
    public void ClickonEditButton() {
    	util.waitUntilElementDisplay(btnRefresh);
    	util.click(btnRefresh);
    	util.dummyWait(3);
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    }
    
    
    
 By btnRefresh = By.xpath("//input[contains(@id,'RefreshButton')]");
 By btnRefreshDOM = By.xpath("//a[contains(@id,'_LOHTICKETNOTESSEARCH_AGENTNOTES_rgROGrid_ctl00_ctl02_ctl00_Button1')]");
    
    
    public void ClickonEditButtonRow() {
    	
    	util.waitUntilElementDisplay(btnRefresh);
    	util.click(btnRefresh);
    	util.dummyWait(3);
    	util.waitUntilElementDisplay(btnEditRow);
    	util.click(btnEditRow);
    }
    
  public void ClickonEditButtonDOM() {
    	
    	util.waitUntilElementDisplay(btnRefreshDOM);
    	util.click(btnRefreshDOM);
    	util.dummyWait(3);
    	util.waitUntilElementDisplay(btnEditDOM);
    	util.click(btnEditDOM);
    }
 
    public void SelectActivityDate(String value) {
    	if (!commonFunction.checkNA(value))
    		if(environment.contains("DOM")) {
    			util.inputTextAndPressTab(txtActivityDateDOM, value);
    		}else {
			util.inputTextAndPressTab(drpActivityDate, value);
    		}
    }
    
    public void SelectAgentForAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgentAlt, value);
    }
    By CategoryRow = By.xpath("//input[contains(@id,'AgntNotes_DDL1_radYALDropDownList_Input') and @type='text']");
    public void SelectCategoryForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(CategoryRow, value);
    }
    
    public void SelectCategoryForAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategoryAlt, value);
    }
    
    public void SelectPriorityForAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriorityAlt, value);
    }
    
   
    
    public void AddOfferAmount(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOfferAmount, value);
    }
    
    public void AddDescription(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescription, value);
    }
    
    By btnClose = By.xpath("//a[@title='Close']");
    public void ClickonUpdateNoteAlt() {
    	util.waitUntilElementDisplay(btnUpdateNote);
    	util.click(btnUpdateNote);
    	util.waitUntilElementDisplay(SuccessMessage);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Note submitted for review.");
        util.dummyWait(1);
      
    }
    
    public void ClickOnNotes() {
    	util.waitUntilElementDisplay(navNotes);
    	util.click(navNotes);
    	util.dummyWait(2);
    }
    
public void EditNotes(Map<String, String> map, String testcaseName) {

	  if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
		  	
				try {
					if(environment.contains("DOM")) {
						util.click(notesTab);
						ClickonEditButtonDOM();
					}else {
					ClickOnNotes();
					ClickonEditButtonRow();
					}
		    		 
		 			log("STEP 2: User can click on the Edit Notes Link  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2: User cannot see the Edit Link   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }
				
				if(environment.contains("DOM")) {
					try {
			    		 util.switchToIframe(iframeNotesDOM);
			    		 util.dummyWait(2);
			    		 SelectActivityDate(map.get(Excel.ActivityDate));
			 			log("STEP 3: User can select the  Activity Date", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 3: User  cannot select  Date  from Date Picker  ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 3");
			 		 }
				}else {
		    	 try {
		    		 util.switchToIframe(iframeRow);
		    		 util.dummyWait(2);
		    		 SelectActivityDate(map.get(Excel.ActivityDate));
		 			log("STEP 3: User can select the  Activity Date", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3: User  cannot select  Date  from Date Picker  ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }
				}
				
		    	 try {
		    		 SelectAgentForAlt(map.get(Excel.Agent));
		 			log("STEP 4: Added value displays in Agent field ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 4: User  cannot select  value  from Agent DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 4");
		 		 }
			
		    	 
		    	 try {
		    		 SelectCategoryForRow(map.get(Excel.Category));
		    		log("STEP 5: Added value displays in Category field ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 5: User  cannot select  value  from Category DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 5");
		 		 }
		    	 
		    	 try {
		    		 SelectPriorityForAlt(map.get(Excel.Priority));
		    		log("STEP 6: Added value displays in Priority field ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 6: User  cannot select  value  from Priority DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 6");
		 		 }
		    
		    	 if(!environment.contains("DOM")) {
		    	 try {
	    		 AddOfferAmount(map.get(Excel.Amount));
	 			log("STEP 8: User can enter a value in Amount field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: User cannot add a value in Amount field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
		    	 }
		    	 
		    	 try {
		    		 AddDescription(map.get(Excel.Description));
		 			log("STEP 9: User can enter a value in Description field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 9: User cannot add a value in Description field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 9");
		 		 }
		    	 
		    	 try {
		    		 ClickonUpdateNoteAlt();
		    		 util.dummyWait(1);
		    		 util.switchToDefaultContent();
		    		 util.click(btnClose);
		 			log("STEP 10:  User can able to click on Add Note button 2) Success message should be appeared ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 10: Notes not added 2) Error message should be display ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 10");
		 		 }

	      }
	
	  else {
	 
 				try {
 					ClickOnNotes();
		    		 ClickonEditButton();
		    		 log("STEP 2: User can click on the Edit Notes Link  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2: User cannot see the Edit Link   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }
				
 		    	 
	    	 try {
	    		 util.switchToIframe(iframeNotesAlt);
	    		 util.dummyWait(2);
	    		 SelectActivityDate(map.get(Excel.ActivityDate));
	 			log("STEP 3: User can select the  Activity Date", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	
	    	 try {
	    		 SelectAgentForAlt(map.get(Excel.Agent));
	 			log("STEP 4: Added value displays in Agent field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: User  cannot select  value  from Agent DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
	    	 try {
	    		 SelectCategoryForAlt(map.get(Excel.Category));
	    		log("STEP 5: Added value displays in Category field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: User  cannot select  value  from Category DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 
	    	 try {
	    		 SelectPriorityForAlt(map.get(Excel.Priority));
	    		log("STEP 6: Added value displays in Priority field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6: User  cannot select  value  from Priority DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 
//	    	 try {
//	    		 AddOfferAmount(map.get(Excel.Amount));
//	 			log("STEP 7: User can enter a value in the field  ", Status.PASS);
//	 		 } catch (Exception e) {
//	 			log("STEP 7: User cannot add a value in the field ", Status.FAIL);
//	 			throw new RuntimeException("Failed in step 7");
//	 		 }
	    	 
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	 			log("STEP 8: User can enter a value in Description field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: User cannot add a value in Description field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 
	    	 try {
	    		 ClickonUpdateNoteAlt();
	    		 util.dummyWait(1);
	    		 util.switchToDefaultContent();
	    		 util.click(btnClose);
	 			log("STEP 9:  User can able to click on Add Note button 2) Success message should be appeared ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 9: Notes not added 2) Error message should be display ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 9");
	 		 }
	     	 
	  }
   }
}
