package pages.agreementManager;

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

public class CF_PaymentTagsPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER, TAG_NAME1, TAG_NAME2;
	SoftAssert sf = new SoftAssert();
	
	public CF_PaymentTagsPage(WebDriver driver) {
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
//
//	private void addOperatingCompany(String value) {
//		if (!commonFunction.checkNA(value)) {
//			util.inputTextAndPressTab(txtOperatingCompany, value);
//		}
//	}

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

	
	By agreementFrame = By.xpath("//iframe[@name='radwinAddNewLease']");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	public void TurnOnDesignMode() {
    	util.waitUntilElementDisplay(btnDesignMode);
    	util.click(btnDesignMode);
    	util.dummyWait(2);
    }
	By customIconAgreement = By.xpath("//span[@title='Manage custom field(s)' and contains(@onclick,'LEASEDATA')]");
	By customIconAgreementTerm = By.xpath("//span[@title='Manage custom field(s)' and contains(@onclick,'LEASETERMINFORMATION')]");
	By btnAddNewRecord = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[1]");
    By txtFieldName = By.xpath("//input[contains(@id,'editcc_Field_Name') and @type='text']");
    By drpFieldType = By.xpath("//input[contains(@id,'editcc_Field_Type_ID_radYALDropDownList_Input') and @type='text']");
    By txtDisplayOrder = By.xpath("//input[contains(@id,'editcc_Display_Order') and @type='text']");
    By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
    By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
    By btnReload = By.xpath("//a[@title='Reload']");
    
	public void ClickOnAddNewRecord() {
    	util.waitUntilElementDisplay(btnAddNewRecord);
    	util.click(btnAddNewRecord);
    	util.dummyWait(1);
    }
	
	public void AddFieldName(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtFieldName, value);
    }
    
    public void SelectFieldType(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpFieldType, value);
    }
    
    public void AddDisplayOrder(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDisplayOrder, value);
    }
    
    public void ClickOnInsertButton() {
    	util.waitUntilElementDisplay(btnInsert);
    	util.click(btnInsert);
    	util.dummyWait(1);
    }
    
    By btnSaveHeader = By.xpath("//input[contains(@id,'btnSaveHeader')]");
    By btnPublish = By.xpath("//input[contains(@id,'PublishViews')]");
    By Message = By.xpath("//span[text()='Views have been published successfully.']");
    By Currency = By.xpath("//input[contains(@id,'idMngCustmAdnlFields_customFields2') and @value='$0.00']");
    By checkboxGeneratePaymentTag = By.xpath("//input[contains(@id,'EditFormControl_editcc_chkGeneratePaymentTag')]");
    By validationMessage = By.xpath("//*[text()='Payment tags can only be created on numeric custom fields with field name containing alphabets, numbers, space and underscore.']");
    public void ClickOnSaveHeader() {
    	util.waitUntilElementDisplay(btnSaveHeader);
    	util.click(btnSaveHeader);
    	util.dummyWait(1);
    }
    
    public void ClickOnPublish() {
    	util.waitUntilElementDisplay(btnPublish);
    	util.click(btnPublish);
    	util.dummyWait(1);
    }
    
    By txtMinValue = By.xpath("//input[contains(@id,'editcc_rntbNumericMin') and @type='text']");
    public void AddMinValue(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtMinValue, value);
    }
    
    By txtMaxValue = By.xpath("//input[contains(@id,'editcc_rntNumericMax') and @type='text']");
    public void AddMaxValue(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtMaxValue, value);
    }
    
	public String addAgreementInformation(Map<String, String> map, String testcaseName) {
		try {
			navigateToAgreementInformationALT();
			commonFunction.projectSelection();
			log("STEP 1:  Navigate to Menu - Agreement Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot Navigate to Menu - Agreement Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			clickOnAddButton();
			log("STEP 2: User can Click Add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot Click Add button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		if(util.isElementPresent(agreementFrame)) {
			util.switchToIframe(agreementFrame);
			
			try {
				if(testcaseName.toLowerCase().contains("orsted")) {
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
					addAgreementStatusPopUp("Signed");
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
			if(testcaseName.toLowerCase().contains("orsted")) {
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
			addAgreementType(map.get(Excel.AgreementType));
			log("STEP 4:  User can select value from the Agreement Type DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot select value from the Agreement Type DD", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			if(environment.contains("NOVA")) {
				addAgreementStatus("Signed");
			}else {
			addAgreementStatus(map.get(Excel.AgreementStatus));
			}
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
			clickOnSaveButton(testcaseName);
			log("STEP 7:  Click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot Click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		}
		
		try {
			TurnOnDesignMode();
			log("STEP 8:  Desing mode turn on", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User cannot Click on design mode icon", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try { 
			util.click(customIconAgreement);
			log("STEP 9:  user can able to click on the custom control icon on the agreement page", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  user cannot click on the custom control icon on the agreement page ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
	
		util.switchToChildWindow();
		util.dummyWait(3);
		
		By FieldName = By.xpath("//*[contains(@id,'idMngCustmAdnlFields_')]/td[text()='" +map.get(Excel.FieldName)+ "']");
		TAG_NAME1=map.get(Excel.FieldName);
		TAG_NAME2=map.get("FieldName2");
		if(!util.isElementVisible(FieldName)) {
   	try {
			ClickOnAddNewRecord();
			log("STEP 10: user can able to click on the add new record (+)", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user can not able to click on the add new record (+) ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			AddFieldName("@#$%^");
			log("STEP 11: user can enter Invalid field name ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot enter Invalid field name ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			SelectFieldType(map.get(Excel.FieldType));
			log("STEP 12: user can able to select the value \"CURRENCY\"  from field type dd ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: user can not able to select the value \"CURRENCY\"  from field type dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		
		try {
			AddDisplayOrder(map.get(Excel.DisplayOrder));
			log("STEP 13: user can able to enter value in Display order field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: user can not able to enter value in Display order field ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			util.click(checkboxGeneratePaymentTag);
			log("STEP 14: user can check Generate Payment Tag Checkbox ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user can check Generate Payment Tag Checkbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
			ClickOnInsertButton();
			log("STEP 15: user can able to click on insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: user cannot able to click on insert button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(validationMessage));
			log("STEP 16: User can see validation message for invalid field name ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 16 : user cannot see validation message for invalid field name ", Status.FAIL);
		}
		
		try {
			AddFieldName(map.get(Excel.FieldName));
			log("STEP 17: user can able to enter text in the \"field name \" field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user not able to enter text in the \"field name \" field     ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}

		try {
			ClickOnInsertButton();
			log("STEP 18: user can able to click on insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: user cannot able to click on insert button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 19 : 'Changes saved successfully!' message is display  ", Status.PASS);
			} else {
			   log("STEP 19: Changes saved successfully!' message does notdisplay ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 19 ");
	   	} 
		

		if (util.isElementPresent(Currency)) {
			   log("STEP 20 : user can able to see the added custom field of type 'CURRENCY' under preview ", Status.PASS);
			} else {
			   log("STEP 20: user cannot see the added custom field of type 'CURRENCY' under preview ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 20 ");
	   	} 
	
		try {
			ClickOnSaveHeader();
			log("STEP 21: user can able to click on Save Header button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: user cannot able to click on Save Header button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
		
		try {
			ClickOnPublish();
			log("STEP 22: user can able to click on Publish button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: user cannot able to click on Publish button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
		
		if (util.isElementPresent(Message)) {
			   log("STEP 23 : 'Views have been published successfully. message is display  ", Status.PASS);
			} else {
			   log("STEP 23: Views have been published successfully. message does notdisplay ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 23 ");
	   	} 
	
		}else {
			 log("STEP 9: Custom control field is already added ", Status.PASS);
		}
	
		util.dummyWait(1);
		driver.close();
		util.switchToParentWindow();
		util.reloadPage();

		try {
			By fieldCurrency = By.xpath("//span[text()='"+map.get(Excel.FieldName)+"']/..//input[@type='text']");
			util.inputTextAndPressTab(fieldCurrency, map.get("CurrencyValue"));
			log("STEP 24: User can add value in the Currency field", Status.PASS);
		} catch (Exception e) {
			log("STEP 24: User cannot add value in the Currency field", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		
		try {
			clickOnSaveButton(testcaseName);
			log("STEP 25:  Click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: User cannot Click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
		
		try {
			clickOnAddTerm();
			switchToTermIframe();
			log("STEP 26:  Click on Add Term button", Status.PASS);
		} catch (Exception e) {
			log("STEP 26:  User cannot Click on Add Term button", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}

		try {
			util.click(customIconAgreementTerm);
			log("STEP 27:  user can able to click on the custom control icon on the Agreement Term popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 27:  user cannot click on the custom control icon  on the Agreement Term popup ", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		}
	    	
		util.switchToChildWindow();
		
		
		By FieldName2 = By.xpath("//*[contains(@id,'idMngCustmAdnlFields_')]/td[text()='" +map.get("FieldName2")+ "']");
		
		if(!util.isElementVisible(FieldName2)) {
			try {
				ClickOnAddNewRecord();
				log("STEP 28: user can able to click on the add new record (+)", Status.PASS);
			} catch (Exception e) {
				log("STEP 28: user can not able to click on the add new record (+) ", Status.FAIL);
				throw new RuntimeException("Failed in step 28");
			}
			
//			try {  // not working for numeric field
//				AddFieldName("@#$%");
//				log("STEP 29: user can able to enter text in the \"field name \" field     ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 29: user not able to enter text in the \"field name \" field     ", Status.FAIL);
//				throw new RuntimeException("Failed in step 29");
//			}
			
			try {
				SelectFieldType(map.get("FieldType2"));
				log("STEP 30: user can able to select the value \"NUMERIC\" from field type dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 30: user can not able to select the value \"NUMERIC\"  from field type dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 30");
			}

			try {
				AddDisplayOrder(map.get(Excel.DisplayOrder));
				log("STEP 31: user can able to enter value in Display order field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 31: user can not able to enter value in Display order field ", Status.FAIL);
				throw new RuntimeException("Failed in step 317");
			}
			
			try {
				AddMinValue(map.get(Excel.MinValue));
				log("STEP 32:  user can able to enter value in Min.numeric field       ", Status.PASS);
			} catch (Exception e) {
				log("STEP 32: user cannot able to enter value in Min.numeric field   ", Status.FAIL);
				throw new RuntimeException("Failed in step 32");
			}
			
			try {
				AddMaxValue(map.get(Excel.MaxValue));
				log("STEP 33:  user can able to enter value in Max.numeric field       ", Status.PASS);
			} catch (Exception e) {
				log("STEP 33: user cannot able to enter value in Max.numeric field   ", Status.FAIL);
				throw new RuntimeException("Failed in step 33");
			}
			
//			try {
//				ClickOnInsertButton();
//				log("STEP 34: user can able to click on insert button ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 34: user cannot able to click on insert button  ", Status.FAIL);
//				throw new RuntimeException("Failed in step 34");
//			}
//			
//			try {
//				Assert.assertTrue(util.isElementVisible(validationMessage));
//				log("STEP 35: User can see validation message for invalid field name ", Status.PASS);
//			} catch (AssertionError e) {
//				log("STEP 35 : user cannot see validation message for invalid field name ", Status.FAIL);
//			}
			
			try {
				AddFieldName(map.get("FieldName2"));
				util.click(checkboxGeneratePaymentTag);
				log("STEP 36: user can able to enter text in the \"field name \" field     ", Status.PASS);
			} catch (Exception e) {
				log("STEP 36: user not able to enter text in the \"field name \" field     ", Status.FAIL);
				throw new RuntimeException("Failed in step 36");
			}

			try {
				ClickOnInsertButton();
				log("STEP 37: user can able to click on insert button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 37: user cannot able to click on insert button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 37");
			}

			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 38 : 'Changes saved successfully!' message is display  ", Status.PASS);
				} else {
				   log("STEP 38: Changes saved successfully!' message does notdisplay ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 38 ");
		   	} 
			
			try {
				ClickOnSaveHeader();
				log("STEP 39: user can able to click on Save Header button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 39: user cannot able to click on Save Header button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 39");
			}
			
			try {
				ClickOnPublish();
				log("STEP 40: user can able to click on Publish button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 40: user cannot able to click on Publish button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 40");
			}
			
			if (util.isElementPresent(Message)) {
				   log("STEP 41 : 'Views have been published successfully. message is display  ", Status.PASS);
				} else {
				   log("STEP 41: Views have been published successfully. message does notdisplay ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 41");
		   	} 
			
		}else {
			 log("STEP 28: Custom control field is already added ", Status.PASS);
		}

		util.dummyWait(1);
		driver.close();
        util.switchToParentWindow();
        util.click(btnReload);
        switchToTermIframe();
		
		try {
			addAgreementTerm(map.get(Excel.AgreementTerm));
			log("STEP 42:  Fill in Agreement Term", Status.PASS);
		} catch (Exception e) {
			log("STEP 42:  User cannot Select value from the Agreement Term DD", Status.FAIL);
			throw new RuntimeException("Failed in step 42");
		}
		try {
			clickExtensionProvision();
			log("STEP 43:  Click on Extension Provision Check box", Status.PASS);
		} catch (Exception e) {
			log("STEP 43:  User cannot check Extension Provision Check box", Status.FAIL);
			throw new RuntimeException("Failed in step 43");
		}
		try {
			clickActiveCheckbox();
			log("STEP 44:  Click on Active Check box", Status.PASS);
		} catch (Exception e) {
			log("STEP 44: User cannot check Active Check box", Status.FAIL);
			throw new RuntimeException("Failed in step 44");
		}
		try {
			addEffectiveDate(map.get(Excel.EffectiveDate));
			log("STEP 45:  Select Effective Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 45: User cannot enter value in the  Effective Date field", Status.FAIL);
			throw new RuntimeException("Failed in step 45");
		}

		try {
			addTermYear(map.get(Excel.TermYMD).split("-")[0]);
			log("STEP 46:  Enter the value in Term Year Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 46:  User cannot Enter the value in Term Year Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 46");
		}
		try {
			addTermMonths(map.get(Excel.TermYMD).split("-")[1]);
			log("STEP 47:  Enter the value in Term Month Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 47: User cannot Enter the value in Term Month Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 47");
		}
		try {
			addTermDays(map.get(Excel.TermYMD).split("-")[2]);
			log("STEP 48:  Enter the value in Term Days Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 48:  User cannot Enter the value in Term Days Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 48");
		}

		try {
			addExpirationDate(map.get(Excel.ExpirationDate));
			log("STEP 49:  Select Expiration Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 49: User cannot select Expiration Date field", Status.FAIL);
			throw new RuntimeException("Failed in step 49");
		}
		
		try {
			addFlatPaymentAmount(map.get(Excel.Amount));
			log("STEP 50:  Enter the value in Flat Payment Amount Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 50:  User cannot Enter the value in Flat Payment Amount Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 50");
		}
		
		try {
			addComments(map.get(Excel.Comments));
			log("STEP 51:  Enter the value in Comments Text field", Status.PASS);
		} catch (Exception e) {
			log("STEP 51:  User cannot Enter the value in Comments Text field", Status.FAIL);
			throw new RuntimeException("Failed in step 51");
		}
		
		try {
			By fieldNumeric = By.xpath("//span[text()='"+map.get("FieldName2")+"']/..//input[@type='text']");
			util.inputTextAndPressTab(fieldNumeric, map.get("NumericValue"));
			log("STEP 52:  User can add value in the newly created numeric field", Status.PASS);
		} catch (Exception e) {
			log("STEP 52:  User cannot add value in the newly created numeric field", Status.FAIL);
			throw new RuntimeException("Failed in step 52");
		}
		
		try {
			clickOnSaveButtonIframe();
			closeTermIframe();
			refreshTermTableAndCheckRecord();
			log("STEP 53:  Click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 53: User cannot click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 53");
		}
		return AGREEMENT_NUMBER;
	}

	By navPaymentInformation = By.xpath("//a//span[contains(text(),'Payment Information')] ");
	
	public void navigateToPaymentInformationALT() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navAgreementManager);
		util.click(navAgreementManager);
		util.waitUntilElementDisplay(navPaymentInformation);
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
	
	By pastTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Past']");
	private void clickOnPastTab() {
		util.click(pastTab);
	}
	
	public void pastPaymentValidation(String landowner, String period, String payment) {
		By pastYears= By.xpath("//tr[contains(@id,'CHECKPast_radYALGridControl')]/..//*[text()='"+landowner+"']/..//*[text()='"+period+"']");
		By pastPayments= By.xpath("//tr[contains(@id,'CHECKPast_radYALGridControl')]/..//*[text()='"+period+"']/..//*[text()='"+landowner+"']/..//*[contains(text(),'"+payment+"')]");
	
			sf.assertTrue(util.isElementVisible(pastYears), "Payment Date "+ period+" is not added for landowner "+landowner);
			sf.assertTrue(util.isElementVisible(pastPayments), "Past Payment for the year "+period+" is not correct for landowner "+landowner);
			ExtentTestManager.info("Expected Past Payment for the year "+period+" is "+payment);
	}
	
      public void addNewPaymentInformation(Map<String, String> map, String testCaseName) {
		
		try {
			navigateToPaymentInformationALT();
			By addedRecord = By.xpath("//td[text()='"+AGREEMENT_NUMBER+"']/parent::tr");
			util.click(addedRecord);
			util.dummyWait(2);
			log("STEP 1: Navigate to Project >agreement manager >payment Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Navigate to Project >agreement manager >payment Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			selectPaymentTemplate(map.get(Excel.PaymentTemplate));
			log("STEP 2:User can select payment template", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select the payment template ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			selectPaymentTerm(map.get(Excel.PaymentTerm));
			log("STEP 3: User can select Payment Term", Status.PASS);
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
		
		util.dummyWait(1);
		try {
			clickOnPastTab();
			log("STEP 5: Click on Past ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on Past Tab ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			pastPaymentValidation(map.get(Excel.Landowner), map.get(Excel.Period),map.get("Amount"));
			log("STEP 6: all Past Payment sucessfully added", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: Past Payment not added or calculations are incorrect", Status.FAIL);
		}
		sf.assertAll();
		
		
	}
	
}
