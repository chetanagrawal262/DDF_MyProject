package pages.PermanentInfrastructure;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditStructureRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditStructureRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	} 
	
   By navStructure = By.xpath("//span[contains(text(),'Structures')]");
   By btnEdit = By.xpath("//input[contains(@id,'customFields2') and @title='Edit']");
   By drpISAResidence= By.xpath("//span[text()='ISA Residence:']/..//input[@type='text']");
   By btnUpdate = By.xpath("//input[contains(@id,'_btnUpdate') and @type='submit']");
   By spinner = By.xpath("(//div[contains(@id,'ProjectSummary_RadAjaxLoadingPanel') and @class='RadAjax RadAjax_Sunset'])[2]");		
   By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
   
   public void ClickOnEditButton() {
	   util.waitUntilElementDisplay(btnEdit);
	   util.click(btnEdit);
	   util.dummyWait(2);
	   util.waitUntilElementDisappear(spinner);
   }
   
   public void UpdateISAResidence(String value) {
	   util.waitUntilElementDisplay(drpISAResidence);
	   if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpISAResidence, value);
   }
   
   public void ClickOnUpdateButton() {
	   util.waitUntilElementDisplay(btnUpdate);
	   util.click(btnUpdate);
	   util.waitUntilElementDisappear(spinner);
   }
   
	public void EditStructureRecord(Map<String, String> map, String testcaseName) {

		try {
			ClickOnEditButton();
			log("STEP 1: user should  be able to click edit record button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User does not able to click edit record button ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			UpdateISAResidence(map.get(Excel.ISAResidence));
			log("STEP 2: User can update ISA Residence ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot update ISA Residence ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			ClickOnUpdateButton();
			log("STEP 3: User can click on Update Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on Update Button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			Assert.assertTrue(util.isElementVisible(SuccessMessage));
			log("STEP 4: User can see success Message", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4: User cannot see success Message ", Status.FAIL);
		}

		try {
			By isaValue = By.xpath("//table[contains(@id,'_radYALGridControl')]/..//a[text()='ISAResidence']/../../../..//td[text()='"
							+ map.get(Excel.ISAResidence) + "']");
			Assert.assertTrue(util.isElementVisible(isaValue));
			log("STEP 5: User can see ISA Residence value in grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot see ISA Residence value in grid view", Status.FAIL);
		}

	} 	 
	
}
