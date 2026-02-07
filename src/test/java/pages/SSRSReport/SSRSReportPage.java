package pages.SSRSReport;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;
import page.Common.LoginPage;

public class SSRSReportPage extends BasePage {

	
	TestUtil util;
	CommonFunction commonFunction;
	public SSRSReportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		// TODO Auto-generated constructor stub
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
	public void setDDReport(String value) {
		if (!commonFunction.checkNA(value))
		util.click(drpDDReport);
		By entertxt = By.xpath("//input[contains(@class,'rddtFilterEmptyMessage')]");
		util.inputText(entertxt, value);
		By selectDD = By.xpath("//*[contains(text(),'"+value+"')]");
		util.click(selectDD);
		//util.clickAndInputTextwithEnterKey(drpDDReport,entertxt,value);
	}
	
	By drpDD1 = By.xpath("(//table[contains(@id,'SearchOptions')]/..//table[@summary='combobox']/..//input[@type='text'])[1]");
	By drpCloseDD1 = By.xpath("(//td[@class='rcbArrowCell rcbArrowCellRight'])[1]");
	By firstProject = By.xpath("((//*[contains(@id,'DropDown')])[1]/..//li)[1]");
	
//	public void setProjectName(String value) {
//		if (!commonFunction.checkNA(value)) {
//		util.waitUntilElementDisplay(drpProject);
//		util.selectValueFromDropdownCheckbox(drpProject, value);}
//		util.click(drpCloaseProject);
//		}
	
	By drpDD2 = By.xpath("(//table[contains(@id,'SearchOptions')]/..//table[@summary='combobox']/..//input[@type='text'])[2]");
	By drpCloseDD2 = By.xpath("(//td[@class='rcbArrowCell rcbArrowCellRight'])[2]");
	By selectAll = By.xpath("(//div[normalize-space()='Select All']//input)[1]");
	
//	public void setAgreementType(String value) {
//		if (!commonFunction.checkNA(value)) {
//			util.waitUntilElementDisplay(drpAgreementType);
//			util.scrollToElement(drpAgreementType);
//			util.selectValueFromDropdownCheckbox(drpAgreementType, value);
//			util.click(drpCloseAgreementType);
//		}
//	}
	
	By drpDD3 = By.xpath("(//table[contains(@id,'SearchOptions')]/..//table[@summary='combobox']/..//input[@type='text'])[3]");
	By drpCloseDD3 = By.xpath("(//td[@class='rcbArrowCell rcbArrowCellRight'])[3]");
//	public void setAgreementStatus (String value) {
//		if (!commonFunction.checkNA(value)) {
//		util.waitUntilElementDisplay(drpAgreementStatus);
//		util.scrollToElement(drpAgreementStatus);
//		util.selectValueFromDropdownCheckbox(drpAgreementStatus, value);
//		util.click(drpCloseAgreementStatus);
//		
//	}}
	By txtStartDate = By.xpath("(//table[contains(@id,'SearchOptions')]/..//input[contains(@id,'dateInput') and @type='text'])[1]");
	//By txtStartDate = By.xpath("//input[contains(@id,'dateInput')]");
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
	
	public void isProjectNameListView(String value1) {
		String value="Workflow Name";
		if (!commonFunction.checkNA(value)) {
		By listOfProjectName = By.xpath("//*[contains(text(),'"+value+"')]");
		util.isElementPresent(listOfProjectName);
		}
		
	}
	
	public void viewSSRSReport(Map<String, String> map, String testcaseName) {
		try {
			navigateToSSRSReport();
			log("STEP 1:  Navigate to Menu - SSRS Report", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  Navigate to Menu - SSRS Report", Status.FAIL);
			throw new RuntimeException("Failed in step 1: Popup up does not appear");
		}
		
		try {
			setDDReport(map.get(Excel.DDReport));
			log("STEP 2:  User can select DDReport", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not enter DDReport", Status.FAIL);
			throw new RuntimeException("Failed in step 2: User can not enter DDReport");
		}
		
		if (util.isElementPresent(drpDD1)) {
		try {
			//setProjectName(map.get(Excel.ProjectName));
			util.waitForWebElementToBePresent(drpDD1);
			util.click(drpDD1);
			if(util.isElementVisible(selectAll)) {
				util.click(selectAll);
				util.click(drpCloseDD1);
				}else {
					util.click(firstProject);
				}
			log("STEP 3:  User can select ProjectName", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User can not enter ProjectName", Status.FAIL);
			throw new RuntimeException("Failed in step 3: User can not enter ProjectName");
		}}
		
		if (util.isElementPresent(drpDD2)) {
			String ddValue=util.getAttributeValue(drpDD2, "value");
			if(!ddValue.contains("All items check")) {
		try {
			//setAgreementType(map.get(Excel.AgreementType));
			util.waitForWebElementToBePresent(drpDD2);
			util.click(drpDD2);
			util.click(selectAll);
			util.click(drpCloseDD2);
			log("STEP 4:  User can select value from the DD2", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User can not select value from the DD2", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}}}
		
		if (util.isElementPresent(drpDD3)) {
		try {
			//setAgreementStatus(map.get(Excel.AgreementStatus));
			util.waitForWebElementToBePresent(drpDD3);
			util.click(drpDD3);
			util.click(selectAll);
			util.click(drpCloseDD3);
			log("STEP 5:  User can select value from the DD3", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not select value from the DD3", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}}
		
		if (util.isElementVisible(txtStartDate)) {
		try {
			setStartDate(map.get(Excel.StartDate));
			log("STEP 5:  User can select StartDate", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not enter StartDate", Status.FAIL);
			throw new RuntimeException("Failed in step 5: User can not enter StartDate");
		}}
		
		if (util.isElementVisible(txtEndDate)) {
		try {
			setEndDate(map.get(Excel.EndDate));
			log("STEP 6:  User can select EndDate", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User can not enter EndDate", Status.FAIL);
			throw new RuntimeException("Failed in step 5: User can not enter EndDate");
		}}
		
		
		try {
			clickOnView();
			log("STEP 7:  User can click on View", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User can not click on View", Status.FAIL);
			throw new RuntimeException("Failed in step 7: User can not click on View");
		}
		
		
		try {
			isProjectNameListView(map.get(Excel.DDReport));
			log("STEP 8:  User can view SSRS Reports", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User can not view SSRS Reports", Status.FAIL);
			throw new RuntimeException("Failed in step 8: User can not view SSRS Reports");
		}
		
		if(util.isElementVisible(errorMsg)) {
			log("reports is throwing an error", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
			
		}else {
			log("Result successfully display", Status.PASS);
			ExtentTestManager.infoWithScreenshot("Report Result");
		}
		
		
	}

}
