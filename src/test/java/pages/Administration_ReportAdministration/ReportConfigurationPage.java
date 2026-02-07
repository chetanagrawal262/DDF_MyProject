package pages.Administration_ReportAdministration;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;
import page.Common.LoginPage;
import pages.ParcelNotes.AddParcelNotesPage;

public class ReportConfigurationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public ReportConfigurationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navReportAdministraion = By.xpath("//span[contains(text(),'Reports Administration')]");
	By navReportConfiguration = By.xpath("//span[text()='Reports Configuration']");
	By btnAddNewButton = By.xpath("//input[contains(@id,'btnSaveRecords')]");
    By iframe = By.xpath("//iframe[@name='EditReportConfig']");
    By drpReportName = By.xpath("//input[contains(@id,'ddlReportName_Input')]");
    By drpSystemNameOfConfig = By.xpath("//input[contains(@id,'ddlSystemNameC_Input')]");
    By drpAvailableOptions = By.xpath("//span[text()='Available Options:']/..//input[@type='text']");
	By btnSave = By.xpath("//input[contains(@id,'idEditReportConfig_btnEdit')]");
	By SuccessMessage = By.xpath("//span[@id='idEditReportConfig_lblMsg']");
	
	
	
	public void NavigateToReportConfiguration() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navReportAdministraion);
		util.click(navReportAdministraion);
		util.waitUntilElementDisplay(navReportConfiguration);
		util.click(navReportConfiguration);
	}
	
	public void ClickOnAddNewButton() {
		util.waitUntilElementDisplay(btnAddNewButton);
		util.click(btnAddNewButton);
		util.dummyWait(2);
		util.switchToIframe(iframe);
	}
	
	public void SelectReportName(String value) {
		util.dummyWait(1);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpReportName, value);
	}
	
	public void SelectSystemNameOfConfig(String value) {
		if (!commonFunction.checkNA(value))
			util.waitUntilElementDisplay(drpSystemNameOfConfig);
			util.inputTextAndPressTab(drpSystemNameOfConfig, value);
	}
	
	public void SelectAvailableOptions(String value) {
		if (!commonFunction.checkNA(value))
			util.waitUntilElementDisplay(drpAvailableOptions);
			util.inputText(drpAvailableOptions, value);
		util.dummyWait(1);
		util.pressENTERkey();
	}
	
	public void ClickOnSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
	}
	
	By btnClose = By.xpath("//a[@title='Close']");
	public void ClickOnCloseButton() {
		util.switchToDefaultContent();
		util.dummyWait(1);
		util.click(btnClose);
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
	public void selectReport(String value) {
		if (!commonFunction.checkNA(value))
		util.click(drpDDReport);
		By entertxt = By.xpath("//input[contains(@class,'rddtFilterEmptyMessage')]");
		util.inputText(entertxt, value);
		By selectDD = By.xpath("//*[contains(text(),'"+value+"')]");
		util.click(selectDD);
	}
	
	By drpProject = By.xpath("(//td[text()='Project']/../..//input[@type='text'])[1]");
	
	public void selectProject(String value) {
		if (!commonFunction.checkNA(value)) {
		util.waitUntilElementDisplay(drpProject);
		util.inputTextAndPressTab(drpProject, value);}
		}
	
	
	By btnView = By.xpath("(//input[contains(@type,'image')])[4]");
	public void clickOnView() {
		util.waitUntilElementDisplay(btnView);
		util.click(btnView);
		util.dummyWait(1);
	}
	
	By errorMsg = By.xpath("//div[contains(@id,'NonReportContent')]");
	
	 public void ReportConfiguration(Map<String, String> map, String testcaseName) {
			try {
				NavigateToReportConfiguration();
				log("STEP 1: Report configuration page should be opened.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Report configuration page should not be opened.    ", Status.FAIL);
				throw new RuntimeException("Failed in step 1: ");
			}

			try {
				ClickOnAddNewButton();
				log("STEP 2:  User can click on add new button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User is unable to click on add new button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			try {
				SelectReportName(map.get(Excel.ReportName));
				log("STEP 3:  User can select any value from report name dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User is unable to select any value from report name dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				SelectSystemNameOfConfig(map.get(Excel.SystemName));
				log("STEP 4: User can select any value from  System name of config dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User is unable to select any value from System name of config dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				SelectAvailableOptions(map.get(Excel.AvailableOptions));
				log("STEP 5: User can select any value from available option dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User is unable to select any value from available option dd    ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
		
			try {
				ClickOnSaveButton();
				ExtentTestManager.infoWithScreenshot("Report Configuration");
				log("STEP 6:  User is able to click on save button.   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User is unable to click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}

			ClickOnCloseButton();
			
			try {
				By expandReport = By.xpath("//td[text()='"+map.get(Excel.ReportName)+"']/..//input[@type='button']");
				util.click(expandReport);
				log("STEP 7:  User can expand configured report on the grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot expand configured report on the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				By configuredColumn = By.xpath("//td[text()='"+map.get(Excel.SystemName)+"']");
				By configuredOption = By.xpath("//td[text()='"+map.get(Excel.SystemName)+"']/..//td[text()='"+map.get(Excel.AvailableOptions)+"']");
				util.waitUntilElementDisplay(configuredColumn);
				Assert.assertTrue(util.isElementVisible(configuredColumn));
				Assert.assertTrue(util.isElementVisible(configuredOption));
				log("STEP 8:  User can see Configured Report Data on the grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 8: User cannot see configured report data on the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				navigateToSSRSReport();
				log("STEP 9:  User can navigate to SSRS Dashboard page ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:   User cannot navigate to SSRS Dashboard page", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				selectReport(map.get(Excel.ReportName));
				log("STEP 10:  User can select  Report", Status.PASS);
			} catch (Exception e) {
				log("STEP 10:  User can not select Report", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				selectProject(LoginPage.projectName);
				log("STEP 11:  User can select Project", Status.PASS);
			} catch (Exception e) {
				log("STEP 11:  User can not select Project", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				clickOnView();
				log("STEP 12:  User can click on View", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:  User can not click on View", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			
			try {
				Assert.assertFalse(util.isElementVisible(errorMsg));
				log("STEP 13:  Report is not throwing any error", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 13:  User can not click on View", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				By column = By.xpath("//div[text()='"+map.get(Excel.SystemName)+"']");
				Assert.assertFalse(util.isElementVisible(column));
				log("STEP 14:  User cannot see non configured columns in the report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 14:  User can see non configured columns in the report", Status.FAIL);
			}
	 }
	
	 public void removeReportConfiguration(Map<String, String> map, String testcaseName) {
			try {
				NavigateToReportConfiguration();
				log("STEP 1: Report configuration page should be opened.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Report configuration page should not be opened.    ", Status.FAIL);
				throw new RuntimeException("Failed in step 1: ");
			}

			try {
				By expandReport = By.xpath("//td[text()='"+map.get(Excel.ReportName)+"']/..//input[@type='button']");
				util.click(expandReport);
				log("STEP 2:  User can expand configured report on the grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot expand configured report on the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				By removeConfiguration = By.xpath("//td[text()='"+map.get(Excel.SystemName)+"']/..//a[text()='Delete']");
				util.waitUntilElementDisplay(removeConfiguration);
				util.click(removeConfiguration);
				util.waitFor(500);
				try {    
		            Alert alert = driver.switchTo().alert();
		            alert.accept();
		        } catch (NoAlertPresentException e) {
		            System.out.println("No alert present!");
		        }
				log("STEP 3:  User can delete the column configuration", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot delete the column configuration", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				navigateToSSRSReport();
				log("STEP 4:  User can navigate to SSRS Dashboard page ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:   User cannot navigate to SSRS Dashboard page", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				selectReport(map.get(Excel.ReportName));
				log("STEP 5:  User can select  Report", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User can not select Report", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				selectProject(LoginPage.projectName);
				log("STEP 6:  User can select Project", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  User can not select Project", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				clickOnView();
				log("STEP 7:  User can click on View", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User can not click on View", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				Assert.assertFalse(util.isElementVisible(errorMsg));
				log("STEP 8:  Report is not throwing any error", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 8:  User can not click on View", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				By column = By.xpath("//div[text()='"+map.get(Excel.SystemName)+"']");
				Assert.assertTrue(util.isElementVisible(column));
				log("STEP 9:  User can see configured columns in the report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9:  User cannot see configured columns in the report", Status.FAIL);
			}
			
	 }
	 
}
