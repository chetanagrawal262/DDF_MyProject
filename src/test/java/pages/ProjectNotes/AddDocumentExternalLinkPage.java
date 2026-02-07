package pages.ProjectNotes;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddDocumentExternalLinkPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddDocumentExternalLinkPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectInformation = By.xpath("(//span[contains(text(),'Project Information')])[1]");
	By navDocumentManagement = By.xpath("(//span[text()='Document Management'])[1]");
	By btnAddDocumentAlt = By.xpath("(//img[@alt='Add Documents'])[3]");
	By btnAddDocumentDot = By.xpath("//input[contains(@id,'_PRAN_UC_btnAddDocuments')]");
	By btnAddDocumentRow = By.xpath("//input[contains(@id,'_TRACTTYPE_btnAdddocuments') and @type='image']");
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
	By ExpandExternalLink = By.xpath("//span[text()='External Link']");
    By txtDocumentNameALT = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtname1')]");
    By txtDocumentName = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_txtDynamic1')]");
    By txtExternalLinkALT = By.xpath("//input[contains(@id,'RadPanelBar2_i0_i0_txtlinkname1')]");
    By txtExternalLink = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_link1')]");
    By txtCategoryALT = By.xpath("//input[contains(@id,'_radYALDropDownList_Input')]");
	By Category = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_RadDropDownTree1']");
	By SelectCategory = By.xpath("(//span[contains(text(),'Docusign Demo') and @class='rtIn'])[1]");
	By txtDescriptionALT = By.xpath("//input[@id='RadPanelBar2_i0_i0_txtDynamic1']");
	By txtDescription = By.xpath("//input[@id='radReportConfigPanels_i0_i0_description1']");
	By btnLoadDocumentALT = By.xpath("//input[@id='RadPanelBar2_i0_i0_btnSave_input']");
	By btnLoadDocument = By.xpath("//input[@id='radReportConfigPanels_i0_i0_btnSave_input']");
    By DocumentName = By.xpath("//span[@id='lblResults']");
	By btnAddALT = By.xpath("//input[@id='RadPanelBar2_i0_i0_btnAdd_input']");
	By btnAdd = By.xpath("//input[@id='radReportConfigPanels_i0_i0_btnAdd_input']");
	
	public void ClickOnAddDocumentALT() {
    	util.waitUntilElementDisplay(btnAddDocumentAlt);
    	util.click(btnAddDocumentAlt);
    	
    }
    
    public void ClickOnAddDocumentDOT() {
    	util.waitUntilElementDisplay(btnAddDocumentDot);
    	util.click(btnAddDocumentDot);
    	
    }
    
    public void ClickOnAddDocumentROW() {
    	util.waitUntilElementDisplay(btnAddDocumentRow);
    	util.click(btnAddDocumentRow);
    	
      }
    
    public void ExpandExternalLink() {
    	util.waitUntilElementDisplay(ExpandExternalLink);
    	util.click(ExpandExternalLink);
    }
    
    public void ExpandExternalLinkDot() {
    	util.waitUntilElementDisplay(ExpandExternalLink);
    	util.click(ExpandExternalLink);
    }
    
    public void AddDocumentNameAlt(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDocumentNameALT, value);
    }
    
    public void AddDocumentName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDocumentName, value);
    }
    
    public void AddExternalLinkALT(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExternalLinkALT, value);
    }
    
    public void AddExternalLink(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtExternalLink, value);
    }
    
    public void AddCategoryALT(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCategoryALT, value);
    }
    
    public void SelectCategory() {
    	util.waitUntilElementDisplay(Category);
    	util.click(Category);
    	util.waitUntilElementDisplay(SelectCategory);
    	util.click(SelectCategory);
    	
      }
    
    public void AddDescriptionALT(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescriptionALT, value);
    }
    
    public void AddDescription(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescription, value);
    }
    
    public void ClickOnLoadDocumentALT() {
    	util.waitUntilElementDisplay(btnLoadDocumentALT);
    	util.click(btnLoadDocumentALT);
    }
    
    public void ClickOnLoadDocument() {
    	util.waitUntilElementDisplay(btnLoadDocument);
    	util.click(btnLoadDocument);
    }
    
    public void ClickOnAddALTButton() {
    	util.waitUntilElementDisplay(btnAddALT);
    	util.click(btnAddALT);
    	  util.switchToDefaultContent();
          util.click(btnClose);
 
    }
    
    By btnClose = By.xpath("//a[@title='Close']");
    public void ClickOnAddButton() {
    	util.waitUntilElementDisplay(btnAdd);
    	util.click(btnAdd);
      util.switchToDefaultContent();
      util.click(btnClose);
    	
    }

    public void AddDocumentExternalLink(Map<String, String> map, String testcaseName) {
    	 if (testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
				log(" Add Document External Link not applicable for ROW", Status.SKIP);
			}
			else {
    	
  		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
	    	 
	    	 try {
	    		 ExpandExternalLink();
	 			log("STEP 1: panel is expanded & fields are visible.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: Panel is not expanded ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }

	    	 
	    	 try {
	    		 AddDocumentNameAlt(map.get(Excel.DocumentName));
	 			log("STEP 2: User can enter a value in DocumentName field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot add a value in DocumentName field ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 
	    	 try {
	    		 AddExternalLinkALT(map.get(Excel.ExternalLink));
	 			log("STEP 3: User can enter a value in ExternalLink field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3:  User cannot add a value in ExternalLink field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 
	    	 try {
	    		 AddCategoryALT(map.get(Excel.Category));
	 			log("STEP 4: Added value displays in Category field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: User  cannot select  value  from Category DD ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
  			
	    	 try {
	    		 AddDescriptionALT(map.get(Excel.Description));
	 			log("STEP 5:  User can enter a value in the field  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: User cannot add a value in the field   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 
	    	 try {
	    		 ClickOnLoadDocumentALT();
	 			log("STEP 6: document is loaded AND message-' Loaded- documentname'  displays", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6:   docuemnt could not be uploaded. AND message-' Loaded- documentname' does not display  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 util.switchToDefaultContent();
	    	 driver.close();
	    	 util.switchToParentWindow();
  		}
  		  
  		else {
 	    	 
 	    	 try {
 	    		ExpandExternalLinkDot();
 	 			log("STEP 1: panel is expanded & fields are visible.", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 1: Panel is not expanded ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 1");
 	 		 }

 	    	 
 	    	 try {
 	    		 AddDocumentName(map.get(Excel.DocumentName));
 	 			log("STEP 2: User can enter a value in DocumentName field  ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 2: User cannot add a value in DocumentName field ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 2");
 	 		 }
 	    	 
 	    	 
 	    	 try {
 	    		 AddExternalLink(map.get(Excel.ExternalLink));
 	 			log("STEP 3: User can enter a value in ExternalLink field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 3:  User cannot add a value in ExternalLink field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 3");
 	 		 }
 	    	 if(util.isElementPresent(txtCategoryALT)) {
 	    		try {
 		    		 AddCategoryALT(map.get(Excel.Category));
 		 			log("STEP 4: Added value displays in Category field  ", Status.PASS);
 		 		 } catch (Exception e) {
 		 			log("STEP 4: User  cannot select  value  from Category DD ", Status.FAIL);
 		 			throw new RuntimeException("Failed in step 4");
 		 		 }
 	    		 
 	    	 }else {
 	    	 try {
 	    		 SelectCategory();
 	 			log("STEP 4: Added value displays in Category field  ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 4: User  cannot select  value  from Category DD ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 4");
 	 		 }
 	    	 }
 	    	 try {
 	    		 AddDescription(map.get(Excel.Description));
 	 			log("STEP 5:  User can enter a value in Description field  ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 5: User cannot add a value in Description field   ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 5");
 	 		 }
 	    	 
 	    	 try {
 	    		 ClickOnLoadDocument();
 	 			log("STEP 6: document is loaded AND message-' Loaded- documentname'  displays", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 6:   docuemnt could not be uploaded. AND message-' Loaded- documentname' does not display  ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 6");
 	 		 }
 	    	util.switchToDefaultContent();
 	    	util.click(btnClose);
 	    	util.switchToParentWindow();
 	    	
  		}
  		
	  }	
    }
}
