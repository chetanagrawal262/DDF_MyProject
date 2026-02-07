package pages.ProjectNotes;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditProjectNotesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditProjectNotesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By btnEdit = By.xpath("(//*[contains(@id,'AGENTNOTES_radYALGridControl')]/..//*[text()='Edit' and contains(@onclick,'ShowAgentNotesEditForm')])[1]");
	By btnEditDot = By.xpath("(//*[contains(@id,'AGENTNOTES_radYALGridControl')]/..//*[text()='Edit' and contains(@onclick,'ShowAgentNotesEditForm')])[1]");
	By btnEditRow = By.xpath("(//*[contains(@id,'AGENTNOTES_radYALGridControl')]/..//*[text()='Edit' and contains(@onclick,'ShowAgentNotesEditForm')])[1]");
	By btnAddNotesAlt = By.xpath("//img[@alt='Add Notes']");
	By iframeNotesAlt = By.xpath("//iframe[@name='UserListDialog']");
	By iframeRow = By.xpath("//body[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/iframe[1]");
	By drpActivityDate = By.xpath("(//input[contains(@id,'_dateInput') and @type='text'])[1]");
	By drpAgentAlt = By.xpath("//input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input')and @type='text']");
    By drpCategoryAlt = By.xpath("//input[contains(@id,'AgntNotes_CID_radYALDropDownList_Input') and @type='text']");
    By drpPriorityAlt = By.xpath("//input[contains(@id,'AgntNotes_PID_radYALDropDownList_Input') and @type='text']");
    By txtOfferAmount = By.xpath("//input[contains(@id,'AgntNotes_AMOUNT') and @type='text']"); 
    By txtDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe'] | //iframe[@id='AgntNotes_Review_Recommended_Text_contentIframe']");
    By btnUpdateNote = By.xpath("//input[@id='AgntNotes_SN']");
    By SuccessMessage = By.xpath("//span[@id='AgntNotes_usrMessage']");
    
    By btnApprove = By.xpath("//input[@id='AgntNotes_btnApprove']");

    
    By RefreshAlt = By.xpath("//img[contains(@id,'AGENTNOTES_radYALGridControl') and contains(@src,'gridrefresh')]");
    
    public void ClickonEditButton() {
    	util.waitUntilElementDisplay(RefreshAlt);
    	util.click(RefreshAlt);
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    }
    
    By RefreshDot = By.xpath("//img[contains(@id,'AGENTNOTES_radYALGridControl') and contains(@src,'gridrefresh')]");
    public void ClickonEditButtonDot() {
    	util.waitUntilElementDisplay(RefreshDot);
    	util.click(RefreshDot);
    	util.dummyWait(4);
    	util.click(btnEditDot);
    }
    
    By RefreshRow = By.xpath("//a[contains(@id,'AGENTNOTES_radYALGridControl')]");
    public void ClickonEditButtonRow() {
    	util.waitUntilElementDisplay(RefreshRow);
    	util.click(RefreshRow);
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(btnEditRow);
    	util.click(btnEditRow);
    }
    
    public void SelectActivityDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpActivityDate, value);
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
    
    
    By firstCategory = By.xpath("//div[@id='AgntNotes_DDL1_radYALDropDownList_DropDown']//li[1]");
    public void SelectCategoryWithoutMap() {
    	util.click(CategoryRow);
    	util.click(firstCategory);
    }
    
    public void SelectPriorityForAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriorityAlt, value);
    }
    
    By AgentAction = By.xpath("//input[contains(@id,'AgntNotes_Agent_ActionsTW_RadTVCbProjectList_Input') and @type='text']");
    public void SelectAgentAction(String value) {
    if (!commonFunction.checkNA(value))
    {
    	util.selectDropDownValue(AgentAction, value);
    	util.pressENTERkey();
    }
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
    	if(util.isElementVisible(btnApprove)) {
    		util.click(btnApprove);
    	}else {
    		util.waitUntilElementDisplay(btnUpdateNote);
        	util.click(btnUpdateNote);
        	util.waitUntilElementDisplay(SuccessMessage);
    		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Note submitted for review.");
            util.dummyWait(1);
    	}
    }
    
