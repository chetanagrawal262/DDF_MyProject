package pages.Title;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddTitleTrackingRecordPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER, GRANTOR;

	public AddTitleTrackingRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	
	By navTitleTracking = By.xpath("//span[contains(text(),'Title Tracking')]");
	By txtTaxAccountNumber = By.xpath("//input[contains(@id,'_TITLETRACK_PROPERTY_TAX') and @type='text']");
	By txtGISIdentifier = By.xpath("//input[contains(@id,'_TITLETRACK_GISID') and @type='text']");
	By txtSecretaryofState = By.xpath("//input[contains(@id,'_TITLETRACK_STATE_SEC_FILENO') and @type='text']");
	By drpDateChecked = By.xpath("//input[contains(@id,'_TITLETRACK_STATE_SEC_DATE_dateInput') and @type='text']");
	By txtTaxAssessed = By.xpath("//input[contains(@id,'_TITLETRACK_TAX_ASSESSED_TO') and @type='text']");
	By txtTaxYear = By.xpath("//input[contains(@id,'_TITLETRACK_TAX_YR') and @type='text']");
	By txtTaxstatus = By.xpath("//input[contains(@id,'_TITLETRACK_TAX_STATUS_ID_radYALDropDownList_Input') and @type='text']");
	By CheckedCheckbox = By.xpath("(//label[text()='Checked'])[1]");
	By txtTaxDelinquentFrom = By.xpath("//input[contains(@id,'_TITLETRACK_TAX_DELINQUENT_YR') and @type='text']");
	By txtCourtIndexedDate = By.xpath("//input[contains(@id,'_TITLETRACK_COURT_INDEXED_THROUGH_dateInput') and @type='text']");
	By txtSchoolDistrict = By.xpath("//input[contains(@id,'_TITLETRACK_School_District') and @type='text']");
	By txtTownship = By.xpath("//input[contains(@id,'_TITLETRACK_Township') and @type='text']");
	By txtAnnualTaxes = By.xpath("//input[contains(@id,'_TITLETRACK_Annual_Tax') and @type='text']");
	By txtLandValues = By.xpath("//input[contains(@id,'_TITLETRACK_Land_Value') and @type='text']");
	By txtBuildingValues = By.xpath("//input[contains(@id,'_TITLETRACK_Building_Value') and @type='text']");
	By txtLTCCompleted = By.xpath("//input[contains(@id,'_TITLETRACK_LTC_COMPLETED_BY') and @type='text']");
	By txtDateLTCCompleted = By.xpath("//input[contains(@id,'_TITLETRACK_DATE_LTC_COMPLETED_dateInput') and @type='text']");
	By txtLTCReviewedBy = By.xpath("//input[contains(@id,'_TITLETRACK_LTC_REVIEWED_BY') and @type='text']");
	By txtGrantor = By.xpath("//textarea[contains(@id,'_TITLETRACK_LEGAL_GRANTOR')]");
	By txtDateLTCReviewed = By.xpath("//input[contains(@id,'_TITLETRACK_DATE_LTC_REVIEWED_dateInput') and @type='text']");
	By txtSubdivisionPlat = By.xpath("//input[contains(@id,'_TITLETRACK_SUBDIVISION_VOL') and @type='text']");
	By txtPage = By.xpath("//input[contains(@id,'_TITLETRACK_SUBDIVISION_PAGE') and @type='text']");
	By txtLegalDescription = By.xpath("//iframe[contains(@id,'_TITLETRACK_PROPERTY_LEGAL_DESC_contentIframe')]");
