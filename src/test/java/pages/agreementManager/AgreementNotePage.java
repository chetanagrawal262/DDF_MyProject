package pages.agreementManager;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AgreementNotePage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	Actions action;
	public AgreementNotePage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navLeaseManager = By.xpath("//a//span[contains(text(),'Lease Manager')] ");
	By navAgreementNotes = By.xpath("//a//span[contains(text(),'Agreement Notes')] ");
	By addNoteButton = By.xpath("//input[contains(@id,'LSINFO_btnAddnotes')]");
	
	public void navigateToAgreementNoteALT() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.dummyWait(1);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();;
		util.dummyWait(1);
		if(!util.isElementPresent(navAgreementNotes, 2)) {
			util.click(navAgreementManager);
			util.dummyWait(1);
		}
		util.waitUntilElementDisplay(navAgreementNotes);
		util.click(navAgreementNotes);
		if (!util.isElementPresent(addNoteButton, 30)) {
			throw new RuntimeException();
		}
	}
	
	By addLeaseButton = By.xpath("//table[contains(@id,'LSLST_RadGridTracts')]//a[contains(@id,'_AddJob')]");
	By leaseNoteTab = By.xpath("//span[text()='Lease Notes']/../../parent::a");
	public void navigateToLeaseManager() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navLeaseManager);
		util.click(navLeaseManager);
	}
	
	public void navigateToLeaseNoteROW() {
		util.waitUntilElementDisplay(addLeaseButton);
		util.click(leaseNoteTab);
	}
	
	private void clickOnNoteButton() {
		util.click(addNoteButton);
	}
	
	By noteIframe = By.xpath("//iframe[@name='AddNotesLease']");
	By editnoteIframe = By.xpath("//iframe[@name='UserListDialog'] | //iframe[@name='AddNotesLease']");
	private void switchToNoteIframe() {
		util.waitForWebElementToBePresent(noteIframe);
		util.switchToIframe(noteIframe);
	}
	private void switchToEditNoteIframe() {
		util.waitForWebElementToBePresent(editnoteIframe);
		util.switchToIframe(editnoteIframe);
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
	By priorityInput = By.xpath("//input[contains(@id,'AgntNotes_PID') and @type='text']");
	private void setPriority(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(priorityInput, value);
		}
	}
	
	By descriptionIframe = By.xpath("//iframe[contains(@id,'AgntNotes_RE1')] | //iframe[@id='AgntNotes_Review_Recommended_Text_contentIframe']");
	 By txtDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe'] | //iframe[@id='AgntNotes_Review_Recommended_Text_contentIframe']");
	private void setDescription(String value) {
		util.inputTextAndPressTab(txtDescription, value);
		util.switchToDefaultContent();
	}
	
	 By btnApprove = By.xpath("//input[@id='AgntNotes_btnApprove']");
	By saveNoteButton = By.xpath("//input[contains(@id,'AgntNotes_SN')]");
	private void clickOnSaveNote() {
		if(util.isElementVisible(btnApprove)) {
    		util.click(btnApprove);
    	}else {
		util.click(saveNoteButton);
    	}
	}
	By closeframe = By.xpath("//a[@title='Close']");
	public void Closeframe() {
		util.click(closeframe);
	}
	
	By agreementNo = By.xpath("//td[text()='AG01']/parent::tr");
	public void addNotes(Map<String, String> map, String testCaseName) {
		
		try {
			util.dummyWait(2);
			if(testCaseName.toLowerCase().contains("row") || testCaseName.contains("TRA")) {
				navigateToLeaseManager();
			} else {
				navigateToAgreementNoteALT();
			}
			commonFunction.projectSelection();
			util.dummyWait(1);
			util.click(agreementNo);
			util.dummyWait(1);
			log("STEP 1: Navigate to Menu -Agreement Information > Agreement Notes tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Menu -Agreement Information > Agreement Notes tab", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		if(testCaseName.toLowerCase().contains("row") || testCaseName.contains("TRA")) {
			navigateToLeaseNoteROW();
		} 
		
		try {
			clickOnNoteButton();
			log("STEP 2: Click Add Notes button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Add Notes button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		try {
			switchToNoteIframe();
			setActivityDate(TestUtil.getCurrentDateTime("MM/dd/yyyy"));
			log("STEP 3: Fill in Activity Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot enter Activity Date", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			setAgent(map.get(Excel.Agent));
			log("STEP 4: User can select value from the Agent DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select value from the Agent DD", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		try {
			setCategory(map.get(Excel.Category));
			log("STEP 5: User can select value from the Category DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select value from the Category DD", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		try {
			setPriority(map.get(Excel.Priority));
			log("STEP 6: User can select Priority", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select Priority", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		try {
			setDescription(map.get(Excel.Description));
			log("STEP 7: User can Fill in Note Description", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot fill in Note Description", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		try {
			switchToNoteIframe();
			clickOnSaveNote();
			util.switchToDefaultContent();
			Closeframe();
			driver.navigate().refresh();
			log("STEP 8: Click on Add Notes button", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on Add Notes button", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		
	}
	
	By refreshButton = By.xpath("//table[contains(@id,'AGENTNOTES_radYALGridControl_ct')]//a[contains(@id,'Button1')]");
	private void clickOnRefresh() {
		util.click(refreshButton);
	}
	
	By editButton = By.xpath("//a[contains(@onclick,'javascript:ShowAgentNotesEditForm')]");
	private void clickOnEditNotes() {
		 util.waitUntilElementDisplay(editButton);
		 util.click(editButton);
		 util.dummyWait(1);
		 if(!util.isElementPresent(editnoteIframe)) {
			 util.click(editButton);
		 }
		
	}
	
	public void editNotes(Map<String, String> map, String testCaseName) {
		if(testCaseName.contains("ROW") || testCaseName.contains("TRA")) {
			util.click(leaseNoteTab);
		}
		if(util.isElementPresent(editButton)){
		try {
			log("STEP 1: User can Navigate to Menu -Agreement Information > Agreement Notes tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Menu -Agreement Information > Agreement Notes tab", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			clickOnRefresh();
			util.waitUntilLoaderDisappear();
			clickOnEditNotes();
			switchToEditNoteIframe();
			log("STEP 2: Click on edit Notes button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on edit Notes button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		if(!testCaseName.contains("ATWELL")) {
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
			setCategory(map.get(Excel.Category));
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
		}
		
		try {
			setDescription(map.get(Excel.Description));
			log("STEP 7: Fill in Note Description", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot fill in Note Description", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		try {
			switchToEditNoteIframe();
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
