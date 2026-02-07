package pages.RoyaltyPayment;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import pages.InfoByParcelReport.AddProjectPage;

public class ProjectPaymentManagerPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String FirstApprover;

	public ProjectPaymentManagerPage(WebDriver driver) {
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
	By userLink = By.xpath("//*[text()='Check Log Approvers']/..//a[text()='Users']");
	By iframeUser = By.xpath("//iframe[@name='WorkQueueUsers']");
	By userName = By.xpath("(//tr[contains(@id,'idEditWORKQUEUEMEMBERS_WORKQUEUEMEMBERS_radYALGridControl')]/..//td[4])[1]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	By btnApprove = By.xpath("//input[contains(@id,'_btnApproveBatch') and @type='image']");
	By ApprovalOptions = By.xpath("//em[text()='Approval Options']/..//span");
	By viewReportLink = By.xpath("//*[@id='Summary']/..//a[text()='View Report']");
	By paymentFileLink = By.xpath("//*[@id='Summary']/..//a[contains(text(),'$')]");
	By btnClose = By.xpath("//a[@title='Close']");
	
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
		util.waitUntilElementDisplay(ExpandSearchOption);
		util.click(ExpandSearchOption);
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
	
	public void ClickSearchButton() {
		util.waitUntilElementDisplay(btnSearch);
		util.click(btnSearch);
		util.dummyWait(2);
	}
	
	 public void ExpandprocessingOptionsPanel() {
			util.waitUntilElementDisplay(ExpandprocessingOptions);
			util.click(ExpandprocessingOptions);
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
	   
	   public void ClickOnUsersLink() {
			util.waitUntilElementDisplay(userLink);
			util.click(userLink);
			util.waitFor(200);
			util.switchToIframe(iframeUser);
		}
	   
	   public String getApprover(By xpath) {
            String name = driver.findElement(xpath).getText();
			String arr[]= name.split(" ");
		    FirstApprover=arr[1]+", "+arr[0];         
		    System.out.println(FirstApprover);
	
		    return FirstApprover;
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
	   
	public void approvePayment(Map<String, String> map,String testcaseName)  {
    	
    	try {
    		navigateToPaymentManager();
			log("STEP 1:user can navigate to payment  Manager.", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: user cannot navigate to payment Manager. ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			ClickOnSearchInformation();
			log("STEP 2: user can click on search information", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: user cannot click on search information ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		if(util.isElementVisible(ExpandSearchOption)) {
		try {
			ExpandSearchOptionPanel();
			log("STEP 3: user can expand search option panel & fields will be visible.", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user cannot expand search option panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		}
		
        try {
			SelectProject(AddProjectPage.PN);
			log("STEP 4: user can select project Name ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  user cannot select project Name", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			SelectPaymentStatus(map.get(Excel.PaymentStatus));
			log("STEP 5: user can select Payment Status ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user cannot select Payment Status ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		try {
			ClickSearchButton();
			log("STEP 6: user can click on search button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: user cannot  click on Search button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		if(util.isElementPresent(ExpandprocessingOptions)) {
		try {
			ExpandprocessingOptionsPanel();
			log("STEP 7: user can expand processing option panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot expand processing option panel. ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		}
		
		try {
			
			ClickOnPlusButton();
			log("STEP 8: user can click on plus button.", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user cannot click on plus button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			util.switchToIframe(iframeCheckBatch);
			util.waitFor(500);
			AddNewCheckLogName(map.get(Excel.CheckLog));
			log("STEP 9: user can enter value in New Check Log Name textbox. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot enter value in New Check Log Name textbox. ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
	
			try {
				ClickOnSaveButton();
				log("STEP 10:  user can click on save button.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: user cannot  value in textboxclick on save button.", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			try {
				util.waitFor(500);
				util.switchToDefaultContent();
				util.waitFor(500);
				SelectCheckLog(map.get(Excel.CheckLog));
				log("STEP 11: User can able to select newly created Check Log ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: No value display in Check Log DD", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
			util.waitFor(1000);
			try {
				By payment = By.xpath("(//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Pending']/../..//*[text()='"+map.get("Royalty Amount")+"']/..//input[contains(@id,'CheckBox')])[1]");
				util.click(payment);
				log("STEP 12: User can select Pending Payments ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User cannot select the Pending Payments   ", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
			util.waitFor(1000);
			try {
				ClickOnAddToCheckLog();
				log("STEP 13: User can click on add to check log button", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: User cannot click on add to check log button ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
			
            try {
				ClickOnSubmitCheckLog();
				util.dummyWait(1);
				log("STEP 14:  user can click on submit check log  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14:  user cannot click on submit check log   ", Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			} 
            
            if(environment.contains("STEELHEAD")) {
 			   try {
            		navigateToPaymentManager();
    				By checkLog = By.xpath("//strong[text()='" + map.get(Excel.CheckLog) + "']/..//*[text()='Submitted']");
    				util.click(checkLog);
    				util.dummyWait(1);
    				log("STEP 13:  user can select checklog", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 13:  user cannot select checklog", Status.FAIL);
    				throw new RuntimeException("Failed in step 13");
    			}
                
                try {
                	ClickOnApproveButtonSTEELHEAD();
    				log("STEP 14:  user can click on Approve button", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 14:  user cannot click on Approve button", Status.FAIL);
    				throw new RuntimeException("Failed in step 14");
    			} 
 		   }
            
            if(!environment.contains("CONNECTGEN") & !environment.contains("AKUOENERGY") & !environment.contains("NOVA")) {
            try {
				navigateToWorkQueue();
				log("STEP 15:  user can navigate to Work Queue ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15:  user cannot navigate to Work Queue", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			} 
            
            try {
				ClickOnUsersLink();
		       getApprover(userName);
		       util.switchToDefaultContent();
		       util.click(btnClose);
				log("STEP 16:  user can click on Users link ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16:  user cannot click on Users link   ", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			} 
            
            try {
				TurnOnDesignMode();
				log("STEP 17:  user can turn on design mode", Status.PASS);
			} catch (Exception e) {
				log("STEP 17:  user cannot turn on design mode", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			} 
            
            try {
            	SelectUser(FirstApprover);
				log("STEP 18:  user can select approver", Status.PASS);
			} catch (Exception e) {
				log("STEP 18:  user cannot select approver ", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			} 
            
            try {
            	navigateToPaymentManager();
				log("STEP 19:  user can navigate to Payment Manager", Status.PASS);
			} catch (Exception e) {
				log("STEP 19:  user cannot navigate to Payment Manager", Status.FAIL);
				throw new RuntimeException("Failed in step 19");
			} 
            }else if(environment.contains("NOVA")) {
            	
            	try {
					TurnOnDesignMode();
					log("STEP 15:  user can turn on design mode", Status.PASS);
				} catch (Exception e) {
					log("STEP 15:  user cannot turn on design mode", Status.FAIL);
					throw new RuntimeException("Failed in step 15");
				} 
	            
	            try {
	            	SelectUser(map.get("FirstApproverNOVA"));
					log("STEP 16:  user can select approver", Status.PASS);
				} catch (Exception e) {
					log("STEP 16:  user cannot select approver ", Status.FAIL);
					throw new RuntimeException("Failed in step 16");
				} 
	            
	            try {
	            	navigateToPaymentManager();
					log("STEP 17:  user can navigate to Payment Manager", Status.PASS);
				} catch (Exception e) {
					log("STEP 17:  user cannot navigate to Payment Manager", Status.FAIL);
					throw new RuntimeException("Failed in step 17");
				} 
            	
	            try {
	            	By checkLog= By.xpath("//strong[text()='"+map.get(Excel.CheckLog)+"']/..//*[text()='Submitted']");
	            	util.click(checkLog);
	            	util.dummyWait(1);
					log("STEP 18:  user can select checklog", Status.PASS);
				} catch (Exception e) {
					log("STEP 18:  user cannot select checklog", Status.FAIL);
					throw new RuntimeException("Failed in step 18");
				} 
	            
	            try {
	            	ClickOnApproveButton();
					log("STEP 19:  user can click on Approve button", Status.PASS);
				} catch (Exception e) {
					log("STEP 19:  user cannot click on Approve button", Status.FAIL);
					throw new RuntimeException("Failed in step 19");
				} 
            	
	            try {
	            	SelectUser(map.get("SecondApproverNOVA"));
					log("STEP 20:  user can select approver", Status.PASS);
				} catch (Exception e) {
					log("STEP 20:  user cannot select approver ", Status.FAIL);
					throw new RuntimeException("Failed in step 20");
				} 
	            
	            try {
	            	navigateToPaymentManager();
					log("STEP 21:  user can navigate to Payment Manager", Status.PASS);
				} catch (Exception e) {
					log("STEP 21:  user cannot navigate to Payment Manager", Status.FAIL);
					throw new RuntimeException("Failed in step 21");
				}
            	
            }else {
            	util.reloadPage();
            }
            
            try {
            	By checkLog= By.xpath("//strong[text()='"+map.get(Excel.CheckLog)+"']/..//*[text()='Submitted']");
            	util.click(checkLog);
            	util.waitFor(1000);
				log("STEP 20:  user can select checklog", Status.PASS);
			} catch (Exception e) {
				log("STEP 20:  user cannot select checklog", Status.FAIL);
				throw new RuntimeException("Failed in step 20");
			} 
            
            try {
            	ClickOnApproveButton();
				log("STEP 21:  user can click on Approve button", Status.PASS);
			} catch (Exception e) {
				log("STEP 21:  user cannot click on Approve button", Status.FAIL);
				throw new RuntimeException("Failed in step 21");
			} 
            
            if(util.isElementVisible(viewReportLink)) {
            try {
            	util.click(viewReportLink);
            	util.switchToChildWindow();
				log("STEP 22:  user can click on View Report Link", Status.PASS);
			} catch (Exception e) {
				log("STEP 22:  user cannot click on View Report Link", Status.FAIL);
				throw new RuntimeException("Failed in step 22");
			} 
            
            try {
            	By projectName= By.xpath("(//*[text()='"+AddProjectPage.PN+"'])[1]");
            	Assert.assertTrue(util.isElementVisible(projectName));
            	driver.close();
				util.switchToParentWindow();
				log("STEP 23:  user can see the payments in report", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 23:  user cannot see the payments in report", Status.FAIL);
				throw new RuntimeException("Failed in step 23");
			} 
            }
            
            try {
            	
            	util.click(paymentFileLink);
				log("STEP 24:  user can click on payment file link", Status.PASS);
			} catch (Exception e) {
				log("STEP 24:  user cannot click on payment file link", Status.FAIL);
				throw new RuntimeException("Failed in step 24");
			}
            
            try {
            	util.reloadPage();
            	By approvedCheckLog= By.xpath("//strong[text()='"+map.get(Excel.CheckLog)+"']/..//*[text()='Approved']");
            	Assert.assertTrue(util.isElementVisible(approvedCheckLog));
				log("STEP 25:  user can see the approved checklog Status", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 25:  user cannot see the approved checklog Status", Status.FAIL);
				throw new RuntimeException("Failed in step 25");
			}
    }

	
	
}
