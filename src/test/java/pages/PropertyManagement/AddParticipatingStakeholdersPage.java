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

public class AddParticipatingStakeholdersPage extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;
	

	public AddParticipatingStakeholdersPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}	
	
	    By Project = By.xpath("(//span[contains(@class,'rddtEmptyMessage')])[1]");
	    By txtProject = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
	    By btnGo = By.xpath("//input[contains(@id,'imgbtnBindTracts')]");
	    By ListOfProperty = By.xpath("//a[contains(@id,'DDTracts_Arrow')]");
	    By closeListOfProperty = By.xpath("//a[contains(@id,'_DDTracts_Arrow')]");
	    By btnAdd = By.xpath("//input[contains(@id,'_imgbtnAddTracts')]");
	    
	   //delete
	    By DeleteParticipatingStakeholder = By.xpath("(//input[contains(@id,'radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')])[1]");
	    By iframDelete = By.xpath("//td[@class='rwWindowContent']");
		By btnCancle = By.xpath("//span[text()='Cancel']");
		By btnOk = By.xpath("//span[text()='OK']");
		By btnDelete = By.xpath("(//input[contains(@id,'radYALGridControl_ctl00_ctl04_gbcDeleteAlignment')])[1]");
		By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
		By CollapsePanel = By.xpath("//span[text()='Participating Stakeholders']");
	
		public void SelectProject(String value) {
    	 util.click(Project);
	    	if (!commonFunction.checkNA(value))
				util.inputText(txtProject, value);
	    	util.dummyWait(1);
	    	util.pressDownkey();
	    	util.pressDownkey();
	    	util.pressENTERkey();
    }
	
	
	
//	public void SelectListOfProperty(String value) {
//		if (!commonFunction.checkNA(value)) {
//			util.click(ListOfProperty);
//			By selectProperty = By.xpath("//input[contains(@value,'"+value+"')]");
//			util.click(selectProperty);
//			util.click(closeListOfProperty);
//		}
//	}
	
	
	public void SelectListOfProperty(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdownCheckboxContains(ListOfProperty, value);
			util.waitFor(1000);
			util.click(ListOfProperty);	
		}
	}
	
	
	
	
	public void clickOnGo() {
		util.waitForWebElementToBePresent(btnGo);
		util.click(btnGo);
	}
	public void clickOnAdd() {
		util.waitForWebElementToBePresent(btnAdd);
		util.click(btnAdd);
	}
	
	//delete
	public void ClickonDelete() {
  		util.waitUntilElementDisplay(DeleteParticipatingStakeholder);
  		util.click(DeleteParticipatingStakeholder);
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
	
	
	public void AddParticipatingStakeholders(Map<String, String> map,String TestcaseName) throws InterruptedException {
		try {
			util.dummyWait(1);
			SelectProject(map.get(Excel.Projects));
			log("STEP 1:  User can able to select the project from dropdown", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot select the project from dropdown  ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			clickOnGo();
			util.dummyWait(2);
			log("STEP 2:  User can able to click on Go button", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot click on Go button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			SelectListOfProperty(map.get(Excel.ListOfProperty));
			log("STEP 3:  User can able to select parcel from dropdown", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot select parcel from dropdown", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			clickOnAdd();
			log("STEP 4:  User can able to click on Add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot click on Add button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		util.dummyWait(2);
		if (util.isElementPresent(By.xpath("//span[contains(@id,'usrTractMessage')]"))) {
			log("STEP 5: Parcel is added successfully", Status.PASS);
		} else {
			log("STEP 5: Parcel is not added sucessfully ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
	}
	
	public void DeleteParticipatingStakeholders() throws InterruptedException {
		 try {
			 ClickonDelete();
				log("STEP 1:  user can click on delete icon   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  Popup Delete does not open", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
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
		  util.click(CollapsePanel);
	
	}
	
}
