package pages.Administration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddNewPredefinedClausesPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public AddNewPredefinedClausesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navAdministration = By.xpath("//span[text()='Administration']");
	By navPredefinedClauses = By.xpath("//span[text()='Pre-defined Clauses']");
	By btnAddNew = By.xpath("//input[contains(@id,'_AddClause')]");
	By txtClauseName = By.xpath("//input[contains(@id,'ClauseName') and @type='text']");
	By drpClauseCategory = By.xpath("//input[contains(@id,'ClauseCategory_radYALDropDownList_Input') and @type='text']");
	By txtOrderNumber = By.xpath("//input[contains(@id,'txtClauseOrderBy') and @type='text']");
	By checkBoxAllowModification = By.xpath("//input[contains(@id,'Allow_Modification') and @type='checkbox']");
	By checkBoxStipulationType = By.xpath("(//*[contains(@id,'Stipulation_Type_radYALListBox')]/..//input)[1]");
	By btnSave = By.xpath("//input[contains(@id,'btnSaveClause')]");
	By switchContentFrame = By.xpath("//iframe[contains(@id,'_contentIframe')]");

	public void NavigateToPredefinedClauses() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navPredefinedClauses);
		util.click(navPredefinedClauses);
	}

	public void ClickOnAddNew() {
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
		util.waitFor(500);
	}

	public void AddClauseName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtClauseName, value);
	}

	public void SelectClauseCategory(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpClauseCategory, value);
	}

	public void AddOrderNumber(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOrderNumber, value);
	}

	public void ClickOnAllowModificationCheckbox() {
		util.waitUntilElementDisplay(checkBoxAllowModification);
		util.click(checkBoxAllowModification);
	}

	public void ClickOnStipulationTypeCheckbox() {
		util.waitUntilElementDisplay(checkBoxStipulationType);
		util.click(checkBoxStipulationType);
	}
	
    public void addDescription(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(switchContentFrame, value);
	}
	
	public void ClickOnSave() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.waitFor(500);
	}

	public void AddNewClause(Map<String, String> map, String testcaseName) {
		try {
			NavigateToPredefinedClauses();
			log("STEP 1:  User can navigate to Pre-defined Clauses", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Pre-defined Clauses", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		By clause = By.xpath("//*[contains(@id,'CLAUSES_rgROGrid_ctl00')]/..//*[text()='" + map.get(Excel.ClauseName) + "']");

		if (!util.isElementVisible(clause)) {
			try {
				ClickOnAddNew();
				util.waitFor(500);
				log("STEP 2:  User can click on Add New button", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on Add New button", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

			try {
				AddClauseName(map.get(Excel.ClauseName));
				log("STEP 3:  User can enter the Clause Dispay Name", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot enter the Clause Display Name", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				SelectClauseCategory(map.get(Excel.ClauseCategory));
				log("STEP 4:  User can select the Clause Category", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot select the Clause Category", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				AddOrderNumber(map.get(Excel.OrderNumber));
				log("STEP 5:  User can enter Order Number", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot enter Order Number", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				ClickOnAllowModificationCheckbox();
				log("STEP 6:  User can check Allow Modification Checkbox", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot check Allow Modification Checkbox", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}

			try {
				ClickOnStipulationTypeCheckbox();
				log("STEP 7:  User can check Stipulation Type Checkbox", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot check Stipulation Type Checkbox", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				addDescription(map.get(Excel.Description));
				log("STEP 8:  User can enter Description", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot enter Description", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				ClickOnSave();
				util.waitFor(500);
				Assert.assertTrue(util.isElementVisible(clause));
				log("STEP 9:  User can click on Save button", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9: User cannot click on Save button", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
		}else {
			log("Record "+map.get(Excel.ClauseName)+" is already present.");
		}
		
		By editClause = By.xpath("(//*[contains(@id,'CLAUSES_rgROGrid_ctl00')]/..//*[text()='" + map.get(Excel.ClauseName) + "']/..//input)[1]");

		try {
			util.click(editClause);
			util.waitFor(500);
			log("STEP 10:  User can click on check box to update the record", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10: User cannot click on check box to update the record", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			addDescription(map.get("Update Description"));
			log("STEP 11:  User can enter Description", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot enter Description", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			ClickOnSave();
			util.waitFor(500);
			log("STEP 12:  User can click on Save button", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
	}
	

	

}
