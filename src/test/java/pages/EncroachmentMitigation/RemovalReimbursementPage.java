package pages.EncroachmentMitigation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class RemovalReimbursementPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public RemovalReimbursementPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By panelRemovalReimbursement = By.xpath("//span[text()='Removal Reimbursement']");
	By btnAddNew = By.xpath("//input[contains(@id,'_BtnAddNewRecord')]");
	By maximizePopup = By.xpath("//a[@title='Maximize']");
	By iframeIssueR = By.xpath("//iframe[@name='IssueR']");
	By btnSave = By.xpath("//input[@id='btnSave']");
	By btnCancel = By.xpath("//input[@id='btnCancel']");
	By btnAddNewRow = By.xpath("//input[@id='btnAddNewRow']");
	By txtPaymentFor = By.xpath("(//input[contains(@id,'Txt_Payment_For') and @type='text'])[last()]");
	By txtComments = By.xpath("(//input[contains(@id,'_Txt_Comments') and @type='text'])[last()]");
	By txtPaymentAmount = By.xpath("(//input[contains(@id,'_RntPay_Amount') and @type='text'])[last()]");
	By checkBoxReimburse = By.xpath("(//input[contains(@id,'_Chk_Reimburse') and @type='checkbox'])[last()]");
    By successMessage = By.xpath("//span[text()='Change(s) saved successfully.']");
	By btnSubmit = By.xpath("//input[@id='btnSubmit']");
	By txtAllocation = By.xpath("//input[contains(@id,'_RntAllocation') and @type='text']");
	By txtCheckNo = By.xpath("//input[contains(@id,'_TxtCheckNo') and @type='text']");
	By txtCheckDate = By.xpath("//input[contains(@id,'_RdCheckDate_dateInput') and @type='text']");
	By submittedMessage = By.xpath("//span[text()='Record submitted successfully..']");
	By btnClose = By.xpath("//a[@title='Close']");
	
	By linkEdit = By.xpath("//a[text()='Edit' and contains(@onclick,'ShowIssueReimburse')]");
	By linkAddDocument = By.xpath("//a[text()='Add Document']");
	By spinnerDocumentPopup = By.xpath("//td[@class='rwWindowContent rwExternalContent rwLoading']");
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
	By txtDescription = By.xpath("//input[contains(@id,'RadUpload1Desc') or contains(@id,'rauFileUploadDesc')] "); 
	By btnLoadDocuments = By.xpath("//input[contains(@id,'buttonSubmit_input') and @type='button']");
    
    
	public void ExpandRemovalReimbursement() {
		util.waitUntilElementDisplay(panelRemovalReimbursement);
		util.click(panelRemovalReimbursement);
	}

	public void ClickOnAddNew() {
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.dummyWait(2);
	}

	public void MaximizePopUp() {
		util.waitUntilElementDisplay(maximizePopup);
		util.click(maximizePopup);
	}

	public void switchToIframe() {
		util.switchToIframe(iframeIssueR);
	}

	public void ClickOnAddNewROW() {
		util.waitUntilElementDisplay(btnAddNewRow);
		util.click(btnAddNewRow);
	}

	public void AddPaymentFor(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPaymentFor, value);
	}

	public void AddComments(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComments, value);
	}

	public void AddPaymentAmount(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPaymentAmount, value);
	}

	public void selectReimburseCheckBox() {
		util.waitUntilElementDisplay(checkBoxReimburse);
		util.click(checkBoxReimburse);
	}

	public void ClickOnSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(1);
	}

	public void ClickOnSubmitButton() {
		util.waitUntilElementDisplay(btnSubmit);
		util.click(btnSubmit);
		util.dummyWait(1);
	}

	public void AddAllocation(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAllocation, value);
	}

	public void AddCheckNumber(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCheckNo, value);
	}

	public void AddCheckDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCheckDate, value);
	}

	public void ClosePopUp() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
		util.dummyWait(1);
	}
	
	public void ClickOnEdit() {
		util.waitUntilElementDisplay(linkEdit);
		util.click(linkEdit);
		util.dummyWait(1);
	}
	
	public void ClickOnAddDocument() {
		util.waitUntilElementDisplay(linkAddDocument);
		util.click(linkAddDocument);
		util.waitUntilElementDisappear(spinnerDocumentPopup);
		util.switchToIframe(iframeDocument);
	}
	
	
	 
	 public void AddReimbursementDetails(Map<String, String> map, String testcaseName) {
			
		  try {
			  ExpandRemovalReimbursement();
				log("STEP 1: User can expand the Removal Reimbursement Panel ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot expand the Removal Reimbursement Panel", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		  
		  try {
			  ClickOnAddNew();
				log("STEP 2: User can click on Add New Button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on Add New Button", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		  
		  try {
			  MaximizePopUp();
			  switchToIframe();
				log("STEP 3: User can Maximize Popup ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot Maximize Popup", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		  
		  try {
			  ClickOnAddNewROW();
				log("STEP 4: User can click on Add New Row Button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot click on Add New Row Button", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		  
			try {
				AddPaymentFor(map.get("PaymentFor"));
				log("STEP 5: User can enter Payment For Value", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot enter Payment For Value", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}

			try {
				AddComments(map.get("Comments"));
				log("STEP 6: User can enter Comments", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot enter Comments", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				AddPaymentAmount(map.get("PaymentAmount"));
				log("STEP 7: User can enter Payment Amount", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot enter Payment Amount", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				selectReimburseCheckBox();
				log("STEP 8: User can select Reimburse Check box ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot select Reimburse Check box", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				ClickOnSaveButton();
				log("STEP 9: User can save the details in Removal Reimbursement Popup ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot save the details in Removal Reimbursement Popup", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}

			try {
				Assert.assertTrue(util.isElementVisible(successMessage));
				log("STEP 10: User can see success message ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10: User cannot see success message", Status.FAIL);
			}
			
			try {
				AddAllocation(map.get("Allocation"));
				log("STEP 11: User can enter Allocation ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User cannot enter Allocation", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				AddCheckNumber(map.get("CheckNumber"));
				log("STEP 12: User can enter Check Number ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User cannot enter Check Number", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			
			try {
			    AddCheckDate(map.get("CheckDate"));
				log("STEP 13: User can enter Check Date ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: User cannot enter Check Date", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}

			try {
				ClickOnSaveButton();
				log("STEP 14: User can save the details in Removal Reimbursement Popup ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: User cannot save the details in Removal Reimbursement Popup", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			try {
				 By totalAmount = By.xpath("//td[contains(text(),'Total Reimbursement')]//*[text()='$ "+map.get("PaymentAmount")+"']");
				 Assert.assertTrue(util.isElementVisible(totalAmount));
				log("STEP 15: User can see correct Total Reimbursement value ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 15: User cannot see correct Total Reimbursement value ", Status.FAIL);
			}
			
			try {
				ClosePopUp();
				util.reloadPage();
				util.waitUntilPageLoad();
				ExpandRemovalReimbursement();
				log("STEP 16: User can close the Removal Reimbursement Popup ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16: User cannot close the Removal Reimbursement Popup", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
			
			try {
				 By totalAmount = By.xpath("//tr[contains(@id,'_ISSUEREMOVALREIMBURSEMENT_radYALGridControl')]/..//*[text()=' $"+map.get("PaymentAmount")+".00']");
				 Assert.assertTrue(util.isElementVisible(totalAmount));
				log("STEP 17: User can see correct Total to be reimbursed value in the grid view ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 17: User cannot see correct Total to be reimbursed value in the grid view ", Status.FAIL);
			}
			
			try {
				 By landownerAmount = By.xpath("(//tr[contains(@id,'_ISSUEREMOVALREIMBURSEMENT_radYALGridControl')]/..//*[contains(normalize-space(),'"+map.get("Payee")+" - $"+map.get("PaymentAmount")+".00')])[last()]");
				 Assert.assertTrue(util.isElementVisible(landownerAmount));
				log("STEP 18: User can see correct Payee Name and Amount in the grid view ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 18: User cannot see correct Payee Name and Amount in the grid view ", Status.FAIL);
			}
			
			try {
				 By status = By.xpath("//tr[contains(@id,'_ISSUEREMOVALREIMBURSEMENT_radYALGridControl')]/..//*[text()='Pending']");
				 Assert.assertTrue(util.isElementVisible(status));
				log("STEP 19: User can see Reimbursement in Pending Status ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 19: User cannot see Reimbursement in Pending Status ", Status.FAIL);
			}
			
			try {
				 By paymentBreakdown = By.xpath("(//tr[contains(@id,'_ISSUEREMOVALREIMBURSEMENT_radYALGridControl')]/..//*[contains(normalize-space(),'"+map.get("PaymentFor")+" "+map.get("PaymentAmount")+".00')])[last()]");
				 Assert.assertTrue(util.isElementVisible(paymentBreakdown));
				log("STEP 20: User can see correct Payment Breakdown in the grid view ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 20: User cannot see correct Payment Breakdown in the grid view ", Status.FAIL);
			}
	 }
	 
	 
	 
	 public void EditReimbursementDetails(String testcaseName) {
			
			try {
				ClickOnEdit();
				log("STEP 1: User can click on Edit Link ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot click on Edit Link", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			try {
				MaximizePopUp();
				switchToIframe();
				log("STEP 2: User can Maximize Popup ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot Maximize Popup", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

			try {
				ClickOnSubmitButton();
				log("STEP 3: User can Submit the details in Removal Reimbursement Popup ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot Submit the details in Removal Reimbursement Popup", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}

			try {
				Assert.assertTrue(util.isElementVisible(submittedMessage));
				log("STEP 4: User can see success message ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 4: User cannot see success message", Status.FAIL);
			}
			
			try {
				ClosePopUp();
				util.reloadPage();
				util.waitUntilPageLoad();
				ExpandRemovalReimbursement();
				log("STEP 5: User can close the Removal Reimbursement Popup ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot close the Removal Reimbursement Popup", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				 By status = By.xpath("//tr[contains(@id,'_ISSUEREMOVALREIMBURSEMENT_radYALGridControl')]/..//*[text()='Request Submitted']");
				 Assert.assertTrue(util.isElementVisible(status));
				log("STEP 6: User can see Reimbursement in Request Submitted Status ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 6: User cannot see Reimbursement in Request Submitted Status ", Status.FAIL);
			}
	 }
  	
}
