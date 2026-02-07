package pages.ProjectSearch;

import java.util.List;
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

public class BulkAssignmentOptionPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
    String projectRole;
	public BulkAssignmentOptionPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By checkbox = By.xpath("//input[contains(@id,'RadGrid1_ctl00_ctl04_CheckBox1')]");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
    By ExpandBulkAssignmentOption = By.xpath("(//em[text()='Bulk Assignment Options']/..//span)[2]");
    By ProjectCheckbox = By.xpath("(//input[@class='rlbCheck'])[1]");
    By ProjectCheckboxDot = By.xpath("(//input[@class='rlbCheck'])[3]");
    By drpProjectRole = By.xpath("//input[contains(@id,'BLKA_PROJECT_ROLE_ID_radYALDropDownList_Input')]");
    By btnUpdate = By.xpath("//input[contains(@id,'_BLKA_SavePrjAssignment')]");
    By SuccessMesssage = By.xpath("//span[@id='ctl00_ConPHRightTop_idSearch_RadDock1_C_BLK_usrMessage']");
	
    public void BulkAssignmentOptionOption() {
    	util.waitUntilElementDisplay(ExpandBulkAssignmentOption);
    	util.click(ExpandBulkAssignmentOption);
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
    By iframe = By.xpath("//iframe[@name='SearchSingleOpen']");
    public void ClickOnOpeninPopupButton() {
    	util.dummyWait(1);
    	util.click(btnOpenInPopup);
    	util.dummyWait(1);
    	util.switchToIframe(iframe);
    	
    }
    
    public void ClickOnProjectCheckbox() {
    	util.waitUntilElementDisplay(ProjectCheckbox);
    	util.click(ProjectCheckbox);
    }
    
    public void ClickOnProjectCheckboxDot() {
    	util.waitUntilElementDisplay(ProjectCheckboxDot);
    	util.click(ProjectCheckboxDot);
    }
    
    public void SelectdrpProjectRole(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpProjectRole, value);
    }
    
    By role = By.xpath("//*[contains(@id,'_PROJECT_ROLE_ID_radYALDropDownList_')]/.//li[last()-1]");
    public void SelectdrpProjectRole() {
    	util.click(drpProjectRole);
//    	projectRole=driver.findElement(role).getText();
//    	util.click(role);
//    	System.out.println(projectRole);
    	List<WebElement> liElements = driver.findElements(By.xpath("//*[contains(@id,'_PROJECT_ROLE_ID_radYALDropDownList_')]/.//li"));

    	if (liElements.size() >= 2) {
            WebElement secondLast = liElements.get(liElements.size() - 2);
            String value = secondLast.getText();
            projectRole =value;
            System.out.println("Second-last <li> value: " + value);
            secondLast.click();
    	}
    }
    
    public void ClickOnUpdate() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    }
    
    By navProjectAssignment = By.xpath("//a[normalize-space()='Project Assignments'] | //a[normalize-space()='Project Team']");
    
    public void NavigateToProjectAssignment() {
    	util.waitUntilElementDisplay(navProjectAssignment);
    	util.click(navProjectAssignment);
    }
    
    public void ClickOnClose() {
    	util.dummyWait(1);
    	util.switchToDefaultContent();
    	util.waitUntilElementDisplay(btnClose);
    	util.click(btnClose);
    }
    
    
    By getStrProjectRoleAlt = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()]//td[3])[2]");
    By getStrAgentNameAlt = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()]//td[2])[2]");
    
    By getStrProjectRoleRow = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')]//td[5])[1]");
    By getStrAgentNameRow = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')]//td[4])[1]");
    
    By getStrProjectRoleDot = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()]//td[5])[1]");
    By getStrAgentNameDot = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()]//td[4])[1]");
    
    public void BulkAssignmentOption(Map<String, String> map, String testcaseName) {

		
		try {
			BulkAssignmentOptionOption();
			log("STEP 1:  User can expand Bulk Assignment option panel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:   User cannot expand bulk Assignment option panel   ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		if(testcaseName.contains("DOT")) {
			try {
				ClickOnProjectCheckboxDot();
				log("STEP 2:  User can select Project User", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User cannot select Project User", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		}
		else {
		try {
			ClickOnProjectCheckbox();
			log("STEP 2:  User can select Project User", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  User cannot select Project User ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
	}
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA") & !testcaseName.contains("DOM")) {
		try {
			if(testcaseName.contains("DOT")) {
			ClickOnCheckbox();
			}
			SelectdrpProjectRole();
			log("STEP 3: User can select Project Role    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Project Role ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
    }
		try {
			ClickOnUpdate();
			log("STEP 4:  user can click on update button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  user cannot click on update button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		if (util.isElementPresent(SuccessMesssage)) {
			   log("STEP 5: Changes saved message will be displayed in green color  ", Status.PASS);
			} else {
			   log("STEP 5: user cannot click on update button.  ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 5 ");
	   	} 
		
//		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
//		try {
//			RightClickOnDocumentGrid();
//			log("STEP 6: when user right click on records 2 options should be displayed 1)Open in window. 2)Open in current window.  ", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 6:  User cannot right click on search results. ", Status.FAIL);
//			throw new RuntimeException("Failed in step 6 ");
//		}
//		
//		try {
//			ClickOnOpeninPopupButton();
//			util.dummyWait(1);
//			NavigateToProjectAssignment();
//			By pagesize = By.xpath("//*[@id='ctl00_ConPHRightTop_radPrjPanels_i3_i0_ProjectAssignments_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_Arrow']");
//		    By pageSize50 = By.xpath(
//					"//div[contains(@id,'YALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_DropDown')]/div/ul/li[3]");
//			if (util.isElementPresent(pagesize)) {
//				util.click(pagesize);
//				util.click(pageSize50);
//				util.dummyWait(1);
//			}
//  		log("STEP 7: User can navigate to Project Assignment Panel ", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 7: User not able to navigate to Project Assignment Panel  ", Status.FAIL);
//			throw new RuntimeException("Failed in step 7 ");
//		}
//		
//		
//		try {
//			By getStrProjectRole = By.xpath("(//tr[contains(@id,'radYALGridControl')]/..//*[text()='"+projectRole+"'])[1]");
//			 String ProjectRoleAlt = util.getText(getStrProjectRole);
//		   		log("Project Role is  :" + ProjectRoleAlt);
//		   		Assert.assertTrue(util.isElementVisible(getStrProjectRole));
//		   		log("STEP 8: Project Role  Matched !!!", Status.PASS);
//		} catch (AssertionError e) {
//			ExtentTestManager.infoWithScreenshot("Project Assignment Grid");
//			log("STEP 8: Project Role  Not Matched !!!", Status.FAIL);
//		}
//		
//			try {
//					ClickOnClose();
//					log("STEP 9: User can close the popup", Status.PASS);
//			} catch (Exception e) {
//				ClickOnClose();
//				log("STEP 9: User not able to close the popup", Status.FAIL);
//				throw new RuntimeException("Failed in step 9");
//			}
//		
//		}
		
		
    }

	
}
