package pages.ToolsBulkEdit;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

public class BulkEdit_MyRequestPage extends BasePage{

	
	TestUtil util;
	CommonFunction commonFunction;

	public BulkEdit_MyRequestPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navTools = By.xpath("//span[text()='Tools']");
	By navBulkEdit = By.xpath("//span[contains(text(),'Bulk Edit')]");
	By navMyRequest = By.xpath("//span[contains(text(),'My Requests')]");
	
	By txtType = By.xpath("//input[contains(@id,'FilterTextBox_TYPE')]");
	By FilterType = By.xpath("//input[contains(@id,'_Filter_TYPE')]");
	By SelectFilterForType = By.xpath("//span[contains(text(),'Contains')]");
	
	By txtProjectName = By.xpath("//input[contains(@id,'FilterTextBox_PROJECT_NAME')]");
	By FilterProjectName = By.xpath("//input[contains(@id,'_Filter_PROJECT_NAME')]");
	By SelectFilterForProjectName = By.xpath("//span[contains(text(),'Contains')]");
	
	By txtAgreementNo = By.xpath("//input[contains(@id,'FilterTextBox_AGREEMENT_NO')]");
	By FilterAgreementNo = By.xpath("//input[contains(@id,'_Filter_AGREEMENT_NO')]");
	By SelectFilterForAgreementNo = By.xpath("//span[contains(text(),'NoFilter')]");
	
	By txtParcel = By.xpath("//input[contains(@id,'FilterTextBox_PARCEL')]");
	By FilterParcel = By.xpath("//input[contains(@id,'_Filter_PARCEL')]");
	By SelectFilterForParcel = By.xpath("//span[contains(text(),'NoFilter')]");
	
	By txtCurrentApprover = By.xpath("//input[contains(@id,'FilterTextBox_CURRENT_APPROVER')]");
	By FilterCurrentApprover = By.xpath("//input[contains(@id,'_Filter_CURRENT_APPROVER')]");
	By SelectFilterForCurrentApprover = By.xpath("//span[contains(text(),'Contains')]");
	
	By txtStatus = By.xpath("//input[contains(@id,'FilterTextBox_STATUS')]");
	By FilterStatus = By.xpath("//input[contains(@id,'_Filter_STATUS')]");
	By SelectFilterForStatus = By.xpath("//span[contains(text(),'Contains')]");
	
	By txtLink = By.xpath("//input[contains(@id,'FilterTextBox_LINKS')]");
    By ViewParcelLink = By.xpath("(//a[contains(text(),'View ')])[2]");
    
    public void NavigateToMyRequest() {
		util.waitUntilElementDisplay(navTools);
		util.click(navTools);
		util.waitUntilElementDisplay(navBulkEdit);
		util.hoverOnElement(navBulkEdit);
		util.click(navMyRequest);
//		WebElement web = driver.findElement(By.xpath("//span[contains(text(),'Bulk Edit')]"));
//		Actions obj = new Actions(driver);
//		obj.moveToElement(web).build().perform();
	}
	
