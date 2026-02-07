package pages.agreementManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class AddNewInformationPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER, AGREEMENT_TITLE;

	public AddNewInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navLeaseManager = By.xpath("//a//span[contains(text(),'Lease Manager')]  | //a//span[contains(text(),'Third Party Agreements')] ");
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
		util.waitForWebElementToBePresent(pageTitle, 20);
		if (!util.isElementPresent(pageTitle)) {
			throw new RuntimeException();
		}
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

	
	private void verifyAutoPopulatedAgreementNumber() {
		AGREEMENT_NUMBER = util.getAttributeValue(agreementNumber, "value");
		ExtentTestManager.info("User typed: " + AGREEMENT_NUMBER);
		if (AGREEMENT_NUMBER.length() == 0) {
			throw new RuntimeException();
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
	By txtAgreementType2 = By.xpath("//span/parent::div[contains(@id,'DOCUMENT_TYPE_ID')]");

	private void addAgreementType(String value) {
		if (!commonFunction.checkNA(value)) {
			if(util.isElementPresent(txtAgreementType1)) {
				util.inputTextAndPressTab(txtAgreementType1, value);
			} else if(util.isElementVisible(txtAgreementType2)) {
				util.selectValueFromDropdown(txtAgreementType2, value);
			}
		}
	}
	
	private void addAgreementTypeAvangrid(String value) {
		util.click(txtAgreementType2);
		By drpSelectValue = By.xpath("//span[normalize-space()='" + value + "']");
		util.click(drpSelectValue);
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
	
	By txtSalesForceId = By.xpath("(//span[contains(text(),'Salesforce ID')]/..//input[@type='text'])[1]");
	private void addSalesForceId(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtSalesForceId, value);
		}
	}
	
	By txtQLSNumber = By.xpath("//span[text()='QLS Number:']/..//input[@type='text']");
	private void addQLSNumber(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtQLSNumber, value);
		}
	}
	
	By txtTotalAgreementAcreage = By.xpath("//span[text()='Total Agreement Acreage:']/..//input[@type='text']");
	private void addTotalAgreementAcreage(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtTotalAgreementAcreage, value);
		}
	}
	
	By txtUsableAcreage = By.xpath("//span[text()='Useable Acreage:']/..//input[@type='text']");
	private void addUsableAcreage(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtUsableAcreage, value);
		}
	}
	
	By txtLeasePaymentAcre = By.xpath("//span[text()='Lease Payment - $/acre:']/..//input[@type='text']");
	private void addLeaseAcre(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtLeasePaymentAcre, value);
		}
	}
	
	By txtOptionPaymentFixed = By.xpath("//span[text()='Option Payment - Fixed $:']/..//input[@type='text']");
	private void addOptionPaymentFixed(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtOptionPaymentFixed, value);
		}
	}
	
	By txtAgreementStatus = By.xpath("//input[contains(@id,'Lease_Status_ID') and @type='text']");

	private void addAgreementStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAgreementStatus, value);
	}
	
	By txtAgreementTitle = By.xpath("//*[text()='Agreement Title:']/..//input[@type='text']");

	private void addAgreementTitle(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAgreementTitle, value);
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

	private void addOperatingCompany(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtOperatingCompany, value);
		}
	}

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

	private void clickOnSaveButton(String testcaseName) {
		util.click(saveButton);
		util.dummyWait(5);
	}

	By saveCloseButton = By.xpath("//input[contains(@id,'leaseInfo_btnSaveAndClose') and not(@disabled)]");
	
	private void clickOnSaveButtonPopUp(String testcaseName) {
		util.click(saveCloseButton);
		util.switchToDefaultContent();
		if (testcaseName.toLowerCase().contains("row") || testcaseName.contains("TRA")) {
			util.waitFor(15000);
		} else {
			if(!testcaseName.contains("ATWELL")) {
			By savedAgreementInformation = By.xpath(
					"//div[contains(@id,'_RadDockTractSS')]//td[text()='Agreement Number']/following-sibling::td[contains(.,'"+AGREEMENT_NUMBER+"')]");
			util.waitForWebElementToBePresent(savedAgreementInformation, 30);
			}
			util.dummyWait(1);
		}
		//util.waitUntilLoaderDisappear();
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

	By duplicateButton = By.xpath("//input[contains(@id,'_btnDuplicate')]");
	By leaseCopyIframe = By.xpath("//iframe[@name='LeaseCopy']");
	By duplicateSaveButton = By.xpath("//input[@id='btnLinkLogs']");

	private void clickOnDuplicateButton() {
		try {
			util.click(duplicateButton);
			util.waitForWebElementToBePresent(leaseCopyIframe, 20);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void switchToLeaseCopyIframe() {
		util.switchToIframe(leaseCopyIframe);
	}

	private void clickOnDuplicateSaveButton() {
		util.click(duplicateSaveButton);
		commonFunction.waitForSuccessAddMessage();
//		if (!commonFunction.getSuccessAddMessage()
//				.equals("New lease has been created. Please close window to see new lease record.")) {
//			throw new RuntimeException();
//		}
	}

	By closeLeaseCopyIframe = By.xpath("//div[contains(@id,'_LeaseCopy')]//a[@title='Close']");

	private void closeLeaseCopyIframe() {
		util.switchToDefaultContent();
		util.click(closeLeaseCopyIframe);
		util.waitFor(5000);
	}

	By agreementFrame = By.xpath("//iframe[@name='radwinAddNewLease']");
	
	String formattedDate;
	private void formattedDate(String value) {
		
		try {
		SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat outputFormat = new SimpleDateFormat("d/M/yyyy");

		Date date = inputFormat.parse(value);
		formattedDate = outputFormat.format(date);
	} catch (Exception e) {
		
	}
	}
	
	public String addAgreementInformation(Map<String, String> map, String testcaseName) {
		try {
			if(testcaseName.toLowerCase().contains("row") || testcaseName.contains("TRA")) {
				navigateToAgreementInformationROW();
			} else {
				navigateToAgreementInformationALT();
			}
			commonFunction.projectSelection();
			log("STEP 1:  Navigate to Menu - Agreement Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot Navigate to Menu - Agreement Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		WebElement projectName=driver.findElement(By.xpath("//*[@id=\"ctl00_ConPHLeftTop_PROJLST_ddt_ProjectList\"]"));
	     ExtentTestManager.info("Adding on Existing Project Name: " +projectName.getAttribute("title"));
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
				if(testcaseName.toLowerCase().contains("row") || testcaseName.toLowerCase().contains("orsted") || testcaseName.contains("TRA")) {
					AGREEMENT_NUMBER = util.randomNumber();
					addLeaseNumberPopUp(AGREEMENT_NUMBER);
					ExtentTestManager.info("Entered Agreement number is " +AGREEMENT_NUMBER );
				} else {
					verifyAutoPopulatedAgreementNumber();
				}
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
				if (environment.contains("NOVA")) {
					addAgreementStatusPopUp("Select One");
				} else {
					addAgreementStatusPopUp(map.get(Excel.AgreementStatus));
				}
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
			if(testcaseName.toLowerCase().contains("row") || testcaseName.toLowerCase().contains("orsted") || testcaseName.contains("TRA")) {
				AGREEMENT_NUMBER = util.randomNumber();
				addLeaseNumber(AGREEMENT_NUMBER);
			} else {
				verifyAutoPopulatedAgreementNumber();
			}
			log("STEP 3:  Value auto populate in Agreement Number Field", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: Cannot Add value in Agreement Number Field", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		try {
			if(environment.contains("AVANGRID")) {
				addAgreementTypeAvangrid(map.get(Excel.AgreementType));
			}else {
			addAgreementType(map.get(Excel.AgreementType));
			}
			log("STEP 4:  User can select value from the Agreement Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot select value from the Agreement Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			if(environment.contains("NOVA")) {
				addAgreementStatus("Select One");
			}else {
			addAgreementStatus(map.get(Excel.AgreementStatus));
			}
			log("STEP 5:  User can select value from the Agreement Status DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User cannot select value from the Agreement Status DD", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		if(environment.contains("TREATYOAK")) {
		try {
			AGREEMENT_TITLE ="Test";
			addAgreementTitle(AGREEMENT_TITLE);
			log("STEP 6 : User can enter Agreement Title", Status.PASS);
		} catch (Exception e) {
			log("STEP 6 : User cannot enter Agreement Title", Status.FAIL);
			throw new RuntimeException("Failed to add Agreement Title");
		}
		}
		
		if (environment.contains("NEXTERA")) {
			try {
				addSalesForceId("123456");
				log("STEP 7:  User can enter value in Salesforce Id field", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User cannot enter value in Salesforce Id field", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				addQLSNumber("654354");
				log("STEP 8:  User can enter value in QLS Number field", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:  User cannot enter value in QLS Number field", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				addTotalAgreementAcreage(map.get("TotalAgreementAcreage"));
				log("STEP 9:  User can enter value in Total Agreement Acreage field", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:  User cannot enter value in Total Agreement Acreage field", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				addUsableAcreage(map.get("UsableAcreage"));
				log("STEP 10:  User can enter value in Usable Acreage field", Status.PASS);
			} catch (Exception e) {
				log("STEP 10:  User cannot enter value in Usable Acreage field", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				addLeaseAcre(map.get("LeaseAcre"));
				log("STEP 11:  User can enter value in Lease Payment Acre field", Status.PASS);
			} catch (Exception e) {
				log("STEP 11:  User cannot enter value in Lease Payment Acre field", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				addOptionPaymentFixed(map.get("OptionPaymentFixed"));
				log("STEP 12:  User can enter value in Option Payment Fixed field", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:  User cannot enter value in Option Payment Fixed field", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
		}
		
		if(util.isElementPresent(txtOperatingCompany)) {
		try {
			addOperatingCompany();
			log("STEP 13:  User can select value from the Operating Company DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User cannot select value from the Operating Company DD", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		}
		try {
			clickOnSaveButton(testcaseName);
			log("STEP 14:  Click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot Click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		}
		
		if(environment.contains("TREATYOAK")) {
			try {
				By agreementTitleDataPoint = By.xpath("(//text()[contains(., 'Agreement Title')]/following-sibling::strong[text()='"+AGREEMENT_TITLE+"'])[1]");
                Assert.assertTrue(util.isElementVisible(agreementTitleDataPoint));
				log("STEP 15: User Can See Agreement Title Data Point with updated value in the Agreement List", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 15: User Cannot See Agreement Title Data Point with updated value in the Agreement List", Status.FAIL);
			}
			}
		
		try {
			clickOnAddTerm();
			log("STEP 16:  Click on Add Term button", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:  User cannot Click on Add Term button", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}

		try {
			switchToTermIframe();
			addAgreementTerm(map.get(Excel.AgreementTerm));
			log("STEP 17:  Fill in Agreement Term", Status.PASS);
		} catch (Exception e) {
			log("STEP 17:  User cannot Select value from the Agreement Term DD", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		try {
			clickExtensionProvision();
			log("STEP 18:  Click on Extension Provision Check box", Status.PASS);
		} catch (Exception e) {
			log("STEP 18:  User cannot check Extension Provision Check box", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		try {
			clickActiveCheckbox();
			log("STEP 19:  Click on Active Check box", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: User cannot check Active Check box", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		try {
			addEffectiveDate(map.get(Excel.EffectiveDate));
			log("STEP 20:  Select Effective Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: User cannot enter value in the  Effective Date field", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}

		try {
			addTermYear(map.get(Excel.TermYMD).split("-")[0]);
			log("STEP 21:  Enter the value in Term Year Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 21:  User cannot Enter the value in Term Year Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
		try {
			addTermMonths(map.get(Excel.TermYMD).split("-")[1]);
			log("STEP 22:  Enter the value in Term Month Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: User cannot Enter the value in Term Month Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
		try {
			addTermDays(map.get(Excel.TermYMD).split("-")[2]);
			log("STEP 23:  Enter the value in Term Days Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 23:  User cannot Enter the value in Term Days Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}

//		try {
//			By expirationDate = By.xpath("//input[contains(@id,'Expiration_Date_dateInput') and @value='"+map.get(Excel.ExpirationDate)+"']");
////			addExpirationDate(map.get(Excel.ExpirationDate));
//			Assert.assertTrue(util.isElementVisible(expirationDate));
//			log("STEP 16:  Expiration Date calcaulated correctly", Status.PASS);
//		} catch (AssertionError e) {
//			log("STEP 16: Expiration Date is not calcaulated correctly", Status.FAIL);
//		}
		try {
			addFlatPaymentAmount(map.get(Excel.Amount));
			log("STEP 24:  Enter the value in Flat Payment Amount Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 24:  User cannot Enter the value in Flat Payment Amount Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		try {
			addComments(map.get(Excel.Comments));
			log("STEP 25:  Enter the value in Comments Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 25:  User cannot Enter the value in Comments Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
		
		try {
			clickOnSaveButtonIframe();
			log("STEP 26:  Click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
		
		try {
			formattedDate(map.get(Excel.ExpirationDate));
			By expirationDate = By.xpath("//input[contains(@id,'Expiration_Date_dateInput') and @value='"+formattedDate+"']");
			Assert.assertTrue(util.isElementVisible(expirationDate));
			log("STEP 27:  Expiration Date calcaulated correctly", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 27: Expiration Date is not calcaulated correctly", Status.FAIL);
		}
		
		try {
			closeTermIframe();
			refreshTermTableAndCheckRecord();
			log("STEP 28:  Click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 28: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 28");
		}
		return AGREEMENT_NUMBER;
	}

	By legalDescriptionIframe = By.xpath("//iframe[contains(@id,'Lease_Description')]");
	By agreementInfoTab = By.xpath("//div[contains(@id,'LSINFO_radPanels')]//span[text()='Agreement Information']");
	private void switchToLegalDescriptionIframe() {
		if(!util.isElementVisible(legalDescriptionIframe,5)) {
			util.click(agreementInfoTab);
			util.waitFor(2000);
		} 
		util.switchToIframe(legalDescriptionIframe);
	}
	
	By legalDescription = By.xpath("//body");
	private void addLegalDescription(String value) {
		util.inputText(legalDescription, value);
	}
	
	By saveButtonAgreementInfo = By.xpath("//input[contains(@id,'btnSave2')]");
	private void clickSaveButtonAgreementInfo() {
		util.switchToDefaultContent();
		util.click(saveButtonAgreementInfo);
	}
	public void addAgreementInformation(String testcaseName) {
		try {
			switchToLegalDescriptionIframe();
			addLegalDescription("Automation comments");
			log("STEP 1: Fill in Legal Description text box", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Fill in Legal Description text box", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			clickSaveButtonAgreementInfo();
			log("STEP 2: Click on Save", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Save", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		util.dummyWait(2);
	}

	public void duplicateTheAgreement(String testcaseName) {
		
			try {
				clickOnDuplicateButton();
				log("STEP 17: Click on Duplicate button", Status.PASS);
			} catch (Exception e) {
				log("STEP 17: User cannot click on Duplicate button", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			try {
				switchToLeaseCopyIframe();
				clickOnDuplicateSaveButton();
				closeLeaseCopyIframe();
				log("STEP 18: Click on Save button", Status.PASS);
			} catch (Exception e) {
				log("STEP 18:User cannot click on Save button", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
			
			try {
				addLeaseNumber(util.randomNumber());
				log("STEP 19:  Value auto populate in Agreement Number Field", Status.PASS);
			} catch (Exception e) {
				log("STEP 19: Cannot Add value in Agreement Number Field", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
			
			try {
				clickOnSaveButton(testcaseName);
				log("STEP 20:  Click on save button", Status.PASS);
			} catch (Exception e) {
				log("STEP 20: User cannot Click on save button", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}
		
	}
	
	
}
