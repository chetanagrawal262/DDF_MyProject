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

public class CustomControl_DependentDDFieldPage extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;
	String pValue1= "Parent_Value1";
	String pValue2= "Parent_Value2";
	String cValue1="Child_Value1";
	String cValue2="Child_Value2";
	

	public CustomControl_DependentDDFieldPage(WebDriver driver) {
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
    By txtDisplayNameParent = By.xpath("//textarea[contains(@id,'_EditFormControl_editcc_DisplayNameParent')]");
    By txtDisplayNameChild = By.xpath("//textarea[contains(@id,'_editcc_DisplayNameChild')]");
    By txtComment = By.xpath("//textarea[contains(@id,'editcc_COMMENTS')]");
    By txtToolTip = By.xpath("//textarea[contains(@id,'editcc_ToolTip')]");
    By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
    By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
    By NewField = By.xpath("//textarea[@id='idMngCustmAdnlFields_customFields2_196']");
    By btnEdit = By.xpath("(//input[contains(@id,'EditButton')])[last()]");
    By RequirdCheckbox = By.xpath("//input[@id='Required']");
    By btnUpdate = By.xpath("//input[contains(@id,'EditFormControl_btnUpdate')]");
    By btnSave = By.xpath("//input[contains(@id,'TractType_btnInternalSave')]");
    
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
    
    public void AddHeight(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtHeight, value);
    }
    
    public void AddPrefix(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtPrefix, value);
    }
    
    public void AddDisplayNameParent(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDisplayNameParent, value);
    }
    
    public void AddDisplayNameChild(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDisplayNameChild, value);
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
    
    By VerifyField = By.xpath("(//span[contains(@class,'rddtFakeInput rddtEmptyMessage')])[1]");
    By VerifyResult = By.xpath("(//span[contains(@class,'rtIn')])[1]");
    public void ClickOnField() {
    	util.waitUntilElementDisplay(VerifyField);
    	util.click(VerifyField);
    }
    
    public void SelectDefaultValue(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(VerifyField, value);
    }
    
    
    public void ClickOnDropDownConfiguration(By value) {
    	util.waitUntilElementDisplay(value);
    	util.click(value);
    }
    
    By ParentValue = By.xpath("//span[contains(text(),'Parent Values')]");
    By ChildValue = By.xpath("//span[contains(text(),'Child Values')]");
    By AddNewRecordLink = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[1]");
    By AddNewRecordLinkChild = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[2]");

    public void ClickOnParentValue() {
    	util.waitUntilElementDisplay(ParentValue);
    	util.click(ParentValue);
    	util.dummyWait(1);
    	
    }
    
    public void ClickOnChildValue() {
    	util.waitUntilElementDisplay(ChildValue);
    	util.click(ChildValue);
   
    }
    
    public void ClickOnAddNewRecordLink() {
    	util.waitUntilElementDisplay(AddNewRecordLink);
    	util.click(AddNewRecordLink);
    }
    
    public void ClickOnAddNewRecordLinkChild() {
    	util.waitUntilElementDisplay(AddNewRecordLinkChild);
    	util.click(AddNewRecordLinkChild);
    }
    
    By drpLookUpType = By.xpath("//input[contains(@id,'Lookup_Type_radYALDropDownList_Input')]");
    By DisplayOrder = By.xpath("(//input[contains(@id,'Lookup_Order')])[1]");
    By txtLookupDescription = By.xpath("(//textarea[contains(@id,'Lookup_Desc')])[1]");
    By txtShortDescription = By.xpath("(//textarea[contains(@id,'Short_Desc')])[1]");
    By DisplayName = By.xpath("(//textarea[contains(@id,'RadDisplayName')])[1]");
    By Insertbtn = By.xpath("(//input[contains(@id,'btnInsert')])[1]");
    
    public void SelectLookUpType(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(drpLookUpType, value);
    }
    
    public void DisplayOrder(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(DisplayOrder, value);
    }
    
    public void AddLookupDescription(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtLookupDescription, value);
    }
    
    public void AddShortDescription(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtShortDescription, value);
    }
    
    public void DisplayName(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(DisplayName, value);
    }
    
    public void ClickOnInsert() {
    util.waitUntilElementDisplay(Insertbtn);
    util.click(Insertbtn);
    }
    
    By LookupParentType = By.xpath("//input[contains(@id,'Parent_ID_radYALDropDownList_Input')]");
    By LookUpValue = By.xpath("(//input[contains(@id,'EditFormControl_Lookup_Value')])[1]");
    
    public void SelectParentType(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(LookupParentType, value);
    }
    
    public void SelectLookUpValue(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(LookUpValue, value);
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
    
    By btnSaveParcel = By.xpath("//input[contains(@id,'TractType_btnInternalSave')]");
    public void ClickOnSaveButton() {
    	util.waitUntilElementDisplay(btnSaveParcel);
    	util.click(btnSaveParcel);
    	util.dummyWait(1);
    }
    
    public void CustomControl(Map<String, String> map, String testcaseName) {
    	
    	
		
		try {
			 By customIcon = By.xpath("//a[@title='Manage custom field(s)' and contains(@href,'"+map.get(Excel.Type)+"')] | //span[@title='Manage custom field(s)' and contains(@onclick,'"+map.get(Excel.Type)+"')]");
			util.click(customIcon);
			util.switchToChildWindow();
			log("STEP 1:  user can able to click on the custom control icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  user cannot click on the custom control icon  ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
	
		By FieldName = By.xpath("//*[contains(@id,'idMngCustmAdnlFields_')]/td[text()='" +map.get(Excel.FieldName)+ "']");
		By ParentDDOnParcelInfo = By.xpath("//span[text()='" +map.get(Excel.DisplayName)+ "']");
		By ChildDDOnParcelInfo = By.xpath("//span[text()='" +map.get("DisplayName_Child")+ "']");
		
		try {
		if(!util.isElementVisible(FieldName)) {
    try {
		ClickOnAddNewRecord();
		log("STEP 2: user can able to click on the add new record (+)", Status.PASS);
	} catch (Exception e) {
		log("STEP 2: user can not able to click on the add new record (+) ", Status.FAIL);
		throw new RuntimeException("Failed in step 2");
	}
	
	try {
		AddFieldName(map.get(Excel.FieldName));
		log("STEP 3: user can able to enter text in the \"field name \" field     ", Status.PASS);
	} catch (Exception e) {
		log("STEP 3: user not able to enter text in the \"field name \" field     ", Status.FAIL);
		throw new RuntimeException("Failed in step 3");
	}
	
	try {
		SelectFieldType(map.get(Excel.FieldType));
		log("STEP 4: user can able to select the value \"DDTREE\"  from field type dd ", Status.PASS);
	} catch (Exception e) {
		log("STEP 4: user can not able to select the value \"DDTREE\"  from field type dd ", Status.FAIL);
		throw new RuntimeException("Failed in step 4");
	}
	
	try {
		AddDropdownCategory(map.get(Excel.Category));
		log("STEP 5: user can able to enter text in the drop down category field  ", Status.PASS);
	} catch (Exception e) {
		log("STEP 5: user can able to enter text in the drop down category field       ", Status.FAIL);
		throw new RuntimeException("Failed in step 5");
	}
	
	
	try {
		AddDisplayOrder(map.get(Excel.DisplayOrder));
		log("STEP 6: user can able to enter value in Display order field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 6: user can not able to enter value in Display order field ", Status.FAIL);
		throw new RuntimeException("Failed in step 6");
	}
	
	try {
		AddNoOfColumn(map.get(Excel.Column));
		log("STEP 7:  user can able to enter value in # of column field", Status.PASS);
	} catch (Exception e) {
		log("STEP 7: user cannot able to enter value in # of column field ", Status.FAIL);
		throw new RuntimeException("Failed in step 7");
	}
	
	try {
		AddPrefix(map.get(Excel.Prefix));
		log("STEP 8: user can able to enter value in Prefix field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 8: user cannot able to enter value in Prefix field ", Status.FAIL);
		throw new RuntimeException("Failed in step 8");
	}
	
	try {
		AddDisplayNameParent(map.get(Excel.DisplayName));
		log("STEP 9: user can able to enter value in Display Name - Parent field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 9: user cannot able to enter value in Display Name - Parent field ", Status.FAIL);
		throw new RuntimeException("Failed in step 9");
	}
	
	try {
		AddDisplayNameChild(map.get("DisplayName_Child"));
		log("STEP 10: user can able to enter value in Display Name - Child field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 10: user cannot able to enter value in Display Name - Child field ", Status.FAIL);
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
		   log("STEP 14: 'Changes saved successfully!' message does notdisplay ", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 14 ");
   	} 
	
	try {
		By ddConfiguration = By.xpath("(//span[text()='"+map.get(Excel.DisplayName)+"']/../../..//span[contains(@id,'_ManageComboID') and @title='ComboBox Configuration'])[1]");
		ClickOnDropDownConfiguration(ddConfiguration);
		util.switchToChildWindow1();
		log("STEP 15: user can able to click on dd config icon of the Parent DD", Status.PASS);
	} catch (Exception e) {
		log("STEP 15: user cannot able to click on dd config icon of the Parent DD ", Status.FAIL);
		throw new RuntimeException("Failed in step 15");
	}
	
	try {
	try {
		ClickOnParentValue();
		log("STEP 16:  user can able  to click on the Parent value tab   ", Status.PASS);
	} catch (Exception e) {
		log("STEP 16:  user cannot able  to click on the Parent value tab    ", Status.FAIL);
		throw new RuntimeException("Failed in step 16");
	}
	
	try {
		ClickOnAddNewRecordLink();
		log("STEP 17:  user can able to click on the add new record (+)  ", Status.PASS);
	} catch (Exception e) {
		log("STEP 17:  user cannot able to click on the add new record (+)    ", Status.FAIL);
		throw new RuntimeException("Failed in step 17");
	}
	
	try {
		AddLookupDescription(pValue1);
		log("STEP 18: user can able to enter the text in the lookup description field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 18: user cannot able to enter the text in the lookup description field ", Status.FAIL);
		throw new RuntimeException("Failed in step 18");
	}
	
	try {
		ClickOnInsert();
		log("STEP 19: user can able to click on insert button ", Status.PASS);
	} catch (Exception e) {
		log("STEP 19:  user cannot click on insert button   ", Status.FAIL);
		throw new RuntimeException("Failed in step 19");
	}
	
	try {
		ClickOnAddNewRecordLink();
		log("STEP 20:  user can able to click on the add new record (+)  ", Status.PASS);
	} catch (Exception e) {
		log("STEP 20:  user cannot able to click on the add new record (+)    ", Status.FAIL);
		throw new RuntimeException("Failed in step 20");
	}
	
	try {
		AddLookupDescription(pValue2);
		log("STEP 21: user can able to enter the text in the lookup description field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 21: user cannot able to enter the text in the lookup description field ", Status.FAIL);
		throw new RuntimeException("Failed in step 21");
	}
	
	try {
		ClickOnInsert();
		log("STEP 22: user can able to click on insert button ", Status.PASS);
	} catch (Exception e) {
		log("STEP 22:  user cannot click on insert button   ", Status.FAIL);
		throw new RuntimeException("Failed in step 22");
	}
	try {
		ClickOnChildValue();
		log("STEP 23: user can able  to click on the child value tab", Status.PASS);
	} catch (Exception e) {
		log("STEP 23: user cannot able  to click on the child value tab", Status.FAIL);
		throw new RuntimeException("Failed in step 23");
	}
	
	try {
		ClickOnAddNewRecordLinkChild();
		log("STEP 24: user can able to click on the add new record (+) 2)Empty fields gets open   ", Status.PASS);
	} catch (Exception e) {
		log("STEP 24: user cannot able to click on the add new record (+) 2)Empty fields gets open   ", Status.FAIL);
		throw new RuntimeException("Failed in step 24");
	}
	
	try {
		SelectParentType(pValue1);
		log("STEP 25: user  can able to select the value from lookup parent type dd ", Status.PASS);
	} catch (Exception e) {
		log("STEP 25: user  cannot select the value from lookup parent type dd  ", Status.FAIL);
		throw new RuntimeException("Failed in step 25");
	}
	
	try {
		AddLookupDescription(cValue1);
		log("STEP 26: user can able to enter the text in the lookup description field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 26: user cannot able to enter the text in the lookup description field ", Status.FAIL);
		throw new RuntimeException("Failed in step 26");
	}
	
	try {
		ClickOnInsert();
		log("STEP 27: user can able to click on insert button ", Status.PASS);
	} catch (Exception e) {
		log("STEP 27:  user cannot click on insert button   ", Status.FAIL);
		throw new RuntimeException("Failed in step 27");
	}
	
	try {
		ClickOnAddNewRecordLinkChild();
		log("STEP 28: user can able to click on the add new record (+) 2)Empty fields gets open   ", Status.PASS);
	} catch (Exception e) {
		log("STEP 28: user cannot able to click on the add new record (+) 2)Empty fields gets open   ", Status.FAIL);
		throw new RuntimeException("Failed in step 28");
	}
	
	try {
		SelectParentType(pValue2);
		log("STEP 29: user  can able to select the value from lookup parent type dd ", Status.PASS);
	} catch (Exception e) {
		log("STEP 29: user  cannot select the value from lookup parent type dd  ", Status.FAIL);
		throw new RuntimeException("Failed in step 29");
	}
	
	try {
		AddLookupDescription(cValue2);
		log("STEP 30: user can able to enter the text in the lookup description field ", Status.PASS);
	} catch (Exception e) {
		log("STEP 30: user cannot able to enter the text in the lookup description field ", Status.FAIL);
		throw new RuntimeException("Failed in step 30");
	}
	
	try {
		ClickOnInsert();
		log("STEP 31: user can able to click on insert button ", Status.PASS);
	} catch (Exception e) {
		log("STEP 31:  user cannot click on insert button   ", Status.FAIL);
		throw new RuntimeException("Failed in step 31");
	}
	}finally {
	util.dummyWait(1);
	driver.close();
	util.switchToChildWindow();
	util.dummyWait(2);
	}
	
	try {
		ClickOnSaveHeader();
		log("STEP 32: user can able to click on Save Header button ", Status.PASS);
	} catch (Exception e) {
		log("STEP 32: user cannot able to click on Save Header button  ", Status.FAIL);
		throw new RuntimeException("Failed in step 32");
	}
	
	try {
		ClickOnPublish();
		log("STEP 33: user can able to click on Publish button ", Status.PASS);
	} catch (Exception e) {
		log("STEP 33: user cannot able to click on Publish button  ", Status.FAIL);
		throw new RuntimeException("Failed in step 33");
	}
	
	if (util.isElementPresent(Message)) {
		   log("STEP 34 : 'Views have been published successfully. message is display  ", Status.PASS);
		} else {
		   log("STEP 34: Views have been published successfully. message does notdisplay ", Status.FAIL);
	      throw new RuntimeException("Faild in STEP 34 ");
   	} 

	util.dummyWait(2);
	util.reloadPage();
	util.dummyWait(1);
	
		}else {
			 log("STEP 4: Custom control field is already added ", Status.PASS);
		}
		}finally {
		util.dummyWait(1);
		driver.close();
		util.switchToParentWindow();
		util.dummyWait(2);
		}
		
		try {
			By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
			util.waitUntilElementDisplay(firstParcel);
			util.click(firstParcel);
			util.dummyWait(10);
			log("STEP 35: user can able to navigate Parcel details page  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 35: user can not navigate to Parcel details page ", Status.FAIL);
			throw new RuntimeException("Failed in step 35");
		}
		     
			try {
				Assert.assertTrue(util.isElementVisible(ParentDDOnParcelInfo));
				log("STEP 36: Parent DD field is dispaly on Parcel information page", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 36:  Parent DD field does not dispaly on Parcel information page", Status.FAIL);
			}
	
			try {
				Assert.assertTrue(util.isElementVisible(ChildDDOnParcelInfo));
				log("STEP 37: Child DD field is dispaly on Parcel information page", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 37:  Child DD field does not dispaly on Parcel information page", Status.FAIL);
			}
	
			try {
				By selectParentValue = By.xpath("(//span[text()='" +map.get(Excel.DisplayName)+ "']/../../..//input[@type='text'])[1]");
				util.inputTextAndPressTab(selectParentValue, pValue1);
				util.dummyWait(2);
				log("STEP 38: User can select Parent value from the dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 38:  User cannot select Parent value from the dd", Status.FAIL);
				throw new RuntimeException("Failed in step 38");
			}

			try {
				By selectChildValue = By.xpath("(//span[text()='" +map.get(Excel.DisplayName)+ "']/../../..//input[@type='text'])[2]");
				util.inputTextAndPressTab(selectChildValue, cValue1);
				util.dummyWait(2);
				log("STEP 39: User can select Child value from the dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 39:  User cannot select Child value from the dd", Status.FAIL);
				throw new RuntimeException("Failed in step 39");
			}
	
			try {
				ClickOnSaveButton();
				log("STEP 40: User can click on save button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 40:  User cannot click on save button", Status.FAIL);
				throw new RuntimeException("Failed in step 40");
			}
	
			try {
				By parentDDValue = By.xpath("(//span[text()='" +map.get(Excel.DisplayName)+ "']/../../..//input[@type='text' and @value='"+pValue1+"'])[1]");
				Assert.assertTrue(util.isElementVisible(parentDDValue));
				log("STEP 41: User can see saved value in Parent dd", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 41:  User cannot see saved value in Parent dd", Status.FAIL);
			}

			try {
				By childDDValue = By.xpath("(//span[text()='" +map.get(Excel.DisplayName)+ "']/../../..//input[@type='text' and @value='"+cValue1+"'])[1]");
				Assert.assertTrue(util.isElementVisible(childDDValue));
				log("STEP 42: User can see saved value in Child dd", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 42:  User cannot see saved value in Child dd", Status.FAIL);
			}
			
  }
    
}
