package pages.GlobalTemplate;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import page.Common.LoginPage;

public class AdditionalPaymentTemplatePage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String QUARTER_END_TEMPLATE, COPY_TEMPLATE;
	
	SoftAssert sf= new SoftAssert();

	public AdditionalPaymentTemplatePage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navGlobalTemplate = By.xpath("//span[contains(text(),'Global Template')]");
	By drpTypeofCalculation = By.xpath("//input[contains(@id,'_CALCULATION_TYPE_ID_radYALDropDownList_Input')and @type='text']");
	By txtOption1DisplayName = By.xpath("//input[contains(@id,'_Option1_Display_name')and @type='text']");
	By txtOption1Formula = By.xpath("//textarea[@id='ctl00_ConPHRightTop_CTRINFO_RadDock3_C_Option1_Formula'] | //*[@id='ctl00_ConPHRightTop_CTRINFO_RadDock3_C_Option1_Formula_contentIframe']");
	By btnTagLookUp = By.xpath("(//img[@alt='Tag Help'])[1]");
    By iframe = By.xpath("//iframe[@name='LeasePayTags']");
    By tabVariables = By.xpath("//span[contains(text(),'Variables')]");
    By btnAddNew = By.xpath("//input[@id='btnAddNewVariable']");
    By txtVariableName = By.xpath("//input[@id='NewTagName']");
    By btnSave = By.xpath("//input[@id='btnSaveNew']");
    By btnSaveTemplate = By.xpath("//input[contains(@id,'CTRINFO_RadDock1_C_btnSave')]");
    By drpVariableName = By.xpath("//input[@id='VariableName_radYALDropDownList_Input']");
    By btnAddNewRecord = By.xpath("//img[@id='VARIABLEVALUES_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
    By txtDisplayName = By.xpath("//input[contains(@id,'_CTRINFO_RadDock1_C_Display_Name') and @type='text']");
    By txtDisplayNameVariable = By.xpath("//input[contains(@id,'xtValueDisplayName') and @type = 'text']");
    By txtValidFrom = By.xpath("//input[contains(@id,'txtValueValidFrom') and @type = 'text']");
    By drpTypeOfCalculation = By.xpath("//input[@id=\"CALCULATION_TYPE_ID_radYALDropDownList_Input\"] | //input[contains(@id,'EditFormControl_CALCULATION_TYPE_ID_radYALDropDownList_Input') and @type = 'text']");
    By txtValid1 = By.xpath("//input[contains(@id,'txtValue1') and @type = 'text']");
    By btnInsert = By.xpath("//input[contains(@id,'_btnInsert') and @type = 'submit']");
    By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
    By tabledata = By.xpath("//div[@id='RadMultiPage1']");
    By btnClose = By.xpath("//a[@title='Close']");
    By btnSubmittoPeerReview = By.xpath("//input[contains(@id,'_btnSubmitPeerReview') and @type = 'image']");
    By btnApprove = By.xpath("//input[contains(@id,'_btnApprove') and @type='image']");
	
	public void navigateToGlobalTemplet() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navGlobalTemplate);
		util.click(navGlobalTemplate);
	}
	
	public void selectTypeofCalculation(String value) {
		util.waitUntilElementDisplay(drpTypeofCalculation);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpTypeofCalculation, value);
	}
	
	public void AddOption1DisplayName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOption1DisplayName, value);
	}
	
	public void AddOption1Formula(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtOption1Formula, value);
	}
	
	public void ClickonTagLookUp() {
		util.waitUntilElementDisplay(btnTagLookUp);
		util.click(btnTagLookUp);
	}
	
	public void ClickonVariablesTab() {
		util.switchToIframe(iframe);
		util.waitUntilElementDisplay(tabVariables);
		util.click(tabVariables);
	}
	
	public void ClickonAddNewButton() {
		util.waitUntilElementDisplay(btnAddNew);
		util.click(btnAddNew);
	}
	
	public void AddVariableName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtVariableName, value);
	}
	
	public void ClickonSaveButton() {
		util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
	
	}
	
	public void SelectVariableName(String value) {
		util.dummyWait(2);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpVariableName, value);
	}
	
	public void ClickonAddNewRecord() {
		util.dummyWait(2);
		util.waitUntilElementDisplay(btnAddNewRecord);
		util.click(btnAddNewRecord);
	}
	
	public void SelectDisplayName(String value) {
		util.waitUntilElementDisplay(txtDisplayNameVariable);
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDisplayNameVariable, value);
	}
	
	public void AddValidFrom(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtValidFrom, value);
	}
	
	public void SelectTypeOfCalculation(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpTypeOfCalculation, value);
	}
	
	public void AddValid1(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtValid1, value);
	}
	
	public void ClickonInsert() {
		util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.dummyWait(1);
	}
	
	public void ClickonCloseTagLookup() {
		util.switchToDefaultContent();
		util.click(btnClose);
	}
	
	public void ClickOnSubmittoPeerReviewButton() {
		util.scrollToElement(btnSubmittoPeerReview);
		util.click(btnSubmittoPeerReview);
		util.dummyWait(2);
	}
	
	public void ClickOnApprovedButton() {
		util.waitUntilElementDisplay(btnApprove);
		util.click(btnApprove);
	}
	
	public void ClickOnSaveTemplate() {
	      util.waitUntilElementDisplay(btnSaveTemplate);
	         util.click(btnSaveTemplate);
   }
    
   public void AddDisplayName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDisplayName, value);
	}
    
    By fpddRadioButton = By.xpath("//input[contains(@id,'_optFPDD')and @type='radio']");
	public void SelectFirstPaymentDateDDButton() {
		util.waitUntilElementDisplay(fpddRadioButton);
		util.click(fpddRadioButton);
		util.dummyWait(1);
	}
	
	By FPDDropdown = By.xpath("//input[contains(@id,'_First_Payment_Type_ID_radYALDropDownList_Input') and @type='text']");
	public void SelectFPDDropdown(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(FPDDropdown, value);
	}
	
	By QERadioButton = By.xpath("//input[contains(@id,'_optQuarterEnd')and @type='radio'] | //input[contains(@id,'_optAdditionalPaymentList') and @type='radio']");
	public void SelectQuarterEndRadioButton() {
		util.waitUntilElementDisplay(QERadioButton);
		util.click(QERadioButton);
	}
	
	By drpAdditionalPayFrequencyType = By.xpath("//input[contains(@id,'_ddlAdditionalPayFreqTypeID_radYALDropDownList_Input') and @type='text']");
	 public void SelectAdditionalPaymentType(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpAdditionalPayFrequencyType, value);
		}
	 
	By lpddRadioButton = By.xpath("//input[contains(@id,'_optLPDD')and @type='radio']");
	public void SelectLastPaymentDateDDButton() {
		util.waitUntilElementDisplay(lpddRadioButton);
		util.click(lpddRadioButton);
		util.dummyWait(1);
	}
	
	 By LPDDropdown = By.xpath("//input[contains(@id,'_Last_Payment_Type_ID_radYALDropDownList_Input')and @type='text']");
    public void SelectpaymentDropdown(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(LPDDropdown, value);
		util.waitUntilElementDisplay(btnSaveTemplate);
		util.click(btnSaveTemplate);
		util.dummyWait(2);
	}
    
    public void SelectLPDDropdown(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(LPDDropdown, value);
	}
	
    By BtnSubmitForReview = By.xpath("//input[contains(@id, 'btnSubmitPeerReview')]");
    By BtnApprove = By.xpath("//input[contains(@id,'btnApprove')]");
    public void ApproveTemplate() {
    	util.waitUntilElementDisplay(BtnSubmitForReview);
    	util.click(BtnSubmitForReview);
    	util.waitUntilElementDisplay(BtnApprove);
    	util.click(BtnApprove);
    }
    
	 public void addPaymentTemplate(Map<String, String> map,String testCaseName)  {
	    	
		 try {
			 By copiedTemplate = By.xpath("(//strong[contains(text(),'"+ProjectGlobalTemplatePage.CUSTOM_DATES_TEMPLATE+"')])[2]");
			util.click(copiedTemplate);
			 util.waitFor(200);
				log("STEP 1: user can select Copied Template ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot select Copied Template ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
		 
		 try {
				AddDisplayName(map.get("EditDisplayName"));
				QUARTER_END_TEMPLATE=map.get("EditDisplayName");
				if(environment.contains("NEXTERA")) {
					setPaymentType("Access Road Payment- Accrued");
				}
				log("STEP 2: user can update value in Display Name textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot update value in Display Name textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}

 	 	try {
 	 		ClickOnSaveTemplate();
				log("STEP 3: user can click on save button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
	 
 	 	try {
    		SelectFirstPaymentDateDDButton();
    		SelectFPDDropdown(map.get(Excel.FirstPaymentDateDropdown));
			log("STEP 4: User can select value from First Payment Date Dropdown  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select value from First Payment Date Dropdown ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
    	
 	 	try {
 	 		SelectQuarterEndRadioButton();
 	 		if (LoginPage.isApplicableVersion(LoginPage.VERSION)) {
 	 			SelectAdditionalPaymentType("Quarter End");
			 }
				log("STEP 5: user can select Quarter End Radio Button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot select Quarter End Radio Button ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
 	 	
    	try {
    		SelectLastPaymentDateDDButton();
    		SelectpaymentDropdown(map.get(Excel.LastPaymentDateDropdown));
			log("STEP 6: User can select value from Last Payment DateDropdown ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot select value from Last Payment DateDropdown ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
    	

    	try {
    		ClickonTagLookUp();
			log("STEP 7: user can click on tag lookup  button.  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot  click on tag lookup  button.  ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
    	
    	try {
    		ClickonVariablesTab();
			log("STEP 8: user can click on variable tab ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  user cannot  click on variable tab. ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
    	
    	try {
    		util.click(drpVariableName);
			log("STEP 9: user can expand variable name dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot expand variable name dd", Status.FAIL);
		}
    	
    	 By variable = By.xpath("//div[@id='VariableName_radYALDropDownList_DropDown']/..//li[text()='"+map.get(Excel.VariableName)+"']");
    	
    	 if(!util.isElementVisible(variable)) {
    	try {
    		ClickonAddNewButton();
			log("STEP 10: User can click on Add New Variable ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot click on Add New Variable ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
    	
    	try {
    		AddVariableName(map.get(Excel.VariableName));
			log("STEP 11: user can enter value in Variable Name textbox   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot enter value in Variable Name textbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
    	
    	try {
    		ClickonSaveButton();
			log("STEP 12: user can click on save button.", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: user cannot  click on save button", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
    	 }
    	 
    	try {
    		SelectVariableName(map.get(Excel.VariableName));
			log("STEP 13: User can select value from Variable Name dd   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: User cannot select value from Variable Name dd  ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
    	
    	for(int i=1; i<=4; i++) {
    		By varValue = By.xpath("//tr[contains(@id,'VARIABLEVALUES_radYALGridControl')]/..//td[text()='"+map.get(Excel.DisplayName+i)+"']");
    		
    		if(!util.isElementVisible(varValue)) {
    	try {
    		ClickonAddNewRecord();
			log("STEP 14: user can click on add new record  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user cannot  click on add new record  ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
    	
    	try {
    		SelectDisplayName(map.get(Excel.DisplayName+i));
			log("STEP 15: user can enter value in Display Name textbox  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: User cannot enter value in Display Name textbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
    	
    	try {
    		AddValidFrom(map.get(Excel.ValidFrom+i));
			log("STEP 16: user can enter value in Valid From textbox   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: User cannot enter value in Valid From textbox  ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
    	
    	try {
    		SelectTypeOfCalculation(map.get(Excel.TypeofCalculation));
			log("STEP 17: User can select value from Type of Calculation dd  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: User cannot select value from Type of Calculation dd  ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
    	
    	try {
    		AddValid1(map.get("Valid"+i));
			log("STEP 18: user can enter value in Valid1 textbox  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: User cannot enter value in Valid1 textbox ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
    	
    	try {
    		ClickonInsert();
			log("STEP 19: user can click on insert button    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: user cannot click on insert button   ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
    	
    	Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
		if (util.isElementPresent(SuccessMessage)) {
			log("STEP 20:'Changes saved successfully!'  message will be displayed & record will be deleted from grid..", Status.PASS);
		} else {
			log("STEP 20:user cannot click on insert button  ", Status.FAIL);
			throw new RuntimeException("Faild in STEP 20");
		}
    		}
    	}
    	
    	try {
    		ClickonCloseTagLookup();
			log("STEP 21: user can close the Tag Lookup Popup", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: user cannot  close the Tag Lookup Popup ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
    	
	    	try {
	    		selectTypeofCalculation(map.get(Excel.TypeofCalculation));
				log("STEP 22:  User can select value from Type of Calculation dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 22: User cannot select value from Type of Calculation dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 22");
			}
	    	
	    	try {
	    		AddOption1DisplayName(map.get(Excel.Option1DisplayName));
				log("STEP 23: user can enter value in Option1 Display Name textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 23: User cannot enter value in Option1 Display Name textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 23");
			}
	    	
	    	try {
	    		AddOption1Formula(map.get(Excel.Option1Formula));
				log("STEP 24: user can enter value in Option1 Formula textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 24: User cannot enter value in Option1 Formula textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 24");
			}
	    	
	    	try {
	    		ClickOnSaveTemplate();
				log("STEP 25: user can click on save template button ", Status.PASS);
			} catch (Exception e) {
				log("STEP 25: User cannot click on save template button", Status.FAIL);
				throw new RuntimeException("Failed in step 25");
			}
				
	    	if(util.isElementVisible(BtnSubmitForReview)) {
	    		try {
		    		ApproveTemplate();
					log("STEP 26 user can able to approve template ", Status.PASS);
				} catch (Exception e) {
					log("STEP 26 user cannot approve the tempalte ", Status.FAIL);
					throw new RuntimeException("Failed to approve");
				}	
	    	}
	    	
   }
	 
	 
	 By btnDuplicate = By.xpath("//input[contains(@id,'_Duplicate')]");
	 By iframeDuplicate = By.xpath("//iframe[@name='LeaseCopy']");
	 By btnsave = By.xpath("//input[contains(@id,'btnLinkLogs')]");
	 public void ClickOnDuplicateButton() {
			util.waitUntilElementDisplay(btnDuplicate);
		    util.click(btnDuplicate);
		    util.switchToIframe(iframeDuplicate);
		}
	 
	 By btnRefresh = By.xpath("(//img[contains(@id,'PAYLST_RadGridTracts') and @alt='refresh'])[2]");
	 public void ClickonSave() {
			util.waitUntilElementDisplay(btnsave);
			util.click(btnsave);	
			util.switchToDefaultContent();
			util.click(btnClose);
			util.dummyWait(2);
			util.click(btnRefresh);
			util.dummyWait(2);
		}
		
	 By EveryOptionButton = By.xpath("//input[contains(@id,'_optAPMonths') and @type='radio']");
	    By txtTextbox = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_Additional_Payment_Frequency']");
	    By drpDropdown = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock2_C_Additional_Payment_Frequency_ID_radYALDropDownList_Input']");
	 public void SelectEveryRadioButton() {
			util.waitUntilElementDisplay(EveryOptionButton);
			util.click(EveryOptionButton);
		}
		
		public void addFrequency(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtTextbox, value);
		}
		
		public void addPeriod(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpDropdown, value);
		}
		
		By drpPaymentType = By.xpath("//input[contains(@id,'_Payment_type_ID_radYALDropDownList_Input') and @type='text']");
		public void setPaymentType(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpPaymentType, value);
		}
		
		By drpProjectName = By.xpath("//input[@name='ddlProject' and @type='text']");
		public void selectProjectName(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpProjectName, value);
		}
		
	 public void createTemplate(Map<String, String> map,String testCaseName)  {
	    	
		 try {
			 COPY_TEMPLATE=util.getAttributeValue(txtDisplayName, "value");
				ClickOnDuplicateButton();
				if(testCaseName.contains("PowerFunction") || testCaseName.contains("CPI")) {
					selectProjectName(map.get(Excel.ProjectName));
				}
				log("STEP 1:user can click on duplicate button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: User cannot click on duplicate button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}    	
	    	
	    	try {
	    		ClickonSave();
				log("STEP 2: user can click on save button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: User cannot click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
		 
		 try {
			 By copiedTemplate = By.xpath("(//strong[contains(text(),'"+COPY_TEMPLATE+"')])[2]");
			util.click(copiedTemplate);
			 util.waitFor(200);
				log("STEP 3: user can select Copied Template ", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: User cannot select Copied Template ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
		 
		 try {
				AddDisplayName(map.get("EditDisplayName"));
				setPaymentType("Access Road Payment- Accrued");
				log("STEP 4: user can update value in Display Name textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: User cannot update value in Display Name textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
		 
		 try {
			 SelectEveryRadioButton();
				log("STEP 5: user can select Every Radio Button  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: User cannot select Every Radio Button ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
		 
		 try {
			 addFrequency("1");
				log("STEP 6: user can update Payment Frequency  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: User cannot update Payment Frequency ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
		 
		 try {
			 addPeriod("Years");
				log("STEP 7: user can select Payment Frequency from the dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: User cannot select Payment Frequency from the dd ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}

		 try {
	    		SelectFirstPaymentDateDDButton();
	    		SelectFPDDropdown(map.get(Excel.FirstPaymentDateDropdown));
			log("STEP 8: User can select 'Effective Date' from First Payment Date Dropdown  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot select 'Effective Date' from First Payment Date Dropdown ", Status.FAIL);
			throw new RuntimeException("Failed in step8");
		}
		 
	    	
	    	try {
	    		SelectLastPaymentDateDDButton();
	    		SelectLPDDropdown(map.get(Excel.LastPaymentDateDropdown));
				log("STEP 9: User can select 'Expiration Date' from Last Payment DateDropdown ", Status.PASS);
			} catch (Exception e) {
				log("STEP 9: User cannot select 'Expiration Date' from Last Payment DateDropdown ", Status.FAIL);
				throw new RuntimeException("Failed in step 9");
			}
	    	
		 try {
	    		selectTypeofCalculation(map.get(Excel.TypeofCalculation));
				log("STEP 10:  User can select value from Type of Calculation dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: User cannot select value from Type of Calculation dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
	    	
	    	try {
	    		AddOption1DisplayName(map.get(Excel.Option1DisplayName));
				log("STEP 11: user can enter value in Option1 Display Name textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 11: User cannot enter value in Option1 Display Name textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 11");
			}
	    	
	    	try {
	    		AddOption1Formula(map.get(Excel.Option1Formula));
				log("STEP 12: user can enter value in Option1 Formula textbox  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 12: User cannot enter value in Option1 Formula textbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 12");
			}
		 
	    	
 	 	try {
 	 		ClickOnSaveTemplate();
				log("STEP 13: user can click on save button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: User cannot click on save button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
 	 	
 	 	if(util.isElementVisible(BtnSubmitForReview)) {
    		try {
	    		ApproveTemplate();
				log("STEP 14 user can able to approve template ", Status.PASS);
			} catch (Exception e) {
				log("STEP 14 user cannot approve the tempalte ", Status.FAIL);
				throw new RuntimeException("Failed to approve");
			}	
    	}
	 }
}
