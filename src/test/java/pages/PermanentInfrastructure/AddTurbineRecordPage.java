package pages.PermanentInfrastructure;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddTurbineRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddTurbineRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navTurbineDetails = By.xpath("//span[contains(text(),'Turbine Details')] | //span[contains(text(),'Mine Details')]");
	By btnAddNewRecord = By.xpath("//div//img[@alt='Add Turbine']");
	By iframe = By.xpath("//iframe[@name='TurbineDialog']");
	By drpFinancialCategory = By.xpath("//input[contains(@id,'Financial_Class_ID_radYALDropDownList_Input') and @type='text']");
    By txtTurbineName = By.xpath("//input[contains(@id,'txtTurbineNumber') and @type='text']");
    By txtTurbineCapacity = By.xpath("//input[contains(@id,'txtTurbineCapacity') and @type='text']");
    By txtTurbineType = By.xpath("//input[contains(@id,'ddlTurbineType_radYALDropDownList_Input') and @type='text']");
    By ActiveCheckbox = By.xpath("//input[@id='chkActive']");
    By txtOperationalDate = By.xpath("//input[contains(@id,'DATE_OPERATIONAL_dateInput') and @type='text']");
    By txtComment = By.xpath("//textarea[@id='txtTUR_COMMENTS']");
    By btnAddNew = By.xpath("//input[contains(@id,'AddNew') and @type='image']");
    By SuccessMessage = By.xpath("//span[text()='Save successful']");
    By btnClose = By.xpath("//a[@class='rwCloseButton']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");

    By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
    public void ClickOnAddNewRecord() {
    	util.waitUntilElementDisplay(navTurbineDetails);
    	util.click(navTurbineDetails);
    	util.waitUntilElementDisplay(btnAddNewRecord);
    	util.click(btnAddNewRecord);	
    }
    
    public void SelectFinancialCategory(String value) {
    	util.switchToIframe(iframe);
    	util.waitUntilElementDisplay(drpFinancialCategory);;
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpFinancialCategory, value);
    }
    
    public void AddTurbineName(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTurbineName, value);
    }
    
    public void AddTurbineCapacity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTurbineCapacity, value);
    }
    
    public void AddTurbineType (String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTurbineType, value);
    }
    
    public void ClickOnActiveCheckbox() {
    	util.waitUntilElementDisplay(ActiveCheckbox);
    	util.click(ActiveCheckbox);
    }
    
    public void AddOperationalDate(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOperationalDate, value);
    }
    
    public void AddComment(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtComment, value);
    }
    
    public void ClickOnAddNewButton() {
    	util.waitUntilElementDisplay(btnAddNew);
    	util.click(btnAddNew);
    	util.waitUntilElementDisplay(SuccessMessage);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Save successful");
		util.switchToDefaultContent();
		util.dummyWait(2);
    }
    
    public void ClickOnCloseButton() {
    	util.waitUntilElementDisplay(btnClose);
    	util.click(btnClose);
    	util.dummyWait(3);
    	

    }
    
    By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
   By navPermanentInfrastructure = By.xpath("(//span[text()='Permanent Infrastructure'])[1]");
   public void NavigateToPermanentInfrastructure() {
       util.waitUntilElementDisplay(navParcel);
       util.click(navParcel);
       util.waitUntilElementDisplay(navParcelInfo);
       util.click(navParcelInfo);
       util.waitUntilElementDisplay(navPermanentInfrastructure);
       util.click(navPermanentInfrastructure);
       util.dummyWait(1);
   }
    
    public void AddTurbineRecord(Map<String, String> map, String testcaseName) {
    	
    	 try {
    		 util.waitUntilElementDisplay(firstParcel);
	    		util.click(firstParcel);
    		 ClickOnAddNewRecord();
	 			log("STEP 1: Popup Manage Turbine should be open", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1: Popup Manage Turbine does not open", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }
    	 
    	 if(environment.contains("RAMACO")) {
	    	 try {
	    		 SelectFinancialCategory(map.get("FinancialCategoryRamaco"));
	 			log("STEP 2: Selected value display in the Financial Category DD ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: selected value does not display in Financial Category DD. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
    	 }else {
    		 try {
	    		 SelectFinancialCategory(map.get(Excel.Category));
	 			log("STEP 2: Selected value display in the Financial Category DD ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 2: selected value does not display in Financial Category DD. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 2");
	 		 }
    	 }
    	 
	    	 try {
	    		 AddTurbineName(map.get(Excel.Name));
	    		log("STEP 3: Entered value should display in the Turbine Name field.", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 3: Entered value does not display in  Turbine Name field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 3");
	 		 }
	    	 
	    	 try {
	    		 AddTurbineCapacity(map.get(Excel.TurbineCapacity));
	 			log("STEP 4: Entered value should display in the Turbine Capacity MW field. ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 4: Entered value does not display in Turbine Capacity MW field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 4");
	 		 }

              try {
	    		 AddTurbineType(map.get(Excel.Type));
	 			log("STEP 5: Selected value display in the Turbine Type DD", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 5: selected value does not display in Turbine Type DD. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 5");
	 		 }
	    	 
	    	 try {
	    		 ClickOnActiveCheckbox();
	 			log("STEP 6: Active checkbox should be display checked ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 6: Active checkbox does not display checked ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 6");
	 		 }
	    	 
	    	 try {
	    		 AddOperationalDate(map.get(Excel.OperationalDate));
	 			log("STEP 7: selected Operational date should be display as selected ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 7: selected Operational date does not display as selected ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 7");
	 		 }
	    	 
	    	 try {
	    		 AddComment(map.get(Excel.Comment));
	 			log("STEP 8: Entered value should display in the Comments field. ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 8: Entered value does not display in Comments field. ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 8");
	 		 }
	    	 
	    	 try {
	    		 ClickOnAddNewButton();
	 			log("STEP 9: Save successful message should be display above the add new button ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 9: Save successful message does not display above the add new button  ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 9");
	 		 }
	    	 
	    	 try {
	    		 ClickOnCloseButton();
	 			log("STEP 10: Popup should close successfully ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 10:  popup does not close     ", Status.FAIL);
	 			throw new RuntimeException("Failed in step 10");
	 		 }
	    	 
	    	
	    	
    }
    
}
