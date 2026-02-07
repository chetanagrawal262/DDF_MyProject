package pages.ProjectPaymentManager;

import java.util.ArrayList;
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
import page.Common.LoginPage;

public class CheckBatchApprovalPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String APPROVER, WBS_OPERATION, WBS_DEVELOPMENT, QLS_NUMBER, SALESFORCE_ID, STATE;
	List<String> approverList;

	public CheckBatchApprovalPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navPaymentManager = By.xpath("//span[contains(text(),'Payment Manager')]");
	By SearchInformation = By.xpath("//span[contains(text(),'Search Information')]");
	By ExpandSearchOption = By.xpath("//em[text()='Search Options']/..//a[@title='Expand']");
	By drpProjects = By.xpath("//input[contains(@id,'_Projects_radYALDropDownList_Input') and @type='text']");
	By drpPaymentStatus = By.xpath("//input[contains(@id,'_PaymentStatus_MSDropDown_Input') and @type='text']");
	By txtMinAmount = By.xpath("//td[contains(text(),'Min Amount :')]//input[@type='text']");
	By txtMaxAmount = By.xpath("//td[contains(text(),'Max Amount :')]//input[@type='text']");
	By btnSearch = By.xpath("//input[contains(@id,'_btnSearch') and @type='button']");
	By ExpandprocessingOptions = By.xpath("//em[text()='Processing Options']/..//a[@title='Expand']");
 	By btnPlus = By.xpath("//img[@alt='Create new check log']");
 	By iframeCheckBatch = By.xpath("//iframe[@name='AddCheckLog']");
 	By txtNewCheckLogName = By.xpath("//input[contains(@id,'ImportMappingName') and @type='text']");
 	By btnSave = By.xpath("//input[contains(@id,'SaveNewMapping') and @type='image']");
	By drpCheckLog = By.xpath("//input[contains(@id,'_chkBatch_radYALDropDownList_Input') and @type='text']");
	By btnSubmitCheckLog = By.xpath("//input[contains(@id,'_btnSubmitCheckLog') and @type='image']");
	By btnRefresh = By.xpath("//input[contains(@id,'_RefreshCheckList')]");
	By Checkbox = By.xpath("//table[contains(@id,'grdSearchPayments_radYALGridControl')]/../..//*[text()='Pending']/..//*[(@class=\"rowcheckbox\")] | //table[contains(@id,'grdSearchPayments')]/../..//*[text()='Pending']/..//input[contains(@id,'CheckBox')]");
	By btnAddtoCheckLog = By.xpath("//input[contains(@id,'_btnAddToBatch') and @type='image']"); 
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navConfiguration = By.xpath("//span[text()='Configuration']");
	By navWorkQueue = By.xpath("//span[text()='Work Queue']");
	By iframeUser = By.xpath("//iframe[@name='WorkQueueUsers']");
	By userName = By.xpath("(//tr[contains(@id,'idEditWORKQUEUEMEMBERS_WORKQUEUEMEMBERS_radYALGridControl')]/..//td[4])");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	By btnApprove = By.xpath("//input[contains(@id,'_btnApproveBatch') and @type='image']");
	By ApprovalOptions = By.xpath("//em[text()='Approval Options']/..//span");
	By viewReportLink = By.xpath("//*[@id='Summary']/..//a[text()='View Report']");
	By paymentFileLink = By.xpath("//*[@id='Summary']/..//a[contains(text(),'$')]");
	By btnClose = By.xpath("//a[@title='Close']");
	By paymentAddedMsg = By.xpath("//span[text()='Items added to check log successfully!']");
	By checkLogSubmittedMsg = By.xpath("//span[text()='Check log has been submitted for approval!']");
	
	public void navigateToPaymentManager() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navPaymentManager);
		util.click(navPaymentManager);
	}
	
	public void ClickOnSearchInformation() {
		util.waitUntilElementDisplay(SearchInformation);
		util.click(SearchInformation);
	}
	
	public void ExpandSearchOptionPanel() {
		if(util.isElementPresent(ExpandSearchOption)) {
		util.waitUntilElementDisplay(ExpandSearchOption);
		util.click(ExpandSearchOption);
	}
	}
	
	public void SelectProject(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpProjects, value);
	}
	
	By closeStatus = By.xpath("//a[contains(@id,'PaymentStatus_MSDropDown_Arrow')]");
	public void SelectPaymentStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.selectValueFromDropdownCheckbox(drpPaymentStatus, value);
		util.click(closeStatus); 
	}
	
	By drpAgreementTerm = By.xpath("//input[contains(@id,'_AgreementTerm_radYALDropDownList_Input') and @type='text']");
	public void SelectAgreementTerm(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgreementTerm, value);
	}
	
	public void EnterMinAmount(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMinAmount, value);
	}
	
	public void EnterMaxAmount(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMaxAmount, value);
	}
	
	public void ClickSearchButton() {
		util.waitUntilElementDisplay(btnSearch);
		util.click(btnSearch);
		util.dummyWait(2);
	}
	
	 public void ExpandprocessingOptionsPanel() {
		 if(util.isElementPresent(ExpandprocessingOptions)) {
			util.waitUntilElementDisplay(ExpandprocessingOptions);
			util.click(ExpandprocessingOptions);
		 }
	   }
	 
	 public void ClickOnPlusButton() {
	    	util.dummyWait(1);
	    	util.waitUntilElementDisplay(btnPlus);
	    	util.click(btnPlus);
	    }
	 
	 public void AddNewCheckLogName(String value) {
		   if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtNewCheckLogName, value);
	   }
	 
	 public void ClickOnSaveButton() {
		   util.waitUntilElementDisplay(btnSave);
		   util.click(btnSave);
		  
	 }

	   public void SelectCheckLog(String CheckLog) {
		  util.waitUntilElementDisplay(drpCheckLog);
		  util.selectValueFromDropdown(drpCheckLog, CheckLog);
		  util.pressENTERkey();
	   }

	    public void ClickOnCheckbox() {
		util.waitUntilElementDisplay(Checkbox);
		util.click(Checkbox);
	   }
	   
	   public void ClickOnAddToCheckLog() {
		   util.waitUntilElementDisplay(btnAddtoCheckLog);
		   util.click(btnAddtoCheckLog);
		   util.dummyWait(1);
	   }
	   
	   public void ClickOnSubmitCheckLog() {
		   util.waitUntilElementDisplay(btnSubmitCheckLog);
		   util.click(btnSubmitCheckLog);
	   }
	   
	   public void navigateToWorkQueue() {
			util.waitUntilElementDisplay(navAdministration);
			util.click(navAdministration);
			util.waitUntilElementDisplay(navConfiguration);
			util.click(navConfiguration);
			util.waitUntilElementDisplay(navWorkQueue);
			util.click(navWorkQueue);
		}
	   
	   public void ClickOnUsersLink(String workQueueName) {
		   By userLink = By.xpath("//*[text()='"+workQueueName+"']/..//a[text()='Users']");
			
			util.waitUntilElementDisplay(userLink);
			util.click(userLink);
			util.waitFor(200);
			util.switchToIframe(iframeUser);
		}
	   
	   public String getApprover(By xpath) {
            String name = driver.findElement(xpath).getText();
			String arr[]= name.split(" ");
			APPROVER=arr[1]+", "+arr[0];         
		    System.out.println(APPROVER);
	
		    return APPROVER;
				}
	   

     public List<String> getApproverList(By xpath) {
        List<WebElement> elements = driver.findElements(xpath);
        List<String> approvers = new ArrayList<>();

    for (WebElement element : elements) {
        String name = element.getText();
        String[] arr = name.split(" ");
        if (arr.length >= 2) {
            String formattedName = arr[1] + ", " + arr[0];
            approvers.add(formattedName);
        }
    }
    System.out.println("Approvers: " + approvers);
	return approvers;
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
	   
	   public void ClickOnApproveButton() {
		   if(!util.isElementVisible(btnApprove)) {
			   util.click(ApprovalOptions);
		   }
			util.waitUntilElementDisplay(btnApprove);
			util.click(btnApprove);
			util.dummyWait(2);
			util.click(ApprovalOptions);
			util.dummyWait(1);
		}
	   
	   public void ClickOnApproveButtonSTEELHEAD() {
		   if(!util.isElementVisible(btnApprove)) {
			   util.click(ApprovalOptions);
		   }
			util.waitUntilElementDisplay(btnApprove);
			util.click(btnApprove);
			util.waitFor(500);
			util.click(ApprovalOptions);
			
		}
	   
	   public void setPagesize(){
			By pagesize = By.xpath("//input[contains(@id,'PageSizeComboBox_Input')]");
			System.out.println("");
			By pageSize50 = By.xpath("//div[contains(@id,'PageSizeComboBox_DropDown')]/div/ul/li[3]");
			if(util.isElementPresent(pagesize)){
				util.click(pagesize);
				util.click(pageSize50);
			}
			else{
				System.out.println("Page Size option not shows");
			}
			
		}
	   
	   
	public void approvePayment(Map<String, String> map,String testcaseName)  {
    	
		if(util.isElementPresent(btnDesignMode)) {
            try {
				TurnOnDesignMode();
				log("STEP 1:  user can turn on design mode", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  user cannot turn on design mode", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			} 
            }
            
             try {
            	SelectUser("Support, Geo");
				log("STEP 2:  user can select approver", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  user cannot select approver ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			} 
		
		try {
    		navigateToPaymentManager();
			log("STEP 3:user can navigate to payment  Manager.", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user cannot navigate to payment Manager. ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		try {
			ClickOnSearchInformation();
			log("STEP 4: user can click on search information", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: user cannot click on search information ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			ExpandSearchOptionPanel();
			log("STEP 5: user can expand search option panel & fields will be visible.", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user cannot expand search option panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
        try {
			SelectProject(map.get(Excel.Project));
			log("STEP 6: user can select project Name ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  user cannot select project Name", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			SelectPaymentStatus(map.get(Excel.PaymentStatus));
			log("STEP 7: user can select Payment Status ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot select Payment Status ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			SelectAgreementTerm(map.get(Excel.AgreementTerm));
			log("STEP 8: user can select Agreement Term ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user cannot select Agreement Term ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			EnterMinAmount(map.get("MinAmount"));
			log("STEP 9: user can enter Min Amount value ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot enter Min Amount value ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			EnterMaxAmount(map.get("MaxAmount"));
			log("STEP 10: user can enter Max Amount value ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user cannot enter Max Amount value", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			ClickSearchButton();
			log("STEP 11: user can click on search button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot  click on Search button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			By state = By.xpath("(//input[contains(@id,'_grdSearchPayments_radYALGridControl')]/..//td[text()='"+STATE+"'])[1]");
			Assert.assertTrue(util.isElementVisible(state));
			log("STEP 12: User can see Project State in the Payment Search Grid  ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 12: user cannot  see Project State in the Payment Search Grid ", Status.FAIL);
		}
		
		if(testcaseName.contains("Development")) {
		try {
			By wbs = By.xpath("(//input[contains(@id,'_grdSearchPayments_radYALGridControl')]/..//td[text()='"+WBS_DEVELOPMENT+".01.D001"+"'])[1]");
			Assert.assertTrue(util.isElementVisible(wbs));
			log("STEP 13: User can see WBS in the Payment Search Grid for Development Payments ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 13: user cannot  see WBS in the Payment Search Grid for Development Payments", Status.FAIL);
		}
		}else {
			try {
				By wbs = By.xpath("(//input[contains(@id,'_grdSearchPayments_radYALGridControl')]/..//td[text()='"+WBS_OPERATION+".01.D001"+"'])[1]");
				Assert.assertTrue(util.isElementVisible(wbs));
				log("STEP 13: User can see WBS in the Payment Search Grid for Operational Payments  ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 13: user cannot  see WBS in the Payment Search Grid for Operational Payments ", Status.FAIL);
			}
		}
		
		try {
			By salesforceId = By.xpath("(//input[contains(@id,'_grdSearchPayments_radYALGridControl')]/..//td[text()='"+SALESFORCE_ID+"'])[1]");
			Assert.assertTrue(util.isElementVisible(salesforceId));
			log("STEP 14: User can see Salesforce ID in the Payment Search Grid  ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 14: user cannot  see Salesforce ID in the Payment Search Grid ", Status.FAIL);
		}
		
		try {
			By QLSNo = By.xpath("(//input[contains(@id,'_grdSearchPayments_radYALGridControl')]/..//td[text()='"+QLS_NUMBER+"'])[1]");
			Assert.assertTrue(util.isElementVisible(QLSNo));
			log("STEP 15: User can see QLS NUMBER in the Payment Search Grid  ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 15: user cannot QLS NUMBER in the Payment Search Grid ", Status.FAIL);
		}
		
		try {
			ExpandprocessingOptionsPanel();
			log("STEP 16: user can expand processing option panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: user cannot expand processing option panel. ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		try {
			
			ClickOnPlusButton();
			log("STEP 17: user can click on plus button.", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user cannot click on plus button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
		try {
			util.switchToIframe(iframeCheckBatch);
			util.waitFor(500);
			AddNewCheckLogName(map.get(Excel.CheckLog));
			log("STEP 18: user can enter value in New Check Log Name textbox. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: user cannot enter value in New Check Log Name textbox. ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		
	
			try {
				ClickOnSaveButton();
				log("STEP 19:  user can click on save button.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 19: user cannot  value in textboxclick on save button.", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			}
			
			try {
				util.waitFor(500);
				util.switchToDefaultContent();
				util.waitFor(500);
				SelectCheckLog(map.get(Excel.CheckLog));
				log("STEP 20: User can able to select newly created Check Log ", Status.PASS);
			} catch (Exception e) {
				log("STEP 20: No value display in Check Log DD", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			}
			util.waitFor(1000);
			try {
				By payment = By.xpath("(//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Pending']/..//input[contains(@id,'CheckBox')])[1]");
				util.click(payment);
				log("STEP 21: User can select Pending Payments ", Status.PASS);
			} catch (Exception e) {
				log("STEP 21: User cannot select the Pending Payments   ", Status.FAIL);
				throw new RuntimeException("Failed in step 21");
			}
			util.waitFor(1000);
			try {
				ClickOnAddToCheckLog();
				log("STEP 22: User can click on add to check log button", Status.PASS);
			} catch (Exception e) {
				log("STEP 22: User cannot click on add to check log button ", Status.FAIL);
				throw new RuntimeException("Failed in step 22");
			}
			
			try {
				Assert.assertTrue(util.isElementVisible(paymentAddedMsg));
				log("STEP 23: User can see 'Items added to check log successfully!' Message", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 23: User cannot see 'Items added to check log successfully!' Message ", Status.FAIL);
				throw new RuntimeException("Failed in step 23");
			}
			
            try {
				ClickOnSubmitCheckLog();
				util.dummyWait(1);
				log("STEP 24:  user can click on submit check log  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 24:  user cannot click on submit check log   ", Status.FAIL);
				throw new RuntimeException("Failed in step 24");
			} 
            
            try {
				Assert.assertTrue(util.isElementVisible(checkLogSubmittedMsg));
				log("STEP 25: User can see 'Check log has been submitted for approval!' Message", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 25: User cannot see 'Check log has been submitted for approval!' Message ", Status.FAIL);
				throw new RuntimeException("Failed in step 25");
			}
            
            try {
				navigateToWorkQueue();
				setPagesize();
				util.dummyWait(5);
				log("STEP 26:  user can navigate to Work Queue ", Status.PASS);
			} catch (Exception e) {
				log("STEP 26:  user cannot navigate to Work Queue", Status.FAIL);
				throw new RuntimeException("Failed in step 26");
			} 
            
            try {
				ClickOnUsersLink(map.get(Excel.WorkQueue));
             approverList = getApproverList(userName);
		       util.switchToDefaultContent();
		       util.click(btnClose);
				log("STEP 27:  user can click on Users link ", Status.PASS);
			} catch (Exception e) {
				log("STEP 27:  user cannot click on Users link   ", Status.FAIL);
				throw new RuntimeException("Failed in step 27");
			} 
            
            if(util.isElementPresent(btnDesignMode)) {
            try {
				TurnOnDesignMode();
				log("STEP 28:  user can turn on design mode", Status.PASS);
			} catch (Exception e) {
				log("STEP 28:  user cannot turn on design mode", Status.FAIL);
				throw new RuntimeException("Failed in step 28");
			} 
            }
            
            for (String APPROVER : approverList) {
            try {
            	SelectUser(APPROVER);
            	util.dummyWait(2);
				log("STEP 29:  user can select approver", Status.PASS);
			} catch (Exception e) {
				log("STEP 29:  user cannot select approver ", Status.FAIL);
				throw new RuntimeException("Failed in step 29");
			} 
            
            try {
            	navigateToPaymentManager();
				log("STEP 30:  user can navigate to Payment Manager", Status.PASS);
			} catch (Exception e) {
				log("STEP 30:  user cannot navigate to Payment Manager", Status.FAIL);
				throw new RuntimeException("Failed in step 30");
			} 
            
            try {
            	By checkLog= By.xpath("//strong[text()='"+map.get(Excel.CheckLog)+"']/..//*[text()='Submitted']");
            	util.click(checkLog);
            	util.waitFor(1000);
				log("STEP 31:  user can select checklog", Status.PASS);
			} catch (Exception e) {
				log("STEP 31:  user cannot select checklog", Status.FAIL);
				throw new RuntimeException("Failed in step 31");
			} 
            
            try {
            	ClickOnApproveButton();
				log("STEP 32:  user can click on Approve button", Status.PASS);
			} catch (Exception e) {
				log("STEP 32:  user cannot click on Approve button", Status.FAIL);
				throw new RuntimeException("Failed in step 32");
			} 
            }
            
            try {
            	util.reloadPage();
            	By approvedCheckLog= By.xpath("//strong[text()='"+map.get(Excel.CheckLog)+"']/..//*[text()='Approved']");
            	Assert.assertTrue(util.isElementVisible(approvedCheckLog));
				log("STEP 33:  user can see the approved checklog Status", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 33:  user cannot see the approved checklog Status", Status.FAIL);
				throw new RuntimeException("Failed in step 33");
			}
            
            try {
    			By state = By.xpath("(//input[contains(@id,'_grdLeasePayments_radYALGridControl')]/..//td[text()='"+STATE+"'])[1]");
    			Assert.assertTrue(util.isElementVisible(state));
    			log("STEP 34: User can see Project State in the Check Log Grid  ", Status.PASS);
    		} catch (AssertionError e) {
    			log("STEP 34: user cannot  see Project State in the Check Log Grid ", Status.FAIL);
    		}
    		
    		if(testcaseName.contains("Development")) {
    		try {
    			By wbs = By.xpath("(//input[contains(@id,'_grdLeasePayments_radYALGridControl')]/..//td[text()='"+WBS_DEVELOPMENT+".01.D001"+"'])[1]");
    			Assert.assertTrue(util.isElementVisible(wbs));
    			log("STEP 35: User can see WBS in the Check Log Grid for Development Payments ", Status.PASS);
    		} catch (AssertionError e) {
    			log("STEP 35: user cannot  see WBS in the Check Log Grid for Development Payments", Status.FAIL);
    		}
    		}else {
    			try {
    				By wbs = By.xpath("(//input[contains(@id,'_grdLeasePayments_radYALGridControl')]/..//td[text()='"+WBS_OPERATION+".01.D001"+"'])[1]");
    				Assert.assertTrue(util.isElementVisible(wbs));
    				log("STEP 35: User can see WBS in the Check Log Grid for Operational Payments  ", Status.PASS);
    			} catch (AssertionError e) {
    				log("STEP 35: user cannot  see WBS in the Check Log Grid for Operational Payments ", Status.FAIL);
    			}
    		}
    		
    		try {
    			By salesforceId = By.xpath("(//input[contains(@id,'_grdLeasePayments_radYALGridControl')]/..//td[text()='"+SALESFORCE_ID+"'])[1]");
    			Assert.assertTrue(util.isElementVisible(salesforceId));
    			log("STEP 36: User can see Salesforce ID in the Check Log Grid  ", Status.PASS);
    		} catch (AssertionError e) {
    			log("STEP 36: user cannot  see Salesforce ID in the Check Log Grid ", Status.FAIL);
    		}
    		
    		try {
    			By QLSNo = By.xpath("(//input[contains(@id,'_grdLeasePayments_radYALGridControl')]/..//td[text()='"+QLS_NUMBER+"'])[1]");
    			Assert.assertTrue(util.isElementVisible(QLSNo));
    			log("STEP 37: User can see QLS NUMBER in the Check Log Grid  ", Status.PASS);
    		} catch (AssertionError e) {
    			log("STEP 37: user cannot QLS NUMBER in the Check Log Grid ", Status.FAIL);
    		}
    		
    		try {
    			By agreementTerm = By.xpath("(//input[contains(@id,'_grdLeasePayments_radYALGridControl')]/..//td[text()='"+map.get(Excel.AgreementTerm)+"'])[1]");
    			Assert.assertTrue(util.isElementVisible(agreementTerm));
    			log("STEP 38: User can see Agreement Term in the Check Log Grid  ", Status.PASS);
    		} catch (AssertionError e) {
    			log("STEP 38: user cannot Agreement Term in the Check Log Grid ", Status.FAIL);
    		}
    }

	
	By txtProjectOprations = By.xpath("//span[text()='Project # Operations:']/..//input[@type='text']");
	public void AddProjectOperationNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtProjectOprations, value);
	}
	
	By txtProjectDevelopment = By.xpath("//span[text()='Project # Development:']/..//input[@type='text']");
	public void AddProjectDevelopmentNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtProjectDevelopment, value);
	}
	
	By projectState=By.xpath("(//table[contains(@id,'_PROJECTSTATECOUNTY_radYALGridControl')]/..//td[count(//table/thead/tr/th[.='State']/preceding-sibling::th)+1])[2]");
	By btnAddNewRecord = By.xpath("(//img[contains(@id,'PROJECTSTATECOUNTY_radYALGridControl')])[1]");
	By drpState = By.xpath("//input[contains(@id,'EditFormControl_RadState_Input')]");
	By drpCounty = By.xpath("//input[contains(@id,'EditFormControl_RadCounty_Input')]");
	By btnInsert = By.xpath("//input[contains(@id,'EditFormControl_btnInsert')]");
	public void setState(String state) throws InterruptedException {
		util.selectValueFromDropdown(drpState, state);
		util.pressENTERkey();
	}

	public void setCounty(String County) throws InterruptedException {
		util.selectValueFromDropdown(drpCounty, County);
		util.pressENTERkey();
	}

	public void clickInsetButton() {
		util.click(btnInsert);
	}
	
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navAgreementInformation = By.xpath("//a//span[contains(text(),'Agreement Information')] | //a//span[contains(text(),'Entity Information')]");
	
	public void navigateToAgreementInformationALT() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.dummyWait(1);
		util.waitForWebElementToBeClickableReturnElement(navAgreementManager).click();
		util.hoverOnElement(navAgreementManager);
		util.click(navAgreementInformation);
	}
	
	By txtSalesForceId = By.xpath("(//span[contains(text(),'Salesforce ID')]/..//input[@type='text'])[1]");
	private void addSalesForceId(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtSalesForceId, value);
		}
	}
	
	By txtQLSNumber = By.xpath("//span[text()='QLS Number:']/..//input[@type='text']");
	private void addQLSNumber(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputTextAndPressTab(txtQLSNumber, value);
		}
	}
	
	By saveButton = By.xpath("(//input[contains(@id,'_btnSave') and not(@disabled)])[1]");

	private void clickOnSaveButton() {
		util.click(saveButton);
		util.dummyWait(5);
	}
	
	By selectAgreement = By.xpath("//tr[contains(@id,'ConPHLeftTop_LSLST_RadGridTracts')][last()]");
	
	public void additionalInfo(Map<String, String> map,String testcaseName)  {
		try {
        	commonFunction.navigateToProjectDeails();
        	commonFunction.projectSelection();
        	log("STEP 1:  user can navigate to project details page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:  user cannot navigate to project details page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		} 
		
		try {
			WBS_OPERATION=map.get("ProjectOperationsNo");
			AddProjectOperationNo(map.get("ProjectOperationsNo"));
        	log("STEP 2:  user can enter Project # Operations", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  user cannot enter Project # Operations", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
       try {
    	   WBS_DEVELOPMENT=map.get("ProjectDevelopmentNo");
    	   AddProjectDevelopmentNo(map.get("ProjectDevelopmentNo"));
        	log("STEP 3:  user can enter Project # Development", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  user cannot enter Project # Development", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
       
       try {
    	   commonFunction.clickOnSaveButton();
       	   log("STEP 4:  user can click on Save Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  user cannot click on Save Button", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
       
       if(!util.isElementPresent(projectState)) {
    	   try {
   			util.waitUntilElementDisplay(btnAddNewRecord);
   			util.click(btnAddNewRecord);
   			log("STEP 5: User can click on Add New Record button of Project states and County information panel", Status.PASS);
   		} catch (Exception e) {
   			log("STEP 5: User cannot click on Add New Record button of Project states and County information panel", Status.FAIL);
   			throw new RuntimeException("Failed in step 1 ");
   		}
   		try {
   			setState(map.get(Excel.State));
   			util.waitUntilLoaderDisappear();
   			log("STEP 6:  State added diplays in the state column    ", Status.PASS);
   		} catch (InterruptedException e) {
   			log("STEP 6: Added state is not displayed in the field", Status.FAIL);
   			throw new RuntimeException("Failed in step 6 ");
   		}
   		try {
   			setCounty(map.get(Excel.County));
   			log("STEP 7: County added diplays in the column field", Status.PASS);
   		} catch (InterruptedException e) {
   			log("STEP 7:  Added county is not displayed in the field", Status.FAIL);
   			throw new RuntimeException("Failed in step 7");
   		}
   		try {
   			clickInsetButton();
   			util.waitUntilLoaderDisappear();
   			log("STEP 8: User can click on Insert button ", Status.PASS);
   		} catch (Exception e) {
   			log("STEP 8: User can not click on Insert Button", Status.FAIL);
   			throw new RuntimeException("Failed in step 8 ");
   		}
       }
       
       STATE=util.getText(projectState);
			System.out.println("State is "+STATE);
       
       try {
    	   navigateToAgreementInformationALT();
    	   util.click(selectAgreement);
         	util.dummyWait(2);
       	    log("STEP 9:  user can navigate to Agreement Manager page", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  user cannot navigate to Agreement Manager page", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		} 
       
       try {
    	   SALESFORCE_ID = map.get("SalesforceID");
			addSalesForceId(SALESFORCE_ID);
       	    log("STEP 10:  user can add Salesforce ID", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  user cannot add Salesforce ID", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
       
       try {
    	   QLS_NUMBER = map.get("QLSNumber");
			addQLSNumber(QLS_NUMBER);
       	    log("STEP 11:  user can add QLS Number", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  user cannot add QLS Number", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
       
       try {
    	   clickOnSaveButton();
       	    log("STEP 12:  user can click on Save Button", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  user cannot click on Save Button", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
       
	}
	
}
