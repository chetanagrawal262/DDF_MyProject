package pages.Compensation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class CompensationTabPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public CompensationTabPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navCompensation = By.xpath("(//span[text()='Compensation'])[1]");
	By tabPaymentObligation = By.xpath("//span[contains(text(),'Payment Obligation')]");
	By txtForecastedAmount = By.xpath("//input[contains(@id,'_txtForecastedAmt') and @type='text']"); 
	By btnSave = By.xpath("//input[@id='ctl00_ConPHRightTop_TRCD2_UC_radPanels_i3_i0_btnSaveForecastedAmount']");
	By changesSavedSuccessfully = By.xpath("//span[text()='Forecasted Amount  added successfully.']");
	
	public void NavigateToCompensationTab() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navCompensation);
		util.click(navCompensation);
	}
	
	public void ClickonPaymentObligationPanel() {
		util.waitUntilElementDisplay(tabPaymentObligation);
		util.click(tabPaymentObligation);
		util.dummyWait(2);
		util.click(tabPaymentObligation);
	}
	
	public void AddForecastedAmount(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtForecastedAmount, value);
	}
	
	public void ClickonSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Forecasted Amount  added successfully.");

	}
	

	public void CompensationTab(Map<String, String> map, String testcaseName) {
	
		 try {
			 NavigateToCompensationTab();
			 commonFunction.projectSelection();
				log("STEP 1:  User can navigate to the Compensation tab ", Status.PASS);
			 } catch (Exception e) {
				log("STEP 1:  Compensation tab does not load ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			 }
	   	 
		 if(!testcaseName.contains("TRA")) {
	   	 try {
	   		ClickonPaymentObligationPanel();
				log("STEP 2: Panel should be expand with respective fields ", Status.PASS);
			 } catch (Exception e) {
				log("STEP 2: Panel should not be expand and fields should not be display ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			 }

	   	 
	   	 try {
	   		AddForecastedAmount(map.get(Excel.Amount));
				log("STEP 3: Entered value should display in the Forecasted Amount field. ", Status.PASS);
			 } catch (Exception e) {
				log("STEP 3: Entered value does not display in Forecasted Amount field.  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			 }
		
	   	try {
	   		ClickonSaveButton();
				log("STEP 4:  Message - 'Message - 'Forecasted Amount added successfully' in green displays  ", Status.PASS);
			 } catch (Exception e) {
				log("STEP 4:  Message - 'Message - 'Forecasted Amount added successfully' does not displays ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			 }
		 }
		
	}
	
	
}
