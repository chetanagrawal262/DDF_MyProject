package pages.agreementManager;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class MilestoneDatePage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public MilestoneDatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By editMilestoneButton = By.xpath("//input[contains(@id,'EditButton')]");
	By milestoneDatesTab = By.xpath("//div[contains(@id,'LSINFO_radPanels')]//span[text()='Milestone Dates']");

	private void openMilestoneDateSection() {
		if (!util.isElementVisible(editMilestoneButton, 5)) {
			util.click(milestoneDatesTab);
			util.waitFor(2000);
		}
	}

	private void clickOnEditMilestoneButton() {
		util.click(editMilestoneButton);
	}

	By expectedDateText = By.xpath("//input[contains(@id,'Expected_Date_dateInput') and @type='text']");
	By actualDateText = By.xpath("//input[contains(@id,'Actual_Date_dateInput') and @type='text']");

	public void setExpectedDate(String value) {
		if (!commonFunction.checkNA(value)) {
		util.inputText(expectedDateText, value);
		}
	}
	
	private void setActualDate(String value) {
		if (!commonFunction.checkNA(value)) {
		util.inputText(actualDateText, value);
		}
	}
	By updateMilestoneButton = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate')]");

	private void clickOnUpdateMilestoneButton() {
		util.click(updateMilestoneButton);
	}

	By milestoneMessage = By.xpath("//span[contains(@id,'LeaseDates_usrMessage')] | //span[contains(@id,'_grdCrossingMilestones_usrMessage')]");

	private void verifySuccessMessageMilestoneDate() {
		util.waitForWebElementToBePresent(milestoneMessage, IMPLICIT_WAIT);
		if (!util.getText(milestoneMessage).equalsIgnoreCase("Changes saved successfully!")) {
			throw new RuntimeException();
		}
	}

	public void addMilestoneDate(Map<String, String> map, String testcaseName) {

		try {
			openMilestoneDateSection();
			log("STEP 1:  Click on milestone dates pannel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Click on milestone dates panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			clickOnEditMilestoneButton();
			log("STEP 2:  Click on edit on the Date name under the Key Dates/Project Schedule", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot Click on edit icon under the Key Dates/Project Schedule", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		if(util.isElementPresent(expectedDateText)) {
		try {
			setExpectedDate(map.get(Excel.ExpectedDate));
			log("STEP 3: User can Enter the Expected start Date", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot Enter the Expected start Date ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}}
		

		try {
			if(util.isElementPresent(actualDateText)) {
			setActualDate(map.get(Excel.ActualDate));
			}
			clickOnUpdateMilestoneButton();
			verifySuccessMessageMilestoneDate();
			log("STEP 4: User can Enter the actual start Date and click update ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:User cannot Enter the actual start Date and click update ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
	}

}
