package pages.InfoByParcelReport;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewPayeeInfoPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
    public static String AGREEMENT_NUMBER;
    public static String AGREEMENT_STATUS, AGREEMENT_TYPE, LANDOWNER;
    
	public AddNewPayeeInfoPage(WebDriver driver) {
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
	By agreementStatus = By.xpath("//input[contains(@id,'_Lease_Status') and @type='text']");
	By agreementType = By.xpath("//input[contains(@id,'_Lease_Type') and @type='text']");
	By agreementNumberPopUp = By.xpath("//span[contains(@id,'leaseInfo_Lease_Number')]/input[contains(@id,'leaseInfo_Lease_Number') and @type='text']");

	public void navigateToAgreementInformationALT() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.dummyWait(1);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navAgreementInformation);
	}
	
	public void navigateToAgreementInformationROW() {
		util.dummyWait(10);
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navLeaseManager);
		util.click(navLeaseManager);
	}
	
	By parcelTractInformationTab = By.xpath("//div[contains(@id,'RadTabStripLO')]//span[text()='Parcel Information' or text()='Tract Information']");
	private void clickOnParcelOrTractInfoTab(){
		util.click(parcelTractInformationTab);
	}
	By availableTract = By.xpath("//div[contains(@id,'TRACTSPanel')]//*[contains(@id,'TRACTS_Arrow')]");
	private void selectAvailableTract(String value){
		util.selectValueFromDropdownCheckboxContains(availableTract, value);
		util.waitFor(1000);
		util.click(availableTract);
	}
	By availableTractInputbox = By.xpath("//input[contains(@id,'_TRACTS_Input')]");
	private void selectAvailableTractROW(String value){
		util.waitForWebElementToBePresentReturn(availableTractInputbox, 30).click();
		util.waitForWebElementToBePresentReturn(availableTractInputbox, 30).sendKeys(value);
		util.dummyWait(10);
		util.waitForWebElementToBePresentReturn(availableTractInputbox, 30).sendKeys(Keys.ENTER);
		util.waitForWebElementToBePresentReturn(availableTractInputbox, 30).sendKeys(Keys.TAB);
	}
	By addAvailableTract = By.xpath("//input[contains(@id,'_ImageButton2')]");
	private void clickOnAddButtonAvailableTract(){
		util.click(addAvailableTract);
	}
	By successMessageAvailableTract = By.xpath("//span[contains(@id,'usrTractMessage')]");
	private void verifySuccessMessageAvailableTract(){
		util.waitUntilLoaderDisappear();
		util.waitForWebElementToBePresent(successMessageAvailableTract, IMPLICIT_WAIT);
		Assert.assertTrue(util.getText(successMessageAvailableTract).toLowerCase().contains("added to"),
				"Available tract is not added successfully.");
	}
	
	public void addPayeeInformation(Map<String, String> map, String testCaseName) {
		try {
			AGREEMENT_NUMBER= util.getAttributeValue(agreementNumber, "value");
			AGREEMENT_STATUS= util.getAttributeValue(agreementStatus, "value");;
			log("STEP 1:  Navigate to Menu - Agreement Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot Navigate to Menu - Agreement Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		// Parcel Information tab
		try {
			clickOnParcelOrTractInfoTab();
			if(testCaseName.toLowerCase().contains(row)) {
				selectAvailableTractROW(map.get(Excel.AvailableTract));
			} else {
				selectAvailableTract(map.get(Excel.AvailableTract));
			}
			log("STEP 1: Fill in Available Parcel(s) DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot select Available Parcel(s) from the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			clickOnAddButtonAvailableTract();
			verifySuccessMessageAvailableTract();
			log("STEP 2: click on Add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Add button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		if(environment.contains("NEXTERA")) {
			util.reloadPage();
			util.dummyWait(2);
			util.waitUntilPageLoad();
			if(!util.isElementVisible(agreementReviewChecked)) {
				util.click(agreementReviewUnchecked);
				clickOnSaveButton();
			}
		}

	}

	By existingContactClose = By.xpath("//a[contains(@id,'LESSOR_Arrow')]");
	By existingContact = By.xpath("//Input[contains(@id,'LESSOR_Input')]");
	private void selectExistingContact(String value) {
		if (!commonFunction.checkNA(value)) {
			util.dummyWait(10);
			util.selectValueFromDropdownLandowner(existingContact, value);
			util.click(existingContactClose); // need to click on dropdown icon
		}
	}
	
	By addPayeeButton = By.xpath("//input[contains(@id,'btnAddLessor')]");
	private void clickOnAddButton() {
		util.click(addPayeeButton);
	}
	By successMessage = By.xpath("//span[contains(@id,'usrLesseeMessage')]");
	private void verifySuccessPayeeMessage(String env) {
		util.waitForWebElementToBePresent(successMessage, 20);
		String message = util.getText(successMessage);
		if(env.toLowerCase().contains("row")||env.toLowerCase().contains("tra")) {
			Assert.assertEquals(message, "Lessor has been added to Lease", "Lessor success message mismatched");
		} else if(env.contains("ATWELL") ||env.contains("ORION")  ) {
			Assert.assertEquals(message, "Landowner has been added to Lease", "Landowner success message mismatched");
		}else {
			Assert.assertEquals(message, "Landowner has been added to Agreement", "Landowner success message mismatched");
		}
	}
	
	 By agreementReviewChecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @checked='checked']");
	    By agreementReviewUnchecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @type='checkbox']");
	    
	    By saveButton = By.xpath("(//input[contains(@id,'_btnSave') and not(@disabled)])[1]");

		private void clickOnSaveButton() {
			util.click(saveButton);
			util.dummyWait(5);
		}
	
	public void addLandownerInformation(Map<String, String> map, String testCaseName) {
		// Lanowner Information tab
		try {
			AGREEMENT_NUMBER= util.getAttributeValue(agreementNumber, "value");
			AGREEMENT_TYPE= util.getAttributeValue(agreementType, "value");;
			selectExistingContact(map.get(Excel.LandownerName));
			LANDOWNER=map.get(Excel.LandownerName);
			log("STEP 1: Fill in Landowner DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot select Existing Landowner", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

	try {
		clickOnAddButton();
		verifySuccessPayeeMessage(testCaseName);
		log("STEP 2: Click on Add", Status.PASS);
	} catch (Exception e) {
		log("STEP 2: User cannot click on Add", Status.FAIL);
		throw new RuntimeException("Failed in step 2");
	}
	
	if(environment.contains("NEXTERA")) {
		util.reloadPage();
		util.dummyWait(2);
		util.waitUntilPageLoad();
		if(!util.isElementVisible(agreementReviewChecked)) {
			util.click(agreementReviewUnchecked);
			clickOnSaveButton();
		}
	}

	}
	
}
