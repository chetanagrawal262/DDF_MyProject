package pages.projectImportALT;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;
import extentReports.ExtentTestManager;

public class ErrorLog extends BasePage{

	
	TestUtil util;
	CommonFunction commonFunction;
	SoftAssert assertion = new SoftAssert();
	
	public ErrorLog(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	
	By parcelAlreadyLinked = By.xpath("(//*[contains(text(),'Parcel #') and contains(text(),'is already associated to Agreement #')])[1]");
	By blankParcelNo = By.xpath("(//*[contains(text(),'Parcel #') and contains(text(),'cannot be blank')])[1]");
	By valueNotExists = By.xpath("(//*[contains(text(),'does not match existing value in application')])[1] | (//*[contains(text(),'does not match configured value in application')])[1]");
	By parcelAcresUnsupportedValue = By.xpath("(//*[contains(text(),'Parcel Acres') and contains(text(),'is not in the supported format.')])[1]");
	By gisParcelAcresUnsupportedValue = By.xpath("(//*[contains(text(),'GIS Parcel Acres') and contains(text(),'is not in the supported format.')])[1]");
	By LeasedAcresUnsupportedValue = By.xpath("(//*[contains(text(),'Leased Acres') and contains(text(),'is not in the supported format.')])[1]");
	By invalidActiveValue = By.xpath("(//*[contains(text(),'Active/Inactive value is not valid. Valid values - Yes, True, No or False.')])[1] | (//*[contains(text(),'Active') and contains(text(),'is not in the supported format. Valid values - Yes, True, No or False')])[1] | (//*[contains(text(),'Active/Inactive') and contains(text(),' value is not valid. Valid values - Yes, True, No or False.')])[1]");
	By duplicateRecord = By.xpath("(//*[contains(text(),'Duplicate records exist for tract # CA1.')])[1]");
//	By msgError = By.xpath("//*[contains(@id,'rgDataMigrationErorLog_radYALGridControl')]/td[4]");
	By msgError = By.xpath("(//table[contains(@id,'rgDataMigrationErorLog_radYALGridControl')]/..//td[count(//table/thead/tr/th[.='Error_Msg']/preceding-sibling::th)+1])[3]");
	
	int count = 0;
	
	public void printErrorLog() {
		List<WebElement> error = driver.findElements(msgError);
		for(WebElement var: error) {
			count++;
			ExtentTestManager.info("Error_Msg " +count+" : "+ var.getText());
		}
	}
	
	public void landDatavalidationMsg(String testcaseName) {	
		if(!testcaseName.contains("NOVA") & !testcaseName.contains("CONNECTGEN")) {
		        assertion.assertTrue(util.isElementPresent(parcelAlreadyLinked, 30), "Parcel Already linked error does not display");
		}
				assertion.assertTrue(util.isElementPresent(blankParcelNo, 30), "Blank Parcel error does not display");
				
				assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non configured values");
				
				assertion.assertTrue(util.isElementPresent(parcelAcresUnsupportedValue, 30), "Unsupported error not displayed for Parcel Acres");
				
				assertion.assertTrue(util.isElementPresent(gisParcelAcresUnsupportedValue, 30), "Unsupported error not displayed for GIS Parcel Acres");
				
		if(!testcaseName.contains("CONNECTGEN")) {
		
			assertion.assertTrue(util.isElementPresent(LeasedAcresUnsupportedValue, 30), "Unsupported error not displayed for Leased Acres");
		    
			assertion.assertTrue(util.isElementPresent(duplicateRecord, 30), "Duplicate record exists error not displayed");
		}	
				assertion.assertTrue(util.isElementPresent(invalidActiveValue, 30), "Error not displayed for Invalid Active value");
			
				assertion.assertAll();
		}
	

	By parcelNotFound = By.xpath("(//*[contains(text(),'Parcel #') and contains(text(),'could not be found within selected project.')])[1]");
	By nonNumericValue = By.xpath("(//*[contains(text(),'There are non numaric value in') and contains(text(),'Phone')])[1]");
	By nameBlank = By.xpath("(//*[contains(text(),'Name cannot be blank for')])[1]");
	By emailInvalid = By.xpath("(//*[contains(text(),'Email address  Invalid Email is invalid on Parcel #')])[1]");
	By ownershipValueNotSupported = By.xpath("(//*[contains(text(),'Ownership') and contains(text(),'is not in the supported format. This should be <= 1')])[1]");
	
	public void ParcelOwnervalidationMsg(String testcaseName) {	
		      
		if(!testcaseName.contains("CONNECTGEN")) {
		          assertion.assertTrue(util.isElementPresent(blankParcelNo, 30), "Blank Parcel error does not display");
	        	
		          assertion.assertTrue(util.isElementPresent(parcelNotFound, 30), "Error for existing parcel not found does not display");
					
		          assertion.assertTrue(util.isElementPresent(nonNumericValue, 30), "Non numeric value in Phone field error not display");
		        
		          assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non configured values");
					
		          assertion.assertTrue(util.isElementPresent(nameBlank, 30), "Blank Name Error does not display");
				
		          assertion.assertTrue(util.isElementPresent(emailInvalid, 30), "Invalid Email Error not displayed");
		}
		          assertion.assertTrue(util.isElementPresent(ownershipValueNotSupported, 30), "Error not displayed for Unsupported Ownership values");
			
				  assertion.assertAll();

		}
		
	By AgreementNotexist = By.xpath("(//*[contains(text(),'Agreement #') and contains(text(),'does not exist on the project')])[1]");
	By ParcelNonotexist = By.xpath("(//*[contains(text(),'Parcel #') and contains(text(),'does not exist on the project')])[1] | (//*[contains(text(),'Orion PID') and contains(text(),'does not exist within the selected project')])[1]");
	By blankAgreementtype = By.xpath("(//*[contains(text(),'Agreement Term Type') and contains(text(),'cannot be blank')])[1]");
	By blankeffectivedate = By.xpath("(//*[contains(text(),'Effective Date') and contains(text(),'cannot be blank')])[1]");
	
		
	public void AgreementDatavalidationMsg(String testcaseName) {	
		
		          assertion.assertTrue(util.isElementPresent(blankAgreementNo, 30), "Blank Agreement error does not display");
					
		          if(testcaseName.contains("CONNECTGEN")) {
		        	  assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non configured values");
		        	  
		        	  assertion.assertTrue(util.isElementPresent(invalidDateFormat, 30), "Error does not display for non supported date values");
		          }
		           assertion.assertAll();

		}

    public void AgreementParcelsvalidationMsg(String testcaseName) {	
		     
		          assertion.assertTrue(util.isElementPresent(AgreementNotexist, 30), "Error for agreement not found does not display");
	        	
		          assertion.assertTrue(util.isElementPresent(ParcelNonotexist, 30), "Error for parcel not found does not display");
		          
		          if(testcaseName.contains("CONNECTGEN")) {
		        	  
		          assertion.assertTrue(util.isElementPresent(blankParcelNo, 30), "Blank Parcel # error does not display");
		          
		          assertion.assertTrue(util.isElementPresent(blankAgreementNo, 30), "Blank Agreement  # error does not display");
		          }
					
		           assertion.assertAll();

		}
	
	public void AgreementTermsvalidationMsg(String testcaseName) {	
		
		          assertion.assertTrue(util.isElementPresent(AgreementNotexist, 30), "Error for agreement not found does not display");
	        	
		          assertion.assertTrue(util.isElementPresent(blankAgreementNo, 30), "Blank Agreement error does not display");
		          
		          assertion.assertTrue(util.isElementPresent(blankAgreementtype, 30), "Blank Agreement term type error does not display");
					
		          assertion.assertTrue(util.isElementPresent(blankeffectivedate, 30), "Blank Effective Date error does not display");
		          
		          if(testcaseName.contains("CONNECTGEN")) {
		          assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non configured dd values");
		          
		          assertion.assertTrue(util.isElementPresent(invalidTermLength, 30), "Error does not display for Unsupported Term Lengh values");
		          }
		          
		           assertion.assertAll();

		}

	By agreementNotExists = By.xpath("(//*[contains(text(),'Agreement #') and contains(text(),'could not be found within selected project')])[1]");
	By blankAgreementNo = By.xpath("(//*[contains(text(),'Agreement # cannot be blank')])[1]");
	By invalidEmail = By.xpath("(//*[contains(text(),'Email address') and contains(text(),'is invalid on Agreement #')])[1]");
	By surfaceOwnershipValueNotSupported = By.xpath("(//*[contains(text(),'Surface Ownership') and contains(text(),'is not in the supported format. This should be <= 1')])[1]");
	By windOwnershipValueNotSupported = By.xpath("(//*[contains(text(),'Wind Ownership') and contains(text(),'is not in the supported format. This should be <= 1')])[1]");
	By cropOwnershipValueNotSupported = By.xpath("(//*[contains(text(),'Crop Ownership') and contains(text(),'is not in the supported format. This should be <= 1')])[1]");
	By paymentShareValueNotSupported = By.xpath("(//*[contains(text(),'Payment Share') and contains(text(),'is not in the supported format. This should be <= 1')])[1]");
	
    public void agreementContactsvalidationMsg(String testcaseName) {	
	        	
		          assertion.assertTrue(util.isElementPresent(agreementNotExists, 30), "Error for existing agreement not found does not display");
					
		          assertion.assertTrue(util.isElementPresent(blankAgreementNo, 30), "Blank Agreement # error does not display");
		        
		          assertion.assertTrue(util.isElementPresent(nameBlank, 30), "Blank Entity Name Error does not display");
				
		          assertion.assertTrue(util.isElementPresent(invalidEmail, 30), "Invalid Email Error not displayed");
				
		          assertion.assertTrue(util.isElementPresent(surfaceOwnershipValueNotSupported, 30), "Error not displayed for Unsupported Surface Ownership values");
		          
		          assertion.assertTrue(util.isElementPresent(windOwnershipValueNotSupported, 30), "Error not displayed for Unsupported Wind Ownership values");
		          
		          assertion.assertTrue(util.isElementPresent(cropOwnershipValueNotSupported, 30), "Error not displayed for Unsupported Crop Ownership values");
		          
		          if(!testcaseName.contains("NOVA")) {
		          assertion.assertTrue(util.isElementPresent(paymentShareValueNotSupported, 30), "Error not displayed for Unsupported Payment Share values");
		          }
		          
		          assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non configured values");
				
				  assertion.assertAll();

		}
	
    //#68475-start
    By invalidEmail_1 = By.xpath("//*[text()='Email address  DSF is invalid on Agreement # ']");
    By invalidEmail_2 = By.xpath("(//*[text()='Email address  werw.dsoiwer is invalid on Agreement # AG01'])[1]");
    By validEmail = By.xpath("(//*[text()='Email address  test@gmail.com is invalid on Agreement # AG01)])[1]");
    public void agreementContactsvalidationMsgOfAvantus(String testcaseName) {	
    	
        assertion.assertTrue(util.isElementPresent(blankAgreementNo, 30), "Blank Agreement # error does not display");
      
        assertion.assertTrue(util.isElementPresent(nameBlank, 30), "Blank Entity Name Error does not display");
		
        assertion.assertTrue(util.isElementPresent(surfaceOwnershipValueNotSupported, 30), "Error not displayed for Unsupported Surface Ownership values");
        
        assertion.assertTrue(util.isElementPresent(windOwnershipValueNotSupported, 30), "Error not displayed for Unsupported Wind Ownership values");
        
        assertion.assertTrue(util.isElementPresent(cropOwnershipValueNotSupported, 30), "Error not displayed for Unsupported Crop Ownership values");
        
         assertion.assertTrue(util.isElementPresent(paymentShareValueNotSupported, 30), "Error not displayed for Unsupported Payment Share values");
         
        assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non configured values");
		
        assertion.assertTrue(util.isElementPresent(invalidEmail_1, 30), "Invalid Email Error not displayed");
		
        assertion.assertTrue(util.isElementPresent(invalidEmail_2, 30), "Invalid Email Error not displayed"); 
        
        assertion.assertFalse(util.isElementPresent(validEmail, 30), "Error Msg not displayed for valid Email Address");
        
		assertion.assertAll();

}
  //#68475-end
    
    By recordNumberNotExists = By.xpath("(//*[contains(text(),'does not exist on the project. Please correct the data and reimport')])[1]");
    By blankRecordType = By.xpath("(//*[contains(text(),'Record Type is required')])[1]");
    By blankRecordNumber = By.xpath("(//*[contains(text(),'Record Number is required')])[1]");
    By blankDocumentLink = By.xpath("(//*[contains(text(),'Document Link is required')])[1]"); 
    By InvalidDocumentType = By.xpath("(//*[contains(text(),'does not match a value configured in the application. Please correct the data and reimport.')])[1]");
    
    public void DocumentImportvalidationMsg(String testcaseName) {	
    	
        assertion.assertTrue(util.isElementPresent(recordNumberNotExists, 30), "Error for existing Record Number not found does not display");
			
        assertion.assertTrue(util.isElementPresent(blankRecordType, 30), "Required msg does not display for blank Record Type");
      
        assertion.assertTrue(util.isElementPresent(blankRecordNumber, 30), "Required msg does not display for blank Record Number");
		
        assertion.assertTrue(util.isElementPresent(blankDocumentLink, 30), "Required msg does not display for blank Document Link");
		
        assertion.assertTrue(util.isElementPresent(InvalidDocumentType, 30), "Error not displayed for non configured Document Type values");
        
		  assertion.assertAll();

}
    
		/* Orion */
    
    By entityRecordExists = By.xpath("(//*[contains(text(),'Entity records exist for Entity #') and contains(text(),'Remove existing Entity or choose ignore to override Entity data.')])[1]");
	By nonExistingLeaseType = By.xpath("(//*[contains(text(),'Lease Type') and contains(text(),'does not match existing value in application. Ignoring this warning will make Agreement Type blank.')])[1]");
	
    public void landDatavalidationMsgOrion(String testcaseName) {	
		
        assertion.assertTrue(util.isElementPresent(entityRecordExists, 30), "Error does not display for Existing Entity Record");
		
		assertion.assertTrue(util.isElementPresent(blankParcelNo, 30), "Blank Parcel error does not display");
		
		assertion.assertTrue(util.isElementPresent(nonExistingLeaseType, 30), "Error does not display for non configured Lease Type values");
	
		assertion.assertAll();
     }
    
    By invalidTermLength = By.xpath("(//*[contains(text(),'Term Length') and contains(text(),'is not in the supported format. This should be whole no (ex. 16)')])[1]");
    By invalidEffectiveDate = By.xpath("(//*[contains(text(),'Effective Date is not in the supported format of MM/DD/YYYY')])[1]");

    public void LeaseTermsvalidationMsg(String testcaseName) {	
    	
    	assertion.assertTrue(util.isElementPresent(blankAgreementNo, 30), "Blank Agreement error does not display");
    	
    	assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non existing values in application");
    	
    	assertion.assertTrue(util.isElementPresent(invalidActiveValue, 30), "Error does not display for Invalid Active value");
    	
    	assertion.assertTrue(util.isElementPresent(invalidTermLength, 30), "Error does not display for Invalid Term Length");
    	
    	assertion.assertTrue(util.isElementPresent(invalidEffectiveDate, 30), "Error does not display for Invalid Effective Date");
		
        assertion.assertTrue(util.isElementPresent(AgreementNotexist, 30), "Error for agreement not found does not display");
        
        assertion.assertTrue(util.isElementPresent(blankAgreementtype, 30), "Blank Agreement term type error does not display");
			
        assertion.assertTrue(util.isElementPresent(blankeffectivedate, 30), "Blank Effective Date error does not display");
        
        assertion.assertAll();

     }
    
    public void leaseContactDatavalidationMsg(String testcaseName) {	
    	
        assertion.assertTrue(util.isElementPresent(agreementNotExists, 30), "Error for existing agreement not found does not display");
		
		  assertion.assertAll();

    }
    
    By invalidDateFormat = By.xpath("(//*[contains(text(),'Date is not in the supported format of MM/DD/YYYY')])[1] | (//*[contains(text(),'does not match the supported format of MM/DD/YYYY')])[1]");
    By turbineDoesNotExist = By.xpath("(//*[contains(text(),'Turbine') and contains(text(),'does not exist within the') and contains(text(),'project')])[1]");
    By invalidProduction = By.xpath("(//*[contains(text(),'The Production amount for Turbine') and contains(text(),'is not a number. Please correct the value and try again')])[1]");
    By blankDate = By.xpath("(//*[contains(text(),'Date cannot be blank')])[1]");
    By blankTurbine = By.xpath("(//*[contains(text(),'Turbine ID cannot be blank')])[1]");
    By blankProduction = By.xpath("(//*[contains(text(),'The Production amount for Turbine') and contains(text(),'is blank')])[1]");
    By blankPricePerTon = By.xpath("(//*[contains(text(),'The Price Per Ton for Turbine') and contains(text(),'is blank')])[1]");
    By blanksales = By.xpath("(//*[contains(text(),'The Sales Field for Turbine') and contains(text(),'is blank')])[1]");
    By blanksalesPer = By.xpath("(//*[contains(text(),'The Sales % for Field For Turbine') and contains(text(),'is blank')])[1]");
    By invalidValue = By.xpath("(//*[contains(text(),'for Turbine') and contains(text(),'is invalid, Please correct the value and try again')])[1]");
    
    public void productionTrackingvalidationMsg(String testcaseName) {	
    	
        assertion.assertTrue(util.isElementPresent(invalidDateFormat, 30), "Error does not display for Invalid Date Format");
        
        assertion.assertTrue(util.isElementPresent(turbineDoesNotExist, 30), "Error does not display for non existing Turbine ID");
        
        assertion.assertTrue(util.isElementPresent(invalidProduction, 30), "Error does not display for Invalid Production");
		
        assertion.assertTrue(util.isElementPresent(blankDate, 30), "Error does not display for Blank Date");
        
        assertion.assertTrue(util.isElementPresent(blankTurbine, 30), "Error does not display for Blank Turbine ID");
        
        assertion.assertTrue(util.isElementPresent(blankProduction, 30), "Error does not display for Blank Production");
        
        if(environment.contains("RAMACO")) {
        	  assertion.assertTrue(util.isElementPresent(blankPricePerTon, 30), "Error does not display for Blank Price Per Ton");
        	  
        	  assertion.assertTrue(util.isElementPresent(blanksales, 30), "Error does not display for Blank Sales");
        	  
        	  assertion.assertTrue(util.isElementPresent(blanksalesPer, 30), "Error does not display for Blank Sales %");
        	  
        	  assertion.assertTrue(util.isElementPresent(invalidValue, 30), "Error does not display for Invalid Values");
        }
		assertion.assertAll();

    }
    
    By parcelRequired = By.xpath("(//*[contains(text(),'Orion PID is required')])[1]");
    
  public void titleImportvalidationMsg(String testcaseName) {	
    	
        assertion.assertTrue(util.isElementPresent(ParcelNonotexist, 30), "Error does not display for non Existing Orion PID");
        
        assertion.assertTrue(util.isElementPresent(parcelRequired, 30), "Error does not display for blank Orion PID");
        
        assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non configured DD values");
        
		assertion.assertAll();

    }
  
  public void layoutPermittedImportvalidationMsg(String testcaseName) {	
  	
      assertion.assertTrue(util.isElementPresent(ParcelNonotexist, 30), "Error does not display for non Existing Orion PID");
      
      assertion.assertTrue(util.isElementPresent(parcelRequired, 30), "Error does not display for blank Orion PID");
      
	  assertion.assertAll();

  }

}
