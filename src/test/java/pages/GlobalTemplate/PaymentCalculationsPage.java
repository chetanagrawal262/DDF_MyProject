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

public class PaymentCalculationsPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;
	
	SoftAssert sf= new SoftAssert();

	public PaymentCalculationsPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navGlobalTemplate = By.xpath("//span[contains(text(),'Global Template')]");
	 
	//for ROW
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navPaymentTemplates = By.xpath("//span[contains(text(),'Payment Templates')]");
	By navGlobalPayTemplates = By.xpath("//span[contains(text(),'Global Pay Templates')]"); 
	
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
    By btnSaveTemplate = By.xpath("//input[contains(@id,'CTRINFO_RadDock1_C_btnSave')]");
    By drpVariableName = By.xpath("//input[@id='VariableName_radYALDropDownList_Input']");
    By btnAddNewRecord = By.xpath("//img[@id='VARIABLEVALUES_radYALGridControl_ctl00_ctl02_ctl00_Img4']");
    By txtDisplayName = By.xpath("//input[contains(@id,'xtValueDisplayName') and @type = 'text']");
    By txtValidFrom = By.xpath("//input[contains(@id,'txtValueValidFrom') and @type = 'text']");
    By drpTypeOfCalculation = By.xpath("//input[@id=\"CALCULATION_TYPE_ID_radYALDropDownList_Input\"] | //input[contains(@id,'EditFormControl_CALCULATION_TYPE_ID_radYALDropDownList_Input') and @type = 'text']");
    By txtValid1 = By.xpath("//input[contains(@id,'txtValue1') and @type = 'text']");
    By txtValid2 = By.xpath("//input[contains(@id,'txtValue2') and @type = 'text']");
    By btnInsert = By.xpath("//input[contains(@id,'_btnInsert') and @type = 'submit']");
    By btnCancel = By.xpath("//input[contains(@id,'_btnCancel') and @type = 'submit']");
    By btnEdit = By.xpath("//input[contains(@id,'_EditButton') and @type = 'image']");
    By btnUpdate = By.xpath("//input[contains(@id,'_btnUpdate') and @type = 'submit']");
    By btnDelete = By.xpath("//input[contains(@id,'_gbcDeleteAlignment') and @type = 'image']");
    By DrpLeases = By.xpath("//input[@id='ddLeases_Input']");
    By btnTestCanculation = By.xpath("//input[@id='btnImgTestCalc']");		
	By SuccessMessage = By.xpath("//span[text()='Changes saved successfully!']");
    By tabledata = By.xpath("//div[@id='RadMultiPage1']");
    By btnClose = By.xpath("//a[@title='Close']");
    
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
    
	public void nevigateToGlobalTemplet() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navGlobalTemplate);
		util.click(navGlobalTemplate);
	}
	
	public void nevigateToGlobalTempletRow() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navPaymentTemplates);
		util.click(navPaymentTemplates);
		util.waitUntilElementDisplay(navGlobalPayTemplates);
		util.click(navGlobalPayTemplates);
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
	
	public void AddOption1FormulaCPI(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtOption1Formula, value);
		util.waitFor(100);
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
	
	By BtnSubmitForReview = By.xpath("//input[contains(@id, 'btnSubmitPeerReview')]");
    By BtnApprove = By.xpath("//input[contains(@id,'btnApprove')]");
    public void ApproveTemplate() {
    	util.waitUntilElementDisplay(BtnSubmitForReview);
    	util.click(BtnSubmitForReview);
    	util.waitUntilElementDisplay(BtnApprove);
    	util.click(BtnApprove);
    }
    
    
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
					AddOption1FormulaCPI("{CPI");
					log("STEP 3: user can enter 'CPI' value in Option1 Formula textbox  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: User cannot enter 'CPI' value in Option1 Formula textbox ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
				
				try {
					Assert.assertTrue(util.isElementVisible(optionCPI_ED));
					log("STEP 5: user can see CPI-U-COMPOUNDEDFROMEFFECTIVEDATE Tagg suggestions for enter CPI characters ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 5: User cannot see CPI-U-COMPOUNDEDFROMEFFECTIVEDATE Tag suggestions for enter CPI characters  ", Status.FAIL);
				}
				
				try {
					Assert.assertTrue(util.isElementVisible(optionCPI_FPD));
					log("STEP 6: user can see CPI-U-COMPOUNDEDFROMFIRSTPAYMENT Tag suggestions for enter CPI characters ", Status.PASS);
				} catch (AssertionError e) {
					log("STEP 6: User cannot see CPI-U-COMPOUNDEDFROMFIRSTPAYMENT Tag suggestions for enter CPI characters  ", Status.FAIL);
				}
				
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
	    
   }
}
