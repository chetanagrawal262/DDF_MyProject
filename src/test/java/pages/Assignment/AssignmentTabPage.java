package pages.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class AssignmentTabPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public AssignmentTabPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
		
	}
	
	By navParcel = By.xpath("//span[text()='Parcel'] | //span[text()='Tract']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info'] | //span[text()='Tract Info']");
	By navAssignment = By.xpath("//div[contains(@id,'RadYALMenu')]/../..//span[text()='Assignments']");
	By navAssignmentdot = By.xpath("//div[contains(@id,'RadYALMenu')]/../..//span[text()='Assignments']");

	By firstParcel = By.xpath("//*[contains(@id,'TractList_RadGridTracts_ctl00__0')]");
	
	public void NavigateToAssignmentTab() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navAssignment);
		util.click(navAssignment);
		
	}
	
	public void NavigateToAssignmentTabDot() {
		util.waitUntilElementDisplay(navParcel);
		util.click(navParcel);
		util.waitUntilElementDisplay(navParcelInfo);
		util.click(navParcelInfo);
		util.waitUntilElementDisplay(navAssignmentdot);
		util.click(navAssignmentdot);
		
	}
	
	  public void AssignmentTab(String testcaseName) {
			 
		  if (testcaseName.contains("DOT")|| testcaseName.contains("ROW") || testcaseName.contains("TRA") || testcaseName.contains("DOM")){
			 try {
				 NavigateToAssignmentTabDot();
				 commonFunction.projectSelection();
				 util.waitUntilElementDisplay(firstParcel);
	 	    		util.click(firstParcel);
	 	    		util.dummyWait(10);
					log("STEP 1: User can navigate to the Assignment tab  ", Status.PASS);
				} catch (Exception e) {
					log("STEP 1: Assignment tab does not load ", Status.FAIL);
					throw new RuntimeException("Failed in step 1 ");
				}
		  }
			 else {
				 try {
					 NavigateToAssignmentTab();
					 commonFunction.projectSelection();
					 util.waitUntilElementDisplay(firstParcel);
		 	    		util.click(firstParcel);
		 	    		util.dummyWait(10);
						log("STEP 1: User can navigate to the Assignment tab  ", Status.PASS);
					} catch (Exception e) {
						log("STEP 1: Assignment tab does not load ", Status.FAIL);
						throw new RuntimeException("Failed in step 1 ");
					}
			 }
	  }
	
}
