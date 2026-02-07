package pages.ProjectSetup;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddAgreementPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER, AGREEMENT_TITLE;

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
	By firstAgreementTypePopUp1 = By.xpath("(//div[contains(@id,'leaseInfo_Lease_Type_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
	
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
	By firstAgreementStatusPopUp = By.xpath("(//div[contains(@id,'leaseInfo_Lease_Status_ID_radYALDropDownList_DropDown')]/..//li[not(contains(text(),'Select One'))])[1]");
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
	By firstOperatingCompany = By.xpath("(//*[contains(@id,'_YALComboBox_DropDown')]/.//li[not(contains(text(),'Select One'))])[1]");

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
	
	By saveButton = By.xpath("//input[contains(@id,'_btnSave') and not(@disabled)]");

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
			}
			commonFunction.projectSelection();
			log("STEP 1:  Navigate to Menu - Agreement Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot Navigate to Menu - Agreement Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		
		if(util.isElementVisible(firstAgreement)) {
			try {
				Actions act = new Actions(driver);
				List<WebElement> agreements=driver.findElements(agreementList);
				System.out.println(agreements.size());
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				for (int i = 0; i < agreements.size(); i++) {
			    	util.waitUntilElementDisplay(firstAgreement);
			    	util.click(firstAgreement);

WebElement web = wait.until(ExpectedConditions.visibilityOfElementLocated(firstAgreement));
    web = wait.until(ExpectedConditions.elementToBeClickable(firstAgreement));

			    	act.moveToElement(web).contextClick().perform();
			    	System.out.println("Right Clicked");
			    	util.waitFor(150);
			    	util.click(deleteAgreement);
			    	util.dummyWait(1);
			   
				}
				log("STEP 2:  User can delete all the existing agreements", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot delete all the existing agreements", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		
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
	
	
}
