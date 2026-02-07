package pages.Relocation;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditRelocationOnFilePage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditRelocationOnFilePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnEdit = By.xpath("//tbody/tr[@id='ctl00_ConPHRightTop_TRRE_UC_radPanels_i2_i0_gridRELOCATIONSONFILE_radYALGridControl_ctl00__0']/td[10]/a[1]");
	By btnSave = By.xpath("//input[contains(@id,'radPrjPanels_i0_i0_btnSaveTract') and @type='button']");	
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	By btnAddNotes = By.xpath("//input[contains(@id,'radPrjPanels_i0_i0_btnAgentNotes') and @type='button']");
	By iframeNotes = By.xpath("//iframe[@name='UserListDialog']");
	By txtActivityDate = By.xpath("//input[contains(@id,'AgntNotes_AD_dateInput') and @type='text']");
	By drpAgent = By.xpath("//input[contains(@id,'AgntNotes_UID_radYALDropDownList_Input') and @type='text']");
	By drpCategory = By.xpath("//input[contains(@id,'AgntNotes_CID_radYALDropDownList_Input') and @type='text']");
	By txtDescription = By.xpath("//iframe[@id='AgntNotes_RE1_contentIframe']");
	By btnSaveNote = By.xpath("//input[contains(@id,'AgntNotes_SN') and @type='button']"); 
	By successmessage = By.xpath("//span[text()='Note submitted and auto-approved.']");
	By btnAddDocument = By.xpath("//input[contains(@id,'radPrjPanels_i0_i0_btnAgentDocs') and @type='button']");
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
	By drpCategoryForDocument = By.xpath("//select[@id='RadPanelBar1_i0_i0_rauFileUploadCategory0']");
	By txtDescriptionForDocument = By.xpath("//textarea[@id='RadPanelBar1_i0_i0_rauFileUploadDesc0']");
	By btnLoadDocument = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_buttonSubmit_input') and @type='submit']");
	By ExternalLink = By.xpath("//span[contains(text(),'External Link')]");
	By txtDocumentName = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_txtDynamic1') and @type='text']");
	By txtExternalLink = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_link1') and @type='text']");
	By Category = By.xpath("//span[@class='rddtInner rddtFocused']");
	By SelectCategory = By.xpath("(//span[contains(text(),'Docusign Demo') and @class='rtIn'])[1]"); 
	By txtDescriptionForExternalLink = By.xpath("//input[@id='radReportConfigPanels_i0_i0_description1']");
	By btnLoadDocumentForExternalLink = By.xpath("//input[@id='radReportConfigPanels_i0_i0_btnSave_input']");
	By btnAdd = By.xpath("//input[@id='radReportConfigPanels_i0_i0_btnAdd_input']");
