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

public class AddProjectStateCountyPage extends BasePage {
	TestUtil util;
	CommonFunction commonFunction;

	public AddProjectStateCountyPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);

	}

	By btnAddNewRecord = By.xpath("(//img[contains(@id,'PROJECTSTATECOUNTY_radYALGridControl')])[1]");
	By drpState = By.xpath("//input[contains(@id,'EditFormControl_RadState_Input')]");
	By drpCounty = By.xpath("//input[contains(@id,'EditFormControl_RadCounty_Input')]");
	By txtCounty = By.xpath("//input[contains(@id,'_EditFormControl_txtCounty') and @type='text']");
	By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");

	By btnEdit = By.xpath("//input[contains(@name,'EditButton')]");
	By EditState = By.xpath("//tr[contains(@id,'EditFormControl')]//input[contains(@name,'RadState')]");
	By EditCounty = By.xpath("(//tr[contains(@id,'EditFormControl')]//input[contains(@name,'RadCounty')])[1]");
	By btnUpdateCounty = By.xpath("//input[contains(@id,'btnUpdate')]");
	By tableCountyName = By.xpath("((//table[@class='rgMasterTable'])[1]//tbody)[last()]//tr[1]//td[5] |  //tr[contains(@id,'_PROJECTSTATECOUNTY_radYALGridControl_')]/..//td[5]");
	By tableStateName = By.xpath("((//table[@class='rgMasterTable'])[1]//tbody)[last()]//tr[1]//td[4] | //tr[contains(@id,'_PROJECTSTATECOUNTY_radYALGridControl_')]/..//td[4]");
	By btnDeleteSTCT = By.xpath("//input[contains(@id,'DeleteAlignment')]");
	By deletePopupFrame = By.xpath("//iframe[contains(@name,'confirm')]");
	By deleteOk = By.xpath("//a[contains(@onClick,'confirm')]//span[text()='OK']");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	String tableValue = "//table//tbody//tr//td[text()='%s']";

	public void setState(String state) throws InterruptedException {
		util.selectValueFromDropdown(drpState, state);
		util.pressENTERkey();
	}

	public void setCounty(String County) throws InterruptedException {
		util.selectValueFromDropdown(drpCounty, County);
		util.pressENTERkey();
	}

	public void addCounty(String County) throws InterruptedException {
		util.inputTextAndPressTab(txtCounty, County);
	}
	
	public void updateState(String updateState) {
		util.selectDropDownValue(EditState, updateState);
	}

	public void updateCounty(String updateCity) {
		util.selectDropDownValue(EditCounty, updateCity);
	}

	public void clickInsetButton() {
		util.click(btnInsert);
	}

	public void addStateAndCountyInformation(Map<String, String> map) throws InterruptedException {
		
		try {
			util.waitUntilElementDisplay(btnAddNewRecord);
			util.click(btnAddNewRecord);
			log("STEP 1: User can click on Add New Record button of Project states and County information panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on Add New Record button of Project states and County information panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}
		try {
			setState(map.get(Excel.State));
			util.waitUntilLoaderDisappear();
			log("STEP 2:  State added diplays in the state column    ", Status.PASS);
		} catch (InterruptedException e) {
			log("STEP 2: Added state is not displayed in the field", Status.FAIL);
			throw new RuntimeException("Failed in step 2 ");
		}
		try {
			if(environment.contains("DOM")) {
				addCounty(map.get(Excel.County));
			}else {
			setCounty(map.get(Excel.County));
			}
			log("STEP 3: County added diplays in the column field", Status.PASS);
		} catch (InterruptedException e) {
			log("STEP 3:  Added county is not displayed in the field", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			clickInsetButton();
			util.waitUntilLoaderDisappear();
			log("STEP 4: User can click on Insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User can not click on Insert Button", Status.FAIL);
			throw new RuntimeException("Failed in step 4 ");
		}
		
		try {
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Verify changes saved successfully.");
			log("STEP 5: Changes saved successfully message displayed ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: Changes saved successfully message does not displayed", Status.FAIL);
		}
		
		if(!environment.contains("DOM")) {
		try {
			Assert.assertTrue(util.isElementPresent(String.format(tableValue, map.get(Excel.County))), "State and County Information is added successfully.");
			log("STEP 6: State and County Information is added sucessfully ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: State and County Information is not added sucessfully", Status.FAIL);
		}
		}
	}

	public void updateStateAndCountyInformation(Map<String, String> map) throws InterruptedException {
		
		try {
			util.waitUntilElementDisplay(btnEdit);
			util.click(btnEdit);
			util.waitUntilLoaderDisappear();
			log("STEP 7: User can click on Edit button", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User can not click on edit button", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			updateState(map.get(Excel.UpdateState));
			log("STEP 8: User can update value in the State DD     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User can not Update value in the State DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		util.waitUntilLoaderDisappear();
		try {
			if(environment.contains("DOM")) {
                addCounty(map.get(Excel.UpdateCounty));
			}else {
			updateCounty(map.get(Excel.UpdateCounty));
			}
			log("STEP 9: User can select county", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot update county value", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		try {
			util.click(btnUpdateCounty);
			util.waitUntilLoaderDisappear();
			log("STEP 10: Click On update", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: Upate button not clickable", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
			log("STEP 11: Changes saved successfully message displayed ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11: Changes saved successfully message does not displayed", Status.FAIL);
		}
		
		if(!environment.contains("DOM")) {
		try {
			By tableCountyName = By.xpath("//tr[contains(@id,'PROJECTSTATECOUNTY_radYALGridControl_')]/..//td[text()='"+map.get(Excel.UpdateCounty)+"']");	
			Assert.assertTrue(util.isElementVisible(tableCountyName));
			log("STEP 12: State and County Information is updated sucessfully ",Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: State and County Information is not updated", Status.FAIL);
		}
		}
		
		// Delete updated County-state
		try {
			util.waitUntilElementDisplay(btnDeleteSTCT);
			util.click(btnDeleteSTCT);
			util.waitUntilLoaderDisappear();
			log("STEP 13: User can click on delete icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot click on delete icon", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
            util.click(deleteOk);
			util.waitUntilLoaderDisappear();
			log("STEP 11: User can click on ok button", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot click on ok button", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}

		try {
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Verify changes saved successfully.");
			log("STEP 12: State and County Information is deleted sucessfully", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: State and County Information is not deleted sucessfully", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		

	}


}
