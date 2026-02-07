package pages.Project;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AffectedAssetsPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public AffectedAssetsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By expandAffectedAssetPanel = By.xpath(
			"//*[contains(@id,'radPrjPanels')]/..//a[normalize-space()='Affected/Involved Assets']");
	By drpAssetType = By.xpath("//input[contains(@id,'_AffectedPanel_Asset_type_radYALDropDownList_Input')]");
	By drpSpecificAssets = By.xpath("//input[contains(@id,'_AffectedPanel_Specific_Asset_Input')]");
	By txtComment = By.xpath("//textarea[contains(@id,'_AffectedPanel_Comments')]");
	By btnAdd = By.xpath("//input[contains(@id,'_AffectedPanel_ImageButton')]");
	By spinner = By.xpath("//div[contains(@id,'_ConPHRightTop_RadMultiPage') and @class='RadAjax RadAjax_WebBlue']");
	
	By btnDelete = By.xpath("//input[contains(@id,'_AffectedPanel_YALProjectRelatedAssets_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
	By iframDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnCancle = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By successMessage = By.xpath("*//div//span[contains(text(),'Changes saved successfully!')]");

	public void expandAffectedAssetPanel() {
		util.waitUntilElementDisplay(expandAffectedAssetPanel);
		util.click(expandAffectedAssetPanel);
	}

	public void selectAssetType(String value) {
		if (!commonFunction.checkNA(value)) {
		util.inputTextAndPressTab(drpAssetType, value);
		util.waitUntilElementDisappear(spinner);
		}
	}

	public void selectSpecificAssets(String value) {
		if (!commonFunction.checkNA(value)) {
		util.inputTextAndPressTab(drpSpecificAssets, value);
		}
	}

	public void setComments(String value) {
		if (!commonFunction.checkNA(value)) {
		util.inputText(txtComment, value);
		}
	}

	public void clickOnAdd() {
		util.click(btnAdd);
		util.waitUntilElementDisappear(spinner);
	}

	public void addAffectedAssets(Map<String, String> map,String TestcaseName) {
		
		if (!TestcaseName.contains("AddLineAssets")) {
			
		try {
			expandAffectedAssetPanel();
			log("STEP 1: User can expand Affected/Involved Assets Panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand Affected/Involved Assets Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}
		}
		
		try {
			selectAssetType(map.get("AssetType"));
			log("STEP 2: User can select Asset Type", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Asset Type", Status.FAIL);
			throw new RuntimeException("Failed in step 2 ");
		}
		
		try {
			selectSpecificAssets(map.get("SpecificAsset"));
			log("STEP 3: User can select Specific Asset", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Specific Asset", Status.FAIL);
			throw new RuntimeException("Failed in step 3 ");
		}
		
		try {
			setComments(map.get(Excel.Comment));
			log("STEP 4: User can enter Comment", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter Comment", Status.FAIL);
			throw new RuntimeException("Failed in step 4 ");
		}
		
		try {
			clickOnAdd();
			log("STEP 5: User can click on Add Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on Add Button", Status.FAIL);
			throw new RuntimeException("Failed in step 5 ");
		}
		
		try {
			By assetNo = By.xpath("(//tr[contains(@id,'_AffectedPanel_YALProjectRelatedAssets_radYALGridControl')]/..//td[text()='"+map.get("Asset#")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(assetNo));
			log("STEP 6: User can see Asset # in the Grid View", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: User cannot see Asset # in the Grid View", Status.FAIL);
		}
		
		try {
			By specificAsset = By.xpath("(//tr[contains(@id,'_AffectedPanel_YALProjectRelatedAssets_radYALGridControl')]/..//td[text()='"+map.get("SpecificAsset")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(specificAsset));
			log("STEP 7: User can see Specific Asset Value in the Functional Location Column", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: User cannot see Specific Asset Value in the Functional Location Column", Status.FAIL);
		}
		
		try {
			By specificAsset = By.xpath("(//tr[contains(@id,'_AffectedPanel_YALProjectRelatedAssets_radYALGridControl')]/..//td[text()='"+map.get("SpecificAsset")+"'])[2]");
			Assert.assertTrue(util.isElementVisible(specificAsset));
			log("STEP 8: User can see Specific Asset Value in the Description Column", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8: User cannot see Specific Asset Value in the Description Column", Status.FAIL);
		}
		
		try {
			By comment = By.xpath("(//tr[contains(@id,'_AffectedPanel_YALProjectRelatedAssets_radYALGridControl')]/..//td[text()='"+map.get("Comment")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(comment));
			log("STEP 9: User can see Comment Value in the grid view", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9: User cannot see Comment Value in the grid view", Status.FAIL);
		}
	}
	
	
	
	public void ClickonDelete() {
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
	}

	public void ClickonOk() {
		util.waitUntilElementDisplay(btnOk);
		util.click(btnOk);
		util.waitUntilElementDisappear(spinner);
	}
	
	public void deleteAffectedAssets(String TestcaseName) {
		try {
			ClickonDelete();
			log("STEP 1: User can click on 'x' icon to delete the record ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User can click on 'x' icon to delete the record ", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}

		try {
			ClickonOk();
			log("STEP 2: User can click on the ok button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User can click on the ok button", Status.FAIL);
			throw new RuntimeException("Failed in step 2 ");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(successMessage));
			log("STEP 3: User can see success message 'Changes saved successfully!'", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3: User cannot see success message 'Changes saved successfully!'", Status.FAIL);
		}
	}

}
