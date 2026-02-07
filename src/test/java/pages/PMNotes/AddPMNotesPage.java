package pages.PMNotes;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddPMNotesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddPMNotesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectInformation = By.xpath("//span[contains(text(),'Project Information')]");
	By navProjectNotes = By.xpath("//span[contains(text(),'Project Notes')]");
	By btnAddNotesAlt = By.xpath("(//img[@alt='Add Notes'])[3]");
	By btnAddNotesDot = By.xpath("//input[contains(@id,'btnPrjAddNotes') and @type='button']");
	By btnAddNotesRow = By.xpath("//img[@alt='Add Notes']"); 
	By iframeNotes = By.xpath("//iframe[@name='UserListDialog']");
	By txtActivityDate = By.xpath("//input[contains(@id,'_AD_dateInput') and @type='text']");
	By drpAgent = By.xpath("//input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input') and @type='text']");
	By drpCategory = By.xpath("//input[contains(@id,'AgntNotes_CID_radYALDropDownList_Input') and @type='text']");
    By drpCategoryRow = By.xpath("//input[contains(@id,'_DDL1_radYALDropDownList_Input') and @type='text']");
    By drpPriority = By.xpath("//input[contains(@id,'_PID_radYALDropDownList_Input') and @type='text']");
    By txtDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
    By btnAddNotes = By.xpath("//input[@id='AgntNotes_SN']");
    By SuccessMessage = By.xpath("//span[@id='AgntNotes_usrMessage']");
    By btnClose = By.xpath("//a[@title='Close']");
    
    
    public void NavigateToPMNotes() {
    	util.waitUntilElementDisplay(navProject);
    	util.click(navProject);
    	util.waitUntilElementDisplay(navProjectInformation);
    	util.click(navProjectInformation);
    	util.waitUntilElementDisplay(navProjectNotes);
    	util.click(navProjectNotes);
    	
    }
    
    public void ClickOnAddNotesAlt() {
    	util.waitUntilElementDisplay(btnAddNotesAlt);
    	util.click(btnAddNotesAlt);
    }
    
    public void ClickOnAddNotesDot() {
    	util.waitUntilElementDisplay(btnAddNotesDot);
    	util.click(btnAddNotesDot);
    }
    
    public void ClickOnAddNotesRow() {
    	util.waitUntilElementDisplay(btnAddNotesRow);
    	util.click(btnAddNotesRow);
    }
    
    public void AddActivityDate(String value) {
    	util.switchToIframe(iframeNotes);
    	util.dummyWait(1);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtActivityDate, value);
    }
    
    public void SelectAgent(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgent, value);
    }
    
    public void SelectCategory(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategory, value);
    }
    
    public void SelectCategoryRow(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategoryRow, value);
    }
    
    public void SelectPriority(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPriority, value);
    }
    
    public void AddDescription(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescription, value);
    }
    
    public void ClickOnAddNotes() {
    	util.waitUntilElementDisplay(btnAddNotes);
    	util.click(btnAddNotes);
    	util.dummyWait(1);
    }
    
    public void AddProjectNotes(Map<String, String> map, String testcaseName) {

    	 try {
    		 NavigateToPMNotes();
    		 commonFunction.projectSelection();
	 			log("STEP 1: User can navigate to the Poject Notes ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User cannot see the option in Menu  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
    	 
    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
    		 try {
    			 ClickOnAddNotesAlt();
    			 log("STEP 2: User can click on the Add Notes button", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot see the Add Notes button ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
    	 }
    	 else if(testcaseName.contains("DOT")) {
    		 try {
    			 ClickOnAddNotesDot();
    			 log("STEP 2: User can click on the Add Notes button", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot see the Add Notes button ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
    	 }
    	 else {
    		 try {
    			 ClickOnAddNotesRow();
    	 			log("STEP 2: User can click on the Add Notes button", Status.PASS);
    	 		 } catch (Exception e) {
    	 			log("STEP 2: User cannot see the Add Notes button ", Status.FAIL);
    	 			throw new RuntimeException("Failed in step 2");
    	 		 }
    	 }
    	 
    	 try {
    		 AddActivityDate(map.get(Excel.ActivityDate));
 			log("STEP 3: User can select the  Activity Date", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 3: User  cannot select  Date  from Date Picker  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 3");
 		 }
    	 
    	 try {
    		 SelectAgent(map.get(Excel.Agent));
    		 log("STEP 4: Added value displays in Agent field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP  4: User  cannot select  value  from Agent DD ", Status.FAIL);
 			throw new RuntimeException("Failed in step 4");
 		 }
    	 
    	 if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
    		 try {
        		 SelectCategoryRow(map.get(Excel.Category));
        		 log("STEP 5: Added value displays in Category field ", Status.PASS);
     		 } catch (Exception e) {
     			log("STEP 5: User  cannot select  value  from Category DD ", Status.FAIL);
     			throw new RuntimeException("Failed in step 5");
     		 }
    	 }
     else {
    	 try {
    		 SelectCategory(map.get(Excel.Category));
 			log("STEP 5: Added value displays in Category field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 5: User  cannot select  value  from Category DD ", Status.FAIL);
 			throw new RuntimeException("Failed in step 5");
 		 }
      }
    	 
    	 try {
    		 SelectPriority(map.get(Excel.Priority));
 			log("STEP 6: Added value displays in Priority field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 6: User  cannot select  value  from Priority DD ", Status.FAIL);
 			throw new RuntimeException("Failed in step 6");
 		 }
    	 
    	 try {
    		 AddDescription(map.get(Excel.Description));
 			log("STEP 7: User can enter a value in Description field ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 7: User cannot add a value in Description field  ", Status.FAIL);
 			throw new RuntimeException("Failed in step 7");
 		 }
    	 
    	 try {
    		 ClickOnAddNotes();
 			log("STEP 8: User can able to click on Add Note button ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 8:  Notes not added ", Status.FAIL);
 			throw new RuntimeException("Failed in step 8");
 		 }
    	 if (util.isElementPresent(SuccessMessage)) {
 			log("STEP 9:Success message should be appeared ", Status.PASS);
 		} else {
 			log("STEP 9:Error message should be display", Status.FAIL);
 			throw new RuntimeException("Faild in STEP 9:Error message should be display");
 		}
    	 
    	 util.switchToDefaultContent();
    	 util.dummyWait(1);
    	 util.click(btnClose);
    	 
    	 
    }
}
