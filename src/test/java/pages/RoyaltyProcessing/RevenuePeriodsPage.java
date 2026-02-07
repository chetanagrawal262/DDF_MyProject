package pages.RoyaltyProcessing;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;
import pages.InfoByParcelReport.AddProjectPage;

public class RevenuePeriodsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String CONFIRMATION_MESSAGE;

	public RevenuePeriodsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);	
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navRoyaltyProcessing = By.xpath("//span[contains(text(),'Royalty Processing')]");
	By navRevenueData = By.xpath("//span[contains(text(),'Revenue Data')]");
	By RevenuePeriods = By.xpath("(//a[@title='Expand'])[1]");
	By SelectOption = By.xpath("//label[contains(text(),'Quarterly')]");
	By btnSave = By.xpath("//input[contains(@id,'_PRODPD_btnSavePds') and @type='image']");
	By successmessage = By.xpath("//span[text()='Save successful']");
	By StartDate = By.xpath("//a[contains(text(),'Start Date')]");
	By EndDate = By.xpath("//a[contains(text(),'End Date')]");
	By txtYear = By.xpath("(//input[contains(@id,'PRODPD_dtPdStartDate_dateInput')])[1]");
	By linkManuallyClose = By.xpath("//a[text()='Manually Close']");
	By firstLinkManuallyClose = By.xpath("(//a[text()='Manually Close'])[1]");
	By msgConfirm = By.xpath("//div[contains(@id,'confirm') and contains(@id,'message')]");
	By btnYes = By.xpath("//span[text()='Yes']");
	By btnClose = By.xpath("//a[@title='Close']");
	By msgRevenueGenerated = By.xpath("//span[text()='Revenue periods of the selected year have already been generated. Please choose a different year to generate revenue periods for.']");
	
	 public void navigateToRevenueData() {
	  		util.waitUntilElementDisplay(navProject);
	  		util.click(navProject);
	  		util.waitUntilElementDisplay(navRoyaltyProcessing);
	  		util.hoverOnElement(navRoyaltyProcessing);
	  		util.waitUntilElementDisplay(navRevenueData);
	  		util.click(navRevenueData);
	 }
	  	
	  public void ExpandRevenuePeriods() {
		  util.waitUntilElementDisplay(RevenuePeriods);
		  util.click(RevenuePeriods);
	  }
	  
	  public void SelectOption() {
		  util.waitUntilElementDisplay(SelectOption);
		  util.click(SelectOption);
	  }
	  
	  public void ClickonSaveButton() {
		  util.waitUntilElementDisplay(btnSave);
		  util.click(btnSave);
		  util.dummyWait(2);
	  }
	  
	  public void AddYear(String value) {
			if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtYear, value);
		}
	  
	  public void RevenuePeriods(Map<String, String> map,String testcaseName)  {

			try {
				navigateToRevenueData();
			    commonFunction.selectProjectNew(AddProjectPage.PN);
			    util.dummyWait(1);
				log("STEP 1: User can navigate to Revenue Data", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to Revenue Data ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
	   
			if(util.isElementVisible(RevenuePeriods)) {			
				try {
				 ExpandRevenuePeriods();
					log("STEP 2: user can  click on revenue periods panel ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: user cannot click on revenue periods panel ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
			}

			if(util.isElementVisible(btnSave)) {
			 try {
				 SelectOption();
					log("STEP 2: user can select any one option from given options. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: user cannot select  any one option from given options.", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
			
			 if(util.isElementVisible(txtYear)) {
				 try {
					 AddYear(map.get(Excel.Year));
						log("STEP 3: user can add year ", Status.PASS);
					} catch (Exception e) {
						log("STEP 3: user cannot add year", Status.FAIL);
						throw new RuntimeException("Failed in step 3");
					}
			 }else {
				 log("STEP 3: Year field is missing", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
			 }

			 try {
				 ClickonSaveButton();
					log("STEP 4: user can click on save button.", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: user cannot click on save button. ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
			}
	    		
	  }
	  
	  By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	  public void SelectUser(String value) {
			if (!commonFunction.checkNA(value)) {
					util.selectValueFromDropdown(drpUser, value);
					
				util.pressENTERkey();
				}
		  }
	  
	  public void VerifyRevenuePeriodsMessage(Map<String, String> map,String testcaseName)  {
		  if(!environment.contains("AKUOENERGY") & !environment.contains("CONNECTGEN")) {
		  try {
          	SelectUser(map.get(Excel.User));
				log("STEP 1:  user can select approver", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  user cannot select approver ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			} 
		  }
		  
			try {
				navigateToRevenueData();
				commonFunction.selectProjectNew(AddProjectPage.PN);
				log("STEP 2: User can navigate to Revenue Data", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot navigate to Revenue Data ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
	   
			try {
				util.click(firstLinkManuallyClose);
				log("STEP 3: User can click on Manually close Link", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot click on Manually close Link ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				CONFIRMATION_MESSAGE =driver.findElement(msgConfirm).getText().trim();
				Assert.assertEquals(CONFIRMATION_MESSAGE, "Processing revenue through royalty - payments tab on payment manager will automatically close the revenue periods. Close it manually only if there are no payments to process for this revenue period. Do you wish to close this revenue period?");
				log("STEP 4: Confirmation Message Matched", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 4: Confirmation Message not Matched ", Status.FAIL);
			}
			
			try {
				util.click(btnYes);
				util.waitFor(500);
				log("STEP 5: User can close the Revenue process manually", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot click on Yes button", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
//				 List<WebElement> linkProcess =driver.findElements(linkManuallyClose);
//				for (WebElement var : linkProcess) {
//					util.waitFor(200);
//					var.click();
//					util.waitFor(200);
//					util.click(btnYes);
//				        }
				 for(int i=0; i<3; i++) {
					 if(util.isElementVisible(firstLinkManuallyClose)) {
						 util.waitFor(500);
							util.click(firstLinkManuallyClose);
							util.waitFor(200);
							util.click(btnYes);
					 }
				 }
				log("STEP 6: User can close all the Process Manually", Status.PASS);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				 AddYear(map.get(Excel.Year));
					log("STEP 7: user can add same year again ", Status.PASS);
				} catch (Exception e) {
					log("STEP 7: user cannot add same year again", Status.FAIL);
					throw new RuntimeException("Failed in step 7");
				}
			
			try {
				 ClickonSaveButton();
					log("STEP 8: user can click on save button.", Status.PASS);
				} catch (Exception e) {
					log("STEP 8: user cannot click on save button. ", Status.FAIL);
					throw new RuntimeException("Failed in step 8");
				}
			
			try {
				Assert.assertTrue(util.isElementVisible(msgRevenueGenerated));
					log("STEP 9: user can see Revenue message for the Generated Year", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 9: user cannot see Revenue message for the Generated Year ", Status.FAIL);
				}
			
			ExtentTestManager.infoWithScreenshot("Revenue Generated Message");
			try {
				 AddYear(map.get("NextYear"));
					log("STEP 10: user can add Next year again ", Status.PASS);
				} catch (Exception e) {
					log("STEP 10: user cannot add Next year again", Status.FAIL);
					throw new RuntimeException("Failed in step 10");
				}
			
			try {
				 ClickonSaveButton();
					log("STEP 11: user can click on save button.", Status.PASS);
				} catch (Exception e) {
					log("STEP 11: user cannot click on save button. ", Status.FAIL);
					throw new RuntimeException("Failed in step 11");
				}
			
			try {
				Assert.assertFalse(util.isElementVisible(msgRevenueGenerated));
					log("STEP 12: user cannot see Revenue message for the year for which revenue is not already generated", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 12: user can see Revenue message for the year for which revenue is not already generated", Status.FAIL);
				}
			
			try {
				Assert.assertFalse(util.isElementVisible(txtYear));
					log("STEP 13: user cannot see Year Field after adding Revenue Periods", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 13: user can see Year Field after adding Revenue Periods", Status.FAIL);
				}
	  }
	  
	//#53871-start
	  By navProductionData = By.xpath("//div[contains(@id,'royaltyMgnt')]//span[contains(text(),'Production Data')]");
	  By drpYear = By.xpath("//input[contains(@id,'YalProdDM_ddlYear_radYALDropDownList_Input')]");
	  By drpPeriod = By.xpath("//input[contains(@id,'YalProdDM_ddlPD_radYALDropDownList_Input')]");
	  By btnView = By.xpath("//input[contains(@id,'YalProdDM_btnView')]");
	  By msgNoTurbinePresent = By.xpath("//div[text()='No Turbines on the project to capture production data. Please add turbine data to capture revenue.']");
	  
	  public void navigateToProductionData() {
	  		util.waitUntilElementDisplay(navProductionData);
	  		util.click(navProductionData);
	 }
	  
	  public void SelectYear(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpYear, value);
	    	util.dummyWait(2);
	    }
	    
	    public void SelectPeriod(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpPeriod, value);
	    	util.dummyWait(2);
	    }
	    
	    public void ClickOnView() {
	    	util.waitUntilElementDisplay(btnView);
	    	util.click(btnView);
	    	util.dummyWait(2);
	    	
	    }
	  
	  public void VerifyNoTurbineMessage(Map<String, String> map, String testcaseName)  {
		  
		  try {
				navigateToProductionData();
				log("STEP 1: user can navigate to Production Tracking page ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: user cannot  navigate to Production Tracking page ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
			try {
				SelectYear(map.get(Excel.Year));
				log("STEP 2: User can select value from  Year dd    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot select value from  Year dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				SelectPeriod(map.get(Excel.Period));
				log("STEP 3: User can select value from  Period dd    ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select value from  Period dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				ClickOnView();
				log("STEP 4: user can able to click on view button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  user cannot able to click on view button  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(msgNoTurbinePresent));
				log("STEP 5: user can able to click on view button  ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 5:  user cannot able to click on view button  ", Status.FAIL);
			}
	  }
	  
	//#53871-end
}
