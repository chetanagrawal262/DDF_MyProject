package pages.projectImportORSTED;

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
	
	By parcelNotFound = By.xpath("(//*[contains(text(),'Parcel #') and contains(text(),'could not be found within selected project.')])[1]");
	By invalidEstAmt = By.xpath("(//*[contains(text(),'Estimate Amount') or contains(text(),'Estimate Quantity') and contains(text(),'is not in the supported format.')])[1]");
	By invalidSurveyAmt = By.xpath("(//*[contains(text(),'Survey Amount') or contains(text(),'As-Built Quantity') and contains(text(),'is not in the supported format.')])[1]");
	By blankParcel = By.xpath("(//*[contains(text(),'Parcel # cannot be blank')])[1]");
	By estTypeNotExist = By.xpath("(//*[contains(text(),'Easement Type') and contains(text(),'does not match existing value in application.')])[1]");
	By blankFinancialClass = By.xpath("(//*[contains(text(),'Financial Class cannot be blank.')])[1]");
	By invalidDateFormat = By.xpath("(//*[contains(text(),'Date format is wrong') and contains(text(),'Please correct the date format and try again (MM/DD/YYYY)')])[1]");
	By turbinealreadyexist = By.xpath("(//*[contains(text(),'Turbine') and contains(text(),'already exists with the same turbine name on parcel')])[1]");
	By turbinealreadyexistOnParcel = By.xpath("(//*[contains(text(),'A turbine already exists on parcel') and contains(text(),'Please reverify your turbine import; if you want to proceed, select ')])[1]");
	By msgError = By.xpath("//*[contains(@id,'rgDataMigrationErorLog_radYALGridControl')]/td[4]");
	
	int count = 0;
	
	public void printErrorLog() {
		List<WebElement> error = driver.findElements(msgError);
		for(WebElement var: error) {
			count++;
			ExtentTestManager.info("Error_Msg " +count+" : "+ var.getText());
		}
	}
	

public void FacilitiesDatavalidationMsg(String testcaseName) {	
	
   
	assertion.assertTrue(util.isElementPresent(parcelNotFound, 30), "Error does not display for parcel not found on selected Project");
	
	assertion.assertTrue(util.isElementPresent(invalidEstAmt, 30), "Error does not display for non supporting Estimate Amount/Quantity");
	
	assertion.assertTrue(util.isElementPresent(invalidSurveyAmt, 30), "Error does not display for non supporting Survey Amount/As-built Quantity");
	
	assertion.assertTrue(util.isElementPresent(blankParcel, 30), "Error does not display for parcel # Blank");
	
	assertion.assertTrue(util.isElementPresent(estTypeNotExist, 30), "Error does not display for Estimate type does not match");

	assertion.assertAll();
}

public void TurbineDatavalidationMsg(String testcaseName) {	
	
	if (testcaseName.contains("ORSTED")) {   
	assertion.assertTrue(util.isElementPresent(blankFinancialClass, 30), "Error does not display for Financial Class Blank");
	}
	assertion.assertTrue(util.isElementPresent(invalidDateFormat, 30), "Error for Date format is wrong");
	
	assertion.assertTrue(util.isElementPresent(blankParcel, 30), "Error does not display for parcel # Blank");
	
	if (testcaseName.contains("ORSTED")) {
	assertion.assertTrue(util.isElementPresent(turbinealreadyexist, 30), "Error for Turbine # does not already exist ");
	}
	assertion.assertAll();
}

By invalidStateCounty = By.xpath("(//*[contains(text(),'Invalid State-County pair entered. Please update the pair and try again')])[1]");
By blankOrstedPin = By.xpath("(//*[contains(text(),'Orsted PIN can not be blank.')])[1]");
By blankAgreementOperatingcompany = By.xpath("(//*[contains(text(),'Orsted PIN can not be blank.')])[1]");
public void landDatavalidationMsg(String testcaseName) {	
	
	   
	assertion.assertTrue(util.isElementPresent(invalidStateCounty, 30), "Error does not display for Invalid state county pair");
	
	assertion.assertTrue(util.isElementPresent(blankOrstedPin, 30), "Error does not display for blank orsted pin");
	
	assertion.assertTrue(util.isElementPresent(blankAgreementOperatingcompany, 30), "Error does not display for invalid agreement company value ");
	
	assertion.assertAll();
}


By stateNotMatch = By.xpath("(//*[contains(text(),'State') and contains(text(),'does not match configured value in application.')])[1]");
By surfaceOwnNotSupport = By.xpath("(//*[contains(text(),'Surface Ownership') and contains(text(),'is not in the supported format. This should be <= 100.00')])[1]");
By windOwnNotSupport = By.xpath("(//*[contains(text(),'Wind Ownership') and contains(text(),'is not in the supported format. This should be <= 100.00')])[1]");
By cropOwnNotSupport = By.xpath("(//*[contains(text(),'Crop Ownership') and contains(text(),'is not in the supported format. This should be <= 100.00')])[1]");
By blanklandownerName = By.xpath("(//*[contains(text(),'Landowner Name cannot be blank.')])[1] | (//*[contains(text(),'Landowner name is blank')])[1]");
By blankOrstedPIN = By.xpath("(//*[contains(text(),'Orsted PIN  cannot be blank.')])[1]");
By notFoundOrstedPIN = By.xpath("(//*[contains(text(),'Orsted PIN') and contains(text(),'could not be found within selected project.')])[1]");
	
