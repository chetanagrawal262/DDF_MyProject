package pages.CustomControl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class CustomControl_MASKEDTEXTBOXFiledPage  extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public CustomControl_MASKEDTEXTBOXFiledPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By IconManageFiled = By.xpath("(//span[contains(@id,'ManageAddFieldsID')])[1]");
    By btnAddNewRecord = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[1]");
    By txtFieldName = By.xpath("//input[contains(@id,'editcc_Field_Name') and @type='text']");
    By drpFieldType = By.xpath("//input[contains(@id,'editcc_Field_Type_ID_radYALDropDownList_Input') and @type='text']");
    By txtDropdownCategory = By.xpath("//input[contains(@id,'editcc_Field_Type_Value') and @type='text']");
    By txtDisplayOrder = By.xpath("//input[contains(@id,'editcc_Display_Order') and @type='text']");
    By txtNoOfColumn = By.xpath("//input[contains(@id,'editcc_No_of_Columns') and @type='text']");
    By txtMaxLengthValue = By.xpath("//input[contains(@id,'editcc_Max_Length_Value') and @type='text']");
    By txtDefaultValue = By.xpath("//textarea[contains(@id,'editcc_txtDefaultValue')]");
    By txtHeight = By.xpath("//input[contains(@id,'editcc_radHeight') and @type='text']");
    By txtPrefix = By.xpath("//input[contains(@id,'editcc_Prefix_Text') and @type='text']");
    By txtDisplayName = By.xpath("//textarea[contains(@id,'editcc_Display_Name')]");
    By txtComment = By.xpath("//textarea[contains(@id,'editcc_COMMENTS')]");
    By txtToolTip = By.xpath("//textarea[contains(@id,'editcc_ToolTip')]");
    By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
    By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
    By NewField = By.xpath("//textarea[@id='idMngCustmAdnlFields_customFields2_196']");
    By btnEdit = By.xpath("(//input[contains(@id,'EditButton')])[last()]");
    By RequirdCheckbox = By.xpath("//input[@id='Required']");
    By btnUpdate = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate')]");
    By btnSave = By.xpath("//input[contains(@id,'TractType_btnInternalSave')]");
	By FieldValidation = By.xpath("//input[contains(@id,'idMngCustmAdnlFields') and @title='ToolTip' and @value='M_sk']");
    
	
	public void NavigateToParcelInformation() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navParcelInformation);
    	util.click(navParcelInformation);
    }
    
    
    public void TurnOnDesignCode() {
    	util.waitUntilElementDisplay(btnDesignMode);
    	util.click(btnDesignMode);
    	util.dummyWait(2);
    }
    
    public void ClickOnAddNewRecord() {
    	util.waitUntilElementDisplay(btnAddNewRecord);
    	util.click(btnAddNewRecord);
    	util.dummyWait(1);
    }
    
    public void AddFieldName(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtFieldName, value);
    }
    
    public void SelectFieldType(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpFieldType, value);
    }
    
    public void AddDropdownCategory(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDropdownCategory, value);
    }
    
    public void AddDisplayOrder(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDisplayOrder, value);
    }
    
    public void AddNoOfColumn(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtNoOfColumn, value);
    }
    
    By txtMask = By.xpath("//input[contains(@id,'rtbMask') and @type='text']");
    public void AddMask(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtMask, value);
    }
    public void AddMaxLengthValue(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtMaxLengthValue, value);
    }
    
    public void AddDefaultValue(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDefaultValue, value);
    }
    
    
    public void ClickOnDefaultValue() {
    	util.waitUntilElementDisplay(txtDefaultValue);
    	util.click(txtDefaultValue);
    }
    
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    	util.dummyWait(1);
    }
    
    public void AddHeight(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtHeight, value);
    }
    
    public void AddPrefix(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtPrefix, value);
    }
    
    public void AddDisplayName(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDisplayName, value);
    }
    
    public void AddComment(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtComment, value);
    }
    
    public void AddToolTip(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtToolTip, value);
    }
    
    public void ClickOnInsertButton() {
    	util.waitUntilElementDisplay(btnInsert);
    	util.click(btnInsert);
    	util.dummyWait(1);
    }
    
    public void ClickOnIconManageFiled() {
    	util.waitUntilElementDisplay(IconManageFiled);
    	util.click(IconManageFiled);
    	util.dummyWait(2);
    }
    
    By btnSaveHeader = By.xpath("//input[contains(@id,'btnSaveHeader')]");
    By btnPublish = By.xpath("//input[contains(@id,'PublishViews')]");
    By Message = By.xpath("//span[text()='Views have been published successfully.']");
    public void ClickOnSaveHeader() {
    	util.waitUntilElementDisplay(btnSaveHeader);
    	util.click(btnSaveHeader);
    }
    
    public void ClickOnPublish() {
    	util.waitUntilElementDisplay(btnPublish);
    	util.click(btnPublish);
    	util.dummyWait(1);
    }
    
    By btnOk = By.xpath("//span[text()='OK']");
    public void ClickOnOK() {
    	util.waitUntilElementDisplay(btnOk);
    	util.click(btnOk);
    }
    
    
    