public void EditProjectNotes(Map<String, String> map, String testcaseName) {
	         if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
				try {
		    		 
		    		 ClickonEditButtonRow();
		 			log("STEP 1: User can click on the Edit Notes link ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 1: User cannot see the Edit Notes link  ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 1");
		 		 }
				

		    	 try {
		    		 util.switchToIframe(iframeRow);
		    		 util.dummyWait(2);
		    		 SelectActivityDate(map.get(Excel.ActivityDate));
		 			log("STEP 2: User can select the  Activity Date", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2: User  cannot select Activity Date ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }
		    	 
		    	 try {
		    		 SelectAgentForAlt(map.get(Excel.Agent));
		 			log("STEP 3: Added value displays in the Agent field ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3: User  cannot select  value  from the Agent DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }
			
		    	 
		    	 try {
		    		 if(environment.contains("WOLFMIDSTREAM")) {
        				 SelectCategoryWithoutMap();
    			 }else {
		    		 SelectCategoryForRow(map.get(Excel.Category));
    			 }
		    		log("STEP 4: Added value displays in the Category field ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 4: User  cannot select  value  from the Category DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 4");
		 		 }
		    	 
		    	 try {
		    		 SelectPriorityForAlt(map.get(Excel.Priority));
		    		log("STEP 5: Added value displays in the Priority field ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 5: User  cannot select  value  from the Priority DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 5");
		 		 }
		    	 
		    	 if(util.isElementVisible(AgentAction)) {
		    	 try {
		    		 SelectAgentAction(map.get(Excel.AgentAction));
		 			log("STEP 6: User can enter a value in the Agent Action field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 6: User cannot add a value in the Agent Action field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 6");
		 		 }
		    	 }
		    	 
		    	 if(util.isElementVisible(txtOfferAmount)) {
		    	 try {
	    		 AddOfferAmount(map.get(Excel.Amount));
	 			log("STEP 7: User can enter a value in the Offer Amount field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: User cannot add a value in the Offer Amount field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
		    	 }
		    	 try {
		    		 AddDescription(map.get(Excel.Description));
		 			log("STEP 8: User can enter a value in the Description field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 8: User cannot add a value in the Description field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 8");
		 		 }
		    	 
		    	 try {
		    		 ClickonUpdateNoteAlt();
		 			log("STEP 9:  User can able to click on Update Note button 2) Success message should be appeared ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 9: Notes not added 2) Error message should be display ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 9");
		 		 }
	    		 util.switchToDefaultContent();
	    		 util.click(btnClose);

	         }
	
	    else {
	
  			if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {	 
  				try { 
		    		 ClickonEditButton();
		 			log("STEP 1: User can click on the Edit Notes link ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 1: User cannot see the Edit Notes link  ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 1");
		 		 } 
  			  } 			
  			 else  {
  				try {
  		    		 ClickonEditButtonDot();
  		 			log("STEP 1: User can click on the Edit Notes link", Status.PASS);
  		 		 } catch (Exception e) {
  		 			log("STEP 1: User cannot see the Edit Notes link ", Status.FAIL);
  		 			throw new RuntimeException("Failed in step 1");
  		 		 }
  				
  				
  			   }

  			util.switchToIframe(iframeNotesAlt);
   		    util.dummyWait(2);
   		 if(!testcaseName.contains("ATWELL")) {
   			 
	    	 try {
	    		 
	    		 SelectActivityDate(map.get(Excel.ActivityDate));
	 			log("STEP 2: User can select the  Activity Date", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User  cannot select Activity Date   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	
	    	 try {
	    		 SelectAgentForAlt(map.get(Excel.Agent));
	 			log("STEP 3: Added value displays in Agent field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: User  cannot select  value  from Agent DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 
	    	 try {
	    		 SelectCategoryForAlt(map.get(Excel.Category));
	    		log("STEP 4: Added value displays in Category field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: User  cannot select  value  from Category DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
	    	 try {
	    		 SelectPriorityForAlt(map.get(Excel.Priority));
	    		log("STEP 5: Added value displays in Priority field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: User  cannot select  value  from Priority DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 
//	    	 try {
//	    		 AddOfferAmount(map.get(Excel.Amount));
//	 			log("STEP 6: User can enter a value in the field  ", Status.PASS);
//	 		 } catch (Exception e) {
//	 			log("STEP 6: User cannot add a value in the field ", Status.FAIL);
//	 			throw new RuntimeException("Failed in step 6");
//	 		 }
   		    }
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	 			log("STEP 7: User can enter a value in Description field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: User cannot add a value in Description field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	 
	    	 
	    	 try {
	    		 ClickonUpdateNoteAlt();
	 			log("STEP 8:  User can able to click on Add Note button 2) Success message should be appeared ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: Notes not added 2) Error message should be display ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
    		 util.switchToDefaultContent();
    		 util.click(btnClose);
	    	 
	  }
    }
}
