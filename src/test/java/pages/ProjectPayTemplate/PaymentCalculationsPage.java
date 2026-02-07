package pages.ProjectPayTemplate;

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

public class PaymentCalculationsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public PaymentCalculationsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectPayTemplate = By.xpath("//span[contains(text(),'Project Pay Templates')]");
	 
	//for ROW
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navPaymentTemplates = By.xpath("//span[contains(text(),'Payment Templates')]");
	By navProjectPayTemplates = By.xpath("//span[contains(text(),'Project Pay Templates')]"); 
	
	By drpTypeofCalculation = By.xpath("//input[contains(@id,'_CALCULATION_TYPE_ID_radYALDropDownList_Input')and @type='text']");
	By txtOption1DisplayName = By.xpath("//input[contains(@id,'_Option1_Display_name')and @type='text']");
	By txtOption1Formula = By.xpath("//textarea[@id='ctl00_ConPHRightTop_CTRINFO_RadDock3_C_Option1_Formula'] | //*[@id='ctl00_ConPHRightTop_CTRINFO_RadDock3_C_Option1_Formula_contentIframe']");
	By txtOption2DisplayName = By.xpath("//input[contains(@id,'_Option2_Display_name') and @type='text']");
	By txtOption2Formula = By.xpath("//textarea[@id='ctl00_ConPHRightTop_CTRINFO_RadDock3_C_Option2_Formula'] | //*[@id='ctl00_ConPHRightTop_CTRINFO_RadDock3_C_Option2_Formula_contentIframe']");
    By drpProject = By.xpath("//input[contains(@id,'_ddProjects_Input')and @type='text']");
    By drpLeases = By.xpath("//input[contains(@id,'ddLeases_Input')and @type='text']");
    By btnShowCalculation = By.xpath("//input[contains(@id,'_btnImgShow')and @type='image']");
    By btnTestCalculation = By.xpath("//input[contains(@id,'_btnImgTestCalc')and @type='image']");
    By btnTagLookUp = By.xpath("(//img[@alt='Tag Help'])[1]");
    By iframe = By.xpath("//iframe[@name='LeasePayTags']");
    By tabVariables = By.xpath("//span[contains(text(),'Variables')]");
    By btnAddNew = By.xpath("//input[@id='btnAddNewVariable']");
    By txtVariableName = By.xpath("//input[@id='NewTagName']");
    By btnSave = By.xpath("//input[@id='btnSaveNew']");
    By drpVariableName = By.xpath("//input[@id='VariableName_radYALDropDownList_Input']");
    By btnAddNewRecord = By.xpath("//img[@id='VARIABLEVALUES_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
    By txtDisplayName = By.xpath("//input[contains(@id,'txtValueDisplayName') and @type = 'text']");
    By txtValidFrom = By.xpath("//input[contains(@id,'txtValueValidFrom') and @type = 'text']");
    By drpTypeOfCalculation = By.xpath("//input[@id='CALCULATION_TYPE_ID_radYALDropDownList_Input'] | //input[contains(@id,'EditFormControl_CALCULATION_TYPE_ID_radYALDropDownList_Input') and @type = 'text']");
    By txtValid1 = By.xpath("//input[contains(@id,'txtValue1') and @type = 'text']");
    By txtValid2 = By.xpath("//input[contains(@id,'txtValue2') and @type = 'text']");
    By btnInsert = By.xpath("//input[contains(@id,'_btnInsert') and @type = 'submit']");
    By btnCancel = By.xpath("//input[contains(@id,'_btnCancel') and @type = 'submit']");
    By btnEdit = By.xpath("//input[contains(@id,'_EditButton') and @type = 'image']");
    By btnDelete = By.xpath("//input[contains(@id,'_gbcDeleteAlignment') and @type = 'image']");
    By btnUpdate = By.xpath("//input[contains(@id,'_btnUpdate') and @type = 'submit']");
    By DrpLeases = By.xpath("//input[@id='ddLeases_Input']");
    By btnTestCanculation = By.xpath("//input[@id='btnImgTestCalc']");		
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
    By tabledata = By.xpath("//div[@id='RadMultiPage1']");
    By btnClose = By.xpath("//a[@title='Close']");
    By btnSaveTemplate = By.xpath("//input[contains(@id,'CTRINFO_RadDock1_C_btnSave')]");
    By btnSubmittoPeerReview = By.xpath("//input[contains(@id,'_btnSubmitPeerReview') and @type = 'image']");
    By btnApprove = By.xpath("//input[contains(@id,'_btnApprove') and @type='image']");
	By btnAgreement = By.xpath("//input[contains(@value,'Add to Agreement')] | //input[contains(@value,'Add to Lease')]");
	By btnLeases = By.xpath("//img[@alt='Add to Lease']");
	By iframeLease = By.xpath("//iframe[@name='LeaseTermsBulk']");
	By drpAgreementType = By.xpath("//input[@id='Lease_Type_ID_radYALDropDownList_Input']");
	By Searchbtn = By.xpath("//input[@id='btnSearch']");
	By drpStartPaymentFrom = By.xpath("//input[@id='START_PAYMENTS_FROM_dateInput']");
	By save = By.xpath("//input[@id='btnApplyPayTemplate']");
	By CheckboxShowAll = By.xpath("//input[@id='chkShowLeasesWithTerms']");
	By CheckboxSelectAll = By.xpath("//input[@id='chkSelectAll']");
    By message = By.xpath("//span[@id='usrMessageAdd']");
	    
	 public void nevigateToProjectPayTemplate() {
			util.waitUntilElementDisplay(navProject);
			util.click(navProject);
			util.waitUntilElementDisplay(navProjectPayTemplate);
			util.click(navProjectPayTemplate);
		}
		
		public void nevigateToProjectPayTemplateRow() {
			util.waitUntilElementDisplay(navAdministration);
			util.click(navAdministration);
			util.waitUntilElementDisplay(navPaymentTemplates);
			util.click(navPaymentTemplates);
			util.waitUntilElementDisplay(navProjectPayTemplates);
			util.click(navProjectPayTemplates);
		}
		
		public void selectTypeofCalculation(String value) {
			util.waitUntilElementDisplay(drpTypeofCalculation);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpTypeofCalculation, value);
		}
		
