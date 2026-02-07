package pages.InfoByParcelReport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;

import extentReports.ExtentTestManager;
import pages.projectImportALT.LandDataImportPage;

public class InfoByParcelsReportsPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	LandDataImportPage objLandDataImportPage;
	JavascriptExecutor js;
	String projectName;
	int count = 0;
	public String parcelNos;
	SoftAssert sa= new SoftAssert();
	
	
	public InfoByParcelsReportsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		js = (JavascriptExecutor) driver;
		objLandDataImportPage = new LandDataImportPage(driver);
	}

	By navProjectMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navImport = By.xpath("*//span[text()='Import'] | *//span[text()='Import'] | //*[@id=\"ctl00_ContentPlaceHolderHeader_YALHD_RadYALMenu\"]/ul/li[3]/div/ul/li[3]/a/span");
	By msgError = By.xpath("//*[contains(@id,'rgDataMigrationErorLog_radYALGridControl')]/td[4]");

	By viewErrorLog = By.xpath("//*[contains(@id,'ViewErrorLog')]/img");
	By downlodPDF = By.xpath("//a[contains(@id,'DownloadPDF')]");
	By downloadExcel = By.xpath("//a[contains(@id,'DownloadEXCEL')]");
	By importMessage = By.xpath("//*[text()='Data imported successfully'] | //*[text()='Data was imported successfully to the selected project']");
	By errorMessage = By.xpath("//*[contains(text(),'error(s) exist in your import file.  Please click on View Errors for more details and try again.')]");
	By btnLoadDataProject = By.xpath("//input[contains(@id,'btnLoadTract')]");
	By parcelNo = By.xpath("//tr[contains(@id,'idYalImport_RadGridUpload_ctl00__0')]/td[1]");
	By panelImportTemplates = By.xpath("//span[@class='rdExpand']");
	
	public void navigateToImport() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navImport);
		util.click(navImport);

	}

	public void printErrorLog() {
		List<WebElement> error = driver.findElements(msgError);
		for(WebElement var: error) {
			count++;
			ExtentTestManager.info("Error_Msg " +count+" : "+ var.getText());
		}
	}
	
	By CheckParcelNo = By.xpath("//tr[contains(@id,'idYalImport_RadGridUpload')]/td[1]");
	List<String> parceList = new ArrayList<String>();
	
	public List<String> importedParcelsList() {
		List<WebElement> lst = driver.findElements(CheckParcelNo);
		
		for(WebElement e : lst){
			//util.highlightElement(e);
			parceList.add(e.getText());
		}
		return parceList;
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
	
	By loadDocument = By.xpath("//input[contains(@id,'buttonSubmit')]");
	By fileUpload = By.xpath("//input[contains(@id,'RadUpload1file') or contains(@id,'rauFileUploadfile')]");

	public void uploadFile(String testcasename) {
		if (testcasename.contains("ALT") || testcasename.contains("ATWELL") || testcasename.contains("CONNECTGEN") || testcasename.contains("ORION") || testcasename.contains("ORSTED") || testcasename.contains("NOVA")) {
			
				String filepath = System.getProperty("user.dir") + File.separator+ ".\\ImportExcels//Scenario_View_InfoByParcelsReports.xlsx";
				driver.findElement(fileUpload).sendKeys(filepath);
		}
	
		util.dummyWait(5);
		log("User can Upload valid template ", Status.PASS);
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
	
	By navParcelMenu = By.xpath("*//a//span[@class='rmText rmExpandDown' and contains(text(),'Parcel')]");
	By navParcelInfo = By.xpath("*//span[text()='Parcel Info']/parent::a");
	By navParcelInformation = By.xpath("*//span[text()='Parcel Information']/parent::a");

	public void navigateToParcelInformation() {
		util.waitUntilElementDisplay(navParcelMenu);
		util.click(navParcelMenu);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
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
	
	public void projectDataImport(Map<String, String> map, String testcaseName) throws Exception {

		try {
			navigateToImport();
			log("STEP 1:  User can navigate to Import Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot navigate to Import Page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
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
			importedParcelsList();
			setProject(map.get(Excel.Project));
			projectName=map.get(Excel.Project);
			log("STEP 5:  User can able to select Project", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  User can not able to select Project", Status.FAIL);
			throw new RuntimeException("Failed in step 5:  User can not able to select Project");
		}
		try {
			setMapping(map.get(Excel.Mapping));
		    util.dummyWait(5);
		    objLandDataImportPage.LandDataMapping(testcaseName);
		    util.dummyWait(5);
			log("STEP 6:  User can able to select Mapping", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User can not able to select Mapping", Status.FAIL);
			throw new RuntimeException("Failed in step 6:  User can not able to select Mapping");
		}
		util.dummyWait(10);
		try {
			util.click(btnLoadDataProject);
			log("STEP 7:  User can able to click on Load Data to Project Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User can not able to click on Load Data to Project Button", Status.FAIL);
			throw new RuntimeException("Failed in step 7: User can not able to click on Load Data to Project Button");
		}
		util.dummyWait(10);
		try {
			Assert.assertTrue(util.isElementPresent(importMessage, 30), "Data import message not displayed");
  			WebElement element = driver.findElement(panelImportTemplates);
		new Actions(driver).moveToElement(element).perform();
			ExtentTestManager.infoWithScreenshot("Data Imported Successfully");
	        log("STEP 8:  Import Successfully :", Status.PASS);
		} catch (AssertionError t) {
			util.dummyWait(10);
			  util.click(viewErrorLog);
			  util.dummyWait(2);
			  util.switchToChildWindow();
			  ExtentTestManager.infoWithScreenshot("Error Log Info");
			  printErrorLog();
			  driver.close();
			  util.switchToParentWindow(); 
			  util.dummyWait(1);
			  log("STEP 8:  Import is not perfome Successfully :", Status.FAIL);
			  throw new RuntimeException("Failed in step 8:  Import is not perfome Successfully");
		}
		
		try {
			navigateToParcelInformation();
			log("STEP 9:  User can navigate to Parcel Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  User cannot navigate to Parcel Page", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			selectProjectNew(map.get(Excel.Project));
			log("STEP 10:  User can select the project", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  User cannot select the project", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			SoftAssert sa= new SoftAssert();
			for(String var: parceList) {
				ExtentTestManager.info("Imported Parcel : " + var);
						By addedRecord = By.xpath("//td[text()='"+var+"']/parent::tr");
						WebElement element = driver.findElement(addedRecord);
						new Actions(driver).moveToElement(element).perform();
						util.highlightElement(driver.findElement(By.xpath("(//td[text()='"+var+"'])[1]")));
						sa.assertTrue(util.isElementVisible(addedRecord, 30), "Record "+var+" is not added yet");
				}
			sa.assertAll();
			log("STEP 11:  All Imported Parcels are visible in the Parcel list", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  Parcel List does not display  imported parcel data", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
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
		if (!commonFunction.checkNA(value)) {
		util.click(drpDDReport);
		By entertxt = By.xpath("//input[contains(@class,'rddtFilterEmptyMessage')]");
		util.inputText(entertxt, value);
		By selectDD = By.xpath("//*[contains(text(),'"+value+"')]");
		util.click(selectDD);
		}
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
	}
	
	By btnNextPage = By.xpath("//input[@title='Next Page' and contains(@src,'NextPage.gif')]");
	public void clickOnNextPage() {
		util.waitUntilElementDisplay(btnNextPage);
		util.click(btnNextPage);
	}
	
	
	By btnPreviousPage = By.xpath("//input[@title='Previous Page' and contains(@src,'PrevPage.gif')]");
	public void clickOnPreviousPage() {
		util.waitUntilElementDisplay(btnPreviousPage);
		util.click(btnPreviousPage);
	}
	
	public void verifyReportData(String testcaseName) throws Exception {
		
		ExtentTestManager.info("Associated Agreement : " + AddNewPayeeInfoPage.AGREEMENT_NUMBER);
		By addedAgr = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[text()='"+AddNewPayeeInfoPage.AGREEMENT_NUMBER+"']");
		sa.assertTrue(util.isElementVisible(addedAgr, 30),"Ageement Number " + AddNewPayeeInfoPage.AGREEMENT_NUMBER + " is not added in Report");

		if(Landowner_AddLandownerPage.ENTITY_NAME != null && !Landowner_AddLandownerPage.ENTITY_NAME.isEmpty()) {
		ExtentTestManager.info("Name : " + Landowner_AddLandownerPage.ENTITY_NAME);
		By addedName = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[text()='"+Landowner_AddLandownerPage.ENTITY_NAME+"']");
		sa.assertTrue(util.isElementVisible(addedName, 30),"Name " + Landowner_AddLandownerPage.ENTITY_NAME + " is not added in Report");
		}
		
		ExtentTestManager.info("Manually Added Parcel # : " + ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL);
		By addedParcel = By.xpath("//*[text()='" + ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL + "']");
		sa.assertTrue(util.isElementVisible(addedParcel, 30),"Parcel # " + ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL + " is not added in Report");

		if(!ParcelInformation_AddNewParcelPage.COUNTY_PID.isEmpty()) {
		ExtentTestManager.info("County PID : " + ParcelInformation_AddNewParcelPage.COUNTY_PID);
		By addedCountyPID = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[text()='"+ParcelInformation_AddNewParcelPage.COUNTY_PID+"']");
		sa.assertTrue(util.isElementVisible(addedCountyPID, 30),"County PID " + ParcelInformation_AddNewParcelPage.COUNTY_PID + " is not added in Report");
		}
		
		if(!AddNewPayeeInfoPage.AGREEMENT_STATUS.contains("Select One")) {
		ExtentTestManager.info("Agreement Status : " + AddNewPayeeInfoPage.AGREEMENT_STATUS);
		By addedStatus = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[text()='"+AddNewPayeeInfoPage.AGREEMENT_STATUS+"']");
		sa.assertTrue(util.isElementVisible(addedStatus, 30),"Agreement Status " + AddNewPayeeInfoPage.AGREEMENT_STATUS+ " is not added in Report");
		}
		
		ExtentTestManager.info("Acquisition Priority : " + ParcelInformation_AddNewParcelPage.ACQUISITION_PRIORITY);
		By addedPriority = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[text()='"+ParcelInformation_AddNewParcelPage.ACQUISITION_PRIORITY+"']");
		sa.assertTrue(util.isElementVisible(addedPriority, 30),"Acquisition Priority " + ParcelInformation_AddNewParcelPage.ACQUISITION_PRIORITY+ " is not added in Report");
		
		ExtentTestManager.info("County : " + LegalDescription_AddLegalDescriptionRecordPage.COUNTY);
		By addedCounty = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[contains(text(),'"+LegalDescription_AddLegalDescriptionRecordPage.COUNTY+"')]");
		sa.assertTrue(util.isElementVisible(addedCounty, 30),"County " + LegalDescription_AddLegalDescriptionRecordPage.COUNTY+ " is not added in Report");
		
		if(!LegalDescription_AddLegalDescriptionRecordPage.LEGALDESC.isEmpty()) {
		ExtentTestManager.info("Legal Desc : " + LegalDescription_AddLegalDescriptionRecordPage.LEGALDESC);
		By addedLegalDesc = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[contains(text(),'"+LegalDescription_AddLegalDescriptionRecordPage.LEGALDESC+"')]");
		sa.assertTrue(util.isElementVisible(addedLegalDesc, 30),"Legal Desc " + LegalDescription_AddLegalDescriptionRecordPage.LEGALDESC+ " is not added in Report");
		}
		
		if(!ParcelInformation_AddNewParcelPage.PARCEL_ACRES.isEmpty()) {
		ExtentTestManager.info("Parcel Acres : " + ParcelInformation_AddNewParcelPage.PARCEL_ACRES);
		By addedParcelAcres = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[contains(text(),'"+ParcelInformation_AddNewParcelPage.PARCEL_ACRES+"')]");
		sa.assertTrue(util.isElementVisible(addedParcelAcres, 30),"Parcel Acres " + ParcelInformation_AddNewParcelPage.PARCEL_ACRES+ " is not added in Report");
	}
	
		if(!testcaseName.contains("ReportConfiguration")) {
			if(!ParcelInformation_AddNewParcelPage.GIS_ACRES.isEmpty()) {
		ExtentTestManager.info("GIS Acres : " + ParcelInformation_AddNewParcelPage.GIS_ACRES);
		By addedGISAcres = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[contains(text(),'"+ParcelInformation_AddNewParcelPage.GIS_ACRES+"')]");
		sa.assertTrue(util.isElementVisible(addedGISAcres, 30),"GIS Acres " + ParcelInformation_AddNewParcelPage.GIS_ACRES+ " is not added in Report");
		}
		}
		
		if(!ParcelInformation_AddNewParcelPage.LEASED_ACRES.isEmpty()) {
		ExtentTestManager.info("Leased Acres : " + ParcelInformation_AddNewParcelPage.LEASED_ACRES);
		By addedLeasedAcres = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[contains(text(),'"+ParcelInformation_AddNewParcelPage.LEASED_ACRES+"')]");
		WebElement element = driver.findElement(addedLeasedAcres);
		new Actions(driver).moveToElement(element).perform();
		sa.assertTrue(util.isElementVisible(addedLeasedAcres, 30),"Leased Acres " + ParcelInformation_AddNewParcelPage.LEASED_ACRES+ " is not added in Report");
		}
		
		ExtentTestManager.info("Section : " + LegalDescription_AddLegalDescriptionRecordPage.SECTION);
		By addedSection = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[contains(text(),'"+LegalDescription_AddLegalDescriptionRecordPage.SECTION+"')]");
		sa.assertTrue(util.isElementVisible(addedSection, 30),"Section " + LegalDescription_AddLegalDescriptionRecordPage.LEGALDESC+ " is not added in Report");
		
		ExtentTestManager.info("Township : " + LegalDescription_AddLegalDescriptionRecordPage.TOWNSHIP);
		By addedTownship = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[contains(text(),'"+LegalDescription_AddLegalDescriptionRecordPage.TOWNSHIP+"')]");
		sa.assertTrue(util.isElementVisible(addedTownship, 30),"Township " + LegalDescription_AddLegalDescriptionRecordPage.TOWNSHIP+ " is not added in Report");
		
		ExtentTestManager.info("Range : " + LegalDescription_AddLegalDescriptionRecordPage.RANGE);
		By addedRange = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[contains(text(),'"+LegalDescription_AddLegalDescriptionRecordPage.RANGE+"')]");
		sa.assertTrue(util.isElementVisible(addedRange, 30),"Range " + LegalDescription_AddLegalDescriptionRecordPage.RANGE+ " is not added in Report");
		
		if(Landowner_AddLandownerPage.CITY != null && !Landowner_AddLandownerPage.CITY.isEmpty()) {
		ExtentTestManager.info("City : " + Landowner_AddLandownerPage.CITY);
		By addedCity = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[text()='"+Landowner_AddLandownerPage.CITY+"']");
		sa.assertTrue(util.isElementVisible(addedCity, 30),"City " + Landowner_AddLandownerPage.CITY + " is not added in Report");
		}
		
//		ExtentTestManager.info("State : " + Landowner_AddLandownerPage.STATE);
//		By addedState = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[text()='"+Landowner_AddLandownerPage.STATE+"']");
//		sa.assertTrue(util.isElementVisible(addedState, 30),"State " + Landowner_AddLandownerPage.STATE + " is not added in Report");
		
		if (Landowner_AddLandownerPage.ZIPCODE != null && !Landowner_AddLandownerPage.ZIPCODE.trim().isEmpty()) {
		ExtentTestManager.info("Zip Code : " + Landowner_AddLandownerPage.ZIPCODE);
		By addedZipCode = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[text()='"+Landowner_AddLandownerPage.ZIPCODE+"']");
		WebElement element1 = driver.findElement(addedZipCode);
		new Actions(driver).moveToElement(element1).perform();
		sa.assertTrue(util.isElementVisible(addedZipCode, 30),"Zip Code " + Landowner_AddLandownerPage.ZIPCODE + " is not added in Report");
		}
		
		
	}
	
	By errorMsg = By.xpath("//div[contains(@id,'NonReportContent')]");
	
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
			throw new RuntimeException("Failed in step 4: User can not click on View");
		}
		
		try {
			Assert.assertFalse(util.isElementVisible(errorMsg));
			log("STEP 5:  Report successfully dislayed", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5:  Report is throwing an error", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			ExtentTestManager.info("Verifying manually added record");
			ExtentTestManager.info("Project Name : "+ map.get(Excel.ProjectName));
					By addedRecord = By.xpath("//*[text()='"+ParcelInformation_AddNewParcelPage.MANUALLYADDED_PARCEL+"']/../../../../..//*[text()='"+map.get(Excel.ProjectName)+"']");
					sa.assertTrue(util.isElementVisible(addedRecord, 30), map.get(Excel.ProjectName)+" is not added in Report");

					verifyReportData(testcaseName);
					sa.assertAll();
		log("STEP 6:  Manually Added Parcels is visible in the Info By Parcels Report", Status.PASS);
	} catch (AssertionError e) {
		log("STEP 6:  Manually Added Parcels does not display in the Info By Parcels Report", Status.FAIL);
	}
		
		
	}

}
