package pages.Title;

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

import extentReports.ExtentTestManager;

public class ViewDocumentLinkPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ViewDocumentLinkPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navEasementsRecord = By.xpath("//span[contains(text(),'Easements, Plats, Oil & Gas Leases')]");
	By LinkAddDocument = By.xpath("//a[contains(text(),'Add Document')]");
	By iframeDocument = By.xpath("//iframe[@name='UserListDialog']");
	By btnSelectDocumnet = By.xpath("//span[@class='ruButton ruBrowse']");
	By drpCategory = By.xpath("//select[@id='RadPanelBar1_i0_i0_rauFileUploadCategoryDD0']");
	By drpCategoryALT = By.xpath("//select[@id='RadPanelBar1_i0_i0_rauFileUploadCategory0']");
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')]"); 
	By btnLoadDocuments = By.xpath("//input[contains(@id,'buttonSubmit_input') and @type='submit'] | //input[contains(@id,'buttonSubmit_input') and @type='button']");
    By message = By.xpath("//span[@id='lblResults']");
	By btnExternalLink = By.xpath("(//span[@class='rpExpandHandle'])[2]");
	By txtDocumentName = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_txtDynamic1') and @type='text'] | //input[contains(@id,'RadPanelBar2_i0_i0_txtname1')]");
	By txtExternalLink = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_link1') and @type='text'] | //input[contains(@id,'RadPanelBar2_i0_i0_txtlinkname1')]");
	By drpCategoryExelink = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_RadDropDownTree1']");
	By selectCategoryExelink = By.xpath("/html[1]/body[1]/form[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/span[2]");
	By txtDescriptionExelink = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_description1') and @type='text']");
	By btnLoadDocumentsExeLink = By.xpath("//input[contains(@id,'radReportConfigPanels_i0_i0_btnSave_input') and @type='submit']");
	By btnAddExeLink = By.xpath("//input[@id='radReportConfigPanels_i0_i0_btnAdd_input']");
	By btnCloseDocuments = By.xpath("//a[@class='rwCloseButton']");
	
	By txtCategoryALT = By.xpath("//input[contains(@id,'_radYALDropDownList_Input')]");
	By txtDescriptionALT = By.xpath("//input[@id='RadPanelBar2_i0_i0_txtDynamic1']");
	By btnLoadDocumentALT = By.xpath("//input[@id='RadPanelBar2_i0_i0_btnSave_input']");
	
	 public void AddDocuments() {
	    	util.waitUntilElementDisplay(LinkAddDocument);
			util.click(LinkAddDocument);
			
	    }
	    
	    By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
		public void uploadFile() {
			String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
			driver.findElement(fileUpload).sendKeys(filepath);
		}
	    
