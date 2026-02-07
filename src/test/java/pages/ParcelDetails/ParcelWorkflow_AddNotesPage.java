package pages.ParcelDetails;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ParcelWorkflow_AddNotesPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ParcelWorkflow_AddNotesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By btnNotes = By.xpath("//span[contains(text(),'Notes')]");
	By iframeNotes = By.xpath("//iframe[@name='radWinAgentNotes']");
	By btnAddNotes = By.xpath("//input[contains(@id,'_btnAddNotes') and  @type='submit']");
	By txtActivityDate = By.xpath("//input[contains(@id,'_AD_dateInput') and  @type='text']");
	By datePicker = By.xpath("//a[@class='rcCalPopup']");
	By SelectDate = By.xpath("//td[@title='Monday, February 27, 2023']");
	By drpAgent = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[1]");
	By drpNotesCategory = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[2]");
	By drpPriority = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[3]");
	By ActivityTime = By.xpath("//a[@title='Open the time view popup.']");
	By SelectTime = By.xpath("//a[contains(text(),'5:00 PM')]");
	By Contacts = By.xpath("(//input[contains(@class,'rlbCheck') and  @type='checkbox'])[1]");
	By drpPlat = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[4]");   
	By drpCallType = By.xpath("(//input[contains(@id,'_radYALDropDownList_Input') and  @type='text'])[5]");
