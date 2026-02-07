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

public class ProjectProcessingOptionsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER, text, COMMENT;

	public ProjectProcessingOptionsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	By navProject = By.xpath("//span[text()='Project']");
	By navPaymentManager = By.xpath("//span[contains(text(),'Payment Manager')]");
	By SearchInformation = By.xpath("//span[contains(text(),'Search Information')]");
 	By ExpandprocessingOptions = By.xpath("//em[text()='Processing Options']/..//a[@title='Expand']");
 	By btnPlus = By.xpath("//img[@alt='Create new check log']");
 	By btnPlusRow = By.xpath("//img[@alt='Create new check log']");
 	By iframeCheckBatch = By.xpath("//iframe[@name='AddCheckLog']");
 	By txtNewCheckLogName = By.xpath("//input[contains(@id,'ImportMappingName') and @type='text']");
 	By btnSave = By.xpath("//input[contains(@id,'SaveNewMapping') and @type='image']");
	By drpCheckLog = By.xpath("//input[contains(@id,'_chkBatch_radYALDropDownList_Input') and @type='text']");
	By btnSubmitCheckLog = By.xpath("//input[contains(@id,'_btnSubmitCheckLog') and @type='image']");
	By txtCancelComment = By.xpath("//textarea[contains(@id,'_txtCancelComments')]");
	By btnCancel = By.xpath("//input[contains(@id,'_btnCancelPayments')]");
	By txtRemittanceComment =  By.xpath("//textarea[contains(@id,'_txtRemittance')]");
	By btnUpdate = By.xpath("//input[contains(@id,'_btnUpdateRemmitance') and @type='image']");
	By txtFixedAmount = By.xpath("//input[contains(@id,'_AddFixedAmount') and @type='text']");
	By txtPercentAmount = By.xpath("//input[contains(@id,'_AddPercentAmount') and @type='text']");
	By txtPaymentComment = By.xpath("//textarea[contains(@id,'_txtAddReason')]");
	By btnUpdatePayment = By.xpath("//input[@id='ctl00_ConPHRightTop_RadDock2_C_btnUpdatePayment']");
	By iconPDF = By.xpath("//img[@id='ctl00_ConPHRightTop_grdSearchPayments_radYALGridControl_ctl00_ctl02_ctl00_Img2']");
    By iconPDFRow =By.xpath("//input[@id='ctl00_ConPHRightTop_grdSearchPayments_RadGrid1_ctl00_ctl02_ctl00_ExportToCsvButton']");
    By iconExcel = By.xpath("//img[@id='ctl00_ConPHRightTop_grdSearchPayments_radYALGridControl_ctl00_ctl02_ctl00_Img3']"); 
    By iconExcelRow = By.xpath("//input[@id='ctl00_ConPHRightTop_grdSearchPayments_RadGrid1_ctl00_ctl02_ctl00_ExportToExcelButton']");
    By btnClose = By.xpath("//a[@title='Close']");

    public void navigateToPaymentManager() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navPaymentManager);
		util.click(navPaymentManager);
	}

    public void ExpandprocessingOptionsPanel() {
    	util.waitUntilElementDisplay(SearchInformation);
		util.click(SearchInformation);
		util.dummyWait(1);
		if(util.isElementPresent(ExpandprocessingOptions)) {
		util.waitUntilElementDisplay(ExpandprocessingOptions);
		util.click(ExpandprocessingOptions);
		}
    }

    public void ClickOnPlusButton() {
    	//util.waitUntilElementDisplay(Checkbox);
    	//util.click(Checkbox);
    	util.dummyWait(1);
    	util.waitUntilElementDisplay(btnPlus);
    	util.click(btnPlus);
    }

    public void ClickOnPlusButtonRow() {
    	util.dummyWait(1);
    	util.waitUntilElementDisplay(btnPlusRow);
    	util.click(btnPlusRow);
    }
    
    By CheckboxP = By.xpath("(//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Pending']/..//*[text()='Regression_LO']/..//input[contains(@id,'CheckBox')])[1]");
    By CheckboxRow = By.xpath("(//input[contains(@id,'grdSearchPayments_RadGrid1_ctl00') and @type='checkbox'])[last()]");
   public void ClickOnPaymentAdd() {
	util.waitUntilElementDisplay(CheckboxP);
	util.click(CheckboxP);
   }
   
   By Checkbox = By.xpath("(//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Pending']/..//input[contains(@id,'CheckBox')])[1]");
   By getText = By.xpath("(//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Pending'])[1]/..//td[3]");
   By txtAgreementNumber = By.xpath("(//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Pending']/..//input[contains(@id,'CheckBox')]/../../..//a[contains(@onclick,'LeaseManager')])[1]");
   public void ClickOnCheckBox() {
		util.waitUntilElementDisplay(Checkbox);
		util.click(Checkbox);
	   }
   
   public void ClickOnCheckboxROW() {
		util.waitUntilElementDisplay(CheckboxRow);
		util.click(CheckboxRow);
	   }
    
   public void AddNewCheckLogName(String value) {
	   if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtNewCheckLogName, value);
   }
 
   By SuccessMessage = By.xpath("//span[text()='New check batch added successfully']");
   public void ClickOnSaveButton() {
	   util.waitUntilElementDisplay(btnSave);
	   util.click(btnSave);
	  
   }
   
 By btnRefresh = By.xpath("//input[contains(@id,'_RefreshCheckList')]");

   public void SelectCheckLog(String CheckLog) {
	  util.waitUntilElementDisplay(drpCheckLog);
	  util.selectValueFromDropdown(drpCheckLog, CheckLog);
	  util.pressENTERkey();
   }

   By btnAddtoCheckLog = By.xpath("//input[contains(@id,'_btnAddToBatch') and @type='image']");
   
   public void ClickOnAddToCheckLog() {
	   util.waitUntilElementDisplay(btnAddtoCheckLog);
	   util.click(btnAddtoCheckLog);
	   util.dummyWait(1);   }
   
   public void ClickOnSubmitCheckLog() {
	   util.waitUntilElementDisplay(btnSubmitCheckLog);
	   util.click(btnSubmitCheckLog);
	   util.dummyWait(1);
   }
   By btnOk = By.xpath("//span[text()='OK']");
   
   By errorMessage = By.xpath("//span[text()='Check log includes payments from agreements not in a signed status. Check log cannot be submitted for processing.']");
   By agreementNoLink = By.xpath("(//a[contains(@onclick,'LeaseManagerFromM')])[last()]");
   
   By txtAgreementStatus = By.xpath("//input[contains(@id,'Lease_Status_ID') and @type='text']");

	private void addAgreementStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAgreementStatus, value);
	}
	
	By saveButton = By.xpath("//input[contains(@id,'_btnSave') and not(@disabled)]");

	private void clickOnSaveButton() {
		util.click(saveButton);
		util.dummyWait(5);
	}
	
   public void AddCancelComment(String value) {
	   util.dummyWait(2);
	   if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCancelComment, value);
   }
   

   public void ClickOnCancelButton() {
	   util.waitUntilElementDisplay(btnCancel);
	   util.click(btnCancel);
   }

   public void AddRemittanceComment(String value) {
	   if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtRemittanceComment, value);
   }
   

   public void ClickOnUpdateButton() {
	   util.waitUntilElementDisplay(btnUpdate);
	   util.click(btnUpdate);
	   util.dummyWait(5);
   }
   
   public void AddFixedAmount(String value) {
	   if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtFixedAmount, value);
   }
   
   public void AddPercentAmount(String value) {
	   if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPercentAmount, value);
   }

   public void AddPaymentComment(String value) {
	   if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPaymentComment, value);
   }

   public void ClickOnUpdatePayment() {
	   util.waitUntilElementDisplay(btnUpdatePayment);
	   util.click(btnUpdatePayment);
   }

   public void ClickOnPDFIcon() {
	   util.waitUntilElementDisplay(iconPDF);
	   util.click(iconPDF);
	   util.dummyWait(1);
   }

   public void ClickOnPDFIconRow() {
	   util.waitUntilElementDisplay(iconPDFRow);
	   util.click(iconPDFRow);
	   util.dummyWait(1);
   }
   
   public void ClickOnExcelIcon() {
	   util.waitUntilElementDisplay(iconExcel);
	   util.click(iconExcel);
	   util.dummyWait(1);
   }

   public void ClickOnExcelIconRow() {
	   util.waitUntilElementDisplay(iconExcelRow);
	   util.click(iconExcelRow);
	   util.dummyWait(1);
   }
   
   By drpProjects = By.xpath("//input[contains(@id,'_Projects_radYALDropDownList_Input') and @type='text']");
   public void SelectProject(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpProjects, value);
	}
	
   By drpPaymentStatus = By.xpath("//input[contains(@id,'_PaymentStatus_MSDropDown_Input') and @type='text']");
	public void SelectPaymentStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(drpPaymentStatus, value);
		util.waitFor(200);
		util.pressDownkey();
		util.pressENTERkey();
	}
	
	By btnSearch = By.xpath("//input[contains(@id,'_btnSearch') and @type='button']");
	public void ClickSearchButton() {
		util.waitUntilElementDisplay(btnSearch);
		util.click(btnSearch);
		util.dummyWait(2);
	}

	By drpProjectsRow = By.xpath("//input[@id='ctl00_ConPHRightTop_RadDock1_C_RadProjectList_Input']");
	public void SelectProjectRow(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpProjectsRow, value);
	}
	
	By drpPaymentStatusClose = By.xpath("//a[contains(@id,'PaymentStatus_MSDropDown_Arrow')]");
	public void SelectPaymentStatusROW(String value) {
		if (!commonFunction.checkNA(value)) {
		String drpSelectName = "//div//ul//li//div[normalize-space()='" + value + "']";
		util.waitFor(1000);
		util.waitUntilElementDisplay(drpPaymentStatus);
		util.click(drpPaymentStatus);
		util.waitFor(1000);
		if (!util.isElementVisible(By.xpath(drpSelectName))) {
			util.click(drpPaymentStatus);
			util.waitFor(1000);
		}
		util.click(By.xpath(drpSelectName));
		util.click(drpPaymentStatusClose);
	}}
	
	By btnSearchRow = By.xpath("//input[contains(@id,'_btnDoSearch') and @type='image']");
	By loader = By.xpath("(//img[contains(@id,'ctl00_ConPHRightTop_Image2') and @alt='loading'])[1]");
	public void ClickSearchButtonRow() {
		util.waitUntilElementDisplay(btnSearchRow);
		util.click(btnSearchRow);
		util.dummyWait(2);
	}
	
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navAgreementManager = By.xpath("//a//span[contains(text(),'Agreement Manager')] ");
	By navPaymentInformation = By.xpath("//a//span[contains(text(),'Payment Information')] ");
	public void navigateToAgreementInformationALT() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navAgreementManager);
		util.click(navAgreementManager);
		util.waitUntilElementDisplay(navPaymentInformation);
		util.click(navPaymentInformation);
	}
	By cancelledTab= By.xpath("//div[contains(@id,'RadTabStripPaymentDetails')]//span[text()='Cancelled']");
	
   public void ProjectProcessingOptions(Map<String, String> map,String testcaseName)  {
		try {
			ExpandprocessingOptionsPanel();
			log("STEP 1: user can expand processing option panel & fields will be visible.", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: user cannot expand processing option panel. ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL"))
		try {
			ClickOnPlusButton();
			log("STEP 2: user can click on plus button.", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: user cannot click on plus button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		else {
		try {
			ClickOnPlusButtonRow();
			log("STEP 3: user can click on plus button.", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user cannot click on plus button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		}
		
		try {
			util.switchToIframe(iframeCheckBatch);
             util.dummyWait(2);
			AddNewCheckLogName(map.get(Excel.NewCheckLogName));
			log("STEP 4: user can enter value in New Check Log Name textbox. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: user cannot enter value in New Check Log Name textbox. ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
	
			try {
				ClickOnSaveButton();
				log("STEP 5:  user can click on save button.  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user cannot  value in textboxclick on save button.", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			
			
		   
	   	if (util.isElementPresent(SuccessMessage)) {
	   		Assert.assertTrue(util.isElementPresent(SuccessMessage), "New check batch added successfully");
	   		log("STEP 6:'New check batch added successfully' message will be displayed.", Status.PASS);
	   	} else {
    		log("STEP 6:user cannot  value in textboxclick on save button.", Status.FAIL);
	   		throw new RuntimeException("Faild in STEP 6 :user cannot click on insert button  ");
	   	}
		
		
	
		try {
			util.dummyWait(2);
			util.switchToDefaultContent();
			util.dummyWait(2);
			SelectCheckLog(map.get(Excel.CheckLog));
			log("STEP 7: User can able to select newly created Check Log ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: No value display in Check Log DD", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		util.dummyWait(1);
		try {
			if(testcaseName.contains("ROW"))
				ClickOnCheckboxROW();
			else
				ClickOnPaymentAdd();
			log("STEP 8: User can select Pending Payments ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot select the Pending Payments   ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		util.dummyWait(1);
		try {
			ClickOnAddToCheckLog();
			log("STEP 9: User can click on add to check log button", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot click on add to check log button ", Status.FAIL);
			throw new RuntimeException("Failed to click on add to check log button");
		}
		
//		if(!testcaseName.contains("ROW") || !testcaseName.contains("TRA")) {
//			try {
//				util.waitUntilElementDisplay(loader);
//				Assert.assertTrue(util.isElementVisible(loader));
//				log("STEP: User can see Spinner after clicked on Add To Check Log button", Status.PASS);
//			} catch (AssertionError e) {
//				log("STEP 9: User cannot see Spinner after clicked on Add To Check Log button ", Status.FAIL);
//			}
//		}
		util.dummyWait(1);
		if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
		try {
			ClickOnSubmitCheckLog();
			log("STEP 10:  user can click on submit check log  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  user cannot click on submit check log   ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		if (util.isElementPresent(btnOk)){
			log("STEP 11:'Submit check log' popup will be opened and ' Submit check log for approval? ' message will be displayed with ok and cancel button.", Status.PASS);
		} else {
			log("STEP 11: user cannot click on submit check log ", Status.FAIL);
		}
		util.click(btnOk);
		}
		else {
			try {
				
				ClickOnSubmitCheckLog();
				log("STEP 10:  user can click on submit check log  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10:  user cannot click on submit check log   ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
			
			if(environment.contains("NOVA")) {
				try {
					Assert.assertTrue(util.isElementVisible(errorMessage));
					log("STEP 11:  user can Prevent payments from being process if the agreement is not in a status of [signed]  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 11:  user cannot Prevent payments from being process if the agreement is not in a status of [signed] ", Status.FAIL);
				}
				
				try {
					util.click(agreementNoLink);
					util.switchToChildWindow();
					log("STEP 12:  user can click on Agreement No Link  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 12:  user cannot click on Agreement No Link  ", Status.FAIL);
					throw new RuntimeException("Failed in step 12");
				}
				
				try {
					addAgreementStatus("Signed");
					log("STEP 13:  user can update agreement status to signed ", Status.PASS);
				} catch (Exception e) {
					log("STEP 13:  user cannotupdate agreement status to signed", Status.FAIL);
					throw new RuntimeException("Failed in step 13");
				}
				
				try {
					clickOnSaveButton();
					driver.close();
					util.switchToParentWindow();
					log("STEP 14:  Click on save button", Status.PASS);
				} catch (Exception e) {
					log("STEP 14: User cannot Click on save button", Status.FAIL);
					throw new RuntimeException("Failed in step 14");
				}
				
				try {
					SelectCheckLog(map.get(Excel.CheckLog));
					log("STEP 15: User can able to select newly created Check Log ", Status.PASS);
				} catch (Exception e) {
					log("STEP 15: No value display in Check Log DD", Status.FAIL);
					throw new RuntimeException("Failed in step 15");
				}
				
				try {
					
					ClickOnSubmitCheckLog();
					log("STEP 16:  user can click on submit check log  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 16:  user cannot click on submit check log   ", Status.FAIL);
					throw new RuntimeException("Failed in step 16");
				}
			}
		}
		
		util.dummyWait(1);
	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {	
		if(!environment.contains("RAMACO")) {
		try {
			ClickOnCheckBox();
			util.dummyWait(1);
			AddRemittanceComment(map.get(Excel.RemittanceComment));
			log("STEP 17: user can enter value in Remittance Comment textbox. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user cannot enter value in Remittance Comment textbox.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
		try {
			ClickOnUpdateButton();
			log("STEP 18:  user can click on update button.  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: user cannot click on update button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
		
		try {
			By updatedText = By.xpath("(//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Pending'])[1]/..//*[text()='"+map.get(Excel.RemittanceComment)+"']");
			Assert.assertTrue(util.isElementVisible(updatedText));
			log("STEP 19:  user can see updated text on payment grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 19: user cannot see updated text on payment grid ", Status.FAIL);
		}
		}
	}	
	util.dummyWait(1);
		try {
			ClickOnCheckBox();
			util.dummyWait(1);
			AddFixedAmount(map.get(Excel.FixedAmount));
			log("STEP 20:  user can enter value in FixedAmount textbox.   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 20:  user cannot enter value in FixedAmount textbox.   ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		
		try {
			AddPaymentComment(map.get(Excel.PaymentComment));
			log("STEP 21:  user can enter value in PaymentComment textbox.  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 21:   user cannot enter value in PaymentComment textbox.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
		
		try {
			ClickOnUpdatePayment();
			log("STEP 22: user can click on update payment button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: user cannot click on update button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
		
		try {
			By updatedPayment = By.xpath("((//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Pending'])[1]/..//*[text()='"+map.get("IncreasedFixedAmount")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(updatedPayment));
			log("STEP 23:  user can see updated Payment on grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 23: user cannot see updated  payment on grid ", Status.FAIL);
		}
		
		util.dummyWait(1);
		try {
			ClickOnCheckBox();
			util.clearInputField(txtFixedAmount);
			AddPercentAmount(map.get(Excel.PercentAmount));
			log("STEP 24:  user can enter value in  PercentAmount textbox.  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 24:   user cannot enter value in PercentAmount textbox.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		
		try {
			AddPaymentComment(map.get(Excel.PaymentComment));
			log("STEP 25:  user can enter value in PaymentComment textbox.  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 25:   user cannot enter value in PaymentComment textbox.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
		
		try {
			ClickOnUpdatePayment();
			log("STEP 26: user can click on update payment button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: user cannot click on update button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
		
		try {
			By updatedPayment = By.xpath("((//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Pending'])[1]/..//*[text()='"+map.get("IncreasedPerAmount")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(updatedPayment));
			log("STEP 27:  user can see updated Payment on grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 27: user cannot see updated  payment on grid ", Status.FAIL);
		}
		
		util.dummyWait(1);
		try {
			ClickOnCheckBox();
			text=driver.findElement(getText).getText();
			util.dummyWait(1);
			AGREEMENT_NUMBER= driver.findElement(txtAgreementNumber).getText();			
		    AddCancelComment(map.get(Excel.CancelComment));
		    COMMENT=map.get(Excel.CancelComment);
			log("STEP 28: user can enter value in Cancel Comment textbox.  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 28: user cannot enter value in Cancel Comment textbox.", Status.FAIL);
			throw new RuntimeException("Failed in step 28");
		}
		
		try {
			ClickOnCancelButton();
			util.dummyWait(1);
			log("STEP 29: user can click on cancel payment button.  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 29: user cannot click on cancel payment button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}
		
		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
		try {
			SelectProject(map.get(Excel.Project));
			log("STEP 30: user can select Project", Status.PASS);
		} catch (Exception e) {
			log("STEP 30: user cannot select project ", Status.FAIL);
			throw new RuntimeException("Failed in step 30");
		}
		
		try {
			SelectPaymentStatus("Cancelled");
	         util.dummyWait(2);
			log("STEP 31: user can select Payment status", Status.PASS);
		} catch (Exception e) {
			log("STEP 31: user cannot select Payment Status ", Status.FAIL);
			throw new RuntimeException("Failed in step 31");
		}
		
		try {
			 ClickSearchButton();
			log("STEP 32: user can click on search button", Status.PASS);
		} catch (Exception e) {
			log("STEP 32: user cannot click on search button ", Status.FAIL);
			throw new RuntimeException("Failed in step 32");
		}
		
		try {
			By cancelledPayment = By.xpath("(//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Cancelled'])[1]/..//*[text()='"+text+"']");;
			Assert.assertTrue(util.isElementVisible(cancelledPayment));
			log("STEP 33:  user can see cancelled Payment on grid", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 33: user cannot see cancelled  payment on grid ", Status.FAIL);
		}
		
		try {
			navigateToAgreementInformationALT();
			commonFunction.projectSelection();
			log("STEP 34: user can navigate to Agreement Manager Page", Status.PASS);
		} catch (Exception e) {
			log("STEP 34: user cannot navigate to Agreement Manager Page", Status.FAIL);
			throw new RuntimeException("Failed in step 34");
		}
		
		try {
			By updatedRecord = By.xpath("//td[text()='"+AGREEMENT_NUMBER.trim()+"']/parent::tr");
			util.click(updatedRecord);
			log("STEP 35: user can select agreement", Status.PASS);
		} catch (Exception e) {
			log("STEP 35: user cannot select agreement", Status.FAIL);
			throw new RuntimeException("Failed in step 35");
		}
	
		try {
			util.waitUntilElementDisplay(cancelledTab);
			util.click(cancelledTab);
			log("STEP 36: user can click on cancelled tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 36: user cannot click on cancelled tab", Status.FAIL);
			throw new RuntimeException("Failed in step 36");
		}
		
		try {
			By updatedComment = By.xpath("(//tr[contains(@id,'_CHECKCancelled_radYALGridControl')]/.//td[text()=' Comment: "+COMMENT+"'])[1]");
			Assert.assertTrue(util.isElementVisible(updatedComment));
			ExtentTestManager.infoWithScreenshot("Cancelled Payment Comment");
			log("STEP 37: user can see updated comment for the cancelled payment", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 37: user cannot see updated comment for the cancelled payment", Status.FAIL);
		}
		
		try {
			navigateToPaymentManager();
			log("STEP 38: user can navigate to payment manager", Status.PASS);
		} catch (Exception e) {
			log("STEP 38: user cannot navigate to payment manager", Status.FAIL);
			throw new RuntimeException("Failed in step 38");
		}
		
		}else {
			try {
				SelectProjectRow(map.get(Excel.Project));
				log("STEP 30: user can select Project  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 30:  user cannot select Project ", Status.FAIL);
				throw new RuntimeException("Failed in step 30");
			}
			
			try {
				SelectPaymentStatusROW("Cancelled");
				log("STEP 31: user can enter value in Payment Status textbox.", Status.PASS);
			} catch (Exception e) {
				log("STEP 31: user cannot enter value in Payment Status textbox.   ", Status.FAIL);
				throw new RuntimeException("Failed in step 31");
			}
			
			try {
				ClickSearchButtonRow();
				log("STEP 32: user can click on search button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 32: user cannot  click on search button ", Status.FAIL);
				throw new RuntimeException("Failed in step 32");
			}
			
			try {
				By cancelledPayment = By.xpath("(//table[contains(@id,'grdSearchPayments')]/../..//*[text()='Cancelled'])[1]/..//*[text()='"+text+"']");;
				Assert.assertTrue(util.isElementVisible(cancelledPayment));
				log("STEP 33:  user can see cancelled Payment on grid", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 33: user cannot see cancelled  payment on grid ", Status.FAIL);
			}
		}
		
   }	
   
}
