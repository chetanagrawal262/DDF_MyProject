package pages.EncroachmentRequests;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class KeyDatePage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public KeyDatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By panelKeyDates = By.xpath("//span[contains(text(),'KeyDates')]");
	By btnEdit = By.xpath("(//input[contains(@id,'OCTKEYDATES_radYALGridControl_ctl00_ctl04_EditButton') and @type='image'])[1]");
    By txtExpectedDate = By.xpath("//input[contains(@id,'_Expected_Date_dateInput') and @type='text']"); 
    By txtActualDate = By.xpath("//input[contains(@id,'_Actual_Date_dateInput') and @type='text']");
    By txtComments = By.xpath("//textarea[contains(@id,'_OCTKEYDATES_radYALGridControl_ctl00_ctl05_EditFormControl_COMMENT')]");
    By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    
    
    public void ExpandKeyDates() {
    	util.waitUntilElementDisplay(panelKeyDates);
		util.click(panelKeyDates);
	}
    
    public void clickOnEdit() {
    	util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.waitUntilLoaderDisappear();
    }
    
    public void AddExpectedDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExpectedDate, value);
	}
    
    public void AddActualDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtActualDate, value);
	 }
    
    public void AddComments(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComments, value);
    }
    
    public void Update() {
    	util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.waitUntilLoaderDisappear();
    }
    
	public void UpdateKeyDate(Map<String, String> map, String testcaseName) {

		try {
			ExpandKeyDates();
			log("STEP 1: User can expand Key dates panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot expand Key dates panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			clickOnEdit();
			log("STEP 2: User can click on Edit Link ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot click on Edit Link ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			AddExpectedDate(map.get(Excel.ExpectedDate));
			log("STEP 2: User can enter a value in Expected Date field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot add a value in Expected Date field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			AddActualDate(map.get(Excel.ActualDate));
			log("STEP 3:User can enter a value in Actual Date field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:   User cannot add a value in Actual Date field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			AddComments(map.get(Excel.Comments));
			log("STEP 4:User can enter a value in Comments field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:   User cannot add a value in Comments field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			Update();
			log("STEP 5: The updated  values displays in the grid    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  Updated values does  not displayed in the grid.    ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
			log("STEP 6: User can see success message ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6:  User cannot see success message  ", Status.FAIL);
		}
		
		try {
			By expectedDate = By.xpath("//tr[contains(@id,'_OCTKEYDATES_radYALGridControl')]//td[text()='Expected Date:']/.//strong[text()='"+map.get(Excel.ExpectedDate)+"']");
			Assert.assertTrue(util.isElementVisible(expectedDate));
			log("STEP 7: User can see added Expected Date in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7:  User cannot see added Expected Date in the grid view  ", Status.FAIL);
		}
		
		try {
			By actualDate = By.xpath("//tr[contains(@id,'_OCTKEYDATES_radYALGridControl')]//td[text()='Actual Date:']/.//strong[text()='"+map.get(Excel.ActualDate)+"']");
			Assert.assertTrue(util.isElementVisible(actualDate));
			log("STEP 8: User can see added Actual Date in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8:  User cannot see added Actual Date in the grid view  ", Status.FAIL);
		}
		
		try {
			By comment = By.xpath("//tr[contains(@id,'_OCTKEYDATES_radYALGridControl')]//td[text()='"+map.get(Excel.Comments)+"']");
			Assert.assertTrue(util.isElementVisible(comment));
			log("STEP 8: User can see added Comments in the grid view ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8:  User cannot see added Comments in the grid view  ", Status.FAIL);
		}

	}
    
   
    
}
