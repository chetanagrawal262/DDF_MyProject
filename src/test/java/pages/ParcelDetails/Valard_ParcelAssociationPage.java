package pages.ParcelDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class Valard_ParcelAssociationPage extends BasePage
{
	TestUtil util;
	CommonFunction commonFunction;
	public static String PrivateClassNo, PermitClassNo, TPClassNo, CrownLandNo;
	
	SoftAssert sa= new SoftAssert();

	public Valard_ParcelAssociationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	//Navigation
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | (//span[contains(text(),'Record Information')])[1]");
	//add Parcel
	By privatePT = By.xpath("(//strong[text()='Private']/../..)[1]");
    By permitPT = By.xpath("(//strong[text()='Permit']/../..)[1]");
    By crownLandPT = By.xpath("(//strong[text()='Crown Land']/../..)[1]");
    By thirdPartyPT = By.xpath("(//strong[text()='Third Party']/../..)[1]");
    By btnSave = By.xpath("//input[contains(@id,'_TractType_btnInternalSave')]");
    By drpRelatedCrownLandAuthorization = By.xpath("//*[text()='Related Crown Land Authorization']/..//input[@type='text']");
    By closeDrpRCLADD = By.xpath("//*[text()='Related Crown Land Authorization']/..//td[contains(@class,'rcbArrow')]");
    By drpRelatedPrivateLandAuthorization = By.xpath("//*[text()='Related Private Land Authorization']/..//input[@type='text']");
    By closeDrpRPLADD = By.xpath("//*[text()='Related Private Land Authorization']/..//td[contains(@class,'rcbArrow')]");
    By drpRelatedThirdPartyAuthorization = By.xpath("//*[text()='Related Third Party Authorization']/..//input[@type='text']");
    By closeDrpRTPADD = By.xpath("//*[text()='Related Third Party Authorization']/..//td[contains(@class,'rcbArrow')]");
    By drpRelatedPermitAuthorization = By.xpath("//*[text()='Related Permit Authorization']/..//input[@type='text']");
    By closeDrpRPADD = By.xpath("//*[text()='Related Permit Authorization']/..//td[contains(@class,'rcbArrow')]");
    By firstDDValue = By.xpath("(//*[contains(@id,'_YALComboBox_DropDown')]/..//input[@type='checkbox'])[1]");
    By firstDDValueChecked = By.xpath("(//*[contains(@id,'_YALComboBox_DropDown')]/..//input[@type='checkbox' and @checked])[1]");
   
    
    public void navigateParcelInformation() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navParcelInformation);
		util.click(navParcelInformation);
		commonFunction.projectSelection();
	}
    
   public void clickOnSave() {
    	util.waitUntilElementDisplay(btnSave);
		util.click(btnSave);
		util.waitUntilLoaderDisappearValard();
		util.dummyWait(2);
	}
    
   By txtParcelNo = By.xpath("//input[contains(@id,'TractType_TRACT_NUMBER') and @type='text']");
   
    public void associateParcels(String testcaseName) {
    	navigateParcelInformation();
    	
    	try {
    		util.waitUntilElementDisplay(crownLandPT);
    		util.click(crownLandPT);
    		util.waitUntilLoaderDisappearValard();
    		util.dummyWait(2);
			log("STEP 1: User can select Crown Land Parcel", Status.PASS);
		} catch (Exception e) {
			log("STEP 1:   User cannot select Crown Land Parcel", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
    	
    	try {
    		util.waitUntilElementDisplay(drpRelatedPrivateLandAuthorization);
    		util.click(drpRelatedPrivateLandAuthorization);
    		if(!util.isElementVisible(firstDDValueChecked)) {
            util.click(firstDDValue);
    		}
            util.click(closeDrpRPLADD);
			log("STEP 2: User can see Related Private Land Authorization DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 2:   User cannot see Related Private Land Authorization DD", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
    	
    	try {
    		util.waitUntilElementDisplay(drpRelatedThirdPartyAuthorization);
    		util.click(drpRelatedThirdPartyAuthorization);
    		if(!util.isElementVisible(firstDDValueChecked)) {
                util.click(firstDDValue);
        		}
            util.click(closeDrpRTPADD);
			log("STEP 3: User can see Related Third Party Authorization DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 3:   User cannot see Related Third Party Authorization DD", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
    	
    	try {
    		util.waitUntilElementDisplay(drpRelatedPermitAuthorization);
    		util.click(drpRelatedPermitAuthorization);
    		if(!util.isElementVisible(firstDDValueChecked)) {
                util.click(firstDDValue);
        		}
            util.click(closeDrpRPADD);
			log("STEP 4: User can see Related Permit Authorization DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 4:   User cannot see Related Permit Authorization DD", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
    	
    	try {
    		clickOnSave();
    		CrownLandNo = util.getAttributeValue(txtParcelNo, "value");
            PrivateClassNo=util.getAttributeValue(drpRelatedPrivateLandAuthorization, "value");
            System.out.println(CrownLandNo);
            System.out.println(PrivateClassNo);
            TPClassNo=util.getAttributeValue(drpRelatedThirdPartyAuthorization, "value");
            System.out.println(TPClassNo);
            PermitClassNo=util.getAttributeValue(drpRelatedPermitAuthorization, "value");
            System.out.println(PermitClassNo);
			log("STEP 5: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:   User cannot click on Save button", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
    	
    	try {
    		
    		 By privateParcel = By.xpath("//td[text()='"+PrivateClassNo.trim()+"']/parent::tr");
    		 util.waitUntilElementDisplay(privateParcel);
    		util.click(privateParcel);
    		util.waitUntilLoaderDisappearValard();
    		util.dummyWait(2);
			log("STEP 6: User can select Private Land Parcel", Status.PASS);
		} catch (Exception e) {
			log("STEP 6:   User cannot select Crown Land Parcel", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
    	
    	try {
    		util.waitUntilElementDisplay(drpRelatedCrownLandAuthorization);
           String CLParcelNo=util.getAttributeValue(drpRelatedCrownLandAuthorization, "value");
           sa.assertEquals(CLParcelNo, CrownLandNo);
			log("STEP 7: User can see associated  parcels no on private parcel", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 7:   User cannot see associated  parcels no on private parcel", Status.FAIL);
		}
    	
    	try {
   		 By permitParcel = By.xpath("//td[text()='"+PermitClassNo.trim()+"']/parent::tr");
   		util.waitUntilElementDisplay(permitParcel);
   		 util.click(permitParcel);
   		util.waitUntilLoaderDisappearValard();
		util.dummyWait(2);
			log("STEP 8: User can select Permit Land Parcel", Status.PASS);
		} catch (Exception e) {
			log("STEP 8:   User cannot select Permit Land Parcel", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
   	
   	try {
   		util.waitUntilElementDisplay(drpRelatedCrownLandAuthorization);
   	     String CLParcelNo=util.getAttributeValue(drpRelatedCrownLandAuthorization, "value");
   	     sa.assertEquals(CLParcelNo, CrownLandNo);
			log("STEP 9: User can see associated parcels no on permit parcel", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 9:   User cannot see associated parcels no on permit parcel", Status.FAIL);
		}
   	
   	try {
  		 By thirdPartyParcel = By.xpath("//td[text()='"+TPClassNo.trim()+"']/parent::tr");
  		util.waitUntilElementDisplay(thirdPartyParcel);
  		 util.click(thirdPartyParcel);
  		util.waitUntilLoaderDisappearValard();
		util.dummyWait(2);
			log("STEP 10: User can select Third Party Parcel", Status.PASS);
		} catch (Exception e) {
			log("STEP 10:   User cannot select Third Party Parcel", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
  	
  	try {
  		util.waitUntilElementDisplay(drpRelatedCrownLandAuthorization);
  	     String CLParcelNo=util.getAttributeValue(drpRelatedCrownLandAuthorization, "value");
  	    sa.assertEquals(CLParcelNo, CrownLandNo);
        sa.assertAll();
			log("STEP 11: User can see associated parcels no on Third Party parcel", Status.PASS);
		} catch (AssertionError e) {
			log("STEP 11:   User cannot see associated parcels no on Third Party parcel", Status.FAIL);
		}
    }
    
}
