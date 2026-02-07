package pages.ParcelSearch;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class BulkMilestonesDatePage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public BulkMilestonesDatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By ExpandBulkMilestonesDatePanel = By.xpath("//*[contains(@id,'idSearch_RadDockBulkMilestoneDate_T')]/..//span[@class='rdExpand']");
    By documentgrid = By.xpath("//tr[@id='ctl00_ConPHRightTop_idSearch_grdSearchResults_RadGrid1_ctl00__0']");
	By Checkbox = By.xpath("//input[contains(@id,'_CheckBox1')]"); 
	By drpMilestone = By.xpath("(//input[contains(@id,'_combo_Milestone_YALComboBox_Input')])[1]");
	By txtExpectedDate = By.xpath("(//input[contains(@id,'Expected_Date_dateInput')])[1]");
	By txtActualDate = By.xpath("(//input[contains(@id,'Actual_Date_dateInput')])[1]");
	By btnUpdate = By.xpath("(//input[contains(@id,'BulkKeyDateUpdate_btnBulkUpdate')])[1]");
	By successMessage = By.xpath("//span[contains(text(),'Change(s) saved!')]");
	
	 public void ExpandBulkMilestonesDate() {
	    	util.waitUntilElementDisplay(ExpandBulkMilestonesDatePanel);
	    	util.click(ExpandBulkMilestonesDatePanel);
	    }
	    
	    public void ClickOnCheckbox() {
	    	util.dummyWait(2);
	    	util.waitUntilElementDisplay(Checkbox);
	    	util.click(Checkbox);
	    }
	    
	    public void RightClickOnDocumentGrid() {
	    	WebElement web = driver.findElement(documentgrid);
	    	util.waitUntilElementDisplay(documentgrid);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	    }

	    By btnOpenInPopup = By.xpath("//span[contains(text(),'Open in pop-up')]");
	    By btnClose = By.xpath("//a[@title='Close']");
	    By iframe = By.xpath("//iframe[@name='SearchSingleOpen']");
	    public void ClickOnOpeninPopupButton() {
	    	util.dummyWait(1);
	    	util.click(btnOpenInPopup);
	    	util.dummyWait(1);
	    	util.switchToIframe(iframe);
	    	util.dummyWait(1);
	    }
	    
	    By ExpandMilestoneDatePanel = By.xpath("//span[contains(text(),'Parcel Milestones')]");
	    public void ClickOnMilestoneDatePanel() {
	    	util.waitUntilElementDisplay(ExpandMilestoneDatePanel);
	    	util.click(ExpandMilestoneDatePanel);
	    }
	    
	    By parcelInformation = By.xpath("(//span[text()='Tract Information'])[2] | (//span[text()='Parcel Information'])[2] | (//span[text()='Record Information'])[2]");
	    
	    By ExpandMilestoneDatePanelRow = By.xpath("//span[contains(text(),'Key Dates (Milestones)')]");
	    public void ClickOnMilestoneDatePanelRow() {
	    	util.click(parcelInformation);
	    	util.dummyWait(3);
	    	util.waitUntilElementDisplay(ExpandMilestoneDatePanelRow);
	    	util.click(ExpandMilestoneDatePanelRow);
	    }
	    
	    By ExpandMilestoneDatePanelAlt = By.xpath("//span[contains(text(),'Milestone Dates')]");

	    public void ClickOnMilestoneDatePanelALT() {
	    	util.waitUntilElementDisplay(ExpandMilestoneDatePanelAlt);
	    	util.click(ExpandMilestoneDatePanelAlt);
	    }
	    
	    
	    public void SelectMilestone(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(drpMilestone, value);
	    }
	    
	    public void SelectExpectedDate(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtExpectedDate, value);
	    }
	    
	    public void SelectActualDate(String value) {
	    	if (!commonFunction.checkNA(value)) 
				util.inputTextAndPressTab(txtActualDate, value);
	    }
	    
	    public void ClickOnUpdate() {
	    	util.waitUntilElementDisplay(btnUpdate);
	    	util.click(btnUpdate);
	    }
	    
	    By getStrDateName = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()]//td[7])[1]");
	    public void VerifyDateName() {
	   		String DateName = util.getText(getStrDateName);
	   		log("Date Name is  :" + DateName);
	   		}
	    
	    By getStrExpectedDate = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()]//td[10])[1]");
	    public void VerifyExpectedDate() {
	   		String ExpectedDate = util.getText(getStrExpectedDate);
	   		log("Expected Date is  :" + ExpectedDate);
	   	}
	    By getStrActualDate = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()]//td[12])[1]");
	    public void VerifyActualDate() {
	   		String ActualDate = util.getText(getStrActualDate);
	   		log("Actual Date is  :" + ActualDate);
	   	}
	    public void ClickOnClose() {
	    	util.switchToDefaultContent();
	    	util.waitUntilElementDisplay(btnClose);
	    	util.click(btnClose);
	    }
	    
	    By getStrDateNameRow = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()]//td[5])[1]");
	    By getStrExpectedDateRow = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()]//td[8])[1]");
	    By getStrActualDateRow = By.xpath("(//tr[contains(@id,'radYALGridControl_ctl00')][last()]//td[10])[1]");

	
	    
       public void BulkMilestonesDate(Map<String, String> map, String testcaseName) {
			if(!testcaseName.contains("ALT") & !testcaseName.contains("ORION") & !testcaseName.contains("ORSTED") & !testcaseName.contains("ATWELL") & !testcaseName.contains("NOVA") & !testcaseName.contains("DOM")) {
			try {
				ClickOnCheckbox();
				log("STEP 1: User can select the checkbox ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot select the checkbox  ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			

			
			try {
				ExpandBulkMilestonesDate();
				log("STEP 2:  User can expand bulk Milestone date panel ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:   User cannot expand bulk Milestone date panel   ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			
			try {
				SelectMilestone(map.get(Excel.Milestone));
				log("STEP 3:   User can select value from Milestone dd ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:   User canbot select value from Milestone dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				SelectExpectedDate(map.get(Excel.ExpectedDate));
				log("STEP 4:  User can select date from Expected Date picker   ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:   User cannot select date from Expected Date picker   ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				SelectActualDate(map.get(Excel.ActualDate));
				log("STEP 5: User can select date from Actual Date picker ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User cannot select date from Actual Date picker ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				ClickOnUpdate();
				log("STEP 6:  User can click on update button.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6:  User cannot  click on update  button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			util.waitFor(300);
			
			if(util.isElementVisible(successMessage)) {
			if(testcaseName.contains("DOT")) {
			try {
				RightClickOnDocumentGrid();
				log("STEP 7: when user right click on records 2 options should be displayed 1)Open in window. 2)Open in current window.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User cannot right click on search results. ", Status.FAIL);
				throw new RuntimeException("Failed in step 7 ");
			}
			
			try {
				ClickOnOpeninPopupButton();
				util.dummyWait(1);
				ClickOnMilestoneDatePanel();
				log("STEP 8: User can navigate to Bulk Milestone panel ", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: User not able navigate to Bulk Milestone panel  ", Status.FAIL);
				throw new RuntimeException("Failed in step 8 ");
			}
			
			try {
				By dateName = By.xpath("//tr[contains(@id,'TRACTDATES_radYALGridControl')]/..//*[text()='"+map.get(Excel.Milestone)+"']");
				Assert.assertTrue(util.isElementVisible(dateName));
				log("STEP 9: Date Name Matched ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9: Date Name not MAtched ", Status.FAIL);
			}
			
			try {
				By dateName = By.xpath("//tr[contains(@id,'TRACTDATES_radYALGridControl')]/..//*[text()='"+map.get(Excel.Milestone)+"']/..//td[text()='"+map.get(Excel.ExpectedDate)+"']");
				Assert.assertTrue(util.isElementVisible(dateName));
				log("STEP 10: Expected Date Matched ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10: Expected Date not MAtched ", Status.FAIL);
			}
			
			try {
				By dateName = By.xpath("//tr[contains(@id,'TRACTDATES_radYALGridControl')]/..//*[text()='"+map.get(Excel.Milestone)+"']/..//td[text()='"+map.get(Excel.ActualDate)+"']");
				Assert.assertTrue(util.isElementVisible(dateName));
				log("STEP 11: Actual Date Matched ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11: Actual Date not MAtched ", Status.FAIL);
			}
					 ClickOnClose();
			}
			
			else if (testcaseName.contains("ROW") || testcaseName.contains("TRA")){
				
				try {
					RightClickOnDocumentGrid();
					log("STEP 7: when user right click on records 2 options should be displayed 1)Open in window. 2)Open in current window.  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 7:  User cannot right click on search results. ", Status.FAIL);
					throw new RuntimeException("Failed in step 7 ");
				}
				
				try {
					ClickOnOpeninPopupButton();
					util.dummyWait(1);
					ClickOnMilestoneDatePanelRow();
					log("STEP 8: User can navigate to Bulk Milestone panel ", Status.PASS);
				} catch (Exception e) {
					log("STEP 8: User not able navigate to Bulk Milestone panel  ", Status.FAIL);
					throw new RuntimeException("Failed in step 8 ");
				}
				
				try {
					By dateName = By.xpath("//tr[contains(@id,'TRACTDATES_radYALGridControl')]/..//*[text()='"+map.get(Excel.Milestone)+"']");
					Assert.assertTrue(util.isElementVisible(dateName));
					log("STEP 9: Date Name Matched ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 9: Date Name not MAtched ", Status.FAIL);
				}
				
				try {
					By dateName = By.xpath("//tr[contains(@id,'TRACTDATES_radYALGridControl')]/..//*[text()='"+map.get(Excel.Milestone)+"']/..//td[text()='"+map.get(Excel.ExpectedDate)+"']");
					Assert.assertTrue(util.isElementVisible(dateName));
					log("STEP 10: Expected Date Matched ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 10: Expected Date not MAtched ", Status.FAIL);
				}
				
				try {
					By dateName = By.xpath("//tr[contains(@id,'TRACTDATES_radYALGridControl')]/..//*[text()='"+map.get(Excel.Milestone)+"']/..//td[text()='"+map.get(Excel.ActualDate)+"']");
					Assert.assertTrue(util.isElementVisible(dateName));
					log("STEP 11: Actual Date Matched ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 11: Actual Date not MAtched ", Status.FAIL);
				}
				   		
					 util.dummyWait(1);
					 ClickOnClose();
				
			}
			
			else {
				
				try {
					RightClickOnDocumentGrid();
					log("STEP 7: when user right click on records 2 options should be displayed 1)Open in window. 2)Open in current window.  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 7:  User cannot right click on search results. ", Status.FAIL);
					throw new RuntimeException("Failed in step 7 ");
				}
				
				try {
					ClickOnOpeninPopupButton();
					util.dummyWait(1);
					ClickOnMilestoneDatePanelALT();
					log("STEP 8: User can navigate to Bulk Milestone panel ", Status.PASS);
				} catch (Exception e) {
					log("STEP 8: User not able navigate to Bulk Milestone panel  ", Status.FAIL);
					throw new RuntimeException("Failed in step 8 ");
				}
				
				 By getStrDateNameAlt = By.xpath("//tr[contains(@id,'TRACTDATES_radYALGridControl')]/..//*[text()='"+map.get(Excel.Milestone)+"']");
				 
				    By getStrExpectedDateAlt = By.xpath("//tr[contains(@id,'TRACTDATES_radYALGridControl')]/..//*[text()='"+map.get(Excel.Milestone)+"']/..//td[3]");
//				    By getStrActualDateAlt = By.xpath("//tr[contains(@id,'TRACTDATES_radYALGridControl')]/..//*[text()='"+map.get(Excel.Milestone)+"']/..//td[4]");
				    
				String DateNameAlt = util.getText(getStrDateNameAlt);
		   		log("Date Name is  :" + DateNameAlt);
					
					if (map.get(Excel.Milestone).equals(DateNameAlt)) {
						System.out.println(map.get(Excel.Milestone).equals(DateNameAlt));
						System.out.println(" Date Name  Matched !!!");
						log("STEP 9: Date Name  Matched !!!", Status.PASS);
					} else {
						System.out.println("Date Name  Not Matched !!!");
						log("STEP 9: Date Name  Not Matched !!!", Status.FAIL);
				    }
					
					
					String getExpectedDateAlt = util.getText(getStrExpectedDateAlt);
			   		log("Expected Date is  :" + getExpectedDateAlt);
					
					if (map.get(Excel.ExpectedDate).equals(getExpectedDateAlt)) {
						System.out.println(map.get(Excel.ExpectedDate).equals(getExpectedDateAlt));
						System.out.println("Expected Date  Matched !!!");
						log("STEP 10: Expected Date  Matched !!!", Status.PASS);
					} else {
						System.out.println("Expected Date  Not Matched !!!");
						log("STEP 10: Expected Date  Not Matched !!!", Status.FAIL);
				    }   
					
						
//						String getActualDateAlt = util.getText(getStrActualDateAlt);
//				   		log("Actual Date is  :" + getActualDateAlt);
//				   		
//				   		if (map.get(Excel.ActualDate).equals(getActualDateAlt)) {
//							System.out.println(map.get(Excel.ActualDate).equals(getActualDateAlt));
//							System.out.println(" Actual Date  Matched !!!");
//							log("STEP 11: Actual Date  Matched !!!", Status.PASS);
//						} else {
//							System.out.println("Actual Date  Not Matched !!!");
//							log("STEP 11: Actual Date Not Matched !!!", Status.FAIL);
//					    }   
				   		
					 util.dummyWait(1);
					 ClickOnClose();
			}
			}
       }else {
    	   log("Bulk  Parcel assignement option is not applicable for this client", Status.SKIP);
		}
    
			
			
			
   }   
}
