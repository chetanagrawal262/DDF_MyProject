package pages.Administration_ReportAdministration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;

import extentReports.ExtentTestManager;
import page.Common.LoginPage;

public class ReportManagementPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	int count=0;

	public ReportManagementPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navReportAdministraion = By.xpath("//span[contains(text(),'Reports Administration')]");
	By navReportPermission = By.xpath("//span[contains(text(),'Reports Permission')]");
	By drpRoles = By.xpath("//input[contains(@id,'DISTRIBUTION_Input')]");
	By PowerBi = By.xpath("//span[contains(text(),'PowerBI Dashboards Permissions')]");
	By ReportsPermission = By.xpath("//span[contains(text(),'Reports Permission')]");
	By RadiobtnYes = By.xpath("//input[contains(@id,'radAdminMenu1_i1_Access_0')and @type='radio']");
	By RadiobtnNo = By.xpath("//input[contains(@id,'radAdminMenu1_i2_Access_1')and @type='radio']");
	By btnSave = By.xpath("//input[contains(@id,'idAllReports_YALManageReports_save')and @type='image']");
	By btnRadio1 = By.xpath("//input[contains(@id,'radpowerbimenu_i0_Access_0')and @type='radio']");
	By btnRadio2 = By.xpath("//input[contains(@id,'radpowerbimenu_i1_Access_1')and @type='radio']");
    
	
	public void getReportCount(Map<String, String> map, String testcase) {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.ReportsPermission, testcase);
		for(int i=1; i<ExcelUtils.totalRows-1; i++) {
			String rowName = "ReportPermission" + clientName+i;
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.ReportsPermission,rowName);
			if(map.get("ReportName")!=null) {
				count++;
			}
		}
	}
	
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
	
	public void ClickOnReportsPermission() {
		util.waitUntilElementDisplay(PowerBi);
		util.click(PowerBi);
		util.dummyWait(2);
		util.waitUntilElementDisplay(ReportsPermission);
		util.click(ReportsPermission);
	}
	
	public void ClickOnRadioButton(By value) {
		util.waitUntilElementDisplay(value);
		util.click(value);
	}
	
	public void ClickOnSave() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
	}
	
	public void ClickOnNoRadioButton() {
		util.waitUntilElementDisplay(btnRadio2);
		util.click(btnRadio2);
	}
	
	By ReportPermission = By.xpath("(//span[text()='Reports Permission'])[2]");
	By ReportScheduler = By.xpath("(//span[text()='Reports Scheduler'])[2]");
	By ReportConfiguration = By.xpath("(//span[text()='Reports Configuration'])[2]");
	By navReport = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Reports')] ");
	By navSSRSReport = By.xpath("//a//span[@class='rmText' and contains(text(),'SSRS Dashboard')]");

	public void navigateToSSRSReport() {
		util.waitUntilElementDisplay(navReport);
		util.click(navReport);
		util.waitUntilElementDisplay(navSSRSReport);
		util.click(navSSRSReport);
	}
	
	By drpDDReport = By.xpath("(//div[contains(@id,'ddt_REPORTLIST_RadDropDownTree1')])[1]");
	By drpDD1 = By.xpath("(//table[contains(@id,'SearchOptions')]/..//table[@summary='combobox']/..//input[@type='text'])[1]");
	By drpCloseDD1 = By.xpath("(//td[@class='rcbArrowCell rcbArrowCellRight'])[1]");
	By drpDD2 = By.xpath("(//table[contains(@id,'SearchOptions')]/..//table[@summary='combobox']/..//input[@type='text'])[2]");
	By drpCloseDD2 = By.xpath("(//td[@class='rcbArrowCell rcbArrowCellRight'])[2]");
	By selectAll = By.xpath("(//div[normalize-space()='Select All']//input)[1]");
	By drpDD3 = By.xpath("(//table[contains(@id,'SearchOptions')]/..//table[@summary='combobox']/..//input[@type='text'])[3]");
	By drpCloseDD3 = By.xpath("(//td[@class='rcbArrowCell rcbArrowCellRight'])[3]");
	By radioButton = By.xpath("//input[@type='radio' and @value='True']");

	By txtStartDate = By.xpath("(//table[contains(@id,'SearchOptions')]/..//input[contains(@id,'dateInput') and @type='text'])[1]");
	public void setStartDate(String value) {
		if (!commonFunction.checkNA(value)) {
		util.waitUntilElementDisplay(txtStartDate);
		util.inputTextAndPressTab(txtStartDate, value);
		}
	}
	
	By txtEndDate = By.xpath("(//table[contains(@id,'SearchOptions')]/..//input[contains(@id,'dateInput') and @type='text'])[2]");
	public void setEndDate(String value) {
		if (!commonFunction.checkNA(value)) {
		util.waitUntilElementDisplay(txtEndDate);
		util.inputTextAndPressTab(txtEndDate, value);
		}}
	
	By btnView = By.xpath("(//input[contains(@type,'image')])[4]");
	public void clickOnView() {
		util.waitUntilElementDisplay(btnView);
		util.click(btnView);
	}
	
	By errorMsg = By.xpath("//div[contains(@id,'NonReportContent')]");
	public void verifyDDReport(String value,  String value1) {
		if (!commonFunction.checkNA(value))
		if(value1.equals("Y")) {
			
			util.click(drpDDReport);
			
		By entertxt = By.xpath("//*[@value='Filtering...']");
		util.inputText(entertxt, value);
		
		By reportName = By.xpath("//*[contains(text(),'"+value+"')]");
		if(util.isElementPresent(reportName)) {
			log("Report "+value+" displays in the report DD");
			util.click(reportName);
			
			util.dummyWait(2);
			if (util.isElementPresent(drpDD1)) {
				try {
					util.waitForWebElementToBePresent(drpDD1);
					util.click(drpDD1);
					
					if(util.isElementVisible(selectAll)) {
						util.click(selectAll);
						util.click(drpCloseDD1);
						}else {
							util.inputTextAndPressTab(drpDD1, LoginPage.projectName);
						}
					
					log("STEP 7:  User can select ProjectName", Status.PASS);
				} catch (Exception e) {
					log("STEP 7:  User can not enter ProjectName", Status.FAIL);
					throw new RuntimeException("Failed in step 7: User can not enter ProjectName");
				}}
				
			
				if (util.isElementPresent(drpDD2)) {
					String ddValue=util.getAttributeValue(drpDD2, "value");
					if(!ddValue.contains("All items check")) {
				try {
					util.waitForWebElementToBePresent(drpDD2);
					util.click(drpDD2);
					util.click(selectAll);
					util.click(drpCloseDD2);
					log("STEP 8:  User can select value from the DD2", Status.PASS);
				} catch (Exception e) {
					log("STEP 8:  User can not select value from the DD2", Status.FAIL);
					throw new RuntimeException("Failed in step 8");
				}}}
				
				
				if (util.isElementPresent(drpDD3)) {
				try {
					util.waitForWebElementToBePresent(drpDD3);
					util.click(drpDD3);
					util.click(selectAll);
					util.click(drpCloseDD3);
					log("STEP 9:  User can select value from the DD3", Status.PASS);
				} catch (Exception e) {
					log("STEP 9:  User can not select value from the DD3", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}}	
				
				if (util.isElementPresent(radioButton)) {
					try {
						util.waitForWebElementToBePresent(radioButton);
						util.click(radioButton);
						log("STEP 10:  User can select the radio button", Status.PASS);
					} catch (Exception e) {
						log("STEP 10:  User can not select the radio button", Status.FAIL);
						throw new RuntimeException("Failed in step 10");
					}}
				
				if (util.isElementVisible(txtStartDate)) {
					try {
						setStartDate("1/1/2021");
						log("STEP 5:  User can select StartDate", Status.PASS);
					} catch (Exception e) {
						log("STEP 5:  User can not enter StartDate", Status.FAIL);
						throw new RuntimeException("Failed in step 5: User can not enter StartDate");
					}}
					
				
				if (util.isElementVisible(txtEndDate)) {
					try {
						setEndDate("1/1/2024");
						log("STEP 6:  User can select EndDate", Status.PASS);
					} catch (Exception e) {
						log("STEP 6:  User can not enter EndDate", Status.FAIL);
						throw new RuntimeException("Failed in step 5: User can not enter EndDate");
					}}
				
				
				try {
					clickOnView();
					log("STEP 11:  User can click on View", Status.PASS);
				} catch (Exception e) {
					log("STEP 11:  User can not click on View", Status.FAIL);
					throw new RuntimeException("Failed in step 11: User can not click on View");
				}
				
				if(util.isElementVisible(errorMsg)) {
					log("reports is throwing an error", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
					
				}else {
					log("Result successfully display", Status.PASS);
					ExtentTestManager.infoWithScreenshot("Report Result");
				}
		}else {
			log("Report "+value+" does not display in the report DD", Status.FAIL);
		}}
		else {
			log("Report "+value+" has N permission set and It will not display in the Report DD");
		}
	}
	
	  public void ReportAdministration(Map<String, String> map, String testcaseName) {

		  try {
			  NavigateToReportPermission();
			  log("STEP 1: User can Navigate To Report Permission   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User  cannot Navigate To Report Permission ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
//	    		if (util.isElementPresent(ReportPermission)) {
//	 			   log("STEP 2 : User can see the Report Permission Tab ", Status.PASS);
//	 			} else {
//	 			   log("STEP 2:User cannot see the Report Permission Tab"  , Status.FAIL);
//	 		      throw new RuntimeException("Faild in STEP 2 ");
//	 	   	    } 

			try {
				SelectRole(map.get(Excel.Roles));
				log("STEP 3: User can select value from Roles dd   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User  cannot select value  from Roles dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			getReportCount(map,testcaseName);
			try {	
				int i=1;
				do {
					String rowName = "ReportPermission" + clientName+i;
					map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.ReportsPermission,rowName);
					System.out.println(ExcelUtils.totalRows);
					System.out.println(count);
					By permission = By.xpath("//span[contains(text(),'"+map.get(Excel.ReportName)+"')]/..//input[@value='"+map.get(Excel.Permission)+"']");
					ClickOnRadioButton(permission);
					ExtentTestManager.info("Report #"+i+" : "+map.get(Excel.Permission)+" Permission set for the report "+map.get(Excel.ReportName));
					i++;
					}while(i<=count);
				log("STEP 4:  User can set the report permission", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User  cannot set the report permission", Status.FAIL);
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
			
			try {
				navigateToSSRSReport();
				log("STEP 6:  User can navigate to SSRS Dashboard page ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:   User cannot navigate to SSRS Dashboard page", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				
				int i=1;
				do {
					
					String rowName = "ReportPermission" + clientName+i;
					map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ADMINISTRATION_CONFIGURATION_TEST_DATA), Excel.ReportsPermission,rowName);
					verifyDDReport(map.get(Excel.ReportName),  map.get(Excel.Permission));
					util.dummyWait(1);
					i++;
					}while(i<=count);
				log("STEP 12:  User can verify the reports in Report  DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:   User cannot verify the reports in Report  DD", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
	  }
	
}
