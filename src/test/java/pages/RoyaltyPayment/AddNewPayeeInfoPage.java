package pages.RoyaltyPayment;

import java.util.List;
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

public class AddNewPayeeInfoPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String LANDOWNER;

	public AddNewPayeeInfoPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By turbineCount = By.xpath("//td[text()='Turbines']/..//strong[text()='1']");

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
		if(environment.contains("ATWELL") ||environment.contains("ORION")) {
			Assert.assertEquals(message, "Landowner has been added to Lease", "Landowner success message mismatched");
		}else {
		Assert.assertEquals(message, "Landowner has been added to Agreement", "Landowner success message mismatched");
		}
	}
	
	By editOwnershipButton = By.xpath("//img[@alt='Edit Ownership'] | //input[contains(@id,'btnEditPayStatus')]");
	private void clickOnEditOwnershipButton() {
		util.click(editOwnershipButton);
	}
	
	By editLandOwnerIframe = By.xpath("//iframe[@name = 'LOOwnership']");
	private void switchToEditLandOwnerIframe() {
		util.waitForWebElementToBePresent(editLandOwnerIframe, IMPLICIT_WAIT);
		util.switchToIframe(editLandOwnerIframe);
	}
	
	By surfacePercentage = By.xpath("//input[contains(@id,'Surface_Ownership_All_Tracts') and @type='text']");
	private void addAllSurfacePercentage(String value) {
		List<WebElement> allEle = util.getWebElements(surfacePercentage);
		for(WebElement wb : allEle) {
			wb.click();
			wb.sendKeys(value);
		}
	}
	
	By windPercentage = By.xpath("//input[contains(@id,'Wind_Ownership_All_Tracts') and @type='text']");
	private void addAllWindPercentage(String value) {
		List<WebElement> allEle = util.getWebElements(windPercentage);
		for(WebElement wb : allEle) {
			wb.click();
			wb.sendKeys(value);
		}
	}
	
	By cropPercentage = By.xpath("//input[contains(@id,'Crop_Ownership_All_Tracts') and @type='text']");
	private void addAllCropPercentage(String value) {
		List<WebElement> allEle = util.getWebElements(cropPercentage);
		for(WebElement wb : allEle) {
			wb.click();
			wb.sendKeys(value);
		}
	}
	
	public void addSurfaceWindCropInEditOwner(Map<String, String> map) {
		addAllSurfacePercentage(map.get(Excel.SurfacePercentage));
		addAllWindPercentage(map.get(Excel.WindPercentage));
		addAllCropPercentage(map.get(Excel.CropPercentage));
	}
	
	By saveButtonAllocationLandownerTab = By.xpath("//table[contains(@id,'OwnershipByEntity')]//input[contains(@id,'btnUpdateAll')]");
	private void clickOnSaveButtonAllocationLandOwnerTab() {
		util.click(saveButtonAllocationLandownerTab);
	}
	
	By closeLandOwnershipForm = By.xpath("//div[contains(@id,'LOOwnership')]//a[@title='Close']");
	private void closeLandOwnershipIframe() {
		util.switchToDefaultContent();
		util.click(closeLandOwnershipForm);
		util.waitFor(5000);
	}
	
	By landownerInformationTab = By.xpath("//div[contains(@id,'RadTabStripLO')]//span[text()='Landowner Information']");
	private void clickOnLandOwnerInfoTab(){
		util.click(landownerInformationTab);
		util.dummyWait(2);
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
	
	By addAvailableTract = By.xpath("//input[contains(@id,'_ImageButton2')]");
	private void clickOnAddButtonAvailableTract(){
		util.click(addAvailableTract);
	}
	
	
	 By agreementReviewChecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @checked='checked']");
	    By agreementReviewUnchecked = By.xpath("//input[contains(@id,'_chkLegalVerified') and @type='checkbox']");
	    
	    By saveButton = By.xpath("(//input[contains(@id,'_btnSave') and not(@disabled)])[1]");

		private void clickOnSaveButton() {
			util.click(saveButton);
			util.dummyWait(5);
		}
		
	public void addPayeeInformation(Map<String, String> map, String testCaseName) {
		
		try {
			selectExistingContact(map.get(Excel.LandownerName));
			LANDOWNER =map.get(Excel.LandownerName);
			log("STEP 1: User can select Existing Contact", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot select Existing Contact", Status.FAIL);
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
		
		// Parcel Information tab
		try {
			clickOnParcelOrTractInfoTab();
			selectAvailableTract(map.get(Excel.AvailableTract));
			log("STEP 3: Fill in Available Parcel(s) DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Available Parcel(s) from the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			clickOnAddButtonAvailableTract();
			log("STEP 4: click on Add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on Add button", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		 try {	
	    	  driver.navigate().refresh();
	  		   clickOnLandOwnerInfoTab();
				log("STEP 5: User can navigate back to Landowner Information Tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot navigate back to Landowner Information Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
		 if (environment.contains("ORSTED")) {
				try {
					Assert.assertTrue(util.isElementVisible(turbineCount));
					log("STEP 6: User can see the Correct Turbine Count in the Agreement Summay", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 6: User cannot see the Correct Turbine Count in the Agreement Summay", Status.FAIL);
				}
			}
		 
			try {
				clickOnEditOwnershipButton();
				switchToEditLandOwnerIframe();
				log("STEP 7: click on Edit Ownership button", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot click on Edit Ownership button", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				addSurfaceWindCropInEditOwner(map);
				log("STEP 8: Fill the value in 'Surface % , Wind % , Crop%' field for 'Allocation by Landowner", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot fill the value in 'Surface % , Wind % , Crop%' field for 'Allocation by Landowner Tab" , Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				clickOnSaveButtonAllocationLandOwnerTab();
				util.dummyWait(1);
				log("STEP 9: click on Save button", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot click on Save button", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			closeLandOwnershipIframe();
			
			
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
