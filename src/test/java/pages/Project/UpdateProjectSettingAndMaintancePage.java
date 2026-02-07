package pages.Project;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class UpdateProjectSettingAndMaintancePage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public UpdateProjectSettingAndMaintancePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	// Project Settings And Maintence
	By tabProjectSettingsAndMaintence = By.xpath("//span[contains(text(),'Project Settings & Maintenance')]");
	By editOther = By.xpath(
			"//input[@id='ctl00_ConPHRightTop_radPrjPanels_i2_i0_ProjectSettings_radYALGridControl_ctl00_ctl04_EditButton']");
	By editRoyaltyProcessing = By.xpath(
			"//*[contains(@id,'_ProjectSettings_radYALGridControl_')]//*[text()='Royalty Processing']/..//*[@title='Edit']");
	By drpRoyaltyProcessing = By.xpath(
			"//input[contains(@id,'_EditFormControl_Setting_Value_ID_radYALDropDownList_Input')]");
	By btnUpdate = By.xpath(
			"//input[contains(@id,'_EditFormControl_btnUpdate')]");

	By successMessage = By.xpath("*//div//span[contains(text(),'Changes saved successfully!')]");
	By getEditRotaltyProcessMsg = By.xpath("*//div//span[contains(text(),'Changes saved successfully!')]");

	public void setRoyaltyProcessing(String royaltyProcessing) {
		util.inputText(drpRoyaltyProcessing, royaltyProcessing);
		util.pressENTERkey();
	}

	public void updateProjectSettingAndMaintence(Map<String, String> map) {

		try {
			util.click(tabProjectSettingsAndMaintence);
			log("STEP 1: User can expand Project Setting and Maintenance Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand Project Setting and Maintenance Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}

		try {
			if(util.isElementVisible(editRoyaltyProcessing)) {
			util.click(editRoyaltyProcessing);
			}else {
				util.click(editOther);
			}
			log("STEP 2: User can click on edit icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on edit icon", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			setRoyaltyProcessing(map.get("Royalty Processing"));
			log("STEP 3: User can select the setting option", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select the setting option", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			util.click(btnUpdate);
			log("STEP 4: User can click on update button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot click on update button", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		

		// Verify Royalty Processing Changes Successfuly
		util.waitUntilElementDisplay(successMessage);
		String getEditRotaltyProcessMsg = driver
				.findElement(By.xpath("*//div//span[contains(text(),'Changes saved successfully!')]")).getText().trim();
		if (getEditRotaltyProcessMsg.contains("Changes saved successfully!")) {
			System.out.println("Edit Royalty Processing Changes Successfully !!!");
			log("STEP 5: Edit Royalty Processing Changes Successfully ", Status.PASS);
		} else {
			System.out.println("Failed to Edit Royalty Processing Changes !!!");
			log("STEP 5: Failed to Edit Royalty Processing Changes ", Status.FAIL);
			throw new RuntimeException("Failed in step 5 ");
		}
		Assert.assertTrue(getEditRotaltyProcessMsg.contains("Changes saved successfully!"),
				"Failed to Edit Royalty Processing Changes !!!");

	}

}
