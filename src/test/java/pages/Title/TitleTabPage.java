package pages.Title;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class TitleTabPage extends BasePage{
	
	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public TitleTabPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}

	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navTitle = By.xpath("(//span[text()='Title'])[1]");
	By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
	
	public void NavigateToTitle() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.click(navTitle);
	}
	  
	 public void TitleTab(String testcaseName) {

		 try {
			 NavigateToTitle();
			 commonFunction.projectSelection();
			 util.waitUntilElementDisplay(firstParcel);
	    		util.click(firstParcel);
	    		util.dummyWait(10);
				log("STEP 1: User can navigate to the Title tab ", Status.PASS);
			} catch (Exception e) {
				log("STEP 1: Title tab does not load ", Status.FAIL);
				throw new RuntimeException("Failed in step 1 ");
			}
		 
	 }
	
}
