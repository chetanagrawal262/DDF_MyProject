package pages.Relocation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewRelocationInformationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddNewRelocationInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnAddNew = By.xpath("//input[contains(@id,'_NewReloInfo')]");
	By iframeRelocation = By.xpath("//iframe[@name='RelocationWindow']");
	By drpRelocationType = By.xpath("//input[contains(@id,'RELOCATION_TYPE_radYALDropDownList_Input') and @type='text']");
	By drpRelocationEntity = By.xpath("//input[contains(@id,'RELOENTITY_radYALDropDownList_Input') and @type='text']");
    By btnSave = By.xpath("//input[@id='btnSave']");
    
    public void ClickOnAddNewButton() {
    	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    }
    
    public void SelectRelocationType(String value) {
    	util.switchToIframe(iframeRelocation);
    	util.dummyWait(5);
    	util.waitUntilElementDisplay(drpRelocationType);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpRelocationType, value);
    }
    
    public void SelectRelocationEntity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpRelocationEntity, value);
    }
    
    public void ClickOnSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    	util.switchToDefaultContent();
    	driver.navigate().refresh();
    }
    
    public void AddNewRelocationInformation(Map<String, String> map, String testcaseName) {
    	

		 try {
			 ClickOnAddNewButton();
			log("STEP 1: popup window should display with all fields", Status.PASS);
		 } catch (Exception e) {
			log("STEP 1: The pop window does not display ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		 }
   	 util.dummyWait(10);
   	 try {
   		SelectRelocationType(map.get(Excel.RelocationType));
			log("STEP 2: Added value displays in Relocation Type field ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 2: User  cannot select  value  from Relocation Type DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		 }
   	 
   	 try {
   		SelectRelocationEntity(map.get(Excel.RelocationEntity));
   		    log("STEP 3: Added value displays in Relocation Entity field ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 3: User  cannot select  value  from Relocation Entity DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		 }
   	 
	 try {
		   ClickOnSaveButton();
				log("STEP 4: User can click on continue button", Status.PASS);
		 } catch (Exception e) {
				log("STEP 4: User cannot click on continue button ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
		 }
   	
    }

}
