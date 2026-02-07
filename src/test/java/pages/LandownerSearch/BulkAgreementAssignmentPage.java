package pages.LandownerSearch;

import java.util.Map;

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

import extentReports.ExtentTestManager;

public class BulkAgreementAssignmentPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public BulkAgreementAssignmentPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By Checkbox = By.xpath("//input[contains(@id,'RadGrid1_ctl00_ctl04_CheckBox1') and @type='checkbox']");
	By ExpandBulkAgreementAssignment = By.xpath("//em[text()='Bulk Agreement Assignment']/..//span[@class='rdExpand']");
	By SelectProject = By.xpath("(//span[@class='rddtFakeInput'])[2]");
	By txtProject = By.xpath("(//input[contains(@class,'rddtFilterEmptyMessage') and @type='text'])[1]");
	By drpAssignment = By.xpath("(//input[contains(@id,'_BLKAGREELOASGN_dd_Lease_Input') and @type='text'])[1]");
	By btnUpdate = By.xpath("(//input[contains(@id,'BLKAGREELOASGN_btnBulkUpdate') and @type='image'])[1]");
	By SuccessMessage = By.xpath("//span[contains(@id,'BLKAGREELOASGN_usrMessage')]");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");

    
    public void ExpandBulkAgreementAssignment() {
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(ExpandBulkAgreementAssignment);
    	util.click(ExpandBulkAgreementAssignment);
    }
    
    public void SelectProject(String value) {
    	util.waitUntilElementDisplay(SelectProject);
    	util.click(SelectProject);
    	if (!commonFunction.checkNA(value)) 
			util.inputText(txtProject, value);
    	By project = By.xpath("//em[text()='"+value+"']");
    	util.click(project);
    }
    
    public void SelectAssignment(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputText(drpAssignment, value);
    	util.dummyWait(1);
    	util.pressDownkey();
    	util.pressENTERkey();
    }
    
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    	util.waitUntilElementDisplay(SuccessMessage);
    }
	
    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
    By btnClose = By.xpath("//a[@title='Close']");
    public void ClickOnOpeninPopupButton() {
    	WebElement web = driver.findElement(documentgrid);
    	util.waitUntilElementDisplay(documentgrid);
    	Actions act = new Actions(driver);
    	act.moveToElement(web).contextClick().build().perform();
    	util.click(btnOpenInPopup);
    	util.dummyWait(1);
    	util.click(btnClose);
    	util.dummyWait(2);
    	util.click(ExpandBulkAgreementAssignment);
    }
    
    By btnRefresh = By.xpath("//input[contains(@id,'RefreshButton')]");
    By ProjectGrid = By.xpath("//tr[contains(@id,'radYALGridControl_ctl00')][last()]");

    public void ClickOnRefreshButton() {
        util.waitUntilElementDisplay(btnRefresh);
        util.click(btnRefresh);
        }
        
       // By AgreementNo = By.xpath("//tbody/tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']/td[14]/a[1]");
          By AgreementNo = By.xpath("(//a[contains(@onclick,'ViewAgreementInfo')])[1]");
        By iframe = By.xpath("//iframe[@name='ViewLoInfo']");
        By getStrProjectName = By.xpath("//tr[contains(@id,'grid_loinfo_radYALGridControl_ctl00')][last()]//td[3]");
        By getStrAgreementNo = By.xpath("//tr[contains(@id,'grid_loinfo_radYALGridControl_ctl00')][last()]//td[5]");
       public void ClickOnAgreementNoLink() {
    	   util.waitUntilElementDisplay(AgreementNo);
    	   util.click(AgreementNo);
    	   util.dummyWait(1);
    	   util.switchToIframe(iframe);
    	   util.dummyWait(1);
    	   setPagesize();
    	   util.dummyWait(2);
       }
       
       public void VerifyProjectName() {
   		String ProjectName = util.getText(getStrProjectName);
   		log("Project Name is  :" + ProjectName);
   		}
       
       public void VerifyAgreementNo() {
      		String AgreementNo = util.getText(getStrAgreementNo);
      		log("Agreement Number is  :" + AgreementNo);
      	}
    
       public void ClickOnClose() {
       	util.switchToDefaultContent();
       	util.dummyWait(1);
       	util.waitUntilElementDisplay(btnClose);
       	util.click(btnClose);
       }
       
       public void setPagesize(){
   		By pagesize = By.xpath("//input[contains(@id,'_PageSizeComboBox_Input')]");
   		System.out.println("");
   		By pageSize50 = By.xpath("//div[contains(@id,'_PageSizeComboBox_DropDown')]/div/ul/li[3]");
   		if(util.isElementPresent(pagesize)){
   			util.click(pagesize);
   			util.click(pageSize50);
   		}
   		else{
   			System.out.println("Page Size option not shows");
   		}
   		
   	}
    public void BulkAgreementAssignment(Map<String, String> map, String testcaseName) {
    	if (testcaseName.contains("DOT")) {
			log(" Bulk Agreement Assignment not applicable for DOT ", Status.SKIP);
		}
		else {
    	
		try {
			util.dummyWait(1);
			ExpandBulkAgreementAssignment();
			log("STEP 2: User can expand  Bulk Agreement Assignment panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot expand Bulk Agreement Assignment panel", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			SelectProject(map.get(Excel.Project));
			log("STEP 3: User can select value from Project dd   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: Project role dd contains no value. ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			SelectAssignment(map.get(Excel.Assignment));
			log("STEP 4:  User can select value from Assignment dd       ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: Assignment dd contains no value.     ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			ClickOnUpdateButton();
			log("STEP 5: User can click on update button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot  click on update  button.      ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 5 :\"Changes saved successfully\" message displays ", Status.PASS);
			} else {
			   log("STEP 5: \"Changes saved successfully\" message not displays", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 5 ");
	   	} 
		
		try {
			ClickOnRefreshButton();
			util.dummyWait(2);
			log("STEP 6: User Can click on refresh button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User Cannot click on refresh button ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			ClickOnAgreementNoLink();
			log("STEP 7: User Can click on Agreement Number Link ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User Cannot click on Agreement Number Link ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		  By projectName = By.xpath("//tr[contains(@id,'grid_loinfo_radYALGridControl_ctl00')]/..//*[text()='"+map.get(Excel.Project)+"']");
			
		  if (util.isElementVisible(projectName)) {
				log("STEP 8: Project Name  Matched !!!", Status.PASS);
			} else {
			ExtentTestManager.infoWithScreenshot("Project Name not assigned");
			util.dummyWait(1);
			ClickOnClose();	
				log("STEP 8: Project Name  Not Matched !!!", Status.FAIL);
		}
			util.dummyWait(1);
			
			
			
			
      		 By agreementNo = By.xpath("//tr[contains(@id,'grid_loinfo_radYALGridControl_ctl00')]/..//*[text()='"+map.get(Excel.Assignment)+"']");
      		String AgreementNo = util.getText(agreementNo);
      		log("Agreement Number is  :" + AgreementNo);
      		
      		if (util.isElementVisible(agreementNo)) {
				log("STEP 9: Agreement Number  Matched !!!", Status.PASS);
			} else {
				ExtentTestManager.infoWithScreenshot("Agreement No not assigned");
				util.dummyWait(1);
				ClickOnClose();	
				log("STEP 9: Agreement Number  Not Matched !!!", Status.FAIL);
		}

			ClickOnClose();	
		
    }
	
    }
}
