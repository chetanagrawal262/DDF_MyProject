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

public class ParcelWorkflow_Edit_DeleteProjectNotesPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ParcelWorkflow_Edit_DeleteProjectNotesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By linkEditRow = By.xpath("//a[contains(text(),'Edit')]");
	By iframeNotes = By.xpath("//iframe[@name='radWinAgentNotes']");
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
 	By OfferAmount = By.xpath("(//input[contains(@id,'AgntNotes_RadNumericTextBox1') and  @type='text'])");  // NOT MENTION IN TC
	By txtDemandAmount = By.xpath("(//input[contains(@id,'AgntNotes_DemandAmount') and  @type='text'])");
	By txtNotesDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
	By btnupdate = By.xpath("//input[@id='AgntNotes_SN']");
	By SuccessMassage = By.xpath("//span[@id='AgntNotes_usrMessage']");
	By closebtn = By.xpath("//a[@class='rwCloseButton']");
	
	By btnRefresh = By.xpath("//img[@id='idManageApproval_NOTES_radYALGridControl_ctl00_ctl02_ctl00_Img1']");
	By iframenote = By.xpath("//iframe[@name='UserListDialog']");
	public void ClickOnEditRow() {
		 util.waitUntilElementDisplay(btnRefresh);
	    	util.click(btnRefresh);
	    	util.waitUntilElementDisplay(linkEditRow);
	    	util.click(linkEditRow);
			util.dummyWait(2);
			util.switchToIframe(iframenote);
			util.dummyWait(1);
	    } 
	 
	  public void AddActivityDate(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtActivityDate, value);
	    }
	    
	    
	    public void SelectNotesCategory(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpNotesCategory, value);
			
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
	    public void SelectAgent(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAgent, value);
			
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
	By    btnUpdateDot = By.xpath("//input[contains(@id,'AgntNotes_SN') and @type='button']");
	
	public void ClickOnUpdatebtnDot() {
    	util.waitUntilElementDisplay(btnUpdateDot);
    	util.click(btnUpdateDot);
    	util.waitUntilElementDisplay(SuccessMassage);
    	Assert.assertTrue(util.isElementPresent(SuccessMassage), "Note submitted and auto-approved.");
    }
	
	    public void ClickOnUpdatebtn() {
	    	util.waitUntilElementDisplay(btnupdate);
	    	util.click(btnupdate);
	    	util.waitUntilElementDisplay(SuccessMassage);
	    	Assert.assertTrue(util.isElementPresent(SuccessMassage), "Note submitted for review.");
	    }
	    By iframe= By.xpath("//iframe[@name='ManageApprovalDialog']");
	    public void ClickonClose() {
			util.switchToDefaultContent();
	    	util.dummyWait(1);
	    	util.switchToIframe(iframe);
            util.dummyWait(1);
		    util.waitUntilElementDisplay(closebtn);
	    	util.click(closebtn);
            util.dummyWait(1);
	    }
	    
	    By btnDelete = By.xpath("(//input[contains(@id,'_gbcDeleteAlignment')])[2]");
	    By btnok = By.xpath("//span[text()='OK']");
	    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
