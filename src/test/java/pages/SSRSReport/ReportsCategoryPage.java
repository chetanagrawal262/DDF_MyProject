package pages.SSRSReport;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class ReportsCategoryPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	
	public ReportsCategoryPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navAdministration = By.xpath("//span[text()='Administration']");
	By navReportAdministraion = By.xpath("//span[contains(text(),'Reports Administration')]");
	By navReportPermission = By.xpath("//span[contains(text(),'Reports Permission')]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By titleReports = By.xpath("//b[text()='Reports']");
	By gridConfigIcon = By.xpath("//span[@title='Manage Reports Permission']");
	By drpConfigIcon = By.xpath("(//span[contains(@id,'ddMSReportCategory_ManageComboID')])[1]");
	By btnAddNewRecord = By.xpath("//*[contains(@id,'idManageDD_GridDetails_radYALGridControl')]//a[contains(@id,'lnkAddNewRecord')]");
	By txtLookupDesc = By.xpath("//textarea[contains(@id,'_EditFormControl_Lookup_Desc')]");
	By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
	By btnUpdate = By.xpath("//input[@value='Update']");
	By successMsg = By.xpath("//span[text()='Update successful!']");
	By drpRoles = By.xpath("//input[contains(@id,'DISTRIBUTION_Input')]");
	By btnSavePermission = By.xpath("//input[contains(@id,'idAllReports_YALManageReports_save')and @type='image']");
	
	public void NavigateToReportPermission() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navReportAdministraion);
		util.click(navReportAdministraion);
		util.waitUntilElementDisplay(navReportPermission);
		util.click(navReportPermission);
	}

	public void TurnOnDesignCode() {
		util.waitUntilElementDisplay(btnDesignMode);
		util.click(btnDesignMode);
		util.dummyWait(2);
	}

	public void ClickOnGridIcon() {
		util.waitUntilElementDisplay(gridConfigIcon);
		util.click(gridConfigIcon);
		util.waitUntilPageLoad();
		util.switchToChildWindow();
	}
	
	public void ClickOnDrpConfigIcon() {
		util.waitUntilElementDisplay(drpConfigIcon);
		util.click(drpConfigIcon);
		util.waitUntilPageLoad();
		util.switchToChildWindow1();
	}

	public void ClickOnAddNewRecord() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
	}

	public void AddLookupDesc(String value) {
		if (!commonFunction.checkNA(value))
			util.waitUntilElementDisplay(txtLookupDesc);
			util.inputTextAndPressTab(txtLookupDesc, value);
	}

	public void ClickOnInsertButton() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.dummyWait(1);
	}

	public void selectReportsCategory(String reportName, String category) {
		if (!commonFunction.checkNA(category)) {
			By drpCategory = By.xpath("//td[text()='"+reportName+"']/..//input[contains(@id,'_ddMSReportCategory_YALComboBox_Input')]");
			util.inputText(drpCategory, category);
			WebElement inputField = util.getElement(drpCategory);
			inputField.sendKeys(Keys.DOWN);
			inputField.sendKeys(Keys.ENTER);
			inputField.sendKeys(Keys.TAB);
		}
	}
	
	public void enterReportsDescription(String reportName, String description) {
		if (!commonFunction.checkNA(description)) {
			By txtDesc = By.xpath("//td[text()='"+reportName+"']/..//input[contains(@id,'_Report_Description') and @type='text']");
			util.inputTextAndPressTab(txtDesc, description);
		}
	}
	
	public void ClickOnUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.waitUntilElementDisplay(successMsg);
	}
	
	public void SelectRole(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpRoles, value);
		util.dummyWait(2);
	}

	public void ClickOnSavePermission() {
		util.waitUntilElementDisplay(btnSavePermission);
		util.click(btnSavePermission);
	}
	
	public void addReportsCategory(Map<String, String> map, String testcaseName) {

		try {
			NavigateToReportPermission();
			log("STEP 1: User can Navigate To Report Permission   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User  cannot Navigate To Report Permission ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			TurnOnDesignCode();
			log("STEP 2: User can Turn on design mode ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User  cannot Turn on design mode ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			SelectRole(map.get(Excel.Roles));
			log("STEP 3: User can select Role", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User  cannot select Role ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			Assert.assertTrue(util.isElementVisible(titleReports));
			log("STEP 4: User can see title 'Reports' on Reports permission page ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4: User  cannot see title 'Reports' on Reports permission page ", Status.FAIL);
		}

		try {
			util.reloadPage();
			ClickOnGridIcon();
			log("STEP 5: User can click on Manage Reports Permission Grid Icon ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User  cannot click on Manage Reports Permission Grid Icon ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			ClickOnDrpConfigIcon();
			log("STEP 6: User can click on DropDown Config Icon ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User  cannot click on DropDown Config Icon ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		By reportsCategory = By.xpath("//*[contains(@id,'idManageDD_GridDetails_radYALGridControl')]/td[text()='" +map.get("Category_1")+ "']");
		if(!util.isElementVisible(reportsCategory)) {
			
			try {
				ClickOnAddNewRecord();
				log("STEP 7: user can click on Add New Record Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: user cannot click on Add New Record Button ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				AddLookupDesc(map.get("Category_1"));
				log("STEP 8: user can enter lookup descrition value", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user cannot enter lookup descrition value ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				ClickOnInsertButton();
				log("STEP 9: user can click on Insert Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: user cannot click on Insert Button ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
		}
		
		By reportsCategory2 = By.xpath("//*[contains(@id,'idManageDD_GridDetails_radYALGridControl')]/td[text()='" +map.get("Category_2")+ "']");
		if(!util.isElementVisible(reportsCategory2)) {
			
			try {
				ClickOnAddNewRecord();
				log("STEP 10: user can click on Add New Record Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: user cannot click on Add New Record Button ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				AddLookupDesc(map.get("Category_2"));
				log("STEP 11: user can enter lookup descrition value", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: user cannot enter lookup descrition value ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				ClickOnInsertButton();
				log("STEP 12: user can click on Insert Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: user cannot click on Insert Button ", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			
		}
		driver.close();
		util.switchToChildWindow();
		util.reloadPage();
		util.waitUntilPageLoad();
		 
		try {
			selectReportsCategory(map.get("Report_Name_1"), map.get("Category_1"));
			log("STEP 13: user can select "+map.get("Category_1")+" category for report "+map.get("Report_Name_1")+"", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: user cannot select "+map.get("Category_1")+" category for report "+map.get("Report_Name_1")+"", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			selectReportsCategory(map.get("Report_Name_1"), map.get("Category_2"));
			log("STEP 14: user can select "+map.get("Category_2")+" category for report "+map.get("Report_Name_1")+"", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user cannot select "+map.get("Category_2")+" category for report "+map.get("Report_Name_1")+"", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
			enterReportsDescription(map.get("Report_Name_1"), map.get("Description"));
			log("STEP 15: user can add description "+map.get("Description")+" for report "+map.get("Report_Name_1")+"", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: user cannot add description "+map.get("Description")+" for report "+map.get("Report_Name_1")+"", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		try {
			selectReportsCategory(map.get("Report_Name_2"), map.get("Category_2"));
			log("STEP 16: user can select "+map.get("Category_2")+" category for report "+map.get("Report_Name_2")+"", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: user cannot select "+map.get("Category_2")+" category for report "+map.get("Report_Name_2")+"", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		try {
			ClickOnUpdateButton();
			log("STEP 17: user can click on Update Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user cannot click on Update Button ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		ExtentTestManager.infoWithScreenshot("Selected Reports Category and Description");
		driver.close();
		util.switchToParentWindow();
		
	}
	
	
	public void ClickOnRadioButton(String reportName) {
		By permission = By.xpath("//span[contains(text(),'"+reportName+"')]/..//input[@value='Y']");
		util.waitUntilElementDisplay(permission);
		util.click(permission);
	}
	
	public void checkReportsPermission(Map<String, String> map, String testcaseName) {

		try {
			ClickOnRadioButton(map.get("Report_Name_1"));
			log("STEP 1:  User can set the report permission for "+map.get("Report_Name_1")+"", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User  cannot set the report permission for "+map.get("Report_Name_1")+"", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			ClickOnRadioButton(map.get("Report_Name_2"));
			log("STEP 2:  User can set the report permission for "+map.get("Report_Name_2")+"", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User  cannot set the report permission for "+map.get("Report_Name_2")+"", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		util.dummyWait(1);
		try {
			ClickOnSavePermission();
			util.dummyWait(10);
			log("STEP 3:  User can click on save button    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User  cannot click on save button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

	}
	
	
	By navReport = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Reports')] ");
	By navSSRSReport = By.xpath("//a//span[@class='rmText' and contains(text(),'SSRS Dashboard')]");

	public void navigateToSSRSReport() {
		util.waitUntilElementDisplay(navReport);
		util.click(navReport);
		util.waitUntilElementDisplay(navSSRSReport);
		util.click(navSSRSReport);
	}
	
	By drpDDReport = By.xpath("(//div[contains(@id,'ddt_REPORTLIST_RadDropDownTree1')])[1]");
	By entertxt = By.xpath("//input[contains(@class,'rddtFilterEmptyMessage')]");
	public By checkReportsAndReportsCategory(String reportName, String category) {
		By reportAndReportCategory = By.xpath("//span[text()='"+category+"']/../..//em[text()='"+reportName+"']");
		return reportAndReportCategory;
	}
	
	By drpProjectName = By.xpath("(//table[contains(@id,'SearchOptions')]/..//table[@summary='combobox']/..//input[@type='text'])[1]");
	public void setProjectName(String value) {
		if (!commonFunction.checkNA(value)) {
		util.waitUntilElementDisplay(drpProjectName);
		util.inputTextAndPressTab(drpProjectName, value);}
		}
	
	By reportDescription = By.xpath("//a[text()='Report Description']");
	By iframeReportDescription = By.xpath("//iframe[@name='RWReportDescription']");
	By btnClose = By.xpath("//a[@title='Close']");
	public void clickOnReportDescription() {
		util.waitUntilElementDisplay(reportDescription);
		util.click(reportDescription);
	}
	
	By btnView = By.xpath("(//input[contains(@type,'image')])[4]");
	public void clickOnView() {
		util.waitUntilElementDisplay(btnView);
		util.click(btnView);
	}
	
	By errorMsg = By.xpath("//div[contains(@id,'NonReportContent')]");
	
	public void verifyReports(Map<String, String> map, String testcaseName) {
		
		try {
			navigateToSSRSReport();
			log("STEP 1:  Navigate to Menu - SSRS Report", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot Navigate to Menu - SSRS Report", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			util.waitUntilElementDisplay(drpDDReport);
			util.click(drpDDReport);
			util.inputText(entertxt, map.get("Report_Name_1"));
			By reportCategory =checkReportsAndReportsCategory(map.get("Report_Name_1"), map.get("Category_1"));
			Assert.assertTrue(util.isElementVisible(reportCategory));
			log("STEP 2:  User can see "+map.get("Report_Name_1")+" under report category "+map.get("Category_1")+"", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 2:  User cannot see "+map.get("Report_Name_1")+" under report category "+map.get("Category_1")+"", Status.FAIL);
		}
		
		try {
			By reportCategory =checkReportsAndReportsCategory(map.get("Report_Name_1"), map.get("Category_2"));
			Assert.assertTrue(util.isElementVisible(reportCategory));
			log("STEP 2:  User can see "+map.get("Report_Name_1")+" under report category "+map.get("Category_1")+"", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 2:  User cannot see "+map.get("Report_Name_1")+" under report category "+map.get("Category_1")+"", Status.FAIL);
		}
		ExtentTestManager.infoWithScreenshot("Report Category on SSRS Report Dashboard Page for report 1");
		try {
			By selectReport = By.xpath("(//*[contains(text(),'"+map.get("Report_Name_1")+"')])[1]");
			util.click(selectReport);
			log("STEP 3:  User can select Report ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot select Report ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			clickOnReportDescription();
			util.switchToIframe(iframeReportDescription);
			log("STEP 4:  User can click on Report Description ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot click on Report Description ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			By desc =By.xpath("//span[text()='"+map.get("Description")+"' and @id='idReportDescription_lblReportDescription']");
			Assert.assertTrue(util.isElementVisible(desc));
			log("STEP 5:  User can see correct report desctiption text", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5:  User cannot see report desctiption text", Status.FAIL);
		}
		ExtentTestManager.infoWithScreenshot("Report Description of report 1");
		try {
			util.switchToDefaultContent();
			util.click(btnClose);
			log("STEP 6:  User can close the popup ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User cannot close the popup ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			clickOnView();
			log("STEP 7:  User can click on view ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User cannot click on view ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			Assert.assertFalse(util.isElementVisible(errorMsg));
			log("STEP 8:  Result successfully display", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8:  Report is throwing an error", Status.FAIL);
		}
		
		ExtentTestManager.infoWithScreenshot("Report Result of report 1");
		try {
			util.waitUntilElementDisplay(drpDDReport);
			util.click(drpDDReport);
			util.inputText(entertxt, map.get("Report_Name_2"));
			By reportCategory =checkReportsAndReportsCategory(map.get("Report_Name_2"), map.get("Category_2"));
			Assert.assertTrue(util.isElementVisible(reportCategory));
			log("STEP 9:  User can see "+map.get("Report_Name_2")+" under report category "+map.get("Category_2")+"", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9:  User cannot see "+map.get("Report_Name_2")+" under report category "+map.get("Category_2")+"", Status.FAIL);
		}
		
		ExtentTestManager.infoWithScreenshot("Report category on SSRS Report Dashboard Page for report 2");
		
		try {
			By selectReport = By.xpath("(//*[contains(text(),'"+map.get("Report_Name_2")+"')])[1]");
			util.click(selectReport);
			util.dummyWait(1);
			log("STEP 10:  User can select Report ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User cannot select Report ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			clickOnReportDescription();
			log("STEP 11:  User can click on Report Description ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  User cannot click on Report Description ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		ExtentTestManager.infoWithScreenshot("Report Description of report 2");
		try {
			util.click(btnClose);
			log("STEP 12:  User can close the popup ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  User cannot close the popup ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			setProjectName(map.get("Project Name"));
			log("STEP 13:  User can select Project ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  User cannot select Project ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			clickOnView();
			log("STEP 14:  User can click on view ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:  User cannot click on view ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		
		try {
			Assert.assertFalse(util.isElementVisible(errorMsg));
			log("STEP 15:  Result successfully display", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 15:  Report is throwing an error", Status.FAIL);
		}
	
	}
}
