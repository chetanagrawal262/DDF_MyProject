package pages.ParcelNotes;

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

public class AddDocumentThroughExternalLinkPage extends BasePage{


	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddDocumentThroughExternalLinkPage(WebDriver driver) {
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
	
	
	    
	    public void ExpandExternalLink() {
	    	util.waitUntilElementDisplay(ExpandExternalLink);
	    	util.click(ExpandExternalLink);
	    }
	    
	    public void AddDocumentNameAlt(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDocumentNameALT, value);
	    }
	    
	    By btnAdd = By.xpath("//input[contains(@id,'_btnAdd_input') and @type='submit']");
	    public void AddDocumentName(String value) {
	    	util.waitUntilElementDisplay(btnAdd);
	    	util.click(btnAdd);
	    	util.dummyWait(2);
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
	    
	    By selectCategory_ExternalLink = By.xpath("//input[contains(@id,'YALDropDownList_Input')]");

		public void selectCategoryExternalLink(String value) {
			util.waitUntilElementDisplay(selectCategory_ExternalLink);
			util.inputTextAndPressTab(selectCategory_ExternalLink, value);
		}

		By selectCategory_ExternalLinkDOT = By.xpath("//div[@id='radReportConfigPanels_i0_i0_XYZ1_RadDropDownTree1'] | //input[contains(@id,'XYZ1_radYALDropDownList_Input')]");

		public void selectCategoryExternalLinkDOT(String value) {
			if (!commonFunction.checkNA(value)) {
			util.waitUntilElementDisplay(selectCategory_ExternalLinkDOT);
			util.selectValueFromDropdown3(selectCategory_ExternalLinkDOT, value);}
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
	    
	    By Message = By.xpath("//span[text()='Documents loaded!']");
	    public void ClickOnLoadDocumentALT() {
	    	util.waitUntilElementDisplay(btnLoadDocumentALT);
	    	util.click(btnLoadDocumentALT);
	    	util.waitUntilElementDisplay(Message);
	    	Assert.assertTrue(util.isElementPresent(Message), "Documents loaded!");

	    }
	    
	    public void ClickOnLoadDocument() {
	    	util.waitUntilElementDisplay(btnLoadDocument);
	    	util.click(btnLoadDocument);
	    	util.waitUntilElementDisplay(Message);
	    	Assert.assertTrue(util.isElementPresent(Message), "Documents loaded!");
	    }
	    
	    public void AddDocumentExternalLink(Map<String, String> map, String testcaseName) {
	    
	    	 if (testcaseName.contains("DOT")) {
	      			log("Add Document External Link  not applicable for DOT ", Status.SKIP);
	      		}
	    	 else {
	    		 if(util.isElementVisible(pendingStatus)) {
	    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ATWELL") || testcaseName.contains("ORION")) {
		  		
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
				    	 util.dummyWait(3);
			    		 ExpandExternalLink();
			 			log("STEP 2: panel is expanded & fields are visible.", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 2: Panel is not expanded ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 2");
			 		 }

			    	 
			    	 try {
			    		 AddDocumentNameAlt(map.get(Excel.DocumentName));
			 			log("STEP 3: User can enter a value in Document Name field  ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 3: User cannot add a value in Document Name field ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 3");
			 		 }
			    	 
			    	 
			    	 try {
			    		 AddExternalLinkALT(map.get(Excel.ExternalLink));
			 			log("STEP 4: User can enter a value in External Link field   ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 4:  User cannot add a value in External Link field    ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 4");
			 		 }
			    	 
			    	 try {
			    		 AddCategoryALT(map.get(Excel.Category));
			 			log("STEP 5: Added value displays in Category field  ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 5: User  cannot select  value  from Category DD ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 5");
			 		 }
		  			
			    	 try {
			    		 AddDescriptionALT(map.get(Excel.Description));
			 			log("STEP 6:  User can enter a value in Category field  ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 6: User cannot add a value in Category field   ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 6");
			 		 }
			    	 
			    	 try {
			    		 ClickOnLoadDocumentALT();
			    		util.dummyWait(2);
				    	driver.close();
						driver.switchTo().window(mainWinID);
						util.dummyWait(2);
			 			log("STEP 7: Document link should be load  ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 7: Document not added ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 7");
			 		 }

		    }
	   
	    
	    else {
	  		
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
			    	 util.dummyWait(3);
			    	 if(!util.isElementVisible(btnAdd)) {
		    		 ExpandExternalLink();
			    	 }
		 			log("STEP 2: panel is expanded & fields are visible.", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 2: Panel is not expanded ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 2");
		 		 }

		    	 
		    	 try {
		    		 AddDocumentName(map.get(Excel.DocumentName));
		 			log("STEP 3: User can enter a value in Document Name field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 3: User cannot add a value in Document Name field ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 3");
		 		 }
		    	 
		    	 
		    	 try {
		    		 AddExternalLink(map.get(Excel.ExternalLink));
		 			log("STEP 4: User can enter a value in External Link field   ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 4:  User cannot add a value in External Link field    ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 4");
		 		 }
		    	 try {
		    		 if (util.isElementPresent(selectCategory_ExternalLink)) {
	 						selectCategoryExternalLink(map.get(Excel.Category));
	 					} else {
	 						selectCategoryExternalLinkDOT(map.get(Excel.Category));}
		  			 log("STEP 5: Added value displays in Category field ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 5:  No value displays in Category Dropdown  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 5");
		  		 }
		    	 
	  			
		    	 try {
		    		 AddDescription(map.get(Excel.Description));
		 			log("STEP 6:  User can enter a value in Description field  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 6: User cannot add a value in Description field   ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 6");
		 		 }
		    	 
		    	 try {
		    		 ClickOnLoadDocument();
		    		util.dummyWait(2);
			    	driver.close();
					driver.switchTo().window(mainWinID);
					util.dummyWait(2);
		 			log("STEP 7: Document link should be load  ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 7: Document not added ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 7");
		 		 }

	    }
	    		 }
	    		 else {
	    			 log("Notes are not in pending status", Status.SKIP);
	    		 }
	 }
  }    	
}
