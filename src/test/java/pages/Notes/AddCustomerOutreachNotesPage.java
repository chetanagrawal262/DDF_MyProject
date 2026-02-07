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

public class AddCustomerOutreachNotesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddCustomerOutreachNotesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navCustomerOutreach = By.xpath("//span[contains(text(),'Customer Outreach')]");
	By navTicketInformation = By.xpath("(//span[contains(text(),'Ticket Information')])[1]");
	By navNotes = By.xpath("//*[@id='idCustOutreach_RadTabStrip1']/..//*[text()='Notes']");
	By navDocuments = By.xpath("//*[@id='idCustOutreach_RadTabStrip1']/..//*[text()='Documents']");
	By navNotesROW = By.xpath("//*[@id='idCustOutreach_RadTabStrip1']/..//*[text()='Notes']");
	By btnAddNotesAlt = By.xpath("//input[contains(@id,'btnAddNotes')]");
	By btnAddNotesRow = By.xpath("//input[contains(@id,'btnAddNotes')]");
	By iframeNotesAlt = By.xpath("//iframe[@name='UserListDialog']");
    By iframeNotesRow = By.xpath("//iframe[@name='UserListDialog']");
	By drpActivityDate = By.xpath("(//input[contains(@id,'dateInput') and @type='text'])[1]");
	By txtActivityDateDOM = By.xpath("(//input[contains(@id,'AgntNotes_AD_dateInput') and @type='text'])[1]");
	By drpAgentAlt = By.xpath("//input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input')and @type='text']");
    By drpAgentRow = By.xpath("//input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input') and @type='text']");
    By drpCategoryAlt = By.xpath("//input[contains(@id,'AgntNotes_CID_radYALDropDownList_Input') and @type='text']");
    By drpCategoryRow = By.xpath("//input[contains(@id,'DDL1_radYALDropDownList_Input') and @type='text']");
    By drpPriorityAlt = By.xpath("//input[contains(@id,'AgntNotes_PID_radYALDropDownList_Input') and @type='text']");
    By drpPriorityRow = By.xpath("//input[contains(@id,'AgntNotes_PID_radYALDropDownList_Input') and @type='text']");
    By txtActivityTime = By.xpath("//input[@id='AgntNotes_ATime_dateInput']");
    By drpPlat = By.xpath("//input[@id='AgntNotes_PLAT_radYALDropDownList_Input']");
    By drpCallType = By.xpath("//input[@id='AgntNotes_CallType_radYALDropDownList_Input']"); 
    By txtDemandAmount = By.xpath("//input[contains(@id,'AgntNotes_DemandAmount') and @type='text']"); 
    By txtDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
    By btnAddNote = By.xpath("//input[@id='AgntNotes_SN']");
    By SuccessMessage = By.xpath("//span[@id='AgntNotes_usrMessage']");
    By btnClose = By.xpath("//a[@class='rwCloseButton']");
    
    
    public void NavigateToNotes() {
    	util.waitUntilElementDisplay(navAdministration);
    	util.click(navAdministration);
    	util.waitFor(200);  
    	util.waitUntilElementDisplay(navCustomerOutreach);
    	util.hoverOnElement(navCustomerOutreach);
    	util.click(navTicketInformation);

    	
    }
    
    public void ClickOnNotes() {
    	util.waitUntilElementDisplay(navNotes);
    	util.click(navNotes);
    	util.dummyWait(3);
    }
    
    public void ClickOnDocuments() {
    	util.waitUntilElementDisplay(navDocuments);
    	util.click(navDocuments);
    	util.dummyWait(2);
    }
    
    public void ClickOnNotesRow() {
    	util.waitUntilElementDisplay(navNotesROW);
    	util.click(navNotesROW);
    	util.dummyWait(2);
    }
    
    public void NavigateToNotesROW() {
//    	util.waitUntilElementDisplay(navAdministration);
//    	util.click(navAdministration);
    	util.waitUntilElementDisplay(navCustomerOutreach);
    	util.click(navCustomerOutreach);
    	util.waitUntilElementDisplay(navTicketInformation);
    	util.click(navTicketInformation);
    
    
    }
    
    
    
    public void ClickonAddNotesAlt() {
    	util.waitUntilElementDisplay(btnAddNotesAlt);
    	util.click(btnAddNotesAlt);
    }
    
    
    public void ClickonAddNotesRow() {
    	util.waitUntilElementDisplay(btnAddNotesRow);
    	util.click(btnAddNotesRow);
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
    
    
    public void SelectAgentForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgentRow, value);
    }
    
    public void SelectCategoryForAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategoryAlt, value);
    }
    
  
    
    public void SelectCategoryForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategoryRow, value);
    }
    
    public void SelectPriorityForAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriorityAlt, value);
    }
    
    
    public void SelectPriorityForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriorityRow, value);
    }
    
    public void AddActivityTimeForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtActivityTime, value);
    }
    
    public void SelectPlatForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPlat, value);
    }
    
   
    public void SelectCallTypeForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCallType, value);
    }
    
    public void AddDemandAmountForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDemandAmount, value);
    }
     
   
    
    public void AddDescription(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescription, value);
    }
    
    public void ClickonAddNoteAlt() {
    	util.waitUntilElementDisplay(btnAddNote);
    	util.click(btnAddNote);
    	util.waitUntilElementDisplay(SuccessMessage);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Note submitted for review.");
        util.switchToDefaultContent();
        util.click(btnClose);
        util.dummyWait(2);
    }
    
    public void ClickonAddNoteDot() {
    	util.waitUntilElementDisplay(btnAddNote);
    	util.click(btnAddNote);
    	util.waitUntilElementDisplay(SuccessMessage);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Note submitted and auto-approved.");
		 util.switchToDefaultContent();
	        util.click(btnClose);
	        util.dummyWait(2);
    	
    }
    
    public void ClickonAddNoteRow() {
    	util.waitUntilElementDisplay(btnAddNote);
    	util.click(btnAddNote);
    	util.waitUntilElementDisplay(SuccessMessage);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Note submitted and auto-approved.");
		 util.switchToDefaultContent();
	        util.click(btnClose);
	        util.dummyWait(2);
    }
    
    By drpTicket = By.xpath("//input[contains(@id,'idCustOutreach_RadLOWTicketQueueSelector_Input') and @type='text']");
    By firstTicket = By.xpath("//*[@id='idCustOutreach_RadGridLOHTicketList_ctl00__0']");  
	   public void SelectTicket(String value) {
		   util.click(drpTicket);
		   util.selectValueFromDropdown(drpTicket, value);
		   util.dummyWait(2);
		   util.waitUntilElementDisplay(firstTicket);
	  		util.click(firstTicket);
	  		util.dummyWait(3);
	   }
   
	   
	  By navEncroachmentRequests = By.xpath("//span[contains(text(),'Encroachment Requests')]");
	  By notesTab = By.xpath("//*[@id='ctl00_ConPHRightTop_RadTabStrip1']/..//*[text()='Notes']");
	   public void NavigateToEncroachmentNotes() {
	    	util.waitUntilElementDisplay(navAdministration);
	    	util.click(navAdministration);
	    	util.waitFor(200);
	    	util.waitUntilElementDisplay(navEncroachmentRequests);
	    	util.hoverOnElement(navEncroachmentRequests);
	    	util.click(navEncroachmentRequests);
	    	util.waitUntilPageLoad();
	    	util.click(notesTab);
	    }
    
    public void AddNotes(Map<String, String> map, String testcaseName) {
        
    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
  			
 			 try {
 				NavigateToNotes();
 				SelectTicket(map.get(Excel.Ticket));
 				ClickOnNotes();
	 			log("STEP 1: User can navigate to the  Notes", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User cannot navigate to the  Notes ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
	    	 
 			 if(util.isElementVisible(btnAddNotesAlt)) {
	    	 try {
	    		
	    		 ClickonAddNotesAlt();
	 			log("STEP 2: User can click on the Add Notes button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot see the Add Notes button  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }}
 			 else {
 				
 				try {
 					ClickOnDocuments();
 		    		 ClickonAddNotesAlt();
 		 			log("STEP 2: User can click on the Add Notes button ", Status.PASS);
 		 		 } catch (Exception e) {
 		 			log("STEP 2: User cannot see the Add Notes button  ", Status.FAIL);
 		 			throw new RuntimeException("Failed in step 2");
 		 		 }
 			 }
	    	 
	    	 try {
	    		 util.switchToIframe(iframeNotesAlt);
	    		 util.dummyWait(2);
	    		 SelectActivityDate(map.get(Excel.ActivityDate));
	 			log("STEP 3: User can select the  Activity Date", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: User  cannot select  Activity Date  ", Status.FAIL);
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
	    	 
	    	
	    	 
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	 			log("STEP 7: User can enter a value in Description field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: User cannot add a value in Description field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	 
	    	 try {
	    		 ClickonAddNoteAlt();
	 			log("STEP 8:  User can able to click on Add Note button", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: Notes not added", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 
    	}
    	
    	
    	
    	
    	else {
  			
    		 if(environment.contains("DOM")) { 
    			 try {
    					
    				 NavigateToEncroachmentNotes();
    	 			log("STEP 1: User can navigate to the Encroachment Notes", Status.PASS);
    	 		 } catch (Exception e) {
    	 			log("STEP 1: User cannot navigate to the Encroachment Notes ", Status.FAIL);
    	 			throw new RuntimeException("Failed in step 1");
    	 		 } 
    		 }else {
			 try {
				
				 NavigateToNotesROW();
				 SelectTicket(map.get(Excel.Ticket));
	 				ClickOnNotesRow();
				
	 			log("STEP 1: User can navigate to the Customer Outreach Notes", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User cannot navigate to the Customer Outreach Notes ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
    		 }
	    	 
			 if(util.isElementVisible(btnAddNotesRow)) {
	    	 try {
	    		
	    		 ClickonAddNotesRow();
	 			log("STEP 2: User can click on the Add Notes button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot click on the Add Notes button  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
			 }else {
				 
				 try {
					 ClickOnDocuments();
		    		 ClickonAddNotesRow();
		 			log("STEP 2: User can click on the Add Notes button ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2: User cannot click on the Add Notes button  ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }
			 }
	    	 try {
	    		 util.switchToIframe(iframeNotesRow);
	    		 util.dummyWait(2);
	    		 SelectActivityDate(map.get(Excel.ActivityDate));
	 			log("STEP 3: User can select the  Activity Date", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: User  cannot select  Activity  Date  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	
	    	 try {
	    		 SelectAgentForRow(map.get(Excel.Agent));
	 			log("STEP 4:  User  can select  value  from Agent DD ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: User  cannot select  value  from Agent DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
	    	 try {
	    		 SelectCategoryForRow(map.get(Excel.Category));
	    		log("STEP 5: User  can select  value  from Category DD ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: User  cannot select  value  from Category DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 
	    	 try {
	    		 SelectPriorityForRow(map.get(Excel.Priority));
	    		log("STEP 6: User  can select  value  from Priority DD ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6: User  cannot select  value  from Priority DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 
	    	 try {
	    		 AddActivityTimeForRow(map.get(Excel.ActivityTime));
	    		log("STEP 7: User can enter Activity Time ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: User  cannot enter Activity Time ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	 
	    	 if(util.isElementVisible(drpPlat)) {
	    	 try {
	    		 SelectPlatForRow(map.get(Excel.Plat));
	 			log("STEP 8: User can enter a value in Plat field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: User cannot add a value in Plat field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 }
	    	 
	    	 try {
	    		 SelectCallTypeForRow(map.get(Excel.CallType));
	 			log("STEP 9: User can select value from Call type dd  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 9: User cannot select value from Call type dd ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 9");
	 		 }
	    	 
	    	 try {
	    		 AddDemandAmountForRow(map.get(Excel.Amount));
	 			log("STEP 10: User can enter a value in Amount field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 10: User cannot add a value in Amount field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 10");
	 		 }
	    	 
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	 			log("STEP 11: User can enter a value in Description field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 11: User cannot add a value in Description field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 11");
	 		 }
	    	 
	    	 try {
	    		 ClickonAddNoteRow();
	 			log("STEP 12:  User can able to click on Add Note button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 12: Notes not added ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 12");
	 		 }
	    	 
     	}

    }
}
