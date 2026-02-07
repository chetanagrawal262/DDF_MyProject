package pages.agreementManager;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.ExcelUtils;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class PaymentInformationPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	Actions action;
	Map<String, String> rowData = new HashMap<String, String>();
	SoftAssert sf = new SoftAssert();
	
	public PaymentInformationPage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navLeaseManager = By.xpath("//a//span[contains(text(),'Lease Manager')] ");
	By navPaymentInformation = By.xpath("//a//span[contains(text(),'Payment Information')] ");
	By addDocumentButton = By.xpath("//div[contains(@id,'LSINFO_RadPageView3')]//img[@alt='Add Documents'] | //div[contains(@id,'LSINFO_RadPageView3')]//input[contains(@id,'_btnAddDoc')]");
	
	public void navigateToPaymentInformationALT() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navAgreementManager);
		util.click(navAgreementManager);
		util.waitUntilElementDisplay(navPaymentInformation);
		util.click(navPaymentInformation);
		util.waitForWebElementToBePresent(addDocumentButton, 20);
		if (!util.isElementPresent(addDocumentButton, 30)) {
			throw new RuntimeException();
		}
	}
	
	By addButton = By.xpath("//table[contains(@id,'LSLST_RadGridTracts')]//a[contains(@id,'_AddJob')]");
	By paymentInformationTab = By.xpath("//span[text()='Payment Information']/../../parent::a[contains(@class,'rtsLink')]");
	public void navigateToPaymentInformationROW() {
		util.dummyWait(5);
		util.waitUntilElementDisplay(paymentInformationTab);
		util.click(paymentInformationTab);
		
	}
	
	
	By paymentTemplateDRP = By.xpath("//input[contains(@id,'MSPAYMENTTERMS_MSDropDown')]/../..//a");
	
	private void selectPaymentTemplate(String value) {
		if (!commonFunction.checkNA(value)) {
			util.selectValueFromDropdownCheckbox(paymentTemplateDRP, value);
			util.click(paymentTemplateDRP); 
		}
	}
	
	By agreementTerm = By.xpath("//input[contains(@id,'Lease_Agreement_ID') and @type='text']");
	private void selectPaymentTerm(String value) {
		if (!commonFunction.checkNA(value)) {
			util.dummyWait(2);
			util.inputTextAndPressTab(agreementTerm, value);
		}
	}
	
	By addNewButton = By.xpath("//input[contains(@id,'ImgAddPaymentTerms')]");
	private void clickOnAddNewButton() {
		util.click(addNewButton);
	}
	By paymentTermGrid= By.xpath(" //*[@id=\"ctl00_ConPHRightTop_LSINFO_RadPanelBar1_i0_i0_LEASE_PAYMENTS_radYALGridControl_ctl00__0\"]/td[8]");
	private void rightClickOnPaymentTermGrid() {
		util.dummyWait(2);
		action.contextClick(util.waitForWebElementToBePresentReturnElement(paymentTermGrid)).build().perform();
	}
	
	By recalculateOption = By.xpath("//span[text()='Recalculate']/parent::a | //span[text()='Recalculate pending payments']/parent::a");
	private void clickOnRecalculate() {
		util.click(recalculateOption);
	}
	
	By paymentHistorySection= By.xpath("//span[text()='Payment History']/../parent::a");
	private void clickOnPaymentHistoryPanel() {
		if(!util.isElementVisible(upcomingTab)) {
			util.waitUntilLoaderDisappear();
			util.click(paymentHistorySection);
		}
	}
	By upcomingTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Upcoming']");
	By pastTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Past']");
	By cancelledTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Cancelled']");
	
	private void clickOnUpcomingTab() {
		util.click(upcomingTab);
	}
	private void clickOnPastTab() {
		util.click(pastTab);
	}
	private void clickOnCancelledTab() {
		util.click(cancelledTab);
	}
	
	public void pastPaymentValidation(String landowner, String period, String payment) {
		By pastYears= By.xpath("//tr[contains(@id,'CHECKPast_radYALGridControl')]/..//*[text()='"+landowner+"']/..//*[text()='"+period+"']");
		By pastPayments= By.xpath("//tr[contains(@id,'CHECKPast_radYALGridControl')]/..//*[text()='"+period+"']/..//*[text()='"+landowner+"']/..//*[contains(text(),'"+payment+"')]");
		
	sf.assertTrue(util.isElementVisible(pastYears), "Payment Date "+ period+" is not added for landowner "+landowner);
	sf.assertTrue(util.isElementVisible(pastPayments), "Past Payment for the year "+period+" is not correct for landowner "+landowner);
	
	ExtentTestManager.info("Expected past Payment for the year "+period+" is "+payment);
	}
	
	public void upcomingPaymentValidation(String landowner, String period, String payment) {
		By upcomingYears= By.xpath("//tr[contains(@id,'CHECKUpcoming_radYALGridControl')]/..//*[text()='"+landowner+"']/..//*[text()='"+period+"']");
		By upcomingPayments= By.xpath("//tr[contains(@id,'CHECKUpcoming_radYALGridControl')]/..//*[text()='"+period+"']/..//*[text()='"+landowner+"']/..//*[contains(text(),'"+payment+"')]");
	
			sf.assertTrue(util.isElementVisible(upcomingYears), "Payment Date "+ period+" is not added for landowner "+landowner);
			sf.assertTrue(util.isElementVisible(upcomingPayments), "Upcoming Payment for the year "+period+" is not correct for landowner "+landowner);
			ExtentTestManager.info("Expected upcoming Payment for the year "+period+" is "+payment);
	}
	
	
	public void addNewPaymentInformation(Map<String, String> map, String testCaseName) {
		
		try {
			if(testCaseName.toLowerCase().contains("row") || testCaseName.contains("TRA")) {
				navigateToPaymentInformationROW();
			} else {
				navigateToPaymentInformationALT();
			}
			log("STEP 1: Navigate to Project >agreement manager >payment Information page", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot Navigate to Project >agreement manager >payment Information page", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			selectPaymentTemplate(map.get(Excel.PaymentTemplate));
			log("STEP 2: Fill in Add payment template dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select the payment template ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			selectPaymentTerm(map.get(Excel.PaymentTerm));
			log("STEP 3: Fill in Agreement Term DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select the Agreement Term from the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
//		try {
//			setPaymentFrom(TestUtil.addDaysInCurrentDate("MM/dd/yyyy", -10));
//			log("STEP 4: Select Start Payments From", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 4: User cannot enter the Start Payment Date", Status.FAIL);
//			throw new RuntimeException("Failed in step 4");
//		}
		
		try {
			clickOnAddNewButton();
			log("STEP 5: Click on Add New button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot click on Add New button", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
		
		if(!testCaseName.contains("ROW")) {
//		try {
//			rightClickOnPaymentTermGrid();
//			log("STEP 6: Right Click on Payment Term Grid", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 6:User cannot Right Click on Payment Term Grid", Status.FAIL);
//			throw new RuntimeException("Failed in step 6");
//		}
//		
//		
//		try {
//			clickOnRemovePendingDocument();
//			log("STEP 7: Click on 'Remove Pending Payments'", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 7: User cannot click on 'Remove Pending Payments'", Status.FAIL);
//			throw new RuntimeException("Failed in step 7");
//		}
		try {
			util.dummyWait(3);
			rightClickOnPaymentTermGrid();
			clickOnRecalculate();
			if(testCaseName.toLowerCase().contains("row") || testCaseName.contains("TRA")) {
			    util.switchToIframe(By.xpath("//iframe[@name='rw_Payment_Recalculation']"));
			    driver.findElement(By.xpath("//*[@id=\"dp_StartDate_dateInput\"]")).sendKeys("01/01/2023");
			    driver.findElement(By.xpath("//*[@id=\"btn_Submit\"]")).click();
			    driver.switchTo().defaultContent();
			    driver.findElement(By.xpath("//*[@id=\"RadWindowWrapper_rw_Payment_Recalculation\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/ul/li[5]/a")).click();
				}

			log("STEP 8: Click on 'ReCalculate'", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot click on 'ReCalculate'", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		}
//		try {
//			clickOnDeletePaymentTerm();
//			log("STEP 9: Click on the Delete button for the record in the Payment Terms panel.(Click on cross icon) ", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 9: User cannot click on the Delete button for the record in the Payment Terms panel.(Click on cross icon) ", Status.FAIL);
//			throw new RuntimeException("Failed in step 9");
//		}
//		try {
//			clickOnDeleteCancelButton();
//			log("STEP 10: click on the Cancel button in the   Delete popup", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 10: User cannot click on the Cancel button in the   Delete popup", Status.FAIL);
//			throw new RuntimeException("Failed in step 10");
//		}
//		try {
//			clickOnDeletePaymentTerm();
//			clickOnDeleteOkButton();
//			log("STEP 11: click OK button in the Delete popup", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 11: User cannot click on OK button in the Delete popup", Status.FAIL);
//			throw new RuntimeException("Failed in step 11");
//		}
//		util.dummyWait(2);		
		try {
			clickOnPaymentHistoryPanel();
			log("STEP 12: Click on Payment History Panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot click on Payment History Panel", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		util.dummyWait(1);
		
		try {
			clickOnPastTab();
			ExtentTestManager.infoWithScreenshot("Past Payments");
			log("STEP 13: Click on Past", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot click on Past Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		if(testCaseName.contains("ALT") || testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
		try {
			for(int i=1; i<ExcelUtils.totalRows-1; i++) {
				String rowName = "PastPayment"+i;
				rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), "PastPaymentCalculations",
						rowName);
				pastPaymentValidation(rowData.get(Excel.Landowner),rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
			}
			log("STEP 14: all Past Payment sucessfully added", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: Past Payment not added or calculations are incorrect", Status.FAIL);
		}
		}else {
			try {
				for(int i=1; i<ExcelUtils.totalRows-1; i++) {
					String rowName = "PastPayment"+i;
					rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), "PastPaymentCalculationsROW",
							rowName);
					pastPaymentValidation(rowData.get(Excel.Landowner),rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
				}
				log("STEP 14: all Past Payment sucessfully added", Status.PASS);
			} catch (Exception e) {
				log("STEP 14: Past Payment not added or calculations are incorrect", Status.FAIL);
			}
		}
		
		util.dummyWait(1);
		try {
			clickOnUpcomingTab();
			ExtentTestManager.infoWithScreenshot("Upcoming Payments");
			log("STEP 15: Click on Upcoming ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: User cannot click on Upcoming Tab ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
		if(testCaseName.contains("ALT") || testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
		try {
			for(int i=1; i<ExcelUtils.totalRows-1; i++) {
				String rowName = "UpcomingPayment"+i;
				rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), "UpcomingPaymentCalculations",
						rowName);
				upcomingPaymentValidation(rowData.get(Excel.Landowner),rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
			}
			log("STEP 16: all Upcoming Payment sucessfully added", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: Upcoming Payment not added or calculations are incorrect", Status.FAIL);
		}
		}else {
			try {
				for(int i=1; i<ExcelUtils.totalRows-1; i++) {
					String rowName = "UpcomingPayment"+i;
					rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), "UpcomingPaymentCalculationsROW",
							rowName);
					upcomingPaymentValidation(rowData.get(Excel.Landowner),rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
				}
				log("STEP 16: all Upcoming Payment sucessfully added", Status.PASS);
			} catch (Exception e) {
				log("STEP 16: Upcoming Payment not added or calculations are incorrect", Status.FAIL);
			}
		}
		sf.assertAll();
		if(testCaseName.toLowerCase().contains("alt")) {
			util.dummyWait(1);
		try {
			clickOnCancelledTab();
			log("STEP 17: Click on Cancelled", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot click on Cancelled Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}}
		
	}
	
	

	By btnTestCalculations = By.xpath("//td[text()='Type of Calculation:']//input[contains(@id,'imgTestCalculation')and @type='image']");
	By iframetestCalculations = By.xpath("//iframe[@name='TestCalculation']");
	By drpProjects = By.xpath("//input[@name='ddProjects']");
	By drpLease = By.xpath("//input[@name='ddLeases']");
	By drpLeaseTerms = By.xpath("//input[@name='Lease_Agreement_ID']");
	By btnShowCalculations = By.xpath("//input[contains(@id,'btnImgShow')and @type='image']");
	By colDueDate = By.xpath("//a[text()='Due Date']");
	By colPayee = By.xpath("//a[text()='Payee']");
	By colAmount = By.xpath("//a[text()='Amount']");
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectPayTemplate = By.xpath("//span[contains(text(),'Project Pay Templates')] | //span[contains(text(),'Payment Terms Manager')]");
	By btnClose = By.xpath("//a[@title='Close']");
	 
	 public void nevigateToProjectPayTemplate() {
			util.waitUntilElementDisplay(navProject);
			util.click(navProject);
			util.waitUntilElementDisplay(navProjectPayTemplate);
			util.click(navProjectPayTemplate);
		}
	 
	 public void testCalculationsValidation(String landowner, String period, String payment) {
			By dueDate= By.xpath("//tr[contains(@id,'radgridShowCalculation_radYALGridControl')]/..//*[text()='"+landowner+"']/..//*[text()='"+period+"']");
			By amount= By.xpath("//tr[contains(@id,'radgridShowCalculation_radYALGridControl')]/..//*[text()='"+period+"']/..//*[text()='"+landowner+"']/..//*[text()='"+payment+"']");
		
				sf.assertTrue(util.isElementVisible(dueDate), "Payment Date "+ period+" is not added");
				sf.assertTrue(util.isElementVisible(amount), "Payment for the year "+period+" is not correct.");
				ExtentTestManager.info("Expected Payment for the period "+period+" is "+payment);
		}
	 
	 public void TestCalculations(Map<String, String> map,String testCaseName, String AGREEMENT_NO)  {
		 try {
				nevigateToProjectPayTemplate();
				commonFunction.projectSelection();
				log("STEP 1: User can navigate to project pay template page.", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot navigate to project pay template page. ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
		 try {
			 By template = By.xpath("//strong[text()='"+map.get(Excel.PaymentTemplate)+"']");
			 util.click(template);
			 util.dummyWait(2);
				log("STEP 2: User can select the Template", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot select the Template", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		 
		 try {
			util.click(btnTestCalculations);
			util.switchToIframe(iframetestCalculations);
				log("STEP 3: Test Calculation button is present besides the Type of Calculations Dd and User can click on Test calculations button", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: Test Calculation button is not present besides the Type of Calculations Dd or User can click on Test calculations button", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		 
		 //#66307-start
		 try {	
				Assert.assertFalse(util.isElementVisible(drpProjects));
				util.dummyWait(1);
					log("STEP 4: User cannot see project dd on Test Calculation popup of Project Pay Template ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 4: User can see project dd on Test Calculation popup of Project Pay Template", Status.FAIL);
				}
		 
		//#66307-end
		 
		 try {
			util.inputTextAndPressEnter(drpLease, AGREEMENT_NO);
				util.dummyWait(1);
				
					log("STEP 5: User can select Lease", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: User cannot select Lease", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
		 
		 try {
				util.inputTextAndPressEnter(drpLeaseTerms, map.get(Excel.PaymentTerm));
					log("STEP 6: User can select Lease term", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: User cannot select Lease Term", Status.FAIL);
					throw new RuntimeException("Failed in step 6");
				}
		 
		 try {
				util.click(btnShowCalculations);
				util.dummyWait(3);
					log("STEP 7: User can click on Show Calculations button", Status.PASS);
				} catch (Exception e) {
					log("STEP 7: User cannot click on Show Calculations button", Status.FAIL);
					throw new RuntimeException("Failed in step 7");
				}
		 
		 try {
				Assert.assertTrue(util.isElementVisible(colDueDate));
					log("STEP 8: User can see Due Date Column", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 8: User cannot see Due Date Column", Status.FAIL);
				}
		 
		 try {
				Assert.assertTrue(util.isElementVisible(colPayee));
					log("STEP 9: User can see Payee Column", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 9: User cannot see Payee Column", Status.FAIL);
				}
		 
		 try {
				Assert.assertTrue(util.isElementVisible(colAmount));
					log("STEP 10: User can see Amount Column", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 10: User cannot see Amount Column", Status.FAIL);
				}
		 
		 try {
				for(int i=1; i<ExcelUtils.totalRows-1; i++) {
					String rowName = "Payment"+i;
					rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.AGREEEMENT_TEST_DATA), "TestCalculations",
							rowName);
					testCalculationsValidation(rowData.get(Excel.Landowner),rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
				}
				
				ExtentTestManager.infoWithScreenshot("Test Calculations");
				util.switchToDefaultContent();
				util.click(btnClose);
				sf.assertAll();
				log("STEP 11: all Payments are correctly calculated", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: Test Calculations are Incorrect", Status.FAIL);
			}
	 }
	
	 public void setPagesize(){
			By pagesize = By.xpath("//input[contains(@id,'_CHECKPast_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_Input')]");
			System.out.println("");
			By pageSize50 = By.xpath("//div[contains(@id,'_CHECKPast_radYALGridControl_ctl00_ctl03_ctl01_PageSizeComboBox_DropDown')]/div/ul/li[3]");
			if(util.isElementPresent(pagesize)){
				util.click(pagesize);
				util.click(pageSize50);
			}
			else{
				System.out.println("Page Size option not shows");
			}
			
		}
	 
	 public void addNewPayment_GlobalTemplate(Map<String, String> map, String testCaseName) {
			
			try {
				selectPaymentTemplate(map.get(Excel.PaymentTemplate));
				log("STEP 1: Fill in Add payment template dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot select the payment template ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
			
			try {
				selectPaymentTerm(map.get(Excel.PaymentTerm));
				log("STEP 2: Fill in Agreement Term DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot select the Agreement Term from the DD", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				clickOnAddNewButton();
				log("STEP 3: Click on Add New button", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot click on Add New button", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				clickOnPaymentHistoryPanel();
				log("STEP 4: Click on Payment History Panel", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot click on Payment History Panel", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			util.dummyWait(1);
			
			try {
				clickOnPastTab();
				setPagesize();
				util.dummyWait(5);
				ExtentTestManager.infoWithScreenshot("Past Payments");
				log("STEP 5: Click on Past", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot click on Past Tab", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
				try {
					for(int i=1; i<ExcelUtils.totalRows-1; i++) {
						String rowName = "PastPayment"+i;
						rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.GLOBAL_TEMPLATE_TEST_DATA), "PastPaymentCalculationsROW",
								rowName);
						pastPaymentValidation(rowData.get(Excel.Landowner),rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
					}
					log("STEP 6: all Past Payment sucessfully added", Status.PASS);
				} catch (Exception e) {
					log("STEP 6: Past Payment not added or calculations are incorrect", Status.FAIL);
				}
			
			util.dummyWait(1);
			try {
				clickOnUpcomingTab();
				ExtentTestManager.infoWithScreenshot("Upcoming Payments");
				log("STEP 7: Click on Upcoming ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot click on Upcoming Tab ", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
				try {
					for(int i=1; i<ExcelUtils.totalRows-1; i++) {
						String rowName = "UpcomingPayment"+i;
						rowData = ExcelUtils.getRowFromRowNumber(prop.getProperty(Excel.GLOBAL_TEMPLATE_TEST_DATA), "UpcomingPaymentCalculationsROW",
								rowName);
						upcomingPaymentValidation(rowData.get(Excel.Landowner),rowData.get(Excel.Period),rowData.get("PaymentCalculation"));
					}
					log("STEP 8: all Upcoming Payment sucessfully added", Status.PASS);
				} catch (Exception e) {
					log("STEP 8: Upcoming Payment not added or calculations are incorrect", Status.FAIL);
				}
				
			
		}
	 
}
