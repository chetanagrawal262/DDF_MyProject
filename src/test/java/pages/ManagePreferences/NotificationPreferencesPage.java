package pages.ManagePreferences;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class NotificationPreferencesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	static String pageTitle;

	public NotificationPreferencesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By EmailRadioButton = By.xpath("//label[contains(@for,'OptEmail')]");
	By DashboardRadioButton = By.xpath("//label[contains(@for,'OptDashboard')]");
	By BothRadioButton = By.xpath("//label[contains(@for,'OptBoth')]");
	By btnSave = By.xpath("//input[contains(@id,'SaveNotificationPref') and @type='image']");
	By CheckBothRadioButton = By.xpath("//input[contains(@id,'OptBoth') and @checked='checked']");
	
	public void ClickOnEmailRadioButton() {
		util.waitUntilElementDisplay(EmailRadioButton);
		util.click(EmailRadioButton);
	}
	
	public void ClickOnDashboardRadioButton() {
		util.waitUntilElementDisplay(DashboardRadioButton);
		util.click(DashboardRadioButton);
	}
	
	public void ClickOnBothRadioButton() {
		util.waitUntilElementDisplay(BothRadioButton);
		util.click(BothRadioButton);
	}
	
	By SuccessMessage = By.xpath("//span[text()='Saved Successfully!']");
	public void ClickOnSave() {
		util.dummyWait(1);
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(2);
		util.waitUntilElementDisplay(SuccessMessage);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Saved Successfully!");		
	}
	
	By navTools = By.xpath("//span[contains(text(),'Tools')]");
	By navMyPrefrence = By.xpath("//span[contains(text(),'My Preferences')]");
	By navManagePreferences = By.xpath("//span[contains(text(),'Manage Preferences')]");
	
	  public void NavigatetToManagePreferencesROW() {
			util.waitUntilElementDisplay(navTools);
			util.click(navTools);
			util.waitFor(200);
			util.waitUntilElementDisplay(navMyPrefrence);
			util.hoverOnElement(navMyPrefrence);
			util.click(navManagePreferences);
		}
		
		public void NavigatetToManagePreferences() {
			util.waitUntilElementDisplay(navMyPrefrence);
			util.click(navMyPrefrence);
			util.waitUntilElementDisplay(navManagePreferences);
			util.click(navManagePreferences);
		}
	
	public void  NotificationPreferences(String testcaseName) throws InterruptedException  {
		util.dummyWait(1);
	 pageTitle = driver.getCurrentUrl();
		log("User landed on "+pageTitle);
		
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
				
				if(testcaseName.contains("ORION"))	{
					
					try {
						String title = driver.getTitle();
						Assert.assertEquals(title, "AMPS: My Dashboard");
							log("STEP 1: User can Successfully landed on My Dashboard Page ", Status.PASS);
						} catch (AssertionError e) {
							log("STEP 1: User not Landded on the My Dashboard page ", Status.FAIL);
						}
				}
				
				try {
					 NavigatetToManagePreferences();
						log("STEP 2: user can navigate to manage preference ", Status.PASS);
					} catch (Exception e) {
						log("STEP 2: user cannot  navigate to manage preference ", Status.FAIL);
						throw new RuntimeException("Failed in step 2");
					}
			}
		
		if(testcaseName.contains("ORION")) {
			
			 try {
				Assert.assertTrue(util.isElementVisible(CheckBothRadioButton));
					log("STEP 2:  By Default Notification Preference set to 'Both'  ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 2: By Default Notification Preference not set to 'Both' ", Status.FAIL);

				}
		}else {
		
		 try {
			 ClickOnEmailRadioButton();
				log("STEP 3: user can able to select Email Radio button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user not able to select Email Radio button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		 
		 try {
			 ClickOnDashboardRadioButton();
				log("STEP 4:  user can able to select Dashboard Radio button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  user can able to select Dashboard Radio button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		 
		 try {
			 ClickOnBothRadioButton();
			 util.dummyWait(2);
			// ClickOnEmailRadioButton();
				log("STEP 5: user can able to select both Radio button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user not able to  select both Radio button ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
		 
		 try {
			 ClickOnSave();
				log("STEP 6: user can able to click on save button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user not able to click on save button ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
		 
		 if (util.isElementPresent(SuccessMessage)) {
			   log("STEP 7: Saved Successfully!", Status.PASS);
			} else {
			   log("STEP 7: Error message should be display", Status.FAIL);
		      throw new RuntimeException("Faild in STEP 7 ");
	    	} 
		}
	}
}
