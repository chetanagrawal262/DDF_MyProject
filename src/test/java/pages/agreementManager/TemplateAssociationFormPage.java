package pages.agreementManager;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class TemplateAssociationFormPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	String AGREEMENT_NUMBER;
	
	public TemplateAssociationFormPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	

	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navLeaseManager = By.xpath("//a//span[contains(text(),'Lease Manager')] ");
	By navAgreementInformation = By.xpath("//a//span[contains(text(),'Agreement Information')] | //a//span[contains(text(),'Entity Information')]");
	By agreementOrLeaseTab = By.xpath("//span[text()='Agreement Forms' or text()='Lease Forms']");
	By addNewAgreementForm = By.xpath("//table[contains(@id,'LeaseInfoApproval')]//a[contains(@id,'lnkAddNewRecord')]");
	By agreementFormIFrame = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@name,'idManageApproval$cbParcelApprovalType')]");
	By drpPaymentTemplate = By.xpath("//span[text()='Payment Template:']/..//input[@type='text']");
	By drpAgreementTerm = By.xpath("//span[text()='Agreement Term:']/..//input[@type='text' and contains(@id,'idManageApproval')]");
	By txtStartPaymentFrom = By.xpath("(//span[text()='Start Payments From:']/..//input[@type='text' and contains(@id,'_dateInput')])[1]");
	By btnSaveApprovals = By.xpath("//input[contains(@id,'_btnSaveHeader')]");
	By btnSubmitForReview = By.xpath("//input[contains(@id,'WorkflowApprove_btnSubmit')]");
	By btnSubmitForReviewNew = By.xpath("//input[@id='idManageApproval_YALInLineWorkflowApprove_btnSubmit']");
	By btnCloseForm = By.xpath("//div[contains(@id,'ManageApprovalDialog')]//a[@title='Close']");
	By tabApproval = By.xpath("//div[@id='idManageApproval_tabStrip']//a[normalize-space()='Approvals' and not(contains(@class,'rtsDisabled'))]");
	By reviewComments = By.xpath("//textarea[contains(@id,'txtReviewerComments')]");
	By approveButton = By.xpath("//input[contains(@id,'btnApprove')]");
	By agreementNumber = By.xpath("//span[contains(@id,'_Lease_Number_wrapper')]/input[contains(@id,'_Lease_Number') and @type='text']");
	By linkPaymentAnalystPeerReview = By.xpath("//a[contains(text(),'Payment Analyst Peer Review')]");
	
	public void navigateToAgreementInformation() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitFor(500);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navAgreementInformation);
		
	}
	
	public void navigateToAgreementForm() {
		if(!util.isElementVisible(addNewAgreementForm)) {
			util.click(agreementOrLeaseTab);
		}
		util.click(addNewAgreementForm);
	}
	
	public void clickOnAddNewRecord() {
		util.click(addNewAgreementForm);
	}
	
	public void switchToAgreementFormIframe() {
		util.waitForWebElementToBePresent(agreementFormIFrame, IMPLICIT_WAIT);
		util.switchToIframe(agreementFormIFrame);
	}
	
	public void selectApprovalType(String value) {
		util.selectValueFromDropdown(drpApprovalType, value);
	}

	private void selectPaymentTemplate(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(drpPaymentTemplate, value);
		}
	}
	
	private void selectPaymentTerm(String value) {
		if (!commonFunction.checkNA(value)) {
			util.dummyWait(2);
			util.inputText(drpAgreementTerm, value);
			util.pressDownkey();
			util.pressENTERkey();
		}
	}
	
	private void EnterStartPaymentDate(String value) {
		if (!commonFunction.checkNA(value)) {
			util.dummyWait(2);
			util.inputTextAndPressTab(txtStartPaymentFrom, value);
		}
	}
	
	public void clickOnSaveApprovals() {
		util.click(btnSaveApprovals);
		util.dummyWait(2);
	}
	
	public void submitTheFormForReview() {
			if(util.isElementPresent(btnSubmitForReviewNew)) {
				util.click(btnSubmitForReviewNew);
			}else {
				util.click(btnSubmitForReview);
			}
	}
	
	public void CloseForm() {
		util.switchToDefaultContent();
		util.isElementVisible(btnCloseForm);
		util.click(btnCloseForm);
	}
	
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	public void TurnOnDesignMode() {
		util.waitUntilElementDisplay(btnDesignMode);
		util.click(btnDesignMode);
		util.dummyWait(2);
	}
	
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	public void SelectUser(String value) {
			if (!commonFunction.checkNA(value)) {
					util.selectValueFromDropdown(drpUser, value);
					
				util.pressENTERkey();
				}
		  }
	
    public void verifyStoredRecord( String workflow) {
		By locator = By.xpath("//td[text()='Approved']/..//td[text()='" + workflow + "']");
		if (util.isElementPresent(locator)) {
			log("STEP 28:  Status changed to 'Approved'  ", Status.PASS);
		} else {
			log("STEP 28: workflow is not Approved ", Status.FAIL);
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
	
	public void CreateTemplateAssociationForm(Map<String, String> map, String testName) {
		
		try {
			AGREEMENT_NUMBER=util.getAttributeValue(agreementNumber, "value");
			if(!util.isElementVisible(agreementReviewChecked)) {
				util.click(agreementReviewUnchecked);
				clickOnSaveButton();
			}
			navigateToAgreementForm();
			switchToAgreementFormIframe();
			log("STEP 1: User can click on Add New Record Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on Add New Record Button", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			selectApprovalType(map.get(Excel.ApprovalType));
			log("STEP 2: User can Select Work Flow from Approval Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Work Flow from Approval Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			selectPaymentTemplate(map.get(Excel.PaymentTemplate));
			log("STEP 3: User can Select Payment Template", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot Select Payment Template", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			selectPaymentTerm(map.get(Excel.AgreementTerm));
			log("STEP 4: User can Select Agreement Term", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select Agreement Term", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			EnterStartPaymentDate(map.get(Excel.StartPaymentFrom));
			util.inputText(drpPeerReviewer, map.get("Approver"));
			log("STEP 5: User can enter Start Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot enter Start Date", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			clickOnSaveApprovals();
			log("STEP 6: User can click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			By displayName = By.xpath("//strong[text()='Display Name:']/../..//td[text()='"+map.get(Excel.PaymentTemplate)+"']");
			Assert.assertTrue(util.isElementVisible(displayName));
			log("STEP 7: User can see Display Name", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: User cannot see Display Name", Status.FAIL);
		}
		
		try {
			By preparedBy = By.xpath("//strong[text()='Prepared By:']/../..//td[text()='"+map.get(Excel.CreatedBy)+"']");
			Assert.assertTrue(util.isElementVisible(preparedBy));
			log("STEP 8: User can see Prepared By", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8: User cannot see Prepared By", Status.FAIL);
		}
		
		try {
			By approvedBy = By.xpath("//strong[text()='Approved By:']/../..//td[text()='"+map.get(Excel.CreatedBy)+"']");
			Assert.assertTrue(util.isElementVisible(approvedBy));
			log("STEP 9: User can see Approved By", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9: User cannot see Approved By", Status.FAIL);
		}
		
		try {
			By firstPayment = By.xpath("//strong[text()='First Payment:']/../..//td[text()='"+map.get(Excel.FirstPaymentDate)+"']");
			Assert.assertTrue(util.isElementVisible(firstPayment));
			log("STEP 10: User can see First Payment Date", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10: User cannot see First Payment Date", Status.FAIL);
		}
		
		try {
			By lastPayment = By.xpath("//strong[text()='Last Payment:']/../..//td[text()='"+map.get(Excel.LastPaymentDate)+"']");
			Assert.assertTrue(util.isElementVisible(lastPayment));
			log("STEP 11: User can see Last Payment Date", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11: User cannot see Last Payment Date", Status.FAIL);
		}
		
		try {
			By calculationType = By.xpath("//strong[text()='Calculation Type:']/../..//td[text()='"+map.get(Excel.TypeofCalculation)+"']");
			Assert.assertTrue(util.isElementVisible(calculationType));
			log("STEP 12: User can see Calculation Type", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: User cannot see Calculation Type", Status.FAIL);
		}
		
		try {
			By distribution = By.xpath("//span[text()='Distribution:']/..//input[@type='text' and @value='"+map.get(Excel.Distribution)+"']");
			Assert.assertTrue(util.isElementVisible(distribution));
			log("STEP 13: User can see Distribution", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 13: User cannot see Distribution", Status.FAIL);
		}
		
		try {
			By landowner = By.xpath("//table[@class='payeefirstpayment']/..//td[text()='"+map.get(Excel.Landowner)+"']");
			Assert.assertTrue(util.isElementVisible(landowner));
			log("STEP 14: User can see Payee", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 14: User cannot see Payee", Status.FAIL);
		}
		
		try {
			By firstPayment = By.xpath("//table[@class='payeefirstpayment']/..//td[text()='"+map.get("FirstPayment")+"']");
			Assert.assertTrue(util.isElementVisible(firstPayment));
			log("STEP 15: User can see First Payment Amount", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 15: User cannot see First Payment Amount", Status.FAIL);
		}
		
		try {
			By firstPaymentDate = By.xpath("//table[@class='payeefirstpayment']/..//td[text()='"+map.get("FirstDate")+"']");
			Assert.assertTrue(util.isElementVisible(firstPaymentDate));
			log("STEP 16: User can see First Payment Date", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 16: User cannot see First Payment Date", Status.FAIL);
		}
		
		try {
			submitTheFormForReview();
			log("STEP 17: User can click on Submit button", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot click on Submit button", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
		try {
			CloseForm();
			log("STEP 18: User can click on close button", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: User cannot click on close button", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		
		try {
			TurnOnDesignMode();
			log("STEP 19: User can Turn on design mode", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: User cannot Turn on design mode", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		
		try {
			SelectUser(map.get("Approver"));
			log("STEP 20: User can switch to approver", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: User cannot switch to approver", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		
        try {
			navigateToAgreementInformation();
			By addedRecord = By.xpath("//td[text()='"+AGREEMENT_NUMBER.trim()+"']/parent::tr");
			util.click(addedRecord);
			util.dummyWait(2);
			log("STEP 21: User can navigate to Agreement Manager", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: User cannot navigate to Agreement Manager", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		} 
        
       try {
    	   By PendingwfID = By.xpath("(//*[text()='In-Review']/..//*[text()='"+map.get(Excel.ApprovalType)+"']/..//a[text()='Edit'])[1]");
			util.click(PendingwfID);
			util.dummyWait(3);
			util.switchToIframe(agreementFormIFrame);
			log("STEP 22: User can click on Edit Template Association Form", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: User cannot click on Edit Template Association Form", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		} 
       
       try {
			util.click(linkPaymentAnalystPeerReview);
			util.dummyWait(3);
			log("STEP 23: User can click on Payment Analyst Peer Review Link", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: User cannot click on Payment Analyst Peer Review Link", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		} 
       
       try {
			util.inputTextAndPressTab(reviewComments, "Approved");
			log("STEP 24: User can enter Reviewer Comments", Status.PASS);
		} catch (Exception e) {
			log("STEP 24: User cannot enter Reviewer Comments", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		} 
       
       
       try {
			util.click(approveButton);
			util.dummyWait(5);
			util.click(tabApproval);
			log("STEP 25: User can click on Approve Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: User cannot click on Approve Button", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		} 
       
       try {
			Assert.assertTrue(util.isElementVisible(By.xpath("//a[text()='Approved']")));
			log("STEP 26: User can see Approved Status", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: User cannot see Approved Status\"", Status.FAIL);
		}
       
       try {
			CloseForm();
			log("STEP 27: User can click on close button", Status.PASS);
		} catch (Exception e) {
			log("STEP 27: User cannot click on close button", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		} 
	}

	
	
	By paymentInformationTab = By.xpath("//span[text()='Payment Information']/../../parent::a[contains(@class,'rtsLink')]");
	public void navigateToPaymentInformation() {
		util.waitUntilElementDisplay(paymentInformationTab);
		util.click(paymentInformationTab);
		util.dummyWait(2);
		
	}

      public void verifyPaymentInformation(Map<String, String> map, String testCaseName) {
		
		try {
			navigateToPaymentInformation();
			log("STEP 1: Navigate to Payment Information", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Payment Information ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			By paymentType = By.xpath("//tr[contains(@id,'LEASE_PAYMENTS_radYALGridControl')]/..//td[text()='"+map.get(Excel.PaymentTemplate)+"']");
			Assert.assertTrue(util.isElementVisible(paymentType));
			log("STEP 2: User can see the Payment Type", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 2: User cannot see the Payment Type", Status.FAIL);
		}
		
		try {
			By totalAmount = By.xpath("//tr[contains(@id,'LEASE_PAYMENTS_radYALGridControl')]/..//td[text()='"+map.get("TotalAmount")+"']");
			Assert.assertTrue(util.isElementVisible(totalAmount));
			log("STEP 3: User can see the Total Amount", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3: User cannot see the Total Amount", Status.FAIL);
		}
		
		try {
			By landownerName = By.xpath("(//tr[contains(@id,'_CHECKUpcoming_radYALGridControl')]/..//td[text()='"+map.get(Excel.Landowner)+"'])[1]");
			Assert.assertTrue(util.isElementVisible(landownerName));
			log("STEP 4: User can see the Landowner Name", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4: User cannot see the Landowner Name", Status.FAIL);
		}
		
		try {
			By displayName = By.xpath("(//tr[contains(@id,'_CHECKUpcoming_radYALGridControl')]/..//td[text()='"+map.get(Excel.PaymentTemplate)+"'])[1]");
			Assert.assertTrue(util.isElementVisible(displayName));
			log("STEP 5: User can see the Display Name", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot see the Display Name", Status.FAIL);
		}
		
		try {
			By paymentDate = By.xpath("//tr[contains(@id,'_CHECKUpcoming_radYALGridControl')]/..//td[text()='"+map.get(Excel.FirstPaymentDate)+"']");
			Assert.assertTrue(util.isElementVisible(paymentDate));
			log("STEP 6: User can see the Payment Date", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: User cannot see the Payment Date", Status.FAIL);
		}
		
		try {
			By calculatedAmount = By.xpath("//tr[contains(@id,'_CHECKUpcoming_radYALGridControl')]/..//td[text()='"+map.get("PaymentAmount")+"']");
			Assert.assertTrue(util.isElementVisible(calculatedAmount));
			log("STEP 7: User can see the Payment Amount", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: User cannot see the Payment Amount", Status.FAIL);
		}
		
      }
	

}
