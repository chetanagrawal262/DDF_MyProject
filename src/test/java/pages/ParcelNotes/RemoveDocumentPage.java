package pages.ParcelNotes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.util.CommonFunction;
import com.util.TestUtil;

public class RemoveDocumentPage extends BasePage{

	TestUtil util;
	CommonFunction commonFunction;

	public RemoveDocumentPage(WebDriver driver) {
		this.driver = driver;
		util = new TestUtil(driver);
		commonFunction = new CommonFunction(driver);
	}
	
	By navParcel = By.xpath("//span[text()='Parcel']");
	By navParcelInfo = By.xpath("//span[text()='Parcel Info']");
	By navParcelNotes = By.xpath("(//span[text()='Parcel Notes'])[1]");
	By navAgentNotes = By.xpath("(//span[text()='Agent Notes'])[1]");
	By ContactLog = By.xpath("//tr[contains(@id,'_AGENTNOTES_radYALGridControl_ctl00__0')]");
	By RemoveDocument = By.xpath("//span[contains(text(),'Remove Document')]");
	
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
	  
	  public void ClickonRemoveDocument() {
	    	WebElement web = driver.findElement(ContactLog);
	    	util.waitUntilElementDisplay(ContactLog);
	    	Actions act = new Actions(driver);
	    	act.moveToElement(web).contextClick().build().perform();
	    	util.waitUntilElementDisplay(RemoveDocument);
	    	util.click(RemoveDocument);
	    	

	}
	  By ViewDocument = By.xpath("//a[contains(text(),'View Document')]");
	  By pendingStatus = By.xpath("(//tr[contains(@id,'_AGENTNOTES_radYALGridControl_ctl00__0')]/.//strong[text()='Pending'])[1]");
	  public void RemoveDocument(String testcaseName) {

		  if (testcaseName.contains("DOT")) {
  			log("Remove  Document not applicable for DOT ", Status.SKIP);
  		}
  	   
		  else {
			  if(util.isElementVisible(pendingStatus)) {
	  	   try {
	  		   util.reloadPage();
	  		   util.dummyWait(3);
	  		 ClickonRemoveDocument();
	  		ClickonRemoveDocument();
		 	    log("STEP 1: User can click on the remove document. option.", Status.PASS);
	   	   } catch (Exception e) {
		 	    log("STEP 1: User cannot click on  remove document.", Status.FAIL);
		 		throw new RuntimeException("Failed in step 1");
		   }
	  	   
	  		   util.reloadPage();
	  		   util.dummyWait(3);
	  		if(!util.isElementPresent(ViewDocument)) {
		 	    log("STEP 2: View document link removed successfully", Status.PASS);
	  		}else {
	   	   
		 	    log("STEP 2: View document link not removed", Status.FAIL);
		 	   throw new RuntimeException("Failed in step 2");
	  		}
	  		util.dummyWait(1);		   
	  }
		 
	 		 else {
	 			 log("Notes are not in pending status", Status.SKIP);
	 		 }
	}
	  
	  }
}
