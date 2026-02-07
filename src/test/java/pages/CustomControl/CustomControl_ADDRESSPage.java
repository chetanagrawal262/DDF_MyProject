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

public class CustomControl_ADDRESSPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public CustomControl_ADDRESSPage(WebDriver driver) {
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
    
    
    By AddressLine1 = By.xpath("(//input[contains(@id,'Address_Line_1')])[1]");
    By AddressLine2 = By.xpath("(//input[contains(@id,'Address_Line_2')])[1]");
    By AddressLine3 = By.xpath("(//input[contains(@id,'Address_Line_3')])[1]");
    By City = By.xpath("(//input[contains(@id,'City')])[1]");
    By State = By.xpath("(//input[contains(@id,'STATE_ID_Input')])[1]");
    By Country = By.xpath("(//input[contains(@id,'COUNTY_ID_Input')])[1]");
    By ZipCode = By.xpath("(//input[contains(@id,'Zip_Code')])[1]");
    By ZipCode2 = By.xpath("(//input[contains(@id,'Zip_Code2')])[1]");
    By POBox = By.xpath("(//input[contains(@id,'PO_Box')])[1]");
	
    By AddressLine1DOT = By.xpath("(//input[contains(@id,'Address_Line_1')])[2]");
    By AddressLine2DOT = By.xpath("(//input[contains(@id,'Address_Line_2')])[2]");
    By AddressLine3DOT = By.xpath("(//input[contains(@id,'Address_Line_3')])[2]");
    By CityDOT = By.xpath("(//input[contains(@id,'City')])[2]");
    By StateDOT = By.xpath("(//input[contains(@id,'STATE_ID_Input')])[2]");
    By CountryDOT = By.xpath("(//input[contains(@id,'COUNTY_ID_Input')])[2]");
    By ZipCodeDOT = By.xpath("(//input[contains(@id,'Zip_Code')])[2]");
    By ZipCode2DOT = By.xpath("(//input[contains(@id,'Zip_Code2')])[2]");
    By POBoxDOT = By.xpath("(//input[contains(@id,'PO_Box')])[1]");
    
    public void ClickOnIconManageFiled() {
    	util.waitUntilElementDisplay(IconManageFiled);
    	util.click(IconManageFiled);
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
    
    public void AddMaxLengthValue(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtMaxLengthValue, value);
    }
    
    public void AddDefaultValue(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDefaultValue, value);
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
    
