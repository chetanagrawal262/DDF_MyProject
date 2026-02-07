package pages.Project;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AddOpertaingCompanyPage extends BasePage {

	
	TestUtil util;
	CommonFunction commonFunction;
	public static String OPERATING_COMPANY;
	public AddOpertaingCompanyPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}

	By btnOperatingComapnies =  By.xpath("(//a[normalize-space()='Operating Companies'])[2]");
	By drpLesses = By.xpath("//input[contains(@id,'ProjectGrantees_GRANTEES_ID_OnDemand_Input')]");
	By btnAdd = By.xpath("//input[contains(@id,'ProjectGrantees_ImageButton1')]");
	By SuccessMessage = By.xpath("//span[contains(text(),'Selected grantees have been assigned!')]");
	
	public void setLesses(String value) {
		util.inputText(drpLesses, value);
		util.dummyWait(1);
		util.pressENTERkey();
	}
	public void clickAdd() {
		util.click(btnAdd);
		util.dummyWait(5);
		Assert.assertTrue(util.isElementPresent(SuccessMessage), "Selected grantees have been assigned!");
	}
	
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navConfiguration = By.xpath("//span[text()='Configuration']");
	By navOperatingCompanies = By.xpath("//span[contains(text(),'Operating Companies')]");
	public void NavigateToOperatingCompanies() {
		util.waitUntilElementDisplay(navAdministration);
		util.click(navAdministration);
		util.waitUntilElementDisplay(navConfiguration);
		util.click(navConfiguration);
		util.waitUntilElementDisplay(navOperatingCompanies);
		util.click(navOperatingCompanies);
	}
	By txtOpComp = By.xpath("(//table[contains(@id,'_GridDetails_radYALGridControl')]/..//td[count(//table/thead/tr/th[.='Company Name']/preceding-sibling::th)+1])[2]");
	
	public void addOperatingCompanies(Map<String, String> map) {
		try {
			NavigateToOperatingCompanies();
			OPERATING_COMPANY=driver.findElement(txtOpComp).getText();
			log("STEP 1: User can navigate to configuration > Operating companies", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: User cannot navigate to configuration > Operating companies", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		
		try {
			commonFunction.navigateToProjectDeails();
			commonFunction.projectSelection();
			log("STEP 2: User can navigate to Project Details", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: User cannot navigate to Project Details", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		try {
			util.click(btnOperatingComapnies);
			log("STEP 3: User can click on Operating Companies panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: User cannot click on operating companies panel  ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		
		try {
			setLesses(OPERATING_COMPANY);
			log("STEP 4: User can select Grantees from the DD", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: User cannot select Grantees from the DD  ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			clickAdd();
			log("STEP 5: User can click on Add button", Status.PASS);
		} catch (Exception e) {
			log("STEP 5: User not able to add operating company", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
	
	}

}
