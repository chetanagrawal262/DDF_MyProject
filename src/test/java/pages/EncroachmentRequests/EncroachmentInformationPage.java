package pages.EncroachmentRequests;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class EncroachmentInformationPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public EncroachmentInformationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navEncroachmentInformation = By.xpath("//span[contains(text(),'Encroachment Information')]/..//span[@class='rpExpandHandle']");
	By radioBtnApproved = By.xpath("//input[contains(@id,'_rdLIIApproved') and @type='radio']");
	By txtDecisionDate = By.xpath("//input[contains(@id,'_dpLIIDecisionDate_dateInput') and @type='text']");
	By checkboxImpactFeeRequired = By.xpath("//input[contains(@id,'_chkLIIImpactFee') and @type='checkbox']");
	By txtEncroachmentDescription = By.xpath("//textarea[contains(@id,'_txtLIIEncroachDesc')]");
	By txtApprovedLocation = By.xpath("//textarea[contains(@id,'_txtLIIApprovLoc')]");
	By txtAssessedValueOfParcel = By.xpath("//input[contains(@id,'_txtLLIAssValPar') and @type='text']");
	By txtAcreageOfParcel = By.xpath("//input[contains(@id,'_txtLLIAssAcerPar') and @type='text']");
	By txtAssessedPerAcreageValueOfParcel = By.xpath("//input[contains(@id,'_txtLLIAssAcerValPar') and @type='text']");
	By txtImpactAreaSquareFit = By.xpath("//input[contains(@id,'_txtLIIImpactAreaSqFt') and @type='text']");
	By txtImpactAreaAverage = By.xpath("//input[contains(@id,'_txtLIIImpactAreaAvg') and @type='text']");
	By txtImpactAreaAverage2 = By.xpath("//input[contains(@id,'_txtLIIImpactAreaAvg2') and @type='text']");
	By txtParcelValue = By.xpath("//input[contains(@id,'_txtLIIParcelValAcre') and @type='text']");
	By txtImpactAreaValue = By.xpath("//input[contains(@id,'_txtLIIImpactAreaVal') and @type='text']");
	By txtPercentValue = By.xpath("//input[contains(@id,'_txtLIIPercentVal') and @type='text']");
    By txtCalculatedEncroachmentFee = By.xpath("//input[contains(@id,'_txtLIICalEncFee') and @type='text']");
	By txtAdjFee = By.xpath("//input[contains(@id,'_txtLIIAdjFee') and @type='text']");
	By txtTotalEncroachmentFee = By.xpath("//input[contains(@id,'_txtLIITtlEncFee') and @type='text']");
	By drpImpactLevel = By.xpath("//div[@id='ctl00_ConPHRightTop_LOHDetails_radPanels_i4_i0_RadDropDownImpactLevel']");
	By btnSave = By.xpath("//input[contains(@id,'_btnLLISave') and @type='image']");
    By SuccessMessage = By.xpath("//span[contains(@id,'_LIIErrorMsg') and text()='Changes saved successfully!']");
    
    public void ExpandEncroachmentInformation() {
    	util.waitUntilElementDisplay(navEncroachmentInformation);
    	util.click(navEncroachmentInformation);
    }
    
    public void selectApprovedRadioButton() {
        util.waitUntilElementDisplay(radioBtnApproved);
    	util.click(radioBtnApproved);
    }
    
    public void selectImpactFeeRequiredCheckBox() {
        util.waitUntilElementDisplay(checkboxImpactFeeRequired);
    	util.click(checkboxImpactFeeRequired);
    }
    
    public void AddEncroachmentDescription(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtEncroachmentDescription, value);
    }
    
    public void AddApprovedLocation(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtApprovedLocation, value);
    }
    
    public void AddAssessedValueOfParcel(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAssessedValueOfParcel, value);
    }
    
    public void AddAcreageOfParcel(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAcreageOfParcel, value);
    }
    
    public void AddImpactArea(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtImpactAreaSquareFit, value);
    }
    
    public void AddImpactAreaAverage2(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtImpactAreaAverage2, value);
    }
    
    public void AddParcelValue(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelValue, value);
    }
    
    public void AddPercentValue(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtPercentValue, value);
    }
    
    public void AddAdjFee(String value) {
    	if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAdjFee, value);
    }
    
    public void SelectImpactLevel(String value) {
    	util.click(drpImpactLevel);
    	By selectValue = By.xpath("//div[contains(@id,'_RadDropDownImpactLevel_DropDown')]//li[text()='"+value+"']");
    	util.click(selectValue);
    }
    
    public void ClickonSaveButton() {
    	util.waitUntilElementDisplay(btnSave);
    	util.click(btnSave);
    }
    
	public void AddEncroachmentInformation(Map<String, String> map, String testcaseName) {

		try {
			ExpandEncroachmentInformation();
			log("STEP 1: User can expand Encroachement Information ", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot expand Encroachement Information", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}

		try {
			selectApprovedRadioButton();
			log("STEP 2: User can select Approved Radio Button ", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot select Approved Radio Button", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}

		try {
			selectImpactFeeRequiredCheckBox();
			log("STEP 3: User can select Impact Fee Required Checkbox ", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot select Impact Fee Required Checkbox", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			AddEncroachmentDescription(map.get("EncroachmentDescription"));
			log("STEP 4: User can enter Encroachment Description ", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot enter Encroachment Description ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}

		try {
			AddApprovedLocation(map.get("ApprovedLocation"));
			log("STEP 5: User can enter Approved Location ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User cannot enter Approved Location ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			AddAssessedValueOfParcel(map.get("AssessedValueOfParcel"));
			log("STEP 6: User can enter Assessed Value Of Parcel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: User cannot enter Assessed Value Of Parcel ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}

		try {
			AddAcreageOfParcel(map.get("AcreageOfParcel"));
			log("STEP 7: User can enter Acreage Of Parcel ", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: User cannot enter Acreage Of Parcel ", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			AddImpactArea(map.get("ImpactArea"));
			log("STEP 8: User can enter Impact Area ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: User cannot enter Impact Area ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
		
		try {
			AddPercentValue(map.get("PercentValue"));
			log("STEP 9: User can enter Percent Value ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: User cannot enter Percent Value ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		try {
			AddAdjFee(map.get("AdjFee"));
			log("STEP 10: User can enter Adj. Fee ", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: User cannot enter Adj. Fee ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		
		try {
			SelectImpactLevel(map.get("ImpactLevel"));
			log("STEP 11: User can select Impact Level", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: User cannot select Impact Level ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}

		try {
			ClickonSaveButton();
			util.dummyWait(1);
			log("STEP 12: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: User cannot click on Save button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}

		try {
			Assert.assertTrue(util.isElementVisible(SuccessMessage));
			log("STEP 13: User can see Success Message", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 13: User cannot see Success Message", Status.FAIL);
		}

		try {
			String currentDate = util.getCurrentDateTime("M/d/yyyy");
			System.out.println("Current Date: " + currentDate);
			Assert.assertEquals(util.getAttributeValue(txtDecisionDate, "value"), currentDate);
			log("STEP 14: User can see auto generated Current Date in Decision Date field ", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 14: User cannot see auto generated Current Date in Decision Date field", Status.FAIL);
		}
		
		try {
			By assessedPerAcreageValueOfParcel = By.xpath("//input[contains(@id,'_txtLLIAssAcerValPar') and @type='text' and @value='$"+map.get("ParcelValuePerAcre")+"']");
			Assert.assertTrue(util.isElementVisible(assessedPerAcreageValueOfParcel));
			log("STEP 15: Assessed Per Acreage Value of Parcel calculated correctly", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 15: Assessed Per Acreage Value of Parcel calculated Incorrectly", Status.FAIL);
		}
		  
		try {
			By impactAreaAverage = By.xpath("(//input[contains(@id,'_txtLIIImpactAreaAvg') and @type='text' and @value='"+map.get("ImapctAreaAverage")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(impactAreaAverage));
			log("STEP 16: Impact Area Average calculated correctly", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 16: Impact Area Average calculated Incorrectly", Status.FAIL);
		}
		
		try {
			By impactAreaAverage2 = By.xpath("(//input[contains(@id,'_txtLIIImpactAreaAvg2') and @type='text' and @value='"+map.get("ImapctAreaAverage")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(impactAreaAverage2));
			log("STEP 17: Impact Area Average 2 value correctly displaying in the field", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 17: Impact Area Average 2 value is not displaying in the field", Status.FAIL);
		}
		
		try {
			By parcelValuePerAcre = By.xpath("(//input[contains(@id,'_txtLIIParcelValAcre') and @type='text' and @value='$"+map.get("ParcelValuePerAcre")+"'])[1]");
			Assert.assertTrue(util.isElementVisible(parcelValuePerAcre));
			log("STEP 18: Parcel Value / Acre correctly displaying in the field", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 18: Parcel Value / Acre is not displaying in the field", Status.FAIL);
		}
		
		try {
			By assessedPerAcreageValueOfParcel = By.xpath("//input[contains(@id,'_txtLIIImpactAreaVal') and @type='text' and @value='$"+map.get("ImapctAreaValue")+"']");
			Assert.assertTrue(util.isElementVisible(assessedPerAcreageValueOfParcel));
			log("STEP 19: Impact Area Value calculated correctly", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 19: Impact Area Value calculated Incorrectly", Status.FAIL);
		}
		
		try {
			By assessedPerAcreageValueOfParcel = By.xpath("//input[contains(@id,'_txtLIICalEncFee') and @type='text' and @value='$"+map.get("CalculatedEncroachmentFee")+"']");
			Assert.assertTrue(util.isElementVisible(assessedPerAcreageValueOfParcel));
			log("STEP 20: Calculated Encroachment Fee value is displayed correctly", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 20: Calculated Encroachment Fee value is displayed Incorrectly", Status.FAIL);
		}
		
		try {
			By assessedPerAcreageValueOfParcel = By.xpath("//input[contains(@id,'_txtLIITtlEncFee') and @type='text' and @value='$"+map.get("TotalEncroachmentFee")+"']");
			Assert.assertTrue(util.isElementVisible(assessedPerAcreageValueOfParcel));
			log("STEP 21: Total Encroachment Fee value is calculated correctly", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 21: Total Encroachment Fee value is calculated Incorrectly", Status.FAIL);
		}
    }
    
   
}