    public void ClickOnEditButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    	util.dummyWait(1);
    }
    
    public void ClickOnRequirdCheckbox() {
    	util.waitUntilElementDisplay(RequirdCheckbox);
    	util.click(RequirdCheckbox);
    	util.dummyWait(1);
    }
    
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    	util.dummyWait(1);
    }
    
    public void ClickOnSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    	util.dummyWait(1);
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
    
    
    public void AddAddressLine1(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(AddressLine1, value);
    }
    
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
    
    By btnOk = By.xpath("//span[text()='OK']");
    public void ClickOnOK() {
    	util.waitUntilElementDisplay(btnOk);
    	util.click(btnOk);
    }
    
    
    
    
    
    public void CustomControl(Map<String, String> map, String testcaseName) {
    
//    	try {
//    		NavigateToParcelInformation();
//    		commonFunction.projectSelection();
//			log("STEP 1:  user can navigate to parcel information", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 1:  user cannot navigate to parcel information ", Status.FAIL);
//			throw new RuntimeException("Failed in step 1");
//		}
//    	
//    	try {
//    		TurnOnDesignCode();
//			log("STEP 2:  user can turn on design mode", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 2:  user cannot turn on design mode ", Status.FAIL);
//			throw new RuntimeException("Failed in step 2");
//		}
		
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
		log("STEP 6: user can able to select the value \"ADDRESS\"  from field type dd ", Status.PASS);
	} catch (Exception e) {
		log("STEP 6: user can not able to select the value \"ADDRESS\"  from field type dd ", Status.FAIL);
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
		AddPrefix(map.get(Excel.Prefix));
		log("STEP 9: user can able to enter value in Prefix field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 9: user cannot able to enter value in Prefix field ", Status.FAIL);
		throw new RuntimeException("Failed in step 9");
	}
	
	try {
		AddDisplayName(map.get(Excel.DisplayName));
		log("STEP 10: user can able to enter value in Display Name field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 10: user cannot able to enter value in Display Name field ", Status.FAIL);
		throw new RuntimeException("Failed in step 10");
	}
	
	
	try {
		AddComment(map.get(Excel.Comment));
		log("STEP 11: user can able to enter value in Comment field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 11:  user cannot able to enter value in Comment field ", Status.FAIL);
		throw new RuntimeException("Failed in step 11");
	}
	
	try {
		AddToolTip(map.get(Excel.ToolTip));
		log("STEP 12: user can able to enter value in ToolTip field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 12:  user cannot able to enter value in ToolTip field   ", Status.FAIL);
		throw new RuntimeException("Failed in step 12");
	}
	
	
	try {
		ClickOnInsertButton();
		log("STEP 13: user can able to click on insert button ", Status.PASS);
	} catch (Exception e) {
		log("STEP 13: user cannot able to click on insert button  ", Status.FAIL);
		throw new RuntimeException("Failed in step 13");
	}
	
	
	if (util.isElementPresent(SuccessMessage)) {
		   log("STEP 14 : 'Changes saved successfully!' message is display  ", Status.PASS);
		} else {
		   log("STEP 14: Changes saved successfully!' message does notdisplay ", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 14 ");
   	} 
	
	if (util.isElementPresent(AddressLine1)) {
		   log("STEP 15 : user can able to see above added field under the preview on the same page   ", Status.PASS);
		} else {
		   log("STEP 15: user cannot able to see above added field under the preview on the same page ", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 15 ");
	} 
	
	
	
	if (util.isElementPresent(AddressLine2)) {
		   log("STEP 16 : user can able to see address line 2 field on the \"ADDRESS\" custom field on the preview      ", Status.PASS);
		} else {
		   log("STEP 16: user cannot  see address line 2 field on the \"ADDRESS\" custom field on the preview", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 16 ");
	} 
	
	if (util.isElementPresent(AddressLine3)) {
		   log("STEP 17 : user can able to see  address line 3 field on the \"ADDRESS\" custom field on the preview      ", Status.PASS);
		} else {
		   log("STEP 17: user cannot  see  address line 3 field on the \"ADDRESS\" custom field on the preview", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 17 ");
	} 
	
	if (util.isElementPresent(City)) {
		   log("STEP 18 : user can able to see City on the custom field of type 'ADDRESS'  under preview  ", Status.PASS);
		} else {
		   log("STEP 18: user cannot see City on the custom field of type 'ADDRESS'  under preview", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 18 ");
	}
	
	if (util.isElementPresent(State)) {
		   log("STEP 19 : user can able to see  state on the custom field of type 'ADDRESS'  under preview  ", Status.PASS);
		} else {
		   log("STEP 19: user cannot see state on the custom field of type 'ADDRESS'  under preview", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 19 ");
	}
	
	if(testcaseName.contains("ALT")||testcaseName.contains("ROW") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")||testcaseName.contains("TRA")) {
	
	if (util.isElementPresent(Country)) {
		   log("STEP 20 : user can able to see  Country on the custom field of type 'ADDRESS'  under preview  ", Status.PASS);
		} else {
		   log("STEP 20: user cannot see Country on the custom field of type 'ADDRESS'  under preview", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 20 ");
	}
	
}
	if (util.isElementPresent(ZipCode)) {
		   log("STEP 21 : user can able to see zip code field on the custum field of type 'ADDRESS' under preview    ", Status.PASS);
		} else {
		   log("STEP 21: user cannot see zip code field on the custum field of type 'ADDRESS' under preview  ", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 21 ");
	} 
	
	if (util.isElementPresent(ZipCode2)) {
		   log("STEP 22 : user can able to see  zip code 2 field on the custum field of type 'ADDRESS' under preview    ", Status.PASS);
		} else {
		   log("STEP 22: user cannot see  zip code 2 field on the custum field of type 'ADDRESS' under preview  ", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 22 ");
	} 
	
	if (util.isElementPresent(POBox)) {
		   log("STEP 23 : user can able to see POBOX field on the custum field of type 'ADDRESS' under preview    ", Status.PASS);
		} else {
		   log("STEP 23: user cannot see  POBOX field on the custum field of type 'ADDRESS' under preview  ", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 23 ");
	} 
	
	
	
	try {
		AddAddressLine1(map.get(Excel.AddressLine));
		log("STEP 24: user can able to enter text in the field like (Address line 1) ", Status.PASS);
	} catch (Exception e) {
		log("STEP 24: user cannot enter text in the field like (Address line 1)      ", Status.FAIL);
		throw new RuntimeException("Failed in step 24");
	}
	
	try {
		ClickOnSaveHeader();
		log("STEP 25: user can able to click on Save Header button ", Status.PASS);
	} catch (Exception e) {
		log("STEP 25: user cannot able to click on Save Header button  ", Status.FAIL);
		throw new RuntimeException("Failed in step 25");
	}
	
	try {
		ClickOnPublish();
		log("STEP 26: user can able to click on Publish button ", Status.PASS);
	} catch (Exception e) {
		log("STEP 26: user cannot able to click on Publish button  ", Status.FAIL);
		throw new RuntimeException("Failed in step 26");
	}
	
	if (util.isElementPresent(Message)) {
		   log("STEP 27 : 'Views have been published successfully. message is display  ", Status.PASS);
		} else {
		   log("STEP 27: Views have been published successfully. message does notdisplay ", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 27 ");
   	} 

		}else {
			 log("STEP 4: Custom control field is already added ", Status.PASS);
		}
	
	util.dummyWait(1);
	driver.close();
	driver.switchTo().window(mainWinID);
	util.dummyWait(2);
	
	try {
		driver.navigate().refresh();
//		NavigateToParcelInformation();
		log("STEP 28: user can able to navigate Parcel details page  ", Status.PASS);
	} catch (Exception e) {
		log("STEP 28: user can not navigate to Parcel details page ", Status.FAIL);
		throw new RuntimeException("Failed in step 28");
	}
	     
		try {
			Assert.assertTrue(util.isElementVisible(FieldNameOnParcelInfo));
			log("STEP 29: Added custom control field is dispaly on Parcel information page", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 29:  Added custom control field does not dispaly on Parcel information page", Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}
	
//		util.dummyWait(1);
//		try {
//			Set<String> windowId1 = driver.getWindowHandles(); // get window id of current window
//			Iterator<String> itererator1 = windowId1.iterator();
//			String mainWinID1 = itererator1.next();
//			String newAdwinID1 = itererator1.next();
//			driver.switchTo().window(newAdwinID1);
//			log("STEP 30:  user can able to switch on custom control page", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 30:  user cannot able to switch on custom control page ", Status.FAIL);
//			throw new RuntimeException("Failed in step 30");
//		}
//		
//	
//	try {
//		By delete = By.xpath("//*[text()='"+map.get(Excel.FieldName)+"']/..//*[@alt='Delete']");
//		util.click(delete);
//		log("STEP 31:  user can click on delete icon", Status.PASS);
//	} catch (Exception e) {
//		log("STEP 31:  user cannot click on delete icon ", Status.FAIL);
//		throw new RuntimeException("Failed in step 31");
//	}
//	
//	try {
//		util.dummyWait(1);
//    	util.waitUntilElementDisplay(btnOk);
//    	util.click(btnOk);
//		log("STEP 32:  user can click on ok button", Status.PASS);
//	} catch (Exception e) {
//		log("STEP 32:  user cannot click on ok button ", Status.FAIL);
//		throw new RuntimeException("Failed in step 32");
//	}	
//	util.reloadPage();
//	driver.close();
//	util.switchToParentWindow();
//	util.reloadPage();
//	if (!util.isElementVisible(AddressLine1)) {
//		   log("STEP 33 : user not able to see deleted ADDRESS Custom control field   ", Status.PASS);
//		} else {
//		   log("STEP 33 : user can able to see deleted ADDRESS Custom control field" , Status.FAIL);
//	      throw new RuntimeException("Faild in STEP 33");
//   	} 
	
	
	
	
	
  }
    
    
}