//	    By newFrame= By.xpath("//iframe[@name='ManageApprovalDialog']");
	    
	    By btnOk = By.xpath("//span[text()='OK']");
	    public void ClickOnDeleteNote() {
	    	util.switchToDefaultContent();
	    	util.waitUntilElementDisplay(btnDelete);
	    	util.click(btnDelete);
	    	util.dummyWait(1);
	    	util.waitUntilElementDisplay(btnOk);
	    	util.click(btnOk);
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(changesSavedSuccessfully);
	    	Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	    }

	 
	   
	    
	    
	    public void EditDeleteNotes(Map<String, String> map, String testcaseName) {
   if(testcaseName.contains("ROW")) {
	    	 try {
	    		 ClickOnEditRow();
	    		 util.dummyWait(5);
	  			 log("STEP 1: User can click on the add Notes button  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 1:  User cannot see the add Notes button  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 1");
	  		 }
	    	 
	    	 
	    	 try {
	    		 AddActivityDate(map.get(Excel.ActivityDate));
	  			 log("STEP 2:  User can select Activity  Date   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 2:  User  cannot select Activity Date  from Date Picker ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 2");
	  		 }
	    	 
	    	 
	    	 try {
	    		 SelectNotesCategory(map.get(Excel.Category));
	  			 log("STEP 4:  Added value displays in Category field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 4:  User  cannot select  value  from Category DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 4");
	  		 }
	  
	    	
	    	 try {
	    		 AddActivityTime();
	  			 log("STEP 6:  Added value displays in the field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 6:  User  cannot select  value  from the DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 6");
	  		 }
	    	 
	    	
	    	 try {
	    		 SelectContacts();
	  			 log("STEP 7:  Added value displays in the field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 7:  User  cannot select  value  from the DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 6");
	  		 }
	    	 
	    	 try {
	    		 SelectPlat(map.get(Excel.Plat));
	  			 log("STEP 8:  Added value displays in Plat field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 8:  User  cannot select  value  from Plat DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 8");
	  		 }
	    	
	    	 try {
	    		 SelectCallType(map.get(Excel.CallType));
	  			 log("STEP 9:  Added value displays in Call Type field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP  9:  User  cannot select  value  from Call Type DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 9");
	  		 }
	    	
	    	 try {
	    		 AddDemandAmount(map.get(Excel.DemandAmount));
	  			 log("STEP 10:  Added value displays in Demand Amount field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 10:  User  cannot select  value  from Demand Amount DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 10");
	  		 }
	    	
	    	 try {
	    		 AddNotesDescription(map.get(Excel.Description));
	  			 log("STEP 11:  Added value displays in Description field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 11:  User  cannot select  value  from Description DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 11");
	  		 }
	  
	    	 try {
	    		 ClickOnUpdatebtn();
	    		 util.dummyWait(2);
	    		 ClickonClose();
	  			 log("STEP 12: User can able to click on Update Note button", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 12:  User  cannot able to click on Update Note button  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 12");
	  		 }


	    	 
   }
   
    else {
	   try {
  		 
		   ClickOnEditRow();
			 log("STEP 1: User can click on the add Notes button  ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 1:  User cannot see the add Notes button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		 }
  	 
  	 
  	 try {
  		 AddActivityDate(map.get(Excel.ActivityDate));
			 log("STEP 2:  User can select Activity  Date   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 2:  User  cannot select Activity Date  from Date Picker ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		 }
  	 
  	 try {
  		 SelectAgent(map.get(Excel.Agent));	
	         log("STEP 3:   Added value displays in Agent field ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 3:  User  cannot select  value  from Agent DD  ", Status.FAIL);
			throw new RuntimeException("Failed in step  3");
		 }
  	
  		 try {
	    	 SelectNotesCategory(map.get(Excel.Category));
	  		 log("STEP 4:  Added value displays in Category field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 4:  User  cannot select  value  from Category DD  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 4");
	  		 } 
  		 

    	 try {
    		 AddNotesDescription(map.get(Excel.Description));
  			 log("STEP 11:  User can enter a value in Description field  ", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 11:  User  cannot enter a value in Description field  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 11");
  		 }
    	 
    	 
      if(testcaseName.contains("DOT")) {
    	 try {
    		 ClickOnUpdatebtnDot();
    		   ClickonClose();
    		 util.dummyWait(2);	
  			 log("STEP 12: User can able to click on Update Note button", Status.PASS);
  		 } catch (Exception e) {
  			log("STEP 12:  User  cannot able to click on Update Note button  ", Status.FAIL);
  			throw new RuntimeException("Failed in step 12");
  		 }
    }
      
      else {
    	  try {
     		 ClickOnUpdatebtn();
     		   ClickonClose();
     		 util.dummyWait(2);
   			 log("STEP 12: User can able to click on Update Note button", Status.PASS);
   		 } catch (Exception e) {
   			log("STEP 12:  User  cannot able to click on Update Note button  ", Status.FAIL);
   			throw new RuntimeException("Failed in step 12");
   		 }
      }
  	 
      }

      util.switchToDefaultContent();
      util.click(closebtn);
      util.dummyWait(2);
	}
	   
	
	
}
