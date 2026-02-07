package pages.SSRSReport;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;
public class ATWELL03_C_ReportValidationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	int count=0;
	SoftAssert sa= new SoftAssert();
	public static String PROJECT_NAME;
	
	public ATWELL03_C_ReportValidationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navReportAdministraion = By.xpath("//span[contains(text(),'Reports Administration')]");
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
	By navParcelInformation = By.xpath("//div[contains(@id,'RadTabStripLO')]//span[text()='Parcel Information']");
	
        public void validationOfImportedData(Map<String, String> map,String testcaseName) {	
		
		SoftAssert assertion = new SoftAssert();
				By addedRecord = By.xpath("//td[text()='"+map.get("Agreement Number").trim()+"']/parent::tr");
				Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Record is not added yet");
				util.click(addedRecord);
				
				util.waitFor(500);
				util.click(navParcelInformation);
				util.waitFor(500);
				By firsPparcel = By.xpath("//tr[contains(@id,'_RadGridTract1_radYALGridControl')]/..//*[text()='"+map.get("Parcel_1").trim()+"']");
				By secondParcel = By.xpath("//tr[contains(@id,'_RadGridTract1_radYALGridControl')]/..//*[text()='"+map.get("Parcel_2").trim()+"']");
				By thirdParcel = By.xpath("//tr[contains(@id,'_RadGridTract1_radYALGridControl')]/..//*[text()='"+map.get("Parcel_3").trim()+"']");
				assertion.assertTrue(util.isElementVisible(firsPparcel), "Parcel "+map.get("Parcel_1").trim()+" not present");
				assertion.assertTrue(util.isElementVisible(secondParcel), "Parcel "+map.get("Parcel_2").trim()+" not present");
				assertion.assertTrue(util.isElementVisible(thirdParcel), "Parcel "+map.get("Parcel_3").trim()+" not present");
					By acres1 = By.xpath("//tr[contains(@id,'_RadGridTract1_radYALGridControl')]/..//*[contains(text(),'"+map.get("Acres_1").trim()+"')]");
					By acres2 = By.xpath("//tr[contains(@id,'_RadGridTract1_radYALGridControl')]/..//*[contains(text(),'"+map.get("Acres_2").trim()+"')]");
					By acres3 = By.xpath("//tr[contains(@id,'_RadGridTract1_radYALGridControl')]/..//*[contains(text(),'"+map.get("Acres_3").trim()+"')]");
					
					assertion.assertTrue(util.isElementVisible(acres1), "Paid Acreage for Parcel "+map.get("Parcel_1").trim()+" mismatched");
					assertion.assertTrue(util.isElementVisible(acres2), "Paid Acreage for Parcel "+map.get("Parcel_2").trim()+" mismatched");
					assertion.assertTrue(util.isElementVisible(acres3), "Paid Acreage for Parcel "+map.get("Parcel_3").trim()+" mismatched");
					
					ExtentTestManager.infoWithScreenshot("Imported Parcel Data");
					assertion.assertAll();
		}
	 
	  public void setDDReport(String value) {
			if (!commonFunction.checkNA(value)) {
			util.click(drpDDReport);
			By entertxt = By.xpath("//input[contains(@class,'rddtFilterEmptyMessage')]");
			util.inputText(entertxt, value);
			By selectDD = By.xpath("//*[contains(text(),'"+value+"')]");
			util.click(selectDD);
			}
		}
	 
	public void verifyReportData(Map<String, String> map, String testcaseName) throws Exception {
		    
		    ExtentTestManager.info("Parcel 1 : " + map.get("Parcel_1"));
		    By parcel1 = By.xpath("//*[text()='"+map.get("Parcel_1")+"']");
		    sa.assertTrue(util.isElementVisible(parcel1, 30),"Parcel " + map.get("Parcel_1") + " is not added in Report");
		    
		    ExtentTestManager.info("Gross Acres for Parcel 1 : " + map.get("Acres_1"));
		    By acres1 = By.xpath("//*[text()='"+map.get("Parcel_1")+"']/../..//*[contains(text(),'"+map.get("Acres_1")+"')]");
		    sa.assertTrue(util.isElementVisible(acres1, 30),"Gross Acres "+map.get("Acres_1")+" for Parcel " + map.get("Parcel_1") + " is not added in Report");
		
			ExtentTestManager.info("Project Name : " + map.get("Project Name"));
			By projectName = By.xpath("//*[text()='"+map.get("Parcel_1")+"']/../..//*[text()='"+map.get("Project Name")+"']");
			sa.assertTrue(util.isElementVisible(projectName, 30),"Project Name " + map.get("Project Name") + " is not added in Report");

			ExtentTestManager.info("Agreement Number : " + map.get("Agreement Number"));
			By agreementNo = By.xpath("//*[text()='"+map.get("Parcel_1")+"']/../..//*[text()='"+map.get("Agreement Number")+"']");
			sa.assertTrue(util.isElementVisible(agreementNo, 30),"Agreement Number " + map.get("Agreement Number") + " is not added in Report");
			
			ExtentTestManager.info("Parcel 2 : " + map.get("Parcel_2"));
		    By parcel2 = By.xpath("//*[text()='"+map.get("Parcel_2")+"']");
		    sa.assertTrue(util.isElementVisible(parcel2, 30),"Parce2 " + map.get("Parcel_2") + " is not added in Report");
		    
		    ExtentTestManager.info("Gross Acres for Parcel 2 : " + map.get("Acres_2"));
		    By acres2 = By.xpath("//*[text()='"+map.get("Parcel_2")+"']/../..//*[contains(text(),'"+map.get("Acres_2")+"')]");
		    sa.assertTrue(util.isElementVisible(acres2, 30),"Gross Acres "+map.get("Acres_2")+" for Parcel " + map.get("Parcel_2") + " is not added in Report");
		
		    ExtentTestManager.info("Parcel 3 : " + map.get("Parcel_3"));
		    By parcel3 = By.xpath("//*[text()='"+map.get("Parcel_3")+"']");
		    sa.assertTrue(util.isElementVisible(parcel3, 30),"Parcel " + map.get("Parcel_3") + " is not added in Report");
		    
		    ExtentTestManager.info("Gross Acres for Parcel 3 : " + map.get("Acres_3"));
		    By acres3 = By.xpath("//*[text()='"+map.get("Parcel_3")+"']/../..//*[contains(text(),'"+map.get("Acres_3")+"')]");
		    sa.assertTrue(util.isElementVisible(acres3, 30),"Gross Acres "+map.get("Acres_3")+" for Parcel " + map.get("Parcel_3") + " is not added in Report");
		
			sa.assertAll();
			
		}
		
	 public void viewSSRSReport(Map<String, String> map, String testcaseName) throws Exception {
         
			try {
				navigateToSSRSReport();
				log("STEP 1:  Navigate to Menu - SSRS Report", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to Menu - SSRS Report", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
			util.dummyWait(2);
			try {
				setDDReport(map.get(Excel.DDReport));
				log("STEP 2:  User can select DDReport", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User can not select Report", Status.FAIL);
				throw new RuntimeException("Failed in step 2: User can not Select Report");
			}
			
			try {
				setProjectName(map.get(Excel.ProjectName));
				PROJECT_NAME = map.get(Excel.ProjectName);
				log("STEP 3:  User can select ProjectName", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User can not enter ProjectName", Status.FAIL);
				throw new RuntimeException("Failed in step 3: User can not enter ProjectName");
			}
			
			try {
				clickOnView();
				log("STEP 4:  User can click on View", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User can not click on View", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				verifyReportData(map,testcaseName);
			log("STEP 5:  User can see all report data correctly", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5:  Report data is missing or incorrect", Status.FAIL);
		}
			
		}
}
