package pages.ParcelDetails;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class LegalDescription_EditLegalDescriptionRecordPage extends BasePage {

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public LegalDescription_EditLegalDescriptionRecordPage (WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navLegalDescription = By.xpath("//span[text()='Legal Description']");
	By btnEditAlt = By.xpath("//input[contains(@id,'_LEGALDESC_radYALGridControl_ctl00_ctl04_EditButton') and @type='image']");
	By btnEditRow = By.xpath("//input[contains(@id,'LEGALDESC_radYALGridControl_ctl00_ctl04_EditButton')] | //input[contains(@id,'gridCustomLegalDesc_radYALGridControl_ctl00_ctl04_EditButton')]");
	By txtState = By.xpath("//input[contains(@id,'_EditLegalDescription2_STATE') and @type='text'] | //input[contains(@id,'EditFormControl_STATE') and @type='text']");
    By txtCounty = By.xpath("//input[contains(@id,'_EditLegalDescription2_County') and @type='text'] |  //input[contains(@id,'EditFormControl_County') and @type='text']");
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
   
    By btnUpdate = By.xpath("//input[contains(@id,'_EditFormControl_btnUpdate') and @type='submit']");
    By changesSavedSuccessfully = By.xpath("//span[text()='Changes saved successfully!']");
    By btnCancel = By.xpath("//input[contains(@id,'_EditFormControl_btnCancel') and @type='submit']");
    
    By txtQuterSectionROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[2] | (//input[contains(@id,'_QSec') and @type='text'])");
    By txtSectionROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[3] | (//input[contains(@id,'_Section') and @type='text'])");
    By txtTownShipROW = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[4] | (//input[contains(@id,'_Township') and @type='text'])[2] |  (//input[contains(@id,'_EditFormControl_TTC') and @type='text'])[1]");
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
    By txtParcelNumber = By.xpath("(//input[contains(@id,'_rtbFieldValue') and @type='text'])[15] | //textarea[contains(@id,'_EditFormControl_TAX_ACCOUNTNUMBER')]");
	By checkboxDefaultLegal= By.xpath("//input[contains(@id,'_chkDefaultLegal') and @type ='checkbox']");
    
    public void ClickOnEditAlt() {
    	if(!util.isElementVisible(btnEditAlt)) {
    		util.click(navLegalDescription);
    	}
    	util.waitUntilElementDisplay(btnEditAlt);
		util.click(btnEditAlt);
		util.dummyWait(5);
		
    }
    
    public void ClickOnEditROW() {
    	if(!util.isElementVisible(btnEditRow)) {
    		util.click(navLegalDescription);
    	}
    	util.waitUntilElementDisplay(btnEditRow);
		util.click(btnEditRow);
		
    }
    
    public void AddState(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtState, value);
		
    }
    
    public void AddCounty(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtCounty, value);
		
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
    
    public void AddTaxAccount(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtTaxAccount, value);
		
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
    	//util.click(checkboxDefaultLegal);
		
    }
    
    public void ClickOnUpdate() {
    	util.waitUntilElementDisplay(btnUpdate);
		util.click(btnUpdate);
		util.waitUntilElementDisplay(changesSavedSuccessfully);
		Assert.assertTrue(util.isElementPresent(changesSavedSuccessfully), "Verify changes saved successfully!");

		
    }
    
    By DefaultLegal = By.xpath("//input[contains(@id,'_chkDefaultLegal') and @type='checkbox']");
    public void ClickonDefaultLegalCheckbox(){
    	util.waitUntilElementDisplay(DefaultLegal);
    	util.click(DefaultLegal);
    }
    
    
    public void ClickOnCancleAlt() {
    	util.waitUntilElementDisplay(btnEditAlt);
		util.click(btnEditAlt);
    	util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
		util.dummyWait(3);

    }
    
    public void ClickOnCancleRow() {
    	util.waitUntilElementDisplay(btnEditRow);
		util.click(btnEditRow);
    	util.waitUntilElementDisplay(btnCancel);
		util.click(btnCancel);
		util.dummyWait(3);
    }
    
    public void EditLegalDescriptionRecord(Map<String, String> map, String testcaseName)  {
    	if (testcaseName.contains("DOT")) {
			log("Edit a Legal Description Record not applicable for DOT ", Status.SKIP);
		}
		else {	
			util.dummyWait(10);
    	if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL"))
    	{
    		
   	 try {
   		ClickOnEditAlt();
			log("STEP 1: record should expands below   ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: record does not expand below ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
   	
   	try {
   		AddState(map.get(Excel.State));
			log("STEP 2: Entered value should displays in the state field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:  unable to enter value in the  state field. ", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
   	
   	try {
   		AddCounty(map.get(Excel.County));
			log("STEP 3:  Entered value should displays in the County field.", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: unable to enter value in the  County field ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
   	
   	try {
   		AddQuterSection(map.get(Excel.QuterSection));
			log("STEP 4: Entered value should displays in the QuterSection field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:  unable to enter value in the  QuterSection field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
   	
   	try {
   		AddSection(map.get(Excel.Section));
			log("STEP 5: Entered value should displays in the Section field. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:  unable to enter value in the  Section field ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
   	
   	try {
   		AddTownShip(map.get(Excel.TownShip));
			log("STEP 6: Entered value should displays in the TownShip field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:  unable to enter value in the  TownShip field ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
   	
	try {
		AddRange(map.get(Excel.Range));
			log("STEP 7: Entered value should displays in the Range field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7:  unable to enter value in the  Range field ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
	
	try {
		AddSchoolDistrict(map.get(Excel.SchoolDistrict));
			log("STEP 8: Entered value should displays in the SchoolDistrict field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:  unable to enter value in the  SchoolDistrict field ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
   	  

	try {
		AddShare(map.get(Excel.Share));
			log("STEP 9: Entered value should displays in the Share field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9:   unable to enter value in the  Share field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
	
	try {
		AddLot(map.get(Excel.Lot));
			log("STEP 10: Entered value should displays in the Lot field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:  unable to enter value in the  Lot field ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
	
	try {
		AddBlock(map.get(Excel.Block));
			log("STEP 11: Entered value should displays in the Block field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11:  unable to enter value in the  Block field ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
	
	
	try {
		AddSubdivision(map.get(Excel.Subdivision));
			log("STEP 12: Entered value should displays in the Subdivision field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12:  unable to enter value in the  Subdivision field ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
	
	try {
		AddCity(map.get(Excel.City));
			log("STEP 13: Entered value should displays in the City field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: unable to enter value in the  City field ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
	
	try {
		AddProperty(map.get(Excel.Property));
			log("STEP 14: Entered value should displays in the Property field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14:   unable to enter value in the  Property field ", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
	
	try {
		AddSurveyTr(map.get(Excel.SurveyTr));
			log("STEP 15: Entered value should displays in the SurveyTr field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15:   unable to enter value in the  SurveyTr field ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
	
	try {
		AddAbstract(map.get(Excel.Abstract));
			log("STEP 16: Entered value should displays in the Abstract field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:  unable to enter value in the  Abstract field ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
	
	try {
		AddSurvey(map.get(Excel.Survey));
			log("STEP 17:  Entered value should displays in the Survey field ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17:  unable to enter value in the  Survey field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
	
	try {
		AddAcres(map.get(Excel.Acres));
			log("STEP 18: Entered value should displays in the Acres field", Status.PASS);
		} catch (Exception e) {
			log("STEP 18:  unable to enter value in the  Acres field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
	
	try {
		AddTaxAccount(map.get(Excel.TaxAccountNumber));
			log("STEP 19: Entered value should displays in the TaxAccountNumber field", Status.PASS);
		} catch (Exception e) {
			log("STEP 19:  unable to enter value in the  TaxAccountNumber field  ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
	util.dummyWait(2);
	
	try {
		ClickOnUpdate();
			log("STEP 20: 'Message - 'Changes saved sucessfully' in green displays", Status.PASS);
		} catch (Exception e) {
			log("STEP 20:  Message- Changes saved sucessfully' does not display  ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
	util.dummyWait(5);
	try {
		ClickOnCancleAlt();
			log("STEP 21:  User can click on cancel button.", Status.PASS);
		} catch (Exception e) {
			log("STEP 21:  User cannot click on cancel button. ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
	
   	 }	
    	
    	else {
    		 try {
    			 ClickOnEditROW();
    				log("STEP 1:user should  be able to click add new record button  ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 1: User does not able to click Add new record button ", Status.FAIL);
    				throw new RuntimeException("Failed in step 1");
    			}
    	   	util.dummyWait(5);
    	   	try {
    	   		AddQuterSectionROW(map.get(Excel.QuterSection));
    				log("STEP 2: Entered value should displays in the QuterSection field. ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 2:  unable to enter value in the  QuterSection field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 2");
    			}
    	   	
    	   	try {
    	   		AddSectionROW(map.get(Excel.Section));
    				log("STEP 3: Entered value should displays in the Section field. ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 3:  unable to enter value in the  Section field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 3");
    			}
    	   	
    	   	if(!environment.contains("WOLFMIDSTREAM")) {
    	   	try {
    	   		AddTownShipROW(map.get(Excel.TownShip));
    				log("STEP 4: Entered value should displays in the TownShip field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 4:  unable to enter value in the  TownShip field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 4");
    			}
    	   	}
    	   	
    		try {
    			AddRangeROW(map.get(Excel.Range));
    				log("STEP 5: Entered value should displays in the Range field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 5:  unable to enter value in the  Range field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 5");
    			}
    		
    		if(!environment.contains("WOLFMIDSTREAM")) {
    		try {
    			AddSchoolDistrictROW(map.get(Excel.SchoolDistrict));
    				log("STEP 6: Entered value should displays in the SchoolDistrict field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 6:  unable to enter value in the  SchoolDistrict field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 6");
    			}
    	   	  

    		try {
    			AddShareROW(map.get(Excel.Share));
    				log("STEP 7: Entered value should displays in the Share field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 7:   unable to enter value in the  Share field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 7");
    			}
    		}
    		
    		try {
    			AddLotROW(map.get(Excel.Lot));
    				log("STEP 8: Entered value should displays in the Lot field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 8:  unable to enter value in the  Lot field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 8");
    			}
    		
    		try {
    			AddBlockROW(map.get(Excel.Block));
    				log("STEP 9: Entered value should displays in the Block field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 9:  unable to enter value in the  Block field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 9");
    			}
    		
    		if(!environment.contains("WOLFMIDSTREAM")) {
    		try {
    			AddSubdivisionROW(map.get(Excel.Subdivision));
    				log("STEP 10: Entered value should displays in the Subdivision field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 10:  unable to enter value in the  Subdivision field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 10");
    			}
    		}
    		
    		try {
    			AddCityROW(map.get(Excel.City));
    				log("STEP 11: Entered value should displays in the City field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 11: unable to enter value in the  City field ", Status.FAIL);
    				throw new RuntimeException("Failed in step 11");
    			}
    		
    		if(!environment.contains("WOLFMIDSTREAM")) {
    		try {
    			AddSurveyROW(map.get(Excel.Survey));
    				log("STEP 12:  Entered value should displays in the Survey field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 12:  unable to enter value in the  Survey field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 12");
    			}
    		}
    		
    		try {
    			AddPorcionROW(map.get(Excel.Porcion));
    				log("STEP 13:  Entered value should displays in the Porcion field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 13:  unable to enter value in the  Porcion field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 13");
    			}
    		
    		try {
    			AddCountyROW(map.get(Excel.County));
    				log("STEP 14:  Entered value should displays in the County field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 14:  unable to enter value in the  County field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 14");
    			}
    		
    		try {
    			AddParcelNumberROW(map.get(Excel.ParcelNumber));
    				log("STEP 15:  Entered value should displays in the ParcelNumber field ", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 15:  unable to enter value in the  ParcelNumber field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 15");
    			}
    		
    		
//    		try {
//    			ClickonDefaultLegalCheckbox();
//    				log("STEP 25:  User can check/uncheck checkbox ", Status.PASS);
//    			} catch (Exception e) {
//    				log("STEP 25:  User can not  check/uncheck checkbox. ", Status.FAIL);
//    				throw new RuntimeException("Failed in step 25");
//    			}
    		
    		util.dummyWait(2);

    		try {
    			ClickOnUpdate();
    				log("STEP 16: Entered value should displays in the state field", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 16:  unable to enter value in the  state field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 16");
    			}
    		util.dummyWait(5);
    		
    		try {
    			ClickOnCancleRow();
    				log("STEP 17: Entered value should displays in the state field", Status.PASS);
    			} catch (Exception e) {
    				log("STEP 17:  unable to enter value in the  state field  ", Status.FAIL);
    				throw new RuntimeException("Failed in step 17");
    			}
    		
    	   }
    		
    
       }
    }
}

