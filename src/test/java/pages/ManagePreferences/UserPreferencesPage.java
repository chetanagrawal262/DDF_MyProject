package pages.ManagePreferences;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class UserPreferencesPage extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;

	public UserPreferencesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navTools = By.xpath("//span[contains(text(),'Tools')]");
	By navMyPrefrence = By.xpath("//span[contains(text(),'My Preferences')]");
	By navManagePreferences = By.xpath("//span[contains(text(),'Manage Preferences')]");
	By btnAddNewRecord = By.xpath("(//a[contains(@id,'lnkAddNewRecord')])[1]");
	By DropDown = By.xpath("//input[contains(@id,'EditFormControl_SessionVariableValue_ID_radYALDropDownList_Input') and @type='text']");
	By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert') and @type='submit']");
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
	By btnEdit = By.xpath("(//input[contains(@id,'EditButton') and @type='image'])[1]");
	By btnUpdate = By.xpath("(//input[contains(@id,'EditFormControl_btnUpdate') and @type='submit'])[1]");
    By btnDelete = By.xpath("(//input[contains(@id,'gbcDeleteAlignment') and @type='image'])[last()]");
    By btnOk = By.xpath("//span[text()='OK']");
    By startPageOption = By.xpath("//td[text()='Start Page']/..//*[text()='My Dashboard']");
    By startPageOptionforCA = By.xpath("//td[text()='Start Page']/..//*[text()='My Approvals']");
    By showOfflineOption = By.xpath("//td[contains(text(),'Show Offline')]/..//*[text()='No']");
    By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	By startPageforAC = By.xpath("//span[text()='My Approvals' and contains(@id,'lblBulkEditName')]");
	By currentStartPageOptionSet = By.xpath("(//table/tbody/tr/td[count(//table/thead/tr/th[.='Current Option']/preceding-sibling::th)+1])[2]");
	By showOfflineCheckbox = By.xpath("//input[contains(@id,'_chkShowOffline') and @checked='checked']");
	
    public void ClickOnAddNewRecord() {
    	util.waitUntilElementDisplay(btnAddNewRecord);
    	util.click(btnAddNewRecord);
    }
    
    public void SelectDropDown(String value) {
    	 if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(DropDown,value);
    }
    
    public void ClickOnInsertButton() {
    	util.waitUntilElementDisplay(btnInsert);
    	util.click(btnInsert);
    	 util.dummyWait(3);
	     util.waitUntilElementDisplay(SuccessMessage);
	     Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
    }
    
    public void ClickOnEditButton() {
    	util.waitUntilElementDisplay(btnEdit);
    	util.click(btnEdit);
    }
    
    public void ClickOnUpdateButton() {
    	util.waitUntilElementDisplay(btnUpdate);
    	util.click(btnUpdate);
    }
    
    public void ClickOnDeleteButton() {
    	util.waitUntilElementDisplay(btnDelete);
    	util.click(btnDelete);
    }
    
    public void ClickOnOk() {
    	driver.switchTo().alert().accept();
    	util.dummyWait(3);
    }
    
    
    public void ClickOnOKButton() {
    	util.waitUntilElementDisplay(btnOk);
    	util.click(btnOk);
    }
    public void NavigatetToManagePreferencesROW() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitFor(200);
		util.waitUntilElementDisplay(navMyPrefrence);
		util.hoverOnElement(navMyPrefrence);
		//util.click(navMyPrefrence);
		
		//util.waitUntilElementDisplay(navManagePreferences);
		util.click(navManagePreferences);
	}
	
	public void NavigatetToManagePreferences() {
		util.waitUntilElementDisplay(navMyPrefrence);
		util.click(navMyPrefrence);
		util.waitUntilElementDisplay(navManagePreferences);
		util.click(navManagePreferences);
	}
    
	 public void TurnOnDesignMode() {
	    	util.waitUntilElementDisplay(btnDesignMode);
	    	util.click(btnDesignMode);
	    	util.dummyWait(2);
	    }
	   
	   public void SelectUser(String value) {
			if (!commonFunction.checkNA(value)) {
					util.selectValueFromDropdown(drpUser, value);
					
				util.pressENTERkey();
				}
		  }
	   
	   By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
		By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
		By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
		
    
	   public void navigateParcelInformation() {
			util.waitUntilElementDisplay(navParcel);
			util.click(navParcel);
			util.waitUntilElementDisplay(navParcelInfo);
			util.click(navParcelInfo);
			util.waitUntilElementDisplay(navParcelInformation);
			util.click(navParcelInformation);			
		}
	   
	public void  UserPreferences(Map<String, String> map,String testcaseName) throws InterruptedException  {
		
		if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
			
			try {
				 NavigatetToManagePreferencesROW();
					log("STEP 1: user can navigate to manage preference  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: user cannot  navigate to manage preference  ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
		}
			else{			
				try {
					 NavigatetToManagePreferences();
						log("STEP 2: user can navigate to manage preference ", Status.PASS);
					} catch (Exception e) {
						log("STEP 2: user cannot  navigate to manage preference ", Status.FAIL);
						throw new RuntimeException("Failed in step 2");
					}
			}
		
		String currentStartPage = driver.findElement(currentStartPageOptionSet).getText();
		log("Current Option Set for Start Page "+currentStartPage);
		ExtentTestManager.infoWithScreenshot("Default Settings");
		
		if(NotificationPreferencesPage.pageTitle.contains("BulkEdit")) {
			try {
				Assert.assertTrue(util.isElementVisible(startPageOptionforCA));
					log("STEP 3: Landing page and Start Page Current option set matched ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 3: Landing page and Start Page Current option set not matched", Status.FAIL);
				}
		}else {
		 if(NotificationPreferencesPage.pageTitle.contains("Dashboard")) {
			 log("STEP 3: Landing page and Start Page Current option set matched ", Status.PASS);
		 }else {
			 log("STEP 3: Landing page and Start Page Current option set not matched ", Status.FAIL);
		 }
		}
		
		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ATWELL")) {
			 try {
				 ClickOnEditButton();
					log("STEP 4: user can able to edit information as per requirement ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: user not able to edit information", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
			 
			 try {
				 ClickOnUpdateButton();
					log("STEP 5: user can able to click on update button  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: user not able to click on update button  ", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
			 
			 if (util.isElementPresent(SuccessMessage)) {
				   log("STEP 6 : \"Changes saved successfully\" message should display  ", Status.PASS);
				} else {
				   log("STEP 6: \"Changes saved successfully\" message not display ", Status.FAIL);
			      throw new RuntimeException("Faild in STEP 6");
		    	} 
			 
			}
			else if(testcaseName.contains("ORION")){
				
				try {
					 Assert.assertTrue(util.isElementVisible(startPageOption));
						log("STEP 4: By Default landing Page option set to 'My Dashboard' ", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 4: By Default landing Page option not set to 'My Dashboard' ", Status.FAIL);
					}
				
				try {
					 Assert.assertTrue(util.isElementVisible(showOfflineOption));
						log("STEP 5: By Default Show Offline Parcel By Default option set to 'No' ", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 5: By Default Show Offline Parcel By Default current option not set to 'No' ", Status.FAIL);
					}
				
				try {
					TurnOnDesignMode();
					log("STEP 6:  user can turn on design mode", Status.PASS);
				} catch (Exception e) {
					log("STEP 6:  user cannot turn on design mode", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				} 
	            
	            try {
	            	SelectUser(map.get(Excel.User));
					log("STEP 7: 'Claude Akana' User selected ", Status.PASS);
				} catch (Exception e) {
					log("STEP 7:  'Claude Akana' User not selected ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				} 
				
//	            try {
//					 Assert.assertTrue(util.isElementVisible(startPageforAC));
//						log("STEP 8: Claude Akana User landed on My Approval Page successfully ", Status.PASS);
//					} catch (AssertionError e) {
//						log("STEP 8: Claude Akana User not landed on My Approval Page ", Status.FAIL);
//					}
	            
	            try {
					 NavigatetToManagePreferences();
						log("STEP 9: user can navigate to manage preference ", Status.PASS);
					} catch (Exception e) {
						log("STEP 9: user cannot  navigate to manage preference ", Status.FAIL);
						throw new RuntimeException("Failed in step 8");
					}
	            
	            try {
					 Assert.assertTrue(util.isElementVisible(startPageOption));
						log("STEP 10: By Default landing Page option set to 'My Dashboard' for 'Claude Akana' Agent ", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 10: By Default landing Page option not set to 'My Dashboard' for 'Claude Akana' Agent  ", Status.FAIL);
					}
	            
			}else {
				 
				 try {
					 ClickOnEditButton();
						log("STEP 4: user can able to edit information as per requirement ", Status.PASS);
					} catch (Exception e) {
						log("STEP 4: user not able to edit information", Status.FAIL);
						throw new RuntimeException("Failed in step 4");
					}
				 
				 try {
					 ClickOnUpdateButton();
						log("STEP 5: user can able to click on update button  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 5: user not able to click on update button  ", Status.FAIL);
						throw new RuntimeException("Failed in step 5");
					}
				 
				 if (util.isElementPresent(SuccessMessage)) {
					   log("STEP 6 : \"Changes saved successfully\" message should display  ", Status.PASS);
					} else {
					   log("STEP 6: \"Changes saved successfully\" message not display ", Status.FAIL);
				      throw new RuntimeException("Faild in STEP 6");
			    	} 
			}
		
		if(util.isElementVisible(showOfflineOption)) {
			log("STEP 8: Show Offline Parcel Option By Default set to 'Yes'  ", Status.PASS);
			
			try {
	    		navigateParcelInformation();
				log("STEP 7: User can navigate to the Parcel Information ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User cannot see the Parcel Information option in Menu", Status.FAIL);
				throw new RuntimeException("User cannot see the Parcel Information option in Menu");
			}
			
			try {
				Assert.assertFalse(util.isElementVisible(showOfflineCheckbox));
				log("STEP 8: show Offline/ Inactive checkbox checked ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 8: show Offline/ Inactive checkbox not checked", Status.FAIL);
			}
			
			if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
				
				try {
					 NavigatetToManagePreferencesROW();
						log("STEP 9: user can navigate to manage preference  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 9: user cannot  navigate to manage preference  ", Status.FAIL);
						throw new RuntimeException("Failed in step 9");
					}
			}
				else{
				
					try {
						 NavigatetToManagePreferences();
							log("STEP 9: user can navigate to manage preference ", Status.PASS);
						} catch (Exception e) {
							log("STEP 9: user cannot  navigate to manage preference ", Status.FAIL);
							throw new RuntimeException("Failed in step 9");
						}
					
				}
		}

	}
 
}
