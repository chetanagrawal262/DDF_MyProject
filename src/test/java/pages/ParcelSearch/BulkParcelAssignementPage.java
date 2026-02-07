package pages.ParcelSearch;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class BulkParcelAssignementPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public BulkParcelAssignementPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By ExpandBulkParcelAssignementPanel = By.xpath("(//span[@class='rdExpand'])[1]");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
	By Checkbox = By.xpath("(//input[contains(@id,'_CheckBox1')])[1]"); 
	By drpAgent = By.xpath("//input[contains(@id,'_BLKTRACTASGN_MSUSER_Input')]");
	By SelectAgentROW = By.xpath("//span[@class='rddtFakeInput rddtEmptyMessage']");
	By txtAgent = By.xpath("//input[contains(@class,'rddtFilterEmptyMessage') and @value='Filtering...']");
	By drpAssignment = By.xpath("//input[contains(@id,'_BLKTRACTASGN_MSASSIGNMENTS_YALComboBox_Input')]");
	By txtDueDate = By.xpath("(//input[contains(@id,'BLKTRACTASGN_DUEDATE_dateInput')])[1]");
	By drpPriority = By.xpath("(//input[contains(@id,'Priority_ID_YALComboBox_Input')])[1]");
	By CheckboxPrimary = By.xpath("(//input[contains(@id,'BLKTRACTASGN_chkPrimary')])[1]");
	By btnUpdate = By.xpath("(//input[contains(@id,'BLKTRACTASGN_AddBulkUsers')])[1]");
	By error = By.xpath("//span[contains(text(),'Please select tract(s) for bulk assignment')]"); 
	
	
	 public void ExpandBulkUpdateOption() {
	    	util.waitUntilElementDisplay(ExpandBulkParcelAssignementPanel);
	    	util.click(ExpandBulkParcelAssignementPanel);
	    }
	    
	    public void ClickOnCheckbox() {
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(Checkbox);
	    	util.click(Checkbox);
//	    	util.click(Checkbox);

	    }
	    
	    public void RightClickOnDocumentGrid() {
	    	WebElement web = driver.findElement(documentgrid);
	    	util.waitUntilElementDisplay(documentgrid);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	    }
	    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
	    By btnClose = By.xpath("//a[@title='Close']");
	    By iframe = By.xpath("//iframe[@name='SearchSingleOpen']");
	    public void ClickOnOpeninPopupButton() {
	    	util.dummyWait(1);
	    	util.click(btnOpenInPopup);
	    	util.dummyWait(1);
	    	util.switchToIframe(iframe);
	    	util.dummyWait(1);
	    
	    }
	    
	    By Assignment = By.xpath("(//span[text()='Assignments'])[2]");
	    
	    public void ClickOnAssignment() {
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(Assignment);
	    	util.click(Assignment);
	    	util.dummyWait(1);

	    }
	    
	    public void SelectAgent(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputText(drpAgent, value);
	    	util.dummyWait(1);
	    	util.pressDownkey();
	    	util.pressENTERkey();
	    }
	    
	    public void SelectAgentROW(String value) {
	    	util.click(SelectAgentROW);
	    	if (!commonFunction.checkNA(value)) 
				util.inputText(txtAgent, value);
	    	util.dummyWait(1);
	    	util.pressDownkey();
	    	util.pressENTERkey();
	    }
	    
	    public void SelectAssignment(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputText(drpAssignment, value);
	    	util.pressDownkey();
	    	util.pressENTERkey();
	    }
	    
	    public void AddDueDate(String value) {
	    	util.dummyWait(1);
	    	util.click(txtDueDate);
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtDueDate, value);
	    }
	    
	    public void AddPriority(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpPriority, value);
	    }
	    
	    public void ClickOnCheckboxPrimary() {
	    	util.waitUntilElementDisplay(CheckboxPrimary);
	    	util.click(CheckboxPrimary);
	    }

	    public void ClickOnUpdate() {
	    	util.waitUntilElementDisplay(btnUpdate);
	    	util.click(btnUpdate);
	    }
	    
        By getStrAssignmentName = By.xpath("//tr[contains(@id,'AGENTS_radYALGridControl_ctl00')][last()]//td[5]");
        By getStrAssignmentNameDot = By.xpath("//tr[contains(@id,'AGENTS_radYALGridControl_ctl00')][last()]//td[23]");
        By getStrAssignmentNameRow = By.xpath("//tr[contains(@id,'AGENTS_radYALGridControl_ctl00')][last()]//td[6]");

        public void VerifyAssignmentName() {
	   		String AssignmentName = util.getText(getStrAssignmentName);
	   		log("Assignment Name is  :" + AssignmentName);
	   		}
	    
	    By getStrAgent = By.xpath("//tr[contains(@id,'AGENTS_radYALGridControl_ctl00')][last()]//td[4]");
	    By getStrAgentDot = By.xpath("//tr[contains(@id,'AGENTS_radYALGridControl_ctl00')][last()]//td[22]");
	    By getStrAgentRow = By.xpath("//tr[contains(@id,'AGENTS_radYALGridControl_ctl00')][last()]//td[5]");

	    public void VerifyAgent() {
	   		String Agent = util.getText(getStrAgent);
	   		log("Agent Name is  :" + Agent);
	   		}

	    By ParcelInformation = By.xpath("(//span[text()='Parcel Information'])[2] | (//span[text()='Record Information'])[2]");
	    public void ClickOnClose() {
	    	util.dummyWait(1);
	    	
	    	util.switchToDefaultContent();
	    	util.waitUntilElementDisplay(btnClose);
	    	util.click(btnClose);
	    }
	    
	
	    public void BulkParcelAssignement(Map<String, String> map, String testcaseName) {
			
//			try {
//				ClickOnCheckbox();
//				log("STEP 2: when user right click on records 2 options should be displayed 1)Open in window. 2)Open in current window.  ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 2:  User cannot right click on search results. ", Status.FAIL);
//				throw new RuntimeException("Failed in step 2");
//			}
			
			
			try {
				ExpandBulkUpdateOption();
				log("STEP 1:  User can expand bulk update option panel ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:   User cannot expand bulk update option panel   ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
				try {
					SelectAgent(map.get(Excel.Agent));
					log("STEP 2:   User can select value from Agent dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2:   User canbot select value from Agent dd  ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
			}
			else {
			try {
				SelectAgent(map.get(Excel.Agent));
				log("STEP 2:   User can select value from Agent dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:   User canbot select value from Agent dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		}
			
			try {
				SelectAssignment(map.get(Excel.Assignment));
				log("STEP 3:   User can select value from Assignment dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:   User canbot select value from Assignment dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
//			try {
//				AddDueDate(map.get(Excel.DueDate));
//				log("STEP 8:   User can select value from DueDate dd ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 8:   User canbot select value from DueDate dd  ", Status.FAIL);
//				throw new RuntimeException("Failed in step 8");
//			}

			try {
				AddPriority(map.get(Excel.Priority));
				log("STEP 4:   User can select value from Priority dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:   User canbot select value from Priority dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				ClickOnCheckboxPrimary();
				log("STEP 5:  User can check checkbox ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User cannot check checkbox  ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				ClickOnUpdate();
				util.dummyWait(2);
				log("STEP 6:  User can click on update button.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  User cannot  click on update  button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			if(util.isElementVisible(error)) {
                util.click(Checkbox);
                ClickOnUpdate();
			}
			
			
			try {
				RightClickOnDocumentGrid();
				log("STEP 7:  when user right click on records 2 options should be displayed 1)Open in window. 2)Open in current window.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User cannot right click on search results. ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				ClickOnOpeninPopupButton();
				log("STEP 8:'AMPS:Project dashboard' popup is open with poject information.", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:  Popup will not be opened. ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			
			try {
				ClickOnAssignment();
				log("STEP 9: User can Navigate To Assignment Tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot Navigate To Assignment Tab ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			

			try {
				By assignment = By.xpath("(//*[contains(@id,'_AGENTS_radYALGridControl_')]//*[text()='"+map.get(Excel.Assignment)+"'])[1]");
				System.out.println(assignment);
				Assert.assertTrue(util.isElementVisible(assignment));
				log("STEP 10: Assigned Role matched", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10: Assigned Role does not matched", Status.FAIL);
			}
			
			
			try {
				By agentName = By.xpath("(//*[contains(@id,'_AGENTS_radYALGridControl_')]//*[text()='"+map.get(Excel.Agent)+"'])[1]");
				System.out.println(agentName);
				Assert.assertTrue(util.isElementVisible(agentName));
				log("STEP 11: Agent Name matched", Status.PASS);
			} catch (AssertionError e) {
				ExtentTestManager.infoWithScreenshot("Parcel Assignment Grid");
				log("STEP 11: Agent Name does not matched", Status.FAIL);
			}
				 ClickOnClose();
				
	 }		
}
