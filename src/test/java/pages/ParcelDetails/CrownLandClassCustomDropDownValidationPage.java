package pages.ParcelDetails;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class CrownLandClassCustomDropDownValidationPage extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public static String RecordNo, CrownLandRecordNo;
	SoftAssert sa= new SoftAssert();
	public CrownLandClassCustomDropDownValidationPage(WebDriver driver) {
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
    By drpConfigIconCrownLandJurisdiction = By.xpath("//*[contains(text(),'Crown Land Jurisdiction')]/..//span[contains(@id,'_ManageComboID')]");
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
		util.dummyWait(3);

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
     
     
     By CheckOntarioStateATValues = By.xpath("//*[contains(text(),'- ON')]");
     public static List<String> OntarioStateATValuesList = new ArrayList<String>();
     
     public List<String> ontarionStateApplicationTypeValues() {
  		List<WebElement> lst = driver.findElements(CheckOntarioStateATValues);
  		
  		for(WebElement e : lst){
  			OntarioStateATValuesList.add(e.getText().replace("- ON", ""));
  		}
  		return OntarioStateATValuesList;
  	}
    
     
     By CheckBCStateValues = By.xpath("//*[contains(text(),'British Columbia')]");
  	public static List<String> BCStateJurisdictionValues = new ArrayList<String>();
  	
      public List<String> BCStateJurisdictionDDValues() {
  		List<WebElement> lst = driver.findElements(CheckBCStateValues);
  		
  		for(WebElement e : lst){
  			BCStateJurisdictionValues.add(e.getText().replace("British Columbia", ""));
  		}
  		return BCStateJurisdictionValues;
  	}
     
      
      By CheckBCStateATValues = By.xpath("//*[contains(text(),'- BC')]");
      public static List<String> BCStateATValuesList = new ArrayList<String>();
      
      public List<String> BCStateApplicationTypeValues() {
   		List<WebElement> lst = driver.findElements(CheckBCStateATValues);
   		
   		for(WebElement e : lst){
   			BCStateATValuesList.add(e.getText().replace("- BC", ""));
   		}
   		return BCStateATValuesList;
   	}
      
      
    By dond = By.xpath("//li[text()='DOND']");
  	By inac = By.xpath("//li[text()='INAC']");
  	By pc = By.xpath("//li[text()='PC']");
  	By tc = By.xpath("//li[text()='TC']");
  	
  	public void verifyONFCLAgreementTypeValues() {
  	    sa.assertTrue(util.isElementVisible(dond, 2), "Value DOND is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(inac, 2), "Value INAC is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(pc, 2), "Value PC is not visible in the DD");
  	}
  	
  	public void verifyBCFCLAgreementTypeValues() {
  		sa.assertTrue(util.isElementVisible(dond, 2), "Value DOND is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(inac, 2), "Value INAC is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(pc, 2), "Value PC is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(tc, 2), "Value TC is not visible in the DD");
  	}
  	
  	By mecpLandUsePermit = By.xpath("//li[text()='MECP - Land Use Permit']");
   	By mecpParksManagementPlan = By.xpath("//li[text()='MECP - Parks Management Plan Amendment Approval']");
   	By mecpPTWP = By.xpath("//li[text()='MECP - Parks Temporary Work Permit']");
   	By mendm1 = By.xpath("//li[contains(text(),'MENDM - Withdrawal of Land from Prospecting')]");
   	By mendm2 = By.xpath("//li[text()='MENDM - Withdrawal of Staking Rights']");
   	By mnrf1 = By.xpath("//li[text()='MNRF - Authority to Haul Unscaled Crown Forest Resources']");
   	
   	public void verifyONPCLAgreementTypeValues() {
   	    sa.assertTrue(util.isElementVisible(mecpLandUsePermit, 2), "Value MECP - Land Use Permit is not visible in the DD");
   		sa.assertTrue(util.isElementVisible(mecpParksManagementPlan, 2), "Value MECP - Parks Management Plan Amendment Approval is not visible in the DD");
   		sa.assertTrue(util.isElementVisible(mecpPTWP, 2), "Value MECP - Parks Temporary Work Permit is not visible in the DD");
   		sa.assertTrue(util.isElementVisible(mendm1, 2), "Value MENDM - Withdrawal of Land from Prospecting is not visible in the DD");
   		sa.assertTrue(util.isElementVisible(mendm2, 2), "Value MENDM - Withdrawal of Staking Rights is not visible in the DD");
   		sa.assertTrue(util.isElementVisible(mnrf1, 2), "Value MNRF - Authority to Haul Unscaled Crown Forest Resources is not visible in the DD");
   		util.click(mnrf1);
   	}
   	
   	By CLUP = By.xpath("//li[text()='Crown Land Use Permit']");
   	By CL = By.xpath("//li[text()='Crown Lease']");
   	By CS = By.xpath("//li[text()='Changes in & about a stream']");
   	
   	public void verifyBCPCLAgreementTypeValues() {
   	    sa.assertTrue(util.isElementVisible(CLUP, 2), "Value Crown Land Use Permit is not visible in the DD");
   		sa.assertTrue(util.isElementVisible(CL, 2), "Value Crown Lease is not visible in the DD");
   		sa.assertTrue(util.isElementVisible(CS, 2), "Value Changes in & about a stream is not visible in the DD");
   		util.click(CS);
   	}
   	
   	
    public void verifyCustomDDValues(String testcaseName) {
    	//navigateParcelInformation();
    	
    		try {
        		util.click(crownLandPT);
        		util.dummyWait(3);
    			log("STEP 1: User can select Crown Land Class from the parcel list", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 1:   User cannot select Crown Land Class from the parcel list", Status.FAIL);
    			throw new RuntimeException("Failed in step 1");
    		}
    	
//    		try {
//    			TurnOnDesignCode();
//    			log("STEP 2:  user can able to click on the design mode icon     ", Status.PASS);
//    		} catch (Exception e) {
//    			log("STEP 2: user not able to click on the design mode icon ", Status.FAIL);
//    			throw new RuntimeException("Failed in step 2");
//    		}
    		
    		try {
    			selectState("Ontario");
    			log("STEP 3:  user can select Ontario State for Crown Land Class ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 3: user cannot select Ontario State for Crown Land Class", Status.FAIL);
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
			util.click(drpConfigIconCrownLandJurisdiction);
			log("STEP 5:  user can click on DropDown Configuration Icon of Crown Land Jurisdiction DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user cannot click on DropDown Configuration Icon of Crown Land Jurisdiction DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
    	
    	try {
			util.switchToChildWindow();
			ExtentTestManager.infoWithScreenshot("Crown Land Jurisdiction DD Configuration Values");
			ontarionStateJurisdictionDDValues();
			log("STEP 6:  user can get Ontario State Jurisdiction values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: user cannot get Ontario State Jurisdiction values list", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
    	
    	try {
    		driver.close();
			util.switchToParentWindow();			
			util.click(drpCrownLandJurisdiction);
			for(String var: OntarioStateJurisdictionValues) {
				System.out.println(var);
				        By expectedValue = By.xpath("//li[text()='"+var.trim()+"']");
				        
						util.highlightElement(driver.findElement(By.xpath("(//li[text()='"+var.trim()+"'])[1]")));
						sa.assertTrue(util.isElementVisible(expectedValue, 5), "Value "+var+" is not visible in the DD");
						
				}
			log("STEP 7:  user can see all Ontario State Jurisdiction values list in the Crown Land Jurisdiction DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot see all Ontario State Jurisdiction values list in the Crown Land Jurisdiction DD", Status.FAIL);
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
			ExtentTestManager.infoWithScreenshot("Application Type DD Configuration Values");
			ontarionStateApplicationTypeValues();
			log("STEP 9:  user can get Ontario State Application Type values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot get Ontario State Application Type values list", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
    	
    	try {
    		driver.close();
			util.switchToParentWindow();
			
			util.click(drpApplicationType);
			for(String var: OntarioStateATValuesList) {
				System.out.println(var);
				        By expectedValue = By.xpath("//li[text()='"+var.trim()+"']");
				        
						util.highlightElement(driver.findElement(By.xpath("(//li[text()='"+var.trim()+"'])[1]")));
						sa.assertTrue(util.isElementVisible(expectedValue, 5), "Value "+var+" is not visible in the DD");
						
				}
			log("STEP 10:  user can see all Ontario State related Application Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user cannot see all Ontario State related Application Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
    	
    	try {
			util.click(drpCrownLandJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Federal Crown Land')])[1]");
			util.click(firstValue);
			log("STEP 11:  user can select Federal Crown Land Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot select Federal Crown Land Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}

		try {
			clickOnSave();
			log("STEP 12:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 12: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		try {
			util.click(drpAgreementType);
			verifyONFCLAgreementTypeValues();
			log("STEP 13:  user can see list of ON-FCL Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: user cannot see list of ON-FCL Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
	
		try {
			util.click(drpCrownLandJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Provincial Crown Land')])[1]");
			util.click(firstValue);
			log("STEP 14:  user can select Provincial Crown Land Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user cannot select Provincial Crown Land Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}

		try {
			clickOnSave();
			log("STEP 15:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 15: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}

		try {
			util.click(drpAgreementType);
			verifyONPCLAgreementTypeValues();
			log("STEP 16:  user can see list of ON-PCL Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 16: user cannot see list of ON-PCL Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		try {
			clickOnSave();
			log("STEP 17:  user can Save Agreement Type value",Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user cannot Save Agreement Type value",Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
    	try {
			selectState("British Columbia");
			log("STEP 18:  user can select British Columbia State for Crown Land Class ", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: user cannot select British Columbia State for Crown Land Class", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
    	
    	try {
    		clickOnSave();
			log("STEP 19: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 19:   User cannot click on Save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
    	
    	try {
			util.click(drpConfigIconCrownLandJurisdiction);
			log("STEP 20:  user can click on DropDown Configuration Icon of Crown Land Jurisdiction DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: user cannot click on DropDown Configuration Icon of Crown Land Jurisdiction DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
    	
    	try {
			util.switchToChildWindow();
			BCStateJurisdictionDDValues();
			log("STEP 21:  user can get British Columbia State Jurisdiction values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: user cannot get British Columbia State Jurisdiction values list", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
    	
    	try {
    		driver.close();
			util.switchToParentWindow();
			util.click(drpCrownLandJurisdiction);
			for(String var: BCStateJurisdictionValues) {
				System.out.println(var);
				        By expectedValue = By.xpath("//li[text()='"+var.trim()+"']");
				        
						util.highlightElement(driver.findElement(By.xpath("(//li[text()='"+var.trim()+"'])[1]")));
						sa.assertTrue(util.isElementVisible(expectedValue, 5), "Value "+var+" is not visible in the DD");
						
				}
			log("STEP 22:  user can see all British Columbia State Jurisdiction values list in the Crown Land Jurisdiction DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: user cannot see all British Columbia State Jurisdiction values list in the Crown Land Jurisdiction DD", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
    	
    	try {
			util.click(drpConfigIconApplicationType);
			log("STEP 23:  user can click on DropDown Configuration Icon of Application/Request Type DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: user cannot click on DropDown Configuration Icon of Application/Request Type DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
    	
    	try {
			util.switchToChildWindow();
			BCStateApplicationTypeValues();
			log("STEP 24:  user can get British Columbia State Application Type values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 24: user cannot get British Columbia State Application Type values list", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
    	
    	try {
    		driver.close();
			util.switchToParentWindow();
			util.click(drpApplicationType);
			for(String var: BCStateATValuesList) {
				System.out.println(var);
				        By expectedValue = By.xpath("//li[text()='"+var.trim()+"']");
				        
						util.highlightElement(driver.findElement(By.xpath("(//li[text()='"+var.trim()+"'])[1]")));
						sa.assertTrue(util.isElementVisible(expectedValue, 5), "Value "+var+" is not visible in the DD");
						
				}
			log("STEP 25:  user can see all British Columbia State related Application Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: user cannot see all British Columbia State related Application Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
    	
    	try {
			util.click(drpCrownLandJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Federal Crown Land')])[1]");
			util.click(firstValue);
			log("STEP 26:  user can select Federal Crown Land Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 26: user cannot select Federal Crown Land Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}

		try {
			clickOnSave();
			log("STEP 27:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 27: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 27");
		}
		
		try {
			util.click(drpAgreementType);
			verifyBCFCLAgreementTypeValues();
			log("STEP 28:  user can see list of BC-FCL Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 28: user cannot see list of BC-FCL Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
	
		try {
			util.click(drpCrownLandJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Provincial Crown Land')])[1]");
			util.click(firstValue);
			log("STEP 29:  user can select Provincial Crown Land Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 29: user cannot select Provincial Crown Land Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}

		try {
			clickOnSave();
			log("STEP 30:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 30: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 30");
		}

		try {
			util.click(drpAgreementType);
			verifyBCPCLAgreementTypeValues();
			log("STEP 31:  user can see list of BC-PCL Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 31: user cannot see list of BC-PCL Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 31");
		}
		
		try {
			clickOnSave();
			sa.assertAll();
			log("STEP 32:  user can Save Agreement Type value",Status.PASS);
		} catch (Exception e) {
			log("STEP 32: user cannot Save Agreement Type value",Status.FAIL);
			throw new RuntimeException("Failed in step 32");
		}
    	
    }
    
}
