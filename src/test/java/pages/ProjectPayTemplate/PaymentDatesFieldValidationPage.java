package pages.ProjectPayTemplate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;
import page.Common.LoginPage;

public class PaymentDatesFieldValidationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public PaymentDatesFieldValidationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);	
	}
	
	By txtFirstPaymentDate = By.xpath("//input[contains(@id,'_First_Payment_Date_dateInput') and @type='text']");
	By drpFirstPaymentDate = By.xpath("//input[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_Input') and @type='text']");
	By valueEffectiveDate = By.xpath("//div[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_DropDown')]//li[text()='Effective Date']");
	By valueExpirationDate = By.xpath("//div[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_DropDown')]//li[text()='Expiration Date']");
	By valueAltFirstPaymentDate = By.xpath("//div[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_DropDown')]//li[text()='Alt. First Payment Date']");
	By valueEffectiveDateAndOffset = By.xpath("//div[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_DropDown')]//li[text()='Effective Date + Offset # of Days']");
	By valueConstructionCommencement = By.xpath("//div[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_DropDown')]//li[text()='Construction Commencement']");
	By arrowFirstPaymentDateDrp = By.xpath("//a[contains(@id,'First_Payment_Type_ID_radYALDropDownList_Arrow')]");
    By txtMonths = By.xpath("//input[contains(@id,'_First_Payment_Months_Add') and @type='text']");
    By drpPeriod = By.xpath("//input[contains(@id,'_Add_Period_ID_radYALDropDownList_Input') and @type='text']");
    By RadioButton = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_optAPMonths']");
    By NARadioButtonAdditionalPayment = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_optAPNA']");	
    By RevenuePeriodButton = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_optRevenuePeriods']");
    By txtDays = By.xpath("//input[contains(@id,'_RadTextNoOfDays') and @type='text']");
    By EveryOptionButton = By.xpath("//input[contains(@id,'_optAPMonths') and @type='radio']");
    By txtTextbox = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_Additional_Payment_Frequency']");
    By drpEvery = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_Additional_Payment_Frequency_ID_radYALDropDownList_Input']");
    By LastPaymentDateButton = By.xpath("//input[contains(@id,'_optLPDP')and @type='radio']");
    By NAButtonLastPaymentDate = By.xpath("//input[contains(@id,'_optLPNA')and @type='radio']");	
    By txtDate = By.xpath("//input[contains(@id,'_Last_payment_Date_dateInput')and @type='text']");
    By drpLastPaymentDate = By.xpath("//input[contains(@id,'_Last_Payment_Type_ID_radYALDropDownList_Input')and @type='text']");
    
    By drpAdditionalPayFrequencyType = By.xpath("//input[contains(@id,'_ddlAdditionalPayFreqTypeID_radYALDropDownList_Input') and @type='text']");
	By valueQuarterStart = By.xpath("//div[contains(@id,'ddlAdditionalPayFreqTypeID_radYALDropDownList_DropDown')]//li[text()='Quarter Start']");
	By valueQuarterEnd = By.xpath("//div[contains(@id,'ddlAdditionalPayFreqTypeID_radYALDropDownList_DropDown')]//li[text()='Quarter End']");
	By valueRevenuePeriods = By.xpath("//div[contains(@id,'ddlAdditionalPayFreqTypeID_radYALDropDownList_DropDown')]//li[text()='Revenue Periods']");
	By valueNA = By.xpath("//div[contains(@id,'ddlAdditionalPayFreqTypeID_radYALDropDownList_DropDown')]//li[text()='N/A']");
	By arrowAdditionalPayFrequencyTypeDrp = By.xpath("//a[contains(@id,'ddlAdditionalPayFreqTypeID_radYALDropDownList_Arrow')]");
    
	By radioRecurring = By.xpath("//input[contains(@id,'_optRecurringDate') and @type='radio']");
	By drpRecurring = By.xpath("//input[contains(@id,'_ddlRecurringID_radYALDropDownList_Input') and @type='text']");
	By valueRecurringPaymentStartDate = By.xpath("//div[contains(@id,'ddlRecurringID_radYALDropDownList_DropDown')]//li[text()='Recurring Payment Start Date']");
	By arrowRecurringDrp = By.xpath("//a[contains(@id,'_ddlRecurringID_radYALDropDownList_Arrow')]");
	By errorMessage = By.xpath("//span[text()='Information needed in both dropdown!']");
	
	By drpRecurringFrequency = By.xpath("//input[contains(@id,'_ddlRecurringFrequency_radYALDropDownList_Input') and @type='text']");
	By valueMonthly = By.xpath("//div[contains(@id,'_ddlRecurringFrequency_radYALDropDownList_DropDown')]//li[text()='Monthly']");
	By valueAnnually = By.xpath("//div[contains(@id,'_ddlRecurringFrequency_radYALDropDownList_DropDown')]//li[text()='Annually']");
	By arrowRecurringFrequencyDrp = By.xpath("//a[contains(@id,'_ddlRecurringFrequency_radYALDropDownList_Arrow')]");
		
	By drpValueEffectiveDateLPD = By.xpath("//div[contains(@id,'_Last_Payment_Type_ID_radYALDropDownList_DropDown')]//li[text()='Effective Date']");
	By drpValueExpirationDateLPD = By.xpath("//div[contains(@id,'_Last_Payment_Type_ID_radYALDropDownList_DropDown')]//li[text()='Expiration Date']");
	By drpValueConstructionCommencement = By.xpath("//div[contains(@id,'_Last_Payment_Type_ID_radYALDropDownList_DropDown')]//li[text()='Construction Commencement']");
	By arrowLastPaymentDateDrp = By.xpath("//a[contains(@id,'_Last_Payment_Type_ID_radYALDropDownList_Arrow')]");
	
    By btnSave = By.xpath("//input[contains(@id,'CTRINFO_RadDock1_C_btnSave')]");
	
    By fpddRadioButton = By.xpath("//input[contains(@id,'_optFPDD')and @type='radio']");
    By lpddRadioButton = By.xpath("//input[contains(@id,'_optLPDD')and @type='radio']");
    
    public void verifyPaymentDatesFields(String testCaseName)  {
		log("verify payment dates fields test case started");
		if (LoginPage.isApplicableVersion(LoginPage.VERSION)) {
	            	try {
	    	    		Assert.assertTrue(util.isElementVisible(txtFirstPaymentDate));
	        			log("STEP 1: User cannot see First Payment Date Input Field ", Status.PASS);
	        		} catch (AssertionError e) {
	        			log("STEP 1: User can see First Payment Date Input Field ", Status.FAIL);
	        		}
	            	
	            	try {
	            		util.click(fpddRadioButton);
	    	    		util.click(drpFirstPaymentDate);
	    	    		Assert.assertFalse(util.isElementVisible(valueConstructionCommencement), "'construction Commencement' value is present in First Payment Date Dropdown");
	    	    		Assert.assertTrue(util.isElementVisible(valueEffectiveDate), "'Effective Date' value is not present in First Payment Date Dropdown");
	    	    		Assert.assertTrue(util.isElementVisible(valueExpirationDate), "'Expiration Date' value is not present in First Payment Date Dropdown");
	    	    		Assert.assertTrue(util.isElementVisible(valueAltFirstPaymentDate), "'Alt. First Payment Date' value is not present in First Payment Date Dropdown");
	    	    		Assert.assertTrue(util.isElementVisible(valueEffectiveDateAndOffset), "'Effective Date + Offset # of Days' value is not present in First Payment Date Dropdown");
	        			util.click(arrowFirstPaymentDateDrp);
	    	    		log("STEP 2: User can see All values in First Payment Date DD", Status.PASS);
	        		} catch (AssertionError e) {
	        			log("STEP 2: User cannot see All required values in First Payment Date DD", Status.FAIL);
	        		}
	            	
	            	try {
	    	    		util.click(drpAdditionalPayFrequencyType);
	    	    		Assert.assertTrue(util.isElementVisible(valueQuarterStart), "'Quarter Start' value is not present in Additional Payment Frequency Type Dropdown");
	    	    		Assert.assertTrue(util.isElementVisible(valueQuarterEnd), "'Quarter End' value is not present in Additional Payment Frequency Type Dropdown");
	    	    		Assert.assertTrue(util.isElementVisible(valueRevenuePeriods), "'Revenue Periods' value is not present in Additional Payment Frequency Type Dropdown");
	    	    		Assert.assertTrue(util.isElementVisible(valueNA), "'N/A' value is not present in Additional Payment Frequency Type Dropdown");
	        			util.click(arrowAdditionalPayFrequencyTypeDrp);
	        			util.click(lpddRadioButton);
	    	    		log("STEP 3: User can see All values in Additional Payment Frequency Type DD", Status.PASS);
	        		} catch (AssertionError e) {
	        			log("STEP 3: User cannot see All required values in Additional Payment Frequency Type DD", Status.FAIL);
	        		}
	            	
	            	try {
	    	    		util.click(drpRecurring);
	    	    		Assert.assertTrue(util.isElementVisible(valueRecurringPaymentStartDate), "'Recurring Payment Start Date' value is not present in Recurring Dropdown");
	        			util.click(arrowRecurringDrp);
	    	    		log("STEP 4: User can see All values in Recurring DD", Status.PASS);
	        		} catch (AssertionError e) {
	        			log("STEP 4: User cannot see All required values in Recurring DD", Status.FAIL);
	        		}
	            	
	            	try {
	    	    		util.click(drpRecurringFrequency);
	    	    		Assert.assertTrue(util.isElementVisible(valueMonthly), "'Monthly' value is not present in Recurring Frequency Dropdown");
	    	    		Assert.assertTrue(util.isElementVisible(valueAnnually), "'Annually' value is not present in Recurring Frequency Dropdown");
	        			util.click(arrowRecurringFrequencyDrp);
	    	    		log("STEP 5: User can see All values in Recurring Frequency DD", Status.PASS);
	        		} catch (AssertionError e) {
	        			log("STEP 5: User cannot see All required values in Recurring Frequency DD", Status.FAIL);
	        		}
	            	
	            	try {
	    	    		util.click(radioRecurring);
	    	    		log("STEP 6: User can select Recurring payment radio button", Status.PASS);
	        		} catch (Exception e) {
	        			log("STEP 6: User cannot select Recurring payment radio button", Status.FAIL);
	        			throw new RuntimeException("Failed in step 6");
	        		}
	            	
	            	try {
	    	    		util.click(btnSave);
	    	    		log("STEP 7: User can click on Save button without selecting Recurring payment option", Status.PASS);
	        		} catch (Exception e) {
	        			log("STEP 7: User cannot click on Save button without selecting Recurring payment option", Status.FAIL);
	        			throw new RuntimeException("Failed in step 7");
	        		}
	            	
	            	try {
	            		util.dummyWait(2);
	    	    		Assert.assertTrue(util.isElementVisible(errorMessage));
	        			log("STEP 8: User can see 'Information needed in both dropdown!' error message", Status.PASS);
	        		} catch (AssertionError e) {
	        			log("STEP 8: User cannot see 'Information needed in both dropdown!' error message", Status.FAIL);
	        		}
	            	
	            	try {
	    	    		util.click(drpLastPaymentDate);
	    	    		Assert.assertFalse(util.isElementVisible(drpValueConstructionCommencement), "'construction Commencement' value is present in Last Payment Date Dropdown");
	    	    		Assert.assertTrue(util.isElementVisible(drpValueEffectiveDateLPD), "'Effective Date' value is not present in Last Payment Date Dropdown");
	    	    		Assert.assertTrue(util.isElementVisible(drpValueExpirationDateLPD), "'Expiration Date' value is not present in Last Payment Date Dropdown");
	    	    		util.click(arrowLastPaymentDateDrp);
	    	    		log("STEP 9: User can see All values in Last Payment Date DD", Status.PASS);
	        		} catch (AssertionError e) {
	        			log("STEP 9: User cannot see All required values in Last Payment Date DD", Status.FAIL);
	        		}
	            	
	            }else {
			 log("This test case is not applicable for this application version ", Status.SKIP);
		}
    	
	 }
	
  	
	    	
}
