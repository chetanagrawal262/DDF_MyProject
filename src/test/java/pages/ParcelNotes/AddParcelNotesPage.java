package pages.ParcelNotes;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddParcelNotesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String PROJECT_NAME, TRACT_NO, ACTIVITY_DATE, CATEGORY, NOTE_TEXT, AGENT;

	public AddParcelNotesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelNotes = By.xpath("(//span[text()='Parcel Notes'])[1]");
	By navNotes = By.xpath("(//span[text()='Notes'])[3]");
	By navAgentNotes = By.xpath("(//span[text()='Agent Notes'])[1]");
	By btnAddNotesAlt = By.xpath("//img[@alt='Add Notes']");
	By btnAddNotesDot = By.xpath("//input[contains(@id,'_TRACTTYPE_btnAgentNotes') and @type='button']");
	By btnAddNotesRow = By.xpath("//input[contains(@id,'_TRACTTYPE_btnAddnotes') and @type='image']");
	By iframeNotesAlt = By.xpath("//iframe[@name='UserListDialog']");
    By iframeNotesDot = By.xpath("//tbody/tr[2]/td[2]/iframe[1]");
    By iframeNotesRow = By.xpath("//tbody/tr[2]/td[2]/iframe[1]");
	By drpActivityDate = By.xpath("(//input[contains(@id,'_dateInput') and @type='text'])[1]");
	By drpAgentAlt = By.xpath("//input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input')and @type='text']");
	By drpAgentDot = By.xpath("(//input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input') and @type='text'])[1]");
    By drpAgentRow = By.xpath("//input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input') and @type='text']");
    By drpCategoryAlt = By.xpath("//input[contains(@id,'AgntNotes_CID_radYALDropDownList_Input') and @type='text']");
    By drpCategoryDot = By.xpath("//input[contains(@id,'AgntNotes_CID_radYALDropDownList_Input') and @type='text']");
    By drpCategoryDot2 = By.xpath("//*[contains(@id,'AgntNotes_CATEGORY')]/span");
    By drpCategoryFilter = By.xpath("//*[@id=\"form1\"]/div[1]/div/div[1]/label/input");
    By drpCategoryRow = By.xpath("//input[contains(@id,'AgntNotes_DDL1_radYALDropDownList_Input') and @type='text']");
    By drpPriorityAlt = By.xpath("//input[contains(@id,'AgntNotes_PID_radYALDropDownList_Input') and @type='text']");
