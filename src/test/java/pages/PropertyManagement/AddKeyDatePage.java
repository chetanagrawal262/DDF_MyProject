package pages.PropertyManagement;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddKeyDatePage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	

	public AddKeyDatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}	
	
	By EditKeyDate = By.xpath("//input[contains(@id,'_TRACTDATES_radYALGridControl_ctl00_ctl04_EditButton')]");
	By txtExpectedDate = By.xpath("//input[contains(@name,'EditFormControl$Expected_Date$dateInput')]");
	By txtProjecedDate = By.xpath("//input[contains(@name,'$EditFormControl$Projected_Date$dateInput')]");
	By txtActualDate = By.xpath("//input[contains(@name,'$EditFormControl$Actual_Date$dateInput')]");
	By txtAmount = By.xpath("//input[contains(@name,'$EditFormControl$AMOUNT')]");
	By btnUpdate = By.xpath("//input[contains(@name,'EditFormControl$btnUpdate')]");
	
	public void editKeyDates() {
		
		util.click(EditKeyDate);
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

	public void setProjectedDate(String value) {
	if (!commonFunction.checkNA(value)) {
	util.inputText(txtProjecedDate, value);
	}
	}

	public void setAmount(String value) {
	if (!commonFunction.checkNA(value)) {
	util.inputText(txtAmount, value);
	}
}

	public void clickUpdate() {
	util.click(btnUpdate);
}
	
	public void KeyDates(Map<String, String> map,String TestcaseName) {
		
		if(util.isElementVisible(EditKeyDate)) {
		try {
			editKeyDates();
			log("STEP 1:  User can click on edit button on the Key Dates panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on edit button on the Key Dates panel  ", Status.FAIL);
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
		
		if(util.isElementVisible(txtProjecedDate)) {
		try {
			setProjectedDate(map.get(Excel.ProjectedDate));
			log("STEP 4:User can enter value in Expected End Date field", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter value in Expected End Date field ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		}
		
		if(util.isElementVisible(txtAmount)) {
		try {
			setAmount(map.get(Excel.Amount));
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
		}else {
			log("Key Date not configured to display", Status.SKIP);
		}
	}
	
	
}
