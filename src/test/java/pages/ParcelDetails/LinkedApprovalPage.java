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

public class LinkedApprovalPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public LinkedApprovalPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')]");
	By navParcelForms = By.xpath("//span[contains(text(),'Parcel Forms')]");
	By btnAddNewRecordAlt = By.xpath("//img[@id='ctl00_ConPHRightTop_ParcelInformation_UC_radPrjPanels_i13_i0_idTractInfoApproval_YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By btnAddNewRecordDot = By.xpath("(//img[@alt='Add new record'])[1]");
	By btnAddNewRecordRow = By.xpath("//img[@id='ctl00_ConPHRightTop_TRPI_UC_radPrjPanels_i25_i0_YALWorkflows_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
	By FullFrm = By.xpath("//iframe[@name='ManageApprovalDialog']");
	By drpApprovalType = By.xpath("//input[contains(@id,'_YALComboBox_Input')  and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'idManageApproval_btnSaveHeader') and @type='image']");
	By drpStatusException = By.xpath("//input[contains(@id,'idManageApproval_STATUS_EXC_ID_radYALDropDownList_Input') and @type='text']");
	By txtReasonForStatusException = By.xpath("//textarea[@id='idManageApproval_STS_COMMENTS']");
	By linkLinkedApprovals = By.xpath("//span[contains(text(),'Linked Approvals')]");
	By ExcelIcon = By.xpath("//img[@id='idManageApproval_gridLinkedApprovals_radYALGridControl_ctl00_ctl02_ctl00_Img3']");
	By SuccessfulMessage = By.xpath("//span[text()='Changes saved successfully.']");

	public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);			
	}
	
	public void clickonAddNewRecordALT()
	{
		util.waitUntilElementDisplay(btnAddNewRecordAlt);
    	util.click(btnAddNewRecordAlt);
		
	}
	
	public void clickonAddNewRecordDOT()
	{
		util.waitUntilElementDisplay(btnAddNewRecordDot);
    	util.click(btnAddNewRecordDot);
		
	}
	
	public void clickonAddNewRecordROW()
	{
		util.waitUntilElementDisplay(btnAddNewRecordRow);
    	util.click(btnAddNewRecordRow);
		
	}
	
	public void SelectApprovalType(String value) {
		util.switchToIframe(FullFrm);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpApprovalType, value);
		
    }
	
	public void clickonSave()
	{
		util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
		util.dummyWait(3);
	    util.waitUntilElementDisplay(SuccessfulMessage);
	    Assert.assertTrue(util.isElementPresent(SuccessfulMessage), "Changes saved successfully.");
	}
	
	public void SelectStatusException(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatusException, value);
		
    }
	
	public void AddReasonForStatusException(String value) {
		util.dummyWait(2);
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtReasonForStatusException, value);
		
    }
	
	public void clickonLinkedApprovals()
	{
		util.waitUntilElementDisplay(linkLinkedApprovals);
    	util.click(linkLinkedApprovals);
		
	}
	
	By btnClose = By.xpath("//a[@class='rwCloseButton']");

	public void clickonExcelIcon()
	{
		util.waitUntilElementDisplay(ExcelIcon);
    	util.click(ExcelIcon);
		util.dummyWait(3);
		util.switchToDefaultContent();
		util.click(btnClose);
	}

	  public void LinkApprovals(Map<String, String> map, String testcaseName) {
// 		 navigateParcelInformation();

		  if(testcaseName.contains("ALT"))
		  {
	    	 try {
	    		 clickonAddNewRecordALT();
	    		 util.dummyWait(5);
	  			 log("STEP 1: user can click on add new record button    ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 1:  User is unable to click on add new record.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 1");
	  		 }
		  }
		  else  if(testcaseName.contains("DOT"))
		  {
			  try {
		    		 clickonAddNewRecordDOT();
		    		 util.dummyWait(5);
		  			 log("STEP 1: user can click on add new record button  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 1:  User is unable to click on add new record.  ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 1");
		  		 } 
		  }
		  else
		  {
			  try {
		    		 clickonAddNewRecordROW();
		    		 util.dummyWait(5);
		  			 log("STEP 1: user can click on add new record button  ", Status.PASS);
		  		 } catch (Exception e) {
		  			log("STEP 1:  User is unable to click on add new record. ", Status.FAIL);
		  			throw new RuntimeException("Failed in step 1");
		  		 }   
		  }
		  
		  try {
			  SelectApprovalType(map.get(Excel.ApprovalType));
	  			 log("STEP 2:  User can select a value in ApprovalType field      ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 2:  User cannot add a value in ApprovalType field    ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 2");
	  		 }
		  
		  try {
			  clickonSave();
	  			 log("STEP 3:  user can click on save button ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 3:  User is unable to click on save button.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 3");
	  		 }
		  
		  try {
			  SelectStatusException(map.get(Excel.StatusException));
	  			 log("STEP 4:  User can select a value in Status Exception field ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 4:   User cannot add a value in Status Exception field   ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 4");
	  		 }
		  
		  try {
			  AddReasonForStatusException(map.get(Excel.ReasonStatusException));
	  			 log("STEP 5: User can select a value in Reason of Status Exception field", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 5:   User cannot add a value in Reason of Status Exception field  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 5");
	  		 }
		  
		  try {
			  clickonSave();
	  			 log("STEP 6:  user can click on save button ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 6:  User is unable to click on save button.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 6");
	  		 }
		  
		  try {
			  clickonLinkedApprovals();
	  			 log("STEP 7:  grid is opened with calumns like Key_ID,id,approval type,key_type,last_updt_ID & status.   ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 7:  grid will not be displayed  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 7");
	  		 }
		  
		  try {
			  clickonExcelIcon();
	  			 log("STEP 8:  User can click on excel icon  ", Status.PASS);
	  		 } catch (Exception e) {
	  			log("STEP 8:  User is unable to download excel file.  ", Status.FAIL);
	  			throw new RuntimeException("Failed in step 8");
	  		 }
		  
	  }
	
}
