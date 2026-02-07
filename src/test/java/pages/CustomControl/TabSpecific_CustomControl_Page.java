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

import extentReports.ExtentTestManager;

public class TabSpecific_CustomControl_Page  extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;

	public TabSpecific_CustomControl_Page(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By btnAddNewRecord = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[1]");
    By txtFieldName = By.xpath("//input[contains(@id,'editcc_Field_Name') and @type='text']");
    By drpFieldType = By.xpath("//input[contains(@id,'editcc_Field_Type_ID_radYALDropDownList_Input') and @type='text']");
    By txtDisplayOrder = By.xpath("//input[contains(@id,'editcc_Display_Order') and @type='text']");
    By txtMaxLengthValue = By.xpath("//input[contains(@id,'editcc_Max_Length_Value') and @type='text']");
    By txtHeight = By.xpath("//input[contains(@id,'editcc_radHeight') and @type='text']");
    By txtDisplayName = By.xpath("//textarea[contains(@id,'editcc_Display_Name')]");
    By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
    By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
    By btnSave = By.xpath("//input[contains(@id,'TractType_btnInternalSave')] | //input[contains(@id,'_TractType_btnSaveTract')] | //input[contains(@id,'_btnSaveCustomFields')]");
    By btnSaveHeader = By.xpath("//input[contains(@id,'btnSaveHeader')]");
    By btnPublish = By.xpath("//input[contains(@id,'PublishViews')]");
    By Message = By.xpath("//span[text()='Views have been published successfully.']");
    By navAcquistion = By.xpath("(//span[text()='Acquisition'])[1] | (//span[text()='ROW Components'])[1]");
    By navSurvey = By.xpath("(//span[text()='Survey'])[1] |(//span[text()='Surveillance'])[1]");
    By navTitle = By.xpath("(//span[text()='Title'])[1]");
    By navDocument = By.xpath("//span[text()='Parcel' and @class='rmText rmExpandDown']/../..//span[text()='Documents'] | //span[text()='Tract']/../..//span[text()='Documents']");
    By navParcelNotes = By.xpath("(//span[text()='Parcel Notes'])[1]");
    By navAssignment = By.xpath("//div[contains(@id,'RadYALMenu')]/../..//span[text()='Assignments']");
    By navPermanentInfrastructure = By.xpath("(//span[text()='Permanent Infrastructure'])[1]");
    By navNextTab = By.xpath("//a[@class='rtsLink rtsAfter']");
    By navPreviousTab = By.xpath("//a[@class='rtsLink rtsBefore']");
    By spinner = By.xpath("(//div[contains(@id,'ctl00_ConPHRightTop_divLoadingPanel') and @class='loading'])[1]");
    
    public void NavigateToParcelInformation() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navParcelInformation);
    	util.click(navParcelInformation);
    }
    
    public void NavigateToAcquisition() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navAcquistion);
    	util.click(navAcquistion);
    	
    }
    
    public void NavigateToSurvey() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navSurvey);
    	util.click(navSurvey);
    }
    
    public void NavigateToTitle() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navTitle);
    	util.click(navTitle);
    }
    
    public void NavigateToDocument() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navDocument);
    	util.click(navDocument);
    }
    
    public void NavigateToParcelNotes() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navParcelNotes);
    	util.click(navParcelNotes);
    }
    
    public void NavigateToAssignments() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navAssignment);
    	util.click(navAssignment);
    }
    
    public void NavigateToPermanentInfrastructure() {
    	util.waitUntilElementDisplay(navParcel);
    	util.click(navParcel);
    	util.waitUntilElementDisplay(navParcelInfo);
    	util.click(navParcelInfo);
    	util.waitUntilElementDisplay(navPermanentInfrastructure);
    	util.click(navPermanentInfrastructure);
    }
    
    public void navigateToNextTab() {
		util.waitUntilElementDisplay(navNextTab);
		util.click(navNextTab);
		util.waitUntilElementDisappear(spinner);
		
	}
    
    public void navigateToPreviousTab() {
		util.waitUntilElementDisplay(navNextTab);
		util.click(navNextTab);
		util.waitUntilElementDisappear(spinner);
	}
    
    public void TurnOnDesignCode() {
    	util.waitUntilElementDisplay(btnDesignMode);
    	util.click(btnDesignMode);
    	util.dummyWait(1);
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
    
    public void AddDisplayOrder(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDisplayOrder, value);
    }
    
    public void AddMaxLengthValue(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtMaxLengthValue, value);
    }
    
    public void AddHeight(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtHeight, value);
    }
    
     public void AddDisplayName(String value) {
    	if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtDisplayName, value);
    }
    
   public void ClickOnInsertButton() {
    	util.waitUntilElementDisplay(btnInsert);
    	util.click(btnInsert);
    	util.dummyWait(1);
    }
    
    public void ClickOnSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    	util.waitUntilPageLoad();
    }
    
    public void ClickOnSaveHeader() {
    	util.waitUntilElementDisplay(btnSaveHeader);
    	util.click(btnSaveHeader);
    }
    
    public void ClickOnPublish() {
    	util.waitUntilElementDisplay(btnPublish);
    	util.click(btnPublish);
    	util.waitUntilPageLoad();
    }
    
    By btnOk = By.xpath("//span[text()='OK']");
    public void ClickOnOK() {
    	util.waitUntilElementDisplay(btnOk);
    	util.click(btnOk);
    }
    
   By FieldValidation = By.xpath("//span[contains(text(),'FieldName')]");
   

   public void verificationOnOtherTab(Map<String, String> map, String testcaseName) {
	   if(util.isElementVisible(navNextTab)) {
	   try {
		   navigateToNextTab();
			By FieldValidation = By.xpath("//span[contains(text(),'"+map.get(Excel.DisplayName)+"')]/..//textarea");
			Assert.assertFalse(util.isElementVisible(FieldValidation));
			log("STEP 19: User cannot see Tab Specific Custom Control Field on other tabs", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 19:  User can see Tab Specific Custom Control Field on other tabs", Status.FAIL);
		}
	   }
   }
   
    public void verifyCustomControl(Map<String, String> map, String testcaseName) {
		
    	if(testcaseName.contains("ParcelInformation")) {
    	try {
			NavigateToParcelInformation();
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
    	}
    	
			try {
				 By customIcon = By.xpath("//a[@title='Manage custom field(s)' and contains(@href,'"+map.get(Excel.Type)+"')] | //span[@title='Manage custom field(s)' and contains(@onclick,'"+map.get(Excel.Type)+"')]");
				util.click(customIcon);
				log("STEP 3:  user can able to click on the Tab Specific Custom control icon of the Type "+map.get(Excel.Type), Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  user cannot click on the Tab Specific Custom control icon of the Type "+map.get(Excel.Type), Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			util.switchToChildWindow();
//			Set<String> windowId = driver.getWindowHandles(); // get window id of current window
//			Iterator<String> itererator = windowId.iterator();
//			String mainWinID = itererator.next();
//			String newAdwinID = itererator.next();
//			driver.switchTo().window(newAdwinID);
			util.dummyWait(1);
			
			By FieldName = By.xpath("//*[contains(@id,'idMngCustmAdnlFields_')]/td[text()='" +map.get(Excel.FieldName)+ "']");
			if(!util.isElementVisible(FieldName)) {
			
			try {
				ClickOnAddNewRecord();
				log("STEP 4: user can able to click on the add new record (+) button on the Custom Control Page", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: user can not able to click on the add new record (+) button on the Custom Control Page ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				AddFieldName(map.get(Excel.FieldName));
				log("STEP 5: user can able to enter text in the \"Field Name \" field     ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user not able to enter text in the \"Field Name \" field     ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				SelectFieldType(map.get(Excel.FieldType));
				log("STEP 6: user can able to select the value \"LTEXT\"  from field type dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user can not able to select the value \"LTEXT\"  from field type dd ", Status.FAIL);
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
				AddMaxLengthValue(map.get(Excel.LengthValue));
				log("STEP 8: user can able to enter value in Max Length/Value field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 98: user cannot able to enter value in Max Length/Value field   ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			try {
				AddHeight(map.get(Excel.Height));
				log("STEP 9:  user can able to enter value in Height field", Status.PASS);
			} catch (Exception e) {
				log("STEP 9:  user cannot able to enter value in Height field ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
			
			try {
				AddDisplayName(map.get(Excel.DisplayName));
				log("STEP 10 : user can able to enter value in Display Name field ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: user cannot able to enter value in Display Name field ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				ClickOnInsertButton();
				log("STEP 11: user can able to click on insert button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: user cannot able to click on insert button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			
			if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 12 : 'Changes saved successfully!' message is display  ", Status.PASS);
				} else {
				   log("STEP 12: Changes saved successfully!' message does notdisplay ", Status.FAIL);
		   	} 
			
			try {
				ClickOnSaveHeader();
				log("STEP 13: user can able to click on Save Header button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: user cannot able to click on Save Header button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
			try {
				ClickOnPublish();
				log("STEP 14 : user can able to click on Publish button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: user cannot able to click on Publish button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
			if (util.isElementPresent(Message)) {
				   log("STEP 15 : 'Views have been published successfully. message is display  ", Status.PASS);
				} else {
				   log("STEP 15: Views have been published successfully. message does notdisplay ", Status.FAIL);
		   	} 
		    
			 By FieldValidation1 = By.xpath("//span[contains(text(),'"+map.get(Excel.DisplayName)+"')]/..//textarea");
			if (util.isElementPresent(FieldValidation1)) {
				   log("STEP 16 :  Display name is correctly visible for the custom field    ", Status.PASS);
				} else {
				   log("STEP 16:  Display name not visible for the custom field " , Status.FAIL);
			      throw new RuntimeException("Faild in STEP 16 ");
		   	} 
			
			//driver.switchTo().window(mainWinID);
			util.switchToParentWindow();
			try {
				driver.navigate().refresh();
				util.dummyWait(2);
				 Assert.assertTrue(util.isElementVisible(FieldValidation1));
				 ExtentTestManager.infoWithScreenshot("Tab Specific custom control Field Added on the Tab");
				log("STEP 17: user can see added Tab Specific Custom Control on Parcel Information Tab ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 17: user can not see added Tab Specific Custom Control on Parcel Information Tab", Status.FAIL);
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(btnSave));
				log("STEP 18: User can see Save button to save value in added Custom Field", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 18:  User cannot see Save button to save value in added Custom Field", Status.FAIL);
			}
			
			if(!testcaseName.contains("Assignment")) {
			verificationOnOtherTab(map,testcaseName);
			}
			
			try {
//			driver.switchTo().window(newAdwinID);
				util.switchToChildWindow();
			By delete = By.xpath("//*[text()='"+map.get(Excel.FieldName)+"']/..//*[@alt='Delete']");
			util.click(delete);
			log("STEP 20:  user can click on delete icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 20:  user cannot click on delete icon ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		
		try {
			util.waitUntilElementDisplay(btnOk);
	    	util.click(btnOk);
			log("STEP 21:  user can click on ok button", Status.PASS);
		} catch (Exception e) {
			log("STEP 21:  user cannot click on ok button ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}	
		
    	util.reloadPage();
    	driver.close();
//    	driver.switchTo().window(mainWinID);
    	util.switchToParentWindow();
			}else {
				log("STEP 4: Custum Control field is already added ", Status.PASS);
				driver.close();
//				driver.switchTo().window(mainWinID);
				util.switchToParentWindow();
			}
    	

    }
    
    
}
