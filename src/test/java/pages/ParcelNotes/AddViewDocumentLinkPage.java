package pages.ParcelNotes;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddViewDocumentLinkPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddViewDocumentLinkPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelNotes = By.xpath("(//span[text()='Parcel Notes'])[1]");
	By navAgentNotes = By.xpath("(//span[text()='Agent Notes'])[1]");
	By ContactLog = By.xpath("//tr[contains(@id,'_AGENTNOTES_radYALGridControl_ctl00__0')]");
	By btnAddUpdateDocument = By.xpath("//span[contains(text(),'Add/Update Document')]");
    By iframeDocument = By.xpath("//iframe[@name='AddDocuments']");
	By drpCategory = By.xpath("//select[@id='RadPanelBar1_i0_i0_rauFileUploadCategory0']");
	By txtDescription = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc0') and @type='text']"); 
    By drpCategoryROW = By.xpath("//select[contains(@id,'_rauFileUploadCategoryDD0')]");
    By txtDescriptionROW = By.xpath("//input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')] ");
	By btnLoadDocuments = By.xpath("//input[contains(@id,'buttonSubmit_input') and @type='submit'] | //input[contains(@id,'buttonSubmit_input') and @type='button']");
    By DocumentName = By.xpath("//span[@id='lblResults']");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
	By pendingStatus = By.xpath("(//tr[contains(@id,'_AGENTNOTES_radYALGridControl_ctl00__0')]/.//strong[text()='Pending'])[1]");
	
	
	  public void NavigateToParcelNotesAlt() {
	        util.waitUntilElementDisplay(navParcel);
	        util.click(navParcel);
	        util.waitUntilElementDisplay(navParcelInfo);
	        util.click(navParcelInfo);
	        util.waitUntilElementDisplay(navParcelNotes);
	        util.click(navParcelNotes);	
	    }
	  
	  public void NavigateToParcelNotesRow() {
	        util.waitUntilElementDisplay(navParcel);
	        util.click(navParcel);
	        util.waitUntilElementDisplay(navParcelInfo);
	        util.click(navParcelInfo);
	        util.waitUntilElementDisplay(navAgentNotes);
	        util.click(navAgentNotes);	
	    }
	  
	  public void ClickonAddUpdateDocument() {
	    	WebElement web = driver.findElement(ContactLog);
	    	util.waitUntilElementDisplay(ContactLog);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	    	util.waitUntilElementDisplay(btnAddUpdateDocument);
	    	util.click(btnAddUpdateDocument);
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
	    
	    public void AddDescription(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDescription, value);
			
	    }
	    
	    public void LoadDocuments() {
	    	util.click(btnLoadDocuments);
	    	util.waitUntilElementDisplay(DocumentName);
	    	Assert.assertTrue(util.isElementPresent(DocumentName));
			
	    }
	    
	    public void SelectCategoryROW(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpCategoryROW, value);
			
	    }

  	  
  	public void AddDescriptionROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescriptionROW, value);
		
    }

	  public void AddDocument(Map<String, String> map, String testcaseName) {
		  if (testcaseName.contains("DOT")) {
    			log("Add  Document not applicable for DOT ", Status.SKIP);
    		}
		  else {
	    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ATWELL") || testcaseName.contains("ORION")) {
	    		util.reloadPage();
	    		 util.dummyWait(8);
	    		 if(util.isElementVisible(pendingStatus)) {
	  			 try {
	  				 
	  				ClickonAddUpdateDocument();
		 			log("STEP 1: User can click on the add document button", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 1: User cannot see the add document button", Status.FAIL);
		 			throw new RuntimeException("Failed in step 1");
		 		 }
		    	 
	  			Set<String> windowId = driver.getWindowHandles(); // get window id of current window
	  			Iterator<String> itererator = windowId.iterator();
	  			String mainWinID = itererator.next();
	  			String newAdwinID = itererator.next();
	  			
	  				  			 
		    	 try {
		    		 driver.switchTo().window(newAdwinID);
		    		 util.dummyWait(8);
		    		 uploadFile();
		 			log("STEP 2: User can upload document from the system ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2:  User cannot upload document from the system   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }

		    	 
		    	 try {
		    		 util.dummyWait(6);
		       		 util.click(drpCategory);
		       		 SelectCategory(map.get(Excel.Category));
		 			log("STEP 3: Value added display in Category field      ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3:  Added value does not display in Category field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }
		    	 
		    	 
		    	 try {
		    		 AddDescription(map.get(Excel.Description));
		 			log("STEP 4: User can enter a value in Description field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 4:  User cannot add a value in Description field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 4");
		 		 }
	  			
		    	 try {
		    		 LoadDocuments();
		    		util.dummyWait(2);
		    	    driver.close();
				  	driver.switchTo().window(mainWinID);
				  	util.dummyWait(2);
		 			log("STEP 5: document is loaded AND message-' Loaded- documentname'  displays", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 5:   docuemnt could not be uploaded. AND message-' Loaded- documentname' does not display  ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 5");
		 		 }
	    		 }
	    		 else {
	    			 log("Notes are not in pending status", Status.SKIP);
	    		 }
	    	}
	    	else {
	    		util.reloadPage();
	    		 util.dummyWait(5);
	    		 if(util.isElementVisible(pendingStatus)) {
		  			 try {
		  				 
		  				ClickonAddUpdateDocument();
			 			log("STEP 1: User can click on the add document button", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 1: User cannot see the add document button", Status.FAIL);
			 			throw new RuntimeException("Failed in step 1");
			 		 }
			    	 
		  			Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		  			Iterator<String> itererator = windowId.iterator();
		  			String mainWinID = itererator.next();
		  			String newAdwinID = itererator.next();
		  			
		  				  			 
			    	 try {
			    		 driver.switchTo().window(newAdwinID);
			    		 util.dummyWait(5);
			    		 uploadFile();
			 			log("STEP 2: User can upload document from the system ", Status.PASS);
			 		 } catch (Exception e) {
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
		 	 	   			selectCategoryROW(map.get(Excel.Category));
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
		 	 	   			log("STEP 4: Fill in Description", Status.FAIL);
		 	 	   			throw new RuntimeException("Failed in step 4");
		 	 	   		}
		  			
			    	 try {
			    		 LoadDocuments();
			    		util.dummyWait(2);
			    	    driver.close();
					  	driver.switchTo().window(mainWinID);
					  	util.dummyWait(2);
			 			log("STEP 5: document is loaded AND message-' Loaded- documentname'  displays", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 5:   docuemnt could not be uploaded. AND message-' Loaded- documentname' does not display  ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 5");
			 		 }
	    		 }
	    		 else {
	    			 log("Notes are not in pending status", Status.SKIP);
	    		 }
	    	  }
 
		  }
	  			
	}
	  
}
