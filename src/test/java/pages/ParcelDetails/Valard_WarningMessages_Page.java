package pages.ParcelDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class Valard_WarningMessages_Page extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public String UpdatedRecord ,WarningMsg;

	public Valard_WarningMessages_Page(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	//Navigation
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
    By btnSave = By.xpath("//input[contains(@id,'_TractType_btnInternalSave')]");
    By txtMunicipality = By.xpath("//*[text()='Municipality']/..//input[@type='text']");
    By btnClose = By.xpath("//a[@title='Close']");
    
    public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
		commonFunction.projectSelection();
		
		
	}
   public void clickOnSave() {
    	util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(2);

	}
    
    public void addValue(By by, String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(by, value);
  	}
    
    By btnAddNewRecord = By.xpath("//img[contains(@id,'YALWorkflows_radYALGridControl')]");
	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@id,'_cbParcelApprovalType_YALComboBox_Input') and @type='text']");
    public void ClickOnAddNewRecord() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
	}
    
    By navToolsMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Tools')]");
	By navToolsMyDashboard = By.xpath("//a//span[contains(text(),'My Dashboard')]");
    public void navigateToMyDashboard() {
		util.hoverOnElement(navToolsMenu);
		util.click(navToolsMyDashboard);
	}
    
    public void verifyMessages(String testcaseName) {
    	try {
    		navigateParcelInformation();
			log("STEP 1: User can navigate to the Parcel Information ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot see the Parcel Information option in Menu", Status.FAIL);
			throw new RuntimeException("User cannot see the Parcel Information option in Menu");
		}
    	
    	try {
    		UpdatedRecord=util.randomNumber();
    		addValue(txtMunicipality, UpdatedRecord);
			log("STEP 2: User can update the  Municipalty Record", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:   User cannot update the  Municipalty Record", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
    	
    	try {
			ClickOnAddNewRecord();
			log("STEP 3: User can click on Add new record button of the Parcel Form", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on Add new record button of the Parcel Form", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
    	
    	try {
    		try 
    	    { 
    		WarningMsg= driver.switchTo().alert().getText();  
    	    }  
    	    catch (NoAlertPresentException Ex) 
    	    {
    	    	log("NoAlertPresent");
    	    }  
    		String expectedMsg="Creating this form will erase unsaved information from this Document Number. Click \"OK\" to continue creating this form (which could result in unsaved edits being lost). Click \"Cancel\" to avoid creating this form.";
			Assert.assertEquals(WarningMsg, expectedMsg);
    		log("STEP 3: User can see correct Warning Message on Alert Popup", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3:   User cannot  see Warning Message on Alert Popup or message is Incorrect", Status.FAIL);
		}
    	
    	try {
    		 
    		driver.switchTo().alert().dismiss();
    		log("STEP 4: User can click on Cancle to abort the attempt to create parcel form without saving changes", Status.PASS);
		} catch (NoAlertPresentException e) {
			log("STEP 4:   User cannot  click on Cancle to abort the attempt to create parcel form", Status.FAIL);
		}
    	
    	try {
    		clickOnSave();
    		util.dummyWait(2);
			log("STEP 5: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
    	
    	try {
    		String update=util.getAttributeValue(txtMunicipality, "value");
    		Assert.assertEquals(update, UpdatedRecord);
			log("STEP 6: Updated record successfully saved", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: Updated record does not display", Status.FAIL);
		}
    	
    	try {
    		UpdatedRecord=util.randomNumber();
    		addValue(txtMunicipality, UpdatedRecord);
			log("STEP 7: User can update the  Municipalty Record again", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:   User cannot update the  Municipalty Record again", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
    	
    	try {
			ClickOnAddNewRecord();
			log("STEP 8: User can click on Add new record button of the Parcel Form", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on Add new record button of the Parcel Form", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
    	
    	try {
    		driver.switchTo().alert().accept();
    		log("STEP 9: User can accept the alert to add new parcel form", Status.PASS);
		} catch (NoAlertPresentException e) {
			log("STEP 9:   User cannot accept the alert to add new parcel form", Status.FAIL);
		}
    	
    	try {
			util.switchToIframe(FullFrm);
			Assert.assertTrue(util.isElementVisible(drpApprovalType), "User can see Approval Type DD");
			log("STEP 10: User can able to add parcel form", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10: Parcel Form popup not opened", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
    	
    	try {
			util.switchToDefaultContent();
			util.click(btnClose);
			util.dummyWait(2);
			log("STEP 11: User can close the parcel form", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot close the parcel form", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
    	
    	try {
    		UpdatedRecord=util.randomNumber();
    		addValue(txtMunicipality, UpdatedRecord);
			log("STEP 12: User can update the  Municipalty Record again", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:   User cannot update the  Municipalty Record again", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
    	
    	try {
    		navigateToMyDashboard();
			log("STEP 13: User cannot navigate to My Dashboard page without saving the changes", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User can navigate to My Dashboard page without saving the changes", Status.FAIL);
			throw new RuntimeException("13");
		}
    	
    	try {
    		try 
    	    { 
    		WarningMsg= driver.switchTo().alert().getText();  
    	    }  
    	    catch (NoAlertPresentException Ex) 
    	    {
    	    	log("NoAlertPresentException");
    	    }
    		String expectedMsg="You have unsaved information on this Document Number. Please click \"Save\" before exiting the Document Number:. Clicking \"Cancel\" in this pop-up will navigate away from the current page, making unsaved edits lost.";
			Assert.assertEquals(WarningMsg, expectedMsg);
    		log("STEP 14: User can see correct Warning Message on Alert Popup while navigating to another page without saving the record", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 14:   User cannot  see Warning Message on Alert Popup or message is Incorrect", Status.FAIL);
		}

    	try {
    		driver.switchTo().alert().accept();
    		log("STEP 15: User can accept the alert to save the changes", Status.PASS);
		} catch (NoAlertPresentException e) {
			log("STEP 15:   User cannot accept the alert to save the changes", Status.FAIL);
		}
    	
    	try {
    		clickOnSave();
    		util.dummyWait(2);
			log("STEP 16: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
    	
    	try {
    		String update=util.getAttributeValue(txtMunicipality, "value");
    		Assert.assertEquals(update, UpdatedRecord);
			log("STEP 17: Updated record successfully saved", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 17: Updated record does not display", Status.FAIL);
		}
    	
    	try {
    		UpdatedRecord=util.randomNumber();
    		addValue(txtMunicipality, UpdatedRecord);
			log("STEP 18: User can update the  Municipalty Record again", Status.PASS);
		} catch (Exception e) {
			log("STEP 18:   User cannot update the  Municipalty Record again", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
    	
    	try {
    		navigateToMyDashboard();
			log("STEP 19: User cannot navigate to My Dashboard page without saving the changes", Status.PASS);
		} catch (Exception e) {
			log("STEP 19:  User can navigate to My Dashboard page without saving the changes", Status.FAIL);
			throw new RuntimeException("19");
		}
    	
    	try {
    		driver.switchTo().alert().dismiss();
    		log("STEP 20: User can Dismiss the alert to navigate to other page without saving the changes", Status.PASS);
		} catch (NoAlertPresentException e) {
			log("STEP 20:   User cannot Dismiss the alert to navigate to other page without saving the changes", Status.FAIL);
		}
    	
    	String title= driver.getTitle();
    	String actual= "AMPS: My Dashboard";
    	
		if(title.contains(actual)) {
			log("STEP 21: User can successfully navigate to My Dashboard page after dismiss the alert", Status.PASS);
		}else {
			log("STEP 21: User cannot navigate to My Dashboard page after dismiss the alert", Status.PASS);
		}
    }
	
 
    
}
