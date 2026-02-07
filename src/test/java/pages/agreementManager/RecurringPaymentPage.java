package pages.agreementManager;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class RecurringPaymentPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	Actions action;
	Map<String, String> rowData = new HashMap<String, String>();
	SoftAssert sf = new SoftAssert();
	String rowName, PAYMENT_TEMPLATE, TERM;
	
	public RecurringPaymentPage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navAgreementInformation = By.xpath("//a//span[contains(text(),'Agreement Information')] ");
	By navLeaseManager = By.xpath("//a//span[contains(text(),'Lease Manager')] ");
	By navPaymentInformation = By.xpath("//a//span[contains(text(),'Payment Information')] ");
	By addDocumentButton = By.xpath("//div[contains(@id,'LSINFO_RadPageView3')]//img[@alt='Add Documents'] | //div[contains(@id,'LSINFO_RadPageView3')]//input[contains(@id,'_btnAddDoc')]");
	By navAgreementInformationTab = By.xpath("//*[@id='ctl00_ConPHRightTop_LSINFO_RadTabStrip1']//span[text()='Agreement Information']");
	By linkShowDetails = By.xpath("//a[text()='Show Details']");
	By leaseDocumentIframe = By.xpath("//iframe[@name='LeaseDocument']");
	By iframeSaveButton = By.xpath("//input[@id='btnSave']");
	By txtAltFirstPaymentDate = By.xpath("//input[@id='rdpAltFirstPayDate_dateInput' and @ type='text']");
	By txtOffsetDays = By.xpath("//input[@id='txtOffsetNoOfDays' and @ type='text']");
	By txtRecurringPaymentStartDate = By.xpath("//input[@id='rdpRecurringPayStartDate_dateInput' and @ type='text']");
	By closeLeaseDocumentIframe = By.xpath("//div[contains(@id,'_LeaseDocument')]//a[@title='Close']");
	By navPaymentInformationTab = By.xpath("//*[@id='ctl00_ConPHRightTop_LSINFO_RadTabStrip1']//span[text()='Payment Information']");
	By recalculate = By.xpath("//div[contains(@id,'_LSINFO_PaymentTermsContextMenu_detached')]/..//span[text()='Recalculate']");
	
	public void navigateToPaymentInformationMenu() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitFor(300);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navPaymentInformation);
	}
	
	public void navigateToAgreementInformationMenu() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navAgreementInformation);
	}
	
	public void navigateToAgreementInformation() {
		util.waitUntilElementDisplay(navAgreementInformationTab);
		util.click(navAgreementInformationTab);		
	}
	
	public void navigateToPaymentInformationTab() {
		util.waitUntilElementDisplay(navPaymentInformationTab);
		util.click(navPaymentInformationTab);		
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
	
	By pastTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Past']");
	private void clickOnPastTab() {
		util.click(pastTab);
	}
	
	public void upcomingPaymentValidation(String period, String payment) {
		By upcomingYears= By.xpath("//tr[contains(@id,'CHECKUpcoming_radYALGridControl')]/..//*[text()='"+PAYMENT_TEMPLATE+"']/..//*[contains(text(),'"+payment+"')]/..//*[text()='"+period+"']");
		By upcomingPayments= By.xpath("//tr[contains(@id,'CHECKUpcoming_radYALGridControl')]/..//*[text()='"+PAYMENT_TEMPLATE+"']/..//*[text()='"+period+"']/..//*[contains(text(),'"+payment+"')]");
	
			sf.assertTrue(util.isElementVisible(upcomingYears), "Payment Date "+ period+" is not added for payment "+payment);
			sf.assertTrue(util.isElementVisible(upcomingPayments), "Upcoming Payment for the year "+period+" is not correct");
			ExtentTestManager.info("Expected Payment for the year "+period+" is "+payment);
	}
	
	public void pastPaymentValidation(String period, String payment) {
		By pastYears= By.xpath("//tr[contains(@id,'CHECKPast_radYALGridControl')]/..//*[text()='"+PAYMENT_TEMPLATE+"']/..//*[contains(text(),'"+payment+"')]/..//*[text()='"+period+"']");
		By pastPayments= By.xpath("//tr[contains(@id,'CHECKPast_radYALGridControl')]/..//*[text()='"+PAYMENT_TEMPLATE+"']/..//*[text()='"+period+"']/..//*[contains(text(),'"+payment+"')]");
	
			sf.assertTrue(util.isElementVisible(pastYears), "Payment Date "+ period+" is not added for payment "+payment);
			sf.assertTrue(util.isElementVisible(pastPayments), "Past Payment for the year "+period+" is not correct");
			ExtentTestManager.info("Expected Payment for the year "+period+" is "+payment);
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
	
	 public void RecalculatePayment(String paymentTemplate, String term) {
		 By leasePaymentGrid = By.xpath("//tr[contains(@id,'_LEASE_PAYMENTS_radYALGridControl')]/..//td[text()='"+paymentTemplate+"']");
		 
		 if(util.isElementVisible(leasePaymentGrid)) {
	    	WebElement web = driver.findElement(leasePaymentGrid);
	    	util.waitUntilElementDisplay(leasePaymentGrid);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	    	util.waitUntilElementDisplay(recalculate);
	    	util.click(recalculate);
		 }else {
			 selectPaymentTemplate(paymentTemplate);
			 selectPaymentTerm(term);
			 clickOnAddNewButton();
		 }
	}
	
	 
	 By agreementReviewChecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @checked='checked']");
	    By agreementReviewUnchecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @type='checkbox']");
	    
	    By saveButton = By.xpath("(//input[contains(@id,'_btnSave') and not(@disabled)])[1]");

		private void clickOnSaveButton() {
			util.click(saveButton);
			util.dummyWait(5);
		}
	public void verifyRecurringPayment(Map<String, String> map, String testCaseName) {
		try {
			navigateToPaymentInformationMenu();
			log("STEP 1: User can navigate to Project >agreement manager >payment Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Project >agreement manager >payment Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			selectPaymentTemplate(map.get(Excel.PaymentTemplate));
			PAYMENT_TEMPLATE = map.get(Excel.PaymentTemplate);
			log("STEP 2: User can select payment template from the dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select payment template from the dd", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			selectPaymentTerm(map.get(Excel.PaymentTerm));
			TERM = map.get(Excel.PaymentTerm);
			log("STEP 3: User can select Agreement Term from the dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Agreement Term from the dd", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			clickOnAddNewButton();
			log("STEP 4: User can click on Add New button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on Add New button", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			clickOnPaymentHistoryPanel();
			log("STEP 5: User can click on Payment History Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on Payment History Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		util.dummyWait(1);
		try {
			clickOnPastTab();
			ExtentTestManager.infoWithScreenshot("Past Payments without Recurring Payment Start Date");
			setPagesize();
			util.dummyWait(1);
			
			log("STEP 6: User can click on Past Tab ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on Past Tab ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "Past_RecurringPayment","Payment1");
			pastPaymentValidation(rowData.get("Recurring_Period"),rowData.get("PaymentCalculation"));
			log("STEP 7: Payment successfully added as per Effective Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: Payment not added as per Effective Date", Status.FAIL);
		}
		
		try {
			navigateToAgreementInformation();
			util.waitUntilPageLoad();
			log("STEP 8: User can navigate to Agreement Information Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot navigate to Agreement Information Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			util.waitUntilElementDisplay(linkShowDetails);
			util.click(linkShowDetails);
			util.switchToIframe(leaseDocumentIframe);
			log("STEP 9: User can click on the Show Details link", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot click on the Show Details link", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			util.inputTextAndPressTab(txtRecurringPaymentStartDate, map.get("RecurringPaymentStartDate"));
			log("STEP 10: User can enter Recurring Payment Start Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot enter Recurring Payment Start Date", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			util.click(iframeSaveButton);
			ExtentTestManager.infoWithScreenshot("Recurring Payment Start Date Updated");
			util.switchToDefaultContent();
			util.click(closeLeaseDocumentIframe);
			log("STEP 11: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			
			if (environment.contains("NEXTERA")) {
				util.reloadPage();
				util.dummyWait(2);
				util.waitUntilPageLoad();
				if(!util.isElementVisible(agreementReviewChecked)) {
					util.click(agreementReviewUnchecked);
					clickOnSaveButton();
				}
			}
			navigateToPaymentInformationTab();
			util.waitUntilPageLoad();
			log("STEP 12: User can navigate to Payment Information", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot navigate to Payment Information", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			RecalculatePayment(map.get(Excel.PaymentTemplate), TERM);
			util.waitUntilPageLoad();
			setPagesize();
			util.dummyWait(1);
			util.waitUntilLoaderDisappear();
			log("STEP 13: User can Recalculate Payment", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot Recalculate Payment", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			for(int i=1; i<ExcelUtils.totalRows-1; i++) {
				String rowName = "Payment"+i;
				rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "RecurringPaymentCalculation",
						rowName);
				upcomingPaymentValidation(rowData.get("Recurring_Period"),rowData.get("PaymentCalculation"));
			}
			sf.assertAll();
			log("STEP 14: All Payment Successfully Added as per Recurring Payment Start Date ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: Payment not Added as per Recurring Payment Start Date", Status.FAIL);
		}
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navGlobalTemplate = By.xpath("//span[contains(text(),'Global Template')]");
	public void nevigateToGlobalTemplet() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navGlobalTemplate);
		util.click(navGlobalTemplate);
	}
	
  By SaveBtn = By.xpath("//input[contains(@id,'_btnSave') and @type='image']");
	public void ClickonSaveButton() {
		util.waitUntilElementDisplay(SaveBtn);
		util.click(SaveBtn);
	}
	
	By fpddRadioButton = By.xpath("//input[contains(@id,'_optFPDD')and @type='radio']");
	public void SelectFirstPaymentDateDDButton() {
		util.waitUntilElementDisplay(fpddRadioButton);
		util.click(fpddRadioButton);
		util.dummyWait(1);
	}
	
	By drpFirstPaymentDate = By.xpath("//input[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_Input') and @type='text']");
	public void SelectFirstPaymentDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpFirstPaymentDate, value);
	}
	
	public void ApproveTemplate() {
    	util.waitUntilElementDisplay(BtnSubmitForReview);
    	util.click(BtnSubmitForReview);
    	util.waitUntilElementDisplay(BtnApprove);
    	util.click(BtnApprove);
    }
    By BtnSubmitForReview = By.xpath("//input[contains(@id, 'btnSubmitPeerReview')]");
    By BtnApprove = By.xpath("//input[contains(@id,'btnApprove')]");
    
	public void updateGlobalTemplate(String firstPaymentDate, String testCaseName) {
		
		try {
			nevigateToGlobalTemplet();
			log("STEP 1: User can navigate to project global template page.", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to project global template page. ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			By paymentTem = By.xpath("//tr[contains(@id,'PAYLST_RadGridTracts')]/..//strong[text()='"+PAYMENT_TEMPLATE+"']/..");
			util.click(paymentTem);
			util.dummyWait(1);
			log("STEP 2: User can select Payment Template", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Payment Template", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			SelectFirstPaymentDateDDButton();
			SelectFirstPaymentDate(firstPaymentDate);
			log("STEP 3: User can select value from First Payment Date Dropdown  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select value from First Payment Date Dropdown ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			ClickonSaveButton();
			log("STEP 4: User can click on Save Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on Save Button", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		if(util.isElementVisible(BtnSubmitForReview)) {
    		try {
	    		ApproveTemplate();
				log("STEP 5 user can able to approve template ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5 user cannot approve the tempalte ", Status.FAIL);
				throw new RuntimeException("Failed to approve");
			}	
    	}
    	
		
	}

	By errorFirstPaymentDate = By.xpath("//td[text()='First payment date (Alt. First Payment Date) has not been specified.']");
	public void verifyAltFirstPaymentDateCalculation(Map<String, String> map, String testCaseName) {
		try {
			navigateToPaymentInformationMenu();
			log("STEP 1: User can navigate to Project >agreement manager >payment Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Project >agreement manager >payment Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			RecalculatePayment(PAYMENT_TEMPLATE, TERM);
			util.waitUntilPageLoad();
			log("STEP 2: User can Recalculate Payment", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot Recalculate Payment", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(errorFirstPaymentDate), "Error Message is not displayed");	
			log("STEP 3: User can see the Error Message 'First payment date (Alt. First Payment Date) has not been specified.' ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3: User cannot see the Error Message 'First payment date (Alt. First Payment Date) has not been specified.' ", Status.FAIL);
		}
		ExtentTestManager.infoWithScreenshot("Error Message if Alt First Payment Date is not added");
		try {
			navigateToAgreementInformation();
			util.waitUntilPageLoad();
			log("STEP 4: User can navigate to Agreement Information Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot navigate to Agreement Information Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			util.waitUntilElementDisplay(linkShowDetails);
			util.click(linkShowDetails);
			util.switchToIframe(leaseDocumentIframe);
			log("STEP 5: User can click on the Show Details link", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on the Show Details link", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			util.inputTextAndPressTab(txtAltFirstPaymentDate, map.get("AltFirstPaymentDate"));
			log("STEP 6: User can enter Alt First Payment Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot enter Alt First Payment Date", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			util.click(iframeSaveButton);
			ExtentTestManager.infoWithScreenshot("Updated Alt First Payment Date");
			util.switchToDefaultContent();
			util.click(closeLeaseDocumentIframe);
			log("STEP 7: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			
			if (environment.contains("NEXTERA")) {
				util.reloadPage();
				util.dummyWait(2);
				util.waitUntilPageLoad();
				if(!util.isElementVisible(agreementReviewChecked)) {
					util.click(agreementReviewUnchecked);
					clickOnSaveButton();
				}
			}
			navigateToPaymentInformationTab();
			util.waitUntilPageLoad();
			log("STEP 8: User can navigate to Payment Information", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot navigate to Payment Information", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			RecalculatePayment(PAYMENT_TEMPLATE, TERM);
			util.waitUntilPageLoad();
			clickOnUpcomingTab();
			ExtentTestManager.infoWithScreenshot("Upcoming Payments without Recurring Payment Start Date");
			setPagesize();
            util.waitUntilLoaderDisappear();
			log("STEP 9: User can Recalculate Payment", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot Recalculate Payment", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "Past_RecurringPayment","Payment1");
			upcomingPaymentValidation(rowData.get("AltFirstPaymentDate_Period"),rowData.get("PaymentCalculation"));
			log("STEP 10: First Payment successfully added as per Alt First Payment Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: First Payment not added as per Alt First Payment Date", Status.FAIL);
		}
		
		try {
			for(int i=1; i<ExcelUtils.totalRows-1; i++) {
				String rowName = "Payment"+i;
				rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "RecurringPaymentCalculation",
						rowName);
				upcomingPaymentValidation(rowData.get("AltFirstPaymentDate_Period"),rowData.get("PaymentCalculation"));
			}
			sf.assertAll();
			log("STEP 11: All Payments Successfully Added starting from Alt First Payment Date ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: Payments are Incorrect or not added as per Alt First Payment Date", Status.FAIL);
		}
		
	}
	
	
	By validation = By.xpath("//span[@id='custvalAltFirstPayDate']");
	public void verifyEffectiveDateOffsetPaymentCalculation(Map<String, String> map, String testCaseName) {
		try {
			navigateToAgreementInformationMenu();
			log("STEP 5: User can navigate to Project >agreement Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot navigate to Project >agreement Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			util.waitUntilElementDisplay(linkShowDetails);
			util.click(linkShowDetails);
			util.switchToIframe(leaseDocumentIframe);
			log("STEP 6: User can click on the Show Details link", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on the Show Details link", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			util.inputTextAndPressTab(txtOffsetDays, map.get("OffsetDays"));
			log("STEP 7: User can enter Offset No of Days", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot enter Offset No of Days", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			util.click(iframeSaveButton);
			log("STEP 8: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			String errorMessage = util.getText(validation);
			System.out.println("Error Message: " + errorMessage);
			Assert.assertEquals(errorMessage, "Only one of the fields, 'Alt. First Payment Date' & 'Offset # of Days', can have a value.");
			ExtentTestManager.infoWithScreenshot("Error Message if both Alt First Payment Date and Offset # of Days added");
			log("STEP 9: User can see the Error Message 'Only one of the fields, 'Alt. First Payment Date:' & 'Offset # of Days:', can have a value.' ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9: User cannot see the Error Message 'Only one of the fields, 'Alt. First Payment Date:' & 'Offset # of Days:', can have a value.' ", Status.FAIL);
		}
		
		try {
			util.clearInputField(txtAltFirstPaymentDate);
			log("STEP 10: User can clear Input field Alt. First Payment Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot clear Input field Alt. First Payment Date", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			util.click(iframeSaveButton);
			util.switchToDefaultContent();
			util.click(closeLeaseDocumentIframe);
			log("STEP 11: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			
			if (environment.contains("NEXTERA")) {
				util.reloadPage();
				util.dummyWait(2);
				util.waitUntilPageLoad();
				if(!util.isElementVisible(agreementReviewChecked)) {
					util.click(agreementReviewUnchecked);
					clickOnSaveButton();
				}
			}
			navigateToPaymentInformationTab();
			util.waitUntilPageLoad();
			
			log("STEP 12: User can navigate to Payment Information", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot navigate to Payment Information", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			RecalculatePayment(PAYMENT_TEMPLATE, TERM);
			util.waitUntilPageLoad();
			setPagesize();
			util.dummyWait(1);
			log("STEP 13: User can Recalculate Payment", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot Recalculate Payment", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "Past_RecurringPayment","Payment1");
			upcomingPaymentValidation(rowData.get("EffectiveDateOffsetDays_Period"),rowData.get("PaymentCalculation"));
			log("STEP 14: First Payment successfully added as per Effective Date + Offset # of Days", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: First Payment not added as per Effective Date + Offset # of Days", Status.FAIL);
		}
		
		try {
			for(int i=1; i<ExcelUtils.totalRows-1; i++) {
				String rowName = "Payment"+i;
				rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADDITIONAL_PAYMENT_INFORMATION), "RecurringPaymentCalculation",
						rowName);
				upcomingPaymentValidation(rowData.get("EffectiveDateOffsetDays_Period"),rowData.get("PaymentCalculation"));
			}
			sf.assertAll();
			log("STEP 15: All Payments Successfully Added starting from Effective Date + Offset # of Days ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: Payments are Incorrect or not added as per Effective Date + Offset # of Days", Status.FAIL);
		}
		
	}
	
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	 public void TurnOnDesignMode() {
		 util.waitUntilPageLoad();
	    	util.waitUntilElementDisplay(btnDesignMode);
	    	util.click(btnDesignMode);
	    	util.dummyWait(2);
	    }
	 
	 By labelIconAltFirstPaymentDate = By.xpath("//span[@id='ylblAltFirstPayDate_ManageLabelID']");
	 By labelIconOffsetNumOfDays = By.xpath("//span[@id='ylblOffsetNumOfDays_ManageLabelID']");
	 By labelIconRecurringPaymentStartDate = By.xpath("//span[@id='ylblRecurringPaymentStartDate_ManageLabelID']");
	 
	public void verifyLabelConfigAgreementTermFields(String testCaseName) {
		
		try {
			navigateToAgreementInformationMenu();
			log("STEP 1: User can navigate to Project >agreement Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Project >agreement Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			TurnOnDesignMode();
			log("STEP 2:  user can turn on design mode", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  user cannot turn on design mode", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		} 
		
		try {
			util.waitUntilElementDisplay(linkShowDetails);
			util.click(linkShowDetails);
			util.switchToIframe(leaseDocumentIframe);
			log("STEP 3: User can click on the Show Details link", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on the Show Details link", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			util.waitUntilElementDisplay(labelIconAltFirstPaymentDate);
			util.click(labelIconAltFirstPaymentDate);
			util.switchToChildWindow();
			log("STEP 4: User can click on Label Config Icon of Alt. First Payment Date ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on Label Config Icon of Alt. First Payment Date ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			String type=driver.getCurrentUrl();
			Assert.assertTrue(type.contains("ALT_FIRST_PAYMENT_DATE"), "Label Config window is not opened for Alt. First Payment Date");
			driver.close();
			util.switchToParentWindow();
			log("STEP 5: User can see correct type for Alt. First Payment Date label config page", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot see correct type for Alt. First Payment Date label config page", Status.FAIL);
		}
		
		try {
			util.switchToIframe(leaseDocumentIframe);
			util.waitUntilElementDisplay(labelIconOffsetNumOfDays);
			util.click(labelIconOffsetNumOfDays);
			util.switchToChildWindow();
			log("STEP 6: User can click on Label Config Icon of Offset # Of Days ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on Label Config Icon of Offset # Of Days ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			String type=driver.getCurrentUrl();
			Assert.assertTrue(type.contains("OFFSET_NUM_OF_DAYS"), "Label Config window is not opened for Offset # Of Days");
			driver.close();
			util.switchToParentWindow();
			log("STEP 7: User can see correct type for Offset # Of Days label config page", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: User cannot see correct type for Offset # Of Days label config page", Status.FAIL);
		}
		
		try {
			util.switchToIframe(leaseDocumentIframe);
			util.waitUntilElementDisplay(labelIconRecurringPaymentStartDate);
			util.click(labelIconRecurringPaymentStartDate);
			util.switchToChildWindow();
			log("STEP 8: User can click on Label Config Icon of Recurring Payment Start Date ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on Label Config Icon of Recurring Payment Start Date ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			String type=driver.getCurrentUrl();
			Assert.assertTrue(type.contains("RECURRING_PAYMENT_START_DATE"), "Label Config window is not opened for Recurring Payment Start Date");
			driver.close();
			util.switchToParentWindow();
			util.click(closeLeaseDocumentIframe);
			log("STEP 9: User can see correct type for Recurring Payment Start Date label config page", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9: User cannot see correct type for Recurring Payment Start Date label config page", Status.FAIL);
		}
	}
	
}
