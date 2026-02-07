package pages.ThirdPartyAgreement;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AgentNotePage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	Actions action;
	public AgentNotePage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navThirdPartyAgreements = By.xpath("//a//span[contains(text(),'Third Party Agreements')] ");
	By agentNoteTab = By.xpath("//span[text()='Agent Notes']/../../parent::a");
	By buttonAddNotes = By.xpath("(//img[contains(@onclick,'TPAgentNotes')])[2]");
	
	public void navigateToThirdPartyAgreement() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navThirdPartyAgreements);
		util.click(navThirdPartyAgreements);		
	}
	
	public void navigateToAgentNotesTab() {
		util.waitUntilElementDisplay(agentNoteTab);
		util.click(agentNoteTab);
	}
	
	private void clickOnAddNoteButton() {
		util.click(buttonAddNotes);
	}
	
	By noteIframe = By.xpath("//iframe[@name='UserListDialog']");
	private void switchToNoteIframe() {
		util.waitForWebElementToBePresent(noteIframe);
		util.switchToIframe(noteIframe);
	}
	
	By activityDate = By.xpath("//input[contains(@id,'AgntNotes_AD_dateInput') and @type='text']");
	private void setActivityDate(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(activityDate, value);
		}
	}
	
	By agentInput = By.xpath("//input[contains(@id,'AgntNotes_UID') and @type='text']");
	private void setAgent(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(agentInput, value);
		}
	}
	By categoryInput = By.xpath("//input[contains(@id,'AgntNotes_CID') or contains(@id,'AgntNotes_DDL') and @type='text']");
	private void setCategory(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(categoryInput, value);
		}
	}
	
	By firstCategory = By.xpath("//div[@id='AgntNotes_DDL1_radYALDropDownList_DropDown']//li[1]");
    public void SelectCategoryWithoutMap() {
    	util.click(categoryInput);
    	util.click(firstCategory);
    }
    
	By priorityInput = By.xpath("//input[contains(@id,'AgntNotes_PID') and @type='text']");
	private void setPriority(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(priorityInput, value);
		}
	}
	
	 By txtDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
	private void setDescription(String value) {
		util.inputTextAndPressTab(txtDescription, value);
		util.switchToDefaultContent();
	}
	
	 By saveNoteButton = By.xpath("//input[contains(@id,'AgntNotes_SN')]");
	private void clickOnSaveNote() {
		util.click(saveNoteButton);
	}
	By closeframe = By.xpath("//a[@title='Close']");
	public void Closeframe() {
		util.click(closeframe);
	}
	
	By agreementNo = By.xpath("//td[text()='AG01']/parent::tr");
	public void addNotes(Map<String, String> map, String testCaseName) {
		
		try {
			navigateToThirdPartyAgreement();
			commonFunction.projectSelection();
			util.dummyWait(1);
			util.click(agreementNo);
			util.dummyWait(1);
			log("STEP 1: User can navigate to Menu -Third Party Agreements", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Menu -Third Party Agreements", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			navigateToAgentNotesTab();
			util.dummyWait(1);
			log("STEP 2: User can navigate to Agent Notes Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot navigate to Agent Notes Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			clickOnAddNoteButton();
			log("STEP 3: Click Add Notes button", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on Add Notes button", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			switchToNoteIframe();
			setActivityDate(TestUtil.getCurrentDateTime("MM/dd/yyyy"));
			log("STEP 4: Fill in Activity Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter Activity Date", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		try {
			setAgent(map.get(Excel.Agent));
			log("STEP 5: User can select value from the Agent DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select value from the Agent DD", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		try {
			SelectCategoryWithoutMap();
			log("STEP 6: User can select value from the Category DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select value from the Category DD", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		try {
			setPriority(map.get(Excel.Priority));
			log("STEP 7: User can select Priority", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot select Priority", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		try {
			setDescription(map.get(Excel.Description));
			log("STEP 8: User can Fill in Note Description", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot fill in Note Description", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		try {
			switchToNoteIframe();
			clickOnSaveNote();
			util.switchToDefaultContent();
			Closeframe();
			driver.navigate().refresh();
			log("STEP 9: Click on Add Notes button", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot click on Add Notes button", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		
	}
	
	By refreshButton = By.xpath("//table[contains(@id,'AGENTNOTES')]//a[contains(@id,'Button1')]");
	private void clickOnRefresh() {
		util.click(refreshButton);
	}
	
	By editButton = By.xpath("//a[contains(@onclick,'javascript:ShowAgentNotesEditForm')]");
	private void clickOnEditNotes() {
		 util.waitUntilElementDisplay(editButton);
		 util.click(editButton);
		 util.dummyWait(1);
		 if(!util.isElementPresent(noteIframe)) {
			 util.click(editButton);
		 }
		
	}
	
	public void editNotes(Map<String, String> map, String testCaseName) {
		if(util.isElementPresent(editButton)){
		try {
			util.click(agentNoteTab);
			log("STEP 1: User can Navigate to Agent Notes tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Agent Notes tab", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			clickOnRefresh();
			util.waitUntilLoaderDisappear();
			clickOnEditNotes();
			switchToNoteIframe();
			log("STEP 2: Click on edit Notes button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on edit Notes button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			
			setActivityDate(TestUtil.getCurrentDateTime("MM/dd/yyyy"));
			log("STEP 3: Fill in Activity Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot enter the Activity Date", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			setAgent(map.get(Excel.Agent));
			log("STEP 4: Fill in Agent DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select the Agent", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		try {
			SelectCategoryWithoutMap();
			log("STEP 5: Fill in Category DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:User cannot select the Category", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		try {
			setPriority(map.get(Excel.Priority));
			log("STEP 6: Fill in Priority DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select the Priority", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			setDescription(map.get(Excel.Description));
			log("STEP 7: Fill in Note Description", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot fill in Note Description", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		try {
			switchToNoteIframe();
			clickOnSaveNote();
			log("STEP 8: Click on Add Notes button", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on Add Notes button", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
	}
		else {
			log(" Edit link is not available", Status.SKIP);
		}
		}


}