//	By btnClose = By.xpath("//a[@class='rwCloseButton']");
	
	public void ClickOnEditButton() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
	}
	
	

	public void ClickOnSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
	}
	
	public void ClickOnAddNotes() {
		util.waitUntilElementDisplay(btnAddNotes);
		util.click(btnAddNotes);
	}
	
	public void SelectActivityDate(String value) {
		util.switchToIframe(iframeNotes);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtActivityDate, value);
    }
	
	  public void SelectAgent(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAgent, value);
	    }
	  
	  public void SelectCategory(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategory, value);
	    }
	    
	  public void AddDescription(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescription, value);
	    }
	  
	  By btnClose = By.xpath("//a[@title='Close']");
	  public void ClickOnSaveNote() {
			util.waitUntilElementDisplay(btnSaveNote);
			util.click(btnSaveNote);
			util.waitUntilElementDisplay(successmessage);
			Assert.assertTrue(util.isElementPresent(successmessage), "Note submitted and auto-approved.");
			util.switchToDefaultContent();
			util.click(btnClose);
	}
	  
	  public void ClickOnAddDocument() {
			util.waitUntilElementDisplay(btnAddDocument);
			util.click(btnAddDocument);
	}
	  
	  By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
		public void uploadFile() {
			String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
			driver.findElement(fileUpload).sendKeys(filepath);
		}
	  
	  public void SelectCategoryForDocument(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategoryForDocument, value);
    }
	  
	  public void AddDescriptionForDocument(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionForDocument, value);
    }
	  
	  public void ClickOnLoadDocument() {
			util.waitUntilElementDisplay(btnLoadDocument);
			util.click(btnLoadDocument);
	}
	  
	  public void ClickOnExternalLink() {
			util.waitUntilElementDisplay(ExternalLink);
			util.click(ExternalLink);
	}
	  
	  public void AddDocumentName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentName, value);
     }
	  
	  public void AddExternalLink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExternalLink, value);
     }
	  
	  public void AddCategory() {
			util.waitUntilElementDisplay(Category);
			util.click(Category);
			util.waitUntilElementDisplay(SelectCategory);
			util.click(SelectCategory);
     }
	  
	  public void AddDescriptionForExternalLink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionForExternalLink, value);
     }
	  
	  public void ClickOnLoadDocumentButton() {
			util.waitUntilElementDisplay(btnLoadDocumentForExternalLink);
			util.click(btnLoadDocumentForExternalLink);
     }
	  
	  public void ClickonAddButton() {
			util.waitUntilElementDisplay(btnAdd);
			util.click(btnAdd);
     }
	  
	  public void ClickonCloseButton() {
		  util.switchToDefaultContent();
			util.waitUntilElementDisplay(btnClose);
			util.click(btnClose);
			util.dummyWait(2);
			
   }
	
	  public void EditRelocationOnFile(Map<String, String> map, String testcaseName) {
		  util.dummyWait(5);
		  try {
			  ClickOnEditButton();
	 			log("STEP 1: Relocation Information Record should be open in new Tab ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: Record does not open in new Tab ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
		  
		  Set<String> windowId = driver.getWindowHandles(); // get window id of current window
			Iterator<String> itererator = windowId.iterator();

			String mainWinID = itererator.next();
			String newAdwinID = itererator.next();
	    	 
	    	 try {
	    		driver.switchTo().window(newAdwinID);
	    		ClickOnSaveButton();
	 			log("STEP 3: Changes saved successfully! message should be display above grid", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: Changes saved successfully! message should be display above the Save button", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 
	    	 try {
	    		 ClickOnAddNotes();
	 			log("STEP 4: User can click on the Add Notes button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: User cannot see the Add Notes button  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
	    	 try {
	    		 SelectActivityDate(map.get(Excel.ActivityDate));
	 			log("STEP 5: User can select the  Activity Date", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: User  cannot select  Date  from Date Picker  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	
	    	 try {
	    		 SelectAgent(map.get(Excel.Agent));
	 			log("STEP 7: Added value displays in the Agent field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: User  cannot select  value  from the Agent DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	 
	    	 try {
	    		 SelectCategory(map.get(Excel.Category));
	    		log("STEP 8: Added value displays in the Category field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: User  cannot select  value  from the Category DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	    		log("STEP 9: User can enter a value in the  Description field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 9: User  cannot enter a value in the Description field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 9");
	 		 }
	    	 
	    	 try {
	    		 
	    		 ClickOnSaveNote();
	    		log("STEP 10: Note submitted for review. message should be display above grid", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 10: Note submitted for review. message should be display above the Save button ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 10");
	 		 }
	    	 
	    	 
	    	 try {
	    		 ClickOnAddDocument();
	    		log("STEP 17: User can click on the add document button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 17: User cannot see the add document button  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step `17");
	 		 }
	    	 
	    	 try {
		    	util.switchToIframe(iframeDocument);
		    	 util.dummyWait(5);
		    	 uploadFile();
		 			log("STEP 18: User can upload document from the system     ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 18:  User cannot upload document from the system   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 18");
		 		 }
	    	 
	    	 try {
	    		 SelectCategoryForDocument(map.get(Excel.DocCategory));
	    		log("STEP 19: Added value displays in Category field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 19: User  cannot select  value  from Category DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 19");
	 		 }
	    	 
	    	 try {
	    		 AddDescriptionForDocument(map.get(Excel.Description));
	    		log("STEP 20: User can enter a value in Description field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 20: User  cannot enter a value in Description field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 20");
	 		 }
	    	 
	    	 try {
	    		 ClickOnLoadDocument();
	    		log("STEP 21:  document is loaded ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 21:  docuemnt could not be uploaded. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 21");
	 		 }
	    	 
	    	 try {
	    		 ClickOnExternalLink();
	    		log("STEP 24: panel is expanded & fields are visible.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 24: Panel is not expanded ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 24");
	 		 }
	    	 
	    	 try {
	    		 AddDocumentName(map.get(Excel.DocumentName));
	    		log("STEP 25: User can enter a value in Document Name field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 25: User  cannot enter a value in Document Name field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 25");
	 		 }
	    	 
	    	 try {
	    		 AddExternalLink(map.get(Excel.ExternalLink));
	    		log("STEP 26: User can enter a value in External Link field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 26: User  cannot enter a value in External Link field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 26");
	 		 }
	    	 
	    	 try {
	    		 AddCategory();
	    		log("STEP 27: Added value displays in the field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 27: User  cannot select  value  from the DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 27");
	 		 }
	    	 
	    	 try {
	    		 AddDescriptionForExternalLink(map.get(Excel.Description));
	    		log("STEP 28: User can enter a value in Description field ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 28: User  cannot enter a value in Description field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 28");
	 		 }
	    	 
	    	 try {
	    		 ClickOnLoadDocumentButton();
	    		log("STEP 29: document is loaded  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 29: docuemnt could not be uploaded. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 29");
	 		 }
	    	 
	    	 
	    	 try {
	    		 ClickonAddButton();
	    		log("STEP 30: User can click on add button.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 30: User cannot click on add button. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 30");
	 		 }
	    	 
	    	 try {
	    		 ClickonCloseButton();
	    		 driver.close();
	    		 driver.switchTo().window(mainWinID);
	    		log("STEP 31: POpup should get closed", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 31: popup does not get closed ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 31");
	 		 }
	  }
	  
}
