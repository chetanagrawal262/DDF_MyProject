package pages.SSRSReport;

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

public class C006_ReportConfigurationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	int count=0;
	String dateName="RegressionMilestoneDate";
	
	public C006_ReportConfigurationPage(WebDriver driver) {
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
	By btnSavePermission = By.xpath("//input[contains(@id,'idAllReports_YALManageReports_save')and @type='image']");
	
	
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
	
	By Label = By.xpath("(//input[@class='rcbCheckAllItemsCheckBox']/../../..//label)[2]");
	By checkbox = By.xpath("(//input[@class='rcbCheckAllItemsCheckBox']/../../..//input[@type='checkbox'])[2]");
	 By closeDrpAvailableOptions = By.xpath("//span[text()='Available Options:']/..//a");
	public void SelectAvailableOptions() {
			util.waitUntilElementDisplay(drpAvailableOptions);
		util.click(drpAvailableOptions);
			util.click(checkbox);
			util.click(closeDrpAvailableOptions);
	}
	
	public void SelectAvailableOptions(String value) {
		util.inputTextAndPressEnter(drpAvailableOptions, value);
}
	
	public void ClickOnSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(1);
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
	
	By drpProjects = By.xpath("(//table[contains(@id,'SearchOptions')]/..//table[@summary='combobox']/..//input[@type='text'])[1]");
	By drpCloseProject = By.xpath("(//td[@class='rcbArrowCell rcbArrowCellRight'])[1]");
	
	public void setProjectName(String value) {
		if (!commonFunction.checkNA(value)) {
		util.waitUntilElementDisplay(drpProjects);
		util.inputTextAndPressTab(drpProjects, value);
		}
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
				By expandReport = By.xpath("//td[text()='"+map.get(Excel.DDReport)+"']/..//input[@type='button']");
				util.click(expandReport);
				util.dummyWait(1);
				log("STEP 2:  User can expand configured report on the grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot expand configured report on the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			By editConfiguration = By.xpath("//td[text()='Tract Milestone Date Name']/..//a[contains(text(),'Edit')]");
			By configDateName = By.xpath("//td[text()='Tract Milestone Date Name']/..//td[contains(text(),'"+dateName+"')]");
			
			if(util.isElementVisible(editConfiguration)) {
			try {
				
				util.waitUntilElementDisplay(editConfiguration);
				util.click(editConfiguration);
				util.dummyWait(2);
				util.switchToIframe(iframe);
				log("STEP 3:  User can edit the Tract Milestone Date Name configuration", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot edit the Tract Milestone Date Name configuration", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			if(!environment.contains("STEELHEAD") & !environment.contains("ORSTED")
					& !environment.contains("WSBALT") & !environment.contains("CONNECTGEN")
					& !environment.contains("RAMACO")& !environment.contains("AVANTUS") & !environment.contains("VALARD")
					& !environment.contains("GRAYHAWKALT") & !environment.contains("TREATYOAK")
					& !environment.contains("NOVA") & !environment.contains("ORION") & !environment.contains("BAYWA") & !environment.contains("WOLFMIDSTREAM")) {
				try {
					SelectAvailableOptions(dateName);
					log("STEP 4: User can select any value from available option dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: User is unable to select any value from available option dd    ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
			}else {
				try {
					SelectAvailableOptions();
					log("STEP 4: User can select any value from available option dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: User is unable to select any value from available option dd    ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
			}
			
		
			try {
				ClickOnSaveButton();
				log("STEP 5:  User is able to click on save button.   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User is unable to click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}

			ClickOnCloseButton();
			}else {
			
			try {
				ClickOnAddNewButton();
				log("STEP 4:  User can click on add new button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User is unable to click on add new button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			try {
				SelectReportName(map.get(Excel.DDReport));
				log("STEP 5:  User can select any value from report name dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User is unable to select any value from report name dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				SelectSystemNameOfConfig("Tract Milestone Date Name");
				log("STEP 6: User can select Show Columns from  System name of config dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User is unable to select Show Columns from System name of config dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			if(!environment.contains("STEELHEAD") & !environment.contains("ORSTED")
					& !environment.contains("WSBALT") & !environment.contains("CONNECTGEN")
					& !environment.contains("RAMACO")& !environment.contains("AVANTUS") & !environment.contains("VALARD")
					& !environment.contains("GRAYHAWKALT") & !environment.contains("TREATYOAK")
					& !environment.contains("NOVA") & !environment.contains("ORION") & !environment.contains("BAYWA") & !environment.contains("WOLFMIDSTREAM")) {
				try {
					SelectAvailableOptions(dateName);
					log("STEP 7: User can select any value from available option dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 7: User is unable to select any value from available option dd    ", Status.FAIL);
					throw new RuntimeException("Failed in step 7");
				}
			}else {
				try {
					SelectAvailableOptions();
					log("STEP 7: User can select any value from available option dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 7: User is unable to select any value from available option dd    ", Status.FAIL);
					throw new RuntimeException("Failed in step 7");
				}
			}
			
		
			try {
				ClickOnSaveButton();
				log("STEP 8:  User is able to click on save button.   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User is unable to click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}

			ClickOnCloseButton();
			}
			try {
				By expandReport = By.xpath("//td[text()='"+map.get(Excel.DDReport)+"']/..//input[@type='button']");
				util.click(expandReport);
				util.dummyWait(1);
				log("STEP 9:  User can expand configured report on the grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot expand configured report on the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				By configSystemName = By.xpath("//td[text()='Tract Milestone Date Name']");
				if(!dateName.contains("All items checked")) {
				util.waitUntilElementDisplay(configSystemName);
				Assert.assertTrue(util.isElementVisible(configDateName));
				}else {
					By configDateNameOther = By.xpath("(//td[text()='Tract Milestone Date Name']/..//td[4])[last()]");
					dateName=util.getText(configDateNameOther);
				}
				Assert.assertTrue(util.isElementVisible(configSystemName));
				log("STEP 10:  User can see Configured Tract Milestone Date Name on the grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10: User cannot see Configured Tract Milestone Date Name on the grid", Status.FAIL);
			}
			
			ExtentTestManager.infoWithScreenshot("C002 Report configuration");
			
			try {
				util.waitFor(500);
				navigateToSSRSReport();
				log("STEP 11:  User can navigate to SSRS Dashboard page ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11:   User cannot navigate to SSRS Dashboard page", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			try {
				selectReport(map.get(Excel.DDReport));
				log("STEP 12:  User can select  Report", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:  User can not select Report", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			
			try {
				setProjectName(map.get(Excel.ProjectName));
				log("STEP 13:  User can select Project", Status.PASS);
			} catch (Exception e) {
				log("STEP 13:  User can not select Project", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
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
				log("STEP 14:  Report successfully display", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 14:  Report is throwing any error", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			if(!environment.contains("STEELHEAD") & !environment.contains("ORSTED")
					& !environment.contains("WSBALT") & !environment.contains("CONNECTGEN")
					& !environment.contains("RAMACO")& !environment.contains("AVANTUS") & !environment.contains("VALARD")
					& !environment.contains("GRAYHAWKALT") & !environment.contains("TREATYOAK")
					& !environment.contains("NOVA") & !environment.contains("ORION") & !environment.contains("BAYWA") & !environment.contains("WOLFMIDSTREAM")) {
			try {
				By column = By.xpath("//div[text()='Milestone Tracking By Project']/../../..//tr[3]//div[text()='"+dateName+"']");
				Assert.assertTrue(util.isElementVisible(column));
				log("STEP 15:  User can see configured date name in the report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 15:  User cannot see configured date name in the report", Status.FAIL);
			}
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
				By expandReport = By.xpath("//td[text()='"+map.get(Excel.DDReport)+"']/..//input[@type='button']");
				util.click(expandReport);
				log("STEP 2:  User can expand configured report on the grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot expand configured report on the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				By removeConfiguration = By.xpath("//td[text()='Tract Milestone Date Name']/..//a[text()='Delete']");
				util.waitUntilElementDisplay(removeConfiguration);
				util.click(removeConfiguration);
				util.waitFor(500);
				try {    
		            Alert alert = driver.switchTo().alert();
		            alert.accept();
		        } catch (NoAlertPresentException e) {
		            System.out.println("No alert present!");
		        }
				log("STEP 3:  User can delete the Tract Milestone Date Name configuration", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot delete the Tract Milestone Date Name configuration", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				util.waitFor(500);
				navigateToSSRSReport();
				log("STEP 4:  User can navigate to SSRS Dashboard page ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:   User cannot navigate to SSRS Dashboard page", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				selectReport(map.get(Excel.DDReport));
				log("STEP 5:  User can select  Report", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User can not select Report", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				setProjectName(map.get(Excel.ProjectName));
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
				log("STEP 8:  Report successfully display", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 8:  Report is throwing any error", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				By column = By.xpath("//div[text()='Milestone Tracking By Project']/../../..//tr[3]//div[text()='"+dateName+"']");
				Assert.assertFalse(util.isElementVisible(column));
				log("STEP 9:  User cannot see removed date name columns in the report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9:  User can see removed date name columns in the report", Status.FAIL);
			}
			
			
			
	 }
	 
	 By navReportPermission = By.xpath("//span[contains(text(),'Reports Permission')]");
		By drpRoles = By.xpath("//input[contains(@id,'DISTRIBUTION_Input')]");
	 public void NavigateToReportPermission() {
			util.waitUntilElementDisplay(navAdministration);
			util.click(navAdministration);
			util.waitUntilElementDisplay(navReportAdministraion);
			util.click(navReportAdministraion);
			util.waitUntilElementDisplay(navReportPermission);
			util.click(navReportPermission);
		}
		
		public void SelectRole(String value) {
			if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpRoles, value);
			util.dummyWait(2);
		}
		
		public void ClickOnRadioButton(By value) {
			util.waitUntilElementDisplay(value);
			util.click(value);
		}
		
		public void ClickOnSave() {
			util.waitUntilElementDisplay(btnSavePermission);
			util.click(btnSavePermission);
		}
	 public void ReportPermission(Map<String, String> map, String testcaseName) {

		  try {
			  NavigateToReportPermission();
			  log("STEP 1: User can Navigate To Report Permission   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User  cannot Navigate To Report Permission ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

			try {
				SelectRole(map.get(Excel.Roles));
				log("STEP 3: User can select value from Roles dd   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User  cannot select value  from Roles dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {	
				
					By permission = By.xpath("//span[contains(text(),'"+map.get(Excel.DDReport)+"')]/..//input[@value='Y']");
					ClickOnRadioButton(permission);
				log("STEP 4:  User can set the report permission for C002 Milestone Date by Project Report", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User  cannot set the report permission for C002 Milestone Date by Project Report", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			util.dummyWait(1);
			try {
				ClickOnSave();
				util.dummyWait(10);
				log("STEP 5:  User can click on save button    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User  cannot click on save button.  ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
	 }
}
