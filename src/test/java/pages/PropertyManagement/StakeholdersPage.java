package pages.PropertyManagement;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class StakeholdersPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	

	public StakeholdersPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}	
	
	By drpstakeholders = By.xpath("//input[contains(@id,'MSLESSOR_YALComboBox_Input')]");
	By BtnSave = By.xpath("//input[contains(@id,'_btnSaveNPStakeholders')]");
	By DrpFirstValue = By.xpath("(//*[contains(@id,'_MSLESSOR_YALComboBox_DropDown')]/..//li)[1]");
	By txtLastName = By.xpath("(//input[contains(@id,'_EditFormControl_ENTITY_Last_Name')])[1]");
	By txtfirstName = By.xpath("(//input[contains(@id,'ditFormControl_ENTITY_First_Name')])[1]");
    By txtmiddleName = By.xpath("//input[contains(@id,'_EditFormControl_ENTITY_Middle_Name')])[1]");
	By editIcon = By.xpath("ctl00_ConPHRightTop_LSINFO_radPanels_i4_i0_grdNPContacts_radYALGridControl_ctl00_ctl04_EditButton");
	By deleteStakeholders = By.xpath("//input[contains(@id,'_i4_i0_grdNPContacts_radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')]");	
	
	By btnCancle = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By btnDelete = By.xpath("(//input[contains(@id,'radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')])[1]");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	
	
	public void selectStakeholders(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdownCheckboxContains(drpstakeholders, value);
			util.waitFor(1000);
			util.click(drpstakeholders);	
		}
	}
	
//	public void EditStakeholder() {
//    	util.waitUntilElementDisplay(drpstakeholders);
//    	util.click(drpstakeholders);
//    	util.waitFor(200);
//    	util.click(DrpFirstValue);
//    }
	
	
	public void EditStakeholders() {
	util.waitUntilElementDisplay(editIcon);	
	util.click(editIcon);
	}
	
	public void ClickOnSave() {
		util.waitUntilElementDisplay(BtnSave);
		util.click(BtnSave);
	}
	
	public void ClickOnDelete() {
		util.waitUntilElementDisplay(deleteStakeholders);
		util.click(deleteStakeholders);
	}
	
	
	public void ClickonCancle()  {
		 util.waitUntilElementDisplay(btnCancle);
	  		util.click(btnCancle);
	    }
	 
	 
	 public void ClickonOk()  {
		    util.waitUntilElementDisplay(btnDelete);
	  		util.click(btnDelete);	
	  		 util.waitUntilElementDisplay(btnOk);
		  		util.click(btnOk);	
	  		util.waitUntilElementDisplay(changesSavedSuccessfully);
			Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
			util.dummyWait(2);
	  		
	    }
	
	public void AddStakeholders(Map<String, String> map,String TestcaseName) throws InterruptedException {
		try {
			selectStakeholders(map.get(Excel.Stakeholders));
			log("STEP 1:  User can able to select the project from dropdown", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot select the project from dropdown  ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			ClickOnSave();
			log("STEP 2:  User can able to click on save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot click on save ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
	}
    public void DeleteStakeholdersInfo() {
	  
    	try {
    		ClickOnDelete();
			log("STEP 1:  User can able to click on delete on the grid", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:   User cannot click on delete on the grid", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
  
    	 try {
			 ClickonCancle();
				log("STEP 2: User can click on cancel button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on cancel button", Status.FAIL);
				throw new RuntimeException("Failed in step 2 ");
			}
		 
		 try {
			 ClickonOk();
				log("STEP 3: Deleted record does not display in the grid and Message- Changes saved suessfully! in green colour displays. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: Message- Changes saved sucessfully' does not display", Status.FAIL);
				throw new RuntimeException("Failed in step 3 ");
			}
    	
    	
    	
    	
		
		
	}
}
