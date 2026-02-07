package pages.CustomControl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class CustomControl_LTEXTPage  extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;
//	By FieldValidation2;

	public CustomControl_LTEXTPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By IconManageFiled = By.xpath("(//span[contains(@id,'ManageAddFieldsID')])[1]");
	By Icon = By.xpath("//span[contains(@onclick,'TRACTTYPEDATA') and @title='Manage custom field(s)']");
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
    By btnSaveHeader = By.xpath("//input[contains(@id,'btnSaveHeader')]");
    By btnPublish = By.xpath("//input[contains(@id,'PublishViews')]");
    By Message = By.xpath("//span[text()='Views have been published successfully.']");
    By RequiredMessage = By.xpath("//span[text()='Information Needed!']");
    
    
    
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
    
    public void RemoveDisplayName() {
//    	WebElement web = driver.findElement(By.xpath("//textarea[contains(@id,'editcc_Display_Name')]"));
//    	Actions act = new Actions(driver);
//    	act.doubleClick(web);
    	util.click(txtDisplayName);
    	util.click(txtDisplayName);
    	for(int i=0;i<=12;i++) {
    	util.pressBackspace();
    	}
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
    
    public void UpdateValue(String value) {
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
    
   By FieldValidation = By.xpath("//span[contains(text(),'FieldName')]");

    public void CustomControl(Map<String, String> map, String testcaseName) {
		try {
			NavigateToParcelInformation();
			commonFunction.projectSelection();
			log("STEP 1:  user can able to navigate to parcel details page  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  user not able to navigate to parcel details page ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			TurnOnDesignCode();
			log("STEP 2:  user can able to click on the design mode icon     ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: user not able to click on the design mode icon ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
        
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
			if(!util.isElementVisible(FieldName)) {
				
				try {
			
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
				log("STEP 6: user can able to select the value \"LTEXT\"  from field type dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user can not able to select the value \"LTEXT\"  from field type dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			
//			try {
//				AddDropdownCategory(map.get(Excel.Category));
//				log("STEP 7: user can able to enter text in the drop down category field  ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 7: user can able to enter text in the drop down category field       ", Status.FAIL);
//				throw new RuntimeException("Failed in step 7");
//			}
			
			try {
				AddDisplayOrder(map.get(Excel.DisplayOrder));
				log("STEP 8: user can able to enter value in Display order field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user can not able to enter value in Display order field ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				AddNoOfColumn(map.get(Excel.Column));
				log("STEP 9:  user can able to enter value in # of column field", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: user cannot able to enter value in # of column field ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				AddMaxLengthValue(map.get(Excel.LengthValue));
				log("STEP 10: user can able to enter value in Max Length/Value field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: user cannot able to enter value in Max Length/Value field   ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
//			try {
//				AddDefaultValue(map.get(Excel.DefaultValue));
//				log("STEP 11:  user can able to enter text in default  value field ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 11:  user can not able to enter text in default  value field  ", Status.FAIL);
//				throw new RuntimeException("Failed in step 11");
//			}
			
			try {
				AddHeight(map.get(Excel.Height));
				log("STEP 12:  user can able to enter value in Height field", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:  user cannot able to enter value in Height field ", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			
			try {
				AddPrefix(map.get(Excel.Prefix));
				log("STEP 13: user can able to enter value in Prefix field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: user cannot able to enter value in Prefix field ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				AddDisplayName(map.get(Excel.DisplayName));
				log("STEP 14: user can able to enter value in Display Name field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: user cannot able to enter value in Display Name field ", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			
			try {
				AddComment(map.get(Excel.Comment));
				log("STEP 15: user can able to enter value in Comment field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15:  user cannot able to enter value in Comment field ", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			try {
				AddToolTip(map.get(Excel.ToolTip));
				log("STEP 16: user can able to enter value in ToolTip field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16:  user cannot able to enter value in ToolTip field   ", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
			
			
			try {
				ClickOnInsertButton();
				log("STEP 17: user can able to click on insert button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 17: user cannot able to click on insert button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 18 : 'Changes saved successfully!' message is display  ", Status.PASS);
				} else {
				   log("STEP 18: Changes saved successfully!' message does notdisplay ", Status.FAIL);
		   	} 
			
			try {
				ClickOnSaveHeader();
				log("STEP 19: user can able to click on Save Header button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 19: user cannot able to click on Save Header button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
			
			try {
				ClickOnPublish();
				log("STEP 20: user can able to click on Publish button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 20: user cannot able to click on Publish button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}
			
			if (util.isElementPresent(Message)) {
				   log("STEP 21 : 'Views have been published successfully. message is display  ", Status.PASS);
				} else {
				   log("STEP 21: Views have been published successfully. message does notdisplay ", Status.FAIL);
		   	} 
		    
			 By FieldValidation1 = By.xpath("//span[contains(text(),'"+map.get(Excel.DisplayName)+"')]");
			if (util.isElementPresent(FieldValidation1)) {
				   log("STEP 21 :  Display name is correctly visible for the custom field    ", Status.PASS);
				} else {
				   log("STEP 21:  Display name not visible for the custom field " , Status.FAIL);
			      throw new RuntimeException("Faild in STEP 21 ");
		   	} 
			
			try {
				 By edit = By.xpath("//tr[contains(@id,'idMngCustmAdnlFields_GridDetails_radYALGridControl')]/.//*[text()='"+map.get(Excel.FieldName)+"']/..//*[@title='Edit']");
				util.click(edit);	
				util.waitFor(500);
				log("STEP 22: user can able to click on the edit icon  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 22: user cannot click on edit icon  ", Status.FAIL);
				throw new RuntimeException("Failed in step 22");
			}
			
			try {
				ClickOnRequirdCheckbox();
				log("STEP 23: user can able to select the required checkbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 23: user cannot select the required checkbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 23");
			}
			
			try {
				UpdateValue(map.get(Excel.UpdateToolTip));
				log("STEP 24: user can able to enter value in ToolTip field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 24:  user cannot able to enter value in ToolTip field   ", Status.FAIL);
				throw new RuntimeException("Failed in step 24");
			}

			try {
				RemoveDisplayName();
				log("STEP 25: user can able to enter value in ToolTip field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 25:  user cannot able to enter value in ToolTip field   ", Status.FAIL);
				throw new RuntimeException("Failed in step 25");
			}
			
			
			try {
				ClickOnUpdateButton();
				log("STEP 26: user can able to click on the update button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 26: user cannot able to click on the update button   ", Status.FAIL);
				throw new RuntimeException("Failed in step 26");
			}
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 27 : \"Changes saved successfully\" message display in green colour     ", Status.PASS);
				} else {
				   log("STEP 27: \"Changes saved successfully\" message not display in green colour" , Status.FAIL);
			      throw new RuntimeException("Faild in STEP 27 ");
		   	} 
			
			By FieldValidation2 = By.xpath("//span[contains(text(),'"+map.get(Excel.FieldName)+"')]");
			if (util.isElementPresent(FieldValidation2)) {
				   log("STEP 28 :  filed name will display for that custom field    ", Status.PASS);
				} else {
				   log("STEP 28:  filed name not displayed for that custom field " , Status.FAIL);
			      throw new RuntimeException("Faild in STEP 28 ");
		   	} 
			
				}finally {
			ExtentTestManager.infoWithScreenshot("Screenshot");
			util.dummyWait(1);
			driver.close();
			driver.switchTo().window(mainWinID);
			
				}
				
			try {
				By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
				util.waitUntilElementDisplay(firstParcel);
				util.click(firstParcel);
				util.dummyWait(10);
				log("STEP 29: user should be able to navigate Parcel details page       ", Status.PASS);
			} catch (Exception e) {
				log("STEP 29: user can not navigate to Parcel details page ", Status.FAIL);
				throw new RuntimeException("Failed in step 29");
			}
			
			try {
				ClickOnSaveButton();
				log("STEP 30: verify user cannot able to click on save button without  entering data in the requird field   as we have configured the field as required field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 30:  verify user can able to click on save button without  entering data in the requird field even though we  configured the field as required field", Status.FAIL);
				throw new RuntimeException("Failed in step 30");
			}
			
			if (util.isElementPresent(RequiredMessage)) {
				   log("STEP 31 : verify \"Required!\"  should be display on the field in red colour   ", Status.PASS);
				} else {
				   log("STEP 31: verify \"Required!\"  should not  be display on the field in red colour" , Status.FAIL);
			      throw new RuntimeException("Faild in STEP 31 ");
		   	} 
		    

			try {
				 By customIcon = By.xpath("//a[@title='Manage custom field(s)' and contains(@href,'"+map.get(Excel.Type)+"')] | //span[@title='Manage custom field(s)' and contains(@onclick,'"+map.get(Excel.Type)+"')]");
				util.click(customIcon);
				util.switchToChildWindow();
				log("STEP 32:  user can able to click on the custom control icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 32:  user cannot click on the custom control icon  ", Status.FAIL);
				throw new RuntimeException("Failed in step 32");
			}
			
			try {
			try {
				 By edit = By.xpath("//tr[contains(@id,'idMngCustmAdnlFields_GridDetails_radYALGridControl')]/.//*[text()='"+map.get(Excel.FieldName)+"']/..//*[@title='Edit']");
				util.click(edit);	
				util.waitFor(500);
				log("STEP 33: user can able to click on the edit icon  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 33: user cannot click on edit icon  ", Status.FAIL);
				throw new RuntimeException("Failed in step 33");
			}
			
			try {
				ClickOnRequirdCheckbox();
				log("STEP 34: user can able to select the required checkbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 34: user cannot select the required checkbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 34");
			}
			
			try {
				ClickOnUpdateButton();
				log("STEP 35: user can able to click on the update button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 35: user cannot able to click on the update button   ", Status.FAIL);
				throw new RuntimeException("Failed in step 35");
			}
		} finally {
			util.dummyWait(1);
			driver.close();
			driver.switchTo().window(mainWinID);

		}
			}else {
				log("STEP 4: Custum Control field is already added ", Status.PASS);
				driver.close();
				driver.switchTo().window(mainWinID);
			}
	
    }
    
    
}