	public void AddType(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtType, value);
	}
	
	public void ClickOnFilterType() {
		util.waitUntilElementDisplay(FilterType);
		util.click(FilterType);
	}
	
	public void SelectFilterForType() {
		util.waitUntilElementDisplay(SelectFilterForType);
		util.click(SelectFilterForType);
	}
	
	public void AddProjectName(String value) {
		util.waitUntilElementDisplay(txtProjectName);
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtProjectName, value);
	}
	
	public void ClickOnFilterProjectName() {
		util.waitUntilElementDisplay(FilterProjectName);
		util.click(FilterProjectName);
	}
	
	public void SelectFilterForProjectName() {
		util.waitUntilElementDisplay(SelectFilterForProjectName);
		util.click(SelectFilterForProjectName);
	}
	
	public void AddAgreementNo(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtAgreementNo, value);
	}
	
	public void ClickOnFilterAgreementNo() {
		util.waitUntilElementDisplay(FilterAgreementNo);
		util.click(FilterAgreementNo);
	}
	
	public void SelectFilterForAgreementNo() {
		util.waitUntilElementDisplay(SelectFilterForAgreementNo);
		util.click(SelectFilterForAgreementNo);
	}
	
	public void AddParcel(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtParcel, value);
	}
	
	public void ClickOnFilterParcel() {
		util.waitUntilElementDisplay(FilterParcel);
		util.click(FilterParcel);
	}
	
	public void SelectFilterForParcel() {
		util.waitUntilElementDisplay(SelectFilterForParcel);
		util.click(SelectFilterForParcel);
	}
	
	public void AddCurrentApprover(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtCurrentApprover, value);
	}
	
	public void ClickOnFilterCurrentApprover() {
		util.waitUntilElementDisplay(FilterCurrentApprover);
		util.click(FilterCurrentApprover);
	}
	
	public void SelectFilterForCurrentApprover() {
		util.waitUntilElementDisplay(SelectFilterForCurrentApprover);
		util.click(SelectFilterForCurrentApprover);
	}
	
	public void AddStatus(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtStatus, value);
	}
	
	public void ClickOnFilterStatus() {
		util.waitUntilElementDisplay(FilterStatus);
		util.click(FilterStatus);
	}
	
	public void SelectFilterForStatus() {
		util.waitUntilElementDisplay(SelectFilterForStatus);
		util.click(SelectFilterForStatus);
	}
	
	public void AddLink(String value) {
		if (!commonFunction.checkNA(value)) 
			util.inputTextAndPressTab(txtLink, value);
	}
	
   
    
	public void ClickOnViewParcelLink() {
		util.waitUntilElementDisplay(ViewParcelLink);
		util.click(ViewParcelLink);
		util.dummyWait(3);
		Set<String> windowId = driver.getWindowHandles(); // get window id of current window
		Iterator<String> itererator = windowId.iterator();
		String mainWinID = itererator.next();
		String newAdwinID = itererator.next();
		driver.switchTo().window(newAdwinID);
		driver.close();
		driver.switchTo().window(mainWinID);
		util.dummyWait(2);
	}
	
	
	public void BulkEditMyRequest(Map<String, String> map, String testcaseName) {		 
		
		   try {
			   NavigateToMyRequest();
				log("STEP 1:  User can navigate to My Request  page ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot navigate to My Request  page", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}

		   try {
			   AddType(map.get(Excel.Type));
				log("STEP 2: user can enter value in  Type textbox ", Status.PASS);
			} catch (Exception e) {
  			log("STEP 2: user cannot enter value in Type textbox  ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}	 
		   
		   try {
			   ClickOnFilterType();
				log("STEP 3: user can click on  Type filter  symbol  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user cannot click on filter symbol.", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		   
		   try {
			   SelectFilterForType();
				log("STEP 4: user can click on any filter ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: user cannot click on filter.", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		   
		   try {
			   AddProjectName(map.get(Excel.Project));
				log("STEP 5: user can enter value in Project Name textbox ", Status.PASS);
			} catch (Exception e) {
  		    	log("STEP 5: user cannot enter value in Project Name textbox  ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}	 
		   
		   try {
			   ClickOnFilterProjectName();
				log("STEP 6: user can click on Project Name filter symbol  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user cannot click on Project Name filter symbol.", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
		   
		   try {
			   SelectFilterForProjectName();
				log("STEP 7: user can click on any filter ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: user cannot click on filter.", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		   
		   
		   try {
			   AddAgreementNo(map.get(Excel.AgreementNo));
				log("STEP 8: user can enter value in Agreement No textbox ", Status.PASS);
			} catch (Exception e) {
  			log("STEP 8: user cannot enter value in Agreement No textbox  ", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}	 
		   
		   try {
			   ClickOnFilterAgreementNo();
				log("STEP 9: user can click on Agreement No filter symbol  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: user cannot click on Agreement No filter symbol.", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
		   
		   try {
			   SelectFilterForAgreementNo();
				log("STEP 10: user can click on any filter ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: user cannot click on filter.", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
		   
		   try {
			   AddParcel(map.get(Excel.Parcel));
				log("STEP 11: user can enter value in Parcel textbox ", Status.PASS);
			} catch (Exception e) {
  			log("STEP 11: user cannot enter value in Parcel textbox  ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}	 
		   
		   try {
			   ClickOnFilterParcel();
				log("STEP 12: user can click on Parcel filter symbol  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: user cannot click on Parcel filter symbol.", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
		   
		   try {
			   SelectFilterForParcel();
				log("STEP 13: user can click on any filter ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: user cannot click on filter.", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
		   
		   try {
			   AddCurrentApprover(map.get(Excel.CurrentApprover));
				log("STEP 14: user can enter value in Current Approver textbox ", Status.PASS);
			} catch (Exception e) {
     			log("STEP 14: user cannot enter value in Current Approver textbox  ", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}	 
		   
		   try {
			   ClickOnFilterCurrentApprover();
				log("STEP 15: user can click on Current Approver filter symbol  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: user cannot click on Current Approver filter symbol.", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
		   
		   try {
			   SelectFilterForCurrentApprover();
				log("STEP 16: user can click on any filter ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16: user cannot click on filter.", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
		   
		   try {
			   AddStatus(map.get(Excel.Status));
				log("STEP 17: user can enter value in Status textbox ", Status.PASS);
			} catch (Exception e) {
     			log("STEP 17: user cannot enter value in Status textbox  ", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}	 
		   
		   try {
			   ClickOnFilterStatus();
				log("STEP 18: user can click on Status filter symbol  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 18: user cannot click on Status filter symbol.", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
		   
		   try {
			   SelectFilterForStatus();
				log("STEP 19: user can click on any filter ", Status.PASS);
			} catch (Exception e) {
				log("STEP 19: user cannot click on filter.", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
		   
		   try {
			   AddLink(map.get(Excel.Link));
				log("STEP 20: user can enter value in Link textbox ", Status.PASS);
			} catch (Exception e) {
     			log("STEP 20: user cannot enter value in Link textbox  ", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}

		   if(util.isElementVisible(ViewParcelLink)) {
		   try {
			   ClickOnViewParcelLink();
				log("STEP 21: user can click on  link ", Status.PASS);
			} catch (Exception e) {
     			log("STEP 21:  user cannot click on link  ", Status.FAIL);
				throw new RuntimeException("Failed in step 21");
			}
		   }
	}
	
	By btnSaveChanges = By.xpath("(//a[contains(@id,'SaveChangesButton')])[1]");
	By btnCancelChanges = By.xpath("(//a[contains(@id,'CancelChangesButton')])[1]");
	
	public void ClickOnSaveChanges() {
		util.waitUntilElementDisplay(btnSaveChanges);
		util.click(btnSaveChanges);
		util.dummyWait(2);

	}
	
	public void ClickOnCancelChanges() {
		util.waitUntilElementDisplay(btnCancelChanges);
		util.click(btnCancelChanges);
		util.dummyWait(2);

	}
	
	  public void SaveChanges_CancelChanges(String testcaseName) {

		  if (testcaseName.contains("ROW")|| testcaseName.contains("DOT")||testcaseName.contains("ALT")|| testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL") || testcaseName.contains("TRA") ) {
				log(" SaveChanges_CancelChanges not applicable for ROW ,DOT,ALT", Status.SKIP);
			}
//			else {
//		 
//		  
//		  try {
//			   ClickOnSaveChanges();
//				log("STEP 1: user can click on save changes button  ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 1: user cannot click on save changes button  ", Status.FAIL);
//				throw new RuntimeException("Failed in step 1");
//			}
//		   
//		   try {
//			   ClickOnCancelChanges();
//				log("STEP 2: user can click on Cancel changes button ", Status.PASS);
//			} catch (Exception e) {
//				log("STEP 2: user cannot  click on Cancel changes button ", Status.FAIL);
//				throw new RuntimeException("Failed in step 2");
//			}
//		}  	  
	  }
	  
	  By btnAddToFavourite = By.xpath("//input[contains(@id,'idBulkEdit_btnAddToFavourite') and @type='submit']");
	  By btnRemoveFromFavourite = By.xpath("//input[contains(@id,'idBulkEdit_btnRemoveFromFavourite') and @type='submit']");
	  By ExportQVData = By.xpath("//input[contains(@id,'idBulkEdit_btnExport') and @type='submit']");
	  
	  
	  public void ClickOnAddToFavourite() {
			util.waitUntilElementDisplay(btnAddToFavourite);
			util.click(btnAddToFavourite);
			util.dummyWait(2);
			
		}
		
	  public void ClickOnRemoveFromFavorite() {
			util.waitUntilElementDisplay(btnRemoveFromFavourite);
			util.click(btnRemoveFromFavourite);
			util.dummyWait(2);
		}
	  
		public void ClickOnExportQVData() {
			util.waitUntilElementDisplay(ExportQVData);
			util.click(ExportQVData);
			util.dummyWait(2);

		}
		
		By MyDashboard = By.xpath("//span[contains(text(),'My Dashboard')]");
		By Myrequest = By.xpath("//td[contains(text(),'My Requests')]");
	  
		public void NavigateToMyDashboard() {
			util.waitUntilElementDisplay(navTools);
			util.click(navTools);
			util.waitUntilElementDisplay(MyDashboard);
			util.click(MyDashboard);
			util.dummyWait(1);
			 util.waitUntilElementDisplay(Myrequest);
	  	   Assert.assertTrue(util.isElementPresent(Myrequest), "My Requests");
			
		}
		
		
		
		public void ClickOnMyApproval() {
			util.waitUntilElementDisplay(Myrequest);
			util.click(Myrequest);
		}
		
		public void AddToFavourite_ExportQVData(String testcaseName) {
			
			if(util.isElementVisible(btnAddToFavourite)) {
			try {
				   ClickOnAddToFavourite();
					log("STEP 1:User can click on Add to favourite button. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: User cannot click on Add to favourite button.  ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
			}
			
			  NavigateToMyDashboard();
			   util.dummyWait(1);
			   ClickOnMyApproval();
			   
			   
			   try {
				   ClickOnExportQVData();
					log("STEP 2: User can click on Export QV data  button.  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: user cannot click on Export QV data button.   ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
			   
			   try {
				   ClickOnRemoveFromFavorite();
					log("STEP 3:User can click on Remove from favourite button. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: User cannot click on Remove from favourite button.  ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
			}
		
}
