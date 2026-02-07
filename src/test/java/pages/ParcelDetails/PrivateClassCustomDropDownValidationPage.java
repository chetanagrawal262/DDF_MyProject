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

public class PrivateClassCustomDropDownValidationPage extends BasePage {
	TestUtil util;
	CommonFunction commonFunction;
	public static String PAGES;
	SoftAssert sa = new SoftAssert();

	public PrivateClassCustomDropDownValidationPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	// Navigation
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navParcelInformation = By.xpath("//span[contains(text(),'Parcel Information')] | //span[contains(text(),'Tract Information')] | //span[contains(text(),'Record Information')]");
	// add Parcel
	By privatePT = By.xpath("(//strong[text()='Private']/../..)[1]");
	By txtParcelNo = By.xpath("//input[contains(@id,'TractType_TRACT_NUMBER') and @type='text']");
	By drpState = By.xpath("//input[contains(@id,'_TractType_STATE_Input') and @type='text']");
	By btnSave = By.xpath("//input[contains(@id,'_TractType_btnInternalSave')]");
	By drpApplicationType = By.xpath("//*[contains(text(),'Application/Request Type')]/..//input[@type='text']");
	By drpAgreementType = By.xpath("//*[contains(text(),'Agreement Type')]/..//input[@type='text']");
	// Private Land Class Custom Control Fields
	By drpPrivateLandJurisdiction = By.xpath("//*[contains(text(),'Private Land Jurisdiction')]/..//input[@type='text']");
	By drpConfigIconPrivateLandJurisdiction = By.xpath("//*[contains(text(),'Private Land Jurisdiction')]/..//span[contains(@id,'_ManageComboID')]");
	By btnDesignMode = By.xpath("//input[contains(@id,'btnDesignModeOff') and @type='image']");
	By drpConfigIconApplicationType = By.xpath("//*[contains(text(),'Request Type')]/..//span[contains(@id,'_ManageComboID')]");
	By drpConfigIconAgreementType = By.xpath("//*[contains(text(),'Agreement Type')]/..//span[contains(@id,'_ManageComboID')]");
	By colLookUpValue = By.xpath("//a[text()='LOOKUP_VALUE']");
	By gridConfig = By.xpath("//span[@title='Grid Configuration']");
	By checkboxDisplayLookUpValue = By.xpath("(//*[text()='LOOKUP_VALUE']/..//input[@type='checkbox' and contains(@id,'Display')])[2]");
	By btnUpdate = By.xpath("//*[@id='idManage_UPDATE']");
	By btnRefresh = By.xpath("//img[@alt='refresh']");
	By pages = By.xpath("//table[contains(@summary,'Data pager')]/..//strong[2]");
	 By firstDDValue = By.xpath("(//*[contains(@id,'_YALComboBox_DropDown')]/..//li[1])[1]");

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
		util.waitUntilLoaderDisappearValard();
		util.dummyWait(2);

	}

	By CheckOntarioStateValues = By.xpath("//*[contains(text(),'Ontario')]");
	public static List<String> OntarioStateJurisdictionValues = new ArrayList<String>();

	public List<String> ontarionStateJurisdictionDDValues() {
		List<WebElement> lst = driver.findElements(CheckOntarioStateValues);

		for (WebElement e : lst) {
			OntarioStateJurisdictionValues.add(e.getText().replace("Ontario", ""));
		}
		return OntarioStateJurisdictionValues;
	}

	By CheckOntarioStateATValues = By.xpath("//*[contains(text(),'- ON')]");
	public static List<String> OntarioStateATValuesList = new ArrayList<String>();

	public List<String> ontarionStateApplicationTypeValues() {
		List<WebElement> lst = driver.findElements(CheckOntarioStateATValues);

		for (WebElement e : lst) {
			OntarioStateATValuesList.add(e.getText().replace("- ON", ""));
		}
		return OntarioStateATValuesList;
	}

	By CheckBCStateValues = By.xpath("//*[contains(text(),'British Columbia')]");
	public static List<String> BCStateJurisdictionValues = new ArrayList<String>();

	public List<String> BCStateJurisdictionDDValues() {
		List<WebElement> lst = driver.findElements(CheckBCStateValues);

		for (WebElement e : lst) {
			BCStateJurisdictionValues.add(e.getText().replace("British Columbia", ""));
		}
		return BCStateJurisdictionValues;
	}

	By CheckBCStateATValues = By.xpath("//*[contains(text(),'- BC')]");
	public static List<String> BCStateATValuesList = new ArrayList<String>();

	public List<String> BCStateApplicationTypeValues() {
		List<WebElement> lst = driver.findElements(CheckBCStateATValues);

		for (WebElement e : lst) {
			BCStateATValuesList.add(e.getText().replace("- BC", ""));
		}
		return BCStateATValuesList;
	}

	By damageRelease = By.xpath("//li[text()='Damage Release']");
	By leaseAgreement = By.xpath("//li[text()='Lease Agreement']");
	By permanentAccess = By.xpath("//li[text()='Permanent Access']");
	By reclamationRelease = By.xpath("//li[text()='Reclamation Release']");
	By temporaryAccess = By.xpath("//li[text()='Temporary Access']");
	By temporaryWorkspace = By.xpath("//li[text()='Temporary Workspace']");
	By utilityROWA = By.xpath("//li[text()='Utility Right-of-Way Agreement']");
	
	public void verifyONPLAgreementTypeValues() {
	    sa.assertTrue(util.isElementVisible(damageRelease, 2), "Value Damage Release is not visible in the DD");
		sa.assertTrue(util.isElementVisible(leaseAgreement, 2), "Value Lease Agreement is not visible in the DD");
		sa.assertTrue(util.isElementVisible(permanentAccess, 2), "Value Permanent Access is not visible in the DD");
		sa.assertTrue(util.isElementVisible(reclamationRelease, 2), "Value Reclamation Release is not visible in the DD");
		sa.assertTrue(util.isElementVisible(temporaryAccess, 2), "Value Temporary Access is not visible in the DD");
		sa.assertTrue(util.isElementVisible(temporaryWorkspace, 2), "Value Temporary Workspace is not visible in the DD");
		sa.assertTrue(util.isElementVisible(utilityROWA, 2), "Value Utility Right-of-Way Agreement is not visible in the DD");
		util.click(utilityROWA);
	}
	
	
	public void verifyCustomDDValues(String testcaseName) {
		//navigateParcelInformation();

		try {
			util.click(privatePT);
			util.waitUntilLoaderDisappearValard();
    		util.dummyWait(2);
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
			log("STEP 5: user cannot click on DropDown Configuration Icon of Private Land Jurisdiction DD ",Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}

		try {
			util.switchToChildWindow();
			ExtentTestManager.infoWithScreenshot("Private Land Jurisdiction DD Configuration Values");
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
			for (String var : OntarioStateJurisdictionValues) {
				System.out.println(var);
				By expectedValue = By.xpath("//li[text()='" + var.trim() + "']");

				util.highlightElement(driver.findElement(By.xpath("(//li[text()='" + var.trim() + "'])[1]")));
				sa.assertTrue(util.isElementVisible(expectedValue, 5), "Value " + var + " is not visible in the DD");

			}
			log("STEP 7:  user can see all Ontario State Jurisdiction values list in the Private Land Jurisdiction DD",
					Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot see all Ontario State Jurisdiction values list in the Private Land Jurisdiction DD",
					Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}

		try {
			util.click(drpConfigIconApplicationType);
			log("STEP 8:  user can click on DropDown Configuration Icon of Application/Request Type DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user cannot click on DropDown Configuration Icon of Application/Request Type DD ",
					Status.FAIL);
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
			for (String var : OntarioStateATValuesList) {
				System.out.println(var);
				By expectedValue = By.xpath("//li[text()='" + var.trim() + "']");
				util.highlightElement(driver.findElement(By.xpath("(//li[text()='" + var.trim() + "'])[1]")));
				sa.assertTrue(util.isElementVisible(expectedValue, 5), "Value " + var + " is not visible in the DD");
			}
			log("STEP 10:  user can see all Ontario State related Application Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user cannot see all Ontario State related Application Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}

			try {
				util.click(drpPrivateLandJurisdiction);
				By firstValue = By.xpath("(//li[contains(text(),'Private Land')])[1]");
				util.click(firstValue);
				log("STEP 11:  user can select Private Land Jurisdiction DD Value",Status.PASS);
			} catch (Exception e) {
				log("STEP 11: user cannot select Private Land Jurisdiction DD Value",Status.FAIL);
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
				verifyONPLAgreementTypeValues();
				log("STEP 13:  user can see list of ON-PL Agreement Type values in the DD", Status.PASS);
			} catch (Exception e) {
				log("STEP 13: user cannot see list of ON-PL Agreement Type values in the DD", Status.FAIL);
				throw new RuntimeException("Failed in step 13");
			}
		

			try {
				clickOnSave();
				log("STEP 14:  user can Save Agreement Type value",Status.PASS);
			} catch (Exception e) {
				log("STEP 14: user cannot Save Agreement Type value",Status.FAIL);
				throw new RuntimeException("Failed in step 14");
			}
			
    	try {
			selectState("British Columbia");
			log("STEP 15:  user can select British Columbia State for Private Class ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: user cannot select British Columbia State for Private Class", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
    	
    	try {
    		clickOnSave();
			log("STEP 16: User can click on Save button", Status.PASS);
		} catch (Exception e) {
			log("STEP 16:   User cannot click on Save button ", Status.FAIL);
			throw new RuntimeException("Failed in step 16");
		}
    	
    	try {
			util.click(drpConfigIconPrivateLandJurisdiction);
			log("STEP 17:  user can click on DropDown Configuration Icon of Private Land Jurisdiction DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user cannot click on DropDown Configuration Icon of Private Land Jurisdiction DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
    	
    	try {
			util.switchToChildWindow();
			BCStateJurisdictionDDValues();
			log("STEP 18:  user can get British Columbia State Jurisdiction values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 18: user cannot get British Columbia State Jurisdiction values list", Status.FAIL);
			throw new RuntimeException("Failed in step 18");
		}
    	
    	try {
    		driver.close();
			util.switchToParentWindow();
			util.click(drpPrivateLandJurisdiction);
			for(String var: BCStateJurisdictionValues) {
				System.out.println(var);
				        By expectedValue = By.xpath("//li[text()='"+var.trim()+"']");
				        
						util.highlightElement(driver.findElement(By.xpath("(//li[text()='"+var.trim()+"'])[1]")));
						sa.assertTrue(util.isElementVisible(expectedValue, 5), "Value "+var+" is not visible in the DD");
						
				}
			log("STEP 19:  user can see all British Columbia State Jurisdiction values list in the Private Land Jurisdiction DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: user cannot see all British Columbia State Jurisdiction values list in the Private Land Jurisdiction DD", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
    	
    	try {
			util.click(drpConfigIconApplicationType);
			log("STEP 20:  user can click on DropDown Configuration Icon of Application/Request Type DD ", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: user cannot click on DropDown Configuration Icon of Application/Request Type DD ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
    	
    	try {
			util.switchToChildWindow();
			BCStateApplicationTypeValues();
			log("STEP 21:  user can get British Columbia State Application Type values list", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: user cannot get British Columbia State Application Type values list", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
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
			log("STEP 22:  user can see all British Columbia State related Application Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 22: user cannot see all British Columbia State related Application Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 22");
		}
    	
    	try {
			util.click(drpPrivateLandJurisdiction);
			By firstValue = By.xpath("(//li[contains(text(),'Private Land')])[1]");
			util.click(firstValue);
			log("STEP 23:  user can select Private Land Jurisdiction DD Value",Status.PASS);
		} catch (Exception e) {
			log("STEP 23: user cannot select Private Land Jurisdiction DD Value",Status.FAIL);
			throw new RuntimeException("Failed in step 23");
		}

		try {
			clickOnSave();
			log("STEP 24:  user can click on Save button",Status.PASS);
		} catch (Exception e) {
			log("STEP 24: user cannot click on Save button",Status.FAIL);
			throw new RuntimeException("Failed in step 24");
		}
		
		try {
			util.click(drpAgreementType);
			verifyONPLAgreementTypeValues();
			log("STEP 25:  user can see list of BC-PL Agreement Type values in the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 25: user cannot see list of BC-PL Agreement Type values in the DD", Status.FAIL);
			throw new RuntimeException("Failed in step 25");
		}
	

		try {
			clickOnSave();
			sa.assertAll();
			log("STEP 26:  user can click on Save Agreement Type value",Status.PASS);
		} catch (Exception e) {
			log("STEP 26: user cannot click on Save Agreement Type value",Status.FAIL);
			throw new RuntimeException("Failed in step 26");
		}
	}

}
