package pages.Relocation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddRelocationOnFileRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AddRelocationOnFileRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	} 
	
	By btnAddNew = By.xpath("//input[@id='ctl00_ConPHRightTop_TRRE_UC_radPanels_i2_i0_NewRelo']");
    By iframe = By.xpath("//iframe[@name='RelocationWindow']");
    By txtCaseNumber = By.xpath("//input[contains(@id,'CASE_NUMBER') and @type='text']");
    By drpAssignedTo = By.xpath("//input[contains(@id,'Assignment_ID_YALComboBox_Input') and @type='text']");
    By txtName = By.xpath("//input[contains(@id,'NAME') and @type='text']");
    By drpRelocationType = By.xpath("//input[contains(@id,'RELOCATION_TYPE_radYALDropDownList_Input') and @type='text']");
    By drpRelocationEntity = By.xpath("//input[contains(@id,'RELOENTITY_radYALDropDownList_Input') and @type='text']");
    By txtCurrentAddress = By.xpath("//input[contains(@id,'CURRENT_ADDRESS') and @type='text']");
    By btnContinue = By.xpath("//input[contains(@id,'btnSave') and @type='image']");
    
   public void ClickOnAddNewButton() {
  	 util.waitUntilElementDisplay(btnAddNew);
  	 util.click(btnAddNew);
   }
   
   public void AddCaseNumber(String value) {
  	 util.switchToIframe(iframe);
	 util.dummyWait(2);
  	 if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCaseNumber, util.randomNumber());
   }
   
   public void SelectAssignedTo(String value) {
  	 if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAssignedTo,value);
   }
   
   public void AddName(String value) {
  	 if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtName,value);
   }
   
   public void SelectRelocationType(String value) {
  	 if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpRelocationType,value);
   }
   
   public void SelectRelocationEntity(String value) {
  	 if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpRelocationEntity,value);
   }
   
   public void AddCurrentAddress(String value) {
  	 if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCurrentAddress,value);
   }
   
   public void ClickOnContinue() {
  	util.waitUntilElementDisplay(btnContinue);
  	util.click(btnContinue);
  	util.switchToDefaultContent();
   }
   
   public void AddRelocationOnFileRecord(Map<String, String> map, String testcaseName) {
   	
     	 try {
     		     ClickOnAddNewButton();
  	 			log("STEP 1: Popup Start Relocation should be open ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 1: Popup Start Relocation does not open ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 1");
  	 		 }
     	 util.dummyWait(5);  	    	 
  	    	 try {
  	    		 AddCaseNumber(map.get(Excel.CaseNumber));
  	 			log("STEP 2: user can enter value in Case Number textbox. ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 2: user can not enter value in Case Number textbox. ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 2");
  	 		 }
  	    	 
  	    	 try {
  	    		 SelectAssignedTo(map.get(Excel.AssignedTo));
  	 			log("STEP 3: Selected value display in the assigned to DD ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 3: selected value does not display in assigned to DD. ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 3");
  	 		 }
  	    	 
  	    	 try {
  	    		 AddName(map.get(Excel.Name));
  	 			log("STEP 4:  user can enter value in Name textbox.", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 4:  user can not enter value in  Name textbox. ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 4");
  	 		 }
  	    	 
  	    	 try {
  	    		 AddCurrentAddress(map.get(Excel.CurrentAddress));
  	 			log("STEP 5: user can enter value in Current Address textbox. ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 5: user can not enter value in Current Address textbox. ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 5");
  	 		 }
  	    	 
  	    	 try {
  	    		 SelectRelocationType(map.get(Excel.RelocationType));
  	 			log("STEP 6: Selected value display in the Relocation Type DD  ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 6: selected value does not display in Relocation Type DD.  ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 6");
  	 		 }
  	    	 
  	    	 try {
  	    		 SelectRelocationEntity(map.get(Excel.RelocationEntity));
  	 			log("STEP 7: Selected value display in the Relocation Entity DD ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 7: selected value does not display in Relocation Entity DD. ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 7");
  	 		 }
  	    	 
  	    	 try {
  	    		 ClickOnContinue();
  	 			log("STEP 10: Newly added record should be display on \"Relocation Information\" Grid ", Status.PASS);
  	 		 } catch (Exception e) {
  	 			log("STEP 10: Newly added record should not be display on \"Relocation Information\" Grid   ", Status.FAIL);
  	 			throw new RuntimeException("Failed in step 10");
  	 		 }
  	 
   }
	
}
