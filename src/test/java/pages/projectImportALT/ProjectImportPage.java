package pages.projectImportALT;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class ProjectImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ErrorLog objErrorLog;
	JavascriptExecutor js;
	String projectName;
	
	public ProjectImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		js = (JavascriptExecutor) driver;
		objErrorLog = new ErrorLog(driver);
	}

	By navProjectMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navImfort = By.xpath("*//span[text()='Import'] | *//span[text()='Import'] | //*[@id=\"ctl00_ContentPlaceHolderHeader_YALHD_RadYALMenu\"]/ul/li[3]/div/ul/li[3]/a/span");

	public void navigateToImport() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navImfort);
		util.click(navImfort);

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
			navigateToImport();
			log("STEP 1:  User can navigate to Import Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to Import Page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			util.click(panelImportTemplates);
			log("STEP 2:  User can expand Import Templates panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot expand Import Templates panel", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		List<WebElement> templates = driver.findElements(linkTemplates);
		ExtentTestManager.info("Total Number of Templates Available: " + templates.size());

		try {
			for (WebElement var : templates) {
				var.click();
				ExtentTestManager.info("User can download '" + var.getText() + "' Template");
				util.dummyWait(5);
				Assert.assertTrue(isFileDownloaded("C:\\Users\\cagrawal\\Downloads\\", var.getText()), "Failed to download Expected document");
//				File f = new File("C:\\Users\\CAgrawal\\Downloads\\"+var.getText()); 
//				 f.exists(); // this will print true or false whether the file exists
				util.dummyWait(2);	
				 ExtentTestManager.info("'"+var.getText()+"'"+" File exists in the download folder");
			        }
				
			log("STEP 3: All Import Templates validated sucessfully", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot click on Template link", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}

	}	
	
	By loadDocument = By.xpath("//input[contains(@id,'buttonSubmit')]");
	By fileUpload = By.xpath("//input[contains(@id,'RadUpload1file') or contains(@id,'rauFileUploadfile')]");

	public void uploadFile(String testcasename) {
		if (testcasename.contains("ALT")) {
			if(environment.contains("STEELHEAD")) {
				String filepath = System.getProperty("user.dir") + File.separator+ ".\\ImportExcels//STEELHEAD-Consolidated_Project_Data_Import.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}else {
			if (testcasename.contains("ProductionTracking")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Valid_Production_Tracking_Import_Template_Ramaco.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			} else {
				String filepath = System.getProperty("user.dir") + File.separator+ ".\\ImportExcels//ALT-Consolidated_Project_Data_Import_Valid data.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			}
			}
		}
		
		if (testcasename.contains("ATWELL")) {
			if (testcasename.contains("ProductionTracking")) {
				String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//Valid_Production_Tracking_Import_Template_Ramaco.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
			} else {
				String filepath = System.getProperty("user.dir") + File.separator+ ".\\ImportExcels//Atwell-Consolidated_Project_Data_Import.xlsx";
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
			if(environment.contains("WOLFMIDSTREAM")) {
                String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//WOLF-Consolidated Import Template.xlsx";
                driver.findElement(fileUpload).sendKeys(filepath);
                }else {
			String filepath = System.getProperty("user.dir") + File.separator + ".\\ImportExcels//ROW-Consolidated Import Template.xlsx";
			driver.findElement(fileUpload).sendKeys(filepath);
			}
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
	
	By drpWorkSheet = By.xpath("//input[contains(@id,'radcbSheets_Input')]");

	public void setWorkSheet(String value) {
		util.waitUntilElementDisplay(drpWorkSheet);
		util.inputTextAndPressTab(drpWorkSheet, value);
	}

	public void setWorkSheetRAMACO(String value) {
		util.waitUntilElementDisplay(drpWorkSheet);
		value = "'" + value + "'";
		util.inputTextAndPressTab(drpWorkSheet, value);
	}

	By drpImportType = By.xpath("//input[contains(@id,'DDImportType')]");

	public void setImportType(String value) {
		util.waitUntilElementDisplay(drpImportType);
		util.inputTextAndPressTab(drpImportType, value);
	}

	By drpProject = By.xpath("//input[contains(@id,'ProjectList')]");

	public void setProject(String value) {
		util.waitUntilElementDisplay(drpProject);
		util.inputTextAndPressTab(drpProject, value);
	}

	By dropMapping = By.xpath("//input[contains(@id,'RadMyUploadMap')]");

	public void setMapping(String value) {
		util.waitUntilElementDisplay(dropMapping);
		util.inputTextAndPressTab(dropMapping, value);
		util.waitUntilLoaderDisappear();
	}

	
	public void projectDataImport(Map<String, String> map, String testcaseName) throws Exception {

		try {
			navigateToImport();
			log("STEP 1:  Navigate to Menu - Import", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  Navigate to Menu - Import", Status.FAIL);
			throw new RuntimeException("Failed in step 1: Popup up does not appear");
		}
		
		try {
			uploadFile(testcaseName);
			if(util.isElementVisible(loadDocument)) {
				util.click(loadDocument);
			}
			log("STEP 2:  User can Upload File", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not Upload File", Status.FAIL);
			throw new RuntimeException("Failed in step 2: User can not Upload File");
		}
			try {
				setWorkSheet(map.get(Excel.WorkSheet));
				
				log("STEP 3:  User can able to select WorkSheet", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User can not able to select WorkSheet", Status.FAIL);
				throw new RuntimeException("Failed in step 3:  User can not able to select WorkSheet");
			}

		try {
			setImportType(map.get(Excel.ImportType));
			log("STEP 4:  User can able to select ImportType", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User can not able to select ImportType", Status.FAIL);
			throw new RuntimeException("Failed in step 4:  User can not able to select ImportType");
		}
		try {
			setProject(map.get(Excel.Project));
			projectName=map.get(Excel.Project);
			log("STEP 5:  User can able to select Project", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not able to select Project", Status.FAIL);
			throw new RuntimeException("Failed in step 5:  User can not able to select Project");
		}
		try {
			setMapping(map.get(Excel.Mapping));
			log("STEP 6:  User can able to select Mapping", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User can not able to select Mapping", Status.FAIL);
			throw new RuntimeException("Failed in step 6:  User can not able to select Mapping");
		}
		util.dummyWait(10);
	}

	By projectErrorMsg = By.xpath("//*[text()='Please select the project for importing tracts.']");
	By projectLable = By.xpath("//span[contains(@id,'lblImportProject_YALLabel')]");
	public void invalidProjectDataImport(Map<String, String> map, String testcaseName) throws Exception {

		try {
			navigateToImport();
			log("STEP 1:  Navigate to Menu - Import", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Navigate to Import Page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			uploadInvalidFile(testcaseName);
			if(util.isElementVisible(loadDocument)) {
				util.click(loadDocument);
			}
			log("STEP 2:  User can Upload File", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User can not Upload File", Status.FAIL);
			throw new RuntimeException("Failed in step 2: User can not Upload File");
		}

			try {
				
					setWorkSheet(map.get(Excel.WorkSheet));
				log("STEP 3:  User can able to select WorkSheet", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User can not able to select WorkSheet", Status.FAIL);
				throw new RuntimeException("Failed in step 3:  User can not able to select WorkSheet");
			}
		
		try {
			
			setImportType(map.get(Excel.ImportType));
			log("STEP 4:  User can able to select ImportType", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User can not able to select ImportType", Status.FAIL);
			throw new RuntimeException("Failed in step 4:  User can not able to select ImportType");
		}
		
		try {
			setMapping(map.get(Excel.Mapping));
			log("STEP 5:  User can able to select Mapping", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not able to select Mapping", Status.FAIL);
			throw new RuntimeException("Failed in step 5:  User can not able to select Mapping");
		}
		util.dummyWait(10);
		
		try {
			util.click(btnLoadDataProject);
			log("STEP 6:  User can able to click on Load Data to Project Button without selecting the project ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User can not able to click on Load Data to Project Button without selecting the project", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		util.waitUntilLoaderDisappear();
		
		try {
			util.waitUntilElementDisplay(projectErrorMsg);
			Assert.assertTrue(util.isElementVisible(projectErrorMsg, 20), "Error message not displayed");
			ExtentTestManager.log("Error msg when project not selected : " +driver.findElement(projectErrorMsg).getText());
			log("STEP 7:  Error messege sucessfully displayed if project not selected", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7:  Error message does not display", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			setProject(map.get(Excel.Project));
			projectName=map.get(Excel.Project);
			log("STEP 8:  User can able to select Project", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User can not able to select Project", Status.FAIL);
			throw new RuntimeException("Failed in step 8:  User can not able to select Project");
		}
		
		util.dummyWait(10);
		try {
			util.click(btnLoadDataProject);
			log("STEP 9:  User can able to click on Load Data to Project Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User can not able to click on Load Data to Project Button", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		util.waitUntilLoaderDisappear();
		try {
			Assert.assertTrue(util.isElementVisible(errorMessage, 30), "Error message not displayed");
  			WebElement element = driver.findElement(panelImportTemplates);
		new Actions(driver).moveToElement(element).perform();
			ExtentTestManager.infoWithScreenshot("Error message sucessfully displayed for Invalid data import");
			ExtentTestManager.log("Error msg when imported invalid data : " + driver.findElement(errorMessage).getText());
	        log("STEP 10:  Error message sucessfully displayed for Invalid data import", Status.PASS);
		} catch (AssertionError t) {
			  log("STEP 10:  Error message does not display for Invalid Import ", Status.FAIL);
			  throw new RuntimeException("Failed in step 10");
		}
		
		try {
			util.dummyWait(10);
			  util.click(viewErrorLog);
			  util.switchToChildWindow();
			  ExtentTestManager.infoWithScreenshot("Error Log Info");
	        log("STEP 11:  User can click on View Error Log button", Status.PASS);
		} catch (Exception e) {
			  log("STEP 11:  User cannot click on View Error Log button ", Status.FAIL);
			  throw new RuntimeException("Failed in step 11");
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
	 
	By navParcelMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Parcel')] | *//a//span[@class='rmText rmExpandDown' and contains(text(),'Tract')]");
	By navParcelInfo = By.xpath("*//span[text()='Parcel Info']/parent::a | *//span[text()='Tract Info']/parent::a");
	By navParcelInformation = By.xpath("//span[text()='Parcel Information']/parent::a | //span[text()='Record Information']/parent::a | //span[text()='Tract Information']/parent::a");

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
	
	By viewErrorLog = By.xpath("//*[contains(@id,'ViewErrorLog')]/img");
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	By importMessage = By.xpath("//*[text()='Data imported successfully'] | //*[text()='Data was imported successfully to the selected project']");
	By errorMessage = By.xpath("//*[contains(text(),'error(s) exist in your import file.  Please click on View Errors for more details and try again.')]");
	By btnLoadDataProject = By.xpath("//input[contains(@id,'btnLoadTract')]");
	By parcelNo = By.xpath("//tr[contains(@id,'idYalImport_RadGridUpload_ctl00__0')]/td[1]");
	By landownerErrorMessage = By.xpath("//*[text()='The Landowner(s) in the import sheet already exist on the tract.  Please click on View Errors for more details and try again.']");
	
	
	public void loadDataToProject(Map<String, String> map, String testcaseName) throws Exception {
		try {
			util.click(btnLoadDataProject);
			log("STEP 8:  User can able to click on Load Data to Project Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  User can not able to click on Load Data to Project Button", Status.FAIL);
			throw new RuntimeException("Failed in step 8: User can not able to click on Load Data to Project Button");
		}
		util.waitUntilLoaderDisappear();
		if(!util.isElementVisible(landownerErrorMessage)) {
		try {
			Assert.assertTrue(util.isElementPresent(importMessage, 30), "Data import message not displayed");
  			WebElement element = driver.findElement(panelImportTemplates);
		new Actions(driver).moveToElement(element).perform();
			ExtentTestManager.infoWithScreenshot("Data Imported Successfully");
	        log("STEP 9:  Import Successfully :", Status.PASS);
		} catch (AssertionError t) {
			util.dummyWait(10);
			  util.click(viewErrorLog);
			  util.dummyWait(2);
			  util.switchToChildWindow();
			  ExtentTestManager.infoWithScreenshot("Error Log Info");
			  objErrorLog.printErrorLog();
			  driver.close();
			  util.switchToParentWindow(); 
			  util.dummyWait(1);
			  log("STEP 9:  Import is not perfome Successfully :", Status.FAIL);
			  throw new RuntimeException("Failed in step 9:  Import is not perfome Successfully");
		}
		}else {
			log("Landowner Already Exists, Update the data and try again", Status.SKIP);
		}
		
	}

}
