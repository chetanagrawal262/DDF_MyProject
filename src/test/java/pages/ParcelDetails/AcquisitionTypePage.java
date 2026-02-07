package pages.ParcelDetails;

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

public class AcquisitionTypePage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;

	public AcquisitionTypePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By panelAcquisitionType = By.xpath("//span[contains(@class,'rpExpandHandle')]/..//span[contains(text(),'Acquisition Type')]");
	By btnAddNewRecord = By.xpath("//a[contains(@id,'_YALTRACTSACQUISITIONTYPESURVEYGRID_radYALGridControl_ctl00_ctl02_ctl00_lnkAddNewRecord')]");
    By drpAcquisitionType = By.xpath("//input[contains(@id,'_EditFormControl_Acquisition_Type_ID_radYALDropDownList_Input') and @type='text']");
    By drpAcquisitionStatus = By.xpath("//input[contains(@id,'_EditFormControl_AcquisitionTypeGridStatusID_radYALDropDownList_Input') and @type='text']"); 
    By txtAddedBy = By.xpath("//input[contains(@id,'_EditFormControl_AddedBy_radYALDropDownList_Input') and @type='text']");
    By txtDateAdded = By.xpath("//input[contains(@id,'_EditFormControl_DateAdded_dateInput') and @type='text']");
    By checkBoxOkToClearTrees = By.xpath("//input[contains(@id,'_EditFormControl_IsClearTrees') and @type='checkbox']");
    By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert') and @type='submit']");
    By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    
    By btnEdit = By.xpath("//input[contains(@id,'_YALTRACTSACQUISITIONTYPESURVEYGRID_radYALGridControl_ctl00_ctl04_EditButton')]");
    By linkViewHistory = By.xpath("//a[contains(text(),'View History')]");
    By iframeHistory = By.xpath("//iframe[@name='HistoryDialog']");
    By btnClose = By.xpath("//a[@title='Close']");
    
    public void expandAcquisitionTypePanel() {
  		util.waitUntilElementDisplay(panelAcquisitionType);
  		util.click(panelAcquisitionType);
    }
    public void clickOnAddNewRecord() {
    	util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.waitUntilLoaderDisappear();
    }
    
    public void selectAcquisitionType(String value) {
    	util.inputTextAndPressTab(drpAcquisitionType, value);
    }
    
    public void selectAcquisitionStatus(String value) {
    	util.inputTextAndPressTab(drpAcquisitionStatus, value);
    }
    
    public void selectOkToClearTreesCheckbox() {
    	util.click(checkBoxOkToClearTrees);
    }
    
    public void clickOnInsert() {
    	util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilLoaderDisappear();
    }
    
    public void clickOnEdit() {
    	util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.waitUntilLoaderDisappear();
    }
    
    public void clickOnUpdate() {
    	util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.waitUntilLoaderDisappear();
    }
    
    public void clickOnViewHistory() {
    	util.waitUntilElementDisplay(linkViewHistory);
		util.click(linkViewHistory);
		util.dummyWait(1);
		util.switchToIframe(iframeHistory);
    }
    
    public void AddAcquisitionTypeRecord(Map<String, String> map, String testcaseName) {
    	
    	 try {
    		expandAcquisitionTypePanel();
    		clickOnAddNewRecord();
			log("STEP 1: User can expand Acquisition Type panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand Acquisition Type panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    
    	 try {
    		 selectAcquisitionType(map.get(Excel.AcquisitionType));
 			log("STEP 2: User can select Acquisition Type ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 2:  User cannot select Acquisition Type ", Status.FAIL);
 			throw new RuntimeException("Failed in step 2");
 		 }
    	 
    	 try {
    		 selectAcquisitionStatus(map.get(Excel.AcquisitionStatus));
 			log("STEP 3: User can select Acquisition Status ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 3:  User cannot select Acquisition Status ", Status.FAIL);
 			throw new RuntimeException("Failed in step 3");
 		 }
    	 
    	 try {
    		 By addedBy = By.xpath("//input[contains(@id,'_EditFormControl_AddedBy_radYALDropDownList_Input') and @type='text' and @value='"+map.get("AddedBy")+"']");
    		 util.isElementVisible(addedBy);
 			log("STEP 4: Added By Value by default selected", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 4: Added By Value not selected By Default", Status.FAIL);
 		 }
    	 
    	 try {
    		 String currentDate = util.getCurrentDateTime("M/d/yyyy");
    		 By dateAdded = By.xpath("//input[contains(@id,'_EditFormControl_DateAdded_dateInput') and @type='text' and @value='"+currentDate+"']");
    		 util.isElementVisible(dateAdded);
 			log("STEP 5: Date Added value is displaying by default", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 5: Date Added value is not displaying by default", Status.FAIL);
 		 }
    	 
    	 try {
    		clickOnInsert();
 			log("STEP 6: User can click on Insert Button ", Status.PASS);
 		 } catch (Exception e) {
 			log("STEP 6:  User cannot click on Insert Button", Status.FAIL);
 			throw new RuntimeException("Failed in step 6");
 		 }
    	 
    	 try {
     		Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
  			log("STEP 7: User can see success message ", Status.PASS);
  		 } catch (AssertionError e) {
  			log("STEP 7:  User cannot see success message", Status.FAIL);
  		 }
    	 
    	 try {
    		 By acquisitionTypeValue = By.xpath("//tr[contains(@id,'_YALTRACTSACQUISITIONTYPESURVEYGRID_radYALGridControl_')]/..//td[text()='"+map.get(Excel.AcquisitionType)+"']");
    		 util.isElementVisible(acquisitionTypeValue);
 			log("STEP 8: User can see Acquisition Type Value in grid view", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 8: User cannot see Acquisition Type Value in grid view", Status.FAIL);
 		 }
    	 
    	 try {
    		 By acquisitionStatusValue = By.xpath("//tr[contains(@id,'_YALTRACTSACQUISITIONTYPESURVEYGRID_radYALGridControl_')]/..//td[text()='"+map.get(Excel.AcquisitionStatus)+"']");
    		 util.isElementVisible(acquisitionStatusValue);
 			log("STEP 9: User can see Acquisition Status Value in grid view", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 9: User cannot see Acquisition Status Value in grid view", Status.FAIL);
 		 }
    	 
    	 try {
    		 By addedBy = By.xpath("//tr[contains(@id,'_YALTRACTSACQUISITIONTYPESURVEYGRID_radYALGridControl_')]/..//td[text()='"+map.get("AddedBy")+"']");
    		 util.isElementVisible(addedBy);
 			log("STEP 10: User can see Added By Value in grid view", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 10: User cannot see Added By Value in grid view", Status.FAIL);
 		 }
    	 
    	 try {
    		 String currentDate = util.getCurrentDateTime("M-d-yyyy");
    		 By dateAdded = By.xpath("//tr[contains(@id,'_YALTRACTSACQUISITIONTYPESURVEYGRID_radYALGridControl_')]/..//td[text()='"+currentDate+"']");
    		 util.isElementVisible(dateAdded);
 			log("STEP 11: User can see Date Added Value in grid view", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 11: User cannot see Date Added Value in grid view", Status.FAIL);
 		 }
    	 
    	 try {
    		 By okToClearTrees = By.xpath("//tr[contains(@id,'_YALTRACTSACQUISITIONTYPESURVEYGRID_radYALGridControl_')]/..//td[text()='No']");
    		 util.isElementVisible(okToClearTrees);
 			log("STEP 12: User can see Ok To Clear Trees value 'No' in grid view", Status.PASS);
 		 } catch (AssertionError e) {
 			log("STEP 12: User cannot see Ok To Clear Trees value 'No' in grid view", Status.FAIL);
 		 }
    	 
    }
   
    
    public void editAcquisitionTypeRecord(Map<String, String> map, String testcaseName) {
    	
    	try {
			clickOnEdit();
			log("STEP 1: User can click on Edit Icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on Edit Icon", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    	
		try {
			selectOkToClearTreesCheckbox();
			log("STEP 2: User can select Ok To Clear Trees Checkbox", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Ok To Clear Trees Checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			clickOnUpdate();
			log("STEP 3: User can click on Update Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on Update Button", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
     		Assert.assertTrue(util.isElementVisible(changesSavedSuccessfully));
  			log("STEP 4: User can see success message ", Status.PASS);
  		 } catch (AssertionError e) {
  			log("STEP 4:  User cannot see success message", Status.FAIL);
  		 }
		
		try {
   		 By okToClearTrees = By.xpath("//tr[contains(@id,'_YALTRACTSACQUISITIONTYPESURVEYGRID_radYALGridControl_')]/..//td[text()='Yes']");
   		 util.isElementVisible(okToClearTrees);
			log("STEP 5: User can see Ok To Clear Trees value 'Yes' in grid view", Status.PASS);
		 } catch (AssertionError e) {
			log("STEP 5: User cannot see Ok To Clear Trees value 'Yes' in grid view", Status.FAIL);
		 }
    }
    
	public void viewHistory(Map<String, String> map, String testcaseName) {

		try {
			clickOnViewHistory();
			log("STEP 1: User can click on View History Link", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot click on View History Link", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			By titleAcquisitionType = By.xpath("//*[@id='form1']/..//strong[text()='AcquisitionType']");
			util.isElementVisible(titleAcquisitionType);
			log("STEP 2: User can see Acquisition Type Column Name on View History PopUp", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 2: User cannot see Acquisition Type Column Name on View History PopUp", Status.FAIL);
		}

		try {
			By titleAcquisitionStatus = By.xpath("//*[@id='form1']/..//strong[text()='AcquisitionStatus']");
			util.isElementVisible(titleAcquisitionStatus);
			log("STEP 3: User can see Acquisition Status Column Name on View History PopUp", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 3: User cannot see Acquisition Status Column Name on View History PopUp", Status.FAIL);
		}

		try {
			By titleUpdatedBy = By.xpath("//*[@id='form1']/..//strong[text()='UpdatedBy']");
			util.isElementVisible(titleUpdatedBy);
			log("STEP 4: User can see Updated By Column Name on View History PopUp", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 4: User cannot see Updated By Column Name on View History PopUp", Status.FAIL);
		}

		try {
			By titleDateUpdated = By.xpath("//*[@id='form1']/..//strong[text()='Date Updated']");
			util.isElementVisible(titleDateUpdated);
			log("STEP 5: User can see Date Updated Column Name on View History PopUp", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 5: User cannot see Date Updated Column Name on View History PopUp", Status.FAIL);
		}
		
		try {
			By titleClearTrees = By.xpath("//*[@id='form1']/..//strong[text()='ClearTrees']");
			util.isElementVisible(titleClearTrees);
			log("STEP 6: User can see Clear Trees Column Name on View History PopUp", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 6: User cannot see Clear Trees Column Name on View History PopUp", Status.FAIL);
		}
		
		try {
			By acquisitionType = By.xpath("(//*[@id='form1']/..//td[text()='"+map.get(Excel.AcquisitionType)+"'])[1]");
			util.isElementVisible(acquisitionType);
			log("STEP 7: User can see Acquisition Type value on View History PopUp", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7: User cannot see Acquisition Type value on View History PopUp", Status.FAIL);
		}
		
		try {
			By acquisitionStatus = By.xpath("(//*[@id='form1']/..//td[text()='"+map.get(Excel.AcquisitionStatus)+"'])[1]");
			util.isElementVisible(acquisitionStatus);
			log("STEP 8: User can see Acquisition Status value on View History PopUp", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 8: User cannot see Acquisition Status value on View History PopUp", Status.FAIL);
		}
		
		try {
			By clearTrees = By.xpath("//*[@id='form1']/..//td[text()='No']");
			util.isElementVisible(clearTrees);
			log("STEP 9: User can see Clear Trees Initial value 'No' on View History PopUp", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9: User cannot see Clear Trees Initial value 'No' on View History PopUp", Status.FAIL);
		}
		
		try {
			By clearTrees = By.xpath("//*[@id='form1']/..//td[text()='Yes']");
			util.isElementVisible(clearTrees);
			log("STEP 10: User can see Clear Trees updated value 'Yes' on View History PopUp", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 10: User cannot see Clear Trees updated value 'Yes' on View History PopUp", Status.FAIL);
		}
		
		ExtentTestManager.infoWithScreenshot("Acquisition Type - View History PopUp");
		
		try {
			util.switchToDefaultContent();
			util.click(btnClose);
			util.dummyWait(1);
			log("STEP 11: User can close the popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot close the popup", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
	}
    
}
