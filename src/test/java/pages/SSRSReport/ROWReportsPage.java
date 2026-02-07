package pages.SSRSReport;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;
import page.Common.LoginPage;
import pages.Assignment.AddParcelAssignmentsPage;
import pages.ParcelNotes.AddParcelNotesPage;

public class ROWReportsPage extends BasePage {

	
	TestUtil util;
	CommonFunction commonFunction;
	String TractNo;
	public ROWReportsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
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
	
	By drpTractNo = By.xpath("//td[text()='Tract Number']/../..//input[@type='text']");
	
	public void selectTractNo(String value) {
		if (!commonFunction.checkNA(value)) {
		util.waitUntilElementDisplay(drpTractNo);
		util.inputTextAndPressTab(drpTractNo, value);}
		}
	
By drpCurrentUser = By.xpath("(//td[text()='Current User']/../..//input[@type='text'])[2]");
	
	public void selectCurrentUser(String value) {
		if (!commonFunction.checkNA(value)) {
		util.waitUntilElementDisplay(drpCurrentUser);
		util.inputTextAndPressTab(drpCurrentUser, value);}
		}
	
	
	By btnView = By.xpath("(//input[contains(@type,'image')])[4]");
	public void clickOnView() {
		util.waitUntilElementDisplay(btnView);
		util.click(btnView);
		util.dummyWait(1);
	}
	
	By errorMsg = By.xpath("//div[contains(@id,'NonReportContent')]");
	
	public void viewReport_ROW016(Map<String, String> map, String testcaseName) {
		try {
			navigateToSSRSReport();
			log("STEP 1:  User can navigate to menu - SSRS Report", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to menu - SSRS Report", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			selectReport(map.get(Excel.DDReport));
			log("STEP 2:  User can select ROW016 Notes by Tract Report", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not select ROW016 Notes by Tract Report", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
//			TractNo=LoginPage.projectName+" - "+AddParcelNotesPage.TRACT_NO;
//			System.out.println(TractNo);
			selectTractNo(AddParcelNotesPage.TRACT_NO);
			log("STEP 3:  User can select Tract No", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User can not select Tract No", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			selectCurrentUser(AddParcelNotesPage.AGENT);
			log("STEP 4:  User can select Current User", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User can not select Current User", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			clickOnView();
			log("STEP 5:  User can click on View", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not click on View", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			Assert.assertFalse(util.isElementVisible(errorMsg));
			ExtentTestManager.infoWithScreenshot("Report Result");
			log("STEP 6:  Report is not throwing any error", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6:  User can not click on View", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
//		try {
//			By project = By.xpath("(//*[text()='"+LoginPage.projectName+"'])[1]");
//			System.out.println(project);
//			Assert.assertTrue(util.isElementVisible(project));
//			log("STEP 6:  User can see Project Name in the report", Status.PASS);
//		} catch (AssertionError e) {
//			log("STEP 6:  User can not see Project Name in the report", Status.FAIL);
//		}
		
//		try {
//			By tract = By.xpath("(//*[text()='"+AddParcelNotesPage.TRACT_NO+"'])[1]");
//			System.out.println(tract);
//			Assert.assertTrue(util.isElementVisible(tract));
//			log("STEP 7:  User can see Tract No in the report", Status.PASS);
//		} catch (AssertionError e) {
//			log("STEP 7:  User can not see Tract No in the report", Status.FAIL);
//		}
		
		try {
			String [] agentName =AddParcelNotesPage.AGENT.split(",");
			String Agent=agentName[1].trim()+" "+agentName[0].trim();
			System.out.println(Agent);
			By user = By.xpath("(//*[contains(text(),'"+Agent+"')])[1]");
			Assert.assertTrue(util.isElementVisible(user));
			log("STEP 8:  User can see Agent Name in the report", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8:  User can not see Agent Name in the report", Status.FAIL);
		}
		
		try {
			By noteCategory = By.xpath("(//*[contains(text(),'"+AddParcelNotesPage.NOTE_TEXT+"')]/../..//*[contains(text(),'"+AddParcelNotesPage.CATEGORY+"')])[1]");
			Assert.assertTrue(util.isElementPresent(noteCategory));
			log("STEP 9:  User can see Notes Category in the report", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9:  User can not see Notes Category in the report", Status.FAIL);
		}
		
		try {
			By activityDate = By.xpath("(//*[contains(text(),'"+AddParcelNotesPage.NOTE_TEXT+"')]/../..//*[contains(text(),'"+AddParcelNotesPage.ACTIVITY_DATE+"')])[1]");
			Assert.assertTrue(util.isElementVisible(activityDate));
			log("STEP 10:  User can see Activity Date in the report", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10:  User can not see Activity Date in the report", Status.FAIL);
		}
		
		try {
			By noteText = By.xpath("(//*[text()='"+AddParcelNotesPage.NOTE_TEXT+"'])[1]");
			Assert.assertTrue(util.isElementVisible(noteText));
			log("STEP 11:  User can see Note Text in the report", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11:  User can not see Note Text in the report", Status.FAIL);
		}
		
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navReportAdministraion = By.xpath("//span[contains(text(),'Reports Administration')]");
	By navReportPermission = By.xpath("//span[contains(text(),'Reports Permission')]");
	By drpRoles = By.xpath("//input[contains(@id,'DISTRIBUTION_Input')]");
	By btnSave = By.xpath("//input[contains(@id,'idAllReports_YALManageReports_save')and @type='image']");
	
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
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
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
			By permission = By.xpath("//span[contains(text(),'" + map.get(Excel.DDReport) + "')]/..//input[@value='"+map.get(Excel.Permission) + "']");
			ClickOnRadioButton(permission);
			log("STEP 4:  User can set the report permission", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User  cannot set the report permission", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		util.dummyWait(1);
		try {
			ClickOnSave();
			util.dummyWait(2);
			log("STEP 5:  User can click on save button    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User  cannot click on save button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
  }
	
}