public void landcontactvalidationMsg(String testcaseName) {	
	
	assertion.assertTrue(util.isElementPresent(stateNotMatch, 30), "Error does not display for State does not match");
	
	assertion.assertTrue(util.isElementPresent(surfaceOwnNotSupport, 30), "Error does not display for Surface Ownership is not in the supported format");
	
	assertion.assertTrue(util.isElementPresent(windOwnNotSupport, 30), "Error does not display for Wind Ownership is not in the supported format");
	
	assertion.assertTrue(util.isElementPresent(cropOwnNotSupport, 30), "Error does not display for Corp Ownership is not in the supported format");
	
	assertion.assertTrue(util.isElementPresent(blankOrstedPIN, 30), "Error does not display for Orsted PIN Blank");
	
	assertion.assertTrue(util.isElementPresent(blanklandownerName, 30), "Error does not display for blank Landowner Name");
	
	assertion.assertTrue(util.isElementPresent(notFoundOrstedPIN, 30), "Error does not display for Orsted PIN not found");

	assertion.assertAll();
}

public void AgreementTractsvalidationMsg(String testcaseName) {	
	
	assertion.assertTrue(util.isElementPresent(blankAgreementNo, 30), "Error does not display for blank Agreement #");
	
	assertion.assertTrue(util.isElementPresent(AgreementNonotexist, 30), "Error does not display for non existing Agreement #");
	
	assertion.assertTrue(util.isElementPresent(ParcelNonotexist, 30), "Error does not display for non existing Parcel #");
	
	assertion.assertTrue(util.isElementPresent(blankParcel, 30), "Error does not display for blank Parcel #");
		
	assertion.assertAll();
}

By agreementNoNotMatch = By.xpath("(//*[contains(text(),'Agreement Number  does not match existing value in application.')])[1]");
By invalidTermYr = By.xpath("(//*[contains(text(),'There are non-numeric values in Term Length (years)')])[1]");
By invalidTermMnth = By.xpath("(//*[contains(text(),'There are non-numeric values in Term Length (months)')])[1]");
By invalidTermDays = By.xpath("(//*[contains(text(),'There are non-numeric values in Term Length (Days)')])[1]");
By reqEffDate = By.xpath("(//*[contains(text(),'Effective Date required.')])[1]");

By blankAgreementNo = By.xpath("(//*[contains(text(),'Agreement #') and contains(text(),'cannot be blank')])[1] | (//*[contains(text(),'Agreement number is blank')])[1]");
By AgreementNonotexist = By.xpath("(//*[contains(text(),'Agreement #') and contains(text(),'does not exist on the project')])[1] | (//*[contains(text(),'Agreement Number') and contains(text(),'does not match existing value in application')])[1]");
By ParcelNonotexist = By.xpath("(//*[contains(text(),'Parcel #') and contains(text(),'does not exist on the project')])[1]");
By blankAgreementtype = By.xpath("(//*[contains(text(),'Agreement Term Type') and contains(text(),'cannot be blank')])[1]");
By blankeffectivedate = By.xpath("(//*[contains(text(),'Effective Date') and contains(text(),'cannot be blank')])[1]");

public void AgreementPhasevalidationMsg(String testcaseName) {	
	SoftAssert assertion = new SoftAssert();
		    	
	          assertion.assertTrue(util.isElementPresent(invalidDateFormat, 30), "Invalid Date format error does not display");
	          
	          assertion.assertTrue(util.isElementPresent(agreementNoNotMatch, 30), "Agreement Number Does Not Match error does not display");
	          
	          assertion.assertTrue(util.isElementPresent(invalidTermYr, 30), "non-numeric values in Term Length (years) error does not display");
	          
	          assertion.assertTrue(util.isElementPresent(invalidTermMnth, 30), "non-numeric values in Term Length (months) error does not display");
	          
	          assertion.assertTrue(util.isElementPresent(invalidTermDays, 30), "non-numeric values in Term Length (Days) error does not display");
	          
	          assertion.assertTrue(util.isElementPresent(reqEffDate, 30), "Effective Date required error does not display");
	          
			  assertion.assertAll();

	}

By agreementNot = By.xpath("(//*[contains(text(),'Effective Date') and contains(text(),'cannot be blank')])[1]");
public void agreementcontactvalidationMsg(String testcaseName) {	
	
	assertion.assertTrue(util.isElementPresent(blankAgreementNo, 30), "Error does not display for blank Agreement No");
	
	assertion.assertTrue(util.isElementPresent(blanklandownerName, 30), "Error does not display for blank Landowner Name");
	
	assertion.assertTrue(util.isElementPresent(AgreementNonotexist, 30), "Error does not display for non Existing Agreement");
	
	assertion.assertTrue(util.isElementPresent(stateNotMatch, 30), "Error does not display for non configured State value");

	assertion.assertAll();
}

}
