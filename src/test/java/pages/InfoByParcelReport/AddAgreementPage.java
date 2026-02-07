package pages.InfoByParcelReport;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddAgreementPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER, AGREEMENT_TITLE, AGREEMENT_TERM, EFFECTIVE_DATE, EXPIRATION_DATE;

	public AddAgreementPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navLeaseManager = By.xpath("//a//span[contains(text(),'Lease Manager')] ");
	By navAgreementInformation = By.xpath("//a//span[contains(text(),'Agreement Information')] | //a//span[contains(text(),'Entity Information')]");
	By pageTitle = By.xpath("//table[contains(@id,'LSLST_RadGridTracts')]//th//a[text()='Agreement Information']");
	By agreementNumber = By.xpath("//span[contains(@id,'_Lease_Number_wrapper')]/input[contains(@id,'_Lease_Number') and @type='text']");
	
	By agreementNumberPopUp = By.xpath("//span[contains(@id,'leaseInfo_Lease_Number')]/input[contains(@id,'leaseInfo_Lease_Number') and @type='text']");

	public void navigateToAgreementInformationALT() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.dummyWait(1);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navAgreementInformation);
		util.dummyWait(1);
	}
	
	public void navigateToAgreementInformationROW() {
		util.dummyWait(10);
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navLeaseManager);
		util.click(navLeaseManager);
	}

	By addButton = By.xpath("//table[contains(@id,'LSLST_RadGridTracts')]//a[contains(@id,'_AddJob')]");
	By assignOrModifyAgreementName = By.xpath("//a[contains(@id,'_changeEntName') and @href]");

	private void clickOnAddButton() {
		util.click(addButton);
		util.waitFor(2000);
		if(!util.isElementPresent(agreementFrame)) {
		util.waitUntilElementDisappear(assignOrModifyAgreementName);
		util.waitForWebElementToBePresent(agreementNumber, 10);
		}
	}

	private void addLeaseNumber(String value) {
		try {
			if (!commonFunction.checkNA(value)) {
				util.inputText(agreementNumber, value);
			}
		} catch (Exception e) { }
	}

	private void addLeaseNumberPopUp(String value) {
		try {
			if (!commonFunction.checkNA(value)) {
				util.inputText(agreementNumberPopUp, value);
			}
		} catch (Exception e) { }
	}
	
	By txtAgreementType1 = By.xpath("//input[contains(@id,'Lease_Type_ID') and @type='text']");
	By firstAgreementType = By.xpath("//div[contains(@id,'_Lease_Type_ID_radYALDropDownList_DropDown')]//li[1]");
	By txtAgreementType2 = By.xpath("//span/parent::div[contains(@id,'DOCUMENT_TYPE_ID')]");

	private void addAgreementType(String value) {
		if (!commonFunction.checkNA(value)) {
			if(util.isElementPresent(txtAgreementType1)) {
//				util.inputTextAndPressTab(txtAgreementType1, value);
				util.click(txtAgreementType1);
				util.click(firstAgreementType);
			} else if(util.isElementVisible(txtAgreementType2)) {
				util.selectValueFromDropdown(txtAgreementType2, value);
			}
		}
	}

	By txtAgreementTypePopUp1 = By.xpath("//input[contains(@id,'leaseInfo_Lease_Type_ID') and @type='text']");
	By firstAgreementTypePopUp1 = By.xpath("//div[contains(@id,'leaseInfo_Lease_Type_ID_radYALDropDownList_DropDown')]/..//li[1]");
	
	private void addAgreementTypePopUp(String value) {
		if (!commonFunction.checkNA(value)) {
			if(util.isElementPresent(txtAgreementTypePopUp1)) {
				//util.inputTextAndPressTab(txtAgreementTypePopUp1, value);
				util.click(txtAgreementTypePopUp1);
				util.click(firstAgreementTypePopUp1);
			} else if(util.isElementPresent(txtAgreementType2)) {
				util.selectValueFromDropdown3(txtAgreementType2, value);
			}
		}
	}
	
	By txtAgreementStatus = By.xpath("//input[contains(@id,'Lease_Status_ID') and @type='text']");

	private void addAgreementStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAgreementStatus, value);
	}
	
	By txtAgreementStatusPopUp = By.xpath("//input[contains(@id,'leaseInfo_Lease_Status_ID') and @type='text']");
	By firstAgreementStatusPopUp = By.xpath("//div[contains(@id,'leaseInfo_Lease_Status_ID_radYALDropDownList_DropDown')]/..//li[1]");
	private void addAgreementStatusPopUp(String value) {
		if(environment.contains("ORSTED")) {
			if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAgreementStatusPopUp, value);
		}else {
			util.click(txtAgreementStatusPopUp);
			util.click(firstAgreementStatusPopUp);
		}
	}
	
	By txtOperatingCompany = By.xpath("//input[contains(@id,'_YALComboBox') and @type='text']");
	By firstOperatingCompany = By.xpath("//*[contains(@id,'_YALComboBox_DropDown')]/.//li[1]");

	private void addOperatingCompany() {
		util.waitUntilElementDisplay(txtOperatingCompany);
		util.click(txtOperatingCompany);
		util.click(firstOperatingCompany);
	}
	
	By txtOperatingCompanyPopUp = By.xpath("//input[contains(@id,'leaseInfo_customFields') and @type='text']");
	By firstOperatingCompanyPopUp = By.xpath("//input[contains(@id,'leaseInfo_customFields') and @type='text']");
	
	private void addOperatingCompanyPopUp(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtOperatingCompanyPopUp, value);
		}
	}
	
	By saveButton = By.xpath("(//input[contains(@id,'_btnSave') and not(@disabled)])[1]");

	private void clickOnSaveButton() {
		util.click(saveButton);
		util.dummyWait(5);
	}

	By saveCloseButton = By.xpath("//input[contains(@id,'leaseInfo_btnSaveAndClose') and not(@disabled)]");
	
	private void clickOnSaveButtonPopUp(String testcaseName) {
		util.click(saveCloseButton);
		util.switchToDefaultContent();
		util.dummyWait(2);
	}
	
	By agreementFrame = By.xpath("//iframe[@name='radwinAddNewLease']");
	By agreementList = By.xpath("//tr[contains(@id,'ctl00_ConPHLeftTop_LSLST_RadGridTracts')]");
	By firstAgreement = By.xpath("(//tr[contains(@id,'ctl00_ConPHLeftTop_LSLST_RadGridTracts')])[1]");
	By deleteAgreement = By.xpath("(//div[@id='ctl00_ConPHLeftTop_LSLST_RadMenuTL_detached']/..//span[text()='Delete'])[1]");
	
	public void addAgreementInformation(Map<String, String> map, String testcaseName) {
		try {
			if(testcaseName.toLowerCase().contains("row") || testcaseName.contains("TRA")) {
				navigateToAgreementInformationROW();
			} else {
				navigateToAgreementInformationALT();
				if(testcaseName.contains("AddLease")) {
				commonFunction.projectSelection();	
				}
			}
			log("STEP 1:  Navigate to Menu - Agreement Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot Navigate to Menu - Agreement Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		
		try {
			clickOnAddButton();
			log("STEP 2:  Click Add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot Click Add button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		if(util.isElementPresent(agreementFrame)) {
			util.switchToIframe(agreementFrame);
			
			try {
				addLeaseNumberPopUp(map.get(Excel.AgreementNumber));
				log("STEP 3:  Value auto populate in Agreement Number Field", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: Cannot Add value in Agreement Number Field", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}

			try {
				addAgreementTypePopUp(map.get(Excel.AgreementType));
				log("STEP 4:  User can select value from the Agreement Type DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User cannot select value from the Agreement Type DD", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			util.dummyWait(5);
			try {
				addAgreementStatusPopUp(map.get(Excel.AgreementStatus));
				log("STEP 5:  User can select value from the Agreement Status DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User cannot select value from the Agreement Status DD", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}

			if(util.isElementPresent(txtOperatingCompanyPopUp)) {
			try {
				addOperatingCompanyPopUp(map.get(Excel.OperatingCompany));
				log("STEP 6:  User can select value from the Operating Company DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  User cannot select value from the Operating Company DD", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			}
			try {
				clickOnSaveButtonPopUp(testcaseName);
				log("STEP 7:  Click on save button", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot Click on save button", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
		}else {
		try {
			addLeaseNumber(map.get(Excel.AgreementNumber));
			log("STEP 3:  Value auto populate in Agreement Number Field", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: Cannot Add value in Agreement Number Field", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			addAgreementType(map.get(Excel.AgreementType));
			log("STEP 4:  User can select value from the Agreement Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot select value from the Agreement Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			addAgreementStatus(map.get(Excel.AgreementStatus));
			log("STEP 5:  User can select value from the Agreement Status DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User cannot select value from the Agreement Status DD", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		if(util.isElementPresent(txtOperatingCompany)) {
		try {
			addOperatingCompany();
			log("STEP 6:  User can select value from the Operating Company DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User cannot select value from the Operating Company DD", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		}
		try {
			clickOnSaveButton();
			log("STEP 7:  Click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot Click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		}
	}
	
	
	By btnAddterm = By.xpath("//input[contains(@id,'_btnAddProjectPhase') or contains(@id,'btnAddLeaseTerm')]");
	By leaseDocumentIframe = By.xpath("//iframe[@name='LeaseDocument']");
	By drpAgreementTerm = By.xpath("//input[contains(@id,'Period_Type_ID_') and @type='text']");

	private void clickOnAddTerm() {
		util.click(btnAddterm);
		util.waitForWebElementToBePresent(leaseDocumentIframe, 20);
	}

	private void switchToTermIframe() {
		util.switchToIframe(leaseDocumentIframe);
	}

	private void addAgreementTerm(String value) {
		if (!commonFunction.checkNA(value) && util.isElementPresent(drpAgreementTerm)) {
			util.inputTextAndPressTab(drpAgreementTerm, value);
		}
	}

	By chkExtensionProvision = By.xpath("//input[contains(@id,'chkExtensionProvision')]");

	private void clickExtensionProvision() {
		if (util.isElementPresent(chkExtensionProvision)) {
			util.click(chkExtensionProvision);
		}
	}

	By chkActive = By.xpath("//input[contains(@id,'active_ind')]");

	private void clickActiveCheckbox() {
		util.click(chkActive);
	}

	By effectiveDate = By.xpath("//input[contains(@id,'Effective_Date_dateInput')]");

	private void addEffectiveDate(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(effectiveDate, value);
		}
	}

	By termYear = By.xpath("//input[contains(@id,'Term_Years') and @type='text']");

	private void addTermYear(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(termYear, value);
		}
	}

	By termMonths = By.xpath("//input[contains(@id,'Term_Months') and @type='text']");

	private void addTermMonths(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(termMonths, value);
		}
	}

	By termDays = By.xpath("//input[contains(@id,'Term_Days') and @type='text']");

	private void addTermDays(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(termDays, value);
		}
	}

	By expirationDate = By.xpath("//input[contains(@id,'Expiration_Date_dateInput') and @type='text']");

	private void addExpirationDate(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(expirationDate, value);
		}
	}

	By flatPaymentAmount = By.xpath("//input[contains(@id,'Flat_Payment_Amount') and @type='text']");

	private void addFlatPaymentAmount(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(flatPaymentAmount, value);
		}
	}

	By txtareaComments = By.xpath("//textarea[contains(@id,'Comments')]");

	private void addComments(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtareaComments, value);
		}
	}

	By iframeSaveButton = By.xpath("//input[@id='btnSave']");

	private void clickOnSaveButtonIframe() {
		util.click(iframeSaveButton);
		commonFunction.waitForSuccessMessage();
		if (!commonFunction.getSuccessMessage().equals("Changes saved successfully!")) {
			throw new RuntimeException();
		}
	}

	By closeLeaseDocumentIframe = By.xpath("//div[contains(@id,'_LeaseDocument')]//a[@title='Close']");

	private void closeTermIframe() {
		util.switchToDefaultContent();
		util.click(closeLeaseDocumentIframe);
		util.waitFor(5000);
	}
	
	By refreshButton = By.xpath("//table[contains(@id,'LEASE_PAYMENTS_ygccontainTable')]//img/parent::a[contains(@id,'Button')]");
	By termTableRecord = By.xpath("//table[contains(@id,'LEASE_PAYMENTS_ygccontainTable')]/tbody//tr[contains(@id,'LEASE_PAYMENTS_radYALGridControl')]");
	private void refreshTermTableAndCheckRecord() {
		if(util.isElementPresent(refreshButton)) {
			util.click(refreshButton);
			try {
				util.waitForWebElementToBePresent(termTableRecord, IMPLICIT_WAIT);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addAgreementTerm(Map<String, String> map, String testcaseName) {
		try {
			clickOnAddTerm();
			log("STEP 1:  Click on Add Term button", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot Click on Add Term button", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			switchToTermIframe();
			addAgreementTerm(map.get(Excel.AgreementTerm));
			AGREEMENT_TERM=map.get(Excel.AgreementTerm);
			log("STEP 2:  Fill in Agreement Term", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot Select value from the Agreement Term DD", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		try {
			clickExtensionProvision();
			log("STEP 3:  Click on Extension Provision Check box", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot check Extension Provision Check box", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			clickActiveCheckbox();
			log("STEP 4:  Click on Active Check box", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot check Active Check box", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		try {
			addEffectiveDate(map.get(Excel.EffectiveDate));
			EFFECTIVE_DATE=map.get(Excel.EffectiveDate);
			log("STEP 5:  Select Effective Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot enter value in the  Effective Date field", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			addTermYear(map.get(Excel.TermYMD).split("-")[0]);
			log("STEP 6:  Enter the value in Term Year Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User cannot Enter the value in Term Year Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		try {
			addTermMonths(map.get(Excel.TermYMD).split("-")[1]);
			log("STEP 7:  Enter the value in Term Month Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot Enter the value in Term Month Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		try {
			addTermDays(map.get(Excel.TermYMD).split("-")[2]);
			log("STEP 8:  Enter the value in Term Days Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User cannot Enter the value in Term Days Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}

		try {
			addExpirationDate(map.get(Excel.ExpirationDate));
			EXPIRATION_DATE=map.get(Excel.ExpirationDate);
			log("STEP 9:  Select Expiration Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot select Expiration Date field", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		try {
			addFlatPaymentAmount(map.get(Excel.Amount));
			log("STEP 10:  Enter the value in Flat Payment Amount Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User cannot Enter the value in Flat Payment Amount Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		try {
			addComments(map.get(Excel.Comments));
			log("STEP 11:  Enter the value in Comments Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User cannot Enter the value in Comments Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		try {
			clickOnSaveButtonIframe();
			closeTermIframe();
			refreshTermTableAndCheckRecord();
			log("STEP 12:  Click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
	}
	
}
