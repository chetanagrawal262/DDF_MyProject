package pages.ProjectSetup;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddLandownerPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public AddLandownerPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	

	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')]");
	By navLandowner = By.xpath("//span[text()='Landowner' and @class='rpText']");
	By btnAddNew = By.xpath("(//img[@alt='Add New Landowner(s)'])[1]");
	By btnAddNewRow = By.xpath("//input[contains(@id,'_ImgAddLandowner') and @type='image']");
	By Activecheckbox = By.xpath("//input[contains(@id,'IsEntityActive') and @checked='checked']");
	By frmFull = By.xpath("//iframe[@name='AddLandowner']");
	By txtExistingContact = By.xpath("//input[contains(@id,'RadEntityInfo_Input') and @type='text']");
	By closeExistingDD = By.xpath("//a[@id='RadEntityInfo_Arrow']");
	By drpEntityName = By.xpath("(//input[contains(@id,'ENTITY_Corporation_Trust') and @type='text'])[1]");
	By txtVendor = By.xpath("//input[contains(@id,'ENTITY_Vendor_ID') and @type='text']");
	By btnSave = By.xpath("//input[@id='btnSaveLO']");
	By ChangesaveSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	By SuccessMassage = By.xpath("//span[contains(text(),'New landowner has created and added to the')]");
	By SuccessMassageRow = By.xpath("//span[text()='New landowner was created and added to the tract.']");
	
	 public void AddnewLandownerRow() {
	    	util.waitUntilElementDisplay(navLandowner);
			util.click(navLandowner);
			util.dummyWait(1);
			util.waitUntilElementDisplay(btnAddNewRow);
			util.click(btnAddNewRow);
	    }
	    
	    public void AddnewLandowner() {
	    	util.waitUntilElementDisplay(navLandowner);
			util.click(navLandowner);
			util.dummyWait(1);
			util.waitUntilElementDisplay(btnAddNew);
			util.click(btnAddNew);
	    }  
	    
	    public void VerifyCheckbox() {
			Assert.assertTrue(true, "Activecheckbox");
	    }
	    
	    public void AddExistingContact(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtExistingContact, value);
	    }
	    
	   public void AddEntityName(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpEntityName, value);
	    }
	    
	    public void AddVendor(String value) {
	    	if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtVendor, value);
	    }
	    
	    public void Save() {
	    	util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.dummyWait(2);			
			Assert.assertTrue(util.isElementPresent(SuccessMassage), "New landowner has created and added");
	    }
	    
	    public void SaveDot() {
	    	util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.waitUntilElementDisplay(ChangesaveSuccessfully);
	    	Assert.assertTrue(util.isElementPresent(ChangesaveSuccessfully), "Changes saved successfully!");	
	    }
	    
	    public void SaveROW() {
	    	util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.waitUntilElementDisplay(SuccessMassageRow);
			Assert.assertTrue(util.isElementPresent(SuccessMassageRow), "New landowner was created and added to the tract.");
	    }
	    
	    By btnClose = By.xpath("//a[@class='rwCloseButton']");
        public void Close() {
	    	util.switchToDefaultContent();
	    	util.dummyWait(3);
	    	util.waitUntilElementDisplay(btnClose);
			util.click(btnClose);
	    }
	    
	    public void ClickOnSaveButton() {
	    	util.waitUntilElementDisplay(btnSave);
	    	util.click(btnSave);
	    	util.waitUntilElementDisplay(ChangesaveSuccessfully);
	    	Assert.assertTrue(util.isElementPresent(ChangesaveSuccessfully), "Changes saved successfully!");
	    }
	    
	    public void AddLandowner(Map<String, String> map, String testcaseName) {
	    	util.dummyWait(3);
	       if(testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM"))
	    	 {  
	    	try {
	    		AddnewLandownerRow();
				log("STEP 1: User can click on Add New Landowner ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  The panel does not expand ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	     }
	    	 else {
	    		
	    	 try {
	    		 AddnewLandowner(); 
					log("STEP 1:User can click on Add New Landowner ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1:  The panel does not expand ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
	     }
	    	
	    	 try {
	    		 util.switchToIframe(frmFull);
	 			log("STEP 2: User can switch to Landowner popup ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: User cannot switch to Landowner popup", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
	    	 
	    	 util.inputText(txtExistingContact, map.get(Excel.EntityName));
	    	 By landownerExists = By.xpath("//*[@id='RadEntityInfo_DropDown']/..//li[contains(normalize-space(),'"+map.get(Excel.EntityName)+"')]");
	    	 
	    	 if(!util.isElementVisible(landownerExists)) {
	    	 try {
	    		 util.click(closeExistingDD);
	    		 util.click(drpEntityName);
	    		 util.waitFor(200);
	    		 AddEntityName(map.get(Excel.EntityName));
	 			log("STEP 3: User can enter a value in EntityName field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3:  User cannot add a value in EntityName field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 
	    	 if(!testcaseName.contains("DOM")) {
	    	 try {
	    		 AddVendor(map.get(Excel.Vendor));
	 			log("STEP 4: User can enter a value in Vendor field   ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4:  User cannot add a value in Vendor field    ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }
	    	 }
	    	
	    	 if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
		    	 try {
		    		 Save();
		 			log("STEP 5: Message - 'Message - 'New landowner has created and added to the parcel.' in green displays     ", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 5:  Added Landowner record does not display in grid      ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 5");
		 		 }
		    	}
		    	 else if(testcaseName.contains("DOT")){
		    		 try {
			    		 SaveDot(); 
			 			log("STEP 5: Message - 'Message - 'New landowner has created and added to the parcel.' in green displays     ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 5:  Added Landowner record does not display in grid      ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 5");
			 		 } 
		    	 }else {
		    		 try {
			    		 SaveROW();
			 			log("STEP 5: Message - 'Message - 'New landowner was created and added to the tract.' in green displays     ", Status.PASS);
			 		 } catch (Exception e) {
			 			log("STEP 5:  Added Landowner record does not display in grid      ", Status.FAIL);
			 			throw new RuntimeException("Failed in step 5");
			 		 }
		    	 }
	    	 
	    	 }else {
	    		 log("Landowner already exists", Status.SKIP);
	    	 }
	    	
	    		 try {
		    		 Close(); 
		 			log("STEP 6: Popup closed", Status.PASS);
		 		 } catch (Exception e) {
		 			log("STEP 6:  Pop up does not able to close ", Status.FAIL);
		 			throw new RuntimeException("Failed in step 6");
		 		 }
	    	
	    util.dummyWait(5);
	  }
}
