package pages.agreementManager;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.CommonConstant;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class AddNewPayeeInfoPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	String agreementAcres, GRANTOR, LAST_NAME, CONTACT_NO;
	public String leaseAcres="52";
	boolean isDisplayedOwnershipColumn;

	public AddNewPayeeInfoPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	

	By existingContactClose = By.xpath("//a[contains(@id,'LESSOR_Arrow')]");
	By existingContact = By.xpath("//Input[contains(@id,'LESSOR_Input')]");
	By leasedAcres = By.xpath("//tr[contains(@id,'RadGridTract1_radYALGridControl_ctl00__0')]/..//td[count(//table/thead/tr/th[.='Leased Acres']/preceding-sibling::th)+1]");
	By paidAcres = By.xpath("//tr[contains(@id,'RadGridTract1_radYALGridControl_ctl00__0')]/..//td[count(//table/thead/tr/th[.='Paid Acres']/preceding-sibling::th)+1]");
	By linkAgreementName = By.xpath("//a[contains(@id,'changeEntName')]");
	By iframeEntity = By.xpath("//iframe[@name='ChangeEntity']");
	By txtGrantor = By.xpath("//input[contains(@id,'_txtNewEntName')]");
	By btnSaveGrantor = By.xpath("//input[@id='idChangeEntityName_btnUpdate']");
	By btnClose = By.xpath("//a[@title='Close']");
	
	private void selectExistingContact(String value) {
		if (!commonFunction.checkNA(value)) {
			util.dummyWait(10);
			util.selectValueFromDropdownLandowner(existingContact, value);
			util.click(existingContactClose); // need to click on dropdown icon
		}
	}
	
	private void selectExistingLandowner(String value) {
		if (!commonFunction.checkNA(value)) {
			util.click(existingContact);
			util.dummyWait(2);
			util.inputText(existingContact, value);
			util.dummyWait(1);
			WebElement inputField = util.getElement(existingContact);
			util.pressDownkey();
			inputField.sendKeys(Keys.TAB); // need to click on dropdown icon
		}
	}
	
	By addPayeeButton = By.xpath("//input[contains(@id,'btnAddLessor')]");
	private void clickOnAddButton() {
		util.click(addPayeeButton);
		util.dummyWait(1);
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
	
	By addNewPayeeButton = By.xpath("//input[contains(@id,'btnAddLandowner')]");
	private void clickOnAddNewButton() {
		util.click(addNewPayeeButton);
	}
	By newLandOwnerIframe = By.xpath("//iframe[@name='AddLandowner']");
	private void switchToLandOwnerIframe() {
		util.waitForWebElementToBePresent(newLandOwnerIframe, IMPLICIT_WAIT);
		util.switchToIframe(newLandOwnerIframe);
	}
	By surfaceOwnership = By.xpath("//input[@name='Pct_Ownership']");
	private void addSurfaceOwnership(String value) {
		if (!commonFunction.checkNA(value)) {
		if(util.isElementPresent(surfaceOwnership)) {
			util.inputText(surfaceOwnership, value);
		}}
	}
	By windOwnership = By.xpath("//input[@name='PCT_Ownership_Wind']");
	private void addWindOwnership(String value) {
		if (!commonFunction.checkNA(value)) {
		if(util.isElementPresent(windOwnership)) {
			util.inputText(windOwnership, value);
		}}
	}
	By cropOwnership = By.xpath("//input[@name='PCT_Ownership_Crop']");
	private void addCropOwnership(String value) {
		if (!commonFunction.checkNA(value)) {
		if(util.isElementPresent(cropOwnership)) {
			util.inputText(cropOwnership, value);
		}
		}
	}
	By contactType = By.xpath("//input[contains(@name,'Title_of_Rep') and @type='text']");
	private void selectContactType(String value) {
		if (!commonFunction.checkNA(value)) {
		if(util.isElementPresent(contactType)) {
			util.inputTextAndPressTab(contactType, value);
		}}
	}
	By entityLastName = By.xpath("//input[@id='ENTITY_Last_Name']");
	private void enterEntityLastName(String value) {
		if (!commonFunction.checkNA(value)) {
		util.inputText(entityLastName, value);
		}
	}
	By entityFirstName = By.xpath("//input[@id='ENTITY_First_Name'] | //input[@id='ENTITY_Corporation_Trust']");
	private void enterEntityFirstName(String value) {
		util.inputText(entityFirstName, value);
	}
	
	By entityName = By.xpath("//input[@id='ENTITY_Corporation_Trust']");
	private void enterEntityName(String value) {
		util.inputText(entityName, value);
	}
	
	By vendorNo = By.xpath("//input[@id='ENTITY_Vendor_ID']");
	private void enterVendorNo(String value) {
		util.inputText(vendorNo, value);
	}
	
	By contactNo = By.xpath("//input[contains(@id,'_txtContactNum') and @type='text']");
	private void enterContactNo(String value) {
		util.inputTextAndPressTab(contactNo, value);
	}
	
	By txtVendor = By.xpath("//input[contains(@id,'ENTITY_Vendor_ID') and @type='text']");
	public void AddVendor(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtVendor, value);
		
    }
	
	public void addLandOwnerDetails(Map<String, String> map) {
		addSurfaceOwnership(map.get(Excel.SurfaceOwnership));
		log("Surface ownership entered");
		addWindOwnership(map.get(Excel.WindOwnership));
		log("Wind ownership entered");
		addCropOwnership(map.get(Excel.CropOwnership));
		log("Crop ownership entered");
		if(!environment.contains("ORION")) {
		selectContactType(map.get(Excel.ContactType));
		log("Contact Type selected");
		}
		
		enterEntityLastName(map.get(Excel.LastName));
		LAST_NAME = map.get(Excel.LastName);
		log("Last Name entered");
		
		if(environment.contains("ORSTED")) {
			if(util.isElementPresent(entityName)) {
				enterEntityName(map.get(Excel.EntityName));
			}else {
				enterEntityFirstName(map.get(Excel.FirstName));
			}
		}else {
		enterEntityFirstName(map.get(Excel.FirstName));
		log("First Name entered");
		}
		if(!environment.contains("ORION")) {
		if (util.isElementVisible(txtVendor)) {
			AddVendor(util.randomNumber());
		}
		}
	}
	
	
	By iframeSaveButtonLO = By.xpath("//input[@id='btnSaveLO']");
	private void clickOnSaveButtonLandOwner() {
		util.click(iframeSaveButtonLO);
	}
	
	private void verifySuccessMessageLO() {
		commonFunction.waitForSuccessMessage();
		if (!commonFunction.getSuccessMessage().equals("New landowner was created and added to the Agreement.") &&
                !commonFunction.getSuccessMessage().equals("New landowner was created and added to the lease.") && !commonFunction.getSuccessMessage().equals("New landowner was created and added to the Lease.")) {
			throw new RuntimeException();
		}
	}
	By closeLandOwnerForm = By.xpath("//div[contains(@id,'AddLandowner')]//a[@title='Close']");
	private void closeLandOwnerIframe() {
		util.switchToDefaultContent();
		util.click(closeLandOwnerForm);
		util.waitFor(5000);
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
	
	By ownershipPercentage = By.xpath("//input[contains(@id,'Ownership_Share_All_Tracts') and @type='text']");
	private void addAllOwnershipPercentage(String value) {
		List<WebElement> allEle = util.getWebElements(ownershipPercentage);
		for(WebElement wb : allEle) {
			wb.click();
			wb.sendKeys(value);
		}
	}
	
	public void addSurfaceWindCropInEditOwner(Map<String, String> map) {
		addAllSurfacePercentage(map.get(Excel.SurfacePercentage));
		addAllWindPercentage(map.get(Excel.WindPercentage));
		addAllCropPercentage(map.get(Excel.CropPercentage));
		addAllOwnershipPercentage(map.get(Excel.OwnershipPercentage));
	}
	
	By depositoryIDDRP = By.xpath("//input[contains(@id,'Depository_ID') and @type='text']");
	private void addDepositoryIDDRP(String value) {
		List<WebElement> allEle = util.getWebElements(depositoryIDDRP);
		for(WebElement wb : allEle) {
			wb.sendKeys(value);
		}
	}
	By payStatusDRP = By.xpath("//input[contains(@id,'_PayStatus') and @type='text']");
	private void addPayStatusDRP(String value) {
		List<WebElement> allEle = util.getWebElements(payStatusDRP);
		for(WebElement wb : allEle) {
			wb.sendKeys(value);
		}
	}
	By reasonDRP = By.xpath("//input[contains(@id,'ddl_Reason') and @type='text']");
	private void addReasonDRP(String value) {
		List<WebElement> allEle = util.getWebElements(reasonDRP);
		for(WebElement wb : allEle) {
			wb.sendKeys(value);
		}
	}
	
	By payStatusComments = By.xpath("//textarea[contains(@id,'txtComments')]");
	private void addPayStatusComments(String value) {
		List<WebElement> allEle = util.getWebElements(payStatusComments);
		for(WebElement wb : allEle) {
			wb.sendKeys(value);
		}
	}
	
	public void addPayStatusInEditOwner(Map<String, String> map) {
		addDepositoryIDDRP(map.get(Excel.DepositoryId));
		addPayStatusDRP(map.get(Excel.PayStatus));
		addReasonDRP(map.get(Excel.Reason));
		addPayStatusComments(map.get(Excel.PayStatusComments));
	}
	
	By saveButtonAllocationLandownerTab = By.xpath("//table[contains(@id,'OwnershipByEntity')]//input[contains(@id,'btnUpdateAll')]");
	private void clickOnSaveButtonAllocationLandOwnerTab() {
		util.click(saveButtonAllocationLandownerTab);
	}
	
	By allocationByParcelTab = By.xpath("//span[text()='Allocation By Parcel']");
	private void clickOnAllocationByParcelTab() {
		util.click(allocationByParcelTab);
	}
	By saveButtonParcelTab = By.xpath("//table[contains(@id,'ProjectDetails')]//input[contains(@id,'btnUpdateAll')]");
	private void clickOnSaveButtonParcelTab() {
		util.click(saveButtonParcelTab);
	}
	
	By turbineOwnershipTab = By.xpath("//span[text()='Turbine Ownership']");
	private void clickOnTurbineOwnershipTab() {
		util.click(turbineOwnershipTab);
	}
	
	By saveButtonTurbineTab = By.xpath("//input[contains(@id,'radGridTurbine_ctl00_ctl02_ctl00_btnUpdateAll')]");
	private void clickOnSaveButtonTurbineTab() {
		util.click(saveButtonTurbineTab);
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
	By parcelTractInformationTab = By.xpath("//div[contains(@id,'RadTabStripLO')]//span[text()='Parcel Information' or text()='Tract Information' or text()='Record Information']");
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
	
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navAgreementInformation = By.xpath("//a//span[contains(text(),'Agreement Information')] | //a//span[contains(text(),'Entity Information')]");
	
	public void navigateToAgreementInformationALT() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.dummyWait(1);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navAgreementInformation);
	}
	
	
	public void editOwnership(Map<String, String> map,String testCaseName) {
		
		driver.navigate().refresh();
		clickOnLandOwnerInfoTab();
		
		if(testCaseName.contains("ORSTED") || testCaseName.contains("ALT") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")){
			
			 try {
					TurnOnDesignMode();
					log("STEP 18:  user can turn on design mode", Status.PASS);
				} catch (Exception e) {
					log("STEP 18:  user cannot turn on design mode", Status.FAIL);
					throw new RuntimeException("Failed in step 18");
				}
			 
			 try {
					util.click(landownerGridConfigIcon);
					util.switchToChildWindow();
					log("STEP 19:  User can click on Grid Config Icon", Status.PASS);
				} catch (Exception e) {
					log("STEP 19:  user cannot click on Grid Config Icon", Status.FAIL);
					throw new RuntimeException("Failed in step 19");
				}
			 
			 try {
				 Assert.assertTrue(util.isElementVisible(ownershipColmnConfig));
					if (util.isElementVisible(ownershipColmnIsDisplayChecked)) {
						isDisplayedOwnershipColumn = true;
					} else {
						isDisplayedOwnershipColumn = false;
					}
					driver.close();
					util.switchToParentWindow();
					log("STEP 20:  User can see the Ownership % column Name on the Manage Grid Config page ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 20:  user cannot see the Ownership % column Name on the Manage Grid Config page", Status.FAIL);
					
				}
			 
			 if (isDisplayedOwnershipColumn==true) {
			 try {
                     Assert.assertTrue(util.isElementVisible(ownershipColumnOnGrid));
					log("STEP 21:  User can see the Ownership % column on Landowner grid  ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 21:  user cannot see the Ownership % column on Landowner grid ", Status.FAIL);
				}
			 }else {
				 try {
                     Assert.assertFalse(util.isElementVisible(ownershipColumnOnGrid));
					log("STEP 21:  User cannot see the Ownership % column on Landowner grid  ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 21:  user can see the Ownership % column on Landowner grid ", Status.FAIL);
				}
			 }
		}
		
		if(util.isElementVisible(editOwnershipButton)) {
		try {
			
			clickOnEditOwnershipButton();
			switchToEditLandOwnerIframe();
			log("STEP 22: click on Edit Ownership button", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: User cannot click on Edit Ownership button", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
		
		try {
			if(testCaseName.toLowerCase().contains(CommonConstant.row)| testCaseName.contains("TRA")) {
				addPayStatusInEditOwner(map);
			} else {
				addSurfaceWindCropInEditOwner(map);
			}
			log("STEP 23: Fill the value in 'Surface % , Wind % , Crop%' field for 'Allocation by Landowner", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: User cannot fill the value in 'Surface % , Wind % , Crop%' field for 'Allocation by Landowner Tab" , Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
		
		try {
			util.dummyWait(1);
			clickOnSaveButtonAllocationLandOwnerTab();
			util.dummyWait(1);
			log("STEP 24: click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 24: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		
		if(testCaseName.toLowerCase().contains(CommonConstant.alt)) {
			try {
				clickOnAllocationByParcelTab();
				log("STEP 25: Fill the value in 'Allocation By Parcel' tab fields", Status.PASS);
			} catch (Exception e) {
				log("STEP 25: User cannot fill the value in 'Allocation By Parcel' tab fields", Status.FAIL);
				throw new RuntimeException("Failed in step 25");
			}
			
			try {
				clickOnSaveButtonParcelTab();
				log("STEP 26: click on Save button", Status.PASS);
			} catch (Exception e) {
				log("STEP 26: User cannot click on Save button", Status.FAIL);
				throw new RuntimeException("Failed in step 26");
			}
			
			if(util.isElementPresent(turbineOwnershipTab)) {
			try {
				clickOnTurbineOwnershipTab();
				log("STEP 27: Fill the value in 'Turbine Ownership' tab fields", Status.PASS);
			} catch (Exception e) {
				log("STEP 27: User cannot fill the value in 'Turbine Ownership' tab fields", Status.FAIL);
				throw new RuntimeException("Failed in step 27");
			}
			try {
				clickOnSaveButtonTurbineTab();
				
				log("STEP 28: click on Save button", Status.PASS);
			} catch (Exception e) {
				log("STEP 28: User cannot click on Save button", Status.FAIL);
				throw new RuntimeException("Failed in step 28");
			}
			}else {
				log("No Turbine Tab found");
			}
		}
		closeLandOwnershipIframe();
		}
	}

	public void addGrantor(Map<String, String> map,String testCaseName) {
		try {
			util.waitUntilElementDisplay(linkAgreementName);
			util.click(linkAgreementName);
			log("STEP 29: User can click on Link Agreement Name", Status.PASS);
		} catch (Exception e) {
			log("STEP 29: User cannot click on Link Agreement Name", Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}
		
		try {
			util.switchToIframe(iframeEntity);
			GRANTOR="Entity1";
			util.inputTextAndPressTab(txtGrantor, GRANTOR);
			log("STEP 30: User can enter Grantor Name", Status.PASS);
		} catch (Exception e) {
			log("STEP 30: User cannot enter Grantor Name", Status.FAIL);
			throw new RuntimeException("Failed in step 30");
		}
		
		try {
			util.click(btnSaveGrantor);
			log("STEP 31: User can save Grantor Name", Status.PASS);
		} catch (Exception e) {
			log("STEP 31: User cannot save Grantor Name", Status.FAIL);
			throw new RuntimeException("Failed in step 31");
		}
		
		util.switchToDefaultContent();
		util.click(btnClose);
		By agreementNo = By.xpath("//td[text()='"+AddNewInformationPage.AGREEMENT_NUMBER.trim()+"']/parent::tr");
		util.click(agreementNo);
		util.dummyWait(1);
		try {
			By GrantorDataPoint = By.xpath("(//text()[contains(.,'Grantor')]/following-sibling::strong[text()='"+GRANTOR+"'])[1]");
			Assert.assertTrue(util.isElementVisible(GrantorDataPoint));
			log("STEP 32: User can see Grantor Data point in Agreement List with value", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 32: User cannot see Grantor Data point in Agreement List with value", Status.FAIL);
		}
	}
	
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By landownerGridConfigIcon = By.xpath("//span[contains(@onclick,'YALLEASELANDOWNERS')]");
	By ownershipColmnConfig = By.xpath("//td[(text()='Ownership %' or text()='Ownership_Share')]");
	By ownershipColmnIsDisplayChecked = By.xpath("(//td[(text()='Ownership %' or text()='Ownership_Share')]/..//input[contains(@id,'Display') and not(contains(@id,'Empty') or contains(@id,'Mobile')) and @type='checkbox' and @checked='checked'])[1]");
	By ownershipColumnOnGrid = By.xpath("//*[contains(@id,'RadGridLO_radYALGridControl')]/..//th[.='Amount Paid']/preceding-sibling::th[.='Ownership %']  | //*[contains(@id,'RadGridLO_radYALGridControl')]/..//th[.='Amount Paid']/preceding-sibling::th[.='Ownership Share']  | //*[contains(@id,'RadGridLO_radYALGridControl')]/..//th[.='Amount Paid']/preceding-sibling::th[.='Payment %'] ");
	public void TurnOnDesignMode() {
    	util.waitUntilElementDisplay(btnDesignMode);
    	util.click(btnDesignMode);
    	util.dummyWait(2);
    }
	
	By rightClickOnParcel = By.xpath("//tr[contains(@id,'RadGridTract1_radYALGridControl_ctl00__0')]");
	By openParcel = By.xpath("//div[contains(@id,'LSINFO_RadMenuTract_detached')]/..//*[text()='Open']");
	By iframeParcel = By.xpath("//iframe[@name='RadWindowAddContact']");
	By txtLeasedAcres = By.xpath("//*[contains(text(),'Leased Acres')]/..//input[@type='text']");	
	By btnSave = By.xpath("//input[contains(@id,'_TractType_btnInternalSave')]");
	By btnRefreshedAcreage = By.xpath("//input[contains(@id,'btnRefreshAcreage')]");
	
	
	public void ClickonOpen() {
		WebElement web = driver.findElement(rightClickOnParcel);
		util.waitUntilElementDisplay(rightClickOnParcel);
		Actions act = new Actions(driver);
		act.moveToElement(web).contextClick().build().perform();
		util.waitUntilElementDisplay(openParcel);
		util.click(openParcel);
	}

	public void checkVisibilityOfLabel(String fieldName) {
		By label = By.xpath("//table[contains(@id,'_RadGridLO_radYALGridControl_')]//td[contains(text(),'"
				+ LAST_NAME + "')]/..//td[contains(normalize-space(),'" + fieldName + "')]");
		Assert.assertFalse(util.isElementVisible(label));

	}

	public void checkAddedValue(String fieldName) {
		By label = By.xpath("//table[contains(@id,'_RadGridLO_radYALGridControl_')]//td[contains(text(),'"
				+ LAST_NAME + "')]/..//td[contains(normalize-space(),'" + fieldName + "')]");
		Assert.assertTrue(util.isElementVisible(label));

	}

	By btnSaveEdit = By.xpath("//input[@id='btnSaveLO']");
	 public void Save() {
	    	util.waitUntilElementDisplay(btnSaveEdit);
			util.click(btnSaveEdit);
			util.dummyWait(2);	
	    }
	 
	    By btnAddNewAddress = By.xpath("//img[@id='YALCONTACTWITHNAME_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
		By txtAddressLine1 = By.xpath("//input[contains(@id,'_EditFormControl_Address_Line_1') and @type='text']");
		By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert') and @type='submit']");
		By btnEditAddress = By.xpath("(//input[contains(@id,'YALCONTACTWITHNAME_radYALGridControl_ctl00_ctl04_EditButton') and @type='image'])[1]");
		By btnAddContact = By.xpath("//input[contains(@id,'_EditFormControl_btnAddItem') and @type='submit']");
		By txtHomePhone = By.xpath("//input[contains(@id,'_EditFormControl_rptOracleSupplierInfo_ctl01_Home_Phone') and @type='text']");
		By txtCellPhone = By.xpath("//input[contains(@id,'_EditFormControl_rptOracleSupplierInfo_ctl01_Cell_Phone') and @type='text']");
		By txtWorkPhone = By.xpath("//input[contains(@id,'_EditFormControl_rptOracleSupplierInfo_ctl01_Work_Phone') and @type='text']");
		By txtEmail  = By.xpath("//input[contains(@id,'_EditFormControl_rptOracleSupplierInfo_ctl01_Email') and @type='text']"); 
		By chcPreferredContact = By.xpath("(//label[text()='Preferred Contact'])[1]");
		By btnSaveContact = By.xpath("//input[contains(@id,'_EditFormControl_btnSaveItem') and @type='submit']");
		By btnUpdateContact = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
		By btnRefresh = By.xpath("//a[contains(@id,'RadGridLO_radYALGridControl')]");
		
		public void addLandOwnerDetailsOrion(Map<String, String> map) {
			selectContactType(map.get(Excel.ContactType));
			Save();
			util.dummyWait(1);
			util.click(btnAddNewAddress);
			util.dummyWait(1);
			util.inputTextAndPressTab(txtAddressLine1, "Add1");
			util.click(btnInsert);
			util.dummyWait(1);
			util.click(btnEditAddress);
			util.dummyWait(1);
			util.click(btnAddContact);
			util.inputTextAndPressTab(txtHomePhone, "1234543212");
			util.inputTextAndPressTab(txtCellPhone, "6545654321");
			util.inputTextAndPressTab(txtWorkPhone, "6765432128767");
			util.inputTextAndPressTab(txtEmail, "test@gmail.com");
			util.click(chcPreferredContact);
			util.click(btnSaveContact);
			util.dummyWait(1);
			util.click(btnUpdateContact);
		}
		
	 
	public void addPayeeInformation(Map<String, String> map, String AGREEMENT_NUMBER, String testCaseName) {
		
		if(environment.contains("VALARD")) {
			try {
				util.click(existingContact);
				util.dummyWait(2);
				WebElement inputField = util.getElement(existingContact);
				inputField.sendKeys(map.get(Excel.LandownerName));
				util.dummyWait(1);
				util.pressDownkey();
				util.pressENTERkey();
//				selectExistingLandowner(map.get(Excel.LandownerName));
				log("STEP 1: Fill in Landowner DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot select Existing Landowner", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		}else {
			try {
				selectExistingContact(map.get(Excel.LandownerName));
				log("STEP 1: Fill in Landowner DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot select Existing Landowner", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		}
		
		
		try {
			clickOnAddButton();
			verifySuccessPayeeMessage(testCaseName);
			log("STEP 2: Click on Add", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Add", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			clickOnAddNewButton();
			log("STEP 3: Click on Add New", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on Add New", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			switchToLandOwnerIframe();	
			addLandOwnerDetails(map);
			log("STEP 4: Fill the value in all fields", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter the Landowner details", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		if(testCaseName.contains("ALT") || testCaseName.contains("ORION") || testCaseName.contains("ORSTED") || testCaseName.contains("ATWELL")){
			if(util.isElementVisible(contactNo)) {
			try {
				enterContactNo("2343243234");
				log("STEP 5: User can enter Contact No", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot enter Contact No", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			}
		}
		
		try {
			clickOnSaveButtonLandOwner();			
			verifySuccessMessageLO();
			log("STEP 6: click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		if (util.isElementPresent(contactNo)) {
			CONTACT_NO=util.getAttributeValue(contactNo, "value");
		}
		
		try {
			closeLandOwnerIframe();
			By addedRecord = By.xpath("//td[text()='"+AGREEMENT_NUMBER+"']/parent::tr");
			util.click(addedRecord);
			util.dummyWait(2);
			log("STEP 7: click on Close (X) icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot click on Close (X) icon", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		if(testCaseName.contains("ALT") || testCaseName.contains("ORION") || testCaseName.contains("ORSTED") || testCaseName.contains("ATWELL")){
			if (CONTACT_NO != null && !CONTACT_NO.trim().isEmpty()) {
			try {
			By conNoGrid = By.xpath("//table[contains(@id,'_RadGridLO_radYALGridControl_')]//*[contains(text(),'"+LAST_NAME+"')]/../..//td[contains(normalize-space(),'Contact Number')]/..//strong[contains(normalize-space(),'"+CONTACT_NO+"')]");
			Assert.assertTrue(util.isElementVisible(conNoGrid));
			log("STEP 8: User can see added contact no on the payee summary grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8: User cannot see added contact no on the payee summary grid", Status.FAIL);
		}
			}
		}
		
		if(testCaseName.contains("ORION")) {
			
			try {
				
				checkVisibilityOfLabel("Contact Type");		
				log("User cannot see Contact Type field on Payee Summary Grid if no value has been added to it", Status.PASS);
			} catch (AssertionError e) {
				log("User can see Contact Type field on Payee Summary Grid if no value has been added to it", Status.FAIL);
			}
			
			try {
				checkVisibilityOfLabel("Vendor #: N/A");				
				log("User cannot see Vendor # field on Payee Summary Grid if no value has been added to it", Status.PASS);
			} catch (AssertionError e) {
				log("User can see Vendor # field on Payee Summary Grid if no value has been added to it", Status.FAIL);
			}
			
			try {
				checkVisibilityOfLabel("Work phone");			
				log("User cannot see Work phone field on Payee Summary Grid if no value has been added to it", Status.PASS);
			} catch (AssertionError e) {
				log("User can see Work phone field on Payee Summary Grid if no value has been added to it", Status.FAIL);
			}
			
			try {
				checkVisibilityOfLabel("Home phone");
				log("User cannot see Home phone field on Payee Summary Grid if no value has been added to it", Status.PASS);
			} catch (AssertionError e) {
				log("User can see Home phone field on Payee Summary Grid if no value has been added to it", Status.FAIL);
			}
			
			try {
				checkVisibilityOfLabel("Cell phone");
				log("User cannot see Cell phone field on Payee Summary Grid if no value has been added to it", Status.PASS);
			} catch (AssertionError e) {
				log("User can see Cell phone field on Payee Summary Grid if no value has been added to it", Status.FAIL);
			}
			
			try {
				checkVisibilityOfLabel("Fax number");
				log("User cannot see Fax number field on Payee Summary Grid if no value has been added to it", Status.PASS);
			} catch (AssertionError e) {
				log("User can see Fax number field on Payee Summary Grid if no value has been added to it", Status.FAIL);
			}
			
			try {
				checkVisibilityOfLabel("Email");				
				log("User cannot see Email field on Payee Summary Grid if no value has been added to it", Status.PASS);
			} catch (AssertionError e) {
				log("User can see Email field on Payee Summary Grid if no value has been added to it", Status.FAIL);
			}
			
			ExtentTestManager.infoWithScreenshot("Payee Summary Grid Before adding any values into the addrss and phone fields");
			try {
				By edit = By.xpath("//table[contains(@id,'_RadGridLO_radYALGridControl_')]//td[contains(text(),'"+LAST_NAME+"')]/..//a[text()='Edit']");	
				util.click(edit);
				util.switchToChildWindow();
				log("User can click on edit landowner", Status.PASS);
			} catch (Exception e) {
				log("User cannot click on edit landowner", Status.FAIL);
			}
			
			try {
				addLandOwnerDetailsOrion(map);
				driver.close();
			    util.switchToParentWindow();
			    util.click(btnRefresh);
				util.dummyWait(2);
				log("User can Add Contact Type, Email and Phone Values", Status.PASS);
			} catch (Exception e) {
				log("User cannot Add Contact Type, Email and Phone Values", Status.FAIL);
			}
			
			try {
				checkAddedValue(map.get(Excel.ContactType));			
				log("User can see Contact Type field on Payee Summary Grid even if value has been added to it", Status.PASS);
			} catch (AssertionError e) {
				log("User cannot see Contact Type field on Payee Summary Grid even if value has been added to it", Status.FAIL);
			}
			
			try {
				checkAddedValue("Email");				
				log("User can see Email field on Payee Summary Grid even if value has been added to it", Status.PASS);
			} catch (AssertionError e) {
				log("User cannot see Email field on Payee Summary Grid even if value has been added to it", Status.FAIL);
			}
			
			ExtentTestManager.infoWithScreenshot("Payee Summary Grid After adding values into the Home, Work, Cell Phone, Email and Contact Type fields");
			
		}
		// Parcel Information tab
		try {
			clickOnParcelOrTractInfoTab();
			if(testCaseName.toLowerCase().contains(row)) {
				selectAvailableTractROW(map.get(Excel.AvailableTract));
			} else {
				selectAvailableTract(map.get(Excel.AvailableTract));
			}
			log("STEP 7: Fill in Available Parcel(s) DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot select Available Parcel(s) from the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		try {
			clickOnAddButtonAvailableTract();
			verifySuccessMessageAvailableTract();
			log("STEP 8: click on Add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on Add button", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		if(!environment.contains("CONNECTGEN") & !environment.contains("STEELHEAD")){
		if(testCaseName.contains("ALT") || testCaseName.contains("ORION") || testCaseName.contains("ORSTED") || testCaseName.contains("ATWELL")){
			try {
				ClickonOpen();
				log("STEP 9: User can click on Open ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot Open Parcel Info", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				util.dummyWait(3);
				util.switchToIframe(iframeParcel);
				util.inputTextAndPressTab(txtLeasedAcres, leaseAcres);
				log("STEP 10: User can enter Lease Acres ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot enter Lease Acres", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				util.click(btnSave);
				util.dummyWait(1);
				util.switchToDefaultContent();
				util.click(btnClose);
				log("STEP 11: User can click on Save button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User cannot click on Save button", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				util.click(btnRefreshedAcreage);
				
				log("STEP 12: User can click on Refresh Acreage button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User cannot click on Refresh Acreage button", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			
			util.dummyWait(3);
			if(testCaseName.contains("ORSTED") || testCaseName.contains("ORION")) {
				try {
					util.dummyWait(3);
					agreementAcres = driver.findElement(leasedAcres).getText();
					Assert.assertTrue(agreementAcres.contains(leaseAcres));
					log("STEP 13: User can see updated lease acres on the Parcel Information Grid on Payee ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 13: User cannot see updated lease acres on the Parcel Information Grid on Payee", Status.FAIL);
				}
			}
			else {
				try {
					agreementAcres = driver.findElement(paidAcres).getText();
					Assert.assertTrue(agreementAcres.contains(leaseAcres));
					log("STEP 13: User can see updated lease acres on the Parcel Information Grid on Payee ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 13: User cannot see updated lease acres on the Parcel Information Grid on Payee", Status.FAIL);
				}
			}
			
			util.dummyWait(1);
			By totalAcres = By.xpath(
					"//div[contains(@id,'_RadDockTractSS')]//td[text()='Total Acres'] | //div[contains(@id,'_RadDockTractSS')]//td[text()='Total Leased Acres']");
			if(util.isElementVisible(totalAcres)) {
			try {
				By totalAcresValue = By.xpath(
						"//div[contains(@id,'_RadDockTractSS')]//td[text()='Total Acres']/following-sibling::td[contains(.,'"+leaseAcres+"')] | //div[contains(@id,'_RadDockTractSS')]//td[text()='Total Leased Acres']/following-sibling::td[contains(.,'"+leaseAcres+"')]");
				Assert.assertTrue(util.isElementVisible(totalAcresValue));
				log("STEP 14: User can see updated total acres on the Agreement Summary", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 14: User cannot see updated total acres on the Agreement Summary", Status.FAIL);
			}
			}
		}
		}
		
		if(testCaseName.contains("ORSTED")){
			try {
				commonFunction.navigateToProjectDeails();
				log("STEP 15: User can navigate to the Project details", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: User cannot see the option in Menu ", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			try {
				By agreementAcresDataPoint = By.xpath("//*[contains(@id,'RadPageView')]/..//*[contains(text(),'Agreement Acres')]/..//*[contains(text(),'"+agreementAcres+"')]");
				System.out.println((agreementAcresDataPoint));
				Assert.assertTrue(util.isElementVisible(agreementAcresDataPoint));
				log("STEP 16: User can see Agreement Acres Data point in Project Summary", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 16: User cannot see Agreement Acres Data point in Project Summary", Status.FAIL);
			}
			
			try {
				navigateToAgreementInformationALT();
				By addedRecord = By.xpath("//td[text()='"+AddNewInformationPage.AGREEMENT_NUMBER+"']/parent::tr");
				util.click(addedRecord);
				log("STEP 17: User can navigate back to Agreement Page", Status.PASS);
			} catch (Exception e) {
				log("STEP 17: User cannot navigate back to Agreement Page ", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
		}
		
		
		editOwnership(map,testCaseName);

		if(environment.contains("TREATYOAK")) {
			addGrantor(map,testCaseName);
		}
	}


}
