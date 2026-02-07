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

public class AddMetTowerRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddMetTowerRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navMetTower = By.xpath("//span[contains(text(),'Met Towers')]");
	By btnAddNewRecord = By.xpath("//img[contains(@alt,'Add Met Tower')]");
	By iframeMet = By.xpath("//iframe[@name='MetDialog']");
	By txtTowerName = By.xpath("//input[contains(@id,'TOWER_NUMBER') and @type='text']");
	By txtInstallationDate = By.xpath("//input[contains(@id,'INSTALLATION_DATE_dateInput') and @type='text']");
	By txtDecommisionDate = By.xpath("//input[contains(@id,'DECOMMISIONED_DATE_dateInput') and @type='text']");
	By drpManufacturer = By.xpath("//input[contains(@id,'TOWERMANF_radYALDropDownList_Input') and @type='text']");
	By DiscardedCheckbox = By.xpath("//input[contains(@id,'IsDiscarded') and @type='checkbox']");
	By txtHeight = By.xpath("//input[contains(@id,'txtHeight') and @type='text']");
	By drpTowerType = By.xpath("//input[contains(@id,'TOWERTYPE_radYALDropDownList_Input') and @type='text']");
	By txtComment = By.xpath("//textarea[@id='Comment']");
	By btnAddNew = By.xpath("//input[@id='AddNew']");
    By SuccessMessage = By.xpath("//span[text()='Save successful']");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
	
	public void ClickOnAddNewRecord() {
		util.waitUntilElementDisplay(navMetTower);
		util.click(navMetTower);
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
	}
	
	public void AddTowerName(String value) {
		util.switchToIframe(iframeMet);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTowerName, value);
	}
	
	public void AddInstallationDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtInstallationDate, value);
	}
	
	public void AddDecommisionDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDecommisionDate, value);
	}
	
	public void SelectManufacturer(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpManufacturer, value);
	}
	
	public void ClickOnDiscardedCheckbox () {
		util.waitUntilElementDisplay(DiscardedCheckbox);
		util.click(DiscardedCheckbox);
	}
	
	public void AddHeight(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtHeight, value);
	}
	
	public void SelectTowerType(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpTowerType, value);
	}
	
	public void AddComment(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
	}
	
	public void ClickOnAddNewButton() {
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.waitUntilElementDisplay(SuccessMessage);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Save successful");
	}
	
	public void ClickOnCloseButton() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
		util.dummyWait(2);
	}
	
	 public void AddMetTowerRecord(Map<String, String> map, String testcaseName) {
		 try {
    		 ClickOnAddNewRecord();
	 			log("STEP 1: user should  be able to click add new record button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: User does not able to click Add new record button ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
    	 
	    	 
	    	 try {
	    		 AddTowerName(map.get(Excel.TowerName));
	 			log("STEP 2: Entered value should display in the Tower Name field.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: Entered value does not display in  Tower Name field.  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 try {
	    		 AddInstallationDate(map.get(Excel.InstallationDate));
	    		log("STEP 3: selected Installation date should be display as selected ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: selected Installation date does not display as selected ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 
	    	 try {
	    		 AddDecommisionDate(map.get(Excel.DecommisionDate));
	    		log("STEP 4: selected Decommision date should be display as selected", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: selected Decommision date does not display as selected ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
	    	 try {
	    		 SelectManufacturer(map.get(Excel.Manufacturer));
	    		log("STEP 5: Selected value display in the Manufacturer DD ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: selected value does not display in Manufacturer DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 
	    	 
	    	 try {
	    		 ClickOnDiscardedCheckbox();
	    		log("STEP 6: Discarded checkbox should be display checked ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6: Discarded checkbox does not display checked ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 
	    	 try {
	    		 AddHeight(map.get(Excel.Height));
	    		log("STEP 7: Entered value should display in the Height field.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: Entered value does not display in  Height field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	 
	    	 try {
	    		 SelectTowerType(map.get(Excel.TowerType));
	    		log("STEP 8: Entered value should display in the Tower Type field.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: Entered value does not display in  Tower Type field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 
	    	 try {
	    		 AddComment(map.get(Excel.Comment));
	    		log("STEP 9: Entered value should display in the Comment field.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 9: Entered value does not display in  Comment field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 9");
	 		 }
	    	 
	    	 try {
	    		 ClickOnAddNewButton();
	    		log("STEP 10: Save successful message should be display above the add new button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 10: Save successful message does not display above the add new button ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 10");
	 		 }
	    	 
	    	 try {
	    		 ClickOnCloseButton();
	    		log("STEP 11: Popup should close successfully ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 11: popup does not close ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 11");
	 		 }

		 
	 }

}
