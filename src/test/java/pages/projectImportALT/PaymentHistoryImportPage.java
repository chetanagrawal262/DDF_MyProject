package pages.projectImportALT;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class PaymentHistoryImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	Map<String, String> map = new HashMap<String, String>();
	
	public PaymentHistoryImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}
	
	By agreementNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Lease Number: ']/..//input[contains(@id,'Dest_Input')] |(//input[contains(@id,'Lease_Number') and @type='text'])[2]");
	public String getAgreementNumber() {
		
		return util.getAttributeValue(agreementNumber, "value");
	}
	
	By typeofPayment = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Type of Payment: ']/..//input[contains(@id,'Dest_Input')]");
	public String getTypeOfPaymentMapping() {
		return util.getAttributeValue(typeofPayment, "value");
	}
	
	By txtTypeofPayment = By.xpath("//*[contains(text(),'Type of Payment')]/..//input[@type='text']");
	public String getTextTypeOfPayment() {
		return util.getAttributeValue(txtTypeofPayment, "value");
	}
	
	By agreementPhase = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agreement Phase: ']/..//input[contains(@id,'Dest_Input')] | //*[text()='Agreement Phase:']/..//input[@type='text']");
	public String getAgreementPhase() {
		return util.getAttributeValue(agreementPhase, "value");
	}
	
	By dueDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Due Date: ']/..//input[contains(@id,'Dest_Input')] | (//*[text()='Due Date:']/..//input[contains(@id,'dateInput')])[1]");
	public String getDueDate() {
		return util.getAttributeValue(dueDate, "value");
	}
	
	By payee = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Payee: ']/..//input[contains(@id,'Dest_Input')] | //*[text()='Distribution:']/..//input[@type='text']");
	public String getPayee() {
		return util.getAttributeValue(payee, "value");
	}
	
	By checkNo = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Check No.: ']/..//input[contains(@id,'Dest_Input')]");
	public String getCheckNo() {
		return util.getAttributeValue(checkNo, "value");
	}
	
	By checkAmount = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Check Amount: ']/..//input[contains(@id,'Dest_Input')] | //*[text()='Payment Amount:']/..//input[@type='text']");
	public String getCheckAmount() {
		return util.getAttributeValue(checkAmount, "value");
	}
	
	By checkDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Check Date: ']/..//input[contains(@id,'Dest_Input')]");
	public String getCheckDate() {
		return util.getAttributeValue(checkDate, "value");
	}
	
	By status = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Status: ']/..//input[contains(@id,'Dest_Input')]");
	public String getStatus() {
		return util.getAttributeValue(status, "value");
	}
	
	By comments = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Comments: ']/..//input[contains(@id,'Dest_Input')] | //*[text()='Remarks:']/..//textarea");
	public String getComments() {
		return util.getAttributeValue(comments, "value");
	}
	
	By amountDue = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Amount Due: ']/..//input[contains(@id,'Dest_Input')]");
	public String getAmountDue() {
		return util.getAttributeValue(amountDue, "value");
	}
	
	Map<String, String> excelData;
	public void PaymentHistoryMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.PaymentHistoryMapping, testcaseName);
				
				assertion.assertEquals(getAgreementNumber(), excelData.get("Lease Number").trim(), "Lease Number mapping mismatched");
				ExtentTestManager.log("Lease Number Mapping : "+getAgreementNumber());
				
				assertion.assertEquals(getTypeOfPaymentMapping(), excelData.get("Type of Payment").trim(), "Type of Payment mapping mismatched");
				ExtentTestManager.log("Type of Payment Mapping : "+getTypeOfPaymentMapping());
				
				assertion.assertEquals(getAgreementPhase(), excelData.get("Agreement Phase").trim(), "Agreement Phase mapping mismatched");
				ExtentTestManager.log("Agreement Phase Mapping : "+getAgreementPhase());
				
				assertion.assertEquals(getDueDate(), excelData.get("Due Date").trim(), "Due Date mapping mismatched");
				ExtentTestManager.log("Due Date Mapping : "+getDueDate());
				
				assertion.assertEquals(getPayee(), excelData.get("Payee").trim(), "Payee mapping mismatched");
				ExtentTestManager.log("Payee Mapping : "+getPayee());
				
				assertion.assertEquals(getCheckNo(), excelData.get("Check No").trim(), "Check No mapping mismatched");
				ExtentTestManager.log("Check No Mapping : "+getCheckNo());
				
				assertion.assertEquals(getCheckAmount(), excelData.get("Check Amount").trim(), "Check Amount mapping mismatched");
				ExtentTestManager.log("Check Amount Mapping : "+getCheckAmount());
				
				assertion.assertEquals(getCheckDate(), excelData.get("Check Date").trim(), "Check Date mapping mismatched");
				ExtentTestManager.log("Check Date Mapping : "+getCheckDate());
				
				assertion.assertEquals(getStatus(), excelData.get("Status").trim(), "Status mapping mismatched");
				ExtentTestManager.log("Status Mapping : "+getStatus());
				
				assertion.assertEquals(getComments(), excelData.get("Comments").trim(), "Comments mapping mismatched");
				ExtentTestManager.log("Comments Mapping : "+getComments());
				
				assertion.assertEquals(getAmountDue(), excelData.get("Amount Due").trim(), "Amount Due mapping mismatched");
				ExtentTestManager.log("Amount Due Mapping : "+getAmountDue());
				
				assertion.assertAll();		
			
			}
    
	
	public void verifyPaymentHistoryMapping(Map<String, String> map, String testcaseName) throws Exception {
		objProjectImportPage.projectDataImport(map, testcaseName);
		try {
			PaymentHistoryMapping(testcaseName);
			log("STEP 7:  All Agreement Terms Mappings are correct", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(10);
		
	}
	
	By iframeWF = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By close = By.xpath("//a[@title='Close']");
	
	public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		
		ExtentTestManager.log("Verifying Imported Payment History Data for Agreement No "+map.get("Lease Number").trim());
		SoftAssert assertion = new SoftAssert();
		        
		By addedRecord = By.xpath("//td[text()='"+map.get("Lease Number").trim()+"']/parent::tr");
		Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
		util.click(addedRecord);

		if(!testcaseName.contains("ATWELL")) {
		By agreementNo = By.xpath("//td[contains(@id,'_tractInfo')]//td[normalize-space()='"+map.get("Lease Number")+"']");
		util.waitForWebElementToBePresent(agreementNo, IMPLICIT_WAIT);
		}
		
		assertion.assertEquals(getAgreementNumber(), map.get("Lease Number").trim(), "Lease Number mismatched");
		ExtentTestManager.log("Lease Number matched : " +getAgreementNumber());
		
		        By btnEdit = By.xpath("//*[text()='One Off Payment']/..//a[text()='Edit']");
				util.waitUntilElementDisplay(btnEdit);
				util.click(btnEdit);
				util.switchToIframe(iframeWF);
				util.dummyWait(1);
		        assertion.assertEquals(getTextTypeOfPayment(), map.get("Type of Payment").trim(), "Type of Payment mismatched");
				ExtentTestManager.log("Type of Payment : "+getTextTypeOfPayment());
				
				assertion.assertEquals(getCheckAmount().replace(",", ""), map.get("Check Amount").trim().replace(",", ""), "Check Amount mismatched");
				ExtentTestManager.log("Check Amount : "+getCheckAmount());
				
				if(testcaseName.contains("ATWELL")) {
					assertion.assertEquals(getAgreementPhase().toUpperCase(), map.get("Agreement Phase").trim().toUpperCase(), "Agreement Phase mismatched");
					ExtentTestManager.log("Agreement Phase : "+getAgreementPhase());
				}else {
				assertion.assertEquals(getAgreementPhase(), map.get("Agreement Phase").trim(), "Agreement Phase mismatched");
				ExtentTestManager.log("Agreement Phase : "+getAgreementPhase());
				}
				
				assertion.assertEquals(getDueDate(), map.get("Due Date").trim(), "Due Date mismatched");
				ExtentTestManager.log("Due Date : "+getDueDate());
				
				assertion.assertEquals(getPayee(), map.get("Payee").trim(), "Payee mismatched");
				ExtentTestManager.log("Payee : "+getPayee());
				
				ExtentTestManager.infoWithScreenshot("Payment History validation");
			    util.switchToDefaultContent();
			    util.click(close);
				assertion.assertAll();
				log("All Imported Data Successfully matched");
			
	}
	
	
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			objErrorLog.printErrorLog(); 
	        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
		} catch (Exception t) {
			  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
			  throw new RuntimeException("Failed in step 12");
		}
		
        try {
			 
			  driver.close();
			  util.switchToParentWindow(); 
			  util.dummyWait(1);
	        log("STEP 14:  User can close the pop up", Status.PASS);
		} catch (Exception t) {
		
			  driver.close();
			  util.switchToParentWindow(); 
			  log("STEP 14:  User cannot close the pop up", Status.FAIL);
			  throw new RuntimeException("Failed in step 14");
		}
	}

}
