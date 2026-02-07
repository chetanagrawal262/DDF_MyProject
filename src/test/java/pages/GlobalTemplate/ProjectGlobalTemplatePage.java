package pages.GlobalTemplate;


import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import page.Common.LoginPage;

public class ProjectGlobalTemplatePage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String CUSTOM_DATES_TEMPLATE;

	public ProjectGlobalTemplatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navGlobalTemplate = By.xpath("//span[contains(text(),'Global Template')]");
	 
	//for ROW
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navPaymentTemplates = By.xpath("//span[contains(text(),'Payment Templates')]");
	By navGlobalPayTemplates = By.xpath("//span[contains(text(),'Global Pay Templates')]");
	
	By btnPlus = By.xpath("//img[contains(@id,'_ctl00_Img2')]");	
	By txtDisplayName = By.xpath("//input[contains(@id,'_CTRINFO_RadDock1_C_Display_Name') and @type='text']");
	By linkDisplayName = By.xpath("//a[contains(text(),'Display Name:')]");
	By iframeDisplay = By.xpath("//iframe[@name='LeasePayTags']");
	By DisplayName = By.xpath("//input[contains(@id,'txtValueDisplayName') and @type='text']");
	By ValidFrom = By.xpath("//input[contains(@id,'txtValueValidFrom') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'btnSaveNewValue') and @type='image']");
	By tableDisplayName = By.xpath("//tr[@id='DISPLAYNAMEVALUES_radYALGridControl_ctl00__0']");
	By btnDelete = By.xpath("//input[contains(@id,'DISPLAYNAMEVALUES_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment') and @type='image']");
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
	By btnClose = By.xpath("//a[@title='Close']");
	By drpPaymentType = By.xpath("//input[contains(@id,'_Payment_type_ID_radYALDropDownList_Input') and @type='text']");
	By drpDistribution = By.xpath("//input[contains(@id,'_DISTRIBUTION_TYPE_ID_radYALDropDownList_Input') and @type='text']");
	By drpPreparedBy = By.xpath("//input[contains(@id,'_Prepared_By_ID_radYALDropDownList_Input') and @type='text']");
	By drpDatePrepared = By.xpath("//input[contains(@id,'_Date_Prepared_dateInput') and @type='text']");
	By drpApprovedBy = By.xpath("//input[contains(@id,'_Approved_By_ID_radYALDropDownList_Input') and @type='text'] ");
	By drpApprovedDate = By.xpath("//input[contains(@id,'_APPROVED_DATE_dateInput') and @type='text']");
	By ActiveCheckBox = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock1_C_Active_Ind']");
	By txtDescription = By.xpath("//textarea[contains(@id,'_Description')]");
	By updatedMessage = By.xpath("//span[contains(@id,'_lblLastUpdatedMsg')]");
	By btnDuplicate = By.xpath("//input[contains(@id,'_Duplicate')]"); 
	By btnDuplicateRow = By.xpath("//img[contains(@alt,'Duplicate')]");
	By iframeDuplicate = By.xpath("//iframe[@name='LeaseCopy']");
	By drpProject = By.xpath("//input[@id='ddlProject_Input']");
	By btnsave = By.xpath("//input[contains(@id,'btnLinkLogs')]");
	By message = By.xpath("//span[@id='usrMessageAdd']");
	By btnReload = By.xpath("//a[@title='Reload']");
	By btnPinon =By.xpath("//a[@title='Pin on']");

	
	public void nevigateToGlobalTemplet() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navGlobalTemplate);
		util.click(navGlobalTemplate);
	}
	
	public void nevigateToGlobalTempletRow() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navPaymentTemplates);
		util.click(navPaymentTemplates);
		
		util.waitFor(500);
		if(util.isElementVisible(navGlobalPayTemplates)) {
		util.waitUntilElementDisplay(navGlobalPayTemplates);
		util.click(navGlobalPayTemplates);
		}else {
			util.waitUntilElementDisplay(navProject);
			util.click(navProject);
			util.waitUntilElementDisplay(navGlobalPayTemplates);
			util.click(navGlobalPayTemplates);
		}
	
	}
	
	public void ClickOnPlus() {
		util.waitUntilElementDisplay(btnPlus);
		util.click(btnPlus);
	}
	
	public void AddDisplayName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDisplayName, value);
	}
	
	public void ClickOnDisplayNameLink() {
		util.waitUntilElementDisplay(linkDisplayName);
		util.click(linkDisplayName);
	}
	
	public void setDisplayName(String value) {
		util.switchToIframe(iframeDisplay);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(DisplayName, value);
	}
	
	public void AddValidFrom(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(ValidFrom, value);
	}
	
	public void clickonSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
	}
	
	public void clickonDeleteButton() {
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
		
	}
	
	public void clickonOkButton() {
		 driver.switchTo().alert().accept();
		util.dummyWait(2);
	  
	}
	
	public void clickonCancelButton() {
	   util.switchToDefaultContent();
	   util.dummyWait(1);
	   util.click(btnClose);
	}
	
	public void setPaymentType(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPaymentType, value);
	}
	
