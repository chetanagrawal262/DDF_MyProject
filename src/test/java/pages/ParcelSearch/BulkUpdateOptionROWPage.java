package pages.ParcelSearch;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class BulkUpdateOptionROWPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	String transferProjectName="";

	public BulkUpdateOptionROWPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By checkbox = By.xpath("//input[contains(@id,'RadGrid1_ctl00_ctl04_CheckBox1')]");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By ExpandBulkUpdateOption = By.xpath("(//a[@title='Expand'])[1]");
    By drpParcelType = By.xpath("(//*[text()='Tract Type']/..//input)[1] | (//*[text()='Parcel Type']/..//input)[1] | (//*[text()='Record Type']/..//input)[1]");
    By drpParcelState = By.xpath("(//*[text()='Tract State']/..//input)[1] | (//*[text()='Parcel State']/..//input)[1] | (//*[text()='Record State']/..//input)[1] | //*[text()='Parcel # State']/..//input[@type='text']");
	By drpAcquisitionType = By.xpath("//*[contains(@id,'BLK_tblBulkOptions')]/..//*[text()='Acquisition Type']/..//input[@type='text']");
	By OfflineRadio = By.xpath("//*[text()='Offline']/..//*[text()='No']/..//input[@type='radio']");
	By AbuttingParcelRadio = By.xpath("(//*[text()='Abutting Tract']/..//input)[1] | (//*[text()='Abutting Parcel']/..//input)[1] |  (//*[text()='Abutting Record']/..//input)[1]");
	By drpSurveyStatus = By.xpath("//*[contains(@id,'BLK_tblBulkOptions')]/..//*[text()='Survey Status']/..//input[@type='text']");
	By txtTitleReasearchPeriod = By.xpath("//*[contains(@id,'BLK_tblBulkOptions')]/..//*[text()='Title Research Period']/..//input[@type='text']");
	By drpTitleStatus = By.xpath("//*[contains(@id,'BLK_tblBulkOptions')]/..//*[text()='Title Status']/..//input[@type='text']");
	By drpAcquisitionStatus = By.xpath("//*[contains(@id,'BLK_tblBulkOptions')]/..//*[text()='Acquisition Status']/..//input[@type='text']");
	By drpTransferToProject = By.xpath("//*[contains(@id,'BLK_tblBulkOptions')]/..//*[text()='Transfer to Project']/..//input[@type='text']");
	By btnUpdate = By.xpath("(//input[contains(@id,'RadDock1_C_BLK_btnBulkUpdate')])[1]");
	By SuccessMessage = By.xpath("//span[@id='ctl00_ConPHRightTop_idSearch_RadDock1_C_BLK_usrMessage']");

	
	  public void ExpandBulkUpdateOption() {
	    	util.waitUntilElementDisplay(ExpandBulkUpdateOption);
	    	util.click(ExpandBulkUpdateOption);
	    }
	    
	    public void ClickOnCheckbox() {
	    	util.dummyWait(2);
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
	    
	    public void SelectParcelType(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpParcelType, value);
	    }
	    
	    public void SelectParcelState(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpParcelState, value);
	    }
	    
	    public void SelectAcquisitionType(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpAcquisitionType, value);
	    }
	    
	    public void ClickOnOfflineRadio() {
	    	util.waitUntilElementDisplay(OfflineRadio);
	    	util.click(OfflineRadio);
	    }
	    
	    public void ClickOnAbuttingParcelRadio() {
	    	util.waitUntilElementDisplay(AbuttingParcelRadio);
	    	util.click(AbuttingParcelRadio);
	    }
	    
	    public void SelectSurveyStatus(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpSurveyStatus, value);
	    }
	    
	    public void AddTitleReasearchPeriod(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtTitleReasearchPeriod, value);
	    }
	    
	    public void SelectTitleStatus(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpTitleStatus, value);
	    }
	    
	    public void SelectAcquisitionStatus(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpAcquisitionStatus, value);
	    	util.dummyWait(1);
	    }
	    
	    public void SelectTransferToProject(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputText(drpTransferToProject, value);
	    }
	    
	   
	    By transferredProject = By.xpath("(//*[contains(@id,'_radYALDropDownList_DropDown')]/.//li)[1]");
	    public void SelectTransferToProject() {
	    	util.click(drpTransferToProject);
	    	util.waitFor(100);
	    	transferProjectName=  driver.findElement(transferredProject).getText();
	    	util.click(transferredProject);
	    }
	    
	    public void ClickOnUpdateButton() {
	    	util.waitUntilElementDisplay(btnUpdate);
	    	util.click(btnUpdate);
	    }
	    
	    //By getStrProjectName = By.xpath("(//tr[contains(@id,'RadGrid1_ctl00')][last()])//td[12]");
	    By getStrProjectName = By.xpath("(//table/tbody/tr/td[count(//table/thead/tr/th[.='Project Name']/preceding-sibling::th)+1])[1]");

	    public void VerifyProjectName() {
			String ProjectName = util.getText(getStrProjectName);
			log("Project Name is  :" + ProjectName);
			
		}
	    
	    public void BulkUpdateOption(Map<String, String> map, String testcaseName) {
	    	 if (testcaseName.contains("DOT") || testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
					log(" Bulk Update Option ROW not applicable for DOT and ALT", Status.SKIP);
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
			
			if(!testcaseName.contains("TRA") & !testcaseName.contains("DOM")) {
			try {
				SelectParcelType(map.get(Excel.ParcelType));
				log("STEP 3:   User can select value from Parcel Type dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:   User canbot select value from Parcel Type dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			}
			
			try {
				SelectParcelState(map.get(Excel.ParcelState));
				log("STEP 4:   User can select value from Parcel State dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:   User canbot select value from Parcel State dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				SelectAcquisitionType(map.get(Excel.AcquisitionType));
				log("STEP 5:   User can select value from Acquisition Type dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:   User canbot select value from Acquisition Type dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}

			try {
				ClickOnOfflineRadio();
				log("STEP 6:  User can select yes/no from option button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  User cannot select yes/no from option button ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				ClickOnAbuttingParcelRadio();
				log("STEP 7:  User can select yes/no from option button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User cannot select yes/no from option button ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				SelectSurveyStatus(map.get(Excel.SurveyStatus));
				log("STEP 8:   User can select value from Survey Status dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8:   User canbot select value from Survey Status dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			if(!testcaseName.contains("DOM")) {
			try {
				AddTitleReasearchPeriod(map.get(Excel.ResearchPeriod));
				log("STEP 9:   User can select value from Research Period dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:   User canbot select value from Research Period dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			}
			
			try {
				SelectTitleStatus(map.get(Excel.TitleStatus));
				log("STEP 10:   User can select value from Title Status dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10:   User canbot select value from Title Status dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				SelectAcquisitionStatus(map.get(Excel.AcquisitionStatus));
				log("STEP 11:  user can able to select value from Acquisition Status dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 11:  user not able to select value from Acquisition Status dd", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			if(!testcaseName.contains("TRA") & !testcaseName.contains("DOM")) {
			try {
				SelectTransferToProject();
				log("STEP 12:  user can able to select value from Transfer To Project dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:  user not able to select value from Transfer To Project dd", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 13:  user can click on update button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13:  user cannot click on update button.  ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 14 : Change(s) saved! Message will be display in green color.  ", Status.PASS);
				} else {
				   log("STEP 14: user cannot click on update button.  ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 14 ");
		   	} 
			
			if(!testcaseName.contains("TRA") & !testcaseName.contains("DOM")) {
			String ProjectName = util.getText(getStrProjectName);
			log("Project Name on grid  :" + ProjectName);
			//log("Transferred Project Name   :" + transferProjectName);
				
//				if (transferProjectName.equals(ProjectName)) {
//					log("STEP 15: Project Name  Matched !!!", Status.PASS);
//				} else {
//					System.out.println("Project Name  Not Matched !!!");
//					log("STEP 15: Project Name  Not Matched !!!", Status.FAIL);
//			}
				
				VerifyProjectName();
			}
	    }
	  }  
	
}
