package pages.ParcelDetails;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ParcelStructurePage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public ParcelStructurePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By panelParcelStructure = By.xpath("//span[contains(@class,'rpExpandHandle')]/..//span[contains(text(),'Parcel Structures')]");
	By btnAddNewRecord = By.xpath("//a[contains(@id,'_STRUCTURES_radYALGridControl_ctl00_ctl02_ctl00_lnkAddNewRecord')]");
    By drpStructureNumber = By.xpath("//input[contains(@id,'_EditFormControl_structure_number_Input') and @type='text']");
    By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert') and @type='submit']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    By btnDelete = By.xpath("//input[contains(@id,'_STRUCTURES_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");
	By iframDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnOk = By.xpath("//span[text()='OK']");
    
    public void expandParcelStructurePanel() {
  		util.waitUntilElementDisplay(panelParcelStructure);
  		util.click(panelParcelStructure);
    }
    public void clickOnAddNewRecord() {
    	util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.waitUntilLoaderDisappear();
    }
    
    public void selectStructureNumber(String value) {
    	util.inputTextAndPressTab(drpStructureNumber, value);
    }
    
    public void clickOnInsert() {
    	util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilLoaderDisappear();
    }
    
     public void AddParcelStructureRecord(Map<String, String> map, String testcaseName) {
    	
    	 try {
    		expandParcelStructurePanel();
    		clickOnAddNewRecord();
			log("STEP 1: User can expand Parcel Structure panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand Parcel Structure panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    
    	 try {
    		 selectStructureNumber(map.get("StructureNumber"));
 			log("STEP 2: User can select Structure Number ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 2:  User cannot select Structure Number ", Status.FAIL);
 			throw new RuntimeException("Failed in step 2");
 		 }
    	 
    	 try {
    		clickOnInsert();
 			log("STEP 3: User can click on Insert Button ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 3:  User cannot click on Insert Button", Status.FAIL);
 			throw new RuntimeException("Failed in step 3");
 		 }
    	 
    	 try {
     		Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
  			log("STEP 4: User can see success message ", Status.PASS);
  		 } catch (AssertionError e) {
  			log("STEP 4:  User cannot see success message", Status.FAIL);
  		 }
    	 
    	 try {
    		 String structureNumber = map.get("StructureNumber").split("-")[1].trim();
    		 By structureNumberValue = By.xpath("//tr[contains(@id,'_STRUCTURES_radYALGridControl')]/..//td[text()='"+structureNumber+"']");
    		 util.isElementVisible(structureNumberValue);
 			log("STEP 5: User can see Structure Number Value in grid view", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 5: User cannot see Structure Number Value in grid view", Status.FAIL);
 		 }
    	 
    	 try {
    		 By structureType = By.xpath("//tr[contains(@id,'_STRUCTURES_radYALGridControl')]/..//td[text()='"+map.get("StructureType")+"']");
    		 util.isElementVisible(structureType);
 			log("STEP 6: User can see Structure Type Value in grid view", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 6: User cannot see Structure Type Value in grid view", Status.FAIL);
 		 }
    	 
    	 try {
    		 By structureMaterial = By.xpath("//tr[contains(@id,'_STRUCTURES_radYALGridControl')]/..//td[text()='"+map.get("StructureMaterial")+"']");
    		 util.isElementVisible(structureMaterial);
 			log("STEP 7: User can see Structure Material Value in grid view", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 7: User cannot see Structure Material Value in grid view", Status.FAIL);
 		 }
    	 
    	 try {
    		 By xCoordinates = By.xpath("//tr[contains(@id,'_STRUCTURES_radYALGridControl')]/..//td[text()='"+map.get("XCoordinates")+"']");
    		 util.isElementVisible(xCoordinates);
 			log("STEP 8: User can see X Coordinates Value in grid view", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 8: User cannot see X Coordinates Value in grid view", Status.FAIL);
 		 }
    	 
    	 try {
    		 By yCoordinates = By.xpath("//tr[contains(@id,'_STRUCTURES_radYALGridControl')]/..//td[text()='"+map.get("YCoordinates")+"']");
    		 util.isElementVisible(yCoordinates);
 			log("STEP 9: User can see Y Coordinates Value in grid view", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 9: User cannot see Y Coordinates Value in grid view", Status.FAIL);
 		 }
    	 
    }
     
     
     public void ClickonDelete() {
 		util.dummyWait(1);
 		util.waitUntilElementDisplay(btnDelete);
 		util.click(btnDelete);
 	}

 	public void ClickonOk() {
 		util.waitUntilElementDisplay(btnOk);
 		util.click(btnOk);
 		util.waitUntilLoaderDisappear();
 	}
   
     public void deleteParcelStructureRecord(String TestcaseName) {
 		try {
 			ClickonDelete();
 			log("STEP 1: User can click on 'x' icon to delete the record ", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 1: User can click on 'x' icon to delete the record ", Status.FAIL);
 			throw new RuntimeException("Failed in step 1 ");
 		}

 		try {
 			ClickonOk();
 			log("STEP 2: User can click on the ok button", Status.PASS);
 		} catch (Exception e) {
 			log("STEP 2: User can click on the ok button", Status.FAIL);
 			throw new RuntimeException("Failed in step 2 ");
 		}
 		
 		try {
 			Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
 			log("STEP 3: User can see success message 'Changes saved successfully!'", Status.PASS);
 		} catch (AssertionError e) {
 			log("STEP 3: User cannot see success message 'Changes saved successfully!'", Status.FAIL);
 		}
 	}
   
    
}