// 	By OfferAmount = By.xpath("(//input[contains(@id,'AgntNotes_RadNumericTextBox1') and  @type='text'])");   NOT MENTION IN TC
	By txtDemandAmount = By.xpath("(//input[contains(@id,'AgntNotes_DemandAmount') and  @type='text'])");
	By txtNotesDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
	By AddNotes = By.xpath("//input[contains(@id,'AgntNotes_SN') and @type ='image']");
	By AddNotesDOT = By.xpath("//input[contains(@id,'AgntNotes_SN') and @type ='button']");
	By SuccessMassage = By.xpath("//span[@id='AgntNotes_usrMessage']");
	
	
	 public void ClickOnNotes() {
	    	util.waitUntilElementDisplay(btnNotes);
	    	util.click(btnNotes);
			
	    } 
	    
	    public void ClickOnAddNotes() {
	    	util.waitUntilElementDisplay(btnAddNotes);
	    	util.click(btnAddNotes);
	    	util.switchToIframe(iframeNotes);
	    	util.dummyWait(5);
			
	    }
	    
	    public void AddActivityDate(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtActivityDate, value);
			
	    }
	    
	    public void SelectAgent(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAgent, value);
			
	    }
	    
	    public void SelectNotesCategory(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpNotesCategory, value);
			
	    }
	    
	    public void SelectPriority(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpPriority, value);
			
	    }
	    
	    public void AddActivityTime() {
	    	util.waitUntilElementDisplay(ActivityTime);
	    	util.click(ActivityTime);
	    	util.dummyWait(5);
	    	util.click(SelectTime);
			
	    }
	    
	    public void SelectContacts() {
	    	util.waitUntilElementDisplay(Contacts);
	    	util.click(Contacts);
			
	    }
	    
	    public void SelectPlat(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpPlat, value);
	    }
	    
	    public void SelectCallType(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCallType, value);
			
	    }
	    
	    public void AddDemandAmount(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDemandAmount, value);
			
	    }
	    
	   
	    public void AddNotesDescription(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtNotesDescription, value);
			
	    }
	    
	    
	    public void ClickonAddNotes() {
	    	util.waitUntilElementDisplay(AddNotes);
	    	util.click(AddNotes);
	    	util.waitUntilElementDisplay(SuccessMassage);
	    	Assert.assertTrue(util.isElementPresent(SuccessMassage), "Note submitted for review.");
	    }

	    public void ClickonAddNotesDOT() {
	    	util.waitUntilElementDisplay(AddNotesDOT);
	    	util.click(AddNotesDOT);
	    	util.waitUntilElementDisplay(SuccessMassage);
	    	Assert.assertTrue(util.isElementPresent(SuccessMassage), "Note submitted and auto-approved.");
	    }
	    
		By btnCloseNotes = By.xpath("//a[@class='rwCloseButton']");
	    By iframe= By.xpath("//iframe[@name='ManageApprovalDialog']");
	    public void ClickonClose() {
			util.switchToDefaultContent();
	    	util.dummyWait(1);
	    	util.switchToIframe(iframe);
            util.dummyWait(1);
		    util.waitUntilElementDisplay(btnCloseNotes);
	    	util.click(btnCloseNotes);
            util.dummyWait(1);

	    }
	    
	    
	    public void AddNotes(Map<String, String> map, String testcaseName) {

	    	 try {
	    		 ClickOnNotes();
	    		 util.dummyWait(5);
	    		 ClickOnAddNotes();
	  			 log("STEP 1: User can click on the add Notes button  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 1:  User cannot see the add Notes button  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 1");
	  		 }
	    	 
	    	 
	    	 try {
	    		 AddActivityDate(map.get(Excel.ActivityDate));
	  			 log("STEP 2:  User can select Activity  Date   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 2:  User  cannot select  Date  from Date Picker ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 2");
	  		 }
	    	 
	    	 try {
	    		 SelectAgent(map.get(Excel.Agent));	
		         log("STEP 4:   Added value displays in the field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 4:  User  cannot select  value  from the DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step  4");
	  		 }
	    	 
	    	 if(testcaseName.contains("DOT")) {
	    		 try {
		    		 SelectNotesCategory(map.get(Excel.Category));
		    		 log("STEP 5:  Added value displays in the field ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 5:  User  cannot select  value  from the DD  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 5");
		  		 } 
	    	 }
	    	 
	    	 else if(testcaseName.contains("ALT")) {
	    		 try {
		    		 SelectNotesCategory(map.get(Excel.Category));
		    		 log("STEP 5:  Added value displays in the field ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 5:  User  cannot select  value  from the DD  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 5");
		  		 } 
	    		 
	    		 try {
		    		 SelectPriority(map.get(Excel.Priority));
		    		 log("STEP 6:  Added value displays in the field ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 6:  User  cannot select  value  from the DD  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 6");
		  		 }
	    	 }
	  
	    	 else {
	    		 
	    		 try {
		    		 SelectNotesCategory(map.get(Excel.Category));
		  			 log("STEP 5:  Added value displays in the field ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 5:  User  cannot select  value  from the DD  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 5");
		  		 } 
	    	 
	    	 try {
	    		 SelectPriority(map.get(Excel.Priority));
	  			 log("STEP 6:  Added value displays in the field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 6:  User  cannot select  value  from the DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 6");
	  		 }
	    	
	    	 try {
	    		 AddActivityTime();
	  			 log("STEP 7:  User can select time from time picker.   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 7:  User  cannot select time from time picker.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 7");
	  		 }
	    	 
	    	
	    	 try {
	    		 SelectContacts();
	  			 log("STEP 8: User can select contact from dd     ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 8:  User  cannot select contact from dd     ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 8");
	  		 }
	    	 
	    	
	    
	    	 
	    	 try {
	    		 SelectCallType(map.get(Excel.CallType));
	  			 log("STEP 9: User can select call type from dd  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 9:  User  cannot select  Call type  from the DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 9");
	  		 }
	    	
	    	 try {
	    		 AddDemandAmount(map.get(Excel.DemandAmount));
	  			 log("STEP 10: User can enter a value in Demand Amount field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 10: User cannot add a value in Demand Amount field  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 10");
	  		 }
	    	 
	    }	
	    	 try {
	    		 AddNotesDescription(map.get(Excel.Description));
	  			 log("STEP 11:  Added value displays in Description field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 11:  User  cannot select  value  from Description DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 11");
	  		 }
	    	
	    	 if(testcaseName.contains("DOT"))
	     {
	    	 try {
	    		 ClickonAddNotesDOT();
	  			 log("STEP 12:  Added value displays in the field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 12:  User  cannot select  value  from the DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 12");
	  		 }
	    }
	    	 else {  
	    	 try {
	    		 ClickonAddNotes();
	  			 log("STEP 12:  Added value displays in the field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 12:  User  cannot select  value  from the DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 12");
	  		 } 
	    	 
	    } 
	    	 ClickonClose();
	   }
		    
	
}
