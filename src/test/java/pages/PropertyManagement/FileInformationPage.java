package pages.PropertyManagement;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class FileInformationPage  extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	

	public FileInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}	
	
	//PM file summary
	By navProjectMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navPropertyManagement = By.xpath("//*[@id=\"ctl00_ContentPlaceHolderHeader_YALHD_RadYALMenu\"]/ul/li[3]/div/ul/li[4]/a/span");
	By navFileInformation =By.xpath("*//a//span[contains(text(),'File Information')] ");
	By AddNewFile = By.xpath("//table[contains(@id,'LSLST_RadGridTracts')]//a[contains(@id,'_Add')]");
	By FileFrame = By.xpath("//iframe[@name='NewPMFile']");
	By drpFiletype = By.xpath("//input[contains(@id,'Activity_type_ID_YALComboBox_Input')]");
	By btnSave = By.xpath("//input[contains(@id,'btnAddPMFile')]");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
//	By FileTypeOnPage = By.xpath("//input[contains(@id,'_Activity_type_ID_radYALDropDownList_Input')]");
	
	public void NavigateToFileInformation() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navPropertyManagement);
		util.click(navPropertyManagement);
		util.waitUntilElementDisplay(navFileInformation);
		util.click(navFileInformation);
	}
	public void addNewFileInformation() {
		util.waitUntilElementDisplay(AddNewFile);
		util.click(AddNewFile);
		
	}
	
	public void SelectFileType(String value) {
		util.switchToIframe(FileFrame);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpFiletype, value);
	}
	
	
	
	
	
	public void ClickonSave() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.switchToDefaultContent();
    	}
	public void ClosePopUp() {
		util.waitUntilElementDisplay(btnClose);
		util.switchToDefaultContent();
		util.click(btnClose);
    	}
	
 
	 By FileTypeOnPage = By.xpath("//input[contains(@id,'_Activity_type_ID_radYALDropDownList_Input')]");
		public String getFileTypeOnPage() {
			return util.getAttributeValue(FileTypeOnPage, "value");
		}
		
		Map<String, String> excelData;
		public void VerifyFileType(String testcaseName) {
			SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROPERTYMANAGEMENT_TEST_DATA), Excel.PMFileSummary, testcaseName);
					
				assertion.assertEquals(getFileTypeOnPage(), excelData.get("FileType").trim(), "File Type miss-matched");
					ExtentTestManager.log("Actual File Type is : " +getFileTypeOnPage());
	 
		}
	 
	 
	 
	 

	 
	public void AddPMFile(Map<String, String> map, String testcaseName) throws InterruptedException {
	
		try {
			NavigateToFileInformation();
			log("STEP 1: User can navigate to File information", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User unable to navigate to File information", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			addNewFileInformation();
			log("STEP 2: User can click on add icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User unable to click on add new icon", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		try {
			SelectFileType(map.get(Excel.FileType));
			log("STEP 3: User can select file type", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select file type", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
			
		try {
			ClickonSave();
			log("STEP 4: User can click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User unable to click on add new icon", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
//		try {
//			ClosePopUp();
//			util.dummyWait(1);
//			log("STEP 4: User can click on close on pop up", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 4: User cannot click on close on pop up", Status.FAIL);
//			throw new RuntimeException("Failed in step 4");
//		}
		try {
			VerifyFileType(testcaseName);
			log("STEP 5: File Type matched", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: File Type mis-matched ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
	}
}
