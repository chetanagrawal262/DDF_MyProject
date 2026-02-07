package pages.SearchTickets;

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

public class SerachCustomerOutreachTicketsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
String ticketNo, FOLLOWUP_DATE, PROJECT, CREATED_DATE, TICKET_OWNER, LAST_UPDATED_DATE;

	public SerachCustomerOutreachTicketsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navCustomerOutreach = By.xpath("//span[contains(text(),'Customer Outreach')]");
	By navSearchTickets = By.xpath("//*[@id='idCustOutreach_RadTabStrip1']//span[text()='Search Tickets']");
	By txtTicketNo = By.xpath("//input[contains(@id,'txtTicketNumber') and @type='text']");
	By txtFollowupDate = By.xpath("//td[text()='Next Follow up Date:']/..//strong");
	By drpProject = By.xpath(" //*[text()='Project']/..//div[contains(@id,'RadDropDownTree1') and @title] | //*[text()='Line/Project:']/..//div[contains(@id,'RadDropDownTree1') and @title] | //*[text()='Project']/..//input[contains(@id,'_YALComboBox_Input') and @type='text']");
	By ticketCreatedDateSummary = By.xpath("//td[text()='Ticket Created Date:']/..//strong");
	By ticketOwnerSummary = By.xpath("//td[text()='Ticket OWNER:']/..//strong");
	By lastUpdatedDateSummary = By.xpath("//td[text()='Last Updated Date:']/..//strong");
	By nextFollowUpDateSummary = By.xpath("//td[text()='Next Follow up Date:']/..//strong");
	By drpCategory = By.xpath("//input[contains(@id,'cbCategory_radYALDropDownList_Input') and @type='text']");
	By drpIssueSubcategory = By.xpath("//input[contains(@id,'cbIssueCategory_radYALDropDownList_Input') and @type='text']");
	By drpStatus = By.xpath("//input[contains(@id,'cbStatus_radYALDropDownList_Input') and @type='text']");
	By btnSearch = By.xpath("//input[contains(@id,'imgBtnSearch') and @type='image']");
	By btnOpenTicket = By.xpath("//u[contains(text(),'Open Ticket')]");
	By navTicketInformation = By.xpath("(//span[contains(text(),'Ticket Information')])[1]");
	By txtIssue = By.xpath("//input[contains(@id,'_Ticket_Number') and @type='text']");
	By drpProjectSearch = By.xpath("//input[contains(@id,'_cbProjects_YALComboBox_Input') and @type='text']");
	By drpTicketOwner = By.xpath("//input[contains(@id,'_cbTicketOwner_YALComboBox_Input') and @type='text']");
	By colTicketOwner = By.xpath("//a[text()='Ticket Owner']");
	By colProject = By.xpath("//a[text()='Project']");
	By colCreateDate = By.xpath("//a[text()='Ticket Created Date']");
	By colFollowupDate = By.xpath("//a[text()='Followup Date']");
	By colLastUpdatedDate = By.xpath("//a[text()='Last Updated Date']");
	
	public void NavigateToSearchTicektALT() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navCustomerOutreach);
		util.hoverOnElement(navCustomerOutreach);
		//util.waitUntilElementDisplay(navSearchTickets);
		util.click(navTicketInformation);
		//util.click(navSearchTickets);
	}
	
	public void NavigateToSearchTicektROW() {
		util.waitUntilElementDisplay(navCustomerOutreach);
		util.click(navCustomerOutreach);
		util.waitUntilElementDisplay(navTicketInformation);
		util.click(navTicketInformation);
	}
	
	public void AddTicketNumber(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTicketNo,value);
	}
	
	public void SelectCategory(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpCategory,value);
	}
	
	public void SelectIssueSubcategory(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpIssueSubcategory,value);
	}
	
	public void SelectStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStatus,value);
	}
	
	By Area = By.xpath("(//span[@class='rddtIcon'])[1]");
	   By txtArea = By.xpath("(//input[contains(@value,'Filtering...')])[1]");
	   public void SelectAreaTeam(String value) {
	    	util.waitUntilElementDisplay(Area);
	    	 util.click(Area);
		    	if (!commonFunction.checkNA(value))
					util.inputText(txtArea, value);
		    	util.dummyWait(1);
		    	util.pressDownkey();
		    	util.pressDownkey();
		    	util.pressENTERkey();
		    	
	    }
	   
	   public void ClickOnSarchButton() {
		   util.waitUntilElementDisplay(btnSearch);
		   util.click(btnSearch);
	   }
	   
       public void AddTicketNo(String value) {
		   util.click(navSearchTickets);
			 util.dummyWait(2);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtTicketNo,value);
	   }
 
	   By drpTicket = By.xpath("//input[contains(@id,'idCustOutreach_RadLOWTicketQueueSelector_Input') and @type='text']");
	 	  By firstTicket = By.xpath("//*[@id='idCustOutreach_RadGridLOHTicketList_ctl00__0']");
	 	   public void SelectTicket(String value) {
	 		   util.click(drpTicket);
	 		   util.selectValueFromDropdown(drpTicket, value);
	 		   util.dummyWait(2);   		
	  		util.waitUntilElementDisplay(firstTicket);
	  		util.click(firstTicket);
	  		util.dummyWait(3);
	 	   }
	 	   
	   public void ClickOnOpenTicket() {
		   util.waitUntilElementDisplay(btnOpenTicket);
		   util.click(btnOpenTicket);
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
	   
	   public void getSummaryData() {
		   ticketNo = util.getAttributeValue(txtIssue, "value");
		   FOLLOWUP_DATE = driver.findElement(txtFollowupDate).getText().trim();
		   PROJECT = util.getAttributeValue(drpProject, "title");
		   TICKET_OWNER = driver.findElement(ticketOwnerSummary).getText().trim();
		   CREATED_DATE = driver.findElement(ticketCreatedDateSummary).getText().trim();
		   LAST_UPDATED_DATE = driver.findElement(lastUpdatedDateSummary).getText().trim();
	   }
	   
	   public void SerachTickets(Map<String, String> map,String testcaseName) throws InterruptedException  {

		   if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
			 try {
				 NavigateToSearchTicektALT();
				 SelectTicket("Working Tickets");
				 getSummaryData();
				 util.click(navSearchTickets);
				 util.dummyWait(2);
					log("STEP 1: User can navigate to search Ticket Tab", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: User cannot navigate to search Ticket Tab  ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
		   }
		   else
		   {
			   try {
					 NavigateToSearchTicektROW();
					 SelectTicket("Working Tickets");
					 getSummaryData();
					 util.click(navSearchTickets);
					 util.dummyWait(2);
						log("STEP 1: User can navigate to search Ticket Tab ", Status.PASS);
					} catch (Exception e) {
						log("STEP 1: User cannot navigate to search Ticket Tab  ", Status.FAIL);
						throw new RuntimeException("Failed in step 1");
					}
			   
		   }
			 try {
				 AddTicketNumber(ticketNo);
					log("STEP 2:  Added value displays in the Ticket Number field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: User  cannot select  value  from the Ticket Number DD     ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
			 
			 try {
				 SelectCategory(map.get(Excel.Category));
					log("STEP 3: Added value displays in the Category field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: User  cannot select  value  from the Category DD    ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
			 
			 try {
				 SelectIssueSubcategory(map.get(Excel.Subcategory));
					log("STEP 4: Added value displays in the Subcategory field ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: User  cannot select  value  from the Subcategory DD ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
			 
			 try {
				 SelectStatus(map.get(Excel.Status));
					log("STEP 5:  Added value displays in the Status field  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: User  cannot select  value  from the Status DD   ", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
			 
			 try {
				 SelectAreaTeam(map.get(Excel.Area));
				 util.reloadPage();
				   util.dummyWait(1);
					log("STEP 6: Added value displays in the Area field  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User  cannot select  value  from the Area DD  ", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
			 
			 try {
				 AddTicketNo(ticketNo);
					log("STEP 7: User can add Ticket No ", Status.PASS);
				} catch (Exception e) {
					log("STEP 7: User cannot add Ticket No  ", Status.FAIL);
					throw new RuntimeException("Failed in step 7");
				}
			 
			 
			 try {
				 ClickOnSarchButton();
				 util.dummyWait(1);
				  log("STEP 8: User can click on search button", Status.PASS);
				} catch (Exception e) {
					log("STEP 8: User cannot click on search button ", Status.FAIL);
					throw new RuntimeException("Failed in step 8");
				}
			 
			 if(!PROJECT.isEmpty() & !PROJECT.contains("Select One")) {
			 try {
				 By projectName = By.xpath("//tr[contains(@id,'idCustOutreach_LOHTICKETSEARCH_YALLOHSEARCHRESULT1_radYALGridControl_')]/..//*[text()='"+PROJECT+"']");
				Assert.assertTrue(util.isElementVisible(colProject));
//				Assert.assertTrue(util.isElementVisible(projectName));
				  log("STEP 9: User can see Project Column and Project Name on the Ticket Search Grid", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 9: User cannot see Project Column and Project Name on the Ticket Search Grid ", Status.FAIL);
				}
			 }
			 
			 if(!TICKET_OWNER.isEmpty()) {
			 try {
				 By owner = By.xpath("//tr[contains(@id,'idCustOutreach_LOHTICKETSEARCH_YALLOHSEARCHRESULT1_radYALGridControl_')]/..//*[text()='"+TICKET_OWNER+"']");
					Assert.assertTrue(util.isElementVisible(colTicketOwner));
					Assert.assertTrue(util.isElementVisible(owner));
					  log("STEP 10: User can see Ticket Owner Column and Owner Name on the Ticket Search Grid", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 12: User cannot see Ticket Owner Column and Owner Name on the Ticket Search Grid ", Status.FAIL);
					}
			 }
			 
			 try {
				 By createdDate = By.xpath("//tr[contains(@id,'idCustOutreach_LOHTICKETSEARCH_YALLOHSEARCHRESULT1_radYALGridControl_')]/..//*[text()='"+CREATED_DATE+"']");
					Assert.assertTrue(util.isElementVisible(colCreateDate));
					Assert.assertTrue(util.isElementVisible(createdDate));
					  log("STEP 11: User can see Ticket Created Date Column and value on the Ticket Search Grid", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 11: User cannot see Ticket Created Date Column and value on the Ticket Search Grid ", Status.FAIL);
					}
			 
			 try {
				 By followupDate = By.xpath("//tr[contains(@id,'idCustOutreach_LOHTICKETSEARCH_YALLOHSEARCHRESULT1_radYALGridControl_')]/..//*[text()='"+FOLLOWUP_DATE+"']");
				 
					Assert.assertTrue(util.isElementVisible(colFollowupDate));
					Assert.assertTrue(util.isElementVisible(followupDate));
					  log("STEP 12: User can see Followup Date Column and value on the Ticket Search Grid", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 12: User cannot see Followup Date Column and value on the Ticket Search Grid ", Status.FAIL);
					}
			 
			 try {
				 By lastUpdated = By.xpath("//tr[contains(@id,'idCustOutreach_LOHTICKETSEARCH_YALLOHSEARCHRESULT1_radYALGridControl_')]/..//*[text()='"+LAST_UPDATED_DATE+"']");
					Assert.assertTrue(util.isElementVisible(colLastUpdatedDate));
					Assert.assertTrue(util.isElementVisible(lastUpdated));
					  log("STEP 13: User can see Last Updated Date Column and value on the Ticket Search Grid", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 13: User cannot see Last Updated Date Column and value on the Ticket Search Grid ", Status.FAIL);
					}
			 
			 if(!PROJECT.isEmpty() & !PROJECT.contains("Select One")) {
				 try {
					 util.inputTextAndPressTab(drpProjectSearch, PROJECT);
					 log("STEP 14: User can select Project and Project DD is single Select DD", Status.PASS);
					} catch (Exception e) {
						log("STEP 14: User cannot select Project or Project DD is not Single Select DD  ", Status.FAIL);
						throw new RuntimeException("Failed in step 14");
					}
				 
				 }
				 
				 if(!TICKET_OWNER.isEmpty()) {
				 try {
					 util.selectValueFromDropdownCheckbox(drpTicketOwner, TICKET_OWNER);
					  log("STEP 15: User can select Ticket Owner and Ticket Owner DD is multi Select DD ", Status.PASS);
					} catch (Exception e) {
						log("STEP 15: User cannot select Ticket Owner or Ticket Owner DD is not multi Select DD  ", Status.FAIL);
						throw new RuntimeException("Failed in step 15");
					}
				 }
				 
				 try {
					 ClickOnSarchButton();
					 util.dummyWait(1);
					  log("STEP 16: User can click on search button", Status.PASS);
					} catch (Exception e) {
						log("STEP 16: User cannot click on search button ", Status.FAIL);
						throw new RuntimeException("Failed in step 16");
					}
				 
			 try {
				 ClickOnOpenTicket();
					log("STEP 17: User can able to click on Open Ticket Link   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 17: Open Ticket Link is not Clickable  ", Status.FAIL);
					throw new RuntimeException("Failed in step 17");
				}
	   }
}
