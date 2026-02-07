package pages.TicketAssociation;

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
import page.Common.LoginPage;

public class COSpecialPermissionPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public COSpecialPermissionPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navCustomerOutreach = By.xpath("//span[contains(text(),'Customer Outreach')]");
	By navTicketInformation = By.xpath("(//span[contains(text(),'Ticket Information')])[1]");
	By navSecurity = By.xpath("(//span[contains(text(),'Security')])[1]");
	By navUserRoles = By.xpath("(//span[contains(text(),'User Roles')])[1]");
	By navSpecialPermissions = By.xpath("(//span[contains(text(),'Special Permissions')])[1]");
	By reopenClosedTicketChecked = By.xpath("//label[contains(text(),'Reopen Closed Tickets')]/..//input[@checked='checked']");
	By reopenClosedTicketUnchecked = By.xpath("//label[contains(text(),'Reopen Closed Tickets')]/..//input[@type='checkbox']");
	By btnSavePermissions = By.xpath("//input[@id='ctl00_ConPHRightTop_savePermissions']");
	By btnLogOff = By.xpath("//input[@alt='Logout']");
	By hereLinkLogIn = By.xpath("//a[@id='UCLogoff_LoginUrl']");
	By btnSave = By.xpath("//input[contains(@id,'_btnSaveJob') and @type='button']");
    By btnSaveandAdd = By.xpath("(//input[contains(@id,'_btnSaveAddNew') and @type='button'])[1]");
    By btnAddNotes = By.xpath("//input[contains(@id,'_btnAddNotes')]");
    By btnAddDocuments = By.xpath("//input[contains(@id,'_btnAddDocuments')]");
    
    By drpTicket = By.xpath("//input[contains(@id,'idCustOutreach_RadLOWTicketQueueSelector_Input') and @type='text']");
	   
	   public void SelectTicket(String value) {
		   util.click(drpTicket);
		   util.selectValueFromDropdown(drpTicket, value);
		   util.dummyWait(2);
	   }
	   
	   public void NavigateToSpecialPermission() {
	    	util.waitUntilElementDisplay(navSpecialPermissions);
	    	util.click(navSpecialPermissions);
	    }
	   
	   public void NavigateToUserRoles() {
           util.waitUntilElementDisplay(navAdministration);
	    	util.click(navAdministration);
	    	util.waitUntilElementDisplay(navSecurity);
	    	util.click(navSecurity);
	    	util.waitUntilElementDisplay(navUserRoles);
	    	util.click(navUserRoles);
	    }
	   
	   public void NavigateToTicketInformationALT() {
		   util.waitUntilElementDisplay(navAdministration);
	    	util.click(navAdministration);
	    	util.waitFor(200);
	    	util.waitUntilElementDisplay(navCustomerOutreach);
	    	util.click(navCustomerOutreach);
	    	if(!util.isElementVisible(navTicketInformation)) {
	    	util.hoverOnElement(navCustomerOutreach);
	    	}
	    	util.click(navTicketInformation);
	    }
	   
	   public void  NavigateToTicketInformationRow() {
			util.waitUntilElementDisplay(navCustomerOutreach);
			util.click(navCustomerOutreach);
			util.waitUntilElementDisplay(navTicketInformation);
			util.click(navTicketInformation);   
	    }
	   
    public void ClickonSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    }
    
    By btnOk = By.xpath("//span[text()='OK']");
    public void ClickonSaveAndAddNew() {
    	util.waitUntilElementDisplay(btnSaveandAdd);
    	util.click(btnSaveandAdd);
    }
    
    
    By txtUsernameOld = By.xpath("//input[@id='UCLogin_txtUserName']"); 
	By txtPasswordOld = By.xpath("//input[@id='UCLogin_txtPassword']");    
	By txtUsername = By.xpath("//input[@id='UCLogin_inpTxtUserName']"); 
	By txtPassword = By.xpath("//input[@id='UCLogin_inpTxtPassword']");    
	By btnLogin = By.xpath("//input[@id='UCLogin_cmdSubmit_login']");
	
	public void setUserName(String userName) {
		if(util.isElementVisible(txtUsername)) {
		util.inputTextAndPressTab(txtUsername, userName);
		}else {
			util.inputTextAndPressTab(txtUsernameOld, userName);
		}
		
	}

	public void setPassword(String password) {
		if(util.isElementVisible(txtPassword)) {
			util.inputText(txtPassword, password);
		}else {
			util.inputText(txtPasswordOld, password);
		}
	}

	public void login(Map<String, String> map) {
		setUserName(map.get("NonSuperAdminUserName"));
		setPassword(map.get("Password2"));
		util.click(btnLogin);
	}
    
	By drpRole = By.xpath("//input[contains(@id,'DISTRIBUTION_Input')]");

	public void selectRoleDD(String value) {
		if (!commonFunction.checkNA(value))
			util.selectDropDownValue(drpRole, value);
	}
	
    public void VerifyReopenClosedTicketSpecialPermission(Map<String, String> map, String testcaseName, String Role) {
    	
    	try {
    		NavigateToUserRoles();
    		selectRoleDD(Role);
    		util.dummyWait(1);
	  		NavigateToSpecialPermission();
				log("STEP 1: User can Navigate to Special Permission", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  User cannot Navigate to Special Permission", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
    	
    	if(!util.isElementVisible(reopenClosedTicketChecked)) {
    		
    	try {
	  		util.click(reopenClosedTicketUnchecked);
				log("STEP 2: User can check the reopen closed ticket Special Permission", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  User cannot check the reopen closed ticket Special Permission", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
    	}
    	
    	try {
	  		util.click(btnSavePermissions);
	  		util.waitFor(500);
				log("STEP 3: User can save the Reopen Closed Ticket Special Permission", Status.PASS);
			} catch (Exception e) {
				log("STEP 3:  User cannot save the Reopen Closed Ticket Special Permission", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
    	
    	try {
	  		util.click(btnLogOff);
	  		if(util.isElementVisible(hereLinkLogIn)) {
	  		util.click(hereLinkLogIn);
	  		}else {
	  			navigateToApplication(appURL);
	  		}
				log("STEP 4: User can log off the application", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  User cannot log off the application", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
    	
    	try {
    		    login(map);
				log("STEP 5: User can logIn the application again", Status.PASS);
			} catch (Exception e) {
				log("STEP 5:  User cannot logIn the application again", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
    	
    	if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
    		try {
    			NavigateToTicketInformationRow();
    				log("STEP 6: User Can Navigate to Customer Outreach Ticket ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 6:  User Cannot Navigate to Customer Outreach Ticket", Status.FAIL);
    				throw new RuntimeException("Failed in step 6");
    			}
    	}
    	else {
    		try {
    	  		NavigateToTicketInformationALT();
    				log("STEP 6: User Can Navigate to Customer Outreach Ticket ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 6:  User Cannot Navigate to Customer Outreach Ticket", Status.FAIL);
    				throw new RuntimeException("Failed in step 6");
    			}
    	}
    	
    	try {
    		SelectTicket("Closed Tickets");
				log("STEP 7: User can select Closed Tickets  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  User cannot select Closed Tickets", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
    	
    	try {
	  		Assert.assertTrue(util.isElementVisible(btnSave));
				log("STEP 8: User can see Save button for the Closed Ticket and user can reopen the Closed tickets ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 8:  User cannot see Save button for the Closed Ticket", Status.FAIL);
			}
    	
    	try {
	  		Assert.assertTrue(util.isElementVisible(btnSaveandAdd));
				log("STEP 9: User can see Save and Add New button for the Closed Ticket and user can reopen the Closed tickets ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 9:  User cannot see Save and Add New button for the Closed Ticket", Status.FAIL);
			}
    	
    	try {
	  		Assert.assertTrue(util.isElementVisible(btnAddNotes));
				log("STEP 10: User can see Add Notes button for the Closed Ticket and user can reopen the Closed tickets ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 10:  User cannot see Add Notes button for the Closed Ticket", Status.FAIL);
			}
    	
    	try {
	  		Assert.assertTrue(util.isElementVisible(btnAddDocuments));
				log("STEP 11: User can see Add Docuemnts button for the Closed Ticket and user can reopen the Closed tickets", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 11:  User cannot see Add Docuemnts button for the Closed Ticket", Status.FAIL);
			}
    	ExtentTestManager.infoWithScreenshot("Reopen closed ticket special permission-checked");
    	try {
    		NavigateToUserRoles();
    		selectRoleDD(Role);
    		util.dummyWait(1);
	  		NavigateToSpecialPermission();
				log("STEP 12: User can Navigate to Special Permission", Status.PASS);
			} catch (Exception e) {
				log("STEP 12:  User cannot Navigate to Special Permission", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
    	
    	try {
	  		util.click(reopenClosedTicketUnchecked);
				log("STEP 13: User can unchecked the Reopen Closed Ticket Special Permission", Status.PASS);
			} catch (Exception e) {
				log("STEP 13:  User cannot unchecked the Reopen Closed Ticket Special Permission", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
    	
    	try {
	  		util.click(btnSavePermissions);
	  		util.waitFor(500);
				log("STEP 14: User can save the Reopen Closed Ticket Special Permission", Status.PASS);
			} catch (Exception e) {
				log("STEP 14:  User cannot save the Reopen Closed Ticket Special Permission", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
    	
    	try {
	  		util.click(btnLogOff);
	  		if(util.isElementVisible(hereLinkLogIn)) {
		  		util.click(hereLinkLogIn);
		  		}
	  		else {
  			navigateToApplication(appURL);
  		}
				log("STEP 15: User can log off the application", Status.PASS);
			} catch (Exception e) {
				log("STEP 15:  User cannot log off the application", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
    	
    	try {
		    login(map);
			log("STEP 16: User can logIn the application again", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:  User cannot logIn the application again", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
	
	if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
		try {
			NavigateToTicketInformationRow();
				log("STEP 17: User Can Navigate to Customer Outreach Ticket ", Status.PASS);
			} catch (Exception e) {
				log("STEP 17:  User Cannot Navigate to Customer Outreach Ticket", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
	}
	else {
		try {
	  		NavigateToTicketInformationALT();
				log("STEP 17: User Can Navigate to Customer Outreach Ticket ", Status.PASS);
			} catch (Exception e) {
				log("STEP 17:  User Cannot Navigate to Customer Outreach Ticket", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
	}
	
	try {
		SelectTicket("Closed Tickets");
			log("STEP 18: User can select Closed Tickets  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18:  User cannot select Closed Tickets", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
	
	try {
  		Assert.assertFalse(util.isElementVisible(btnSave));
			log("STEP 19: User cannot see Save button for the Closed Ticket, So user cannot reopen the closed tickets ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 19:  User can see Save button for the Closed Ticket", Status.FAIL);
		}
	
	try {
  		Assert.assertFalse(util.isElementVisible(btnSaveandAdd));
			log("STEP 20: User cannot see Save and Add New button for the Closed Ticket, So user cannot reopen the Closed tickets ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 20:  User can see Save and Add New button for the Closed Ticket", Status.FAIL);
		}
    }
    
    
}
