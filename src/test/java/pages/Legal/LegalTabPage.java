package pages.Legal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class LegalTabPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public LegalTabPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navLegal = By.xpath("//span[contains(text(),'Legal')]");
	
	public void NavigateToLegalTab() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navLegal);
		util.click(navLegal);
		
	}
	
      public void LegalTab(String testcaseName) {
		 
		 try {
			 NavigateToLegalTab();
			 commonFunction.projectSelection();
				log("STEP 1: User can navigate to the Legal tab  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Legal tab does not load", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}
		 
     }
      
      
    
      
      
}
