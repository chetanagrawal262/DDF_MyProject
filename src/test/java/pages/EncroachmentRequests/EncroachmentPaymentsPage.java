package pages.EncroachmentRequests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class EncroachmentPaymentsPage extends BasePage{

	
	TestUtil util;
	CommonFunction commonFunction;
	public static String ALLOCATION, PAYMENT_METHOD, ORIGINAL_EFFECTIVE_DATE, RENTAL_EFFECTIVE_DATE, ORIGINAL_BASE_AMOUNT, RENTAL_BASE_AMOUNT, ORIGINAL_GST_AMOUNT, RENTAL_GST_AMOUNT;

	public EncroachmentPaymentsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	//Encroachment Payments grid
	By navEncroachmentPayments = By.xpath("//span[text()='Encroachment Payments']");
	By btnAddNewRecord = By.xpath("//a[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl_ctl00_ctl02_ctl00_lnkAddNewRecord')]");
	By txtFileNo = By.xpath("//input[contains(@id,'_EditFormControl_File_No') and @type='text']");
	By txtLeaseAcres = By.xpath("//input[contains(@id,'_EditFormControl_NET_ACRES') and @type='text']");
	By drpUnits = By.xpath("//input[contains(@id,'_EditFormControl_Acres_UNIT_ID_radYALDropDownList_Input') and @type='text']");
	By drpPaymentFrequency = By.xpath("//input[contains(@id,'_EditFormControl_PAYMENT_FREQUENCY_ID_radYALDropDownList_Input') and @type='text']");
	By txtEffectiveDate = By.xpath("//input[contains(@id,'_EditFormControl_EXTENSION_DATE_dateInput') and @type='text']");
	By txtExpirationDate = By.xpath("//input[contains(@id,'_EditFormControl_EXTENSION_EXPIRAITION_dateInput') and @type='text']");
	By txtRenewalDate = By.xpath("//input[contains(@id,'_EditFormControl_Renewal_Date_dateInput') and @type='text']");
	By txtGSTRegNo = By.xpath("//input[contains(@id,'_EditFormControl_GST_RegNo') and @type='text']");
	By checkboxAutoRenewal = By.xpath("//input[contains(@id,'_EditFormControl_Automatic_Renew') and @type='checkbox']");
	By txtFirstDate = By.xpath("//input[contains(@id,'_EditFormControl_First_Payment_Date_dateInput') and @type='text']");
	By txtLastDate = By.xpath("//input[contains(@id,'_EditFormControl_Last_Payment_Date_dateInput') and @type='text']");
	By txtPreviousAmount = By.xpath("//input[contains(@id,'_EditFormControl_PREVIOUS_RENTAL') and @type='text']");
	By txtBaseAmount = By.xpath("//input[contains(@id,'EditFormControl_Base_Payment') and @type='text']");
	By txtGSTAmount = By.xpath("//input[contains(@id,'_EditFormControl_GST_Amount') and @type='text']");
	By txtRentReviewDate = By.xpath("//input[contains(@id,'_EditFormControl_Rent_Review_Date_dateInput') and @type='text']");
	By txtNextReviewDate = By.xpath("//input[contains(@id,'_EditFormControl_Next_Review_Date_dateInput') and @type='text']");
	By txtLastTitleDate = By.xpath("//input[contains(@id,'_EditFormControl_Ownership_last_Updated_dateInput') and @type='text']");
	By txtAllocation = By.xpath("//input[contains(@id,'_EditFormControl_rptPayees_ctl01_txtPercent') and @type='text']");
	By drpPaymentMethod = By.xpath("//input[contains(@id,'_EditFormControl_rptPayees_ctl01_Payment_type_ID_radYALDropDownList_Input') and @type='text']");
	By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert')]");
	By changesSavedSuccessfully = By.xpath("//span[contains(@id,'RECURRING_PAYMENTS_usrMessage') and text()='Changes saved successfully!']");
	By btnEdit = By.xpath("//input[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl_ctl00_ctl04_EditButton')]");
	By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate')]");
	
   //Record Payment
    By linkRecordPayment = By.xpath("//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//a[text()='Record Payment']");
    By iframeRecurringPayment = By.xpath("//iframe[@name='CheckRecurringPayment']");
	By txtBackRent = By.xpath("//input[@id='Back_Rent' and @type='text']");
	By txtBaseAmountPopup = By.xpath("//input[@id='Base_Amount' and @type='text']");
	By txtGSTAmountPopup = By.xpath("//input[@id='GST_Amount' and @type='text']");
	By txtDueDate = By.xpath("//input[@id='Due_Date_dateInput' and @type='text']");
	By drpStatus = By.xpath("//input[@id='STATUS_ID_radYALDropDownList_Input' and @type='text']");
	By drpPaymentSource = By.xpath("//input[@id='Payment_Source_ID_radYALDropDownList_Input' and @type='text']");
	By txtCommnets = By.xpath("//textarea[@id='DESCRIPTION']");
	By btnSavePopup = By.xpath("//input[@id='btnSave1']");
	By successMsg = By.xpath("//span[@id='usrMessage' and text()='Changes saved successfully']");
	By tabPaymentHistory = By.xpath("//span[text()='Payment History']");
	By btnRefreshPaymentHistory = By.xpath("//a[@id='RECURRING_PAYMENTS_HIST_radYALGridControl_ctl00_ctl02_ctl00_Button1']");
	By btnClose = By.xpath("//a[@title='Close']");
	By linkViewDetails = By.xpath("//a[text()='View Details']");
	
	//Rental Review
	 By linkRentalReview = By.xpath("//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//a[text()='Rental Review']");
	 By iframeRentalPayment = By.xpath("//iframe[@name='RentalPayment']");
	 By txtReviewDate = By.xpath("//input[@id='REVIEW_DATE_dateInput' and @type='text']");
	 By txtEffectiveDatePopup = By.xpath("//input[@id='Effective_Date_dateInput' and @type='text']");
	 By txtComments = By.xpath("//textarea[@id='Comments']");
	 By tabReviewHistory = By.xpath("//span[text()='Review History']");
	 By btnRefreshReviewHistory = By.xpath("//a[@id='RENT_REVIEW_HIST_radYALGridControl_ctl00_ctl02_ctl00_Button1']");
	 
	//Rental Note
     By linkAddNotes = By.xpath("//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//a[text()='Add Notes']");
	 By iframeRentalNote = By.xpath("//iframe[@name='RentalNote']");
	 By txtActivityDate = By.xpath("//input[@id='Activity_Date_dateInput' and @type='text']");
	 By tabCommentsHistory = By.xpath("//span[text()='Comments History']");
	 By btnRefreshCommentsHistory = By.xpath("//a[@id='RENT_REVIEW_COMMENTS_radYALGridControl_ctl00_ctl02_ctl00_Button1']");
	
	public void ExpandEncroachmentPayments() {
		util.waitUntilElementDisplay(navEncroachmentPayments);
		util.click(navEncroachmentPayments);
	}
	
	public void ClickonAddNewRecord() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.waitUntilLoaderDisappear();
	}
	
	public void AddFileNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFileNo, value);
	}

	public void AddLeaseAcres(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLeaseAcres, value);
	}

	public void SelectUnits(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpUnits, value);
	}

	public void SelectPaymentFrequency(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPaymentFrequency, value);
	}

	public void SetEffectiveDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEffectiveDate, value);
	}

	public void SetExpirationDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExpirationDate, value);
	}

	public void SetRenewalDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtRenewalDate, value);
	}

	public void SetGSTRegNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGSTRegNo, value);
	}

	public void SetAutoRenewal() {
		util.waitUntilElementDisplay(checkboxAutoRenewal);
		util.click(checkboxAutoRenewal);
	}

	public void SetFirstPaymentDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFirstDate, value);
	}

	public void SetLastPaymentDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLastDate, value);
	}

	public void SetPreviousAmount(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPreviousAmount, value);
	}

	public void SetBaseAmount(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtBaseAmount, value);
	}

	public void SetGSTAmount(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGSTAmount, value);
	}

	public void SetRentReviewDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtRentReviewDate, value);
	}

	public void SetNextReviewDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtNextReviewDate, value);
	}

	public void SetLastTitleDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLastTitleDate, value);
	}

	public void SetAllocation(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAllocation, value);
	}

	public void SelectPaymentMethod(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPaymentMethod, value);
	}

	public void ClickonInsert() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilLoaderDisappear();
	}
	
	public void ClickEdit() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.waitUntilLoaderDisappear();
	}

	public void ClickUpdate() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.waitUntilLoaderDisappear();
	}

	// ===== Record Payments - Fields & History =====
	public void ClickRecordPayment() {
		util.waitUntilElementDisplay(linkRecordPayment);
		util.click(linkRecordPayment);
		util.dummyWait(2);
	}

	public void SwitchToRecurringPaymentFrame() {
		util.switchToIframe(iframeRecurringPayment);
	}

	public void SetBackRent(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtBackRent, value);
	}

	public void SetBaseAmountPopup(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtBaseAmountPopup, value);
	}

	public void SetGSTAmountPopup(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtGSTAmountPopup, value);
	}

	public void SetDueDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDueDate, value);
	}

	public void SelectStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatus, value);
	}

	public void SelectPaymentSource(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpPaymentSource, value);
	}

	public void SetCommentsInRecordPayment(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCommnets, value);
	}

	public void ClickSavePaymentPopup() {
		util.waitUntilElementDisplay(btnSavePopup);
		util.click(btnSavePopup);
		util.dummyWait(2);
	}

	public void NavigatePaymentHistoryTab() {
		util.waitUntilElementDisplay(tabPaymentHistory);
		util.click(tabPaymentHistory);
	}

	public void RefreshPaymentHistory() {
		util.waitUntilElementDisplay(btnRefreshPaymentHistory);
		util.click(btnRefreshPaymentHistory);
		util.dummyWait(1);
	}

	public void ClickViewDetails() {
		util.waitUntilElementDisplay(linkViewDetails);
		util.click(linkViewDetails);
		util.dummyWait(1);
	}
	
	public void ClickClosePopup() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
	}

	// ===== Rental Review - Fields & History =====
	public void ClickRentalReview() {
		util.waitUntilElementDisplay(linkRentalReview);
		util.click(linkRentalReview);
		util.dummyWait(2);
	}

	public void SwitchToRentalPaymentFrame() {
		util.switchToIframe(iframeRentalPayment);
	}

	public void SetReviewDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtReviewDate, value);
	}

	public void SetEffectiveDateInReview(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEffectiveDatePopup, value);
	}

	public void SetReviewComments(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComments, value);
	}

	public void NavigateReviewHistoryTab() {
		util.waitUntilElementDisplay(tabReviewHistory);
		util.click(tabReviewHistory);
		util.dummyWait(1);
	}

	public void RefreshReviewHistory() {
		util.waitUntilElementDisplay(btnRefreshReviewHistory);
		util.click(btnRefreshReviewHistory);
		util.dummyWait(1);
	}

	// ===== Rental Notes - Fields & History =====
	public void ClickAddNotes() {
		util.waitUntilElementDisplay(linkAddNotes);
		util.click(linkAddNotes);
		util.dummyWait(2);
	}

	public void SwitchToRentalNoteFrame() {
		util.switchToIframe(iframeRentalNote);
	}

	public void SetActivityDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtActivityDate, value);
	}

	public void NavigateCommentsHistoryTab() {
		util.waitUntilElementDisplay(tabCommentsHistory);
		util.click(tabCommentsHistory);
		util.dummyWait(1);
	}

	public void RefreshCommentsHistory() {
		util.waitUntilElementDisplay(btnRefreshCommentsHistory);
		util.click(btnRefreshCommentsHistory);
		util.dummyWait(1);
	}

	public void AddEncroachmentPaymentRecord(Map<String, String> map, String testcaseName) {

		try {
			ExpandEncroachmentPayments();
			log("STEP 1: User can expand the Encroachment Payments Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand the Encroachment Payments Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			ClickonAddNewRecord();
			log("STEP 2: User can click on Add New record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Add New record button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			AddFileNo(map.get("FileNo"));
			log("STEP 3: User can enter File No", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot enter File No", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			AddLeaseAcres(map.get(Excel.LeasedAcres));
			log("STEP 4: User can enter Lease Acres", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter Lease Acres", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			SelectUnits(map.get(Excel.Units));
			log("STEP 5: User can select Units", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select Units", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			SelectPaymentFrequency(map.get("PaymentFrequency"));
			log("STEP 6: User can select Payment Frequency", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select Payment Frequency", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			SetEffectiveDate(map.get(Excel.EffectiveDate));
			ORIGINAL_EFFECTIVE_DATE =map.get(Excel.EffectiveDate);
			log("STEP 7: User can set Effective Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot set Effective Date", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			SetExpirationDate(map.get(Excel.ExpirationDate));
			log("STEP 8: User can set Expiration Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot set Expiration Date", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}

		try {
			SetRenewalDate(map.get("RenewableDate"));
			log("STEP 9: User can set Renewal Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot set Renewal Date", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

		try {
			SetGSTRegNo(map.get("GSTRegNo"));
			log("STEP 10: User can set GST Registration Number", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot set GST Registration Number", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		try {
             SetAutoRenewal();
			log("STEP 11: User can set Auto Renewal", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot set Auto Renewal", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}

		try {
			SetFirstPaymentDate(map.get(Excel.FirstPaymentDate));
			log("STEP 12: User can set First Payment Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot set First Payment Date", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}

		try {
			SetLastPaymentDate(map.get(Excel.LastPaymentDate));
			log("STEP 13: User can set Last Payment Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot set Last Payment Date", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}

		try {
			SetPreviousAmount(map.get("PreviousAmount"));
			log("STEP 14: User can set Previous Amount", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot set Previous Amount", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}

		try {
			SetBaseAmount(map.get("BaseAmount"));
			ORIGINAL_BASE_AMOUNT =map.get("BaseAmount");
			log("STEP 15: User can set Base Amount", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: User cannot set Base Amount", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}

		try {
			SetGSTAmount(map.get("GSTAmount"));
			ORIGINAL_GST_AMOUNT =map.get("GSTAmount");
			log("STEP 16: User can set GST Amount", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot set GST Amount", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		try {
			SetRentReviewDate(map.get("RentReviewDate"));
			log("STEP 17: User can set Rent Review Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot set Rent Review Date", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}

		try {
			SetNextReviewDate(map.get("NextReviewDate"));
			log("STEP 18: User can set Next Review Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: User cannot set Next Review Date", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}

		try {
			SetLastTitleDate(util.getCurrentDateTime("M/d/yyyy"));
			log("STEP 19: User can set Last Title Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: User cannot set Last Title Date", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}

		try {
			SetAllocation(map.get("Allocation"));
			ALLOCATION=map.get("Allocation");
			log("STEP 20: User can set Allocation", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: User cannot set Allocation", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}

		try {
			SelectPaymentMethod(map.get(Excel.PaymentMethod));
			PAYMENT_METHOD=map.get(Excel.PaymentMethod);
			log("STEP 21: User can select Payment Method", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: User cannot select Payment Method", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}

		try {
			ClickonInsert();
			log("STEP 22: User can click on Insert button", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: User cannot click on Insert button", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}

		try {
			Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
			log("STEP 23: User can see 'Changes saved successfully!' message", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 23: User cannot see 'Changes saved successfully!' message", Status.FAIL);	
		}
		
		try {
			By fileNo = By.xpath("(//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//td[text()='"+map.get("FileNo")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(fileNo));
			log("STEP 24: User can see added File No in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 24: User cannot see added File No in the grid view", Status.FAIL);	
		}	
		
		try {
			String inputDate = map.get(Excel.EffectiveDate);
			String formattedDate="";
	        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
	        SimpleDateFormat outputFormat = new SimpleDateFormat("d/M/yyyy"); 
	        try {
	        Date date = inputFormat.parse(inputDate);
	        formattedDate= outputFormat.format(date);
		 } catch (ParseException e) {
	            e.printStackTrace();
	        }
			By effectiveDate = By.xpath("(//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//td[contains(text(),'"+formattedDate+"')])[1]");
			Assert.assertTrue(util.isElementVisible(effectiveDate));
			log("STEP 25: User can see added Effective Date in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 25: User cannot see added Effective Date in the grid view", Status.FAIL);	
		}

		try {
			By expirationDate = By.xpath("(//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//td[contains(text(),'"+map.get(Excel.ExpirationDate)+"')])[1]");
			Assert.assertTrue(util.isElementVisible(expirationDate));
			log("STEP 26: User can see added Expiration Date in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 26: User cannot see added Expiration Date in the grid view", Status.FAIL);	
		}
		
		try {
			By baseAmount = By.xpath("(//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//td[contains(text(),'"+map.get("BaseAmount")+"')])[1]");
			Assert.assertTrue(util.isElementVisible(baseAmount));
			log("STEP 27: User can see added Base Amount in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 27: User cannot see added Base Amount in the grid view", Status.FAIL);	
		}
		
		try {
			By gstAmount = By.xpath("(//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//td[contains(text(),'"+ map.get("GSTAmount") + "')])[1]");
			Assert.assertTrue(util.isElementVisible(gstAmount));
			log("STEP 28: User can see added GST Amount in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 28: User cannot see added GST Amount in the grid view", Status.FAIL);
		}
	}

	public void recordPayment(Map<String, String> map, String testcaseName) {

		try {
			ClickRecordPayment();
			log("STEP 1: User can click 'Record Payment' link", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click 'Record Payment' link", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			SwitchToRecurringPaymentFrame();
			log("STEP 2: User can switch to 'Recurring Payment' iframe", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot switch to 'Recurring Payment' iframe", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			SetBackRent(map.get("BackRent"));
			log("STEP 3: User can enter Back Rent", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot enter Back Rent", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			SetBaseAmountPopup(map.get("BaseAmount"));
			log("STEP 4: User can enter Base Amount in popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter Base Amount in popup", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			SetGSTAmountPopup(map.get("GSTAmount"));
			log("STEP 5: User can enter GST Amount in popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot enter GST Amount in popup", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			SetDueDate(map.get(Excel.DueDate));
			log("STEP 6: User can set Due Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot set Due Date", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			SelectStatus(map.get(Excel.Status));
			log("STEP 7: User can select Status", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot select Status", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			SelectPaymentSource(map.get("PaymentSource"));
			log("STEP 8: User can select Payment Source", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot select Payment Source", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}

		try {
			SetCommentsInRecordPayment(map.get(Excel.Comments));
			log("STEP 9: User can enter Comments in Record Payment", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot enter Comments in Record Payment", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

		try {
			By landownerName = By.xpath("//*[@id='UpdatePanel1']//td[contains(text(),'"+map.get(Excel.Landowner)+"')]");
			Assert.assertTrue(util.isElementVisible(landownerName));
			log("STEP 10: User can see Landowner Name on the Record Payment Popup", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10: User cannot see Landowner Name on the Record Payment Popup", Status.FAIL);
		}
		
		try {
			By type = By.xpath("//*[@id='rptPayees_ctl01_lblType' and normalize-space()='Landowner']");
			Assert.assertTrue(util.isElementVisible(type));
			log("STEP 11: User can see Payee Type on the Record Payment Popup", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11: User cannot see Payee Type on the Record Payment Popup", Status.FAIL);
		}
		
		try {
			By allocation = By.xpath("//*[@id='rptPayees_ctl01_txtPercent' and @value='"+ALLOCATION+".00']");
			Assert.assertTrue(util.isElementVisible(allocation));
			log("STEP 12: User can see Allocation on the Record Payment Popup", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: User cannot see Allocation on the Record Payment Popup", Status.FAIL);
		}
		
		try {
			By paymentMethod = By.xpath("//*[@id='rptPayees_ctl01_Payment_type_ID_radYALDropDownList_Input' and @value='"+PAYMENT_METHOD+"']");
			Assert.assertTrue(util.isElementVisible(paymentMethod));
			log("STEP 13: User can see Payment Method on the Record Payment Popup", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 13: User cannot see Payment Method on the Record Payment Popup", Status.FAIL);
		}
		
		ExtentTestManager.infoWithScreenshot("Payment Details");
		try {
			ClickSavePaymentPopup();
			log("STEP 14: User can click Save on Record Payment popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot click Save on Record Payment popup", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}

		try {
			Assert.assertTrue(util.isElementVisible(successMsg));
			log("STEP 15: User can see 'Changes saved successfully' for Record Payment", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 15: User cannot see 'Changes saved successfully' for Record Payment", Status.FAIL);
		}

		try {
			NavigatePaymentHistoryTab();
			log("STEP 16: User can Navigate to Payment History tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot Navigate to Payment History tab", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		try {
			RefreshPaymentHistory();
			log("STEP 17: User can refresh Payment History", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot refresh Payment History", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}

		try {
			By dueDate = By.xpath("//tr[contains(@id,'RECURRING_PAYMENTS_HIST_radYALGridControl')]//td[text()='"+map.get(Excel.DueDate)+"']");
			Assert.assertTrue(util.isElementVisible(dueDate));
			log("STEP 18: User can see added Due Date in the Payment History Grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 18: User cannot see added Due Date in the Payment History Grid", Status.FAIL);
		}
		
		try {
			By amount = By.xpath("//tr[contains(@id,'RECURRING_PAYMENTS_HIST_radYALGridControl')]//td[text()='"+map.get("Amount")+"']");
			Assert.assertTrue(util.isElementVisible(amount));
			log("STEP 19: User can see added Amount in the Payment History Grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 19: User cannot see added Amount in the Payment History Grid", Status.FAIL);
		}
		
		try {
			By status = By.xpath("//tr[contains(@id,'RECURRING_PAYMENTS_HIST_radYALGridControl')]//td[text()='"+map.get("Status")+"']");
			Assert.assertTrue(util.isElementVisible(status));
			log("STEP 20: User can see added Status in the Payment History Grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 20: User cannot see added Status in the Payment History Grid", Status.FAIL);
		}
		
		ExtentTestManager.infoWithScreenshot("Payment History");
		
		try {
			ClickViewDetails();
			log("STEP 21: User can click on View Details Link", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: User cannot click on View Details Link", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}

		try {
			By backRent = By.xpath("//input[contains(@id,'Back_Rent') and @value='"+map.get("BackRent")+".00']");
			Assert.assertTrue(util.isElementVisible(backRent));
			log("STEP 22: User can see the payment Details", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 22: User cannot see the payment Details", Status.FAIL);
		}
		
		try {
			ClickClosePopup();
			log("STEP 23: User can close Record Payment popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: User cannot close Record Payment popup", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}

	}
	
	
	public void rentalReview(Map<String, String> map, String testcaseName) {

		try {
			util.reloadPage();
			util.waitUntilPageLoad();
			ExpandEncroachmentPayments();
			log("STEP 1: User can Expand Encroachment Payments Grid", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Expand Encroachment Payments Grid", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			ClickRentalReview();
			log("STEP 2: User can click 'Rental Review' link", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click 'Rental Review' link", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			SwitchToRentalPaymentFrame();
			log("STEP 3: User can switch to 'Rental Payment' iframe", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot switch to 'Rental Payment' iframe", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			SetReviewDate(map.get("ReviewDate"));
			log("STEP 4: User can set Review Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot set Review Date", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			SetEffectiveDateInReview(map.get("ReviewEffectiveDate"));
			RENTAL_EFFECTIVE_DATE =map.get("ReviewEffectiveDate");
			log("STEP 5: User can set Effective Date in Review", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot set Effective Date in Review", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			SetBackRent(map.get("BackRent"));
			log("STEP 6: User can enter Back Rent", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot enter Back Rent", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			SetBaseAmountPopup(map.get("BaseAmount"));
			RENTAL_BASE_AMOUNT =map.get("BaseAmount");
			log("STEP 7: User can enter Base Amount in popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot enter Base Amount in popup", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			SetGSTAmountPopup(map.get("GSTAmount"));
			RENTAL_GST_AMOUNT =map.get("GSTAmount");
			log("STEP 8: User can enter GST Amount in popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot enter GST Amount in popup", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			SetReviewComments(map.get("ReviewComments"));
			log("STEP 9: User can enter Review Comments", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot enter Review Comments", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}

		ExtentTestManager.infoWithScreenshot("Review Details");
		try {
			ClickSavePaymentPopup();
			log("STEP 10: User can click Save on Review Payment popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot click Save on Review Payment popup", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

		try {
			Assert.assertTrue(util.isElementVisible(successMsg));
			log("STEP 11: User can see 'Changes saved successfully' for Review Payment", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11: User cannot see 'Changes saved successfully' for Review Payment", Status.FAIL);
		}
		
		try {
			NavigateReviewHistoryTab();
			log("STEP 12: User can navigate to Review History tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot navigate to Review History tab", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}

		try {
			RefreshReviewHistory();
			log("STEP 13: User can refresh Review History", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot refresh Review History", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			By originalComment = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='Original Rental']");
			Assert.assertTrue(util.isElementVisible(originalComment));
			log("STEP 14: User can see Original Rental Comment in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 14: User cannot see Original Rental Comment in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By originalEffectiveDate = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='"+ORIGINAL_EFFECTIVE_DATE+"']");
			Assert.assertTrue(util.isElementVisible(originalEffectiveDate));
			log("STEP 15: User can see Original Effective Date in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 15: User cannot see Original Effective Date in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By originalBackRent = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='N/A']");
			Assert.assertTrue(util.isElementVisible(originalBackRent));
			log("STEP 16: User can see Original Back Rent as 'N/A' in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 16: User cannot see Original Back Rent as 'N/A' in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By originalBaseAmount = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='$"+ORIGINAL_BASE_AMOUNT+".00']");
			Assert.assertTrue(util.isElementVisible(originalBaseAmount));
			log("STEP 17: User can see Original Base Amount in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 17: User cannot see Original Base Amount in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By originalGSTAmount = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='$"+ORIGINAL_GST_AMOUNT+".00']");
			Assert.assertTrue(util.isElementVisible(originalGSTAmount));
			log("STEP 18: User can see Original GST Amount in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 18: User cannot see Original GST Amount in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By originalTotalAmount = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='$"+map.get("OriginalTotalAmount")+".00']");
			Assert.assertTrue(util.isElementVisible(originalTotalAmount));
			log("STEP 18: User can see Original Total Amount in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 18: User cannot see Original Total Amount in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By rentalComment = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='"+map.get("ReviewComments")+"']");
			Assert.assertTrue(util.isElementVisible(rentalComment));
			log("STEP 19: User can see Rental Payment Comment in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 19: User cannot see Rental Payment Comment in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By rentalEffectiveDate = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='"+RENTAL_EFFECTIVE_DATE+"']");
			Assert.assertTrue(util.isElementVisible(rentalEffectiveDate));
			log("STEP 20: User can see Rental Effective Date in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 20: User cannot see Rental Effective Date in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By rentalBackRent = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='$"+map.get("BackRent")+".00']");
			Assert.assertTrue(util.isElementVisible(rentalBackRent));
			log("STEP 21: User can see Rental Back Rent in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 21: User cannot see Rental Back Rent in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By rentalBaseAmount = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='$"+RENTAL_BASE_AMOUNT+".00']");
			Assert.assertTrue(util.isElementVisible(rentalBaseAmount));
			log("STEP 22: User can see Rental Base Amount in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 22: User cannot see Rental Base Amount in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By rentalGSTAmount = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='$"+RENTAL_GST_AMOUNT+".00']");
			Assert.assertTrue(util.isElementVisible(rentalGSTAmount));
			log("STEP 23: User can see Rental GST Amount in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 23: User cannot see Rental GST Amount in the Review History Grid View", Status.FAIL);
		}
		
		try {
			By rentalTotalAmount = By.xpath("//tr[contains(@id,'RENT_REVIEW_HIST_radYALGridControl')]//td[text()='$"+map.get("RentalTotalAmount")+".00']");
			Assert.assertTrue(util.isElementVisible(rentalTotalAmount));
			log("STEP 24: User can see Rental Total Amount in the Review History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 24: User cannot see Rental Total Amount in the Review History Grid View", Status.FAIL);
		}
		
		ExtentTestManager.infoWithScreenshot("Review History");
		
		try {
			ClickClosePopup();
			log("STEP 24: User can close Review Payment popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 24: User cannot close Review Payment popup", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		
		try {
			util.reloadPage();
			util.waitUntilPageLoad();
			ExpandEncroachmentPayments();
			log("STEP 25: User can Expand Encroachment Payments Grid", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: User cannot Expand Encroachment Payments Grid", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
		
		try {
			By baseAmount = By.xpath("(//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//td[contains(text(),'"+RENTAL_BASE_AMOUNT+"')])[1]");
			Assert.assertTrue(util.isElementVisible(baseAmount));
			log("STEP 26: User can see updated Base Amount in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 26: User cannot see updated Base Amount in the grid view", Status.FAIL);	
		}
		
		try {
			By gstAmount = By.xpath("(//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//td[contains(text(),'"+RENTAL_GST_AMOUNT + "')])[1]");
			Assert.assertTrue(util.isElementVisible(gstAmount));
			log("STEP 27: User can see updated GST Amount in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 27: User cannot see updated GST Amount in the grid view", Status.FAIL);
		}
		
		try {
			By reviewDate = By.xpath("(//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//td[contains(text(),'"+map.get("ReviewDate") + "')])[1]");
			Assert.assertTrue(util.isElementVisible(reviewDate));
			log("STEP 28: User can see Review Date in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 28: User cannot see Review Date in the grid view", Status.FAIL);
		}

	}
	
	
	public void reviewComments(Map<String, String> map, String testcaseName) {

		try {
			ClickAddNotes();
			log("STEP 1: User can click 'Add Notes' link", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click 'Add Notes' link", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			SwitchToRentalNoteFrame();
			log("STEP 2: User can switch to 'Rental Note' iframe", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot switch to 'Rental Note' iframe", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			SetActivityDate(map.get("ActivityDate"));
			log("STEP 3: User can set Activity Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot set Activity Date", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			SetReviewComments(map.get("ReviewComments"));
			log("STEP 4: User can enter Review Comments", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter Review Comments", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		ExtentTestManager.infoWithScreenshot("Review Comments");
		try {
			ClickSavePaymentPopup();
			log("STEP 5: User can click Save on Review Comments popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click Save on Review Comments popup", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			Assert.assertTrue(util.isElementVisible(successMsg));
			log("STEP 6: User can see 'Changes saved successfully' for Review Comments", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: User cannot see 'Changes saved successfully' for Review Comments", Status.FAIL);
		}
		
		try {
			NavigateCommentsHistoryTab();
			log("STEP 7: User can navigate to Comments History tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot navigate to Comments History tab", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			RefreshCommentsHistory();
			log("STEP 8: User can refresh Comments History", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot refresh Comments History", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			By activityDate = By.xpath("//tr[contains(@id,'RENT_REVIEW_COMMENTS_radYALGridControl')]//td[text()='"+map.get("ActivityDate")+"']");
			Assert.assertTrue(util.isElementVisible(activityDate));
			log("STEP 9: User can see Activity Date in the Comments History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9: User cannot see Activity Date in the Comments History Grid View", Status.FAIL);
		}
		
		try {
			By activityDate = By.xpath("//tr[contains(@id,'RENT_REVIEW_COMMENTS_radYALGridControl')]//td[text()='"+map.get("ReviewComments")+"']");
			Assert.assertTrue(util.isElementVisible(activityDate));
			log("STEP 10: User can see Review Comment in the Comments History Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10: User cannot see Review Comment in the Comments History Grid View", Status.FAIL);
		}
		
		ExtentTestManager.infoWithScreenshot("Comments History");
		
		try {
			ClickClosePopup();
			log("STEP 11: User can close Review Comments popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot close Review Comments popup", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			util.reloadPage();
			util.waitUntilPageLoad();
			ExpandEncroachmentPayments();
			log("STEP 12: User can Expand Encroachment Payments Grid", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot Expand Encroachment Payments Grid", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			By reviewComments = By.xpath("(//tr[contains(@id,'_RECURRING_PAYMENTS_radYALGridControl')]//td[text()='"+map.get("ReviewComments")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(reviewComments));
			log("STEP 13: User can see updated Review Comments in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 13: User cannot see updated Review Comments in the grid view", Status.FAIL);	
		}

	}
}
