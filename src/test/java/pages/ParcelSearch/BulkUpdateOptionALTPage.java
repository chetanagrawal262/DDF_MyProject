package pages.ParcelSearch;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class BulkUpdateOptionALTPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	String transferProjectName;
	public String TitleStatus, TitleOrderStatus;
	SoftAssert assertion =new SoftAssert();
	String DefaultStatus ="Select One";
 
	public BulkUpdateOptionALTPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By checkbox = By.xpath("//input[contains(@id,'RadGrid1_ctl00_ctl04_CheckBox1')]");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By ExpandBulkUpdateOption = By.xpath("(//a[@title='Expand'])[1]");
    By drpTitleStatus = By.xpath("//td[text()='Title Status']/.//input[@type='text']");
    By drpTitleOrderStatus = By.xpath("//td[text()='Title Order Status']/.//input[@type='text']");
    By drpAcquisitionStatus = By.xpath("//td[text()='Acquisition Status']/.//input[@type='text']");
    By drpTitlePriority = By.xpath("//td[text()='Title Priority']/.//input[@type='text']");
    By drpAcquisitionPriority = By.xpath("//td[text()='Acquisition Type']/.//input[@type='text'] |//td[contains(text(),'Acquisition Priority')]/.//input[@type='text']");
 
  
    By InactiveRadio = By.xpath("(//td[text()='Offline']/.//input[@type='radio'])[2] | (//td[text()='Inactive']/.//input[@type='radio'])[2] | (//td[text()='Orion Interest']/.//input[@type='radio'])[2]");
    By drpTransferToProject = By.xpath("//td[text()='Transfer to Project']/.//input[@type='text']");
    By btnUpdate = By.xpath("//input[contains(@id,'idSearch_RadDock1_C_BLK_btnBulkUpdate')]");
    By SuccessMesssage = By.xpath("//span[@id='ctl00_ConPHRightTop_idSearch_RadDock1_C_BLK_usrMessage']");
    By refreshButton = By.xpath("//input[contains(@id,'_RefreshButton') and @type='submit']");
    
    public void ExpandBulkUpdateOption() {
    	util.waitUntilElementDisplay(ExpandBulkUpdateOption);
    	util.click(ExpandBulkUpdateOption);
    }
    
    public void ClickOnCheckbox() {
    	util.waitUntilElementDisplay(checkbox);
    	util.click(checkbox);
    }
    
    public void RightClickOnDocumentGrid() {
    	WebElement web = driver.findElement(documentgrid);
    	util.waitUntilElementDisplay(documentgrid);
    	Actions act = new Actions(driver);
    	act.moveToElement(web).contextClick().build().perform();
    }

    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
    By btnClose = By.xpath("//a[@title='Close']");
    public void ClickOnOpeninPopupButton() {
    	util.dummyWait(1);
    	util.click(btnOpenInPopup);
    	util.dummyWait(1);
    	util.click(btnClose);
    }
    
    public void SelectTitleStatus(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpTitleStatus, value);
    }
    
    public void SelectAcquisitionStatus(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpAcquisitionStatus, value);
    }
    
    public void SelectAcquisitionPriority(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpAcquisitionPriority, value);
    }
    
    public void ClickOnInactiveRadio() {
    	util.waitUntilElementDisplay(InactiveRadio);
    	util.click(InactiveRadio);
    }
    
    public void SelectTransferToProject(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpTransferToProject, value);
    }
    By transferredProject = By.xpath("(//*[contains(@id,'_radYALDropDownList_DropDown')]/.//li)[1]");
     
    public void SelectTransferToProject() {
    	util.click(drpTransferToProject);
    	//transferProjectName=  driver.findElement(transferredProject).getText();
    	util.click(transferredProject);
    }
    
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    }
    
    By getStrProjectName = By.xpath("(//table/tbody/tr/td[count(//table/thead/tr/th[.='Project Name']/preceding-sibling::th)+1])[1]");
    
   
	public String getTitileStatus() {
		return util.getAttributeValue(drpTitleStatus, "value");
	}
    
  public void ValidateTitleStatusDefaultValue() {
	 // TitleStatus=driver.findElement(drpTitleStatus).getText();
	   assertion.assertEquals(getTitileStatus(), DefaultStatus, "Default value for Title Status dd is not 'Select One'");
		ExtentTestManager.log("Default value of Title Status DD is : " + getTitileStatus());
	}
  
	public String getTitleOrderStatus() {
		return util.getAttributeValue(drpTitleOrderStatus, "value");
	}
  
  public void ValidateTitleOrderStatusDefaultValue() {
	
	   assertion.assertEquals(getTitleOrderStatus(), DefaultStatus, "Default value for Title Order Status dd is not 'Select One'");
		ExtentTestManager.log("Default value of Title Order Status DD is : " + getTitleOrderStatus());
	}
  
  public String getTitlePriority() {
		return util.getAttributeValue(drpTitlePriority, "value");
	}

 public void ValidateTitlePriorityDefaultValue() {
	
	   assertion.assertEquals(getTitlePriority(), DefaultStatus, "Default value for Title Priority dd is not 'Select One'");
		ExtentTestManager.log("Default value of Title Priority DD is : " + getTitlePriority());
	}
 public String getAcquisitionStatus() {
		return util.getAttributeValue(drpAcquisitionStatus, "value");
	}

