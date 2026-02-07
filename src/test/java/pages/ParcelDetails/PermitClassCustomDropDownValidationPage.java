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

public class PermitClassCustomDropDownValidationPage extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public static String RecordNo, CrownLandRecordNo;
	SoftAssert sa= new SoftAssert();
	public PermitClassCustomDropDownValidationPage(WebDriver driver) {
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
    By drpConfigIconPermitJurisdiction = By.xpath("//*[contains(text(),'Permit Jurisdiction')]/..//span[contains(@id,'_ManageComboID')]");
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
		util.dummyWait(5);

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
      
      
    By cirnac = By.xpath("//li[text()='CIRNAC - Consultation Approval']");
  	By dfo1 = By.xpath("//li[text()='DFO - Fisheries Authorization']");
  	By dfo2 = By.xpath("//li[text()='DFO - Request for Review and/or Authorization']");
  	By dfo3 = By.xpath("//li[text()='DFO - SARA Permit']");
  	By eccc = By.xpath("//li[text()='ECCC - SARA Permit']");
  	
  	public void verifyONFPAgreementTypeValues() {
  	    sa.assertTrue(util.isElementVisible(cirnac, 2), "Value CIRNAC - Consultation Approval is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(dfo1, 2), "Value DFO - Fisheries Authorization is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(dfo2, 2), "Value DFO - Request for Review and/or Authorization is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(dfo3, 2), "Value DFO - SARA Permit is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(eccc, 2), "Value ECCC - SARA Permit is not visible in the DD");
  		
  	}
  	
  	
  	By bp = By.xpath("//li[text()='Building Permit']");
  	By dp = By.xpath("//li[text()='Development Permit']");
  	By ep = By.xpath("//li[text()='Electrical Permit']");
  	By hlp = By.xpath("//li[text()='Heavy Load Permit']");
  	By nble = By.xpath("//li[text()='Noise By-Law Exemption']");
  	
  	public void verifyONMPAgreementTypeValues() {
  	    sa.assertTrue(util.isElementVisible(bp, 2), "Value Building Permit is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(dp, 2), "Value Development Permit is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(ep, 2), "Value Electrical Permit is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(hlp, 2), "Value Heavy Load Permit is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(nble, 2), "Value Noise By-Law Exemption is not visible in the DD");
  		
  	}
  	
  	By mnrf1 = By.xpath("//li[text()='MNRF - Authorization to Interfere with/Destroy']");
  	By mnrf2 = By.xpath("//li[text()='MNRF – Authority to Haul Crown Trees (Patent Lands)']");
  	By mecp1 = By.xpath("//li[text()='MECP - Environmental Assessment (Notice of Approval)']");
  	By mecp2 = By.xpath("//li[text()='MECP - Permit to Take Water']");
  	By mnrf3 = By.xpath("//li[text()='MNRF - Aggregate Extraction Permit']");
  	
  	public void verifyONPPAgreementTypeValues() {
  	    sa.assertTrue(util.isElementVisible(mnrf1, 2), "Value MNRF - Authorization to Interfere with/Destroy is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(mnrf2), "Value MNRF – Authority to Haul Crown Trees (Patent Lands) is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(mecp1, 2), "Value MECP - Environmental Assessment (Notice of Approval) is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(mecp2, 2), "Value MECP - Permit to Take Water is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(mnrf3, 2), "Value MNRF - Aggregate Extraction Permit is not visible in the DD");
  		
  	}
  	
  	By ai = By.xpath("//li[text()='Authorization to Interfere with/Destroy']");
  	By ahct = By.xpath("//li[text()='Authority to Haul Crown Trees (Patent Lands)']");
  	By ea = By.xpath("//li[text()='Environmental Assessment (Notice of Approval)']");
  	By ptw = By.xpath("//li[text()='Permit to Take Water']");
  	By aep = By.xpath("//li[text()='Aggregate Extraction Permit']");
  	
  	public void verifyBCPPAgreementTypeValues() {
  	    sa.assertTrue(util.isElementVisible(ai, 2), "Value Authorization to Interfere with/Destroy is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(ahct), "Value Authority to Haul Crown Trees (Patent Lands) is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(ea, 2), "Value Environmental Assessment (Notice of Approval) is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(ptw, 2), "Value Permit to Take Water is not visible in the DD");
  		sa.assertTrue(util.isElementVisible(aep, 2), "Value Aggregate Extraction Permit is not visible in the DD");
  		
  	}
  	
    public void verifyCustomDDValues(String testcaseName) {
//    	navigateParcelInformation();
    	
    		try {
        		util.click(permitPT);
        		util.dummyWait(3);  
        		util.waitUntilLoaderDisappear();
        		log("STEP 1: User can select Permit Class from the parcel list", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 1:   User cannot select Permit Class from the parcel list", Status.FAIL);
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
    			log("STEP 3:  user can select Ontario State for Permit Class ", Status.PASS);
    		} catch (Exception e) {
    			log("STEP 3: user cannot select Ontario State for Permit Class", Status.FAIL);
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
			util.click(drpConfigIconPermitJurisdiction);
			log("STEP 5:  user can click on DropDown Configuration Icon of Permit Jurisdiction DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: user cannot click on DropDown Configuration Icon of Permit Jurisdiction DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
    	
    	try {
			util.switchToChildWindow();
			ExtentTestManager.infoWithScreenshot("Permit Jurisdiction DD Configuration Values");
			ontarionStateJurisdictionDDValues();
			log("STEP 6:  user can get Ontario State Jurisdiction values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: user cannot get Ontario State Jurisdiction values list", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
    	
    	try {
    		driver.close();
			util.switchToParentWindow();			
			util.click(drpPermitJurisdiction);
			for(String var: OntarioStateJurisdictionValues) {
				System.out.println(var);
				        By expectedValue = By.xpath("//li[text()='"+var.trim()+"']");
				        
						util.highlightElement(driver.findElement(By.xpath("(//li[text()='"+var.trim()+"'])[1]")));
						sa.assertTrue(util.isElementVisible(expectedValue, 5), "Value "+var+" is not visible in the DD");
						
				}
			log("STEP 7:  user can see all Ontario State Jurisdiction values list in the Permit Jurisdiction DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot see all Ontario State Jurisdiction values list in the Permit Jurisdiction DD", Status.FAIL);
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
			util.click(drpPermitJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Federal Permit')])[1]");
			util.click(firstValue);
			log("STEP 11:  user can select Federal Permit Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot select Federal Permit Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}

    	try {
			util.click(drpApplicationType);
			By firstValue = By.xpath("(//li[contains(text(),'Amendment')])[1]");
			util.click(firstValue);
			log("STEP 12:  user can select Application Type DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 12: user cannot select Application Type DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
    	
		try {
			clickOnSave();
			log("STEP 13:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 13: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			util.click(drpAgreementType);
			verifyONFPAgreementTypeValues();
			log("STEP 14:  user can see list of ON-FP Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user cannot see list of ON-FP Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
	
		try {
			util.click(drpPermitJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Municipal Permit')])[1]");
			util.click(firstValue);
			log("STEP 15:  user can select Municipal Permit Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 15: user cannot select Municipal Permit Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}

		try {
			clickOnSave();
			log("STEP 16:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 16: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
		
		try {
			util.click(drpAgreementType);
			verifyONMPAgreementTypeValues();
			log("STEP 17:  user can see list of ON-MP Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user cannot see list of ON-MP Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
		try {
			util.click(drpPermitJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Provincial Permit')])[1]");
			util.click(firstValue);
			log("STEP 18:  user can select Provincial Permit Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 18: user cannot select Provincial Permit Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}

		try {
			clickOnSave();
			log("STEP 19:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 19: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		
		try {
			util.click(drpAgreementType);
			verifyONPPAgreementTypeValues();
			log("STEP 20:  user can see list of ON-PP Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: user cannot see list of ON-PP Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		
		
    	try {
			selectState("British Columbia");
			log("STEP 21:  user can select British Columbia State for Permit Class ", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: user cannot select British Columbia State for Permit Class", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
    	
    	try {
    		clickOnSave();
			log("STEP 22: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 22:   User cannot click on Save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
    	
    	try {
			util.click(drpConfigIconPermitJurisdiction);
			log("STEP 23:  user can click on DropDown Configuration Icon of Permit Jurisdiction DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 23: user cannot click on DropDown Configuration Icon of Permit Jurisdiction DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}
    	
    	try {
			util.switchToChildWindow();
			BCStateJurisdictionDDValues();
			log("STEP 24:  user can get British Columbia State Jurisdiction values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 24: user cannot get British Columbia State Jurisdiction values list", Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
    	
    	try {
    		driver.close();
			util.switchToParentWindow();
			util.click(drpPermitJurisdiction);
			for(String var: BCStateJurisdictionValues) {
				System.out.println(var);
				        By expectedValue = By.xpath("//li[text()='"+var.trim()+"']");
				        
						util.highlightElement(driver.findElement(By.xpath("(//li[text()='"+var.trim()+"'])[1]")));
						sa.assertTrue(util.isElementVisible(expectedValue, 5), "Value "+var+" is not visible in the DD");
						
				}
			log("STEP 25:  user can see all British Columbia State Jurisdiction values list in the Permit Jurisdiction DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: user cannot see all British Columbia State Jurisdiction values list in the Permit Jurisdiction DD", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
    	
    	try {
			util.click(drpConfigIconApplicationType);
			log("STEP 26:  user can click on DropDown Configuration Icon of Application/Request Type DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 26: user cannot click on DropDown Configuration Icon of Application/Request Type DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
    	
    	try {
			util.switchToChildWindow();
			BCStateApplicationTypeValues();
			log("STEP 27:  user can get British Columbia State Application Type values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 27: user cannot get British Columbia State Application Type values list", Status.FAIL);
			throw new RuntimeException("Failed in step 27");
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
			log("STEP 28:  user can see all British Columbia State related Application Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 28: user cannot see all British Columbia State related Application Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 28");
		}
    	
    	try {
			util.click(drpPermitJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Federal Permit')])[1]");
			util.click(firstValue);
			log("STEP 29:  user can select Federal Permit Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 29: user cannot select Federal Permit Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 29");
		}

    	try {
			util.click(drpApplicationType);
			By firstValue = By.xpath("(//li[contains(text(),'Amendment')])[1]");
			util.click(firstValue);
			log("STEP 30:  user can select Application Type DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 30: user cannot select Application Type DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 30");
		}
    	
		try {
			clickOnSave();
			log("STEP 31:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 31: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 31");
		}
		
		try {
			util.click(drpAgreementType);
			verifyONFPAgreementTypeValues();
			log("STEP 32:  user can see list of BC-FP Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 32: user cannot see list of BC-FP Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 32");
		}
		
		try {
			util.click(drpPermitJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Municipal Permit')])[1]");
			util.click(firstValue);
			log("STEP 33:  user can select Municipal Permit Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 33: user cannot select Municipal Permit Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 33");
		}

		try {
			clickOnSave();
			log("STEP 34:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 34: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 34");
		}
		
		try {
			util.click(drpAgreementType);
			verifyONMPAgreementTypeValues();
			log("STEP 35:  user can see list of BC-MP Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 35: user cannot see list of BC-MP Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 35");
		}
		
		try {
			util.click(drpPermitJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Provincial Permit')])[1]");
			util.click(firstValue);
			log("STEP 36:  user can select Provincial Permit Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 36: user cannot select Provincial Permit Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 36");
		}

		try {
			clickOnSave();
			log("STEP 37:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 37: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 37");
		}
		
		try {
			util.click(drpAgreementType);
			verifyBCPPAgreementTypeValues();
			sa.assertAll();
			log("STEP 38:  user can see list of BC-PP Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 38: user cannot see list of BC-PP Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 38");
		}
		
    }
    
}
