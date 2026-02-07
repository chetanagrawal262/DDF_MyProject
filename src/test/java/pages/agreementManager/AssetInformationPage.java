package pages.agreementManager;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AssetInformationPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public AssetInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	

	By addButton = By.xpath("//img[contains(@id,'YALASSETINFO_radYALGridControl_') and @alt='Add new record']");
	By drpAssetType = By.xpath("//input[contains(@id,'EditFormControl_ASSET_TYPE_radYALDropDownList_Input') and  @type='text']");
	By txtAssetName = By.xpath("//input[contains(@id,'EditFormControl_Asset_Name') and  @type='text']");
	By txtQuantity = By.xpath("//input[contains(@id,'EditFormControl_Quantity') and  @type='text']");
	By txtUnitCost = By.xpath("//input[contains(@id,'EditFormControl_Unit_Cost') and  @type='text']");
	By txtDescription = By.xpath("//textarea[contains(@id,'EditFormControl_Desc')]");
	By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert')]");
	By btnEditOwnership = By.xpath("//input[contains(@id,'_btnEditOwnership')]");
	By ifrmaeOwnership = By.xpath("//iframe[@name='LOOwnership']");
	By btnSave = By.xpath("//input[contains(@id,'_HeaderTemplate_btnsave')]");
	By btnClose = By.xpath("//a[@title='Close']");
	By linkShowDetails = By.xpath("//tr[contains(@id,'_LEASE_PAYMENTS_radYALGridControl')]/..//a[text()='Show Details']");
	By leaseDocumentIframe = By.xpath("//iframe[@name='LeaseDocument']");
	By drpOwnershipType = By.xpath("//input[@id='Ownership_ID_YALComboBox_Input']");
	By addedOwnershipType = By.xpath("//div[@id='Ownership_ID_YALComboBox_DropDown']/..//input[1]");
	By btnSaveTerm = By.xpath("//input[@name='btnSave']");

	private void clickOnAddButton() {
		util.click(addButton);
		util.waitFor(2000);
	}

	private void selectAssetType(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(drpAssetType, value);
		}
	}
	
	private void addAssetName(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtAssetName, value);
		}
	}
	
	private void addQuantity(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtQuantity, value);
		}
	}
	
	private void addUnitCost(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtUnitCost, value);
		}
	}
	
	private void addDescription(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtDescription, value);
		}
	}
	
	private void clickOnInsertButton() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
	}
	
	private void clickOnEditOwnership() {
		util.waitUntilElementDisplay(btnEditOwnership);
		util.click(btnEditOwnership);
	}
	
	private void switchToIframeOwnership() {
		util.waitUntilElementDisplay(ifrmaeOwnership);
		util.switchToIframe(ifrmaeOwnership);
	}
	
	By percentage = By.xpath("//input[contains(@id,'txt') and @type='text' and @onblur]");
	private void addAllPercentage(String value) {
		List<WebElement> allEle = util.getWebElements(percentage);
		for(WebElement wb : allEle) {
			wb.click();
			wb.sendKeys(value);
		}
	}
	
	private void clickOnSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
	}
	
	private void closePopUp() {
		util.switchToDefaultContent();
		util.click(btnClose);
	}

	private void clickOnShowDetailsLink() {
		util.waitUntilElementDisplay(linkShowDetails);
		util.click(linkShowDetails);
	}
	
	private void switchToIframeLeaseTerm() {
		util.waitUntilElementDisplay(leaseDocumentIframe);
		util.switchToIframe(leaseDocumentIframe);
	}
	
	private void selectOwnershipType() {
		util.click(drpOwnershipType);
		util.click(addedOwnershipType);
	}
	
	private void clickOnSaveTermButton() {
		util.click(btnSaveTerm);
		
	}
	
	public void addAssetInformation(Map<String, String> map, String testcaseName) {
		try {
			clickOnAddButton();
			log("STEP 1:  User can click on Add New Record button", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot click on Add New Record button", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			selectAssetType(map.get("AssetType"));
			log("STEP 2:  User can select Asset Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Asset Type", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			addAssetName(map.get("AssetName"));
			log("STEP 3:  User can add Asset Name", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot add Asset Name", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			addQuantity(map.get("Quantity"));
			log("STEP 3:  User can add Quantity", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot add Quantity", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			addUnitCost(map.get("UnitCost"));
			log("STEP 4:  User can add Unit Cost", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot add Unit Cost", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			addDescription(map.get("Description"));
			log("STEP 5:  User can add Description", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot add Description", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			clickOnInsertButton();
			util.dummyWait(2);
			log("STEP 6:  User can click on Insert Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on Insert Button", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		
		try {
			clickOnEditOwnership();
			switchToIframeOwnership();
			log("STEP 7:  User can click on Edit Ownership button", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot click on Edit Ownership button", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			addAllPercentage(map.get("Ownership"));
			log("STEP 8:  User can add Ownership", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot add Ownership", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			clickOnSaveButton();
			util.dummyWait(2);
			closePopUp();
			log("STEP 9:  User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			clickOnShowDetailsLink();
			switchToIframeLeaseTerm();
			log("STEP 10:  User can click on Show Details Link", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot click on Show Details Link", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			selectOwnershipType();
			log("STEP 11:  User can select Ownership Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot select Ownership Type", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			clickOnSaveTermButton();
			util.dummyWait(2);
			closePopUp();
			log("STEP 12:  User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
	}

	
	
}
