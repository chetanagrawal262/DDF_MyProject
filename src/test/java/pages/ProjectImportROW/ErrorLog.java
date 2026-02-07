package pages.ProjectImportROW;

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
	By parcelAcresUnsupportedValue = By.xpath("(//*[contains(text(),'Parcel Acres') and contains(text(),'is not in the supported format.')])[1]");
	By gisParcelAcresUnsupportedValue = By.xpath("(//*[contains(text(),'GIS Parcel Acres') and contains(text(),'is not in the supported format.')])[1]");
	By LeasedAcresUnsupportedValue = By.xpath("(//*[contains(text(),'Leased Acres') and contains(text(),'is not in the supported format.')])[1]");
	By invalidActiveValue = By.xpath("(//*[contains(text(),'Active/Inactive value is not valid. Valid values - Yes, True, No or False.')])[1]");
	By duplicateRecord = By.xpath("(//*[contains(text(),'Duplicate records exist for tract # CA1.')])[1]");
	By parcelNotFound = By.xpath("(//*[contains(text(),'Parcel #') and contains(text(),'could not be found within selected project.')])[1]");
	By tractNotexist = By.xpath("(//*[contains(text(),'Tract #') and contains(text(),'does not exist within the selected project.')])[1]");
	By nonNumericValue = By.xpath("(//*[contains(text(),'There are non numaric value in') and contains(text(),'Phone')])[1]");
	By nameBlank = By.xpath("(//*[contains(text(),'Name cannot be blank for Parcel #')])[1]");
	By emailInvalid = By.xpath("(//*[contains(text(),'Email address  Invalid Email is invalid on Parcel #')])[1]");
	By ownershipValueNotSupported = By.xpath("(//*[contains(text(),'Ownership') and contains(text(),'is not in the supported format. This should be <= 1')])[1]");
	By invalidAgent = By.xpath("(//*[contains(text(),'Invalid Agent Name')])[1]");
	By invalidChildCate = By.xpath("(//*[contains(text(),'Type Sub Category selection(s) listed are invalid')])[1]");
	By invalidActiveDate = By.xpath("(//*[contains(text(),'Activity Date') and contains(text(),'is not a valid date. Please enter the date in MM/DD/YYYY format')])[1]");
	By invalidRecordedDate = By.xpath("(//*[contains(text(),'Recorded Date') and contains(text(),'is not in supported format. Please enter the date in MM/DD/YYYY format')])[1]");
	By invalidEffectiveDate = By.xpath("(//*[contains(text(),'Effective Date') and contains(text(),'is not in supported format. Please enter the date in MM/DD/YYYY format')])[1]");
	By invalidExpirationDate = By.xpath("(//*[contains(text(),'Expiration Date') and contains(text(),'is not in supported format. Please enter the date in MM/DD/YYYY format')])[1]");
	By tractNorequired = By.xpath("(//*[contains(text(),'Tract # is required')])[1]");
	By docTypeNotSupport = By.xpath("(//*[contains(text(),'Document Type') and contains(text(),'is not supported. Supported values are Easements,  Liens, Deeds.')])[1]");
	By blankParcelNo = By.xpath("(//*[contains(text(),'Parcel #') and contains(text(),'cannot be blank')])[1]");
	By valueNotExists = By.xpath("(//*[contains(text(),'does not match existing  values in application')])[1]");
	By tractNotExists = By.xpath("(//*[contains(text(),'Tract #') and contains(text(),'does not exist within the selected project')])[1]");
	By startDateInvalid = By.xpath("(//*[contains(text(),'Start Date') and contains(text(),'is not a valid date. Please enter the date in MM/DD/YYYY format')])[1]");
	By endDateInvalid = By.xpath("(//*[contains(text(),'End Date') and contains(text(),'is not a valid date. Please enter the date in MM/DD/YYYY format')])[1]");
	By nextDueDateInvalid = By.xpath("(//*[contains(text(),'Next Due Date') and contains(text(),'is not a valid date. Please enter the date in MM/DD/YYYY format')])[1]");
	By dateApprovedInvalid = By.xpath("(//*[contains(text(),'Date Approved') and contains(text(),'is not a valid date. Please enter the date in MM/DD/YYYY format')])[1]");
	//By msgError = By.xpath("//*[contains(@id,'rgDataMigrationErorLog_radYALGridControl')]/td[4]");
	By msgError = By.xpath("//table/tbody/tr/td[count(//table/thead/tr/th[.='Error_Msg']/preceding-sibling::th)+1]");
	By tractRequired = By.xpath("(//*[contains(text(),'Tract # is Required')])[1] | (//*[contains(text(),'Tract # is required')])[1]");
	By lengthNonNumeric = By.xpath("(//*[contains(text(),'Length Value') and contains(text(),'is not numeric.')])[1]");
	By widthNonNumeric = By.xpath("(//*[contains(text(),'Width value') and contains(text(),'is not numeric.')])[1]");
	By invalidChildCategory = By.xpath("(//*[contains(text(),'Type Sub Category selection(s) listed are invalid')])[1]");
	By tractNoBlank = By.xpath("(//*[contains(text(),' Tract No.# () is blank')])[1]");
	By nonExistingDDValue = By.xpath("(//*[contains(text(),'does NOT match existing DD value')])[1]");
	By invalidState = By.xpath("(//*[contains(text(),'State value') and contains(text(),'is not valid')])[1]");
	By invalidCounty = By.xpath("(//*[contains(text(),'County Value') and contains(text(),'is not valid for the state')])[1]");
	By invalidPerOwnership = By.xpath("(//*[contains(text(),'Percent Ownership value') and contains(text(),'is invalid')])[1]");
	By invalidPreferredContact = By.xpath("(//*[contains(text(),'Preferred contact Value') and contains(text(),'is invalid')])[1]");
	By invalidPrimaryValue = By.xpath("(//*[contains(text(),'Primary on Value') and contains(text(),'is invalid')])[1]");
	By invalidEmail = By.xpath("(//*[contains(text(),'Email') and contains(text(),'is invalid')])[1]");
	
	int count = 0;
	
	public void printErrorLog() {
		List<WebElement> error = driver.findElements(msgError);
		for(WebElement var: error) {
			count++;
			ExtentTestManager.info("Error_Msg " +count+" : "+ var.getText());
		}
	}
	
        
	public void AgentNotesvalidationMsg(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
		
		        assertion.assertTrue(util.isElementPresent(tractNotexist, 30), "Parcel does not exist error does not display");
				
				assertion.assertTrue(util.isElementPresent(invalidAgent, 30), "Invalid Agent name error does not display");
				
				assertion.assertTrue(util.isElementPresent(invalidChildCate, 30), "Invalid Child Category error does not display");
				
				assertion.assertTrue(util.isElementPresent(invalidActiveDate, 30), "Active Date format invalid error not display");
				
				assertion.assertAll();
		}
      
        public void TitlevalidationMsg(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
		      
		          assertion.assertTrue(util.isElementPresent(tractNotexist, 30), "Parcel does not exist error does not display");
	        	
		          assertion.assertTrue(util.isElementPresent(tractNorequired, 30), "Error for required parcel # does not display");
					
		          assertion.assertTrue(util.isElementPresent(docTypeNotSupport, 30), "Error for Document Type not support does not display");
		        
		          assertion.assertTrue(util.isElementPresent(invalidRecordedDate, 30), "Error does not display for Invalid Recorded Date");
					
		          assertion.assertTrue(util.isElementPresent(invalidEffectiveDate, 30), "Error does not display for Invalid Effective Date");
				
		          assertion.assertTrue(util.isElementPresent(invalidExpirationDate, 30), "Error does not display for Invalid Expiration Date");				
		         
				  assertion.assertAll();

		}
	
	By blankAgreementNo = By.xpath("(//*[contains(text(),'Agreement #') and contains(text(),'cannot be blank')])[1]");
	By AgreementNonotexist = By.xpath("(//*[contains(text(),'Agreement #') and contains(text(),'does not exist on the project')])[1]");
	By ParcelNonotexist = By.xpath("(//*[contains(text(),'Parcel #') and contains(text(),'does not exist on the project')])[1]");
	By blankAgreementtype = By.xpath("(//*[contains(text(),'Agreement Term Type') and contains(text(),'cannot be blank')])[1]");
	By blankeffectivedate = By.xpath("(//*[contains(text(),'Effective Date') and contains(text(),'cannot be blank')])[1]");
	
		
	public void AgreementvalidationMsg(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
		          assertion.assertTrue(util.isElementPresent(blankAgreementNo, 30), "Blank Agreement error does not display");
	        	
//		          assertion.assertTrue(util.isElementPresent(GrantorAgreementName, 30), "Error for Grantor/Agreement Name not found does not display");
		     		
		          assertion.assertAll();

		}
	
	
	
	public void AgreementParcelsvalidationMsg(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
		          assertion.assertTrue(util.isElementPresent(AgreementNonotexist, 30), "Error for agreement not found does not display");
	        	
		          assertion.assertTrue(util.isElementPresent(ParcelNonotexist, 30), "Error for parcel not found does not display");
		       // ExtentTestManager.info("Validation 2 : validation Msg successfully display when imported Parcel # does not exists in the selected project");
					
		           assertion.assertAll();

		}
	
	public void AgreementTermsvalidationMsg(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
		      //  ExtentTestManager.info("Import Validations");
		          assertion.assertTrue(util.isElementPresent(AgreementNonotexist, 30), "Error for agreement not found does not display");
	        	//ExtentTestManager.info("Validation 1 : validation Msg successfully display when Parcel # kept blank");
	        	
		          assertion.assertTrue(util.isElementPresent(blankAgreementNo, 30), "Blank Agreement error does not display");
		       // ExtentTestManager.info("Validation 2 : validation Msg successfully display when imported Parcel # does not exists in the selected project");
		          
		          assertion.assertTrue(util.isElementPresent(blankAgreementtype, 30), "Blank Agreement term type error does not display");
			    // ExtentTestManager.info("Validation 2 : validation Msg successfully display when imported Parcel # does not exists in the selected project");
					
		          assertion.assertTrue(util.isElementPresent(blankeffectivedate, 30), "Blank Effective Date error does not display");
				 // ExtentTestManager.info("Validation 2 : validation Msg successfully display when imported Parcel # does not exists in the selected project");
		          
		           assertion.assertAll();

		}
	
	By Keydatenamenotexist = By.xpath("(//*[contains(text(),'Key Date') and contains(text(),'does not exist on')])[1]");
	
	public void KeyDatesvalidationMsg(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
		      //  ExtentTestManager.info("Import Validations");
		          assertion.assertTrue(util.isElementPresent(Keydatenamenotexist, 30), "Error for key date name not found");
	        	//ExtentTestManager.info("Validation 1 : validation Msg successfully display when Parcel # kept blank");
	        	
		       		      
		           assertion.assertAll();

		}
	
	By invalidhomephone = By.xpath("//*[contains(text(),'Home Phone') and contains(text(),'is invalid')]");
	By invalidcellphone = By.xpath("//*[contains(text(),'Cell Phone') and contains(text(),'is invalid')]");
	By invalidfaxno = By.xpath("//*[contains(text(),'Fax Number') and contains(text(),'is invalid')]");
	By invalidworkphone = By.xpath("//*[contains(text(),'Work Phone') and contains(text(),'is invalid')]");
	
	public void contactvalidationMsg(String testcaseName) {	
		SoftAssert assertion = new SoftAssert();
		    
		          assertion.assertTrue(util.isElementPresent(invalidhomephone, 30), "Error for invalid Home Phone not found");
		          
		          assertion.assertTrue(util.isElementPresent(invalidcellphone, 30), "Error for invalid Cell Phone not found");
		          
		          assertion.assertTrue(util.isElementPresent(invalidfaxno, 30), "Error for invalid Fax Number not found");
		          
		          assertion.assertTrue(util.isElementPresent(invalidworkphone, 30), "Error for invalid Work Phone not found");
	        	
		       		      
		           assertion.assertAll();

		}

	public void specialConditionsvalidationMsg(String testcaseName) {	
		
		
				assertion.assertTrue(util.isElementPresent(tractNotExists, 30), "Tract Not Exists error does not display");
				
				assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non configured values");
				
				assertion.assertTrue(util.isElementPresent(startDateInvalid, 30), "Error does not display for Invalid Start Date");
				
				assertion.assertTrue(util.isElementPresent(endDateInvalid, 30), "Error does not display for Invalid End Date");
				
				assertion.assertTrue(util.isElementPresent(nextDueDateInvalid, 30), "Error does not display for Invalid Next Due Date");
				
				assertion.assertTrue(util.isElementPresent(dateApprovedInvalid, 30), "Error does not display for Invalid Date Approved");
				
				assertion.assertAll();
		}
	
	public void rowDimensionsvalidationMsg(String testcaseName) {	
		
		
		assertion.assertTrue(util.isElementPresent(tractNotExists, 30), "Tract Not Exists error does not display");
		
		assertion.assertTrue(util.isElementPresent(tractRequired, 30), "Tract # Required error does not display");
		
		assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non configured values");
		
		assertion.assertTrue(util.isElementPresent(lengthNonNumeric, 30), "Error does not display for Non numeric length value");
		
		assertion.assertTrue(util.isElementPresent(widthNonNumeric, 30), "Error does not display for Non numeric width value");
		
		assertion.assertAll();
       }

    public void projectNotesvalidationMsg(String testcaseName) {	
		
		
		assertion.assertTrue(util.isElementPresent(invalidChildCategory, 30), "Error does not display for Invalid Child Category");
		
		assertion.assertAll();
        }
    
    public void legalDescriptionvalidationMsg(String testcaseName) {	
		
		
		assertion.assertTrue(util.isElementPresent(tractNoBlank, 30), "Error does not display for Blank Tract No");
		
		assertion.assertTrue(util.isElementPresent(tractNotExists, 30), "Error does not display for Non Existing Tract");
		
		assertion.assertAll();
        }
 
    public void landownervalidationMsg(String testcaseName) {	
		
		
		assertion.assertTrue(util.isElementPresent(tractRequired, 30), "Error does not display for Blank Tract No");
		
		assertion.assertTrue(util.isElementPresent(tractNotExists, 30), "Error does not display for Non Existing Tract");
		
		assertion.assertTrue(util.isElementPresent(nonExistingDDValue, 30), "Error does not display for Non Existing DD Values");
		
		assertion.assertTrue(util.isElementPresent(invalidState, 30), "Error does not display for Invalid State value");
		
		assertion.assertTrue(util.isElementPresent(invalidCounty, 30), "Error does not display for Invalid County value");
		
		assertion.assertTrue(util.isElementPresent(invalidPerOwnership, 30), "Error does not display for Invalid Percent Ownership value");
		
		assertion.assertTrue(util.isElementPresent(invalidPreferredContact, 30), "Error does not display for Invalid Primary Contact value");
		
		assertion.assertTrue(util.isElementPresent(invalidPrimaryValue, 30), "Error does not display for Invalid Primary On value");
		
		assertion.assertTrue(util.isElementPresent(invalidEmail, 30), "Error does not display for Invalid Email");
		
		assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for Non Existing values");
		
		assertion.assertAll();
        }
 
        }