//		public void selectTypeofCalculation(String value) {
//			util.waitUntilElementDisplay(drpTypeofCalculation);
//			if (!commonFunction.checkNA(value))
//				util.inputText(drpTypeofCalculation, value);
//			By text = By.xpath("//em[contains(text(),'"+value+"')]/..");
//			util.click(text);
//		}
		
		 By selectCalculationType = By.xpath("//div[@id='CALCULATION_TYPE_ID_radYALDropDownList_DropDown']/..//li[1] | //div[contains(@id,'CALCULATION_TYPE_ID_radYALDropDownList_DropDown') and contains(@id,'VARIABLEVALUES')]/..//li[1] ");
		public void selectTypeofCalculation() {
			util.click(drpTypeofCalculation);
			util.click(selectCalculationType);
		}
		
		public void AddOption1DisplayName(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtOption1DisplayName, value);
		}
		
		public void AddOption1Formula(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtOption1Formula, value);
		}
		
		public void AddOption1FormulaCPI(String value) {
			if (!commonFunction.checkNA(value))
				util.inputText(txtOption1Formula, value);
		}
		
		public void AddOption2DisplayName(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtOption2DisplayName, value);
		}
		
		public void AddOption2Formula(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtOption2Formula, value);
			util.waitUntilElementDisplay(btnSaveTemplate);
			util.click(btnSaveTemplate);
			util.dummyWait(2);
		}
		
		public void AddProject(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpProject, value);
			
		}
		
		public void AddLeases(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpLeases, value);
		}
		
		public void ClickonShowCalculation() {
			util.waitUntilElementDisplay(btnShowCalculation);
			util.click(btnShowCalculation);
		}
		
		public void ClickonTestCalculation() {
			util.waitUntilElementDisplay(btnTestCalculation);
			util.click(btnTestCalculation);
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
			util.dummyWait(1);
			util.click(btnAddNew);
		}
		
		public void ClickonAddNewButtonAlT() {
			util.waitUntilElementDisplay(btnAddNew);
			util.click(btnAddNew);
		}
		
		public void AddVariableName(String value) {
			util.dummyWait(2);
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
			util.waitUntilElementDisplay(txtDisplayName);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDisplayName, value);
		}
		
		public void AddValidFrom(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtValidFrom, value);
		}
		
		
		public void SelectTypeOfCalculation(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpTypeOfCalculation, value);
		}
		
		By firstValue = By.xpath("(//*[contains(@id,'_EditFormControl_CALCULATION_TYPE_ID_radYALDropDownList')]/..//li)[1]");
		public void SelectTypeOfCalculation() {
			util.click(drpTypeOfCalculation);
			util.click(firstValue);
		}
		
		public void AddValid1(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtValid1, value);
		}
		
		public void AddValid2(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtValid2, value);
		}
		
		By btnSaveRow = By.xpath("//input[contains(@id,'btnSaveNewValue') and @type = 'image']");
		public void ClickonSaveRow() {
			util.waitUntilElementDisplay(btnSaveRow);
			util.click(btnSaveRow);
			util.dummyWait(2);
		}
		
		public void ClickonInsert() {
			util.waitUntilElementDisplay(btnInsert);
			util.click(btnInsert);
			util.dummyWait(2);
		}
		
		public void ClickonCancel() {
			util.waitUntilElementDisplay(btnAddNewRecord);
			util.click(btnAddNewRecord);
			util.dummyWait(2);
			util.waitUntilElementDisplay(btnCancel);
			util.click(btnCancel);
		}
		
		public void ClickonEditButton() {
			util.waitUntilElementDisplay(btnEdit);
			util.click(btnEdit);
			util.dummyWait(2);
		}
		
		public void ClickonUpdateButton() {
			util.waitUntilElementDisplay(btnUpdate);
			util.click(btnUpdate);
			util.dummyWait(2);
		}
		
		public void ClickonDeleteButton() {
			util.waitUntilElementDisplay(btnDelete);
			util.click(btnDelete);
			driver.switchTo().alert().accept();
			util.dummyWait(2);
			util.waitUntilElementDisplay(SuccessMessage);
			Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
		}
		
		public void SelectLeases(String value) {
			util.dummyWait(2);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpLeases, value);
		}
		
		public void ClickonTestCanculation() {
			util.waitUntilElementDisplay(btnTestCanculation);
			util.click(btnTestCanculation);
			util.dummyWait(2);
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
		
		By btnSAVE = By.xpath("//input[contains(@id,'btnSave')]");
		public void ClickonSave() {
			util.waitUntilElementDisplay(btnSAVE);
			util.click(btnSAVE);
		}
		
		By btnActive = By.xpath("//input[contains(@id,'_Active_Ind') and @type='checkbox']");
		public void ClickOnActiveCheckBox() {
			util.waitUntilElementDisplay(btnActive);
			util.click(btnActive);
			util.dummyWait(2);
			util.click(btnActive);
			util.dummyWait(2);

			
		}
		
		public void ClickonAgreementButton() {
		util.waitUntilElementDisplay(btnAgreement);
		util.click(btnAgreement);	
		util.switchToIframe(iframeLease);
	   }

	    public void ClickonLeasesButton() {
	    	util.waitUntilElementDisplay(btnLeases);
		    util.click(btnLeases);	
		    util.switchToIframe(iframeLease);
	    }

	     public void AddAgreementType(String value) {
		    if (!commonFunction.checkNA(value))
		    	util.inputTextAndPressTab(drpAgreementType, value);
	    }

	      public void ClickonSearchButton() {
		     util.waitUntilElementDisplay(Searchbtn);
		        util.click(Searchbtn);	
	    }

	      public void SelectStartPaymentFrom(String StartPaymentFrom) {
			util.inputTextAndPressTab(drpStartPaymentFrom, StartPaymentFrom);
	    }

	    public void ClickOnSave() {
		      util.waitUntilElementDisplay(save);
		         util.click(save); 
		         util.dummyWait(3);
      
	     }

	      By SaveBtn = By.xpath("//input[@id='ctl00_ConPHRightTop_CTRINFO_RadDock1_C_btnSave']");
	      public void ClickOnsave() {
		      util.waitUntilElementDisplay(SaveBtn);
		         util.click(SaveBtn); 
		         util.dummyWait(3);
      
	     }
	    public void ClickonShowAllCheckbox() {
		     util.waitUntilElementDisplay(CheckboxShowAll);
		        util.click(CheckboxShowAll);	
	    }

	    public void ClickonSelectAllCheckbox() {
		      util.waitUntilElementDisplay(CheckboxSelectAll);
		         util.click(CheckboxSelectAll);	
	    }
		
	    public void ApproveTemplate() {
	    	util.waitUntilElementDisplay(BtnSubmitForReview);
	    	util.click(BtnSubmitForReview);
	    	util.waitUntilElementDisplay(BtnApprove);
	    	util.click(BtnApprove);
	    }
	    By BtnSubmitForReview = By.xpath("//input[contains(@id, 'btnSubmitPeerReview')]");
	    By BtnApprove = By.xpath("//input[contains(@id,'btnApprove')]");
	    By optionCPI_U = By.xpath("(//div[text()='CPI-U'])[1]");
	    By optionCPI_ED = By.xpath("(//div[text()='CPI-U-COMPOUNDEDFROMEFFECTIVEDATE'])[1]");
	    By optionCPI_FPD = By.xpath("(//div[text()='CPI-U-COMPOUNDEDFROMFIRSTPAYMENT'])[1]");
	    
		 public void PaymentCalculations(Map<String, String> map,String testCaseName)  {

		    	try {
		    		selectTypeofCalculation(map.get(Excel.TypeofCalculation));
					log("STEP 1:  User can select value from Type of Calculation dd  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: User cannot select value from Type of Calculation dd  ", Status.FAIL);
					throw new RuntimeException("Failed in step 1");
				}
		    	
		    	try {
		    		AddOption1DisplayName(map.get(Excel.Option1DisplayName));
					log("STEP 2: user can enter value in Option1 Display Name textbox  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: User cannot enter value in Option1 Display Name textbox ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
				
		    	if(testCaseName.contains("ALT") || testCaseName.contains("ORION") || testCaseName.contains("ORSTED") || testCaseName.contains("ATWELL")) {
					
					try {
			    		AddOption1Formula("{CPI");
			    		ExtentTestManager.infoWithScreenshot("CPI Tags");
						log("STEP 3: user can enter 'CPI' value in Option1 Formula textbox  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 3: User cannot enter 'CPI' value in Option1 Formula textbox ", Status.FAIL);
					}
					
//					try {
//						Assert.assertTrue(util.isElementPresent(optionCPI_ED));
//						log("STEP 4: user can see CPI-U-COMPOUNDEDFROMEFFECTIVEDATE Tagg suggestions for enter CPI characters ", Status.PASS);
//					} catch (AssertionError e) {
//						log("STEP 4: User cannot see CPI-U-COMPOUNDEDFROMEFFECTIVEDATE Tag suggestions for enter CPI characters  ", Status.FAIL);
//					}
//					
//					try {
//						util.waitFor(300);
//						Assert.assertTrue(util.isElementPresent(optionCPI_FPD));
//						log("STEP 5: user can see CPI-U-COMPOUNDEDFROMFIRSTPAYMENT Tag suggestions for enter CPI characters ", Status.PASS);
//					} catch (AssertionError e) {
//						log("STEP 5: User cannot see CPI-U-COMPOUNDEDFROMFIRSTPAYMENT Tag suggestions for enter CPI characters  ", Status.FAIL);
//					}
					
					try {
			    		AddOption1Formula(map.get("InvalidTag"));
			    		util.click(txtOption2DisplayName);
						log("STEP 7: user can enter Invalid Tag in Option1 Formula textbox  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 7: User cannot enter Invalid Tag in Option1 Formula textbox ", Status.FAIL);
						throw new RuntimeException("Failed in step 7");
					}
					
					try {
						util.switchToIframe(txtOption1Formula);
						By invalidTagColor = By.xpath("(//font[text()='"+map.get("InvalidTag")+"' and @color='red'])[1]");
						System.out.println(invalidTagColor);
						Assert.assertTrue(util.isElementVisible(invalidTagColor));
						util.switchToDefaultContent();
						log("STEP 8: user can see Invalid Tag Font Color in Red", Status.PASS);
					} catch (AssertionError e) {
						log("STEP 8: User cannot see Invalid Tag Font Color in Red", Status.FAIL);
					}
				}
		    	
		    	try {
		    		AddOption1Formula(map.get(Excel.Option1Formula));
					log("STEP 9: user can enter value in Option1 Formula textbox  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 9: User cannot enter value in Option1 Formula textbox ", Status.FAIL);
					throw new RuntimeException("Failed in step 9");
				}
				
		    	try {
		    		AddOption2DisplayName(map.get(Excel.Option2DisplayName));
					log("STEP 10: user can enter value in Option2 Display Name textbox  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 10: User cannot enter value in Option2 Display Name textbox ", Status.FAIL);
					throw new RuntimeException("Failed in step 10");
				}
		    	
		    	try {
		    		AddOption2Formula(map.get(Excel.Option2Formula));
					log("STEP 11: user can enter value in Option2 Formula textbox    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 11: User cannot enter value in Option2 Formula textbox ", Status.FAIL);
					throw new RuntimeException("Failed in step 11");
				}
		    	
		    	if(util.isElementVisible(BtnSubmitForReview)) {
		    		try {
			    		ApproveTemplate();
						log("STEP 12 user can able to approve template ", Status.PASS);
					} catch (Exception e) {
						log("STEP 12 user cannot approve the tempalte ", Status.FAIL);
						throw new RuntimeException("Failed to approve");
					}	
		    	}
		    	
		    	if(util.isElementVisible(drpProject)) {
		    	try {
		    		AddProject(map.get(Excel.Project));
		    		util.dummyWait(2);
					log("STEP 13: User can select value from Project dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 13: User cannot select value from Project dd", Status.FAIL);
					throw new RuntimeException("Failed in step 13");
				}
		    	
		    	try {
		    		AddLeases(map.get(Excel.Lease));
					log("STEP 14: User can select value from Lease dd ", Status.PASS);
				} catch (Exception e) {
					log("STEP 14: User cannot select value from Lease dd ", Status.FAIL);
					throw new RuntimeException("Failed in step 14");
				}
		    	
		    	try {
		    		ClickonShowCalculation();
					log("STEP 15: user can click on show calculations button.", Status.PASS);
				} catch (Exception e) {
					log("STEP 15: user cannot  click on show calculations button. ", Status.FAIL);
					throw new RuntimeException("Failed in step 15");
				}
		    	util.waitFor(5000);
		    	try {
		    		ClickonTestCalculation();
					log("STEP 16: user can click on test calculations button. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 16: user cannot  click on test calculations button. ", Status.FAIL);
					throw new RuntimeException("Failed in step 16");
				}
		    	util.waitFor(5000);
		    	}
		    	else {
		    		log("Payment Test Calculation buttons not visible");
		    	}
		    	try {
		    		ClickonTagLookUp();
					log("STEP 17: user can click on tag lookup  button.  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 17: user cannot  click on tag lookup  button.  ", Status.FAIL);
					throw new RuntimeException("Failed in step 17");
				}
		    	
		    	try {
		    		ClickonVariablesTab();
					log("STEP 18: user can click on variable tab ", Status.PASS);
				} catch (Exception e) {
					log("STEP 18:  user cannot  click on variable tab. ", Status.FAIL);
					throw new RuntimeException("Failed in step 18");
				}
		    	
		    	if(testCaseName.contains("ALT")|| testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
		    		try {
			    		ClickonAddNewButtonAlT();
						log("STEP 19: Variable name textbox will be visible.", Status.PASS);
					} catch (Exception e) {
						log("STEP 19: Variable name textbox will not be visible. ", Status.FAIL);
						throw new RuntimeException("Failed in step 19");
					}
		    	}
		    	else {
		    	try {
		    		ClickonAddNewButton();
					log("STEP 19: Variable name textbox will be visible.", Status.PASS);
				} catch (Exception e) {
					log("STEP 19: Variable name textbox will not be visible. ", Status.FAIL);
					throw new RuntimeException("Failed in step 19");
				}
		   	}	
		    	try {
		    		AddVariableName(map.get(Excel.VariableName));
					log("STEP 20: user can enter value in Variable Name textbox   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 20: User cannot enter value in Variable Name textbox ", Status.FAIL);
					throw new RuntimeException("Failed in step 20");
				}
		    	
		    	try {
		    		ClickonSaveButton();
					log("STEP 21: user can click on save button.   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 21: user cannot  click on save button. ", Status.FAIL);
					throw new RuntimeException("Failed in step 21");
				}
		    	
		    	try {
		    		SelectVariableName(map.get(Excel.VariableName));
					log("STEP 22: User can select value from Variable Name dd   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 22: User cannot select value from Variable Name dd  ", Status.FAIL);
					throw new RuntimeException("Failed in step 22");
				}
		    	
		    	if(testCaseName.contains("ALT")|| testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
		    	try {
		    		ClickonAddNewRecord();
					log("STEP 23: user can click on add new record  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 23: user cannot  click on add new record  ", Status.FAIL);
					throw new RuntimeException("Failed in step 23");
				}
		    }
		    	
		    	try {
		    		SelectDisplayName(map.get(Excel.DisplayName));
					log("STEP 24: user can enter value in Display Name textbox  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 24: User cannot enter value in Display Name textbox ", Status.FAIL);
					throw new RuntimeException("Failed in step 24");
				}
		    	
		    	try {
		    		AddValidFrom(map.get(Excel.ValidFrom));
					log("STEP 25: user can enter value in Valid From textbox   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 25: User cannot enter value in Valid From textbox  ", Status.FAIL);
					throw new RuntimeException("Failed in step 25");
				}
		    	
		    	try {
		    		SelectTypeOfCalculation(map.get(Excel.TypeofCalculation));
					log("STEP 26: User can select value from Type of Calculation dd  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 26: User cannot select value from Type of Calculation dd  ", Status.FAIL);
					throw new RuntimeException("Failed in step 26");
				}
		    	
		    	try {
		    		AddValid1(map.get(Excel.Valid1));
					log("STEP 27: user can enter value in Valid1 textbox  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 27: User cannot enter value in Valid1 textbox ", Status.FAIL);
					throw new RuntimeException("Failed in step 27");
				}
		    	
		    	try {
		    		AddValid2(map.get(Excel.Valid2));
					log("STEP 28: user can enter value in Valid2 textbox  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 28: User cannot enter value in Valid2 textbox ", Status.FAIL);
					throw new RuntimeException("Failed in step 28");
				}
		    	
		    	if(testCaseName.contains("ROW") || testCaseName.contains("TRA")) {
		    		try {
			    		ClickonSaveRow();
			    		log("STEP 29:  user can click on save button", Status.PASS);
					} catch (Exception e) {
						log("STEP 29: User cannot click on Save button ", Status.FAIL);
						throw new RuntimeException("Failed in step 29");
					}
		    	}
		    
		    	else {
		    	
		    	try {
		    		ClickonInsert();
					log("STEP 29: user can click on insert button    ", Status.PASS);
				} catch (Exception e) {
					log("STEP 29: user cannot click on insert button   ", Status.FAIL);
					throw new RuntimeException("Failed in step 29");
				}
		    	Assert.assertTrue(util.isElementPresent(SuccessMessage), "Changes saved successfully!");
	    		if (util.isElementPresent(SuccessMessage)) {
	    			log("STEP 30:'Changes saved successfully!'  message will be displayed & record will be deleted from grid..", Status.PASS);
	    		} else {
	    			log("STEP 30:user cannot click on insert button  ", Status.FAIL);
	    			throw new RuntimeException("Faild in STEP 30 :user cannot click on insert button  ");
	    		}
		    	
		    	try {
		    		ClickonCancel();
					log("STEP 31: user can click on cancel button  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 31: User cannot click on cancel button ", Status.FAIL);
					throw new RuntimeException("Failed in step 31");
				}
		    	util.dummyWait(3);
		    	try {
		    		ClickonEditButton();
					log("STEP 32: user can edit record  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 32: user cannot edit record. ", Status.FAIL);
					throw new RuntimeException("Failed in step 32");
				}
		    	
		    	try {
		    		SelectDisplayName(map.get(Excel.EditDisplayName));
					log("STEP 33: user can Update Display Name ", Status.PASS);
				} catch (Exception e) {
					log("STEP 33: User cannot update display name ", Status.FAIL);
					throw new RuntimeException("Failed in step 33");
				}
		    	
		    	try {
		    		ClickonUpdateButton();
					log("STEP 34: user can click on update button  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 34: user cannot click on update button    ", Status.FAIL);
					throw new RuntimeException("Failed in step 34");
				}
		    	
		    	try {
		    		ClickonDeleteButton();
					log("STEP 35: user can click on cross icon  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 35: user cannot click on cross icon.    ", Status.FAIL);
					throw new RuntimeException("Failed in step 35");
				}
		    }	
		    	try {
		    		SelectLeases(map.get(Excel.Lease));
					log("STEP 36: User can select value from Lease dd  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 36: User cannot select value from Lease dd ", Status.FAIL);
					throw new RuntimeException("Failed in step 36");
				}
		    	
		    	try {
		    		ClickonTestCanculation();
					log("STEP 37: user can click on test calculations button.   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 37: user cannot  click on test calculations button.  ", Status.FAIL);
					throw new RuntimeException("Failed in step 37");
				}

		    	if(testCaseName.contains("ALT")|| testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
		    		try {
		    			ClickonAgreementButton();
		    			log("STEP 38: ser can click on agreement button. ", Status.PASS);
		    		} catch (Exception e) {
		    			log("STEP 38: User cannot click on add to agreement button. ", Status.FAIL);
		    			throw new RuntimeException("Failed in step 38");
		    		}	
		        }
		        	else {
		        		if(util.isElementVisible(btnLeases)) {
		        		try {
		        			ClickonLeasesButton();
		        			log("STEP 38: ser can click on agreement button. ", Status.PASS);
		        		} catch (Exception e) {
		        			log("STEP 38: User cannot click on add to agreement button.", Status.FAIL);
		        			throw new RuntimeException("Failed in step 38");
		        		}	
		        		}
		         }	
		    	
		    	if(util.isElementVisible(drpAgreementType)) {
		    	try {
		    		AddAgreementType(map.get(Excel.AgreementType));
					log("STEP 39: User can select value from Agreement Type dd   ", Status.PASS);
				} catch (Exception e) {
					log("STEP 39: User cannot select value from Agreement Type dd ", Status.FAIL);
					throw new RuntimeException("Failed in step 39");
				}
		    	
		    	try {
		    		ClickonSearchButton();
					log("STEP 40: User can click on search button. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 40: User cannot click on pin search button. ", Status.FAIL);
					throw new RuntimeException("Failed in step 40");
				}
		    	
		    	try {
		    		SelectStartPaymentFrom(TestUtil.getCurrentDateTime("MM/dd/yyyy"));
					log("STEP 41: User can select date from date picker. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 41: User cannot select date from date picker. ", Status.FAIL);
					throw new RuntimeException("Failed in step 41");
				}

		    	
				try {
					ClickonShowAllCheckbox();
					log("STEP 42:  User can check/uncheck ckeckbox ", Status.PASS);
				} catch (Exception e) {
					log("STEP 42: User cannot check/uncheck ckeckbox. ", Status.FAIL);
					throw new RuntimeException("Failed in step 42");
				}
				
				try {
					ClickonSelectAllCheckbox();
					log("STEP 43: User can check/uncheck ckeckbox ", Status.PASS);
				} catch (Exception e) {
					log("STEP 43: User cannot check/uncheck ckeckbox.", Status.FAIL);
					throw new RuntimeException("Failed in step 43");
				}
		    
				try {
		    		ClickOnSave();
					log("STEP 44:  user can click on save button", Status.PASS);
				} catch (Exception e) {
					log("STEP 44: User cannot click on Save button ", Status.FAIL);
					throw new RuntimeException("Failed in step 44");
				}
				
				if (util.isElementPresent(message)) {
					log("STEP 45: Success message will be displayed & record will be deleted from grid..", Status.PASS);
				} else {
					log("STEP 45: Success message does not display", Status.FAIL);
					throw new RuntimeException("Faild in STEP 45 :");
				}
				util.dummyWait(1);
				  util.switchToDefaultContent();
			         util.click(btnClose);
		    	
				util.dummyWait(5);	
		    	}
	   }


}
