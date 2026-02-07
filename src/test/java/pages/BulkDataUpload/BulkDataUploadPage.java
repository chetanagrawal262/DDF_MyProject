package pages.BulkDataUpload;

import java.io.File;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class BulkDataUploadPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	JavascriptExecutor js;
	String projectName;
	
	public BulkDataUploadPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		js = (JavascriptExecutor) driver;
	}

	By navTool = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Tools')] ");
	By navBulkDataUpload = By.xpath("*//a//span[contains(text(),'Bulk Data Upload')] ");

	public void navigateToBulkDataUpload() {
		util.waitUntilElementDisplay(navTool);
		util.click(navTool);
		util.waitUntilElementDisplay(navBulkDataUpload);
		util.click(navBulkDataUpload);
	}

	public boolean isFileDownloaded(String fileDownloadpath, String fileName) {
		boolean flag = false;
		File directory = new File(fileDownloadpath);
		File[] content = directory.listFiles();
		for (int i = 0; i < content.length; i++)
		{ 
			if (content[i].getName().equals(fileName)) 
				return flag=true; 
			
		}
        return flag; 
		}
	
	By panelImportTemplates = By.xpath("//span[@class='rdExpand']");
	By linkTemplates = By.xpath("//a[contains(@id,'linkFileName')]");

	public void downloadImportTemplates() {

		try {
			navigateToBulkDataUpload();
			log("STEP 1:  User can navigate to Bulk Data Upload Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to Bulk Data Upload Page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		String templateName = driver.findElement(linkTemplates).getText();

		try {
			    util.click(linkTemplates);
				ExtentTestManager.info("User can download '" + templateName + "' Template");
				util.dummyWait(5);
				Assert.assertTrue(isFileDownloaded("C:\\Users\\cagrawal\\Downloads\\", templateName), "Failed to download Expected document");
				util.dummyWait(2);	
				 ExtentTestManager.info("'"+templateName+"'"+" File exists in the download folder");
			log("STEP 2: Bulk Data Upload Templates downloaded sucessfully", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot download Bulk Data Upload Template", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

	}	
	
	By btnScheduleImportJob = By.xpath("//input[contains(@id,'_bttnImportJob')]");
	By fileUpload = By.xpath("//input[contains(@id,'RadUpload1file') or contains(@id,'rauFileUploadfile')]");

	public void uploadFile(String testcasename) {
		if (testcasename.contains("ALT") || testcasename.contains("ATWELL")) {
			if (testcasename.contains("ProductionTracking")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Valid_Production_Tracking_Import_Template_Ramaco.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			} else {
				String filepath = System.getProperty("user.dir") + File.separator+ ".\\ImportExcels//ALT-Consolidated_Project_Data_Import_Valid data.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}
		}
		
		if (testcasename.contains("CONNECTGEN")) {
			if (testcasename.contains("ProductionTracking")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Valid Production Tracking Import Template.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}else if(testcasename.contains("DocumentImport")){
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Document Import.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);	
			} else{
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ConnectGen_Valid_Project_Data_Import.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
				}
		}
		
		if (testcasename.contains("ORION")) {
		if (testcasename.contains("ProductionTracking")) {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Valid Production Tracking Import Template.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}else if (testcasename.contains("TitleImport") || testcasename.contains("Layout_PermittedImport")) {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ORION-Valid Title Import Template.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}else {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Orion_Project_Data_Import.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}
		}
        
		if (testcasename.contains("NOVA")) {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//NOVA-Consolidated_Project_Data_Import_Valid data.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}

		if (testcasename.contains("ORSTED")) {
			if(testcasename.contains("FacilitiesDataImport")) {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ORSTED-Facilities_Data_Import_With_valid_data.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
			}
			else if (testcasename.contains("TurbineDataImport")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ORSTED-Turbine_Data_Import_With_valid_data.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}
			else  if (testcasename.contains("ProductionTracking")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Valid Production Tracking Import Template.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
		}else {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ORSTED-Consolidated_Project_Data_Import_With_valid_data.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}
				
		}
		
		if (testcasename.contains("ROW") || testcasename.contains("TRA")) {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ROW-Consolidated Import Template.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}
		util.dummyWait(5);
		log("User can Upload valid template ", Status.PASS);
	}

	public void uploadInvalidFile(String testcasename) {
		if (testcasename.contains("ALT") || testcasename.contains("ATWELL")) {
			if (testcasename.contains("ProductionTracking")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Invalid_Production_Tracking_Import_Template_Ramaco.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}else if (environment.contains("STEELHEAD") & testcasename.contains("TurbineDataImport")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//STEELHEAD-Turbine_Data_Import_With_Invalid_data.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}else if (environment.contains("STEELHEAD") & testcasename.contains("EasementData")){
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//STEELHEAD-Invalid_Easement_Data_Import.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}else {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ALT-Consolidated_Project_Data_Import_Invalid_Data.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}
		}
		
		if (clientName.contains("ORSTED")) {
			if(testcasename.contains("FacilitiesDataImport")) {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ORSTED-Facilities_Data_Import_With_Invalid_data.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
			}
			else if(testcasename.contains("TurbineDataImport")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ORSTED-Turbine_Data_Import_With_Invalid_data.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}else  if (testcasename.contains("ProductionTrackingImportORSTED")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Invalid Production Tracking Import Template.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}else {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ALT-Consolidated_Project_Data_Import_Invalid_Data.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}
			}
		if (testcasename.contains("CONNECTGEN")) {
			if (testcasename.contains("ProductionTracking")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Invalid Production Tracking Import Template.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}else {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ConnectGen_Invalid_Project_Data_Import.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
			}
		}
		
		
		
		if (testcasename.contains("ROW") || testcasename.contains("TRA")) {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ROW-InvalidConsolidated Import Template.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}

		if (testcasename.contains("ORION")) {
			
			if (testcasename.contains("ProductionTracking")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Invalid Production Tracking Import Template.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}else if (testcasename.contains("TitleImport") || testcasename.contains("Layout_PermittedImport")){
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ORION-Invalid Title Import Template.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}else {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Orion_Invalid_Project_Data_Import.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}
			
		}
        
		if (testcasename.contains("NOVA")) {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//NOVA-Consolidated_Project_Data_Import_Invalid_Data.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}
		
		if (testcasename.contains("DOT")) {
			String filepath = System.getProperty("user.dir") + File.separator + "DOT-Document Import.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
		}
		util.dummyWait(5);
		log("User can Upload the Invalid Template ", Status.PASS);
	}
	
	
	public void scheduleImportJob(String testcaseName) throws Exception {

		try {
			navigateToBulkDataUpload();
			log("STEP 1:  Navigate to Menu - Bulk Data Upload", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  Navigate to Menu - Bulk Data Upload", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			uploadFile(testcaseName);
			log("STEP 2:  User can Upload File", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not Upload File", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			util.click(btnScheduleImportJob);
			log("STEP 3:  User can click on Schedule Import Job button", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User can not click on Schedule Import Job button", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

		util.dummyWait(10);
	}

	By projectErrorMsg = By.xpath("//*[text()='Please select the project for importing tracts.']");
	By projectLable = By.xpath("//span[contains(@id,'lblImportProject_YALLabel')]");
	public void invalidBulkDataUpload(Map<String, String> map, String testcaseName) throws Exception {

		try {
			navigateToBulkDataUpload();
			log("STEP 1:  Navigate to Menu - Bulk Data Upload", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Navigate to Bulk Data Upload Page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			uploadInvalidFile(testcaseName);
			log("STEP 2:  User can Upload File", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not Upload File", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

			try {
				util.click(btnScheduleImportJob);
				log("STEP 3:  User can click on Schedule Import Job button", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User can not click on Schedule Import Job button", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectInformation = By.xpath("//span[contains(text(),'Project Information')]");
	By navProjectDetails = By.xpath("*//a//span[contains(text(),'Project Details')] ");
	
	 public void NavigateToProjectInformation() {
	    	util.waitUntilElementDisplay(navProject);
	    	util.click(navProject);
	    	util.waitUntilElementDisplay(navProjectInformation);
	    	util.click(navProjectInformation);
	    	util.waitUntilElementDisplay(navProjectDetails);
			util.click(navProjectDetails);
	    	
	    }
	 
	By navParcelMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Parcel')]");
	By navParcelInfo = By.xpath("*//span[text()='Parcel Info']/parent::a");
	By navParcelInformation = By.xpath("//span[text()='Parcel Information']/parent::a | //span[text()='Record Information']/parent::a");

	public void navigateToParcelInformation() {
		util.waitUntilElementDisplay(navParcelMenu);
		util.click(navParcelMenu);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
	}
    
	By navAcquisitionTab = By.xpath("//*[@id=\"ctl00_ContentPlaceHolderHeader_YALHD_RadYALMenu\"]/.//*[text()='Acquisition'] | //*[@id='ctl00_ContentPlaceHolderHeader_YALHD_RadYALMenu']/.//*[text()='ROW Components']");
	public void navigateToAcquisition() {
		util.waitUntilElementDisplay(navParcelMenu);
		util.click(navParcelMenu);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navAcquisitionTab);
		util.click(navAcquisitionTab);
	}
	
	By navNotesTab = By.xpath("//*[@id='ctl00_ContentPlaceHolderHeader_YALHD_RadYALMenu']/.//*[text()='Parcel Notes'] |//*[@id='ctl00_ContentPlaceHolderHeader_YALHD_RadYALMenu']/.//*[text()='Agent Notes']");
	public void navigateToNotes() {
		util.waitUntilElementDisplay(navParcelMenu);
		util.click(navParcelMenu);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navNotesTab);
		util.click(navNotesTab);
	}
	
	public void NotesSelection(Map<String, String> map, String testcaseName) {
		navigateToNotes();		
		selectProjectNew(map.get(Excel.Project));
		
	}
	
	public void acquisitionSelection(Map<String, String> map, String testcaseName) {
		navigateToAcquisition();		
		selectProjectNew(map.get(Excel.Project));
		
	}
	
	By navTitleTab = By.xpath("//*[@id=\"ctl00_ContentPlaceHolderHeader_YALHD_RadYALMenu\"]/.//*[text()='Title']");
	public void navigateToTitle() {
		util.waitUntilElementDisplay(navParcelMenu);
		util.click(navParcelMenu);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navTitleTab);
		util.click(navTitleTab);
		
		
	}
	

	public void titleSelection(Map<String, String> map, String testcaseName) {
		navigateToTitle();		
		selectProjectNew(map.get(Excel.Project));
		
	}
	
	By navProjectMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navAgreementInformation = By.xpath("//a//span[contains(text(),'Agreement Information')] | //a//span[contains(text(),'Entity Information')]");
	By pageTitle = By.xpath("//table[contains(@id,'LSLST_RadGridTracts')]//th//a[text()='Agreement Information']");
	
	public void navigateToAgreementInformation() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.dummyWait(1);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navAgreementInformation);
	}
	By txtProjectName = By.xpath("//span/parent::div[contains(@id,'ProjectList')]");
	By CategoryFilter = By.xpath("//input[contains(@class,'rddtFilterEmptyMessage')]");

	private void selectProjectNew(String value) {
		if (!commonFunction.checkNA(value)) {
			util.waitUntilElementDisplay(txtProjectName);
			util.click(txtProjectName);
			util.inputText(CategoryFilter, value);
			By selectDD = By
					.xpath("//div[contains(@id,'ProjectList_EmbeddedTree')]//*[contains(text(),'" + value + "')]");
			util.click(selectDD);

		}
	}

	public void projectSelection(Map<String, String> map, String testcaseName) {
		navigateToParcelInformation();
		selectProjectNew(map.get(Excel.Project));

	}

	By navPermanentInfrastructure = By.xpath("*//span[text()='Permanent Infrastructure']/parent::a");
	public void projectSelectionPermanentInfrastructure(Map<String, String> map, String testcaseName) {
		util.waitUntilElementDisplay(navParcelMenu);
		util.click(navParcelMenu);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navPermanentInfrastructure);
		util.click(navPermanentInfrastructure);
		selectProjectNew(map.get(Excel.Project));

	}
	
	public void projectSelectionParcel(Map<String, String> map, String testcaseName) {
		navigateToParcelInformation();
		selectProjectNew(projectName);

	}
	
	public void projectSelectionAgreement(Map<String, String> map,String testcaseName) {
		navigateToAgreementInformation();
		selectProjectNew(map.get(Excel.Project));

	}
	
	public void projectSelectionAgreementConnectGen(Map<String, String> map,String testcaseName) {
		navigateToAgreementInformation();
		selectProjectNew(projectName);

	}
	
	public void projectSelectionProject(Map<String, String> map,String testcaseName) {
		NavigateToProjectInformation();
		selectProjectNew(map.get(Excel.Project));

	}

}