By firstPaymentType = By.xpath("(//*[contains(@id,'_Payment_type_ID_radYALDropDownList')]/..//li[not(contains(text(),'Select One'))])[1]");
	
	public void setPaymentType() {
		 util.click(drpPaymentType);
		 util.click(firstPaymentType);
	}
	public void setDistribution(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpDistribution, value);
	}
	
	public void setPreparedBy(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPreparedBy, value);
	}
	
	public void setDatePrepared(String DatePrepared) {
			util.inputTextAndPressTab(drpDatePrepared, DatePrepared);
	}
	
	public void setApprovedBy(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpApprovedBy, value);
	}

	public void setApprovedDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpApprovedDate, value);
	}
	
	public void ClickonActiveCheckBox() {
		util.waitUntilElementDisplay(ActiveCheckBox);
		util.click(ActiveCheckBox);
	}
	

	public void AddDescription(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescription, value);
	}

	By SaveBtn = By.xpath("//input[contains(@id,'_btnSave') and @type='image']");
	
	public void ClickonSaveButton() {
		util.waitUntilElementDisplay(SaveBtn);
		util.click(SaveBtn);
	}
	
	public void ClickOnDuplicateButton() {
		
		util.waitUntilElementDisplay(btnDuplicate);
	    util.click(btnDuplicate);
	    util.switchToIframe(iframeDuplicate);
	}
	
	public void ClickOnDuplicateButtonRow() {
		util.waitUntilElementDisplay(btnDuplicateRow);
	    util.click(btnDuplicateRow);
	    util.switchToIframe(iframeDuplicate);

	}
	
	public void SelectProject(String value) {
		util.waitUntilElementDisplay(drpProject);
		util.selectValueFromDropdown(drpProject, value);
	}
	
	public void ClickonSave() {
		util.waitUntilElementDisplay(btnsave);
		util.click(btnsave);	
	}
	
	public void ClickonReload() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnReload);
		util.click(btnReload);	
		util.dummyWait(2);
	}
	
	public void ClickOnPinOff() {
		util.waitUntilElementDisplay(btnPinon);
		util.click(btnPinon);	
		util.scrollDownToPage();
//		util.switchToDefaultContent();
		util.click(btnClose);
		util.dummyWait(2);
	}
	

	
    public void ProjectGlobalTemplate(Map<String, String> map,String testCaseName)  {
    	if(testCaseName.contains("ALT") || testCaseName.contains("ORSTED")||testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
		try {
			nevigateToGlobalTemplet();
			log("STEP 1: User can navigate to project global template page.", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to project global template page. ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    }
    	else {
		try {
			nevigateToGlobalTempletRow();
			log("STEP 1: User can navigate to project global template page.", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to project global template page. ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    }
		try {
			ClickOnPlus();
			util.dummyWait(2);
			if (LoginPage.isApplicableVersion(LoginPage.VERSION)) {
			AddDisplayName(map.get("DisplayName2"));
			CUSTOM_DATES_TEMPLATE=map.get("DisplayName2");
			}else {
				AddDisplayName(map.get(Excel.DisplayName));
				CUSTOM_DATES_TEMPLATE=map.get(Excel.DisplayName);
			}
			log("STEP 2: user can enter value in Display Name textbox  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot enter value in Display Name textbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
    	
		
    	try {
    		setPaymentType();
			log("STEP 3: User can select value from Payment Type dd  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select value from Payment Type dd  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
    	if(util.isElementVisible(drpDistribution)) {
    	try {
    		setDistribution(map.get(Excel.Distribution));
			log("STEP 4: User can select value from Distribution dd  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot select value from Distribution dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
    	}
    	
    	if(testCaseName.contains("ROW")  || testCaseName.contains("TRA")) {
    	try {
    		setPreparedBy(map.get(Excel.PreparedBy));
			log("STEP 5: User can select value from PreparedBy dd ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select value from PreparedBy dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
    	
    	try {
    		setDatePrepared(TestUtil.getCurrentDateTime("MM/dd/yyyy"));
			log("STEP 6: User can select date from date picker.  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select date from date picker. ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
    	
    	try {
    		setApprovedBy(map.get(Excel.ApprovedBy));
			log("STEP 7: user can enter value in ApprovedBy textbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot enter value in ApprovedBy textbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
    	
    	try {
    		setApprovedDate(map.get(Excel.ApprovedDate));
			log("STEP 8:  User can select date from date picker.   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user cannot enter value in ApprovedDate textbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
    	
    	try {
    		ClickonActiveCheckBox();
			log("STEP 9: User can click on Active Check Box  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot click on Active Check Box ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

    }	
		
    	try {
    		AddDescription(map.get(Excel.Description));
			log("STEP 10: user can enter value in Description textbox  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot enter value in Description textbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
    	
    	try {
    		ClickonSaveButton();
			log("STEP 11: user can click on save button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot click on save button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
    	util.dummyWait(2);
		
    	Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
		if (util.isElementPresent(SuccessMessage)) {
			log("STEP 12:'Changes saved successfully!'  message will be displayed & record will be deleted from grid..", Status.PASS);
		} else {
			log("STEP 12:User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Faild in STEP 12 :User cannot click on Save button");
		}
		
		if (util.isElementPresent(updatedMessage)) {
			log("STEP 13:Last Updated by geosupport at 9/21/2022 2:57:01 AM message will be displayed in black color. ", Status.PASS);
		} else {
			log("STEP 13:User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Faild in STEP 13 :User cannot click on Save button");
		}
		
    	if(testCaseName.contains("ALT") || testCaseName.contains("ORSTED")||testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
        		
        		try {
        			ClickOnDisplayNameLink();
        			log("STEP 14: user can click on display name link.  ", Status.PASS);
        		} catch (Exception e) {
        			log("STEP 14: User cannot click on display name link. ", Status.FAIL);
        			throw new RuntimeException("Failed in step 14");
        		}
        		
        		try {
        			setDisplayName(map.get(Excel.DisplayedName));
        			log("STEP 15: User can enter the value in the  Displayed Nametext field ", Status.PASS);
        		} catch (Exception e) {
        			log("STEP 15: User cannot add value  to the Displayed Name field ", Status.FAIL);
        			throw new RuntimeException("Failed in step 15");
        		}
        		
        		try {
        			AddValidFrom(map.get(Excel.ValidFrom));
        			log("STEP 16: user can enter value in Valid From textbox  ", Status.PASS);
        		} catch (Exception e) {
        			log("STEP 16: User cannot enter value in Valid From textbox ", Status.FAIL);
        			throw new RuntimeException("Failed in step 16");
        		}
        		
        		try {
        			clickonSaveButton();
        			log("STEP 17: user can click on save button.", Status.PASS);
        		} catch (Exception e) {
        			log("STEP 17: User cannot click on save button. ", Status.FAIL);
        			throw new RuntimeException("Failed in step 17");
        		}
        		util.dummyWait(5);
        		if (util.isElementPresent(tableDisplayName)) {
        			System.out.println("record  displayed in grid. !!!");
        			log("STEP 18: Once you click on save button record will be displayed in grid.", Status.PASS);
        		} else {
        			log("STEP 18: Record not displayed in grid.", Status.FAIL);
        			throw new RuntimeException("Faild in STEP 18 :Record not displayed in grid. ");
        		}
        		
        		try {
        			clickonDeleteButton();
        			log("STEP 19: user can click on cross icon ", Status.PASS);
        		} catch (Exception e) {
        			log("STEP 19: user cannot click on cross icon.   ", Status.FAIL);
        			throw new RuntimeException("Failed in step 19");
        		}
        		
        		try {
        			clickonOkButton();
        			log("STEP 20: user can click on ok button ", Status.PASS);
        		} catch (Exception e) {
        			log("STEP 20: User cannot click on ok button ", Status.FAIL);
        			throw new RuntimeException("Failed in step 20");
        		}
        		util.dummyWait(2);
        		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
        		if (util.isElementPresent(SuccessMessage)) {
        			log("STEP 21:'Changes saved successfully!'  message will be displayed & record will be deleted from grid..", Status.PASS);
        		} else {
        			log("STEP 21:User cannot click on ok button", Status.FAIL);
        			throw new RuntimeException("Faild in STEP 21 :User cannot click on ok button");
        		}
        		
        	try {
        		clickonCancelButton();
        		log("STEP 22: user can click on cancel button.   ", Status.PASS);
        	} catch (Exception e) {
        		log("STEP 22: User cannot click on cancel button.  ", Status.FAIL);
        		throw new RuntimeException("Failed in step 22");
      		}
    	
    		
		try {
			ClickOnDuplicateButton();
			log("STEP 23:user can click on duplicate button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: User cannot click on duplicate button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		
    }
    	else {
    		if(util.isElementVisible(btnDuplicateRow)) {
    		try {
    			ClickOnDuplicateButtonRow();
    			log("STEP 14: user can click on duplicate button. ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 14: User cannot click on duplicate button. ", Status.FAIL);
    			throw new RuntimeException("Failed in step 14");
    		}	
    		}else {
    			log("Duplicate button not displaying");
    		}
    	}
    	
    	
    	if(util.isElementVisible(btnsave)) {
    	try {
    		ClickonSave();
			log("STEP 24: user can click on save button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 24: User cannot click on save button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}	
    	util.dummyWait(2);
    	
    	if (util.isElementPresent(message)) {
			log("STEP 25:New agreement payment template has been created. Please close window to see/edit the newly created template message will be displayed.", Status.PASS);
		} else {
			log("STEP 25:User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Faild in STEP 25 :User cannot click on Save button");
		}
    	
    	try {
    		ClickonReload();
			log("STEP 26: User can click on reload icon. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: User cannot click on reload icon. ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}	
    	
    	try {
    		ClickOnPinOff();
			log("STEP 27: User can click on pin off icon.  And Popup window will be movable", Status.PASS);
		} catch (Exception e) {
			log("STEP 27: User cannot click on pin off icon ", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		}
    	}

    }
}
