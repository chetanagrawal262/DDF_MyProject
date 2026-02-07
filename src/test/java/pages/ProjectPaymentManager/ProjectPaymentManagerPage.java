package pages.ProjectPaymentManager;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

import extentReports.ExtentTestManager;

public class ProjectPaymentManagerPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public ProjectPaymentManagerPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navPaymentManager = By.xpath("//span[contains(text(),'Payment Manager')]");
	By SearchInformation = By.xpath("//span[contains(text(),'Search Information')]");
	By ExpandSearchOption = By.xpath("//em[text()='Search Options']/..//a[@title='Expand']");
	By btnPaymentNext = By.xpath("//input[contains(@id,'_btnOpenCommitments') and @type='button']");
	By txtDays = By.xpath("//input[contains(@id,'_txtdays') and @type='text']");
	By drpProjects = By.xpath("//input[contains(@id,'_Projects_radYALDropDownList_Input') and @type='text']");
	By txtAgreementNumber = By.xpath("//input[contains(@id,'_txtLeaseNumber') and @type='text']");		
	By drpAgreementName = By.xpath("//input[contains(@id,'_RadEntityInfo_Input') and @type='text']");	
	By drpLandowner = By.xpath("//input[contains(@id,'_SearchLandOwners_MSDropDown_Input') and @type='text']");
	By drpAgreementTeam = By.xpath("//input[contains(@id,'_AgreementTerm_radYALDropDownList_Input') and @type='text']");
	By txtVendor = By.xpath("//input[contains(@id,'_txtVendorID') and @type='text']");
	By drpPaymentStatus = By.xpath("//input[contains(@id,'_PaymentStatus_MSDropDown_Input') and @type='text']");
	By drpAgreementType = By.xpath("//input[contains(@id,'_AgreementType_radYALDropDownList_Input') and @type='text']");
	By drpPaymentType = By.xpath("//input[contains(@id,'_PaymentType_MSDropDown_Input') and @type='text']");
	By drpStartDate = By.xpath("//input[contains(@id,'_startRange_dateInput') and @type='text']");
	By drpEndDate = By.xpath("//input[contains(@id,'_endRange_dateInput') and @type='text']");
	By btnSearch = By.xpath("//input[contains(@id,'_btnSearch') and @type='button']");
	By btnReset = By.xpath("//input[contains(@id,'_btnReset') and @type='button']");
	By txtMinAmount = By.xpath("//td[contains(text(),'Min Amount :')]//input[@type='text']");
	By txtMaxAmount = By.xpath("//td[contains(text(),'Max Amount :')]//input[@type='text']");
	By searchAmountResult = By.xpath("(//td[contains(text(),'$')])[1]");
	
	
	
	//For Row
	
	By drpProjectsRow = By.xpath("//input[@id='ctl00_ConPHRightTop_RadDock1_C_RadProjectList_Input']");
	By drpLandownerRow = By.xpath("//input[contains(@id,'_RadLOInfo_Input') and @type='text']");
