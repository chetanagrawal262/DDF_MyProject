package pages.Relocation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class RelocationTabPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public RelocationTabPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	} 
	
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navRelocation = By.xpath("(//span[text()='Relocation'])[1]");
	
	public void NavigateToRelocationTab() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navRelocation);
		util.click(navRelocation);
		
	}
	
      public void RelocationTab(String testcaseName) {
		 
		 try {
			 NavigateToRelocationTab();
			 commonFunction.projectSelection();
				log("STEP 1: User can navigate to the Relocation tab  ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Relocation tab does not load,failed", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}
		 
     } 
      
      
}
