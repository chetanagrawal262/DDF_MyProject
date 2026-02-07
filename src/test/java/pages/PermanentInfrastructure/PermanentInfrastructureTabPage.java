package pages.PermanentInfrastructure;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class PermanentInfrastructureTabPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public PermanentInfrastructureTabPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navPermanentInfrastructure = By.xpath("(//span[text()='Permanent Infrastructure'])[1]");
	
	By TractNo = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__1')]/td[2]");
	
	public void NavigateToPermanentInfrastructure() {
	        util.waitUntilElementDisplay(navParcel);
	        util.click(navParcel);
	        util.waitUntilElementDisplay(navParcelInfo);
	        util.click(navParcelInfo);
	        util.waitUntilElementDisplay(navPermanentInfrastructure);
	        util.click(navPermanentInfrastructure);	
	    }
	    
	 public void PermanentInfrastructureTab(String testcaseName) {
		 
		 try {
			 NavigateToPermanentInfrastructure();
			 commonFunction.projectSelection();
	 			log("STEP 1: User can navigate to the Permanent Infrastructure tab ", Status.PASS);
	 		 } catch (Exception e) {
	 			log("STEP 1:  Permanent Infrastructure tab does not load", Status.FAIL);
	 			throw new RuntimeException("Failed in step 1");
	 		 }

		 
	 }
	
}