//	By txtVendorRow = By.xpath("//input[contains(@id,'_txtVendorID') and @type='text']");
//	By drpPaymentStatusRow = By.xpath("//input[contains(@id,'_PaymentStatus_MSDropDown_Input') and @type='text']");
//	By drpStartDateRow = By.xpath("//input[contains(@id,'_startRange_dateInput') and @type='text']");
//	By drpEndDateRow = By.xpath("//input[contains(@id,'_endRange_dateInput') and @type='text']");
	By btnSearchRow = By.xpath("//input[contains(@id,'_btnDoSearch') and @type='image']");
	By btnResetRow = By.xpath("//input[contains(@id,'_btnOpenCommitments') and @type='image']");
	By txtMinAmountROW = By.xpath("//input[contains(@id,'_minAmt') and @type='text']");
	By txtMaxAmountROW = By.xpath("//input[contains(@id,'_maxAmt') and @type='text']");
	By radioCalculatedTotal = By.xpath("//input[contains(@id,'_CalTotal') and @type='radio']");
	
	
	public void navigateToPaymentManager() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navPaymentManager);
		util.click(navPaymentManager);
	}
	
	public void ClickOnSearchInformation() {
		util.waitUntilElementDisplay(SearchInformation);
		util.click(SearchInformation);
	}
	
	public void ExpandSearchOptionPanel() {
		util.waitUntilElementDisplay(ExpandSearchOption);
		util.click(ExpandSearchOption);
//		util.waitUntilElementDisplay(btnPaymentNext);
	}
	
	public void ClickOnPaymentNextButton() {
		util.waitUntilElementDisplay(btnPaymentNext);
		util.click(btnPaymentNext);
	}
	
	public void AddDays(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtDays, value);
	}
	
	public void SelectProject(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpProjects, value);
	}
	
	public void SelectProjectRow(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpProjectsRow, value);
	}
	
	public void SetAgreementNumber(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtAgreementNumber, value);
	}
	
	public void SelectAgreementName(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgreementName, value);
	}
	
	
	public void SelectLandowner(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputText(drpLandowner, value);
			util.dummyWait(2);
		util.pressDownkey();
		util.pressENTERkey();
		}
	}
	
	public void SelectLandownerRow(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpLandownerRow, value);
	}
	
	public void SelectAgreementTerm(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgreementTeam, value);
	}
	
	public void SetVendor(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtVendor, value);
	}
	
	public void SelectPaymentStatus(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(drpPaymentStatus, value);
		util.waitFor(200);
		util.pressDownkey();
		util.pressENTERkey();
	}
	
	By drpPaymentStatusClose = By.xpath("//a[contains(@id,'PaymentStatus_MSDropDown_Arrow')]");
	public void SelectPaymentStatusROW(String value) {
		if (!commonFunction.checkNA(value)) {
		String drpSelectName = "//div//ul//li//div[normalize-space()='" + value + "']";
		util.waitFor(1000);
		util.waitUntilElementDisplay(drpPaymentStatus);
		util.click(drpPaymentStatus);
		util.waitFor(1000);
		if (!util.isElementVisible(By.xpath(drpSelectName))) {
			util.click(drpPaymentStatus);
			util.waitFor(1000);
		}
		util.click(By.xpath(drpSelectName));
		util.click(drpPaymentStatusClose);
	}}
	
	By Checkbox = By.xpath("//input[contains(@id,'PaymentStatus_MSDropDown_i3_CheckBox')]");
	public void SelectPaymentStatusRow(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(drpPaymentStatus, value);
		util.click(Checkbox);
	}
	
	
	public void SelectAgreementType(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpAgreementType, value);	}
	
	public void SelectPaymentType(String value) {
		if (!commonFunction.checkNA(value)) {
			util.inputText(drpPaymentType, value);
		util.pressDownkey();
		util.pressENTERkey();
	}}
	
	public void SetStartDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpStartDate, value);
	}

	public void SetEndDate(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(drpEndDate, value);
	}
	
	public void EnterMinAmount(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMinAmount, value);
	}
	
	public void EnterMaxAmount(String value) {
		if (!commonFunction.checkNA(value))
			util.inputTextAndPressTab(txtMaxAmount, value);
	}
	
	public void ClickSearchButton() {
		util.waitUntilElementDisplay(btnSearch);
		util.click(btnSearch);
		util.dummyWait(10);
	}
	
	public void ClickSearchButtonRow() {
		util.waitUntilElementDisplay(btnSearchRow);
		util.click(btnSearchRow);
		util.dummyWait(2);
	}
	
	public void ClickResetButton() {
		util.waitUntilElementDisplay(btnReset);
		util.click(btnReset);
		util.dummyWait(2);
		if(util.isElementVisible(ExpandSearchOption)) {
		util.click(ExpandSearchOption);
		}

	}
	
	public void ClickResetButtonRow() {
		util.waitUntilElementDisplay(btnResetRow);
		util.click(btnResetRow);
	    util.dummyWait(3);
	
	}
	
    public void ProjectPaymentManager(Map<String, String> map,String testcaseName)  {
    	
    	try {
    		navigateToPaymentManager();
			log("STEP 1:user can navigate to payment  Manager.", Status.PASS);
		} catch (Exception e) {
			log("STEP 1: user cannot navigate to payment Manager. ", Status.FAIL);
			throw new RuntimeException("Failed in step 1");
		}
		try {
			ClickOnSearchInformation();
			log("STEP 2: user can click on search information Tab", Status.PASS);
		} catch (Exception e) {
			log("STEP 2: user cannot click on search information Tab", Status.FAIL);
			throw new RuntimeException("Failed in step 2");
		}
		
		if(util.isElementVisible(ExpandSearchOption)) {
		try {
			ExpandSearchOptionPanel();
			log("STEP 3: user can expand search option panel", Status.PASS);
		} catch (Exception e) {
			log("STEP 3: user cannot expand search option panel ", Status.FAIL);
			throw new RuntimeException("Failed in step 3");
		}
		}
		
		if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
			try {
				SelectProjectRow(map.get(Excel.Project));
				log("STEP 4: user can select projecy from Project dd  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4:  user cannot select projecy from Project dd  ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			try {
				SelectLandownerRow(map.get(Excel.Landowner));
				log("STEP 5: user can select landowner from Landowner dd", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user cannot select landowner from Landowner dd", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			try {
				util.click(radioCalculatedTotal);
				log("STEP 6: user can select Calculated Total Radio Button", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user cannot select Calculated Total Radio Button", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			
			try {
				util.inputTextAndPressTab(txtMinAmountROW, map.get("MinAmount"));
				log("STEP 7: user can enter Min Amount", Status.PASS);
			} catch (Exception e) {
				log("STEP 7: user cannot enter Min Amount", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
			
			try {
				util.inputTextAndPressTab(txtMaxAmountROW, map.get("MaxAmount"));
				log("STEP 8: user can enter Max Amount", Status.PASS);
			} catch (Exception e) {
				log("STEP 8: user cannot enter Max Amount", Status.FAIL);
				throw new RuntimeException("Failed in step 8");
			}
			
			
		}
		else { 	
		
		try {
			AddDays(map.get(Excel.Days));
			log("STEP 4: user can enter value in Days textbox.", Status.PASS);
		} catch (Exception e) {
			log("STEP 4: user cannot enter value in Days textbox. ", Status.FAIL);
			throw new RuntimeException("Failed in step 4");
		}
		
		try {
			ClickOnPaymentNextButton();
			log("STEP 5:user can click on payments next button.", Status.PASS);
		} catch (Exception e) {
			log("STEP 5:user cannot  click on payments next button..  ", Status.FAIL);
			throw new RuntimeException("Failed in step 5");
		}
        util.dummyWait(10);		
        try {
			SelectProject(map.get(Excel.Project));
			log("STEP 6: user can select project from Project dd  ", Status.PASS);
		} catch (Exception e) {
			log("STEP 6: user cannot select project from Project dd  ", Status.FAIL);
			throw new RuntimeException("Failed in step 6");
		}
		
		try {
			SetAgreementNumber(map.get(Excel.AgreementNumber));
			log("STEP 7: user can enter value in Agreement Number textbox.", Status.PASS);
		} catch (Exception e) {
			log("STEP 7: user cannot enter value in Agreement Number textbox.", Status.FAIL);
			throw new RuntimeException("Failed in step 7");
		}
		
		try {
			SelectLandowner(map.get(Excel.Landowner));
			log("STEP 8: user can select landowner from Landowner dd", Status.PASS);
		} catch (Exception e) {
			log("STEP 8: user cannot select landowner from Landowner dd", Status.FAIL);
			throw new RuntimeException("Failed in step 8");
		}
	}
		try {
			SetVendor(map.get(Excel.Vendor));
			log("STEP 9: user can enter value in Vendor textbox. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 9: user cannot enter value in Vendor textbox.   ", Status.FAIL);
			throw new RuntimeException("Failed in step 9");
		}
		
		if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
		try {
			SelectPaymentStatus(map.get(Excel.PaymentStatus));
			log("STEP 10: user can enter value in Payment Status textbox.", Status.PASS);
		} catch (Exception e) {
			log("STEP 10: user cannot enter value in Payment Status textbox.   ", Status.FAIL);
			throw new RuntimeException("Failed in step 10");
		}
		}else {
			try {
				SelectPaymentStatusROW(map.get(Excel.PaymentStatus));
				log("STEP 10: user can enter value in Payment Status textbox.", Status.PASS);
			} catch (Exception e) {
				log("STEP 10: user cannot enter value in Payment Status textbox.   ", Status.FAIL);
				throw new RuntimeException("Failed in step 10");
			}
		}
		util.dummyWait(1);
		try {
			SetStartDate(map.get(Excel.StartDate));
			log("STEP 11: user can select Start date ", Status.PASS);
		} catch (Exception e) {
			log("STEP 11: user cannot select Start date ", Status.FAIL);
			throw new RuntimeException("Failed in step 11");
		}
		
		try {
			SetEndDate(map.get(Excel.EndDate));
			log("STEP 12: user can select End Date ", Status.PASS);
		} catch (Exception e) {
			log("STEP 12: user cannot select End Date", Status.FAIL);
			throw new RuntimeException("Failed in step 12");
		}
		
		if(!testcaseName.contains("ROW") & !testcaseName.contains("TRA")) {
		try {
			EnterMinAmount(map.get("MinAmount"));
			log("STEP 13: user can enter Min Amount value ", Status.PASS);
		} catch (Exception e) {
			log("STEP 13: user cannot enter Min Amount value ", Status.FAIL);
			throw new RuntimeException("Failed in step 13");
		}
		
		try {
			EnterMaxAmount(map.get("MaxAmount"));
			log("STEP 14: user can enter Max Amount value ", Status.PASS);
		} catch (Exception e) {
			log("STEP 14: user cannot enter Max Amount value", Status.FAIL);
			throw new RuntimeException("Failed in step 14");
		}
		}
		
		if(testcaseName.contains("ROW") || testcaseName.contains("TRA")) {
			try {
				ClickSearchButtonRow();
				log("STEP 15: user can click on search button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 15: user cannot  click on search button ", Status.FAIL);
				throw new RuntimeException("Failed in step 15");
			}
			
			try {
				ClickResetButtonRow();
				log("STEP 16: user can click on reset button. ", Status.PASS);
			} catch (Exception e) {
				log("STEP 16: user cannot  click on reset button.     ", Status.FAIL);
				throw new RuntimeException("Failed in step 16");
			}
			
			try {
				SelectProjectRow(map.get(Excel.Project));
		         util.dummyWait(2);
				log("STEP 17: user can select Project", Status.PASS);
			} catch (Exception e) {
				log("STEP 17: user cannot select project ", Status.FAIL);
				throw new RuntimeException("Failed in step 17");
			}
			
			try {
				 ClickSearchButtonRow();
				log("STEP 18: user can click on search button", Status.PASS);
			} catch (Exception e) {
				log("STEP 18: user cannot click on search button ", Status.FAIL);
				throw new RuntimeException("Failed in step 18");
			}
			
	        
		}
		else {
		try {
			ClickSearchButton();
			log("STEP 15: user can click on search button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 15: user cannot  click on Search button  ", Status.FAIL);
			throw new RuntimeException("Failed in step 15");
		}
		
//		try {
//			String displayedAmountText = util.getText(searchAmountResult);
//			log("Searched amount stored in a variable ");
//			double displayedAmount = Double.parseDouble(displayedAmountText.replaceAll("[^\\d.]", ""));
//			log("removed . from searched amount and converted to double ");
//			double minAmount = Double.parseDouble(map.get("MinAmount"));
//			log(" converted min amount to double ");
//			double maxAmount = Double.parseDouble(map.get("MaxAmount"));
//			log(" converted max amount to double ");
//			Assert.assertTrue(displayedAmount >= minAmount && displayedAmount <= maxAmount, "Displayed amount is not within the expected range");
//			log("STEP 16: user can see Search Payment using payment amount filter", Status.PASS);
//		} catch (AssertionError e) {
//			log("STEP 16: user cannot  see Search Payment using payment amount  filter", Status.FAIL);
//		}
		
		try {
			ExtentTestManager.infoWithScreenshot("Searched Payment Records");
			ClickResetButton();
			util.waitFor(500);
			log("STEP 17: user can click on reset button. ", Status.PASS);
		} catch (Exception e) {
			log("STEP 17: user cannot  click on reset button.     ", Status.FAIL);
			throw new RuntimeException("Failed in step 17");
		}
		
//		if(util.isElementVisible(ExpandSearchOption)) {
//		try {
//			ExpandSearchOptionPanel();
//			log("STEP 18: user can expand search option panel & fields will be visible.", Status.PASS);
//		} catch (Exception e) {
//			log("STEP 18: user cannot expand search option panel ", Status.FAIL);
//			throw new RuntimeException("Failed in step 18");
//		}
//		}
		
		try {
			SelectProject(map.get(Excel.Project));
			log("STEP 19: user can select Project", Status.PASS);
		} catch (Exception e) {
			log("STEP 19: user cannot select project ", Status.FAIL);
			throw new RuntimeException("Failed in step 19");
		}
		
		try {
			SelectPaymentStatus(map.get(Excel.PaymentStatus));
	         util.dummyWait(2);
			log("STEP 20: user can select Payment status", Status.PASS);
		} catch (Exception e) {
			log("STEP 20: user cannot select Payment Status ", Status.FAIL);
			throw new RuntimeException("Failed in step 20");
		}
		
		if(testcaseName.contains("ROW")) {
			util.click(radioCalculatedTotal);
			util.inputTextAndPressTab(txtMinAmountROW, map.get("MinAmount"));
			util.inputTextAndPressTab(txtMaxAmountROW, map.get("MaxAmount"));
		}
		try {
			 ClickSearchButton();
			log("STEP 21: user can click on search button", Status.PASS);
		} catch (Exception e) {
			log("STEP 21: user cannot click on search button ", Status.FAIL);
			throw new RuntimeException("Failed in step 21");
		}
        
	
		}
    }

	
	
}
