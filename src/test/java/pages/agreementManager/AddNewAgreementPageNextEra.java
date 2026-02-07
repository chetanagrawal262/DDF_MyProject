package pages.agreementManager;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;
import pages.Project.AddProjectPage;

public class AddNewAgreementPageNextEra extends BasePage {

	TestUtil util;
	Map<String, String> rowData = new HashMap<String, String>();
	SoftAssert sf = new SoftAssert();
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER, SALESFORCE_ID, QLS_NUMBER, AGREEMENT_PAYMENT_STATUS, NEXT_AGREEMENT_NUMBER, PAYMENT_TEMPLATE;

	public AddNewAgreementPageNextEra(WebDriver driver) {
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
	
	By txtAgreementTitle = By.xpath("//*[text()='Agreement Title:']/..//input[@type='text']");

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
	}
	
	By txtSalesForceId = By.xpath("//span[text()='Salesforce ID:']/..//input[@type='text']");
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
	
	By drpAgreementPaymentStatus = By.xpath("//span[text()='Agreement Payment Status:']/..//input[@type='text']");
	private void selectAgreementPaymentStatus(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(drpAgreementPaymentStatus, value);
		}
	}
	
	By agreementFrame = By.xpath("//iframe[@name='radwinAddNewLease']");
	
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	 public void TurnOnDesignMode() {
	    	util.waitUntilElementDisplay(btnDesignMode);
	    	util.click(btnDesignMode);
	    	util.dummyWait(2);
	    }
	 
	 By customIcon = By.xpath("//span[@title='Manage custom field(s)' and contains(@onclick,'LEASEDATA')]");
	 By salesforceIdField = By.xpath("//*[contains(@id,'idMngCustmAdnlFields_')]/td[text()='Salesforce ID:']/..//input[@alt='Edit']");
	 By QLSNumberField = By.xpath("//*[contains(@id,'idMngCustmAdnlFields_')]/td[text()='QLS Number:']/..//input[@alt='Edit']");
	 By agreementPaymentStatusField = By.xpath("//*[contains(@id,'idMngCustmAdnlFields_')]/td[text()='Agreement Payment Status:']/..//input[@alt='Edit']");
	 By searchableChecked = By.xpath("//*[contains(@id,'_EditFormControl_editcc_chkSearchable') and @checked='checked']");
	 By searchableUnchecked = By.xpath("//*[contains(@id,'_EditFormControl_editcc_chkSearchable')]");
	 By btnSaveHeader = By.xpath("//input[contains(@id,'btnSaveHeader')]");
	 By btnPublish = By.xpath("//input[contains(@id,'PublishViews')]");
	 By Message = By.xpath("//span[text()='Views have been published successfully.']");
	 By btnUpdate = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate')]");
	 
	 
	 public void ClickOnUpdateButton() {
	    	util.waitUntilElementDisplay(btnUpdate);
	    	util.click(btnUpdate);
	    	util.dummyWait(1);
	    }
	    
	    public void ClickOnSaveHeader() {
	    	util.waitUntilElementDisplay(btnSaveHeader);
	    	util.click(btnSaveHeader);
	    	util.dummyWait(2);
	    }
	    
	    public void ClickOnPublish() {
	    	util.waitUntilElementDisplay(btnPublish);
	    	util.click(btnPublish);
	    	util.dummyWait(2);
	    }
	    
	public void verifyAgreementPage(Map<String, String> map, String testcaseName) {
		try {
			navigateToAgreementInformationALT();
			if (testcaseName.contains("AgreementSearchNEXTERA")) {
			commonFunction.projectSelection();
			}
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
				verifyAutoPopulatedAgreementNumber();
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
			verifyAutoPopulatedAgreementNumber();
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
		
		if (testcaseName.contains("AgreementSearchNEXTERA")) {
		try {
			SALESFORCE_ID = map.get("SalesforceID");
			addSalesForceId(SALESFORCE_ID);
			log("STEP 7:  User can enter value in Salesforce Id field", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User cannot enter value in Salesforce Id field", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			QLS_NUMBER = map.get("QLSNumber");
			addQLSNumber(QLS_NUMBER);
			log("STEP 8:  User can enter value in QLS Number field", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User cannot enter value in QLS Number field", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			AGREEMENT_PAYMENT_STATUS = map.get("AgreementPaymentStatus");
			selectAgreementPaymentStatus(AGREEMENT_PAYMENT_STATUS);
			log("STEP 9:  User can select value from the Agreement Payment Status DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User cannot select value from the Agreement Payment Status DD", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		}
		
		try {
			clickOnSaveButton(testcaseName);
			log("STEP 10:  Click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot Click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
	}
		
		if (testcaseName.contains("AgreementSearchNEXTERA")) {
			
		try {
			By salesForceIdDataPoint = By.xpath("(//text()[contains(., 'Salesforce Id')]/following-sibling::strong[text()='" + SALESFORCE_ID+ "'])[1]");
			Assert.assertTrue(util.isElementVisible(salesForceIdDataPoint));
			log("STEP 11: User Can See Salesforce Id Data Point with updated value in the Agreement List", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11: User Cannot See Salesforce Id Data Point with updated value in the Agreement List",Status.FAIL);
		}
		
		try {
			By QLSNumberDataPoint = By.xpath("(//text()[contains(., 'Qls Number')]/following-sibling::strong[text()='" + QLS_NUMBER+ "'])[1]");
			Assert.assertTrue(util.isElementVisible(QLSNumberDataPoint));
			log("STEP 12: User Can See QLS Number Data Point with updated value in the Agreement List", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: User Cannot See QLS Number Data Point with updated value in the Agreement List",Status.FAIL);
		}
		
		try {
			By agreementPaymentStatusDataPoint = By.xpath("(//text()[contains(., 'Qls Number')]/following-sibling::strong[text()='" + QLS_NUMBER+ "'])[1]");
			Assert.assertTrue(util.isElementVisible(agreementPaymentStatusDataPoint));
			log("STEP 13: User Can See Agreement Payment Status Data Point with updated value in the Agreement List", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 13: User Cannot See Agreement Payment Status Data Point with updated value in the Agreement List",Status.FAIL);
		}
		
		
		
		try {
			TurnOnDesignMode();
			log("STEP 14:  user can turn on design mode", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:  user cannot turn on design mode", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		} 
		
		try {
			 util.click(customIcon);
			util.switchToChildWindow();
			log("STEP 15:  user can able to click on the custom control icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:  user cannot click on the custom control icon  ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		try {
		
		if(util.isElementVisible(salesforceIdField)) {
			
			try {
				util.waitUntilElementDisplay(salesforceIdField);
				 util.click(salesforceIdField);
				log("STEP 16:  user can click on edit icon of Salesforce Id field", Status.PASS);
			} catch (Exception e) {
				log("STEP 16:  user cannot click on edit icon of Salesforce Id field", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
			
			try {
				util.waitUntilElementDisplay(searchableUnchecked);
				if(!util.isElementPresent(searchableChecked)) {
				 util.click(searchableUnchecked);
				}
				log("STEP 17:  user can select searchable checkbox", Status.PASS);
			} catch (Exception e) {
				log("STEP 17:  user cannot select searchable checkbox", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 18: user can click on update button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 18: user cannot click on update button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
			
		}

       if(util.isElementVisible(QLSNumberField)) {
			
			try {
				util.waitUntilElementDisplay(QLSNumberField);
				 util.click(QLSNumberField);
				log("STEP 19:  user can click on edit icon of QLS Number field", Status.PASS);
			} catch (Exception e) {
				log("STEP 19:  user cannot click on edit icon of QLS Number field", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
			
			try {
				util.waitUntilElementDisplay(searchableUnchecked);
				if(!util.isElementPresent(searchableChecked)) {
				 util.click(searchableUnchecked);
				}
				log("STEP 20:  user can select searchable checkbox", Status.PASS);
			} catch (Exception e) {
				log("STEP 20:  user cannot select searchable checkbox", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 21: user can click on update button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 21: user cannot click on update button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 21");
			}
			
		}

       if(util.isElementVisible(agreementPaymentStatusField)) {
			
			try {
				util.waitUntilElementDisplay(agreementPaymentStatusField);
				 util.click(agreementPaymentStatusField);
				log("STEP 22:  user can click on edit icon of Agreement Payment Status field", Status.PASS);
			} catch (Exception e) {
				log("STEP 22:  user cannot click on edit icon of Agreement Payment Status field", Status.FAIL);
				throw new RuntimeException("Failed in step 22");
			}
			
			try {
				util.waitUntilElementDisplay(searchableUnchecked);
				if(!util.isElementPresent(searchableChecked)) {
				 util.click(searchableUnchecked);
				}
				log("STEP 23:  user can select searchable checkbox", Status.PASS);
			} catch (Exception e) {
				log("STEP 23:  user cannot select searchable checkbox", Status.FAIL);
				throw new RuntimeException("Failed in step 23");
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 24: user can click on update button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 24: user cannot click on update button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 24");
			}
			
		}
		
		try {
			ClickOnSaveHeader();
			log("STEP 25: user can able to click on Save Header button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: user cannot able to click on Save Header button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
		
		try {
			ClickOnPublish();
			log("STEP 26: user can able to click on Publish button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: user cannot able to click on Publish button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
		
		if (util.isElementPresent(Message)) {
			   log("STEP 27 : 'Views have been published successfully. message is display  ", Status.PASS);
			} else {
			   log("STEP 27: Views have been published successfully. message does notdisplay ", Status.FAIL);
	   	}
	
		}finally {
	    ExtentTestManager.infoWithScreenshot("Closing the custom control popup window");
		driver.close();
		util.switchToParentWindow();
		}
		
		}
	}

	public void projectSelection() {
		commonFunction.projectSelection();
	}
	
	public void verifyAgreementNumber() {
		try {
			Assert.assertTrue(AGREEMENT_NUMBER.contains("ILM"));
			log("Current Agreement Number: " + AGREEMENT_NUMBER);
			   log("STEP 11 : Agreement number starting with 'ILM' ", Status.PASS);
			} catch(AssertionError e) {
			   log("STEP 11: Agreement number not starting with 'ILM' ", Status.FAIL);
	   	}
		
		try {
			int nextNumber = Integer.parseInt(AGREEMENT_NUMBER.substring(3)) + 1;
			NEXT_AGREEMENT_NUMBER = "ILM" + String.format("%04d", nextNumber);
			log("Expected Next Agreement Number: " + NEXT_AGREEMENT_NUMBER);
			} catch(Exception e) {
	   	}
	}
	
	public void verifyNextAgreementNumber() {
		String actualNextAgreementNumber = util.getAttributeValue(agreementNumber, "value");
		try {
			
			Assert.assertTrue(actualNextAgreementNumber.contains("ILM"));
			log("Actual Agreement Number: " + actualNextAgreementNumber);
			   log("STEP 11 : Agreement number starting with 'ILM' ", Status.PASS);
			} catch(AssertionError e) {
			   log("STEP 11: Agreement number not starting with 'ILM' ", Status.FAIL);
	   	}
		
		try {
			Assert.assertEquals(actualNextAgreementNumber, NEXT_AGREEMENT_NUMBER);
			   log("STEP 12 : Agreement number is Unique and incrementing by '1' number ", Status.PASS);
			} catch(AssertionError e) {
			   log("STEP 12: Agreement number is not Unique nor incrementing by '1' number  ", Status.FAIL);
	   	}
		
		try {
			commonFunction.navigateToProjectDeails();
			commonFunction.selectProjectNew(AddProjectPage.PROJECT_NAME);
			log("STEP 13: The button text should be changed to UNARCHIVE", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: Archive Button text or color does not change ", Status.FAIL);
			throw new RuntimeException("Failed in step 13 ");
		}
		
		By btnArchieve = By.xpath("//input[@id='ctl00_ConPHRightTop_radPrjPanels_i0_i0_OBJPROJECTINFO_btnArchive']");
		if(util.isElementVisible(btnArchieve)) {
			try {
				util.waitFor(2000);
				commonFunction.clickOnArchieveButton();
				log("STEP 14: The button text should be changed to UNARCHIVE", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: Archive Button text or color does not change ", Status.FAIL);
				throw new RuntimeException("Failed in step 14 ");
			}
			util.dummyWait(2);
			try {
				commonFunction.clickOnSaveButton();
				log("STEP 15: Project is unarchive and does not display in Poject list DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: Project still displays under the project list", Status.FAIL);
				throw new RuntimeException("Failed in step 15 ");
			}
			}
	}


	By btnAddterm = By.xpath("//input[contains(@id,'_btnAddProjectPhase') or contains(@id,'btnAddLeaseTerm')]");
	By leaseDocumentIframe = By.xpath("//iframe[@name='LeaseDocument']");
	By drpAgreementTerm = By.xpath("//input[contains(@id,'Period_Type_ID_') and @type='text']");

	private void clickOnAddTerm() {
		util.waitUntilElementDisplay(btnAddterm);
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

	public void AddAgreementTerm(Map<String, String> map, String testcaseName) {
		
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
			log("STEP 2:  User can select Agreement Term", Status.PASS);
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
		
		if(!testcaseName.contains("AddPowerFunctionPaymentsNEXTERA")) {
		try {
			clickActiveCheckbox();
			log("STEP 4:  Click on Active Check box", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot check Active Check box", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		}
		try {
			addEffectiveDate(map.get(Excel.EffectiveDate));
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
	
	
	
	By navPaymentInformation = By.xpath("//div[contains(@id,'LSINFO_RadTabStrip1')]//span[contains(text(),'Payment Information')]");
	By navAgreementInformationTab = By.xpath("//div[contains(@id,'LSINFO_RadTabStrip1')]//span[contains(text(),'Agreement Information')]");
	
	public void navigateToAgreementInformationTab() {
		util.click(navAgreementInformationTab);
	}
	
	public void navigateToPaymentInformationTab() {
		util.click(navPaymentInformation);
	}
	
	By paymentTemplateDRP = By.xpath("//input[contains(@id,'MSPAYMENTTERMS_MSDropDown')]/../..//a");
	private void selectPaymentTemplate(String value) {
		if (!commonFunction.checkNA(value)) {
			util.waitUntilElementDisplay(paymentTemplateDRP);
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
		util.dummyWait(2);
	}
	
	
	 By agreementReviewChecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @checked='checked']");
	    By agreementReviewUnchecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @type='checkbox']");
	    
	    By saveButtonAgreement = By.xpath("(//input[contains(@id,'_btnSave') and not(@disabled)])[1]");

		private void clickOnSaveButton() {
			util.click(saveButtonAgreement);
			util.dummyWait(5);
		}
		
	public void addPayment(Map<String, String> map, String testCaseName) {
		try {
			util.reloadPage();
			util.dummyWait(2);
			util.waitUntilPageLoad();
			if (environment.contains("NEXTERA")) {
				if(!util.isElementVisible(agreementReviewChecked)) {
					util.click(agreementReviewUnchecked);
					clickOnSaveButton();
				}
			}
			navigateToPaymentInformationTab();
			log("STEP 13: Navigate to Project >agreement manager >payment Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot Navigate to Project >agreement manager >payment Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			selectPaymentTemplate(map.get(Excel.PaymentTemplate));
			PAYMENT_TEMPLATE = map.get(Excel.PaymentTemplate);
			log("STEP 14: Fill in Add payment template dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: User cannot select the payment template ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
			selectPaymentTerm(map.get(Excel.PaymentTerm));
			log("STEP 15: Fill in Agreement Term DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: User cannot select the Agreement Term from the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		try {
			clickOnAddNewButton();
			log("STEP 16: Click on Add New button", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot click on Add New button", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		try {
			By templateName = By.xpath("//tr[contains(@id,'_LEASE_PAYMENTS_radYALGridControl')]//td[text()='"+map.get(Excel.PaymentTemplate)+"']");
			Assert.assertTrue(util.isElementVisible(templateName));
			log("STEP 17: User can see added payment on the grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 17: User cannot see added payment on the grid", Status.FAIL);
		}
		
		try {
			By paymentAmount = By.xpath("//tr[contains(@id,'_LEASE_PAYMENTS_radYALGridControl')]//td[text()='"+map.get(Excel.PaymentTemplate)+"']/..//td[text()='"+map.get("PaymentAmount")+"']");
			Assert.assertTrue(util.isElementVisible(paymentAmount));
			log("STEP 18: User can see Payment Amount on the grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 18: User cannot see Payment Amount on the grid", Status.FAIL);
		}
		
		
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
	
	public void setPagesizeOfPastPayment(){
		By pagesize = By.xpath("//input[contains(@id,'_CHECKPast_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox') and @type='text']");
		System.out.println("");
		By pageSize50 = By.xpath("//div[contains(@id,'_CHECKPast_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_DropDown')]//li[3]");
		if(util.isElementPresent(pagesize)){
			util.click(pagesize);
			util.click(pageSize50);
		}
		else{
			System.out.println("Page Size option not shows");
		}
		
	}
	
	By pastTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Past']");
	private void clickOnPastTab() {
		util.click(pastTab);
	}
	
	public void verifyPowerPaymentCalculation(Map<String, String> map, String testCaseName) {
		try {
			clickOnPastTab();
			log("STEP 1: User can Expand the Past Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User can Expand the Past Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			for(int i=1; i<ExcelUtils.totalRows-1; i++) {
				String rowName = "Payment"+i;
				rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), "Power_Payment",
						rowName);
				pastPaymentValidation(rowData.get("Period"),rowData.get("PaymentCalculation"));
			}
			sf.assertAll();
			log("STEP 2: All Payments Successfully Added for the Power Function Template ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Payments are Incorrect or not added for the Power Function Template", Status.FAIL);
		}
		
	}
	
	
	public void verifyCPIPayment(Map<String, String> map, String testCaseName) {
		try {
			selectPaymentTemplate(map.get(Excel.PaymentTemplate));
			PAYMENT_TEMPLATE = map.get(Excel.PaymentTemplate);
			log("STEP 1: Fill in Add payment template dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot select the payment template ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			selectPaymentTerm(map.get(Excel.PaymentTerm));
			log("STEP 2: Fill in Agreement Term DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select the Agreement Term from the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			clickOnAddNewButton();
			log("STEP 3: Click on Add New button", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on Add New button", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			By templateName = By.xpath("//tr[contains(@id,'_LEASE_PAYMENTS_radYALGridControl')]//td[text()='"+map.get(Excel.PaymentTemplate)+"']");
			Assert.assertTrue(util.isElementVisible(templateName));
			log("STEP 4: User can see added payment on the grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4: User cannot see added payment on the grid", Status.FAIL);
		}
		
		try {
			By paymentAmount = By.xpath("//tr[contains(@id,'_LEASE_PAYMENTS_radYALGridControl')]//td[text()='"+map.get(Excel.PaymentTemplate)+"']/..//td[text()='"+map.get("PaymentAmount")+"']");
			Assert.assertTrue(util.isElementVisible(paymentAmount));
			log("STEP 5: User can see Payment Amount on the grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot see Payment Amount on the grid", Status.FAIL);
		}
		
		try {
			clickOnPastTab();
			setPagesizeOfPastPayment();
			util.waitUntilLoaderDisappear();
			log("STEP 6: User can Expand the Past Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User can Expand the Past Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			for(int i=1; i<ExcelUtils.totalRows-1; i++) {
				String rowName = "Payment"+i;
				rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.NEXTERA_PAYMENT_INFORMATION), "CPI_Payment",
						rowName);
				pastPaymentValidation(rowData.get("Period"),rowData.get("PaymentCalculation"));
			}
			sf.assertAll();
			log("STEP 7: All Payments Successfully Added for the CPI Template ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: Payments are Incorrect or not added for the CPI Template", Status.FAIL);
		}
	}
	
}
