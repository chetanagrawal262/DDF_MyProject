package pages.Negotiations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class NegotiationsTabPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public NegotiationsTabPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navNegotiations = By.xpath("(//span[text()='Negotiations'])[1]");
	
	 public void nevigateToNegotiation() {
	  		util.waitUntilElementDisplay(navParcel);
	  		util.click(navParcel);
	  		util.waitUntilElementDisplay(navParcelInfo);
	  		util.click(navParcelInfo);
	  		util.waitUntilElementDisplay(navNegotiations);
	  		util.click(navNegotiations);
	  		
	    }
	 
     public void Negotiations(String testcaseName) {
		 
		 try {
			 nevigateToNegotiation();
			 commonFunction.projectSelection();
				log("STEP 1: User can navigate to the Negotiations tab ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1:  Negotiations tab does not load ", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}
	
      }
}
