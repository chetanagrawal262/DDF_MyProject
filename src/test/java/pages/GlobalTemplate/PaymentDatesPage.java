package pages.GlobalTemplate;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import page.Common.LoginPage;

public class PaymentDatesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public PaymentDatesPage(WebDriver driver) {
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
	
	By txtFirstPaymentDate = By.xpath("//input[contains(@id,'_First_Payment_Date_dateInput') and @type='text']");
	By dropdown = By.xpath("//input[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_Input') and @type='text']");
    By txtMonths = By.xpath("//input[contains(@id,'_First_Payment_Months_Add') and @type='text']");
    By drpPeriod = By.xpath("//input[contains(@id,'_Add_Period_ID_radYALDropDownList_Input') and @type='text']");
    By RadioButton = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_optAPMonths']");
    By NARadioButton = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_optAPNA']");	
    By RevenueButton = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_optRevenuePeriods']");
    By txtDays = By.xpath("//input[contains(@id,'_RadTextNoOfDays') and @type='text']");
    By EveryOptionButton = By.xpath("//input[contains(@id,'_optAPMonths') and @type='radio']");
    By txtTextbox = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_Additional_Payment_Frequency']");
    By drpDropdown = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_Additional_Payment_Frequency_ID_radYALDropDownList_Input']");
    By LastPaymentDateButton = By.xpath("//input[contains(@id,'_optLPDD')and @type='radio']");
    By NAButton = By.xpath("//input[contains(@id,'_optLPNA')and @type='radio']");	
    By txtDate = By.xpath("//input[contains(@id,'_Last_payment_Date_dateInput')and @type='text']");
    By paymentDropdown = By.xpath("//input[contains(@id,'_Last_Payment_Type_ID_radYALDropDownList_Input')and @type='text']");
    By txtAddPaymentDates = By.xpath("//input[contains(@id,'_Add_payment_Date') and @type='text']");
    By radioButtonAddPayDate = By.xpath("//input[contains(@id,'_optAPSPDates') and @type='radio']");
    By addButtonAddPayDate = By.xpath("//input[contains(@id,'_AddDate') and @type='image']");
    
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
		util.waitUntilElementDisplay(navGlobalPayTemplates);
		util.click(navGlobalPayTemplates);
	}
	
	By fpddRadioButton = By.xpath("//input[contains(@id,'_optFPDD')and @type='radio']");
	public void SelectFirstPaymentDateDDButton() {
		util.waitUntilElementDisplay(fpddRadioButton);
		util.click(fpddRadioButton);
		util.dummyWait(1);
	}
	
	public void SelectDropdown(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(dropdown, value);
	}
	
	public void SelectNARadioButton() {
		util.waitUntilElementDisplay(NARadioButton);
		util.click(NARadioButton);
	}
	
	public void SelectEveryRadioButton() {
		util.waitUntilElementDisplay(EveryOptionButton);
		util.click(EveryOptionButton);
	}
	
	public void addMonth(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTextbox, value);
	}
	
	public void SelectAddRadioButton() {
		util.waitUntilElementDisplay(radioButtonAddPayDate);
		util.click(radioButtonAddPayDate);
	}
	
	By radioRecurring = By.xpath("//input[contains(@id,'_optRecurringDate') and @type='radio']");
	By drpRecurring = By.xpath("//input[contains(@id,'_ddlRecurringID_radYALDropDownList_Input') and @type='text']");
	public void selectRecurringPaymentOption(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpRecurring, value);
	}
	
	By drpRecurringFrequency = By.xpath("//input[contains(@id,'_ddlRecurringFrequency_radYALDropDownList_Input') and @type='text']");
	public void selectRecurringPaymentFrequency(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpRecurringFrequency, value);
	}
	
	public void clickOnAdd() {
		util.waitUntilElementDisplay(addButtonAddPayDate);
		util.click(addButtonAddPayDate);
		util.waitFor(200);
	}
	
	public void addDate(String Date) {
		util.inputText(txtAddPaymentDates, Date);
	}
	
	By lpddRadioButton = By.xpath("//input[contains(@id,'_optLPDD')and @type='radio']");
	public void SelectLastPaymentDateDDButton() {
		util.waitUntilElementDisplay(lpddRadioButton);
		util.click(lpddRadioButton);
		util.dummyWait(1);
	}
	
By btnSave = By.xpath("//input[contains(@id,'CTRINFO_RadDock1_C_btnSave')]");
	public void SelectpaymentDropdown(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(paymentDropdown, value);
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(2);
	}
	
	 public void PaymentDates(Map<String, String> map,String testCaseName)  {
		 
		 if(testCaseName.contains("ALT") || testCaseName.contains("ORSTED")||testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
			 if (LoginPage.isApplicableVersion(LoginPage.VERSION)) {
			 
				 try {
					 util.click(radioRecurring);
					 selectRecurringPaymentOption("Recurring Payment Start Date");
					 selectRecurringPaymentFrequency("Annually");
		    			log("STEP 1: User can select Addional Payment option as Recurring Payment Start Date", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 1: User cannot select Addional Payment option as Recurring Payment Start Date", Status.FAIL);
		    			throw new RuntimeException("Failed in step 1");
		    		} 
				 
			 }else {
				 try {
			    		addDate(map.get("Date1"));
			    		clickOnAdd();
			    		addDate(map.get("Date2"));
			    		clickOnAdd();
			    		addDate(map.get("Date3"));
			    		clickOnAdd();
			    		addDate(map.get("Date4"));
			    		clickOnAdd();
			    		SelectAddRadioButton();
		    			log("STEP 1: User can add Additional Custom Payment Dates ", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 1: User cannot add Additional Custom Payment Dates", Status.FAIL);
		    			throw new RuntimeException("Failed in step 1");
		    		} 
			 }
		 }else {
			 try {
				 SelectEveryRadioButton();
				 addMonth("12");
		    		log("STEP 1:  user can select addtional payment date ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: User cannot select addtional payment date", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
		 }
		 
		 try {
	    		SelectFirstPaymentDateDDButton();
	    		SelectDropdown(map.get(Excel.FirstPaymentDateDropdown));
			log("STEP 2: User can select 'Effective Date' from First Payment Date Dropdown  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select 'Effective Date' from First Payment Date Dropdown ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		 
	    	
	    	try {
	    		SelectLastPaymentDateDDButton();
	    		SelectpaymentDropdown(map.get(Excel.LastPaymentDateDropdown));
				log("STEP 3: User can select 'Expiration Date' from Last Payment DateDropdown ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select 'Expiration Date' from Last Payment DateDropdown ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
	    	
	 }	
}
