package pages.CustomControl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;

import extentReports.ExtentManager;
import extentReports.ExtentTestManager;

public class CustomControl_WF extends BasePage{

	
	TestUtil util;
	CommonFunction commonFunction;
	SoftAssert assertion = new SoftAssert();

	public CustomControl_WF(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By IconManageFiled = By.xpath("(//span[contains(@id,'ManageAddFieldsID')])[1]");
    By btnAddNewRecord = By.xpath("//img[contains(@id,'YALWorkflows_radYALGridControl')]");
    By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@id,'idManageApproval_cbParcelApprovalType_YALComboBox_Input') and @type='text']");
    By FieldValidation = By.xpath("//span[contains(text(),'TEXT')]");

    
    public void TurnOnDesignCode() {
    	util.waitUntilElementDisplay(btnDesignMode);
    	util.click(btnDesignMode);
    	util.dummyWait(2);
    }
    
    public void ClickOnAddNewRecord() {
    	util.waitUntilElementDisplay(btnAddNewRecord);
    	util.click(btnAddNewRecord);
    	util.dummyWait(1);
    }
    
    public void SelectApprovalType(String value) {
		util.switchToIframe(FullFrm);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpApprovalType, value);
	}
     

    By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
    public void NavigateToParcelInformation() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navParcelInformation);
    	util.click(navParcelInformation);
    }
    
    
    public void VerifyCustomFieldsOnWF(Map<String, String> map, String testcaseName) throws InterruptedException {
    	try {
    		NavigateToParcelInformation();
    		commonFunction.projectSelection();
			log("STEP 1:  user can navigate to parcel information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  user cannot navigate to parcel information page ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    	try {
    		TurnOnDesignCode();
			log("STEP 2: User can Turn on the Design mode", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot Turn on the Design mode", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	    
    	try {
			ClickOnAddNewRecord();
			log("STEP 3: user can able to click on the add new record (+) button of the Parcel Forms", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user can not able to click on the add new record (+) of the Parcel Forms ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
	    
    	util.dummyWait(3);	   
    	
    	try {
    		SelectApprovalType(map.get(Excel.ApprovalType));
			log("STEP 4: user can select Approval Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: user can not select the Approval Type", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
    	
    	try {
    		util.dummyWait(1);
			By customIcon = By.xpath("//span[@title='Manage custom field(s)' and contains(@onclick,'"+map.get("Custom Control Type")+"')]");
			util.click(customIcon);
			log("STEP 5:  user can able to click on the custom control icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  user cannot click on the custom control icon  ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
	    
    	Set<String> windowId = driver.getWindowHandles(); // get window id of current window
    	Iterator<String> itererator = windowId.iterator();
    	String mainWinID = itererator.next();
    	String newAdwinID = itererator.next();
    	driver.switchTo().window(newAdwinID);
    	util.dummyWait(1);  
		
		try {
			String url=driver.getCurrentUrl();
			String type=url.substring(url.lastIndexOf("=")+1);
			Assert.assertEquals(type, map.get("Custom Control Type").trim());
			ExtentTestManager.info("Custom Control Type : "+type);
			log("STEP 6: Page Type Sucessfully verified ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: Page Type is missing or not matching ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		util.dummyWait(1);
		driver.close();
		driver.switchTo().window(mainWinID);
		util.dummyWait(1);	
		util.switchToIframe(FullFrm);
		try {
			int count=0;
			for(int i=1; i<ExcelUtils.totalCols-2; i++) {	
				for(int j=i+1; j<ExcelUtils.totalCols-2; j++) {
				
					if(map.get("Field"+i)==map.get("Field"+j)) {
						count=2;
						break;
					}else {
						count=1;
					}
				}
				
				if(count==1) {
					if(!map.get("Field"+i).contains("NA")) {
						ExtentTestManager.info("Verifying Custom Field "+i+" : "+map.get("Field"+i));
					By customFields = By.xpath("(//*[contains(text(),'"+map.get("Field"+i)+":')]/..)[1]");
					assertion.assertTrue(util.isElementVisible(customFields),  "Custom Field "+map.get("Field"+i)+" not visible ");
				}}else {
					if(!map.get("Field"+i).contains("NA")) {
						ExtentTestManager.info("Verifying Custom Field "+i+" : "+map.get("Field"+i));
					By customFields = By.xpath("(//*[contains(text(),'"+map.get("Field"+i)+":')]/..)[2]");
					assertion.assertTrue(util.isElementVisible(customFields), "Custom Field "+map.get("Field"+i)+" not visible ");
				}
				}
				util.waitFor(500);
		}
			ExtentTestManager.infoWithScreenshot("Custom Fields visible on the WF");
			assertion.assertAll();
			log("STEP 7: All Custom fields sucessfully verified on the WF ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: Some Custom fields are missing or incorrect ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
    }
    
    
    
}
