package pages.ProjectDocuments;

import java.io.File;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class ApplicationBehaviourSettingsPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public ApplicationBehaviourSettingsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	    By drpDraft_Final = By.xpath("//input[contains(@id,'_editcc_ddlDocDraftFinal_radYALDropDownList_Input') and @type='text']");
	    
	    public void SelectDraft_Final(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpDraft_Final, value);
	    }
	    	
		By navAdministration = By.xpath("//span[text()='Administration']");
		By navABS = By.xpath("//span[contains(text(),'Application Behavior Settings')]");
		By txtFilterKeyName = By.xpath("//input[@alt='Filter key_name column']");
		By btnFilterKeyName = By.xpath("//input[contains(@id,'Filter_key_name') and @type='button']");
		By optionFilter = By.xpath("//span[text()='Contains']");
	    By btnSubmitAll = By.xpath("//input[@title='Submit All']");
		
		public void NavigateToApplicationBehaviorSettings() {
	    	util.waitUntilElementDisplay(navAdministration);
	    	util.click(navAdministration);
	    	util.waitUntilElementDisplay(navABS);
	    	util.click(navABS);
	    }
		
		 public void enterKeyName(String value) {
				util.waitUntilElementDisplay(txtFilterKeyName);
				util.inputTextAndPressTab(txtFilterKeyName, value);
			}
		
		 public void selectFilter() {
			 util.waitFor(300);
		    	if(!util.isElementVisible(optionFilter)) {
				util.waitUntilElementDisplay(btnFilterKeyName);
				util.click(btnFilterKeyName);
				util.click(optionFilter);
				}
			}
		 
		
		 public void setKeyValue(String key, String value) {
		    	By keyValue = By.xpath("//*[text()='"+key+"']/..//input[contains(@name,'txtValue')]");
		    	util.dummyWait(1);
				//util.waitUntilElementDisplay(keyValue);
				util.inputTextAndPressTab(keyValue, value);
			}
		 
		  public void clickOnSubmitAll() {
				util.waitUntilElementDisplay(btnSubmitAll);
				util.click(btnSubmitAll);;
			}
		  
		  
		public void SetDocDraftFinalSetting(Map<String, String> map, String testcaseName, String value)
				throws InterruptedException {
			
			try {
				NavigateToApplicationBehaviorSettings();
				log("STEP 1: User can navigate to Application Behavior Settings ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to Application Behavior Settings ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			try {
				enterKeyName(map.get("ABS_DraftFinal"));
				log("STEP 2: User can enter key name " + map.get("ABS_DraftFinal"), Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot enter key name " + map.get("ABS_DraftFinal"), Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

			try {
				selectFilter();
				log("STEP 3: User can click on Filter Icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot click on Filter Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}

			try {
				setKeyValue(map.get("ABS_DraftFinal"), value);
				log("STEP 4: User can set " + value + " value for key name " + map.get("ABS_DraftFinal"), Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot set " + value + " value for key name " + map.get("ABS_DraftFinal"), Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}

			try {
				clickOnSubmitAll();
				log("STEP 5: User can click on Submit All button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot click on Submit All button", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				enterKeyName(map.get("ExecutionDate"));
				log("STEP 6: User can enter key name " + map.get("ExecutionDate"), Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot enter key name " + map.get("ExecutionDate"), Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}

			try {
				selectFilter();
				log("STEP 7: User can click on Filter Icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot click on Filter Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}

			try {
				setKeyValue(map.get("ExecutionDate"), value);
				log("STEP 8: User can set " + value + " value for key name " + map.get("ExecutionDate"), Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot set " + value + " value for key name " + map.get("ExecutionDate"), Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}

			try {
				clickOnSubmitAll();
				log("STEP 9: User can click on Submit All button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot click on Submit All button", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
		}
		
}