//  By drpPriorityDot = By.xpath("//input[contains(@id,'AgntNotes_CID_radYALDropDownList_Input') and @type='text']");
    By drpPriorityRow = By.xpath("//input[contains(@id,'AgntNotes_PID_radYALDropDownList_Input') and @type='text']");
    By txtOfferAmount = By.xpath("//input[contains(@id,'AgntNotes_AMOUNT') and @type='text']"); 
    By txtDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
    By btnAddNote = By.xpath("//input[@id='AgntNotes_SN']");
    By SuccessMessage = By.xpath("//span[@id='AgntNotes_usrMessage']");
    By btnClose = By.xpath("//a[@class='rwCloseButton']");
    
    By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
    //By firstParcel = By.xpath("//*[contains(@id,'LeftTop_TractList_RadGridTracts_ctl00__0')]/td[3]");
    public void NavigateToParcelNotesAlt() {
        util.waitUntilElementDisplay(navParcel);
        util.click(navParcel);
        util.waitUntilElementDisplay(navParcelInfo);
        util.click(navParcelInfo);
        util.waitUntilElementDisplay(navParcelNotes);
        util.click(navParcelNotes);	
    }
    
    public void NavigateToParcelNotesDot() {
        util.waitUntilElementDisplay(navParcel);
        util.click(navParcel);
        util.waitUntilElementDisplay(navParcelInfo);
        util.click(navParcelInfo);
        util.waitUntilElementDisplay(navNotes);
        util.click(navNotes);	
    }
    
    public void NavigateToParcelNotesRow() {
        util.waitUntilElementDisplay(navParcel);
        util.click(navParcel);
        util.waitUntilElementDisplay(navParcelInfo);
        util.click(navParcelInfo);
        util.waitUntilElementDisplay(navAgentNotes);
        util.click(navAgentNotes);	
    }
    
    public void ClickonAddNotesAlt() {
    	util.waitUntilElementDisplay(btnAddNotesAlt);
    	util.click(btnAddNotesAlt);
    }
    
    public void ClickonAddNotesDot() {
    	util.waitUntilElementDisplay(btnAddNotesDot);
    	util.click(btnAddNotesDot);
    }
    
    public void ClickonAddNotesRow() {
    	util.waitUntilElementDisplay(btnAddNotesRow);
    	util.click(btnAddNotesRow);
    }
    
    public void SelectActivityDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpActivityDate, value);
    	
    }
    
    public void SelectAgentForAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgentAlt, value);
    }
    
    public void SelectAgentForDot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgentDot, value);
    }
    
    public void SelectAgentForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgentRow, value);
    }
    
    public void SelectCategoryForAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategoryAlt, value);
    }
    
    public void SelectCategoryForDot(String value) {
    	if (!commonFunction.checkNA(value))
    		util.inputTextAndPressTab(drpCategoryDot, value);
    }
    
   public void SelectCategoryTreeForDot(String value) {
		util.waitUntilElementDisplay(drpCategoryDot2);
		util.click(drpCategoryDot2);
		
		util.inputTextAndPressTab(drpCategoryFilter, value);
		util.pressENTERkey();
    }
   
    
    public void SelectCategoryForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategoryRow, value);
    }
    
    By firstCategory = By.xpath("//div[@id='AgntNotes_DDL1_radYALDropDownList_DropDown']//li[1]");
    public void SelectCategoryWithoutMap() {
    	util.click(drpCategoryRow);
    	util.click(firstCategory);
    }
    
    public void SelectPriorityForAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriorityAlt, value);
    }
    
    public void SelectPriorityForRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriorityRow, value);
    }
    
    public void AddOfferAmount(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOfferAmount, value);
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
   
    
    public void AddParcelNotes(Map<String, String> map, String testcaseName) {
        
    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ATWELL") || testcaseName.contains("ORION")) {
  			
 			 try {
 				NavigateToParcelNotesAlt();
 				commonFunction.projectSelection();
 				util.waitUntilElementDisplay(firstParcel);
 	    		util.click(firstParcel);
 	    		util.dummyWait(10);
	 			log("STEP 1: User can navigate to the Parcel Notes", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User cannot see the Parcel Notes option in Menu ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
	    	 
	    	 try {
	    		
	    		 ClickonAddNotesAlt();
	 			log("STEP 2: User can click on the Add Notes button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot see the Add Notes button  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 try {
	    		 util.switchToIframe(iframeNotesAlt);
	    		 util.dummyWait(2);
	    		 SelectActivityDate(map.get(Excel.ActivityDate));
	 			log("STEP 3: User can select the  Activity Date", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: User  cannot select  the  Activity Date  ", Status.FAIL);
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
	 			log("STEP 8:  User can able to click on Add Note button 2) Success message should be appeared ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: Notes not added 2) Error message should be display ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 
    	}
    	
    	
    	else if(testcaseName.contains("DOT")) {
  			
			 try {
				NavigateToParcelNotesDot();
				commonFunction.projectSelection();
	 			log("STEP 1: User can navigate to the Parcel Notes", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User cannot see the option in Menu ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
	    	 
	    	 try {
	    		
	    		 ClickonAddNotesDot();
	 			log("STEP 2: User can click on the Add Notes button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot see the Add Notes button  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 try {
	    		 util.switchToIframe(iframeNotesDot);
	    		 util.dummyWait(2);
	    		 SelectActivityDate(map.get(Excel.ActivityDate));
	 			log("STEP 3: User can select the  Activity Date", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: User  cannot select  the  Activity Date ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	
	    	 try {
	    		 SelectAgentForDot(map.get(Excel.Agent));
	 			log("STEP 4: Added value displays in Agent field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: User  cannot select  value  from the Agent DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
	    	 if(util.isElementPresent(drpCategoryDot)) {
	    	 
	    	 try {
	    		 SelectCategoryForDot(map.get(Excel.Category));
	    		log("STEP 5: Added value displays in Category field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: User  cannot select  value  from Category DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 }else {
	    		 try {
		    		 SelectCategoryTreeForDot(map.get(Excel.Category));
		    		log("STEP 5: Added value displays in Category field ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 5: User  cannot select  value  from Category DD ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 5");
		 		 }
	    	 }
	    	 
	    	
	    	 
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	 			log("STEP 6: User can enter a value in Description field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6: User cannot add a value in Description field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 
	    	 try {
	    		 ClickonAddNoteDot();
	 			log("STEP 7:  User can able to click on Add Note button 2) Success message should be appeared ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: Notes not added 2) Error message should be display ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	 
   	  }
    	
    	else {
  			
			 try {
				NavigateToParcelNotesRow();
				commonFunction.projectSelection();
				TRACT_NO = driver
						.findElement(By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]")).getAttribute("value");
	 			log("STEP 1: User can navigate to the Parcel Notes", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User cannot see the option in Menu ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
	    	 
	    	 try {
	    		
	    		 ClickonAddNotesRow();
	 			log("STEP 2: User can click on the Add Notes button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot see the Add Notes button  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 try {
	    		 util.switchToIframe(iframeNotesRow);
	    		 util.dummyWait(2);
	    		 SelectActivityDate(map.get(Excel.ActivityDate));
	    		 ACTIVITY_DATE=map.get(Excel.ActivityDate);
	 			log("STEP 3: User can select the  Activity Date", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: User  cannot select  the  Activity Date ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	
	    	 try {
	    		 SelectAgentForRow(map.get(Excel.Agent));
	    		 AGENT=map.get(Excel.Agent);
	 			log("STEP 4: Added value displays in Agent field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: User  cannot select  value  from Agent DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
	    	 try {
	    		 if(environment.contains("WOLFMIDSTREAM")) {
    				 SelectCategoryWithoutMap();
			 }else {
	    		 SelectCategoryForRow(map.get(Excel.Category));
	    		 CATEGORY=map.get(Excel.Category);
			 }
	    		log("STEP 5: Added value displays in Category field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: User  cannot select  value  from Category DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 
	    	 try {
	    		 SelectPriorityForRow(map.get(Excel.Priority));
	    		log("STEP 6: Added value displays in Priority field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6: User  cannot select  value  from Priority DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 
	    	 if(!environment.contains("WOLFMIDSTREAM")) {
	    	 try {
	    		 AddOfferAmount(map.get(Excel.Amount));
	 			log("STEP 7: User can enter a value in Amount field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: User cannot add a value in Amount field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
			} else {
				By contactName = By.xpath(
						"//div[@id='AgntNotes_NOTE_OWNERS_radYALListBox']//span[contains(text(),'Regression_LO')]/..//input[@type='checkbox']");
				if (util.isElementVisible(contactName)) {
					try {
						util.click(contactName);
						log("STEP 7: User can select ContactName ", Status.PASS);
					} catch (Exception e) {
						log("STEP 7: User cannot select ContactName ", Status.FAIL);
					}
				}

			}
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	    		 NOTE_TEXT=map.get(Excel.Description);
	 			log("STEP 8: User can enter a value in Description field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: User cannot add a value in Description field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 
	    	 try {
	    		 ClickonAddNoteRow();
	 			log("STEP 9:  User can able to click on Add Note button 2) Success message should be appeared ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 9: Notes not added 2) Error message should be display ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 9");
	 		 }
	    	 
     	}

    }
}
