package pages.ProjectNotes;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class DeleteNotesPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;
	public static String AGREEMENT_NUMBER;

	public DeleteNotesPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelNotes = By.xpath("(//span[text()='Parcel Notes'])[1]");
	By navAgentNotes = By.xpath("(//span[text()='Agent Notes'])[1]");
	By ContactLog = By.xpath("//tbody/tr[contains(@id,'_AGENTNOTES_radYALGridControl_ctl00__0')]/td[2]");
	By Delete = By.xpath("(//span[text()='Delete'])[1]");
	
	 public void NavigateToParcelNotesAlt() {
	        util.waitUntilElementDisplay(navParcel);
	        util.click(navParcel);
	        util.waitUntilElementDisplay(navParcelInfo);
	        util.click(navParcelInfo);
	        util.waitUntilElementDisplay(navParcelNotes);
	        util.click(navParcelNotes);	
	    }
	  
	  public void NavigateToParcelNotesRow() {
	        util.waitUntilElementDisplay(navParcel);
	        util.click(navParcel);
	        util.waitUntilElementDisplay(navParcelInfo);
	        util.click(navParcelInfo);
	        util.waitUntilElementDisplay(navAgentNotes);
	        util.click(navAgentNotes);	
	    }
	  
	  public void ClickonDeleteDocument() {
	    	WebElement web = driver.findElement(ContactLog);
	    	util.waitUntilElementDisplay(ContactLog);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	    	util.waitUntilElementDisplay(Delete);
	    	util.click(Delete);
	    	driver.switchTo().alert().accept();
	}
	  
	  public void ClickonDeleteDocumentROW() {
	    	WebElement web = driver.findElement(ContactLog);
	    	util.waitUntilElementDisplay(ContactLog);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	    	util.waitUntilElementDisplay(Delete);
	    	util.click(Delete);
	    	
	}
	  
	By   btnDelete = By.xpath("//input[contains(@id,'_ctl00_ctl04_gbcDeleteAlignment')]");
	By btnOk = By.xpath("//span[text()='OK']");
	public void DeleteNote() {
		driver.navigate().refresh();
		util.dummyWait(3);
		util.waitUntilElementDisplay(btnDelete);
		util.click(btnDelete);
		util.waitUntilElementDisplay(btnOk);
		util.click(btnOk);
	}
			  
	  
	  
	  public void DeleteNotes(String testcaseName) {
		  if(testcaseName.contains("ALT") || testcaseName.contains("ORSTED") || testcaseName.contains("ATWELL") || testcaseName.contains("ORION")) {
	  	   try {
	  		    ClickonDeleteDocument();
		 	    log("STEP 1: User can click on the delete option ", Status.PASS);
	   	   } catch (Exception e) {
		 	    log("STEP 1: User cannot click on delete option. ", Status.FAIL);
		 		throw new RuntimeException("Failed in step 1");
		   }
		 }
		  
		  else if(testcaseName.contains("DOT")) {
			  try {
				  DeleteNote();
			 	    log("STEP 1: User can click on the delete option ", Status.PASS);
		   	   } catch (Exception e) {
			 	    log("STEP 1: User cannot click on delete option. ", Status.FAIL);
			 		throw new RuntimeException("Failed in step 1");
			   }
		  }
		  else {
			  log("Delete Notes not applicable for ROW ", Status.SKIP);
//			  try {
//				  ClickonDeleteDocumentROW();
//			 	    log("STEP 1: User can click on the delete option ", Status.PASS);
//		   	   } catch (Exception e) {
//			 	    log("STEP 1: User cannot click on delete option. ", Status.FAIL);
//			 		throw new RuntimeException("Failed in step 1");
//			   }
		  }
		  
	  }
}
