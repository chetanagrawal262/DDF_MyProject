package pages.ToolsBulkEdit;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

import bsh.util.Util;

public class BulkEdit_MyApprovalPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public BulkEdit_MyApprovalPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By navTools = By.xpath("//span[text()='Tools']");
	By navBulkEdit = By.xpath("//span[contains(text(),'Bulk Edit')]");
	By navMyApproval = By.xpath("//span[contains(text(),'My Approvals')]");
	By navApprovedPayments = By.xpath("//span[contains(text(),'Approved Payments')]");

	By ApproveRejectLink = By.xpath("(//a[text()='Approve/Reject'])[1]");
	By ViewParcelLink = By.xpath("(//a[contains(text(),'View ')])[1]");
	By btnSaveChanges = By.xpath("(//a[contains(@id,'SaveChangesButton')])[1]");
	By btnCancelChanges = By.xpath("(//a[contains(@id,'CancelChangesButton')])[1]");
	By btnAddToFavourite = By.xpath("//input[contains(@id,'idBulkEdit_btnAddToFavourite') and @type='submit']");
	By btnRemoveFromFavourite = By.xpath("//input[contains(@id,'idBulkEdit_btnRemoveFromFavourite') and @type='submit']");
	By ExportQVData = By.xpath("//input[contains(@id,'idBulkEdit_btnExport') and @type='submit']");
	By wfConfigurationIcon = By.xpath("//span[contains(@title,'WorkFlow Configuration')]");
	By BulkEditFrm = By.xpath("(//iframe[contains(@name,'_idBulkEdit_RadWindowManager')])[1]");
	By tabGroupingOrSorting = By.xpath("//span[text()='Grouping/Sorting']");
	By btnAddNewRecord = By.xpath("//img[@alt='Add new record']");
	By drpColumn = By.xpath("//input[contains(@id,'EditFormControl_Column_ID_YALComboBox_Input') and @type='text']");
	By drpGroupOrSort = By.xpath("//input[contains(@id,'_EditFormControl_Group_Type_ID_YALComboBox_Input') and @type='text']");
	By txtApplyInOrder = By.xpath("//input[contains(@id,'_EditFormControl_Apply_ORDER') and @type='text']");
	By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert')]");
	By btnClose = By.xpath("//a[@class='rwCloseButton']");
	By groupParcelApproval = By.xpath("//div[contains(text(),'Approval Record Type: Parcel Approval')]");
	By recordParcelApproval = By.xpath("(//div[contains(text(),'Approval Record Type: Parcel Approval')]/../../../../following-sibling::tr/.//*[text()='Parcel Approval'])[1]");
	By groupProjectApproval = By.xpath("//div[contains(text(),'Approval Record Type: Project Approval')]");
	By recordProjectApproval = By.xpath("(//div[contains(text(),'Approval Record Type: Project Approval')]/../../../../following-sibling::tr/.//*[text()='Project Approval'])[1]");
	
	public void NavigateToMyApproval() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitFor(150);
		util.hoverOnElement(navBulkEdit);
		util.waitFor(150);
		if(util.isElementVisible(navMyApproval)) {
			util.hoverOnElement(navBulkEdit);
		}
		util.click(navMyApproval);
	}
	
	public void ClickOnAddToFavourite() {
		util.waitUntilElementDisplay(btnAddToFavourite);
		util.click(btnAddToFavourite);
		util.dummyWait(2);
	}
	
	public void ClickOnRemoveFromFavorite() {
		util.waitUntilElementDisplay(btnRemoveFromFavourite);
		util.click(btnRemoveFromFavourite);
		util.dummyWait(2);
	}
	
	public void ClickOnExportQVData() {
		util.waitUntilElementDisplay(ExportQVData);
		util.click(ExportQVData);
	}
	
	By MyDashboard = By.xpath("//span[contains(text(),'My Dashboard')]");
	By MyApproval = By.xpath("//td[contains(text(),'My Approvals')]");
	public void NavigateToMyDashboard() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitUntilElementDisplay(MyDashboard);
		util.click(MyDashboard);
		util.dummyWait(1);
		 util.waitUntilElementDisplay(MyApproval);
  	   Assert.assertTrue(util.isElementPresent(MyApproval), "My Approvals");
		
	}

	public void ClickOnMyApproval() {
		util.waitUntilElementDisplay(MyApproval);
		util.click(MyApproval);
	}
	
	public void ClickOnWFConfigurationIcon() {
		util.waitUntilElementDisplay(wfConfigurationIcon);
		util.click(wfConfigurationIcon);
		util.waitFor(100);
		util.switchToIframe(BulkEditFrm);
	}
	
	public void NavigateToGroupingSortingTab() {
		util.waitUntilElementDisplay(tabGroupingOrSorting);
		util.click(tabGroupingOrSorting);
		util.waitFor(200);
	}
	
	public void ClickOnAddNewRecord() {
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
		util.waitFor(200);
	}
	
	public void SelectColumn(String value) {
		util.waitUntilElementDisplay(drpColumn);
		util.inputTextAndPressTab(drpColumn, value);
	}
	
	public void SelectType(String value) {
		util.waitUntilElementDisplay(drpGroupOrSort);
		util.inputTextAndPressTab(drpGroupOrSort, value);
	}
	
	public void AddOrder(String value) {
		util.waitUntilElementDisplay(txtApplyInOrder);
		util.inputTextAndPressTab(txtApplyInOrder, value);
	}
	
	public void ClickOnInsert() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitFor(200);
	}
	
	public void ClosePopUp() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
		util.waitFor(200);
	}
	
	   public void verifyGroupingAndSorting(Map<String, String> map, String testcaseName) {
     
		   try {
			   NavigateToMyApproval();
				log("STEP 1:  User can navigate to  My Approval page   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to My Approval  page", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
 
		   try {
			   ClickOnWFConfigurationIcon();
				log("STEP 2:  User can click on Workflow Configuration Icon ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on Workflow Configuration Icon", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		   
		   try {
			   NavigateToGroupingSortingTab();
				log("STEP 3:  User can Navigate to Grouping or Sorting Tab", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot Navigate to Grouping or Sorting Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		   
		   By record = By.xpath("//*[text()='"+map.get(Excel.Type)+"']/..//td[text()='"+map.get(Excel.Column)+"']");
		   
		   if(!util.isElementVisible(record)) {
		   
		   try {
			   ClickOnAddNewRecord();
				log("STEP 4:  User can click on Add New Record Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot click on Add New Record Button", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		   
		   try {
			   SelectColumn(map.get(Excel.Column));
				log("STEP 5:  User can select value from the column dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot select value from the column dd", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
	
		   try {
			   SelectType(map.get(Excel.Type));
				log("STEP 6:  User can select Grouping / Sorting Type", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot select Grouping / Sorting Type", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
		   
		   try {
			   AddOrder(map.get(Excel.Order));
				log("STEP 7:  User can enter Order", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot enter Order", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		   
		   try {
			  ClickOnInsert();
			 
				log("STEP 8:  User can click on Insert Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User cannot click on Insert Button", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
		   }
		   ClosePopUp();
		   util.reloadPage();
		   
		   if(!environment.contains("ORSTED") & !environment.contains("WSBALT") & !environment.contains("CONNECTGEN") & !environment.contains("RAMACO") & !environment.contains("AVANTUS") & !environment.contains("TREATYOAK") & !environment.contains("ORION") & !environment.contains("NOVA")) {
				
		   try {
				  Assert.assertTrue(util.isElementVisible(groupParcelApproval));
					log("STEP 9:  User can see Parcel Approval Group", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 9: User cannotsee Parcel Approval Group", Status.FAIL);
				}
		   
		   try {
				  Assert.assertTrue(util.isElementVisible(recordParcelApproval));
					log("STEP 10:  User can see Parcel Approval record under parcel approval Group", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 10: User cannotsee Parcel Approval record under parcel approval Group", Status.FAIL);
				}
		   }
		   
		   try {
				  Assert.assertTrue(util.isElementVisible(groupProjectApproval));
					log("STEP 11:  User can see Project Approval Group", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 11: User cannotsee Project Approval Group", Status.FAIL);
				}
		   
		   try {
				  Assert.assertTrue(util.isElementVisible(recordProjectApproval));
					log("STEP 12:  User can see Project Approval record under Project approval Group", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 12: User cannotsee Project Approval record under Project approval Group", Status.FAIL);
				}
		   
}
	   
	   
	   
}