public void ValidateAcquisitionStatusDefaultValue() {
	
	   assertion.assertEquals(getAcquisitionStatus(), DefaultStatus, "Default value for Acquisition Status dd is not 'Select One'");
		ExtentTestManager.log("Default value of Acquisition Status DD is : " + getTitlePriority());
	}
  
  
public String getAcquisitionPriority() {
	return util.getAttributeValue(drpAcquisitionPriority, "value");
}

public void ValidateAcquisitionPriorityDefaultValue() {

   assertion.assertEquals(getAcquisitionPriority(), DefaultStatus, "Default value for Acquisition Priority dd is not 'Select One'");
	ExtentTestManager.log("Default value of Acquisition Priority DD is : " + getAcquisitionPriority());
}
  
    public void BulkUpdateOption(Map<String, String> map, String testcaseName) {
    	 if (testcaseName.contains("DOT") || testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")) {
				log(" Bulk Update Option ALT not applicable for DOT and ROW", Status.SKIP);
			}
			else {
		 
		try {
			ClickOnCheckbox();
			log("STEP 1: user can check checkbox which is present before project name ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: user cannot check checkbox  before project name", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		
		try {
			ExpandBulkUpdateOption();
			log("STEP 2:  User can expand bulk update option panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:   User cannot expand bulk update option panel   ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		if(!environment.contains("STEELHEAD")) {
		ValidateTitleStatusDefaultValue();
		}
		ValidateTitleOrderStatusDefaultValue();
		ValidateTitlePriorityDefaultValue();
		if(util.isElementVisible(drpAcquisitionStatus)) {
		ValidateAcquisitionStatusDefaultValue();
		}
		if(util.isElementVisible(drpAcquisitionPriority)) {
		ValidateAcquisitionPriorityDefaultValue();
		}
		
	  if(!environment.contains("STEELHEAD")) {
		try {
			SelectTitleStatus(map.get(Excel.TitleStatus));
			log("STEP 4:   User can select value from Title Status dd ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:   User canbot select value from Title Status dd  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		}
		
	  if(util.isElementVisible(drpAcquisitionStatus)) {
		try {
			SelectAcquisitionStatus(map.get(Excel.AcquisitionStatus));
			log("STEP 5:  user can able to select value from Acquisition Status dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  user not able to select value from Acquisition Status dd", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
	  }
		
		if(util.isElementVisible(drpAcquisitionPriority)) {
		try {
			SelectAcquisitionPriority(map.get(Excel.AcquisitionPriority));
			log("STEP 5:  user can able to select value from Acquisition Priority dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  user not able to select value from Acquisition Priority dd", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		}
		
		try {
			ClickOnInactiveRadio();
			log("STEP 6:  User can select yes/no from radio button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:   User cannot select yes/no from radio button.", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			SelectTransferToProject();
			//log("Transferred Project Name:" + transferProjectName);	
			log("STEP 7:  user can able to select value from Transfer To Project dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  user not able to select value from Transfer To Project dd", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		
		try {
			ClickOnUpdateButton();
			util.dummyWait(1);
			log("STEP 8:  user can click on update button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  user cannot click on update button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		if (util.isElementPresent(SuccessMesssage)) {
		   log("STEP 9 :X  Records has been updated message will be display in black color.  ", Status.PASS);
		} else {
		   log("STEP 9: user cannot click on update button.  ", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 9 ");
	   	} 
		util.dummyWait(1);
		util.click(refreshButton);
		util.dummyWait(1);
		String ProjectName = util.getText(getStrProjectName);
		
		log("Project Name on grid  :" + ProjectName);
//		log("Transferred Project Name:" + transferProjectName);	
//			if (transferProjectName.trim().equals(ProjectName.trim())) {
//				log("STEP 10: Project Name  Matched !!!", Status.PASS);
//			} else {
//				System.out.println("Project Name  Not Matched !!!");
//				log("STEP 10: Project Name  Not Matched !!!", Status.FAIL);
//		}
		
		if(!environment.contains("STEELHEAD")) {
		ValidateTitleStatusDefaultValue();
		}
		ValidateTitleOrderStatusDefaultValue();
		ValidateTitlePriorityDefaultValue();
		if(util.isElementVisible(drpAcquisitionStatus)) {
		ValidateAcquisitionStatusDefaultValue();
		}
		if(util.isElementVisible(drpAcquisitionPriority)) {
		ValidateAcquisitionPriorityDefaultValue();
		}
		
    }
    	 
    	 
    	 
    	 
    	 
    
    }
}
