package pages.Administration_IndexManager;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class IndexManagerPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public IndexManagerPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navAdministration = By.xpath("//span[text()='Administration']");
	By navIndexManager = By.xpath("//span[contains(text(),'Index Manager')]");
	By navPaymentTemplate = By.xpath("//span[contains(text(),'Payment Templates')]");
	By drpIndexName = By.xpath("//input[contains(@id,'ID_radYALDropDownList_Input')]");
    By txtEffectiveDate = By.xpath("(//input[contains(@id,'Effective_Date_dateInput')])[1]");
    By txtValue = By.xpath("//input[@id='ctl00_ConPHRightTop_Index_Value']");
    By btnSave = By.xpath("//input[@id='ctl00_ConPHRightTop_btnSaveNewValue']");

    public void NavigateToIndexManagerALT() {
    	util.waitUntilElementDisplay(navAdministration);
    	util.click(navAdministration);
    	util.waitUntilElementDisplay(navIndexManager);
    	util.click(navIndexManager);
    }
    
    public void NavigateToIndexManager() {
    	util.waitUntilElementDisplay(navAdministration);
    	util.click(navAdministration);
    	util.waitUntilElementDisplay(navPaymentTemplate);
    	util.click(navPaymentTemplate);
    	util.waitUntilElementDisplay(navIndexManager);
    	util.click(navIndexManager);
    }
    
    
    public void SelectIndexName(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpIndexName, value);
    }
    
    By drpIndexValue = By.xpath("//*[@id=\"ctl00_ConPHRightTop_INDEX_ID_radYALDropDownList_DropDown\"]/..//li[1]");
    public void SelectIndexName() {
    	util.click(drpIndexName);
    	util.click(drpIndexValue);
    }
    
    public void SelectEffectiveDate(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtEffectiveDate, value);
    }
    
    public void SelectValue(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtValue, value);
    }
	
    public void ClickOnSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    }
    By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
    public void IndexManager(Map<String, String> map, String testcaseName) {
   	 if (testcaseName.contains("DOT")) {
			log(" Index Manager not applicable for DOT ", Status.SKIP);
		}
		else {

    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")){
    		try {
    			NavigateToIndexManagerALT();
    			log("STEP 1: User can navigate sucessfully to Index Manager ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 1: User cannot navigate to Index Manager ", Status.FAIL);
    			throw new RuntimeException("Failed in step 1");
    		}
    	}else
    	{
    		try {
    			NavigateToIndexManager();
    			log("STEP 1: User can navigate sucessfully to Index Manager ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 1: User cannot navigate to Index Manager ", Status.FAIL);
    			throw new RuntimeException("Failed in step 1");
    		}
    	}
		
    	 if(environment.contains("CONNECTGEN")) {
			try {
				SelectIndexName();
				log("STEP 2: User can select a value in the Index Name field   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot select a value in the Index Name field ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		}else {
			try {
				SelectIndexName(map.get(Excel.IndexName));
				log("STEP 2: User can select a value in the Index Name field   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot select a value in the Index Name field ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		}
		
    	
		try {
			SelectEffectiveDate(map.get(Excel.EffectiveDate));
			log("STEP 3:  User can select the  Effective Date    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:   User cannot select the  Effective Date   ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			SelectValue(map.get(Excel.Value));
			log("STEP 4:  User can enter value in the Value field  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:   User cannot enter value in the Value field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			ClickOnSaveButton();
			log("STEP 5: User is able to click on save button.    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User is unable to click on save button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 6 :Changes saved sucessfully ! message will be display in green color.   ", Status.PASS);
			} else {
			   log("STEP 6: User is unable to click on save button."  , Status.FAIL);
		      throw new RuntimeException("Faild in STEP 6 ");
	   	} 
		
      }
    }
}
