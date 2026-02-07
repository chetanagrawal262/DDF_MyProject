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

public class BulkParcelAssignementPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public BulkParcelAssignementPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By ExpandBulkParcelAssignment = By.xpath("(//span[@class='rdExpand'])[2]");
	By Checkbox = By.xpath("(//input[contains(@id,'RadGrid1_ctl00_ctl04_CheckBox1') and @type='checkbox'])[1]");
	By SelectProject = By.xpath("(//span[@class='rddtFakeInput'])[1]");
	By txtProject = By.xpath("(//input[contains(@class,'rddtFilterEmptyMessage') and @type='text'])[1]");
	By drpParcel = By.xpath("(//input[contains(@id,'Tracts_Input') and @type='text'])[1]");
	By btnUpdate = By.xpath("(//input[contains(@id,'BLKTRACTLOASGN_btnBulkUpdate') and @type='image'])[1]");
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");

    
    public void ExpandBulkParcelAssignment() {
    	util.dummyWait(2);
    	util.waitUntilElementDisplay(ExpandBulkParcelAssignment);
    	util.click(ExpandBulkParcelAssignment);
    	util.dummyWait(1);
    
    }
    
    public void SelectProject(String value) {
    	util.waitUntilElementDisplay(SelectProject);
    	util.click(SelectProject);
    	util.dummyWait(1);
    	if (!commonFunction.checkNA(value)) 
			util.inputText(txtProject, value);
    	String drpSelectName = "(//ul//li[contains(normalize-space(),'"+value+"')]//span[@class='rtIn'])[1]";
    	util.click(drpSelectName);
    }
    
    By UpArrow = By.xpath("//a[contains(@id,'dd_Tracts_Arrow')]");
    public void SelectParcel(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputText(drpParcel, value);
    	util.dummyWait(1);
    	util.pressDownkey();
//    	util.pressEscapkey();
    	util.dummyWait(1);
    	util.pressENTERkey();
    }
    
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    	util.waitUntilElementDisplay(SuccessMessage);
    	Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
    }
	
    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
    By btnClose = By.xpath("//a[@title='Close']");
	By Arrow = By.xpath("(//span[@class='rdCollapse'])[2]");
    By btnRefresh = By.xpath("//input[contains(@id,'RefreshButton')]");
    public void ClickOnRefreshButton() {
    util.waitUntilElementDisplay(btnRefresh);
    util.click(btnRefresh);
    util.dummyWait(2);
    }
    
    By ParcelNo = By.xpath("(//a[contains(@onclick,'ViewParcelInfo')])[1]");
    By ParcelNoDot = By.xpath("(//a[contains(@onclick,'ViewParcelInfo')])[1]");
    //By ParcelNoRow = By.xpath("//tbody/tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']/td[5]/a[1]");
    By ParcelNoRow = By.xpath("(//a[contains(@onclick,'ViewParcelInfo')])[1]");
    By iframe = By.xpath("//iframe[@name='ViewLoInfo']");
    By getStrProjectName = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()])//td[3]");
    By getStrParcelNumber = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()])//td[4]");
   public void ClickOnParcelNoLink() {
	   util.dummyWait(1);
	   util.waitUntilElementDisplay(ParcelNo);
	   util.click(ParcelNo);
	   util.dummyWait(1);
	   util.switchToIframe(iframe);
	   util.dummyWait(1);
   }
   
   public void ClickOnParcelNoLinkDOT() {
	   util.waitUntilElementDisplay(ParcelNoDot);
	   util.click(ParcelNoDot);
	   util.dummyWait(1);
	   util.switchToIframe(iframe);
	   util.dummyWait(1);
   }
   
   public void ClickOnParcelNoLinkROW() {
	   util.dummyWait(1);
	   util.waitUntilElementDisplay(ParcelNoRow);
	   util.click(ParcelNoRow);
	   util.dummyWait(1);
	   util.switchToIframe(iframe);
	   util.dummyWait(1);
   }
   By ProjectGrid = By.xpath("//tr[contains(@id,'radYALGridControl_ctl00')][last()]");
 
   
   public void VerifyProjectName() {
		String ProjectName = util.getText(getStrProjectName);
		log("Project Name is  :" + ProjectName);
		
	}
   
    public void ClickOnClose() {
    	util.switchToDefaultContent();
    	util.dummyWait(1);
    	util.waitUntilElementDisplay(btnClose);
    	util.click(btnClose);
    	util.dummyWait(1);
    	util.click(Arrow);
    }

    
    public void BulkParcelAssignement(Map<String, String> map, String testcaseName) {
		try {
			
			ExpandBulkParcelAssignment();
			log("STEP 1: User can expand  Bulk parcel assignment panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand Bulk parcel assignment panel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			SelectProject(map.get(Excel.Project));
			log("STEP 2: User can select value from Project dd   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: Project role dd contains no value. ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			util.dummyWait(2);
			util.click(Checkbox);
			util.dummyWait(1);
			SelectParcel(map.get(Excel.Parcel));
			log("STEP 3:  User can select value from Parcel dd       ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: Parcel dd contains no value.     ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			ClickOnUpdateButton();
			log("STEP 4: User can click on update button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot  click on update  button.      ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 5 :\"Changes saved successfully\" message displays ", Status.PASS);
			} else {
			   log("STEP 5: \"Changes saved successfully\" message not displays", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 5 ");
	   	} 
		
		try {
			ClickOnRefreshButton();
			log("STEP 6: User Can click on refresh button", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  User Cannot click on refresh button ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
		try {
			ClickOnParcelNoLink();
			log("STEP 7: User Can click on Parcel Number Link ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  User Cannot click on Parcel Number Link ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
	}
		else if(testcaseName.contains("DOT")){
			try {
				ClickOnParcelNoLinkDOT();
				log("STEP 7: User Can click on Parcel Number Link ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User Cannot click on Parcel Number Link ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
		}
		else{
			try {
				ClickOnParcelNoLinkROW();
				log("STEP 7: User Can click on Parcel Number Link ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User Cannot click on Parcel Number Link ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		}
			  
			try {	
			   
			   
				By projectName = By.xpath("//*[@id='grid_loinfo_radYALGridControl_ctl00']//*[text()='"+map.get(Excel.Parcel)+"']/..//*[text()='"+map.get(Excel.Project)+"']");
			    By parcelNumber = By.xpath("//*[@id='grid_loinfo_radYALGridControl_ctl00']//*[text()='"+map.get(Excel.Project)+"']/..//*[text()='"+map.get(Excel.Parcel)+"']");
			    
			    try {
					Assert.assertTrue(util.isElementVisible(projectName));
					 String ProjectName = util.getText(projectName);
						ExtentTestManager.info("Project Name is " + ProjectName);
					log("STEP 8: Project Name Match ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 8:  Project Name not Match ", Status.FAIL);
				}
			    
			    try {
					Assert.assertTrue(util.isElementVisible(parcelNumber));
					 String ParcelNumber = util.getText(parcelNumber);
						ExtentTestManager.info("Parcel Number is " + ParcelNumber);
					log("STEP 9: Parcel Number  Matched ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 9:  Parcel Number  Not Matched ", Status.FAIL);
				}
			    
			}finally {
				
				ClickOnClose();	
			}
		   
	
    }
}
