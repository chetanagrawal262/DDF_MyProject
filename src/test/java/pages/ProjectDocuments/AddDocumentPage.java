package pages.ProjectDocuments;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddDocumentPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddDocumentPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectInformation = By.xpath("(//span[contains(text(),'Project Information')])[1]");
	By navDocumentManagement = By.xpath("(//span[text()='Document Management'])[1] | (//span[text()='Project Documents'])[1]");
	By btnAddDocumentAlt = By.xpath("(//*[@id='ctl00_ConPHRightTop_RadPageView2']//img[@alt='Add Documents'])[1]");
	By btnAddDocumentDot = By.xpath("//input[contains(@id,'_UC_btnAddDocumenyDM')]");
	By btnAddDocumentRow = By.xpath("//img[@alt='Add Documents']");
	By iframeDocument = By.xpath("//iframe[@name='AddDocuments'] | //iframe[@name='AddDocumentsNR']");
	By drpCategory = By.xpath("//select[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadCategory')]");
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc0') and @type='text']"); 
	By btnLoadDocuments = By.xpath("//input[contains(@id,'buttonSubmit_input') and @type='submit'] | //input[contains(@id,'buttonSubmit_input') and @type='button']");
    By DocumentName = By.xpath("//span[@id='lblResults']");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
	By drpDraftFinalExternalDoc = By.xpath("//select[contains(@id,'_rauFileUploadDraftFinal')]");
	By drpDraftFinalExternalLink = By.xpath("//input[contains(@id,'_ddlDynamicDocDraft1') and @type='text']");
	By txtExecutionDate = By.xpath("//input[contains(@id,'_dpExecDate1')]");
	By txtEffectiveDateExtDoc = By.xpath("//input[contains(@id,'_rauFileUploaddpEffecDate1')]");
	By txtEffectiveDateExtLink = By.xpath("//input[contains(@id,'_dpEffecDate1')]");
    
    //DOT
    By drpCategoryDOT = By.xpath("//select[contains(@id,'Category')]");
    By txtDescriptionDOT = By.xpath("//textarea[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')]");
   
    //ROW
    By drpCategoryROW = By.xpath("//select[contains(@id,'_rauFileUploadCategory')] | //select[contains(@id,'_rauFileUploadcategory')]");
    By txtDescriptionROW = By.xpath("//input[contains(@id,'RadUpload1Desc') or contains(@id,'rauFileUploadDesc')] ");
    
    
    public void NavigateToDocumentManagement() {
        util.waitUntilElementDisplay(navProject);
        util.click(navProject);
        util.waitUntilElementDisplay(navProjectInformation);
        util.click(navProjectInformation);
        util.waitUntilElementDisplay(navDocumentManagement);
        util.click(navDocumentManagement);
 	
    }
    
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
    
       By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
  		public void uploadFile() {
  			util.dummyWait(1);
  			String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
  			driver.findElement(fileUpload).sendKeys(filepath);
  		}
  	    
  	    public void SelectCategory(String value) {
  	    	if (!commonFunction.checkNA(value))
  				util.inputTextAndPressTab(drpCategory, value);
  			
  	    }
  	    
  	  public void SelectDraftFinalExtDoc(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpDraftFinalExternalDoc, value);
			
	    }
  	  
  	  public void SelectCategoryDOT(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategoryDOT, value);
			
	    }
  	    
  	By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined')]");
    
    public void selectCategoryTree(String value) {
		if (!commonFunction.checkNA(value)) {
			util.waitForWebElementToBePresent(drpCategoryROWTree);
			util.selectValueFromDropdown3(drpCategoryROWTree, value);			
		}
	}
    
  	  public void SelectCategoryROW(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategoryROW, value);
			
	    }
  	    
  	    public void AddDescription(String value) {
  	    	if (!commonFunction.checkNA(value))
  				util.inputTextAndPressTab(txtDescription, value);
  			
  	    }
  	    
  	  public void AddDescriptionDOT(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionDOT, value);
			
	    }
  	  
  	public void AddDescriptionROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescriptionROW, value);
		
    }
  	    
  	    public void LoadDocuments() {
  	    	util.click(btnLoadDocuments);
  	    	util.dummyWait(1);
  	    	Assert.assertTrue(util.isElementPresent(DocumentName));
  			
  	    }
  	    
  	  public void ClickOnCloseButton() {
  		  util.switchToDefaultContent();
  		  util.waitUntilElementDisplay(btnClose);
	    	util.click(btnClose);
			
	    }

  	  public void AddDocument(Map<String, String> map, String testcaseName) {
	    	
  		try {
  			NavigateToDocumentManagement();
  			commonFunction.projectSelection();
			log("STEP 1: User can navigate to the Document Management", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot see the option in Menu", Status.FAIL);
			throw new RuntimeException("Failed in step 1 ");
		}
  		
  		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
  			
  			 try {
  				ClickOnAddDocumentALT();
	 			log("STEP 2: User can click on the add document button", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot see the add document button", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 try {
	    		util.switchToIframe(iframeDocument);
	    		 util.dummyWait(5);
	    		 uploadFile();
	 			log("STEP 3: User can upload document from the system ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3:  User cannot upload document from the system   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }

	    	 
	    	 try {
	    		 util.dummyWait(5);
	       		 util.click(drpCategory);
	       		 SelectCategory(map.get(Excel.Category));
	 			log("STEP 4: Value added diplays in Category field      ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4:  Added value does not display in Category field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 
	    	 
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	 			log("STEP 5: User can enter a value in Description field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5:  User cannot add a value in Description field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 
	    	 try {
	    		 SelectDraftFinalExtDoc(map.get("DraftFinal"));
	 			log("STEP 6: User can select Draft Final Value  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6:  User cannot select Draft Final Value   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
  			
	    	 try {
	    		 LoadDocuments();
	 			log("STEP 7: document is loaded AND message-' Loaded- documentname'  displays", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7:   docuemnt could not be uploaded. AND message-' Loaded- documentname' does not display  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
  			
  		}
  		  
  		else if(testcaseName.contains("DOT")) {
  			
  			 try {
   				ClickOnAddDocumentDOT();
 	 			log("STEP 2: User can click on the add document button", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 2: User cannot see the add document button", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 2");
 	 		 }
 	    	 
 	    	 try {
 	    		util.switchToIframe(iframeDocument);
 	    		 util.dummyWait(5);
 	    		 uploadFile();
 	 			log("STEP 3: User can upload document from the system ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 3:  User cannot upload document from the system   ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 3");
 	 		 }

 	    	 
 	    	 try {
 	    		 util.dummyWait(10);
 	    		 util.click(drpCategoryDOT);
 	    		 SelectCategoryDOT(map.get(Excel.Category));
 	 			log("STEP 4: Value added diplays in Category field      ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 4:  Added value does not display in Category field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 4");
 	 		 }
 	    	 
 	    	 
 	    	 try {
 	    		 AddDescriptionDOT(map.get(Excel.Description));
 	 			log("STEP 5: User can enter a value in Description field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 5:  User cannot add a value in Description field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 5");
 	 		 }
   			
 	    	 try {
 	    		 LoadDocuments();
 	 			log("STEP 6: document is loaded AND message-' Loaded- documentname'  displays", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 6:   docuemnt could not be uploaded. AND message-' Loaded- documentname' does not display  ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 6");
 	 		 }
   			
  		}
  		
  		else {
  			
  			 try {
   				ClickOnAddDocumentROW();
 	 			log("STEP 2: User can click on the add document button", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 2: User cannot see the add document button", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 2");
 	 		 }
 	    	 
 	    	 try {
 	    		util.switchToIframe(iframeDocument);
 	    		 util.dummyWait(5);
 	    		 uploadFile();
 	 			log("STEP 3: User can upload document from the system ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 3:  User cannot upload document from the system   ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 3");
 	 		 }
              
 	    	if(util.isElementPresent(drpCategoryROWTree)) {
 	   			try {
 	   				selectCategoryTree(map.get(Excel.Category));
 	   				log("STEP 4: Value added diplays in Category field      ", Status.PASS);
 	   			} catch (Exception e) {
 	   				log("STEP 4:  Added value does not display in Category field    ", Status.FAIL);
 	   				throw new RuntimeException("Failed in step 4");
 	   			}
 	   		}else {
 	    	 
 	    	 try {
 	    		 util.dummyWait(5);
 	    		 util.click(drpCategoryROW);
 	    		 SelectCategoryROW(map.get(Excel.Category));
 	 			log("STEP 4: Value added diplays in Category field      ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 4:  Added value does not display in Category field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 4");
 	 		 }
 	   		}
 	    	 
 	    	 try {
 	    		 AddDescriptionROW(map.get(Excel.Description));
 	 			log("STEP 5: User can enter a value in Description field   ", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 5:  User cannot add a value in Description field    ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 5");
 	 		 }
   			
 	    	try {
	    		 SelectDraftFinalExtDoc(map.get("DraftFinal"));
	 			log("STEP 6: User can select Draft Final Value  ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6:  User cannot select Draft Final Value   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
 	    	
 	    	try {
	    		 Assert.assertTrue(util.isElementVisible(txtEffectiveDateExtDoc));
	 			log("STEP 7: User can see Effective Date Field on the External Document   ", Status.PASS);
	 		 } catch (AssertionError e) {
	 			log("STEP 7:  User cannot see Effective Date Field on the External Document ", Status.FAIL);
	 		 }
 	    	
 	    	 try {
 	    		 LoadDocuments();
 	 			log("STEP 8: document is loaded AND message-' Loaded- documentname'  displays", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 8:   docuemnt could not be uploaded. AND message-' Loaded- documentname' does not display  ", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 8");
 	 		 }
   			
  		}
  		  
  	  } 
}
