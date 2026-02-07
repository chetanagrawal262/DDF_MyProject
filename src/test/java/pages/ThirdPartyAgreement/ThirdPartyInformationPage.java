package pages.ThirdPartyAgreement;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class ThirdPartyInformationPage extends BasePage {
	
	TestUtil util;
	CommonFunction commonFunction;
	Actions action;
	public static String CROSSING_NUMBER, CROSSING_STATUS;
	public ThirdPartyInformationPage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navProjectMenu = By.xpath("//a//span[@class='rmText rmExpandDown' and contains(text(),'Project')] ");
	By navThirdPartyAgreements = By.xpath("//a//span[contains(text(),'Third Party Agreements')] ");
	By buttonAddNewCrossing = By.xpath("//*[@id='ctl00_ConPHLeftTop_CrossList_RadGridTracts_ctl00']//a[contains(@id,'AddJob')]");
	By txtCrossingNumber = By.xpath("//input[contains(@id,'OBJPROJECTINFO_CROSSING_NUMBER') and @type='text']");
	By drpCrossingStatus = By.xpath("//input[contains(@id,'_OBJPROJECTINFO_CROSSING_STATUS_radYALDropDownList_Input') and @type='text']");
	By drpGrantee = By.xpath("//input[contains(@id,'_OBJPROJECTINFO_ddlGrantee_radYALDropDownList_Input') and @type='text']");
	By buttonSave = By.xpath("//input[contains(@id,'_btnSaveProject')]");
	By successMessage = By.xpath("//span[text()='Save successful']");
	By txtHistoricalGrantee = By.xpath("//span[text()='Historical Grantee:']/..//input[@type='text']");
	
	public void navigateToThirdPartyAgreement() {
		util.waitUntilElementDisplay(navProjectMenu);
		util.click(navProjectMenu);
		util.waitUntilElementDisplay(navThirdPartyAgreements);
		util.click(navThirdPartyAgreements);
		util.waitUntilPageLoad();
	}
	
	public void clickOnAddNew() {
		util.waitUntilElementDisplay(buttonAddNewCrossing);
		util.click(buttonAddNewCrossing);
		util.waitUntilPageLoad();
	}
	
	public void AddCrossingNumber(String crossingNumber) {
		util.waitUntilElementDisplay(txtCrossingNumber);
		CROSSING_NUMBER = util.randomNumber();
		util.inputTextAndPressTab(txtCrossingNumber, CROSSING_NUMBER);
	}
	
	public void selectCrossingStatus(String status) {
	    util.waitUntilElementDisplay(drpCrossingStatus);
	    util.inputTextAndPressTab(drpCrossingStatus, status);
	}

	public void selectGrantee(String grantee) {
	    util.waitUntilElementDisplay(drpGrantee);
	    util.inputTextAndPressTab(drpGrantee, grantee);
	}

	public void clickOnSave() {
		util.waitUntilElementDisplay(buttonSave);
		util.click(buttonSave);
		util.waitUntilPageLoad();
	}
	
	public void addNewCrossing(Map<String, String> map, String testCaseName) {
		
		try {
			navigateToThirdPartyAgreement();
			commonFunction.projectSelection();
			util.waitUntilPageLoad();
			log("STEP 1: User can navigate to Menu -Third Party Agreements", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to Menu -Third Party Agreements", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			clickOnAddNew();
			log("STEP 2: User can click on Add New Crossing icon", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot click on Add New Crossing icon", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
		    AddCrossingNumber(map.get(Excel.CrossingNumber));
		    log("STEP 3: User can enter Crossing Number", Status.PASS);
		} catch (Exception e) {
		    log("STEP 3: User cannot enter Crossing Number", Status.FAIL);
		    throw new RuntimeException("Failed in step 3");
		}

		try {
			selectCrossingStatus(map.get(Excel.AgreementStatus));
		    CROSSING_STATUS = map.get(Excel.AgreementStatus);
		    log("STEP 4: User can select Agreement Status", Status.PASS);
		} catch (Exception e) {
		    log("STEP 4: User cannot select Agreement Status", Status.FAIL);
		    throw new RuntimeException("Failed in step 4");
		}

		try {
		    selectGrantee(map.get(Excel.Grantee));
		    log("STEP 5: User can select Grantee", Status.PASS);
		} catch (Exception e) {
		    log("STEP 5: User cannot select Grantee", Status.FAIL);
		    throw new RuntimeException("Failed in step 5");
		}
		
		try {
			   Assert.assertFalse(util.isElementVisible(txtHistoricalGrantee));
			    log("STEP 6: User cannot see Historical Grantee Field", Status.PASS);
			} catch (AssertionError e) {
			    log("STEP 6: User can see Historical Grantee Field", Status.FAIL);
			}
		

		try {
		    clickOnSave();
		    log("STEP 7: User can click on Save", Status.PASS);
		} catch (Exception e) {
		    log("STEP 7: User cannot click on Save", Status.FAIL);
		    throw new RuntimeException("Failed in step 7");
		}
		
		try {
		   Assert.assertTrue(util.isElementVisible(successMessage));
		    log("STEP 8: User can see Success Message", Status.PASS);
		} catch (AssertionError e) {
		    log("STEP 8: User cannot see Success Message", Status.FAIL);
		}
		}

	
	By txtGrantor = By.xpath("//textarea[contains(@id,'_CROSSGRANT_GRANTOR')]");
	By txtGrantee = By.xpath("//textarea[contains(@id,'_CROSSGRANT_GRANTEE')]");
	By buttonSaveGrantor = By.xpath("//input[contains(@id,'_CROSSGRANT_btnSaveGrant')]");
	By successMessageGrantor = By.xpath("//span[text()='Changes saved successfully!']");
	
	public void enterGrantor(String grantor) {
	    util.waitUntilElementDisplay(txtGrantor);
	    util.inputTextAndPressTab(txtGrantor, grantor);
	}

	public void enterGrantee(String grantee) {
	    util.waitUntilElementDisplay(txtGrantee);
	    util.inputTextAndPressTab(txtGrantee, grantee);
	}

	public void clickSaveGrantor() {
	    util.waitUntilElementDisplay(buttonSaveGrantor);
	    util.click(buttonSaveGrantor);
	    util.waitUntilPageLoad();
	}

	public void verifyGrantorSuccessMessage() {
	    Assert.assertTrue(util.isElementVisible(successMessageGrantor));
	}
	
	public void addGrantorGranteeDetails(Map<String, String> map, String testCaseName) {
	    try {
	        enterGrantor(map.get(Excel.Grantor));
	        log("STEP 1: User can enter Grantor", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 1: User cannot enter Grantor", Status.FAIL);
	        throw new RuntimeException("Failed in step 1");
	    }

	    try {
	        enterGrantee(map.get(Excel.Grantee));
	        log("STEP 2: User can enter Grantee", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 2: User cannot enter Grantee", Status.FAIL);
	        throw new RuntimeException("Failed in step 2");
	    }

	    try {
	        clickSaveGrantor();
	        log("STEP 3: User can Save Grantor", Status.PASS);
	    } catch (Exception e) {
	        log("STEP 3: User cannot Save Grantor", Status.FAIL);
	        throw new RuntimeException("Failed in step 3");
	    }

	    try {
	        verifyGrantorSuccessMessage();
	        util.scrollDownToPage();
	        log("STEP 4: User can see Grantor Success Message", Status.PASS);
	    } catch (AssertionError e) {
	        log("STEP 4: User cannot see Grantor Success Message", Status.FAIL);
	    }
	}
}
