package pages.ProjectPayTemplate;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.Excel;
import com.util.CommonFunction;
import com.util.TestUtil;

public class PaymentTermFilterPage extends BasePage{


	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public PaymentTermFilterPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);	
	}
	
	By navProject = By.xpath("//span[text()='Project']");
	By navProjectPayTemplate = By.xpath("//span[contains(text(),'Project Pay Templates')]");
	//for ROW
	By navAdministration = By.xpath("//span[text()='Administration']");
	By navPaymentTemplates = By.xpath("//span[contains(text(),'Payment Templates')]");
	By navProjectPayTemplates = By.xpath("//span[contains(text(),'Project Pay Templates')]"); 
		
	By SelectProject = By.xpath("//tr[@id='ctl00_ConPHLeftTop_PAYLST_RadGridTracts_ctl00__0']");
	By txtPaymentTerm = By.xpath("//input[contains(@id,'_FilterTextBox_Payment_Terms') and @type='text']");
	By iconFilter = By.xpath("//input[contains(@id,'_Filter_Payment_Terms') and @type='submit']");
	By SelectFilter = By.xpath("//span[contains(text(),'Contains')]");
	By ResultAlt = By.xpath("//strong[contains(text(),'Geo Support')]");
	By ResultRow = By.xpath("//strong[contains(text(),'Geo Support')]");
	
	 public void nevigateToProjectPayTemplate() {
	  		util.waitUntilElementDisplay(navProject);
	  		util.click(navProject);
	  		util.waitUntilElementDisplay(navProjectPayTemplate);
	  		util.click(navProjectPayTemplate);
	 }
	  	
	  	public void nevigateToProjectPayTemplateRow() {
	  		util.waitUntilElementDisplay(navAdministration);
	  		util.click(navAdministration);
	  		util.waitUntilElementDisplay(navPaymentTemplates);
	  		util.click(navPaymentTemplates);
	  		util.waitUntilElementDisplay(navProjectPayTemplates);
	  		util.click(navProjectPayTemplates);
	  }
	  	
	  	public void ClickonProject() {
	  		util.waitUntilElementDisplay(SelectProject);
	  		util.click(SelectProject);
	  	}
	  	
	  	public void AddPaymentTerm(String value) {
	  		if (!commonFunction.checkNA(value))
	  			util.inputTextAndPressTab(txtPaymentTerm, value);
	  	}
	  	
	  	public void ClickonFilterIcon() {
	  		util.waitUntilElementDisplay(iconFilter);
	  		util.click(iconFilter);
	  		util.click(iconFilter);
	  	}
	  	
	  	public void SelectFilter() {
	  		util.waitUntilElementDisplay(SelectFilter);
	  		util.click(SelectFilter);
	  	}
	  	
	  	 public void PaymentTermFilter(Map<String, String> map,String testCaseName)  {
		    	try {
		    		ClickonProject();
					log("STEP 2: User can select value from dd  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 2: User cannot select value from dd  ", Status.FAIL);
					throw new RuntimeException("Failed in step 2");
				}
		    	
		    	try {
		    		if(environment.contains("CONNECTGEN")) {
		    			AddPaymentTerm(map.get("PaymentTermCONNECTGEN"));
		    		}else {
		    		AddPaymentTerm(map.get(Excel.PaymentTerm));
		    		}
					log("STEP 3: User can enter value in PaymentTerm textbox.", Status.PASS);
				} catch (Exception e) {
					log("STEP 3: user cannot enter value in PaymentTerm textbox. ", Status.FAIL);
					throw new RuntimeException("Failed in step 3");
				}
		    	
		    	try {
		    		ClickonFilterIcon();
					log("STEP 4: User can click on filter icon. ", Status.PASS);
				} catch (Exception e) {
					log("STEP 4: user cannot click on filter icon. ", Status.FAIL);
					throw new RuntimeException("Failed in step 4");
				}
		    	
		    	try {
		    		SelectFilter();
					log("STEP 5: user can select any filter ", Status.PASS);
				} catch (Exception e) {
					log("STEP 5: User cannot select any filter.", Status.FAIL);
					throw new RuntimeException("Failed in step 5");
				}
		    	
		    	if(testCaseName.contains("ALT")|| testCaseName.contains("ORSTED") || testCaseName.contains("ORION") || testCaseName.contains("ATWELL")) {
		    		util.dummyWait(5);
		    		if(environment.contains("CONNECTGEN")) {
		    			By Result = By.xpath("(//strong[contains(text(),'"+map.get("PaymentTermCONNECTGEN")+"')])[1]");
			    		
			    		if (util.isElementVisible(Result)) {
			    			System.out.println("Payment terms result will be displayed according to selected filter");
			    			log("STEP 6: Payment terms result is displayed according to selected filter ", Status.PASS);
			    		} else {
			    			log("STEP 6: Record not displayed in list.", Status.FAIL);
			    			throw new RuntimeException("Faild in STEP 6 :Record not displayed in list. ");
			    		}
		    		}else {
		    		By Result = By.xpath("(//strong[contains(text(),'"+map.get(Excel.PaymentTerm)+"')])[1]");
		    		
		    		if (util.isElementVisible(Result)) {
		    			System.out.println("Payment terms result will be displayed according to selected filter");
		    			log("STEP 6: Payment terms result is displayed according to selected filter ", Status.PASS);
		    		} else {
		    			log("STEP 6: Record not displayed in list.", Status.FAIL);
		    			throw new RuntimeException("Faild in STEP 6 :Record not displayed in list. ");
		    		}
		    		}
		    	}
		    	else{
		    		util.dummyWait(5);
		    		By Result = By.xpath("(//strong[contains(text(),'"+map.get(Excel.PaymentTerm)+"')])[1]");
		    		if (util.isElementVisible(Result)) {
		    			System.out.println("record  displayed in list. !!!");
		    			log("STEP 6: Payment terms result is displayed according to selected filter ", Status.PASS);
		    		} else {
		    			log("STEP 6: Record not displayed in list.", Status.FAIL);
		    			throw new RuntimeException("Faild in STEP 6 :Record not displayed in list. ");
		    		}
		    	}
		    	
	  	 }
}
