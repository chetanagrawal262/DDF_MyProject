package pages.ProjectPaymentManager;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class PaymentTermsFilterPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public PaymentTermsFilterPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navPaymentManager = By.xpath("//span[contains(text(),'Payment Manager')]");
	By ShowArchieved = By.xpath("//input[contains(@id,'_chkShowArchived') and @type='checkbox']");
	By txtPaymentTerm = By.xpath("//input[contains(@id,'_FilterTextBox_Payment_Terms') and @type='text']");
	By FilterIcon = By.xpath("//input[contains(@id,'_Filter_Payment_Terms') and @title='Filter']");
	By SelectFilter = By.xpath("//span[text()='Contains']");
	By btnRefresh = By.xpath("//img[@id='ctl00_ConPHLeftTop_LSLST_RadGridTracts_ctl00_ctl02_ctl00_Img1']");
	By linkArchieve = By.xpath("(//a[text()='Archive'])[1]");
	By iframe = By.xpath("//iframe[@name='CheckLog']");
	By SuccessMessgae = By.xpath("//span[text()='The selected check log has been archived successfully.']");
	By btnClose = By.xpath("//a[@title='Close']");
			
			
	public void navigateToPaymentManager() {
		util.waitUntilElementDisplay(navProject);
		util.click(navProject);
		util.waitUntilElementDisplay(navPaymentManager);
		util.click(navPaymentManager);
	}
	
	public void ClickOnShowArchievedCheckBox() {
		util.waitUntilElementDisplay(ShowArchieved);
		util.click(ShowArchieved);
	}
	
	public void SetPaymentTerm(String value) {
		if (!commonFunction.checkNA(value))
			util.inputText(txtPaymentTerm, value);	
	}	
	
	public void ClickOnFilterIcon() {
		util.waitUntilElementDisplay(FilterIcon);
		util.click(FilterIcon);
//		util.click(FilterIcon);
	}	
	
	public void SelectFilter() {
		util.waitUntilElementDisplay(SelectFilter);
		util.click(SelectFilter);
	}	
	
	public void ClickOnRefresh() {
		util.waitUntilElementDisplay(btnRefresh);
		util.click(btnRefresh);
		util.dummyWait(1);
	}
	
	public void ClickOnArchieveLink() {
		util.waitUntilElementDisplay(linkArchieve);
		util.click(linkArchieve);
		util.switchToIframe(iframe);
		
	}
	public void clickonClose() {
		util.switchToDefaultContent();
		util.waitUntilElementDisplay(btnClose);
		util.click(btnClose);
	}
	
	   public void PaymentTermsFilter(Map<String, String> map,String testcaseName)  {
		   try {
			   navigateToPaymentManager();
				log("STEP 1:user can navigate to payment  Manager.", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: user cannot navigate to payment Manager. ", Status.FAIL);
				throw new RuntimeException("Failed in step 1");
			}
   
			try {
				SetPaymentTerm(map.get(Excel.PaymentTerm));
				log("STEP 2: user can enter value in Payment Term textbox.", Status.PASS);
			} catch (Exception e) {
				log("STEP 2: user cannot enter value in Payment Term textbox. ", Status.FAIL);
				throw new RuntimeException("Failed in step 2");
			}
			
			try {
				ClickOnFilterIcon();
				log("STEP 3: user can click on filter icon.", Status.PASS);
			} catch (Exception e) {
				log("STEP 3: user cannot click on filter icon. ", Status.FAIL);
				throw new RuntimeException("Failed in step 3");
			}
			
			try {
				SelectFilter();
				log("STEP 4: user can select any filter ", Status.PASS);
			} catch (Exception e) {
				log("STEP 4: user cannot select any filter ", Status.FAIL);
				throw new RuntimeException("Failed in step 4");
			}
			
			
			try {
				ClickOnRefresh();
				log("STEP 5: user can click on refresh button", Status.PASS);
			} catch (Exception e) {
				log("STEP 5: user cannot click on refresh button. ", Status.FAIL);
				throw new RuntimeException("Failed in step 5");
			}
			
			if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED")||testcaseName.contains("ORION") || testcaseName.contains("ATWELL")) {
			if(util.isElementVisible(linkArchieve)) {
				try {
				ClickOnArchieveLink();
				log("STEP 6: user can click on Archive link.", Status.PASS);
			} catch (Exception e) {
				log("STEP 6: user cannot click on Archive link ", Status.FAIL);
				throw new RuntimeException("Failed in step 6");
			}
			if (util.isElementPresent(SuccessMessgae)) {
				log("New popup 'Check log processing' will be opened & 'The selected check log has been archived successfully' message will be displayed.", Status.PASS);
			} else {
				log("message not be displayed.", Status.FAIL);
			}
            util.dummyWait(2);
			clickonClose();
			}
			
			try {
				ClickOnShowArchievedCheckBox();
				 util.dummyWait(2);
				log("STEP 7: user can check/uncheck checkbox.", Status.PASS);
			} catch (Exception e) {
				log("STEP 7:  user cannot  check/uncheck checkbox ", Status.FAIL);
				throw new RuntimeException("Failed in step 7");
			}
		}
			
	 }
 }
