package pages.ParcelDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class Valard_DropDownValidationPage extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public static String RecordNo, CrownLandRecordNo;
	SoftAssert sa= new SoftAssert();
	public Valard_DropDownValidationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	//Navigation
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	//add Parcel
	By drpParcelType = By.xpath("//input[contains(@id,'_Tract_Type_ID_radYALDropDownList_Input') and @type='text']");
    By privatePT = By.xpath("(//strong[text()='Private']/../..)[1]");
    By permitPT = By.xpath("(//strong[text()='Permit']/../..)[1]");
    By crownLandPT = By.xpath("(//strong[text()='Crown Land']/../..)[1]");
    By thirdPartyPT = By.xpath("(//strong[text()='Third Party']/../..)[1]");
    By txtParcelNo = By.xpath("//input[contains(@id,'TractType_TRACT_NUMBER') and @type='text']");
    By drpState = By.xpath("//input[contains(@id,'_TractType_STATE_Input') and @type='text']");
    By btnSave = By.xpath("//input[contains(@id,'_TractType_btnInternalSave')]");
   //Crown Land Class Custom Control Fields
    By drpCrownLandJurisdiction = By.xpath("//*[contains(text(),'Crown Land Jurisdiction')]/..//input[@type='text']");
    By drpApplicationType = By.xpath("//*[contains(text(),'Application/Request Type')]/..//input[@type='text']");
    By drpAgreementType = By.xpath("//*[contains(text(),'Agreement Type')]/..//input[@type='text']");
    By drpReleatedCrownLandAuthorization = By.xpath("//*[text()='Related Crown Land Authorization']/..//input[@type='text']");
    By closeDrpRCLADD = By.xpath("//*[text()='Related Crown Land Authorization']/..//td[contains(@class,'rcbArrow')]");
    By drpRelatedPrivateLandAuthorization = By.xpath("//*[text()='Related Private Land Authorization']/..//input[@type='text']");
    By closeDrpRPLADD = By.xpath("//*[text()='Related Private Land Authorization']/..//td[contains(@class,'rcbArrow')]");
    By drpRelatedThirdPartyAuthorization = By.xpath("//*[text()='Related Third Party Authorization']/..//input[@type='text']");
    By closeDrpRTPADD = By.xpath("//*[text()='Related Third Party Authorization']/..//td[contains(@class,'rcbArrow')]");
    By drpRelatedPermitAuthorization = By.xpath("//*[text()='Related Permit Authorization']/..//input[@type='text']");
    By closeDrpRPADD = By.xpath("//*[text()='Related Permit Authorization']/..//td[contains(@class,'rcbArrow')]");
    //Private Land Class Custom Control Fields
    By drpPrivateLandJurisdiction = By.xpath("//*[contains(text(),'Private Land Jurisdiction')]/..//input[@type='text']");
    By drpConfigIconPrivateLandJurisdiction = By.xpath("//*[contains(text(),'Private Land Jurisdiction')]/..//span[contains(@id,'_ManageComboID')]");
    //Permit Class Custom Control Fields
    By drpPermitJurisdiction = By.xpath("//*[contains(text(),'Permit Jurisdiction')]/..//input[@type='text']");
  //Third Party Class Custom Control Fields
    By drpThirdPartyJurisdiction = By.xpath("//*[contains(text(),'Third Party Jurisdiction')]/..//input[@type='text']");
    By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
    By drpConfigIconApplicationType = By.xpath("//*[contains(text(),'Request Type')]/..//span[contains(@id,'_ManageComboID')]");
    
    public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
		commonFunction.projectSelection();
		
		
	}
  
    public void TurnOnDesignCode() {
    	util.waitUntilElementDisplay(btnDesignMode);
    	util.click(btnDesignMode);
    	util.dummyWait(2);
    }
    
    public void selectParcelType(String value) {
    	
    			if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpParcelType, value);
	}
    
    public void addParcelNo(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtParcelNo, util.randomNumber());
	}
    
     public void selectState(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpState, value);
	}
    
     public void clickOnSave() {
    	util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.dummyWait(2);

	}
     
     By CheckOntarioStateValues = By.xpath("//*[contains(text(),'Ontario')]");
 	public static List<String> OntarioStateJurisdictionValues = new ArrayList<String>();
 	
     public List<String> ontarionStateJurisdictionDDValues() {
 		List<WebElement> lst = driver.findElements(CheckOntarioStateValues);
 		
 		for(WebElement e : lst){
 			OntarioStateJurisdictionValues.add(e.getText().replace("Ontario", ""));
 		}
 		return OntarioStateJurisdictionValues;
 	}
    
    public void verifyCustomDDValues(String testcaseName) {
    	navigateParcelInformation();
    	
    		try {
        		util.click(privatePT);
    			log("STEP 1: User can select Private Class from the parcel list", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 1:   User cannot select Private Class from the parcel list", Status.FAIL);
    			throw new RuntimeException("Failed in step 1");
    		}
    	
    		try {
    			TurnOnDesignCode();
    			log("STEP 2:  user can able to click on the design mode icon     ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 2: user not able to click on the design mode icon ", Status.FAIL);
    			throw new RuntimeException("Failed in step 2");
    		}
    		
    		try {
    			selectState("Ontario");
    			log("STEP 3:  user can select Ontario State for Private Class ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 3: user cannot select Ontario State for Private Class", Status.FAIL);
    			throw new RuntimeException("Failed in step 3");
    		}
    		
    	try {
    		clickOnSave();
			log("STEP 4: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:   User cannot click on Save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
    	
    	try {
			util.click(drpConfigIconPrivateLandJurisdiction);
			log("STEP 5:  user can click on DropDown Configuration Icon of Private Land Jurisdiction DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user cannot click on DropDown Configuration Icon of Private Land Jurisdiction DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
    	
    	try {
			util.switchToChildWindow();
			ontarionStateJurisdictionDDValues();
			log("STEP 6:  user can get Ontario State Jurisdiction values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: user cannot get Ontario State Jurisdiction values list", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
    	
    	try {
    		driver.close();
			util.switchToParentWindow();
			util.click(drpPrivateLandJurisdiction);
			for(String var: OntarioStateJurisdictionValues) {
				System.out.println(var);
				        By expectedValue = By.xpath("//li[text()='"+var.trim()+"']");
				        
						util.highlightElement(driver.findElement(By.xpath("(//li[text()='"+var.trim()+"'])[1]")));
						sa.assertTrue(util.isElementVisible(expectedValue, 5), "Value "+var+" is not visible in the DD");
						
				}
			log("STEP 7:  user can see all Ontario State Jurisdiction values list in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot see all Ontario State Jurisdiction values list in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
    	
    	try {
			util.click(drpConfigIconApplicationType);
			log("STEP 8:  user can click on DropDown Configuration Icon of Application/Request Type DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user cannot click on DropDown Configuration Icon of Application/Request Type DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
    	
    	try {
			util.switchToChildWindow();
			ontarionStateJurisdictionDDValues();
			log("STEP 9:  user can get Ontario State Jurisdiction values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot get Ontario State Jurisdiction values list", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
    }
    
}
