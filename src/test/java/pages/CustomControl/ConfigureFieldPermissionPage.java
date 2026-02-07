package pages.CustomControl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ConfigureFieldPermissionPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public ConfigureFieldPermissionPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By ConfigureFieldPermissionLink = By.xpath("//a[contains(text(),'Configure Field Permissions')]");
	By Iframe = By.xpath("//iframe[@name='rwCC_Permissions']");
	By drpRole = By.xpath("//input[contains(@id,'ddROLES_Input')]");
	By ReadPermission = By.xpath("//*[@id=\"radAdminMenu1\"]//*[text()='ADDRESS']/..//input[@type='radio' and @value='R']");
	//By ReadPermission = By.xpath("(//input[contains(@id,'radAdminMenu1') and @value='R'])[1]");
	//By WritePermission = By.xpath("(//input[contains(@id,'radAdminMenu1') and @value='W'])[1]");
	By WritePermission=By.xpath("//*[@id=\"radAdminMenu1\"]//*[text()='ADDRESS']/..//input[@type='radio' and @value='W']");
	//By NPermission = By.xpath("(//input[contains(@id,'radAdminMenu1') and @value='N'])[1]");
	By NPermission = By.xpath("//*[@id=\"radAdminMenu1\"]//*[text()='ADDRESS']/..//input[@type='radio' and @value='N']");
	By btnClose = By.xpath("//a[@title='Close']");
	By IconManageFiled = By.xpath("(//span[contains(@id,'ManageAddFieldsID')])[1]");
    By btnSavePermission = By.xpath("//input[contains(@id,'savePermissions')]");
	By txtAddress = By.xpath("(//input[contains(@id,'Address_Line_1')])[1]");
	By SuccessMessage = By.xpath("//span[contains(text(),'Changes Saved Successfully')]");
    By Message = By.xpath("//span[text()='Changes saved successfully!']");

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
    
    By AddrField= By.xpath("//div[@class='rtIn']//span[text()='ADDRESS']");
    
    
	public void ClickOnIconManageFiled() {
		util.waitUntilElementDisplay(IconManageFiled);
		util.click(IconManageFiled);
		util.dummyWait(1);
	}
	
	public void NavigateToParcelInformation() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navParcelInformation);
    	util.click(navParcelInformation);
    }
    By btnAddNewRecord = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[1]");

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

	
	public void ClickOnConfigureFieldPermissionLink() {
		util.waitUntilElementDisplay(ConfigureFieldPermissionLink);
		util.click(ConfigureFieldPermissionLink);
		util.switchToIframe(Iframe);
		util.dummyWait(1);
	}
	
	public void SelectRole(String value) {
		util.waitUntilElementDisplay(drpRole);
		util.selectValueFromDropdown(drpRole, value);
		util.dummyWait(2);
	}
	
	public void SelecteWritePermission() {
		util.waitUntilElementDisplay(ReadPermission);
		util.click(ReadPermission);
		util.click(WritePermission);
		util.dummyWait(1);
	}
	
	public void SelecteReadPermission() {
		util.waitUntilElementDisplay(ReadPermission);
		util.click(ReadPermission);
		util.dummyWait(1);
	}
	
	public void SelecteNPermission() {
		util.waitUntilElementDisplay(NPermission);
		util.click(NPermission);
		util.dummyWait(1);
	}
	
	public void ClickOnSavePermission() {
		util.waitUntilElementDisplay(btnSavePermission);
		util.click(btnSavePermission);
	}
	
	public void ClickOnClose() {
		util.switchToDefaultContent();
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
	}
	
	 public void AddAddressLine1(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtAddress, value);
	    }
	
		By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");

	 public void TurnOnDesignCode() {
	    	util.waitUntilElementDisplay(btnDesignMode);
	    	util.click(btnDesignMode);
	    	util.dummyWait(2);
	    }
	    By FieldValidation = By.xpath("(//td[@style='border-color:Black;border-width:1px;border-style:Solid;width:120px;'])[1]");
	  
	    public void ReadOnlyField()
	    {
	    	WebElement AddressFieldRO=driver.findElement(txtAddress);
	    	boolean ReadOnly= !AddressFieldRO.isEnabled();
	       if(ReadOnly==false) {
	    	  System.out.println("Element is Read Only");
	       }
	        
	    }
	    By btnOk = By.xpath("//span[text()='OK']");
	    By AddressLine1 = By.xpath("(//input[contains(@id,'Address_Line_1')])[1]");
	    
	    public void ConfigureFieldPermission(Map<String, String> map, String testcaseName) {
		   
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
			 try {
					ClickOnAddNewRecord();
					log("STEP 4: user can able to click on the add new record (+)", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: user can not able to click on the add new record (+) ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
				
				try {
					AddFieldName(map.get(Excel.FieldName1));
					log("STEP 5: user can able to enter text in the \"field name \" field     ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: user not able to enter text in the \"field name \" field     ", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
				
				try {
					SelectFieldType(map.get(Excel.FieldType1));
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
					AddDisplayName(map.get(Excel.DisplayName2));
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
			
				if (util.isElementPresent(Message)) {
					   log("STEP 14 : 'Changes saved successfully!' message is display  ", Status.PASS);
					} else {
					   log("STEP 14: Changes saved successfully!' message does notdisplay ", Status.FAIL);
				      throw new RuntimeException("Faild in STEP 14 ");
			   	} 
				
				
			try {
				ClickOnConfigureFieldPermissionLink();
				log("STEP 15:  user can able to click on the \"Configured field permission\" link 2) pop up gets open    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15:  user cannot  able to click on the \"Configured field permission\" link 2) pop up does not gets open        ", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}

			try {
				SelectRole(map.get(Excel.Roles));
				log("STEP 16:  user can able to select administartion role from dd    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16: user not able select administartion role from dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
			
			try {
				SelecteWritePermission();
				log("STEP 17:  user can able to select the W radio button for the above added custom control field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 17:  user can not able to select the W radio button for the above added custom control field        ", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			
			
			
			try {
				ClickOnSavePermission();
				log("STEP 18: user can able to click on the save permission button", Status.PASS);
			} catch (Exception e) {
				log("STEP 18:  user cannot able to click on the save permission button ", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 19 : 'Changes saved successfully!' message is display  ", Status.PASS);
				} else {
				   log("STEP 19: Changes saved successfully!' message does notdisplay ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 19 ");
		   	} 
			
			try {
				ClickOnClose();
				log("STEP 20: user can able to click on the (X) 2) pop  up gets close      ", Status.PASS);
			} catch (Exception e) {
				log("STEP 20: user cannot able to click on the (X) 2) pop  updoes not gets close     ", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}
			
			util.reloadPage();
			util.dummyWait(2);
			
			if (util.isElementPresent(txtAddress)) {
				   log("STEP 21 : user can able to add text in the filed for which W permission is set  ", Status.PASS);
				} else {
				   log("STEP 21: user cannot able to add text in the filed for which W permission is set ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 21");
		   	} 
			
			util.dummyWait(2);
			try {
				AddAddressLine1(map.get(Excel.AddressLine1));
				log("STEP 22: user can able to add text in the filed for which W permission is set ", Status.PASS);
			} catch (Exception e) {
				log("STEP 22: user can able to add text in the filed for which W permission is set  ", Status.FAIL);
				throw new RuntimeException("Failed in step 22");
			}
			
			
			try {
				ClickOnConfigureFieldPermissionLink();
				log("STEP 23:  user can able to click on the \"Configured field permission\" link 2) pop up gets open    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 23:  user cannot  able to click on the \"Configured field permission\" link 2) pop up does not gets open        ", Status.FAIL);
				throw new RuntimeException("Failed in step 23");
			}

			try {
				SelectRole(map.get(Excel.Roles));
				log("STEP 24:  user can able to select administartion role from dd    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 24: user not able select administartion role from dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 24");
			}
			
			try {
				SelecteReadPermission();
				log("STEP 25:  user can able to select the R radio button for the above added custom control field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 25:  user can not able to select the R radio button for the above added custom control field        ", Status.FAIL);
				throw new RuntimeException("Failed in step 25");
			}
						
			try {
				ClickOnSavePermission();
				log("STEP 26: user can able to click on the save permission button", Status.PASS);
			} catch (Exception e) {
				log("STEP 26:  user cannot able to click on the save permission button ", Status.FAIL);
				throw new RuntimeException("Failed in step 26");
			}
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 27 : 'Changes saved successfully!' message is display  ", Status.PASS);
				} else {
				   log("STEP 27: Changes saved successfully!' message does notdisplay ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 27");
		   	} 
			
			try {
				ClickOnClose();
				log("STEP 28: user can able to click on the (X) 2) pop  up gets close      ", Status.PASS);
			} catch (Exception e) {
				log("STEP 28: user cannot able to click on the (X) 2) pop  updoes not gets close     ", Status.FAIL);
				throw new RuntimeException("Failed in step 28");
			}
			util.reloadPage();
			util.dummyWait(2);
			
			if (util.isElementPresent(txtAddress)) {
				   log("STEP 29 : user can able to see Address field ", Status.PASS);
				} else {
				   log("STEP 29: user cannot able to see Address field ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 29 ");
		   	} 
			util.dummyWait(1);
			
			WebElement AddressFieldRO=driver.findElement(txtAddress);
	    	boolean ReadOnly= !AddressFieldRO.isEnabled();
	    	if(ReadOnly=true) {
			//AddAddressLine1(map.get(Excel.AddressLine1));
	    
 			log("STEP 30: user can not able to add text in the filed for which R permission is set ", Status.PASS);
	    	}else {
			log("STEP 30: user can able to add text in the filed for which R permission is set  ", Status.FAIL);
		  }
			
			
			
			try {
				ClickOnConfigureFieldPermissionLink();
				log("STEP 31:  user can able to click on the \"Configured field permission\" link 2) pop up gets open    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 31:  user cannot  able to click on the \"Configured field permission\" link 2) pop up does not gets open        ", Status.FAIL);
				throw new RuntimeException("Failed in step 31");
			}

			try {
				SelectRole(map.get(Excel.Roles));
				log("STEP 32:  user can able to select administartion role from dd    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 32: user not able select administartion role from dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 32");
			}
			
			try {
				SelecteNPermission();
				log("STEP 33:  user can able to select the N radio button for the above added custom control field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 33:  user can not able to select the N radio button for the above added custom control field        ", Status.FAIL);
				throw new RuntimeException("Failed in step 33");
			}
			
			
			
			try {
				ClickOnSavePermission();
				log("STEP 34: user can able to click on the save permission button", Status.PASS);
			} catch (Exception e) {
				log("STEP 34:  user cannot able to click on the save permission button ", Status.FAIL);
				throw new RuntimeException("Failed in step 34");
			}
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 35 : 'Changes saved successfully!' message is display  ", Status.PASS);
				} else {
				   log("STEP 35: Changes saved successfully!' message does notdisplay ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 35 ");
		   	} 
			
			try {
				ClickOnClose();
				log("STEP 36: user can able to click on the (X) 2) pop  up gets close      ", Status.PASS);
			} catch (Exception e) {
				log("STEP 36: user cannot able to click on the (X) 2) pop  updoes not gets close     ", Status.FAIL);
				throw new RuntimeException("Failed in step 36");
			}
			
			util.reloadPage();
			util.dummyWait(2);
			
			if (!util.isElementPresent(txtAddress)) {
				   log("STEP 37 :user cannot see the filed for which N permission is set ", Status.PASS);
				} else {
				   log("STEP 37: user can able see the filed for which N permission is set  ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 37 ");
		   	} 
			
//			util.dummyWait(1);
//			driver.close();
//			driver.switchTo().window(mainWinID);
//			util.dummyWait(2);
//			
//			try {
//				NavigateToParcelInformation();
//				log("STEP 38:  user can able to navigate to parcel details page  ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 38:  user not able to navigate to parcel details page ", Status.FAIL);
//				throw new RuntimeException("Failed in step 38");
//			}
//			
//			if (util.isElementPresent(FieldValidation)) {
//				   log("STEP 39 :user cannot see the filed for which N permission is set ", Status.PASS);
//				} else {
//				   log("STEP 39: user can able see the filed for which N permission is set  ", Status.FAIL);
//			      throw new RuntimeException("Faild in STEP 39 ");
//		   	} 
//			
			
			try {
				By delete = By.xpath("//*[text()='"+map.get(Excel.FieldName1)+"']/..//*[@alt='Delete']");
				util.click(delete);
				log("STEP 28:  user can click on delete icon", Status.PASS);
			} catch (Exception e) {
				log("STEP 28:  user cannot click on delete icon ", Status.FAIL);
				throw new RuntimeException("Failed in step 28");
			}
			
			try {
				util.dummyWait(1);
		    	util.waitUntilElementDisplay(btnOk);
		    	util.click(btnOk);
				log("STEP 29:  user can click on ok button", Status.PASS);
			} catch (Exception e) {
				log("STEP 29:  user cannot click on ok button ", Status.FAIL);
				throw new RuntimeException("Failed in step 29");
			}	
			util.reloadPage();
			driver.close();
			util.switchToParentWindow();
			util.reloadPage();
			if (!util.isElementVisible(AddressLine1)) {
				   log("STEP 30 : user not able to see deleted ADDRESS Custom control field   ", Status.PASS);
				} else {
				   log("STEP 30 : user can able to see deleted ADDRESS Custom control field" , Status.FAIL);
			      throw new RuntimeException("Faild in STEP 30 ");
		   	} 
	   }
	
}
