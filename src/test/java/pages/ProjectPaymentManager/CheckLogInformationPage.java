package pages.ProjectPaymentManager;



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

public class CheckLogInformationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String FirstApprover, MAIN_USER, AGREEMENT_NUMBER, LO_NAME, SUBMITTED_BY, NEXT_REVIEWER, ACTION, PAYMENT_AMOUNT;

	public CheckLogInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navPaymentManager = By.xpath("//span[contains(text(),'Payment Manager')]");
	By successmessage = By.xpath("//span[text()='Check log has been approved!']");
	By PaymentFileLink = By.xpath("//*[@id='Summary']/..//a");
	By PaymentFileLinkROW = By.xpath("//a[contains(text(),'Download DAT File')]");
	By txtPaymentTerm = By.xpath("//input[contains(@id,'_FilterTextBox_Payment_Terms') and @type='text']");
	By FilterIcon = By.xpath("//input[contains(@id,'_Filter_Payment_Terms') and @type='submit']");
	By SelectFilter = By.xpath("//span[text()='Contains']");
	
	public void navigateToPaymentManager() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navPaymentManager);
		util.click(navPaymentManager);
	}
	
	By checklog = By.xpath("//span[contains(text(),'Check Log Information')]");
	public void ExpandApprovalOptionsPanel() {
		util.waitUntilElementDisplay(checklog);
		util.click(checklog);
		util.dummyWait(2);
		util.waitUntilElementDisplay(ApprovalOptions);
		util.click(ApprovalOptions);
	}
	
	public void SetPaymentTerm(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPaymentTerm, value);	
	}	
	
	public void ClickOnFilterIcon() {
		util.waitUntilElementDisplay(FilterIcon);
		util.click(FilterIcon);
	}	
	
	public void SelectFilter() {
		util.waitUntilElementDisplay(SelectFilter);
		util.click(SelectFilter);
	}
	
	public void SelectCheckLog(String value) {
		By selectChecklog = By.xpath("//*[contains(@id,'RadGridTracts')]/tbody/..//*[text()='" +value +"']");
		util.waitUntilElementDisplay(selectChecklog);
		util.click(selectChecklog);
		util.dummyWait(3);
		if(util.isElementVisible(ApprovalOptions)) {
		util.click(ApprovalOptions);
		}
	}
	
	public void SelectCheckLogROW(String value) {
		By selectChecklog = By.xpath("//*[contains(@id,'RadGridTracts')]/tbody/..//*[text()='" +value +"']");
		util.waitUntilElementDisplay(selectChecklog);
		util.click(selectChecklog);
		util.dummyWait(5);
		if(util.isElementVisible(ApprovalOptions)) {
			util.click(ApprovalOptions);
			}
	}

	public void ClickonPaymentFileLink() {
		util.waitUntilElementDisplay(PaymentFileLink);
		util.click(PaymentFileLink);
		util.dummyWait(2);
		util.click(btnClose);
		util.dummyWait(2);
	}
	
	public void ClickonPaymentFileLinkRow() {
		util.waitUntilElementDisplay(PaymentFileLinkROW);
		util.click(PaymentFileLinkROW);
		util.dummyWait(2);
		util.click(btnClose);
		util.dummyWait(2);
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navConfiguration = By.xpath("//span[text()='Configuration']");
	By navWorkQueue = By.xpath("//span[text()='Work Queue']");
	By userLink = By.xpath("//*[text()='Check Log Approvers']/..//a[text()='Users']");
	By iframeUser = By.xpath("//iframe[@name='WorkQueueUsers']");
	By userName = By.xpath("(//tr[contains(@id,'idEditWORKQUEUEMEMBERS_WORKQUEUEMEMBERS_radYALGridControl')]/..//td[4])[1]");
	By btnAddNew = By.xpath("//*[contains(@id,'idEditWORKQUEUEMEMBERS_WORKQUEUEMEMBERS_radYALGridControl')]/../..//img[@alt='Add new record']");
	By drpWorkUser = By.xpath("//input[contains(@id,'EditFormControl_idEditWorkQueue_cbUserIDs_YALComboBox_Input')]");
	By txtProcessOrder = By.xpath("//input[contains(@id,'_EditFormControl_idEditWorkQueue_Process_Order')]");
	By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert')]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By drpUser= By.xpath("//input[contains(@id,'_YALHD_mockUserID_radYALDropDownList_Input')]");
	By btnApprove = By.xpath("//input[contains(@id,'_btnApproveBatch') and @type='image']");
	By ApprovalOptions = By.xpath("//em[text()='Approval Options']/..//span[@class='rdExpand']");
	By viewReportLink = By.xpath("//*[@id='Summary']/..//a[text()='View Report']");
	By paymentFileLink = By.xpath("//*[@id='Summary']/..//a[contains(text(),'$')]");
	By btnClose = By.xpath("//a[@title='Close']");
	By agreementNumber = By.xpath("(//tr[contains(@id,'ctl00_ConPHRightTop_grdLeasePayments_')]/..//a[contains(@onclick,'LeaseManager')])[1]");
	By loName = By.xpath("(//table[contains(@id,'ctl00_ConPHRightTop_grdLeasePayments_')]/..//td[count(//table/thead/tr/th[.='Landowner Name']/preceding-sibling::th)-3])[2]");
	By loNameConnectgen = By.xpath("(//table[contains(@id,'ctl00_ConPHRightTop_grdLeasePayments_')]/..//td[count(//table/thead/tr/th[.='Landowner Name']/preceding-sibling::th)-4])[2]");
	By loNameSteelhead = By.xpath("(//table[contains(@id,'ctl00_ConPHRightTop_grdLeasePayments_')]/..//td[count(//table/thead/tr/th[.='Payee Name 1']/preceding-sibling::th)+1])[2]");
	
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
			String arr[] = name.split(" ");
			FirstApprover = arr[1] + ", " + arr[0];
			System.out.println(FirstApprover);

			return FirstApprover;
		}

		public void ClickAddNew() {
			util.waitUntilElementDisplay(btnAddNew);
			util.click(btnAddNew);
			util.waitFor(200);
		}
		
		public void SelectWorkQueueUser(String value) {
			if (!commonFunction.checkNA(value)) {
				util.inputText(drpWorkUser, value);
				util.pressDownkey();
				util.pressENTERkey();
			}
		}

		public void addProcessOrder(String value) {
			if (!commonFunction.checkNA(value)) {
				util.inputTextAndPressTab(txtProcessOrder, value);
			}
		}

		public void ClickOnInsert() {
			util.waitUntilElementDisplay(btnInsert);
			util.click(btnInsert);
			util.waitFor(200);
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
			util.waitUntilElementDisplay(btnApprove);
			util.click(btnApprove);
			util.waitFor(500);
			util.reloadPage();
			util.waitUntilPageLoad();
			util.click(ApprovalOptions);
			
		}
	   
	   public void ClickOnApproveButtonSTEELHEAD() {
		   if(!util.isElementVisible(btnApprove)) {
			   util.click(ApprovalOptions);
		   }
			util.waitUntilElementDisplay(btnApprove);
			util.click(btnApprove);
			util.waitFor(500);
			
			if(util.isElementVisible(ApprovalOptions)) {
			util.click(ApprovalOptions);
			}
			
		}
	   
	   By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
		By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
		By navAgreementInformation = By.xpath("//a//span[contains(text(),'Agreement Information')] | //a//span[contains(text(),'Entity Information')]");
		public void navigateToAgreementInformationALT() {
			util.waitUntilElementDisplay(navProjectMenu);
			util.click(navProjectMenu);
			util.waitUntilElementDisplay(navAgreementManager);
			util.click(navAgreementManager);
			util.waitUntilElementDisplay(navAgreementInformation);
			util.click(navAgreementInformation);
		}
		
		By saveButtonLO = By.xpath("//input[@id='btnSaveLO']");
		private void clickOnSaveButtonLandOwner() {
			util.click(saveButtonLO);
		}
		
		By submittedBy= By.xpath("(//table[contains(@id,'_RadGridAuditTrail_')]/..//td[count(//table/thead/tr/th[.='Approver']/preceding-sibling::th)+1])[1]");
		By nextReviewerRamaco= By.xpath("(//table[contains(@id,'_RadGridAuditTrail_')]/..//td[count(//table/thead/tr/th[.='Approver']/preceding-sibling::th)+1])[2]");
		By nextReviewer= By.xpath("(//table[contains(@id,'_RadGridAuditTrail_')]/..//td[count(//table/thead/tr/th[.='Next Reviewer(S)']/preceding-sibling::th)+1])[1]");
		By action= By.xpath("(//table[contains(@id,'_RadGridAuditTrail_')]/..//td[count(//table/thead/tr/th[.='Action']/preceding-sibling::th)+1])[1]");
		By approvedBy= By.xpath("(//table[contains(@id,'_RadGridAuditTrail_')]/..//td[count(//table/thead/tr/th[.='Approver']/preceding-sibling::th)+1])[2]");
		By approvedAction= By.xpath("(//table[contains(@id,'_RadGridAuditTrail_')]/..//td[count(//table/thead/tr/th[.='Action']/preceding-sibling::th)+1])[2]");
		
	   public void CheckLogInformation(Map<String, String> map, String testcaseName)  {

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
		  
		   if(!environment.contains("CONNECTGEN") & !environment.contains("NOVA") & !environment.contains("AKUOENERGY")) {
	           
			   if(!environment.contains("STEELHEAD")) {
				   try {
		            	By checkLog= By.xpath("//strong[text()='"+map.get(Excel.CheckLog)+"']/..//*[text()='Submitted']");
		            	util.click(checkLog);
		            	util.dummyWait(1);
		            	if(util.isElementVisible(ApprovalOptions)) {
		     			   util.click(ApprovalOptions);
		     		   }
						log("STEP 15:  user can select Submitted checklog", Status.PASS);
					} catch (Exception e) {
						log("STEP 15:  user cannot select Submitted checklog", Status.FAIL);
					}
				   
				   try {
					   SUBMITTED_BY = util.getText(submittedBy);
					   Assert.assertTrue(SUBMITTED_BY !=null && !SUBMITTED_BY.trim().isEmpty());
		            	log("STEP 16:  user can see Approver/Submitted By Text on Approver Grid", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 16:  user cannot see Approver/Submitted By Text on Approver Grid", Status.FAIL);
					}
				   
				   if(!environment.contains("RAMACO")) {
				   try {
		            	NEXT_REVIEWER = util.getText(nextReviewer);
		            	Assert.assertTrue(NEXT_REVIEWER !=null && !NEXT_REVIEWER.trim().isEmpty());
		            	log("STEP 17:  user can see Next Reviewer(s) on Approver Grid", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 17:  user cannot see Next Reviewer(s) on Approver Grid", Status.FAIL);
					}
				   }else {
					   try {
			            	NEXT_REVIEWER = util.getText(nextReviewerRamaco);
			            	Assert.assertTrue(NEXT_REVIEWER !=null && !NEXT_REVIEWER.trim().isEmpty());
			            	log("STEP 17:  user can see Next Reviewer(s) on Approver Grid", Status.PASS);
						} catch (AssertionError e) {
							log("STEP 17:  user cannot see Next Reviewer(s) on Approver Grid", Status.FAIL);
						}
				   }
				   
				   try {
		            	ACTION = util.getText(action);
		            	Assert.assertNotNull(ACTION);
		            	Assert.assertEquals(ACTION, "Submitted","Action 'Submitted' is not displayed in Action Column");
		            	log("STEP 18:  user can see Action on Approver Grid", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 18:  user cannot see Action on Approver Grid", Status.FAIL);
					}
				   ExtentTestManager.infoWithScreenshot("Next Reviewer(s) are displayed on Approver Grid");
			   }
			   
			   
			   try {
					navigateToWorkQueue();
					log("STEP 19:  user can navigate to Work Queue ", Status.PASS);
				} catch (Exception e) {
					log("STEP 19:  user cannot navigate to Work Queue", Status.FAIL);
					throw new RuntimeException("Failed in step 19");
				} 
	            
	            try {
					ClickOnUsersLink();
					log("STEP 20:  user can click on Users link ", Status.PASS);
				} catch (Exception e) {
					log("STEP 20:  user cannot click on Users link   ", Status.FAIL);
					throw new RuntimeException("Failed in step 20");
				} 
	            
	            if(util.isElementVisible(userName)) {
	            	 getApprover(userName);
				       
	            }else {
	            	try {
	            		ClickAddNew();
						log("STEP 21:  user can click on Add New Record button ", Status.PASS);
					} catch (Exception e) {
						log("STEP 21: user cannot click on Add New Record button", Status.FAIL);
						throw new RuntimeException("Failed in step 21");
					} 
	            	
	            	try {
	            	SelectWorkQueueUser(map.get("User"));//need to add column in excel sheet
	            	FirstApprover=map.get("User");
	            		log("STEP 22:  user can select User Name from the dd ", Status.PASS);
					} catch (Exception e) {
						log("STEP 22: user cannot select User Name from the dd", Status.FAIL);
						throw new RuntimeException("Failed in step 22");
					}
	            	
	            	try {
	            	addProcessOrder(map.get("ProcessOrder"));//need to add column in excel sheet
	            		log("STEP 23: user can add Process Order ", Status.PASS);
					} catch (Exception e) {
						log("STEP 23: user cannot add Process Order", Status.FAIL);
						throw new RuntimeException("Failed in step 23");
					}
	            	
	            	try {
	            		ClickOnInsert();
	            		log("STEP 24: user can click on Insert button ", Status.PASS);
					} catch (Exception e) {
						log("STEP 24: user cannot click on Insert button", Status.FAIL);
						throw new RuntimeException("Failed in step 24");
					}
	            }
	            
	            util.switchToDefaultContent();
			       util.click(btnClose);
			       
	            try {
					TurnOnDesignMode();
					//MAIN_USER=map.get("MainUser");
					log("STEP 25:  user can turn on design mode", Status.PASS);
				} catch (Exception e) {
					log("STEP 25:  user cannot turn on design mode", Status.FAIL);
					throw new RuntimeException("Failed in step 25");
				} 
	            
	            try {
	            	SelectUser(FirstApprover);
					log("STEP 26:  user can select approver", Status.PASS);
				} catch (Exception e) {
					log("STEP 26:  user cannot select approver ", Status.FAIL);
					throw new RuntimeException("Failed in step 26");
				} 
	            
	            try {
	            	navigateToPaymentManager();
					log("STEP 27:  user can navigate to Payment Manager", Status.PASS);
				} catch (Exception e) {
					log("STEP 27:  user cannot navigate to Payment Manager", Status.FAIL);
					throw new RuntimeException("Failed in step 27");
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
	            	util.dummyWait(1);
					log("STEP 28:  user can select checklog", Status.PASS);
				} catch (Exception e) {
					log("STEP 28:  user cannot select checklog", Status.FAIL);
					throw new RuntimeException("Failed in step 28");
				} 
	            
	            try {
	            	ClickOnApproveButton();
					log("STEP 29:  user can click on Approve button", Status.PASS);
				} catch (Exception e) {
					log("STEP 29:  user cannot click on Approve button", Status.FAIL);
					throw new RuntimeException("Failed in step 29");
				} 
	            
	            if(!environment.contains("STEELHEAD") & !environment.contains("CONNECTGEN") & !environment.contains("NOVA") & !environment.contains("AKUOENERGY") & !environment.contains("RAMACO")) {
					   try {
						   String ApprovedBy = util.getText(approvedBy);
			            	Assert.assertNotNull(ApprovedBy);
			            	Assert.assertEquals(ApprovedBy, NEXT_REVIEWER, "Approver Name is not matched with Next Reviewer Name");
			            	log("STEP 30:  user can see Approver Name on Approver Grid", Status.PASS);
						} catch (AssertionError e) {
							log("STEP 30:  user cannot see Approver Name on Approver Grid", Status.FAIL);
						}
					   
					  try {
			            	ACTION = util.getText(approvedAction);
			            	Assert.assertNotNull(map);
			            	Assert.assertEquals(ACTION, "Approved","Action 'Approved' is not displayed in Action Column");
			            	log("STEP 31:  user can see Approved Action on Approver Grid", Status.PASS);
						} catch (AssertionError e) {
							log("STEP 31:  user cannot see Approved Action on Approver Grid", Status.FAIL);
						}
					   ExtentTestManager.infoWithScreenshot(" Approver Grid of Approved Check is displayed with Approver Name and Action");
				   }
	            
	            if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
	            	AGREEMENT_NUMBER= util.getText(agreementNumber);
	            	if(environment.contains("CONNECTGEN")) {
                		LO_NAME= util.getText(loNameConnectgen);
					} else if (environment.contains("STEELHEAD")) {
						LO_NAME = util.getText(loNameSteelhead);
					}else {
	            	LO_NAME= util.getText(loName);
	            	}
	            }
	            if(util.isElementVisible(viewReportLink)) {
	            try {
	            	util.click(viewReportLink);
	            	util.switchToChildWindow();
					log("STEP 32:  user can click on View Report Link", Status.PASS);
				} catch (Exception e) {
					log("STEP 32:  user cannot click on View Report Link", Status.FAIL);
					throw new RuntimeException("Failed in step 32");
				} 
	            
	            try {
	            	By projectName= By.xpath("(//*[text()='"+map.get("ProjectName")+"'])[1]");
	            	Assert.assertTrue(util.isElementVisible(projectName));
					log("STEP 33:  user can see the payments in report", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 33:  user cannot see the payments in report", Status.FAIL);
					throw new RuntimeException("Failed in step 33");
				} 
	            
	            driver.close();
	        	util.switchToParentWindow();
	            }
	            try {
	            	Assert.assertTrue(util.isElementVisible(PaymentFileLink));
	            	PAYMENT_AMOUNT=util.getText(PaymentFileLink);
	            	log("Payment File Amount "+PAYMENT_AMOUNT);
//	            	util.click(paymentFileLink);
					log("STEP 34:  user can see payment file link", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 34:  user cannot see payment file link", Status.FAIL);
				}
	            
	            try {
	            	util.reloadPage();
	            	util.waitFor(500);
	            	if(util.isElementVisible(ApprovalOptions)) {
	            	util.click(ApprovalOptions);
	            	}
	            	By approvedCheckLog= By.xpath("(//strong[text()='"+map.get(Excel.CheckLog)+"']/..//*[text()='Approved'])[1]");
	            	Assert.assertTrue(util.isElementVisible(approvedCheckLog));
					log("STEP 35:  user can see the approved checklog Status", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 35:  user cannot see the approved checklog Status", Status.FAIL);
					throw new RuntimeException("Failed in step 35");
				}
	            
	            try {
	            	By approvedCheckLog= By.xpath("(//strong[text()='"+map.get(Excel.CheckLog)+"']/..//*[text()='Approved'])[1]/..//strong[text()='"+PAYMENT_AMOUNT+"']");
	            	Assert.assertTrue(util.isElementVisible(approvedCheckLog));
					log("STEP 36:  Payment File link and Checklog Total Amount Matched", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 36:  Payment File link and Checklog Total Amount not Matched", Status.FAIL);
				}

	            //81270
	            if(testcaseName.contains("ALT") || testcaseName.contains("ATWELL") || testcaseName.contains("ORSTED")) {
	            	try {
	        			navigateToAgreementInformationALT();
	        			commonFunction.projectSelection();
	        			util.dummyWait(3);	        			
	        			log("STEP 36: user can navigate to Agreement Manager Page", Status.PASS);
	        		} catch (Exception e) {
	        			log("STEP 36: user cannot navigate to Agreement Manager Page", Status.FAIL);
	        			throw new RuntimeException("Failed in step 36");
	        		}
	        		
	        		try {
	        			By updatedRecord = By.xpath("//td[text()='"+AGREEMENT_NUMBER.trim()+"']/parent::tr");
	        			util.click(updatedRecord);
	        			util.dummyWait(3);
	        			log("STEP 37: user can select agreement", Status.PASS);
	        		} catch (Exception e) {
	        			log("STEP 37: user cannot select agreement", Status.FAIL);
	        			throw new RuntimeException("Failed in step 37");
	        		}
	        	
	        		try {
	        			By editLO= By.xpath("//tr[contains(@id,'RadGridLO_radYALGridControl') or contains(@id,'LSINFO_radPanels_i1_i0_RadGridLO')]/.//*[contains(text(),'"+LO_NAME+"')]/..//a[text()='Edit']");
	        			util.click(editLO);
	        			util.switchToChildWindow();
	        			log("STEP 38: user can click on edit Landowner ", Status.PASS);
	        		} catch (Exception e) {
	        			log("STEP 38: user cannot click on edit Landowner ", Status.FAIL);
	        			throw new RuntimeException("Failed in step 38");
	        		}
	        		
                    try { 
                    	clickOnSaveButtonLandOwner();
	        			log("STEP 39: user can click on save Landowner ", Status.PASS);
	        		} catch (Exception e) {
	        			log("STEP 39: user cannot click on save Landowner ", Status.FAIL);
	        			throw new RuntimeException("Failed in step 39");
	        		}
	        		
                    try {   
                    	By pendingPaymentMsg = By.xpath("//span[text()='Pending payments exist for selected landowner.  Please come back later to make changes.']");
                    	Assert.assertFalse(util.isElementVisible(pendingPaymentMsg));
	        			log("STEP 40: user cannot see Pending Payment Message", Status.PASS);
	        		} catch (AssertionError e) {
	        			log("STEP 40: user cannot see Pending Payment Message", Status.FAIL);
	        		}
                    
	        		try {
	        			driver.close();
	        			util.switchToParentWindow();
	        			log("STEP 41: user can close the landowner window", Status.PASS);
	        		} catch (Exception e) {
	        			log("STEP 41: user cannot close the landowner window", Status.FAIL);
	        			throw new RuntimeException("Failed in step 41");
	        		}
	            }
		   
	   }
	   
	   
	   public void addWorkQueueUser(Map<String, String> map, String testcaseName)  {
		   if(!environment.contains("CONNECTGEN") & !environment.contains("NOVA") & !environment.contains("AKUOENERGY")) { 
		   try {
				navigateToWorkQueue();
				log("STEP 1:  user can navigate to Work Queue ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  user cannot navigate to Work Queue", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			} 
           
           try {
				ClickOnUsersLink();
				log("STEP 2:  user can click on Users link ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2:  user cannot click on Users link   ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			} 
           
           if(util.isElementVisible(userName)) {
			       
           }else {
           	try {
           		ClickAddNew();
					log("STEP 3:  user can click on Add New Record button ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: user cannot click on Add New Record button", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				} 
           	
           	try {
           	SelectWorkQueueUser(map.get("User"));
           	FirstApprover=map.get("User");
           		log("STEP 4:  user can select User Name from the dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: user cannot select User Name from the dd", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
           	
           	try {
           	addProcessOrder(map.get("ProcessOrder"));
           		log("STEP 5: user can add Process Order ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: user cannot add Process Order", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
           	
           	try {
           		ClickOnInsert();
           		log("STEP 6: user can click on Insert button ", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: user cannot click on Insert button", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
           }
           
           util.switchToDefaultContent();
		       util.click(btnClose);
		   }
	   }
}
