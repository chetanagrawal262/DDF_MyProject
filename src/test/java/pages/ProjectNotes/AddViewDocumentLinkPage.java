package pages.ProjectNotes;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	By linkAddView = By.xpath("//a[contains(text(),'Add/View Document')]");
    By iframe = By.xpath("//iframe[@name='AddViewDocument']");
    By btnAddDocuments = By.xpath("//input[contains(@id,'btnAddDocuments') and @type='submit']");
    By iframeDocuments = By.xpath("//iframe[@name='rwAddDocuments']");
	By drpCategory = By.xpath("//select[contains(@id,'Category')]");
	By txtDescription = By.xpath("//textarea[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')] | //input[contains(@id,'RadPanelBar1_i0_i0_rauFileUploadDesc')]");
	By btnLoadDocument = By.xpath("//input[contains(@id,'_buttonSubmit_input') and @type='submit']"); 
	By SuccessMessage = By.xpath("//span[@id='lblResults']");
	
	public void ClickonAddViewLink() {
		util.dummyWait(2);
		util.waitUntilElementDisplay(linkAddView);
		util.click(linkAddView);
	}
	
	By ContactLog = By.xpath("//tbody/tr[contains(@id,'_AGENTNOTES_radYALGridControl_ctl00__0')]/td[2]");
	By btnAddUpdateDocument = By.xpath("//span[contains(text(),'Add/Update Document')]");
	
	public void ClickonAddUpdateDocument() {
    	WebElement web = driver.findElement(ContactLog);
    	util.waitUntilElementDisplay(ContactLog);
    	Actions act = new Actions(driver);
    	act.moveToElement(web).contextClick().build().perform();
    	util.waitUntilElementDisplay(btnAddUpdateDocument);
    	util.click(btnAddUpdateDocument);
}
	public void ClickOnAddDocument() {
		util.switchToIframe(iframe);
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnAddDocuments);
		util.click(btnAddDocuments);
	}
	
	public void ClickOnAddDocumentALT() {
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnAddDocuments);
		util.click(btnAddDocuments);
	}
	
	By fileUpload = By.xpath("//input[contains(@id,'FileUploadfile')]");
	public void uploadFile() {
		String filepath = System.getProperty("user.dir") + File.separator + "test.txt";
		driver.findElement(fileUpload).sendKeys(filepath);
	}
	
	By drpCategoryROWTree = By.xpath("//div[contains(@id,'rauFileUploadundefined') and @title]");
    
    public void selectCategoryTree(String value) {
		if (!commonFunction.checkNA(value)) {
			util.waitForWebElementToBePresent(drpCategoryROWTree);
			util.selectValueFromDropdown3(drpCategoryROWTree, value);	
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
	
	public void ClickOnLoadDocument() {
		util.waitUntilElementDisplay(btnLoadDocument);
		util.click(btnLoadDocument);
	}
	By btnClose = By.xpath("//a[@class='rwCloseButton']");

	
	
	
	
	public void AddViewDocumentLink(Map<String, String> map, String testcaseName) {
		
		 if (testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
				log(" Add View Document Link not applicable for ROW", Status.SKIP);
			}
			else {
		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
			try {
 				 util.reloadPage();
	    		 util.dummyWait(5);
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
	 	 			log("STEP 2: User can click on the add document button", Status.PASS);
	 	 		 } catch (Exception e) {
	 	 			log("STEP 2: User cannot see the add document button", Status.FAIL);
	 	 			throw new RuntimeException("Failed in step 2");
	 	 		 }
			 
		}else {
  			 try {
  				ClickonAddViewLink();
	 			log("STEP 1: User can click on the Add/View Document Link  ;  if field does not exists in the instance  and skip the step      And", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1:User cannot see the Add/View Document Link", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
		
  			 try {
  				ClickOnAddDocument();
 	 			log("STEP 2: User can click on the add document button", Status.PASS);
 	 		 } catch (Exception e) {
 	 			log("STEP 2: User cannot see the add document button", Status.FAIL);
 	 			throw new RuntimeException("Failed in step 2");
 	 		 }
  			 
		
	    	 try {
	    		util.switchToIframe(iframeDocuments);
	    		 util.dummyWait(5);
	    		 uploadFile();
	 			log("STEP 3: User can upload document from the system ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3:  User cannot upload document from the system   ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
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
	    		 util.dummyWait(5);
	       		 util.click(drpCategory);
	       		 SelectCategory(map.get(Excel.Category));
	 			log("STEP 4: Value added diplays in Category field      ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4:  Added value does not display in Category field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	   		}
	    	 
	    	 try {
	    		 AddDescription(map.get(Excel.Description));
	 			log("STEP 5: User can enter a value in Description field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5:  User cannot add a value in Description field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
  			
	    	 try {
	    		 ClickOnLoadDocument();
	 			log("STEP 6: document is loaded", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6:  document could not be uploaded. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 if (util.isElementPresent(SuccessMessage)) {
	  			log("STEP 7:message-' Loaded- documentname'  displays ", Status.PASS);
	  		} else {
	  			log("STEP 7:message-' Loaded- documentname'   does not display", Status.FAIL);
	  			throw new RuntimeException("Faild in STEP 7:message-' Loaded- documentname'   does not display");
	  		}
	    	
	    	 util.dummyWait(1);
	    	
	    	
  		}
	}	  
}
