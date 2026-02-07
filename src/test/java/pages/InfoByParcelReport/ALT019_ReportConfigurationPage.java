package pages.InfoByParcelReport;

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

public class ALT019_ReportConfigurationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	int count=0;
	
	public ALT019_ReportConfigurationPage(WebDriver driver) {
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
		util.selectValueFromDropdownCheckbox(drpProjects, value);}
		util.click(drpCloseProject);
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
				SelectReportName(map.get(Excel.DDReport));
				log("STEP 3:  User can select any value from report name dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User is unable to select any value from report name dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				SelectSystemNameOfConfig("Show Columns");
				log("STEP 4: User can select Show Columns from  System name of config dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User is unable to select Show Columns from System name of config dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				SelectAvailableOptions("Agreement Number");
				SelectAvailableOptions("Agreement Status");
				SelectAvailableOptions("Section");
				SelectAvailableOptions("Range");
				log("STEP 5: User can select any value from available option dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User is unable to select any value from available option dd    ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
		
			try {
				ClickOnSaveButton();
				log("STEP 6:  User is able to click on save button.   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User is unable to click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}

			try {
				SelectSystemNameOfConfig("Show Custom Fields");
				log("STEP 7: User can select Show Custom Fields from  System name of config dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User is unable to select Show Custom Fields from System name of config dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				util.waitFor(500);
				SelectAvailableOptions("Parcel Acres:");
				SelectAvailableOptions("Leased Acres:");
				log("STEP 8: User can select any value from available option dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User is unable to select any value from available option dd    ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
		
			try {
				ClickOnSaveButton();
				log("STEP 9:  User is able to click on save button.   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User is unable to click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			ClickOnCloseButton();
			
			try {
				By expandReport = By.xpath("//td[text()='"+map.get(Excel.DDReport)+"']/..//input[@type='button']");
				util.click(expandReport);
				log("STEP 10:  User can expand configured report on the grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot expand configured report on the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				By configSystemName = By.xpath("//td[text()='Show Columns']");
				By configColAgreementNumber = By.xpath("//td[text()='Show Columns']/..//td[contains(text(),'Agreement Number')]");
				util.waitUntilElementDisplay(configSystemName);
				Assert.assertTrue(util.isElementVisible(configSystemName));
				Assert.assertTrue(util.isElementVisible(configColAgreementNumber));
				log("STEP 11:  User can see Configured Name and value of Show Column on the grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11: User cannot see Configured Name and value of show column on the grid", Status.FAIL);
			}
			
			try {
				By configSystemName2 = By.xpath("//td[text()='Show Custom Fields']");
				util.waitUntilElementDisplay(configSystemName2);
				Assert.assertTrue(util.isElementVisible(configSystemName2));
				By configColParcelAcres = By.xpath("//td[text()='Show Custom Fields']/..//td[contains(text(),'Parcel Acres:')]");
				Assert.assertTrue(util.isElementVisible(configColParcelAcres));
				log("STEP 12:  User can see Configured Name and value of Show Custom Fields on the grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12: User cannot see Configured Name and value of Show Custom Fields on the grid", Status.FAIL);
			}
			
			ExtentTestManager.infoWithScreenshot("ALT019 Report configuration");
			
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
				By removeConfiguration = By.xpath("//td[text()='Show Columns']/..//a[text()='Delete']");
				util.waitUntilElementDisplay(removeConfiguration);
				util.click(removeConfiguration);
				util.waitFor(500);
				try {    
		            Alert alert = driver.switchTo().alert();
		            alert.accept();
		        } catch (NoAlertPresentException e) {
		            System.out.println("No alert present!");
		        }
				log("STEP 3:  User can delete the Show column configuration", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot delete the Show column configuration", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				By expandReport = By.xpath("//td[text()='"+map.get(Excel.DDReport)+"']/..//input[@type='button']");
				util.click(expandReport);
				log("STEP 4:  User can expand configured report on the grid ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot expand configured report on the grid", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				By removeConfiguration = By.xpath("//td[text()='Show Custom Fields']/..//a[text()='Delete']");
				util.waitUntilElementDisplay(removeConfiguration);
				util.click(removeConfiguration);
				util.waitFor(500);
				try {    
		            Alert alert = driver.switchTo().alert();
		            alert.accept();
		        } catch (NoAlertPresentException e) {
		            System.out.println("No alert present!");
		        }
				log("STEP 5:  User can delete the Show Custom Fields configuration", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot delete the Show Custom Fields configuration", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				util.waitFor(500);
				navigateToSSRSReport();
				log("STEP 6:  User can navigate to SSRS Dashboard page ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:   User cannot navigate to SSRS Dashboard page", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				selectReport(map.get(Excel.DDReport));
				log("STEP 7:  User can select  Report", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User can not select Report", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				setProjectName(map.get(Excel.ProjectName));
				log("STEP 8:  User can select Project", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:  User can not select Project", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				clickOnView();
				log("STEP 9:  User can click on View", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:  User can not click on View", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				Assert.assertFalse(util.isElementVisible(errorMsg));
				log("STEP 10:  Report successfully dislayed", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10:  Report is throwing an error", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			
			try {
				By column = By.xpath("//div[text()='Agreement Number']");
				Assert.assertFalse(util.isElementVisible(column));
				log("STEP 11:  User cannot see Agreement Number columns in the report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11:  User can see Agreement Number columns in the report", Status.FAIL);
			}
			
			try {
				By column = By.xpath("//div[text()='Agreement Status']");
				Assert.assertFalse(util.isElementVisible(column));
				log("STEP 12:  User cannot see Agreement Status columns in the report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 12:  User can see Agreement Status columns in the report", Status.FAIL);
			}
			
			try {
				By column = By.xpath("//div[text()='Range']");
				Assert.assertFalse(util.isElementVisible(column));
				log("STEP 13:  User cannot see Range columns in the report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 13:  User can see Range columns in the report", Status.FAIL);
			}
			
			try {
				By column = By.xpath("//div[text()='Range']");
				Assert.assertFalse(util.isElementVisible(column));
				log("STEP 14:  User cannot see Section columns in the report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 14:  User can see Section columns in the report", Status.FAIL);
			}
			
			try {
				By column = By.xpath("//div[text()='Leased Acres']");
				Assert.assertFalse(util.isElementVisible(column));
				log("STEP 15:  User cannot see Leased Acres columns in the report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 15:  User can see Leased Acres columns in the report", Status.FAIL);
			}
			
			try {
				By column = By.xpath("//div[text()='Parcel Acres']");
				Assert.assertFalse(util.isElementVisible(column));
				log("STEP 16:  User cannot see Parcel Acres columns in the report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 16:  User can see Parcel Acres columns in the report", Status.FAIL);
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
				log("STEP 2: User can select value from Roles dd   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User  cannot select value  from Roles dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {	
				
					By permission1 = By.xpath("//span[contains(text(),'(ALT006) Info By Parcels Report')]/..//input[@value='Y']");
					ClickOnRadioButton(permission1);
					By permission2 = By.xpath("//span[contains(text(),'(ALT019) Info By Parcels (V2) Report')]/..//input[@value='Y']");
					ClickOnRadioButton(permission2);
				log("STEP 3:  User can set the report permission", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User  cannot set the report permission", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			util.dummyWait(1);
			try {
				ClickOnSave();
				util.dummyWait(10);
				log("STEP 4:  User can click on save button    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User  cannot click on save button.  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
	 }
}
