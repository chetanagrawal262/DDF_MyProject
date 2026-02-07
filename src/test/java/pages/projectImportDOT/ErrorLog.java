package pages.projectImportDOT;

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
	
	By tractRequired = By.xpath("(//*[contains(text(),'Parcel # is required')])[1] | (//*[contains(text(),'Parcel # is Required')])[1] | (//*[contains(text(),'Tract # is required')])[1]");
	By tractNotExists = By.xpath("(//*[contains(text(),'Tract #') and contains(text(),'does not exist within the selected project')])[1] | (//*[contains(text(),'Parcel #') and contains(text(),'does not exist within the selected project')])[1]");
	By invalidAgentName = By.xpath("(//*[contains(text(),'Invalid Agent Name')])[1]");
	By invalidCategory = By.xpath("(//*[contains(text(),'Type Category selection(s) listed are invalid')])[1]");
	By invalidSubCategory = By.xpath("(//*[contains(text(),'Type Sub Category selection(s) listed are invalid')])[1]");
	By invalidDateFormat = By.xpath("(//*[contains(text(),'Activity Date') and contains(text(),'is not a valid date. Please enter the date in MM/DD/YYYY format')])[1]");
	By valueNotExists = By.xpath("(//*[contains(text(),'does not match existing value in application')])[1] | (//*[contains(text(),'does not match existing  values in application')])[1]");
	By valueNotConfigure = By.xpath("(//*[contains(text(),'does not match configured value in application')])[1]");
	By nameBlank = By.xpath("(//*[contains(text(),'Name cannot be blank for Parcel #')])[1]");
	By nonExistingDDValue = By.xpath("(//*[contains(text(),'does NOT match existing DD value')])[1]");
	By invalidState = By.xpath("(//*[contains(text(),'State value') and contains(text(),'is not valid')])[1] | (//*[contains(text(),'State Value') and contains(text(),'is not valid')])[1]");
	By invalidCounty = By.xpath("(//*[contains(text(),'County Value') and contains(text(),'is not valid for the state')])[1]");
	By invalidPerOwnership = By.xpath("(//*[contains(text(),'Percent Ownership value') and contains(text(),'is invalid')])[1]");
	By nonNumaricValue = By.xpath("(//*[contains(text(),'There are non numaric value in')])[1]");
	By invalidPreferredContact = By.xpath("(//*[contains(text(),'Preferred contact Value') and contains(text(),'is invalid')])[1]");
	By invalidPrimaryValue = By.xpath("(//*[contains(text(),'Primary on Value') and contains(text(),'is invalid')])[1]");
	By invalidEmail = By.xpath("(//*[contains(text(),'Email') and contains(text(),'is invalid')])[1]");
	By invalidPhone = By.xpath("(//*[contains(text(),'Phone') and contains(text(),'is invalid')])[1]");
	By msgError = By.xpath("//*[contains(@id,'rgDataMigrationErorLog_radYALGridControl')]/td[4]");
	
	int count = 0;
	
	public void printErrorLog() {
		List<WebElement> error = driver.findElements(msgError);
		for(WebElement var: error) {
			count++;
			ExtentTestManager.info("Error_Msg " +count+" : "+ var.getText());
		}
	}
	
	public void parcelImportValidationMsg(String testcaseName) {	
		
		        assertion.assertTrue(util.isElementPresent(tractRequired, 30), "Parcel # required error does not display");
				
				assertion.assertTrue(util.isElementPresent(valueNotConfigure, 30), "Error does not display for non configured values");
				
				assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for non existing values");
			
				assertion.assertAll();
		}
	
	public void AgentNotesValidationMsg(String testcaseName) {	
		
        assertion.assertTrue(util.isElementPresent(tractRequired, 30), "Tract # required error does not display");
		
		assertion.assertTrue(util.isElementPresent(tractNotExists, 30), "Error does not display for non existsting Tract #");
		
		assertion.assertTrue(util.isElementPresent(invalidAgentName, 30), "Error does not display for invalid Agent Name");
	
		assertion.assertTrue(util.isElementPresent(invalidCategory, 30), "Error does not display for invalid Category");
		
		assertion.assertTrue(util.isElementPresent(invalidSubCategory, 30), "Error does not display for invalid  Sub Category");
		
		assertion.assertTrue(util.isElementPresent(invalidDateFormat, 30), "Error does not display for invalid  Activity Date Format");
		
		assertion.assertAll();
    }
	
     public void landownerValidationMsg(String testcaseName) {	
		
		
		assertion.assertTrue(util.isElementPresent(tractRequired, 30), "Error does not display for Blank Tract No");
		
		assertion.assertTrue(util.isElementPresent(tractNotExists, 30), "Error does not display for Non Existing Tract");
		
		assertion.assertTrue(util.isElementPresent(nameBlank, 30), "Error does not display for Blank Entity Name");
		
		assertion.assertTrue(util.isElementPresent(nonExistingDDValue, 30), "Error does not display for Non Existing DD Values");
		
		assertion.assertTrue(util.isElementPresent(invalidState, 30), "Error does not display for Invalid State value");
		
		assertion.assertTrue(util.isElementPresent(invalidCounty, 30), "Error does not display for Invalid County value");
		
		assertion.assertTrue(util.isElementPresent(invalidPerOwnership, 30), "Error does not display for Invalid Percent Ownership value");
		
		assertion.assertTrue(util.isElementPresent(invalidPrimaryValue, 30), "Error does not display for Invalid Primary On value");
		
		assertion.assertTrue(util.isElementPresent(nonNumaricValue, 30), "Error does not display for non Numaric phone values");
		
		assertion.assertTrue(util.isElementPresent(invalidEmail, 30), "Error does not display for Invalid Email");
		
		assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for Non Existing values");
		
		assertion.assertAll();
        }
	
     public void contactValidationMsg(String testcaseName) {	
 		
 		
 		assertion.assertTrue(util.isElementPresent(tractRequired, 30), "Error does not display for Blank Tract No");
 		
 		assertion.assertTrue(util.isElementPresent(tractNotExists, 30), "Error does not display for Non Existing Tract");
 		
 		assertion.assertTrue(util.isElementPresent(nameBlank, 30), "Error does not display for Blank Entity Name");
 		
 		assertion.assertTrue(util.isElementPresent(nonExistingDDValue, 30), "Error does not display for Non Existing DD Values");
 		
 		assertion.assertTrue(util.isElementPresent(invalidState, 30), "Error does not display for Invalid State value");
 		
 		assertion.assertTrue(util.isElementPresent(invalidPhone, 30), "Error does not display for Invalid phone values");
 		
 		assertion.assertTrue(util.isElementPresent(invalidEmail, 30), "Error does not display for Invalid Email");
 		
 		assertion.assertTrue(util.isElementPresent(valueNotExists, 30), "Error does not display for Non Existing values");
 		
 		assertion.assertAll();
         }
	
        
     By Keydatenamenotexist = By.xpath("(//*[contains(text(),'Key Date') and contains(text(),'does not exist on')])[1]");
     By parcelNotExists = By.xpath("(//*[contains(text(),'Parcel #') and contains(text(),'does not exist within the selected project')])[1]");
     By dateNotBlank	= By.xpath("(//*[contains(text(),'Date Name cannot be blank.')])[1]");
     By expectedDateNotValid	= By.xpath("(//*[contains(text(),'Expected Date') and contains(text(),'is not a valid date. Please enter the date in MM/DD/YYYY format')])[1]");
     By actualDateNotValid	= By.xpath("(//*[contains(text(),'Actual Date') and contains(text(),'is not a valid date. Please enter the date in MM/DD/YYYY format')])[1]");


     public void KeyDatesvalidationMsg(String testcaseName) {	
	
   
	assertion.assertTrue(util.isElementPresent(Keydatenamenotexist, 30), "Error for key date name not found");
	
	assertion.assertTrue(util.isElementPresent(parcelNotExists, 30), "Error does not display for non existsting parcel #");
	
	assertion.assertTrue(util.isElementPresent(dateNotBlank, 30), "Error does not display for Date Name cannot be blank");
	
	assertion.assertTrue(util.isElementPresent(expectedDateNotValid, 30), "Error does not display for Expected Date not valid");
	
	
	
	assertion.assertAll();
      }

     public void ProjectNotesValidationMsg(String testcaseName) {	
		
        assertion.assertTrue(util.isElementPresent(tractRequired, 30), "Tract # required error does not display");
		
		assertion.assertTrue(util.isElementPresent(tractNotExists, 30), "Error does not display for non existsting Tract #");
		
		assertion.assertTrue(util.isElementPresent(invalidAgentName, 30), "Error does not display for invalid Agent Name");
	
		assertion.assertTrue(util.isElementPresent(invalidCategory, 30), "Error does not display for invalid Category");
		
		assertion.assertTrue(util.isElementPresent(invalidSubCategory, 30), "Error does not display for invalid  Sub Category");
		
		assertion.assertTrue(util.isElementPresent(invalidDateFormat, 30), "Error does not display for invalid  Activity Date Format");
		
		assertion.assertAll();
       }  
}