//	By btnSave = By.xpath("//input[contains(@id,'_TITLETRACK_btnSaveTractTitle')]");
	By btnSave = By.xpath("//input[contains(@id,'_TITLEASSIGNMENT_TractType_btnSaveTract')]");
	By btnSaveROW = By.xpath("//input[contains(@id,'TITLETRACK_btnSaveTractTitle')]");
	By successmassageROW = By.xpath("//span[contains(@id,'TITLETRACK_usrMessage')]");
	By successmassage = By.xpath("//span[contains(text(),'Changes Saved Successfully!')] | //span[contains(text(),'Changes saved successfully!')]");
	By txtGrantorSummary = By.xpath("//td[contains(@id,'_Title_UC_radPanels_i0_i0_TITLEASSIGNMENT_TractSS_RadDockTractSS_C_tractInfo')]/..//strong[text()='Grantor:']");
	
	 public void ClickonTitleTracking() {
			util.waitUntilElementDisplay(navTitleTracking);
			util.click(navTitleTracking);
			util.dummyWait(3);			
		}
	 
	 public void AddTaxAccountNumber(String value) {
		 util.dummyWait(1);
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtTaxAccountNumber, value);
		}
	 
	 public void AddGISIdentifier(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtGISIdentifier, value);
		}
	 
	 
	 public void AddSecretaryofState(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSecretaryofState, value);
		}
	 
	 public void AddDateChecked(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(drpDateChecked, value);
		}
	 
	 public void AddTaxAssessed(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtTaxAssessed, value);
		}
	 
	 public void AddTaxYear(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtTaxYear, value);
		}
	 
	 public void AddTaxstatus(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtTaxstatus, value);
		}

	 
	 public void ClickonCheckedCheckbox() {
		 util.waitUntilElementDisplay(CheckedCheckbox);
			util.click(CheckedCheckbox);
			}
	
	 public void AddTaxDelinquentFrom(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtTaxDelinquentFrom, value);
		}
	
	 public void AddCourtIndexedDate(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtCourtIndexedDate, value);
		}
	
	 public void AddSchoolDistrict(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSchoolDistrict, value);
		}
	
	 public void AddTownship(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtTownship, value);
		}
	
	 public void AddAnnualTaxes(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtAnnualTaxes, value);
		}
	 public void AddLandValues(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtLandValues, value);
		}
	 
	 public void AddBuildingValues(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtBuildingValues, value);
		}
	 
	 public void AddLTCCompleted(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtLTCCompleted, value);
		}
	 
	 public void AddDateLTCCompleted(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDateLTCCompleted, value);
		}
	 	
	 public void AddLTCReviewedBy(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtLTCReviewedBy, value);
		}
	 
	 
	 public void AddDateLTCReviewed(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtDateLTCReviewed, value);
		}
	 
	 public void AddGrantor(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtGrantor, value);
		}
	 
	 public void AddSubdivisionPlat(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtSubdivisionPlat, value);
		}
	 
	 public void AddPage(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtPage, value);
		}
	 
	 public void AddLegalDescription(String value) {
			if (!commonFunction.checkNA(value))
				util.inputTextAndPressTab(txtLegalDescription, value);
		}
	 
	 public void ClickonSavebutton() {
			util.waitUntilElementDisplay(btnSave);
			util.click(btnSave);
			util.dummyWait(5);
			util.waitUntilElementDisplay(successmassage);
			Assert.assertTrue(util.isElementPresent(successmassage), "Changes saved successfully!");
	        util.dummyWait(2);
		}
	 
	 public void ClickonSavebuttonROW() {
			util.waitUntilElementDisplay(btnSaveROW);
			util.click(btnSaveROW);
			util.dummyWait(5);
			util.waitUntilElementDisplay(successmassageROW);
			Assert.assertTrue(util.isElementPresent(successmassageROW), "Changes saved successfully!");
	        util.dummyWait(2);

		}
	 
	 public void AddTitleTrackingRecord(Map<String, String> map, String testcaseName)
	 {
		 
		 try {
			   ClickonTitleTracking();
	    	   log("STEP 1: Record Grid should expands below ", Status.PASS);
	    	} catch (Exception e) {
			   log("STEP 1: record does not expand below  ", Status.FAIL);
			   throw new RuntimeException(" Failed in step 1 ");
		   }
		 
		 try {
			   AddTaxAccountNumber(map.get(Excel.TaxAccountNumber));
	   			log("STEP 2:  Entered value should display in the Tax Account Number field  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 2: Entered value does not display in  Tax Account Number field  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 2");
	   		}
		 
		 try {
			 AddGISIdentifier(map.get(Excel.GISIdentifier));
	   			log("STEP 3:  Entered value should display in the GIS Identifier field  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 3:  Entered value does not display in GIS Identifier field ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 3");
	   		}
		 
		 try {
			 AddSecretaryofState(map.get(Excel.SecretaryofState));
	   			log("STEP 4: Entered value should display in the Secretary of State:  File No field.     ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 4: Entered value does not display in Secretary of State:  File No field  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 4");
	   		}

		 try {
			    AddDateChecked(map.get(Excel.DateChecked));
	   			log("STEP 5:  User can select the  Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 5: User  cannot select  Date  from Date Picker ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 5");
	   		}
		 
		 try {
			 AddTaxAssessed(map.get(Excel.TaxAssessed));
	   			log("STEP 6:  Entered value should display in the Tax Assessed To field  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 6: Entered value does not display in Tax Assessed To field  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 6");
	   		}
		 
		 try {
			 AddTaxYear(map.get(Excel.TaxYear));
	   			log("STEP 7:  Entered value should display in the Tax Year field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 7: User not able to enter the Tax Year ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 7");
	   		}
		 
		 try {
			 AddTaxstatus(map.get(Excel.Taxstatus));
	   			log("STEP 8:  Selected value display in the Tax Status dd field  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 8: Added value does not display in the Tax Status field  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 8");
	   		}
		 
		 try {
			 ClickonCheckedCheckbox();
	   			log("STEP 9:  User can select Checked Checkbox ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 9: User cannot select Checked Checkbox", Status.FAIL);
	   			throw new RuntimeException("Failed in step 9");
	   		}
		 
		 try {
			 AddTaxDelinquentFrom(map.get(Excel.TaxDelinquentFrom));
	   			log("STEP 10:   Entered value should display in the Tax Delinquent From field ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 10: User can enter value in the Tax Delinquent From field ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 10");
	   		}
		 
		 try {
			 AddCourtIndexedDate(map.get(Excel.CourtIndexedDate));
	   			log("STEP 11:  User can select the Court Indexed Date     ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 11: User cannot select the Court Indexed Date ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 11 ");
	   		}
		 
		 try {
			 AddSchoolDistrict(map.get(Excel.SchoolDistrict));
	   			log("STEP 12:  Entered value should display in the School District field   ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 12: Entered value does not display in School District field  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 12");
	   		}
		 
		 try {
			   AddTownship(map.get(Excel.Township));
	   			log("STEP 13:  Entered value should display in the Township field  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 13:Entered value does not display in Township field  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 13");
	   		}
		 
		 
		 try {
			 AddAnnualTaxes(map.get(Excel.AnnualTaxes));
	   			log("STEP 14:   Entered value should display in the Annual Taxes field   ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 14: User cannot enter Annual Taxes ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 14");
	   		}
		 
		 try {
			 AddLandValues(map.get(Excel.LandValues));
	   			log("STEP 15:  Entered value should display in the Land Value field.     ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 15: User cannot enter Land Values ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 15");
	   		}
		 
		 try {
			 AddBuildingValues(map.get(Excel.BuildingValues));
	   			log("STEP 16:   Entered value should display in the Building Value field.   ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 16: User cannot enter Building Values ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 16");
	   		}
		 
		 try {
			 AddLTCCompleted(map.get(Excel.LTCCompleted));
	   			log("STEP 17: Entered value should display in the LTC Completed By field  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 17: Entered value does not display in LTC Completed By field  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 17");
	   		}
		 
		 try {
			 AddDateLTCCompleted(map.get(Excel.DateLTCCompleted));
	   			log("STEP 18:   User can select the LTC  Completed Date    ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 18:User  cannot select LTC  Completed Date", Status.FAIL);
	   			throw new RuntimeException("Failed in step 18");
	   		}
		 
		 try {
			 AddLTCReviewedBy(map.get(Excel.LTCReviewedBy));
	   			log("STEP 19:  Entered value should display in the LTC Reviewed By field.  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 19:  Entered value does not display in LTC Reviewed By field. ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 19");
	   		}
		 
		 try {
			 AddDateLTCReviewed(map.get(Excel.DateLTCReviewed));
	   			log("STEP 20:  User can select the LTC Reviewed Date  ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 20: User  cannot select LTC Reviewed Date", Status.FAIL);
	   			throw new RuntimeException("Failed in step 20");
	   		}
		 
		 try {
			 AddGrantor(map.get(Excel.Grantor));
			 GRANTOR=map.get(Excel.Grantor);
	   			log("STEP 21:  Entered value should display in the Grantor field.   ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 21:unable to enter value in the Grantor field.   ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 21");
	   		}
		 
		 try {
			 AddSubdivisionPlat(map.get(Excel.SubdivisionPlat));
	   			log("STEP 22: Entered value should display in the Subdivision Plat: Volume:  field   ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 22: Entered value does not display in Subdivision Plat: Volume:  field.   ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 22");
	   		}
		 
		 try {
			 AddPage(map.get(Excel.Page));
	   			log("STEP 23:  Entered value should display in the Page:  field.    ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 23: Entered value does not display in Page:  field.  ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 23");
	   		}
		 
		 try {
			 AddLegalDescription(map.get(Excel.LegalDescription));
	   			log("STEP 24:   Entered value should display in the Legal Description  field.    ", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 24: Entered value does not display in Legal Description  field.   ", Status.FAIL);
	   			throw new RuntimeException("Failed in step 24");
	   		}
		 
		 if(util.isElementPresent(btnSaveROW)) {
			 try {
				 ClickonSavebuttonROW();
		   			log("STEP 25: Title Tracking record successfully saved", Status.PASS);
		   		} catch (Exception e) {
		   			log("STEP 25:Title Tracking record does not saved", Status.FAIL);
		   			throw new RuntimeException("Failed in step 25");
		   		}
		 }else {
		 try {
			 ClickonSavebutton();
	   			log("STEP 25: Title Tracking record successfully saved", Status.PASS);
	   		} catch (Exception e) {
	   			log("STEP 25:Title Tracking record does not saved", Status.FAIL);
	   			throw new RuntimeException("Failed in step 25");
	   		}
		 }
	 }
	 
	 public void AddGrantorInParcelSummary(String testcaseName) throws InterruptedException {
		 if(util.isElementVisible(txtGrantorSummary)) {
		 try {
			 By txtGrantorSummaryValue = By.xpath("//td[contains(@id,'_Title_UC_radPanels_i0_i0_TITLEASSIGNMENT_TractSS_RadDockTractSS_C_tractInfo')]/..//strong[text()='Grantor:']/../..//*[contains(text(),'"+GRANTOR+"')]");
				Assert.assertTrue(util.isElementVisible(txtGrantorSummaryValue));
	   			log("STEP 26: User can see Grantor in Parcel Summary", Status.PASS);
	   		} catch (AssertionError e) {
	   			log("STEP 26: User cannot see Grantor in Parcel Summary", Status.FAIL);
	   		}
	 }
		 
	 }
	 
}