public void CustomControl(Map<String, String> map, String testcaseName) throws InterruptedException {


	  
	    try {
			 By customIcon = By.xpath("//a[@title='Manage custom field(s)' and contains(@href,'"+map.get(Excel.Type)+"')] | //span[@title='Manage custom field(s)' and contains(@onclick,'"+map.get(Excel.Type)+"')]");
			util.click(customIcon);
			log("STEP 3:  user can able to click on the custom control icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  user cannot click on the custom control icon  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
	    	
	    Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		Iterator<String> itererator = windowId.iterator();
		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();
		driver.switchTo().window(newAdwinID);
		util.dummyWait(1);
    	
		
		By FieldName = By.xpath("//*[contains(@id,'idMngCustmAdnlFields_')]/td[text()='" +map.get(Excel.FieldName)+ "']");
		By FieldNameOnParcelInfo = By.xpath("//span[text()='" +map.get(Excel.DisplayName)+ "']");
		
		try {
		if(!util.isElementVisible(FieldName)) {
    	try {
			ClickOnAddNewRecord();
			log("STEP 4: user can able to click on the add new record (+)", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: user can not able to click on the add new record (+) ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			AddFieldName(map.get(Excel.FieldName));
			log("STEP 5: user can able to enter text in the \"field name \" field     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user not able to enter text in the \"field name \" field     ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			SelectFieldType(map.get(Excel.FieldType));
			log("STEP 6: user can able to select the value MASKEDTEXTBOX from field type dd ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: user can not able to select the value MASKEDTEXTBOX  from field type dd ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		
		try {
			AddDisplayOrder(map.get(Excel.DisplayOrder));
			log("STEP 7: user can able to enter value in Display order field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user can not able to enter value in Display order field ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			AddNoOfColumn(map.get(Excel.Column));
			log("STEP 8:  user can able to enter value in # of column field", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user cannot able to enter value in # of column field ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			AddMask(map.get(Excel.Mask));
			log("STEP 9: user can able to enter text/value in Mask field   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot able to enter text/value in Mask field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			AddPrefix(map.get(Excel.Prefix));
			log("STEP 10: user can able to enter value in Prefix field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user cannot able to enter value in Prefix field ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			AddDisplayName(map.get(Excel.DisplayName));
			log("STEP 11: user can able to enter value in Display Name field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot able to enter value in Display Name field ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		
		try {
			AddComment(map.get(Excel.Comment));
			log("STEP 12: user can able to enter value in Comment field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  user cannot able to enter value in Comment field ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			AddToolTip(map.get(Excel.ToolTip));
			log("STEP 13: user can able to enter value in ToolTip field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13:  user cannot able to enter value in ToolTip field   ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		
		try {
			ClickOnInsertButton();
			log("STEP 14: user can able to click on insert button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user cannot able to click on insert button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		

		if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 15 : 'Changes saved successfully!' message is display  ", Status.PASS);
			} else {
			   log("STEP 15: Changes saved successfully!' message does notdisplay ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 15 ");
	   	} 
		

		if (util.isElementPresent(FieldValidation)) {
			   log("STEP 16 : user can able to see custom  field of type 'MASKEDTEXTBOX' on preview   ", Status.PASS);
			} else {
			   log("STEP 16: user cannot able to see custom field of type 'MASKEDTEXTBOX'  on preview    ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 16 ");
	   	} 
		
		try {
			ClickOnSaveHeader();
			log("STEP 17: user can able to click on Save Header button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user cannot able to click on Save Header button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
		try {
			ClickOnPublish();
			log("STEP 18: user can able to click on Publish button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: user cannot able to click on Publish button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		
		if (util.isElementPresent(Message)) {
			   log("STEP 19 : 'Views have been published successfully. message is display  ", Status.PASS);
			} else {
			   log("STEP 19: Views have been published successfully. message does notdisplay ", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 19");
	   	} 
		
		}else {
			 log("STEP 4: Custom control field is already added ", Status.PASS);
		}
	
		}finally {
	util.dummyWait(1);
	driver.close();
	driver.switchTo().window(mainWinID);
		}
	
	try {
		By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
		util.waitUntilElementDisplay(firstParcel);
		util.click(firstParcel);
		util.dummyWait(10);
		log("STEP 20: user can able to navigate Parcel details page  ", Status.PASS);
	} catch (Exception e) {
		log("STEP 20: user can not navigate to Parcel details page ", Status.FAIL);
		throw new RuntimeException("Failed in step 20");
	}
	     
		try {
			Assert.assertTrue(util.isElementVisible(FieldNameOnParcelInfo));
			log("STEP 21: Added custom control field is dispaly on Parcel information page", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 21:  Added custom control field does not dispaly on Parcel information page", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}

		

		
		
		
 }	
	
}
