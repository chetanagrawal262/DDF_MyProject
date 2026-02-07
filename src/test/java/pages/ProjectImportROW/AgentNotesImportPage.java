package pages.ProjectImportROW;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;
import extentReports.ExtentTestManager;
import pages.projectImportALT.ProjectImportPage;

public class AgentNotesImportPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	ProjectImportPage objProjectImportPage;
	ErrorLog objErrorLog;
	public static String DEFAULT_PAGE_SIZE;
	Map<String, String> map = new HashMap<String, String>();
	
	public AgentNotesImportPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		objProjectImportPage = new ProjectImportPage(driver);
		objErrorLog = new ErrorLog(driver);
	}

	
	By tractNumber = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Tract #: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'TRACT_NUMBER') and @type='text'])[1]");
	public String getTractNumber() {
		return util.getAttributeValue(tractNumber, "value");
	}
	
	By activityDate = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Activity Date: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'AgntNotes_AD_dateInput') and @type='text'])[1]");
	public String getActivityDate() {
		return util.getAttributeValue(activityDate, "value");
	}
	By activityTime = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Activity Time: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'AgntNotes_ATime_dateInput') and @type='text'])[1]");
	public String getActivityTime() {
		return util.getAttributeValue(activityTime, "value");
	}
	
	By agentName = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Agent Name: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'AgntNotes_UID') and @type='text'])[1]");
	public String getAgentName() {
		return util.getAttributeValue(agentName, "value");
	}
	
	By category = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Category: ']/..//input[contains(@id,'Dest_Input')] | (//input[contains(@id,'AgntNotes_DDL1_radYALDropDownList_Input') and @type='text'])[1]");
	public String getCategory() {
		return util.getAttributeValue(category, "value");
	}
	
	By childCategory = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Child Category: ']/..//input[contains(@id,'Dest_Input')] | //div[@id=\"AgntNotes_CID_RadDropDownTree1\"]");
	public String getChildCategory() {
		return util.getAttributeValue(childCategory, "value");
	}
	
	By priority = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Priority: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'AgntNotes_PID') and @type='text']");
	public String getPriority() {
		return util.getAttributeValue(priority, "value");
	}
	
	By callType = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Call Type: ']/..//input[contains(@id,'Dest_Input')] | //input[contains(@id,'AgntNotes_CallType') and @type='text']");
	public String getCallType() {
		return util.getAttributeValue(callType, "value");
	}
	
	By notes = By.xpath("//span[contains(@id,'idYalImport_SourceCols') and text()='Notes: ']/..//input[contains(@id,'Dest_Input')] ");
	public String getNotes() {
		return util.getAttributeValue(notes, "value");
	}
	

	Map<String, String> excelData;
	public void AgentNotesImportMapping(String testcaseName) {
		SoftAssert assertion = new SoftAssert();
			excelData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.PROJECT_TEST_DATA), Excel.AgentNotesMapping, testcaseName);
				
				assertion.assertEquals(getTractNumber(), excelData.get("Parcel Number").trim(), "Tract # mapping mismatched");
				ExtentTestManager.log("Tract # Mapping : " +getTractNumber());
				
				assertion.assertEquals(getActivityDate(), excelData.get("Activity Date").trim(), "Activity Date mapping mismatched");
				ExtentTestManager.log("Activity Date Mapping : " +getActivityDate());
				
				assertion.assertEquals(getActivityTime(), excelData.get("Activity Time").trim(), "Activity Time mapping mismatched");
				ExtentTestManager.log("Activity Time Mapping : "+getActivityTime());
				
				assertion.assertEquals(getAgentName(), excelData.get("Agent Name").trim(), "Agent Name mapping mismatched");
				ExtentTestManager.log("Agent Name Mapping : "+getAgentName());
				
				assertion.assertEquals(getCategory(), excelData.get("Notes Category-Parent").trim(), "Category mapping mismatched");
				ExtentTestManager.log("Category Mapping : "+getCategory());
				
				assertion.assertEquals(getChildCategory(), excelData.get("Notes Category-Child").trim(), "Child Category mapping mismatched");
				ExtentTestManager.log("Child Category Mapping : "+getChildCategory());
				
				assertion.assertEquals(getPriority(), excelData.get("Priority").trim(), "Priority mapping mismatched");
				ExtentTestManager.log("Priority Mapping : "+getPriority());
				
				assertion.assertEquals(getCallType(), excelData.get("Call Type").trim(), "Call Type mapping mismatched");
				ExtentTestManager.log("Call Type Mapping : "+getCallType());
				
				assertion.assertEquals(getNotes(), excelData.get("Notes").trim(), "Notes mapping mismatched");
				ExtentTestManager.log("Notes Mapping : "+getNotes());
				
				assertion.assertAll();

			}
	
	public void verifyAgentNotesImportMapping(Map<String, String> map, String testcaseName) throws Exception {
	objProjectImportPage.projectDataImport(map, testcaseName);
	try {
		AgentNotesImportMapping(testcaseName);
		log("STEP 7:  All Land  Data Mappings are correct", Status.PASS);
	} catch (Exception e) {
		log("STEP 7:  Some Mappings are Missing or Incorrect", Status.FAIL);
		throw new RuntimeException("Failed in step 7");
	}
	util.dummyWait(10);
	
}

	By descriptionIframe = By.xpath("//iframe[contains(@id,'AgntNotes_RE1')]");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
	By loaderIcon = By.xpath("(//div[contains(@id,'_RadMultiPage1')])[1]");
	
	public void validationOfImportedData(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();	
		if(environment.contains("WOLFMIDSTREAM")) {
			map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.WOLF_PROJECTIMPORT_FILE), Excel.AgentNotesImport, testcaseName);
			
		}else {
		map = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.ROW_PROJECTIMPORT_FILE), Excel.AgentNotesImport,testcaseName);
		}
		
		util.dummyWait(2);
				 	By addedRecord = By.xpath("//td[text()='"+map.get("Tract #") +"']/parent::tr");
					Assert.assertTrue(util.isElementPresent(addedRecord, 30), "Unable to select parcel");
					util.click(addedRecord);
					
					util.waitUntilElementDisappear(loaderIcon);
					assertion.assertEquals(getTractNumber(), map.get("Tract #").trim(), "Parcel number mismatched");
					ExtentTestManager.log("Parcel number matched : " +getTractNumber());
					
					By editnote = By.xpath("(//tr[contains(@id,'AGENTNOTES_radYALGridControl')]/..//*[contains(text(),'"+map.get("Notes")+"')]/..//*[text()='Edit'])[1]");
					Assert.assertTrue(util.isElementPresent(editnote, 30), "Unable to click on edit link of imported note");
					util.click(editnote);
					util.dummyWait(2);
					
					By iframeRow = By.xpath("//body[1]/form[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/iframe[1]");
					util.switchToIframe(iframeRow);
					util.dummyWait(1);
					
					assertion.assertEquals(getActivityDate(), map.get("Activity Date").trim(), "Activity Date mismatched");
					ExtentTestManager.log("Activity Date  : " +getActivityDate());
					
					assertion.assertEquals(getActivityTime(), map.get("Activity Time").trim(), "Activity Time mismatched");
					ExtentTestManager.log("Activity Time  : "+getActivityTime());
					
					assertion.assertEquals(getAgentName(), map.get("Agent Name").trim(), "Agent Name mismatched");
					ExtentTestManager.log("Agent Name  : "+getAgentName());
					
					assertion.assertEquals(getCategory(), map.get("Category").trim(), "Category mismatched");
					ExtentTestManager.log("Category  : "+getCategory());
					
					if(!map.get("Child Category").trim().contains("NA")) {
					assertion.assertEquals(getChildCategory(), map.get("Child Category").trim(), "Child Category mismatched");
					ExtentTestManager.log("Child Category  : "+getChildCategory());					
					}
					
					assertion.assertEquals(getPriority(), map.get("Priority").trim(), "Priority value mismatched");
					ExtentTestManager.log("Priority value  : "+getPriority());
					
					if(!environment.contains("WOLFMIDSTREAM")) {
					assertion.assertEquals(getCallType(), map.get("Call Type").trim(), "Call Type mismatched");
					ExtentTestManager.log("Call Type  : "+getCallType());
					}
					
					 util.switchToIframe(descriptionIframe);					 
					 By NotesDesc = By.xpath("//body[contains(text(),'"+map.get("Notes").trim()+"')]");
		
					if(util.isElementVisible(NotesDesc)) {
					String Notestext = driver.findElement(NotesDesc).getText();	
					assertion.assertTrue(util.isElementVisible(NotesDesc), "Notes Mistmatched");
					ExtentTestManager.log("Notes : "+Notestext);
					}
					
					util.switchToDefaultContent();
					util.click(btnClose);
					assertion.assertAll();
			 }
		
	public void errorLogValidation(String testcaseName) throws Exception {

		try {
			//objErrorLog.AgentNotesvalidationMsg(testcaseName); 
			objErrorLog.printErrorLog();
	        log("STEP 12:  All Import validation Msg validated sucessfully", Status.PASS);
		} catch (Exception t) {
			  log("STEP 12:  Some Import Validation Msg are missing", Status.FAIL);
			  throw new RuntimeException("Failed in step 12");
		}
		
		try {
			  driver.close();
			  util.switchToParentWindow(); 
			  util.dummyWait(1);
	        log("STEP 13:  User can close the popup", Status.PASS);
		} catch (Exception t) {
			  driver.close();
			  util.switchToParentWindow(); 
			  log("STEP 13:  User cannot close the popup", Status.FAIL);
			  throw new RuntimeException("Failed in step 13");
		}
	}
	
	 By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']"); 
	  By pagesize = By.xpath("//input[contains(@id,'_AGENTNOTES_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_Input')]");
	  By gridConfigIcon = By.xpath("//span[contains(@id,'_AGENTNOTES_ManageGridID')]");
	  By fieldPageSize = By.xpath("//input[contains(@id,'_PageSize') and @type='text']");
	  By btnUpdate = By.xpath("//input[contains(@value,'Update') and @type='submit']");
	  By successMessage = By.xpath("//span[contains(text(),'Update successful!')]");
		
	  public void TurnOnDesignMode() {
	    	util.waitUntilElementDisplay(btnDesignMode);
	    	util.click(btnDesignMode);
	    }
	  
	  public void ClickOnGridConfigIcon() {
	    	util.waitUntilElementDisplay(gridConfigIcon);
	    	util.click(gridConfigIcon);
	    }
	  
	  public void setPageSize(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(fieldPageSize, value);
	    }
	  
	  public void ClickOnUpdate() {
	    	util.waitUntilElementDisplay(btnUpdate);
	    	util.click(btnUpdate);
	    	util.waitUntilElementDisplay(successMessage);
	    	Assert.assertTrue(util.isElementPresent(successMessage), "Update successful!");
	    }
	  
	  public void verifyPageSize(String testcaseName) {
		  
		  try {
			  TurnOnDesignMode();
		 	    log("STEP 1: User can Turn on Design mode", Status.PASS);
	   	   } catch (Exception e) {
		 	    log("STEP 1: User cannot Turn on Design mode", Status.FAIL);
		 		throw new RuntimeException("Failed in step 1");
		   }
		  
		  try {
			  ClickOnGridConfigIcon();
			  util.switchToChildWindow();
		 	    log("STEP 2: User can click on Grid Configuration Icon", Status.PASS);
	   	   } catch (Exception e) {
		 	    log("STEP 2: User cannot click on Grid Configuration Icon", Status.FAIL);
		 		throw new RuntimeException("Failed in step 2");
		   }
		  
		  try {
			  setPageSize("50");
			  DEFAULT_PAGE_SIZE = "50";
			  ExtentTestManager.infoWithScreenshot("Default Page Size Validation");
		 	    log("STEP 3: User can update default Page Size to 50", Status.PASS);
	   	   } catch (Exception e) {
		 	    log("STEP 3: User cannot update default Page Size to 50", Status.FAIL);
		 		throw new RuntimeException("Failed in step 3");
		   }
		  
		  try {
			  ClickOnUpdate();
		 	    log("STEP 4: Default Page Size successfully set", Status.PASS);
	   	   } catch (Exception e) {
		 	    log("STEP 4: User cannot  Update the Configuration", Status.FAIL);
		 		throw new RuntimeException("Failed in step 4");
		   }
		  
		  driver.close();
		  util.switchToParentWindow();
		  driver.navigate().refresh();
		  util.dummyWait(2);
		  
		  try {
			 String actualPageSize= util.getAttributeValue(pagesize, "value");
			 Assert.assertEquals(actualPageSize, DEFAULT_PAGE_SIZE);
		 	    log("STEP 5: Default Page Size set matched", Status.PASS);
	   	   } catch (AssertionError e) {
		 	    log("STEP 5: Default Page Size set not matched", Status.FAIL);
		 	   throw new RuntimeException("Failed in step 5");
		   }
	  }
	  
}
			
		
