package pages.agreementManager;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class AdditionalPaymentInformationPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	Actions action;
	Map<String, String> rowData = new HashMap<String, String>();
	SoftAssert sf = new SoftAssert();
	
	public AdditionalPaymentInformationPage(WebDriver driver) {
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
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navPaymentInformation);
		
	}
	
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
	
	By paymentTermGrid= By.xpath(" //*[@id=\"ctl00_ConPHRightTop_LSINFO_RadPanelBar1_i0_i0_LEASE_PAYMENTS_radYALGridControl_ctl00__0\"]/td[8]");
	By paymentHistorySection= By.xpath("//span[text()='Payment History']/../parent::a");
	private void clickOnPaymentHistoryPanel() {
		if(!util.isElementVisible(upcomingTab)) {
			util.waitUntilLoaderDisappear();
			util.click(paymentHistorySection);
		}
	}
	
	By upcomingTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Upcoming']");
	private void clickOnUpcomingTab() {
		util.click(upcomingTab);
	}
	
	
	public void upcomingPaymentValidation(String period, String payment) {
		By upcomingYears= By.xpath("//tr[contains(@id,'CHECKUpcoming_radYALGridControl')]/..//*[contains(text(),'"+payment+"')]/..//*[text()='"+period+"']");
		By upcomingPayments= By.xpath("//tr[contains(@id,'CHECKUpcoming_radYALGridControl')]/..//*[text()='"+period+"']/..//*[contains(text(),'"+payment+"')]");
	
			sf.assertTrue(util.isElementVisible(upcomingYears), "Payment Date "+ period+" is not added for payment "+payment);
			sf.assertTrue(util.isElementVisible(upcomingPayments), "Upcoming Payment for the year "+period+" is not correct");
			ExtentTestManager.info("Expected upcoming Payment for the year "+period+" is "+payment);
	}
	
	public void setPagesize(){
		By pagesize = By.xpath("//input[contains(@id,'_CHECKUpcoming_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox') and @type='text']");
		System.out.println("");
		By pageSize50 = By.xpath("//div[contains(@id,'_CHECKUpcoming_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_DropDown')]//li[3]");
		if(util.isElementPresent(pagesize)){
			util.click(pagesize);
			util.click(pageSize50);
		}
		else{
			System.out.println("Page Size option not shows");
		}
		
	}
	
	
	 By agreementReviewChecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @checked='checked']");
	    By agreementReviewUnchecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @type='checkbox']");
	    
	    By saveButton = By.xpath("(//input[contains(@id,'_btnSave') and not(@disabled)])[1]");
	    By drpPeerReviewer = By.xpath("//span[text()='Peer Reviewer:']/..//input[@type='text']");

		private void clickOnSaveButton() {
			util.click(saveButton);
			util.dummyWait(5);
		}
		
		By pastTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Past']");
		private void clickOnPastTab() {
			util.click(pastTab);
		}
		
		public void pastPaymentValidation(String period, String payment) {
			By pastYears= By.xpath("//tr[contains(@id,'CHECKPast_radYALGridControl')]/..//*[contains(text(),'"+payment+"')]/..//*[text()='"+period+"']");
			By pastPayments= By.xpath("//tr[contains(@id,'CHECKPast_radYALGridControl')]/..//*[text()='"+period+"']/..//*[contains(text(),'"+payment+"')]");
			
			sf.assertTrue(util.isElementVisible(pastYears), "Payment Date "+ period+" is not added for payment "+payment);
			sf.assertTrue(util.isElementVisible(pastPayments), "Past Payment for the year "+period+" is not correct");
			ExtentTestManager.info("Expected past Payment for the year "+period+" is "+payment);
		}
		
	public void addNewPaymentInformation(Map<String, String> map, String testCaseName) {
		if (environment.contains("NEXTERA")) {
			if(!util.isElementVisible(agreementReviewChecked)) {
				util.click(agreementReviewUnchecked);
				clickOnSaveButton();
			}
		}
		
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
		
				
		try {
			clickOnPaymentHistoryPanel();
			log("STEP 5: Click on Payment History Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on Payment History Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
util.dummyWait(1);
		
		try {
			clickOnPastTab();
			ExtentTestManager.infoWithScreenshot("Past Payments");
			log("STEP 6: Click on Past", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on Past Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		if(testCaseName.contains("CustomDate")) {
			try {
				for(int i=1; i<ExcelUtils.totalRows-1; i++) {
					String rowName = "PastPayment"+i;
					rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "PastCustomDates_Payments",
							rowName);
					pastPaymentValidation(rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
				}
				log("STEP 7: all Upcoming Payment sucessfully added", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: Upcoming Payment not added or calculations are incorrect", Status.FAIL);
			}
			
			}else {
				try {
					for(int i=1; i<ExcelUtils.totalRows-1; i++) {
						String rowName = "PastPayment"+i;
						rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "PastQuarterEnd_Payments",
								rowName);
						if(environment.contains("NEXTERA")) {
							pastPaymentValidation(rowData.get(Excel.Period),rowData.get("PaymentNEXTERA"));
						}else {
							pastPaymentValidation(rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
						}
					}
					log("STEP 7: all Upcoming Payment sucessfully added", Status.PASS);
				} catch (Exception e) {
					log("STEP 7: Upcoming Payment not added or calculations are incorrect", Status.FAIL);
				}
				
				
			}
		

		util.dummyWait(1);
		try {
			clickOnUpcomingTab();
			ExtentTestManager.infoWithScreenshot("Upcoming Payments");
			setPagesize();
			util.dummyWait(1);
			log("STEP 8: Click on Upcoming ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on Upcoming Tab ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		if(testCaseName.contains("CustomDate")) {
		try {
			for(int i=1; i<ExcelUtils.totalRows-1; i++) {
				String rowName = "UpcomingPayment"+i;
				rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "AdditionalCustomDates_Payments",
						rowName);
				upcomingPaymentValidation(rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
			}
			log("STEP 9: all Upcoming Payment sucessfully added", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: Upcoming Payment not added or calculations are incorrect", Status.FAIL);
		}
		
		}else {
			try {
				for(int i=1; i<ExcelUtils.totalRows-1; i++) {
					String rowName = "UpcomingPayment"+i;
					rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "AdditionalQuarterEnd_Payments",
							rowName);
					if(environment.contains("NEXTERA")) {
						upcomingPaymentValidation(rowData.get(Excel.Period),rowData.get("PaymentNEXTERA"));
					}else {
					upcomingPaymentValidation(rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
					}
				}
				log("STEP 9: all Upcoming Payment sucessfully added", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: Upcoming Payment not added or calculations are incorrect", Status.FAIL);
			}
			
			
		}
		sf.assertAll();
		
	}
	
	

	
	
}