By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined')]");
	    
	    public void selectCategoryTree(String value) {
			if (!commonFunction.checkNA(value)) {
				util.waitForWebElementToBePresent(drpCategoryROWTree);
				util.selectValueFromDropdown3(drpCategoryROWTree, value);			
			}
		}
	    
	    By drpCategoryExtDoc = By.xpath("//select[contains(@id,'_rauFileUploadcategory')] | //select[contains(@id,'_rauFileUploadCategory')]");
	    
	    public void selectCategoryROW(String value) {
			if (util.isElementPresent(drpCategoryExtDoc)) {
				util.selectValueFromDropdown2(value, drpCategoryExtDoc);
			}
		}
	    
	    public void selectCategory() {
			util.click(drpCategoryExtDoc);
			util.waitFor(100);
			
			util.pressDownkey();
			util.pressENTERkey();
		}
	    
	    By description = By.xpath("//input[contains(@id,'RadUpload1Desc') or contains(@id,'rauFileUploadDesc')] ");
	    public void setDescription(String value) {
 			if (util.isElementPresent(description)) {
 				util.inputText(description, value);
 			}
 		}
	    
	    public void SelectCategory(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategory, value);
			
	    }
	    
	    public void SelectCategoryALT(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategoryALT, value);
			
	    }
	    
	    public void AddDescription(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescription, value);
			
	    }
	    
	    public void LoadDocuments() {
	    	util.click(btnLoadDocuments);
			Assert.assertTrue(util.isElementPresent(message));

	    }
	    
	    public void ClickonExternalLink() {
	    	util.waitUntilElementDisplay(btnExternalLink);
	    	util.click(btnExternalLink);
			
	    }
	    
	    public void AddDocumentName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentName, value);
			
	    }
	    
	    public void AddExternalLink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExternalLink, value);
			
	    }
	    
	    By selectCategory_ExternalLink = By.xpath("//input[contains(@id,'YALDropDownList_Input')]");
	    By firstCategory = By.xpath("//div[contains(@id,'radYALDropDownList_DropDown')]/..//li[1]");
		public void selectCategoryExternalLink(String value) {
			util.waitUntilElementDisplay(selectCategory_ExternalLink);
			util.inputTextAndPressTab(selectCategory_ExternalLink, value);
		}

		public void selectCategoryExternalLink() {
			util.click(selectCategory_ExternalLink);
			util.click(firstCategory);
		}
		
		By selectCategory_ExternalLinkDOT = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_RadDropDownTree1'] | //input[contains(@id,'XYZ1_radYALDropDownList_Input')]");

		public void selectCategoryExternalLinkDOT(String value) {
			if (!commonFunction.checkNA(value)) {
			util.waitUntilElementDisplay(selectCategory_ExternalLinkDOT);
			util.selectValueFromDropdown3(selectCategory_ExternalLinkDOT, value);}
		}
	    public void AddCategoryForExeLink() {
	    	util.click(drpCategoryExelink);
	    	util.waitUntilElementDisplay(selectCategoryExelink);
	    	util.click(selectCategoryExelink);
			
	    }
	    
	    public void AddCategoryALT(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCategoryALT, value);
	    }
	    
	    public void AddDescriptionExelink(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionExelink, value);
			
	    }
	    
	    public void AddDescriptionALT(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescriptionALT, value);
	    }
	    
	    public void ClickOnLoadDocumentsExeLink() {
	    	util.waitUntilElementDisplay(btnLoadDocumentsExeLink);
	    	util.click(btnLoadDocumentsExeLink);
			Assert.assertTrue(util.isElementPresent(message));

			
	    }
	    
	    public void ClickOnLoadDocumentALT() {
	    	util.waitUntilElementDisplay(btnLoadDocumentALT);
	    	util.click(btnLoadDocumentALT);
	    }
	    
	    public void ClickOnAddExeLink() {
	    	util.waitUntilElementDisplay(btnAddExeLink);
	    	util.click(btnAddExeLink);
			
	    }
	    
	    public void ClickOnCloseDocument() {
	    	util.switchToDefaultContent();
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(btnCloseDocuments);
	    	util.click(btnCloseDocuments);
	    	util.dummyWait(2);

	    }
	    
	    
	    public void ViewDocumentLink(Map<String, String> map, String testcaseName) {
	    	
	    	
	    try {
   		 AddDocuments();
			log("STEP 1: Document popup window should display with external documents tab     ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 1:  The document pop window does not display    ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		 }
   	 
   	 try {
   		util.switchToIframe(iframeDocument);
   		 util.dummyWait(5);
   		 uploadFile();
			log("STEP 2: User can upload document from the system     ", Status.PASS);
		 } catch (Exception e) {
			 ExtentTestManager.infoWithScreenshot("Document does not upload");
			 ClickOnCloseDocument();
			log("STEP 2:  User cannot upload document from the system   ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		 }

   	if(util.isElementPresent(drpCategoryROWTree)) {
			try {
				selectCategoryTree(map.get(Excel.Category));
				log("STEP 3:  User can select Category", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User can not select Category", Status.FAIL);
				throw new RuntimeException("STEP 3:  User can not select Category");
			}
		}else {
		try {
			//selectCategoryROW(map.get(Excel.Category));
			selectCategory();
			log("STEP 3:  User can select Category", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User can not select Category", Status.FAIL);
			throw new RuntimeException("STEP 3:  User can not select Category");
		}
		}
    	 
		try {
			setDescription(map.get(Excel.Description));
			log("STEP 4: Fill in Description", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot Fill in Description", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
   	 

   	 try {
   		 LoadDocuments();
			log("STEP 5: document is loaded     ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 5:   docuemnt could not be uploaded.   ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		 }
   	 
   	 try {
   		 if(!util.isElementVisible(txtDocumentName)) {
   		 ClickonExternalLink();
   		 }
			log("STEP 6: panel is expanded & fields are visible.     ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 6:  Panel is not expanded    ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		 }
   	 
   	 try {
   		 AddDocumentName(map.get(Excel.DocumentName1));
			log("STEP 7: User can enter a value in the  Document Name field   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 7:  User cannot add a value in Document Name field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		 }
   	 
   	 
   	 try {
   		 AddExternalLink(map.get(Excel.ExternalLink1));
			log("STEP 8: User can enter a value in External Link field   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 8:  User cannot add a value in External Link field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		 }
   	 
   	 if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
   	 try {
   		 if (util.isElementPresent(selectCategory_ExternalLink)) {
				//selectCategoryExternalLink(map.get(Excel.Category));
   			selectCategoryExternalLink();
			} else {
				selectCategoryExternalLinkDOT(map.get(Excel.Category));}
			log("STEP 9: User can enter a value in the field   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 9:  User cannot add a value in the field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		 }
   	 
   	 try {
   		 AddDescriptionExelink(map.get(Excel.DescriptionExelink));
			log("STEP 10: User can enter a value in Description field   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 10:  User cannot add a value in Description field    ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		 }
   	 
   	 try {
   		 ClickOnLoadDocumentsExeLink();
			log("STEP 11:document is loaded     ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 11:  document could not be uploaded   ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		 }
   	 
   	try {
   	 ClickOnAddExeLink();
			log("STEP 12:  User can click on add button.      ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 12:  User cannot click on add button.    ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		 }
   	
   	 }else {
   		try {
   		 AddCategoryALT(map.get(Excel.Category));
			log("STEP 9: Added value displays in Category field  ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 9: User  cannot select  value  from Category DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		 }
			
   	 try {
   		 AddDescriptionALT(map.get(Excel.Description));
			log("STEP 10:  User can enter a value in Description field  ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 10: User cannot add a value in Description field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		 }
   	 
   	 try {
   		 ClickOnLoadDocumentALT();
			log("STEP 11: document is loaded AND message-' Loaded- documentname'  displays", Status.PASS);
		 } catch (Exception e) {
			log("STEP 11:   docuemnt could not be uploaded. AND message-' Loaded- documentname' does not display  ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		 }
   	 }
   	 
   	 
   	 
   	 try {
   		 ClickOnCloseDocument();
			log("STEP 13: POpup should get closed   ", Status.PASS);
		 } catch (Exception e) {
			log("STEP 13:  popup does not get closed    ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		 }
   	 
   	 
    }
}
