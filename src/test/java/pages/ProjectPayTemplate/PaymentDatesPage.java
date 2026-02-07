package pages.ProjectPayTemplate;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

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
	By navProjectPayTemplate = By.xpath("//span[contains(text(),'Project Pay Templates')]");
	 
	//for ROW
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navPaymentTemplates = By.xpath("//span[contains(text(),'Payment Templates')]");
	By navProjectPayTemplates = By.xpath("//span[contains(text(),'Project Pay Templates')]"); 
	
	By txtFirstPaymentDate = By.xpath("//input[contains(@id,'_First_Payment_Date_dateInput') and @type='text']");
	By drpFirstPaymentDate = By.xpath("//input[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_Input') and @type='text']");
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
    
    public void nevigateToProjectPayTemplate() {
  		util.waitUntilElementDisplay(navProject);
  		util.click(navProject);
  		util.waitUntilElementDisplay(navProjectPayTemplate);
  		util.click(navProjectPayTemplate);
  	}
  	
  	public void nevigateToProjectPayTemplateRow() {
  		util.waitUntilElementDisplay(navAdministration);
  		util.click(navAdministration);
  		util.waitUntilElementDisplay(navPaymentTemplates);
  		util.click(navPaymentTemplates);
  		util.waitUntilElementDisplay(navProjectPayTemplates);
  		util.click(navProjectPayTemplates);
  	}
  	
  	By Radiobtn = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_optFPDP']");
  	public void setFirstPaymentDate(String FirstPaymentDate) {
  		util.click(Radiobtn);
  		util.inputText(txtFirstPaymentDate, FirstPaymentDate);
  	}
      
  	By fpddRadioButton = By.xpath("//input[contains(@id,'_optFPDD')and @type='radio']");
	public void SelectFirstPaymentDateDDButton() {
		util.waitUntilElementDisplay(fpddRadioButton);
		util.click(fpddRadioButton);
		util.dummyWait(1);
	}
	
  	public void SelectDropdown(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpFirstPaymentDate, value);
  	}
  	
  	public void AddMonths(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtMonths, value);
  	}
      
  	public void SelectPeriod(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpPeriod, value);
  	}
  	
  	public void SelectAdditionlPaymentRadioButton() {
  		util.waitUntilElementDisplay(RadioButton);
  		util.click(RadioButton);
  	}
  	
    public void AddDays(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtDays, value);
  	}
  	
  	public void SelectEveryOptionButton() {
  		util.waitUntilElementDisplay(EveryOptionButton);
  		util.click(EveryOptionButton);
  	}
  	
  	public void AddTextBox(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(txtTextbox, value);
  	}
  	
  	public void SelectDropDown(String value) {
  		if (!commonFunction.checkNA(value))
  			util.inputTextAndPressTab(drpEvery, value);
  	}
  	
  	public void SelectLastPaymentDateButton() {
  		util.waitUntilElementDisplay(LastPaymentDateButton);
  		util.click(LastPaymentDateButton);
  	}
  	
  	public void setDate(String Date) {
  		util.inputText(txtDate, Date);
  	}
  	

  	By lpddRadioButton = By.xpath("//input[contains(@id,'_optLPDD')and @type='radio']");
	public void SelectLastPaymentDateDDButton() {
		util.waitUntilElementDisplay(lpddRadioButton);
		util.click(lpddRadioButton);
		util.dummyWait(1);
	}
	
  	By btnSave = By.xpath("//input[contains(@id,'CTRINFO_RadDock1_C_btnSave')]");
	public void SelectdrpLastPaymentDateDDValue(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpLastPaymentDate, value);
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(2);
	}

	public void PaymentDates(Map<String, String> map,String testCaseName)  {
	    	
	    	try {
	    		SelectFirstPaymentDateDDButton();
	    		SelectDropdown(map.get(Excel.FirstPaymentDateDropdown));
    			log("STEP 1: User can select 'Effective Date' from First Payment Date Dropdown dd ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 1: User cannot select 'Effective Date' from First Payment Date Dropdown dd ", Status.FAIL);
    			throw new RuntimeException("Failed in step 1");
    		}
	    	
	    	
	    	try {
	    		AddMonths(map.get(Excel.Months));
    			log("STEP 2:user can enter Additional First Payment Value textbox  ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 2: User cannot enter Additional First Payment Value textbox  ", Status.FAIL);
    			throw new RuntimeException("Failed in step 2");
    		}
	    	
	    	if(testCaseName.contains("ALT")|| testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
				try {
					SelectPeriod(map.get(Excel.Period));
					log("STEP 3: User can select value from Period dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: User cannot select value from Period dd ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
	    	}
	    	
	    	try {
	    		SelectAdditionlPaymentRadioButton();
	    		log("STEP 4:  user can select Every Radio Button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot select Every Radio Button ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
	    	
	    	try {
	    		AddTextBox(map.get(Excel.TextBox));
				log("STEP 5:  user can enter value in Every TextBox ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot enter value in Every TextBox ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
	    	
	    	if(testCaseName.contains("ALT")|| testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
				try {
					SelectDropDown(map.get(Excel.Period));
					log("STEP 6:  User can select Addional Payment Frequency ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User cannot select Addional Payment Frequency ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
	    	}
	    	
	    	try {
	    		SelectLastPaymentDateDDButton();
	    		SelectdrpLastPaymentDateDDValue(map.get(Excel.LastPaymentDateDropdown));
				log("STEP 7: User can select 'Expiration Date' from Last Payment Date Dropdown ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot select 'Expiration Date' from Last Payment Date Dropdown ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
  	 }
	    	
}
