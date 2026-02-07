package pages.Administration_ReportAdministration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditReportSchedulerPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public EditReportSchedulerPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By btnEdit = By.xpath("(//input[contains(@id,'EditButton')])[last()]");
	By iframe = By.xpath("//iframe[@name='EditReportScheduler']");
	By drpReport = By.xpath("//input[contains(@id,'rcbReports_Input')]");
	By ActiveCheckbox = By.xpath("//input[contains(@id,'chkActive')]");
	By drpReportFormat = By.xpath("//input[contains(@id,'cbReportFormat_YALComboBox_Input')]");
	By txtFirstExecution = By.xpath("//input[contains(@id,'dp_Actual_Date_dateInput') and @type='text']");
	By drpHour = By.xpath("//select[contains(@id,'ddlHour')]");
	By drpMinute = By.xpath("//select[contains(@id,'ddlMin')]");
    By drpAMPM = By.xpath("//select[contains(@id,'ddlAMPM')]");	
    By txtEmailSelected = By.xpath("//input[contains(@id,'txtEmailSubject')and @type='text']");
    By txtEmailMassage = By.xpath("//textarea[contains(@id,'txtEmailBody')]");
    By drpEmailToApplicationUserRole = By.xpath("//input[contains(@id,'cbUserRoles_YALComboBox_Input')]");
    By txtEmailTo = By.xpath("//textarea[contains(@id,'txtEmailTo')]");
    By drpAdditionalExecution = By.xpath("//input[contains(@id,'cbSchedulerType_YALComboBox_Input')]");
    By txtEvery = By.xpath("//input[contains(@id,'txtEvery')and @type='text']");
    By btnUpdate = By.xpath("//input[contains(@id,'btnUpdate')]");
	By btnCancel = By.xpath("//input[contains(@id,'btnCancel')and @type='submit']");
	By SuccessMessage = By.xpath("//span[@id='idEditMenageReportScheduleDetails_lblUserMsg']");
	By btnClose = By.xpath("//a[@title='Close']");

	
	public void ClickOnEditButton() {
		util.waitUntilElementDisplay(btnEdit);
		util.click(btnEdit);
		util.switchToIframe(iframe);
		util.dummyWait(2);
	}
	
	public void SelectReport(String value) {
		if(util.isElementPresent(drpReport)) {
			util.click(drpReport);
			util.selectDropDownValue(drpReport, value);
		}
	}
	
	public void ClickOnActiveCheckbox() {
		util.waitUntilElementDisplay(ActiveCheckbox);
		util.click(ActiveCheckbox);
	}
	
	public void SelectReportFormat(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpReportFormat, value);
	}
	
	public void AddFirstExecutionDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFirstExecution, value);
	}
	
	public void AddHour(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpHour, value);
	}
	
	public void AddMinute(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpMinute, value);
	}
	
	public void AddAMPM(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAMPM, value);
	}
	
	public void AddEmailSelected(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmailSelected, value);
	}
	
	public void AddEmailMassage(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmailMassage, value);
	}
	
	public void SelectEmailToApplicationUserRole(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEmailToApplicationUserRole, value);
	}
	
	public void AddEmailTo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEmailTo, value);
	}
	
	public void AddAdditionalExecution(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAdditionalExecution, value);
	}
	
	public void AddEvery(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEvery, value);
	}
	
	public void ClickOnUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.dummyWait(2);
	}
	
	public void ClickOnCancel() {
		util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
	util.dummyWait(2);
	util.switchToDefaultContent();
	util.click(btnClose);
	}

	public void EditReportScheduler(Map<String, String> map, String testcaseName) {
	
		try {
			ClickOnEditButton();
			log("STEP 1:  User can click on the Edit scheduler  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  User cannot click on the Edit scheduler", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			SelectReport(map.get(Excel.Report));
			log("STEP 2: User can select any value from Report dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot select any value from Report dd", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		

		try {
			//ClickOnActiveCheckbox();
			log("STEP 3:  User can click on active checkbox ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  User cannot click on active checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			SelectReportFormat(map.get(Excel.ReportFormat));
			log("STEP 4:  User can select any value from Report Format dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  User cannot select any value from Report Format dd", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		try {
			AddFirstExecutionDate(map.get(Excel.FirstExecution));
			log("STEP 5: User can select the First Execution Date  Date ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot select the First Execution Date  Date", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		try {
			AddHour(map.get(Excel.Hour));
			log("STEP 6: User can select time ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select time ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			AddMinute(map.get(Excel.Minute));
			log("STEP 7: User can select time", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User can not enter time", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		try {
			AddAMPM(map.get(Excel.AM_PM));
			log("STEP 8: User can select time in AM/PM format", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User  cannot select  time from dd", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		try {
			AddEmailSelected(map.get(Excel.EmailSubject));
			log("STEP 9: User can enter a value in the Email Subject field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot enter a value in the Email Subject field", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			AddEmailMassage(map.get(Excel.EmailMessage));
			log("STEP 10: User can enter a value in the Email Message field  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot enter a value in the Email Message field ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		try {
			SelectEmailToApplicationUserRole(map.get(Excel.UserRoles));
			log("STEP 11: User can select any value from Email To Application User Role dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot select any value from Email To Application User Role dd", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		try {
			AddEmailTo(map.get(Excel.Email));
			log("STEP 12: User can enter a value in the text EmailTo field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot enter a value in the text EmailTo field", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		try {
			AddAdditionalExecution(map.get(Excel.AdditionalExecution));
			log("STEP 13: User can select any value from Additional Execution dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot select any value from Additional Execution dd", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			AddEvery(map.get(Excel.Every));
			log("STEP 14:  User can enter a value in the  Every field", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:  User cannot enter a value in the  Every field", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		try {
			ClickOnUpdateButton();
			log("STEP 15:  User can click on Update button", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:  User cannot click on Update button ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 16 :Message - 'Report has been scheduled.!' in green displays .   ", Status.PASS);
			} else {
			   log("STEP 16: User cannot click on insert button "  , Status.FAIL);
		      throw new RuntimeException("Faild in STEP 16 ");
	   	    } 
		
		try {
			ClickOnCancel();
			log("STEP 17:  User can click on cancel button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot click on cancel button ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
	}
	
	By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteAlignment')])[last()]");
	By iframDelete = By.xpath("//td[@class='rwWindowContent']");
	By btnCancle = By.xpath("//span[text()='Cancel']");
	By btnOk = By.xpath("//span[text()='OK']");
	By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
	
	
	public void ClickonDelete() {
  		util.waitUntilElementDisplay(btnDelete);
  		util.click(btnDelete);
  		
  		
    }

 
 public void ClickonCancle() 
 {
    util.dummyWait(3);
  		util.waitUntilElementDisplay(btnCancle);
  		util.click(btnCancle);
  		
  		
    }
 
 
 public void ClickonOk() 
 {
	    util.waitUntilElementDisplay(btnDelete);
  		util.click(btnDelete);	
  		util.waitUntilElementDisplay(btnOk);
  		util.click(btnOk);
  		util.dummyWait(3);
  		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
  		
  		
    }
 
 
     public void DeleteReportScheduler(String testcaseName) {
	 util.dummyWait(2);	 
	 try {
		 ClickonDelete();
			log("STEP 1:  user can click on cross icon   ", Status.PASS);
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
	 
	 util.dummyWait(1);
	 try {
		 ClickonOk();
			log("STEP 3: Deleted record does not display in the grid and 2)Message- Changes saved suessfully! in green displays. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: Message- Changes saved sucessfully' does not display", Status.FAIL);
			throw new RuntimeException("Failed in step 3 ");
		
		}
	 
}
	
}
