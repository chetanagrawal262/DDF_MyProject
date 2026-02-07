package pages.RoyaltyPayment;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;

import extentReports.ExtentTestManager;
import pages.InfoByParcelReport.AddProjectPage;

public class PaymentInformationPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	Actions action;
	Map<String, String> rowData = new HashMap<String, String>();
	SoftAssert sf = new SoftAssert();
	
	public PaymentInformationPage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navLeaseManager = By.xpath("//a//span[contains(text(),'Lease Manager')] ");
	By navPaymentInformation = By.xpath("//a//span[contains(text(),'Payment Information')] ");
	By addDocumentButton = By.xpath("//div[contains(@id,'LSINFO_RadPageView3')]//img[@alt='Add Documents'] | //div[contains(@id,'LSINFO_RadPageView3')]//input[contains(@id,'_btnAddDoc')]");
	
	public void navigateToPaymentInformationALT() {
		util.waitUntilElementDisplay(paymentInformationTab);
		util.click(paymentInformationTab);
	}
	
	By paymentInformationTab = By.xpath("//span[text()='Payment Information']/../../parent::a[contains(@class,'rtsLink')]");
	By paymentTemplateDRP = By.xpath("//input[contains(@id,'MSPAYMENTTERMS_MSDropDown')]/../..//a");
	
	private void selectPaymentTemplate(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdownCheckbox(paymentTemplateDRP, value);
			util.click(paymentTemplateDRP); 
		}
	}
	
	By agreementTerm = By.xpath("//input[contains(@id,'Lease_Agreement_ID') and @type='text']");
	private void selectPaymentTerm(String value) {
		if (!commonFunction.checkNA(value)) {
			util.dummyWait(2);
			util.inputTextAndPressTab(agreementTerm, value);
		}
	}
	
	By addNewButton = By.xpath("//input[contains(@id,'ImgAddPaymentTerms')]");
	private void clickOnAddNewButton() {
		util.click(addNewButton);
	}
	By paymentHistorySection= By.xpath("//span[text()='Payment History']/../parent::a");
	private void clickOnPaymentHistoryPanel() {
		if(!util.isElementVisible(upcomingTab)) {
			util.waitUntilLoaderDisappear();
			util.click(paymentHistorySection);
		}
	}
	
	By upcomingTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Upcoming']");
	By pastTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Past']");
	private void clickOnUpcomingTab() {
		util.click(upcomingTab);
	}
	private void clickOnPastTab() {
		util.click(pastTab);
		util.dummyWait(1);
	}
	
	public void calculationValidation(String period, String payment) {
		
		By pastYears= By.xpath("//tr[contains(@id,'CHECKPast_radYALGridControl')]/..//*[text()='"+period+"']");
		By pastPayments= By.xpath("//tr[contains(@id,'CHECKPast_radYALGridControl')]/..//*[text()='"+period+"']/..//*[text()='"+payment+"']");
		
		By upcomingYears= By.xpath("//tr[contains(@id,'CHECKUpcoming_radYALGridControl')]/..//*[text()='"+period+"']");
		By upcomingPayments= By.xpath("//tr[contains(@id,'CHECKUpcoming_radYALGridControl')]/..//*[text()='"+period+"']/..//*[text()='"+payment+"']");
		
		if(util.isElementVisible(pastYears)) {
	sf.assertTrue(util.isElementVisible(pastYears), "Payment Date "+ period+" is not added");
	if(!payment.contains("NA")) {
	sf.assertTrue(util.isElementVisible(pastPayments), "Payment for the year "+period+" is not correct.");
	}
	ExtentTestManager.info("Expected Payment for the year "+period+" is "+payment);
		}
		else {
			if(!util.isElementVisible(upcomingYears)) {
			clickOnUpcomingTab();
		}
			sf.assertTrue(util.isElementVisible(upcomingYears), "Payment Date "+ period+" is not added");
			sf.assertTrue(util.isElementVisible(upcomingPayments), "Payment for the year "+period+" is not correct.");
			ExtentTestManager.info("Expected Payment for the year "+period+" is "+payment);
		}
	}
	
	
	public void addNewPaymentInformation(Map<String, String> map, String testCaseName) {
		
		try {
			navigateToPaymentInformationALT();
			log("STEP 1: Navigate to Project >agreement manager >payment Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Navigate to Project >agreement manager >payment Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			selectPaymentTemplate(map.get(Excel.PaymentTemplate));
			log("STEP 2: Fill in Add payment template dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select the payment template ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			selectPaymentTerm(map.get(Excel.PaymentTerm));
			log("STEP 3: Fill in Agreement Term DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select the Agreement Term from the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			clickOnAddNewButton();
			log("STEP 4: Click on Add New button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on Add New button", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
				
//		try {
//			clickOnPaymentHistoryPanel();
//			log("STEP 5: Click on Payment History Panel", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 5: User cannot click on Payment History Panel", Status.FAIL);
//			throw new RuntimeException("Failed in step 5");
//		}
//		
//		try {
//			clickOnPastTab();
//			log("STEP 6: User can click on Past Payment Tab", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 6: User cannot click on Past Payment Tab", Status.FAIL);
//			throw new RuntimeException("Failed in step 6");
//		}
//		
//		for(int i=1; i<ExcelUtils.totalRows-1; i++) {
//			String rowName = "Payment"+i;
//			rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), "PaymentCalculations",rowName);
//			calculationValidation(rowData.get("Payment Date"),rowData.get("Calculated Amount"));		
//		}
//		sf.assertAll();
//		
	}
	
	By navAgreementInformation = By.xpath("//a//span[contains(text(),'Agreement Information')] | //a//span[contains(text(),'Entity Information')]");
	
	public void navigateToAgreementInformationALT() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.dummyWait(1);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navAgreementInformation);
		navigateToPaymentInformationALT();
	}
 public void verifyCalculations(Map<String, String> map, String testCaseName) {
		
		try {
			navigateToAgreementInformationALT();
			commonFunction.selectProjectNew(AddProjectPage.PN);
			log("STEP 1: Navigate to Project >agreement manager >payment Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Navigate to Project >agreement manager >payment Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
				
		try {
			clickOnPaymentHistoryPanel();
			log("STEP 2: Click on Payment History Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Payment History Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			clickOnPastTab();
			log("STEP 3: User can click on Past Payment Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on Past Payment Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		for(int i=1; i<ExcelUtils.totalRows-1; i++) {
			String rowName = "Payment"+i;
			rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROYALTY_PAYMENT_TEST_DATA), "PaymentCalculations",rowName);
			calculationValidation(rowData.get("Payment Date"),rowData.get("Calculated Amount"));		
		}
		sf.assertAll();
		
	}
	
	
}
