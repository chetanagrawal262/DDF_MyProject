package pages.Negotiations;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EditLandInventoryPage extends BasePage{
	

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public EditLandInventoryPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navFreeAcquisitions = By.xpath("(//span[@class='rpExpandHandle'])[3]");
    By btnEdit = By.xpath("//input[contains(@id,'_ACQDIMENSIONS_radYALGridControl_ctl00_ctl04_EditButton') and @type='image']");
    By drpAcquisitionType = By.xpath("(//*[contains(@id,'EditFormControl_Acquisition_type_ID_RadDropDownTree1')])[1]");
	By txtAcquisitionType = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
	By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnSave') and @type='submit']");
 
	public void ClickOnFreeAcquisitions() {
  	    util.dummyWait(1);
     }
	
	public void ClickOnEditButton() {
		util.waitUntilElementDisplay(btnEdit);
  		util.click(btnEdit);
  		util.dummyWait(5);
	}
	
	public void SelectAcquisitionType(String value) {
  		util.waitUntilElementDisplay(drpAcquisitionType);
  		util.click(drpAcquisitionType);
  		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAcquisitionType, value);
  		util.pressDownkey();
  		util.pressDownkey();
  		util.pressENTERkey();
  		util.dummyWait(2);
  		
     }
	
	public void ClickOnUpdateButton() {
		util.waitUntilElementDisplay(btnUpdate);
  		util.click(btnUpdate);
	}
	
	public void EditLandInventory(Map<String, String> map, String testcaseName) {
		 
		 try {
			 ClickOnFreeAcquisitions();
			 util.dummyWait(2);
			 ClickOnEditButton();
				log("STEP 1: Record Grid should expands below  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: record does not expand below ", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}
		 util.dummyWait(5);	
		 try {
			 SelectAcquisitionType(map.get(Excel.AcquisitionType));
				log("STEP 2:  Selected value display in the Acquisition Type DD ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  selected value does not display in Acquisition Type DD. ", Status.FAIL);
				throw new RuntimeException("Failed in step 2 ");
			}
	
		 try {
			 ClickOnUpdateButton();
				log("STEP 3: record should be aded in a grid with all the details added  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:   all the entered information does not retain ", Status.FAIL);
				throw new RuntimeException("Failed in step 3 ");
			}
		 util.dummyWait(5);
		
	      
		 
    }
	
}
