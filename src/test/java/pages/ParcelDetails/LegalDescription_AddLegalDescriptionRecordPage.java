package pages.ParcelDetails;

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

import extentReports.ExtentTestManager;

public class LegalDescription_AddLegalDescriptionRecordPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;
    String ParcelNo; 
	
	public LegalDescription_AddLegalDescriptionRecordPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	 By txtParcelNo = By.xpath("(//input[contains(@id,'_TRACT_NUMBER')])[1]");
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')]");
	By navLegalDescription = By.xpath("//span[text()='Legal Description']");
	By btnAddRecord = By.xpath("(//img[contains(@id,'LEGALDESC_radYALGridControl')])[1]");
	By txtState = By.xpath("//input[contains(@id,'_EditLegalDescription2_STATE') and @type='text'] | //input[contains(@id,'EditFormControl_STATE') and @type='text']");
    By txtCountry = By.xpath("//input[contains(@id,'_EditLegalDescription2_County') and @type='text'] |  //input[contains(@id,'EditFormControl_County') and @type='text']");
    By txtQuterSection = By.xpath("//input[contains(@id,'_EditLegalDescription2_QSec') and @type='text'] | //input[contains(@id,'EditFormControl_QSec') and @type='text']");
    By txtSection = By.xpath("//input[contains(@id,'_EditLegalDescription2_Section') and @type='text'] | //input[contains(@id,'EditFormControl_Section') and @type='text']");
    By txtTownShip = By.xpath("//input[contains(@id,'_EditFormControl_EditLegalDescription2_Township') and @type='text'] | //input[contains(@id,'EditFormControl_Township') and @type='text']");
    By txtRange = By.xpath("//input[contains(@id,'_EditLegalDescription2_Range') and @type='text'] | //input[contains(@id,'EditFormControl_Range') and @type='text']");
    By txtSchoolDistrict = By.xpath("//input[contains(@id,'_EditLegalDescription2_Porcion') and @type='text'] | //input[contains(@id,'EditFormControl_Porcion') and @type='text']");
    By txtShare = By.xpath("//input[contains(@id,'_EditLegalDescription2_Share') and @type='text'] | //input[contains(@id,'EditFormControl_Share') and @type='text']");
    By txtLot = By.xpath("//input[contains(@id,'_EditLegalDescription2_Lot') and @type='text'] | //input[contains(@id,'EditFormControl_Lot') and @type='text']");
    By txtBlock = By.xpath("//input[contains(@id,'_EditLegalDescription2_Block') and @type='text'] | //input[contains(@id,'EditFormControl_Block') and @type='text']");
    By txtSubdivision = By.xpath("//input[contains(@id,'_EditLegalDescription2_Subdivision') and @type='text'] | //input[contains(@id,'EditFormControl_Subdivision') and @type='text']");
    By txtCity = By.xpath("//input[contains(@id,'_EditLegalDescription2_City') and @type='text'] | //input[contains(@id,'EditFormControl_City') and @type='text']");
    By txtProperty = By.xpath("//input[contains(@id,'_EditLegalDescription2_PROPERTYNUMBER') and @type='text'] | //input[contains(@id,'EditFormControl_PROPERTYNUMBER') and @type='text']");
    By txtSurveyTr = By.xpath("//input[contains(@id,'_EditLegalDescription2_SurTrNo') and @type='text'] | //input[contains(@id,'EditFormControl_SurTrNo') and @type='text']");
    By txtAbstract = By.xpath("//input[contains(@id,'_EditLegalDescription2_Abstract') and @type='text'] | //input[contains(@id,'EditFormControl_Abstract') and @type='text']");
    By txtSurvey = By.xpath("//textarea[contains(@id,'_EditLegalDescription2_Survey')] | //textarea[contains(@id,'_EditFormControl_Survey')]");
    By txtAcres =  By.xpath("//input[contains(@id,'_EditLegalDescription2_Acres') and @type='text'] | //input[contains(@id,'_EditFormControl_Acres') and @type='text']");
    By txtTaxAccount = By.xpath("//textarea[contains(@id,'_EditLegalDescription2_TAX_ACCOUNTNUMBER')] | //textarea[contains(@id,'_EditFormControl_TAX_ACCOUNTNUMBER')]");
    By btnInsert = By.xpath("//input[contains(@id,'_EditFormControl_btnInsert') and @type='submit']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    By btnFullLegal = By.xpath("//span[contains(text(),'Full Legal')]");
    By txtDescription = 
    		By.xpath("//iframe[contains(@id,'LEGALDESC_radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_editor_LongLegal_contentIframe')]");
    By btnCancel = By.xpath("//input[contains(@id,'_EditFormControl_btnCancel') and @type='submit']");
    
    //For ROW
    
    By btnAddRecordROW = By.xpath("//img[contains(@id,'LEGALDESC_radYALGridControl')] | //img[contains(@id,'gridCustomLegalDesc_radYALGridControl')]");
    By txtQuterSectionROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[2] | (//input[contains(@id,'_QSec') and @type='text'])");
    By txtSectionROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[3] | (//input[contains(@id,'_Section') and @type='text'])");
    By txtTownShipROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[4] |   (//input[contains(@id,'_Township') and @type='text'])[2] |  (//input[contains(@id,'_TTC') and @type='text'])[1]");
    By txtRangeROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[5] | (//input[contains(@id,'_Range') and @type='text'])");
    By txtDistrictROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[1]");
    By txtShareROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[9] | //input[contains(@id,'_EditLegalDescription2_Share') and @type='text']");
    By txtLotROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[10] | //input[contains(@id,'_EditLegalDescription2_Lot') and @type='text'] | //input[contains(@id,'_EditFormControl_Lot') and @type='text']");
    By txtBlockROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[11] | //input[contains(@id,'_EditLegalDescription2_Block') and @type='text'] | //input[contains(@id,'_EditFormControl_Block') and @type='text']");
    By txtSubdivisionROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[12] | //input[contains(@id,'_EditLegalDescription2_Subdivision') and @type='text']");
    By txtCityROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[13] | //input[contains(@id,'_EditLegalDescription2_City') and @type='text'] | //input[contains(@id,'_EditFormControl_City') and @type='text']");
    By txtAbstractROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[7] | //input[contains(@id,'_EditLegalDescription2_Abstract') and @type='text']");
    By txtSurveyROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[6] | //textarea[contains(@id,'_EditLegalDescription2_Survey')]");
    By txtPorcionROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[8] | (//input[contains(@id,'_Porcion') and @type='text'])");
    By txtCountyROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[14] | (//input[contains(@id,'_PARISH') and @type='text'])");
    By txtParcelNumber = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[15] | (//textarea[contains(@id,'_EditFormControl_TAX_ACCOUNTNUMBER')])[1]");
    By CheckboxDefaultLegal = By.xpath("//input[contains(@id,'_chkDefaultLegal') and @type ='checkbox']");
    By txtDescriptionROW =
    		By.xpath("//iframe[contains(@id,'radYALGridControl_ctl00_ctl02_ctl03_EditFormControl_editor_LongLegal_contentIframe')]");
    
    By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
    By txtParcelFilter = By.xpath("(//input[contains(@id,'FilterTextBox')])[1]");
    By FilterIcon = By.xpath("(//input[contains(@id,'Filter_Nova Parcel ID') and @title='Filter'])[1] | //input[contains(@id,'Filter_Parcel #') and @title='Filter'] | (//input[contains(@id,'Filter_Orsted PIN') and @title='Filter'])[1] | (//input[contains(@id,'Filter_Tract #') and @title='Filter'])[1] |  (//input[contains(@id,'Filter_Parcel(Map/Lot) #') and @title='Filter'])[1]");
    By AddFilter =By.xpath("//*[text()='EqualTo']");
    By AddFilterDOM =By.xpath("//*[text()='Contains']");
    By SerchedRecordGrid =By.xpath("//*[contains(@id,'_TractList_RadGridTracts_ctl00__0')]");
    By DuplicateRecord =By.xpath("//*[contains(@id,'_TractList_RadGridTracts_ctl00__1')]");
    By NoFilter = By.xpath("//*[text()='NoFilter']");
   
    public void navigateToLegalDescription() {
  		util.waitUntilElementDisplay(navParcel);
  		util.click(navParcel);
  		util.waitUntilElementDisplay(navParcelInfo);
  		util.click(navParcelInfo);
  		util.waitUntilElementDisplay(navParcelInformation);
  		util.click(navParcelInformation);
  		commonFunction.projectSelection();
  		util.waitUntilElementDisplay(firstParcel);
		util.click(firstParcel);
		util.dummyWait(1);
  		util.waitUntilElementDisplay(navLegalDescription);
		util.click(navLegalDescription);
    }
    
    public void AddnewRecordALT() {
		util.waitUntilElementDisplay(btnAddRecord);
		util.click(btnAddRecord);
		
    }
    
    public void AddnewRecordROW() {
		util.waitUntilElementDisplay(btnAddRecordROW);
		util.click(btnAddRecordROW);
		
    }
    
    public void AddState(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtState, value);
		
    }
    
    public void AddCountry(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCountry, value);
		
    }
    
    
    public void AddQuterSection(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtQuterSection, value);
		
    }
    
    public void AddQuterSectionROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtQuterSectionROW, value);
		
    }

    public void AddSection(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSection, value);
		
    }
    
    public void AddSectionROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSectionROW, value);
		
    }
    
    
    public void AddTownShip(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTownShip, value);
		
    }
    
    public void AddTownShipROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTownShipROW, value);
		
    }
    
    public void AddRange(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtRange, value);
		
    }
    
    public void AddRangeROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtRangeROW, value);
		
    }
    
    public void AddSchoolDistrict(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSchoolDistrict, value);
		
    }
    
    public void AddSchoolDistrictROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDistrictROW, value);
		
    }
    
    public void AddShare(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtShare, value);
		
    }
    
    public void AddShareROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtShareROW, value);
		
    }
    
    public void AddLot(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLot, value);
		
    }
    
    public void AddLotROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtLotROW, value);
		
    }
    
    public void AddBlock(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtBlock, value);
		
    }
    
    public void AddBlockROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtBlockROW, value);
		
    }
    
    public void AddSubdivision(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSubdivision, value);
		
    }
    
    public void AddSubdivisionROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSubdivisionROW, value);
		
    }
    
    public void AddCity(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCity, value);
		
    }
    
    public void AddCityROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCityROW, value);
		
    }
    
    public void AddProperty(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtProperty, value);
		
    }
    
    public void AddSurveyTr(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSurveyTr, value);
		
    }
    
    public void AddAbstract(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAbstract, value);
		
    }
    
    public void AddAbstractROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAbstractROW, value);
		
    }
    
    public void AddSurvey(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSurvey, value);
		
    }
    
    public void AddSurveyROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtSurveyROW, value);
		
    }
    
    public void AddAcres(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAcres, value);
		
    }
    
    public void AddTaxAccount(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTaxAccount, value);
		
    }
    
    public void AddPorcionROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPorcionROW, value);
		
    }
    
    public void AddCountyROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCountyROW, value);
		
    }
    
    public void AddParcelNumberROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelNumber, value);
	
    }
    
    public void ClickOnDefaultLegalCheckbox() {
    	util.waitUntilElementDisplay(CheckboxDefaultLegal);
    	util.click(CheckboxDefaultLegal);
    }
    
    public void ClickOnInsert() {
    	util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");
		util.dummyWait(3);
		
    }
    
    public void ClickOnFullLegal() {
    	util.waitUntilElementDisplay(btnFullLegal);
		util.click(btnFullLegal);
		
    }
    
    public void AddDescription(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescription, value);
		
    }

    public void AddDescriptionROW(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDescriptionROW, value);
		
    }
    
    public void ClickOnInsertButton() {
    	util.waitUntilElementDisplay(btnInsert);
		util.click(btnInsert);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Changes saved successfully!");

		
    }
    
    
    public void ClickOnCancle() {
    	util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
		util.dummyWait(4);
    }
    

    
    public void GetAddedParcelNo() {
        ParcelNo = util.getAttributeValue(txtParcelNo, "value");
     //   ParcelNo = util.getText(txtParcelNo);
        log("Added Parcel number is: " + ParcelNo);
		util.dummyWait(1);
//		 By ParcelOnGrid=By.xpath("(//td[text()='"+ParcelNo+"']/parent::tr)[1]");
//		util.click(ParcelOnGrid);
    }
    
    public void ParcelFilter(String value) {
    	util.inputTextAndPressTab(txtParcelFilter, value);
    	util.waitFor(200);
		
  }
    
    public void AddFilter() {
    	util.waitUntilElementDisplay(FilterIcon);
    	util.click(FilterIcon);
    	if(environment.contains("DOM")) {
    		util.waitUntilElementDisplay(AddFilterDOM);
        	util.click(AddFilterDOM);
    	}else {
    	util.waitUntilElementDisplay(AddFilter);
    	util.click(AddFilter);
    	}
    	util.dummyWait(3);
    }
    
    public void ClickOnNoFilter() {
    	util.waitUntilElementDisplay(FilterIcon);
    	util.click(FilterIcon);
    	util.waitUntilElementDisplay(NoFilter);
    	util.click(NoFilter);
    	util.dummyWait(1);
    	
    }
    
    
    public void AddLegalDescriptionRecord(Map<String, String> map, String testcaseName) 
    { 
		if (testcaseName.contains("DOT")) {
			log("Add a Legal Description Record not applicable for DOT ", Status.SKIP);
		}
		else {
    	
			util.dummyWait(5);
    	 try {
    		 navigateToLegalDescription();
    		 
   			log("STEP 1: user can expand Legal Description panel", Status.PASS);
   		} catch (Exception e) {
   			log("STEP 1: User cannot expand Legal Description panel ", Status.FAIL);
   			throw new RuntimeException("Failed in step 1");
   		}
    	 if(!testcaseName.contains("ORION")) {
    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")|| testcaseName.contains("ATWELL"))
   	 {  
   	 try {
   		  AddnewRecordALT();
			log("STEP 2:user should  be able to click add new record button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User does not able to click Add new record button ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
   	util.dummyWait(5);   	
   	try {
   		AddState(map.get(Excel.State));
			log("STEP 3: Entered value should displays in the state field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:  unable to enter value in the  state field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
   	
   	try {
   		AddCountry(map.get(Excel.County));
			log("STEP 4:  Entered value should displays in the County field.", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: unable to enter value in the  county field ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
   	
   	try {
   		AddQuterSection(map.get(Excel.QuterSection));
			log("STEP 5: Entered value should displays in the quarter section ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: Entered value does not display in the quarter section ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
   	
   	try {
   		AddSection(map.get(Excel.Section));
			log("STEP 6: Entered value should displays in the Section field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  unable to enter value in the  section field ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
   	
	try {
   		AddTownShip(map.get(Excel.TownShip));
			log("STEP 7: Entered value should displays in the TownShip field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  unable to enter value in the  TownShip field ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
   	
	try {
		AddRange(map.get(Excel.Range));
			log("STEP 8: Entered value should displays in the Range field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  unable to enter value in the  Range field ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
	
	try {
		AddSchoolDistrict(map.get(Excel.SchoolDistrict));
			log("STEP 9: Entered value should displays in the SchoolDistrict field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:  unable to enter value in the  SchoolDistrict field ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
   	  

	try {
		AddShare(map.get(Excel.Share));
			log("STEP 10: Entered value should displays in the Share field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:   unable to enter value in the  Share field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
	
	try {
		AddLot(map.get(Excel.Lot));
			log("STEP 11: Entered value should displays in the Lot field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  unable to enter value in the  Lot field ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
	
	try {
		AddBlock(map.get(Excel.Block));
			log("STEP 12: Entered value should displays in the Block field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  unable to enter value in the  Block field ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
	
	try {
		AddSubdivision(map.get(Excel.Subdivision));
			log("STEP 13: Entered value should displays in the Subdivision field ", Status.PASS);
		} catch (Exception e) { 
			log("STEP 13:  unable to enter value in the  Subdivision field ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
	
	try {
		AddCity(map.get(Excel.City));
			log("STEP 14: Entered value should displays in the City field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: unable to enter value in the  City field ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
	
	try {
		AddProperty(map.get(Excel.Property));
			log("STEP 15: Entered value should displays in the Property field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:   unable to enter value in the  Property field ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
	
	try {
		AddSurveyTr(map.get(Excel.SurveyTr));
			log("STEP 16: Entered value should displays in the SurveyTr field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:   unable to enter value in the  SurveyTr field ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
	
	try {
		AddAbstract(map.get(Excel.Abstract));
			log("STEP 17: Entered value should displays in the Abstract field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17:  unable to enter value in the  Abstract field ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
	
	try {
		AddSurvey(map.get(Excel.Survey));
			log("STEP 18:  Entered value should displays in the Survey field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18:  unable to enter value in the  Survey field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
	
	try {
		AddAcres(map.get(Excel.Acres));
			log("STEP 19: Entered value should displays in the Acres field", Status.PASS);
		} catch (Exception e) {
			log("STEP 19:  unable to enter value in the  Acres field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
	
	try {
		AddTaxAccount(map.get(Excel.TaxAccountNumber));
			log("STEP 20: Entered value should displays in the TaxAccountNumber field", Status.PASS);
		} catch (Exception e) {
			log("STEP 20:  unable to enter value in the  TaxAccountNumber field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
	util.dummyWait(2);
	try {
		ClickOnInsert();
			log("STEP 21: Changes saved successfully!  message should be display above the add new button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: Save successful message does not display above the add new button ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
	
	
	try {
		
		AddnewRecordALT();
			log("STEP 22: user should  be able to click add new record button   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: User does not able to click Add new record button ", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
	if(util.isElementPresent(btnFullLegal)){
	try {
		ClickOnFullLegal();
			log("STEP 23: Focus should be on Full Legal tab and grid should expands below with blank fields ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: Full legal tab not present ", Status.FAIL);
			throw new RuntimeException("Failed in step  23");
		}
	
	try {
		AddDescription(map.get(Excel.Description));
			log("STEP 24: Entered value should displays in the Description fields.    ", Status.PASS);
		} catch (Exception e) {
			log("STEP 24:  Entered value does not display in the field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
	}else {
		ExtentTestManager.info("Full Legal Description Tab Not Available");
	}
	try {
		ClickOnInsertButton();
			log("STEP 25: Changes saved successfully!  message should be display above the add new button  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: Save successful message does not display above the add new button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
	
	
	try {
		AddnewRecordALT();
		util.dummyWait(3);
	
		ClickOnCancle();
			log("STEP 26: Cancel button is clicked   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 26:  cancel button is not clicked. ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
	
	
   	 }	
    	else {
    	
    		 try {
    	   		  AddnewRecordROW();
    				log("STEP 2: user should  be able to click add new record button ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 2: User does not able to click Add new record button ", Status.FAIL);
    				throw new RuntimeException("Failed in step 2");
    			}
    	   	util.dummyWait(10);
    	   	
    	   	if(util.isElementPresent(txtState)) {
    	   	try {
    	   		AddState(map.get(Excel.State));
    				log("STEP 2: Entered value should displays in the state field. ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 2:  unable to enter value in the  state field. ", Status.FAIL);
    				throw new RuntimeException("Failed in step 2");
    			}
    	   	
    	   	try {
    	   		AddCountry(map.get(Excel.County));
    				log("STEP 3:  Entered value should displays in the County field.", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 3: unable to enter value in the  county field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 3");
    			}
    	   	}
    	   	
    	   	try {
    	   		AddQuterSectionROW(map.get(Excel.QuterSection));
    				log("STEP 4: Entered value should displays in the QuterSection field. ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 4:  unable to enter value in the  QuterSection field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 4");
    			}
    	   	
    	   	try {
    	   		AddSectionROW(map.get(Excel.Section));
    				log("STEP 5: Entered value should displays in the Section field. ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 5:  unable to enter value in the  Section field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 5");
    			}
    	   	
    	   	try {
    	   		AddTownShipROW(map.get(Excel.TownShip));
    				log("STEP 6: Entered value should displays in the TownShip field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 6:  unable to enter value in the  TownShip field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 6");
    			}
    	   	
    		try {
    			AddRangeROW(map.get(Excel.Range));
    				log("STEP 7: Entered value should displays in the Range field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 7:  unable to enter value in the  Range field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 7");
    			}
    		
    		if(!environment.contains("WOLFMIDSTREAM")) {
    		try {
    			AddSchoolDistrictROW(map.get(Excel.SchoolDistrict));
    				log("STEP 8: Entered value should displays in the SchoolDistrict field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 8:  unable to enter value in the  SchoolDistrict field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 8");
    			}
    	   	  

    		try {
    			AddShareROW(map.get(Excel.Share));
    				log("STEP 9: Entered value should displays in the Share field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 9:   unable to enter value in the  Share field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 9");
    			}
    		}
    		
    		try {
    			AddLotROW(map.get(Excel.Lot));
    				log("STEP 10: Entered value should displays in the Lot field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 10:  unable to enter value in the  Lot field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 10");
    			}
    		
    		try {
    			AddBlockROW(map.get(Excel.Block));
    				log("STEP 11: Entered value should displays in the Block field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 11:  unable to enter value in the  Block field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 11");
    			}
    		
    		if(!environment.contains("WOLFMIDSTREAM")) {
    		try {
    			AddSubdivisionROW(map.get(Excel.Subdivision));
    				log("STEP 12: Entered value should displays in the Subdivision field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 12:  unable to enter value in the  Subdivision field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 12");
    			}
    		}
    		
    		try {
    			AddCityROW(map.get(Excel.City));
    				log("STEP 13: Entered value should displays in the City field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 13: unable to enter value in the  City field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 13");
    			}
    		
    		if(!environment.contains("WOLFMIDSTREAM")) {
    		try {
    			AddAbstractROW(map.get(Excel.Abstract));
    				log("STEP 14: Entered value should displays in the Abstract field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 14:  unable to enter value in the  Abstract field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 14");
    			}
    		
    		try {
    			AddSurveyROW(map.get(Excel.Survey));
    				log("STEP 15:  Entered value should displays in the Survey field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 15:  unable to enter value in the  Survey field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 15");
    			}
    		}
    		
    		try {
    			AddPorcionROW(map.get(Excel.Porcion));
    				log("STEP 16:  Entered value should displays in the Porcion field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 16:  unable to enter value in the  Porcion field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 16");
    			}
    		
    		try {
    			AddCountyROW(map.get(Excel.County));
    				log("STEP 17:  Entered value should displays in the County field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 17:  unable to enter value in the  County field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 17");
    			}
    		
    		try {
    			AddParcelNumberROW(map.get(Excel.ParcelNumber));
    				log("STEP 18:  Entered value should displays in the ParcelNumber field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 18:  unable to enter value in the  ParcelNumber field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 18");
    			}
    		
    		
    		if(util.isElementVisible(CheckboxDefaultLegal)) {
    			ClickOnDefaultLegalCheckbox();
    				log("STEP 19: User can check/uncheck checkbox. ", Status.PASS);
    			} else {
    				log("STEP 19: User can not  check/uncheck checkbox.", Status.FAIL);
    				throw new RuntimeException("Failed in step 19");
    			}
    		
    		util.dummyWait(2);
    		try {
    			ClickOnInsert();
    				log("STEP 20: Changes saved successfully!  message should be display above the add new button  ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 20: Save successful message does not display above the add new button ", Status.FAIL);
    				throw new RuntimeException("Failed in step 20");
    			}
    		
    		if(!environment.contains("WOLFMIDSTREAM")) {
    		try {
    			
    			AddnewRecordROW();
    				log("STEP 21: user should  be able to click add new record button   ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 21: User does not able to click Add new record button ", Status.FAIL);
    				throw new RuntimeException("Failed in step 21");
    			}
    		
    		try {
    			ClickOnFullLegal();
    				log("STEP 22: Focus should be on Full Legal tab and grid should expands below with blank fields ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 22: grid does not expands to ad new record ", Status.FAIL);
    				throw new RuntimeException("Failed in step  22");
    			}
    		
    		try {
    			AddDescriptionROW(map.get(Excel.Description));
    				log("STEP 23: Entered value should displays in the Description fields.    ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 23:  Entered value does not display in the field. ", Status.FAIL);
    				throw new RuntimeException("Failed in step 23");
    			}
    		
    		try {
    			ClickOnInsert();
    				log("STEP 24: Changes saved successfully!  message should be display above the add new button  ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 24: Save successful message does not display above the add new button  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 24");
    			}
    		
			} else {
				ExtentTestManager.info("Full Legal Description Tab Not Available");
			}
    		try {
    			AddnewRecordROW();
    			util.dummyWait(3);
    			ClickOnCancle();
    				log("STEP 25: Cancel button is clicked   ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 25:  cancel button is not clicked. ", Status.FAIL);
    				throw new RuntimeException("Failed in step 25");
    			}

    	}
    	
    	try {
    		   GetAddedParcelNo();
				log("STEP 26: User can click on the First parcel ", Status.PASS);
			} catch (Exception e) {
				log("STEP 26:  User cannot click on the First parcel  ", Status.FAIL);
				throw new RuntimeException("Failed in step 26");
			}
    	
    	try {
 		       ParcelFilter(ParcelNo);
				log("STEP 27: User can Enter parcel Number in the Parcel# filter  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 27:  User cannot Enter parcel Number in the Parcel# filter  ", Status.FAIL);
				throw new RuntimeException("Failed in step 27");
			}
    	try {
		       AddFilter();
				log("STEP 28: User can Search the parcel by applying 'Equal To' filter  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 28:  User cannot Search the parcel by applying 'Equal To' filter  ", Status.FAIL);
				throw new RuntimeException("Failed in step 28");
			}
    	try {
		       Assert.assertTrue(util.isElementVisible(SerchedRecordGrid)," User cannot see Search Parcel Record in the Tract List");
				log("STEP 29: User can able to see Filterd record on grid ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 29: User cannot able to see Filterd record on grid ", Status.FAIL);
			}
    	try {
		       Assert.assertFalse(util.isElementVisible(DuplicateRecord)," User can see Duplicate Record on grid ");
				log("STEP 30: User cannot see Duplicate Record on grid  ", Status.PASS);
			} catch (AssertionError e) {
				log("STEP 30: User can see Duplicate Record on grid ", Status.FAIL);
			}
    	try {
    		ClickOnNoFilter();
				log("STEP 31: User can Click on 'Nofilter' option ", Status.PASS);
			} catch (Exception e) {
				log("STEP 31:  User cannot Click on 'Nofilter' option  ", Status.FAIL);
				throw new RuntimeException("Failed in step 31");
			}
    	
    }else {
    	log("Add Legal Description TC is not applicable for this client ", Status.SKIP);
    }
		}
	 }
}
