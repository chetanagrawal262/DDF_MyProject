package pages.agreementManager;

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
import page.Common.LoginPage;

public class CF_PaymentTags_PaymentTemplatePage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String TEMPLATE_NAME;

	public CF_PaymentTags_PaymentTemplatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectPayTemplate = By.xpath("//span[contains(text(),'Project Pay Templates')] | //span[contains(text(),'Payment Terms Manager')]");
	 
	//for ROW
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navPaymentTemplates = By.xpath("//span[contains(text(),'Payment Templates')]");
	By navProjectPayTemplates = By.xpath("//span[contains(text(),'Project Pay Templates')]"); 
	By NAButton = By.xpath("//input[contains(@id,'_optAPNA') and @type='radio']");
	By txtTextbox = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_Additional_Payment_Frequency']");
	By drpDropdown = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_Additional_Payment_Frequency_ID_radYALDropDownList_Input']");
	By drpPeriod = By.xpath("//input[contains(@id,'_Add_Period_ID_radYALDropDownList_Input') and @type='text']");
	By txtDisplayName = By.xpath("//input[contains(@id,'_CTRINFO_RadDock1_C_Display_Name') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'btnSaveNewValue') and @type='image']");
	By drpPaymentType = By.xpath("//input[contains(@id,'_Payment_type_ID_radYALDropDownList_Input') and @type='text']");
	By drpDistribution = By.xpath("//input[contains(@id,'_DISTRIBUTION_TYPE_ID_radYALDropDownList_Input') and @type='text']");
	By txtDescription = By.xpath("//textarea[contains(@id,'_Description')]");
	By updatedMessage = By.xpath("//span[contains(@id,'_lblLastUpdatedMsg')]");
	By btnDuplicate = By.xpath("//input[contains(@id,'_Duplicate')]"); 
	By btnDuplicateRow = By.xpath("//img[contains(@alt,'Duplicate')]");
	By iframeDuplicate = By.xpath("//iframe[@name='LeaseCopy']");
	By drpProject = By.xpath("//input[@id='ddlProject_Input']");
	By btnsave = By.xpath("//input[contains(@id,'btnLinkLogs')]");
	By drpTypeofCalculation = By.xpath("//input[contains(@id,'_CALCULATION_TYPE_ID_radYALDropDownList_Input')and @type='text']");
	By txtOption1DisplayName = By.xpath("//input[contains(@id,'_Option1_Display_name')and @type='text']");
	By txtOption1Formula = By.xpath("//textarea[@id='ctl00_ConPHRightTop_CTRINFO_RadDock3_C_Option1_Formula'] | //*[@id='ctl00_ConPHRightTop_CTRINFO_RadDock3_C_Option1_Formula_contentIframe']");
	By btnClose = By.xpath("//a[@title='Close']");
	
	public void nevigateToProjectPayTemplate() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navProjectPayTemplate);
		util.click(navProjectPayTemplate);
	}
	
	By btnPlus = By.xpath("//img[contains(@id,'_ctl00_Img2')]");	
	public void ClickOnPlus() {
		util.dummyWait(2);
		util.waitUntilElementDisplay(btnPlus);
		util.click(btnPlus);
	}
	public void AddDisplayName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDisplayName, value);
	}
	
	public void clickonSaveButtonOnCopy() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
	}
	
	public void setPaymentType(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPaymentType, value);
	}
	
	
	By firstPaymentType = By.xpath("(//*[contains(@id,'_Payment_type_ID_radYALDropDownList')]/..//li)[1]");
	
	public void setPaymentType() {
		 util.click(drpPaymentType);
		 util.click(firstPaymentType);
	}
	
	public void setDistribution(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpDistribution, value);
	}
	
	public void AddDescription(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescription, value);
	}

	By SaveBtn = By.xpath("//input[contains(@id,'CTRINFO_RadDock1_C_btnSave') and @type='image']");
	By SubmitBtn = By.xpath("//input[contains(@id,'btnSubmitPeerReview') and @type='image']");
	public void ClickonSaveButton() {
		util.waitUntilElementDisplay(SaveBtn);
		util.click(SaveBtn);
	}
	
	
	public void ClickOnDuplicateButton() {
		util.waitUntilElementDisplay(btnDuplicate);
	    util.click(btnDuplicate);
	    util.switchToIframe(iframeDuplicate);
	}
	
	By fpddRadioButton = By.xpath("//input[contains(@id,'_optFPDD')and @type='radio']");
	public void SelectFirstPaymentDateDDButton() {
		util.waitUntilElementDisplay(fpddRadioButton);
		util.click(fpddRadioButton);
		util.dummyWait(1);
	}
	
	By dropdown = By.xpath("//input[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_Input') and @type='text']");
  	public void SelectDropdown(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(dropdown, value);
  	}
  	
  	public void SelectProject(String value) {
		util.waitUntilElementDisplay(drpProject);
		util.selectValueFromDropdown(drpProject, value);
	}
  	
  	public void ClickonSave() {
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnsave);
		util.click(btnsave);	
		util.dummyWait(1);
	}
	
  	public void SelectNAButton() {
  		util.waitUntilElementDisplay(NAButton);
  		util.click(NAButton);
  	}
  	
  	public void AddTextBox(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtTextbox, value);
  	}
  	
  	public void SelectDropDown(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpDropdown, value);
  	}
  	
  	By paymentDropdown = By.xpath("//input[contains(@id,'_Last_Payment_Type_ID_radYALDropDownList_Input')and @type='text']");
  	By lpddRadioButton = By.xpath("//input[contains(@id,'_optLPDD')and @type='radio']");
	public void SelectLastPaymentDateDDButton() {
		util.waitUntilElementDisplay(lpddRadioButton);
		util.click(lpddRadioButton);
		util.dummyWait(1);
	}
  	
  public void SelectpaymentDropdown(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(paymentDropdown, value);
	}
	
  public void selectTypeofCalculation(String value) {
		util.waitUntilElementDisplay(drpTypeofCalculation);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpTypeofCalculation, value);
	}
	
	public void AddOption1DisplayName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOption1DisplayName, value);
	}
	
	public void AddOption1Formula(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOption1Formula, value);
	}
	
	public void CloseDuplicatePopUp() {	
		util.scrollDownToPage();
		util.switchToDefaultContent();
		util.click(btnClose);
		util.dummyWait(1);
	}
	
	public void ApproveTemplate() {
		util.waitUntilElementDisplay(BtnSubmitForReview);
		util.click(BtnSubmitForReview);
		util.waitUntilElementDisplay(BtnApprove);
		util.click(BtnApprove);
	}

	By BtnSubmitForReview = By.xpath("//input[contains(@id, 'btnSubmitPeerReview')]");
	By BtnApprove = By.xpath("//input[contains(@id,'btnApprove')]");
	
	By btnTagLookUp = By.xpath("(//img[@alt='Tag Help'])[1]");
	By iframe = By.xpath("//iframe[@name='LeasePayTags']");
	public void ClickonTagLookUp() {
		util.waitUntilElementDisplay(btnTagLookUp);
		util.click(btnTagLookUp);
		util.switchToIframe(iframe);
	}
	
	By navGlobalTemplate = By.xpath("//span[contains(text(),'Global Template')]");
	public void navigateToGlobalTemplet() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navGlobalTemplate);
		util.click(navGlobalTemplate);
	}
	
	By AdditionalPaymentRadioButton = By.xpath("//input[contains(@id,'_optAdditionalPaymentList') and @type='radio']");
	By drpAdditionalPayFrequencyType = By.xpath("//input[contains(@id,'_ddlAdditionalPayFreqTypeID_radYALDropDownList_Input') and @type='text']");
	 public void SelectAdditionalPaymentType(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAdditionalPayFrequencyType, value);
		}
	 
	 public void PaymentTerms(Map<String, String> map,String testCaseName)  {
	    	try {
				nevigateToProjectPayTemplate();
				commonFunction.projectSelection();
				log("STEP 1: User can navigate to project pay template page.", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to project pay template page. ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
	    	try {
				ClickOnPlus();
				util.dummyWait(1);
				AddDisplayName(map.get("Template"));
				TEMPLATE_NAME=map.get("Template");
				log("STEP 2: user can enter value in Display Name textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot enter value in Display Name textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
	    	try {
	    		if(environment.contains("ORSTED")) {
	    			setPaymentType(map.get(Excel.PaymentType));
	    		}else {
	    		setPaymentType();
	    		}
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
	    	
	    	try {
	    		AddDescription(map.get(Excel.Description));
				log("STEP 5: user can enter value in Description textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot enter value in Description textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
	    	
	    	try {
	    		ClickonSaveButton();
				log("STEP 6: user can click on save button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
	   
	    	try {
	    		SelectFirstPaymentDateDDButton();
	    		SelectDropdown(map.get(Excel.FirstPaymentDateDropdown));
    			log("STEP 7: User can select value from First Payment Date Dropdown dd ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 7: User cannot select value from First Payment Date Dropdown dd ", Status.FAIL);
    			throw new RuntimeException("Failed in step 7");
    		}
	    	
	    	
 	 		if (LoginPage.isApplicableVersion(LoginPage.VERSION)) {
 	 			util.click(AdditionalPaymentRadioButton);
 	 			SelectAdditionalPaymentType("N/A");
			 }
 	 		
	    	try {
	    		SelectLastPaymentDateDDButton();
	    		SelectpaymentDropdown(map.get(Excel.LastPaymentDateDropdown));
				log("STEP 8: User can select value from Last Payment Date Dropdown ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot select value from Last Payment Date Dropdown ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
	    	
	    	try {
	    		selectTypeofCalculation(map.get(Excel.TypeofCalculation));
				log("STEP 9:  User can select value from Type of Calculation dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot select value from Type of Calculation dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
	    	
	    	try {
	    		AddOption1DisplayName(map.get(Excel.Option1DisplayName));
				log("STEP 10: user can enter value in Option1 Display Name textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot enter value in Option1 Display Name textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
	    	try {
	    		String Tag1 ="{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}";
	    		String Tag2 ="{CF_LEASETERMINFORMATION_"+CF_PaymentTagsPage.TAG_NAME2+"}";
	    		String Formula = Tag1 +"*"+Tag2;
	    		AddOption1Formula(Formula);
	    		ExtentTestManager.infoWithScreenshot("Template");
				log("STEP 11: user can enter value in Option1 Formula textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User cannot enter value in Option1 Formula textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
	    	
	    	try {
	    		ClickonSaveButton();
				log("STEP 12: user can click on save button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User cannot click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
	    	
	    	if(util.isElementVisible(BtnSubmitForReview)) {
	    		try {
		    		ApproveTemplate();
					log("STEP 13:  user can able to approve template ", Status.PASS);
				} catch (Exception e) {
					log("STEP 13: user cannot approve the tempalte ", Status.FAIL);
					throw new RuntimeException("Failed in step 13");
				}	
	    	}
	    	
	    	try {
	    		ClickonTagLookUp();
				log("STEP 14: user can click on tag lookup  button.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: user cannot  click on tag lookup  button.  ", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
	    	
	    	try {
	    		By leaseDataTagName = By.xpath("//td[contains(text(),'{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}')]");
	    		Assert.assertTrue(util.isElementVisible(leaseDataTagName));
				log("STEP 15: user can see "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+" tag name on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 15: user cannot see "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  Tag Lookup", Status.FAIL);
			}
	    	
	    	try {
	    		By leaseDataCategory = By.xpath("//td[contains(text(),'{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}')]/..//td[text()='Agreement']");
	    		Assert.assertTrue(util.isElementVisible(leaseDataCategory));
				log("STEP 16: user can see Category 'Agreement' for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  tag on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 16: user cannot see Category 'Agreement' for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  tag on the Tag Lookupp", Status.FAIL);
			}
	    	
	    	try {
	    		By leaseDataDescription = By.xpath("//td[contains(text(),'{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}')]/..//td[contains(text(),'Value from {"+CF_PaymentTagsPage.TAG_NAME1+"} field on Agreement')]");
	    		Assert.assertTrue(util.isElementVisible(leaseDataDescription));
				log("STEP 17: user can see Correct Description for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  tag on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 17: user cannot see Correct Description for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  tag on the Tag Lookupp", Status.FAIL);
			}
	    	
	    	try {
	    		By leaseInformationTagName = By.xpath("//td[contains(text(),'{CF_LEASETERMINFORMATION_"+CF_PaymentTagsPage.TAG_NAME2+"}')]");
	    		Assert.assertTrue(util.isElementVisible(leaseInformationTagName));
				log("STEP 18: user can see "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+"  tag name on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 18: user cannot see "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag name on the Tag Lookup", Status.FAIL);
			}
	    	
	    	try {
	    		By leaseInformationCategory = By.xpath("//td[contains(text(),'{CF_LEASETERMINFORMATION_"+CF_PaymentTagsPage.TAG_NAME2+"}')]/..//td[text()='Agreement Term']");
	    		Assert.assertTrue(util.isElementVisible(leaseInformationCategory));
				log("STEP 19: user can see Category 'Agreement Term' for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 19: user cannot see Category 'Agreement Term' for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag on the Tag Lookupp", Status.FAIL);
			}
	    	
	    	try {
	    		By leaseInformationDescription = By.xpath("//td[contains(text(),'{CF_LEASETERMINFORMATION_"+CF_PaymentTagsPage.TAG_NAME2+"}')]/..//td[contains(text(),'Value from {"+CF_PaymentTagsPage.TAG_NAME2+"} field on Agreement')]");
	    		Assert.assertTrue(util.isElementVisible(leaseInformationDescription));
				log("STEP 20: user can see Correct Description for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 20: user cannot see Correct Description for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag on the Tag Lookupp", Status.FAIL);
			}
	    	ExtentTestManager.infoWithScreenshot("Project Pay Template");
	    	util.switchToDefaultContent();
	    	util.click(btnClose);
	    	
	    	try {
	    		navigateToGlobalTemplet();
	    		ClickonTagLookUp();
				log("STEP 21: user can navigate to Global Template Page", Status.PASS);
			} catch (Exception e) {
				log("STEP 21: user cannot  navigate to Global Template Page", Status.FAIL);
				throw new RuntimeException("Failed in step 21");
			}
	    	
	    	try {
	    		By leaseDataTagName = By.xpath("//td[contains(text(),'{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}')]");
	    		Assert.assertTrue(util.isElementVisible(leaseDataTagName));
				log("STEP 22: user can see "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  tag name on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 22: user cannot see "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  tag name on the Tag Lookup", Status.FAIL);
			}
	    	
	    	try {
	    		By leaseDataCategory = By.xpath("//td[contains(text(),'{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}')]/..//td[text()='Agreement']");
	    		Assert.assertTrue(util.isElementVisible(leaseDataCategory));
				log("STEP 23: user can see Category 'Agreement' for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  tag on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 23: user cannot see Category 'Agreement' for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  tag on the Tag Lookupp", Status.FAIL);
			}
	    	
	    	try {
	    		By leaseDataDescription = By.xpath("//td[contains(text(),'{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}')]/..//td[contains(text(),'Value from {"+CF_PaymentTagsPage.TAG_NAME1+"} field on Agreement')]");
	    		Assert.assertTrue(util.isElementVisible(leaseDataDescription));
				log("STEP 24: user can see Correct Description for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  tag on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 24: user cannot see Correct Description for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME1+"}"+"  tag on the Tag Lookupp", Status.FAIL);
			}
	    	
	    	try {
	    		By leaseInformationTagName = By.xpath("//td[contains(text(),'{CF_LEASETERMINFORMATION_"+CF_PaymentTagsPage.TAG_NAME2+"}')]");
	    		Assert.assertTrue(util.isElementVisible(leaseInformationTagName));
				log("STEP 25: user can see "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag name on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 25: user cannot see "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag name on the Tag Lookup", Status.FAIL);
			}
	    	
	    	try {
	    		By leaseInformationCategory = By.xpath("//td[contains(text(),'{CF_LEASETERMINFORMATION_"+CF_PaymentTagsPage.TAG_NAME2+"}')]/..//td[text()='Agreement Term']");
	    		Assert.assertTrue(util.isElementVisible(leaseInformationCategory));
				log("STEP 26: user can see Category 'Agreement Term' for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 26: user cannot see Category 'Agreement Term' for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag on the Tag Lookupp", Status.FAIL);
			}
	    	
	    	try {
	    		By leaseInformationDescription = By.xpath("//td[contains(text(),'{CF_LEASETERMINFORMATION_"+CF_PaymentTagsPage.TAG_NAME2+"}')]/..//td[contains(text(),'Value from {"+CF_PaymentTagsPage.TAG_NAME2+"} field on Agreement')]");
	    		Assert.assertTrue(util.isElementVisible(leaseInformationDescription));
				log("STEP 27: user can see Correct Description for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag on the Tag Lookup ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 27: user cannot see Correct Description for "+"{CF_LEASEDATA_"+CF_PaymentTagsPage.TAG_NAME2+"}"+" tag on the Tag Lookupp", Status.FAIL);
			}
	    	ExtentTestManager.infoWithScreenshot("Global Template");
	    	util.switchToDefaultContent();
	    	util.click(btnClose);
	    }
	
}
