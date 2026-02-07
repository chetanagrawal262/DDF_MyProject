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

public class AddKeyDatePage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public AddKeyDatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By btnProjectSchedule = By.xpath(
			"//*[contains(@id,'radPrjPanels')]/..//a[normalize-space()='Project Schedule' or normalize-space()='Project Key Dates (Milestones)'] | //*[contains(@id,'radPrjPanels')]/..//a[normalize-space()='Project Dates & Additional Information']");
	By btnProjectScheduleDOT = By.xpath(
			"//a[normalize-space()='Project Key Dates (milestones)'] | //a[normalize-space()='Project Dates']");
	By editProjectSchedule = By.xpath("//table//tbody//tr//td//input[contains(@name,'PRJKEYDATES$radYALGridControl$ctl00$ctl04$EditButton')]");
	By txtExpectedDate = By.xpath("//input[contains(@name,'ProjectKeyDatesGrid$Expected_Date$dateInput')]");
	By txtActualDate = By.xpath("//input[contains(@name,'Actual_Date$dateInput')]");
	By txtExpectedEnd = By.xpath("//input[contains(@name,'Expected_End_Date$dateInput')]");
	By txtActualEnd = By.xpath("//input[contains(@name,'Actual_End_Date$dateInput')]");
	By btnUpdate = By.xpath("//input[contains(@name,'IDEditProjectKeyDatesGrid$btnUpdate')]");

	By successMessage = By.xpath("*//div//span[contains(text(),'Changes saved successfully!')]");

	public void clickProjectSchedule(String TestCaseName) {
		try {
			util.click(btnProjectSchedule);
		} catch (Exception e) {
			util.click(btnProjectScheduleDOT);
		}
		
	}

	public void editPrjectSchecule() {
		
			util.click(editProjectSchedule);
	}
	public void setExpectedDate(String value) {
		if (!commonFunction.checkNA(value)) {
		util.inputText(txtExpectedDate, value);
		}
	}

	public void setActualDate(String value) {
		if (!commonFunction.checkNA(value)) {
		util.inputText(txtActualDate, value);
		}
	}

	public void setExpectedEnd(String value) {
		if (!commonFunction.checkNA(value)) {
		util.inputText(txtExpectedEnd, value);
		}
	}

	public void setAcutalEnd(String value) {
		if (!commonFunction.checkNA(value)) {
		util.inputText(txtActualEnd, value);
		}
	}

	public void clickUpdate() {
		util.click(btnUpdate);
	}

	public void addKeyDate(Map<String, String> map,String TestcaseName) {
		if (TestcaseName.equals("AddKeyDOT")) {
			util.click(btnProjectScheduleDOT);
		} else {
				
				util.click(btnProjectSchedule);
			
		}
		
		if(util.isElementVisible(editProjectSchedule)) {
		try {
			editPrjectSchecule();
			log("STEP 1:  User can click on edit button on the Project Schedule panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on edit button on the Project Schedule panel  ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		if(util.isElementVisible(txtExpectedDate)) {
		try {
			setExpectedDate(map.get(Excel.ExpectedDate));
			log("STEP 2:User can enter value in Expected Start Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot enter value in Expected Start Date field ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		}
		
		if(util.isElementVisible(txtActualDate)) {
		try {
			setActualDate(map.get(Excel.ActualDate));
			log("STEP 3:User can enter value in Actual Start Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot enter value in Actual Start Date field ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		}
		
		if(util.isElementVisible(txtExpectedEnd)) {
		try {
			setExpectedEnd(map.get(Excel.ExpectedEnd));
			log("STEP 4:User can enter value in Expected End Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter value in Expected End Date field ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		}
		
		if(util.isElementVisible(txtActualEnd)) {
		try {
			setAcutalEnd(map.get(Excel.ActualEnd));
			log("STEP 5:User can enter value in Actual End Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot enter value in Actual End Date field ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		}
		
		try {
			clickUpdate();
			log("STEP 6:User can click on update button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot click on update button", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		util.dummyWait(3);

		// Verify Add Key Date Changes Successfuly
		util.waitUntilElementDisplay(successMessage);
		String getEditRotaltyProcessMsg = driver
				.findElement(By.xpath("*//div//span[contains(text(),'Changes saved successfully!')]")).getText().trim();
		if (getEditRotaltyProcessMsg.contains("Changes saved successfully!")) {
			System.out.println("Add Key Date Changes Successfully !!!");
			log("STEP 7:  Add Key Date Changes Successfullys", Status.PASS);
		} else {
			System.out.println("Failed to Add Key Date !!!");
			log("STEP 7: Failed to Add Key Date  ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		Assert.assertTrue(getEditRotaltyProcessMsg.contains("Changes saved successfully!"),
				"Failed to Add Key Date !!!");
		}
		else {
			log("Key Dates not configured", Status.SKIP);
		}
	}

}
